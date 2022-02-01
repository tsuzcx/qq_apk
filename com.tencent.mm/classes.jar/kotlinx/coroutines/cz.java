package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class cz
{
  public static final cz ajwN;
  private static final ThreadLocal<bm> ajwO;
  
  static
  {
    AppMethodBeat.i(189036);
    ajwN = new cz();
    ajwO = new ThreadLocal();
    AppMethodBeat.o(189036);
  }
  
  public static void c(bm parambm)
  {
    AppMethodBeat.i(189026);
    ajwO.set(parambm);
    AppMethodBeat.o(189026);
  }
  
  public static bm kCM()
  {
    AppMethodBeat.i(189002);
    bm localbm = (bm)ajwO.get();
    if (localbm == null)
    {
      localbm = (bm)new i(Thread.currentThread());
      ajwO.set(localbm);
      AppMethodBeat.o(189002);
      return localbm;
    }
    AppMethodBeat.o(189002);
    return localbm;
  }
  
  public static bm kCN()
  {
    AppMethodBeat.i(189009);
    bm localbm = (bm)ajwO.get();
    AppMethodBeat.o(189009);
    return localbm;
  }
  
  public static void kCO()
  {
    AppMethodBeat.i(189019);
    ajwO.set(null);
    AppMethodBeat.o(189019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cz
 * JD-Core Version:    0.7.0.1
 */