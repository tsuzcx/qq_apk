package com.tencent.mm.plugin.trafficmonitor;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<Integer, Long> Nfd;
  private static Map<Integer, Long> Nfe;
  private static Map<Integer, Long> Nff;
  private static Map<Integer, Long> Nfg;
  private static Map<Integer, Long> Nfh;
  private static Map<Integer, Long> Nfi;
  private static Map<Integer, Long> Nfj;
  private static Map<Integer, Long> Nfk;
  
  static
  {
    AppMethodBeat.i(123897);
    Nfd = new HashMap();
    Nfe = new HashMap();
    Nff = new HashMap();
    Nfg = new HashMap();
    Nfh = new HashMap();
    Nfi = new HashMap();
    Nfj = new HashMap();
    Nfk = new HashMap();
    AppMethodBeat.o(123897);
  }
  
  public static long ajP(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (Nfj == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (Nfj.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)Nfj.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Nfj.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public static long ajQ(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (Nfk == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (Nfk.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)Nfk.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Nfk.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public static long ajR(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (Nfh == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (Nfh.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)Nfh.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Nfh.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public static long ajS(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (Nfi == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (Nfi.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)Nfi.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Nfi.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public static void fs(int paramInt)
  {
    AppMethodBeat.i(123891);
    Nfe.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Nfd.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Nfg.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Nff.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AppMethodBeat.o(123891);
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123890);
    Nfd.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nfe.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nff.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nfg.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nfh.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nfi.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nfj.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Nfk.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  @TargetApi(23)
  public static void update(int paramInt)
  {
    AppMethodBeat.i(123896);
    l7 = 0L;
    l5 = 0L;
    long l6 = 0L;
    Object localObject2 = (NetworkStatsManager)MMApplicationContext.getContext().getSystemService("netstats");
    if (localObject2 == null)
    {
      AppMethodBeat.o(123896);
      return;
    }
    Object localObject1 = new NetworkStats.Bucket();
    l1 = l6;
    l2 = l5;
    try
    {
      NetworkStats localNetworkStats = ((NetworkStatsManager)localObject2).querySummary(1, null, 0L, System.currentTimeMillis());
      l4 = 0L;
      l3 = 0L;
      for (;;)
      {
        l1 = l6;
        l2 = l5;
        if (!localNetworkStats.hasNextBucket()) {
          break;
        }
        l1 = l6;
        l2 = l5;
        localNetworkStats.getNextBucket((NetworkStats.Bucket)localObject1);
        l1 = l6;
        l2 = l5;
        if (((NetworkStats.Bucket)localObject1).getUid() == Process.myUid())
        {
          l1 = l6;
          l2 = l5;
          l3 += ((NetworkStats.Bucket)localObject1).getRxBytes();
          l1 = l6;
          l2 = l5;
          l4 += ((NetworkStats.Bucket)localObject1).getTxBytes();
        }
      }
      l3 = 0L + l3;
      l4 = 0L + l4;
      l1 = l3;
      l2 = l4;
      if (!b.o(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE"))
      {
        l1 = l3;
        l2 = l4;
        init(paramInt);
        AppMethodBeat.o(123896);
        return;
      }
      l1 = l3;
      l2 = l4;
      localObject2 = ((NetworkStatsManager)localObject2).querySummary(0, null, 0L, System.currentTimeMillis());
      l5 = 0L;
      l6 = 0L;
      for (;;)
      {
        l1 = l3;
        l2 = l4;
        if (!((NetworkStats)localObject2).hasNextBucket()) {
          break;
        }
        l1 = l3;
        l2 = l4;
        ((NetworkStats)localObject2).getNextBucket((NetworkStats.Bucket)localObject1);
        l1 = l3;
        l2 = l4;
        if (((NetworkStats.Bucket)localObject1).getUid() == Process.myUid())
        {
          l1 = l3;
          l2 = l4;
          l6 += ((NetworkStats.Bucket)localObject1).getRxBytes();
          l1 = l3;
          l2 = l4;
          long l8 = ((NetworkStats.Bucket)localObject1).getTxBytes();
          l5 = l8 + l5;
        }
      }
      l1 = l3;
      l2 = l4;
      l3 = 0L + l6;
      l4 = 0L + l5;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Nfh.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Nfi.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Nfj.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Nfk.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Nfd.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Nfe.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Nff.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Nfg.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Log.e("NsmTrafficStats", "query traffic stats failed, e = " + localException.getMessage());
        long l3 = 0L;
        long l4 = l7;
        continue;
        l5 = l4;
        continue;
        l5 = l3;
        continue;
        l5 = l2;
        continue;
        l5 = l1;
      }
    }
    if (((Long)Nfe.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Nfe.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)Nfd.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Nfd.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)Nfg.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Nfg.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)Nff.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Nff.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = Nfh;
    if (l4 >= ((Long)Nfd.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)Nfd.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = Nfi;
      if (l3 < ((Long)Nfe.get(Integer.valueOf(paramInt))).longValue()) {
        break label1022;
      }
      l5 = l3 - ((Long)Nfe.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = Nfj;
      if (l2 < ((Long)Nff.get(Integer.valueOf(paramInt))).longValue()) {
        break label1029;
      }
      l5 = l2 - ((Long)Nff.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = Nfk;
      if (l1 < ((Long)Nfg.get(Integer.valueOf(paramInt))).longValue()) {
        break label1035;
      }
      l5 = l1 - ((Long)Nfg.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      Nfd.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      Nfe.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      Nff.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      Nfg.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */