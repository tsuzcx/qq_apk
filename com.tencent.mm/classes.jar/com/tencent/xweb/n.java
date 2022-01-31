package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;

public final class n
{
  static HashSet<String> BDA;
  static HashSet<String> BDB;
  static boolean BDC;
  static List<String> BDy;
  static List<String> BDz;
  
  static
  {
    AppMethodBeat.i(151421);
    BDy = new ArrayList();
    BDz = new ArrayList();
    BDA = new HashSet();
    BDB = new HashSet();
    init();
    AppMethodBeat.o(151421);
  }
  
  private static boolean E(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(151419);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!TextUtils.isEmpty(paramString)) && (paramString.endsWith(str)))
      {
        if (paramString.length() == str.length())
        {
          AppMethodBeat.o(151419);
          return true;
        }
        if (paramString.charAt(paramString.length() - str.length() - 1) == '.')
        {
          AppMethodBeat.o(151419);
          return true;
        }
      }
    }
    AppMethodBeat.o(151419);
    return false;
  }
  
  private static boolean a(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(151420);
    if (paramSet.contains(paramString))
    {
      AppMethodBeat.o(151420);
      return true;
    }
    AppMethodBeat.o(151420);
    return false;
  }
  
  public static boolean axU(String paramString)
  {
    AppMethodBeat.i(151416);
    if (!init())
    {
      AppMethodBeat.o(151416);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(151416);
      return false;
    }
    paramString = paramString.trim();
    if ((!a(paramString, BDA)) && (!E(paramString, BDy)))
    {
      AppMethodBeat.o(151416);
      return false;
    }
    if ((a(paramString, BDB)) || (E(paramString, BDz)))
    {
      f.m(903L, 121L, 1L);
      Log.i("UrlDispatcher", "dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(151416);
      return false;
    }
    f.m(903L, 120L, 1L);
    Log.i("UrlDispatcher", "dispatch to toolsmp suc, host = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(151416);
    return true;
  }
  
  private static List<String> axV(String paramString)
  {
    AppMethodBeat.i(151418);
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(151418);
      return localArrayList;
    }
    paramString = paramString.split(",");
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(151418);
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
    AppMethodBeat.o(151418);
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
    //   5: ldc 154
    //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 156	com/tencent/xweb/n:BDC	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 154
    //   18: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_0
    //   25: ireturn
    //   26: ldc 158
    //   28: ldc 160
    //   30: invokestatic 166	com/tencent/xweb/a:iW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 168
    //   36: ldc 160
    //   38: invokestatic 166	com/tencent/xweb/a:iW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_2
    //   42: ldc 170
    //   44: ldc 160
    //   46: invokestatic 166	com/tencent/xweb/a:iW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_3
    //   50: ldc 172
    //   52: ldc 160
    //   54: invokestatic 166	com/tencent/xweb/a:iW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 4
    //   59: getstatic 30	com/tencent/xweb/n:BDy	Ljava/util/List;
    //   62: aload_1
    //   63: invokestatic 174	com/tencent/xweb/n:axV	(Ljava/lang/String;)Ljava/util/List;
    //   66: invokeinterface 178 2 0
    //   71: pop
    //   72: getstatic 32	com/tencent/xweb/n:BDz	Ljava/util/List;
    //   75: aload_2
    //   76: invokestatic 174	com/tencent/xweb/n:axV	(Ljava/lang/String;)Ljava/util/List;
    //   79: invokeinterface 178 2 0
    //   84: pop
    //   85: getstatic 37	com/tencent/xweb/n:BDA	Ljava/util/HashSet;
    //   88: aload_3
    //   89: invokestatic 174	com/tencent/xweb/n:axV	(Ljava/lang/String;)Ljava/util/List;
    //   92: invokevirtual 179	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   95: pop
    //   96: getstatic 39	com/tencent/xweb/n:BDB	Ljava/util/HashSet;
    //   99: aload 4
    //   101: invokestatic 174	com/tencent/xweb/n:axV	(Ljava/lang/String;)Ljava/util/List;
    //   104: invokevirtual 179	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   107: pop
    //   108: iconst_1
    //   109: putstatic 156	com/tencent/xweb/n:BDC	Z
    //   112: getstatic 156	com/tencent/xweb/n:BDC	Z
    //   115: istore_0
    //   116: ldc 154
    //   118: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: goto -100 -> 21
    //   124: astore_1
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: ldc 119
    //   133: ldc 181
    //   135: invokestatic 184	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.n
 * JD-Core Version:    0.7.0.1
 */