package com.tencent.mm.sdk.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.j;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/sdk/observer/MvvmObserverOwner$LifecycleBoundObserver$onChange$1$2", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvvmObserverOwner$LifecycleBoundObserver$onChange$1$2
  implements j
{
  MvvmObserverOwner$LifecycleBoundObserver$onChange$1$2(MvvmObserverOwner<T, E>.LifecycleBoundObserver paramMvvmObserverOwner, List<? extends E> paramList, MvvmObserverOwner<T, E> paramMvvmObserverOwner1) {}
  
  public final String getKey()
  {
    AppMethodBeat.i(369595);
    String str = this.this$1.getLogTag();
    AppMethodBeat.o(369595);
    return str;
  }
  
  public final boolean isLogging()
  {
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(369592);
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
    AppMethodBeat.o(369592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.MvvmObserverOwner.LifecycleBoundObserver.onChange.1.2
 * JD-Core Version:    0.7.0.1
 */