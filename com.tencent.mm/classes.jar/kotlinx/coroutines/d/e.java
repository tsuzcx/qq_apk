package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.br;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "", "name", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Ljava/lang/String;", "I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "()I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  extends br
  implements Executor, j
{
  private final ConcurrentLinkedQueue<Runnable> Gap;
  private final c ajBC;
  private final int ajBD;
  private final int lxb;
  private final String name;
  
  static
  {
    AppMethodBeat.i(118040);
    ajBE = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");
    AppMethodBeat.o(118040);
  }
  
  public e(c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(189458);
    this.ajBC = paramc;
    this.ajBD = paramInt;
    this.name = paramString;
    this.lxb = 1;
    this.Gap = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
    AppMethodBeat.o(189458);
  }
  
  private final void c(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    for (;;)
    {
      if (ajBE.incrementAndGet(this) <= this.ajBD)
      {
        this.ajBC.b(paramRunnable, (j)this, paramBoolean);
        AppMethodBeat.o(118036);
        return;
      }
      this.Gap.add(paramRunnable);
      if (ajBE.decrementAndGet(this) >= this.ajBD)
      {
        AppMethodBeat.o(118036);
        return;
      }
      paramRunnable = (Runnable)this.Gap.poll();
      if (paramRunnable == null)
      {
        AppMethodBeat.o(118036);
        return;
      }
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118035);
    c(paramRunnable, false);
    AppMethodBeat.o(118035);
  }
  
  public final void b(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(189505);
    c(paramRunnable, true);
    AppMethodBeat.o(189505);
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
  
  public final int kEC()
  {
    return this.lxb;
  }
  
  public final void kED()
  {
    AppMethodBeat.i(118038);
    Runnable localRunnable = (Runnable)this.Gap.poll();
    if (localRunnable != null)
    {
      this.ajBC.b(localRunnable, (j)this, true);
      AppMethodBeat.o(118038);
      return;
    }
    ajBE.decrementAndGet(this);
    localRunnable = (Runnable)this.Gap.poll();
    if (localRunnable == null)
    {
      AppMethodBeat.o(118038);
      return;
    }
    c(localRunnable, true);
    AppMethodBeat.o(118038);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118037);
    String str = this.name;
    if (str == null)
    {
      str = super.toString() + "[dispatcher = " + this.ajBC + ']';
      AppMethodBeat.o(118037);
      return str;
    }
    AppMethodBeat.o(118037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.e
 * JD-Core Version:    0.7.0.1
 */