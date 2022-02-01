package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

public final class d
{
  public static int XsG = 30000;
  public static int XsH = 30000;
  
  /* Error */
  public static byte[] Z(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 30	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 33	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_2
    //   13: sipush 16384
    //   16: newarray byte
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: iconst_0
    //   22: sipush 16384
    //   25: invokevirtual 39	java/io/InputStream:read	([BII)I
    //   28: istore_1
    //   29: iload_1
    //   30: iconst_m1
    //   31: if_icmpeq +39 -> 70
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: iload_1
    //   38: invokevirtual 43	java/io/ByteArrayOutputStream:write	([BII)V
    //   41: goto -22 -> 19
    //   44: astore_2
    //   45: ldc 45
    //   47: ldc 47
    //   49: aload_2
    //   50: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   63: ldc 22
    //   65: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_2
    //   71: invokevirtual 75	java/io/ByteArrayOutputStream:flush	()V
    //   74: aload_0
    //   75: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   78: aload_2
    //   79: invokevirtual 79	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   82: astore_0
    //   83: ldc 22
    //   85: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_0
    //   89: areturn
    //   90: astore_2
    //   91: aload_0
    //   92: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   95: ldc 22
    //   97: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramInputStream	InputStream
    //   28	10	1	i	int
    //   12	23	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   44	35	2	localException	Exception
    //   90	11	2	localObject	Object
    //   18	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   19	29	44	java/lang/Exception
    //   34	41	44	java/lang/Exception
    //   70	74	44	java/lang/Exception
    //   19	29	90	finally
    //   34	41	90	finally
    //   45	59	90	finally
    //   70	74	90	finally
  }
  
