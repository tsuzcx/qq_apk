package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class gk
  implements fw
{
  protected static final boolean a = gj.b;
  private static int d = 3000;
  private static int e = 4096;
  protected final gn b;
  protected final gl c;
  
  public gk(gn paramgn)
  {
    this(paramgn, new gl(e));
    AppMethodBeat.i(147997);
    AppMethodBeat.o(147997);
  }
  
  public gk(gn paramgn, gl paramgl)
  {
    this.b = paramgn;
    this.c = paramgl;
  }
  
  protected static Map<String, String> a(Set<Map.Entry<String, List<String>>> paramSet)
  {
    AppMethodBeat.i(148002);
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramSet.next();
      if (localEntry.getKey() != null) {
        localTreeMap.put(localEntry.getKey(), ((List)localEntry.getValue()).get(0));
      }
    }
    AppMethodBeat.o(148002);
    return localTreeMap;
  }
  
  private void a(long paramLong, gb<?> paramgb, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(147999);
    if ((a) || (paramLong > d)) {
      if (paramArrayOfByte == null) {
        break label87;
      }
    }
    label87:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      gj.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramgb, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramInt), Integer.valueOf(paramgb.q().b()) });
      AppMethodBeat.o(147999);
      return;
    }
  }
  
  private static void a(String paramString, gb<?> paramgb, gi paramgi)
  {
    AppMethodBeat.i(148000);
    gf localgf = paramgb.q();
    int i = paramgb.p();
    try
    {
      localgf.a(paramgi);
      paramgb.a(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      AppMethodBeat.o(148000);
      return;
    }
    catch (gi paramgi)
    {
      paramgb.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      AppMethodBeat.o(148000);
      throw paramgi;
    }
  }
  
  private byte[] a(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(148001);
    gp localgp = new gp(this.c, paramHttpURLConnection.getContentLength());
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    InputStream localInputStream;
    try
    {
      localInputStream = paramHttpURLConnection.getInputStream();
      if (localInputStream == null)
      {
        localObject = arrayOfByte;
        paramHttpURLConnection = new gg();
        localObject = arrayOfByte;
        AppMethodBeat.o(148001);
        localObject = arrayOfByte;
        throw paramHttpURLConnection;
      }
    }
    finally
    {
      this.c.a((byte[])localObject);
      localgp.close();
      AppMethodBeat.o(148001);
    }
    localObject = arrayOfByte;
    paramHttpURLConnection = this.c.a(1024);
    for (;;)
    {
      localObject = paramHttpURLConnection;
      int i = localInputStream.read(paramHttpURLConnection);
      if (i == -1) {
        break;
      }
      localObject = paramHttpURLConnection;
      localgp.write(paramHttpURLConnection, 0, i);
    }
    localObject = paramHttpURLConnection;
    localInputStream.close();
    localObject = paramHttpURLConnection;
    arrayOfByte = localgp.toByteArray();
    this.c.a(paramHttpURLConnection);
    localgp.close();
    AppMethodBeat.o(148001);
    return arrayOfByte;
  }
  
  /* Error */
  public fz a(gb<?> paramgb)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 215	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore 4
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_3
    //   14: if_icmpge +548 -> 562
    //   17: aconst_null
    //   18: astore 10
    //   20: aconst_null
    //   21: astore 9
    //   23: invokestatic 221	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   26: astore 8
    //   28: new 223	java/util/HashMap
    //   31: dup
    //   32: invokespecial 224	java/util/HashMap:<init>	()V
    //   35: astore 6
    //   37: aload_0
    //   38: getfield 51	com/tencent/tencentmap/mapsdk/maps/a/gk:b	Lcom/tencent/tencentmap/mapsdk/maps/a/gn;
    //   41: aload_1
    //   42: aload 6
    //   44: invokeinterface 229 3 0
    //   49: astore 7
    //   51: aload 8
    //   53: astore 6
    //   55: aload 7
    //   57: invokevirtual 232	java/net/HttpURLConnection:getResponseCode	()I
    //   60: istore_3
    //   61: aload 8
    //   63: astore 6
    //   65: aload 7
    //   67: invokevirtual 235	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   70: invokeinterface 239 1 0
    //   75: invokestatic 241	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(Ljava/util/Set;)Ljava/util/Map;
    //   78: astore 10
    //   80: iload_3
    //   81: sipush 304
    //   84: if_icmpne +37 -> 121
    //   87: aload 10
    //   89: astore 6
    //   91: new 243	com/tencent/tencentmap/mapsdk/maps/a/fz
    //   94: dup
    //   95: sipush 304
    //   98: aconst_null
    //   99: aload 10
    //   101: iconst_1
    //   102: invokestatic 215	android/os/SystemClock:elapsedRealtime	()J
    //   105: lload 4
    //   107: lsub
    //   108: invokespecial 246	com/tencent/tencentmap/mapsdk/maps/a/fz:<init>	(I[BLjava/util/Map;ZJ)V
    //   111: astore 8
    //   113: ldc 209
    //   115: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload 8
    //   120: areturn
    //   121: aload 9
    //   123: astore 6
    //   125: aload 7
    //   127: ifnull +19 -> 146
    //   130: aload 10
    //   132: astore 6
    //   134: aload_0
    //   135: aload 7
    //   137: invokespecial 248	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(Ljava/net/HttpURLConnection;)[B
    //   140: astore 8
    //   142: aload 8
    //   144: astore 6
    //   146: aload_0
    //   147: invokestatic 215	android/os/SystemClock:elapsedRealtime	()J
    //   150: lload 4
    //   152: lsub
    //   153: aload_1
    //   154: aload 6
    //   156: aload 7
    //   158: invokevirtual 232	java/net/HttpURLConnection:getResponseCode	()I
    //   161: invokespecial 250	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(JLcom/tencent/tencentmap/mapsdk/maps/a/gb;[BI)V
    //   164: iload_3
    //   165: sipush 200
    //   168: if_icmplt +10 -> 178
    //   171: iload_3
    //   172: sipush 299
    //   175: if_icmple +42 -> 217
    //   178: new 208	java/io/IOException
    //   181: dup
    //   182: invokespecial 251	java/io/IOException:<init>	()V
    //   185: astore 8
    //   187: ldc 209
    //   189: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload 8
    //   194: athrow
    //   195: astore 6
    //   197: ldc 253
    //   199: aload_1
    //   200: new 255	com/tencent/tencentmap/mapsdk/maps/a/gh
    //   203: dup
    //   204: invokespecial 256	com/tencent/tencentmap/mapsdk/maps/a/gh:<init>	()V
    //   207: invokestatic 258	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(Ljava/lang/String;Lcom/tencent/tencentmap/mapsdk/maps/a/gb;Lcom/tencent/tencentmap/mapsdk/maps/a/gi;)V
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: istore_2
    //   214: goto -202 -> 12
    //   217: new 243	com/tencent/tencentmap/mapsdk/maps/a/fz
    //   220: dup
    //   221: iload_3
    //   222: aload 6
    //   224: aload 10
    //   226: iconst_0
    //   227: invokestatic 215	android/os/SystemClock:elapsedRealtime	()J
    //   230: lload 4
    //   232: lsub
    //   233: invokespecial 246	com/tencent/tencentmap/mapsdk/maps/a/fz:<init>	(I[BLjava/util/Map;ZJ)V
    //   236: astore 8
    //   238: ldc 209
    //   240: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload 8
    //   245: areturn
    //   246: astore 6
    //   248: new 260	java/lang/RuntimeException
    //   251: dup
    //   252: new 262	java/lang/StringBuilder
    //   255: dup
    //   256: ldc_w 264
    //   259: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: aload_1
    //   263: invokevirtual 269	com/tencent/tencentmap/mapsdk/maps/a/gb:c	()Ljava/lang/String;
    //   266: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: aload 6
    //   274: invokespecial 279	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: astore_1
    //   278: ldc 209
    //   280: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: aload_1
    //   284: athrow
    //   285: astore 7
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 8
    //   292: astore 6
    //   294: aload 10
    //   296: astore 8
    //   298: aload 8
    //   300: ifnull +115 -> 415
    //   303: aload 8
    //   305: invokevirtual 232	java/net/HttpURLConnection:getResponseCode	()I
    //   308: istore_3
    //   309: ldc_w 281
    //   312: iconst_2
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: iload_3
    //   319: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: aload_1
    //   326: invokevirtual 269	com/tencent/tencentmap/mapsdk/maps/a/gb:c	()Ljava/lang/String;
    //   329: aastore
    //   330: invokestatic 283	com/tencent/tencentmap/mapsdk/maps/a/gj:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: aload 9
    //   335: ifnull +210 -> 545
    //   338: new 243	com/tencent/tencentmap/mapsdk/maps/a/fz
    //   341: dup
    //   342: iload_3
    //   343: aload 9
    //   345: aload 6
    //   347: iconst_0
    //   348: invokestatic 215	android/os/SystemClock:elapsedRealtime	()J
    //   351: lload 4
    //   353: lsub
    //   354: invokespecial 246	com/tencent/tencentmap/mapsdk/maps/a/fz:<init>	(I[BLjava/util/Map;ZJ)V
    //   357: astore 6
    //   359: iload_3
    //   360: sipush 401
    //   363: if_icmpeq +10 -> 373
    //   366: iload_3
    //   367: sipush 403
    //   370: if_icmpne +64 -> 434
    //   373: ldc_w 285
    //   376: aload_1
    //   377: new 287	com/tencent/tencentmap/mapsdk/maps/a/fs
    //   380: dup
    //   381: aload 6
    //   383: invokespecial 290	com/tencent/tencentmap/mapsdk/maps/a/fs:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/fz;)V
    //   386: invokestatic 258	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(Ljava/lang/String;Lcom/tencent/tencentmap/mapsdk/maps/a/gb;Lcom/tencent/tencentmap/mapsdk/maps/a/gi;)V
    //   389: goto -179 -> 210
    //   392: astore 6
    //   394: ldc_w 292
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload 6
    //   405: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   408: aastore
    //   409: invokestatic 283	com/tencent/tencentmap/mapsdk/maps/a/gj:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: goto -202 -> 210
    //   415: new 297	com/tencent/tencentmap/mapsdk/maps/a/ga
    //   418: dup
    //   419: aload 7
    //   421: invokespecial 300	com/tencent/tencentmap/mapsdk/maps/a/ga:<init>	(Ljava/lang/Throwable;)V
    //   424: astore 6
    //   426: ldc 209
    //   428: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: aload 6
    //   433: athrow
    //   434: iload_3
    //   435: sipush 400
    //   438: if_icmplt +29 -> 467
    //   441: iload_3
    //   442: sipush 499
    //   445: if_icmpgt +22 -> 467
    //   448: new 302	com/tencent/tencentmap/mapsdk/maps/a/ft
    //   451: dup
    //   452: aload 6
    //   454: invokespecial 303	com/tencent/tencentmap/mapsdk/maps/a/ft:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/fz;)V
    //   457: astore 6
    //   459: ldc 209
    //   461: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: aload 6
    //   466: athrow
    //   467: iload_3
    //   468: sipush 500
    //   471: if_icmplt +55 -> 526
    //   474: iload_3
    //   475: sipush 599
    //   478: if_icmpgt +48 -> 526
    //   481: aload_1
    //   482: invokevirtual 306	com/tencent/tencentmap/mapsdk/maps/a/gb:n	()Z
    //   485: ifeq +22 -> 507
    //   488: ldc_w 308
    //   491: aload_1
    //   492: new 176	com/tencent/tencentmap/mapsdk/maps/a/gg
    //   495: dup
    //   496: aload 6
    //   498: invokespecial 309	com/tencent/tencentmap/mapsdk/maps/a/gg:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/fz;)V
    //   501: invokestatic 258	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(Ljava/lang/String;Lcom/tencent/tencentmap/mapsdk/maps/a/gb;Lcom/tencent/tencentmap/mapsdk/maps/a/gi;)V
    //   504: goto -294 -> 210
    //   507: new 176	com/tencent/tencentmap/mapsdk/maps/a/gg
    //   510: dup
    //   511: aload 6
    //   513: invokespecial 309	com/tencent/tencentmap/mapsdk/maps/a/gg:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/fz;)V
    //   516: astore 6
    //   518: ldc 209
    //   520: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: aload 6
    //   525: athrow
    //   526: new 176	com/tencent/tencentmap/mapsdk/maps/a/gg
    //   529: dup
    //   530: aload 6
    //   532: invokespecial 309	com/tencent/tencentmap/mapsdk/maps/a/gg:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/fz;)V
    //   535: astore 6
    //   537: ldc 209
    //   539: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload 6
    //   544: athrow
    //   545: ldc_w 311
    //   548: aload_1
    //   549: new 313	com/tencent/tencentmap/mapsdk/maps/a/fy
    //   552: dup
    //   553: invokespecial 314	com/tencent/tencentmap/mapsdk/maps/a/fy:<init>	()V
    //   556: invokestatic 258	com/tencent/tencentmap/mapsdk/maps/a/gk:a	(Ljava/lang/String;Lcom/tencent/tencentmap/mapsdk/maps/a/gb;Lcom/tencent/tencentmap/mapsdk/maps/a/gi;)V
    //   559: goto -349 -> 210
    //   562: ldc 209
    //   564: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   567: aconst_null
    //   568: areturn
    //   569: astore 10
    //   571: aconst_null
    //   572: astore 9
    //   574: aload 7
    //   576: astore 8
    //   578: aload 10
    //   580: astore 7
    //   582: goto -284 -> 298
    //   585: astore 9
    //   587: aload 7
    //   589: astore 8
    //   591: aload 9
    //   593: astore 7
    //   595: aload 6
    //   597: astore 9
    //   599: aload 10
    //   601: astore 6
    //   603: goto -305 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	gk
    //   0	606	1	paramgb	gb<?>
    //   11	203	2	i	int
    //   60	419	3	j	int
    //   8	344	4	l	long
    //   35	120	6	localObject1	Object
    //   195	28	6	localSocketTimeoutException	java.net.SocketTimeoutException
    //   246	27	6	localMalformedURLException	java.net.MalformedURLException
    //   292	90	6	localObject2	Object
    //   392	12	6	localIOException1	java.io.IOException
    //   424	178	6	localObject3	Object
    //   49	108	7	localHttpURLConnection	HttpURLConnection
    //   285	290	7	localIOException2	java.io.IOException
    //   580	14	7	localIOException3	java.io.IOException
    //   26	564	8	localObject4	Object
    //   21	552	9	arrayOfByte	byte[]
    //   585	7	9	localIOException4	java.io.IOException
    //   597	1	9	localObject5	Object
    //   18	277	10	localMap	Map
    //   569	31	10	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   28	51	195	java/net/SocketTimeoutException
    //   55	61	195	java/net/SocketTimeoutException
    //   65	80	195	java/net/SocketTimeoutException
    //   91	113	195	java/net/SocketTimeoutException
    //   134	142	195	java/net/SocketTimeoutException
    //   146	164	195	java/net/SocketTimeoutException
    //   178	195	195	java/net/SocketTimeoutException
    //   217	238	195	java/net/SocketTimeoutException
    //   28	51	246	java/net/MalformedURLException
    //   55	61	246	java/net/MalformedURLException
    //   65	80	246	java/net/MalformedURLException
    //   91	113	246	java/net/MalformedURLException
    //   134	142	246	java/net/MalformedURLException
    //   146	164	246	java/net/MalformedURLException
    //   178	195	246	java/net/MalformedURLException
    //   217	238	246	java/net/MalformedURLException
    //   28	51	285	java/io/IOException
    //   303	333	392	java/io/IOException
    //   338	359	392	java/io/IOException
    //   373	389	392	java/io/IOException
    //   415	434	392	java/io/IOException
    //   448	467	392	java/io/IOException
    //   481	504	392	java/io/IOException
    //   507	526	392	java/io/IOException
    //   526	545	392	java/io/IOException
    //   545	559	392	java/io/IOException
    //   55	61	569	java/io/IOException
    //   65	80	569	java/io/IOException
    //   91	113	569	java/io/IOException
    //   134	142	569	java/io/IOException
    //   146	164	585	java/io/IOException
    //   178	195	585	java/io/IOException
    //   217	238	585	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gk
 * JD-Core Version:    0.7.0.1
 */