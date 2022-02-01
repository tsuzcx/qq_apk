package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "removesFutureOnCancellation", "", "close", "", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "initFutureCancellation", "initFutureCancellation$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "kotlinx-coroutines-core"})
public abstract class bo
  extends bn
  implements av
{
  private boolean abxn;
  
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
  
  public final void a(long paramLong, m<? super x> paramm)
  {
    if (this.abxn) {}
    for (ScheduledFuture localScheduledFuture = a((Runnable)new cq((af)this, paramm), paramLong, TimeUnit.MILLISECONDS); localScheduledFuture != null; localScheduledFuture = null)
    {
      paramm.am((b)new j((Future)localScheduledFuture));
      return;
    }
    ar.abwJ.a(paramLong, paramm);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        Executor localExecutor = getExecutor();
        paramf = cx.abxP;
        if (paramf != null)
        {
          Runnable localRunnable = paramf.iSa();
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
        ar.abwJ.bl(paramRunnable);
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
  
  public final be d(long paramLong, Runnable paramRunnable)
  {
    if (this.abxn) {}
    for (ScheduledFuture localScheduledFuture = a(paramRunnable, paramLong, TimeUnit.MILLISECONDS); localScheduledFuture != null; localScheduledFuture = null) {
      return (be)new bd((Future)localScheduledFuture);
    }
    return ar.abwJ.d(paramLong, paramRunnable);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bo)) && (((bo)paramObject).getExecutor() == getExecutor());
  }
  
  public int hashCode()
  {
    return System.identityHashCode(getExecutor());
  }
  
  public final void iRE()
  {
    this.abxn = d.b(getExecutor());
  }
  
  public String toString()
  {
    return getExecutor().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.bo
 * JD-Core Version:    0.7.0.1
 */