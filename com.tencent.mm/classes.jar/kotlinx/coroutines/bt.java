package kotlinx.coroutines;

import a.c.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"})
public final class bt
  extends w
{
  public static final bt CIE;
  
  static
  {
    AppMethodBeat.i(118489);
    CIE = new bt();
    AppMethodBeat.o(118489);
  }
  
  public final void a(e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(118488);
    j.q(parame, "context");
    j.q(paramRunnable, "block");
    parame = (Throwable)new UnsupportedOperationException();
    AppMethodBeat.o(118488);
    throw parame;
  }
  
  public final boolean b(e parame)
  {
    AppMethodBeat.i(118487);
    j.q(parame, "context");
    AppMethodBeat.o(118487);
    return false;
  }
  
  public final String toString()
  {
    return "Unconfined";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.bt
 * JD-Core Version:    0.7.0.1
 */