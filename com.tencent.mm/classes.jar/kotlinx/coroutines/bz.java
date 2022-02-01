package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class bz<J extends bu>
  extends z
  implements bc, bp
{
  public final J TUQ;
  
  public bz(J paramJ)
  {
    this.TUQ = paramJ;
  }
  
  public final void dispose()
  {
    Object localObject1 = this.TUQ;
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
    localObject1 = (ca)localObject1;
    Object localObject2;
    do
    {
      localObject2 = ((ca)localObject1).hNm();
      if (!(localObject2 instanceof bz)) {
        break;
      }
    } while ((localObject2 == this) && (!ca.TTD.compareAndSet(localObject1, localObject2, cb.hNt())));
    while ((!(localObject2 instanceof bp)) || (((bp)localObject2).hMX() == null)) {
      return;
    }
    remove();
  }
  
  public final cf hMX()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bz
 * JD-Core Version:    0.7.0.1
 */