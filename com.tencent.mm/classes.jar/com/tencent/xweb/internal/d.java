package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public final class d
{
  private static HashMap<String, Long> aijY;
  
  static
  {
    AppMethodBeat.i(212584);
    aijY = new HashMap();
    AppMethodBeat.o(212584);
  }
  
  public static void bHP(String paramString)
  {
    try
    {
      AppMethodBeat.i(212573);
      XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForFrequentLimiter().edit().putLong(paramString, 0L).commit();
      AppMethodBeat.o(212573);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean bHQ(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(175641);
        SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForReportDaily();
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (str.equals(localSharedPreferences.getString(paramString, "")))
        {
          AppMethodBeat.o(175641);
          return bool;
        }
        if ("true".equals(b.kfi().bHl("dis_".concat(String.valueOf(paramString)))))
        {
          Log.i("FrequentLimiter", "canDoDaily, dis_" + paramString + " is true");
          AppMethodBeat.o(175641);
          continue;
        }
        localSharedPreferences.edit().putString(paramString, str).commit();
      }
      finally {}
      bool = true;
      AppMethodBeat.o(175641);
    }
  }
  
  public static boolean cH(String paramString, long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156968);
        if ("true".equals(a.keX().bHl("dis_".concat(String.valueOf(paramString)))))
        {
          Log.i("FrequentLimiter", "canDo, dis_" + paramString + " is true");
          AppMethodBeat.o(156968);
          return bool;
        }
        SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForFrequentLimiter();
        long l1 = localSharedPreferences.getLong(paramString, 0L);
        long l2 = System.currentTimeMillis();
        if (Math.abs(l2 - l1) < paramLong)
        {
          Log.i("FrequentLimiter", "canDo, time not up for ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(156968);
          continue;
        }
        localSharedPreferences.edit().putLong(paramString, l2).commit();
      }
      finally {}
      bool = true;
      AppMethodBeat.o(156968);
    }
  }
  
  /* Error */
  public static boolean qY(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 163
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 166	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferencesForXWebValueChanged	()Landroid/content/SharedPreferences;
    //   11: astore 5
    //   13: aload 5
    //   15: aload_0
    //   16: ldc 73
    //   18: invokeinterface 77 3 0
    //   23: astore 4
    //   25: aload 4
    //   27: astore_3
    //   28: aload 4
    //   30: ifnonnull +6 -> 36
    //   33: ldc 73
    //   35: astore_3
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +15 -> 56
    //   44: iconst_0
    //   45: istore_2
    //   46: ldc 163
    //   48: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: ldc 2
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: aload 5
    //   58: invokeinterface 42 1 0
    //   63: aload_0
    //   64: aload_1
    //   65: invokeinterface 130 3 0
    //   70: invokeinterface 52 1 0
    //   75: pop
    //   76: iconst_1
    //   77: istore_2
    //   78: ldc 163
    //   80: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -32 -> 51
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString1	String
    //   0	92	1	paramString2	String
    //   45	33	2	bool	boolean
    //   27	10	3	str1	String
    //   23	6	4	str2	String
    //   11	46	5	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   3	25	86	finally
    //   36	44	86	finally
    //   46	51	86	finally
    //   56	76	86	finally
    //   78	83	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.d
 * JD-Core Version:    0.7.0.1
 */