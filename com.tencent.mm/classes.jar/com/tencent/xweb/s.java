package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;

public final class s
{
  static boolean IMO;
  static List<String> IMQ;
  static List<String> IMR;
  static HashSet<String> IMS;
  static HashSet<String> IMT;
  
  static
  {
    AppMethodBeat.i(156768);
    IMQ = new ArrayList();
    IMR = new ArrayList();
    IMS = new HashSet();
    IMT = new HashSet();
    init();
    AppMethodBeat.o(156768);
  }
  
  private static boolean L(String paramString, List<String> paramList)
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
  
  public static boolean aOZ(String paramString)
  {
    AppMethodBeat.i(156763);
    if (!init())
    {
      AppMethodBeat.o(156763);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(156763);
      return false;
    }
    paramString = paramString.trim();
    if ((!a(paramString, IMS)) && (!L(paramString, IMQ)))
    {
      AppMethodBeat.o(156763);
      return false;
    }
    if ((a(paramString, IMT)) || (L(paramString, IMR)))
    {
      g.r(903L, 121L, 1L);
      Log.i("UrlDispatcher", "dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    g.r(903L, 120L, 1L);
    Log.i("UrlDispatcher", "dispatch to toolsmp suc, host = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(156763);
    return true;
  }
  
  public static boolean aPa(String paramString)
  {
    AppMethodBeat.i(195160);
    if ((a(paramString, IMT)) || (L(paramString, IMR)))
    {
      g.r(903L, 121L, 1L);
      Log.i("UrlDispatcher", "isInXWebBlackList dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195160);
      return true;
    }
    AppMethodBeat.o(195160);
    return false;
  }
  
  private static List<String> aPb(String paramString)
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
  
  /* Error */
  private static boolean init()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 163
    //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 165	com/tencent/xweb/s:IMO	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 163
    //   18: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_0
    //   25: ireturn
    //   26: ldc 167
    //   28: ldc 169
    //   30: invokestatic 175	com/tencent/xweb/a:lW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 177
    //   36: ldc 169
    //   38: invokestatic 175	com/tencent/xweb/a:lW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_2
    //   42: ldc 179
    //   44: ldc 169
    //   46: invokestatic 175	com/tencent/xweb/a:lW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_3
    //   50: ldc 181
    //   52: ldc 169
    //   54: invokestatic 175	com/tencent/xweb/a:lW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 4
    //   59: getstatic 30	com/tencent/xweb/s:IMQ	Ljava/util/List;
    //   62: aload_1
    //   63: invokestatic 183	com/tencent/xweb/s:aPb	(Ljava/lang/String;)Ljava/util/List;
    //   66: invokeinterface 187 2 0
    //   71: pop
    //   72: getstatic 32	com/tencent/xweb/s:IMR	Ljava/util/List;
    //   75: aload_2
    //   76: invokestatic 183	com/tencent/xweb/s:aPb	(Ljava/lang/String;)Ljava/util/List;
    //   79: invokeinterface 187 2 0
    //   84: pop
    //   85: getstatic 37	com/tencent/xweb/s:IMS	Ljava/util/HashSet;
    //   88: aload_3
    //   89: invokestatic 183	com/tencent/xweb/s:aPb	(Ljava/lang/String;)Ljava/util/List;
    //   92: invokevirtual 188	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   95: pop
    //   96: getstatic 39	com/tencent/xweb/s:IMT	Ljava/util/HashSet;
    //   99: aload 4
    //   101: invokestatic 183	com/tencent/xweb/s:aPb	(Ljava/lang/String;)Ljava/util/List;
    //   104: invokevirtual 188	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   107: pop
    //   108: iconst_1
    //   109: putstatic 165	com/tencent/xweb/s:IMO	Z
    //   112: getstatic 165	com/tencent/xweb/s:IMO	Z
    //   115: istore_0
    //   116: ldc 163
    //   118: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: goto -100 -> 21
    //   124: astore_1
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: ldc 124
    //   133: ldc 190
    //   135: invokestatic 193	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public static void refresh()
  {
    try
    {
      AppMethodBeat.i(195161);
      IMO = false;
      IMQ = new ArrayList();
      IMR = new ArrayList();
      IMS = new HashSet();
      IMT = new HashSet();
      init();
      AppMethodBeat.o(195161);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.s
 * JD-Core Version:    0.7.0.1
 */