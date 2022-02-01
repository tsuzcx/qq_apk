package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
public final class cg
  implements bc, q
{
  public static final cg TVh;
  
  static
  {
    AppMethodBeat.i(118190);
    TVh = new cg();
    AppMethodBeat.o(118190);
  }
  
  public final boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(118189);
    AppMethodBeat.o(118189);
    return false;
  }
  
  public final void dispose() {}
  
  public final String toString()
  {
    return "NonDisposableHandle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cg
 * JD-Core Version:    0.7.0.1
 */