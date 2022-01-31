package com.tencent.soter.core.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

public final class e
{
  private static Handler wPp = null;
  CountDownLatch rSV = null;
  
  static void d(Runnable paramRunnable)
  {
    if (wPp == null) {
      wPp = new Handler(Looper.getMainLooper());
    }
    wPp.post(paramRunnable);
  }
  
  public final void countDown()
  {
    if (this.rSV != null)
    {
      this.rSV.countDown();
      this.rSV = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.d.e
 * JD-Core Version:    0.7.0.1
 */