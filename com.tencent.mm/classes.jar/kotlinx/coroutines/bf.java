package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class bf<J extends bc>
  extends t
  implements ap, ay
{
  public final J CIm;
  
  public bf(J paramJ)
  {
    this.CIm = paramJ;
  }
  
  public final void dispose()
  {
    Object localObject1 = this.CIm;
    if (localObject1 == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
    localObject1 = (bg)localObject1;
    j.q(this, "node");
    Object localObject2;
    do
    {
      localObject2 = ((bg)localObject1).epR();
      if (!(localObject2 instanceof bf)) {
        break;
      }
    } while ((localObject2 == this) && (!bg.CHi.compareAndSet(localObject1, localObject2, bh.epY())));
    while ((!(localObject2 instanceof ay)) || (((ay)localObject2).epJ() == null)) {
      return;
    }
    aQx();
  }
  
  public final bk epJ()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bf
 * JD-Core Version:    0.7.0.1
 */