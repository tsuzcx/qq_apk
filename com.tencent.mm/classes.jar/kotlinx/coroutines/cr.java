package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.p;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/RemoveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class cr
  extends g
{
  private final p ajwL;
  
  public cr(p paramp)
  {
    this.ajwL = paramp;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(188982);
    this.ajwL.remove();
    AppMethodBeat.o(188982);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188990);
    String str = "RemoveOnCancel[" + this.ajwL + ']';
    AppMethodBeat.o(188990);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cr
 * JD-Core Version:    0.7.0.1
 */