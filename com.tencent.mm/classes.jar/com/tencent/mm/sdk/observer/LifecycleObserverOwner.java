package com.tencent.mm.sdk.observer;

import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner;", "T", "Lcom/tencent/mm/sdk/observer/ILifecycleObserver;", "E", "Lcom/tencent/mm/sdk/observer/ILifecycleObserverOwner;", "()V", "observerMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner$LifecycleBoundObserver;", "Lkotlin/collections/HashMap;", "createLifecycleBoundObserver", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;Ljava/lang/String;)Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner$LifecycleBoundObserver;", "getDefaultThreadTag", "getLogTag", "hasObserver", "", "notify", "", "event", "(Ljava/lang/Object;)V", "eventList", "", "observe", "lifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "removeObserver", "(Lcom/tencent/mm/sdk/observer/ILifecycleObserver;)V", "Companion", "LifecycleBoundObserver", "wechat-sdk_release"})
public abstract class LifecycleObserverOwner<T extends ILifecycleObserver<E>, E>
  implements ILifecycleObserverOwner<T, E>
{
  public static final LifecycleObserverOwner.Companion Companion = new LifecycleObserverOwner.Companion(null);
  public static final String MainThread = "%MainThread%";
  private final HashMap<Integer, WeakReference<LifecycleObserverOwner<T, E>.LifecycleBoundObserver>> observerMap = new HashMap();
  
  public LifecycleObserverOwner<T, E>.LifecycleBoundObserver createLifecycleBoundObserver(androidx.lifecycle.l paraml, T paramT, String paramString)
  {
    p.k(paraml, "owner");
    p.k(paramT, "observer");
    return new LifecycleObserverOwner.LifecycleBoundObserver(this, paraml, paramT, paramString);
  }
  
  public abstract String getDefaultThreadTag();
  
  public abstract String getLogTag();
  
  public boolean hasObserver()
  {
    synchronized (this.observerMap)
    {
      boolean bool = ((Map)this.observerMap).isEmpty();
      if (!bool)
      {
        bool = true;
        return bool;
      }
      bool = false;
    }
  }
  
  public void notify(E paramE)
  {
    notify(j.listOf(paramE));
  }
  
  public void notify(List<? extends E> paramList)
  {
    p.k(paramList, "eventList");
    for (;;)
    {
      try
      {
        if (!((Map)this.observerMap).isEmpty())
        {
          i = 1;
          if (i != 0)
          {
            if (((Collection)paramList).isEmpty()) {
              break label140;
            }
            i = 1;
            if (i != 0)
            {
              localObject2 = (Map)this.observerMap;
              localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
              localObject2 = ((Map)localObject2).entrySet().iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              ((Collection)localObject1).add((Map.Entry)((Iterator)localObject2).next());
              continue;
            }
          }
          return;
        }
      }
      catch (Exception paramList)
      {
        Log.printErrStackTrace(getLogTag(), (Throwable)paramList, "doNotify", new Object[0]);
      }
      i = 0;
      continue;
      label140:
      i = 0;
    }
    Object localObject1 = (List)localObject1;
    Object localObject2 = ((Iterable)localObject1).iterator();
    int i = 0;
    for (;;)
    {
      Map.Entry localEntry;
      LifecycleObserverOwner localLifecycleObserverOwner;
      if (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        ??? = (LifecycleObserverOwner.LifecycleBoundObserver)((WeakReference)localEntry.getValue()).get();
        if (??? != null) {
          ((LifecycleObserverOwner.LifecycleBoundObserver)???).onChange(paramList);
        } else {
          localLifecycleObserverOwner = (LifecycleObserverOwner)this;
        }
      }
      else
      {
        synchronized (localLifecycleObserverOwner.observerMap)
        {
          Log.i(localLifecycleObserverOwner.getLogTag(), "doNotify removeObserverKey:" + ((Number)localEntry.getKey()).intValue());
          localLifecycleObserverOwner.observerMap.remove(localEntry.getKey());
          i += 1;
        }
      }
    }
  }
  
  public void observe(androidx.lifecycle.l paraml, T paramT)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramT, "observer");
    synchronized (this.observerMap)
    {
      Object localObject = (WeakReference)this.observerMap.get(Integer.valueOf(paramT.hashCode()));
      if (localObject != null)
      {
        localObject = (LifecycleObserverOwner.LifecycleBoundObserver)((WeakReference)localObject).get();
        if (localObject != null)
        {
          localObject = ((LifecycleObserverOwner.LifecycleBoundObserver)localObject).getOwner();
          if (localObject != null)
          {
            if ((p.h(localObject, paraml) ^ true)) {}
            while (localObject != null)
            {
              Log.e(getLogTag(), "Cannot add the same observer with different lifecycles");
              return;
              localObject = null;
            }
          }
        }
      }
      paraml = createLifecycleBoundObserver$default(this, paraml, paramT, null, 4, null);
      paraml.attachObserver();
      this.observerMap.put(Integer.valueOf(paramT.hashCode()), new WeakReference(paraml));
      Log.d(getLogTag(), "observe: " + paramT.hashCode());
      paraml = x.aazN;
      return;
    }
  }
  
  public void observe(androidx.lifecycle.l paraml, String paramString, T paramT)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramString, "threadTag");
    p.k(paramT, "observer");
    synchronized (this.observerMap)
    {
      Object localObject = (WeakReference)this.observerMap.get(Integer.valueOf(paramT.hashCode()));
      if (localObject != null)
      {
        localObject = (LifecycleObserverOwner.LifecycleBoundObserver)((WeakReference)localObject).get();
        if (localObject != null)
        {
          localObject = ((LifecycleObserverOwner.LifecycleBoundObserver)localObject).getOwner();
          if (localObject != null)
          {
            if ((p.h(localObject, paraml) ^ true)) {}
            while (localObject != null)
            {
              Log.e(getLogTag(), "Cannot add the same observer with different lifecycles");
              return;
              localObject = null;
            }
          }
        }
      }
      paraml = createLifecycleBoundObserver(paraml, paramT, paramString);
      paraml.attachObserver();
      this.observerMap.put(Integer.valueOf(paramT.hashCode()), new WeakReference(paraml));
      Log.d(getLogTag(), "observe: " + paramT.hashCode());
      paraml = x.aazN;
      return;
    }
  }
  
  public void removeObserver(T paramT)
  {
    p.k(paramT, "observer");
    synchronized (this.observerMap)
    {
      Object localObject = (WeakReference)this.observerMap.remove(Integer.valueOf(paramT.hashCode()));
      if (localObject != null)
      {
        localObject = (LifecycleObserverOwner.LifecycleBoundObserver)((WeakReference)localObject).get();
        if (localObject != null) {
          ((LifecycleObserverOwner.LifecycleBoundObserver)localObject).detachObserver();
        }
        Log.d(getLogTag(), "removeObserver: " + paramT.hashCode());
        paramT = x.aazN;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.observer.LifecycleObserverOwner
 * JD-Core Version:    0.7.0.1
 */