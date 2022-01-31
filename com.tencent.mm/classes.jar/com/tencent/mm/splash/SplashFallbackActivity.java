package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SplashFallbackActivity
  extends Activity
{
  private Handler mHandler;
  private Runnable yvI;
  
  public SplashFallbackActivity()
  {
    AppMethodBeat.i(114874);
    this.yvI = new Runnable()
    {
      private long yvJ = -1L;
      
      public final void run()
      {
        AppMethodBeat.i(114873);
        if (this.yvJ == -1L) {
          this.yvJ = System.currentTimeMillis();
        }
        if (!SplashFallbackActivity.dvH())
        {
          if (System.currentTimeMillis() - this.yvJ >= 80000L)
          {
            h.c("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
            SplashFallbackActivity.this.finish();
            SplashFallbackActivity.this.overridePendingTransition(2131034276, 2131034274);
            AppMethodBeat.o(114873);
            return;
          }
          SplashFallbackActivity.b(SplashFallbackActivity.this).postDelayed(SplashFallbackActivity.a(SplashFallbackActivity.this), 100L);
          AppMethodBeat.o(114873);
          return;
        }
        h.c("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
        SplashFallbackActivity.this.finish();
        SplashFallbackActivity.this.overridePendingTransition(2131034276, 2131034274);
        AppMethodBeat.o(114873);
      }
    };
    AppMethodBeat.o(114874);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(114876);
    h.c("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
    AppMethodBeat.o(114876);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114875);
    super.onCreate(paramBundle);
    h.c("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
    paramBundle = new HandlerThread("splash-activity");
    paramBundle.start();
    this.mHandler = new Handler(paramBundle.getLooper());
    this.mHandler.postDelayed(this.yvI, 100L);
    AppMethodBeat.o(114875);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.SplashFallbackActivity
 * JD-Core Version:    0.7.0.1
 */