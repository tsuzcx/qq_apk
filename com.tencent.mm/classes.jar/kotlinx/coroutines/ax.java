package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.l;
import d.p;
import d.q;
import d.v;
import d.y;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.w;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class ax
{
  private static final void a(aw<?> paramaw)
  {
    AppMethodBeat.i(191102);
    Object localObject = ce.LSl;
    localObject = ce.geq();
    if (((bc)localObject).gdU())
    {
      ((bc)localObject).b(paramaw);
      AppMethodBeat.o(191102);
      return;
    }
    ((bc)localObject).zG(true);
    try
    {
      a(paramaw, paramaw.gdt(), 2);
      boolean bool;
      do
      {
        bool = ((bc)localObject).gdT();
      } while (bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramaw.c(localThrowable, null);
      return;
    }
    finally
    {
      ((bc)localObject).gdW();
      AppMethodBeat.o(191102);
    }
  }
  
  public static final <T> void a(aw<? super T> paramaw, int paramInt)
  {
    AppMethodBeat.i(191100);
    Object localObject = paramaw.gdt();
    if ((ajb(paramInt)) && ((localObject instanceof at)) && (aja(paramInt) == aja(paramaw.LRu)))
    {
      ab localab = ((at)localObject).LRq;
      localObject = ((d.d.d)localObject).fOf();
      if (localab.gdB())
      {
        localab.a((f)localObject, (Runnable)paramaw);
        AppMethodBeat.o(191100);
        return;
      }
      a(paramaw);
      AppMethodBeat.o(191100);
      return;
    }
    a(paramaw, (d.d.d)localObject, paramInt);
    AppMethodBeat.o(191100);
  }
  
  private static <T> void a(aw<? super T> paramaw, d.d.d<? super T> paramd, int paramInt)
  {
    AppMethodBeat.i(191101);
    Object localObject = paramaw.gdn();
    paramaw = aw.fJ(localObject);
    if (paramaw != null) {
      if ((!al.gdE()) || (!(paramd instanceof d.d.b.a.d)))
      {
        label32:
        if (paramaw == null) {
          break label123;
        }
        localObject = p.KTg;
      }
    }
    for (paramaw = p.eI(q.n(paramaw));; paramaw = p.eI(localObject)) {
      switch (paramInt)
      {
      default: 
        paramaw = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
        AppMethodBeat.o(191101);
        throw paramaw;
        paramaw = r.a(paramaw, (d.d.b.a.d)paramd);
        break label32;
        paramaw = null;
        break label32;
        label123:
        paramaw = p.KTg;
      }
    }
    paramd.eK(paramaw);
    AppMethodBeat.o(191101);
    return;
    au.a(paramd, paramaw);
    AppMethodBeat.o(191101);
    return;
    if (paramd == null)
    {
      paramaw = new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      AppMethodBeat.o(191101);
      throw paramaw;
    }
    at localat = (at)paramd;
    paramd = localat.fOf();
    localObject = w.a(paramd, localat.LRo);
    try
    {
      localat.LRr.eK(paramaw);
      paramaw = y.KTp;
      return;
    }
    finally
    {
      w.b(paramd, localObject);
      AppMethodBeat.o(191101);
    }
  }
  
  public static final boolean aja(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean ajb(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ax
 * JD-Core Version:    0.7.0.1
 */