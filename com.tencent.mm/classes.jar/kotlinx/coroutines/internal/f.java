package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "", "cleanPrev", "()V", "", "markAsClosed", "()Z", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "value", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "getLeftmostAliveNode", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "leftmostAliveNode", "getNext", "next", "", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getPrev", "getRemoved", "removed", "getRightmostAliveNode", "rightmostAliveNode", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f<N extends f<N>>
{
  public f(N paramN)
  {
    this._prev = paramN;
  }
  
  private N kDQ()
  {
    Object localObject = this._next;
    if (localObject == e.kDP()) {
      return null;
    }
    return (f)localObject;
  }
  
  private final N kDT()
  {
    for (f localf = (f)this._prev; (localf != null) && (localf.kDS()); localf = (f)localf._prev) {}
    return localf;
  }
  
  private final N kDU()
  {
    if (au.ASSERTIONS_ENABLED)
    {
      if (!kDR()) {}
      for (int i = 1; i == 0; i = 0) {
        throw new AssertionError();
      }
    }
    f localf = kDQ();
    s.checkNotNull(localf);
    while (localf.kDS())
    {
      localf = localf.kDQ();
      s.checkNotNull(localf);
    }
    return localf;
  }
  
  public final boolean a(N paramN)
  {
    return ajAk.compareAndSet(this, null, paramN);
  }
  
  public final boolean kDR()
  {
    return kDQ() == null;
  }
  
  public abstract boolean kDS();
  
  public final void remove()
  {
    if ((au.ASSERTIONS_ENABLED) && (!kDS())) {
      throw new AssertionError();
    }
    if (au.ASSERTIONS_ENABLED)
    {
      if (!kDR()) {}
      for (int i = 1; i == 0; i = 0) {
        throw new AssertionError();
      }
    }
    f localf1;
    f localf2;
    do
    {
      localf1 = kDT();
      localf2 = kDU();
      localf2._prev = localf1;
      if (localf1 != null) {
        localf1._next = localf2;
      }
    } while ((localf2.kDS()) || ((localf1 != null) && (localf1.kDS())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.f
 * JD-Core Version:    0.7.0.1
 */