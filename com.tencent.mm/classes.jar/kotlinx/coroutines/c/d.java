package kotlinx.coroutines.c;

import a.c.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.av;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "toString", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public class d
  extends av
{
  private final int CJP;
  private final long CJQ;
  private final String CJR;
  private a CKq;
  private final int cgb;
  
  private d(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118294);
    this.cgb = paramInt1;
    this.CJP = paramInt2;
    this.CJQ = paramLong;
    this.CJR = paramString;
    this.CKq = new a(this.cgb, this.CJP, this.CJQ, this.CJR);
    AppMethodBeat.o(118294);
  }
  
  private d(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, m.CKJ, paramString);
    AppMethodBeat.i(118295);
    AppMethodBeat.o(118295);
  }
  
  public final void a(e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(118290);
    a.f.b.j.q(parame, "context");
    a.f.b.j.q(paramRunnable, "block");
    try
    {
      a.a(this.CKq, paramRunnable);
      AppMethodBeat.o(118290);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      ag.CHJ.a(parame, paramRunnable);
      AppMethodBeat.o(118290);
    }
  }
  
  public final void b(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(118293);
    a.f.b.j.q(paramRunnable, "block");
    a.f.b.j.q(paramj, "context");
    try
    {
      this.CKq.a(paramRunnable, paramj, paramBoolean);
      AppMethodBeat.o(118293);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      ag.CHJ.aC((Runnable)a.a(paramRunnable, paramj));
      AppMethodBeat.o(118293);
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(118291);
    this.CKq.close();
    AppMethodBeat.o(118291);
  }
  
  public String toString()
  {
    AppMethodBeat.i(118292);
    String str = super.toString() + "[scheduler = " + this.CKq + ']';
    AppMethodBeat.o(118292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlinx.coroutines.c.d
 * JD-Core Version:    0.7.0.1
 */