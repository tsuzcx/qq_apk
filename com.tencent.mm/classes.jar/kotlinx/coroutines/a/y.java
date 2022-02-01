package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"})
final class y
  extends br
  implements an
{
  private final String LEI;
  private final Throwable cause;
  
  public y(Throwable paramThrowable, String paramString)
  {
    this.cause = paramThrowable;
    this.LEI = paramString;
  }
  
  private final Void gaM()
  {
    AppMethodBeat.i(202359);
    if (this.cause == null)
    {
      x.gaL();
      AppMethodBeat.o(202359);
      throw null;
    }
    StringBuilder localStringBuilder = new StringBuilder("Module with the Main dispatcher had failed to initialize");
    Object localObject = this.LEI;
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
    AppMethodBeat.o(202359);
    throw ((Throwable)localObject);
  }
  
  public final boolean fKU()
  {
    AppMethodBeat.i(202356);
    gaM();
    AppMethodBeat.o(202356);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202360);
    StringBuilder localStringBuilder = new StringBuilder("Main[missing");
    if (this.cause != null) {}
    for (String str = ", cause=" + this.cause;; str = "")
    {
      str = str + ']';
      AppMethodBeat.o(202360);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.y
 * JD-Core Version:    0.7.0.1
 */