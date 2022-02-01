package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bi;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class u
  extends cm
  implements ba
{
  private final String ajAL;
  private final Throwable cause;
  
  public u(Throwable paramThrowable, String paramString)
  {
    this.cause = paramThrowable;
    this.ajAL = paramString;
  }
  
  private final Void kEl()
  {
    AppMethodBeat.i(189400);
    if (this.cause == null)
    {
      t.kEk();
      localObject = new kotlin.f();
      AppMethodBeat.o(189400);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ajAL;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localObject = new IllegalStateException(s.X("Module with the Main dispatcher had failed to initialize", localObject), this.cause);
      AppMethodBeat.o(189400);
      throw ((Throwable)localObject);
      String str = s.X(". ", localObject);
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final bi a(long paramLong, Runnable paramRunnable, kotlin.d.f paramf)
  {
    AppMethodBeat.i(189422);
    kEl();
    paramRunnable = new kotlin.f();
    AppMethodBeat.o(189422);
    throw paramRunnable;
  }
  
  public final boolean kBY()
  {
    AppMethodBeat.i(189414);
    kEl();
    kotlin.f localf = new kotlin.f();
    AppMethodBeat.o(189414);
    throw localf;
  }
  
  public final cm kCK()
  {
    return (cm)this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189431);
    StringBuilder localStringBuilder = new StringBuilder("Dispatchers.Main[missing");
    if (this.cause != null) {}
    for (String str = s.X(", cause=", this.cause);; str = "")
    {
      str = str + ']';
      AppMethodBeat.o(189431);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.u
 * JD-Core Version:    0.7.0.1
 */