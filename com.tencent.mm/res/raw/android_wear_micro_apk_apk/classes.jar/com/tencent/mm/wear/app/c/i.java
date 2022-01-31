package com.tencent.mm.wear.app.c;

import android.os.Handler;
import android.os.Looper;

public final class i
{
  private Handler handler;
  
  public final void e(Runnable paramRunnable)
  {
    if (this.handler != null) {
      this.handler.postDelayed(paramRunnable, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.i
 * JD-Core Version:    0.7.0.1
 */