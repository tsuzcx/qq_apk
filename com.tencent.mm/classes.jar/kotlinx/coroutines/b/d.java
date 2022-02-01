package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bg;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "toString", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public class d
  extends bg
{
  private final int Kbd;
  private final long LTA;
  private final String LTB;
  private a LTV;
  private final int cSv;
  
  private d(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(117970);
    this.cSv = paramInt1;
    this.Kbd = paramInt2;
    this.LTA = paramLong;
    this.LTB = paramString;
    this.LTV = new a(this.cSv, this.Kbd, this.LTA, this.LTB);
    AppMethodBeat.o(117970);
  }
  
  private d(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, l.LUg, paramString);
    AppMethodBeat.i(117971);
    AppMethodBeat.o(117971);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(117966);
    try
    {
      a.a(this.LTV, paramRunnable);
      AppMethodBeat.o(117966);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      an.LRk.a(paramf, paramRunnable);
      AppMethodBeat.o(117966);
    }
  }
  
  public final void b(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(117969);
    try
    {
      this.LTV.a(paramRunnable, paramj, paramBoolean);
      AppMethodBeat.o(117969);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      an.LRk.aX((Runnable)a.a(paramRunnable, paramj));
      AppMethodBeat.o(117969);
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(117967);
    this.LTV.close();
    AppMethodBeat.o(117967);
  }
  
  public String toString()
  {
    AppMethodBeat.i(117968);
    String str = super.toString() + "[scheduler = " + this.LTV + ']';
    AppMethodBeat.o(117968);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.d
 * JD-Core Version:    0.7.0.1
 */