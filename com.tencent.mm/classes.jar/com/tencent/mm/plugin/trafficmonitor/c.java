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
  private static Map<Integer, Long> Gss;
  private static Map<Integer, Long> Gst;
  private static Map<Integer, Long> Gsu;
  private static Map<Integer, Long> Gsv;
  private static Map<Integer, Long> Gsw;
  private static Map<Integer, Long> Gsx;
  private static Map<Integer, Long> Gsy;
  private static Map<Integer, Long> Gsz;
  
  static
  {
    AppMethodBeat.i(123897);
    Gss = new HashMap();
    Gst = new HashMap();
    Gsu = new HashMap();
    Gsv = new HashMap();
    Gsw = new HashMap();
    Gsx = new HashMap();
    Gsy = new HashMap();
    Gsz = new HashMap();
    AppMethodBeat.o(123897);
  }
  
  public static long acj(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (Gsy == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (Gsy.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)Gsy.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Gsy.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public static long ack(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (Gsz == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (Gsz.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)Gsz.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Gsz.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public static long acl(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (Gsw == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (Gsw.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)Gsw.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Gsw.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public static long acm(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (Gsx == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (Gsx.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)Gsx.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Gsx.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123890);
    Gss.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gst.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gsu.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gsv.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gsw.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gsx.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gsy.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Gsz.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  public static void reset(int paramInt)
  {
    AppMethodBeat.i(123891);
    Gst.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Gss.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Gsv.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Gsu.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AppMethodBeat.o(123891);
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
      if (!b.n(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE"))
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
        Gsw.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Gsx.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Gsy.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Gsz.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        Gss.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Gst.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Gsu.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Gsv.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
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
    if (((Long)Gst.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Gst.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)Gss.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Gss.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)Gsv.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Gsv.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)Gsu.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      Gsu.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = Gsw;
    if (l4 >= ((Long)Gss.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)Gss.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = Gsx;
      if (l3 < ((Long)Gst.get(Integer.valueOf(paramInt))).longValue()) {
        break label1022;
      }
      l5 = l3 - ((Long)Gst.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = Gsy;
      if (l2 < ((Long)Gsu.get(Integer.valueOf(paramInt))).longValue()) {
        break label1029;
      }
      l5 = l2 - ((Long)Gsu.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = Gsz;
      if (l1 < ((Long)Gsv.get(Integer.valueOf(paramInt))).longValue()) {
        break label1035;
      }
      l5 = l1 - ((Long)Gsv.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      Gss.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      Gst.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      Gsu.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      Gsv.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */