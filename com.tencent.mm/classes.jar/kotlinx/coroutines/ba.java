package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class ba
  extends h
{
  private final az LQD;
  
  public ba(az paramaz)
  {
    AppMethodBeat.i(118047);
    this.LQD = paramaz;
    AppMethodBeat.o(118047);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118046);
    String str = "DisposeOnCancel[" + this.LQD + ']';
    AppMethodBeat.o(118046);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118044);
    this.LQD.dispose();
    AppMethodBeat.o(118044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ba
 * JD-Core Version:    0.7.0.1
 */