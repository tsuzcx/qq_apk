package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.bk;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f
  extends bk
  implements Executor, j
{
  private static final AtomicIntegerFieldUpdater TWU;
  private final d TWV;
  private final int TWW;
  private final int gqO;
  private volatile int inFlightTasks;
  private final ConcurrentLinkedQueue<Runnable> vTW;
  
  static
  {
    AppMethodBeat.i(118040);
    TWU = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public f(d paramd, int paramInt)
  {
    AppMethodBeat.i(192363);
    this.TWV = paramd;
    this.TWW = paramInt;
    this.gqO = 1;
    this.vTW = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(192363);
  }
  
  private final void d(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (TWU.incrementAndGet(this) <= this.TWW)
      {
        this.TWV.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.vTW.add(paramRunnable);
      if (TWU.decrementAndGet(this) >= this.TWW)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.vTW.poll();
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
  
  public final void hOe()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.vTW.poll();
    if (localRunnable != null)
    {
      this.TWV.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    TWU.decrementAndGet(this);
    localRunnable = (Runnable)this.vTW.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    d(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final int hOf()
  {
    return this.gqO;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = super.toString() + "[dispatcher = " + this.TWV + ']';
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.b.f
 * JD-Core Version:    0.7.0.1
 */