package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DeviceParser
{
  private static InputStream drinkACupOfCoffeeForCamera(InputStream paramInputStream, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49855);
    paramInputStream = new ByteArrayInputStream(DeviceCoffee.drink(IOUtils.toByteArray(paramInputStream), paramString1, paramString2));
    AppMethodBeat.o(49855);
    return paramInputStream;
  }
  
  private static InputStream drinkACupOfCoffeeForFast(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(49857);
    paramInputStream = new ByteArrayInputStream(DeviceCoffee.drinkRawData(IOUtils.toByteArray(paramInputStream), paramString));
    AppMethodBeat.o(49857);
    return paramInputStream;
  }
  
  /* Error */
  public static String parseCameraAttrsFile(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 54
    //   7: ldc 56
    //   9: aload_1
    //   10: invokestatic 62	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 66	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 72	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: new 74	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 81	java/io/File:exists	()Z
    //   34: ifeq +156 -> 190
    //   37: aload 4
    //   39: invokevirtual 84	java/io/File:isFile	()Z
    //   42: ifeq +148 -> 190
    //   45: ldc 54
    //   47: ldc 86
    //   49: invokestatic 72	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: new 88	java/io/FileInputStream
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_0
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: invokestatic 93	com/tencent/ttpic/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   68: astore_1
    //   69: aload_0
    //   70: invokestatic 97	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: astore 4
    //   76: aload_0
    //   77: astore_3
    //   78: aload 4
    //   80: ifnull +598 -> 678
    //   83: new 99	java/io/InputStreamReader
    //   86: dup
    //   87: aload 4
    //   89: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   92: astore_0
    //   93: new 103	java/io/BufferedReader
    //   96: dup
    //   97: aload_0
    //   98: sipush 1024
    //   101: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   104: astore_1
    //   105: new 108	java/lang/StringBuffer
    //   108: dup
    //   109: invokespecial 109	java/lang/StringBuffer:<init>	()V
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +195 -> 316
    //   124: aload_2
    //   125: aload 5
    //   127: invokevirtual 117	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
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
    //   144: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 124	java/io/BufferedReader:close	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 125	java/io/InputStreamReader:close	()V
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 128	java/io/InputStream:close	()V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 129	java/io/FileInputStream:close	()V
    //   181: aconst_null
    //   182: astore_1
    //   183: ldc 52
    //   185: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: areturn
    //   190: ldc 54
    //   192: ldc 131
    //   194: invokestatic 72	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_0
    //   198: ifnull +506 -> 704
    //   201: aload_0
    //   202: invokevirtual 137	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   205: aload_1
    //   206: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   209: astore_1
    //   210: aload_1
    //   211: aload_2
    //   212: aload_3
    //   213: invokestatic 93	com/tencent/ttpic/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   216: astore_0
    //   217: aload_1
    //   218: invokestatic 97	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   221: aload_1
    //   222: astore_3
    //   223: aload_3
    //   224: ifnull +472 -> 696
    //   227: aload_0
    //   228: astore_1
    //   229: aload_0
    //   230: astore_2
    //   231: aload_3
    //   232: invokevirtual 128	java/io/InputStream:close	()V
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
    //   253: invokevirtual 128	java/io/InputStream:close	()V
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
    //   281: invokevirtual 128	java/io/InputStream:close	()V
    //   284: aload_0
    //   285: astore_1
    //   286: aload_0
    //   287: astore_2
    //   288: ldc 52
    //   290: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   317: invokevirtual 146	java/lang/StringBuffer:toString	()Ljava/lang/String;
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
    //   335: invokevirtual 124	java/io/BufferedReader:close	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 125	java/io/InputStreamReader:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 128	java/io/InputStream:close	()V
    //   356: aload_0
    //   357: astore_1
    //   358: aload_3
    //   359: ifnull -176 -> 183
    //   362: aload_3
    //   363: invokevirtual 129	java/io/FileInputStream:close	()V
    //   366: aload_0
    //   367: astore_1
    //   368: goto -185 -> 183
    //   371: astore_1
    //   372: aload_1
    //   373: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   376: aload_0
    //   377: astore_1
    //   378: goto -195 -> 183
    //   381: astore_0
    //   382: aload_0
    //   383: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
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
    //   406: invokevirtual 124	java/io/BufferedReader:close	()V
    //   409: aload_1
    //   410: ifnull +7 -> 417
    //   413: aload_1
    //   414: invokevirtual 125	java/io/InputStreamReader:close	()V
    //   417: aload 4
    //   419: ifnull +8 -> 427
    //   422: aload 4
    //   424: invokevirtual 128	java/io/InputStream:close	()V
    //   427: aload_3
    //   428: ifnull +7 -> 435
    //   431: aload_3
    //   432: invokevirtual 129	java/io/FileInputStream:close	()V
    //   435: ldc 52
    //   437: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_0
    //   441: athrow
    //   442: astore_1
    //   443: aload_1
    //   444: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
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
    //   0	711	0	paramContext	android.content.Context
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
  public static String parseFastCaptureFile(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 54
    //   7: ldc 151
    //   9: aload_1
    //   10: invokestatic 62	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 66	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 72	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 54
    //   21: ldc 153
    //   23: invokestatic 72	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: ifnull +450 -> 477
    //   30: aload_0
    //   31: invokevirtual 137	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   34: aload_1
    //   35: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: aload_0
    //   40: aload_2
    //   41: invokestatic 155	com/tencent/ttpic/device/DeviceParser:drinkACupOfCoffeeForFast	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 97	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
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
    //   64: invokevirtual 128	java/io/InputStream:close	()V
    //   67: aload_1
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +394 -> 464
    //   73: aload_0
    //   74: astore 4
    //   76: aload_0
    //   77: astore 5
    //   79: new 99	java/io/InputStreamReader
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: astore_1
    //   88: new 103	java/io/BufferedReader
    //   91: dup
    //   92: aload_1
    //   93: sipush 1024
    //   96: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   99: astore_3
    //   100: new 108	java/lang/StringBuffer
    //   103: dup
    //   104: invokespecial 109	java/lang/StringBuffer:<init>	()V
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 4
    //   114: aload 4
    //   116: ifnull +122 -> 238
    //   119: aload_2
    //   120: aload 4
    //   122: invokevirtual 117	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   125: pop
    //   126: goto -18 -> 108
    //   129: astore 4
    //   131: aload_1
    //   132: astore_2
    //   133: aload 4
    //   135: astore_1
    //   136: aload_1
    //   137: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 124	java/io/BufferedReader:close	()V
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 125	java/io/InputStreamReader:close	()V
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 128	java/io/InputStream:close	()V
    //   164: aconst_null
    //   165: astore_2
    //   166: ldc 149
    //   168: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   183: invokevirtual 128	java/io/InputStream:close	()V
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
    //   205: invokevirtual 128	java/io/InputStream:close	()V
    //   208: aload_0
    //   209: astore 4
    //   211: aload_0
    //   212: astore 5
    //   214: ldc 149
    //   216: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   239: invokevirtual 146	java/lang/StringBuffer:toString	()Ljava/lang/String;
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
    //   257: invokevirtual 124	java/io/BufferedReader:close	()V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 125	java/io/InputStreamReader:close	()V
    //   268: aload_1
    //   269: astore_2
    //   270: aload_0
    //   271: ifnull -105 -> 166
    //   274: aload_0
    //   275: invokevirtual 128	java/io/InputStream:close	()V
    //   278: aload_1
    //   279: astore_2
    //   280: goto -114 -> 166
    //   283: astore_0
    //   284: aload_0
    //   285: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   288: aload_1
    //   289: astore_2
    //   290: goto -124 -> 166
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
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
    //   315: invokevirtual 124	java/io/BufferedReader:close	()V
    //   318: aload_2
    //   319: ifnull +7 -> 326
    //   322: aload_2
    //   323: invokevirtual 125	java/io/InputStreamReader:close	()V
    //   326: aload_0
    //   327: ifnull +7 -> 334
    //   330: aload_0
    //   331: invokevirtual 128	java/io/InputStream:close	()V
    //   334: ldc 149
    //   336: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_1
    //   340: athrow
    //   341: astore_0
    //   342: aload_0
    //   343: invokestatic 121	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
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
    //   0	484	0	paramContext	android.content.Context
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceParser
 * JD-Core Version:    0.7.0.1
 */