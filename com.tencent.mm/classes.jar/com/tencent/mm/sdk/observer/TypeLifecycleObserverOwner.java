package com.tencent.mm.sdk.observer;

import TK;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/observer/TypeLifecycleObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/ILifecycleObserver;", "E", "K", "Lcom/tencent/mm/sdk/observer/ITypeLifecycleObserverOwner;", "()V", "ownerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sdk/observer/TypeLifecycleObserverOwner$TypeObserverOwner;", "Lkotlin/collections/HashMap;", "getOwnerMap", "()Ljava/util/HashMap;", "getDefaultThreadTag", "", "getLogTag", "hasObserver", "", "key", "(Ljava/lang/Object;)Z", "notify", "", "event", "notifyAll", "(Ljava/lang/Object;Ljava/lang/Object;Z)V", "eventList", "", "(Ljava/lang/Object;Ljava/util/List;Z)V", "(Ljava/lang/Object;)V", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "threadTag", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "onRemoveObserver", "type", "(Ljava/lang/Object;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "removeObserver", "reset", "TypeObserverOwner", "wechat-sdk_release"})
public abstract class TypeLifecycleObserverOwner<T extends ILifecycleObserver<E>, E, K>
  implements ITypeLifecycleObserverOwner<T, E, K>
{
  private final HashMap<K, TypeLifecycleObserverOwner<T, E, K>.TypeObserverOwner> ownerMap = new HashMap();
  
  public abstract String getDefaultThreadTag();
  
  public abstract String getLogTag();
  
  public final HashMap<K, TypeLifecycleObserverOwner<T, E, K>.TypeObserverOwner> getOwnerMap()
  {
    return this.ownerMap;
  }
  
  public boolean hasObserver(K paramK)
  {
    paramK = (TypeObserverOwner)this.ownerMap.get(paramK);
    if (paramK != null) {
      return paramK.hasObserver();
    }
    return false;
  }
  
  public void notify(K paramK, E paramE, boolean paramBoolean)
  {
    notify(paramK, j.listOf(paramE), paramBoolean);
  }
  
  public void notify(K paramK, List<? extends E> paramList, boolean paramBoolean)
  {
    p.k(paramList, "eventList");
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
    notifyAll(j.listOf(paramE));
  }
  
  public void notifyAll(List<? extends E> paramList)
  {
    p.k(paramList, "eventList");
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
  
  public void observe(androidx.lifecycle.l paraml, T paramT)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramT, "observer");
    observe(getAllKey(), paraml, paramT);
  }
  
  public void observe(androidx.lifecycle.l paraml, String paramString, T paramT)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramString, "threadTag");
    p.k(paramT, "observer");
    observe(getAllKey(), paraml, paramString, paramT);
  }
  
  public void observe(K paramK, androidx.lifecycle.l paraml, T paramT)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramT, "observer");
    synchronized (this.ownerMap)
    {
      Map localMap = (Map)this.ownerMap;
      Object localObject = localMap.get(paramK);
      if (localObject == null)
      {
        localObject = new TypeObserverOwner(paramK);
        localMap.put(paramK, localObject);
        paramK = (TK)localObject;
        ((TypeObserverOwner)paramK).observe(paraml, paramT);
        paramK = x.aazN;
        return;
      }
      paramK = (TK)localObject;
    }
  }
  
  public void observe(K paramK, androidx.lifecycle.l paraml, String paramString, T paramT)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramString, "threadTag");
    p.k(paramT, "observer");
    synchronized (this.ownerMap)
    {
      Map localMap = (Map)this.ownerMap;
      Object localObject = localMap.get(paramK);
      if (localObject == null)
      {
        localObject = new TypeObserverOwner(paramK);
        localMap.put(paramK, localObject);
        paramK = (TK)localObject;
        ((TypeObserverOwner)paramK).observe(paraml, paramString, paramT);
        paramK = x.aazN;
        return;
      }
      paramK = (TK)localObject;
    }
  }
  
  protected void onRemoveObserver(K paramK, T paramT)
  {
    p.k(paramT, "observer");
  }
  
  public void removeObserver(K paramK, T paramT)
  {
    p.k(paramT, "observer");
    synchronized (this.ownerMap)
    {
      TypeObserverOwner localTypeObserverOwner = (TypeObserverOwner)this.ownerMap.get(paramK);
      if (localTypeObserverOwner != null)
      {
        localTypeObserverOwner.removeObserver(paramT);
        if (!localTypeObserverOwner.hasObserver())
        {
          this.ownerMap.remove(paramK);
          Log.d(getLogTag(), "owner remove key:".concat(String.valueOf(paramK)));
        }
        paramK = x.aazN;
      }
      return;
    }
  }
  
  public final void reset()
  {
    synchronized (this.ownerMap)
    {
      this.ownerMap.clear();
      x localx = x.aazN;
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/observer/TypeLifecycleObserverOwner$TypeObserverOwner;", "Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner;", "type", "(Lcom/tencent/mm/sdk/observer/TypeLifecycleObserverOwner;Ljava/lang/Object;)V", "getType", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDefaultThreadTag", "", "getLogTag", "removeObserver", "", "observer", "(Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "wechat-sdk_release"})
  public final class TypeObserverOwner
    extends LifecycleObserverOwner<T, E>
  {
    private final K type;
    
    public TypeObserverOwner()
    {
      Object localObject;
      this.type = localObject;
    }
    
    public final String getDefaultThreadTag()
    {
      AppMethodBeat.i(187495);
      String str = TypeLifecycleObserverOwner.this.getDefaultThreadTag();
      AppMethodBeat.o(187495);
      return str;
    }
    
    public final String getLogTag()
    {
      AppMethodBeat.i(187494);
      String str = TypeLifecycleObserverOwner.this.getLogTag();
      AppMethodBeat.o(187494);
      return str;
    }
    
    public final K getType()
    {
      return this.type;
    }
    
    public final void removeObserver(T paramT)
    {
      AppMethodBeat.i(187496);
      p.k(paramT, "observer");
      super.removeObserver(paramT);
      TypeLifecycleObserverOwner.this.onRemoveObserver(this.type, paramT);
      AppMethodBeat.o(187496);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.TypeLifecycleObserverOwner
 * JD-Core Version:    0.7.0.1
 */