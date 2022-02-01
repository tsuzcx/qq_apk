package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c
{
  static HashMap<String, Long> aaeN;
  
  static
  {
    AppMethodBeat.i(197051);
    aaeN = new HashMap();
    AppMethodBeat.o(197051);
  }
  
  public static void bFv(String paramString)
  {
    try
    {
      AppMethodBeat.i(197044);
      XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER").edit().putLong(paramString, 0L).commit();
      AppMethodBeat.o(197044);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean bFw(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(175641);
        SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (str.equals(localSharedPreferences.getString(paramString, "")))
        {
          AppMethodBeat.o(175641);
          return bool;
        }
        if ("true".equals(b.bEI("dis_".concat(String.valueOf(paramString)))))
        {
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
  
  public static boolean cv(String paramString, long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156968);
        if ("true".equals(a.bEI("dis_".concat(String.valueOf(paramString)))))
        {
          AppMethodBeat.o(156968);
          return bool;
        }
        SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER");
        long l1 = localSharedPreferences.getLong(paramString, 0L);
        long l2 = System.currentTimeMillis();
        if (Math.abs(l2 - l1) < paramLong)
        {
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
  public static boolean pb(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 133
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 135
    //   10: invokestatic 38	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   13: astore 5
    //   15: aload 5
    //   17: aload_0
    //   18: ldc 77
    //   20: invokeinterface 81 3 0
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ifnonnull +6 -> 38
    //   35: ldc 77
    //   37: astore_3
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +15 -> 58
    //   46: iconst_0
    //   47: istore_2
    //   48: ldc 133
    //   50: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: ldc 2
    //   55: monitorexit
    //   56: iload_2
    //   57: ireturn
    //   58: aload 5
    //   60: invokeinterface 44 1 0
    //   65: aload_0
    //   66: aload_1
    //   67: invokeinterface 108 3 0
    //   72: invokeinterface 54 1 0
    //   77: pop
    //   78: iconst_1
    //   79: istore_2
    //   80: ldc 133
    //   82: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -32 -> 53
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString1	String
    //   0	94	1	paramString2	String
    //   47	33	2	bool	boolean
    //   29	10	3	str1	String
    //   25	6	4	str2	String
    //   13	46	5	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   3	27	88	finally
    //   38	46	88	finally
    //   48	53	88	finally
    //   58	78	88	finally
    //   80	85	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.c
 * JD-Core Version:    0.7.0.1
 */