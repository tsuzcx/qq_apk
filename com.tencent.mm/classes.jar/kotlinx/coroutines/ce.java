package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class ce
  extends ci
  implements ac
{
  private final boolean ajwu;
  
  public ce(cb paramcb)
  {
    super(true);
    AppMethodBeat.i(188776);
    f(paramcb);
    paramcb = (v)this._parentHandle;
    if ((paramcb instanceof w)) {}
    boolean bool;
    for (paramcb = (w)paramcb; paramcb == null; paramcb = null)
    {
      bool = false;
      this.ajwu = bool;
      AppMethodBeat.o(188776);
      return;
    }
    label108:
    for (paramcb = paramcb.kCx();; paramcb = paramcb.kCx())
    {
      if (paramcb.kCw())
      {
        bool = true;
        break;
      }
      paramcb = (v)paramcb._parentHandle;
      if ((paramcb instanceof w)) {}
      for (paramcb = (w)paramcb;; paramcb = null)
      {
        if (paramcb != null) {
          break label108;
        }
        bool = false;
        break;
      }
    }
  }
  
  public final boolean R(Throwable paramThrowable)
  {
    AppMethodBeat.i(188799);
    boolean bool = iJ(new ae(paramThrowable));
    AppMethodBeat.o(188799);
    return bool;
  }
  
  public final boolean kBR()
  {
    return true;
  }
  
  public final boolean kCw()
  {
    return this.ajwu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ce
 * JD-Core Version:    0.7.0.1
 */