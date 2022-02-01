package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class ci
{
  private static final ThreadLocal<bd> Ogm;
  public static final ci Ogn;
  
  static
  {
    AppMethodBeat.i(209200);
    Ogn = new ci();
    Ogm = new ThreadLocal();
    AppMethodBeat.o(209200);
  }
  
  public static void a(bd parambd)
  {
    AppMethodBeat.i(209199);
    Ogm.set(parambd);
    AppMethodBeat.o(209199);
  }
  
  public static bd gAs()
  {
    AppMethodBeat.i(209197);
    bd localbd2 = (bd)Ogm.get();
    bd localbd1 = localbd2;
    if (localbd2 == null)
    {
      localbd1 = (bd)new e(Thread.currentThread());
      Ogm.set(localbd1);
    }
    AppMethodBeat.o(209197);
    return localbd1;
  }
  
  public static void gAt()
  {
    AppMethodBeat.i(209198);
    Ogm.set(null);
    AppMethodBeat.o(209198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ci
 * JD-Core Version:    0.7.0.1
 */