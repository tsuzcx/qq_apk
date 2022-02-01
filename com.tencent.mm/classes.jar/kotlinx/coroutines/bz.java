package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class bz
{
  private static final ThreadLocal<ax> KeK;
  public static final bz KeL;
  
  static
  {
    AppMethodBeat.i(189990);
    KeL = new bz();
    KeK = new ThreadLocal();
    AppMethodBeat.o(189990);
  }
  
  public static void a(ax paramax)
  {
    AppMethodBeat.i(189989);
    KeK.set(paramax);
    AppMethodBeat.o(189989);
  }
  
  public static ax fLG()
  {
    AppMethodBeat.i(189987);
    ax localax2 = (ax)KeK.get();
    ax localax1 = localax2;
    if (localax2 == null)
    {
      localax1 = (ax)new c(Thread.currentThread());
      KeK.set(localax1);
    }
    AppMethodBeat.o(189987);
    return localax1;
  }
  
  public static void fLH()
  {
    AppMethodBeat.i(189988);
    KeK.set(null);
    AppMethodBeat.o(189988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bz
 * JD-Core Version:    0.7.0.1
 */