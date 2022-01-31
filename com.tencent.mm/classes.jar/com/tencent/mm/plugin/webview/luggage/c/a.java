package com.tencent.mm.plugin.webview.luggage.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<Integer, a.a> reN = new HashMap();
  private static boolean reO = false;
  private static boolean reP = false;
  private static boolean reQ = false;
  private static boolean reR = false;
  private static boolean reS = false;
  private static boolean reT = false;
  private static Map<Integer, Long> startTimeMap = new HashMap();
  
  public static a.a RT(String paramString)
  {
    if (!reN.containsKey(Integer.valueOf(paramString.hashCode()))) {
      reN.put(Integer.valueOf(paramString.hashCode()), new a.a());
    }
    return (a.a)reN.get(Integer.valueOf(paramString.hashCode()));
  }
  
  public static void RU(String paramString)
  {
    long l1 = Sb(paramString);
    long l2 = System.currentTimeMillis() - l1;
    y.i("MicroMsg.WebCostTimeReport", "reportOpenPageCostTime, url: %s, startTime = %d, costTime = %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
    if ((l1 != 0L) && (!reO))
    {
      h.nFQ.a(846L, 1L, l2, false);
      RT(paramString).reU = l2;
    }
    reO = true;
  }
  
  public static void RV(String paramString)
  {
    long l1 = Sb(paramString);
    long l2 = System.currentTimeMillis() - l1;
    y.i("MicroMsg.WebCostTimeReport", "reportGetA8KeyCostTime, url: %s, startTime = %d, costTime = %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
    if ((l1 != 0L) && (!reP))
    {
      h.nFQ.a(846L, 2L, l2, false);
      RT(paramString).reX = (System.currentTimeMillis() - RT(paramString).rfa);
    }
    reP = true;
  }
  
  public static void RW(String paramString)
  {
    long l1 = Sb(paramString);
    RT(paramString).reZ = System.currentTimeMillis();
    long l2 = RT(paramString).reZ - l1;
    y.i("MicroMsg.WebCostTimeReport", "reportPageStarted, url: %s, startTime = %d, costTime = %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
    if ((l1 != 0L) && (!reQ))
    {
      h.nFQ.a(846L, 3L, l2, false);
      RT(paramString).reV = l2;
    }
    reQ = true;
  }
  
  public static void RX(String paramString)
  {
    long l1 = Sb(paramString);
    long l2 = System.currentTimeMillis() - l1;
    y.i("MicroMsg.WebCostTimeReport", "reportPageFinished, url: %s, startTime = %d, costTime = %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
    if ((l1 != 0L) && (!reR))
    {
      h.nFQ.a(846L, 4L, l2, false);
      RT(paramString).reW = (System.currentTimeMillis() - RT(paramString).reZ);
    }
    reR = true;
  }
  
  public static void RY(String paramString)
  {
    long l1 = Sb(paramString);
    long l2 = System.currentTimeMillis() - l1;
    y.i("MicroMsg.WebCostTimeReport", "reportPreverifyStarted, url: %s, startTime = %d, costTime = %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
    if ((l1 != 0L) && (!reS))
    {
      h.nFQ.a(846L, 5L, l2, false);
      RT(paramString).rfb = System.currentTimeMillis();
    }
    reS = true;
  }
  
  public static void RZ(String paramString)
  {
    long l1 = Sb(paramString);
    long l2 = System.currentTimeMillis() - l1;
    y.i("MicroMsg.WebCostTimeReport", "reportPreverifyFinished, url: %s, startTime = %d, costTime = %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
    if ((l1 != 0L) && (!reT))
    {
      h.nFQ.a(846L, 6L, l2, false);
      RT(paramString).reY = (System.currentTimeMillis() - RT(paramString).rfb);
    }
    reT = true;
  }
  
  public static void Sa(String paramString)
  {
    RT(paramString).rfa = System.currentTimeMillis();
  }
  
  private static long Sb(String paramString)
  {
    if (startTimeMap.containsKey(Integer.valueOf(paramString.hashCode()))) {
      return ((Long)startTimeMap.get(Integer.valueOf(paramString.hashCode()))).longValue();
    }
    return 0L;
  }
  
  public static void clean()
  {
    startTimeMap.clear();
    reN.clear();
  }
  
  public static void w(long paramLong, String paramString)
  {
    y.i("MicroMsg.WebCostTimeReport", "setStartTime, url: %s, startTime = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    startTimeMap.put(Integer.valueOf(paramString.hashCode()), Long.valueOf(paramLong));
    paramString = RT(paramString);
    paramString.reU = 0L;
    paramString.reV = 0L;
    paramString.reW = 0L;
    paramString.reX = 0L;
    paramString.reY = 0L;
    paramString.reZ = 0L;
    paramString.rfa = 0L;
    paramString.rfb = 0L;
    reO = false;
    reP = false;
    reQ = false;
    reR = false;
    reS = false;
    reT = false;
    h.nFQ.a(846L, 0L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */