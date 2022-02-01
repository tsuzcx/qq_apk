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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/util/RepairerLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "configMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getConfigMap", "()Ljava/util/HashMap;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setMmkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "ready", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setReady", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "readyListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/util/OnRepairerReadyListener;", "getConfig", "key", "Lcom/tencent/mm/util/ConstantsRepairer$ItemInfoKey;", "defaultValue", "getConfigInt", "", "getConfigString", "registerReadyListener", "", "listener", "saveConfig", "value", "libcompatible_release"})
public final class i
{
  private static final String TAG = "MicroMsg.RepairerLogic";
  private static AtomicBoolean YyV;
  private static LinkedList<WeakReference<h>> YyW;
  public static final i YyX;
  private static MultiProcessMMKV cQO;
  private static final HashMap<String, Object> kra;
  
  static
  {
    AppMethodBeat.i(261577);
    YyX = new i();
    TAG = "MicroMsg.RepairerLogic";
    kra = new HashMap();
    YyV = new AtomicBoolean(false);
    com.tencent.e.h.ZvG.d((Runnable)1.YyY, "RepairerConfigThread");
    YyW = new LinkedList();
    AppMethodBeat.o(261577);
  }
  
  public static int a(b.a parama, int paramInt)
  {
    AppMethodBeat.i(261567);
    p.k(parama, "key");
    parama = a(parama, Integer.valueOf(paramInt));
    if (parama == null)
    {
      parama = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(261567);
      throw parama;
    }
    paramInt = ((Integer)parama).intValue();
    AppMethodBeat.o(261567);
    return paramInt;
  }
  
  public static Object a(b.a parama, Object paramObject)
  {
    AppMethodBeat.i(261566);
    p.k(parama, "key");
    p.k(paramObject, "defaultValue");
    if (kra.containsKey(parama.name()))
    {
      parama = kra.get(parama.name());
      if (parama != null) {
        break label352;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(261566);
      return paramObject;
      Object localObject2 = cQO;
      Object localObject1 = paramObject;
      if (localObject2 != null)
      {
        localObject1 = paramObject;
        if (((MultiProcessMMKV)localObject2).containsKey(parama.name()) == true)
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
        ((Map)kra).put(parama.name(), localObject1);
        AppMethodBeat.o(261566);
        return localObject1;
        localObject1 = paramObject;
        if (((String)localObject2).equals("Float"))
        {
          localObject2 = cQO;
          localObject1 = paramObject;
          if (localObject2 != null)
          {
            localObject1 = Float.valueOf(((MultiProcessMMKV)localObject2).decodeFloat(parama.name(), ((Float)paramObject).floatValue()));
            continue;
            localObject1 = paramObject;
            if (((String)localObject2).equals("Long"))
            {
              localObject2 = cQO;
              localObject1 = paramObject;
              if (localObject2 != null)
              {
                localObject1 = Long.valueOf(((MultiProcessMMKV)localObject2).decodeLong(parama.name(), ((Long)paramObject).longValue()));
                continue;
                localObject1 = paramObject;
                if (((String)localObject2).equals("String"))
                {
                  localObject2 = cQO;
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
                        localObject2 = cQO;
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
      label352:
      paramObject = parama;
    }
  }
  
  public static String a(b.a parama, String paramString)
  {
    AppMethodBeat.i(261569);
    p.k(parama, "key");
    p.k(paramString, "defaultValue");
    parama = a(parama, paramString);
    if (parama == null)
    {
      parama = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(261569);
      throw parama;
    }
    parama = (String)parama;
    AppMethodBeat.o(261569);
    return parama;
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(261574);
    p.k(paramh, "listener");
    if (!YyV.get()) {
      YyW.add(new WeakReference(paramh));
    }
    AppMethodBeat.o(261574);
  }
  
  public static void b(MultiProcessMMKV paramMultiProcessMMKV)
  {
    cQO = paramMultiProcessMMKV;
  }
  
  public static void b(b.a parama, Object paramObject)
  {
    AppMethodBeat.i(261571);
    p.k(parama, "key");
    p.k(paramObject, "value");
    Object localObject = (String)n.a((CharSequence)parama.name(), new String[] { "_" }).get(3);
    switch (((String)localObject).hashCode())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(261571);
          return;
          if (((String)localObject).equals("Float"))
          {
            localObject = cQO;
            if (localObject != null) {
              ((MultiProcessMMKV)localObject).encode(parama.name(), ((Float)paramObject).floatValue());
            }
            ((Map)kra).put(parama.name(), paramObject);
            AppMethodBeat.o(261571);
            return;
            if (((String)localObject).equals("Long"))
            {
              localObject = cQO;
              if (localObject != null) {
                ((MultiProcessMMKV)localObject).encode(parama.name(), ((Long)paramObject).longValue());
              }
              ((Map)kra).put(parama.name(), paramObject);
            }
          }
        }
      } while (!((String)localObject).equals("String"));
      localObject = cQO;
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).encode(parama.name(), (String)paramObject);
      }
      ((Map)kra).put(parama.name(), paramObject);
      AppMethodBeat.o(261571);
      return;
    } while (!((String)localObject).equals("Int"));
    localObject = cQO;
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).encode(parama.name(), ((Integer)paramObject).intValue());
    }
    ((Map)kra).put(parama.name(), paramObject);
    AppMethodBeat.o(261571);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    return cQO;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static AtomicBoolean ier()
  {
    return YyV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.util.i
 * JD-Core Version:    0.7.0.1
 */