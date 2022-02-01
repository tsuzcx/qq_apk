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
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<Integer, Long> AiA;
  private static Map<Integer, Long> AiB;
  private static Map<Integer, Long> AiC;
  private static Map<Integer, Long> AiD;
  private static Map<Integer, Long> AiE;
  private static Map<Integer, Long> AiF;
  private static Map<Integer, Long> AiG;
  private static Map<Integer, Long> AiH;
  
  static
  {
    AppMethodBeat.i(123897);
    AiA = new HashMap();
    AiB = new HashMap();
    AiC = new HashMap();
    AiD = new HashMap();
    AiE = new HashMap();
    AiF = new HashMap();
    AiG = new HashMap();
    AiH = new HashMap();
    AppMethodBeat.o(123897);
  }
  
  public static long RC(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (AiG == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (AiG.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)AiG.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiG.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public static long RD(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (AiH == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (AiH.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)AiH.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiH.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public static long RE(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (AiE == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (AiE.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)AiE.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiE.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public static long RF(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (AiF == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (AiF.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)AiF.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiF.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123890);
    AiA.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiB.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiC.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiD.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiE.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiF.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiG.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiH.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  public static void reset(int paramInt)
  {
    AppMethodBeat.i(123891);
    AiB.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AiA.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AiD.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AiC.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AppMethodBeat.o(123891);
  }
  
  @TargetApi(23)
  public static void update(int paramInt)
  {
    AppMethodBeat.i(123896);
    l7 = 0L;
    l5 = 0L;
    long l6 = 0L;
    Object localObject2 = (NetworkStatsManager)ai.getContext().getSystemService("netstats");
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
      if (!b.o(ai.getContext(), "android.permission.READ_PHONE_STATE"))
      {
        l1 = l3;
        l2 = l4;
        init(paramInt);
        AppMethodBeat.o(123896);
        return;
      }
      l1 = l3;
      l2 = l4;
      localObject2 = ((NetworkStatsManager)localObject2).querySummary(0, q.XR(), 0L, System.currentTimeMillis());
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
        AiE.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        AiF.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        AiG.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        AiH.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        AiA.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        AiB.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        AiC.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        AiD.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
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
    if (((Long)AiB.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      AiB.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)AiA.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      AiA.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)AiD.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      AiD.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)AiC.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      AiC.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = AiE;
    if (l4 >= ((Long)AiA.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)AiA.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = AiF;
      if (l3 < ((Long)AiB.get(Integer.valueOf(paramInt))).longValue()) {
        break label989;
      }
      l5 = l3 - ((Long)AiB.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = AiG;
      if (l2 < ((Long)AiC.get(Integer.valueOf(paramInt))).longValue()) {
        break label996;
      }
      l5 = l2 - ((Long)AiC.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = AiH;
      if (l1 < ((Long)AiD.get(Integer.valueOf(paramInt))).longValue()) {
        break label1002;
      }
      l5 = l1 - ((Long)AiD.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      AiA.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      AiB.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      AiC.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      AiD.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */