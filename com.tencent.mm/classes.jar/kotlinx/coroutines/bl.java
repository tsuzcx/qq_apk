package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
public final class bl
  implements ap, m
{
  public static final bl CIC;
  
  static
  {
    AppMethodBeat.i(118506);
    CIC = new bl();
    AppMethodBeat.o(118506);
  }
  
  public final void dispose() {}
  
  public final String toString()
  {
    return "NonDisposableHandle";
  }
  
  public final boolean x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118505);
    j.q(paramThrowable, "cause");
    AppMethodBeat.o(118505);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.bl
 * JD-Core Version:    0.7.0.1
 */