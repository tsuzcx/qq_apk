package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class bj
  extends n
{
  private final bi ajvj;
  
  public bj(bi parambi)
  {
    AppMethodBeat.i(118047);
    this.ajvj = parambi;
    AppMethodBeat.o(118047);
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118044);
    this.ajvj.dispose();
    AppMethodBeat.o(118044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118046);
    String str = "DisposeOnCancel[" + this.ajvj + ']';
    AppMethodBeat.o(118046);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bj
 * JD-Core Version:    0.7.0.1
 */