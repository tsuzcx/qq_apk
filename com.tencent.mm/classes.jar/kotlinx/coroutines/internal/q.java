package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.av;
import kotlinx.coroutines.be;
import kotlinx.coroutines.ci;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"})
final class q
  extends ci
  implements av
{
  private final String abzu;
  private final Throwable cause;
  
  public q(Throwable paramThrowable, String paramString)
  {
    this.cause = paramThrowable;
    this.abzu = paramString;
  }
  
  private final Void iSW()
  {
    AppMethodBeat.i(204975);
    if (this.cause == null)
    {
      p.iSV();
      AppMethodBeat.o(204975);
      throw null;
    }
    StringBuilder localStringBuilder = new StringBuilder("Module with the Main dispatcher had failed to initialize");
    Object localObject = this.abzu;
    if (localObject != null)
    {
      String str = ". ".concat(String.valueOf(localObject));
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localObject = (Throwable)new IllegalStateException(localObject, this.cause);
    AppMethodBeat.o(204975);
    throw ((Throwable)localObject);
  }
  
  public final be d(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(204972);
    iSW();
    AppMethodBeat.o(204972);
    throw null;
  }
  
  public final ci iRV()
  {
    return (ci)this;
  }
  
  public final boolean iRd()
  {
    AppMethodBeat.i(204970);
    iSW();
    AppMethodBeat.o(204970);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204976);
    StringBuilder localStringBuilder = new StringBuilder("Main[missing");
    if (this.cause != null) {}
    for (String str = ", cause=" + this.cause;; str = "")
    {
      str = str + ']';
      AppMethodBeat.o(204976);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.q
 * JD-Core Version:    0.7.0.1
 */