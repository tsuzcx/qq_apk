package com.tencent.mm.wear.app.emoji.gif;

import android.os.Handler;
import android.os.Looper;

public final class a
{
  private Handler handler;
  
  public final void o(Runnable paramRunnable)
  {
    if (this.handler != null) {
      this.handler.postDelayed(paramRunnable, 0L);
    }
  }
  
  public final void start()
  {
    new Thread()
    {
      public final void run()
      {
        Looper.prepare();
        a.a(a.this, new Handler());
        Looper.loop();
      }
    }.start();
  }
  
  public final void stop()
  {
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler.getLooper().quit();
    }
    this.handler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.gif.a
 * JD-Core Version:    0.7.0.1
 */