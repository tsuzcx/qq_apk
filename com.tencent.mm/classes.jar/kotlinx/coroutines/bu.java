package kotlinx.coroutines;

import d.l;
import d.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class bu<J extends br>
  extends y
  implements ba, bm
{
  public final J NIO;
  
  public bu(J paramJ)
  {
    this.NIO = paramJ;
  }
  
  public final void dispose()
  {
    Object localObject1 = this.NIO;
    if (localObject1 == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
    localObject1 = (bv)localObject1;
    Object localObject2;
    do
    {
      localObject2 = ((bv)localObject1).gvE();
      if (!(localObject2 instanceof bu)) {
        break;
      }
    } while ((localObject2 == this) && (!bv.NHD.compareAndSet(localObject1, localObject2, bw.gvL())));
    while ((!(localObject2 instanceof bm)) || (((bm)localObject2).gvq() == null)) {
      return;
    }
    remove();
  }
  
  public final ca gvq()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bu
 * JD-Core Version:    0.7.0.1
 */