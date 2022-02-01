package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bw;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"})
final class n
  extends bw
  implements ar
{
  private final String LTc;
  private final Throwable cause;
  
  public n(Throwable paramThrowable, String paramString)
  {
    this.cause = paramThrowable;
    this.LTc = paramString;
  }
  
  private final Void geI()
  {
    AppMethodBeat.i(191210);
    if (this.cause == null)
    {
      m.geH();
      AppMethodBeat.o(191210);
      throw null;
    }
    StringBuilder localStringBuilder = new StringBuilder("Module with the Main dispatcher had failed to initialize");
    Object localObject = this.LTc;
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
    AppMethodBeat.o(191210);
    throw ((Throwable)localObject);
  }
  
  public final boolean gdB()
  {
    AppMethodBeat.i(191207);
    geI();
    AppMethodBeat.o(191207);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191211);
    StringBuilder localStringBuilder = new StringBuilder("Main[missing");
    if (this.cause != null) {}
    for (String str = ", cause=" + this.cause;; str = "")
    {
      str = str + ']';
      AppMethodBeat.o(191211);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.n
 * JD-Core Version:    0.7.0.1
 */