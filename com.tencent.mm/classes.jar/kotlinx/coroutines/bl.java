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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "removesFutureOnCancellation", "", "close", "", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "initFutureCancellation", "initFutureCancellation$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "kotlinx-coroutines-core"})
public abstract class bl
  extends bk
  implements at
{
  boolean TUJ;
  
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
  
  public final void a(long paramLong, k<? super x> paramk)
  {
    if (this.TUJ) {}
    for (ScheduledFuture localScheduledFuture = a((Runnable)new ck((ad)this, paramk), paramLong, TimeUnit.MILLISECONDS); localScheduledFuture != null; localScheduledFuture = null)
    {
      paramk.W((b)new h((Future)localScheduledFuture));
      return;
    }
    ap.TUg.a(paramLong, paramk);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        Executor localExecutor = getExecutor();
        paramf = cr.TVl;
        if (paramf != null)
        {
          Runnable localRunnable = paramf.hNB();
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
        ap.TUg.bd(paramRunnable);
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
  
  public final bc d(long paramLong, Runnable paramRunnable)
  {
    if (this.TUJ) {}
    for (ScheduledFuture localScheduledFuture = a(paramRunnable, paramLong, TimeUnit.MILLISECONDS); localScheduledFuture != null; localScheduledFuture = null) {
      return (bc)new bb((Future)localScheduledFuture);
    }
    return ap.TUg.d(paramLong, paramRunnable);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bl)) && (((bl)paramObject).getExecutor() == getExecutor());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bl
 * JD-Core Version:    0.7.0.1
 */