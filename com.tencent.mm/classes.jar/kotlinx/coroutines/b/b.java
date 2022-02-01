package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.d.d;
import d.g.a.m;
import d.g.b.aa;
import d.v;
import kotlinx.coroutines.a.z;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.q;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class b
{
  public static final <T, R> Object a(z<? super T> paramz, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(202332);
    paramz.gaB();
    try
    {
      locald = (d)paramz;
      if (paramm == null)
      {
        paramR = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(202332);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      d locald;
      for (paramR = new q(paramR); paramR == a.JgJ; paramR = ((m)aa.eR(paramm)).n(paramR, locald))
      {
        paramz = a.JgJ;
        AppMethodBeat.o(202332);
        return paramz;
      }
      paramR = paramz.gj(paramR);
      if (paramR == bo.KeC)
      {
        paramz = a.JgJ;
        AppMethodBeat.o(202332);
        return paramz;
      }
      if ((paramR instanceof q))
      {
        paramR = ((q)paramR).cause;
        paramz = paramz.LEJ;
        if ((!ah.fKX()) || (!(paramz instanceof e))) {}
        for (paramz = paramR;; paramz = kotlinx.coroutines.a.l.a(paramR, (e)paramz))
        {
          AppMethodBeat.o(202332);
          throw paramz;
        }
      }
      paramz = bo.fK(paramR);
      AppMethodBeat.o(202332);
    }
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.b.b
 * JD-Core Version:    0.7.0.1
 */