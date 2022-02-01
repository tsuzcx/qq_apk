package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class ci
{
  private static final ThreadLocal<bd> NJg;
  public static final ci NJh;
  
  static
  {
    AppMethodBeat.i(190709);
    NJh = new ci();
    NJg = new ThreadLocal();
    AppMethodBeat.o(190709);
  }
  
  public static void a(bd parambd)
  {
    AppMethodBeat.i(190708);
    NJg.set(parambd);
    AppMethodBeat.o(190708);
  }
  
  public static bd gvQ()
  {
    AppMethodBeat.i(190706);
    bd localbd2 = (bd)NJg.get();
    bd localbd1 = localbd2;
    if (localbd2 == null)
    {
      localbd1 = (bd)new e(Thread.currentThread());
      NJg.set(localbd1);
    }
    AppMethodBeat.o(190706);
    return localbd1;
  }
  
  public static void gvR()
  {
    AppMethodBeat.i(190707);
    NJg.set(null);
    AppMethodBeat.o(190707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ci
 * JD-Core Version:    0.7.0.1
 */