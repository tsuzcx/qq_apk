package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class aq
  extends g
{
  private final ap CHV;
  
  public aq(ap paramap)
  {
    AppMethodBeat.i(118370);
    this.CHV = paramap;
    AppMethodBeat.o(118370);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118369);
    String str = "DisposeOnCancel[" + this.CHV + ']';
    AppMethodBeat.o(118369);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118367);
    this.CHV.dispose();
    AppMethodBeat.o(118367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.aq
 * JD-Core Version:    0.7.0.1
 */