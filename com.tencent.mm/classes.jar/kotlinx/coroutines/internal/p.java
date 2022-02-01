package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ce;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"})
final class p
  extends ce
  implements at
{
  private final String TWd;
  private final Throwable cause;
  
  public p(Throwable paramThrowable, String paramString)
  {
    this.cause = paramThrowable;
    this.TWd = paramString;
  }
  
  private final Void hNQ()
  {
    AppMethodBeat.i(192456);
    if (this.cause == null)
    {
      o.hNP();
      AppMethodBeat.o(192456);
      throw null;
    }
    StringBuilder localStringBuilder = new StringBuilder("Module with the Main dispatcher had failed to initialize");
    Object localObject = this.TWd;
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
    AppMethodBeat.o(192456);
    throw ((Throwable)localObject);
  }
  
  public final bc d(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(192453);
    hNQ();
    AppMethodBeat.o(192453);
    throw null;
  }
  
  public final boolean hMH()
  {
    AppMethodBeat.i(192452);
    hNQ();
    AppMethodBeat.o(192452);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192457);
    StringBuilder localStringBuilder = new StringBuilder("Main[missing");
    if (this.cause != null) {}
    for (String str = ", cause=" + this.cause;; str = "")
    {
      str = str + ']';
      AppMethodBeat.o(192457);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.p
 * JD-Core Version:    0.7.0.1
 */