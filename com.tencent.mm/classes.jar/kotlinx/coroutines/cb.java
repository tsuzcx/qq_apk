package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"})
public class cb
  extends ce
  implements w
{
  private final boolean abxu;
  
  public cb(by paramby)
  {
    super(true);
    AppMethodBeat.i(204904);
    c(paramby);
    Object localObject = iRI();
    paramby = (by)localObject;
    if (!(localObject instanceof t)) {
      paramby = null;
    }
    paramby = (t)paramby;
    boolean bool;
    if (paramby != null)
    {
      localObject = (ce)paramby.Gib;
      paramby = (by)localObject;
      if (localObject != null) {}
    }
    else
    {
      bool = false;
    }
    for (;;)
    {
      this.abxu = bool;
      AppMethodBeat.o(204904);
      return;
      do
      {
        if (paramby.iRH())
        {
          bool = true;
          break;
        }
        localObject = paramby.iRI();
        paramby = (by)localObject;
        if (!(localObject instanceof t)) {
          paramby = null;
        }
        paramby = (t)paramby;
        if (paramby == null) {
          break label118;
        }
        localObject = (ce)paramby.Gib;
        paramby = (by)localObject;
      } while (localObject != null);
      label118:
      bool = false;
    }
  }
  
  public final boolean iRG()
  {
    return true;
  }
  
  public final boolean iRH()
  {
    return this.abxu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cb
 * JD-Core Version:    0.7.0.1
 */