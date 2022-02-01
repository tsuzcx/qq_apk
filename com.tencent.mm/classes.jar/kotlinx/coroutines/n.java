package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.CancellationException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class n
  extends bl<bn>
  implements m
{
  public final o Kdk;
  
  public n(bn parambn, o paramo)
  {
    super((bj)parambn);
    AppMethodBeat.i(118196);
    this.Kdk = paramo;
    AppMethodBeat.o(118196);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118195);
    String str = "ChildHandle[" + this.Kdk + ']';
    AppMethodBeat.o(118195);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.Kdk.a((bv)this.Kes);
    AppMethodBeat.o(118192);
  }
  
  public final boolean x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    bn localbn = (bn)this.Kes;
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    if (localbn.fF(paramThrowable))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    AppMethodBeat.o(118194);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.n
 * JD-Core Version:    0.7.0.1
 */