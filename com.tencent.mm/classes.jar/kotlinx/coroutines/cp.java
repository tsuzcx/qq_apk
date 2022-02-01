package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class cp
{
  private static final ThreadLocal<bg> TVj;
  public static final cp TVk;
  
  static
  {
    AppMethodBeat.i(192328);
    TVk = new cp();
    TVj = new ThreadLocal();
    AppMethodBeat.o(192328);
  }
  
  public static void a(bg parambg)
  {
    AppMethodBeat.i(192327);
    TVj.set(parambg);
    AppMethodBeat.o(192327);
  }
  
  public static void hNA()
  {
    AppMethodBeat.i(192326);
    TVj.set(null);
    AppMethodBeat.o(192326);
  }
  
  public static bg hNz()
  {
    AppMethodBeat.i(192325);
    bg localbg2 = (bg)TVj.get();
    bg localbg1 = localbg2;
    if (localbg2 == null)
    {
      localbg1 = (bg)new e(Thread.currentThread());
      TVj.set(localbg1);
    }
    AppMethodBeat.o(192325);
    return localbg1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cp
 * JD-Core Version:    0.7.0.1
 */