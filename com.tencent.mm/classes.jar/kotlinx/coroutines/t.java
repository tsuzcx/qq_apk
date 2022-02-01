package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class t
  extends ca<ce>
  implements s
{
  public final u abwm;
  
  public t(ce paramce, u paramu)
  {
    super((by)paramce);
    AppMethodBeat.i(118196);
    this.abwm = paramu;
    AppMethodBeat.o(118196);
  }
  
  public final boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    boolean bool = ((ce)this.Gib).B(paramThrowable);
    AppMethodBeat.o(118194);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118195);
    String str = "ChildHandle[" + this.abwm + ']';
    AppMethodBeat.o(118195);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.abwm.a((cm)this.Gib);
    AppMethodBeat.o(118192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.t
 * JD-Core Version:    0.7.0.1
 */