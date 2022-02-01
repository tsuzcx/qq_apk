package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/ChildHandle;", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/ChildJob;)V", "parent", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "childCancelled", "", "cause", "", "invoke", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends cd
  implements v
{
  public final x ajvu;
  
  public w(x paramx)
  {
    this.ajvu = paramx;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118192);
    this.ajvu.a((cq)kCx());
    AppMethodBeat.o(118192);
  }
  
  public final boolean Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(118194);
    boolean bool = kCx().Q(paramThrowable);
    AppMethodBeat.o(118194);
    return bool;
  }
  
  public final cb kBL()
  {
    AppMethodBeat.i(188773);
    cb localcb = (cb)kCx();
    AppMethodBeat.o(188773);
    return localcb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.w
 * JD-Core Version:    0.7.0.1
 */