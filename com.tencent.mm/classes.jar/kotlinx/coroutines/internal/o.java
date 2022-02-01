package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.as;
import kotlinx.coroutines.bz;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"})
final class o
  extends bz
  implements as
{
  private final String Ohf;
  private final Throwable cause;
  
  public o(Throwable paramThrowable, String paramString)
  {
    this.cause = paramThrowable;
    this.Ohf = paramString;
  }
  
  private final Void gAJ()
  {
    AppMethodBeat.i(209312);
    if (this.cause == null)
    {
      n.gAI();
      AppMethodBeat.o(209312);
      throw null;
    }
    StringBuilder localStringBuilder = new StringBuilder("Module with the Main dispatcher had failed to initialize");
    Object localObject = this.Ohf;
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
    AppMethodBeat.o(209312);
    throw ((Throwable)localObject);
  }
  
  public final boolean gzD()
  {
    AppMethodBeat.i(209309);
    gAJ();
    AppMethodBeat.o(209309);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209313);
    StringBuilder localStringBuilder = new StringBuilder("Main[missing");
    if (this.cause != null) {}
    for (String str = ", cause=" + this.cause;; str = "")
    {
      str = str + ']';
      AppMethodBeat.o(209313);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.o
 * JD-Core Version:    0.7.0.1
 */