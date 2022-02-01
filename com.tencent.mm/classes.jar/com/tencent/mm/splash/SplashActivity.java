package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class SplashActivity
  extends HellActivity
{
  private boolean acAZ = false;
  
  private void iVV()
  {
    AppMethodBeat.i(40662);
    e locale = i.acAG;
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40653);
        SplashActivity.c(SplashActivity.this);
        AppMethodBeat.o(40653);
      }
    };
    if (locale.aDw()) {
      iVX();
    }
    AppMethodBeat.o(40662);
  }
  
  private void iVX()
  {
    AppMethodBeat.i(40664);
    if (this.acAZ)
    {
      AppMethodBeat.o(40664);
      return;
    }
    this.acAZ = true;
    if (!isFinishing())
    {
      setResult(-100);
      int i = getIntent().getIntExtra("hashcode", 0);
      Iterator localIterator = i.acAD.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (i == localj.hashCode()) {
          i.a(localj);
        }
      }
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40655);
          SplashActivity.this.finish();
          SplashActivity.d(SplashActivity.this);
          AppMethodBeat.o(40655);
        }
      }, 50L);
    }
    for (;;)
    {
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40656);
          i.acAG = null;
          AppMethodBeat.o(40656);
        }
      }, 5000L);
      AppMethodBeat.o(40664);
      return;
      onBackPressed();
    }
  }
  
  public final void iVW()
  {
    AppMethodBeat.i(40663);
    if (i.acAG != null)
    {
      if (!i.acAG.a(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40654);
          SplashActivity.c(SplashActivity.this);
          AppMethodBeat.o(40654);
        }
      }))
      {
        iVV();
        AppMethodBeat.o(40663);
      }
    }
    else
    {
      i.g("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
      iVX();
    }
    AppMethodBeat.o(40663);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40657);
    super.onCreate(paramBundle);
    i.a(this);
    i.g("WxSplash.SplashActivity", "onCreate", new Object[0]);
    if (!i.iVM())
    {
      i.g("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
      iVW();
    }
    if (i.acAP != null) {
      i.acAP.s(this);
    }
    AppMethodBeat.o(40657);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40660);
    i.b(this);
    i.g("WxSplash.SplashActivity", "onDestroy", new Object[0]);
    super.onDestroy();
    AppMethodBeat.o(40660);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(40659);
    i.g("WxSplash.SplashActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(40659);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(40661);
    if (i.acAG != null) {
      i.acAG.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(40661);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(40658);
    super.onResume();
    i.g("WxSplash.SplashActivity", "onResume", new Object[0]);
    AppMethodBeat.o(40658);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.SplashActivity
 * JD-Core Version:    0.7.0.1
 */