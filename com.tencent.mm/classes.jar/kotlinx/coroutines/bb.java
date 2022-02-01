package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class bb
  extends i
{
  private final ba OeE;
  
  public bb(ba paramba)
  {
    AppMethodBeat.i(118047);
    this.OeE = paramba;
    AppMethodBeat.o(118047);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118046);
    String str = "DisposeOnCancel[" + this.OeE + ']';
    AppMethodBeat.o(118046);
    return str;
  }
  
  public final void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118044);
    this.OeE.dispose();
    AppMethodBeat.o(118044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bb
 * JD-Core Version:    0.7.0.1
 */