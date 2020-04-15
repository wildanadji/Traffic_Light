package com.example.traffic_light;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    ImageView merah,kuning,hijau,merahnyala,kuningnyala,hijaunyala;
    Button mulai,henti;
    TextView tm1,tk1,th1;
    public int nh,nk,nm,st;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	merah=(ImageView) findViewById(R.id.im);
	kuning=(ImageView) findViewById(R.id.ik);	
	hijau=(ImageView)findViewById(R.id.ih);
	merahnyala=(ImageView) findViewById(R.id.imn);
	kuningnyala=(ImageView) findViewById(R.id.ikn);
	hijaunyala=(ImageView)findViewById(R.id.ihn);
	mulai=(Button) findViewById(R.id.btnstart);
	henti=(Button) findViewById(R.id.btnstop);
	merahnyala.setVisibility(View.GONE);
	kuningnyala.setVisibility(View.GONE);
	hijaunyala.setVisibility(View.GONE);
	tm1=(TextView) findViewById(R.id.tm);
	tk1=(TextView) findViewById(R.id.tk);
	th1=(TextView) findViewById(R.id.th);
	nm=0;nk=0;nh=0;st=0;
	mulai.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v) {
             countRed();
         }
     });
	henti.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
        	 merahnyala.setVisibility(View.GONE);
	    	 merah.setVisibility(View.VISIBLE);
	    	 kuningnyala.setVisibility(View.GONE);
	    	 kuning.setVisibility(View.VISIBLE);
	    	 hijaunyala.setVisibility(View.GONE);
	    	 hijau.setVisibility(View.VISIBLE);
	    	 tm1.setText("0");
	    	 tk1.setText("0");
	    	 th1.setText("0");
	    	 st=1;
	    	 
        }
    });
	}
	public void countRed()
	{
		new CountDownTimer(10000, 1000) {
		     public void onTick(long millisUntilFinished) {
		    	 if(st==1)
		    	 {
		    		 cancel();
		    		 st=0;
		    	 }
		    	 else
		    	 { 
		    	 merahnyala.setVisibility(View.VISIBLE);
		    	 merah.setVisibility(View.GONE);
		         tm1.setText("Berhenti Selama: " + millisUntilFinished / 1000);
		    		 
		    	 }
		    	
		     }

		     public void onFinish() {
		         tm1.setText("0");
		    	 merahnyala.setVisibility(View.GONE);
		    	 merah.setVisibility(View.VISIBLE);
		    	 if(nk==1)
		    	 {
		    		 nk=0;
		    	 }
		         countYellow();
		     }
		  }.start();
	}
	public void countYellow()
	{
		new CountDownTimer(5000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 if(st==1)
		    	 {
		    		 cancel();
		    		 st=0;
		    	 }
		    	 else
		    	 { 
		    		 kuningnyala.setVisibility(View.VISIBLE);
			    	 kuning.setVisibility(View.GONE);
			         tk1.setText("Hati-hati: " + millisUntilFinished / 1000);
		    	 }
		    	 
		     }

		     public void onFinish() {
		         tk1.setText("0");
		    	 kuningnyala.setVisibility(View.GONE);
		    	 kuning.setVisibility(View.VISIBLE);
		    	 if(nh==1)
		    	 {
		    		 nk=1;
		    		 nh=0;
		    		 countRed();
		    	 }
		    	 else
		    	 {
			         countGreen();
		    	 }

		     }
		  }.start();
	}
	public void countGreen()
	{
		new CountDownTimer(10000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 if(st==1)
		    	 {
		    		 cancel();
		    		 st=0;
		    	 }
		    	 else
		    	 { 
		    		 hijaunyala.setVisibility(View.VISIBLE);
			    	 hijau.setVisibility(View.GONE);
			         th1.setText("Jalan Selama: " + millisUntilFinished / 1000);
		    	 }
		    	 
		     }

		     public void onFinish() {
		         th1.setText("0");
		    	 hijaunyala.setVisibility(View.GONE);
		    	 hijau.setVisibility(View.VISIBLE);
		    	 nh=1;
		    	 countYellow();
		     }
		  }.start();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
