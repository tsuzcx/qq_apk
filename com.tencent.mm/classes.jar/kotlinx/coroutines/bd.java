package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class bd
  extends i
{
  private final bc TTy;
  
  public bd(bc parambc)
  {
    AppMethodBeat.i(118047);
    this.TTy = parambc;
    AppMethodBeat.o(118047);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118046);
    String str = "DisposeOnCancel[" + this.TTy + ']';
    AppMethodBeat.o(118046);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118044);
    this.TTy.dispose();
    AppMethodBeat.o(118044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */