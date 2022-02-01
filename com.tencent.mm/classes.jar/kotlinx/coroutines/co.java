package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "parent", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class co
  implements v
{
  public static final co ajwK;
  
  static
  {
    AppMethodBeat.i(118190);
    ajwK = new co();
    AppMethodBeat.o(118190);
  }
  
  public final boolean Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(118189);
    AppMethodBeat.o(118189);
    return false;
  }
  
  public final void dispose() {}
  
  public final cb kBL()
  {
    return null;
  }
  
  public final String toString()
  {
    return "NonDisposableHandle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.co
 * JD-Core Version:    0.7.0.1
 */