package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.g.a.m;
import d.g.b.aa;
import d.l;
import d.v;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bt;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.t;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class b
{
  public static final <T, R> Object a(q<? super T> paramq, R paramR, m<? super R, ? super d.d.d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(191153);
    paramq.gdf();
    try
    {
      locald = (d.d.d)paramq;
      if (paramm == null)
      {
        paramR = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(191153);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      d.d.d locald;
      for (paramR = new t(paramR); paramR == a.KUd; paramR = ((m)aa.eU(paramm)).n(paramR, locald))
      {
        paramq = a.KUd;
        AppMethodBeat.o(191153);
        return paramq;
      }
      paramR = paramq.fO(paramR);
      if (paramR == bt.LSc)
      {
        paramq = a.KUd;
        AppMethodBeat.o(191153);
        return paramq;
      }
      if ((paramR instanceof t))
      {
        paramR = ((t)paramR).cause;
        paramq = paramq.LTe;
        if ((!al.gdE()) || (!(paramq instanceof d.d.b.a.d))) {}
        for (paramq = paramR;; paramq = r.a(paramR, (d.d.b.a.d)paramq))
        {
          AppMethodBeat.o(191153);
          throw paramq;
        }
      }
      paramq = bt.fS(paramR);
      AppMethodBeat.o(191153);
    }
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a.b
 * JD-Core Version:    0.7.0.1
 */