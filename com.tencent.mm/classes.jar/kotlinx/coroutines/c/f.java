package kotlinx.coroutines.c;

import a.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.av;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "parallelism", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILkotlinx/coroutines/scheduling/TaskMode;)V", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "executor", "getExecutor", "()Ljava/util/concurrent/Executor;", "inFlightTasks", "Lkotlinx/atomicfu/AtomicInt;", "getParallelism", "()I", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getTaskMode", "()Lkotlinx/coroutines/scheduling/TaskMode;", "afterTask", "", "close", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "fair", "", "execute", "command", "toString", "", "kotlinx-coroutines-core"})
final class f
  extends av
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater CKt;
  private final ConcurrentLinkedQueue<Runnable> CKr;
  private volatile int CKs;
  private final d CKu;
  private final int CKv;
  private final l CKw;
  
  static
  {
    AppMethodBeat.i(118364);
    CKt = AtomicIntegerFieldUpdater.newUpdater(f.class, "CKs");
    AppMethodBeat.o(118364);
  }
  
  public f(d paramd, int paramInt, l paraml)
  {
    AppMethodBeat.i(118363);
    this.CKu = paramd;
    this.CKv = paramInt;
    this.CKw = paraml;
    this.CKr = new ConcurrentLinkedQueue();
    this.CKs = 0;
    AppMethodBeat.o(118363);
  }
  
  private final void b(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118360);
    for (;;)
    {
      if (CKt.incrementAndGet(this) <= this.CKv)
      {
        this.CKu.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118360);
        return;
      }
      this.CKr.add(paramRunnable);
      if (CKt.decrementAndGet(this) >= this.CKv)
      {
        AppMethodBeat.o(118360);
        return;
      }
      paramRunnable = (Runnable)this.CKr.poll();
      if (paramRunnable == null)
      {
        AppMethodBeat.o(118360);
        return;
      }
    }
  }
  
  public final void a(e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(118359);
    a.f.b.j.q(parame, "context");
    a.f.b.j.q(paramRunnable, "block");
    b(paramRunnable, false);
    AppMethodBeat.o(118359);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118358);
    Throwable localThrowable = (Throwable)new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    AppMethodBeat.o(118358);
    throw localThrowable;
  }
  
  public final void eqH()
  {
    AppMethodBeat.i(118362);
    Runnable localRunnable = (Runnable)this.CKr.poll();
    if (localRunnable != null)
    {
      this.CKu.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118362);
      return;
    }
    CKt.decrementAndGet(this);
    localRunnable = (Runnable)this.CKr.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118362);
      return;
    }
    b(localRunnable, true);
    AppMethodBeat.o(118362);
  }
  
  public final l eqI()
  {
    return this.CKw;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(118357);
    a.f.b.j.q(paramRunnable, "command");
    b(paramRunnable, false);
    AppMethodBeat.o(118357);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118361);
    String str = super.toString() + "[dispatcher = " + this.CKu + ']';
    AppMethodBeat.o(118361);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.c.f
 * JD-Core Version:    0.7.0.1
 */