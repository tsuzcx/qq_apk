package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"})
public class bx
  extends ca
  implements u
{
  private final boolean TUR;
  
  public bx(bu parambu)
  {
    super(true);
    AppMethodBeat.i(192497);
    b(parambu);
    Object localObject = (q)this._parentHandle;
    parambu = (bu)localObject;
    if (!(localObject instanceof r)) {
      parambu = null;
    }
    parambu = (r)parambu;
    boolean bool;
    if (parambu != null)
    {
      localObject = (ca)parambu.TUQ;
      parambu = (bu)localObject;
      if (localObject != null) {}
    }
    else
    {
      bool = false;
    }
    for (;;)
    {
      this.TUR = bool;
      AppMethodBeat.o(192497);
      return;
      do
      {
        if (parambu.hNl())
        {
          bool = true;
          break;
        }
        localObject = (q)parambu._parentHandle;
        parambu = (bu)localObject;
        if (!(localObject instanceof r)) {
          parambu = null;
        }
        parambu = (r)parambu;
        if (parambu == null) {
          break label124;
        }
        localObject = (ca)parambu.TUQ;
        parambu = (bu)localObject;
      } while (localObject != null);
      label124:
      bool = false;
    }
  }
  
  public final boolean hNk()
  {
    return true;
  }
  
  public final boolean hNl()
  {
    return this.TUR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bx
 * JD-Core Version:    0.7.0.1
 */