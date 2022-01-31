package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class SplashActivity
  extends Activity
{
  private boolean yvG = false;
  
  private void dvE()
  {
    AppMethodBeat.i(114868);
    if (h.yvn.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114860);
        SplashActivity.c(SplashActivity.this);
        AppMethodBeat.o(114860);
      }
    })) {
      dvG();
    }
    AppMethodBeat.o(114868);
  }
  
  private void dvG()
  {
    AppMethodBeat.i(114870);
    if (this.yvG)
    {
      AppMethodBeat.o(114870);
      return;
    }
    this.yvG = true;
    if (!isFinishing())
    {
      setResult(-100);
      int i = getIntent().getIntExtra("hashcode", 0);
      Iterator localIterator = h.yvj.iterator();
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
          AppMethodBeat.i(114862);
          SplashActivity.this.finish();
          SplashActivity.d(SplashActivity.this);
          AppMethodBeat.o(114862);
        }
      }, 50L);
    }
    for (;;)
    {
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          h.yvn = null;
        }
      }, 5000L);
      AppMethodBeat.o(114870);
      return;
      onBackPressed();
    }
  }
  
  public final void dvF()
  {
    AppMethodBeat.i(114869);
    if (h.yvn != null)
    {
      if (!h.yvn.a(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114861);
          SplashActivity.c(SplashActivity.this);
          AppMethodBeat.o(114861);
        }
      }))
      {
        dvE();
        AppMethodBeat.o(114869);
      }
    }
    else
    {
      h.c("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
      dvG();
    }
    AppMethodBeat.o(114869);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114863);
    super.onCreate(paramBundle);
    h.a(this);
    h.c("WxSplash.SplashActivity", "onCreate", new Object[0]);
    if (!h.dvu())
    {
      h.c("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
      dvF();
    }
    if (h.yvw != null) {
      h.yvw.m(this);
    }
    AppMethodBeat.o(114863);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(114866);
    h.b(this);
    h.c("WxSplash.SplashActivity", "onDestroy", new Object[0]);
    super.onDestroy();
    AppMethodBeat.o(114866);
  }
  
  protected void onPause()
  {
    AppMethodBeat.i(114865);
    h.c("WxSplash.SplashActivity", "onPause", new Object[0]);
    super.onPause();
    AppMethodBeat.o(114865);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114867);
    if (h.yvn != null) {
      h.yvn.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(114867);
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(114864);
    super.onResume();
    h.c("WxSplash.SplashActivity", "onResume", new Object[0]);
    AppMethodBeat.o(114864);
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