package com.tencent.mm.sdk.observer;

import TK;;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/observer/MvvmTypeObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "E", "K", "Lcom/tencent/mm/sdk/observer/IMvvmTypeObserverOwner;", "()V", "ownerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sdk/observer/MvvmTypeObserverOwner$TypeObserverOwner;", "Lkotlin/collections/HashMap;", "getOwnerMap", "()Ljava/util/HashMap;", "getLogTag", "", "hasObserver", "", "key", "(Ljava/lang/Object;)Z", "notify", "", "event", "notifyAll", "(Ljava/lang/Object;Ljava/lang/Object;Z)V", "eventList", "", "(Ljava/lang/Object;Ljava/util/List;Z)V", "(Ljava/lang/Object;)V", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "threadTag", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "onRemoveObserver", "type", "(Ljava/lang/Object;Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "removeObserver", "reset", "TypeObserverOwner", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MvvmTypeObserverOwner<T extends IMvvmObserver<E>, E, K>
  implements IMvvmTypeObserverOwner<T, E, K>
{
  private final HashMap<K, MvvmTypeObserverOwner<T, E, K>.TypeObserverOwner> ownerMap = new HashMap();
  
  public abstract String getLogTag();
  
  public final HashMap<K, MvvmTypeObserverOwner<T, E, K>.TypeObserverOwner> getOwnerMap()
  {
    return this.ownerMap;
  }
  
  public boolean hasObserver(K paramK)
  {
    paramK = (TypeObserverOwner)this.ownerMap.get(paramK);
    if (paramK == null) {
      return false;
    }
    return paramK.hasObserver();
  }
  
  public void notify(K paramK, E paramE, boolean paramBoolean)
  {
    notify(paramK, p.listOf(paramE), paramBoolean);
  }
  
  public void notify(K paramK, List<? extends E> paramList, boolean paramBoolean)
  {
    s.u(paramList, "eventList");
    try
    {
      paramK = (TypeObserverOwner)this.ownerMap.get(paramK);
      if (paramK != null) {
        paramK.notify(paramList);
      }
      if (paramBoolean) {
        notifyAll(paramList);
      }
      return;
    }
    catch (Exception paramK)
    {
      Log.printErrStackTrace(getLogTag(), (Throwable)paramK, "doNotify", new Object[0]);
    }
  }
  
  public void notifyAll(E paramE)
  {
    notifyAll(p.listOf(paramE));
  }
  
  public void notifyAll(List<? extends E> paramList)
  {
    s.u(paramList, "eventList");
    try
    {
      if (!((Collection)paramList).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          TypeObserverOwner localTypeObserverOwner = (TypeObserverOwner)this.ownerMap.get(getAllKey());
          if (localTypeObserverOwner != null) {
            localTypeObserverOwner.notify(paramList);
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace(getLogTag(), (Throwable)paramList, "doNotify", new Object[0]);
    }
  }
  
  public void observe(q paramq, T paramT)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramT, "observer");
    observe(getAllKey(), paramq, paramT);
  }
  
  public void observe(q paramq, String paramString, T paramT)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramString, "threadTag");
    s.u(paramT, "observer");
    observe(getAllKey(), paramq, paramString, paramT);
  }
  
  public void observe(K paramK, q paramq, T paramT)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramT, "observer");
    for (;;)
    {
      Object localObject;
      synchronized (this.ownerMap)
      {
        Map localMap = (Map)getOwnerMap();
        localObject = localMap.get(paramK);
        if (localObject == null)
        {
          localObject = new TypeObserverOwner(paramK);
          localMap.put(paramK, localObject);
          paramK = (TK)localObject;
          ((TypeObserverOwner)paramK).observe(paramq, paramT);
          paramK = ah.aiuX;
          return;
        }
      }
      paramK = (TK)localObject;
    }
  }
  
  public void observe(K paramK, q paramq, String paramString, T paramT)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramString, "threadTag");
    s.u(paramT, "observer");
    for (;;)
    {
      Object localObject;
      synchronized (this.ownerMap)
      {
        Map localMap = (Map)getOwnerMap();
        localObject = localMap.get(paramK);
        if (localObject == null)
        {
          localObject = new TypeObserverOwner(paramK);
          localMap.put(paramK, localObject);
          paramK = (TK)localObject;
          ((TypeObserverOwner)paramK).observe(paramq, paramString, paramT);
          paramK = ah.aiuX;
          return;
        }
      }
      paramK = (TK)localObject;
    }
  }
  
  protected void onRemoveObserver(K paramK, T paramT)
  {
    s.u(paramT, "observer");
  }
  
  public void removeObserver(K paramK, T paramT)
  {
    s.u(paramT, "observer");
    synchronized (this.ownerMap)
    {
      TypeObserverOwner localTypeObserverOwner = (TypeObserverOwner)getOwnerMap().get(paramK);
      if (localTypeObserverOwner != null)
      {
        localTypeObserverOwner.removeObserver(paramT);
        if (!localTypeObserverOwner.hasObserver())
        {
          getOwnerMap().remove(paramK);
          Log.d(getLogTag(), s.X("owner remove key:", paramK));
        }
        paramK = ah.aiuX;
      }
      return;
    }
  }
  
  public final void reset()
  {
    synchronized (this.ownerMap)
    {
      getOwnerMap().clear();
      ah localah = ah.aiuX;
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/observer/MvvmTypeObserverOwner$TypeObserverOwner;", "Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;", "type", "(Lcom/tencent/mm/sdk/observer/MvvmTypeObserverOwner;Ljava/lang/Object;)V", "getType", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLogTag", "", "removeObserver", "", "observer", "(Lcom/tencent/mm/sdk/observer/IMvvmObserver;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class TypeObserverOwner
    extends MvvmObserverOwner<T, E>
  {
    private final K type;
    
    public TypeObserverOwner()
    {
      AppMethodBeat.i(243271);
      Object localObject;
      this.type = localObject;
      AppMethodBeat.o(243271);
    }
    
    public final String getLogTag()
    {
      AppMethodBeat.i(243277);
      String str = MvvmTypeObserverOwner.this.getLogTag();
      AppMethodBeat.o(243277);
      return str;
    }
    
    public final K getType()
    {
      return this.type;
    }
    
    public final void removeObserver(T paramT)
    {
      AppMethodBeat.i(243283);
      s.u(paramT, "observer");
      super.removeObserver(paramT);
      MvvmTypeObserverOwner.this.onRemoveObserver(this.type, paramT);
      AppMethodBeat.o(243283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.MvvmTypeObserverOwner
 * JD-Core Version:    0.7.0.1
 */