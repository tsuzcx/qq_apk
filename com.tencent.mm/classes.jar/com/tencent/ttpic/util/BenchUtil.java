package com.tencent.ttpic.util;

import android.text.TextUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BenchUtil
{
  private static final int COUNT = 20;
  public static boolean ENABLE_LOG = false;
  public static boolean ENABLE_MEMINFO = false;
  private static final String PREFIX = "[time]";
  private static final String TAG = BenchUtil.class.getSimpleName();
  private static Map<String, Long> lastTimeMap;
  private static BenchUtil.LoggerAgent sLogger;
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, List<Long>> totalTimeMap = new HashMap();
  
  static
  {
    lastTimeMap = new HashMap();
    sLogger = new BenchUtil.LoggerAgent();
  }
  
  public static long benchEnd(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap == null) || (startTimeMap.get(paramString) == null)) {
      return 0L;
    }
    Object localObject = (List)totalTimeMap.get(paramString);
    if (localObject == null)
    {
      localObject = new ArrayList();
      totalTimeMap.put(paramString, localObject);
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
      ((List)localObject).add(Long.valueOf(l1));
      if (((List)localObject).size() >= 20)
      {
        long l2 = getTotalTime((List)localObject) / ((List)localObject).size();
        sLogger.d(TAG, "[time]" + paramString + ": " + l2 + "ms");
        lastTimeMap.put(paramString, Long.valueOf(l2));
        ((List)localObject).clear();
      }
      return l1;
    }
  }
  
  public static void benchEnd(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      return;
    }
    Object localObject = (List)totalTimeMap.get(paramString);
    if (localObject == null)
    {
      localObject = new ArrayList();
      totalTimeMap.put(paramString, localObject);
    }
    for (;;)
    {
      ((List)localObject).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
      if (((List)localObject).size() < 20) {
        break;
      }
      sLogger.d(TAG, "[time]" + paramString + ": " + getTotalTime((List)localObject) / (((List)localObject).size() / paramInt) + "ms");
      ((List)localObject).clear();
      return;
    }
  }
  
  public static void benchEndReverse(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      return;
    }
    Object localObject = (List)totalTimeMap.get(paramString);
    if (localObject == null)
    {
      localObject = new ArrayList();
      totalTimeMap.put(paramString, localObject);
    }
    for (;;)
    {
      ((List)localObject).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
      if (((List)localObject).size() < 20) {
        break;
      }
      sLogger.d(TAG, "[time]" + paramString + ": " + ((List)localObject).size() * paramInt / getTotalTime((List)localObject) + "fps");
      ((List)localObject).clear();
      return;
    }
  }
  
  public static long benchEndTotal(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      return 0L;
    }
    Object localObject = (List)totalTimeMap.get(paramString);
    if (localObject == null)
    {
      localObject = new ArrayList();
      totalTimeMap.put(paramString, localObject);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
      ((List)localObject).add(Long.valueOf(l));
      return l;
    }
  }
  
  public static void benchStart(String paramString)
  {
    if (!ENABLE_LOG) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void calcFps()
  {
    benchEnd("bench_fps");
    benchStart("bench_fps");
  }
  
  private static long elapsed(String paramString)
  {
    if (!lastTimeMap.containsKey(paramString)) {
      return 0L;
    }
    return ((Long)lastTimeMap.get(paramString)).longValue();
  }
  
  public static void flush()
  {
    Iterator localIterator = totalTimeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      sLogger.d(TAG, "[time]" + (String)localEntry.getKey() + ": " + getTotalTime((List)localEntry.getValue()) + "ms");
    }
    totalTimeMap.clear();
  }
  
  public static String getLastBenchAverage()
  {
    if (!ENABLE_LOG) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    long l = elapsed("bench_fps");
    if (l != 0L) {
      localStringBuilder.append("fps : ").append(Math.round((float)(1000L / l))).append("\n");
    }
    localStringBuilder.append("frame elapsed : ").append(l).append("\n");
    localStringBuilder.append("PTBeauty: ").append(elapsed("PTBeauty")).append("\n");
    localStringBuilder.append("PTSmoothSkin: ").append(elapsed("PTSmoothSkin")).append("\n");
    localStringBuilder.append("PTFilter: ").append(elapsed("PTFilter")).append("\n");
    localStringBuilder.append("PTFaceDetector: ").append(elapsed("PTFaceDetector")).append("\n");
    localStringBuilder.append("PTSticker: ").append(elapsed("PTSticker")).append("\n");
    localStringBuilder.append("\n");
    localStringBuilder.append("retrieve data: ").append(elapsed("RetrieveData")).append("\n");
    localStringBuilder.append("face track: ").append(elapsed("FaceTrack")).append("\n");
    localStringBuilder.append("face detect: ").append(elapsed("FaceDetect")).append("\n");
    localStringBuilder.append("\n");
    localStringBuilder.append("glReadPixels: ").append(elapsed("glReadPixels")).append("\n");
    localStringBuilder.append("\n");
    localStringBuilder.append("glFinish: ").append(elapsed("glFinish")).append("\n");
    return localStringBuilder.toString();
  }
  
  public static String getLastBenchAveragePitu(int paramInt)
  {
    if (!ENABLE_LOG) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    long l = elapsed("bench_fps");
    if (l != 0L) {
      localStringBuffer.append("fps : " + Math.round((float)(1000L / l)) + "\n");
    }
    localStringBuffer.append("frame elapsed : " + l + "\n");
    localStringBuffer.append("onDrawFrame : " + elapsed("onDrawFrame") + "\n");
    localStringBuffer.append("materialSize : " + VideoMemoryManager.getInstance().getMaterialSizeInMB() + " MB\n");
    localStringBuffer.append("ratation : " + paramInt + "\n");
    return localStringBuffer.toString();
  }
  
  private static long getTotalTime(List<Long> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return 0L;
    }
    paramList = paramList.iterator();
    for (long l = 0L; paramList.hasNext(); l = ((Long)paramList.next()).longValue() + l) {}
    return l;
  }
  
  public static void init()
  {
    startTimeMap.clear();
    totalTimeMap.clear();
    lastTimeMap.clear();
  }
  
  public static void setLoggerAgent(BenchUtil.LoggerAgent paramLoggerAgent)
  {
    sLogger = paramLoggerAgent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.BenchUtil
 * JD-Core Version:    0.7.0.1
 */