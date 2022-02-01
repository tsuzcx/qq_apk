package com.tencent.mm.sdk.observer;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/observer/IMvvmTypeObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "E", "K", "", "getAllKey", "()Ljava/lang/Object;", "hasObserver", "", "key", "(Ljava/lang/Object;)Z", "notify", "", "event", "notifyAll", "(Ljava/lang/Object;Ljava/lang/Object;Z)V", "eventList", "", "(Ljava/lang/Object;Ljava/util/List;Z)V", "(Ljava/lang/Object;)V", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "threadTag", "", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "removeObserver", "(Ljava/lang/Object;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IMvvmTypeObserverOwner<T extends IMvvmObserver<E>, E, K>
{
  public abstract K getAllKey();
  
  public abstract boolean hasObserver(K paramK);
  
  public abstract void notify(K paramK, E paramE, boolean paramBoolean);
  
  public abstract void notify(K paramK, List<? extends E> paramList, boolean paramBoolean);
  
  public abstract void notifyAll(E paramE);
  
  public abstract void notifyAll(List<? extends E> paramList);
  
  public abstract void observe(q paramq, T paramT);
  
  public abstract void observe(q paramq, String paramString, T paramT);
  
  public abstract void observe(K paramK, q paramq, T paramT);
  
  public abstract void observe(K paramK, q paramq, String paramString, T paramT);
  
  public abstract void removeObserver(K paramK, T paramT);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class DefaultImpls
  {
    public static <T extends IMvvmObserver<E>, E, K> void notify(IMvvmTypeObserverOwner<T, E, K> paramIMvvmTypeObserverOwner, K paramK, E paramE, boolean paramBoolean)
    {
      AppMethodBeat.i(243282);
      s.u(paramIMvvmTypeObserverOwner, "this");
      AppMethodBeat.o(243282);
    }
    
    public static <T extends IMvvmObserver<E>, E, K> void notify(IMvvmTypeObserverOwner<T, E, K> paramIMvvmTypeObserverOwner, K paramK, List<? extends E> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(243299);
      s.u(paramIMvvmTypeObserverOwner, "this");
      s.u(paramList, "eventList");
      AppMethodBeat.o(243299);
    }
    
    public static <T extends IMvvmObserver<E>, E, K> void notifyAll(IMvvmTypeObserverOwner<T, E, K> paramIMvvmTypeObserverOwner, E paramE)
    {
      AppMethodBeat.i(243310);
      s.u(paramIMvvmTypeObserverOwner, "this");
      AppMethodBeat.o(243310);
    }
    
    public static <T extends IMvvmObserver<E>, E, K> void notifyAll(IMvvmTypeObserverOwner<T, E, K> paramIMvvmTypeObserverOwner, List<? extends E> paramList)
    {
      AppMethodBeat.i(243313);
      s.u(paramIMvvmTypeObserverOwner, "this");
      s.u(paramList, "eventList");
      AppMethodBeat.o(243313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.IMvvmTypeObserverOwner
 * JD-Core Version:    0.7.0.1
 */