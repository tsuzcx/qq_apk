package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class d
{
  public static int uYH = 30000;
  public static int uYI = 30000;
  
  /* Error */
  public static d.a a(String paramString1, java.util.Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: sipush 7042
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 32	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 40	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 42	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: getstatic 13	com/tencent/mm/plugin/webview/preload/d:uYH	I
    //   25: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   28: aload_0
    //   29: getstatic 15	com/tencent/mm/plugin/webview/preload/d:uYI	I
    //   32: invokevirtual 48	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   35: aload_0
    //   36: ldc 50
    //   38: invokevirtual 53	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: iconst_1
    //   43: invokevirtual 57	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   46: aload_0
    //   47: iconst_1
    //   48: invokevirtual 60	java/net/HttpURLConnection:setDoInput	(Z)V
    //   51: aload_0
    //   52: iconst_0
    //   53: invokevirtual 63	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   56: aload_1
    //   57: ifnull +110 -> 167
    //   60: aload_1
    //   61: invokeinterface 69 1 0
    //   66: ifle +101 -> 167
    //   69: aload_1
    //   70: invokeinterface 73 1 0
    //   75: invokeinterface 79 1 0
    //   80: astore 4
    //   82: aload 4
    //   84: invokeinterface 85 1 0
    //   89: ifeq +78 -> 167
    //   92: aload 4
    //   94: invokeinterface 89 1 0
    //   99: checkcast 91	java/lang/String
    //   102: astore 5
    //   104: aload_0
    //   105: aload 5
    //   107: aload_1
    //   108: aload 5
    //   110: invokeinterface 95 2 0
    //   115: checkcast 91	java/lang/String
    //   118: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: goto -39 -> 82
    //   124: astore_2
    //   125: aload_0
    //   126: astore_1
    //   127: aload_1
    //   128: astore_0
    //   129: ldc 101
    //   131: ldc 103
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_2
    //   140: aastore
    //   141: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_1
    //   145: ifnull +14 -> 159
    //   148: aload_1
    //   149: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   152: invokevirtual 118	java/io/InputStream:close	()V
    //   155: aload_1
    //   156: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   159: sipush 7042
    //   162: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload_2
    //   168: invokevirtual 128	java/lang/String:getBytes	()[B
    //   171: astore_1
    //   172: aload_0
    //   173: invokevirtual 131	java/net/HttpURLConnection:connect	()V
    //   176: new 133	java/io/DataOutputStream
    //   179: dup
    //   180: aload_0
    //   181: invokevirtual 137	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   184: invokespecial 140	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   187: astore_2
    //   188: aload_2
    //   189: aload_1
    //   190: invokevirtual 144	java/io/DataOutputStream:write	([B)V
    //   193: aload_2
    //   194: invokevirtual 147	java/io/DataOutputStream:flush	()V
    //   197: new 6	com/tencent/mm/plugin/webview/preload/d$a
    //   200: dup
    //   201: invokespecial 149	com/tencent/mm/plugin/webview/preload/d$a:<init>	()V
    //   204: astore_2
    //   205: aload_2
    //   206: aload_0
    //   207: invokevirtual 152	java/net/HttpURLConnection:getResponseCode	()I
    //   210: putfield 155	com/tencent/mm/plugin/webview/preload/d$a:statusCode	I
    //   213: aload_2
    //   214: getfield 155	com/tencent/mm/plugin/webview/preload/d$a:statusCode	I
    //   217: sipush 200
    //   220: if_icmpne +357 -> 577
    //   223: aload_0
    //   224: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   227: astore_1
    //   228: aload_0
    //   229: invokevirtual 159	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   232: astore 4
    //   234: aload 4
    //   236: aload_1
    //   237: invokestatic 163	com/tencent/mm/plugin/webview/preload/d:f	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   240: astore_1
    //   241: aload_2
    //   242: aload_1
    //   243: invokestatic 167	com/tencent/mm/plugin/webview/preload/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   246: putfield 171	com/tencent/mm/plugin/webview/preload/d$a:data	Ljava/lang/String;
    //   249: aload_1
    //   250: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   253: goto +324 -> 577
    //   256: aload_0
    //   257: iload_3
    //   258: invokevirtual 179	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_0
    //   263: iload_3
    //   264: invokevirtual 182	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   267: astore 4
    //   269: aload_1
    //   270: ifnonnull +8 -> 278
    //   273: aload 4
    //   275: ifnull +116 -> 391
    //   278: aload_2
    //   279: getfield 186	com/tencent/mm/plugin/webview/preload/d$a:itJ	Ljava/util/Map;
    //   282: aload_1
    //   283: aload 4
    //   285: invokeinterface 190 3 0
    //   290: pop
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore_3
    //   295: goto -39 -> 256
    //   298: aload_1
    //   299: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   302: aload_0
    //   303: ifnull +14 -> 317
    //   306: aload_0
    //   307: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   310: invokevirtual 118	java/io/InputStream:close	()V
    //   313: aload_0
    //   314: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   317: sipush 7042
    //   320: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: aconst_null
    //   324: areturn
    //   325: astore_1
    //   326: ldc 101
    //   328: aload_1
    //   329: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   332: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -22 -> 313
    //   338: astore_2
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_1
    //   342: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   345: sipush 7042
    //   348: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: aload_2
    //   352: athrow
    //   353: astore_2
    //   354: aload_0
    //   355: astore_1
    //   356: aload_1
    //   357: astore_0
    //   358: ldc 101
    //   360: ldc 103
    //   362: iconst_1
    //   363: anewarray 4	java/lang/Object
    //   366: dup
    //   367: iconst_0
    //   368: aload_2
    //   369: aastore
    //   370: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload_1
    //   374: ifnull -215 -> 159
    //   377: aload_1
    //   378: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   381: invokevirtual 118	java/io/InputStream:close	()V
    //   384: aload_1
    //   385: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   388: goto -229 -> 159
    //   391: aload_0
    //   392: ifnull +14 -> 406
    //   395: aload_0
    //   396: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   399: invokevirtual 118	java/io/InputStream:close	()V
    //   402: aload_0
    //   403: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   406: sipush 7042
    //   409: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_2
    //   413: areturn
    //   414: astore_1
    //   415: ldc 101
    //   417: aload_1
    //   418: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: goto -22 -> 402
    //   427: astore_0
    //   428: ldc 101
    //   430: aload_0
    //   431: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   434: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: goto -282 -> 155
    //   440: astore_0
    //   441: ldc 101
    //   443: aload_0
    //   444: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   447: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: goto -66 -> 384
    //   453: astore_2
    //   454: aconst_null
    //   455: astore_1
    //   456: aload_1
    //   457: astore_0
    //   458: ldc 101
    //   460: ldc 103
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload_2
    //   469: aastore
    //   470: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   473: aload_1
    //   474: ifnull -315 -> 159
    //   477: aload_1
    //   478: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   481: invokevirtual 118	java/io/InputStream:close	()V
    //   484: aload_1
    //   485: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   488: goto -329 -> 159
    //   491: astore_0
    //   492: ldc 101
    //   494: aload_0
    //   495: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   498: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: goto -17 -> 484
    //   504: astore_1
    //   505: aconst_null
    //   506: astore_0
    //   507: aload_0
    //   508: ifnull +14 -> 522
    //   511: aload_0
    //   512: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   515: invokevirtual 118	java/io/InputStream:close	()V
    //   518: aload_0
    //   519: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   522: sipush 7042
    //   525: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_1
    //   529: athrow
    //   530: astore_2
    //   531: ldc 101
    //   533: aload_2
    //   534: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   537: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: goto -22 -> 518
    //   543: astore_1
    //   544: goto -37 -> 507
    //   547: astore_1
    //   548: goto -41 -> 507
    //   551: astore_2
    //   552: aload_0
    //   553: astore_1
    //   554: goto -98 -> 456
    //   557: astore_2
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -204 -> 356
    //   563: astore_2
    //   564: aconst_null
    //   565: astore_1
    //   566: goto -439 -> 127
    //   569: astore_2
    //   570: goto -229 -> 341
    //   573: astore_2
    //   574: goto -276 -> 298
    //   577: iconst_0
    //   578: istore_3
    //   579: goto -323 -> 256
    //   582: astore_1
    //   583: aconst_null
    //   584: astore_1
    //   585: goto -287 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramString1	String
    //   0	588	1	paramMap	java.util.Map<String, String>
    //   0	588	2	paramString2	String
    //   257	322	3	i	int
    //   80	204	4	localObject	Object
    //   102	7	5	str	String
    // Exception table:
    //   from	to	target	type
    //   21	56	124	java/net/MalformedURLException
    //   60	82	124	java/net/MalformedURLException
    //   82	121	124	java/net/MalformedURLException
    //   167	234	124	java/net/MalformedURLException
    //   249	253	124	java/net/MalformedURLException
    //   256	269	124	java/net/MalformedURLException
    //   278	291	124	java/net/MalformedURLException
    //   298	302	124	java/net/MalformedURLException
    //   341	353	124	java/net/MalformedURLException
    //   306	313	325	java/lang/Exception
    //   234	241	338	finally
    //   21	56	353	java/io/IOException
    //   60	82	353	java/io/IOException
    //   82	121	353	java/io/IOException
    //   167	234	353	java/io/IOException
    //   249	253	353	java/io/IOException
    //   256	269	353	java/io/IOException
    //   278	291	353	java/io/IOException
    //   298	302	353	java/io/IOException
    //   341	353	353	java/io/IOException
    //   395	402	414	java/lang/Exception
    //   148	155	427	java/lang/Exception
    //   377	384	440	java/lang/Exception
    //   6	21	453	java/lang/Exception
    //   477	484	491	java/lang/Exception
    //   6	21	504	finally
    //   511	518	530	java/lang/Exception
    //   21	56	543	finally
    //   60	82	543	finally
    //   82	121	543	finally
    //   167	234	543	finally
    //   249	253	543	finally
    //   256	269	543	finally
    //   278	291	543	finally
    //   298	302	543	finally
    //   341	353	543	finally
    //   129	144	547	finally
    //   358	373	547	finally
    //   458	473	547	finally
    //   21	56	551	java/lang/Exception
    //   60	82	551	java/lang/Exception
    //   82	121	551	java/lang/Exception
    //   167	234	551	java/lang/Exception
    //   249	253	551	java/lang/Exception
    //   256	269	551	java/lang/Exception
    //   278	291	551	java/lang/Exception
    //   298	302	551	java/lang/Exception
    //   341	353	551	java/lang/Exception
    //   6	21	557	java/io/IOException
    //   6	21	563	java/net/MalformedURLException
    //   241	249	569	finally
    //   241	249	573	java/io/IOException
    //   234	241	582	java/io/IOException
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(7046);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(7046);
      return;
    }
    catch (IOException paramCloseable)
    {
      ab.b("MicroMsg.RequestUtil", "", new Object[] { paramCloseable });
      AppMethodBeat.o(7046);
      return;
    }
    catch (Exception paramCloseable)
    {
      ab.b("MicroMsg.RequestUtil", "", new Object[] { paramCloseable });
      AppMethodBeat.o(7046);
    }
  }
  
  /* Error */
  private static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 7045
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 203	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   14: astore_0
    //   15: new 208	java/io/BufferedReader
    //   18: dup
    //   19: aload_0
    //   20: sipush 512
    //   23: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_1
    //   27: new 213	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual 217	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +62 -> 103
    //   44: aload_2
    //   45: new 213	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   52: aload_3
    //   53: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 223
    //   58: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -33 -> 35
    //   71: astore_2
    //   72: ldc 101
    //   74: ldc 103
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_2
    //   83: aastore
    //   84: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_0
    //   88: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   91: aload_1
    //   92: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   95: sipush 7045
    //   98: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aconst_null
    //   102: areturn
    //   103: aload_0
    //   104: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   107: aload_1
    //   108: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   111: aload_2
    //   112: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_0
    //   116: sipush 7045
    //   119: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: ldc 101
    //   127: ldc 103
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_2
    //   136: aastore
    //   137: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_0
    //   141: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   144: aload_1
    //   145: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   148: sipush 7045
    //   151: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_2
    //   157: aload_0
    //   158: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   161: aload_1
    //   162: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   165: sipush 7045
    //   168: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramInputStream	InputStream
    //   26	136	1	localBufferedReader	java.io.BufferedReader
    //   34	11	2	localStringBuilder	java.lang.StringBuilder
    //   71	41	2	localIOException	IOException
    //   124	12	2	localException	Exception
    //   156	16	2	localObject	Object
    //   39	14	3	str	String
    // Exception table:
    //   from	to	target	type
    //   35	40	71	java/io/IOException
    //   44	68	71	java/io/IOException
    //   35	40	124	java/lang/Exception
    //   44	68	124	java/lang/Exception
    //   35	40	156	finally
    //   44	68	156	finally
    //   72	87	156	finally
    //   125	140	156	finally
  }
  
  private static InputStream f(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(7044);
    if ((paramString == null) || ("identity".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(7044);
      return paramInputStream;
    }
    if ("gzip".equalsIgnoreCase(paramString))
    {
      paramString = new GZIPInputStream(paramInputStream);
      AppMethodBeat.o(7044);
      return paramString;
    }
    if ("deflate".equalsIgnoreCase(paramString))
    {
      paramString = new InflaterInputStream(paramInputStream, new Inflater(false), 512);
      AppMethodBeat.o(7044);
      return paramString;
    }
    paramString = new RuntimeException("unsupported content-encoding: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(7044);
    throw paramString;
  }
  
  /* Error */
  public static d.a y(String paramString, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: sipush 7043
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 32	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 40	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 42	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull +39 -> 61
    //   25: aload_0
    //   26: ifnull +14 -> 40
    //   29: aload_0
    //   30: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   33: invokevirtual 118	java/io/InputStream:close	()V
    //   36: aload_0
    //   37: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   40: sipush 7043
    //   43: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aconst_null
    //   47: areturn
    //   48: astore_1
    //   49: ldc 101
    //   51: aload_1
    //   52: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   55: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: goto -22 -> 36
    //   61: aload_0
    //   62: getstatic 13	com/tencent/mm/plugin/webview/preload/d:uYH	I
    //   65: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload_0
    //   69: getstatic 15	com/tencent/mm/plugin/webview/preload/d:uYI	I
    //   72: invokevirtual 48	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   75: aload_0
    //   76: ldc_w 265
    //   79: invokevirtual 53	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: iconst_0
    //   84: invokevirtual 63	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   87: aload_1
    //   88: ifnull +107 -> 195
    //   91: aload_1
    //   92: invokeinterface 69 1 0
    //   97: ifle +98 -> 195
    //   100: aload_1
    //   101: invokeinterface 73 1 0
    //   106: invokeinterface 79 1 0
    //   111: astore_3
    //   112: aload_3
    //   113: invokeinterface 85 1 0
    //   118: ifeq +77 -> 195
    //   121: aload_3
    //   122: invokeinterface 89 1 0
    //   127: checkcast 91	java/lang/String
    //   130: astore 4
    //   132: aload_0
    //   133: aload 4
    //   135: aload_1
    //   136: aload 4
    //   138: invokeinterface 95 2 0
    //   143: checkcast 91	java/lang/String
    //   146: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -37 -> 112
    //   152: astore_3
    //   153: aload_0
    //   154: astore_1
    //   155: aload_1
    //   156: astore_0
    //   157: ldc 101
    //   159: ldc 103
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_3
    //   168: aastore
    //   169: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_1
    //   173: ifnull +14 -> 187
    //   176: aload_1
    //   177: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   180: invokevirtual 118	java/io/InputStream:close	()V
    //   183: aload_1
    //   184: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   187: sipush 7043
    //   190: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aconst_null
    //   194: areturn
    //   195: new 6	com/tencent/mm/plugin/webview/preload/d$a
    //   198: dup
    //   199: invokespecial 149	com/tencent/mm/plugin/webview/preload/d$a:<init>	()V
    //   202: astore_3
    //   203: aload_3
    //   204: aload_0
    //   205: invokevirtual 152	java/net/HttpURLConnection:getResponseCode	()I
    //   208: putfield 155	com/tencent/mm/plugin/webview/preload/d$a:statusCode	I
    //   211: aload_3
    //   212: getfield 155	com/tencent/mm/plugin/webview/preload/d$a:statusCode	I
    //   215: sipush 200
    //   218: if_icmpne +357 -> 575
    //   221: aload_0
    //   222: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   225: astore_1
    //   226: aload_0
    //   227: invokevirtual 159	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   230: astore 4
    //   232: aload 4
    //   234: aload_1
    //   235: invokestatic 163	com/tencent/mm/plugin/webview/preload/d:f	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   238: astore_1
    //   239: aload_3
    //   240: aload_1
    //   241: invokestatic 167	com/tencent/mm/plugin/webview/preload/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   244: putfield 171	com/tencent/mm/plugin/webview/preload/d$a:data	Ljava/lang/String;
    //   247: aload_1
    //   248: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   251: goto +324 -> 575
    //   254: aload_0
    //   255: iload_2
    //   256: invokevirtual 179	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   259: astore_1
    //   260: aload_0
    //   261: iload_2
    //   262: invokevirtual 182	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   265: astore 4
    //   267: aload_1
    //   268: ifnonnull +8 -> 276
    //   271: aload 4
    //   273: ifnull +116 -> 389
    //   276: aload_3
    //   277: getfield 186	com/tencent/mm/plugin/webview/preload/d$a:itJ	Ljava/util/Map;
    //   280: aload_1
    //   281: aload 4
    //   283: invokeinterface 190 3 0
    //   288: pop
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore_2
    //   293: goto -39 -> 254
    //   296: aload_1
    //   297: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   300: aload_0
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   308: invokevirtual 118	java/io/InputStream:close	()V
    //   311: aload_0
    //   312: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   315: sipush 7043
    //   318: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aconst_null
    //   322: areturn
    //   323: astore_1
    //   324: ldc 101
    //   326: aload_1
    //   327: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   330: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: goto -22 -> 311
    //   336: astore_3
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: invokestatic 175	com/tencent/mm/plugin/webview/preload/d:closeQuietly	(Ljava/io/Closeable;)V
    //   343: sipush 7043
    //   346: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_3
    //   350: athrow
    //   351: astore_3
    //   352: aload_0
    //   353: astore_1
    //   354: aload_1
    //   355: astore_0
    //   356: ldc 101
    //   358: ldc 103
    //   360: iconst_1
    //   361: anewarray 4	java/lang/Object
    //   364: dup
    //   365: iconst_0
    //   366: aload_3
    //   367: aastore
    //   368: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload_1
    //   372: ifnull -185 -> 187
    //   375: aload_1
    //   376: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   379: invokevirtual 118	java/io/InputStream:close	()V
    //   382: aload_1
    //   383: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   386: goto -199 -> 187
    //   389: aload_0
    //   390: ifnull +14 -> 404
    //   393: aload_0
    //   394: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   397: invokevirtual 118	java/io/InputStream:close	()V
    //   400: aload_0
    //   401: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   404: sipush 7043
    //   407: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: aload_3
    //   411: areturn
    //   412: astore_1
    //   413: ldc 101
    //   415: aload_1
    //   416: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   419: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -22 -> 400
    //   425: astore_0
    //   426: ldc 101
    //   428: aload_0
    //   429: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   432: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: goto -252 -> 183
    //   438: astore_0
    //   439: ldc 101
    //   441: aload_0
    //   442: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   445: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: goto -66 -> 382
    //   451: astore_3
    //   452: aconst_null
    //   453: astore_1
    //   454: aload_1
    //   455: astore_0
    //   456: ldc 101
    //   458: ldc 103
    //   460: iconst_1
    //   461: anewarray 4	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload_3
    //   467: aastore
    //   468: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: aload_1
    //   472: ifnull -285 -> 187
    //   475: aload_1
    //   476: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   479: invokevirtual 118	java/io/InputStream:close	()V
    //   482: aload_1
    //   483: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   486: goto -299 -> 187
    //   489: astore_0
    //   490: ldc 101
    //   492: aload_0
    //   493: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   496: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: goto -17 -> 482
    //   502: astore_1
    //   503: aconst_null
    //   504: astore_0
    //   505: aload_0
    //   506: ifnull +14 -> 520
    //   509: aload_0
    //   510: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   513: invokevirtual 118	java/io/InputStream:close	()V
    //   516: aload_0
    //   517: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   520: sipush 7043
    //   523: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   526: aload_1
    //   527: athrow
    //   528: astore_3
    //   529: ldc 101
    //   531: aload_3
    //   532: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   535: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: goto -22 -> 516
    //   541: astore_1
    //   542: goto -37 -> 505
    //   545: astore_1
    //   546: goto -41 -> 505
    //   549: astore_3
    //   550: aload_0
    //   551: astore_1
    //   552: goto -98 -> 454
    //   555: astore_3
    //   556: aconst_null
    //   557: astore_1
    //   558: goto -204 -> 354
    //   561: astore_3
    //   562: aconst_null
    //   563: astore_1
    //   564: goto -409 -> 155
    //   567: astore_3
    //   568: goto -229 -> 339
    //   571: astore_3
    //   572: goto -276 -> 296
    //   575: iconst_0
    //   576: istore_2
    //   577: goto -323 -> 254
    //   580: astore_1
    //   581: aconst_null
    //   582: astore_1
    //   583: goto -287 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	paramString	String
    //   0	586	1	paramMap	java.util.Map<String, String>
    //   255	322	2	i	int
    //   111	11	3	localIterator	java.util.Iterator
    //   152	16	3	localMalformedURLException1	java.net.MalformedURLException
    //   202	75	3	locala	d.a
    //   336	14	3	localObject1	Object
    //   351	60	3	localIOException1	IOException
    //   451	16	3	localException1	Exception
    //   528	4	3	localException2	Exception
    //   549	1	3	localException3	Exception
    //   555	1	3	localIOException2	IOException
    //   561	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   567	1	3	localObject2	Object
    //   571	1	3	localIOException3	IOException
    //   130	152	4	str	String
    // Exception table:
    //   from	to	target	type
    //   29	36	48	java/lang/Exception
    //   61	87	152	java/net/MalformedURLException
    //   91	112	152	java/net/MalformedURLException
    //   112	149	152	java/net/MalformedURLException
    //   195	232	152	java/net/MalformedURLException
    //   247	251	152	java/net/MalformedURLException
    //   254	267	152	java/net/MalformedURLException
    //   276	289	152	java/net/MalformedURLException
    //   296	300	152	java/net/MalformedURLException
    //   339	351	152	java/net/MalformedURLException
    //   304	311	323	java/lang/Exception
    //   232	239	336	finally
    //   61	87	351	java/io/IOException
    //   91	112	351	java/io/IOException
    //   112	149	351	java/io/IOException
    //   195	232	351	java/io/IOException
    //   247	251	351	java/io/IOException
    //   254	267	351	java/io/IOException
    //   276	289	351	java/io/IOException
    //   296	300	351	java/io/IOException
    //   339	351	351	java/io/IOException
    //   393	400	412	java/lang/Exception
    //   176	183	425	java/lang/Exception
    //   375	382	438	java/lang/Exception
    //   6	21	451	java/lang/Exception
    //   475	482	489	java/lang/Exception
    //   6	21	502	finally
    //   509	516	528	java/lang/Exception
    //   61	87	541	finally
    //   91	112	541	finally
    //   112	149	541	finally
    //   195	232	541	finally
    //   247	251	541	finally
    //   254	267	541	finally
    //   276	289	541	finally
    //   296	300	541	finally
    //   339	351	541	finally
    //   157	172	545	finally
    //   356	371	545	finally
    //   456	471	545	finally
    //   61	87	549	java/lang/Exception
    //   91	112	549	java/lang/Exception
    //   112	149	549	java/lang/Exception
    //   195	232	549	java/lang/Exception
    //   247	251	549	java/lang/Exception
    //   254	267	549	java/lang/Exception
    //   276	289	549	java/lang/Exception
    //   296	300	549	java/lang/Exception
    //   339	351	549	java/lang/Exception
    //   6	21	555	java/io/IOException
    //   6	21	561	java/net/MalformedURLException
    //   239	247	567	finally
    //   239	247	571	java/io/IOException
    //   232	239	580	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.d
 * JD-Core Version:    0.7.0.1
 */