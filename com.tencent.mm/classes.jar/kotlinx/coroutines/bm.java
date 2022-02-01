package kotlinx.coroutines;

import d.l;
import d.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class bm<J extends bj>
  extends u
  implements au, be
{
  public final J Kes;
  
  public bm(J paramJ)
  {
    this.Kes = paramJ;
  }
  
  public final void dispose()
  {
    Object localObject1 = this.Kes;
    if (localObject1 == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
    localObject1 = (bn)localObject1;
    Object localObject2;
    do
    {
      localObject2 = ((bn)localObject1).fLv();
      if (!(localObject2 instanceof bm)) {
        break;
      }
    } while ((localObject2 == this) && (!bn.Kdh.compareAndSet(localObject1, localObject2, bo.fLB())));
    while ((!(localObject2 instanceof be)) || (((be)localObject2).fLh() == null)) {
      return;
    }
    bsN();
  }
  
  public final bs fLh()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bm
 * JD-Core Version:    0.7.0.1
 */