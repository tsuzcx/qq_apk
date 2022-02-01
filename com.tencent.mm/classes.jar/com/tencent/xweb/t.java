package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;

public final class t
{
  static List<String> aaaA;
  static HashSet<String> aaaB;
  static HashSet<String> aaaC;
  static boolean aaax;
  static List<String> aaaz;
  
  static
  {
    AppMethodBeat.i(156768);
    aaaz = new ArrayList();
    aaaA = new ArrayList();
    aaaB = new HashSet();
    aaaC = new HashSet();
    init();
    AppMethodBeat.o(156768);
  }
  
  private static boolean R(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(156766);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(paramString))
      {
        if ("all".equalsIgnoreCase(str))
        {
          AppMethodBeat.o(156766);
          return true;
        }
        if (paramString.endsWith(str))
        {
          if (paramString.length() == str.length())
          {
            AppMethodBeat.o(156766);
            return true;
          }
          if (paramString.charAt(paramString.length() - str.length() - 1) == '.')
          {
            AppMethodBeat.o(156766);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(156766);
    return false;
  }
  
  private static boolean a(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156767);
    if (paramSet.contains(paramString))
    {
      AppMethodBeat.o(156767);
      return true;
    }
    AppMethodBeat.o(156767);
    return false;
  }
  
  public static boolean bFg(String paramString)
  {
    AppMethodBeat.i(156763);
    if (!init())
    {
      Log.i("UrlDispatcher", "init urldispatcher failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("UrlDispatcher", "host is empty ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    paramString = paramString.trim();
    if ((!a(paramString, aaaB)) && (!R(paramString, aaaz)))
    {
      Log.i("UrlDispatcher", "not in white list ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    if ((a(paramString, aaaC)) || (R(paramString, aaaA)))
    {
      h.u(903L, 121L, 1L);
      Log.i("UrlDispatcher", "dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    h.u(903L, 120L, 1L);
    Log.i("UrlDispatcher", "dispatch to toolsmp suc, host = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(156763);
    return true;
  }
  
  public static boolean bFh(String paramString)
  {
    AppMethodBeat.i(196889);
    if ((a(paramString, aaaC)) || (R(paramString, aaaA)))
    {
      h.u(903L, 121L, 1L);
      Log.i("UrlDispatcher", "isInXWebBlackList dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(196889);
      return true;
    }
    AppMethodBeat.o(196889);
    return false;
  }
  
  private static List<String> bFi(String paramString)
  {
    AppMethodBeat.i(156765);
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(156765);
      return localArrayList;
    }
    paramString = paramString.split(",");
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(156765);
      return localArrayList;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        localArrayList.add(localCharSequence.trim());
      }
      i += 1;
    }
    AppMethodBeat.o(156765);
    return localArrayList;
  }
  
  public static void bfU()
  {
    try
    {
      AppMethodBeat.i(196893);
      aaax = false;
      aaaz = new ArrayList();
      aaaA = new ArrayList();
      aaaB = new HashSet();
      aaaC = new HashSet();
      init();
      AppMethodBeat.o(196893);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private static boolean init()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 176
    //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 173	com/tencent/xweb/t:aaax	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 176
    //   18: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_0
    //   25: ireturn
    //   26: ldc 178
    //   28: ldc 180
    //   30: invokestatic 186	com/tencent/xweb/a:oO	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 188
    //   36: ldc 180
    //   38: invokestatic 186	com/tencent/xweb/a:oO	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_2
    //   42: ldc 190
    //   44: ldc 180
    //   46: invokestatic 186	com/tencent/xweb/a:oO	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_3
    //   50: ldc 192
    //   52: ldc 180
    //   54: invokestatic 186	com/tencent/xweb/a:oO	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 4
    //   59: getstatic 30	com/tencent/xweb/t:aaaz	Ljava/util/List;
    //   62: aload_1
    //   63: invokestatic 194	com/tencent/xweb/t:bFi	(Ljava/lang/String;)Ljava/util/List;
    //   66: invokeinterface 198 2 0
    //   71: pop
    //   72: getstatic 32	com/tencent/xweb/t:aaaA	Ljava/util/List;
    //   75: aload_2
    //   76: invokestatic 194	com/tencent/xweb/t:bFi	(Ljava/lang/String;)Ljava/util/List;
    //   79: invokeinterface 198 2 0
    //   84: pop
    //   85: getstatic 37	com/tencent/xweb/t:aaaB	Ljava/util/HashSet;
    //   88: aload_3
    //   89: invokestatic 194	com/tencent/xweb/t:bFi	(Ljava/lang/String;)Ljava/util/List;
    //   92: invokevirtual 199	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   95: pop
    //   96: getstatic 39	com/tencent/xweb/t:aaaC	Ljava/util/HashSet;
    //   99: aload 4
    //   101: invokestatic 194	com/tencent/xweb/t:bFi	(Ljava/lang/String;)Ljava/util/List;
    //   104: invokevirtual 199	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   107: pop
    //   108: iconst_1
    //   109: putstatic 173	com/tencent/xweb/t:aaax	Z
    //   112: getstatic 173	com/tencent/xweb/t:aaax	Z
    //   115: istore_0
    //   116: ldc 176
    //   118: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: goto -100 -> 21
    //   124: astore_1
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: ldc 106
    //   133: ldc 201
    //   135: invokestatic 126	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -26 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	115	0	bool	boolean
    //   33	30	1	str1	String
    //   124	5	1	localObject	Object
    //   130	1	1	localException	java.lang.Exception
    //   41	35	2	str2	String
    //   49	40	3	str3	String
    //   57	43	4	str4	String
    // Exception table:
    //   from	to	target	type
    //   5	21	124	finally
    //   26	112	124	finally
    //   112	121	124	finally
    //   131	138	124	finally
    //   26	112	130	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.t
 * JD-Core Version:    0.7.0.1
 */