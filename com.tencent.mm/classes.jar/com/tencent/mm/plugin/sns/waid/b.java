package com.tencent.mm.plugin.sns.waid;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
{
  public static String bbr(String paramString)
  {
    AppMethodBeat.i(306350);
    if (TextUtils.isEmpty(paramString))
    {
      Log.d("ad.waid.WaidHelper", "getAppWaid, pkg is empty");
      AppMethodBeat.o(306350);
      return "";
    }
    if (!htg())
    {
      Log.w("ad.waid.WaidHelper", "getAppWaid, isInnerExptWaidEnable==false");
      AppMethodBeat.o(306350);
      return "";
    }
    paramString = bbs(paramString);
    AppMethodBeat.o(306350);
    return paramString;
  }
  
  public static String bbs(String paramString)
  {
    try
    {
      AppMethodBeat.i(306357);
      try
      {
        long l = System.currentTimeMillis();
        String str = mX(paramString, htc());
        Log.i("ad.waid.WaidHelper", "doGetAppWaid pkg=" + paramString + ", appWaid=" + str + ", timeCost=" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(306357);
        paramString = str;
      }
      finally
      {
        for (;;)
        {
          paramString = finally;
          Log.e("ad.waid.WaidHelper", "doGetAppWaid exp=" + paramString.toString());
          paramString = "";
          AppMethodBeat.o(306357);
        }
      }
      return paramString;
    }
    finally {}
  }
  
  private static String bbt(String paramString)
  {
    AppMethodBeat.i(306367);
    paramString = Util.nullAsNil(paramString).replace(" ", "_");
    AppMethodBeat.o(306367);
    return paramString;
  }
  
  /* Error */
  private static String htc()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 112
    //   4: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 64	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 114
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: getstatic 120	android/os/Build:BRAND	Ljava/lang/String;
    //   19: invokestatic 122	com/tencent/mm/plugin/sns/waid/b:bbt	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 105
    //   27: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokestatic 127	com/tencent/mm/compatible/deviceinfo/q:aPo	()Ljava/lang/String;
    //   33: invokestatic 122	com/tencent/mm/plugin/sns/waid/b:bbt	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: ldc 129
    //   46: invokestatic 135	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   49: aload 6
    //   51: ldc 34
    //   53: invokevirtual 138	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 5
    //   58: getstatic 144	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   61: invokevirtual 147	com/tencent/mm/plugin/normsg/a/d:gtJ	()Ljava/lang/String;
    //   64: astore 4
    //   66: ldc 21
    //   68: new 64	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 149
    //   74: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload 6
    //   79: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 151
    //   84: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 4
    //   89: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 153
    //   94: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 5
    //   99: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 5
    //   110: astore_3
    //   111: aload 5
    //   113: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifeq +81 -> 197
    //   119: aload 5
    //   121: astore_3
    //   122: aload 4
    //   124: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +70 -> 197
    //   130: aload 6
    //   132: aload 4
    //   134: invokestatic 156	com/tencent/mm/plugin/sns/waid/b:mY	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: invokestatic 159	com/tencent/mm/plugin/sns/waid/b:htd	()Ljava/lang/String;
    //   140: astore_3
    //   141: invokestatic 163	com/tencent/mm/plugin/sns/waid/b:hte	()I
    //   144: istore_1
    //   145: ldc 21
    //   147: new 64	java/lang/StringBuilder
    //   150: dup
    //   151: ldc 165
    //   153: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload 6
    //   158: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 167
    //   163: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_1
    //   167: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: iload_1
    //   177: iconst_1
    //   178: if_icmple +228 -> 406
    //   181: invokestatic 173	com/tencent/mm/plugin/sns/waid/b:hti	()Z
    //   184: ifne +146 -> 330
    //   187: ldc 175
    //   189: ldc 177
    //   191: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 4
    //   196: astore_3
    //   197: aload_3
    //   198: astore 5
    //   200: aload_3
    //   201: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +118 -> 322
    //   207: aload_3
    //   208: astore 5
    //   210: aload 4
    //   212: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +107 -> 322
    //   218: aload_3
    //   219: astore 5
    //   221: aload_3
    //   222: aload 4
    //   224: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifne +95 -> 322
    //   230: invokestatic 184	com/tencent/mm/plugin/sns/waid/b:hth	()Z
    //   233: istore_2
    //   234: ldc 21
    //   236: new 64	java/lang/StringBuilder
    //   239: dup
    //   240: ldc 186
    //   242: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload 6
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 153
    //   252: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_3
    //   256: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc 151
    //   261: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 4
    //   266: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 188
    //   271: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload_2
    //   275: invokevirtual 191	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   278: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: iload_2
    //   285: ifeq +13 -> 298
    //   288: aload 6
    //   290: aload 4
    //   292: invokestatic 156	com/tencent/mm/plugin/sns/waid/b:mY	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 4
    //   297: astore_3
    //   298: invokestatic 163	com/tencent/mm/plugin/sns/waid/b:hte	()I
    //   301: istore_1
    //   302: iload_2
    //   303: ifeq +109 -> 412
    //   306: invokestatic 173	com/tencent/mm/plugin/sns/waid/b:hti	()Z
    //   309: ifne +108 -> 417
    //   312: ldc 175
    //   314: ldc 193
    //   316: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_3
    //   320: astore 5
    //   322: ldc 112
    //   324: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload 5
    //   329: areturn
    //   330: aload_3
    //   331: invokestatic 198	com/tencent/mm/plugin/sns/waid/c:bbu	(Ljava/lang/String;)Ljava/lang/String;
    //   334: astore_3
    //   335: ldc 175
    //   337: ldc 200
    //   339: aload_3
    //   340: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   343: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   346: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: getstatic 213	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   352: sipush 18666
    //   355: iconst_2
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: sipush 2004
    //   364: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: aload_3
    //   371: aastore
    //   372: invokevirtual 222	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   375: aload 4
    //   377: astore_3
    //   378: goto -181 -> 197
    //   381: astore_3
    //   382: ldc 175
    //   384: new 64	java/lang/StringBuilder
    //   387: dup
    //   388: ldc 224
    //   390: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: aload_3
    //   394: invokestatic 230	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   397: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload 4
    //   408: astore_3
    //   409: goto -212 -> 197
    //   412: iconst_0
    //   413: istore_0
    //   414: goto -108 -> 306
    //   417: new 232	org/json/JSONObject
    //   420: dup
    //   421: invokespecial 235	org/json/JSONObject:<init>	()V
    //   424: astore 4
    //   426: aload 4
    //   428: ldc 237
    //   430: iload_0
    //   431: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload 4
    //   437: ldc 243
    //   439: iload_1
    //   440: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 4
    //   446: invokevirtual 244	org/json/JSONObject:toString	()Ljava/lang/String;
    //   449: invokestatic 198	com/tencent/mm/plugin/sns/waid/c:bbu	(Ljava/lang/String;)Ljava/lang/String;
    //   452: astore 4
    //   454: ldc 175
    //   456: ldc 246
    //   458: aload 4
    //   460: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   463: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   466: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: getstatic 213	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   472: sipush 18666
    //   475: iconst_2
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: sipush 2003
    //   484: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: aastore
    //   488: dup
    //   489: iconst_1
    //   490: aload 4
    //   492: aastore
    //   493: invokevirtual 222	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   496: aload_3
    //   497: astore 5
    //   499: goto -177 -> 322
    //   502: astore 4
    //   504: ldc 175
    //   506: new 64	java/lang/StringBuilder
    //   509: dup
    //   510: ldc 248
    //   512: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   515: aload 4
    //   517: invokestatic 230	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   520: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload_3
    //   530: astore 5
    //   532: goto -210 -> 322
    //   535: astore_3
    //   536: ldc 21
    //   538: new 64	java/lang/StringBuilder
    //   541: dup
    //   542: ldc 250
    //   544: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   547: aload_3
    //   548: invokestatic 230	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   551: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: ldc 112
    //   562: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: ldc 34
    //   567: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	430	0	i	int
    //   144	296	1	j	int
    //   233	70	2	bool	boolean
    //   110	268	3	localObject1	Object
    //   381	13	3	localThrowable1	Throwable
    //   408	122	3	localObject2	Object
    //   535	13	3	localThrowable2	Throwable
    //   64	427	4	localObject3	Object
    //   502	14	4	localThrowable3	Throwable
    //   56	475	5	localObject4	Object
    //   42	247	6	str	String
    // Exception table:
    //   from	to	target	type
    //   330	375	381	finally
    //   417	496	502	finally
    //   7	108	535	finally
    //   111	119	535	finally
    //   122	176	535	finally
    //   181	194	535	finally
    //   200	207	535	finally
    //   210	218	535	finally
    //   221	284	535	finally
    //   288	295	535	finally
    //   298	302	535	finally
    //   306	319	535	finally
    //   382	406	535	finally
    //   504	529	535	finally
  }
  
  private static String htd()
  {
    AppMethodBeat.i(306386);
    localObject1 = new JSONObject();
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
      String[] arrayOfString = localMultiProcessMMKV.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          ((JSONObject)localObject1).put(str, localMultiProcessMMKV.getString(str, ""));
          i += 1;
        }
      }
      return localObject1;
    }
    finally
    {
      Log.e("ad.waid.WaidHelper", "dumpKV exp=" + localObject2.toString());
      localObject1 = ((JSONObject)localObject1).toString();
      AppMethodBeat.o(306386);
    }
  }
  
  private static int hte()
  {
    AppMethodBeat.i(306389);
    try
    {
      String[] arrayOfString = MultiProcessMMKV.getMMKV("ad_id_kv_pref").allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(306389);
        return 0;
      }
      int i = arrayOfString.length;
      AppMethodBeat.o(306389);
      return i;
    }
    finally
    {
      Log.e("ad.waid.WaidHelper", "getKVCount exp=" + localObject.toString());
      AppMethodBeat.o(306389);
    }
    return 0;
  }
  
  public static boolean htf()
  {
    AppMethodBeat.i(306393);
    try
    {
      if (((c)h.ax(c.class)).a(c.a.yHT, 0) > 0)
      {
        AppMethodBeat.o(306393);
        return true;
      }
      AppMethodBeat.o(306393);
      return false;
    }
    finally
    {
      Log.e("ad.waid.WaidHelper", "isExptWaidEnable, exp=" + localObject.toString());
      AppMethodBeat.o(306393);
    }
    return false;
  }
  
  private static boolean htg()
  {
    AppMethodBeat.i(306396);
    try
    {
      if (((c)h.ax(c.class)).a(c.a.yHS, 1) > 0)
      {
        AppMethodBeat.o(306396);
        return true;
      }
      AppMethodBeat.o(306396);
      return false;
    }
    finally
    {
      Log.e("ad.waid.WaidHelper", "isInnerExptWaidEnable, exp=" + localObject.toString());
      AppMethodBeat.o(306396);
    }
    return false;
  }
  
  private static boolean hth()
  {
    AppMethodBeat.i(306399);
    try
    {
      if (((c)h.ax(c.class)).a(c.a.yHU, 0) > 0)
      {
        AppMethodBeat.o(306399);
        return true;
      }
      AppMethodBeat.o(306399);
      return false;
    }
    finally
    {
      Log.e("ad.waid.WaidHelper", "isExptWaidNeedUpdate, exp=" + localObject.toString());
      AppMethodBeat.o(306399);
    }
    return false;
  }
  
  public static boolean hti()
  {
    AppMethodBeat.i(306404);
    if ((h.baF().mDv) && (h.baC().aZN()))
    {
      AppMethodBeat.o(306404);
      return true;
    }
    AppMethodBeat.o(306404);
    return false;
  }
  
  private static String mX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306372);
    paramString1 = Util.nullAsNil(paramString1).trim();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(306372);
      return "";
    }
    paramString1 = paramString1.toLowerCase();
    paramString1 = paramString1 + "_" + paramString2;
    try
    {
      paramString1 = g.getMessageDigest(paramString1.getBytes("UTF-8"));
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = "waid".concat(String.valueOf(paramString1));
        AppMethodBeat.o(306372);
        return paramString1;
      }
    }
    finally
    {
      Log.e("ad.waid.WaidHelper", "getAppWaid, exp=" + paramString1.toString());
      AppMethodBeat.o(306372);
    }
    return "";
  }
  
  private static void mY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306376);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(306376);
      return;
    }
    paramString2 = Util.nullAsNil(paramString2);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
    int i = hte();
    if (i >= 10)
    {
      localMultiProcessMMKV.clear().commit();
      Log.e("ad.waid.WaidHelper", "saveKVString, clearKv, kvCOunt=".concat(String.valueOf(i)));
    }
    localMultiProcessMMKV.edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(306376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.b
 * JD-Core Version:    0.7.0.1
 */