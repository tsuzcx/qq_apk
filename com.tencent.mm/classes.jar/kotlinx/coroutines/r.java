package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class r
  extends bw<ca>
  implements q
{
  public final s TTH;
  
  public r(ca paramca, s params)
  {
    super((bu)paramca);
    AppMethodBeat.i(118196);
    this.TTH = params;
    AppMethodBeat.o(118196);
  }
  
  public final boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    boolean bool = ((ca)this.TUQ).B(paramThrowable);
    AppMethodBeat.o(118194);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118195);
    String str = "ChildHandle[" + this.TTH + ']';
    AppMethodBeat.o(118195);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.TTH.a((ci)this.TUQ);
    AppMethodBeat.o(118192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.r
 * JD-Core Version:    0.7.0.1
 */