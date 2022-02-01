package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class e
{
  public static int DXA = 30000;
  public static int DXB = 30000;
  
  /* Error */
  public static a K(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 34	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 44	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: ifnonnull +38 -> 59
    //   24: aload_0
    //   25: ifnull +14 -> 39
    //   28: aload_0
    //   29: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   32: invokevirtual 53	java/io/InputStream:close	()V
    //   35: aload_0
    //   36: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   39: ldc 26
    //   41: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: astore_1
    //   47: ldc 61
    //   49: aload_1
    //   50: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   53: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: goto -21 -> 35
    //   59: aload_0
    //   60: getstatic 14	com/tencent/mm/plugin/webview/g/e:DXA	I
    //   63: invokevirtual 74	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   66: aload_0
    //   67: getstatic 16	com/tencent/mm/plugin/webview/g/e:DXB	I
    //   70: invokevirtual 77	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   73: aload_0
    //   74: ldc 79
    //   76: invokevirtual 82	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: iconst_0
    //   81: invokevirtual 86	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   84: aload_1
    //   85: ifnull +106 -> 191
    //   88: aload_1
    //   89: invokeinterface 92 1 0
    //   94: ifle +97 -> 191
    //   97: aload_1
    //   98: invokeinterface 96 1 0
    //   103: invokeinterface 102 1 0
    //   108: astore_3
    //   109: aload_3
    //   110: invokeinterface 108 1 0
    //   115: ifeq +76 -> 191
    //   118: aload_3
    //   119: invokeinterface 112 1 0
    //   124: checkcast 114	java/lang/String
    //   127: astore 4
    //   129: aload_0
    //   130: aload 4
    //   132: aload_1
    //   133: aload 4
    //   135: invokeinterface 118 2 0
    //   140: checkcast 114	java/lang/String
    //   143: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: goto -37 -> 109
    //   149: astore_3
    //   150: aload_0
    //   151: astore_1
    //   152: aload_1
    //   153: astore_0
    //   154: ldc 61
    //   156: ldc 123
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_3
    //   165: aastore
    //   166: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +14 -> 184
    //   173: aload_1
    //   174: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   177: invokevirtual 53	java/io/InputStream:close	()V
    //   180: aload_1
    //   181: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   184: ldc 26
    //   186: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aconst_null
    //   190: areturn
    //   191: new 6	com/tencent/mm/plugin/webview/g/e$a
    //   194: dup
    //   195: invokespecial 129	com/tencent/mm/plugin/webview/g/e$a:<init>	()V
    //   198: astore_3
    //   199: aload_3
    //   200: aload_0
    //   201: invokevirtual 132	java/net/HttpURLConnection:getResponseCode	()I
    //   204: putfield 135	com/tencent/mm/plugin/webview/g/e$a:statusCode	I
    //   207: aload_3
    //   208: getfield 135	com/tencent/mm/plugin/webview/g/e$a:statusCode	I
    //   211: sipush 200
    //   214: if_icmpne +353 -> 567
    //   217: aload_0
    //   218: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   221: astore_1
    //   222: aload_0
    //   223: invokevirtual 138	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   226: astore 4
    //   228: aload 4
    //   230: aload_1
    //   231: invokestatic 142	com/tencent/mm/plugin/webview/g/e:d	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   234: astore_1
    //   235: aload_3
    //   236: aload_1
    //   237: invokestatic 146	com/tencent/mm/plugin/webview/g/e:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   240: putfield 150	com/tencent/mm/plugin/webview/g/e$a:data	Ljava/lang/String;
    //   243: aload_1
    //   244: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   247: goto +320 -> 567
    //   250: aload_0
    //   251: iload_2
    //   252: invokevirtual 158	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   255: astore_1
    //   256: aload_0
    //   257: iload_2
    //   258: invokevirtual 161	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   261: astore 4
    //   263: aload_1
    //   264: ifnonnull +8 -> 272
    //   267: aload 4
    //   269: ifnull +114 -> 383
    //   272: aload_3
    //   273: getfield 165	com/tencent/mm/plugin/webview/g/e$a:lWV	Ljava/util/Map;
    //   276: aload_1
    //   277: aload 4
    //   279: invokeinterface 169 3 0
    //   284: pop
    //   285: iload_2
    //   286: iconst_1
    //   287: iadd
    //   288: istore_2
    //   289: goto -39 -> 250
    //   292: aload_1
    //   293: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   296: aload_0
    //   297: ifnull +14 -> 311
    //   300: aload_0
    //   301: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   304: invokevirtual 53	java/io/InputStream:close	()V
    //   307: aload_0
    //   308: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   311: ldc 26
    //   313: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_1
    //   319: ldc 61
    //   321: aload_1
    //   322: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   325: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: goto -21 -> 307
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_1
    //   334: aload_1
    //   335: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   338: ldc 26
    //   340: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload_3
    //   344: athrow
    //   345: astore_3
    //   346: aload_0
    //   347: astore_1
    //   348: aload_1
    //   349: astore_0
    //   350: ldc 61
    //   352: ldc 123
    //   354: iconst_1
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_3
    //   361: aastore
    //   362: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload_1
    //   366: ifnull -182 -> 184
    //   369: aload_1
    //   370: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   373: invokevirtual 53	java/io/InputStream:close	()V
    //   376: aload_1
    //   377: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   380: goto -196 -> 184
    //   383: aload_0
    //   384: ifnull +14 -> 398
    //   387: aload_0
    //   388: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   391: invokevirtual 53	java/io/InputStream:close	()V
    //   394: aload_0
    //   395: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   398: ldc 26
    //   400: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_3
    //   404: areturn
    //   405: astore_1
    //   406: ldc 61
    //   408: aload_1
    //   409: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   412: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: goto -21 -> 394
    //   418: astore_0
    //   419: ldc 61
    //   421: aload_0
    //   422: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   425: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: goto -248 -> 180
    //   431: astore_0
    //   432: ldc 61
    //   434: aload_0
    //   435: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   438: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: goto -65 -> 376
    //   444: astore_3
    //   445: aconst_null
    //   446: astore_1
    //   447: aload_1
    //   448: astore_0
    //   449: ldc 61
    //   451: ldc 123
    //   453: iconst_1
    //   454: anewarray 4	java/lang/Object
    //   457: dup
    //   458: iconst_0
    //   459: aload_3
    //   460: aastore
    //   461: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: aload_1
    //   465: ifnull -281 -> 184
    //   468: aload_1
    //   469: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   472: invokevirtual 53	java/io/InputStream:close	()V
    //   475: aload_1
    //   476: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   479: goto -295 -> 184
    //   482: astore_0
    //   483: ldc 61
    //   485: aload_0
    //   486: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   489: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: goto -17 -> 475
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_0
    //   498: aload_0
    //   499: ifnull +14 -> 513
    //   502: aload_0
    //   503: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   506: invokevirtual 53	java/io/InputStream:close	()V
    //   509: aload_0
    //   510: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   513: ldc 26
    //   515: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: aload_1
    //   519: athrow
    //   520: astore_3
    //   521: ldc 61
    //   523: aload_3
    //   524: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   527: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: goto -21 -> 509
    //   533: astore_1
    //   534: goto -36 -> 498
    //   537: astore_1
    //   538: goto -40 -> 498
    //   541: astore_3
    //   542: aload_0
    //   543: astore_1
    //   544: goto -97 -> 447
    //   547: astore_3
    //   548: aconst_null
    //   549: astore_1
    //   550: goto -202 -> 348
    //   553: astore_3
    //   554: aconst_null
    //   555: astore_1
    //   556: goto -404 -> 152
    //   559: astore_3
    //   560: goto -226 -> 334
    //   563: astore_3
    //   564: goto -272 -> 292
    //   567: iconst_0
    //   568: istore_2
    //   569: goto -319 -> 250
    //   572: astore_1
    //   573: aconst_null
    //   574: astore_1
    //   575: goto -283 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	paramString	String
    //   0	578	1	paramMap	Map<String, String>
    //   251	318	2	i	int
    //   108	11	3	localIterator	java.util.Iterator
    //   149	16	3	localMalformedURLException1	java.net.MalformedURLException
    //   198	75	3	locala	a
    //   331	13	3	localObject1	Object
    //   345	59	3	localIOException1	IOException
    //   444	16	3	localException1	Exception
    //   520	4	3	localException2	Exception
    //   541	1	3	localException3	Exception
    //   547	1	3	localIOException2	IOException
    //   553	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   559	1	3	localObject2	Object
    //   563	1	3	localIOException3	IOException
    //   127	151	4	str	String
    // Exception table:
    //   from	to	target	type
    //   28	35	46	java/lang/Exception
    //   59	84	149	java/net/MalformedURLException
    //   88	109	149	java/net/MalformedURLException
    //   109	146	149	java/net/MalformedURLException
    //   191	228	149	java/net/MalformedURLException
    //   243	247	149	java/net/MalformedURLException
    //   250	263	149	java/net/MalformedURLException
    //   272	285	149	java/net/MalformedURLException
    //   292	296	149	java/net/MalformedURLException
    //   334	345	149	java/net/MalformedURLException
    //   300	307	318	java/lang/Exception
    //   228	235	331	finally
    //   59	84	345	java/io/IOException
    //   88	109	345	java/io/IOException
    //   109	146	345	java/io/IOException
    //   191	228	345	java/io/IOException
    //   243	247	345	java/io/IOException
    //   250	263	345	java/io/IOException
    //   272	285	345	java/io/IOException
    //   292	296	345	java/io/IOException
    //   334	345	345	java/io/IOException
    //   387	394	405	java/lang/Exception
    //   173	180	418	java/lang/Exception
    //   369	376	431	java/lang/Exception
    //   5	20	444	java/lang/Exception
    //   468	475	482	java/lang/Exception
    //   5	20	495	finally
    //   502	509	520	java/lang/Exception
    //   59	84	533	finally
    //   88	109	533	finally
    //   109	146	533	finally
    //   191	228	533	finally
    //   243	247	533	finally
    //   250	263	533	finally
    //   272	285	533	finally
    //   292	296	533	finally
    //   334	345	533	finally
    //   154	169	537	finally
    //   350	365	537	finally
    //   449	464	537	finally
    //   59	84	541	java/lang/Exception
    //   88	109	541	java/lang/Exception
    //   109	146	541	java/lang/Exception
    //   191	228	541	java/lang/Exception
    //   243	247	541	java/lang/Exception
    //   250	263	541	java/lang/Exception
    //   272	285	541	java/lang/Exception
    //   292	296	541	java/lang/Exception
    //   334	345	541	java/lang/Exception
    //   5	20	547	java/io/IOException
    //   5	20	553	java/net/MalformedURLException
    //   235	243	559	finally
    //   235	243	563	java/io/IOException
    //   228	235	572	java/io/IOException
  }
  
  /* Error */
  public static a a(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: ldc 173
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 34	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 44	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: getstatic 14	com/tencent/mm/plugin/webview/g/e:DXA	I
    //   24: invokevirtual 74	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   27: aload_0
    //   28: getstatic 16	com/tencent/mm/plugin/webview/g/e:DXB	I
    //   31: invokevirtual 77	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   34: aload_0
    //   35: ldc 175
    //   37: invokevirtual 82	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: invokevirtual 178	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   45: aload_0
    //   46: iconst_1
    //   47: invokevirtual 181	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload_0
    //   51: iconst_0
    //   52: invokevirtual 86	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   55: aload_1
    //   56: ifnull +109 -> 165
    //   59: aload_1
    //   60: invokeinterface 92 1 0
    //   65: ifle +100 -> 165
    //   68: aload_1
    //   69: invokeinterface 96 1 0
    //   74: invokeinterface 102 1 0
    //   79: astore 4
    //   81: aload 4
    //   83: invokeinterface 108 1 0
    //   88: ifeq +77 -> 165
    //   91: aload 4
    //   93: invokeinterface 112 1 0
    //   98: checkcast 114	java/lang/String
    //   101: astore 5
    //   103: aload_0
    //   104: aload 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 118 2 0
    //   114: checkcast 114	java/lang/String
    //   117: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: goto -39 -> 81
    //   123: astore_2
    //   124: aload_0
    //   125: astore_1
    //   126: aload_1
    //   127: astore_0
    //   128: ldc 61
    //   130: ldc 123
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_2
    //   139: aastore
    //   140: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_1
    //   144: ifnull +14 -> 158
    //   147: aload_1
    //   148: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   151: invokevirtual 53	java/io/InputStream:close	()V
    //   154: aload_1
    //   155: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   158: ldc 173
    //   160: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: aload_2
    //   166: invokevirtual 185	java/lang/String:getBytes	()[B
    //   169: astore_1
    //   170: aload_0
    //   171: invokevirtual 188	java/net/HttpURLConnection:connect	()V
    //   174: new 190	java/io/DataOutputStream
    //   177: dup
    //   178: aload_0
    //   179: invokevirtual 194	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   182: invokespecial 197	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   185: astore_2
    //   186: aload_2
    //   187: aload_1
    //   188: invokevirtual 201	java/io/DataOutputStream:write	([B)V
    //   191: aload_2
    //   192: invokevirtual 204	java/io/DataOutputStream:flush	()V
    //   195: new 6	com/tencent/mm/plugin/webview/g/e$a
    //   198: dup
    //   199: invokespecial 129	com/tencent/mm/plugin/webview/g/e$a:<init>	()V
    //   202: astore_2
    //   203: aload_2
    //   204: aload_0
    //   205: invokevirtual 132	java/net/HttpURLConnection:getResponseCode	()I
    //   208: putfield 135	com/tencent/mm/plugin/webview/g/e$a:statusCode	I
    //   211: aload_2
    //   212: getfield 135	com/tencent/mm/plugin/webview/g/e$a:statusCode	I
    //   215: sipush 200
    //   218: if_icmpne +431 -> 649
    //   221: aload_0
    //   222: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   225: astore_1
    //   226: aload_0
    //   227: invokevirtual 138	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   230: astore 4
    //   232: aload 4
    //   234: aload_1
    //   235: invokestatic 142	com/tencent/mm/plugin/webview/g/e:d	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   238: astore_1
    //   239: aload_2
    //   240: aload_1
    //   241: invokestatic 146	com/tencent/mm/plugin/webview/g/e:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   244: putfield 150	com/tencent/mm/plugin/webview/g/e$a:data	Ljava/lang/String;
    //   247: aload_1
    //   248: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   251: goto +398 -> 649
    //   254: aload_0
    //   255: iload_3
    //   256: invokevirtual 158	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   259: astore_1
    //   260: aload_0
    //   261: iload_3
    //   262: invokevirtual 161	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   265: astore 4
    //   267: aload_1
    //   268: ifnonnull +8 -> 276
    //   271: aload 4
    //   273: ifnull +140 -> 413
    //   276: aload_2
    //   277: getfield 165	com/tencent/mm/plugin/webview/g/e$a:lWV	Ljava/util/Map;
    //   280: aload_1
    //   281: aload 4
    //   283: invokeinterface 169 3 0
    //   288: pop
    //   289: iload_3
    //   290: iconst_1
    //   291: iadd
    //   292: istore_3
    //   293: goto -39 -> 254
    //   296: aload_1
    //   297: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   300: aload_0
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   308: invokevirtual 53	java/io/InputStream:close	()V
    //   311: aload_0
    //   312: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   315: ldc 173
    //   317: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aconst_null
    //   321: areturn
    //   322: astore_1
    //   323: ldc 61
    //   325: aload_1
    //   326: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   329: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: goto -21 -> 311
    //   335: astore_0
    //   336: ldc 61
    //   338: aload_0
    //   339: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: goto -30 -> 315
    //   348: astore_2
    //   349: aconst_null
    //   350: astore_1
    //   351: aload_1
    //   352: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   355: ldc 173
    //   357: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: aload_2
    //   361: athrow
    //   362: astore_2
    //   363: aload_0
    //   364: astore_1
    //   365: aload_1
    //   366: astore_0
    //   367: ldc 61
    //   369: ldc 123
    //   371: iconst_1
    //   372: anewarray 4	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: aload_2
    //   378: aastore
    //   379: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: aload_1
    //   383: ifnull -225 -> 158
    //   386: aload_1
    //   387: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   390: invokevirtual 53	java/io/InputStream:close	()V
    //   393: aload_1
    //   394: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   397: goto -239 -> 158
    //   400: astore_0
    //   401: ldc 61
    //   403: aload_0
    //   404: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   407: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: goto -252 -> 158
    //   413: aload_0
    //   414: ifnull +14 -> 428
    //   417: aload_0
    //   418: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   421: invokevirtual 53	java/io/InputStream:close	()V
    //   424: aload_0
    //   425: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   428: ldc 173
    //   430: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aload_2
    //   434: areturn
    //   435: astore_1
    //   436: ldc 61
    //   438: aload_1
    //   439: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   442: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: goto -21 -> 424
    //   448: astore_0
    //   449: ldc 61
    //   451: aload_0
    //   452: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: goto -30 -> 428
    //   461: astore_0
    //   462: ldc 61
    //   464: aload_0
    //   465: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -317 -> 154
    //   474: astore_0
    //   475: ldc 61
    //   477: aload_0
    //   478: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: goto -326 -> 158
    //   487: astore_0
    //   488: ldc 61
    //   490: aload_0
    //   491: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   494: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -104 -> 393
    //   500: astore_2
    //   501: aconst_null
    //   502: astore_1
    //   503: aload_1
    //   504: astore_0
    //   505: ldc 61
    //   507: ldc 123
    //   509: iconst_1
    //   510: anewarray 4	java/lang/Object
    //   513: dup
    //   514: iconst_0
    //   515: aload_2
    //   516: aastore
    //   517: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: aload_1
    //   521: ifnull -363 -> 158
    //   524: aload_1
    //   525: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   528: invokevirtual 53	java/io/InputStream:close	()V
    //   531: aload_1
    //   532: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   535: goto -377 -> 158
    //   538: astore_0
    //   539: ldc 61
    //   541: aload_0
    //   542: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   545: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: goto -390 -> 158
    //   551: astore_0
    //   552: ldc 61
    //   554: aload_0
    //   555: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -30 -> 531
    //   564: astore_1
    //   565: aconst_null
    //   566: astore_0
    //   567: aload_0
    //   568: ifnull +14 -> 582
    //   571: aload_0
    //   572: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   575: invokevirtual 53	java/io/InputStream:close	()V
    //   578: aload_0
    //   579: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   582: ldc 173
    //   584: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: aload_1
    //   588: athrow
    //   589: astore_2
    //   590: ldc 61
    //   592: aload_2
    //   593: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   596: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: goto -21 -> 578
    //   602: astore_0
    //   603: ldc 61
    //   605: aload_0
    //   606: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   609: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: goto -30 -> 582
    //   615: astore_1
    //   616: goto -49 -> 567
    //   619: astore_1
    //   620: goto -53 -> 567
    //   623: astore_2
    //   624: aload_0
    //   625: astore_1
    //   626: goto -123 -> 503
    //   629: astore_2
    //   630: aconst_null
    //   631: astore_1
    //   632: goto -267 -> 365
    //   635: astore_2
    //   636: aconst_null
    //   637: astore_1
    //   638: goto -512 -> 126
    //   641: astore_2
    //   642: goto -291 -> 351
    //   645: astore_2
    //   646: goto -350 -> 296
    //   649: iconst_0
    //   650: istore_3
    //   651: goto -397 -> 254
    //   654: astore_1
    //   655: aconst_null
    //   656: astore_1
    //   657: goto -361 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	paramString1	String
    //   0	660	1	paramMap	Map<String, String>
    //   0	660	2	paramString2	String
    //   255	396	3	i	int
    //   79	203	4	localObject	Object
    //   101	7	5	str	String
    // Exception table:
    //   from	to	target	type
    //   20	55	123	java/net/MalformedURLException
    //   59	81	123	java/net/MalformedURLException
    //   81	120	123	java/net/MalformedURLException
    //   165	232	123	java/net/MalformedURLException
    //   247	251	123	java/net/MalformedURLException
    //   254	267	123	java/net/MalformedURLException
    //   276	289	123	java/net/MalformedURLException
    //   296	300	123	java/net/MalformedURLException
    //   351	362	123	java/net/MalformedURLException
    //   304	311	322	java/lang/Exception
    //   311	315	335	java/lang/Exception
    //   232	239	348	finally
    //   20	55	362	java/io/IOException
    //   59	81	362	java/io/IOException
    //   81	120	362	java/io/IOException
    //   165	232	362	java/io/IOException
    //   247	251	362	java/io/IOException
    //   254	267	362	java/io/IOException
    //   276	289	362	java/io/IOException
    //   296	300	362	java/io/IOException
    //   351	362	362	java/io/IOException
    //   393	397	400	java/lang/Exception
    //   417	424	435	java/lang/Exception
    //   424	428	448	java/lang/Exception
    //   147	154	461	java/lang/Exception
    //   154	158	474	java/lang/Exception
    //   386	393	487	java/lang/Exception
    //   5	20	500	java/lang/Exception
    //   531	535	538	java/lang/Exception
    //   524	531	551	java/lang/Exception
    //   5	20	564	finally
    //   571	578	589	java/lang/Exception
    //   578	582	602	java/lang/Exception
    //   20	55	615	finally
    //   59	81	615	finally
    //   81	120	615	finally
    //   165	232	615	finally
    //   247	251	615	finally
    //   254	267	615	finally
    //   276	289	615	finally
    //   296	300	615	finally
    //   351	362	615	finally
    //   128	143	619	finally
    //   367	382	619	finally
    //   505	520	619	finally
    //   20	55	623	java/lang/Exception
    //   59	81	623	java/lang/Exception
    //   81	120	623	java/lang/Exception
    //   165	232	623	java/lang/Exception
    //   247	251	623	java/lang/Exception
    //   254	267	623	java/lang/Exception
    //   276	289	623	java/lang/Exception
    //   296	300	623	java/lang/Exception
    //   351	362	623	java/lang/Exception
    //   5	20	629	java/io/IOException
    //   5	20	635	java/net/MalformedURLException
    //   239	247	641	finally
    //   239	247	645	java/io/IOException
    //   232	239	654	java/io/IOException
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(79236);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(79236);
      return;
    }
    catch (IOException paramCloseable)
    {
      ad.m("MicroMsg.RequestUtil", "", new Object[] { paramCloseable });
      AppMethodBeat.o(79236);
      return;
    }
    catch (Exception paramCloseable)
    {
      ad.m("MicroMsg.RequestUtil", "", new Object[] { paramCloseable });
      AppMethodBeat.o(79236);
    }
  }
  
  /* Error */
  private static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 210
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 212	java/io/InputStreamReader
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 215	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   13: astore_0
    //   14: new 217	java/io/BufferedReader
    //   17: dup
    //   18: aload_0
    //   19: sipush 512
    //   22: invokespecial 220	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_1
    //   26: new 222	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_1
    //   35: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +61 -> 101
    //   43: aload_2
    //   44: new 222	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   51: aload_3
    //   52: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 232
    //   57: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: goto -33 -> 34
    //   70: astore_2
    //   71: ldc 61
    //   73: ldc 123
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_0
    //   87: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   90: aload_1
    //   91: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   94: ldc 210
    //   96: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_0
    //   102: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   105: aload_1
    //   106: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   109: aload_2
    //   110: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore_0
    //   114: ldc 210
    //   116: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: areturn
    //   121: astore_2
    //   122: ldc 61
    //   124: ldc 123
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_2
    //   133: aastore
    //   134: invokestatic 127	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_0
    //   138: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   141: aload_1
    //   142: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   145: ldc 210
    //   147: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_2
    //   153: aload_0
    //   154: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   157: aload_1
    //   158: invokestatic 154	com/tencent/mm/plugin/webview/g/e:closeQuietly	(Ljava/io/Closeable;)V
    //   161: ldc 210
    //   163: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_2
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramInputStream	InputStream
    //   25	133	1	localBufferedReader	java.io.BufferedReader
    //   33	11	2	localStringBuilder	java.lang.StringBuilder
    //   70	40	2	localIOException	IOException
    //   121	12	2	localException	Exception
    //   152	15	2	localObject	Object
    //   38	14	3	str	String
    // Exception table:
    //   from	to	target	type
    //   34	39	70	java/io/IOException
    //   43	67	70	java/io/IOException
    //   34	39	121	java/lang/Exception
    //   43	67	121	java/lang/Exception
    //   34	39	152	finally
    //   43	67	152	finally
    //   71	86	152	finally
    //   122	137	152	finally
  }
  
  private static InputStream d(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(79234);
    if ((paramString == null) || ("identity".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(79234);
      return paramInputStream;
    }
    if ("gzip".equalsIgnoreCase(paramString))
    {
      paramString = new GZIPInputStream(paramInputStream);
      AppMethodBeat.o(79234);
      return paramString;
    }
    if ("deflate".equalsIgnoreCase(paramString))
    {
      paramString = new InflaterInputStream(paramInputStream, new Inflater(false), 512);
      AppMethodBeat.o(79234);
      return paramString;
    }
    paramString = new RuntimeException("unsupported content-encoding: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(79234);
    throw paramString;
  }
  
  public static final class a
  {
    public String data;
    public Map<String, String> lWV;
    public int statusCode;
    
    public a()
    {
      AppMethodBeat.i(79231);
      this.lWV = new HashMap();
      this.data = "";
      AppMethodBeat.o(79231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.e
 * JD-Core Version:    0.7.0.1
 */