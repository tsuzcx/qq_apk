package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.l;
import kotlinx.coroutines.an;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cs;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.v;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class b
{
  public static final <T, R> Object a(s<? super T> params, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(192393);
    params.hMl();
    try
    {
      locald = (d)params;
      if (paramm == null)
      {
        paramR = new kotlin.t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(192393);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      d locald;
      for (paramR = new v(paramR); paramR == a.SXO; paramR = ((m)af.r(paramm, 2)).invoke(paramR, locald))
      {
        params = a.SXO;
        AppMethodBeat.o(192393);
        return params;
      }
      paramR = params.fZ(paramR);
      if (paramR == cb.TVb)
      {
        params = a.SXO;
        AppMethodBeat.o(192393);
        return params;
      }
      if ((paramR instanceof v))
      {
        paramR = ((v)paramR).cause;
        params = params.TWf;
        if ((!an.hML()) || (!(params instanceof e))) {}
        for (params = paramR;; params = kotlinx.coroutines.internal.t.a(paramR, (e)params))
        {
          AppMethodBeat.o(192393);
          throw params;
        }
      }
      params = cb.gd(paramR);
      AppMethodBeat.o(192393);
    }
    return params;
  }
  
  public static final <T, R> Object b(s<? super T> params, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(192394);
    params.hMl();
    try
    {
      localObject = (d)params;
      if (paramm == null)
      {
        paramR = new kotlin.t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(192394);
        throw paramR;
      }
    }
    catch (Throwable paramR)
    {
      Object localObject;
      for (paramR = new v(paramR); paramR == a.SXO; paramR = ((m)af.r(paramm, 2)).invoke(paramR, localObject))
      {
        params = a.SXO;
        AppMethodBeat.o(192394);
        return params;
      }
      paramm = params.fZ(paramR);
      if (paramm == cb.TVb)
      {
        params = a.SXO;
        AppMethodBeat.o(192394);
        return params;
      }
      if ((paramm instanceof v))
      {
        localObject = ((v)paramm).cause;
        int i;
        if ((!(localObject instanceof cs)) || (((cs)localObject).TVm != params))
        {
          i = 1;
          if (i == 0) {
            break label202;
          }
          paramR = ((v)paramm).cause;
          params = params.TWf;
          if ((an.hML()) && ((params instanceof e))) {
            break label190;
          }
        }
        label190:
        for (params = paramR;; params = kotlinx.coroutines.internal.t.a(paramR, (e)params))
        {
          AppMethodBeat.o(192394);
          throw params;
          i = 0;
          break;
        }
        label202:
        if ((paramR instanceof v))
        {
          paramR = ((v)paramR).cause;
          params = params.TWf;
          if ((!an.hML()) || (!(params instanceof e))) {}
          for (params = paramR;; params = kotlinx.coroutines.internal.t.a(paramR, (e)params))
          {
            AppMethodBeat.o(192394);
            throw params;
          }
        }
        AppMethodBeat.o(192394);
        return paramR;
      }
      params = cb.gd(paramm);
      AppMethodBeat.o(192394);
    }
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a.b
 * JD-Core Version:    0.7.0.1
 */