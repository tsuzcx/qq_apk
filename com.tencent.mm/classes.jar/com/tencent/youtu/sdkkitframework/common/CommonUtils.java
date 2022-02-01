package com.tencent.youtu.sdkkitframework.common;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class CommonUtils
{
  public static final int MAX_TIMEOUT_MS = 30000;
  public static final int MIN_TIMEOUT_MS = 0;
  private static final String TAG = "CommonUtils";
  private static ConcurrentHashMap<String, BenchMarkTime> benchMarkMaps;
  
  static
  {
    AppMethodBeat.i(218358);
    benchMarkMaps = new ConcurrentHashMap();
    AppMethodBeat.o(218358);
  }
  
  public static void benchMarkBegin(String paramString)
  {
    AppMethodBeat.i(218298);
    if (!benchMarkMaps.containsKey(paramString)) {
      benchMarkMaps.put(paramString, new BenchMarkTime());
    }
    ((BenchMarkTime)benchMarkMaps.get(paramString)).begin();
    AppMethodBeat.o(218298);
  }
  
  public static long benchMarkEnd(String paramString)
  {
    AppMethodBeat.i(218308);
    if (!benchMarkMaps.containsKey(paramString))
    {
      AppMethodBeat.o(218308);
      return 0L;
    }
    BenchMarkTime localBenchMarkTime = (BenchMarkTime)benchMarkMaps.get(paramString);
    localBenchMarkTime.end();
    YtLogger.d("CommonUtils", "benchMarkEnd -- " + paramString + " : " + localBenchMarkTime.cur + "ms");
    long l = localBenchMarkTime.cur;
    AppMethodBeat.o(218308);
    return l;
  }
  
  public static String getBenchMarkTime(String paramString)
  {
    AppMethodBeat.i(218312);
    if (!benchMarkMaps.containsKey(paramString))
    {
      AppMethodBeat.o(218312);
      return "";
    }
    paramString = "[" + paramString + "]" + ((BenchMarkTime)benchMarkMaps.get(paramString)).getTime();
    AppMethodBeat.o(218312);
    return paramString;
  }
  
  private static byte[] getSignature(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218343);
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString2.getBytes(), localMac.getAlgorithm()));
    paramString1 = localMac.doFinal(paramString1.getBytes());
    AppMethodBeat.o(218343);
    return paramString1;
  }
  
  public static String getYoutuOpenAppSign(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(218323);
    long l = System.currentTimeMillis() / 1000L;
    int i = Math.abs(new Random().nextInt());
    paramString1 = "a=" + paramString1 + "&k=" + paramString2 + "&e=" + (2592000L + l) + "&t=" + l + "&r=" + i + "&u=" + paramString4 + "&f=";
    paramString2 = getSignature(paramString1, paramString3);
    paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
    paramString1 = new String(Base64.encode(paramString3, 2));
    AppMethodBeat.o(218323);
    return paramString1;
  }
  
  public static String makeMessageJson(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(218333);
    try
    {
      new JSONObject(paramString2);
      AppMethodBeat.o(218333);
      return paramString2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString2 = "{ \"errorcode\":" + paramInt + ",\"errormsg\": \"" + paramString1 + "\",\"extrainfo\":\"" + paramString2 + "\"}";
      }
    }
  }
  
  public static void reportException(String paramString, Exception paramException)
  {
    AppMethodBeat.i(218353);
    YtSDKStats.getInstance().reportInfo(paramString + " cause exception: " + paramException.getLocalizedMessage());
    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    AppMethodBeat.o(218353);
  }
  
  static class BenchMarkTime
  {
    long avg;
    long begin;
    long cur;
    long max;
    long min;
    long tick;
    long total;
    
    public BenchMarkTime()
    {
      AppMethodBeat.i(218273);
      this.total = 0L;
      this.tick = 0L;
      this.cur = 0L;
      this.avg = 0L;
      this.min = 9223372036854775807L;
      this.max = -9223372036854775808L;
      AppMethodBeat.o(218273);
    }
    
    private void update(long paramLong)
    {
      AppMethodBeat.i(218281);
      this.tick += 1L;
      this.min = Math.min(paramLong, this.min);
      this.max = Math.max(paramLong, this.max);
      this.total += paramLong;
      this.avg = (this.total / this.tick);
      AppMethodBeat.o(218281);
    }
    
    public void begin()
    {
      AppMethodBeat.i(218284);
      this.begin = System.currentTimeMillis();
      AppMethodBeat.o(218284);
    }
    
    public void end()
    {
      AppMethodBeat.i(218288);
      this.cur = (System.currentTimeMillis() - this.begin);
      update(this.cur);
      AppMethodBeat.o(218288);
    }
    
    public String getTime()
    {
      AppMethodBeat.i(218295);
      String str = "avg: " + this.avg + "ms min: " + this.min + "ms max: " + this.max + "ms cur: " + this.cur + "ms";
      AppMethodBeat.o(218295);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.CommonUtils
 * JD-Core Version:    0.7.0.1
 */