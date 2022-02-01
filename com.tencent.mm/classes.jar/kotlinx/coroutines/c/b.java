package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ag;
import kotlin.l;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.cf;
import kotlinx.coroutines.cy;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class b
{
  public static final <T, R> Object a(kotlinx.coroutines.internal.t<? super T> paramt, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(204880);
    paramt.iQC();
    try
    {
      locald = (d)paramt;
      if (paramm == null)
      {
        paramR = new kotlin.t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(204880);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      d locald;
      for (paramR = new x(paramR); paramR == a.aaAA; paramR = ((m)ag.x(paramm, 2)).invoke(paramR, locald))
      {
        paramt = a.aaAA;
        AppMethodBeat.o(204880);
        return paramt;
      }
      paramR = paramt.gi(paramR);
      if (paramR == cf.abxE)
      {
        paramt = a.aaAA;
        AppMethodBeat.o(204880);
        return paramt;
      }
      if ((paramR instanceof x))
      {
        paramR = ((x)paramR).cause;
        paramt = paramt.abzw;
        if ((!ap.iRh()) || (!(paramt instanceof e))) {}
        for (paramt = paramR;; paramt = u.a(paramR, (e)paramt))
        {
          AppMethodBeat.o(204880);
          throw paramt;
        }
      }
      paramt = cf.gl(paramR);
      AppMethodBeat.o(204880);
    }
    return paramt;
  }
  
  public static final <T, R> Object b(kotlinx.coroutines.internal.t<? super T> paramt, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(204881);
    paramt.iQC();
    try
    {
      localObject = (d)paramt;
      if (paramm == null)
      {
        paramR = new kotlin.t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(204881);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      Object localObject;
      for (paramR = new x(paramR); paramR == a.aaAA; paramR = ((m)ag.x(paramm, 2)).invoke(paramR, localObject))
      {
        paramt = a.aaAA;
        AppMethodBeat.o(204881);
        return paramt;
      }
      paramm = paramt.gi(paramR);
      if (paramm == cf.abxE)
      {
        paramt = a.aaAA;
        AppMethodBeat.o(204881);
        return paramt;
      }
      if ((paramm instanceof x))
      {
        localObject = ((x)paramm).cause;
        int i;
        if ((!(localObject instanceof cy)) || (((cy)localObject).abxQ != paramt))
        {
          i = 1;
          if (i == 0) {
            break label202;
          }
          paramR = ((x)paramm).cause;
          paramt = paramt.abzw;
          if ((ap.iRh()) && ((paramt instanceof e))) {
            break label190;
          }
        }
        label190:
        for (paramt = paramR;; paramt = u.a(paramR, (e)paramt))
        {
          AppMethodBeat.o(204881);
          throw paramt;
          i = 0;
          break;
        }
        label202:
        if ((paramR instanceof x))
        {
          paramR = ((x)paramR).cause;
          paramt = paramt.abzw;
          if ((!ap.iRh()) || (!(paramt instanceof e))) {}
          for (paramt = paramR;; paramt = u.a(paramR, (e)paramt))
          {
            AppMethodBeat.o(204881);
            throw paramt;
          }
        }
        AppMethodBeat.o(204881);
        return paramR;
      }
      paramt = cf.gl(paramm);
      AppMethodBeat.o(204881);
    }
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.c.b
 * JD-Core Version:    0.7.0.1
 */