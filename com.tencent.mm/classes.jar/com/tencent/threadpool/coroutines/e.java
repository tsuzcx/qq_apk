package com.tencent.threadpool.coroutines;

import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bq;
import kotlinx.coroutines.cf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/threadpool/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "backupDispatcher", "getBackupDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "execute", "Lcom/tencent/threadpool/coroutines/DefaultDispatcher;", "Lcom/tencent/threadpool/coroutines/IoDispatcher;", "Lcom/tencent/threadpool/coroutines/ComputeDispatcher;", "threadpool-coroutines_release"}, k=1, mv={1, 1, 16})
public abstract class e
  extends al
{
  private final al ahAN = b.ahAL;
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    s.t(paramf, "context");
    s.t(paramRunnable, "block");
    try
    {
      execute((Runnable)new d(paramRunnable));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      al localal;
      do
      {
        cf.a(paramf, bq.i("The task was rejected", (Throwable)localRejectedExecutionException));
        localal = this.ahAN;
      } while (localal == null);
      localal.a(paramf, paramRunnable);
    }
  }
  
  protected abstract void execute(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.threadpool.coroutines.e
 * JD-Core Version:    0.7.0.1
 */