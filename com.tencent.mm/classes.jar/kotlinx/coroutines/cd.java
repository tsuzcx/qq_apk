package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class cd<J extends by>
  extends ab
  implements be, bt
{
  public final J Gib;
  
  public cd(J paramJ)
  {
    this.Gib = paramJ;
  }
  
  public final void dispose()
  {
    Object localObject1 = this.Gib;
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
    localObject1 = (ce)localObject1;
    Object localObject2;
    do
    {
      localObject2 = ((ce)localObject1).iRJ();
      if (!(localObject2 instanceof cd)) {
        break;
      }
    } while ((localObject2 == this) && (!ce.abwi.compareAndSet(localObject1, localObject2, cf.iRQ())));
    while ((!(localObject2 instanceof bt)) || (((bt)localObject2).iRt() == null)) {
      return;
    }
    remove();
  }
  
  public final cj iRt()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cd
 * JD-Core Version:    0.7.0.1
 */