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
  private boolean IFe = false;
  
  private void frs()
  {
    AppMethodBeat.i(40662);
    e locale = h.IEL;
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40653);
        SplashActivity.c(SplashActivity.this);
        AppMethodBeat.o(40653);
      }
    };
    if (locale.MK()) {
      fru();
    }
    AppMethodBeat.o(40662);
  }
  
  private void fru()
  {
    AppMethodBeat.i(40664);
    if (this.IFe)
    {
      AppMethodBeat.o(40664);
      return;
    }
    this.IFe = true;
    if (!isFinishing())
    {
      setResult(-100);
      int i = getIntent().getIntExtra("hashcode", 0);
      Iterator localIterator = h.IEI.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (i == locali.hashCode()) {
          h.a(locali);
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
          h.IEL = null;
          AppMethodBeat.o(40656);
        }
      }, 5000L);
      AppMethodBeat.o(40664);
      return;
      onBackPressed();
    }
  }
  
  public final void frt()
  {
    AppMethodBeat.i(40663);
    if (h.IEL != null)
    {
      if (!h.IEL.a(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40654);
          SplashActivity.c(SplashActivity.this);
          AppMethodBeat.o(40654);
        }
      }))
      {
        frs();
        AppMethodBeat.o(40663);
      }
    }
    else
    {
      h.b("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
      fru();
    }
    AppMethodBeat.o(40663);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40657);
    super.onCreate(paramBundle);
    h.a(this);
    h.b("WxSplash.SplashActivity", "onCreate", new Object[0]);
    if (!h.frj())
    {
      h.b("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
      frt();
    }
    if (h.IEU != null) {
      h.IEU.r(this);
    }
    AppMethodBeat.o(40657);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40660);
    h.b(this);
    h.b("WxSplash.SplashActivity", "onDestroy", new Object[0]);
    super.onDestroy();
    AppMethodBeat.o(40660);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(40659);
    h.b("WxSplash.SplashActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(40659);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(40661);
    if (h.IEL != null) {
      h.IEL.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(40661);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(40658);
    super.onResume();
    h.b("WxSplash.SplashActivity", "onResume", new Object[0]);
    AppMethodBeat.o(40658);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.SplashActivity
 * JD-Core Version:    0.7.0.1
 */