package com.tencent.mm.sdk.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/observer/ITypeLifecycleObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/ILifecycleObserver;", "E", "K", "", "getAllKey", "()Ljava/lang/Object;", "hasObserver", "", "key", "(Ljava/lang/Object;)Z", "notify", "", "event", "notifyAll", "(Ljava/lang/Object;Ljava/lang/Object;Z)V", "eventList", "", "(Ljava/lang/Object;Ljava/util/List;Z)V", "(Ljava/lang/Object;)V", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "threadTag", "", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "removeObserver", "(Ljava/lang/Object;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "wechat-sdk_release"})
public abstract interface ITypeLifecycleObserverOwner<T extends ILifecycleObserver<E>, E, K>
{
  public abstract K getAllKey();
  
  public abstract boolean hasObserver(K paramK);
  
  public abstract void notify(K paramK, E paramE, boolean paramBoolean);
  
  public abstract void notify(K paramK, List<? extends E> paramList, boolean paramBoolean);
  
  public abstract void notifyAll(E paramE);
  
  public abstract void notifyAll(List<? extends E> paramList);
  
  public abstract void observe(androidx.lifecycle.l paraml, T paramT);
  
  public abstract void observe(androidx.lifecycle.l paraml, String paramString, T paramT);
  
  public abstract void observe(K paramK, androidx.lifecycle.l paraml, T paramT);
  
  public abstract void observe(K paramK, androidx.lifecycle.l paraml, String paramString, T paramT);
  
  public abstract void removeObserver(K paramK, T paramT);
  
  @kotlin.l(iBK={1, 1, 16})
  public static final class DefaultImpls
  {
    public static <T extends ILifecycleObserver<E>, E, K> void notify(ITypeLifecycleObserverOwner<T, E, K> paramITypeLifecycleObserverOwner, K paramK, E paramE, boolean paramBoolean) {}
    
    public static <T extends ILifecycleObserver<E>, E, K> void notify(ITypeLifecycleObserverOwner<T, E, K> paramITypeLifecycleObserverOwner, K paramK, List<? extends E> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(188826);
      p.k(paramList, "eventList");
      AppMethodBeat.o(188826);
    }
    
    public static <T extends ILifecycleObserver<E>, E, K> void notifyAll(ITypeLifecycleObserverOwner<T, E, K> paramITypeLifecycleObserverOwner, E paramE) {}
    
    public static <T extends ILifecycleObserver<E>, E, K> void notifyAll(ITypeLifecycleObserverOwner<T, E, K> paramITypeLifecycleObserverOwner, List<? extends E> paramList)
    {
      AppMethodBeat.i(188828);
      p.k(paramList, "eventList");
      AppMethodBeat.o(188828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.ITypeLifecycleObserverOwner
 * JD-Core Version:    0.7.0.1
 */