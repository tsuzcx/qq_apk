package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.d.d;
import d.g.a.m;
import d.g.b.ae;
import d.l;
import d.v;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bw;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.u;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class b
{
  public static final <T, R> Object a(r<? super T> paramr, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(209254);
    paramr.gzh();
    try
    {
      locald = (d)paramr;
      if (paramm == null)
      {
        paramR = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(209254);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      d locald;
      for (paramR = new u(paramR); paramR == a.Nif; paramR = ((m)ae.p(paramm, 2)).p(paramR, locald))
      {
        paramr = a.Nif;
        AppMethodBeat.o(209254);
        return paramr;
      }
      paramR = paramr.fU(paramR);
      if (paramR == bw.Oge)
      {
        paramr = a.Nif;
        AppMethodBeat.o(209254);
        return paramr;
      }
      if ((paramR instanceof u))
      {
        paramR = ((u)paramR).cause;
        paramr = paramr.Ohh;
        if ((!am.gzG()) || (!(paramr instanceof e))) {}
        for (paramr = paramR;; paramr = s.a(paramR, (e)paramr))
        {
          AppMethodBeat.o(209254);
          throw paramr;
        }
      }
      paramr = bw.fY(paramR);
      AppMethodBeat.o(209254);
    }
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a.b
 * JD-Core Version:    0.7.0.1
 */