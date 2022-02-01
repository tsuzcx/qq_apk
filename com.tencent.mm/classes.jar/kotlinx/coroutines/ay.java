package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.l;
import d.p;
import d.q;
import d.v;
import d.z;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.x;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class ay
{
  private static final void a(ax<?> paramax)
  {
    AppMethodBeat.i(190712);
    Object localObject = ci.NJh;
    localObject = ci.gvQ();
    if (((bd)localObject).gvu())
    {
      ((bd)localObject).b(paramax);
      AppMethodBeat.o(190712);
      return;
    }
    ((bd)localObject).Au(true);
    try
    {
      a(paramax, paramax.guT(), 2);
      boolean bool;
      do
      {
        bool = ((bd)localObject).gvt();
      } while (bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramax.c(localThrowable, null);
      return;
    }
    finally
    {
      ((bd)localObject).gvw();
      AppMethodBeat.o(190712);
    }
  }
  
  public static final <T> void a(ax<? super T> paramax, int paramInt)
  {
    AppMethodBeat.i(190710);
    Object localObject = paramax.guT();
    if ((alC(paramInt)) && ((localObject instanceof au)) && (alB(paramInt) == alB(paramax.NIp)))
    {
      ac localac = ((au)localObject).NIl;
      localObject = ((d)localObject).gfE();
      if (localac.gvb())
      {
        localac.a((f)localObject, (Runnable)paramax);
        AppMethodBeat.o(190710);
        return;
      }
      a(paramax);
      AppMethodBeat.o(190710);
      return;
    }
    a(paramax, (d)localObject, paramInt);
    AppMethodBeat.o(190710);
  }
  
  private static <T> void a(ax<? super T> paramax, d<? super T> paramd, int paramInt)
  {
    AppMethodBeat.i(190711);
    Object localObject = paramax.guN();
    paramax = ax.fM(localObject);
    if (paramax != null) {
      if ((!am.gve()) || (!(paramd instanceof e)))
      {
        label32:
        if (paramax == null) {
          break label123;
        }
        localObject = p.MKe;
      }
    }
    for (paramax = p.eL(q.o(paramax));; paramax = p.eL(localObject)) {
      switch (paramInt)
      {
      default: 
        paramax = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
        AppMethodBeat.o(190711);
        throw paramax;
        paramax = s.a(paramax, (e)paramd);
        break label32;
        paramax = null;
        break label32;
        label123:
        paramax = p.MKe;
      }
    }
    paramd.eN(paramax);
    AppMethodBeat.o(190711);
    return;
    av.a(paramd, paramax);
    AppMethodBeat.o(190711);
    return;
    if (paramd == null)
    {
      paramax = new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      AppMethodBeat.o(190711);
      throw paramax;
    }
    au localau = (au)paramd;
    paramd = localau.gfE();
    localObject = x.a(paramd, localau.NIj);
    try
    {
      localau.NIm.eN(paramax);
      paramax = z.MKo;
      return;
    }
    finally
    {
      x.b(paramd, localObject);
      AppMethodBeat.o(190711);
    }
  }
  
  public static final boolean alB(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean alC(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ay
 * JD-Core Version:    0.7.0.1
 */