  /* Error */
  public static a a(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 87	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 94	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 96	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: getstatic 14	com/tencent/mm/plugin/webview/k/d:XsG	I
    //   24: invokevirtual 99	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   27: aload_0
    //   28: getstatic 16	com/tencent/mm/plugin/webview/k/d:XsH	I
    //   31: invokevirtual 102	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   34: aload_0
    //   35: ldc 104
    //   37: invokevirtual 107	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: invokevirtual 111	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   45: aload_0
    //   46: iconst_1
    //   47: invokevirtual 114	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload_0
    //   51: iconst_0
    //   52: invokevirtual 117	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   55: aload_1
    //   56: ifnull +109 -> 165
    //   59: aload_1
    //   60: invokeinterface 123 1 0
    //   65: ifle +100 -> 165
    //   68: aload_1
    //   69: invokeinterface 127 1 0
    //   74: invokeinterface 133 1 0
    //   79: astore 4
    //   81: aload 4
    //   83: invokeinterface 139 1 0
    //   88: ifeq +77 -> 165
    //   91: aload 4
    //   93: invokeinterface 143 1 0
    //   98: checkcast 49	java/lang/String
    //   101: astore 5
    //   103: aload_0
    //   104: aload 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 147 2 0
    //   114: checkcast 49	java/lang/String
    //   117: invokevirtual 150	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: goto -39 -> 81
    //   123: astore_2
    //   124: aload_0
    //   125: astore_1
    //   126: aload_1
    //   127: astore_0
    //   128: ldc 45
    //   130: ldc 152
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_2
    //   139: aastore
    //   140: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_1
    //   144: ifnull +14 -> 158
    //   147: aload_1
    //   148: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   151: invokevirtual 163	java/io/InputStream:close	()V
    //   154: aload_1
    //   155: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   158: ldc 85
    //   160: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: aload_2
    //   166: invokevirtual 169	java/lang/String:getBytes	()[B
    //   169: astore_1
    //   170: aload_0
    //   171: invokevirtual 172	java/net/HttpURLConnection:connect	()V
    //   174: new 174	java/io/DataOutputStream
    //   177: dup
    //   178: aload_0
    //   179: invokevirtual 178	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   182: invokespecial 181	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   185: astore_2
    //   186: aload_2
    //   187: aload_1
    //   188: invokevirtual 184	java/io/DataOutputStream:write	([B)V
    //   191: aload_2
    //   192: invokevirtual 185	java/io/DataOutputStream:flush	()V
    //   195: new 6	com/tencent/mm/plugin/webview/k/d$a
    //   198: dup
    //   199: invokespecial 186	com/tencent/mm/plugin/webview/k/d$a:<init>	()V
    //   202: astore_2
    //   203: aload_2
    //   204: aload_0
    //   205: invokevirtual 189	java/net/HttpURLConnection:getResponseCode	()I
    //   208: putfield 192	com/tencent/mm/plugin/webview/k/d$a:statusCode	I
    //   211: aload_2
    //   212: getfield 192	com/tencent/mm/plugin/webview/k/d$a:statusCode	I
    //   215: sipush 200
    //   218: if_icmpne +431 -> 649
    //   221: aload_0
    //   222: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   225: astore_1
    //   226: aload_0
    //   227: invokevirtual 196	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   230: astore 4
    //   232: aload 4
    //   234: aload_1
    //   235: invokestatic 200	com/tencent/mm/plugin/webview/k/d:g	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   238: astore_1
    //   239: aload_2
    //   240: aload_1
    //   241: invokestatic 204	com/tencent/mm/plugin/webview/k/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   244: putfield 208	com/tencent/mm/plugin/webview/k/d$a:data	Ljava/lang/String;
    //   247: aload_1
    //   248: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   251: goto +398 -> 649
    //   254: aload_0
    //   255: iload_3
    //   256: invokevirtual 215	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   259: astore_1
    //   260: aload_0
    //   261: iload_3
    //   262: invokevirtual 218	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   265: astore 4
    //   267: aload_1
    //   268: ifnonnull +8 -> 276
    //   271: aload 4
    //   273: ifnull +140 -> 413
    //   276: aload_2
    //   277: getfield 222	com/tencent/mm/plugin/webview/k/d$a:toO	Ljava/util/Map;
    //   280: aload_1
    //   281: aload 4
    //   283: invokeinterface 226 3 0
    //   288: pop
    //   289: iload_3
    //   290: iconst_1
    //   291: iadd
    //   292: istore_3
    //   293: goto -39 -> 254
    //   296: aload_1
    //   297: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   300: aload_0
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   308: invokevirtual 163	java/io/InputStream:close	()V
    //   311: aload_0
    //   312: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   315: ldc 85
    //   317: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aconst_null
    //   321: areturn
    //   322: astore_1
    //   323: ldc 45
    //   325: aload_1
    //   326: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   329: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: goto -21 -> 311
    //   335: astore_0
    //   336: ldc 45
    //   338: aload_0
    //   339: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: goto -30 -> 315
    //   348: astore_2
    //   349: aconst_null
    //   350: astore_1
    //   351: aload_1
    //   352: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   355: ldc 85
    //   357: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: aload_2
    //   361: athrow
    //   362: astore_2
    //   363: aload_0
    //   364: astore_1
    //   365: aload_1
    //   366: astore_0
    //   367: ldc 45
    //   369: ldc 152
    //   371: iconst_1
    //   372: anewarray 4	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: aload_2
    //   378: aastore
    //   379: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: aload_1
    //   383: ifnull -225 -> 158
    //   386: aload_1
    //   387: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   390: invokevirtual 163	java/io/InputStream:close	()V
    //   393: aload_1
    //   394: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   397: goto -239 -> 158
    //   400: astore_0
    //   401: ldc 45
    //   403: aload_0
    //   404: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   407: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: goto -252 -> 158
    //   413: aload_0
    //   414: ifnull +14 -> 428
    //   417: aload_0
    //   418: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   421: invokevirtual 163	java/io/InputStream:close	()V
    //   424: aload_0
    //   425: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   428: ldc 85
    //   430: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aload_2
    //   434: areturn
    //   435: astore_1
    //   436: ldc 45
    //   438: aload_1
    //   439: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   442: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: goto -21 -> 424
    //   448: astore_0
    //   449: ldc 45
    //   451: aload_0
    //   452: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: goto -30 -> 428
    //   461: astore_0
    //   462: ldc 45
    //   464: aload_0
    //   465: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -317 -> 154
    //   474: astore_0
    //   475: ldc 45
    //   477: aload_0
    //   478: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: goto -326 -> 158
    //   487: astore_0
    //   488: ldc 45
    //   490: aload_0
    //   491: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   494: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -104 -> 393
    //   500: astore_2
    //   501: aconst_null
    //   502: astore_1
    //   503: aload_1
    //   504: astore_0
    //   505: ldc 45
    //   507: ldc 152
    //   509: iconst_1
    //   510: anewarray 4	java/lang/Object
    //   513: dup
    //   514: iconst_0
    //   515: aload_2
    //   516: aastore
    //   517: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: aload_1
    //   521: ifnull -363 -> 158
    //   524: aload_1
    //   525: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   528: invokevirtual 163	java/io/InputStream:close	()V
    //   531: aload_1
    //   532: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   535: goto -377 -> 158
    //   538: astore_0
    //   539: ldc 45
    //   541: aload_0
    //   542: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   545: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: goto -390 -> 158
    //   551: astore_0
    //   552: ldc 45
    //   554: aload_0
    //   555: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -30 -> 531
    //   564: astore_1
    //   565: aconst_null
    //   566: astore_0
    //   567: aload_0
    //   568: ifnull +14 -> 582
    //   571: aload_0
    //   572: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   575: invokevirtual 163	java/io/InputStream:close	()V
    //   578: aload_0
    //   579: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   582: ldc 85
    //   584: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: aload_1
    //   588: athrow
    //   589: astore_2
    //   590: ldc 45
    //   592: aload_2
    //   593: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   596: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: goto -21 -> 578
    //   602: astore_0
    //   603: ldc 45
    //   605: aload_0
    //   606: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   609: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  /* Error */
  public static a af(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 234
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 87	java/net/URL
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 94	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 96	java/net/HttpURLConnection
    //   21: astore_0
    //   22: aload_0
    //   23: ifnonnull +38 -> 61
    //   26: aload_0
    //   27: ifnull +14 -> 41
    //   30: aload_0
    //   31: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   34: invokevirtual 163	java/io/InputStream:close	()V
    //   37: aload_0
    //   38: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   41: ldc 234
    //   43: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aconst_null
    //   47: areturn
    //   48: astore_1
    //   49: ldc 45
    //   51: aload_1
    //   52: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   55: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: goto -21 -> 37
    //   61: aload_0
    //   62: getstatic 14	com/tencent/mm/plugin/webview/k/d:XsG	I
    //   65: invokevirtual 99	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload_0
    //   69: getstatic 16	com/tencent/mm/plugin/webview/k/d:XsH	I
    //   72: invokevirtual 102	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   75: aload_0
    //   76: ldc 236
    //   78: invokevirtual 107	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: iconst_0
    //   83: invokevirtual 117	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   86: aload_1
    //   87: ifnull +111 -> 198
    //   90: aload_1
    //   91: invokeinterface 123 1 0
    //   96: ifle +102 -> 198
    //   99: aload_1
    //   100: invokeinterface 127 1 0
    //   105: invokeinterface 133 1 0
    //   110: astore 4
    //   112: aload 4
    //   114: invokeinterface 139 1 0
    //   119: ifeq +79 -> 198
    //   122: aload 4
    //   124: invokeinterface 143 1 0
    //   129: checkcast 49	java/lang/String
    //   132: astore 5
    //   134: aload_0
    //   135: aload 5
    //   137: aload_1
    //   138: aload 5
    //   140: invokeinterface 147 2 0
    //   145: checkcast 49	java/lang/String
    //   148: invokevirtual 150	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: goto -39 -> 112
    //   154: astore 4
    //   156: aload_0
    //   157: astore_1
    //   158: aload_1
    //   159: astore_0
    //   160: ldc 45
    //   162: ldc 152
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload 4
    //   172: aastore
    //   173: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_1
    //   177: ifnull +14 -> 191
    //   180: aload_1
    //   181: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   184: invokevirtual 163	java/io/InputStream:close	()V
    //   187: aload_1
    //   188: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   191: ldc 234
    //   193: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aconst_null
    //   197: areturn
    //   198: new 6	com/tencent/mm/plugin/webview/k/d$a
    //   201: dup
    //   202: invokespecial 186	com/tencent/mm/plugin/webview/k/d$a:<init>	()V
    //   205: astore 4
    //   207: aload 4
    //   209: aload_0
    //   210: invokevirtual 189	java/net/HttpURLConnection:getResponseCode	()I
    //   213: putfield 192	com/tencent/mm/plugin/webview/k/d$a:statusCode	I
    //   216: iconst_0
    //   217: istore_2
    //   218: aload_0
    //   219: iload_2
    //   220: invokevirtual 215	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   223: astore_1
    //   224: aload_0
    //   225: iload_2
    //   226: invokevirtual 218	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   229: astore 5
    //   231: aload_1
    //   232: ifnonnull +8 -> 240
    //   235: aload 5
    //   237: ifnull +24 -> 261
    //   240: aload 4
    //   242: getfield 222	com/tencent/mm/plugin/webview/k/d$a:toO	Ljava/util/Map;
    //   245: aload_1
    //   246: aload 5
    //   248: invokeinterface 226 3 0
    //   253: pop
    //   254: iload_2
    //   255: iconst_1
    //   256: iadd
    //   257: istore_2
    //   258: goto -40 -> 218
    //   261: aload 4
    //   263: getfield 222	com/tencent/mm/plugin/webview/k/d$a:toO	Ljava/util/Map;
    //   266: ldc 238
    //   268: invokeinterface 147 2 0
    //   273: checkcast 49	java/lang/String
    //   276: invokevirtual 241	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   279: astore_1
    //   280: aload_1
    //   281: ldc 243
    //   283: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   286: ifne +382 -> 668
    //   289: aload_1
    //   290: ldc 249
    //   292: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   295: ifne +373 -> 668
    //   298: iload_3
    //   299: istore_2
    //   300: aload_1
    //   301: ldc 251
    //   303: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   306: ifeq +6 -> 312
    //   309: goto +359 -> 668
    //   312: aload 4
    //   314: getfield 192	com/tencent/mm/plugin/webview/k/d$a:statusCode	I
    //   317: sipush 200
    //   320: if_icmpne +38 -> 358
    //   323: aload_0
    //   324: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   327: astore_1
    //   328: aload_0
    //   329: invokevirtual 196	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   332: astore 5
    //   334: aload 5
    //   336: aload_1
    //   337: invokestatic 200	com/tencent/mm/plugin/webview/k/d:g	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   340: astore_1
    //   341: iload_2
    //   342: ifeq +39 -> 381
    //   345: aload 4
    //   347: aload_1
    //   348: invokestatic 253	com/tencent/mm/plugin/webview/k/d:Z	(Ljava/io/InputStream;)[B
    //   351: putfield 257	com/tencent/mm/plugin/webview/k/d$a:XsI	[B
    //   354: aload_1
    //   355: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   358: aload_0
    //   359: ifnull +14 -> 373
    //   362: aload_0
    //   363: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   366: invokevirtual 163	java/io/InputStream:close	()V
    //   369: aload_0
    //   370: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   373: ldc 234
    //   375: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload 4
    //   380: areturn
    //   381: aload 4
    //   383: aload_1
    //   384: invokestatic 204	com/tencent/mm/plugin/webview/k/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   387: putfield 208	com/tencent/mm/plugin/webview/k/d$a:data	Ljava/lang/String;
    //   390: goto -36 -> 354
    //   393: astore 4
    //   395: aload_1
    //   396: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   399: aload_0
    //   400: ifnull +14 -> 414
    //   403: aload_0
    //   404: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   407: invokevirtual 163	java/io/InputStream:close	()V
    //   410: aload_0
    //   411: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   414: ldc 234
    //   416: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aconst_null
    //   420: areturn
    //   421: astore_1
    //   422: ldc 45
    //   424: aload_1
    //   425: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -21 -> 410
    //   434: astore_1
    //   435: aconst_null
    //   436: astore 4
    //   438: aload 4
    //   440: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   443: ldc 234
    //   445: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aload_1
    //   449: athrow
    //   450: astore 4
    //   452: aload_0
    //   453: astore_1
    //   454: aload_1
    //   455: astore_0
    //   456: ldc 45
    //   458: ldc 152
    //   460: iconst_1
    //   461: anewarray 4	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload 4
    //   468: aastore
    //   469: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   472: aload_1
    //   473: ifnull -282 -> 191
    //   476: aload_1
    //   477: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   480: invokevirtual 163	java/io/InputStream:close	()V
    //   483: aload_1
    //   484: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   487: goto -296 -> 191
    //   490: astore_1
    //   491: ldc 45
    //   493: aload_1
    //   494: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   497: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: goto -131 -> 369
    //   503: astore_0
    //   504: ldc 45
    //   506: aload_0
    //   507: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   510: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: goto -326 -> 187
    //   516: astore_0
    //   517: ldc 45
    //   519: aload_0
    //   520: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   523: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: goto -43 -> 483
    //   529: astore 4
    //   531: aconst_null
    //   532: astore_1
    //   533: aload_1
    //   534: astore_0
    //   535: ldc 45
    //   537: ldc 152
    //   539: iconst_1
    //   540: anewarray 4	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload 4
    //   547: aastore
    //   548: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   551: aload_1
    //   552: ifnull -361 -> 191
    //   555: aload_1
    //   556: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   559: invokevirtual 163	java/io/InputStream:close	()V
    //   562: aload_1
    //   563: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   566: goto -375 -> 191
    //   569: astore_0
    //   570: ldc 45
    //   572: aload_0
    //   573: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   576: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: goto -17 -> 562
    //   582: astore_1
    //   583: aconst_null
    //   584: astore_0
    //   585: aload_0
    //   586: ifnull +14 -> 600
    //   589: aload_0
    //   590: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   593: invokevirtual 163	java/io/InputStream:close	()V
    //   596: aload_0
    //   597: invokevirtual 166	java/net/HttpURLConnection:disconnect	()V
    //   600: ldc 234
    //   602: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   605: aload_1
    //   606: athrow
    //   607: astore 4
    //   609: ldc 45
    //   611: aload 4
    //   613: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   616: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: goto -23 -> 596
    //   622: astore_1
    //   623: goto -38 -> 585
    //   626: astore_1
    //   627: goto -42 -> 585
    //   630: astore 4
    //   632: aload_0
    //   633: astore_1
    //   634: goto -101 -> 533
    //   637: astore 4
    //   639: aconst_null
    //   640: astore_1
    //   641: goto -187 -> 454
    //   644: astore 4
    //   646: aconst_null
    //   647: astore_1
    //   648: goto -490 -> 158
    //   651: astore 5
    //   653: aload_1
    //   654: astore 4
    //   656: aload 5
    //   658: astore_1
    //   659: goto -221 -> 438
    //   662: astore_1
    //   663: aconst_null
    //   664: astore_1
    //   665: goto -270 -> 395
    //   668: iconst_1
    //   669: istore_2
    //   670: goto -358 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	paramString	String
    //   0	673	1	paramMap	Map<String, String>
    //   217	453	2	i	int
    //   1	298	3	j	int
    //   110	13	4	localIterator	Iterator
    //   154	17	4	localMalformedURLException1	java.net.MalformedURLException
    //   205	177	4	locala	a
    //   393	1	4	localIOException1	IOException
    //   436	3	4	localCloseable	Closeable
    //   450	17	4	localIOException2	IOException
    //   529	17	4	localException1	Exception
    //   607	5	4	localException2	Exception
    //   630	1	4	localException3	Exception
    //   637	1	4	localIOException3	IOException
    //   644	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   654	1	4	localMap	Map<String, String>
    //   132	203	5	str	String
    //   651	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	48	java/lang/Exception
    //   61	86	154	java/net/MalformedURLException
    //   90	112	154	java/net/MalformedURLException
    //   112	151	154	java/net/MalformedURLException
    //   198	216	154	java/net/MalformedURLException
    //   218	231	154	java/net/MalformedURLException
    //   240	254	154	java/net/MalformedURLException
    //   261	298	154	java/net/MalformedURLException
    //   300	309	154	java/net/MalformedURLException
    //   312	334	154	java/net/MalformedURLException
    //   354	358	154	java/net/MalformedURLException
    //   395	399	154	java/net/MalformedURLException
    //   438	450	154	java/net/MalformedURLException
    //   345	354	393	java/io/IOException
    //   381	390	393	java/io/IOException
    //   403	410	421	java/lang/Exception
    //   334	341	434	finally
    //   61	86	450	java/io/IOException
    //   90	112	450	java/io/IOException
    //   112	151	450	java/io/IOException
    //   198	216	450	java/io/IOException
    //   218	231	450	java/io/IOException
    //   240	254	450	java/io/IOException
    //   261	298	450	java/io/IOException
    //   300	309	450	java/io/IOException
    //   312	334	450	java/io/IOException
    //   354	358	450	java/io/IOException
    //   395	399	450	java/io/IOException
    //   438	450	450	java/io/IOException
    //   362	369	490	java/lang/Exception
    //   180	187	503	java/lang/Exception
    //   476	483	516	java/lang/Exception
    //   7	22	529	java/lang/Exception
    //   555	562	569	java/lang/Exception
    //   7	22	582	finally
    //   589	596	607	java/lang/Exception
    //   61	86	622	finally
    //   90	112	622	finally
    //   112	151	622	finally
    //   198	216	622	finally
    //   218	231	622	finally
    //   240	254	622	finally
    //   261	298	622	finally
    //   300	309	622	finally
    //   312	334	622	finally
    //   354	358	622	finally
    //   395	399	622	finally
    //   438	450	622	finally
    //   160	176	626	finally
    //   456	472	626	finally
    //   535	551	626	finally
    //   61	86	630	java/lang/Exception
    //   90	112	630	java/lang/Exception
    //   112	151	630	java/lang/Exception
    //   198	216	630	java/lang/Exception
    //   218	231	630	java/lang/Exception
    //   240	254	630	java/lang/Exception
    //   261	298	630	java/lang/Exception
    //   300	309	630	java/lang/Exception
    //   312	334	630	java/lang/Exception
    //   354	358	630	java/lang/Exception
    //   395	399	630	java/lang/Exception
    //   438	450	630	java/lang/Exception
    //   7	22	637	java/io/IOException
    //   7	22	644	java/net/MalformedURLException
    //   345	354	651	finally
    //   381	390	651	finally
    //   334	341	662	java/io/IOException
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(295776);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(295776);
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.printInfoStack("MicroMsg.RequestUtil", "", new Object[] { paramCloseable });
      AppMethodBeat.o(295776);
      return;
    }
    catch (Exception paramCloseable)
    {
      Log.printInfoStack("MicroMsg.RequestUtil", "", new Object[] { paramCloseable });
      AppMethodBeat.o(295776);
    }
  }
  
