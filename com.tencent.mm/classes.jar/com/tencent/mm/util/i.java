package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/RepairerLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "configMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getConfigMap", "()Ljava/util/HashMap;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setMmkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "ready", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setReady", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "readyListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/util/OnRepairerReadyListener;", "getConfig", "key", "Lcom/tencent/mm/util/ConstantsRepairer$ItemInfoKey;", "defaultValue", "getConfigInt", "", "getConfigString", "getGlobalKey", "name", "registerReadyListener", "", "listener", "saveConfig", "value", "saveGlobalKey", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final String TAG;
  public static final i agtt;
  private static AtomicBoolean agtu;
  private static LinkedList<WeakReference<h>> agtv;
  private static MultiProcessMMKV eMf;
  private static final HashMap<String, Object> mUV;
  
  static
  {
    AppMethodBeat.i(234017);
    agtt = new i();
    TAG = "MicroMsg.RepairerLogic";
    mUV = new HashMap();
    agtu = new AtomicBoolean(false);
    com.tencent.threadpool.h.ahAA.g(i..ExternalSyntheticLambda0.INSTANCE, "RepairerConfigThread");
    agtv = new LinkedList();
    AppMethodBeat.o(234017);
  }
  
  public static int a(b.a parama, int paramInt)
  {
    AppMethodBeat.i(233977);
    s.u(parama, "key");
    paramInt = ((Integer)a(parama, Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(233977);
    return paramInt;
  }
  
  public static Object a(b.a parama, Object paramObject)
  {
    AppMethodBeat.i(233973);
    s.u(parama, "key");
    s.u(paramObject, "defaultValue");
    if (mUV.containsKey(parama.name()))
    {
      parama = mUV.get(parama.name());
      if (parama == null)
      {
        AppMethodBeat.o(233973);
        return paramObject;
      }
      AppMethodBeat.o(233973);
      return parama;
    }
    Object localObject1 = eMf;
    int i;
    Object localObject2;
    if ((localObject1 != null) && (((MultiProcessMMKV)localObject1).containsKey(parama.name()) == true))
    {
      i = 1;
      localObject1 = paramObject;
      if (i != 0)
      {
        localObject2 = (String)n.a((CharSequence)parama.name(), new String[] { "_" }).get(3);
        switch (((String)localObject2).hashCode())
        {
        default: 
          localObject1 = paramObject;
        }
      }
    }
    for (;;)
    {
      ((Map)mUV).put(parama.name(), localObject1);
      AppMethodBeat.o(233973);
      return localObject1;
      i = 0;
      break;
      localObject1 = paramObject;
      if (((String)localObject2).equals("Float"))
      {
        localObject2 = eMf;
        localObject1 = paramObject;
        if (localObject2 != null)
        {
          localObject1 = Float.valueOf(((MultiProcessMMKV)localObject2).decodeFloat(parama.name(), ((Float)paramObject).floatValue()));
          continue;
          localObject1 = paramObject;
          if (((String)localObject2).equals("Long"))
          {
            localObject2 = eMf;
            localObject1 = paramObject;
            if (localObject2 != null)
            {
              localObject1 = Long.valueOf(((MultiProcessMMKV)localObject2).decodeLong(parama.name(), ((Long)paramObject).longValue()));
              continue;
              localObject1 = paramObject;
              if (((String)localObject2).equals("String"))
              {
                localObject2 = eMf;
                localObject1 = paramObject;
                if (localObject2 != null)
                {
                  localObject2 = ((MultiProcessMMKV)localObject2).decodeString(parama.name(), (String)paramObject);
                  localObject1 = paramObject;
                  if (localObject2 != null)
                  {
                    localObject1 = localObject2;
                    continue;
                    localObject1 = paramObject;
                    if (((String)localObject2).equals("Int"))
                    {
                      localObject2 = eMf;
                      localObject1 = paramObject;
                      if (localObject2 != null) {
                        localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject2).decodeInt(parama.name(), ((Integer)paramObject).intValue()));
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static String a(b.a parama, String paramString)
  {
    AppMethodBeat.i(233984);
    s.u(parama, "key");
    s.u(paramString, "defaultValue");
    parama = (String)a(parama, paramString);
    AppMethodBeat.o(233984);
    return parama;
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(233996);
    s.u(paramh, "listener");
    if (!agtu.get()) {
      agtv.add(new WeakReference(paramh));
    }
    AppMethodBeat.o(233996);
  }
  
  public static void b(b.a parama, Object paramObject)
  {
    AppMethodBeat.i(233992);
    s.u(parama, "key");
    s.u(paramObject, "value");
    Object localObject = (String)n.a((CharSequence)parama.name(), new String[] { "_" }).get(3);
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(233992);
      return;
      if (!((String)localObject).equals("Float"))
      {
        AppMethodBeat.o(233992);
        return;
        if (!((String)localObject).equals("Long"))
        {
          AppMethodBeat.o(233992);
          return;
          if (!((String)localObject).equals("String"))
          {
            AppMethodBeat.o(233992);
            return;
            if (!((String)localObject).equals("Int")) {
              continue;
            }
            localObject = eMf;
            if (localObject != null) {
              ((MultiProcessMMKV)localObject).encode(parama.name(), ((Integer)paramObject).intValue());
            }
            ((Map)mUV).put(parama.name(), paramObject);
            AppMethodBeat.o(233992);
            return;
          }
          localObject = eMf;
          if (localObject != null) {
            ((MultiProcessMMKV)localObject).encode(parama.name(), (String)paramObject);
          }
          ((Map)mUV).put(parama.name(), paramObject);
          AppMethodBeat.o(233992);
        }
      }
      else
      {
        localObject = eMf;
        if (localObject != null) {
          ((MultiProcessMMKV)localObject).encode(parama.name(), ((Float)paramObject).floatValue());
        }
        ((Map)mUV).put(parama.name(), paramObject);
        AppMethodBeat.o(233992);
        return;
      }
      localObject = eMf;
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).encode(parama.name(), ((Long)paramObject).longValue());
      }
      ((Map)mUV).put(parama.name(), paramObject);
    }
  }
  
  public static int bDL(String paramString)
  {
    AppMethodBeat.i(234004);
    s.u(paramString, "name");
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(234004);
      return 0;
    }
    int i = localMultiProcessMMKV.decodeInt(paramString, 0);
    AppMethodBeat.o(234004);
    return i;
  }
  
  private static final void dEx()
  {
    int i = 0;
    AppMethodBeat.i(234009);
    Object localObject = MultiProcessMMKV.getMMKV("Repairer");
    eMf = (MultiProcessMMKV)localObject;
    if (localObject == null)
    {
      if (i == 1) {
        break label173;
      }
      localObject = eMf;
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).clearMemoryCache();
      }
      localObject = eMf;
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).clearAll();
      }
      Log.i(TAG, "diff version, clear all currentVersion:" + i + " currentVersion:1");
    }
    for (;;)
    {
      localObject = eMf;
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).encode(b.a.agqp.name(), 1);
      }
      agtu.set(true);
      localObject = ((Iterable)agtv).iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((WeakReference)((Iterator)localObject).next()).get();
        if (localh != null) {
          localh.ready();
        }
      }
      i = ((MultiProcessMMKV)localObject).decodeInt(b.a.agqp.name(), 0);
      break;
      label173:
      Log.i(TAG, "same version, currentVersion:1");
    }
    agtv.clear();
    AppMethodBeat.o(234009);
  }
  
  public static AtomicBoolean jJz()
  {
    return agtu;
  }
  
  public static void jj(String paramString, int paramInt)
  {
    AppMethodBeat.i(234001);
    s.u(paramString, "name");
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.encode(paramString, paramInt);
    }
    AppMethodBeat.o(234001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.i
 * JD-Core Version:    0.7.0.1
 */