package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.h;

@Metadata(d1={""}, d2={"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class be
{
  private static final void a(bd<?> parambd)
  {
    AppMethodBeat.i(188846);
    Object localObject = cz.ajwN;
    localObject = cz.kCM();
    if (((bm)localObject).kCn())
    {
      ((bm)localObject).b(parambd);
      AppMethodBeat.o(188846);
      return;
    }
    ((bm)localObject).PI(true);
    try
    {
      a(parambd, parambd.kBz(), true);
      boolean bool;
      do
      {
        bool = ((bm)localObject).kCl();
      } while (bool);
      ((bm)localObject).PJ(true);
      AppMethodBeat.o(188846);
      return;
    }
    finally
    {
      try
      {
        parambd.c(localThrowable, null);
        return;
      }
      finally
      {
        ((bm)localObject).PJ(true);
        AppMethodBeat.o(188846);
      }
    }
  }
  
  public static final <T> void a(bd<? super T> parambd, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(188831);
    if (au.ASSERTIONS_ENABLED)
    {
      if (paramInt != -1) {}
      for (int i = 1; i == 0; i = 0)
      {
        parambd = new AssertionError();
        AppMethodBeat.o(188831);
        throw parambd;
      }
    }
    Object localObject = parambd.kBz();
    if (paramInt == 4) {}
    while ((!bool) && ((localObject instanceof h)) && (aMD(paramInt) == aMD(parambd.ajvU)))
    {
      al localal = ((h)localObject).bRx;
      localObject = ((d)localObject).getContext();
      if (localal.kBY())
      {
        localal.a((f)localObject, (Runnable)parambd);
        AppMethodBeat.o(188831);
        return;
        bool = false;
      }
      else
      {
        a(parambd);
        AppMethodBeat.o(188831);
        return;
      }
    }
    a(parambd, (d)localObject, bool);
    AppMethodBeat.o(188831);
  }
  
  private static <T> void a(bd<? super T> parambd, d<? super T> paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(188839);
    Object localObject1 = parambd.kBC();
    Object localObject2 = parambd.iB(localObject1);
    h localh;
    if (localObject2 != null)
    {
      parambd = Result.Companion;
      parambd = Result.constructor-impl(ResultKt.createFailure((Throwable)localObject2));
      if (!paramBoolean) {
        break label174;
      }
      localh = (h)paramd;
      paramd = localh.alw;
      localObject2 = localh.ajAa;
      localObject1 = paramd.getContext();
      localObject2 = ag.b((f)localObject1, localObject2);
      if (localObject2 == ag.ajAT) {
        break label144;
      }
    }
    for (paramd = ak.a(paramd, (f)localObject1, localObject2);; paramd = null)
    {
      try
      {
        localh.alw.resumeWith(parambd);
        parambd = ah.aiuX;
        return;
      }
      finally
      {
        label144:
        if ((paramd != null) && (!paramd.kCP())) {
          break label167;
        }
        ag.c((f)localObject1, localObject2);
        AppMethodBeat.o(188839);
      }
      localObject2 = Result.Companion;
      parambd = Result.constructor-impl(parambd.iA(localObject1));
      break;
    }
    label167:
    label174:
    return;
  }
  
  public static final boolean aMD(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.be
 * JD-Core Version:    0.7.0.1
 */