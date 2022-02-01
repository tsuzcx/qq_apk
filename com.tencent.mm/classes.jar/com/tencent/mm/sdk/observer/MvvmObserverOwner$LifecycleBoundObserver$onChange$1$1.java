package com.tencent.mm.sdk.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "E"}, k=3, mv={1, 5, 1}, xi=48)
final class MvvmObserverOwner$LifecycleBoundObserver$onChange$1$1
  extends u
  implements a<ah>
{
  MvvmObserverOwner$LifecycleBoundObserver$onChange$1$1(MvvmObserverOwner<T, E>.LifecycleBoundObserver paramMvvmObserverOwner, List<? extends E> paramList)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AppMethodBeat.i(369593);
    if (MvvmObserverOwner.LifecycleBoundObserver.access$shouldBeActive(this.this$0))
    {
      Object localObject1 = (Iterable)this.$eventList;
      MvvmObserverOwner.LifecycleBoundObserver localLifecycleBoundObserver = this.this$0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localLifecycleBoundObserver.getObserver().onChanged(localObject2);
      }
    }
    AppMethodBeat.o(369593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.MvvmObserverOwner.LifecycleBoundObserver.onChange.1.1
 * JD-Core Version:    0.7.0.1
 */