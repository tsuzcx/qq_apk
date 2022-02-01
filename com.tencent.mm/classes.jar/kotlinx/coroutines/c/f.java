package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.bb;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f
  extends bb
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater Kgm;
  private final d Kgn;
  private final int Kgo;
  private final int fnW;
  private volatile int inFlightTasks;
  private final ConcurrentLinkedQueue<Runnable> qRN;
  
  static
  {
    AppMethodBeat.i(118040);
    Kgm = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public f(d paramd, int paramInt)
  {
    AppMethodBeat.i(190015);
    this.Kgn = paramd;
    this.Kgo = paramInt;
    this.fnW = 1;
    this.qRN = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(190015);
  }
  
  private final void c(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (Kgm.incrementAndGet(this) <= this.Kgo)
      {
        this.Kgn.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.qRN.add(paramRunnable);
      if (Kgm.decrementAndGet(this) >= this.Kgo)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.qRN.poll();
      if (paramRunnable == null)
      {
        AppMethodBeat.o(118036);
        return;
      }
    }
  }
  
  public final void a(d.d.f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118035);
    c(paramRunnable, false);
    AppMethodBeat.o(118035);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118034);
    Throwable localThrowable = (Throwable)new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    AppMethodBeat.o(118034);
    throw localThrowable;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(118033);
    c(paramRunnable, false);
    AppMethodBeat.o(118033);
  }
  
  public final void fMg()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.qRN.poll();
    if (localRunnable != null)
    {
      this.Kgn.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    Kgm.decrementAndGet(this);
    localRunnable = (Runnable)this.qRN.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    c(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final int fMh()
  {
    return this.fnW;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = super.toString() + "[dispatcher = " + this.Kgn + ']';
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.f
 * JD-Core Version:    0.7.0.1
 */