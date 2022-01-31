package com.tencent.ttpic.device;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TemplateParser
{
  private static InputStream drinkACupOfCoffeeForCamera(InputStream paramInputStream, String paramString1, String paramString2)
  {
    return new ByteArrayInputStream(IOUtils.toByteArray(paramInputStream));
  }
  
  private static InputStream drinkACupOfCoffeeForFast(InputStream paramInputStream, String paramString)
  {
    return new ByteArrayInputStream(IOUtils.toByteArray(paramInputStream));
  }
  
  /* Error */
  public static String parseCameraAttrsFile(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 32
    //   2: new 34	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 36
    //   8: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 53	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 55	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 60	java/io/File:exists	()Z
    //   36: ifeq +151 -> 187
    //   39: aload 4
    //   41: invokevirtual 63	java/io/File:isFile	()Z
    //   44: ifeq +143 -> 187
    //   47: ldc 32
    //   49: ldc 65
    //   51: invokestatic 53	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: new 67	java/io/FileInputStream
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore_0
    //   64: aload_0
    //   65: aload_2
    //   66: aload_3
    //   67: invokestatic 72	com/tencent/ttpic/device/TemplateParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   70: astore_1
    //   71: aload_0
    //   72: invokestatic 76	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   75: aload_1
    //   76: astore 4
    //   78: aload_0
    //   79: astore_3
    //   80: aload 4
    //   82: ifnull +570 -> 652
    //   85: new 78	java/io/InputStreamReader
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 80	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   94: astore_0
    //   95: new 82	java/io/BufferedReader
    //   98: dup
    //   99: aload_0
    //   100: sipush 1024
    //   103: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   106: astore_1
    //   107: new 87	java/lang/StringBuffer
    //   110: dup
    //   111: invokespecial 88	java/lang/StringBuffer:<init>	()V
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   119: astore 5
    //   121: aload 5
    //   123: ifnull +181 -> 304
    //   126: aload_2
    //   127: aload 5
    //   129: invokevirtual 94	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: goto -18 -> 115
    //   136: astore 5
    //   138: aload_1
    //   139: astore_2
    //   140: aload_0
    //   141: astore_1
    //   142: aload 5
    //   144: astore_0
    //   145: aload_0
    //   146: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 101	java/io/BufferedReader:close	()V
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   165: aload 4
    //   167: ifnull +8 -> 175
    //   170: aload 4
    //   172: invokevirtual 105	java/io/InputStream:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 106	java/io/FileInputStream:close	()V
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: areturn
    //   187: ldc 32
    //   189: ldc 108
    //   191: invokestatic 53	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +483 -> 678
    //   198: aload_0
    //   199: invokevirtual 114	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   202: aload_1
    //   203: invokevirtual 120	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   206: astore_1
    //   207: aload_1
    //   208: aload_2
    //   209: aload_3
    //   210: invokestatic 72	com/tencent/ttpic/device/TemplateParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   213: astore_0
    //   214: aload_1
    //   215: invokestatic 76	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   218: aload_1
    //   219: astore_3
    //   220: aload_3
    //   221: ifnull +449 -> 670
    //   224: aload_0
    //   225: astore_1
    //   226: aload_0
    //   227: astore_2
    //   228: aload_3
    //   229: invokevirtual 105	java/io/InputStream:close	()V
    //   232: aconst_null
    //   233: astore_3
    //   234: aload_0
    //   235: astore 4
    //   237: goto -157 -> 80
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_0
    //   245: aload_1
    //   246: ifnull +416 -> 662
    //   249: aload_1
    //   250: invokevirtual 105	java/io/InputStream:close	()V
    //   253: aconst_null
    //   254: astore_3
    //   255: aload_0
    //   256: astore 4
    //   258: goto -178 -> 80
    //   261: astore_3
    //   262: aconst_null
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_0
    //   267: aload 4
    //   269: ifnull +12 -> 281
    //   272: aload_0
    //   273: astore_1
    //   274: aload_0
    //   275: astore_2
    //   276: aload 4
    //   278: invokevirtual 105	java/io/InputStream:close	()V
    //   281: aload_0
    //   282: astore_1
    //   283: aload_0
    //   284: astore_2
    //   285: aload_3
    //   286: athrow
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_3
    //   290: aconst_null
    //   291: astore 5
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_1
    //   296: astore 4
    //   298: aload 5
    //   300: astore_1
    //   301: goto -156 -> 145
    //   304: aload_2
    //   305: invokevirtual 121	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   308: astore_2
    //   309: aload_1
    //   310: astore 5
    //   312: aload_0
    //   313: astore_1
    //   314: aload_2
    //   315: astore_0
    //   316: aload 5
    //   318: ifnull +8 -> 326
    //   321: aload 5
    //   323: invokevirtual 101	java/io/BufferedReader:close	()V
    //   326: aload_1
    //   327: ifnull +7 -> 334
    //   330: aload_1
    //   331: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   334: aload 4
    //   336: ifnull +8 -> 344
    //   339: aload 4
    //   341: invokevirtual 105	java/io/InputStream:close	()V
    //   344: aload_0
    //   345: astore_1
    //   346: aload_3
    //   347: ifnull -162 -> 185
    //   350: aload_3
    //   351: invokevirtual 106	java/io/FileInputStream:close	()V
    //   354: aload_0
    //   355: areturn
    //   356: astore_1
    //   357: aload_1
    //   358: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   361: aload_0
    //   362: areturn
    //   363: astore_0
    //   364: aload_0
    //   365: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   368: aconst_null
    //   369: areturn
    //   370: astore_0
    //   371: aconst_null
    //   372: astore_3
    //   373: aconst_null
    //   374: astore_1
    //   375: aconst_null
    //   376: astore_2
    //   377: aconst_null
    //   378: astore 4
    //   380: aload_2
    //   381: ifnull +7 -> 388
    //   384: aload_2
    //   385: invokevirtual 101	java/io/BufferedReader:close	()V
    //   388: aload_1
    //   389: ifnull +7 -> 396
    //   392: aload_1
    //   393: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   396: aload 4
    //   398: ifnull +8 -> 406
    //   401: aload 4
    //   403: invokevirtual 105	java/io/InputStream:close	()V
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 106	java/io/FileInputStream:close	()V
    //   414: aload_0
    //   415: athrow
    //   416: astore_1
    //   417: aload_1
    //   418: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   421: goto -7 -> 414
    //   424: astore 5
    //   426: aload_0
    //   427: astore_3
    //   428: aconst_null
    //   429: astore_1
    //   430: aconst_null
    //   431: astore_2
    //   432: aconst_null
    //   433: astore 4
    //   435: aload 5
    //   437: astore_0
    //   438: goto -58 -> 380
    //   441: astore 6
    //   443: aload_0
    //   444: astore_3
    //   445: aconst_null
    //   446: astore 5
    //   448: aconst_null
    //   449: astore_2
    //   450: aload_1
    //   451: astore 4
    //   453: aload 6
    //   455: astore_0
    //   456: aload 5
    //   458: astore_1
    //   459: goto -79 -> 380
    //   462: astore_0
    //   463: aconst_null
    //   464: astore_3
    //   465: aconst_null
    //   466: astore_1
    //   467: aconst_null
    //   468: astore 5
    //   470: aload_2
    //   471: astore 4
    //   473: aload 5
    //   475: astore_2
    //   476: goto -96 -> 380
    //   479: astore 5
    //   481: aconst_null
    //   482: astore_3
    //   483: aconst_null
    //   484: astore_1
    //   485: aconst_null
    //   486: astore_2
    //   487: aload_0
    //   488: astore 4
    //   490: aload 5
    //   492: astore_0
    //   493: goto -113 -> 380
    //   496: astore_0
    //   497: aconst_null
    //   498: astore_1
    //   499: aconst_null
    //   500: astore_2
    //   501: goto -121 -> 380
    //   504: astore 5
    //   506: aload_0
    //   507: astore_1
    //   508: aconst_null
    //   509: astore_2
    //   510: aload 5
    //   512: astore_0
    //   513: goto -133 -> 380
    //   516: astore 6
    //   518: aload_0
    //   519: astore_2
    //   520: aload_1
    //   521: astore 5
    //   523: aload 6
    //   525: astore_0
    //   526: aload_2
    //   527: astore_1
    //   528: aload 5
    //   530: astore_2
    //   531: goto -151 -> 380
    //   534: astore_0
    //   535: goto -155 -> 380
    //   538: astore_0
    //   539: aconst_null
    //   540: astore_3
    //   541: aconst_null
    //   542: astore_1
    //   543: aconst_null
    //   544: astore_2
    //   545: aconst_null
    //   546: astore 4
    //   548: goto -403 -> 145
    //   551: astore 5
    //   553: aload_0
    //   554: astore_3
    //   555: aconst_null
    //   556: astore_1
    //   557: aconst_null
    //   558: astore_2
    //   559: aconst_null
    //   560: astore 4
    //   562: aload 5
    //   564: astore_0
    //   565: goto -420 -> 145
    //   568: astore 6
    //   570: aload_0
    //   571: astore_3
    //   572: aconst_null
    //   573: astore 5
    //   575: aconst_null
    //   576: astore_2
    //   577: aload_1
    //   578: astore 4
    //   580: aload 6
    //   582: astore_0
    //   583: aload 5
    //   585: astore_1
    //   586: goto -441 -> 145
    //   589: astore 5
    //   591: aconst_null
    //   592: astore_3
    //   593: aconst_null
    //   594: astore_1
    //   595: aconst_null
    //   596: astore_2
    //   597: aload_0
    //   598: astore 4
    //   600: aload 5
    //   602: astore_0
    //   603: goto -458 -> 145
    //   606: astore_0
    //   607: aconst_null
    //   608: astore_1
    //   609: aconst_null
    //   610: astore_2
    //   611: goto -466 -> 145
    //   614: astore 5
    //   616: aload_0
    //   617: astore_1
    //   618: aconst_null
    //   619: astore_2
    //   620: aload 5
    //   622: astore_0
    //   623: goto -478 -> 145
    //   626: astore_3
    //   627: aconst_null
    //   628: astore_0
    //   629: aload_1
    //   630: astore 4
    //   632: goto -365 -> 267
    //   635: astore_3
    //   636: aload_1
    //   637: astore 4
    //   639: goto -372 -> 267
    //   642: astore_0
    //   643: aconst_null
    //   644: astore_0
    //   645: goto -400 -> 245
    //   648: astore_2
    //   649: goto -404 -> 245
    //   652: aconst_null
    //   653: astore_1
    //   654: aconst_null
    //   655: astore 5
    //   657: aconst_null
    //   658: astore_0
    //   659: goto -343 -> 316
    //   662: aconst_null
    //   663: astore_3
    //   664: aload_0
    //   665: astore 4
    //   667: goto -587 -> 80
    //   670: aconst_null
    //   671: astore_3
    //   672: aload_0
    //   673: astore 4
    //   675: goto -595 -> 80
    //   678: aconst_null
    //   679: astore_3
    //   680: aconst_null
    //   681: astore_0
    //   682: goto -462 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	paramContext	android.content.Context
    //   0	685	1	paramString1	String
    //   0	685	2	paramString2	String
    //   0	685	3	paramString3	String
    //   29	645	4	localObject1	Object
    //   119	9	5	str1	String
    //   136	7	5	localException1	java.lang.Exception
    //   291	31	5	str2	String
    //   424	12	5	localObject2	Object
    //   446	28	5	localObject3	Object
    //   479	12	5	localObject4	Object
    //   504	7	5	localObject5	Object
    //   521	8	5	str3	String
    //   551	12	5	localException2	java.lang.Exception
    //   573	11	5	localObject6	Object
    //   589	12	5	localException3	java.lang.Exception
    //   614	7	5	localException4	java.lang.Exception
    //   655	1	5	localObject7	Object
    //   441	13	6	localObject8	Object
    //   516	8	6	localObject9	Object
    //   568	13	6	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   107	115	136	java/lang/Exception
    //   115	121	136	java/lang/Exception
    //   126	133	136	java/lang/Exception
    //   304	309	136	java/lang/Exception
    //   198	207	240	java/io/IOException
    //   198	207	261	finally
    //   228	232	287	java/lang/Exception
    //   276	281	287	java/lang/Exception
    //   285	287	287	java/lang/Exception
    //   321	326	356	java/io/IOException
    //   330	334	356	java/io/IOException
    //   339	344	356	java/io/IOException
    //   350	354	356	java/io/IOException
    //   153	157	363	java/io/IOException
    //   161	165	363	java/io/IOException
    //   170	175	363	java/io/IOException
    //   179	183	363	java/io/IOException
    //   21	64	370	finally
    //   187	194	370	finally
    //   384	388	416	java/io/IOException
    //   392	396	416	java/io/IOException
    //   401	406	416	java/io/IOException
    //   410	414	416	java/io/IOException
    //   64	71	424	finally
    //   71	75	441	finally
    //   228	232	462	finally
    //   276	281	462	finally
    //   285	287	462	finally
    //   249	253	479	finally
    //   85	95	496	finally
    //   95	107	504	finally
    //   107	115	516	finally
    //   115	121	516	finally
    //   126	133	516	finally
    //   304	309	516	finally
    //   145	149	534	finally
    //   21	64	538	java/lang/Exception
    //   187	194	538	java/lang/Exception
    //   64	71	551	java/lang/Exception
    //   71	75	568	java/lang/Exception
    //   249	253	589	java/lang/Exception
    //   85	95	606	java/lang/Exception
    //   95	107	614	java/lang/Exception
    //   207	214	626	finally
    //   214	218	635	finally
    //   207	214	642	java/io/IOException
    //   214	218	648	java/io/IOException
  }
  
  /* Error */
  public static String parseFastCaptureFile(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 32
    //   2: new 34	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 125
    //   8: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 53	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 32
    //   23: ldc 127
    //   25: invokestatic 53	com/tencent/ttpic/baseutils/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: ifnull +420 -> 449
    //   32: aload_0
    //   33: invokevirtual 114	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   36: aload_1
    //   37: invokevirtual 120	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: astore_0
    //   41: aload_0
    //   42: aload_2
    //   43: invokestatic 129	com/tencent/ttpic/device/TemplateParser:drinkACupOfCoffeeForFast	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   46: astore_1
    //   47: aload_0
    //   48: invokestatic 76	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   51: aload_0
    //   52: astore_2
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: ifnull +15 -> 71
    //   59: aload_1
    //   60: astore 4
    //   62: aload_1
    //   63: astore 5
    //   65: aload_2
    //   66: invokevirtual 105	java/io/InputStream:close	()V
    //   69: aload_1
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +364 -> 436
    //   75: aload_0
    //   76: astore 4
    //   78: aload_0
    //   79: astore 5
    //   81: new 78	java/io/InputStreamReader
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 80	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   89: astore_1
    //   90: new 82	java/io/BufferedReader
    //   93: dup
    //   94: aload_1
    //   95: sipush 1024
    //   98: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   101: astore_3
    //   102: new 87	java/lang/StringBuffer
    //   105: dup
    //   106: invokespecial 88	java/lang/StringBuffer:<init>	()V
    //   109: astore_2
    //   110: aload_3
    //   111: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 4
    //   118: ifnull +106 -> 224
    //   121: aload_2
    //   122: aload 4
    //   124: invokevirtual 94	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   127: pop
    //   128: goto -18 -> 110
    //   131: astore 4
    //   133: aload_1
    //   134: astore_2
    //   135: aload 4
    //   137: astore_1
    //   138: aload_1
    //   139: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 101	java/io/BufferedReader:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 105	java/io/InputStream:close	()V
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: areturn
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_2
    //   176: ifnull +270 -> 446
    //   179: aload_2
    //   180: invokevirtual 105	java/io/InputStream:close	()V
    //   183: goto -112 -> 71
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_2
    //   192: ifnull +13 -> 205
    //   195: aload_0
    //   196: astore 4
    //   198: aload_0
    //   199: astore 5
    //   201: aload_2
    //   202: invokevirtual 105	java/io/InputStream:close	()V
    //   205: aload_0
    //   206: astore 4
    //   208: aload_0
    //   209: astore 5
    //   211: aload_1
    //   212: athrow
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_3
    //   218: aload 4
    //   220: astore_0
    //   221: goto -83 -> 138
    //   224: aload_2
    //   225: invokevirtual 121	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   228: astore_2
    //   229: aload_3
    //   230: astore 4
    //   232: aload_1
    //   233: astore_3
    //   234: aload_2
    //   235: astore_1
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 101	java/io/BufferedReader:close	()V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   254: aload_1
    //   255: astore_2
    //   256: aload_0
    //   257: ifnull -89 -> 168
    //   260: aload_0
    //   261: invokevirtual 105	java/io/InputStream:close	()V
    //   264: aload_1
    //   265: areturn
    //   266: astore_0
    //   267: aload_0
    //   268: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   271: aload_1
    //   272: areturn
    //   273: astore_0
    //   274: aload_0
    //   275: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_2
    //   283: aconst_null
    //   284: astore_3
    //   285: aconst_null
    //   286: astore_0
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 101	java/io/BufferedReader:close	()V
    //   295: aload_2
    //   296: ifnull +7 -> 303
    //   299: aload_2
    //   300: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   303: aload_0
    //   304: ifnull +7 -> 311
    //   307: aload_0
    //   308: invokevirtual 105	java/io/InputStream:close	()V
    //   311: aload_1
    //   312: athrow
    //   313: astore_0
    //   314: aload_0
    //   315: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   318: goto -7 -> 311
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_2
    //   324: aconst_null
    //   325: astore_3
    //   326: aload 5
    //   328: astore_0
    //   329: goto -42 -> 287
    //   332: astore_1
    //   333: aconst_null
    //   334: astore_2
    //   335: aconst_null
    //   336: astore_3
    //   337: goto -50 -> 287
    //   340: astore 4
    //   342: aload_1
    //   343: astore_2
    //   344: aconst_null
    //   345: astore_3
    //   346: aload 4
    //   348: astore_1
    //   349: goto -62 -> 287
    //   352: astore 4
    //   354: aload_1
    //   355: astore_2
    //   356: aload 4
    //   358: astore_1
    //   359: goto -72 -> 287
    //   362: astore_1
    //   363: goto -76 -> 287
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_2
    //   369: aconst_null
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_0
    //   373: goto -235 -> 138
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_2
    //   379: aconst_null
    //   380: astore_3
    //   381: goto -243 -> 138
    //   384: astore 4
    //   386: aload_1
    //   387: astore_2
    //   388: aconst_null
    //   389: astore_3
    //   390: aload 4
    //   392: astore_1
    //   393: goto -255 -> 138
    //   396: astore_1
    //   397: aconst_null
    //   398: astore_3
    //   399: aload_0
    //   400: astore_2
    //   401: aload_3
    //   402: astore_0
    //   403: goto -212 -> 191
    //   406: astore_2
    //   407: aload_1
    //   408: astore_3
    //   409: aload_2
    //   410: astore_1
    //   411: aload_0
    //   412: astore_2
    //   413: aload_3
    //   414: astore_0
    //   415: goto -224 -> 191
    //   418: astore_1
    //   419: aconst_null
    //   420: astore_1
    //   421: aload_0
    //   422: astore_2
    //   423: aload_1
    //   424: astore_0
    //   425: goto -250 -> 175
    //   428: astore_2
    //   429: aload_0
    //   430: astore_2
    //   431: aload_1
    //   432: astore_0
    //   433: goto -258 -> 175
    //   436: aconst_null
    //   437: astore_3
    //   438: aconst_null
    //   439: astore 4
    //   441: aconst_null
    //   442: astore_1
    //   443: goto -207 -> 236
    //   446: goto -375 -> 71
    //   449: aconst_null
    //   450: astore_2
    //   451: aconst_null
    //   452: astore_1
    //   453: goto -400 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	paramContext	android.content.Context
    //   0	456	1	paramString1	String
    //   0	456	2	paramString2	String
    //   101	337	3	localObject1	Object
    //   60	63	4	localObject2	Object
    //   131	5	4	localException1	java.lang.Exception
    //   196	46	4	localObject3	Object
    //   340	7	4	localObject4	Object
    //   352	5	4	localObject5	Object
    //   384	7	4	localException2	java.lang.Exception
    //   439	1	4	localObject6	Object
    //   63	264	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   102	110	131	java/lang/Exception
    //   110	116	131	java/lang/Exception
    //   121	128	131	java/lang/Exception
    //   224	229	131	java/lang/Exception
    //   32	41	170	java/io/IOException
    //   32	41	186	finally
    //   65	69	213	java/lang/Exception
    //   81	90	213	java/lang/Exception
    //   201	205	213	java/lang/Exception
    //   211	213	213	java/lang/Exception
    //   241	246	266	java/io/IOException
    //   250	254	266	java/io/IOException
    //   260	264	266	java/io/IOException
    //   146	150	273	java/io/IOException
    //   154	158	273	java/io/IOException
    //   162	166	273	java/io/IOException
    //   21	28	280	finally
    //   291	295	313	java/io/IOException
    //   299	303	313	java/io/IOException
    //   307	311	313	java/io/IOException
    //   65	69	321	finally
    //   81	90	321	finally
    //   201	205	321	finally
    //   211	213	321	finally
    //   179	183	332	finally
    //   90	102	340	finally
    //   102	110	352	finally
    //   110	116	352	finally
    //   121	128	352	finally
    //   224	229	352	finally
    //   138	142	362	finally
    //   21	28	366	java/lang/Exception
    //   179	183	376	java/lang/Exception
    //   90	102	384	java/lang/Exception
    //   41	47	396	finally
    //   47	51	406	finally
    //   41	47	418	java/io/IOException
    //   47	51	428	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.TemplateParser
 * JD-Core Version:    0.7.0.1
 */