  /* Error */
  private static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 265	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 268	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   14: astore_0
    //   15: new 270	java/io/BufferedReader
    //   18: dup
    //   19: aload_0
    //   20: sipush 512
    //   23: invokespecial 273	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_1
    //   27: new 275	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual 279	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +63 -> 104
    //   44: aload_2
    //   45: new 275	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   52: aload_3
    //   53: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 285
    //   59: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -34 -> 35
    //   72: astore_2
    //   73: ldc 45
    //   75: ldc 152
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_2
    //   84: aastore
    //   85: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   92: aload_1
    //   93: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   96: ldc_w 263
    //   99: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aconst_null
    //   103: areturn
    //   104: aload_0
    //   105: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   108: aload_1
    //   109: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   112: aload_2
    //   113: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_0
    //   117: ldc_w 263
    //   120: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: ldc 45
    //   128: ldc 152
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: aastore
    //   138: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_0
    //   142: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   145: aload_1
    //   146: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   149: ldc_w 263
    //   152: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_2
    //   158: aload_0
    //   159: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   162: aload_1
    //   163: invokestatic 211	com/tencent/mm/plugin/webview/k/d:closeQuietly	(Ljava/io/Closeable;)V
    //   166: ldc_w 263
    //   169: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_2
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramInputStream	InputStream
    //   26	137	1	localBufferedReader	java.io.BufferedReader
    //   34	11	2	localStringBuilder	java.lang.StringBuilder
    //   72	41	2	localIOException	IOException
    //   125	12	2	localException	Exception
    //   157	16	2	localObject	Object
    //   39	14	3	str	String
    // Exception table:
    //   from	to	target	type
    //   35	40	72	java/io/IOException
    //   44	69	72	java/io/IOException
    //   35	40	125	java/lang/Exception
    //   44	69	125	java/lang/Exception
    //   35	40	157	finally
    //   44	69	157	finally
    //   73	88	157	finally
    //   126	141	157	finally
  }
  
  public static void cv(Map paramMap)
  {
    AppMethodBeat.i(295759);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        cv((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(295759);
  }
  
  private static InputStream g(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(295763);
    if ((paramString == null) || ("identity".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(295763);
      return paramInputStream;
    }
    if ("gzip".equalsIgnoreCase(paramString))
    {
      paramString = new GZIPInputStream(paramInputStream);
      AppMethodBeat.o(295763);
      return paramString;
    }
    if ("deflate".equalsIgnoreCase(paramString))
    {
      paramString = new InflaterInputStream(paramInputStream, new Inflater(false), 512);
      AppMethodBeat.o(295763);
      return paramString;
    }
    paramString = new RuntimeException("unsupported content-encoding: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(295763);
    throw paramString;
  }
  
  public static final class a
  {
    public byte[] XsI;
    public String data;
    public int statusCode;
    public Map<String, String> toO;
    
    public a()
    {
      AppMethodBeat.i(295747);
      this.toO = new HashMap();
      this.data = "";
      this.XsI = null;
      AppMethodBeat.o(295747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.d
 * JD-Core Version:    0.7.0.1
 */