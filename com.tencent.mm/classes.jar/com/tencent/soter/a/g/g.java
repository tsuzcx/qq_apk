package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g wQk = null;
  private Handler wPp = null;
  private Handler wQl = null;
  
  private g()
  {
    HandlerThread localHandlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
    localHandlerThread.start();
    if (localHandlerThread.getLooper() != null) {}
    for (this.wQl = new Handler(localHandlerThread.getLooper());; this.wQl = new Handler(Looper.getMainLooper()))
    {
      this.wPp = new Handler(Looper.getMainLooper());
      return;
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g cPK()
  {
    if (wQk == null) {
      try
      {
        if (wQk == null) {
          wQk = new g();
        }
        g localg = wQk;
        return localg;
      }
      finally {}
    }
    return wQk;
  }
  
  public final void H(Runnable paramRunnable)
  {
    this.wQl.post(paramRunnable);
  }
  
  public final void d(Runnable paramRunnable)
  {
    this.wPp.post(paramRunnable);
  }
  
  public final void m(Runnable paramRunnable, long paramLong)
  {
    this.wQl.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */