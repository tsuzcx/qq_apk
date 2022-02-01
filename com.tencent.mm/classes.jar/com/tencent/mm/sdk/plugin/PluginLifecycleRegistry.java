package com.tencent.mm.sdk.plugin;

import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/plugin/PluginLifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "()V", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/lifecycle/LifecycleObserver;", "getObserverMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setObserverMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "state", "Landroidx/lifecycle/Lifecycle$State;", "addObserver", "", "observer", "getCurrentState", "moveToCreateState", "moveToDestroyState", "removeObserver", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class PluginLifecycleRegistry
  extends j
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.PluginLifecycleRegistry";
  private ConcurrentHashMap<Integer, p> observerMap;
  private j.b state;
  
  static
  {
    AppMethodBeat.i(243233);
    Companion = new Companion(null);
    AppMethodBeat.o(243233);
  }
  
  public PluginLifecycleRegistry()
  {
    AppMethodBeat.i(243229);
    this.state = j.b.bHh;
    this.observerMap = new ConcurrentHashMap();
    AppMethodBeat.o(243229);
  }
  
  public void addObserver(p paramp)
  {
    AppMethodBeat.i(243242);
    s.u(paramp, "observer");
    ConcurrentHashMap localConcurrentHashMap = this.observerMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(Integer.valueOf(paramp.hashCode()), paramp);
    }
    AppMethodBeat.o(243242);
  }
  
  public j.b getCurrentState()
  {
    return this.state;
  }
  
  protected final ConcurrentHashMap<Integer, p> getObserverMap()
  {
    return this.observerMap;
  }
  
  public final void moveToCreateState()
  {
    AppMethodBeat.i(243250);
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToCreateState start");
    Object localObject1 = this.observerMap;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (List)localObject1)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)ab.aivy;
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        Object localObject3 = localObject2.getClass().getMethods();
        s.s(localObject3, "observer::class.java.methods");
        localObject3 = (Object[])localObject3;
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          Method localMethod = (Method)localObject3[i];
          z localz = (z)localMethod.getAnnotation(z.class);
          if ((localz != null) && (localz.Ho() == j.a.ON_CREATE)) {
            localMethod.invoke(localObject2, new Object[0]);
          }
          i += 1;
        }
      }
      localObject2 = (Map)localObject1;
      localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((p)((Map.Entry)((Iterator)localObject2).next()).getValue());
      }
    }
    this.state = j.b.bHi;
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToCreateState end");
    AppMethodBeat.o(243250);
  }
  
  public final void moveToDestroyState()
  {
    AppMethodBeat.i(243258);
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToDestroyState start");
    Object localObject1 = this.observerMap;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (List)localObject1)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)ab.aivy;
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        Object localObject3 = localObject2.getClass().getMethods();
        s.s(localObject3, "observer::class.java.methods");
        localObject3 = (Object[])localObject3;
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          Method localMethod = (Method)localObject3[i];
          z localz = (z)localMethod.getAnnotation(z.class);
          if ((localz != null) && (localz.Ho() == j.a.ON_DESTROY)) {
            localMethod.invoke(localObject2, new Object[0]);
          }
          i += 1;
        }
      }
      localObject2 = (Map)localObject1;
      localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((p)((Map.Entry)((Iterator)localObject2).next()).getValue());
      }
    }
    this.observerMap = null;
    this.state = j.b.bHg;
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToDestroyState end");
    AppMethodBeat.o(243258);
  }
  
  public void removeObserver(p paramp)
  {
    AppMethodBeat.i(243244);
    s.u(paramp, "observer");
    ConcurrentHashMap localConcurrentHashMap = this.observerMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(Integer.valueOf(paramp.hashCode()));
    }
    AppMethodBeat.o(243244);
  }
  
  protected final void setObserverMap(ConcurrentHashMap<Integer, p> paramConcurrentHashMap)
  {
    this.observerMap = paramConcurrentHashMap;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/plugin/PluginLifecycleRegistry$Companion;", "", "()V", "TAG", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.PluginLifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */