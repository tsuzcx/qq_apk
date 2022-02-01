package com.tencent.mm.plugin.trafficmonitor;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<Integer, Long> BAm;
  private static Map<Integer, Long> BAn;
  private static Map<Integer, Long> BAo;
  private static Map<Integer, Long> BAp;
  private static Map<Integer, Long> BAq;
  private static Map<Integer, Long> BAr;
  private static Map<Integer, Long> BAs;
  private static Map<Integer, Long> BAt;
  
  static
  {
    AppMethodBeat.i(123897);
    BAm = new HashMap();
    BAn = new HashMap();
    BAo = new HashMap();
    BAp = new HashMap();
    BAq = new HashMap();
    BAr = new HashMap();
    BAs = new HashMap();
    BAt = new HashMap();
    AppMethodBeat.o(123897);
  }
  
  public static long Tm(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (BAs == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (BAs.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)BAs.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BAs.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public static long Tn(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (BAt == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (BAt.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)BAt.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BAt.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public static long To(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (BAq == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (BAq.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)BAq.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BAq.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public static long Tp(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (BAr == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (BAr.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)BAr.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BAr.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123890);
    BAm.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAn.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAo.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAp.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAq.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAr.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAs.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BAt.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  public static void reset(int paramInt)
  {
    AppMethodBeat.i(123891);
    BAn.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    BAm.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    BAp.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    BAo.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AppMethodBeat.o(123891);
  }
  
  @TargetApi(23)
  public static void update(int paramInt)
  {
    AppMethodBeat.i(123896);
    l7 = 0L;
    l5 = 0L;
    long l6 = 0L;
    Object localObject2 = (NetworkStatsManager)aj.getContext().getSystemService("netstats");
    Object localObject1 = new NetworkStats.Bucket();
    l1 = l6;
    l2 = l5;
    try
    {
      NetworkStats localNetworkStats = ((NetworkStatsManager)localObject2).querySummary(1, "", 0L, System.currentTimeMillis());
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
      if (!b.n(aj.getContext(), "android.permission.READ_PHONE_STATE"))
      {
        l1 = l3;
        l2 = l4;
        init(paramInt);
        AppMethodBeat.o(123896);
        return;
      }
      l1 = l3;
      l2 = l4;
      localObject2 = ((NetworkStatsManager)localObject2).querySummary(0, q.aas(), 0L, System.currentTimeMillis());
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
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        BAq.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BAr.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BAs.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BAt.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BAm.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        BAn.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        BAo.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        BAp.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
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
    if (((Long)BAn.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BAn.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)BAm.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BAm.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)BAp.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BAp.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)BAo.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BAo.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = BAq;
    if (l4 >= ((Long)BAm.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)BAm.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = BAr;
      if (l3 < ((Long)BAn.get(Integer.valueOf(paramInt))).longValue()) {
        break label989;
      }
      l5 = l3 - ((Long)BAn.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = BAs;
      if (l2 < ((Long)BAo.get(Integer.valueOf(paramInt))).longValue()) {
        break label996;
      }
      l5 = l2 - ((Long)BAo.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = BAt;
      if (l1 < ((Long)BAp.get(Integer.valueOf(paramInt))).longValue()) {
        break label1002;
      }
      l5 = l1 - ((Long)BAp.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      BAm.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      BAn.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      BAo.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      BAp.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */