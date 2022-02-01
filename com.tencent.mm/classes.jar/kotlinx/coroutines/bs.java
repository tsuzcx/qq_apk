package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlinx.coroutines.internal.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class bs
  extends br
  implements ba
{
  private final Executor executor;
  
  public bs(Executor paramExecutor)
  {
    AppMethodBeat.i(188816);
    this.executor = paramExecutor;
    d.h(this.executor);
    AppMethodBeat.o(188816);
  }
  
  private static ScheduledFuture<?> a(ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable, f paramf, long paramLong)
  {
    AppMethodBeat.i(188820);
    try
    {
      paramScheduledExecutorService = paramScheduledExecutorService.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(188820);
      return paramScheduledExecutorService;
    }
    catch (RejectedExecutionException paramScheduledExecutorService)
    {
      for (;;)
      {
        a(paramf, paramScheduledExecutorService);
        paramScheduledExecutorService = null;
      }
    }
  }
  
  private static void a(f paramf, RejectedExecutionException paramRejectedExecutionException)
  {
    AppMethodBeat.i(188825);
    cg.a(paramf, bq.i("The task was rejected", (Throwable)paramRejectedExecutionException));
    AppMethodBeat.o(188825);
  }
  
  public final bi a(long paramLong, Runnable paramRunnable, f paramf)
  {
    AppMethodBeat.i(188847);
    Object localObject = this.executor;
    if ((localObject instanceof ScheduledExecutorService))
    {
      localObject = (ScheduledExecutorService)localObject;
      if (localObject != null) {
        break label68;
      }
    }
    label68:
    for (localObject = null;; localObject = a((ScheduledExecutorService)localObject, paramRunnable, paramf, paramLong))
    {
      if (localObject == null) {
        break label82;
      }
      paramRunnable = (bi)new bh((Future)localObject);
      AppMethodBeat.o(188847);
      return paramRunnable;
      localObject = null;
      break;
    }
    label82:
    paramRunnable = aw.ajvR.a(paramLong, paramRunnable, paramf);
    AppMethodBeat.o(188847);
    return paramRunnable;
  }
  
  public final void a(long paramLong, p<? super ah> paramp)
  {
    AppMethodBeat.i(188838);
    Object localObject = this.executor;
    if ((localObject instanceof ScheduledExecutorService))
    {
      localObject = (ScheduledExecutorService)localObject;
      if (localObject != null) {
        break label72;
      }
    }
    label72:
    for (localObject = null;; localObject = a((ScheduledExecutorService)localObject, (Runnable)new cu((al)this, paramp), paramp.getContext(), paramLong))
    {
      if (localObject == null) {
        break label104;
      }
      paramp.bg((b)new m((Future)localObject));
      AppMethodBeat.o(188838);
      return;
      localObject = null;
      break;
    }
    label104:
    aw.ajvR.a(paramLong, paramp);
    AppMethodBeat.o(188838);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(188830);
    try
    {
      Executor localExecutor = this.executor;
      if (c.ajvf == null)
      {
        localExecutor.execute(paramRunnable);
        AppMethodBeat.o(188830);
        return;
      }
      AppMethodBeat.o(188830);
      throw null;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      a(paramf, localRejectedExecutionException);
      bg.kCi().a(paramf, paramRunnable);
      AppMethodBeat.o(188830);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(188852);
    Object localObject = this.executor;
    if ((localObject instanceof ExecutorService)) {}
    for (localObject = (ExecutorService)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ExecutorService)localObject).shutdown();
      }
      AppMethodBeat.o(188852);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bs)) && (((bs)paramObject).executor == this.executor);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188866);
    int i = System.identityHashCode(this.executor);
    AppMethodBeat.o(188866);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188859);
    String str = this.executor.toString();
    AppMethodBeat.o(188859);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bs
 * JD-Core Version:    0.7.0.1
 */