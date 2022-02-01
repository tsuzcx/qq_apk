package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;

public final class v
{
  private static boolean aieU;
  private static List<String> aieV;
  private static List<String> aieW;
  private static HashSet<String> aieX;
  private static HashSet<String> aieY;
  
  static
  {
    AppMethodBeat.i(156768);
    aieV = new ArrayList();
    aieW = new ArrayList();
    aieX = new HashSet();
    aieY = new HashSet();
    init();
    AppMethodBeat.o(156768);
  }
  
  private static boolean Y(String paramString, List<String> paramList)
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
  
  private static boolean b(String paramString, Set<String> paramSet)
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
  
  public static void bDL()
  {
    try
    {
      AppMethodBeat.i(212411);
      aieU = false;
      aieV = new ArrayList();
      aieW = new ArrayList();
      aieX = new HashSet();
      aieY = new HashSet();
      init();
      AppMethodBeat.o(212411);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public static boolean bHC(String paramString)
  {
    AppMethodBeat.i(156763);
    if (!init())
    {
      Log.i("UrlDispatcher", "needUseXWeb false, init failed, host:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("UrlDispatcher", "needUseXWeb false, host is empty");
      AppMethodBeat.o(156763);
      return false;
    }
    paramString = paramString.trim();
    if ((!b(paramString, aieX)) && (!Y(paramString, aieV)))
    {
      Log.i("UrlDispatcher", "needUseXWeb false, host not in white list, host:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    if ((b(paramString, aieY)) || (Y(paramString, aieW)))
    {
      l.y(903L, 121L, 1L);
      Log.i("UrlDispatcher", "needUseXWeb false, host in blacklist, host:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156763);
      return false;
    }
    l.y(903L, 120L, 1L);
    Log.i("UrlDispatcher", "needUseXWeb true, host:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(156763);
    return true;
  }
  
  @Deprecated
  public static boolean bHD(String paramString)
  {
    AppMethodBeat.i(212403);
    if ((b(paramString, aieY)) || (Y(paramString, aieW)))
    {
      l.y(903L, 121L, 1L);
      Log.i("UrlDispatcher", "isInXWebBlackList, host in blacklist, host:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(212403);
      return true;
    }
    AppMethodBeat.o(212403);
    return false;
  }
  
  private static List<String> bHE(String paramString)
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
    //   5: ldc 176
    //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 106	com/tencent/xweb/v:aieU	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 176
    //   18: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_0
    //   25: ireturn
    //   26: invokestatic 182	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   29: ldc 184
    //   31: ldc 186
    //   33: invokevirtual 190	com/tencent/xweb/a:qM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_1
    //   37: invokestatic 182	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   40: ldc 192
    //   42: ldc 186
    //   44: invokevirtual 190	com/tencent/xweb/a:qM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_2
    //   48: invokestatic 182	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   51: ldc 194
    //   53: ldc 186
    //   55: invokevirtual 190	com/tencent/xweb/a:qM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_3
    //   59: invokestatic 182	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   62: ldc 196
    //   64: ldc 186
    //   66: invokevirtual 190	com/tencent/xweb/a:qM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 4
    //   71: getstatic 30	com/tencent/xweb/v:aieV	Ljava/util/List;
    //   74: aload_1
    //   75: invokestatic 198	com/tencent/xweb/v:bHE	(Ljava/lang/String;)Ljava/util/List;
    //   78: invokeinterface 202 2 0
    //   83: pop
    //   84: getstatic 32	com/tencent/xweb/v:aieW	Ljava/util/List;
    //   87: aload_2
    //   88: invokestatic 198	com/tencent/xweb/v:bHE	(Ljava/lang/String;)Ljava/util/List;
    //   91: invokeinterface 202 2 0
    //   96: pop
    //   97: getstatic 37	com/tencent/xweb/v:aieX	Ljava/util/HashSet;
    //   100: aload_3
    //   101: invokestatic 198	com/tencent/xweb/v:bHE	(Ljava/lang/String;)Ljava/util/List;
    //   104: invokevirtual 203	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   107: pop
    //   108: getstatic 39	com/tencent/xweb/v:aieY	Ljava/util/HashSet;
    //   111: aload 4
    //   113: invokestatic 198	com/tencent/xweb/v:bHE	(Ljava/lang/String;)Ljava/util/List;
    //   116: invokevirtual 203	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   119: pop
    //   120: iconst_1
    //   121: putstatic 106	com/tencent/xweb/v:aieU	Z
    //   124: getstatic 106	com/tencent/xweb/v:aieU	Z
    //   127: istore_0
    //   128: ldc 176
    //   130: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: goto -112 -> 21
    //   136: astore_1
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: ldc 111
    //   145: ldc 205
    //   147: aload_1
    //   148: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokevirtual 121	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 131	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: goto -33 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	127	0	bool	boolean
    //   36	39	1	str1	String
    //   136	5	1	localObject1	Object
    //   142	6	1	localObject2	Object
    //   47	41	2	str2	String
    //   58	43	3	str3	String
    //   69	43	4	str4	String
    // Exception table:
    //   from	to	target	type
    //   5	21	136	finally
    //   124	133	136	finally
    //   143	157	136	finally
    //   26	124	142	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.v
 * JD-Core Version:    0.7.0.1
 */