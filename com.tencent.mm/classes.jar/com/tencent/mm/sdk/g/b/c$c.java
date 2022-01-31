package com.tencent.mm.sdk.g.b;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d.b;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

final class c$c
  extends AbstractQueuedSynchronizer
  implements b
{
  volatile int id;
  Runnable ysW;
  volatile long ysX;
  
  c$c(c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(52595);
    setState(-1);
    this.ysW = paramRunnable;
    AppMethodBeat.o(52595);
  }
  
  public static boolean duB()
  {
    AppMethodBeat.i(52596);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = Looper.myLooper().getQueue().isIdle();
      AppMethodBeat.o(52596);
      return bool;
    }
    AppMethodBeat.o(52596);
    return false;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(52602);
    String str = "ForkThreadPool#" + c.a(this.ysV) + this.id;
    AppMethodBeat.o(52602);
    return str;
  }
  
  protected final boolean isHeldExclusively()
  {
    AppMethodBeat.i(52598);
    if (getState() != 0)
    {
      AppMethodBeat.o(52598);
      return true;
    }
    AppMethodBeat.o(52598);
    return false;
  }
  
  public final boolean isLocked()
  {
    AppMethodBeat.i(52601);
    boolean bool = isHeldExclusively();
    AppMethodBeat.o(52601);
    return bool;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52597);
    this.ysV.b(this);
    AppMethodBeat.o(52597);
  }
  
  protected final boolean tryAcquire(int paramInt)
  {
    AppMethodBeat.i(52599);
    if (compareAndSetState(0, 1))
    {
      setExclusiveOwnerThread(Thread.currentThread());
      AppMethodBeat.o(52599);
      return true;
    }
    AppMethodBeat.o(52599);
    return false;
  }
  
  protected final boolean tryRelease(int paramInt)
  {
    AppMethodBeat.i(52600);
    setExclusiveOwnerThread(null);
    setState(0);
    AppMethodBeat.o(52600);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b.c.c
 * JD-Core Version:    0.7.0.1
 */