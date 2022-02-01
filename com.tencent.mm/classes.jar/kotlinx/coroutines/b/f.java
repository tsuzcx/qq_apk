package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.bg;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f
  extends bg
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater LTW;
  private final d LTX;
  private final int LTY;
  private final int frq;
  private volatile int inFlightTasks;
  private final ConcurrentLinkedQueue<Runnable> rNK;
  
  static
  {
    AppMethodBeat.i(118040);
    LTW = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public f(d paramd, int paramInt)
  {
    AppMethodBeat.i(191127);
    this.LTX = paramd;
    this.LTY = paramInt;
    this.frq = 1;
    this.rNK = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(191127);
  }
  
  private final void c(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (LTW.incrementAndGet(this) <= this.LTY)
      {
        this.LTX.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.rNK.add(paramRunnable);
      if (LTW.decrementAndGet(this) >= this.LTY)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.rNK.poll();
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
  
  public final void geW()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.rNK.poll();
    if (localRunnable != null)
    {
      this.LTX.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    LTW.decrementAndGet(this);
    localRunnable = (Runnable)this.rNK.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    c(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final int geX()
  {
    return this.frq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = super.toString() + "[dispatcher = " + this.LTX + ']';
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.f
 * JD-Core Version:    0.7.0.1
 */