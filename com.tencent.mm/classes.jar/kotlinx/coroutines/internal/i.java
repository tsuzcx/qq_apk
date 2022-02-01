package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bm;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cz;
import kotlinx.coroutines.de;

@Metadata(d1={""}, d2={"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "getREUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "getUNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final ac ajAn;
  private static final ac ajxL;
  
  static
  {
    AppMethodBeat.i(189430);
    ajxL = new ac("UNDEFINED");
    ajAn = new ac("REUSABLE_CLAIMED");
    AppMethodBeat.o(189430);
  }
  
  public static final <T> void a(d<? super T> paramd, Object paramObject, b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(189396);
    if ((paramd instanceof h))
    {
      h localh = (h)paramd;
      paramd = ai.e(paramObject, null);
      paramb = localh.bRx;
      localh.getContext();
      if (paramb.kBY())
      {
        localh._state = paramd;
        localh.ajvU = 1;
        localh.bRx.a(localh.getContext(), (Runnable)localh);
        AppMethodBeat.o(189396);
        return;
      }
      paramb = cz.ajwN;
      paramb = cz.kCM();
      if (paramb.kCn())
      {
        localh._state = paramd;
        localh.ajvU = 1;
        paramb.b((bd)localh);
        AppMethodBeat.o(189396);
        return;
      }
      bd localbd = (bd)localh;
      paramb.PI(true);
      try
      {
        Object localObject1 = (cb)localh.getContext().get((f.c)cb.ajws);
        Object localObject2;
        int i;
        if ((localObject1 != null) && (!((cb)localObject1).isActive()))
        {
          localObject1 = ((cb)localObject1).kCu();
          localh.a(paramd, (Throwable)localObject1);
          paramd = (d)localh;
          localObject2 = Result.Companion;
          paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject1)));
          i = 1;
          if (i == 0)
          {
            paramd = localh.alw;
            localObject2 = localh.ajAa;
            localObject1 = paramd.getContext();
            localObject2 = ag.b((f)localObject1, localObject2);
            if (localObject2 == ag.ajAT) {
              break label330;
            }
          }
        }
        for (paramd = ak.a(paramd, (f)localObject1, localObject2);; paramd = null)
        {
          try
          {
            localh.alw.resumeWith(paramObject);
            paramObject = ah.aiuX;
            if ((paramd == null) || (paramd.kCP())) {
              ag.c((f)localObject1, localObject2);
            }
            boolean bool;
            return;
          }
          finally
          {
            label330:
            if ((paramd != null) && (!paramd.kCP())) {
              break label354;
            }
            ag.c((f)localObject1, localObject2);
            AppMethodBeat.o(189396);
          }
          i = 0;
          break;
        }
        label354:
        paramd.resumeWith(paramObject);
      }
      finally
      {
        try
        {
          localbd.c(paramd, null);
          return;
        }
        finally
        {
          paramb.PJ(true);
          AppMethodBeat.o(189396);
        }
      }
    }
    AppMethodBeat.o(189396);
  }
  
  public static final boolean a(h<? super ah> paramh)
  {
    AppMethodBeat.i(189413);
    localObject2 = ah.aiuX;
    localObject1 = cz.ajwN;
    localObject1 = cz.kCM();
    if (((bm)localObject1).kCo())
    {
      AppMethodBeat.o(189413);
      return false;
    }
    if (((bm)localObject1).kCn())
    {
      paramh._state = localObject2;
      paramh.ajvU = 1;
      ((bm)localObject1).b((bd)paramh);
      AppMethodBeat.o(189413);
      return true;
    }
    localObject2 = (bd)paramh;
    ((bm)localObject1).PI(true);
    try
    {
      paramh.run();
      boolean bool;
      do
      {
        bool = ((bm)localObject1).kCl();
      } while (bool);
      ((bm)localObject1).PJ(true);
    }
    finally
    {
      try
      {
        ((bd)localObject2).c(paramh, null);
        ((bm)localObject1).PJ(true);
      }
      finally
      {
        ((bm)localObject1).PJ(true);
        AppMethodBeat.o(189413);
      }
    }
    AppMethodBeat.o(189413);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.i
 * JD-Core Version:    0.7.0.1
 */