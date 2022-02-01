package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.bb;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "toString", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public class d
  extends bb
{
  private final int Izu;
  private final long KfS;
  private final String KfT;
  private a Kgl;
  private final int cUZ;
  
  private d(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(117970);
    this.cUZ = paramInt1;
    this.Izu = paramInt2;
    this.KfS = paramLong;
    this.KfT = paramString;
    this.Kgl = new a(this.cUZ, this.Izu, this.KfS, this.KfT);
    AppMethodBeat.o(117970);
  }
  
  private d(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, l.Kgw, paramString);
    AppMethodBeat.i(117971);
    AppMethodBeat.o(117971);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(117966);
    try
    {
      a.a(this.Kgl, paramRunnable);
      AppMethodBeat.o(117966);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      aj.KdJ.a(paramf, paramRunnable);
      AppMethodBeat.o(117966);
    }
  }
  
  public final void b(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(117969);
    try
    {
      this.Kgl.a(paramRunnable, paramj, paramBoolean);
      AppMethodBeat.o(117969);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      aj.KdJ.aU((Runnable)a.a(paramRunnable, paramj));
      AppMethodBeat.o(117969);
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(117967);
    this.Kgl.close();
    AppMethodBeat.o(117967);
  }
  
  public String toString()
  {
    AppMethodBeat.i(117968);
    String str = super.toString() + "[scheduler = " + this.Kgl + ']';
    AppMethodBeat.o(117968);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.d
 * JD-Core Version:    0.7.0.1
 */