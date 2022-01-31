package com.tencent.mm.plugin.webview.ui.tools.preload;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class b
{
  public static int rBe = 30000;
  public static int rBf = 30000;
  
  /* Error */
  public static b.a a(String paramString1, java.util.Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: new 24	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 28	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 32	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 34	java/net/HttpURLConnection
    //   14: astore 4
    //   16: aload 4
    //   18: getstatic 13	com/tencent/mm/plugin/webview/ui/tools/preload/b:rBe	I
    //   21: invokevirtual 38	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   24: aload 4
    //   26: getstatic 15	com/tencent/mm/plugin/webview/ui/tools/preload/b:rBf	I
    //   29: invokevirtual 41	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   32: aload 4
    //   34: ldc 43
    //   36: invokevirtual 46	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: aload 4
    //   41: iconst_1
    //   42: invokevirtual 50	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   45: aload 4
    //   47: iconst_1
    //   48: invokevirtual 53	java/net/HttpURLConnection:setDoInput	(Z)V
    //   51: aload 4
    //   53: iconst_0
    //   54: invokevirtual 56	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   57: aload_1
    //   58: ifnull +83 -> 141
    //   61: aload_1
    //   62: invokeinterface 62 1 0
    //   67: ifle +74 -> 141
    //   70: aload_1
    //   71: invokeinterface 66 1 0
    //   76: invokeinterface 72 1 0
    //   81: astore_0
    //   82: aload_0
    //   83: invokeinterface 78 1 0
    //   88: ifeq +53 -> 141
    //   91: aload_0
    //   92: invokeinterface 82 1 0
    //   97: checkcast 84	java/lang/String
    //   100: astore 5
    //   102: aload 4
    //   104: aload 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 88 2 0
    //   114: checkcast 84	java/lang/String
    //   117: invokevirtual 92	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: goto -38 -> 82
    //   123: astore_0
    //   124: ldc 94
    //   126: ldc 96
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: aastore
    //   136: invokestatic 102	com/tencent/mm/sdk/platformtools/y:l	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aconst_null
    //   140: areturn
    //   141: aload_2
    //   142: invokevirtual 106	java/lang/String:getBytes	()[B
    //   145: astore_0
    //   146: aload 4
    //   148: invokevirtual 109	java/net/HttpURLConnection:connect	()V
    //   151: new 111	java/io/DataOutputStream
    //   154: dup
    //   155: aload 4
    //   157: invokevirtual 115	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   160: invokespecial 118	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: astore_1
    //   164: aload_1
    //   165: aload_0
    //   166: invokevirtual 122	java/io/DataOutputStream:write	([B)V
    //   169: aload_1
    //   170: invokevirtual 125	java/io/DataOutputStream:flush	()V
    //   173: new 6	com/tencent/mm/plugin/webview/ui/tools/preload/b$a
    //   176: dup
    //   177: invokespecial 127	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:<init>	()V
    //   180: astore_1
    //   181: aload_1
    //   182: aload 4
    //   184: invokevirtual 130	java/net/HttpURLConnection:getResponseCode	()I
    //   187: putfield 133	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:statusCode	I
    //   190: aload_1
    //   191: getfield 133	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:statusCode	I
    //   194: sipush 200
    //   197: if_icmpne +118 -> 315
    //   200: aload 4
    //   202: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   205: astore_0
    //   206: aload 4
    //   208: invokevirtual 141	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   211: astore_2
    //   212: aload_2
    //   213: aload_0
    //   214: invokestatic 145	com/tencent/mm/plugin/webview/ui/tools/preload/b:f	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   217: astore_0
    //   218: aload_1
    //   219: aload_0
    //   220: invokestatic 149	com/tencent/mm/plugin/webview/ui/tools/preload/b:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   223: putfield 153	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:data	Ljava/lang/String;
    //   226: aload_0
    //   227: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   230: goto +85 -> 315
    //   233: aload 4
    //   235: iload_3
    //   236: invokevirtual 161	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   239: astore_0
    //   240: aload 4
    //   242: iload_3
    //   243: invokevirtual 164	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   246: astore_2
    //   247: aload_0
    //   248: ifnonnull +7 -> 255
    //   251: aload_2
    //   252: ifnull +53 -> 305
    //   255: aload_1
    //   256: getfield 168	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:gRQ	Ljava/util/Map;
    //   259: aload_0
    //   260: aload_2
    //   261: invokeinterface 172 3 0
    //   266: pop
    //   267: iload_3
    //   268: iconst_1
    //   269: iadd
    //   270: istore_3
    //   271: goto -38 -> 233
    //   274: aload_0
    //   275: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   278: aconst_null
    //   279: areturn
    //   280: aload_0
    //   281: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   284: aload_1
    //   285: athrow
    //   286: astore_0
    //   287: ldc 94
    //   289: ldc 96
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload_0
    //   298: aastore
    //   299: invokestatic 102	com/tencent/mm/sdk/platformtools/y:l	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: goto -163 -> 139
    //   305: aload_1
    //   306: areturn
    //   307: astore_1
    //   308: goto -28 -> 280
    //   311: astore_1
    //   312: goto -38 -> 274
    //   315: iconst_0
    //   316: istore_3
    //   317: goto -84 -> 233
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_0
    //   323: goto -49 -> 274
    //   326: astore_1
    //   327: aconst_null
    //   328: astore_0
    //   329: goto -49 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString1	String
    //   0	332	1	paramMap	java.util.Map<String, String>
    //   0	332	2	paramString2	String
    //   235	82	3	i	int
    //   14	227	4	localHttpURLConnection	java.net.HttpURLConnection
    //   100	8	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	57	123	java/net/MalformedURLException
    //   61	82	123	java/net/MalformedURLException
    //   82	120	123	java/net/MalformedURLException
    //   141	212	123	java/net/MalformedURLException
    //   226	230	123	java/net/MalformedURLException
    //   233	247	123	java/net/MalformedURLException
    //   255	267	123	java/net/MalformedURLException
    //   274	278	123	java/net/MalformedURLException
    //   280	286	123	java/net/MalformedURLException
    //   0	57	286	java/io/IOException
    //   61	82	286	java/io/IOException
    //   82	120	286	java/io/IOException
    //   141	212	286	java/io/IOException
    //   226	230	286	java/io/IOException
    //   233	247	286	java/io/IOException
    //   255	267	286	java/io/IOException
    //   274	278	286	java/io/IOException
    //   280	286	286	java/io/IOException
    //   218	226	307	finally
    //   218	226	311	java/io/IOException
    //   212	218	320	java/io/IOException
    //   212	218	326	finally
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  private static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 181	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 184	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_0
    //   9: new 186	java/io/BufferedReader
    //   12: dup
    //   13: aload_0
    //   14: sipush 512
    //   17: invokespecial 189	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_1
    //   21: new 191	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_1
    //   30: invokevirtual 195	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +41 -> 76
    //   38: aload_2
    //   39: new 191	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   46: aload_3
    //   47: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 201
    //   52: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -33 -> 29
    //   65: astore_2
    //   66: aload_0
    //   67: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   70: aload_1
    //   71: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload_0
    //   77: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   80: aload_1
    //   81: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   84: aload_2
    //   85: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: areturn
    //   89: astore_2
    //   90: aload_0
    //   91: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   94: aload_1
    //   95: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramInputStream	InputStream
    //   20	75	1	localBufferedReader	java.io.BufferedReader
    //   28	11	2	localStringBuilder	java.lang.StringBuilder
    //   65	20	2	localIOException	IOException
    //   89	10	2	localObject	Object
    //   33	14	3	str	String
    // Exception table:
    //   from	to	target	type
    //   29	34	65	java/io/IOException
    //   38	62	65	java/io/IOException
    //   29	34	89	finally
    //   38	62	89	finally
  }
  
  private static InputStream f(String paramString, InputStream paramInputStream)
  {
    if ((paramString == null) || ("identity".equalsIgnoreCase(paramString))) {
      return paramInputStream;
    }
    if ("gzip".equalsIgnoreCase(paramString)) {
      return new GZIPInputStream(paramInputStream);
    }
    if ("deflate".equalsIgnoreCase(paramString)) {
      return new InflaterInputStream(paramInputStream, new Inflater(false), 512);
    }
    throw new RuntimeException("unsupported content-encoding: " + paramString);
  }
  
  /* Error */
  public static b.a v(String paramString, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: new 24	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 28	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 32	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 34	java/net/HttpURLConnection
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: aload_3
    //   22: getstatic 13	com/tencent/mm/plugin/webview/ui/tools/preload/b:rBe	I
    //   25: invokevirtual 38	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   28: aload_3
    //   29: getstatic 15	com/tencent/mm/plugin/webview/ui/tools/preload/b:rBf	I
    //   32: invokevirtual 41	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   35: aload_3
    //   36: ldc 236
    //   38: invokevirtual 46	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 56	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   46: aload_1
    //   47: ifnull +82 -> 129
    //   50: aload_1
    //   51: invokeinterface 62 1 0
    //   56: ifle +73 -> 129
    //   59: aload_1
    //   60: invokeinterface 66 1 0
    //   65: invokeinterface 72 1 0
    //   70: astore_0
    //   71: aload_0
    //   72: invokeinterface 78 1 0
    //   77: ifeq +52 -> 129
    //   80: aload_0
    //   81: invokeinterface 82 1 0
    //   86: checkcast 84	java/lang/String
    //   89: astore 4
    //   91: aload_3
    //   92: aload 4
    //   94: aload_1
    //   95: aload 4
    //   97: invokeinterface 88 2 0
    //   102: checkcast 84	java/lang/String
    //   105: invokevirtual 92	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -37 -> 71
    //   111: astore_0
    //   112: ldc 94
    //   114: ldc 96
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: invokestatic 102	com/tencent/mm/sdk/platformtools/y:l	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aconst_null
    //   128: areturn
    //   129: new 6	com/tencent/mm/plugin/webview/ui/tools/preload/b$a
    //   132: dup
    //   133: invokespecial 127	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:<init>	()V
    //   136: astore_1
    //   137: aload_1
    //   138: aload_3
    //   139: invokevirtual 130	java/net/HttpURLConnection:getResponseCode	()I
    //   142: putfield 133	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:statusCode	I
    //   145: aload_1
    //   146: getfield 133	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:statusCode	I
    //   149: sipush 200
    //   152: if_icmpne +119 -> 271
    //   155: aload_3
    //   156: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   159: astore_0
    //   160: aload_3
    //   161: invokevirtual 141	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   164: astore 4
    //   166: aload 4
    //   168: aload_0
    //   169: invokestatic 145	com/tencent/mm/plugin/webview/ui/tools/preload/b:f	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   172: astore_0
    //   173: aload_1
    //   174: aload_0
    //   175: invokestatic 149	com/tencent/mm/plugin/webview/ui/tools/preload/b:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   178: putfield 153	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:data	Ljava/lang/String;
    //   181: aload_0
    //   182: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   185: goto +86 -> 271
    //   188: aload_3
    //   189: iload_2
    //   190: invokevirtual 161	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   193: astore_0
    //   194: aload_3
    //   195: iload_2
    //   196: invokevirtual 164	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   199: astore 4
    //   201: aload_0
    //   202: ifnonnull +8 -> 210
    //   205: aload 4
    //   207: ifnull +54 -> 261
    //   210: aload_1
    //   211: getfield 168	com/tencent/mm/plugin/webview/ui/tools/preload/b$a:gRQ	Ljava/util/Map;
    //   214: aload_0
    //   215: aload 4
    //   217: invokeinterface 172 3 0
    //   222: pop
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -39 -> 188
    //   230: aload_0
    //   231: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   234: aconst_null
    //   235: areturn
    //   236: aload_0
    //   237: invokestatic 157	com/tencent/mm/plugin/webview/ui/tools/preload/b:closeQuietly	(Ljava/io/Closeable;)V
    //   240: aload_1
    //   241: athrow
    //   242: astore_0
    //   243: ldc 94
    //   245: ldc 96
    //   247: iconst_1
    //   248: anewarray 4	java/lang/Object
    //   251: dup
    //   252: iconst_0
    //   253: aload_0
    //   254: aastore
    //   255: invokestatic 102	com/tencent/mm/sdk/platformtools/y:l	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: goto -131 -> 127
    //   261: aload_1
    //   262: areturn
    //   263: astore_1
    //   264: goto -28 -> 236
    //   267: astore_1
    //   268: goto -38 -> 230
    //   271: iconst_0
    //   272: istore_2
    //   273: goto -85 -> 188
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -49 -> 230
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_0
    //   285: goto -49 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramString	String
    //   0	288	1	paramMap	java.util.Map<String, String>
    //   189	84	2	i	int
    //   14	181	3	localHttpURLConnection	java.net.HttpURLConnection
    //   89	127	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	15	111	java/net/MalformedURLException
    //   21	46	111	java/net/MalformedURLException
    //   50	71	111	java/net/MalformedURLException
    //   71	108	111	java/net/MalformedURLException
    //   129	166	111	java/net/MalformedURLException
    //   181	185	111	java/net/MalformedURLException
    //   188	201	111	java/net/MalformedURLException
    //   210	223	111	java/net/MalformedURLException
    //   230	234	111	java/net/MalformedURLException
    //   236	242	111	java/net/MalformedURLException
    //   0	15	242	java/io/IOException
    //   21	46	242	java/io/IOException
    //   50	71	242	java/io/IOException
    //   71	108	242	java/io/IOException
    //   129	166	242	java/io/IOException
    //   181	185	242	java/io/IOException
    //   188	201	242	java/io/IOException
    //   210	223	242	java/io/IOException
    //   230	234	242	java/io/IOException
    //   236	242	242	java/io/IOException
    //   173	181	263	finally
    //   173	181	267	java/io/IOException
    //   166	173	276	java/io/IOException
    //   166	173	282	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.b
 * JD-Core Version:    0.7.0.1
 */