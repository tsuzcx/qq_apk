package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.bn;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f
  extends bn
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater abAl;
  private final ConcurrentLinkedQueue<Runnable> ABz;
  private final d abAm;
  private final int abAn;
  private final int iUW;
  private volatile int inFlightTasks;
  
  static
  {
    AppMethodBeat.i(118040);
    abAl = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public f(d paramd, int paramInt)
  {
    AppMethodBeat.i(204713);
    this.abAm = paramd;
    this.abAn = paramInt;
    this.iUW = 1;
    this.ABz = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(204713);
  }
  
  private final void d(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (abAl.incrementAndGet(this) <= this.abAn)
      {
        this.abAm.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.ABz.add(paramRunnable);
      if (abAl.decrementAndGet(this) >= this.abAn)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.ABz.poll();
      if (paramRunnable == null)
      {
        AppMethodBeat.o(118036);
        return;
      }
    }
  }
  
  public final void a(kotlin.d.f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118035);
    d(paramRunnable, false);
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
    d(paramRunnable, false);
    AppMethodBeat.o(118033);
  }
  
  public final Executor getExecutor()
  {
    return (Executor)this;
  }
  
  public final void iTk()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.ABz.poll();
    if (localRunnable != null)
    {
      this.abAm.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    abAl.decrementAndGet(this);
    localRunnable = (Runnable)this.ABz.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    d(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final int iTl()
  {
    return this.iUW;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = super.toString() + "[dispatcher = " + this.abAm + ']';
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.d.f
 * JD-Core Version:    0.7.0.1
 */