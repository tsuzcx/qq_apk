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
  private final a FEs;
  private Context mContext;
  
  b(a parama)
  {
    this.FEs = parama;
  }
  
  private static int a(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    AppMethodBeat.i(189800);
    try
    {
      int i = paramInputStream.read(paramArrayOfByte);
      AppMethodBeat.o(189800);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      boolean bool = e.DEBUG;
      if ("unexpected end of stream".equals(paramArrayOfByte.getMessage()))
      {
        AppMethodBeat.o(189800);
        return -1;
      }
      AppMethodBeat.o(189800);
    }
    return -2147483648;
  }
  
  private static void a(c paramc, InputStream paramInputStream, OutputStream paramOutputStream, FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(189799);
    paramc.mState = 2012;
    byte[] arrayOfByte = new byte[4096];
    long l = paramc.mContentLength;
    if (e.DEBUG)
    {
      new StringBuilder("Start transfer data, content length = ").append(l).append(", id = ").append(paramc.mId);
      e.eOC();
    }
    for (;;)
    {
      if (paramc.mCancelled)
      {
        if (e.DEBUG)
        {
          new StringBuilder("Stopping the download as Download Request is cancelled, id ").append(paramc.mId);
          e.eOC();
        }
        paramc = new com.tencent.mm.toolkit.a.a.a(1201, "Download cancelled");
        AppMethodBeat.o(189799);
        throw paramc;
      }
      int i = a(arrayOfByte, paramInputStream);
      l = paramc.FEC;
      System.currentTimeMillis();
      if (i == -1)
      {
        paramc.mState = 2020;
        try
        {
          if (!paramc.FEw.renameTo(paramc.FEx))
          {
            paramc = new com.tencent.mm.toolkit.a.a.a(1001, "Cannot rename intermediate file to dest file!");
            AppMethodBeat.o(189799);
            throw paramc;
          }
        }
        catch (com.tencent.mm.toolkit.a.a.a paramc)
        {
          boolean bool = e.DEBUG;
          paramc = new com.tencent.mm.toolkit.a.a.a(paramc.mErrorCode, paramc.getLocalizedMessage());
          AppMethodBeat.o(189799);
          throw paramc;
        }
        if (paramc.FEG != null) {
          paramc.FEG.d(paramc);
        }
        paramInputStream = paramc.FEI;
        if (paramInputStream != null) {
          paramInputStream.a(paramc);
        }
        paramc.finish();
        AppMethodBeat.o(189799);
        return;
      }
      if (i == -2147483648)
      {
        paramc = new com.tencent.mm.toolkit.a.a.a(1102, "Failed reading http response");
        AppMethodBeat.o(189799);
        throw paramc;
      }
      if (!a(arrayOfByte, i, paramOutputStream, paramFileDescriptor)) {
        break;
      }
      paramc.FEC = (l + i);
    }
    paramc = new com.tencent.mm.toolkit.a.a.a(1001, "Failed writing file");
    AppMethodBeat.o(189799);
    throw paramc;
  }
  
  private static boolean a(c paramc, File paramFile)
  {
    AppMethodBeat.i(189798);
    if ((paramc.FEA) && (paramFile.exists()))
    {
      AppMethodBeat.o(189798);
      return true;
    }
    try
    {
      if (!paramFile.getParentFile().exists()) {
        paramFile.getParentFile().mkdirs();
      }
      bool = paramFile.createNewFile();
      AppMethodBeat.o(189798);
      return bool;
    }
    catch (IOException paramc)
    {
      boolean bool = e.DEBUG;
      AppMethodBeat.o(189798);
    }
    return false;
  }
  
  private static boolean a(c paramc, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(189797);
    if (paramc.mContentLength != -1L)
    {
      AppMethodBeat.o(189797);
      return true;
    }
    String str = paramHttpURLConnection.getHeaderField("Transfer-Encoding");
    if ((str != null) && (str.equalsIgnoreCase("chunked")))
    {
      AppMethodBeat.o(189797);
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
          paramc.mContentLength = (paramc.FEC + l);
          if (l == -1L) {
            break;
          }
          AppMethodBeat.o(189797);
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
    AppMethodBeat.o(189797);
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt, OutputStream paramOutputStream, FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(189801);
    if (paramFileDescriptor.valid()) {
      try
      {
        paramOutputStream.write(paramArrayOfByte, 0, paramInt);
        paramOutputStream.flush();
        paramFileDescriptor.sync();
        AppMethodBeat.o(189801);
        return true;
      }
      catch (IOException paramArrayOfByte)
      {
        boolean bool = e.DEBUG;
        AppMethodBeat.o(189801);
        return false;
      }
    }
    if (e.DEBUG) {
      e.eOD();
    }
    AppMethodBeat.o(189801);
    return false;
  }
  
  /* Error */
  private static void c(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 242
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 246	com/tencent/mm/toolkit/a/c:FEv	Landroid/net/Uri;
    //   11: invokevirtual 251	android/net/Uri:getScheme	()Ljava/lang/String;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnull +23 -> 41
    //   21: aload 4
    //   23: ldc 253
    //   25: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   28: ifne +51 -> 79
    //   31: aload 4
    //   33: ldc 255
    //   35: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   38: ifne +41 -> 79
    //   41: new 62	com/tencent/mm/toolkit/a/a/a
    //   44: dup
    //   45: sipush 1105
    //   48: new 75	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 257
    //   55: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 246	com/tencent/mm/toolkit/a/c:FEv	Landroid/net/Uri;
    //   62: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   71: astore_0
    //   72: ldc 242
    //   74: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: athrow
    //   79: new 265	java/net/URL
    //   82: dup
    //   83: aload_0
    //   84: getfield 246	com/tencent/mm/toolkit/a/c:FEv	Landroid/net/Uri;
    //   87: invokevirtual 266	android/net/Uri:toString	()Ljava/lang/String;
    //   90: invokespecial 267	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 271	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   100: checkcast 197	java/net/HttpURLConnection
    //   103: astore 6
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: ldc_w 273
    //   114: invokevirtual 276	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   117: aload 6
    //   119: astore 5
    //   121: aload 6
    //   123: iconst_0
    //   124: invokevirtual 280	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   127: aload 6
    //   129: astore 5
    //   131: aload 6
    //   133: aload_0
    //   134: invokevirtual 284	com/tencent/mm/toolkit/a/c:eOB	()Lcom/tencent/mm/toolkit/a/a/e;
    //   137: invokeinterface 290 1 0
    //   142: invokevirtual 293	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   145: aload 6
    //   147: astore 5
    //   149: aload 6
    //   151: aload_0
    //   152: invokevirtual 284	com/tencent/mm/toolkit/a/c:eOB	()Lcom/tencent/mm/toolkit/a/a/e;
    //   155: invokeinterface 290 1 0
    //   160: invokevirtual 296	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: getfield 300	com/tencent/mm/toolkit/a/c:FEF	Ljava/util/HashMap;
    //   171: astore_3
    //   172: aload_3
    //   173: ifnull +145 -> 318
    //   176: aload 6
    //   178: astore 5
    //   180: aload_3
    //   181: invokevirtual 306	java/util/HashMap:keySet	()Ljava/util/Set;
    //   184: invokeinterface 312 1 0
    //   189: astore 4
    //   191: aload 6
    //   193: astore 5
    //   195: aload 4
    //   197: invokeinterface 317 1 0
    //   202: ifeq +116 -> 318
    //   205: aload 6
    //   207: astore 5
    //   209: aload 4
    //   211: invokeinterface 321 1 0
    //   216: checkcast 54	java/lang/String
    //   219: astore 7
    //   221: aload 6
    //   223: astore 5
    //   225: aload 6
    //   227: aload 7
    //   229: aload_3
    //   230: aload 7
    //   232: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   235: checkcast 54	java/lang/String
    //   238: invokevirtual 329	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: goto -50 -> 191
    //   244: astore_3
    //   245: aload 6
    //   247: astore 5
    //   249: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   252: istore_2
    //   253: aload 6
    //   255: astore 5
    //   257: aload_0
    //   258: invokevirtual 284	com/tencent/mm/toolkit/a/c:eOB	()Lcom/tencent/mm/toolkit/a/a/e;
    //   261: invokeinterface 332 1 0
    //   266: ifeq +952 -> 1218
    //   269: aload 6
    //   271: astore 5
    //   273: aload_0
    //   274: sipush 2030
    //   277: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   280: aload 6
    //   282: ifnull +969 -> 1251
    //   285: aload 6
    //   287: invokevirtual 335	java/net/HttpURLConnection:disconnect	()V
    //   290: ldc 242
    //   292: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: return
    //   296: astore_0
    //   297: new 62	com/tencent/mm/toolkit/a/a/a
    //   300: dup
    //   301: sipush 1105
    //   304: ldc_w 337
    //   307: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   310: astore_0
    //   311: ldc 242
    //   313: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_0
    //   317: athrow
    //   318: aload 6
    //   320: astore 5
    //   322: aload_0
    //   323: getfield 123	com/tencent/mm/toolkit/a/c:FEw	Ljava/io/File;
    //   326: invokevirtual 177	java/io/File:exists	()Z
    //   329: ifeq +102 -> 431
    //   332: aload 6
    //   334: astore 5
    //   336: invokestatic 98	com/tencent/mm/toolkit/a/e:eOC	()V
    //   339: aload 6
    //   341: astore 5
    //   343: aload_0
    //   344: getfield 173	com/tencent/mm/toolkit/a/c:FEA	Z
    //   347: ifeq +342 -> 689
    //   350: aload 6
    //   352: astore 5
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 123	com/tencent/mm/toolkit/a/c:FEw	Ljava/io/File;
    //   359: invokevirtual 340	java/io/File:length	()J
    //   362: putfield 113	com/tencent/mm/toolkit/a/c:FEC	J
    //   365: aload 6
    //   367: astore 5
    //   369: new 75	java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 342
    //   376: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload_0
    //   380: getfield 113	com/tencent/mm/toolkit/a/c:FEC	J
    //   383: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: ldc_w 344
    //   389: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: astore_3
    //   396: aload 6
    //   398: astore 5
    //   400: ldc_w 346
    //   403: aload_3
    //   404: invokestatic 350	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   407: invokevirtual 353	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   410: pop
    //   411: aload 6
    //   413: astore 5
    //   415: invokestatic 98	com/tencent/mm/toolkit/a/e:eOC	()V
    //   418: aload 6
    //   420: astore 5
    //   422: aload 6
    //   424: ldc_w 355
    //   427: aload_3
    //   428: invokevirtual 329	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 6
    //   433: astore 5
    //   435: aload_0
    //   436: sipush 2011
    //   439: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   442: aload 6
    //   444: astore 5
    //   446: aload 6
    //   448: invokevirtual 358	java/net/HttpURLConnection:getResponseCode	()I
    //   451: istore_1
    //   452: aload 6
    //   454: astore 5
    //   456: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   459: ifeq +902 -> 1361
    //   462: aload 6
    //   464: astore 5
    //   466: new 75	java/lang/StringBuilder
    //   469: dup
    //   470: ldc_w 360
    //   473: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   480: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 362
    //   486: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload_1
    //   490: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 6
    //   496: astore 5
    //   498: invokestatic 98	com/tencent/mm/toolkit/a/e:eOC	()V
    //   501: goto +860 -> 1361
    //   504: aload 6
    //   506: astore 5
    //   508: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   511: ifeq +56 -> 567
    //   514: aload 6
    //   516: astore 5
    //   518: new 75	java/lang/StringBuilder
    //   521: dup
    //   522: ldc_w 364
    //   525: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   528: iload_1
    //   529: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   532: ldc_w 366
    //   535: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   542: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: ldc_w 368
    //   548: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 6
    //   553: invokevirtual 371	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   556: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 6
    //   562: astore 5
    //   564: invokestatic 236	com/tencent/mm/toolkit/a/e:eOD	()V
    //   567: aload 6
    //   569: astore 5
    //   571: new 62	com/tencent/mm/toolkit/a/a/a
    //   574: dup
    //   575: sipush 1101
    //   578: new 75	java/lang/StringBuilder
    //   581: dup
    //   582: ldc_w 373
    //   585: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   588: iload_1
    //   589: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc_w 375
    //   595: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload 6
    //   600: invokevirtual 371	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   603: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   612: astore_3
    //   613: aload 6
    //   615: astore 5
    //   617: ldc 242
    //   619: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: aload 6
    //   624: astore 5
    //   626: aload_3
    //   627: athrow
    //   628: astore_0
    //   629: aload 6
    //   631: astore 5
    //   633: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   636: istore_2
    //   637: aload 6
    //   639: astore 5
    //   641: new 62	com/tencent/mm/toolkit/a/a/a
    //   644: dup
    //   645: sipush 1102
    //   648: ldc_w 377
    //   651: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   654: astore_0
    //   655: aload 6
    //   657: astore 5
    //   659: ldc 242
    //   661: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: aload 6
    //   666: astore 5
    //   668: aload_0
    //   669: athrow
    //   670: astore_0
    //   671: aload 5
    //   673: astore_3
    //   674: aload_3
    //   675: ifnull +7 -> 682
    //   678: aload_3
    //   679: invokevirtual 335	java/net/HttpURLConnection:disconnect	()V
    //   682: ldc 242
    //   684: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   687: aload_0
    //   688: athrow
    //   689: aload 6
    //   691: astore 5
    //   693: aload_0
    //   694: lconst_0
    //   695: putfield 113	com/tencent/mm/toolkit/a/c:FEC	J
    //   698: aload 6
    //   700: astore 5
    //   702: invokestatic 98	com/tencent/mm/toolkit/a/e:eOC	()V
    //   705: aload 6
    //   707: astore 5
    //   709: aload_0
    //   710: getfield 123	com/tencent/mm/toolkit/a/c:FEw	Ljava/io/File;
    //   713: invokestatic 383	com/tencent/mm/toolkit/a/d$b:O	(Ljava/io/File;)V
    //   716: goto -285 -> 431
    //   719: aload 6
    //   721: astore 5
    //   723: aload_0
    //   724: aload 6
    //   726: invokestatic 385	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/net/HttpURLConnection;)Z
    //   729: ifeq +247 -> 976
    //   732: aload 6
    //   734: astore 5
    //   736: new 128	java/io/File
    //   739: dup
    //   740: aload_0
    //   741: getfield 123	com/tencent/mm/toolkit/a/c:FEw	Ljava/io/File;
    //   744: invokevirtual 388	java/io/File:getPath	()Ljava/lang/String;
    //   747: invokespecial 389	java/io/File:<init>	(Ljava/lang/String;)V
    //   750: astore_3
    //   751: aload 6
    //   753: astore 5
    //   755: aload_0
    //   756: aload_3
    //   757: invokestatic 391	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/io/File;)Z
    //   760: istore_2
    //   761: iload_2
    //   762: ifeq +181 -> 943
    //   765: aload 6
    //   767: invokevirtual 395	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   770: astore 4
    //   772: new 397	java/io/FileOutputStream
    //   775: dup
    //   776: aload_3
    //   777: iconst_1
    //   778: invokespecial 400	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   781: astore 5
    //   783: aload 5
    //   785: checkcast 397	java/io/FileOutputStream
    //   788: invokevirtual 404	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   791: astore 7
    //   793: new 406	java/io/BufferedOutputStream
    //   796: dup
    //   797: aload 5
    //   799: invokespecial 409	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   802: astore_3
    //   803: aload_0
    //   804: aload 4
    //   806: aload_3
    //   807: aload 7
    //   809: invokestatic 411	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/io/FileDescriptor;)V
    //   812: aload 6
    //   814: astore 5
    //   816: aload 4
    //   818: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   821: aload 6
    //   823: astore 5
    //   825: aload_3
    //   826: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   829: aload 6
    //   831: ifnull +420 -> 1251
    //   834: aload 6
    //   836: invokevirtual 335	java/net/HttpURLConnection:disconnect	()V
    //   839: ldc 242
    //   841: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   844: return
    //   845: astore_3
    //   846: aconst_null
    //   847: astore_3
    //   848: aconst_null
    //   849: astore 7
    //   851: aload 7
    //   853: ifnonnull +67 -> 920
    //   856: new 62	com/tencent/mm/toolkit/a/a/a
    //   859: dup
    //   860: sipush 1102
    //   863: ldc_w 419
    //   866: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   869: astore 4
    //   871: ldc 242
    //   873: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   876: aload 4
    //   878: athrow
    //   879: astore 5
    //   881: aload_3
    //   882: astore 4
    //   884: aload 5
    //   886: astore_3
    //   887: aload 6
    //   889: astore 5
    //   891: aload 7
    //   893: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   896: aload 6
    //   898: astore 5
    //   900: aload 4
    //   902: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   905: aload 6
    //   907: astore 5
    //   909: ldc 242
    //   911: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   914: aload 6
    //   916: astore 5
    //   918: aload_3
    //   919: athrow
    //   920: new 62	com/tencent/mm/toolkit/a/a/a
    //   923: dup
    //   924: sipush 1001
    //   927: ldc_w 421
    //   930: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   933: astore 4
    //   935: ldc 242
    //   937: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: aload 4
    //   942: athrow
    //   943: aload 6
    //   945: astore 5
    //   947: new 62	com/tencent/mm/toolkit/a/a/a
    //   950: dup
    //   951: sipush 1001
    //   954: ldc_w 423
    //   957: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   960: astore_3
    //   961: aload 6
    //   963: astore 5
    //   965: ldc 242
    //   967: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   970: aload 6
    //   972: astore 5
    //   974: aload_3
    //   975: athrow
    //   976: aload 6
    //   978: astore 5
    //   980: new 62	com/tencent/mm/toolkit/a/a/a
    //   983: dup
    //   984: sipush 1104
    //   987: ldc_w 425
    //   990: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   993: astore_3
    //   994: aload 6
    //   996: astore 5
    //   998: ldc 242
    //   1000: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1003: aload 6
    //   1005: astore 5
    //   1007: aload_3
    //   1008: athrow
    //   1009: aload 6
    //   1011: astore 5
    //   1013: aload_0
    //   1014: getfield 428	com/tencent/mm/toolkit/a/c:FEz	Z
    //   1017: ifeq +101 -> 1118
    //   1020: aload 6
    //   1022: astore 5
    //   1024: aload_0
    //   1025: getfield 431	com/tencent/mm/toolkit/a/c:FEB	I
    //   1028: iconst_5
    //   1029: if_icmpge +89 -> 1118
    //   1032: aload 6
    //   1034: astore 5
    //   1036: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   1039: ifeq +32 -> 1071
    //   1042: aload 6
    //   1044: astore 5
    //   1046: new 75	java/lang/StringBuilder
    //   1049: dup
    //   1050: ldc_w 433
    //   1053: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1056: aload_0
    //   1057: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   1060: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 6
    //   1066: astore 5
    //   1068: invokestatic 98	com/tencent/mm/toolkit/a/e:eOC	()V
    //   1071: aload 6
    //   1073: astore 5
    //   1075: aload_0
    //   1076: aload 6
    //   1078: ldc_w 435
    //   1081: invokevirtual 201	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1084: invokestatic 439	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1087: putfield 246	com/tencent/mm/toolkit/a/c:FEv	Landroid/net/Uri;
    //   1090: aload 6
    //   1092: astore 5
    //   1094: aload_0
    //   1095: aload_0
    //   1096: getfield 431	com/tencent/mm/toolkit/a/c:FEB	I
    //   1099: iconst_1
    //   1100: iadd
    //   1101: putfield 431	com/tencent/mm/toolkit/a/c:FEB	I
    //   1104: aload 6
    //   1106: astore 5
    //   1108: aload_0
    //   1109: sipush 2030
    //   1112: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   1115: goto -286 -> 829
    //   1118: aload 6
    //   1120: astore 5
    //   1122: aload_0
    //   1123: getfield 428	com/tencent/mm/toolkit/a/c:FEz	Z
    //   1126: ifeq +329 -> 1455
    //   1129: aload 6
    //   1131: astore 5
    //   1133: new 75	java/lang/StringBuilder
    //   1136: dup
    //   1137: ldc_w 441
    //   1140: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1143: aload_0
    //   1144: getfield 431	com/tencent/mm/toolkit/a/c:FEB	I
    //   1147: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: astore_3
    //   1154: aload 6
    //   1156: astore 5
    //   1158: new 62	com/tencent/mm/toolkit/a/a/a
    //   1161: dup
    //   1162: sipush 1103
    //   1165: aload_3
    //   1166: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1169: astore_3
    //   1170: aload 6
    //   1172: astore 5
    //   1174: ldc 242
    //   1176: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1179: aload 6
    //   1181: astore 5
    //   1183: aload_3
    //   1184: athrow
    //   1185: aload 6
    //   1187: astore 5
    //   1189: new 62	com/tencent/mm/toolkit/a/a/a
    //   1192: dup
    //   1193: iload_1
    //   1194: aload 6
    //   1196: invokevirtual 371	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1199: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1202: astore_3
    //   1203: aload 6
    //   1205: astore 5
    //   1207: ldc 242
    //   1209: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1212: aload 6
    //   1214: astore 5
    //   1216: aload_3
    //   1217: athrow
    //   1218: aload 6
    //   1220: astore 5
    //   1222: new 62	com/tencent/mm/toolkit/a/a/a
    //   1225: dup
    //   1226: sipush 1106
    //   1229: ldc_w 443
    //   1232: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1235: astore_0
    //   1236: aload 6
    //   1238: astore 5
    //   1240: ldc 242
    //   1242: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1245: aload 6
    //   1247: astore 5
    //   1249: aload_0
    //   1250: athrow
    //   1251: ldc 242
    //   1253: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1256: return
    //   1257: astore_0
    //   1258: goto -584 -> 674
    //   1261: astore_0
    //   1262: aconst_null
    //   1263: astore 6
    //   1265: goto -636 -> 629
    //   1268: astore_3
    //   1269: aconst_null
    //   1270: astore 6
    //   1272: goto -1027 -> 245
    //   1275: astore_3
    //   1276: aconst_null
    //   1277: astore 4
    //   1279: aconst_null
    //   1280: astore 7
    //   1282: goto -395 -> 887
    //   1285: astore_3
    //   1286: aconst_null
    //   1287: astore 5
    //   1289: aload 4
    //   1291: astore 7
    //   1293: aload 5
    //   1295: astore 4
    //   1297: goto -410 -> 887
    //   1300: astore_3
    //   1301: aload 4
    //   1303: astore 7
    //   1305: aload 5
    //   1307: astore 4
    //   1309: goto -422 -> 887
    //   1312: astore 5
    //   1314: aload_3
    //   1315: astore 8
    //   1317: aload 4
    //   1319: astore 7
    //   1321: aload 5
    //   1323: astore_3
    //   1324: aload 8
    //   1326: astore 4
    //   1328: goto -441 -> 887
    //   1331: astore_3
    //   1332: aconst_null
    //   1333: astore_3
    //   1334: aload 4
    //   1336: astore 7
    //   1338: goto -487 -> 851
    //   1341: astore_3
    //   1342: aload 5
    //   1344: astore_3
    //   1345: aload 4
    //   1347: astore 7
    //   1349: goto -498 -> 851
    //   1352: astore 5
    //   1354: aload 4
    //   1356: astore 7
    //   1358: goto -507 -> 851
    //   1361: iload_1
    //   1362: lookupswitch	default:+90->1452, 200:+-643->719, 206:+-643->719, 301:+-353->1009, 302:+-353->1009, 303:+-353->1009, 307:+-353->1009, 404:+-177->1185, 416:+-177->1185, 500:+-177->1185, 503:+-177->1185
    //   1453: <illegal opcode>
    //   1454: astore_1
    //   1455: ldc_w 445
    //   1458: astore_3
    //   1459: goto -305 -> 1154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1462	0	paramc	c
    //   451	911	1	i	int
    //   252	510	2	bool	boolean
    //   1	229	3	localHashMap	java.util.HashMap
    //   244	1	3	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   395	431	3	localObject1	Object
    //   845	1	3	localIOException1	IOException
    //   847	370	3	localObject2	Object
    //   1268	1	3	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1275	1	3	localObject3	Object
    //   1285	1	3	localObject4	Object
    //   1300	15	3	localObject5	Object
    //   1323	1	3	localObject6	Object
    //   1331	1	3	localIOException2	IOException
    //   1333	1	3	localObject7	Object
    //   1341	1	3	localIOException3	IOException
    //   1344	115	3	localObject8	Object
    //   14	1341	4	localObject9	Object
    //   107	717	5	localObject10	Object
    //   879	6	5	localObject11	Object
    //   889	417	5	localHttpURLConnection1	HttpURLConnection
    //   1312	31	5	localObject12	Object
    //   1352	1	5	localIOException4	IOException
    //   103	1168	6	localHttpURLConnection2	HttpURLConnection
    //   219	1138	7	localObject13	Object
    //   1315	10	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   109	117	244	java/net/SocketTimeoutException
    //   121	127	244	java/net/SocketTimeoutException
    //   131	145	244	java/net/SocketTimeoutException
    //   149	163	244	java/net/SocketTimeoutException
    //   167	172	244	java/net/SocketTimeoutException
    //   180	191	244	java/net/SocketTimeoutException
    //   195	205	244	java/net/SocketTimeoutException
    //   209	221	244	java/net/SocketTimeoutException
    //   225	241	244	java/net/SocketTimeoutException
    //   322	332	244	java/net/SocketTimeoutException
    //   336	339	244	java/net/SocketTimeoutException
    //   343	350	244	java/net/SocketTimeoutException
    //   354	365	244	java/net/SocketTimeoutException
    //   369	396	244	java/net/SocketTimeoutException
    //   400	411	244	java/net/SocketTimeoutException
    //   415	418	244	java/net/SocketTimeoutException
    //   422	431	244	java/net/SocketTimeoutException
    //   435	442	244	java/net/SocketTimeoutException
    //   446	452	244	java/net/SocketTimeoutException
    //   456	462	244	java/net/SocketTimeoutException
    //   466	494	244	java/net/SocketTimeoutException
    //   498	501	244	java/net/SocketTimeoutException
    //   508	514	244	java/net/SocketTimeoutException
    //   518	560	244	java/net/SocketTimeoutException
    //   564	567	244	java/net/SocketTimeoutException
    //   571	613	244	java/net/SocketTimeoutException
    //   617	622	244	java/net/SocketTimeoutException
    //   626	628	244	java/net/SocketTimeoutException
    //   693	698	244	java/net/SocketTimeoutException
    //   702	705	244	java/net/SocketTimeoutException
    //   709	716	244	java/net/SocketTimeoutException
    //   723	732	244	java/net/SocketTimeoutException
    //   736	751	244	java/net/SocketTimeoutException
    //   755	761	244	java/net/SocketTimeoutException
    //   816	821	244	java/net/SocketTimeoutException
    //   825	829	244	java/net/SocketTimeoutException
    //   891	896	244	java/net/SocketTimeoutException
    //   900	905	244	java/net/SocketTimeoutException
    //   909	914	244	java/net/SocketTimeoutException
    //   918	920	244	java/net/SocketTimeoutException
    //   947	961	244	java/net/SocketTimeoutException
    //   965	970	244	java/net/SocketTimeoutException
    //   974	976	244	java/net/SocketTimeoutException
    //   980	994	244	java/net/SocketTimeoutException
    //   998	1003	244	java/net/SocketTimeoutException
    //   1007	1009	244	java/net/SocketTimeoutException
    //   1013	1020	244	java/net/SocketTimeoutException
    //   1024	1032	244	java/net/SocketTimeoutException
    //   1036	1042	244	java/net/SocketTimeoutException
    //   1046	1064	244	java/net/SocketTimeoutException
    //   1068	1071	244	java/net/SocketTimeoutException
    //   1075	1090	244	java/net/SocketTimeoutException
    //   1094	1104	244	java/net/SocketTimeoutException
    //   1108	1115	244	java/net/SocketTimeoutException
    //   1122	1129	244	java/net/SocketTimeoutException
    //   1133	1154	244	java/net/SocketTimeoutException
    //   1158	1170	244	java/net/SocketTimeoutException
    //   1174	1179	244	java/net/SocketTimeoutException
    //   1183	1185	244	java/net/SocketTimeoutException
    //   1189	1203	244	java/net/SocketTimeoutException
    //   1207	1212	244	java/net/SocketTimeoutException
    //   1216	1218	244	java/net/SocketTimeoutException
    //   79	95	296	java/net/MalformedURLException
    //   109	117	628	java/io/IOException
    //   121	127	628	java/io/IOException
    //   131	145	628	java/io/IOException
    //   149	163	628	java/io/IOException
    //   167	172	628	java/io/IOException
    //   180	191	628	java/io/IOException
    //   195	205	628	java/io/IOException
    //   209	221	628	java/io/IOException
    //   225	241	628	java/io/IOException
    //   322	332	628	java/io/IOException
    //   336	339	628	java/io/IOException
    //   343	350	628	java/io/IOException
    //   354	365	628	java/io/IOException
    //   369	396	628	java/io/IOException
    //   400	411	628	java/io/IOException
    //   415	418	628	java/io/IOException
    //   422	431	628	java/io/IOException
    //   435	442	628	java/io/IOException
    //   446	452	628	java/io/IOException
    //   456	462	628	java/io/IOException
    //   466	494	628	java/io/IOException
    //   498	501	628	java/io/IOException
    //   508	514	628	java/io/IOException
    //   518	560	628	java/io/IOException
    //   564	567	628	java/io/IOException
    //   571	613	628	java/io/IOException
    //   617	622	628	java/io/IOException
    //   626	628	628	java/io/IOException
    //   693	698	628	java/io/IOException
    //   702	705	628	java/io/IOException
    //   709	716	628	java/io/IOException
    //   723	732	628	java/io/IOException
    //   736	751	628	java/io/IOException
    //   755	761	628	java/io/IOException
    //   816	821	628	java/io/IOException
    //   825	829	628	java/io/IOException
    //   891	896	628	java/io/IOException
    //   900	905	628	java/io/IOException
    //   909	914	628	java/io/IOException
    //   918	920	628	java/io/IOException
    //   947	961	628	java/io/IOException
    //   965	970	628	java/io/IOException
    //   974	976	628	java/io/IOException
    //   980	994	628	java/io/IOException
    //   998	1003	628	java/io/IOException
    //   1007	1009	628	java/io/IOException
    //   1013	1020	628	java/io/IOException
    //   1024	1032	628	java/io/IOException
    //   1036	1042	628	java/io/IOException
    //   1046	1064	628	java/io/IOException
    //   1068	1071	628	java/io/IOException
    //   1075	1090	628	java/io/IOException
    //   1094	1104	628	java/io/IOException
    //   1108	1115	628	java/io/IOException
    //   1122	1129	628	java/io/IOException
    //   1133	1154	628	java/io/IOException
    //   1158	1170	628	java/io/IOException
    //   1174	1179	628	java/io/IOException
    //   1183	1185	628	java/io/IOException
    //   1189	1203	628	java/io/IOException
    //   1207	1212	628	java/io/IOException
    //   1216	1218	628	java/io/IOException
    //   109	117	670	finally
    //   121	127	670	finally
    //   131	145	670	finally
    //   149	163	670	finally
    //   167	172	670	finally
    //   180	191	670	finally
    //   195	205	670	finally
    //   209	221	670	finally
    //   225	241	670	finally
    //   249	253	670	finally
    //   257	269	670	finally
    //   273	280	670	finally
    //   322	332	670	finally
    //   336	339	670	finally
    //   343	350	670	finally
    //   354	365	670	finally
    //   369	396	670	finally
    //   400	411	670	finally
    //   415	418	670	finally
    //   422	431	670	finally
    //   435	442	670	finally
    //   446	452	670	finally
    //   456	462	670	finally
    //   466	494	670	finally
    //   498	501	670	finally
    //   508	514	670	finally
    //   518	560	670	finally
    //   564	567	670	finally
    //   571	613	670	finally
    //   617	622	670	finally
    //   626	628	670	finally
    //   633	637	670	finally
    //   641	655	670	finally
    //   659	664	670	finally
    //   668	670	670	finally
    //   693	698	670	finally
    //   702	705	670	finally
    //   709	716	670	finally
    //   723	732	670	finally
    //   736	751	670	finally
    //   755	761	670	finally
    //   816	821	670	finally
    //   825	829	670	finally
    //   891	896	670	finally
    //   900	905	670	finally
    //   909	914	670	finally
    //   918	920	670	finally
    //   947	961	670	finally
    //   965	970	670	finally
    //   974	976	670	finally
    //   980	994	670	finally
    //   998	1003	670	finally
    //   1007	1009	670	finally
    //   1013	1020	670	finally
    //   1024	1032	670	finally
    //   1036	1042	670	finally
    //   1046	1064	670	finally
    //   1068	1071	670	finally
    //   1075	1090	670	finally
    //   1094	1104	670	finally
    //   1108	1115	670	finally
    //   1122	1129	670	finally
    //   1133	1154	670	finally
    //   1158	1170	670	finally
    //   1174	1179	670	finally
    //   1183	1185	670	finally
    //   1189	1203	670	finally
    //   1207	1212	670	finally
    //   1216	1218	670	finally
    //   1222	1236	670	finally
    //   1240	1245	670	finally
    //   1249	1251	670	finally
    //   765	772	845	java/io/IOException
    //   856	879	879	finally
    //   920	943	879	finally
    //   95	105	1257	finally
    //   95	105	1261	java/io/IOException
    //   95	105	1268	java/net/SocketTimeoutException
    //   765	772	1275	finally
    //   772	783	1285	finally
    //   783	803	1300	finally
    //   803	812	1312	finally
    //   772	783	1331	java/io/IOException
    //   783	803	1341	java/io/IOException
    //   803	812	1352	java/io/IOException
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(189795);
    Context localContext = this.mContext;
    locala = new a();
    if ((localContext != null) && (android.support.v4.content.b.checkSelfPermission(localContext, "android.permission.WAKE_LOCK") == 0))
    {
      locala.zqF = ((PowerManager)localContext.getSystemService("power")).newWakeLock(1, e.TAG);
      if (!locala.zqF.isHeld())
      {
        locala.zqF.setWorkSource(new WorkSource());
        locala.zqF.acquire();
      }
      locala.FEt = ((WifiManager)localContext.getSystemService("wifi")).createWifiLock("WIFI LOCK : " + e.TAG);
      if (!locala.FEt.isHeld()) {
        locala.FEt.acquire();
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
        if (!paramc.FEy) {
          continue;
        }
        if (!e.DEBUG) {
          continue;
        }
        new StringBuilder("clean up target file, path = ").append(paramc.FEx.getPath());
        e.eOC();
        d.b.O(paramc.FEx);
        d.b.O(paramc.FEw);
        a.a(paramc, i, str);
        paramc.finish();
        return;
      }
      finally
      {
        locala.release();
        AppMethodBeat.o(189795);
      }
      e.eOD();
    }
  }
  
  public final void fM(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  static final class a
  {
    WifiManager.WifiLock FEt;
    PowerManager.WakeLock zqF;
    
    public final void release()
    {
      AppMethodBeat.i(189794);
      try
      {
        if ((this.zqF != null) && (this.zqF.isHeld())) {
          this.zqF.release();
        }
        if ((this.FEt != null) && (this.FEt.isHeld())) {
          this.FEt.release();
        }
        AppMethodBeat.o(189794);
        return;
      }
      catch (Throwable localThrowable)
      {
        boolean bool = e.DEBUG;
        AppMethodBeat.o(189794);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.b
 * JD-Core Version:    0.7.0.1
 */