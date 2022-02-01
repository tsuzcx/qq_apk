package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "job", "Lkotlinx/coroutines/JobSupport;", "getJob", "()Lkotlinx/coroutines/JobSupport;", "setJob", "(Lkotlinx/coroutines/JobSupport;)V", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ch
  extends ag
  implements bi, bw
{
  public ci ajwv;
  
  public final void dispose()
  {
    ci localci = kCx();
    Object localObject;
    do
    {
      localObject = localci.kCy();
      if (!(localObject instanceof ch)) {
        break;
      }
    } while ((localObject == this) && (!ci.ajvp.compareAndSet(localci, localObject, cj.kCE())));
    while ((!(localObject instanceof bw)) || (((bw)localObject).kCj() == null)) {
      return;
    }
    remove();
  }
  
  public final boolean isActive()
  {
    return true;
  }
  
  public final cn kCj()
  {
    return null;
  }
  
  public final ci kCx()
  {
    ci localci = this.ajwv;
    if (localci != null) {
      return localci;
    }
    s.bIx("job");
    return null;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + "[job@" + Integer.toHexString(System.identityHashCode(kCx())) + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ch
 * JD-Core Version:    0.7.0.1
 */