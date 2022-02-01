package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.l;
import kotlinx.coroutines.internal.u;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class y
{
  public static final <T> Object b(Object paramObject, d<? super T> paramd)
  {
    AppMethodBeat.i(204221);
    if ((paramObject instanceof x))
    {
      Object localObject = Result.Companion;
      localObject = ((x)paramObject).cause;
      paramObject = localObject;
      if (ap.iRh()) {
        if ((paramd instanceof e)) {
          break label56;
        }
      }
      label56:
      for (paramObject = localObject;; paramObject = u.a((Throwable)localObject, (e)paramd))
      {
        paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
        AppMethodBeat.o(204221);
        return paramObject;
      }
    }
    paramd = Result.Companion;
    paramObject = Result.constructor-impl(paramObject);
    AppMethodBeat.o(204221);
    return paramObject;
  }
  
  public static final <T> Object ga(Object paramObject)
  {
    AppMethodBeat.i(118154);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(118154);
      return paramObject;
    }
    paramObject = new x(localThrowable);
    AppMethodBeat.o(118154);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.y
 * JD-Core Version:    0.7.0.1
 */