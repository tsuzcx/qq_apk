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
  private static Map<Integer, Long> yUL;
  private static Map<Integer, Long> yUM;
  private static Map<Integer, Long> yUN;
  private static Map<Integer, Long> yUO;
  private static Map<Integer, Long> yUP;
  private static Map<Integer, Long> yUQ;
  private static Map<Integer, Long> yUR;
  private static Map<Integer, Long> yUS;
  
  static
  {
    AppMethodBeat.i(123897);
    yUL = new HashMap();
    yUM = new HashMap();
    yUN = new HashMap();
    yUO = new HashMap();
    yUP = new HashMap();
    yUQ = new HashMap();
    yUR = new HashMap();
    yUS = new HashMap();
    AppMethodBeat.o(123897);
  }
  
  public static long Pw(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (yUR == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (yUR.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)yUR.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)yUR.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public static long Px(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (yUS == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (yUS.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)yUS.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)yUS.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public static long Py(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (yUP == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (yUP.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)yUP.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)yUP.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public static long Pz(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (yUQ == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (yUQ.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)yUQ.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)yUQ.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123890);
    yUL.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUM.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUN.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUO.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUP.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUQ.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUR.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    yUS.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  public static void reset(int paramInt)
  {
    AppMethodBeat.i(123891);
    yUM.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    yUL.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    yUO.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    yUN.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
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
      if (!b.o(aj.getContext(), "android.permission.READ_PHONE_STATE"))
      {
        l1 = l3;
        l2 = l4;
        init(paramInt);
        AppMethodBeat.o(123896);
        return;
      }
      l1 = l3;
      l2 = l4;
      localObject2 = ((NetworkStatsManager)localObject2).querySummary(0, q.WU(), 0L, System.currentTimeMillis());
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
        yUP.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        yUQ.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        yUR.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        yUS.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        yUL.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        yUM.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        yUN.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        yUO.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
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
    if (((Long)yUM.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      yUM.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)yUL.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      yUL.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)yUO.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      yUO.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)yUN.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      yUN.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = yUP;
    if (l4 >= ((Long)yUL.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)yUL.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = yUQ;
      if (l3 < ((Long)yUM.get(Integer.valueOf(paramInt))).longValue()) {
        break label989;
      }
      l5 = l3 - ((Long)yUM.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = yUR;
      if (l2 < ((Long)yUN.get(Integer.valueOf(paramInt))).longValue()) {
        break label996;
      }
      l5 = l2 - ((Long)yUN.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = yUS;
      if (l1 < ((Long)yUO.get(Integer.valueOf(paramInt))).longValue()) {
        break label1002;
      }
      l5 = l1 - ((Long)yUO.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      yUL.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      yUM.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      yUN.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      yUO.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */