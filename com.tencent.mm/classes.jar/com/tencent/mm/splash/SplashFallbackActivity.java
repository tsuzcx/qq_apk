package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class SplashFallbackActivity
  extends HellActivity
{
  private Runnable UZJ;
  private Handler mHandler;
  
  public SplashFallbackActivity()
  {
    AppMethodBeat.i(40668);
    this.UZJ = new Runnable()
    {
      private long UZK = -1L;
      
      public final void run()
      {
        AppMethodBeat.i(40667);
        if (this.UZK == -1L) {
          this.UZK = System.currentTimeMillis();
        }
        if (!SplashFallbackActivity.huv())
        {
          if (System.currentTimeMillis() - this.UZK >= 80000L)
          {
            i.g("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
            SplashFallbackActivity.this.finish();
            SplashFallbackActivity.this.overridePendingTransition(h.a.UZk, h.a.UZi);
            AppMethodBeat.o(40667);
            return;
          }
          SplashFallbackActivity.b(SplashFallbackActivity.this).postDelayed(SplashFallbackActivity.a(SplashFallbackActivity.this), 100L);
          AppMethodBeat.o(40667);
          return;
        }
        i.g("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
        SplashFallbackActivity.this.finish();
        SplashFallbackActivity.this.overridePendingTransition(h.a.UZk, h.a.UZi);
        AppMethodBeat.o(40667);
      }
    };
    AppMethodBeat.o(40668);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(40670);
    i.g("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
    AppMethodBeat.o(40670);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40669);
    super.onCreate(paramBundle);
    i.g("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
    paramBundle = new HandlerThread("splash-activity");
    paramBundle.start();
    this.mHandler = new Handler(paramBundle.getLooper());
    this.mHandler.postDelayed(this.UZJ, 100L);
    AppMethodBeat.o(40669);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.SplashFallbackActivity
 * JD-Core Version:    0.7.0.1
 */