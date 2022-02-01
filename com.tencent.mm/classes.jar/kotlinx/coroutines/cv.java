package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class cv
{
  private static final ThreadLocal<bi> abxN;
  public static final cv abxO;
  
  static
  {
    AppMethodBeat.i(204921);
    abxO = new cv();
    abxN = new ThreadLocal();
    AppMethodBeat.o(204921);
  }
  
  public static void c(bi parambi)
  {
    AppMethodBeat.i(204920);
    abxN.set(parambi);
    AppMethodBeat.o(204920);
  }
  
  public static bi iRX()
  {
    AppMethodBeat.i(204916);
    bi localbi2 = (bi)abxN.get();
    bi localbi1 = localbi2;
    if (localbi2 == null)
    {
      localbi1 = (bi)new f(Thread.currentThread());
      abxN.set(localbi1);
    }
    AppMethodBeat.o(204916);
    return localbi1;
  }
  
  public static bi iRY()
  {
    AppMethodBeat.i(204918);
    bi localbi = (bi)abxN.get();
    AppMethodBeat.o(204918);
    return localbi;
  }
  
  public static void iRZ()
  {
    AppMethodBeat.i(204919);
    abxN.set(null);
    AppMethodBeat.o(204919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cv
 * JD-Core Version:    0.7.0.1
 */