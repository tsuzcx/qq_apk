package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.y;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class az
{
  private static final void a(ay<?> paramay)
  {
    AppMethodBeat.i(192332);
    Object localObject = cp.TVk;
    localObject = cp.hNz();
    if (((bg)localObject).hNb())
    {
      ((bg)localObject).b(paramay);
      AppMethodBeat.o(192332);
      return;
    }
    ((bg)localObject).EX(true);
    try
    {
      a(paramay, paramay.hMz(), 2);
      boolean bool;
      do
      {
        bool = ((bg)localObject).hNa();
      } while (bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramay.c(localThrowable, null);
      return;
    }
    finally
    {
      ((bg)localObject).hNd();
      AppMethodBeat.o(192332);
    }
  }
  
  public static final <T> void a(ay<? super T> paramay, int paramInt)
  {
    AppMethodBeat.i(192330);
    Object localObject = paramay.hMz();
    if ((avV(paramInt)) && ((localObject instanceof av)) && (avU(paramInt) == avU(paramay.TUq)))
    {
      ad localad = ((av)localObject).TUm;
      localObject = ((d)localObject).getContext();
      if (localad.hMH())
      {
        localad.a((f)localObject, (Runnable)paramay);
        AppMethodBeat.o(192330);
        return;
      }
      a(paramay);
      AppMethodBeat.o(192330);
      return;
    }
    a(paramay, (d)localObject, paramInt);
    AppMethodBeat.o(192330);
  }
  
  private static <T> void a(ay<? super T> paramay, d<? super T> paramd, int paramInt)
  {
    AppMethodBeat.i(192331);
    Object localObject = paramay.hMt();
    paramay = ay.fT(localObject);
    if (paramay != null) {
      if ((!an.hML()) || (!(paramd instanceof e)))
      {
        label32:
        if (paramay == null) {
          break label123;
        }
        localObject = Result.Companion;
      }
    }
    for (paramay = Result.constructor-impl(ResultKt.createFailure(paramay));; paramay = Result.constructor-impl(localObject)) {
      switch (paramInt)
      {
      default: 
        paramay = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
        AppMethodBeat.o(192331);
        throw paramay;
        paramay = kotlinx.coroutines.internal.t.a(paramay, (e)paramd);
        break label32;
        paramay = null;
        break label32;
        label123:
        paramay = Result.Companion;
      }
    }
    paramd.resumeWith(paramay);
    AppMethodBeat.o(192331);
    return;
    aw.a(paramd, paramay);
    AppMethodBeat.o(192331);
    return;
    if (paramd == null)
    {
      paramay = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      AppMethodBeat.o(192331);
      throw paramay;
    }
    av localav = (av)paramd;
    paramd = localav.getContext();
    localObject = y.a(paramd, localav.TUk);
    try
    {
      localav.TUn.resumeWith(paramay);
      paramay = x.SXb;
      return;
    }
    finally
    {
      y.b(paramd, localObject);
      AppMethodBeat.o(192331);
    }
  }
  
  public static final boolean avU(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean avV(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.az
 * JD-Core Version:    0.7.0.1
 */