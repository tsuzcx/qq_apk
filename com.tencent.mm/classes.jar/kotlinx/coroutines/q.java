package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.CancellationException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class q
  extends bq<bs>
  implements p
{
  public final r LQM;
  
  public q(bs parambs, r paramr)
  {
    super((bo)parambs);
    AppMethodBeat.i(118196);
    this.LQM = paramr;
    AppMethodBeat.o(118196);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118195);
    String str = "ChildHandle[" + this.LQM + ']';
    AppMethodBeat.o(118195);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.LQM.a((ca)this.LRS);
    AppMethodBeat.o(118192);
  }
  
  public final boolean y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    bs localbs = (bs)this.LRS;
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    if (localbs.fL(paramThrowable))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    AppMethodBeat.o(118194);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.q
 * JD-Core Version:    0.7.0.1
 */