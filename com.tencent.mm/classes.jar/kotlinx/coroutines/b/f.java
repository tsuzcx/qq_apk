package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.bh;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f
  extends bh
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater OhX;
  private final d OhY;
  private final int OhZ;
  private final int fLC;
  private volatile int inFlightTasks;
  private final ConcurrentLinkedQueue<Runnable> sVc;
  
  static
  {
    AppMethodBeat.i(118040);
    OhX = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public f(d paramd, int paramInt)
  {
    AppMethodBeat.i(209228);
    this.OhY = paramd;
    this.OhZ = paramInt;
    this.fLC = 1;
    this.sVc = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(209228);
  }
  
  private final void e(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (OhX.incrementAndGet(this) <= this.OhZ)
      {
        this.OhY.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.sVc.add(paramRunnable);
      if (OhX.decrementAndGet(this) >= this.OhZ)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.sVc.poll();
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
    e(paramRunnable, false);
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
    e(paramRunnable, false);
    AppMethodBeat.o(118033);
  }
  
  public final void gAX()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.sVc.poll();
    if (localRunnable != null)
    {
      this.OhY.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    OhX.decrementAndGet(this);
    localRunnable = (Runnable)this.sVc.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    e(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final int gAY()
  {
    return this.fLC;
  }
  
  public final Executor getExecutor()
  {
    return (Executor)this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = super.toString() + "[dispatcher = " + this.OhY + ']';
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.f
 * JD-Core Version:    0.7.0.1
 */