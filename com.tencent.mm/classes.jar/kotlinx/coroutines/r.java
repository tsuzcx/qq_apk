package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.CancellationException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class r
  extends bt<bv>
  implements q
{
  public final s OeN;
  
  public r(bv parambv, s params)
  {
    super((br)parambv);
    AppMethodBeat.i(118196);
    this.OeN = params;
    AppMethodBeat.o(118196);
  }
  
  public final boolean A(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    bv localbv = (bv)this.OfU;
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    if (localbv.fR(paramThrowable))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    AppMethodBeat.o(118194);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118195);
    String str = "ChildHandle[" + this.OeN + ']';
    AppMethodBeat.o(118195);
    return str;
  }
  
  public final void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.OeN.a((cd)this.OfU);
    AppMethodBeat.o(118192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.r
 * JD-Core Version:    0.7.0.1
 */