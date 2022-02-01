package com.tencent.mm.toolkit.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.f;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

final class b
  implements com.tencent.mm.toolkit.a.a.c
{
  private final a adsH;
  private Context mContext;
  
  b(a parama)
  {
    this.adsH = parama;
  }
  
  private static int a(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    AppMethodBeat.i(232027);
    try
    {
      int i = paramInputStream.read(paramArrayOfByte);
      AppMethodBeat.o(232027);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      boolean bool = e.DEBUG;
      if ("unexpected end of stream".equals(paramArrayOfByte.getMessage()))
      {
        AppMethodBeat.o(232027);
        return -1;
      }
      AppMethodBeat.o(232027);
    }
    return -2147483648;
  }
  
  private static void a(c paramc, InputStream paramInputStream, OutputStream paramOutputStream, FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(232025);
    paramc.mState = 2012;
    byte[] arrayOfByte = new byte[4096];
    long l4 = paramc.mContentLength;
    if (e.DEBUG)
    {
      new StringBuilder("Start transfer data, content length = ").append(l4).append(", id = ").append(paramc.mId);
      e.jhd();
    }
    long l1 = 0L;
    long l5 = paramc.adsS;
    for (;;)
    {
      if (paramc.mCancelled)
      {
        if (e.DEBUG)
        {
          new StringBuilder("Stopping the download as Download Request is cancelled, id ").append(paramc.mId);
          e.jhd();
        }
        paramc = new com.tencent.mm.toolkit.a.a.a(1201, "Download cancelled");
        AppMethodBeat.o(232025);
        throw paramc;
      }
      int i = a(arrayOfByte, paramInputStream);
      long l6 = paramc.adsR;
      long l3 = System.currentTimeMillis();
      long l2 = l1;
      if (l3 - l1 > l5)
      {
        if ((l4 != -1L) && (l4 > 0L))
        {
          com.tencent.mm.toolkit.a.a.b localb = paramc.adsX;
          if ((localb != null) && (localb.isCanceled()))
          {
            if (e.DEBUG)
            {
              new StringBuilder("request is canceled, id = ").append(paramc.mId);
              e.jhd();
            }
            paramc.mCancelled = true;
          }
        }
        l2 = l3;
      }
      if (i == -1)
      {
        paramc.mState = 2020;
        try
        {
          if (!paramc.adsL.renameTo(paramc.adsM))
          {
            paramc = new com.tencent.mm.toolkit.a.a.a(1001, "Cannot rename intermediate file to dest file!");
            AppMethodBeat.o(232025);
            throw paramc;
          }
        }
        catch (com.tencent.mm.toolkit.a.a.a paramc)
        {
          boolean bool = e.DEBUG;
          paramc = new com.tencent.mm.toolkit.a.a.a(paramc.mErrorCode, paramc.getLocalizedMessage());
          AppMethodBeat.o(232025);
          throw paramc;
        }
        if (paramc.adsV != null) {
          paramc.adsV.d(paramc);
        }
        paramInputStream = paramc.adsX;
        if (paramInputStream != null) {
          paramInputStream.a(paramc);
        }
        paramc.finish();
        AppMethodBeat.o(232025);
        return;
      }
      if (i == -2147483648)
      {
        paramc = new com.tencent.mm.toolkit.a.a.a(1102, "Failed reading http response");
        AppMethodBeat.o(232025);
        throw paramc;
      }
      if (!a(arrayOfByte, i, paramOutputStream, paramFileDescriptor)) {
        break;
      }
      paramc.adsR = (i + l6);
      l1 = l2;
    }
    paramc = new com.tencent.mm.toolkit.a.a.a(1001, "Failed writing file");
    AppMethodBeat.o(232025);
    throw paramc;
  }
  
  private static boolean a(c paramc, File paramFile)
  {
    AppMethodBeat.i(232021);
    if ((paramc.adsP) && (paramFile.exists()))
    {
      AppMethodBeat.o(232021);
      return true;
    }
    try
    {
      if (!paramFile.getParentFile().exists()) {
        paramFile.getParentFile().mkdirs();
      }
      bool = paramFile.createNewFile();
      AppMethodBeat.o(232021);
      return bool;
    }
    catch (IOException paramc)
    {
      boolean bool = e.DEBUG;
      AppMethodBeat.o(232021);
    }
    return false;
  }
  
  private static boolean a(c paramc, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(232019);
    if (paramc.mContentLength != -1L)
    {
      AppMethodBeat.o(232019);
      return true;
    }
    String str = paramHttpURLConnection.getHeaderField("Transfer-Encoding");
    if ((str != null) && (str.equalsIgnoreCase("chunked")))
    {
      AppMethodBeat.o(232019);
      return true;
    }
    label93:
    for (;;)
    {
      try
      {
        long l = Long.parseLong(paramHttpURLConnection.getHeaderField("Content-Length"));
        boolean bool = e.DEBUG;
      }
      catch (NumberFormatException paramc)
      {
        try
        {
          paramc.mContentLength = (paramc.adsR + l);
          if (l == -1L) {
            break;
          }
          AppMethodBeat.o(232019);
          return true;
        }
        catch (NumberFormatException paramc)
        {
          break label93;
        }
        paramc = paramc;
        l = -1L;
      }
    }
    AppMethodBeat.o(232019);
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt, OutputStream paramOutputStream, FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(232029);
    if (paramFileDescriptor.valid()) {
      try
      {
        paramOutputStream.write(paramArrayOfByte, 0, paramInt);
        paramOutputStream.flush();
        paramFileDescriptor.sync();
        AppMethodBeat.o(232029);
        return true;
      }
      catch (IOException paramArrayOfByte)
      {
        boolean bool = e.DEBUG;
        AppMethodBeat.o(232029);
        return false;
      }
    }
    if (e.DEBUG) {
      e.jhe();
    }
    AppMethodBeat.o(232029);
    return false;
  }
  
  /* Error */
  private void c(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 250
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 254	com/tencent/mm/toolkit/a/c:adsK	Landroid/net/Uri;
    //   12: invokevirtual 259	android/net/Uri:getScheme	()Ljava/lang/String;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull +25 -> 44
    //   22: aload 5
    //   24: ldc_w 261
    //   27: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   30: ifne +52 -> 82
    //   33: aload 5
    //   35: ldc_w 263
    //   38: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   41: ifne +41 -> 82
    //   44: new 62	com/tencent/mm/toolkit/a/a/a
    //   47: dup
    //   48: sipush 1105
    //   51: new 75	java/lang/StringBuilder
    //   54: dup
    //   55: ldc_w 265
    //   58: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: getfield 254	com/tencent/mm/toolkit/a/c:adsK	Landroid/net/Uri;
    //   65: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   74: astore_1
    //   75: ldc 250
    //   77: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: new 273	java/net/URL
    //   85: dup
    //   86: aload_1
    //   87: getfield 254	com/tencent/mm/toolkit/a/c:adsK	Landroid/net/Uri;
    //   90: invokevirtual 274	android/net/Uri:toString	()Ljava/lang/String;
    //   93: invokespecial 275	java/net/URL:<init>	(Ljava/lang/String;)V
    //   96: astore 5
    //   98: aload 5
    //   100: invokevirtual 279	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   103: checkcast 205	java/net/HttpURLConnection
    //   106: astore 7
    //   108: aload 7
    //   110: astore 6
    //   112: aload 7
    //   114: ldc_w 281
    //   117: invokevirtual 284	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   120: aload 7
    //   122: astore 6
    //   124: aload 7
    //   126: iconst_0
    //   127: invokevirtual 288	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   130: aload 7
    //   132: astore 6
    //   134: aload 7
    //   136: aload_1
    //   137: invokevirtual 292	com/tencent/mm/toolkit/a/c:jhc	()Lcom/tencent/mm/toolkit/a/a/e;
    //   140: invokeinterface 298 1 0
    //   145: invokevirtual 301	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   148: aload 7
    //   150: astore 6
    //   152: aload 7
    //   154: aload_1
    //   155: invokevirtual 292	com/tencent/mm/toolkit/a/c:jhc	()Lcom/tencent/mm/toolkit/a/a/e;
    //   158: invokeinterface 298 1 0
    //   163: invokevirtual 304	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   166: aload 7
    //   168: astore 6
    //   170: aload_1
    //   171: getfield 308	com/tencent/mm/toolkit/a/c:adsU	Ljava/util/HashMap;
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +148 -> 326
    //   181: aload 7
    //   183: astore 6
    //   185: aload 4
    //   187: invokevirtual 314	java/util/HashMap:keySet	()Ljava/util/Set;
    //   190: invokeinterface 320 1 0
    //   195: astore 5
    //   197: aload 7
    //   199: astore 6
    //   201: aload 5
    //   203: invokeinterface 325 1 0
    //   208: ifeq +118 -> 326
    //   211: aload 7
    //   213: astore 6
    //   215: aload 5
    //   217: invokeinterface 329 1 0
    //   222: checkcast 54	java/lang/String
    //   225: astore 8
    //   227: aload 7
    //   229: astore 6
    //   231: aload 7
    //   233: aload 8
    //   235: aload 4
    //   237: aload 8
    //   239: invokevirtual 333	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: checkcast 54	java/lang/String
    //   245: invokevirtual 337	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: goto -51 -> 197
    //   251: astore 4
    //   253: aload 7
    //   255: astore 6
    //   257: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   260: istore_3
    //   261: aload 7
    //   263: astore 6
    //   265: aload_1
    //   266: invokevirtual 292	com/tencent/mm/toolkit/a/c:jhc	()Lcom/tencent/mm/toolkit/a/a/e;
    //   269: invokeinterface 340 1 0
    //   274: ifeq +981 -> 1255
    //   277: aload 7
    //   279: astore 6
    //   281: aload_1
    //   282: sipush 2030
    //   285: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   288: aload 7
    //   290: ifnull +998 -> 1288
    //   293: aload 7
    //   295: invokevirtual 343	java/net/HttpURLConnection:disconnect	()V
    //   298: ldc 250
    //   300: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: astore_1
    //   305: new 62	com/tencent/mm/toolkit/a/a/a
    //   308: dup
    //   309: sipush 1105
    //   312: ldc_w 345
    //   315: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   318: astore_1
    //   319: ldc 250
    //   321: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: athrow
    //   326: aload 7
    //   328: astore 6
    //   330: aload_1
    //   331: getfield 140	com/tencent/mm/toolkit/a/c:adsL	Ljava/io/File;
    //   334: invokevirtual 187	java/io/File:exists	()Z
    //   337: ifeq +105 -> 442
    //   340: aload 7
    //   342: astore 6
    //   344: invokestatic 98	com/tencent/mm/toolkit/a/e:jhd	()V
    //   347: aload 7
    //   349: astore 6
    //   351: aload_1
    //   352: getfield 184	com/tencent/mm/toolkit/a/c:adsP	Z
    //   355: ifeq +350 -> 705
    //   358: aload 7
    //   360: astore 6
    //   362: aload_1
    //   363: aload_1
    //   364: getfield 140	com/tencent/mm/toolkit/a/c:adsL	Ljava/io/File;
    //   367: invokevirtual 348	java/io/File:length	()J
    //   370: putfield 116	com/tencent/mm/toolkit/a/c:adsR	J
    //   373: aload 7
    //   375: astore 6
    //   377: new 75	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 350
    //   384: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload_1
    //   388: getfield 116	com/tencent/mm/toolkit/a/c:adsR	J
    //   391: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   394: ldc_w 352
    //   397: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: astore 4
    //   405: aload 7
    //   407: astore 6
    //   409: ldc_w 354
    //   412: aload 4
    //   414: invokestatic 358	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   417: invokevirtual 361	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   420: pop
    //   421: aload 7
    //   423: astore 6
    //   425: invokestatic 98	com/tencent/mm/toolkit/a/e:jhd	()V
    //   428: aload 7
    //   430: astore 6
    //   432: aload 7
    //   434: ldc_w 363
    //   437: aload 4
    //   439: invokevirtual 337	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload 7
    //   444: astore 6
    //   446: aload_1
    //   447: sipush 2011
    //   450: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   453: aload 7
    //   455: astore 6
    //   457: aload 7
    //   459: invokevirtual 366	java/net/HttpURLConnection:getResponseCode	()I
    //   462: istore_2
    //   463: aload 7
    //   465: astore 6
    //   467: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   470: ifeq +938 -> 1408
    //   473: aload 7
    //   475: astore 6
    //   477: new 75	java/lang/StringBuilder
    //   480: dup
    //   481: ldc_w 368
    //   484: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: aload_1
    //   488: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   491: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 370
    //   497: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload_2
    //   501: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: invokestatic 98	com/tencent/mm/toolkit/a/e:jhd	()V
    //   512: goto +896 -> 1408
    //   515: aload 7
    //   517: astore 6
    //   519: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   522: ifeq +56 -> 578
    //   525: aload 7
    //   527: astore 6
    //   529: new 75	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 372
    //   536: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: iload_2
    //   540: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc_w 374
    //   546: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_1
    //   550: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   553: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: ldc_w 376
    //   559: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 7
    //   564: invokevirtual 379	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   567: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 7
    //   573: astore 6
    //   575: invokestatic 244	com/tencent/mm/toolkit/a/e:jhe	()V
    //   578: aload 7
    //   580: astore 6
    //   582: new 62	com/tencent/mm/toolkit/a/a/a
    //   585: dup
    //   586: sipush 1101
    //   589: new 75	java/lang/StringBuilder
    //   592: dup
    //   593: ldc_w 381
    //   596: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   599: iload_2
    //   600: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: ldc_w 383
    //   606: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 7
    //   611: invokevirtual 379	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   614: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   623: astore 4
    //   625: aload 7
    //   627: astore 6
    //   629: ldc 250
    //   631: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   634: aload 7
    //   636: astore 6
    //   638: aload 4
    //   640: athrow
    //   641: astore_1
    //   642: aload 7
    //   644: astore 6
    //   646: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   649: istore_3
    //   650: aload 7
    //   652: astore 6
    //   654: new 62	com/tencent/mm/toolkit/a/a/a
    //   657: dup
    //   658: sipush 1102
    //   661: ldc_w 385
    //   664: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   667: astore_1
    //   668: aload 7
    //   670: astore 6
    //   672: ldc 250
    //   674: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   677: aload 7
    //   679: astore 6
    //   681: aload_1
    //   682: athrow
    //   683: astore_1
    //   684: aload 6
    //   686: astore 4
    //   688: aload 4
    //   690: ifnull +8 -> 698
    //   693: aload 4
    //   695: invokevirtual 343	java/net/HttpURLConnection:disconnect	()V
    //   698: ldc 250
    //   700: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   703: aload_1
    //   704: athrow
    //   705: aload 7
    //   707: astore 6
    //   709: aload_1
    //   710: lconst_0
    //   711: putfield 116	com/tencent/mm/toolkit/a/c:adsR	J
    //   714: aload 7
    //   716: astore 6
    //   718: invokestatic 98	com/tencent/mm/toolkit/a/e:jhd	()V
    //   721: aload 7
    //   723: astore 6
    //   725: aload_1
    //   726: getfield 140	com/tencent/mm/toolkit/a/c:adsL	Ljava/io/File;
    //   729: invokestatic 391	com/tencent/mm/toolkit/a/d$b:R	(Ljava/io/File;)V
    //   732: goto -290 -> 442
    //   735: aload 7
    //   737: astore 6
    //   739: aload_1
    //   740: aload 7
    //   742: invokestatic 393	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/net/HttpURLConnection;)Z
    //   745: ifeq +260 -> 1005
    //   748: aload 7
    //   750: astore 6
    //   752: new 145	java/io/File
    //   755: dup
    //   756: aload_1
    //   757: getfield 140	com/tencent/mm/toolkit/a/c:adsL	Ljava/io/File;
    //   760: invokevirtual 396	java/io/File:getPath	()Ljava/lang/String;
    //   763: invokespecial 397	java/io/File:<init>	(Ljava/lang/String;)V
    //   766: astore 4
    //   768: aload 7
    //   770: astore 6
    //   772: aload_1
    //   773: aload 4
    //   775: invokestatic 399	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/io/File;)Z
    //   778: istore_3
    //   779: iload_3
    //   780: ifeq +190 -> 970
    //   783: aload 7
    //   785: invokevirtual 403	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   788: astore 5
    //   790: new 405	java/io/FileOutputStream
    //   793: dup
    //   794: aload 4
    //   796: iconst_1
    //   797: invokespecial 408	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   800: astore 6
    //   802: aload 6
    //   804: checkcast 405	java/io/FileOutputStream
    //   807: invokevirtual 412	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   810: astore 8
    //   812: new 414	java/io/BufferedOutputStream
    //   815: dup
    //   816: aload 6
    //   818: invokespecial 417	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   821: astore 4
    //   823: aload_1
    //   824: aload 5
    //   826: aload 4
    //   828: aload 8
    //   830: invokestatic 419	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/io/FileDescriptor;)V
    //   833: aload 7
    //   835: astore 6
    //   837: aload 5
    //   839: invokestatic 425	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   842: aload 7
    //   844: astore 6
    //   846: aload 4
    //   848: invokestatic 425	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   851: aload 7
    //   853: ifnull +435 -> 1288
    //   856: aload 7
    //   858: invokevirtual 343	java/net/HttpURLConnection:disconnect	()V
    //   861: ldc 250
    //   863: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   866: return
    //   867: astore 4
    //   869: aconst_null
    //   870: astore 4
    //   872: aconst_null
    //   873: astore 8
    //   875: aload 8
    //   877: ifnonnull +70 -> 947
    //   880: new 62	com/tencent/mm/toolkit/a/a/a
    //   883: dup
    //   884: sipush 1102
    //   887: ldc_w 427
    //   890: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   893: astore 5
    //   895: ldc 250
    //   897: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   900: aload 5
    //   902: athrow
    //   903: astore 6
    //   905: aload 4
    //   907: astore 5
    //   909: aload 6
    //   911: astore 4
    //   913: aload 7
    //   915: astore 6
    //   917: aload 8
    //   919: invokestatic 425	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   922: aload 7
    //   924: astore 6
    //   926: aload 5
    //   928: invokestatic 425	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   931: aload 7
    //   933: astore 6
    //   935: ldc 250
    //   937: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: aload 7
    //   942: astore 6
    //   944: aload 4
    //   946: athrow
    //   947: new 62	com/tencent/mm/toolkit/a/a/a
    //   950: dup
    //   951: sipush 1001
    //   954: ldc_w 429
    //   957: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   960: astore 5
    //   962: ldc 250
    //   964: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   967: aload 5
    //   969: athrow
    //   970: aload 7
    //   972: astore 6
    //   974: new 62	com/tencent/mm/toolkit/a/a/a
    //   977: dup
    //   978: sipush 1001
    //   981: ldc_w 431
    //   984: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   987: astore 4
    //   989: aload 7
    //   991: astore 6
    //   993: ldc 250
    //   995: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   998: aload 7
    //   1000: astore 6
    //   1002: aload 4
    //   1004: athrow
    //   1005: aload 7
    //   1007: astore 6
    //   1009: new 62	com/tencent/mm/toolkit/a/a/a
    //   1012: dup
    //   1013: sipush 1104
    //   1016: ldc_w 433
    //   1019: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1022: astore 4
    //   1024: aload 7
    //   1026: astore 6
    //   1028: ldc 250
    //   1030: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1033: aload 7
    //   1035: astore 6
    //   1037: aload 4
    //   1039: athrow
    //   1040: aload 7
    //   1042: astore 6
    //   1044: aload_1
    //   1045: getfield 436	com/tencent/mm/toolkit/a/c:adsO	Z
    //   1048: ifeq +101 -> 1149
    //   1051: aload 7
    //   1053: astore 6
    //   1055: aload_1
    //   1056: getfield 439	com/tencent/mm/toolkit/a/c:adsQ	I
    //   1059: iconst_5
    //   1060: if_icmpge +89 -> 1149
    //   1063: aload 7
    //   1065: astore 6
    //   1067: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   1070: ifeq +32 -> 1102
    //   1073: aload 7
    //   1075: astore 6
    //   1077: new 75	java/lang/StringBuilder
    //   1080: dup
    //   1081: ldc_w 441
    //   1084: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1087: aload_1
    //   1088: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   1091: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload 7
    //   1097: astore 6
    //   1099: invokestatic 98	com/tencent/mm/toolkit/a/e:jhd	()V
    //   1102: aload 7
    //   1104: astore 6
    //   1106: aload_1
    //   1107: aload 7
    //   1109: ldc_w 443
    //   1112: invokevirtual 209	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1115: invokestatic 447	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1118: putfield 254	com/tencent/mm/toolkit/a/c:adsK	Landroid/net/Uri;
    //   1121: aload 7
    //   1123: astore 6
    //   1125: aload_1
    //   1126: aload_1
    //   1127: getfield 439	com/tencent/mm/toolkit/a/c:adsQ	I
    //   1130: iconst_1
    //   1131: iadd
    //   1132: putfield 439	com/tencent/mm/toolkit/a/c:adsQ	I
    //   1135: aload 7
    //   1137: astore 6
    //   1139: aload_1
    //   1140: sipush 2030
    //   1143: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   1146: goto -295 -> 851
    //   1149: aload 7
    //   1151: astore 6
    //   1153: aload_1
    //   1154: getfield 436	com/tencent/mm/toolkit/a/c:adsO	Z
    //   1157: ifeq +346 -> 1503
    //   1160: aload 7
    //   1162: astore 6
    //   1164: new 75	java/lang/StringBuilder
    //   1167: dup
    //   1168: ldc_w 449
    //   1171: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1174: aload_1
    //   1175: getfield 439	com/tencent/mm/toolkit/a/c:adsQ	I
    //   1178: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: astore 4
    //   1186: aload 7
    //   1188: astore 6
    //   1190: new 62	com/tencent/mm/toolkit/a/a/a
    //   1193: dup
    //   1194: sipush 1103
    //   1197: aload 4
    //   1199: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1202: astore 4
    //   1204: aload 7
    //   1206: astore 6
    //   1208: ldc 250
    //   1210: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1213: aload 7
    //   1215: astore 6
    //   1217: aload 4
    //   1219: athrow
    //   1220: aload 7
    //   1222: astore 6
    //   1224: new 62	com/tencent/mm/toolkit/a/a/a
    //   1227: dup
    //   1228: iload_2
    //   1229: aload 7
    //   1231: invokevirtual 379	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1234: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1237: astore 4
    //   1239: aload 7
    //   1241: astore 6
    //   1243: ldc 250
    //   1245: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: aload 7
    //   1250: astore 6
    //   1252: aload 4
    //   1254: athrow
    //   1255: aload 7
    //   1257: astore 6
    //   1259: new 62	com/tencent/mm/toolkit/a/a/a
    //   1262: dup
    //   1263: sipush 1106
    //   1266: ldc_w 451
    //   1269: invokespecial 111	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1272: astore_1
    //   1273: aload 7
    //   1275: astore 6
    //   1277: ldc 250
    //   1279: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1282: aload 7
    //   1284: astore 6
    //   1286: aload_1
    //   1287: athrow
    //   1288: ldc 250
    //   1290: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1293: return
    //   1294: astore_1
    //   1295: goto -607 -> 688
    //   1298: astore_1
    //   1299: aconst_null
    //   1300: astore 7
    //   1302: goto -660 -> 642
    //   1305: astore 4
    //   1307: aconst_null
    //   1308: astore 7
    //   1310: goto -1057 -> 253
    //   1313: astore 4
    //   1315: aconst_null
    //   1316: astore 5
    //   1318: aconst_null
    //   1319: astore 8
    //   1321: goto -408 -> 913
    //   1324: astore 4
    //   1326: aconst_null
    //   1327: astore 6
    //   1329: aload 5
    //   1331: astore 8
    //   1333: aload 6
    //   1335: astore 5
    //   1337: goto -424 -> 913
    //   1340: astore 4
    //   1342: aload 5
    //   1344: astore 8
    //   1346: aload 6
    //   1348: astore 5
    //   1350: goto -437 -> 913
    //   1353: astore 6
    //   1355: aload 4
    //   1357: astore 9
    //   1359: aload 5
    //   1361: astore 8
    //   1363: aload 6
    //   1365: astore 4
    //   1367: aload 9
    //   1369: astore 5
    //   1371: goto -458 -> 913
    //   1374: astore 4
    //   1376: aconst_null
    //   1377: astore 4
    //   1379: aload 5
    //   1381: astore 8
    //   1383: goto -508 -> 875
    //   1386: astore 4
    //   1388: aload 6
    //   1390: astore 4
    //   1392: aload 5
    //   1394: astore 8
    //   1396: goto -521 -> 875
    //   1399: astore 6
    //   1401: aload 5
    //   1403: astore 8
    //   1405: goto -530 -> 875
    //   1408: iload_2
    //   1409: lookupswitch	default:+91->1500, 200:+-674->735, 206:+-674->735, 301:+-369->1040, 302:+-369->1040, 303:+-369->1040, 307:+-369->1040, 404:+-189->1220, 416:+-189->1220, 500:+-189->1220, 503:+-189->1220
    //   1501: <illegal opcode>
    //   1502: dload_1
    //   1503: ldc_w 453
    //   1506: astore 4
    //   1508: goto -322 -> 1186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1511	0	this	b
    //   0	1511	1	paramc	c
    //   462	947	2	i	int
    //   260	520	3	bool	boolean
    //   1	235	4	localHashMap	java.util.HashMap
    //   251	1	4	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   403	444	4	localObject1	Object
    //   867	1	4	localIOException1	IOException
    //   870	383	4	localObject2	Object
    //   1305	1	4	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1313	1	4	localObject3	Object
    //   1324	1	4	localObject4	Object
    //   1340	16	4	localObject5	Object
    //   1365	1	4	localObject6	Object
    //   1374	1	4	localIOException2	IOException
    //   1377	1	4	localObject7	Object
    //   1386	1	4	localIOException3	IOException
    //   1390	117	4	localObject8	Object
    //   15	1387	5	localObject9	Object
    //   110	735	6	localObject10	Object
    //   903	7	6	localObject11	Object
    //   915	432	6	localHttpURLConnection1	HttpURLConnection
    //   1353	36	6	localObject12	Object
    //   1399	1	6	localIOException4	IOException
    //   106	1203	7	localHttpURLConnection2	HttpURLConnection
    //   225	1179	8	localObject13	Object
    //   1357	11	9	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   112	120	251	java/net/SocketTimeoutException
    //   124	130	251	java/net/SocketTimeoutException
    //   134	148	251	java/net/SocketTimeoutException
    //   152	166	251	java/net/SocketTimeoutException
    //   170	176	251	java/net/SocketTimeoutException
    //   185	197	251	java/net/SocketTimeoutException
    //   201	211	251	java/net/SocketTimeoutException
    //   215	227	251	java/net/SocketTimeoutException
    //   231	248	251	java/net/SocketTimeoutException
    //   330	340	251	java/net/SocketTimeoutException
    //   344	347	251	java/net/SocketTimeoutException
    //   351	358	251	java/net/SocketTimeoutException
    //   362	373	251	java/net/SocketTimeoutException
    //   377	405	251	java/net/SocketTimeoutException
    //   409	421	251	java/net/SocketTimeoutException
    //   425	428	251	java/net/SocketTimeoutException
    //   432	442	251	java/net/SocketTimeoutException
    //   446	453	251	java/net/SocketTimeoutException
    //   457	463	251	java/net/SocketTimeoutException
    //   467	473	251	java/net/SocketTimeoutException
    //   477	505	251	java/net/SocketTimeoutException
    //   509	512	251	java/net/SocketTimeoutException
    //   519	525	251	java/net/SocketTimeoutException
    //   529	571	251	java/net/SocketTimeoutException
    //   575	578	251	java/net/SocketTimeoutException
    //   582	625	251	java/net/SocketTimeoutException
    //   629	634	251	java/net/SocketTimeoutException
    //   638	641	251	java/net/SocketTimeoutException
    //   709	714	251	java/net/SocketTimeoutException
    //   718	721	251	java/net/SocketTimeoutException
    //   725	732	251	java/net/SocketTimeoutException
    //   739	748	251	java/net/SocketTimeoutException
    //   752	768	251	java/net/SocketTimeoutException
    //   772	779	251	java/net/SocketTimeoutException
    //   837	842	251	java/net/SocketTimeoutException
    //   846	851	251	java/net/SocketTimeoutException
    //   917	922	251	java/net/SocketTimeoutException
    //   926	931	251	java/net/SocketTimeoutException
    //   935	940	251	java/net/SocketTimeoutException
    //   944	947	251	java/net/SocketTimeoutException
    //   974	989	251	java/net/SocketTimeoutException
    //   993	998	251	java/net/SocketTimeoutException
    //   1002	1005	251	java/net/SocketTimeoutException
    //   1009	1024	251	java/net/SocketTimeoutException
    //   1028	1033	251	java/net/SocketTimeoutException
    //   1037	1040	251	java/net/SocketTimeoutException
    //   1044	1051	251	java/net/SocketTimeoutException
    //   1055	1063	251	java/net/SocketTimeoutException
    //   1067	1073	251	java/net/SocketTimeoutException
    //   1077	1095	251	java/net/SocketTimeoutException
    //   1099	1102	251	java/net/SocketTimeoutException
    //   1106	1121	251	java/net/SocketTimeoutException
    //   1125	1135	251	java/net/SocketTimeoutException
    //   1139	1146	251	java/net/SocketTimeoutException
    //   1153	1160	251	java/net/SocketTimeoutException
    //   1164	1186	251	java/net/SocketTimeoutException
    //   1190	1204	251	java/net/SocketTimeoutException
    //   1208	1213	251	java/net/SocketTimeoutException
    //   1217	1220	251	java/net/SocketTimeoutException
    //   1224	1239	251	java/net/SocketTimeoutException
    //   1243	1248	251	java/net/SocketTimeoutException
    //   1252	1255	251	java/net/SocketTimeoutException
    //   82	98	304	java/net/MalformedURLException
    //   112	120	641	java/io/IOException
    //   124	130	641	java/io/IOException
    //   134	148	641	java/io/IOException
    //   152	166	641	java/io/IOException
    //   170	176	641	java/io/IOException
    //   185	197	641	java/io/IOException
    //   201	211	641	java/io/IOException
    //   215	227	641	java/io/IOException
    //   231	248	641	java/io/IOException
    //   330	340	641	java/io/IOException
    //   344	347	641	java/io/IOException
    //   351	358	641	java/io/IOException
    //   362	373	641	java/io/IOException
    //   377	405	641	java/io/IOException
    //   409	421	641	java/io/IOException
    //   425	428	641	java/io/IOException
    //   432	442	641	java/io/IOException
    //   446	453	641	java/io/IOException
    //   457	463	641	java/io/IOException
    //   467	473	641	java/io/IOException
    //   477	505	641	java/io/IOException
    //   509	512	641	java/io/IOException
    //   519	525	641	java/io/IOException
    //   529	571	641	java/io/IOException
    //   575	578	641	java/io/IOException
    //   582	625	641	java/io/IOException
    //   629	634	641	java/io/IOException
    //   638	641	641	java/io/IOException
    //   709	714	641	java/io/IOException
    //   718	721	641	java/io/IOException
    //   725	732	641	java/io/IOException
    //   739	748	641	java/io/IOException
    //   752	768	641	java/io/IOException
    //   772	779	641	java/io/IOException
    //   837	842	641	java/io/IOException
    //   846	851	641	java/io/IOException
    //   917	922	641	java/io/IOException
    //   926	931	641	java/io/IOException
    //   935	940	641	java/io/IOException
    //   944	947	641	java/io/IOException
    //   974	989	641	java/io/IOException
    //   993	998	641	java/io/IOException
    //   1002	1005	641	java/io/IOException
    //   1009	1024	641	java/io/IOException
    //   1028	1033	641	java/io/IOException
    //   1037	1040	641	java/io/IOException
    //   1044	1051	641	java/io/IOException
    //   1055	1063	641	java/io/IOException
    //   1067	1073	641	java/io/IOException
    //   1077	1095	641	java/io/IOException
    //   1099	1102	641	java/io/IOException
    //   1106	1121	641	java/io/IOException
    //   1125	1135	641	java/io/IOException
    //   1139	1146	641	java/io/IOException
    //   1153	1160	641	java/io/IOException
    //   1164	1186	641	java/io/IOException
    //   1190	1204	641	java/io/IOException
    //   1208	1213	641	java/io/IOException
    //   1217	1220	641	java/io/IOException
    //   1224	1239	641	java/io/IOException
    //   1243	1248	641	java/io/IOException
    //   1252	1255	641	java/io/IOException
    //   112	120	683	finally
    //   124	130	683	finally
    //   134	148	683	finally
    //   152	166	683	finally
    //   170	176	683	finally
    //   185	197	683	finally
    //   201	211	683	finally
    //   215	227	683	finally
    //   231	248	683	finally
    //   257	261	683	finally
    //   265	277	683	finally
    //   281	288	683	finally
    //   330	340	683	finally
    //   344	347	683	finally
    //   351	358	683	finally
    //   362	373	683	finally
    //   377	405	683	finally
    //   409	421	683	finally
    //   425	428	683	finally
    //   432	442	683	finally
    //   446	453	683	finally
    //   457	463	683	finally
    //   467	473	683	finally
    //   477	505	683	finally
    //   509	512	683	finally
    //   519	525	683	finally
    //   529	571	683	finally
    //   575	578	683	finally
    //   582	625	683	finally
    //   629	634	683	finally
    //   638	641	683	finally
    //   646	650	683	finally
    //   654	668	683	finally
    //   672	677	683	finally
    //   681	683	683	finally
    //   709	714	683	finally
    //   718	721	683	finally
    //   725	732	683	finally
    //   739	748	683	finally
    //   752	768	683	finally
    //   772	779	683	finally
    //   837	842	683	finally
    //   846	851	683	finally
    //   917	922	683	finally
    //   926	931	683	finally
    //   935	940	683	finally
    //   944	947	683	finally
    //   974	989	683	finally
    //   993	998	683	finally
    //   1002	1005	683	finally
    //   1009	1024	683	finally
    //   1028	1033	683	finally
    //   1037	1040	683	finally
    //   1044	1051	683	finally
    //   1055	1063	683	finally
    //   1067	1073	683	finally
    //   1077	1095	683	finally
    //   1099	1102	683	finally
    //   1106	1121	683	finally
    //   1125	1135	683	finally
    //   1139	1146	683	finally
    //   1153	1160	683	finally
    //   1164	1186	683	finally
    //   1190	1204	683	finally
    //   1208	1213	683	finally
    //   1217	1220	683	finally
    //   1224	1239	683	finally
    //   1243	1248	683	finally
    //   1252	1255	683	finally
    //   1259	1273	683	finally
    //   1277	1282	683	finally
    //   1286	1288	683	finally
    //   783	790	867	java/io/IOException
    //   880	903	903	finally
    //   947	970	903	finally
    //   98	108	1294	finally
    //   98	108	1298	java/io/IOException
    //   98	108	1305	java/net/SocketTimeoutException
    //   783	790	1313	finally
    //   790	802	1324	finally
    //   802	823	1340	finally
    //   823	833	1353	finally
    //   790	802	1374	java/io/IOException
    //   802	823	1386	java/io/IOException
    //   823	833	1399	java/io/IOException
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(232034);
    Context localContext = this.mContext;
    locala = new a();
    if ((localContext != null) && (androidx.core.content.a.checkSelfPermission(localContext, "android.permission.WAKE_LOCK") == 0))
    {
      locala.mUJ = ((PowerManager)localContext.getSystemService("power")).newWakeLock(1, e.TAG);
      if (!locala.mUJ.isHeld())
      {
        locala.mUJ.setWorkSource(new WorkSource());
        PowerManager.WakeLock localWakeLock = locala.mUJ;
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "lock", "(Landroid/content/Context;)Lcom/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
        localWakeLock.acquire();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "lock", "(Landroid/content/Context;)Lcom/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      }
      locala.adsI = ((WifiManager)localContext.getSystemService("wifi")).createWifiLock("WIFI LOCK : " + e.TAG);
      if (!locala.adsI.isHeld()) {
        locala.adsI.acquire();
      }
    }
    for (;;)
    {
      try
      {
        paramc.mState = 2010;
        c(paramc);
        i = paramc.mState;
        if (i == 2060) {
          continue;
        }
        return;
      }
      catch (com.tencent.mm.toolkit.a.a.a locala1)
      {
        boolean bool = e.DEBUG;
        int i = locala1.mErrorCode;
        String str = locala1.getLocalizedMessage();
        paramc.mState = 2040;
        if (!paramc.adsN) {
          continue;
        }
        if (!e.DEBUG) {
          continue;
        }
        new StringBuilder("clean up target file, path = ").append(paramc.adsM.getPath());
        e.jhd();
        d.b.R(paramc.adsM);
        d.b.R(paramc.adsL);
        a.a(paramc, i, str);
        paramc.finish();
        return;
      }
      finally
      {
        locala.release();
        AppMethodBeat.o(232034);
      }
      e.jhe();
    }
  }
  
  public final void jt(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  static final class a
  {
    WifiManager.WifiLock adsI;
    PowerManager.WakeLock mUJ;
    
    public final void release()
    {
      AppMethodBeat.i(231993);
      try
      {
        if ((this.mUJ != null) && (this.mUJ.isHeld()))
        {
          PowerManager.WakeLock localWakeLock = this.mUJ;
          com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "release", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          localWakeLock.release();
          com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "release", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        }
        if ((this.adsI != null) && (this.adsI.isHeld())) {
          this.adsI.release();
        }
        AppMethodBeat.o(231993);
        return;
      }
      finally
      {
        boolean bool = e.DEBUG;
        AppMethodBeat.o(231993);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.b
 * JD-Core Version:    0.7.0.1
 */