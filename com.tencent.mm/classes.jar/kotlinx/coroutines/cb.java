package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
public final class cb
  implements ba, q
{
  public static final cb Ogk;
  
  static
  {
    AppMethodBeat.i(118190);
    Ogk = new cb();
    AppMethodBeat.o(118190);
  }
  
  public final boolean A(Throwable paramThrowable)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cb
 * JD-Core Version:    0.7.0.1
 */