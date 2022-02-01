package com.tencent.mm.sdk.observer;

import java.util.List;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/observer/ILifecycleObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/ILifecycleObserver;", "E", "", "hasObserver", "", "notify", "", "event", "(Ljava/lang/Object;)V", "eventList", "", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "threadTag", "", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "removeObserver", "(Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "wechat-sdk_release"})
public abstract interface ILifecycleObserverOwner<T extends ILifecycleObserver<E>, E>
{
  public abstract boolean hasObserver();
  
  public abstract void notify(E paramE);
  
  public abstract void notify(List<? extends E> paramList);
  
  public abstract void observe(androidx.lifecycle.l paraml, T paramT);
  
  public abstract void observe(androidx.lifecycle.l paraml, String paramString, T paramT);
  
  public abstract void removeObserver(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.ILifecycleObserverOwner
 * JD-Core Version:    0.7.0.1
 */