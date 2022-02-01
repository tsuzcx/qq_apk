package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
public final class by
  implements az, p
{
  public static final by LSi;
  
  static
  {
    AppMethodBeat.i(118190);
    LSi = new by();
    AppMethodBeat.o(118190);
  }
  
  public final void dispose() {}
  
  public final String toString()
  {
    return "NonDisposableHandle";
  }
  
  public final boolean y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118189);
    AppMethodBeat.o(118189);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.by
 * JD-Core Version:    0.7.0.1
 */