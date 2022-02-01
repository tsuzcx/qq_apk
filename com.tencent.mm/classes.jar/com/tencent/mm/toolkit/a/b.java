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
  private final a VOC;
  private Context mContext;
  
  b(a parama)
  {
    this.VOC = parama;
  }
  
  private static int a(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    AppMethodBeat.i(220765);
    try
    {
      int i = paramInputStream.read(paramArrayOfByte);
      AppMethodBeat.o(220765);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      boolean bool = e.DEBUG;
      if ("unexpected end of stream".equals(paramArrayOfByte.getMessage()))
      {
        AppMethodBeat.o(220765);
        return -1;
      }
      AppMethodBeat.o(220765);
    }
    return -2147483648;
  }
  
  private static void a(c paramc, InputStream paramInputStream, OutputStream paramOutputStream, FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(220763);
    paramc.mState = 2012;
    byte[] arrayOfByte = new byte[4096];
    long l = paramc.mContentLength;
    if (e.DEBUG)
    {
      new StringBuilder("Start transfer data, content length = ").append(l).append(", id = ").append(paramc.mId);
      e.hEQ();
    }
    for (;;)
    {
      if (paramc.mCancelled)
      {
        if (e.DEBUG)
        {
          new StringBuilder("Stopping the download as Download Request is cancelled, id ").append(paramc.mId);
          e.hEQ();
        }
        paramc = new com.tencent.mm.toolkit.a.a.a(1201, "Download cancelled");
        AppMethodBeat.o(220763);
        throw paramc;
      }
      int i = a(arrayOfByte, paramInputStream);
      l = paramc.VOM;
      System.currentTimeMillis();
      if (i == -1)
      {
        paramc.mState = 2020;
        try
        {
          if (!paramc.VOG.renameTo(paramc.VOH))
          {
            paramc = new com.tencent.mm.toolkit.a.a.a(1001, "Cannot rename intermediate file to dest file!");
            AppMethodBeat.o(220763);
            throw paramc;
          }
        }
        catch (com.tencent.mm.toolkit.a.a.a paramc)
        {
          boolean bool = e.DEBUG;
          paramc = new com.tencent.mm.toolkit.a.a.a(paramc.mErrorCode, paramc.getLocalizedMessage());
          AppMethodBeat.o(220763);
          throw paramc;
        }
        if (paramc.VOQ != null) {
          paramc.VOQ.d(paramc);
        }
        paramInputStream = paramc.VOS;
        if (paramInputStream != null) {
          paramInputStream.a(paramc);
        }
        paramc.finish();
        AppMethodBeat.o(220763);
        return;
      }
      if (i == -2147483648)
      {
        paramc = new com.tencent.mm.toolkit.a.a.a(1102, "Failed reading http response");
        AppMethodBeat.o(220763);
        throw paramc;
      }
      if (!a(arrayOfByte, i, paramOutputStream, paramFileDescriptor)) {
        break;
      }
      paramc.VOM = (l + i);
    }
    paramc = new com.tencent.mm.toolkit.a.a.a(1001, "Failed writing file");
    AppMethodBeat.o(220763);
    throw paramc;
  }
  
  private static boolean a(c paramc, File paramFile)
  {
    AppMethodBeat.i(220749);
    if ((paramc.VOK) && (paramFile.exists()))
    {
      AppMethodBeat.o(220749);
      return true;
    }
    try
    {
      if (!paramFile.getParentFile().exists()) {
        paramFile.getParentFile().mkdirs();
      }
      bool = paramFile.createNewFile();
      AppMethodBeat.o(220749);
      return bool;
    }
    catch (IOException paramc)
    {
      boolean bool = e.DEBUG;
      AppMethodBeat.o(220749);
    }
    return false;
  }
  
  private static boolean a(c paramc, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(220746);
    if (paramc.mContentLength != -1L)
    {
      AppMethodBeat.o(220746);
      return true;
    }
    String str = paramHttpURLConnection.getHeaderField("Transfer-Encoding");
    if ((str != null) && (str.equalsIgnoreCase("chunked")))
    {
      AppMethodBeat.o(220746);
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
          paramc.mContentLength = (paramc.VOM + l);
          if (l == -1L) {
            break;
          }
          AppMethodBeat.o(220746);
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
    AppMethodBeat.o(220746);
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt, OutputStream paramOutputStream, FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(220769);
    if (paramFileDescriptor.valid()) {
      try
      {
        paramOutputStream.write(paramArrayOfByte, 0, paramInt);
        paramOutputStream.flush();
        paramFileDescriptor.sync();
        AppMethodBeat.o(220769);
        return true;
      }
      catch (IOException paramArrayOfByte)
      {
        boolean bool = e.DEBUG;
        AppMethodBeat.o(220769);
        return false;
      }
    }
    if (e.DEBUG) {
      e.hER();
    }
    AppMethodBeat.o(220769);
    return false;
  }
  
  /* Error */
  private void c(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 242
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 246	com/tencent/mm/toolkit/a/c:VOF	Landroid/net/Uri;
    //   12: invokevirtual 251	android/net/Uri:getScheme	()Ljava/lang/String;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull +23 -> 42
    //   22: aload 5
    //   24: ldc 253
    //   26: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   29: ifne +51 -> 80
    //   32: aload 5
    //   34: ldc 255
    //   36: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   39: ifne +41 -> 80
    //   42: new 62	com/tencent/mm/toolkit/a/a/a
    //   45: dup
    //   46: sipush 1105
    //   49: new 75	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 257
    //   56: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: getfield 246	com/tencent/mm/toolkit/a/c:VOF	Landroid/net/Uri;
    //   63: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   72: astore_1
    //   73: ldc 242
    //   75: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_1
    //   79: athrow
    //   80: new 265	java/net/URL
    //   83: dup
    //   84: aload_1
    //   85: getfield 246	com/tencent/mm/toolkit/a/c:VOF	Landroid/net/Uri;
    //   88: invokevirtual 266	android/net/Uri:toString	()Ljava/lang/String;
    //   91: invokespecial 267	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: astore 5
    //   96: aload 5
    //   98: invokevirtual 271	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   101: checkcast 197	java/net/HttpURLConnection
    //   104: astore 7
    //   106: aload 7
    //   108: astore 6
    //   110: aload 7
    //   112: ldc_w 273
    //   115: invokevirtual 276	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   118: aload 7
    //   120: astore 6
    //   122: aload 7
    //   124: iconst_0
    //   125: invokevirtual 280	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   128: aload 7
    //   130: astore 6
    //   132: aload 7
    //   134: aload_1
    //   135: invokevirtual 284	com/tencent/mm/toolkit/a/c:hEP	()Lcom/tencent/mm/toolkit/a/a/e;
    //   138: invokeinterface 290 1 0
    //   143: invokevirtual 293	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   146: aload 7
    //   148: astore 6
    //   150: aload 7
    //   152: aload_1
    //   153: invokevirtual 284	com/tencent/mm/toolkit/a/c:hEP	()Lcom/tencent/mm/toolkit/a/a/e;
    //   156: invokeinterface 290 1 0
    //   161: invokevirtual 296	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   164: aload 7
    //   166: astore 6
    //   168: aload_1
    //   169: getfield 300	com/tencent/mm/toolkit/a/c:VOP	Ljava/util/HashMap;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +148 -> 324
    //   179: aload 7
    //   181: astore 6
    //   183: aload 4
    //   185: invokevirtual 306	java/util/HashMap:keySet	()Ljava/util/Set;
    //   188: invokeinterface 312 1 0
    //   193: astore 5
    //   195: aload 7
    //   197: astore 6
    //   199: aload 5
    //   201: invokeinterface 317 1 0
    //   206: ifeq +118 -> 324
    //   209: aload 7
    //   211: astore 6
    //   213: aload 5
    //   215: invokeinterface 321 1 0
    //   220: checkcast 54	java/lang/String
    //   223: astore 8
    //   225: aload 7
    //   227: astore 6
    //   229: aload 7
    //   231: aload 8
    //   233: aload 4
    //   235: aload 8
    //   237: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   240: checkcast 54	java/lang/String
    //   243: invokevirtual 329	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -51 -> 195
    //   249: astore 4
    //   251: aload 7
    //   253: astore 6
    //   255: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   258: istore_3
    //   259: aload 7
    //   261: astore 6
    //   263: aload_1
    //   264: invokevirtual 284	com/tencent/mm/toolkit/a/c:hEP	()Lcom/tencent/mm/toolkit/a/a/e;
    //   267: invokeinterface 332 1 0
    //   272: ifeq +981 -> 1253
    //   275: aload 7
    //   277: astore 6
    //   279: aload_1
    //   280: sipush 2030
    //   283: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   286: aload 7
    //   288: ifnull +998 -> 1286
    //   291: aload 7
    //   293: invokevirtual 335	java/net/HttpURLConnection:disconnect	()V
    //   296: ldc 242
    //   298: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: astore_1
    //   303: new 62	com/tencent/mm/toolkit/a/a/a
    //   306: dup
    //   307: sipush 1105
    //   310: ldc_w 337
    //   313: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   316: astore_1
    //   317: ldc 242
    //   319: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_1
    //   323: athrow
    //   324: aload 7
    //   326: astore 6
    //   328: aload_1
    //   329: getfield 123	com/tencent/mm/toolkit/a/c:VOG	Ljava/io/File;
    //   332: invokevirtual 177	java/io/File:exists	()Z
    //   335: ifeq +105 -> 440
    //   338: aload 7
    //   340: astore 6
    //   342: invokestatic 98	com/tencent/mm/toolkit/a/e:hEQ	()V
    //   345: aload 7
    //   347: astore 6
    //   349: aload_1
    //   350: getfield 173	com/tencent/mm/toolkit/a/c:VOK	Z
    //   353: ifeq +350 -> 703
    //   356: aload 7
    //   358: astore 6
    //   360: aload_1
    //   361: aload_1
    //   362: getfield 123	com/tencent/mm/toolkit/a/c:VOG	Ljava/io/File;
    //   365: invokevirtual 340	java/io/File:length	()J
    //   368: putfield 113	com/tencent/mm/toolkit/a/c:VOM	J
    //   371: aload 7
    //   373: astore 6
    //   375: new 75	java/lang/StringBuilder
    //   378: dup
    //   379: ldc_w 342
    //   382: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload_1
    //   386: getfield 113	com/tencent/mm/toolkit/a/c:VOM	J
    //   389: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: ldc_w 344
    //   395: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: astore 4
    //   403: aload 7
    //   405: astore 6
    //   407: ldc_w 346
    //   410: aload 4
    //   412: invokestatic 350	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   415: invokevirtual 353	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   418: pop
    //   419: aload 7
    //   421: astore 6
    //   423: invokestatic 98	com/tencent/mm/toolkit/a/e:hEQ	()V
    //   426: aload 7
    //   428: astore 6
    //   430: aload 7
    //   432: ldc_w 355
    //   435: aload 4
    //   437: invokevirtual 329	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload 7
    //   442: astore 6
    //   444: aload_1
    //   445: sipush 2011
    //   448: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   451: aload 7
    //   453: astore 6
    //   455: aload 7
    //   457: invokevirtual 358	java/net/HttpURLConnection:getResponseCode	()I
    //   460: istore_2
    //   461: aload 7
    //   463: astore 6
    //   465: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   468: ifeq +938 -> 1406
    //   471: aload 7
    //   473: astore 6
    //   475: new 75	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 360
    //   482: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload_1
    //   486: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   489: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: ldc_w 362
    //   495: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: iload_2
    //   499: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 7
    //   505: astore 6
    //   507: invokestatic 98	com/tencent/mm/toolkit/a/e:hEQ	()V
    //   510: goto +896 -> 1406
    //   513: aload 7
    //   515: astore 6
    //   517: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   520: ifeq +56 -> 576
    //   523: aload 7
    //   525: astore 6
    //   527: new 75	java/lang/StringBuilder
    //   530: dup
    //   531: ldc_w 364
    //   534: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   537: iload_2
    //   538: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: ldc_w 366
    //   544: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_1
    //   548: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   551: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: ldc_w 368
    //   557: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 7
    //   562: invokevirtual 371	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   565: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 7
    //   571: astore 6
    //   573: invokestatic 236	com/tencent/mm/toolkit/a/e:hER	()V
    //   576: aload 7
    //   578: astore 6
    //   580: new 62	com/tencent/mm/toolkit/a/a/a
    //   583: dup
    //   584: sipush 1101
    //   587: new 75	java/lang/StringBuilder
    //   590: dup
    //   591: ldc_w 373
    //   594: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   597: iload_2
    //   598: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 375
    //   604: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 7
    //   609: invokevirtual 371	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   612: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   621: astore 4
    //   623: aload 7
    //   625: astore 6
    //   627: ldc 242
    //   629: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   632: aload 7
    //   634: astore 6
    //   636: aload 4
    //   638: athrow
    //   639: astore_1
    //   640: aload 7
    //   642: astore 6
    //   644: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   647: istore_3
    //   648: aload 7
    //   650: astore 6
    //   652: new 62	com/tencent/mm/toolkit/a/a/a
    //   655: dup
    //   656: sipush 1102
    //   659: ldc_w 377
    //   662: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   665: astore_1
    //   666: aload 7
    //   668: astore 6
    //   670: ldc 242
    //   672: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   675: aload 7
    //   677: astore 6
    //   679: aload_1
    //   680: athrow
    //   681: astore_1
    //   682: aload 6
    //   684: astore 4
    //   686: aload 4
    //   688: ifnull +8 -> 696
    //   691: aload 4
    //   693: invokevirtual 335	java/net/HttpURLConnection:disconnect	()V
    //   696: ldc 242
    //   698: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   701: aload_1
    //   702: athrow
    //   703: aload 7
    //   705: astore 6
    //   707: aload_1
    //   708: lconst_0
    //   709: putfield 113	com/tencent/mm/toolkit/a/c:VOM	J
    //   712: aload 7
    //   714: astore 6
    //   716: invokestatic 98	com/tencent/mm/toolkit/a/e:hEQ	()V
    //   719: aload 7
    //   721: astore 6
    //   723: aload_1
    //   724: getfield 123	com/tencent/mm/toolkit/a/c:VOG	Ljava/io/File;
    //   727: invokestatic 383	com/tencent/mm/toolkit/a/d$b:M	(Ljava/io/File;)V
    //   730: goto -290 -> 440
    //   733: aload 7
    //   735: astore 6
    //   737: aload_1
    //   738: aload 7
    //   740: invokestatic 385	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/net/HttpURLConnection;)Z
    //   743: ifeq +260 -> 1003
    //   746: aload 7
    //   748: astore 6
    //   750: new 128	java/io/File
    //   753: dup
    //   754: aload_1
    //   755: getfield 123	com/tencent/mm/toolkit/a/c:VOG	Ljava/io/File;
    //   758: invokevirtual 388	java/io/File:getPath	()Ljava/lang/String;
    //   761: invokespecial 389	java/io/File:<init>	(Ljava/lang/String;)V
    //   764: astore 4
    //   766: aload 7
    //   768: astore 6
    //   770: aload_1
    //   771: aload 4
    //   773: invokestatic 391	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/io/File;)Z
    //   776: istore_3
    //   777: iload_3
    //   778: ifeq +190 -> 968
    //   781: aload 7
    //   783: invokevirtual 395	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   786: astore 5
    //   788: new 397	java/io/FileOutputStream
    //   791: dup
    //   792: aload 4
    //   794: iconst_1
    //   795: invokespecial 400	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   798: astore 6
    //   800: aload 6
    //   802: checkcast 397	java/io/FileOutputStream
    //   805: invokevirtual 404	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   808: astore 8
    //   810: new 406	java/io/BufferedOutputStream
    //   813: dup
    //   814: aload 6
    //   816: invokespecial 409	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   819: astore 4
    //   821: aload_1
    //   822: aload 5
    //   824: aload 4
    //   826: aload 8
    //   828: invokestatic 411	com/tencent/mm/toolkit/a/b:a	(Lcom/tencent/mm/toolkit/a/c;Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/io/FileDescriptor;)V
    //   831: aload 7
    //   833: astore 6
    //   835: aload 5
    //   837: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   840: aload 7
    //   842: astore 6
    //   844: aload 4
    //   846: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   849: aload 7
    //   851: ifnull +435 -> 1286
    //   854: aload 7
    //   856: invokevirtual 335	java/net/HttpURLConnection:disconnect	()V
    //   859: ldc 242
    //   861: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   864: return
    //   865: astore 4
    //   867: aconst_null
    //   868: astore 4
    //   870: aconst_null
    //   871: astore 8
    //   873: aload 8
    //   875: ifnonnull +70 -> 945
    //   878: new 62	com/tencent/mm/toolkit/a/a/a
    //   881: dup
    //   882: sipush 1102
    //   885: ldc_w 419
    //   888: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   891: astore 5
    //   893: ldc 242
    //   895: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   898: aload 5
    //   900: athrow
    //   901: astore 6
    //   903: aload 4
    //   905: astore 5
    //   907: aload 6
    //   909: astore 4
    //   911: aload 7
    //   913: astore 6
    //   915: aload 8
    //   917: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   920: aload 7
    //   922: astore 6
    //   924: aload 5
    //   926: invokestatic 417	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   929: aload 7
    //   931: astore 6
    //   933: ldc 242
    //   935: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: aload 7
    //   940: astore 6
    //   942: aload 4
    //   944: athrow
    //   945: new 62	com/tencent/mm/toolkit/a/a/a
    //   948: dup
    //   949: sipush 1001
    //   952: ldc_w 421
    //   955: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   958: astore 5
    //   960: ldc 242
    //   962: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   965: aload 5
    //   967: athrow
    //   968: aload 7
    //   970: astore 6
    //   972: new 62	com/tencent/mm/toolkit/a/a/a
    //   975: dup
    //   976: sipush 1001
    //   979: ldc_w 423
    //   982: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   985: astore 4
    //   987: aload 7
    //   989: astore 6
    //   991: ldc 242
    //   993: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   996: aload 7
    //   998: astore 6
    //   1000: aload 4
    //   1002: athrow
    //   1003: aload 7
    //   1005: astore 6
    //   1007: new 62	com/tencent/mm/toolkit/a/a/a
    //   1010: dup
    //   1011: sipush 1104
    //   1014: ldc_w 425
    //   1017: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1020: astore 4
    //   1022: aload 7
    //   1024: astore 6
    //   1026: ldc 242
    //   1028: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1031: aload 7
    //   1033: astore 6
    //   1035: aload 4
    //   1037: athrow
    //   1038: aload 7
    //   1040: astore 6
    //   1042: aload_1
    //   1043: getfield 428	com/tencent/mm/toolkit/a/c:VOJ	Z
    //   1046: ifeq +101 -> 1147
    //   1049: aload 7
    //   1051: astore 6
    //   1053: aload_1
    //   1054: getfield 431	com/tencent/mm/toolkit/a/c:VOL	I
    //   1057: iconst_5
    //   1058: if_icmpge +89 -> 1147
    //   1061: aload 7
    //   1063: astore 6
    //   1065: getstatic 46	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   1068: ifeq +32 -> 1100
    //   1071: aload 7
    //   1073: astore 6
    //   1075: new 75	java/lang/StringBuilder
    //   1078: dup
    //   1079: ldc_w 433
    //   1082: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1085: aload_1
    //   1086: getfield 92	com/tencent/mm/toolkit/a/c:mId	I
    //   1089: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1092: pop
    //   1093: aload 7
    //   1095: astore 6
    //   1097: invokestatic 98	com/tencent/mm/toolkit/a/e:hEQ	()V
    //   1100: aload 7
    //   1102: astore 6
    //   1104: aload_1
    //   1105: aload 7
    //   1107: ldc_w 435
    //   1110: invokevirtual 201	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1113: invokestatic 439	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1116: putfield 246	com/tencent/mm/toolkit/a/c:VOF	Landroid/net/Uri;
    //   1119: aload 7
    //   1121: astore 6
    //   1123: aload_1
    //   1124: aload_1
    //   1125: getfield 431	com/tencent/mm/toolkit/a/c:VOL	I
    //   1128: iconst_1
    //   1129: iadd
    //   1130: putfield 431	com/tencent/mm/toolkit/a/c:VOL	I
    //   1133: aload 7
    //   1135: astore 6
    //   1137: aload_1
    //   1138: sipush 2030
    //   1141: putfield 69	com/tencent/mm/toolkit/a/c:mState	I
    //   1144: goto -295 -> 849
    //   1147: aload 7
    //   1149: astore 6
    //   1151: aload_1
    //   1152: getfield 428	com/tencent/mm/toolkit/a/c:VOJ	Z
    //   1155: ifeq +344 -> 1499
    //   1158: aload 7
    //   1160: astore 6
    //   1162: new 75	java/lang/StringBuilder
    //   1165: dup
    //   1166: ldc_w 441
    //   1169: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1172: aload_1
    //   1173: getfield 431	com/tencent/mm/toolkit/a/c:VOL	I
    //   1176: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1179: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: astore 4
    //   1184: aload 7
    //   1186: astore 6
    //   1188: new 62	com/tencent/mm/toolkit/a/a/a
    //   1191: dup
    //   1192: sipush 1103
    //   1195: aload 4
    //   1197: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1200: astore 4
    //   1202: aload 7
    //   1204: astore 6
    //   1206: ldc 242
    //   1208: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1211: aload 7
    //   1213: astore 6
    //   1215: aload 4
    //   1217: athrow
    //   1218: aload 7
    //   1220: astore 6
    //   1222: new 62	com/tencent/mm/toolkit/a/a/a
    //   1225: dup
    //   1226: iload_2
    //   1227: aload 7
    //   1229: invokevirtual 371	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1232: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1235: astore 4
    //   1237: aload 7
    //   1239: astore 6
    //   1241: ldc 242
    //   1243: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1246: aload 7
    //   1248: astore 6
    //   1250: aload 4
    //   1252: athrow
    //   1253: aload 7
    //   1255: astore 6
    //   1257: new 62	com/tencent/mm/toolkit/a/a/a
    //   1260: dup
    //   1261: sipush 1106
    //   1264: ldc_w 443
    //   1267: invokespecial 108	com/tencent/mm/toolkit/a/a/a:<init>	(ILjava/lang/String;)V
    //   1270: astore_1
    //   1271: aload 7
    //   1273: astore 6
    //   1275: ldc 242
    //   1277: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1280: aload 7
    //   1282: astore 6
    //   1284: aload_1
    //   1285: athrow
    //   1286: ldc 242
    //   1288: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1291: return
    //   1292: astore_1
    //   1293: goto -607 -> 686
    //   1296: astore_1
    //   1297: aconst_null
    //   1298: astore 7
    //   1300: goto -660 -> 640
    //   1303: astore 4
    //   1305: aconst_null
    //   1306: astore 7
    //   1308: goto -1057 -> 251
    //   1311: astore 4
    //   1313: aconst_null
    //   1314: astore 5
    //   1316: aconst_null
    //   1317: astore 8
    //   1319: goto -408 -> 911
    //   1322: astore 4
    //   1324: aconst_null
    //   1325: astore 6
    //   1327: aload 5
    //   1329: astore 8
    //   1331: aload 6
    //   1333: astore 5
    //   1335: goto -424 -> 911
    //   1338: astore 4
    //   1340: aload 5
    //   1342: astore 8
    //   1344: aload 6
    //   1346: astore 5
    //   1348: goto -437 -> 911
    //   1351: astore 6
    //   1353: aload 4
    //   1355: astore 9
    //   1357: aload 5
    //   1359: astore 8
    //   1361: aload 6
    //   1363: astore 4
    //   1365: aload 9
    //   1367: astore 5
    //   1369: goto -458 -> 911
    //   1372: astore 4
    //   1374: aconst_null
    //   1375: astore 4
    //   1377: aload 5
    //   1379: astore 8
    //   1381: goto -508 -> 873
    //   1384: astore 4
    //   1386: aload 6
    //   1388: astore 4
    //   1390: aload 5
    //   1392: astore 8
    //   1394: goto -521 -> 873
    //   1397: astore 6
    //   1399: aload 5
    //   1401: astore 8
    //   1403: goto -530 -> 873
    //   1406: iload_2
    //   1407: lookupswitch	default:+89->1496, 200:+-674->733, 206:+-674->733, 301:+-369->1038, 302:+-369->1038, 303:+-369->1038, 307:+-369->1038, 404:+-189->1218, 416:+-189->1218, 500:+-189->1218, 503:+-189->1218
    //   1497: <illegal opcode>
    //   1498: dload_3
    //   1499: ldc_w 445
    //   1502: astore 4
    //   1504: goto -320 -> 1184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1507	0	this	b
    //   0	1507	1	paramc	c
    //   460	947	2	i	int
    //   258	520	3	bool	boolean
    //   1	233	4	localHashMap	java.util.HashMap
    //   249	1	4	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   401	444	4	localObject1	Object
    //   865	1	4	localIOException1	IOException
    //   868	383	4	localObject2	Object
    //   1303	1	4	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1311	1	4	localObject3	Object
    //   1322	1	4	localObject4	Object
    //   1338	16	4	localObject5	Object
    //   1363	1	4	localObject6	Object
    //   1372	1	4	localIOException2	IOException
    //   1375	1	4	localObject7	Object
    //   1384	1	4	localIOException3	IOException
    //   1388	115	4	localObject8	Object
    //   15	1385	5	localObject9	Object
    //   108	735	6	localObject10	Object
    //   901	7	6	localObject11	Object
    //   913	432	6	localHttpURLConnection1	HttpURLConnection
    //   1351	36	6	localObject12	Object
    //   1397	1	6	localIOException4	IOException
    //   104	1203	7	localHttpURLConnection2	HttpURLConnection
    //   223	1179	8	localObject13	Object
    //   1355	11	9	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   110	118	249	java/net/SocketTimeoutException
    //   122	128	249	java/net/SocketTimeoutException
    //   132	146	249	java/net/SocketTimeoutException
    //   150	164	249	java/net/SocketTimeoutException
    //   168	174	249	java/net/SocketTimeoutException
    //   183	195	249	java/net/SocketTimeoutException
    //   199	209	249	java/net/SocketTimeoutException
    //   213	225	249	java/net/SocketTimeoutException
    //   229	246	249	java/net/SocketTimeoutException
    //   328	338	249	java/net/SocketTimeoutException
    //   342	345	249	java/net/SocketTimeoutException
    //   349	356	249	java/net/SocketTimeoutException
    //   360	371	249	java/net/SocketTimeoutException
    //   375	403	249	java/net/SocketTimeoutException
    //   407	419	249	java/net/SocketTimeoutException
    //   423	426	249	java/net/SocketTimeoutException
    //   430	440	249	java/net/SocketTimeoutException
    //   444	451	249	java/net/SocketTimeoutException
    //   455	461	249	java/net/SocketTimeoutException
    //   465	471	249	java/net/SocketTimeoutException
    //   475	503	249	java/net/SocketTimeoutException
    //   507	510	249	java/net/SocketTimeoutException
    //   517	523	249	java/net/SocketTimeoutException
    //   527	569	249	java/net/SocketTimeoutException
    //   573	576	249	java/net/SocketTimeoutException
    //   580	623	249	java/net/SocketTimeoutException
    //   627	632	249	java/net/SocketTimeoutException
    //   636	639	249	java/net/SocketTimeoutException
    //   707	712	249	java/net/SocketTimeoutException
    //   716	719	249	java/net/SocketTimeoutException
    //   723	730	249	java/net/SocketTimeoutException
    //   737	746	249	java/net/SocketTimeoutException
    //   750	766	249	java/net/SocketTimeoutException
    //   770	777	249	java/net/SocketTimeoutException
    //   835	840	249	java/net/SocketTimeoutException
    //   844	849	249	java/net/SocketTimeoutException
    //   915	920	249	java/net/SocketTimeoutException
    //   924	929	249	java/net/SocketTimeoutException
    //   933	938	249	java/net/SocketTimeoutException
    //   942	945	249	java/net/SocketTimeoutException
    //   972	987	249	java/net/SocketTimeoutException
    //   991	996	249	java/net/SocketTimeoutException
    //   1000	1003	249	java/net/SocketTimeoutException
    //   1007	1022	249	java/net/SocketTimeoutException
    //   1026	1031	249	java/net/SocketTimeoutException
    //   1035	1038	249	java/net/SocketTimeoutException
    //   1042	1049	249	java/net/SocketTimeoutException
    //   1053	1061	249	java/net/SocketTimeoutException
    //   1065	1071	249	java/net/SocketTimeoutException
    //   1075	1093	249	java/net/SocketTimeoutException
    //   1097	1100	249	java/net/SocketTimeoutException
    //   1104	1119	249	java/net/SocketTimeoutException
    //   1123	1133	249	java/net/SocketTimeoutException
    //   1137	1144	249	java/net/SocketTimeoutException
    //   1151	1158	249	java/net/SocketTimeoutException
    //   1162	1184	249	java/net/SocketTimeoutException
    //   1188	1202	249	java/net/SocketTimeoutException
    //   1206	1211	249	java/net/SocketTimeoutException
    //   1215	1218	249	java/net/SocketTimeoutException
    //   1222	1237	249	java/net/SocketTimeoutException
    //   1241	1246	249	java/net/SocketTimeoutException
    //   1250	1253	249	java/net/SocketTimeoutException
    //   80	96	302	java/net/MalformedURLException
    //   110	118	639	java/io/IOException
    //   122	128	639	java/io/IOException
    //   132	146	639	java/io/IOException
    //   150	164	639	java/io/IOException
    //   168	174	639	java/io/IOException
    //   183	195	639	java/io/IOException
    //   199	209	639	java/io/IOException
    //   213	225	639	java/io/IOException
    //   229	246	639	java/io/IOException
    //   328	338	639	java/io/IOException
    //   342	345	639	java/io/IOException
    //   349	356	639	java/io/IOException
    //   360	371	639	java/io/IOException
    //   375	403	639	java/io/IOException
    //   407	419	639	java/io/IOException
    //   423	426	639	java/io/IOException
    //   430	440	639	java/io/IOException
    //   444	451	639	java/io/IOException
    //   455	461	639	java/io/IOException
    //   465	471	639	java/io/IOException
    //   475	503	639	java/io/IOException
    //   507	510	639	java/io/IOException
    //   517	523	639	java/io/IOException
    //   527	569	639	java/io/IOException
    //   573	576	639	java/io/IOException
    //   580	623	639	java/io/IOException
    //   627	632	639	java/io/IOException
    //   636	639	639	java/io/IOException
    //   707	712	639	java/io/IOException
    //   716	719	639	java/io/IOException
    //   723	730	639	java/io/IOException
    //   737	746	639	java/io/IOException
    //   750	766	639	java/io/IOException
    //   770	777	639	java/io/IOException
    //   835	840	639	java/io/IOException
    //   844	849	639	java/io/IOException
    //   915	920	639	java/io/IOException
    //   924	929	639	java/io/IOException
    //   933	938	639	java/io/IOException
    //   942	945	639	java/io/IOException
    //   972	987	639	java/io/IOException
    //   991	996	639	java/io/IOException
    //   1000	1003	639	java/io/IOException
    //   1007	1022	639	java/io/IOException
    //   1026	1031	639	java/io/IOException
    //   1035	1038	639	java/io/IOException
    //   1042	1049	639	java/io/IOException
    //   1053	1061	639	java/io/IOException
    //   1065	1071	639	java/io/IOException
    //   1075	1093	639	java/io/IOException
    //   1097	1100	639	java/io/IOException
    //   1104	1119	639	java/io/IOException
    //   1123	1133	639	java/io/IOException
    //   1137	1144	639	java/io/IOException
    //   1151	1158	639	java/io/IOException
    //   1162	1184	639	java/io/IOException
    //   1188	1202	639	java/io/IOException
    //   1206	1211	639	java/io/IOException
    //   1215	1218	639	java/io/IOException
    //   1222	1237	639	java/io/IOException
    //   1241	1246	639	java/io/IOException
    //   1250	1253	639	java/io/IOException
    //   110	118	681	finally
    //   122	128	681	finally
    //   132	146	681	finally
    //   150	164	681	finally
    //   168	174	681	finally
    //   183	195	681	finally
    //   199	209	681	finally
    //   213	225	681	finally
    //   229	246	681	finally
    //   255	259	681	finally
    //   263	275	681	finally
    //   279	286	681	finally
    //   328	338	681	finally
    //   342	345	681	finally
    //   349	356	681	finally
    //   360	371	681	finally
    //   375	403	681	finally
    //   407	419	681	finally
    //   423	426	681	finally
    //   430	440	681	finally
    //   444	451	681	finally
    //   455	461	681	finally
    //   465	471	681	finally
    //   475	503	681	finally
    //   507	510	681	finally
    //   517	523	681	finally
    //   527	569	681	finally
    //   573	576	681	finally
    //   580	623	681	finally
    //   627	632	681	finally
    //   636	639	681	finally
    //   644	648	681	finally
    //   652	666	681	finally
    //   670	675	681	finally
    //   679	681	681	finally
    //   707	712	681	finally
    //   716	719	681	finally
    //   723	730	681	finally
    //   737	746	681	finally
    //   750	766	681	finally
    //   770	777	681	finally
    //   835	840	681	finally
    //   844	849	681	finally
    //   915	920	681	finally
    //   924	929	681	finally
    //   933	938	681	finally
    //   942	945	681	finally
    //   972	987	681	finally
    //   991	996	681	finally
    //   1000	1003	681	finally
    //   1007	1022	681	finally
    //   1026	1031	681	finally
    //   1035	1038	681	finally
    //   1042	1049	681	finally
    //   1053	1061	681	finally
    //   1065	1071	681	finally
    //   1075	1093	681	finally
    //   1097	1100	681	finally
    //   1104	1119	681	finally
    //   1123	1133	681	finally
    //   1137	1144	681	finally
    //   1151	1158	681	finally
    //   1162	1184	681	finally
    //   1188	1202	681	finally
    //   1206	1211	681	finally
    //   1215	1218	681	finally
    //   1222	1237	681	finally
    //   1241	1246	681	finally
    //   1250	1253	681	finally
    //   1257	1271	681	finally
    //   1275	1280	681	finally
    //   1284	1286	681	finally
    //   781	788	865	java/io/IOException
    //   878	901	901	finally
    //   945	968	901	finally
    //   96	106	1292	finally
    //   96	106	1296	java/io/IOException
    //   96	106	1303	java/net/SocketTimeoutException
    //   781	788	1311	finally
    //   788	800	1322	finally
    //   800	821	1338	finally
    //   821	831	1351	finally
    //   788	800	1372	java/io/IOException
    //   800	821	1384	java/io/IOException
    //   821	831	1397	java/io/IOException
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(220703);
    Context localContext = this.mContext;
    locala = new a();
    if ((localContext != null) && (androidx.core.content.a.checkSelfPermission(localContext, "android.permission.WAKE_LOCK") == 0))
    {
      locala.kqO = ((PowerManager)localContext.getSystemService("power")).newWakeLock(1, e.TAG);
      if (!locala.kqO.isHeld())
      {
        locala.kqO.setWorkSource(new WorkSource());
        PowerManager.WakeLock localWakeLock = locala.kqO;
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "lock", "(Landroid/content/Context;)Lcom/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
        localWakeLock.acquire();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "lock", "(Landroid/content/Context;)Lcom/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      }
      locala.VOD = ((WifiManager)localContext.getSystemService("wifi")).createWifiLock("WIFI LOCK : " + e.TAG);
      if (!locala.VOD.isHeld()) {
        locala.VOD.acquire();
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
        if (!paramc.VOI) {
          continue;
        }
        if (!e.DEBUG) {
          continue;
        }
        new StringBuilder("clean up target file, path = ").append(paramc.VOH.getPath());
        e.hEQ();
        d.b.M(paramc.VOH);
        d.b.M(paramc.VOG);
        a.a(paramc, i, str);
        paramc.finish();
        return;
      }
      finally
      {
        locala.release();
        AppMethodBeat.o(220703);
      }
      e.hER();
    }
  }
  
  public final void fB(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  static final class a
  {
    WifiManager.WifiLock VOD;
    PowerManager.WakeLock kqO;
    
    public final void release()
    {
      AppMethodBeat.i(220684);
      try
      {
        if ((this.kqO != null) && (this.kqO.isHeld()))
        {
          PowerManager.WakeLock localWakeLock = this.kqO;
          com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "release", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          localWakeLock.release();
          com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/toolkit/downloader/DownloadPerformerImpl$Locker", "release", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        }
        if ((this.VOD != null) && (this.VOD.isHeld())) {
          this.VOD.release();
        }
        AppMethodBeat.o(220684);
        return;
      }
      catch (Throwable localThrowable)
      {
        boolean bool = e.DEBUG;
        AppMethodBeat.o(220684);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.b
 * JD-Core Version:    0.7.0.1
 */