package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.bh;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f
  extends bh
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater NKR;
  private final d NKS;
  private final int NKT;
  private final int fJz;
  private volatile int inFlightTasks;
  private final ConcurrentLinkedQueue<Runnable> sJP;
  
  static
  {
    AppMethodBeat.i(118040);
    NKR = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public f(d paramd, int paramInt)
  {
    AppMethodBeat.i(190737);
    this.NKS = paramd;
    this.NKT = paramInt;
    this.fJz = 1;
    this.sJP = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(190737);
  }
  
  private final void c(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (NKR.incrementAndGet(this) <= this.NKT)
      {
        this.NKS.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.sJP.add(paramRunnable);
      if (NKR.decrementAndGet(this) >= this.NKT)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.sJP.poll();
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
  
  public final Executor getExecutor()
  {
    return (Executor)this;
  }
  
  public final void gwv()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.sJP.poll();
    if (localRunnable != null)
    {
      this.NKS.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    NKR.decrementAndGet(this);
    localRunnable = (Runnable)this.sJP.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    c(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final int gww()
  {
    return this.fJz;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = super.toString() + "[dispatcher = " + this.NKS + ']';
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.f
 * JD-Core Version:    0.7.0.1
 */