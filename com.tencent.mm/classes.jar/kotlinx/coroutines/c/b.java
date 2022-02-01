package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.an;
import kotlinx.coroutines.ae;
import kotlinx.coroutines.au;
import kotlinx.coroutines.cj;
import kotlinx.coroutines.da;
import kotlinx.coroutines.internal.ab;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final <T, R> Object a(y<? super T> paramy, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(188871);
    if (paramm == null) {
      try
      {
        paramR = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(188871);
        throw paramR;
      }
      finally
      {
        paramR = new ae(paramR);
      }
    }
    while (paramR == a.aiwj)
    {
      paramy = a.aiwj;
      AppMethodBeat.o(188871);
      return paramy;
      paramR = ((m)an.y(paramm, 2)).invoke(paramR, (d)paramy);
    }
    paramR = paramy.iK(paramR);
    if (paramR == cj.ajwE)
    {
      paramy = a.aiwj;
      AppMethodBeat.o(188871);
      return paramy;
    }
    if ((paramR instanceof ae))
    {
      paramR = ((ae)paramR).cause;
      paramy = paramy.ajzY;
      if ((!au.ajvP) || (!(paramy instanceof e))) {}
      for (paramy = paramR;; paramy = ab.a(paramR, (e)paramy))
      {
        AppMethodBeat.o(188871);
        throw paramy;
      }
    }
    paramy = cj.iN(paramR);
    AppMethodBeat.o(188871);
    return paramy;
  }
  
  public static final <T, R> Object b(y<? super T> paramy, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(188879);
    if (paramm == null) {
      try
      {
        paramR = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(188879);
        throw paramR;
      }
      finally
      {
        paramR = new ae(paramR);
      }
    }
    while (paramR == a.aiwj)
    {
      paramy = a.aiwj;
      AppMethodBeat.o(188879);
      return paramy;
      paramR = ((m)an.y(paramm, 2)).invoke(paramR, (d)paramy);
    }
    paramm = paramy.iK(paramR);
    if (paramm == cj.ajwE)
    {
      paramy = a.aiwj;
      AppMethodBeat.o(188879);
      return paramy;
    }
    if ((paramm instanceof ae))
    {
      Throwable localThrowable = ((ae)paramm).cause;
      int i;
      if ((!(localThrowable instanceof da)) || (((da)localThrowable).ajwP != paramy))
      {
        i = 1;
        if (i == 0) {
          break label194;
        }
        paramR = ((ae)paramm).cause;
        paramy = paramy.ajzY;
        if ((au.ajvP) && ((paramy instanceof e))) {
          break label182;
        }
      }
      label182:
      for (paramy = paramR;; paramy = ab.a(paramR, (e)paramy))
      {
        AppMethodBeat.o(188879);
        throw paramy;
        i = 0;
        break;
      }
      label194:
      if ((paramR instanceof ae))
      {
        paramR = ((ae)paramR).cause;
        paramy = paramy.ajzY;
        if ((!au.ajvP) || (!(paramy instanceof e))) {}
        for (paramy = paramR;; paramy = ab.a(paramR, (e)paramy))
        {
          AppMethodBeat.o(188879);
          throw paramy;
        }
      }
      AppMethodBeat.o(188879);
      return paramR;
    }
    paramy = cj.iN(paramm);
    AppMethodBeat.o(188879);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.b
 * JD-Core Version:    0.7.0.1
 */