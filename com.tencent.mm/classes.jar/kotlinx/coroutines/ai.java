package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlinx.coroutines.internal.ab;

@Metadata(d1={""}, d2={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final <T> Object e(Object paramObject, d<? super T> paramd)
  {
    AppMethodBeat.i(188892);
    if ((paramObject instanceof ae))
    {
      Object localObject = Result.Companion;
      localObject = ((ae)paramObject).cause;
      paramObject = localObject;
      if (au.ajvP) {
        if ((paramd instanceof e)) {
          break label56;
        }
      }
      label56:
      for (paramObject = localObject;; paramObject = ab.a((Throwable)localObject, (e)paramd))
      {
        paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
        AppMethodBeat.o(188892);
        return paramObject;
      }
    }
    paramd = Result.Companion;
    paramObject = Result.constructor-impl(paramObject);
    AppMethodBeat.o(188892);
    return paramObject;
  }
  
  public static final <T> Object e(Object paramObject, b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(188887);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      if (paramb != null)
      {
        paramObject = new af(paramObject, paramb);
        AppMethodBeat.o(188887);
        return paramObject;
      }
      AppMethodBeat.o(188887);
      return paramObject;
    }
    paramObject = new ae(localThrowable);
    AppMethodBeat.o(188887);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ai
 * JD-Core Version:    0.7.0.1
 */