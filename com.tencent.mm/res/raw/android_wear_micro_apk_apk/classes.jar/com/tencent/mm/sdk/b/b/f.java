package com.tencent.mm.sdk.b.b;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import com.tencent.mm.sdk.b.c.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

final class f
  extends AbstractQueuedSynchronizer
  implements Printer, Runnable
{
  final HandlerThread abj;
  volatile Runnable abk;
  volatile String abl;
  volatile long abm;
  volatile boolean abn = false;
  Handler handler;
  
  f(c paramc, Runnable paramRunnable)
  {
    setState(-1);
    this.abk = paramRunnable;
    this.abl = c.k(paramRunnable);
    int i = c.cb(c.a(paramc).get());
    this.abj = paramc.lS().a(this, "HandlerThreadPool#".concat(String.valueOf(i + 1)), this);
  }
  
  protected final boolean isHeldExclusively()
  {
    return getState() != 0;
  }
  
  public final boolean isLocked()
  {
    return isHeldExclusively();
  }
  
  public final boolean lU()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return this.handler.getLooper().getQueue().isIdle();
    }
    return false;
  }
  
  public final void println(String paramString)
  {
    if (!this.abn) {}
    for (boolean bool = true;; bool = false)
    {
      this.abn = bool;
      return;
    }
  }
  
  public final void run()
  {
    this.abo.a(this);
  }
  
  protected final boolean tryAcquire(int paramInt)
  {
    if (compareAndSetState(0, 1))
    {
      setExclusiveOwnerThread(Thread.currentThread());
      return true;
    }
    return false;
  }
  
  public final boolean tryLock()
  {
    return tryAcquire(1);
  }
  
  protected final boolean tryRelease(int paramInt)
  {
    setExclusiveOwnerThread(null);
    setState(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b.f
 * JD-Core Version:    0.7.0.1
 */