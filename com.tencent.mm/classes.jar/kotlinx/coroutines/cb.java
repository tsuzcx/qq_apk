package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
public final class cb
  implements ba, q
{
  public static final cb NJe;
  
  static
  {
    AppMethodBeat.i(118190);
    NJe = new cb();
    AppMethodBeat.o(118190);
  }
  
  public final void dispose() {}
  
  public final String toString()
  {
    return "NonDisposableHandle";
  }
  
  public final boolean z(Throwable paramThrowable)
  {
    AppMethodBeat.i(118189);
    AppMethodBeat.o(118189);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cb
 * JD-Core Version:    0.7.0.1
 */