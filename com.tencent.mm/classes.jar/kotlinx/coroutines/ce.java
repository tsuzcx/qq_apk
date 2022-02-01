package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class ce
{
  private static final ThreadLocal<bc> LSk;
  public static final ce LSl;
  
  static
  {
    AppMethodBeat.i(191099);
    LSl = new ce();
    LSk = new ThreadLocal();
    AppMethodBeat.o(191099);
  }
  
  public static void a(bc parambc)
  {
    AppMethodBeat.i(191098);
    LSk.set(parambc);
    AppMethodBeat.o(191098);
  }
  
  public static bc geq()
  {
    AppMethodBeat.i(191096);
    bc localbc2 = (bc)LSk.get();
    bc localbc1 = localbc2;
    if (localbc2 == null)
    {
      localbc1 = (bc)new e(Thread.currentThread());
      LSk.set(localbc1);
    }
    AppMethodBeat.o(191096);
    return localbc1;
  }
  
  public static void ger()
  {
    AppMethodBeat.i(191097);
    LSk.set(null);
    AppMethodBeat.o(191097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ce
 * JD-Core Version:    0.7.0.1
 */