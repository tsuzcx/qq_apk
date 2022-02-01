package kotlinx.coroutines;

import d.l;
import d.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class br<J extends bo>
  extends x
  implements az, bj
{
  public final J LRS;
  
  public br(J paramJ)
  {
    this.LRS = paramJ;
  }
  
  public final void dispose()
  {
    Object localObject1 = this.LRS;
    if (localObject1 == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
    localObject1 = (bs)localObject1;
    Object localObject2;
    do
    {
      localObject2 = ((bs)localObject1).gee();
      if (!(localObject2 instanceof br)) {
        break;
      }
    } while ((localObject2 == this) && (!bs.LQI.compareAndSet(localObject1, localObject2, bt.gel())));
    while ((!(localObject2 instanceof bj)) || (((bj)localObject2).gdQ() == null)) {
      return;
    }
    bzN();
  }
  
  public final bx gdQ()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.br
 * JD-Core Version:    0.7.0.1
 */