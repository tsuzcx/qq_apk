package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.br;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "toString", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends br
{
  private final int ahBX;
  private a ajBB;
  private final long ajBd;
  private final String ajBe;
  private final int hsI;
  
  private c(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(117970);
    this.hsI = paramInt1;
    this.ahBX = paramInt2;
    this.ajBd = paramLong;
    this.ajBe = paramString;
    this.ajBB = new a(this.hsI, this.ahBX, this.ajBd, this.ajBe);
    AppMethodBeat.o(117970);
  }
  
  private c(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, l.ajBL, paramString);
    AppMethodBeat.i(117971);
    AppMethodBeat.o(117971);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(117966);
    try
    {
      a.a(this.ajBB, paramRunnable, null, false, 6);
      AppMethodBeat.o(117966);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      aw.ajvR.a(paramf, paramRunnable);
      AppMethodBeat.o(117966);
    }
  }
  
  public final void b(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(117969);
    try
    {
      this.ajBB.a(paramRunnable, paramj, paramBoolean);
      AppMethodBeat.o(117969);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      aw.ajvR.bs((Runnable)a.a(paramRunnable, paramj));
      AppMethodBeat.o(117969);
    }
  }
  
  public final void b(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(189470);
    try
    {
      a.a(this.ajBB, paramRunnable, null, true, 2);
      AppMethodBeat.o(189470);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      aw.ajvR.b(paramf, paramRunnable);
      AppMethodBeat.o(189470);
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(117967);
    this.ajBB.close();
    AppMethodBeat.o(117967);
  }
  
  public String toString()
  {
    AppMethodBeat.i(117968);
    String str = super.toString() + "[scheduler = " + this.ajBB + ']';
    AppMethodBeat.o(117968);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.c
 * JD-Core Version:    0.7.0.1
 */