package com.tencent.tavkit.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class BenchUtil
{
  public static boolean ENABLE_DEBUG = false;
  private static final String TAG = "BenchUtil";
  private static Map<String, Long> endTimeMap;
  private static Map<String, Long> startTimeMap;
  
  static
  {
    AppMethodBeat.i(200993);
    startTimeMap = new HashMap();
    endTimeMap = new HashMap();
    ENABLE_DEBUG = false;
    AppMethodBeat.o(200993);
  }
  
  public static long benchEnd(String paramString)
  {
    AppMethodBeat.i(200992);
    if ((ENABLE_DEBUG) && (!TextUtils.isEmpty(paramString)) && (startTimeMap != null))
    {
      Long localLong = (Long)startTimeMap.get(paramString);
      if (localLong == null)
      {
        AppMethodBeat.o(200992);
        return 0L;
      }
      long l = System.currentTimeMillis() - localLong.longValue();
      new StringBuilder().append(paramString).append(", cost time: ").append(l);
      AppMethodBeat.o(200992);
      return l;
    }
    AppMethodBeat.o(200992);
    return 0L;
  }
  
  public static void benchStart(String paramString)
  {
    AppMethodBeat.i(200991);
    if ((ENABLE_DEBUG) && (!TextUtils.isEmpty(paramString))) {
      startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
    AppMethodBeat.o(200991);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(200990);
    startTimeMap.clear();
    endTimeMap.clear();
    AppMethodBeat.o(200990);
  }
  
  public static void setEnableDebugLog(boolean paramBoolean)
  {
    ENABLE_DEBUG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tavkit.utils.BenchUtil
 * JD-Core Version:    0.7.0.1
 */