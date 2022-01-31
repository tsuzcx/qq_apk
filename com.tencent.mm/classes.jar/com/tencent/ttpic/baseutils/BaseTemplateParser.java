package com.tencent.ttpic.baseutils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.device.DeviceCoffee;
import com.tencent.ttpic.util.Coffee;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.json.JSONObject;

public class BaseTemplateParser
{
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  public static final String POSTFIX_ORIG = "xml";
  private static final String POSTFIX_TXT = "txt";
  public static final String POSTFIX_WMC = "wmc";
  
  private static int RGBAStr2Int(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int k = 1;
    AppMethodBeat.i(49587);
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(49587);
      return 0;
    }
    int i1 = Integer.parseInt(paramString4);
    int j = Integer.parseInt(paramString1);
    int n = Integer.parseInt(paramString2);
    int m = Integer.parseInt(paramString3);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    j = n;
    if (n == 0) {
      j = 1;
    }
    if (m == 0) {}
    for (;;)
    {
      i = Color.argb(i1, i, j, k);
      AppMethodBeat.o(49587);
      return i;
      k = m;
    }
  }
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(49586);
    paramInputStream = IOUtils.toByteArray(paramInputStream);
    if (paramBoolean) {}
    for (paramInputStream = Coffee.drink_ios(paramInputStream, Coffee.getDefaultSign());; paramInputStream = Coffee.drink(paramInputStream, Coffee.getDefaultSign()))
    {
      paramInputStream = IOUtils.toInputStream(paramInputStream);
      AppMethodBeat.o(49586);
      return paramInputStream;
    }
  }
  
  private static InputStream drinkACupOfCoffeeForCamera(InputStream paramInputStream, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49588);
    paramInputStream = new ByteArrayInputStream(DeviceCoffee.drink(IOUtils.toByteArray(paramInputStream), paramString1, paramString2));
    AppMethodBeat.o(49588);
    return paramInputStream;
  }
  
  private static InputStream drinkACupOfCoffeeForFast(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(49590);
    paramInputStream = new ByteArrayInputStream(DeviceCoffee.drinkRawData(IOUtils.toByteArray(paramInputStream), paramString));
    AppMethodBeat.o(49590);
    return paramInputStream;
  }
  
  /* Error */
  public static String parseCameraAttrsFile(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 109
    //   7: ldc 111
    //   9: aload_1
    //   10: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 121	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: new 129	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 136	java/io/File:exists	()Z
    //   34: ifeq +156 -> 190
    //   37: aload 4
    //   39: invokevirtual 139	java/io/File:isFile	()Z
    //   42: ifeq +148 -> 190
    //   45: ldc 109
    //   47: ldc 141
    //   49: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: new 143	java/io/FileInputStream
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_0
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: invokestatic 148	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   68: astore_1
    //   69: aload_0
    //   70: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: astore 4
    //   76: aload_0
    //   77: astore_3
    //   78: aload 4
    //   80: ifnull +598 -> 678
    //   83: new 154	java/io/InputStreamReader
    //   86: dup
    //   87: aload 4
    //   89: invokespecial 156	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   92: astore_0
    //   93: new 158	java/io/BufferedReader
    //   96: dup
    //   97: aload_0
    //   98: sipush 1024
    //   101: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   104: astore_1
    //   105: new 163	java/lang/StringBuffer
    //   108: dup
    //   109: invokespecial 164	java/lang/StringBuffer:<init>	()V
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +195 -> 316
    //   124: aload_2
    //   125: aload 5
    //   127: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   130: pop
    //   131: goto -18 -> 113
    //   134: astore 5
    //   136: aload_1
    //   137: astore_2
    //   138: aload_0
    //   139: astore_1
    //   140: aload 5
    //   142: astore_0
    //   143: aload_0
    //   144: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 178	java/io/BufferedReader:close	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 182	java/io/InputStream:close	()V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 183	java/io/FileInputStream:close	()V
    //   181: aconst_null
    //   182: astore_1
    //   183: ldc 107
    //   185: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: areturn
    //   190: ldc 109
    //   192: ldc 185
    //   194: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_0
    //   198: ifnull +506 -> 704
    //   201: aload_0
    //   202: invokevirtual 191	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   205: aload_1
    //   206: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   209: astore_1
    //   210: aload_1
    //   211: aload_2
    //   212: aload_3
    //   213: invokestatic 148	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   216: astore_0
    //   217: aload_1
    //   218: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   221: aload_1
    //   222: astore_3
    //   223: aload_3
    //   224: ifnull +472 -> 696
    //   227: aload_0
    //   228: astore_1
    //   229: aload_0
    //   230: astore_2
    //   231: aload_3
    //   232: invokevirtual 182	java/io/InputStream:close	()V
    //   235: aconst_null
    //   236: astore_3
    //   237: aload_0
    //   238: astore 4
    //   240: goto -162 -> 78
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_0
    //   248: aload_1
    //   249: ifnull +439 -> 688
    //   252: aload_1
    //   253: invokevirtual 182	java/io/InputStream:close	()V
    //   256: aconst_null
    //   257: astore_3
    //   258: aload_0
    //   259: astore 4
    //   261: goto -183 -> 78
    //   264: astore_3
    //   265: aconst_null
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_0
    //   270: aload 4
    //   272: ifnull +12 -> 284
    //   275: aload_0
    //   276: astore_1
    //   277: aload_0
    //   278: astore_2
    //   279: aload 4
    //   281: invokevirtual 182	java/io/InputStream:close	()V
    //   284: aload_0
    //   285: astore_1
    //   286: aload_0
    //   287: astore_2
    //   288: ldc 107
    //   290: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload_0
    //   294: astore_1
    //   295: aload_0
    //   296: astore_2
    //   297: aload_3
    //   298: athrow
    //   299: astore_0
    //   300: aconst_null
    //   301: astore_3
    //   302: aconst_null
    //   303: astore 5
    //   305: aconst_null
    //   306: astore_2
    //   307: aload_1
    //   308: astore 4
    //   310: aload 5
    //   312: astore_1
    //   313: goto -170 -> 143
    //   316: aload_2
    //   317: invokevirtual 200	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   320: astore_2
    //   321: aload_1
    //   322: astore 5
    //   324: aload_0
    //   325: astore_1
    //   326: aload_2
    //   327: astore_0
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 178	java/io/BufferedReader:close	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 182	java/io/InputStream:close	()V
    //   356: aload_0
    //   357: astore_1
    //   358: aload_3
    //   359: ifnull -176 -> 183
    //   362: aload_3
    //   363: invokevirtual 183	java/io/FileInputStream:close	()V
    //   366: aload_0
    //   367: astore_1
    //   368: goto -185 -> 183
    //   371: astore_1
    //   372: aload_1
    //   373: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   376: aload_0
    //   377: astore_1
    //   378: goto -195 -> 183
    //   381: astore_0
    //   382: aload_0
    //   383: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   386: aconst_null
    //   387: astore_1
    //   388: goto -205 -> 183
    //   391: astore_0
    //   392: aconst_null
    //   393: astore_3
    //   394: aconst_null
    //   395: astore_1
    //   396: aconst_null
    //   397: astore_2
    //   398: aconst_null
    //   399: astore 4
    //   401: aload_2
    //   402: ifnull +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 178	java/io/BufferedReader:close	()V
    //   409: aload_1
    //   410: ifnull +7 -> 417
    //   413: aload_1
    //   414: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   417: aload 4
    //   419: ifnull +8 -> 427
    //   422: aload 4
    //   424: invokevirtual 182	java/io/InputStream:close	()V
    //   427: aload_3
    //   428: ifnull +7 -> 435
    //   431: aload_3
    //   432: invokevirtual 183	java/io/FileInputStream:close	()V
    //   435: ldc 107
    //   437: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_0
    //   441: athrow
    //   442: astore_1
    //   443: aload_1
    //   444: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   447: goto -12 -> 435
    //   450: astore 5
    //   452: aload_0
    //   453: astore_3
    //   454: aconst_null
    //   455: astore_1
    //   456: aconst_null
    //   457: astore_2
    //   458: aconst_null
    //   459: astore 4
    //   461: aload 5
    //   463: astore_0
    //   464: goto -63 -> 401
    //   467: astore 6
    //   469: aload_0
    //   470: astore_3
    //   471: aconst_null
    //   472: astore 5
    //   474: aconst_null
    //   475: astore_2
    //   476: aload_1
    //   477: astore 4
    //   479: aload 6
    //   481: astore_0
    //   482: aload 5
    //   484: astore_1
    //   485: goto -84 -> 401
    //   488: astore_0
    //   489: aconst_null
    //   490: astore_3
    //   491: aconst_null
    //   492: astore_1
    //   493: aconst_null
    //   494: astore 5
    //   496: aload_2
    //   497: astore 4
    //   499: aload 5
    //   501: astore_2
    //   502: goto -101 -> 401
    //   505: astore 5
    //   507: aconst_null
    //   508: astore_3
    //   509: aconst_null
    //   510: astore_1
    //   511: aconst_null
    //   512: astore_2
    //   513: aload_0
    //   514: astore 4
    //   516: aload 5
    //   518: astore_0
    //   519: goto -118 -> 401
    //   522: astore_0
    //   523: aconst_null
    //   524: astore_1
    //   525: aconst_null
    //   526: astore_2
    //   527: goto -126 -> 401
    //   530: astore 5
    //   532: aload_0
    //   533: astore_1
    //   534: aconst_null
    //   535: astore_2
    //   536: aload 5
    //   538: astore_0
    //   539: goto -138 -> 401
    //   542: astore 6
    //   544: aload_0
    //   545: astore_2
    //   546: aload_1
    //   547: astore 5
    //   549: aload 6
    //   551: astore_0
    //   552: aload_2
    //   553: astore_1
    //   554: aload 5
    //   556: astore_2
    //   557: goto -156 -> 401
    //   560: astore_0
    //   561: goto -160 -> 401
    //   564: astore_0
    //   565: aconst_null
    //   566: astore_3
    //   567: aconst_null
    //   568: astore_1
    //   569: aconst_null
    //   570: astore_2
    //   571: aconst_null
    //   572: astore 4
    //   574: goto -431 -> 143
    //   577: astore 5
    //   579: aload_0
    //   580: astore_3
    //   581: aconst_null
    //   582: astore_1
    //   583: aconst_null
    //   584: astore_2
    //   585: aconst_null
    //   586: astore 4
    //   588: aload 5
    //   590: astore_0
    //   591: goto -448 -> 143
    //   594: astore 6
    //   596: aload_0
    //   597: astore_3
    //   598: aconst_null
    //   599: astore 5
    //   601: aconst_null
    //   602: astore_2
    //   603: aload_1
    //   604: astore 4
    //   606: aload 6
    //   608: astore_0
    //   609: aload 5
    //   611: astore_1
    //   612: goto -469 -> 143
    //   615: astore 5
    //   617: aconst_null
    //   618: astore_3
    //   619: aconst_null
    //   620: astore_1
    //   621: aconst_null
    //   622: astore_2
    //   623: aload_0
    //   624: astore 4
    //   626: aload 5
    //   628: astore_0
    //   629: goto -486 -> 143
    //   632: astore_0
    //   633: aconst_null
    //   634: astore_1
    //   635: aconst_null
    //   636: astore_2
    //   637: goto -494 -> 143
    //   640: astore 5
    //   642: aload_0
    //   643: astore_1
    //   644: aconst_null
    //   645: astore_2
    //   646: aload 5
    //   648: astore_0
    //   649: goto -506 -> 143
    //   652: astore_3
    //   653: aconst_null
    //   654: astore_0
    //   655: aload_1
    //   656: astore 4
    //   658: goto -388 -> 270
    //   661: astore_3
    //   662: aload_1
    //   663: astore 4
    //   665: goto -395 -> 270
    //   668: astore_0
    //   669: aconst_null
    //   670: astore_0
    //   671: goto -423 -> 248
    //   674: astore_2
    //   675: goto -427 -> 248
    //   678: aconst_null
    //   679: astore_1
    //   680: aconst_null
    //   681: astore 5
    //   683: aconst_null
    //   684: astore_0
    //   685: goto -357 -> 328
    //   688: aconst_null
    //   689: astore_3
    //   690: aload_0
    //   691: astore 4
    //   693: goto -615 -> 78
    //   696: aconst_null
    //   697: astore_3
    //   698: aload_0
    //   699: astore 4
    //   701: goto -623 -> 78
    //   704: aconst_null
    //   705: astore_3
    //   706: aconst_null
    //   707: astore_0
    //   708: goto -485 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	paramContext	Context
    //   0	711	1	paramString1	String
    //   0	711	2	paramString2	String
    //   0	711	3	paramString3	String
    //   27	673	4	localObject1	Object
    //   117	9	5	str1	String
    //   134	7	5	localException1	java.lang.Exception
    //   303	31	5	str2	String
    //   450	12	5	localObject2	Object
    //   472	28	5	localObject3	Object
    //   505	12	5	localObject4	Object
    //   530	7	5	localObject5	Object
    //   547	8	5	str3	String
    //   577	12	5	localException2	java.lang.Exception
    //   599	11	5	localObject6	Object
    //   615	12	5	localException3	java.lang.Exception
    //   640	7	5	localException4	java.lang.Exception
    //   681	1	5	localObject7	Object
    //   467	13	6	localObject8	Object
    //   542	8	6	localObject9	Object
    //   594	13	6	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   105	113	134	java/lang/Exception
    //   113	119	134	java/lang/Exception
    //   124	131	134	java/lang/Exception
    //   316	321	134	java/lang/Exception
    //   201	210	243	java/io/IOException
    //   201	210	264	finally
    //   231	235	299	java/lang/Exception
    //   279	284	299	java/lang/Exception
    //   288	293	299	java/lang/Exception
    //   297	299	299	java/lang/Exception
    //   333	338	371	java/io/IOException
    //   342	346	371	java/io/IOException
    //   351	356	371	java/io/IOException
    //   362	366	371	java/io/IOException
    //   151	155	381	java/io/IOException
    //   159	163	381	java/io/IOException
    //   168	173	381	java/io/IOException
    //   177	181	381	java/io/IOException
    //   19	62	391	finally
    //   190	197	391	finally
    //   405	409	442	java/io/IOException
    //   413	417	442	java/io/IOException
    //   422	427	442	java/io/IOException
    //   431	435	442	java/io/IOException
    //   62	69	450	finally
    //   69	73	467	finally
    //   231	235	488	finally
    //   279	284	488	finally
    //   288	293	488	finally
    //   297	299	488	finally
    //   252	256	505	finally
    //   83	93	522	finally
    //   93	105	530	finally
    //   105	113	542	finally
    //   113	119	542	finally
    //   124	131	542	finally
    //   316	321	542	finally
    //   143	147	560	finally
    //   19	62	564	java/lang/Exception
    //   190	197	564	java/lang/Exception
    //   62	69	577	java/lang/Exception
    //   69	73	594	java/lang/Exception
    //   252	256	615	java/lang/Exception
    //   83	93	632	java/lang/Exception
    //   93	105	640	java/lang/Exception
    //   210	217	652	finally
    //   217	221	661	finally
    //   210	217	668	java/io/IOException
    //   217	221	674	java/io/IOException
  }
  
  /* Error */
  public static String parseFastCaptureFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 203
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 109
    //   7: ldc 205
    //   9: aload_1
    //   10: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 121	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 109
    //   21: ldc 207
    //   23: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: ifnull +450 -> 477
    //   30: aload_0
    //   31: invokevirtual 191	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   34: aload_1
    //   35: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: aload_0
    //   40: aload_2
    //   41: invokestatic 209	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffeeForFast	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   49: aload_0
    //   50: astore_2
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: ifnull +15 -> 69
    //   57: aload_1
    //   58: astore 4
    //   60: aload_1
    //   61: astore 5
    //   63: aload_2
    //   64: invokevirtual 182	java/io/InputStream:close	()V
    //   67: aload_1
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +394 -> 464
    //   73: aload_0
    //   74: astore 4
    //   76: aload_0
    //   77: astore 5
    //   79: new 154	java/io/InputStreamReader
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 156	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: astore_1
    //   88: new 158	java/io/BufferedReader
    //   91: dup
    //   92: aload_1
    //   93: sipush 1024
    //   96: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   99: astore_3
    //   100: new 163	java/lang/StringBuffer
    //   103: dup
    //   104: invokespecial 164	java/lang/StringBuffer:<init>	()V
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 4
    //   114: aload 4
    //   116: ifnull +122 -> 238
    //   119: aload_2
    //   120: aload 4
    //   122: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   125: pop
    //   126: goto -18 -> 108
    //   129: astore 4
    //   131: aload_1
    //   132: astore_2
    //   133: aload 4
    //   135: astore_1
    //   136: aload_1
    //   137: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 178	java/io/BufferedReader:close	()V
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 182	java/io/InputStream:close	()V
    //   164: aconst_null
    //   165: astore_2
    //   166: ldc 203
    //   168: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: areturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_2
    //   179: ifnull +295 -> 474
    //   182: aload_2
    //   183: invokevirtual 182	java/io/InputStream:close	()V
    //   186: goto -117 -> 69
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_2
    //   195: ifnull +13 -> 208
    //   198: aload_0
    //   199: astore 4
    //   201: aload_0
    //   202: astore 5
    //   204: aload_2
    //   205: invokevirtual 182	java/io/InputStream:close	()V
    //   208: aload_0
    //   209: astore 4
    //   211: aload_0
    //   212: astore 5
    //   214: ldc 203
    //   216: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_0
    //   220: astore 4
    //   222: aload_0
    //   223: astore 5
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_2
    //   230: aconst_null
    //   231: astore_3
    //   232: aload 4
    //   234: astore_0
    //   235: goto -99 -> 136
    //   238: aload_2
    //   239: invokevirtual 200	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   242: astore_2
    //   243: aload_3
    //   244: astore 4
    //   246: aload_1
    //   247: astore_3
    //   248: aload_2
    //   249: astore_1
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 178	java/io/BufferedReader:close	()V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   268: aload_1
    //   269: astore_2
    //   270: aload_0
    //   271: ifnull -105 -> 166
    //   274: aload_0
    //   275: invokevirtual 182	java/io/InputStream:close	()V
    //   278: aload_1
    //   279: astore_2
    //   280: goto -114 -> 166
    //   283: astore_0
    //   284: aload_0
    //   285: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   288: aload_1
    //   289: astore_2
    //   290: goto -124 -> 166
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -134 -> 166
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_0
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 178	java/io/BufferedReader:close	()V
    //   318: aload_2
    //   319: ifnull +7 -> 326
    //   322: aload_2
    //   323: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   326: aload_0
    //   327: ifnull +7 -> 334
    //   330: aload_0
    //   331: invokevirtual 182	java/io/InputStream:close	()V
    //   334: ldc 203
    //   336: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_1
    //   340: athrow
    //   341: astore_0
    //   342: aload_0
    //   343: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   346: goto -12 -> 334
    //   349: astore_1
    //   350: aconst_null
    //   351: astore_2
    //   352: aconst_null
    //   353: astore_3
    //   354: aload 5
    //   356: astore_0
    //   357: goto -47 -> 310
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_3
    //   365: goto -55 -> 310
    //   368: astore 4
    //   370: aload_1
    //   371: astore_2
    //   372: aconst_null
    //   373: astore_3
    //   374: aload 4
    //   376: astore_1
    //   377: goto -67 -> 310
    //   380: astore 4
    //   382: aload_1
    //   383: astore_2
    //   384: aload 4
    //   386: astore_1
    //   387: goto -77 -> 310
    //   390: astore_1
    //   391: goto -81 -> 310
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_2
    //   397: aconst_null
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_0
    //   401: goto -265 -> 136
    //   404: astore_1
    //   405: aconst_null
    //   406: astore_2
    //   407: aconst_null
    //   408: astore_3
    //   409: goto -273 -> 136
    //   412: astore 4
    //   414: aload_1
    //   415: astore_2
    //   416: aconst_null
    //   417: astore_3
    //   418: aload 4
    //   420: astore_1
    //   421: goto -285 -> 136
    //   424: astore_1
    //   425: aconst_null
    //   426: astore_3
    //   427: aload_0
    //   428: astore_2
    //   429: aload_3
    //   430: astore_0
    //   431: goto -237 -> 194
    //   434: astore_2
    //   435: aload_1
    //   436: astore_3
    //   437: aload_2
    //   438: astore_1
    //   439: aload_0
    //   440: astore_2
    //   441: aload_3
    //   442: astore_0
    //   443: goto -249 -> 194
    //   446: astore_1
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_0
    //   450: astore_2
    //   451: aload_1
    //   452: astore_0
    //   453: goto -275 -> 178
    //   456: astore_2
    //   457: aload_0
    //   458: astore_2
    //   459: aload_1
    //   460: astore_0
    //   461: goto -283 -> 178
    //   464: aconst_null
    //   465: astore_3
    //   466: aconst_null
    //   467: astore 4
    //   469: aconst_null
    //   470: astore_1
    //   471: goto -221 -> 250
    //   474: goto -405 -> 69
    //   477: aconst_null
    //   478: astore_2
    //   479: aconst_null
    //   480: astore_1
    //   481: goto -430 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramString1	String
    //   0	484	2	paramString2	String
    //   99	367	3	localObject1	Object
    //   58	63	4	localObject2	Object
    //   129	5	4	localException1	java.lang.Exception
    //   199	57	4	localObject3	Object
    //   368	7	4	localObject4	Object
    //   380	5	4	localObject5	Object
    //   412	7	4	localException2	java.lang.Exception
    //   467	1	4	localObject6	Object
    //   61	294	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   100	108	129	java/lang/Exception
    //   108	114	129	java/lang/Exception
    //   119	126	129	java/lang/Exception
    //   238	243	129	java/lang/Exception
    //   30	39	173	java/io/IOException
    //   30	39	189	finally
    //   63	67	227	java/lang/Exception
    //   79	88	227	java/lang/Exception
    //   204	208	227	java/lang/Exception
    //   214	219	227	java/lang/Exception
    //   225	227	227	java/lang/Exception
    //   255	260	283	java/io/IOException
    //   264	268	283	java/io/IOException
    //   274	278	283	java/io/IOException
    //   144	148	293	java/io/IOException
    //   152	156	293	java/io/IOException
    //   160	164	293	java/io/IOException
    //   19	26	303	finally
    //   314	318	341	java/io/IOException
    //   322	326	341	java/io/IOException
    //   330	334	341	java/io/IOException
    //   63	67	349	finally
    //   79	88	349	finally
    //   204	208	349	finally
    //   214	219	349	finally
    //   225	227	349	finally
    //   182	186	360	finally
    //   88	100	368	finally
    //   100	108	380	finally
    //   108	114	380	finally
    //   119	126	380	finally
    //   238	243	380	finally
    //   136	140	390	finally
    //   19	26	394	java/lang/Exception
    //   182	186	404	java/lang/Exception
    //   88	100	412	java/lang/Exception
    //   39	45	424	finally
    //   45	49	434	finally
    //   39	45	446	java/io/IOException
    //   45	49	456	java/io/IOException
  }
  
  public static JSONObject parseFile(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(49583);
    if (paramBoolean)
    {
      paramContext = parseIOSFileProcess(paramContext, paramString1, paramString2, false);
      AppMethodBeat.o(49583);
      return paramContext;
    }
    paramContext = parseFileProcess(paramContext, paramString1, paramString2, false);
    AppMethodBeat.o(49583);
    return paramContext;
  }
  
  /* Error */
  private static JSONObject parseFileProcess(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 219
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 221	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 227
    //   18: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 229
    //   27: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: astore 6
    //   32: iload_3
    //   33: ifeq +285 -> 318
    //   36: ldc 14
    //   38: astore 5
    //   40: aload 6
    //   42: aload 5
    //   44: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 5
    //   52: new 221	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   59: aload_1
    //   60: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 227
    //   65: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_2
    //   69: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 229
    //   74: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: astore_2
    //   78: iload_3
    //   79: ifne +246 -> 325
    //   82: ldc 14
    //   84: astore_1
    //   85: aload_2
    //   86: aload_1
    //   87: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 7
    //   95: ldc 109
    //   97: ldc 232
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload 5
    //   107: aastore
    //   108: invokestatic 235	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: new 129	java/io/File
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore_1
    //   121: new 129	java/io/File
    //   124: dup
    //   125: aload 7
    //   127: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: astore_2
    //   131: aload_1
    //   132: invokevirtual 136	java/io/File:exists	()Z
    //   135: ifeq +10 -> 145
    //   138: aload_1
    //   139: invokevirtual 139	java/io/File:isFile	()Z
    //   142: ifne +17 -> 159
    //   145: aload_2
    //   146: invokevirtual 136	java/io/File:exists	()Z
    //   149: ifeq +214 -> 363
    //   152: aload_2
    //   153: invokevirtual 139	java/io/File:isFile	()Z
    //   156: ifeq +207 -> 363
    //   159: ldc 109
    //   161: ldc 237
    //   163: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 136	java/io/File:exists	()Z
    //   170: ifeq +161 -> 331
    //   173: aload_1
    //   174: invokevirtual 139	java/io/File:isFile	()Z
    //   177: ifeq +154 -> 331
    //   180: new 143	java/io/FileInputStream
    //   183: dup
    //   184: aload_1
    //   185: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   188: astore_0
    //   189: iload_3
    //   190: ifne +750 -> 940
    //   193: aload_0
    //   194: iconst_0
    //   195: invokestatic 239	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   198: astore_1
    //   199: aload_0
    //   200: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   203: aload_1
    //   204: ifnull +712 -> 916
    //   207: new 154	java/io/InputStreamReader
    //   210: dup
    //   211: aload_1
    //   212: invokespecial 156	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   215: astore_2
    //   216: new 158	java/io/BufferedReader
    //   219: dup
    //   220: aload_2
    //   221: sipush 1024
    //   224: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   227: astore 6
    //   229: new 163	java/lang/StringBuffer
    //   232: dup
    //   233: invokespecial 164	java/lang/StringBuffer:<init>	()V
    //   236: astore 5
    //   238: aload 6
    //   240: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   243: astore 7
    //   245: aload 7
    //   247: ifnull +271 -> 518
    //   250: aload 5
    //   252: aload 7
    //   254: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   257: pop
    //   258: goto -20 -> 238
    //   261: astore 7
    //   263: aload_2
    //   264: astore 5
    //   266: aload 7
    //   268: astore_2
    //   269: aload_2
    //   270: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   273: aload 6
    //   275: ifnull +8 -> 283
    //   278: aload 6
    //   280: invokevirtual 178	java/io/BufferedReader:close	()V
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 182	java/io/InputStream:close	()V
    //   301: aload_0
    //   302: ifnull +7 -> 309
    //   305: aload_0
    //   306: invokevirtual 183	java/io/FileInputStream:close	()V
    //   309: aconst_null
    //   310: astore_1
    //   311: ldc 219
    //   313: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_1
    //   317: areturn
    //   318: ldc 8
    //   320: astore 5
    //   322: goto -282 -> 40
    //   325: ldc 8
    //   327: astore_1
    //   328: goto -243 -> 85
    //   331: aload_2
    //   332: invokevirtual 136	java/io/File:exists	()Z
    //   335: ifeq +592 -> 927
    //   338: aload_2
    //   339: invokevirtual 139	java/io/File:isFile	()Z
    //   342: ifeq +585 -> 927
    //   345: new 143	java/io/FileInputStream
    //   348: dup
    //   349: aload_2
    //   350: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   353: astore_0
    //   354: iload_3
    //   355: ifne +580 -> 935
    //   358: iconst_1
    //   359: istore_3
    //   360: goto +572 -> 932
    //   363: ldc 109
    //   365: ldc 241
    //   367: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_0
    //   371: invokevirtual 191	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   374: aload 5
    //   376: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   379: astore 6
    //   381: iload_3
    //   382: ifne +25 -> 407
    //   385: aload 6
    //   387: iconst_0
    //   388: invokestatic 239	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   391: astore_1
    //   392: aload_1
    //   393: astore_2
    //   394: aload_1
    //   395: astore 5
    //   397: aload 6
    //   399: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   402: aconst_null
    //   403: astore_0
    //   404: goto -201 -> 203
    //   407: aconst_null
    //   408: astore_0
    //   409: aload 6
    //   411: astore_1
    //   412: goto -209 -> 203
    //   415: astore_1
    //   416: aconst_null
    //   417: astore_1
    //   418: iload_3
    //   419: istore 4
    //   421: aload_1
    //   422: astore_2
    //   423: aload_1
    //   424: astore 5
    //   426: aload_0
    //   427: invokevirtual 191	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   430: aload 7
    //   432: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   435: astore 6
    //   437: iload_3
    //   438: ifne +42 -> 480
    //   441: iconst_1
    //   442: istore_3
    //   443: iload_3
    //   444: ifne +41 -> 485
    //   447: iload_3
    //   448: istore 4
    //   450: aload_1
    //   451: astore_2
    //   452: aload_1
    //   453: astore 5
    //   455: aload 6
    //   457: iconst_0
    //   458: invokestatic 239	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   461: astore_0
    //   462: aload_0
    //   463: astore_1
    //   464: aload_0
    //   465: astore_2
    //   466: aload 6
    //   468: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   471: aconst_null
    //   472: astore_2
    //   473: aload_0
    //   474: astore_1
    //   475: aload_2
    //   476: astore_0
    //   477: goto -274 -> 203
    //   480: iconst_0
    //   481: istore_3
    //   482: goto -39 -> 443
    //   485: aconst_null
    //   486: astore_0
    //   487: aload 6
    //   489: astore_1
    //   490: goto -287 -> 203
    //   493: astore 5
    //   495: aload_1
    //   496: astore_0
    //   497: iload 4
    //   499: istore_3
    //   500: aload_0
    //   501: astore_1
    //   502: aload_0
    //   503: astore_2
    //   504: aload 5
    //   506: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   509: aconst_null
    //   510: astore_2
    //   511: aload_0
    //   512: astore_1
    //   513: aload_2
    //   514: astore_0
    //   515: goto -312 -> 203
    //   518: iload_3
    //   519: ifeq +102 -> 621
    //   522: aload 5
    //   524: invokevirtual 200	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   527: invokestatic 247	com/tencent/ttpic/json/XML:toJSONObject	(Ljava/lang/String;)Lcom/tencent/ttpic/json/JSONObject;
    //   530: invokevirtual 250	com/tencent/ttpic/json/JSONObject:toString	()Ljava/lang/String;
    //   533: astore 5
    //   535: ldc 109
    //   537: aload 5
    //   539: invokestatic 253	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload 5
    //   544: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   547: ifne +363 -> 910
    //   550: new 255	org/json/JSONTokener
    //   553: dup
    //   554: aload 5
    //   556: invokespecial 256	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   559: invokevirtual 260	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   562: checkcast 262	org/json/JSONObject
    //   565: astore 5
    //   567: aload 6
    //   569: ifnull +8 -> 577
    //   572: aload 6
    //   574: invokevirtual 178	java/io/BufferedReader:close	()V
    //   577: aload_2
    //   578: ifnull +7 -> 585
    //   581: aload_2
    //   582: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   585: aload_1
    //   586: ifnull +7 -> 593
    //   589: aload_1
    //   590: invokevirtual 182	java/io/InputStream:close	()V
    //   593: aload 5
    //   595: astore_1
    //   596: aload_0
    //   597: ifnull -286 -> 311
    //   600: aload_0
    //   601: invokevirtual 183	java/io/FileInputStream:close	()V
    //   604: aload 5
    //   606: astore_1
    //   607: goto -296 -> 311
    //   610: astore_0
    //   611: aload_0
    //   612: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   615: aload 5
    //   617: astore_1
    //   618: goto -307 -> 311
    //   621: aload 5
    //   623: invokevirtual 200	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   626: astore 5
    //   628: goto -93 -> 535
    //   631: astore_0
    //   632: aload_0
    //   633: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   636: aconst_null
    //   637: astore_1
    //   638: goto -327 -> 311
    //   641: astore_2
    //   642: aconst_null
    //   643: astore_0
    //   644: aconst_null
    //   645: astore 5
    //   647: aconst_null
    //   648: astore 6
    //   650: aconst_null
    //   651: astore_1
    //   652: aload 6
    //   654: ifnull +8 -> 662
    //   657: aload 6
    //   659: invokevirtual 178	java/io/BufferedReader:close	()V
    //   662: aload 5
    //   664: ifnull +8 -> 672
    //   667: aload 5
    //   669: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   672: aload_1
    //   673: ifnull +7 -> 680
    //   676: aload_1
    //   677: invokevirtual 182	java/io/InputStream:close	()V
    //   680: aload_0
    //   681: ifnull +7 -> 688
    //   684: aload_0
    //   685: invokevirtual 183	java/io/FileInputStream:close	()V
    //   688: ldc 219
    //   690: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   693: aload_2
    //   694: athrow
    //   695: astore_0
    //   696: aload_0
    //   697: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   700: goto -12 -> 688
    //   703: astore_2
    //   704: aconst_null
    //   705: astore 5
    //   707: aconst_null
    //   708: astore 6
    //   710: aconst_null
    //   711: astore_1
    //   712: goto -60 -> 652
    //   715: astore_2
    //   716: aconst_null
    //   717: astore 5
    //   719: aconst_null
    //   720: astore 6
    //   722: goto -70 -> 652
    //   725: astore 7
    //   727: aconst_null
    //   728: astore_0
    //   729: aconst_null
    //   730: astore 5
    //   732: aconst_null
    //   733: astore 6
    //   735: aload_2
    //   736: astore_1
    //   737: aload 7
    //   739: astore_2
    //   740: goto -88 -> 652
    //   743: astore_2
    //   744: aconst_null
    //   745: astore_0
    //   746: aconst_null
    //   747: astore 5
    //   749: aconst_null
    //   750: astore 6
    //   752: goto -100 -> 652
    //   755: astore_2
    //   756: aconst_null
    //   757: astore 5
    //   759: aconst_null
    //   760: astore 6
    //   762: goto -110 -> 652
    //   765: astore 6
    //   767: aload_2
    //   768: astore 5
    //   770: aconst_null
    //   771: astore 7
    //   773: aload 6
    //   775: astore_2
    //   776: aload 7
    //   778: astore 6
    //   780: goto -128 -> 652
    //   783: astore 7
    //   785: aload_2
    //   786: astore 5
    //   788: aload 7
    //   790: astore_2
    //   791: goto -139 -> 652
    //   794: astore_2
    //   795: goto -143 -> 652
    //   798: astore_2
    //   799: aconst_null
    //   800: astore_0
    //   801: aconst_null
    //   802: astore 5
    //   804: aconst_null
    //   805: astore 6
    //   807: aconst_null
    //   808: astore_1
    //   809: goto -540 -> 269
    //   812: astore_2
    //   813: aconst_null
    //   814: astore 5
    //   816: aconst_null
    //   817: astore 6
    //   819: aconst_null
    //   820: astore_1
    //   821: goto -552 -> 269
    //   824: astore_2
    //   825: aconst_null
    //   826: astore 5
    //   828: aconst_null
    //   829: astore 6
    //   831: goto -562 -> 269
    //   834: astore_2
    //   835: aconst_null
    //   836: astore_0
    //   837: aconst_null
    //   838: astore 7
    //   840: aconst_null
    //   841: astore 6
    //   843: aload 5
    //   845: astore_1
    //   846: aload 7
    //   848: astore 5
    //   850: goto -581 -> 269
    //   853: astore_0
    //   854: aconst_null
    //   855: astore 7
    //   857: aconst_null
    //   858: astore 5
    //   860: aconst_null
    //   861: astore 6
    //   863: aload_2
    //   864: astore_1
    //   865: aload_0
    //   866: astore_2
    //   867: aload 7
    //   869: astore_0
    //   870: goto -601 -> 269
    //   873: astore_2
    //   874: aconst_null
    //   875: astore 5
    //   877: aconst_null
    //   878: astore 6
    //   880: goto -611 -> 269
    //   883: astore 6
    //   885: aload_2
    //   886: astore 5
    //   888: aconst_null
    //   889: astore 7
    //   891: aload 6
    //   893: astore_2
    //   894: aload 7
    //   896: astore 6
    //   898: goto -629 -> 269
    //   901: astore 5
    //   903: goto -403 -> 500
    //   906: astore_2
    //   907: goto -489 -> 418
    //   910: aconst_null
    //   911: astore 5
    //   913: goto -346 -> 567
    //   916: aconst_null
    //   917: astore_2
    //   918: aconst_null
    //   919: astore 6
    //   921: aconst_null
    //   922: astore 5
    //   924: goto -357 -> 567
    //   927: aconst_null
    //   928: astore_0
    //   929: goto -740 -> 189
    //   932: goto -743 -> 189
    //   935: iconst_0
    //   936: istore_3
    //   937: goto -5 -> 932
    //   940: aload_0
    //   941: astore_1
    //   942: aload_0
    //   943: astore_2
    //   944: aload_1
    //   945: astore_0
    //   946: aload_2
    //   947: astore_1
    //   948: goto -745 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	951	0	paramContext	Context
    //   0	951	1	paramString1	String
    //   0	951	2	paramString2	String
    //   0	951	3	paramBoolean	boolean
    //   419	79	4	bool	boolean
    //   38	416	5	localObject1	Object
    //   493	30	5	localIOException1	java.io.IOException
    //   533	354	5	localObject2	Object
    //   901	1	5	localIOException2	java.io.IOException
    //   911	12	5	localObject3	Object
    //   30	731	6	localObject4	Object
    //   765	9	6	localObject5	Object
    //   778	101	6	localObject6	Object
    //   883	9	6	localException1	java.lang.Exception
    //   896	24	6	localObject7	Object
    //   93	160	7	str	String
    //   261	170	7	localException2	java.lang.Exception
    //   725	13	7	localObject8	Object
    //   771	6	7	localObject9	Object
    //   783	6	7	localObject10	Object
    //   838	57	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   229	238	261	java/lang/Exception
    //   238	245	261	java/lang/Exception
    //   250	258	261	java/lang/Exception
    //   522	535	261	java/lang/Exception
    //   535	567	261	java/lang/Exception
    //   621	628	261	java/lang/Exception
    //   370	381	415	java/io/IOException
    //   385	392	415	java/io/IOException
    //   426	437	493	java/io/IOException
    //   455	462	493	java/io/IOException
    //   572	577	610	java/io/IOException
    //   581	585	610	java/io/IOException
    //   589	593	610	java/io/IOException
    //   600	604	610	java/io/IOException
    //   278	283	631	java/io/IOException
    //   288	293	631	java/io/IOException
    //   297	301	631	java/io/IOException
    //   305	309	631	java/io/IOException
    //   111	145	641	finally
    //   145	159	641	finally
    //   159	189	641	finally
    //   331	354	641	finally
    //   363	370	641	finally
    //   370	381	641	finally
    //   385	392	641	finally
    //   657	662	695	java/io/IOException
    //   667	672	695	java/io/IOException
    //   676	680	695	java/io/IOException
    //   684	688	695	java/io/IOException
    //   193	199	703	finally
    //   199	203	715	finally
    //   397	402	725	finally
    //   426	437	725	finally
    //   455	462	725	finally
    //   466	471	743	finally
    //   504	509	743	finally
    //   207	216	755	finally
    //   216	229	765	finally
    //   229	238	783	finally
    //   238	245	783	finally
    //   250	258	783	finally
    //   522	535	783	finally
    //   535	567	783	finally
    //   621	628	783	finally
    //   269	273	794	finally
    //   111	145	798	java/lang/Exception
    //   145	159	798	java/lang/Exception
    //   159	189	798	java/lang/Exception
    //   331	354	798	java/lang/Exception
    //   363	370	798	java/lang/Exception
    //   370	381	798	java/lang/Exception
    //   385	392	798	java/lang/Exception
    //   193	199	812	java/lang/Exception
    //   199	203	824	java/lang/Exception
    //   397	402	834	java/lang/Exception
    //   426	437	834	java/lang/Exception
    //   455	462	834	java/lang/Exception
    //   466	471	853	java/lang/Exception
    //   504	509	853	java/lang/Exception
    //   207	216	873	java/lang/Exception
    //   216	229	883	java/lang/Exception
    //   466	471	901	java/io/IOException
    //   397	402	906	java/io/IOException
  }
  
  /* Error */
  private static JSONObject parseIOSFileProcess(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 221	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 227
    //   19: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_2
    //   23: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 229
    //   28: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: astore 6
    //   33: iload_3
    //   34: ifeq +270 -> 304
    //   37: ldc 14
    //   39: astore 5
    //   41: aload 6
    //   43: aload 5
    //   45: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 5
    //   53: new 221	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   60: aload_1
    //   61: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 227
    //   66: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 229
    //   75: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: astore_2
    //   79: iload_3
    //   80: ifne +231 -> 311
    //   83: ldc 14
    //   85: astore_1
    //   86: aload_2
    //   87: aload_1
    //   88: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 7
    //   96: new 129	java/io/File
    //   99: dup
    //   100: aload 5
    //   102: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: new 129	java/io/File
    //   109: dup
    //   110: aload 7
    //   112: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 136	java/io/File:exists	()Z
    //   120: ifeq +10 -> 130
    //   123: aload_1
    //   124: invokevirtual 139	java/io/File:isFile	()Z
    //   127: ifne +17 -> 144
    //   130: aload_2
    //   131: invokevirtual 136	java/io/File:exists	()Z
    //   134: ifeq +215 -> 349
    //   137: aload_2
    //   138: invokevirtual 139	java/io/File:isFile	()Z
    //   141: ifeq +208 -> 349
    //   144: ldc 109
    //   146: ldc 237
    //   148: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: invokevirtual 136	java/io/File:exists	()Z
    //   155: ifeq +162 -> 317
    //   158: aload_1
    //   159: invokevirtual 139	java/io/File:isFile	()Z
    //   162: ifeq +155 -> 317
    //   165: new 143	java/io/FileInputStream
    //   168: dup
    //   169: aload_1
    //   170: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   173: astore_0
    //   174: iload_3
    //   175: ifne +752 -> 927
    //   178: aload_0
    //   179: iconst_1
    //   180: invokestatic 239	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   183: astore_1
    //   184: aload_0
    //   185: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   188: aload_1
    //   189: ifnull +714 -> 903
    //   192: new 154	java/io/InputStreamReader
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 156	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   200: astore_2
    //   201: new 158	java/io/BufferedReader
    //   204: dup
    //   205: aload_2
    //   206: sipush 1024
    //   209: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   212: astore 6
    //   214: new 163	java/lang/StringBuffer
    //   217: dup
    //   218: invokespecial 164	java/lang/StringBuffer:<init>	()V
    //   221: astore 5
    //   223: aload 6
    //   225: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   228: astore 7
    //   230: aload 7
    //   232: ifnull +272 -> 504
    //   235: aload 5
    //   237: aload 7
    //   239: invokevirtual 171	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   242: pop
    //   243: goto -20 -> 223
    //   246: astore 7
    //   248: aload_2
    //   249: astore 5
    //   251: aload 7
    //   253: astore_2
    //   254: aload_2
    //   255: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   258: aload 6
    //   260: ifnull +8 -> 268
    //   263: aload 6
    //   265: invokevirtual 178	java/io/BufferedReader:close	()V
    //   268: aload 5
    //   270: ifnull +8 -> 278
    //   273: aload 5
    //   275: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   278: aload_1
    //   279: ifnull +7 -> 286
    //   282: aload_1
    //   283: invokevirtual 182	java/io/InputStream:close	()V
    //   286: aload_0
    //   287: ifnull +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 183	java/io/FileInputStream:close	()V
    //   294: aconst_null
    //   295: astore_1
    //   296: ldc_w 263
    //   299: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aload_1
    //   303: areturn
    //   304: ldc 20
    //   306: astore 5
    //   308: goto -267 -> 41
    //   311: ldc 20
    //   313: astore_1
    //   314: goto -228 -> 86
    //   317: aload_2
    //   318: invokevirtual 136	java/io/File:exists	()Z
    //   321: ifeq +593 -> 914
    //   324: aload_2
    //   325: invokevirtual 139	java/io/File:isFile	()Z
    //   328: ifeq +586 -> 914
    //   331: new 143	java/io/FileInputStream
    //   334: dup
    //   335: aload_2
    //   336: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   339: astore_0
    //   340: iload_3
    //   341: ifne +581 -> 922
    //   344: iconst_1
    //   345: istore_3
    //   346: goto +573 -> 919
    //   349: ldc 109
    //   351: ldc 241
    //   353: invokestatic 127	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: invokevirtual 191	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   360: aload 5
    //   362: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   365: astore 6
    //   367: iload_3
    //   368: ifne +25 -> 393
    //   371: aload 6
    //   373: iconst_1
    //   374: invokestatic 239	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   377: astore_1
    //   378: aload_1
    //   379: astore_2
    //   380: aload_1
    //   381: astore 5
    //   383: aload 6
    //   385: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   388: aconst_null
    //   389: astore_0
    //   390: goto -202 -> 188
    //   393: aconst_null
    //   394: astore_0
    //   395: aload 6
    //   397: astore_1
    //   398: goto -210 -> 188
    //   401: astore_1
    //   402: aconst_null
    //   403: astore_1
    //   404: iload_3
    //   405: istore 4
    //   407: aload_1
    //   408: astore_2
    //   409: aload_1
    //   410: astore 5
    //   412: aload_0
    //   413: invokevirtual 191	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   416: aload 7
    //   418: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   421: astore 6
    //   423: iload_3
    //   424: ifne +42 -> 466
    //   427: iconst_1
    //   428: istore_3
    //   429: iload_3
    //   430: ifne +41 -> 471
    //   433: iload_3
    //   434: istore 4
    //   436: aload_1
    //   437: astore_2
    //   438: aload_1
    //   439: astore 5
    //   441: aload 6
    //   443: iconst_1
    //   444: invokestatic 239	com/tencent/ttpic/baseutils/BaseTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   447: astore_0
    //   448: aload_0
    //   449: astore_1
    //   450: aload_0
    //   451: astore_2
    //   452: aload 6
    //   454: invokestatic 152	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   457: aconst_null
    //   458: astore_2
    //   459: aload_0
    //   460: astore_1
    //   461: aload_2
    //   462: astore_0
    //   463: goto -275 -> 188
    //   466: iconst_0
    //   467: istore_3
    //   468: goto -39 -> 429
    //   471: aconst_null
    //   472: astore_0
    //   473: aload 6
    //   475: astore_1
    //   476: goto -288 -> 188
    //   479: astore 5
    //   481: aload_1
    //   482: astore_0
    //   483: iload 4
    //   485: istore_3
    //   486: aload_0
    //   487: astore_1
    //   488: aload_0
    //   489: astore_2
    //   490: aload 5
    //   492: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   495: aconst_null
    //   496: astore_2
    //   497: aload_0
    //   498: astore_1
    //   499: aload_2
    //   500: astore_0
    //   501: goto -313 -> 188
    //   504: iload_3
    //   505: ifeq +102 -> 607
    //   508: aload 5
    //   510: invokevirtual 200	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   513: invokestatic 247	com/tencent/ttpic/json/XML:toJSONObject	(Ljava/lang/String;)Lcom/tencent/ttpic/json/JSONObject;
    //   516: invokevirtual 250	com/tencent/ttpic/json/JSONObject:toString	()Ljava/lang/String;
    //   519: astore 5
    //   521: ldc 109
    //   523: aload 5
    //   525: invokestatic 253	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload 5
    //   530: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   533: ifne +364 -> 897
    //   536: new 255	org/json/JSONTokener
    //   539: dup
    //   540: aload 5
    //   542: invokespecial 256	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   545: invokevirtual 260	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   548: checkcast 262	org/json/JSONObject
    //   551: astore 5
    //   553: aload 6
    //   555: ifnull +8 -> 563
    //   558: aload 6
    //   560: invokevirtual 178	java/io/BufferedReader:close	()V
    //   563: aload_2
    //   564: ifnull +7 -> 571
    //   567: aload_2
    //   568: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   571: aload_1
    //   572: ifnull +7 -> 579
    //   575: aload_1
    //   576: invokevirtual 182	java/io/InputStream:close	()V
    //   579: aload 5
    //   581: astore_1
    //   582: aload_0
    //   583: ifnull -287 -> 296
    //   586: aload_0
    //   587: invokevirtual 183	java/io/FileInputStream:close	()V
    //   590: aload 5
    //   592: astore_1
    //   593: goto -297 -> 296
    //   596: astore_0
    //   597: aload_0
    //   598: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   601: aload 5
    //   603: astore_1
    //   604: goto -308 -> 296
    //   607: aload 5
    //   609: invokevirtual 200	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   612: astore 5
    //   614: goto -93 -> 521
    //   617: astore_0
    //   618: aload_0
    //   619: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   622: aconst_null
    //   623: astore_1
    //   624: goto -328 -> 296
    //   627: astore_2
    //   628: aconst_null
    //   629: astore_0
    //   630: aconst_null
    //   631: astore 5
    //   633: aconst_null
    //   634: astore 6
    //   636: aconst_null
    //   637: astore_1
    //   638: aload 6
    //   640: ifnull +8 -> 648
    //   643: aload 6
    //   645: invokevirtual 178	java/io/BufferedReader:close	()V
    //   648: aload 5
    //   650: ifnull +8 -> 658
    //   653: aload 5
    //   655: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   658: aload_1
    //   659: ifnull +7 -> 666
    //   662: aload_1
    //   663: invokevirtual 182	java/io/InputStream:close	()V
    //   666: aload_0
    //   667: ifnull +7 -> 674
    //   670: aload_0
    //   671: invokevirtual 183	java/io/FileInputStream:close	()V
    //   674: ldc_w 263
    //   677: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   680: aload_2
    //   681: athrow
    //   682: astore_0
    //   683: aload_0
    //   684: invokestatic 175	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   687: goto -13 -> 674
    //   690: astore_2
    //   691: aconst_null
    //   692: astore 5
    //   694: aconst_null
    //   695: astore 6
    //   697: aconst_null
    //   698: astore_1
    //   699: goto -61 -> 638
    //   702: astore_2
    //   703: aconst_null
    //   704: astore 5
    //   706: aconst_null
    //   707: astore 6
    //   709: goto -71 -> 638
    //   712: astore 7
    //   714: aconst_null
    //   715: astore_0
    //   716: aconst_null
    //   717: astore 5
    //   719: aconst_null
    //   720: astore 6
    //   722: aload_2
    //   723: astore_1
    //   724: aload 7
    //   726: astore_2
    //   727: goto -89 -> 638
    //   730: astore_2
    //   731: aconst_null
    //   732: astore_0
    //   733: aconst_null
    //   734: astore 5
    //   736: aconst_null
    //   737: astore 6
    //   739: goto -101 -> 638
    //   742: astore_2
    //   743: aconst_null
    //   744: astore 5
    //   746: aconst_null
    //   747: astore 6
    //   749: goto -111 -> 638
    //   752: astore 6
    //   754: aload_2
    //   755: astore 5
    //   757: aconst_null
    //   758: astore 7
    //   760: aload 6
    //   762: astore_2
    //   763: aload 7
    //   765: astore 6
    //   767: goto -129 -> 638
    //   770: astore 7
    //   772: aload_2
    //   773: astore 5
    //   775: aload 7
    //   777: astore_2
    //   778: goto -140 -> 638
    //   781: astore_2
    //   782: goto -144 -> 638
    //   785: astore_2
    //   786: aconst_null
    //   787: astore_0
    //   788: aconst_null
    //   789: astore 5
    //   791: aconst_null
    //   792: astore 6
    //   794: aconst_null
    //   795: astore_1
    //   796: goto -542 -> 254
    //   799: astore_2
    //   800: aconst_null
    //   801: astore 5
    //   803: aconst_null
    //   804: astore 6
    //   806: aconst_null
    //   807: astore_1
    //   808: goto -554 -> 254
    //   811: astore_2
    //   812: aconst_null
    //   813: astore 5
    //   815: aconst_null
    //   816: astore 6
    //   818: goto -564 -> 254
    //   821: astore_2
    //   822: aconst_null
    //   823: astore_0
    //   824: aconst_null
    //   825: astore 7
    //   827: aconst_null
    //   828: astore 6
    //   830: aload 5
    //   832: astore_1
    //   833: aload 7
    //   835: astore 5
    //   837: goto -583 -> 254
    //   840: astore_0
    //   841: aconst_null
    //   842: astore 7
    //   844: aconst_null
    //   845: astore 5
    //   847: aconst_null
    //   848: astore 6
    //   850: aload_2
    //   851: astore_1
    //   852: aload_0
    //   853: astore_2
    //   854: aload 7
    //   856: astore_0
    //   857: goto -603 -> 254
    //   860: astore_2
    //   861: aconst_null
    //   862: astore 5
    //   864: aconst_null
    //   865: astore 6
    //   867: goto -613 -> 254
    //   870: astore 6
    //   872: aload_2
    //   873: astore 5
    //   875: aconst_null
    //   876: astore 7
    //   878: aload 6
    //   880: astore_2
    //   881: aload 7
    //   883: astore 6
    //   885: goto -631 -> 254
    //   888: astore 5
    //   890: goto -404 -> 486
    //   893: astore_2
    //   894: goto -490 -> 404
    //   897: aconst_null
    //   898: astore 5
    //   900: goto -347 -> 553
    //   903: aconst_null
    //   904: astore_2
    //   905: aconst_null
    //   906: astore 6
    //   908: aconst_null
    //   909: astore 5
    //   911: goto -358 -> 553
    //   914: aconst_null
    //   915: astore_0
    //   916: goto -742 -> 174
    //   919: goto -745 -> 174
    //   922: iconst_0
    //   923: istore_3
    //   924: goto -5 -> 919
    //   927: aload_0
    //   928: astore_1
    //   929: aload_0
    //   930: astore_2
    //   931: aload_1
    //   932: astore_0
    //   933: aload_2
    //   934: astore_1
    //   935: goto -747 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	938	0	paramContext	Context
    //   0	938	1	paramString1	String
    //   0	938	2	paramString2	String
    //   0	938	3	paramBoolean	boolean
    //   405	79	4	bool	boolean
    //   39	401	5	localObject1	Object
    //   479	30	5	localIOException1	java.io.IOException
    //   519	355	5	localObject2	Object
    //   888	1	5	localIOException2	java.io.IOException
    //   898	12	5	localObject3	Object
    //   31	717	6	localObject4	Object
    //   752	9	6	localObject5	Object
    //   765	101	6	localObject6	Object
    //   870	9	6	localException1	java.lang.Exception
    //   883	24	6	localObject7	Object
    //   94	144	7	str	String
    //   246	171	7	localException2	java.lang.Exception
    //   712	13	7	localObject8	Object
    //   758	6	7	localObject9	Object
    //   770	6	7	localObject10	Object
    //   825	57	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   214	223	246	java/lang/Exception
    //   223	230	246	java/lang/Exception
    //   235	243	246	java/lang/Exception
    //   508	521	246	java/lang/Exception
    //   521	553	246	java/lang/Exception
    //   607	614	246	java/lang/Exception
    //   356	367	401	java/io/IOException
    //   371	378	401	java/io/IOException
    //   412	423	479	java/io/IOException
    //   441	448	479	java/io/IOException
    //   558	563	596	java/io/IOException
    //   567	571	596	java/io/IOException
    //   575	579	596	java/io/IOException
    //   586	590	596	java/io/IOException
    //   263	268	617	java/io/IOException
    //   273	278	617	java/io/IOException
    //   282	286	617	java/io/IOException
    //   290	294	617	java/io/IOException
    //   96	130	627	finally
    //   130	144	627	finally
    //   144	174	627	finally
    //   317	340	627	finally
    //   349	356	627	finally
    //   356	367	627	finally
    //   371	378	627	finally
    //   643	648	682	java/io/IOException
    //   653	658	682	java/io/IOException
    //   662	666	682	java/io/IOException
    //   670	674	682	java/io/IOException
    //   178	184	690	finally
    //   184	188	702	finally
    //   383	388	712	finally
    //   412	423	712	finally
    //   441	448	712	finally
    //   452	457	730	finally
    //   490	495	730	finally
    //   192	201	742	finally
    //   201	214	752	finally
    //   214	223	770	finally
    //   223	230	770	finally
    //   235	243	770	finally
    //   508	521	770	finally
    //   521	553	770	finally
    //   607	614	770	finally
    //   254	258	781	finally
    //   96	130	785	java/lang/Exception
    //   130	144	785	java/lang/Exception
    //   144	174	785	java/lang/Exception
    //   317	340	785	java/lang/Exception
    //   349	356	785	java/lang/Exception
    //   356	367	785	java/lang/Exception
    //   371	378	785	java/lang/Exception
    //   178	184	799	java/lang/Exception
    //   184	188	811	java/lang/Exception
    //   383	388	821	java/lang/Exception
    //   412	423	821	java/lang/Exception
    //   441	448	821	java/lang/Exception
    //   452	457	840	java/lang/Exception
    //   490	495	840	java/lang/Exception
    //   192	201	860	java/lang/Exception
    //   201	214	870	java/lang/Exception
    //   452	457	888	java/io/IOException
    //   383	388	893	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.BaseTemplateParser
 * JD-Core Version:    0.7.0.1
 */