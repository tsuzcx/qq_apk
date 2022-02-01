package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DisposeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class bg
  extends cd<by>
{
  private final be abwb;
  
  public bg(by paramby, be parambe)
  {
    super(paramby);
    this.abwb = parambe;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204801);
    String str = "DisposeOnCompletion[" + this.abwb + ']';
    AppMethodBeat.o(204801);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(204799);
    this.abwb.dispose();
    AppMethodBeat.o(204799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.bg
 * JD-Core Version:    0.7.0.1
 */