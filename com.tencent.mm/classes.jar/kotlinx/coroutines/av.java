package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class av
  extends f
{
  private final au KdY;
  
  public av(au paramau)
  {
    AppMethodBeat.i(118047);
    this.KdY = paramau;
    AppMethodBeat.o(118047);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118046);
    String str = "DisposeOnCancel[" + this.KdY + ']';
    AppMethodBeat.o(118046);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118044);
    this.KdY.dispose();
    AppMethodBeat.o(118044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.av
 * JD-Core Version:    0.7.0.1
 */