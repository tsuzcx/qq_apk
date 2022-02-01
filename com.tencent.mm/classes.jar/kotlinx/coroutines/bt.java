package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
public final class bt
  implements au, m
{
  public static final bt KeI;
  
  static
  {
    AppMethodBeat.i(118190);
    KeI = new bt();
    AppMethodBeat.o(118190);
  }
  
  public final void dispose() {}
  
  public final String toString()
  {
    return "NonDisposableHandle";
  }
  
  public final boolean x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118189);
    AppMethodBeat.o(118189);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bt
 * JD-Core Version:    0.7.0.1
 */