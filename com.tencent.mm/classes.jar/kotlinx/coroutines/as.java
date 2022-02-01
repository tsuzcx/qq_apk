package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.p;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class as
{
  private static final void a(ar<?> paramar)
  {
    AppMethodBeat.i(189993);
    Object localObject = bz.KeL;
    localObject = bz.fLG();
    if (((ax)localObject).fLl())
    {
      ((ax)localObject).b(paramar);
      AppMethodBeat.o(189993);
      return;
    }
    ((ax)localObject).yo(true);
    try
    {
      a(paramar, paramar.fKM(), 2);
      boolean bool;
      do
      {
        bool = ((ax)localObject).fLk();
      } while (bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramar.c(localThrowable, null);
      return;
    }
    finally
    {
      ((ax)localObject).fLn();
      AppMethodBeat.o(189993);
    }
  }
  
  public static final <T> void a(ar<? super T> paramar, int paramInt)
  {
    AppMethodBeat.i(189991);
    Object localObject = paramar.fKM();
    if ((agf(paramInt)) && ((localObject instanceof ap)) && (age(paramInt) == age(paramar.KdT)))
    {
      y localy = ((ap)localObject).KdP;
      localObject = ((d)localObject).fvA();
      if (localy.fKU())
      {
        localy.a((f)localObject, (Runnable)paramar);
        AppMethodBeat.o(189991);
        return;
      }
      a(paramar);
      AppMethodBeat.o(189991);
      return;
    }
    a(paramar, (d)localObject, paramInt);
    AppMethodBeat.o(189991);
  }
  
  private static <T> void a(ar<? super T> paramar, d<? super T> paramd, int paramInt)
  {
    AppMethodBeat.i(189992);
    Object localObject = paramar.fKG();
    paramar = ar.fD(localObject);
    if (paramar != null) {
      if ((!ah.fKX()) || (!(paramd instanceof e)))
      {
        label32:
        if (paramar == null) {
          break label123;
        }
        localObject = p.JfM;
      }
    }
    for (paramar = p.eF(d.q.n(paramar));; paramar = p.eF(localObject)) {
      switch (paramInt)
      {
      default: 
        paramar = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
        AppMethodBeat.o(189992);
        throw paramar;
        paramar = kotlinx.coroutines.a.l.a(paramar, (e)paramd);
        break label32;
        paramar = null;
        break label32;
        label123:
        paramar = p.JfM;
      }
    }
    paramd.eH(paramar);
    AppMethodBeat.o(189992);
    return;
    aq.a(paramd, paramar);
    AppMethodBeat.o(189992);
    return;
    if (paramd == null)
    {
      paramar = new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      AppMethodBeat.o(189992);
      throw paramar;
    }
    ap localap = (ap)paramd;
    paramd = localap.fvA();
    localObject = kotlinx.coroutines.a.q.a(paramd, localap.KdN);
    try
    {
      localap.KdQ.eH(paramar);
      paramar = d.y.JfV;
      return;
    }
    finally
    {
      kotlinx.coroutines.a.q.b(paramd, localObject);
      AppMethodBeat.o(189992);
    }
  }
  
  public static final boolean age(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean agf(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.as
 * JD-Core Version:    0.7.0.1
 */