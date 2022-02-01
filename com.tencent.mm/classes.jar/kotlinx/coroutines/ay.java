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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class ay
{
  private static final void a(ax<?> paramax)
  {
    AppMethodBeat.i(209203);
    Object localObject = ci.Ogn;
    localObject = ci.gAs();
    if (((bd)localObject).gzW())
    {
      ((bd)localObject).b(paramax);
      AppMethodBeat.o(209203);
      return;
    }
    ((bd)localObject).AH(true);
    try
    {
      a(paramax, paramax.gzv(), 2);
      boolean bool;
      do
      {
        bool = ((bd)localObject).gzV();
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
      ((bd)localObject).gzY();
      AppMethodBeat.o(209203);
    }
  }
  
  public static final <T> void a(ax<? super T> paramax, int paramInt)
  {
    AppMethodBeat.i(209201);
    Object localObject = paramax.gzv();
    if ((amm(paramInt)) && ((localObject instanceof au)) && (aml(paramInt) == aml(paramax.Ofv)))
    {
      ac localac = ((au)localObject).Ofr;
      localObject = ((d)localObject).gkg();
      if (localac.gzD())
      {
        localac.a((f)localObject, (Runnable)paramax);
        AppMethodBeat.o(209201);
        return;
      }
      a(paramax);
      AppMethodBeat.o(209201);
      return;
    }
    a(paramax, (d)localObject, paramInt);
    AppMethodBeat.o(209201);
  }
  
  private static <T> void a(ax<? super T> paramax, d<? super T> paramd, int paramInt)
  {
    AppMethodBeat.i(209202);
    Object localObject = paramax.gzp();
    paramax = ax.fP(localObject);
    if (paramax != null) {
      if ((!am.gzG()) || (!(paramd instanceof e)))
      {
        label32:
        if (paramax == null) {
          break label123;
        }
        localObject = p.Nhh;
      }
    }
    for (paramax = p.eO(q.p(paramax));; paramax = p.eO(localObject)) {
      switch (paramInt)
      {
      default: 
        paramax = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
        AppMethodBeat.o(209202);
        throw paramax;
        paramax = s.a(paramax, (e)paramd);
        break label32;
        paramax = null;
        break label32;
        label123:
        paramax = p.Nhh;
      }
    }
    paramd.eQ(paramax);
    AppMethodBeat.o(209202);
    return;
    av.a(paramd, paramax);
    AppMethodBeat.o(209202);
    return;
    if (paramd == null)
    {
      paramax = new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      AppMethodBeat.o(209202);
      throw paramax;
    }
    au localau = (au)paramd;
    paramd = localau.gkg();
    localObject = x.a(paramd, localau.Ofp);
    try
    {
      localau.Ofs.eQ(paramax);
      paramax = z.Nhr;
      return;
    }
    finally
    {
      x.b(paramd, localObject);
      AppMethodBeat.o(209202);
    }
  }
  
  public static final boolean aml(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean amm(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ay
 * JD-Core Version:    0.7.0.1
 */