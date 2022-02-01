package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DisposeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class be
  extends bz<bu>
{
  private final bc TTy;
  
  public be(bu parambu, bc parambc)
  {
    super(parambu);
    this.TTy = parambc;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192391);
    String str = "DisposeOnCompletion[" + this.TTy + ']';
    AppMethodBeat.o(192391);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(192389);
    this.TTy.dispose();
    AppMethodBeat.o(192389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.be
 * JD-Core Version:    0.7.0.1
 */