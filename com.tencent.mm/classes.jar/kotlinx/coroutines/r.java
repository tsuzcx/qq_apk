package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.CancellationException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class r
  extends bt<bv>
  implements q
{
  public final s NHH;
  
  public r(bv parambv, s params)
  {
    super((br)parambv);
    AppMethodBeat.i(118196);
    this.NHH = params;
    AppMethodBeat.o(118196);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118195);
    String str = "ChildHandle[" + this.NHH + ']';
    AppMethodBeat.o(118195);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.NHH.a((cd)this.NIO);
    AppMethodBeat.o(118192);
  }
  
  public final boolean z(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    bv localbv = (bv)this.NIO;
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    if (localbv.fO(paramThrowable))
    {
      AppMethodBeat.o(118194);
      return true;
    }
    AppMethodBeat.o(118194);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.r
 * JD-Core Version:    0.7.0.1
 */