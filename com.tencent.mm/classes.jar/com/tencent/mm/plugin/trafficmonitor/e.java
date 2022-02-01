package com.tencent.mm.plugin.trafficmonitor;

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

public class e
  implements c
{
  private static e TRY;
  private final Map<Integer, Long> TRO;
  private final Map<Integer, Long> TRP;
  private final Map<Integer, Long> TRQ;
  private final Map<Integer, Long> TRR;
  private final Map<Integer, Long> TRS;
  private final Map<Integer, Long> TRT;
  private final Map<Integer, Long> TRU;
  private final Map<Integer, Long> TRV;
  
  private e()
  {
    AppMethodBeat.i(260741);
    this.TRO = new HashMap();
    this.TRP = new HashMap();
    this.TRQ = new HashMap();
    this.TRR = new HashMap();
    this.TRS = new HashMap();
    this.TRT = new HashMap();
    this.TRU = new HashMap();
    this.TRV = new HashMap();
    AppMethodBeat.o(260741);
  }
  
  /* Error */
  public static e hPm()
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 57	com/tencent/mm/plugin/trafficmonitor/e:TRY	Lcom/tencent/mm/plugin/trafficmonitor/e;
    //   11: ifnonnull +19 -> 30
    //   14: ldc 2
    //   16: monitorenter
    //   17: new 2	com/tencent/mm/plugin/trafficmonitor/e
    //   20: dup
    //   21: invokespecial 58	com/tencent/mm/plugin/trafficmonitor/e:<init>	()V
    //   24: putstatic 57	com/tencent/mm/plugin/trafficmonitor/e:TRY	Lcom/tencent/mm/plugin/trafficmonitor/e;
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 57	com/tencent/mm/plugin/trafficmonitor/e:TRY	Lcom/tencent/mm/plugin/trafficmonitor/e;
    //   36: astore_0
    //   37: ldc 55
    //   39: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: ldc 55
    //   50: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: ldc 55
    //   61: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	7	0	locale	e
    //   44	10	0	localObject1	Object
    //   55	10	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	30	44	finally
    //   8	17	55	finally
    //   30	33	55	finally
    //   45	55	55	finally
  }
  
  public final long apg(int paramInt)
  {
    AppMethodBeat.i(123892);
    if (this.TRU.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123892);
      return 0L;
    }
    if (((Long)this.TRU.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)this.TRU.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123892);
      return l;
    }
    AppMethodBeat.o(123892);
    return 0L;
  }
  
  public final long aph(int paramInt)
  {
    AppMethodBeat.i(123893);
    if (this.TRV == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (this.TRV.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123893);
      return 0L;
    }
    if (((Long)this.TRV.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)this.TRV.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123893);
      return l;
    }
    AppMethodBeat.o(123893);
    return 0L;
  }
  
  public final long api(int paramInt)
  {
    AppMethodBeat.i(123894);
    if (this.TRS == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (this.TRS.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123894);
      return 0L;
    }
    if (((Long)this.TRS.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)this.TRS.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123894);
      return l;
    }
    AppMethodBeat.o(123894);
    return 0L;
  }
  
  public final long apj(int paramInt)
  {
    AppMethodBeat.i(123895);
    if (this.TRT == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (this.TRT.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123895);
      return 0L;
    }
    if (((Long)this.TRT.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)this.TRT.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123895);
      return l;
    }
    AppMethodBeat.o(123895);
    return 0L;
  }
  
  public final void iF(int paramInt)
  {
    AppMethodBeat.i(123891);
    this.TRP.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    this.TRO.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    this.TRR.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    this.TRQ.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AppMethodBeat.o(123891);
  }
  
  public final void sE(int paramInt)
  {
    AppMethodBeat.i(123890);
    this.TRO.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRP.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRQ.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRR.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRS.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRT.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRU.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    this.TRV.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123890);
  }
  
  public final void update(int paramInt)
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
    long l1 = l6;
    long l2 = l5;
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
      if (!b.s(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE"))
      {
        l1 = l3;
        l2 = l4;
        sE(paramInt);
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
        this.TRS.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        this.TRT.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        this.TRU.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        this.TRV.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        this.TRO.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        this.TRP.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        this.TRQ.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        this.TRR.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
        Log.e("NsmTrafficStats", "query traffic stats failed, e = " + localException.getMessage());
        long l3 = 0L;
        long l4 = l7;
        continue;
        l5 = 0L;
        continue;
        l5 = 0L;
        continue;
        l5 = 0L;
        continue;
        l5 = 0L;
      }
    }
    if (((Long)this.TRP.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      this.TRP.put(Integer.valueOf(paramInt), Long.valueOf(l3));
    }
    if (((Long)this.TRO.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      this.TRO.put(Integer.valueOf(paramInt), Long.valueOf(l4));
    }
    if (((Long)this.TRR.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      this.TRR.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    }
    if (((Long)this.TRQ.get(Integer.valueOf(paramInt))).longValue() < 0L) {
      this.TRQ.put(Integer.valueOf(paramInt), Long.valueOf(l2));
    }
    localObject1 = this.TRS;
    if (l4 >= ((Long)this.TRO.get(Integer.valueOf(paramInt))).longValue())
    {
      l5 = l4 - ((Long)this.TRO.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = this.TRT;
      if (l3 < ((Long)this.TRP.get(Integer.valueOf(paramInt))).longValue()) {
        break label1073;
      }
      l5 = l3 - ((Long)this.TRP.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = this.TRU;
      if (l2 < ((Long)this.TRQ.get(Integer.valueOf(paramInt))).longValue()) {
        break label1079;
      }
      l5 = l2 - ((Long)this.TRQ.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      localObject1 = this.TRV;
      if (l1 < ((Long)this.TRR.get(Integer.valueOf(paramInt))).longValue()) {
        break label1085;
      }
      l5 = l1 - ((Long)this.TRR.get(Integer.valueOf(paramInt))).longValue();
      ((Map)localObject1).put(Integer.valueOf(paramInt), Long.valueOf(l5));
      this.TRO.put(Integer.valueOf(paramInt), Long.valueOf(l4));
      this.TRP.put(Integer.valueOf(paramInt), Long.valueOf(l3));
      this.TRQ.put(Integer.valueOf(paramInt), Long.valueOf(l2));
      this.TRR.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(123896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */