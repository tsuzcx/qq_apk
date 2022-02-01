package com.tencent.mm.sdk.b.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.sdk.b.c.c;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class h
  implements e, RejectedExecutionHandler
{
  public HandlerThread abq = c.H("ThreadPool#FallBackExecutor");
  Handler abr = null;
  
  private h(g paramg) {}
  
  private void m(Runnable paramRunnable)
  {
    if (this.abr == null) {}
    synchronized (this.abq)
    {
      if (this.abr == null)
      {
        if (!this.abq.isAlive()) {
          this.abq.start();
        }
        this.abr = new Handler(this.abq.getLooper());
      }
      this.abr.post(paramRunnable);
      return;
    }
  }
  
  public final void l(Runnable paramRunnable)
  {
    m(paramRunnable);
  }
  
  public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    m(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b.h
 * JD-Core Version:    0.7.0.1
 */