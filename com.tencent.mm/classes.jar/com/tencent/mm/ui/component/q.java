package com.tencent.mm.ui.component;

import androidx.lifecycle.af;
import androidx.lifecycle.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UicViewModelStore;", "Landroidx/lifecycle/ViewModelStore;", "isEnableOnCleared", "", "(Z)V", "isCleared", "()Z", "setCleared", "setEnableOnCleared", "lock", "", "getLock", "()Ljava/lang/Object;", "map", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/ViewModel;", "Lkotlin/collections/HashMap;", "executeOnCleared", "", "isExecuteOnCleared", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "vm", "printMap", "toString", "SynchronizedMap", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends aj
{
  boolean aeZX;
  boolean aeZY;
  final Object lock;
  private HashMap<String, af> map;
  
  public q(boolean paramBoolean)
  {
    AppMethodBeat.i(250371);
    this.aeZX = paramBoolean;
    this.lock = new Object();
    Field localField = aj.class.getDeclaredField("bIx");
    localField.setAccessible(true);
    this.map = ((HashMap)new a(this));
    localField.set(this, this.map);
    AppMethodBeat.o(250371);
  }
  
  public final void aT(b<? super af, Boolean> paramb)
  {
    AppMethodBeat.i(250408);
    s.u(paramb, "isExecuteOnCleared");
    HashMap localHashMap1 = this.map;
    if (localHashMap1 != null)
    {
      HashMap localHashMap2;
      HashMap localHashMap3;
      synchronized (this.lock)
      {
        this.aeZX = true;
        localHashMap2 = new HashMap((Map)localHashMap1);
        localHashMap3 = new HashMap();
        Object localObject2 = localHashMap1.entrySet();
        s.s(localObject2, "it.entries");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          Object localObject4 = ((Map.Entry)localObject3).getValue();
          s.s(localObject4, "entry.value");
          if (((Boolean)paramb.invoke(localObject4)).booleanValue())
          {
            localObject4 = (Map)localHashMap3;
            Object localObject5 = ((Map.Entry)localObject3).getKey();
            s.s(localObject5, "entry.key");
            localObject3 = ((Map.Entry)localObject3).getValue();
            s.s(localObject3, "entry.value");
            ((Map)localObject4).put(localObject5, localObject3);
          }
        }
      }
      localHashMap1.clear();
      localHashMap1.putAll((Map)localHashMap3);
      clear();
      localHashMap1.putAll((Map)localHashMap2);
      paramb = ah.aiuX;
      AppMethodBeat.o(250408);
      return;
    }
    AppMethodBeat.o(250408);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250412);
    Object localObject = this.map;
    if (localObject == null)
    {
      AppMethodBeat.o(250412);
      return "null";
    }
    localObject = ((HashMap)localObject).toString();
    if (localObject == null)
    {
      AppMethodBeat.o(250412);
      return "null";
    }
    AppMethodBeat.o(250412);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UicViewModelStore$SynchronizedMap;", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/ViewModel;", "Lkotlin/collections/HashMap;", "store", "Lcom/tencent/mm/ui/component/UicViewModelStore;", "(Lcom/tencent/mm/ui/component/UicViewModelStore;)V", "empty", "getEmpty", "()Ljava/util/HashMap;", "getStore", "()Lcom/tencent/mm/ui/component/UicViewModelStore;", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "get", "key", "put", "value", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends HashMap<String, af>
  {
    private final q aeZZ;
    private final HashMap<String, af> afaa;
    
    public a(q paramq)
    {
      AppMethodBeat.i(250304);
      this.aeZZ = paramq;
      this.afaa = new HashMap(0);
      AppMethodBeat.o(250304);
    }
    
    private af aN(String paramString)
    {
      AppMethodBeat.i(250315);
      s.u(paramString, "key");
      synchronized (this.aeZZ.lock)
      {
        paramString = (af)super.get(paramString);
        AppMethodBeat.o(250315);
        return paramString;
      }
    }
    
    private af b(String paramString, af paramaf)
    {
      AppMethodBeat.i(250319);
      s.u(paramString, "key");
      s.u(paramaf, "value");
      synchronized (this.aeZZ.lock)
      {
        paramString = (af)super.put(paramString, paramaf);
        AppMethodBeat.o(250319);
        return paramString;
      }
    }
    
    private Collection<af> qJ()
    {
      AppMethodBeat.i(250311);
      synchronized (this.aeZZ.lock)
      {
        if (this.aeZZ.aeZX)
        {
          localCollection = super.values();
          s.s(localCollection, "synchronized(store.lock)…alues else empty.values }");
          AppMethodBeat.o(250311);
          return localCollection;
        }
        Collection localCollection = this.afaa.values();
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(250323);
      synchronized (this.aeZZ.lock)
      {
        if (this.aeZZ.aeZX)
        {
          super.clear();
          this.aeZZ.aeZY = true;
        }
        ah localah = ah.aiuX;
        AppMethodBeat.o(250323);
        return;
      }
    }
    
    public final Collection<af> values()
    {
      AppMethodBeat.i(250332);
      Collection localCollection = qJ();
      AppMethodBeat.o(250332);
      return localCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.q
 * JD-Core Version:    0.7.0.1
 */