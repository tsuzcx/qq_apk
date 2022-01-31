package com.tencent.mrs.a;

import android.os.Build.VERSION;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class c
{
  static HttpURLConnection a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    int i = paramArrayOfByte.length;
    Object localObject = com.tencent.mm.a.g.o(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.spa), Integer.valueOf(i) }).getBytes()).toLowerCase();
    paramArrayOfByte = com.tencent.mm.a.q.l(paramArrayOfByte);
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.a.c.a(localPByteArray, paramArrayOfByte, ((String)localObject).getBytes());
    if ((ae.cqV()) && (com.tencent.mm.kernel.g.DK())) {}
    for (paramArrayOfByte = com.tencent.mm.model.q.Gj();; paramArrayOfByte = null)
    {
      String str = "android-" + Build.VERSION.SDK_INT;
      localObject = new StringBuilder(512).append("http://support.weixin.qq.com/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.spa)).append("&devicetype=").append(str).append("&filelength=").append(i).append("&sum=").append((String)localObject).append("&reporttype=").append(paramInt1);
      if (paramInt2 > 0) {
        ((StringBuilder)localObject).append("&NewReportType=").append(paramInt2);
      }
      if (paramString1 != null) {
        ((StringBuilder)localObject).append("&reportvalue=").append(paramString1);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() != 0)) {
        ((StringBuilder)localObject).append("&username=").append(paramArrayOfByte);
      }
      if (paramString2 != null) {
        ((StringBuilder)localObject).append("&rtxname=").append(paramString2);
      }
      paramArrayOfByte = (HttpURLConnection)new URL(((StringBuilder)localObject).toString()).openConnection();
      paramArrayOfByte.setRequestMethod("POST");
      paramArrayOfByte.setReadTimeout(20000);
      paramArrayOfByte.setConnectTimeout(10000);
      paramArrayOfByte.setRequestProperty("content-type", "binary/octet-stream");
      paramArrayOfByte.setDoOutput(true);
      paramArrayOfByte.setDoInput(true);
      paramArrayOfByte.connect();
      paramString1 = paramArrayOfByte.getOutputStream();
      paramString1.write(localPByteArray.value);
      paramString1.flush();
      paramString1.close();
      return paramArrayOfByte;
    }
  }
  
  public static void a(com.tencent.matrix.c.b paramb, File paramFile, final boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists()))
    {
      com.tencent.matrix.d.b.e("Matrix.ReportMrsUpload", "report mrs file error, path: %s is null or not exist", new Object[] { paramFile });
      return;
    }
    final long l = paramFile.length();
    if (l <= 0L)
    {
      com.tencent.matrix.d.b.e("Matrix.ReportMrsUpload", "report mrs file error len file:%s len:%d", new Object[] { paramFile.getPath(), Long.valueOf(l) });
      return;
    }
    e.a(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: invokestatic 44	com/tencent/mm/sdk/platformtools/bk:UY	()J
        //   3: lstore 4
        //   5: ldc 46
        //   7: ldc 48
        //   9: iconst_2
        //   10: anewarray 4	java/lang/Object
        //   13: dup
        //   14: iconst_0
        //   15: aload_0
        //   16: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   19: invokevirtual 54	java/io/File:getPath	()Ljava/lang/String;
        //   22: aastore
        //   23: dup
        //   24: iconst_1
        //   25: aload_0
        //   26: getfield 25	com/tencent/mrs/a/c$1:wDs	J
        //   29: invokestatic 60	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   32: aastore
        //   33: invokestatic 66	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   36: iconst_0
        //   37: istore 7
        //   39: iconst_0
        //   40: istore 6
        //   42: aload_0
        //   43: getfield 25	com/tencent/mrs/a/c$1:wDs	J
        //   46: ldc2_w 67
        //   49: lcmp
        //   50: ifgt +97 -> 147
        //   53: aload_0
        //   54: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   57: invokevirtual 71	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   60: iconst_0
        //   61: iconst_m1
        //   62: invokestatic 77	com/tencent/mm/a/e:d	(Ljava/lang/String;II)[B
        //   65: astore 9
        //   67: aload_0
        //   68: getfield 27	com/tencent/mrs/a/c$1:wDt	Lcom/tencent/matrix/c/b;
        //   71: getfield 83	com/tencent/matrix/c/b:tag	Ljava/lang/String;
        //   74: aload 9
        //   76: iconst_0
        //   77: iconst_1
        //   78: lload 4
        //   80: invokestatic 87	com/tencent/mrs/a/c:b	(Ljava/lang/String;[BIIJ)Z
        //   83: istore 6
        //   85: ldc 46
        //   87: ldc 89
        //   89: iconst_3
        //   90: anewarray 4	java/lang/Object
        //   93: dup
        //   94: iconst_0
        //   95: iload 6
        //   97: invokestatic 94	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   100: aastore
        //   101: dup
        //   102: iconst_1
        //   103: aload_0
        //   104: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   107: invokevirtual 54	java/io/File:getPath	()Ljava/lang/String;
        //   110: aastore
        //   111: dup
        //   112: iconst_2
        //   113: invokestatic 44	com/tencent/mm/sdk/platformtools/bk:UY	()J
        //   116: lload 4
        //   118: lsub
        //   119: invokestatic 60	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   122: aastore
        //   123: invokestatic 97	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   126: iload 6
        //   128: ifeq +18 -> 146
        //   131: aload_0
        //   132: getfield 29	com/tencent/mrs/a/c$1:eSb	Z
        //   135: ifeq +11 -> 146
        //   138: aload_0
        //   139: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   142: invokevirtual 101	java/io/File:delete	()Z
        //   145: pop
        //   146: return
        //   147: aload_0
        //   148: getfield 25	com/tencent/mrs/a/c$1:wDs	J
        //   151: l2d
        //   152: ldc2_w 102
        //   155: ddiv
        //   156: invokestatic 109	java/lang/Math:ceil	(D)D
        //   159: d2i
        //   160: istore_3
        //   161: ldc 110
        //   163: newarray byte
        //   165: astore 11
        //   167: aconst_null
        //   168: astore 12
        //   170: new 112	java/io/FileInputStream
        //   173: dup
        //   174: aload_0
        //   175: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   178: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   181: astore 9
        //   183: iconst_0
        //   184: istore_1
        //   185: iload_1
        //   186: iload_3
        //   187: if_icmpge +60 -> 247
        //   190: iconst_0
        //   191: istore 8
        //   193: iconst_0
        //   194: istore 6
        //   196: iload 8
        //   198: istore 7
        //   200: aload 9
        //   202: aload 11
        //   204: iconst_0
        //   205: ldc 110
        //   207: invokevirtual 119	java/io/FileInputStream:read	([BII)I
        //   210: istore_2
        //   211: iload_2
        //   212: ifge +48 -> 260
        //   215: iload 8
        //   217: istore 7
        //   219: ldc 46
        //   221: ldc 121
        //   223: iconst_2
        //   224: anewarray 4	java/lang/Object
        //   227: dup
        //   228: iconst_0
        //   229: aload_0
        //   230: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   233: invokevirtual 54	java/io/File:getPath	()Ljava/lang/String;
        //   236: aastore
        //   237: dup
        //   238: iconst_1
        //   239: iload_2
        //   240: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   243: aastore
        //   244: invokestatic 66	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   247: aload 9
        //   249: invokevirtual 129	java/io/FileInputStream:close	()V
        //   252: goto -167 -> 85
        //   255: astore 9
        //   257: goto -172 -> 85
        //   260: iload_2
        //   261: ldc 110
        //   263: if_icmpge +290 -> 553
        //   266: iload 8
        //   268: istore 7
        //   270: ldc 46
        //   272: ldc 131
        //   274: iconst_2
        //   275: anewarray 4	java/lang/Object
        //   278: dup
        //   279: iconst_0
        //   280: iload_2
        //   281: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   284: aastore
        //   285: dup
        //   286: iconst_1
        //   287: ldc 110
        //   289: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   292: aastore
        //   293: invokestatic 66	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   296: iload 8
        //   298: istore 7
        //   300: iload_2
        //   301: newarray byte
        //   303: astore 10
        //   305: iload 8
        //   307: istore 7
        //   309: aload 11
        //   311: iconst_0
        //   312: aload 10
        //   314: iconst_0
        //   315: iload_2
        //   316: invokestatic 137	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   319: iconst_0
        //   320: istore_2
        //   321: iconst_0
        //   322: istore 6
        //   324: iload_2
        //   325: iconst_2
        //   326: if_icmpge +234 -> 560
        //   329: aload_0
        //   330: getfield 27	com/tencent/mrs/a/c$1:wDt	Lcom/tencent/matrix/c/b;
        //   333: getfield 83	com/tencent/matrix/c/b:tag	Ljava/lang/String;
        //   336: aload 10
        //   338: iload_1
        //   339: iload_3
        //   340: lload 4
        //   342: invokestatic 87	com/tencent/mrs/a/c:b	(Ljava/lang/String;[BIIJ)Z
        //   345: istore 8
        //   347: iload 8
        //   349: istore 6
        //   351: iload 8
        //   353: ifne +50 -> 403
        //   356: iload 8
        //   358: istore 7
        //   360: ldc 46
        //   362: ldc 139
        //   364: iconst_3
        //   365: anewarray 4	java/lang/Object
        //   368: dup
        //   369: iconst_0
        //   370: iload_1
        //   371: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   374: aastore
        //   375: dup
        //   376: iconst_1
        //   377: iload_3
        //   378: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   381: aastore
        //   382: dup
        //   383: iconst_2
        //   384: iload_2
        //   385: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   388: aastore
        //   389: invokestatic 142	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   392: iload_2
        //   393: iconst_1
        //   394: iadd
        //   395: istore_2
        //   396: iload 8
        //   398: istore 6
        //   400: goto -76 -> 324
        //   403: iload 6
        //   405: ifne +90 -> 495
        //   408: iload 6
        //   410: istore 7
        //   412: ldc 46
        //   414: ldc 144
        //   416: iconst_3
        //   417: anewarray 4	java/lang/Object
        //   420: dup
        //   421: iconst_0
        //   422: aload_0
        //   423: getfield 23	com/tencent/mrs/a/c$1:val$file	Ljava/io/File;
        //   426: invokevirtual 54	java/io/File:getPath	()Ljava/lang/String;
        //   429: aastore
        //   430: dup
        //   431: iconst_1
        //   432: iload_1
        //   433: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   436: aastore
        //   437: dup
        //   438: iconst_2
        //   439: iload_3
        //   440: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   443: aastore
        //   444: invokestatic 142	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   447: goto -200 -> 247
        //   450: astore 10
        //   452: ldc 46
        //   454: aload 10
        //   456: ldc 146
        //   458: iconst_0
        //   459: anewarray 4	java/lang/Object
        //   462: invokestatic 150	com/tencent/matrix/d/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   465: iload 7
        //   467: istore 6
        //   469: aload 9
        //   471: ifnull -386 -> 85
        //   474: aload 9
        //   476: invokevirtual 129	java/io/FileInputStream:close	()V
        //   479: iload 7
        //   481: istore 6
        //   483: goto -398 -> 85
        //   486: astore 9
        //   488: iload 7
        //   490: istore 6
        //   492: goto -407 -> 85
        //   495: iload_1
        //   496: iconst_1
        //   497: iadd
        //   498: istore_1
        //   499: goto -314 -> 185
        //   502: astore 10
        //   504: aconst_null
        //   505: astore 9
        //   507: aload 9
        //   509: ifnull +8 -> 517
        //   512: aload 9
        //   514: invokevirtual 129	java/io/FileInputStream:close	()V
        //   517: aload 10
        //   519: athrow
        //   520: astore 9
        //   522: goto -5 -> 517
        //   525: astore 10
        //   527: goto -20 -> 507
        //   530: astore 10
        //   532: goto -25 -> 507
        //   535: astore 10
        //   537: aload 12
        //   539: astore 9
        //   541: goto -89 -> 452
        //   544: astore 10
        //   546: iload 6
        //   548: istore 7
        //   550: goto -98 -> 452
        //   553: aload 11
        //   555: astore 10
        //   557: goto -238 -> 319
        //   560: goto -157 -> 403
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	563	0	this	1
        //   184	315	1	i	int
        //   210	186	2	j	int
        //   160	280	3	k	int
        //   3	338	4	l	long
        //   40	507	6	bool1	boolean
        //   37	512	7	bool2	boolean
        //   191	206	8	bool3	boolean
        //   65	183	9	localObject1	Object
        //   255	220	9	localIOException1	IOException
        //   486	1	9	localIOException2	IOException
        //   505	8	9	localObject2	Object
        //   520	1	9	localIOException3	IOException
        //   539	1	9	localObject3	Object
        //   303	34	10	arrayOfByte1	byte[]
        //   450	5	10	localThrowable1	Throwable
        //   502	16	10	localObject4	Object
        //   525	1	10	localObject5	Object
        //   530	1	10	localObject6	Object
        //   535	1	10	localThrowable2	Throwable
        //   544	1	10	localThrowable3	Throwable
        //   555	1	10	arrayOfByte2	byte[]
        //   165	389	11	arrayOfByte3	byte[]
        //   168	370	12	localObject7	Object
        // Exception table:
        //   from	to	target	type
        //   247	252	255	java/io/IOException
        //   200	211	450	java/lang/Throwable
        //   219	247	450	java/lang/Throwable
        //   270	296	450	java/lang/Throwable
        //   300	305	450	java/lang/Throwable
        //   309	319	450	java/lang/Throwable
        //   360	392	450	java/lang/Throwable
        //   412	447	450	java/lang/Throwable
        //   474	479	486	java/io/IOException
        //   170	183	502	finally
        //   512	517	520	java/io/IOException
        //   200	211	525	finally
        //   219	247	525	finally
        //   270	296	525	finally
        //   300	305	525	finally
        //   309	319	525	finally
        //   329	347	525	finally
        //   360	392	525	finally
        //   412	447	525	finally
        //   452	465	530	finally
        //   170	183	535	java/lang/Throwable
        //   329	347	544	java/lang/Throwable
      }
    }, "ReportMrsUploadFile", 10);
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = null;
    String str = null;
    long l = System.currentTimeMillis();
    try
    {
      paramString = a(paramArrayOfByte, 19860829, -1, paramLong + '.' + paramInt1 + '.' + paramInt2, paramString);
      str = paramString;
      localObject = paramString;
      int i = paramString.getResponseCode();
      if (i != 200)
      {
        b(paramString, null);
        com.tencent.matrix.d.b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis() - l) });
        return false;
      }
      b(paramString, null);
      com.tencent.matrix.d.b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis() - l) });
      return true;
    }
    catch (Throwable paramString)
    {
      localObject = str;
      com.tencent.matrix.d.b.printErrStackTrace("Matrix.ReportMrsUpload", paramString, "matrix report http error", new Object[0]);
      b(str, null);
      com.tencent.matrix.d.b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis() - l) });
      return false;
    }
    finally
    {
      b((HttpURLConnection)localObject, null);
      com.tencent.matrix.d.b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  static void b(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramHttpURLConnection)
    {
      com.tencent.matrix.d.b.printErrStackTrace("Matrix.ReportMrsUpload", paramHttpURLConnection, "close error", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.a.c
 * JD-Core Version:    0.7.0.1
 */