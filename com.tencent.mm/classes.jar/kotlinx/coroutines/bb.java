package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class bb
{
  private static final void a(ba<?> paramba)
  {
    AppMethodBeat.i(204786);
    Object localObject = cv.abxO;
    localObject = cv.iRX();
    if (((bi)localObject).iRw())
    {
      ((bi)localObject).b(paramba);
      AppMethodBeat.o(204786);
      return;
    }
    ((bi)localObject).JE(true);
    try
    {
      a(paramba, paramba.iQU(), 2);
      boolean bool;
      do
      {
        bool = ((bi)localObject).iRv();
      } while (bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramba.c(localThrowable, null);
      return;
    }
    finally
    {
      ((bi)localObject).JF(true);
      AppMethodBeat.o(204786);
    }
  }
  
  public static final <T> void a(ba<? super T> paramba, int paramInt)
  {
    AppMethodBeat.i(204783);
    Object localObject = paramba.iQU();
    if ((aFP(paramInt)) && ((localObject instanceof ax)) && (aFO(paramInt) == aFO(paramba.abwT)))
    {
      af localaf = ((ax)localObject).abwP;
      localObject = ((d)localObject).getContext();
      if (localaf.iRd())
      {
        localaf.a((f)localObject, (Runnable)paramba);
        AppMethodBeat.o(204783);
        return;
      }
      a(paramba);
      AppMethodBeat.o(204783);
      return;
    }
    a(paramba, (d)localObject, paramInt);
    AppMethodBeat.o(204783);
  }
  
  private static <T> void a(ba<? super T> paramba, d<? super T> paramd, int paramInt)
  {
    AppMethodBeat.i(204785);
    Object localObject2 = paramba.iQO();
    Object localObject1 = ba.gc(localObject2);
    if (localObject1 != null) {
      if ((!ap.iRh()) || (!(paramd instanceof e)))
      {
        label34:
        if (localObject1 == null) {
          break label123;
        }
        paramba = Result.Companion;
      }
    }
    for (paramba = Result.constructor-impl(ResultKt.createFailure((Throwable)localObject1));; paramba = Result.constructor-impl(paramba.fZ(localObject2))) {
      switch (paramInt)
      {
      default: 
        paramba = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
        AppMethodBeat.o(204785);
        throw paramba;
        localObject1 = u.a((Throwable)localObject1, (e)paramd);
        break label34;
        localObject1 = null;
        break label34;
        label123:
        localObject1 = Result.Companion;
      }
    }
    paramd.resumeWith(paramba);
    AppMethodBeat.o(204785);
    return;
    ay.a(paramd, paramba);
    AppMethodBeat.o(204785);
    return;
    if (paramd == null)
    {
      paramba = new t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      AppMethodBeat.o(204785);
      throw paramba;
    }
    localObject2 = (ax)paramd;
    paramd = ((ax)localObject2).getContext();
    localObject1 = z.a(paramd, ((ax)localObject2).abwN);
    try
    {
      ((ax)localObject2).abwQ.resumeWith(paramba);
      paramba = x.aazN;
      return;
    }
    finally
    {
      z.b(paramd, localObject1);
      AppMethodBeat.o(204785);
    }
  }
  
  public static final boolean aFO(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean aFP(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bb
 * JD-Core Version:    0.7.0.1
 */