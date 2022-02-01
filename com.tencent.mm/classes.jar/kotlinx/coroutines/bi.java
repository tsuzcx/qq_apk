package kotlinx.coroutines;

import d.d.f;
import d.g.a.b;
import d.l;
import d.z;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "removesFutureOnCancellation", "", "close", "", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "initFutureCancellation", "initFutureCancellation$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "kotlinx-coroutines-core"})
public abstract class bi
  extends bh
  implements as
{
  boolean OfN;
  
  private final ScheduledFuture<?> a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      Executor localExecutor = getExecutor();
      Object localObject = localExecutor;
      if (!(localExecutor instanceof ScheduledExecutorService)) {
        localObject = null;
      }
      localObject = (ScheduledExecutorService)localObject;
      if (localObject != null)
      {
        paramRunnable = ((ScheduledExecutorService)localObject).schedule(paramRunnable, paramLong, paramTimeUnit);
        return paramRunnable;
      }
      return null;
    }
    catch (RejectedExecutionException paramRunnable) {}
    return null;
  }
  
  public final void a(long paramLong, k<? super z> paramk)
  {
    if (this.OfN) {}
    for (ScheduledFuture localScheduledFuture = a((Runnable)new cf((ac)this, paramk), paramLong, TimeUnit.MILLISECONDS); localScheduledFuture != null; localScheduledFuture = null)
    {
      paramk.N((b)new h((Future)localScheduledFuture));
      return;
    }
    ao.Ofl.a(paramLong, paramk);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        Executor localExecutor = getExecutor();
        paramf = ck.Ogo;
        if (paramf != null)
        {
          Runnable localRunnable = paramf.gAu();
          paramf = localRunnable;
          if (localRunnable != null)
          {
            localExecutor.execute(paramf);
            return;
          }
        }
      }
      catch (RejectedExecutionException paramf)
      {
        ao.Ofl.aT(paramRunnable);
        return;
      }
      paramf = paramRunnable;
    }
  }
  
  public void close()
  {
    Executor localExecutor = getExecutor();
    Object localObject = localExecutor;
    if (!(localExecutor instanceof ExecutorService)) {
      localObject = null;
    }
    localObject = (ExecutorService)localObject;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdown();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bi)) && (((bi)paramObject).getExecutor() == getExecutor());
  }
  
  public int hashCode()
  {
    return System.identityHashCode(getExecutor());
  }
  
  public String toString()
  {
    return getExecutor().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bi
 * JD-Core Version:    0.7.0.1
 */