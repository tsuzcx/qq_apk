package com.tencent.mm.plugin.trafficmonitor;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<Integer, Long> BRK;
  private static Map<Integer, Long> BRL;
  private static Map<Integer, Long> BRM;
  private static Map<Integer, Long> BRN;
  private static Map<Integer, Long> BRO;
  private static Map<Integer, Long> BRP;
  private static Map<Integer, Long> BRQ;
  private static Map<Integer, Long> BRR;
  
  static
  {
    AppMethodBeat.i(123897);
    BRK = new HashMap();
    BRL = new HashMap();
    BRM = new HashMap();
    BRN = new HashMap();
    BRO = new HashMap();
    BRP = new HashMap();
    BRQ = new HashMap();
    BRR = new HashMap();
    AppMethodBeat.o(123897);
  }
  
  public static long TT(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (BRQ == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (BRQ.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)BRQ.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BRQ.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public static long TU(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (BRR == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (BRR.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)BRR.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BRR.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public static long TV(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (BRO == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (BRO.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)BRO.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BRO.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public static long TW(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (BRP == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (BRP.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)BRP.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)BRP.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123890);
    BRK.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRL.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRM.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRN.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRO.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRP.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRQ.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    BRR.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  public static void reset(int paramInt)
  {
    AppMethodBeat.i(123891);
    BRL.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    BRK.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    BRN.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    BRM.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AppMethodBeat.o(123891);
  }
  
  @TargetApi(23)
  public static void update(int paramInt)
  {
    AppMethodBeat.i(123896);
    l7 = 0L;
    l5 = 0L;
    long l6 = 0L;
    Object localObject2 = (NetworkStatsManager)ak.getContext().getSystemService("netstats");
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
      if (!b.n(ak.getContext(), "android.permission.READ_PHONE_STATE"))
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
        BRO.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BRP.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BRQ.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BRR.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        BRK.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        BRL.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        BRM.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        BRN.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        ae.e("NsmTrafficStats", "query traffic stats failed, e = " + localException.getMessage());
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
    if (((Long)BRL.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BRL.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)BRK.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BRK.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)BRN.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BRN.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)BRM.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      BRM.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = BRO;
    if (l4 >= ((Long)BRK.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)BRK.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = BRP;
      if (l3 < ((Long)BRL.get(Integer.valueOf(paramInt))).longValue()) {
        break label1022;
      }
      l5 = l3 - ((Long)BRL.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = BRQ;
      if (l2 < ((Long)BRM.get(Integer.valueOf(paramInt))).longValue()) {
        break label1029;
      }
      l5 = l2 - ((Long)BRM.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = BRR;
      if (l1 < ((Long)BRN.get(Integer.valueOf(paramInt))).longValue()) {
        break label1035;
      }
      l5 = l1 - ((Long)BRN.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      BRK.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      BRL.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      BRM.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      BRN.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */