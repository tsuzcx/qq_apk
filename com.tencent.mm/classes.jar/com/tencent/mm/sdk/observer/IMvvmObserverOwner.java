package com.tencent.mm.sdk.observer;

import androidx.lifecycle.q;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/observer/IMvvmObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "E", "", "hasObserver", "", "notify", "", "event", "(Ljava/lang/Object;)V", "eventList", "", "notifyAny", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "threadTag", "", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "removeObserver", "(Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "uiObserve", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IMvvmObserverOwner<T extends IMvvmObserver<E>, E>
{
  public abstract boolean hasObserver();
  
  public abstract void notify(E paramE);
  
  public abstract void notify(List<? extends E> paramList);
  
  public abstract void notifyAny(Object paramObject);
  
  public abstract void observe(q paramq, T paramT);
  
  public abstract void observe(q paramq, String paramString, T paramT);
  
  public abstract void removeObserver(T paramT);
  
  public abstract void uiObserve(q paramq, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.IMvvmObserverOwner
 * JD-Core Version:    0.7.0.1
 */