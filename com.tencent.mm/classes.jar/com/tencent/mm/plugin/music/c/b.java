package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements Runnable
{
  public int ddo;
  public boolean isStop;
  public String mimeType;
  public boolean ruo;
  private String wjL;
  public f wjM;
  public a wjN;
  public float wjO;
  private long wjP;
  public int wjQ;
  public b wjR;
  
  public b(f paramf, a parama)
  {
    AppMethodBeat.i(137216);
    this.wjL = null;
    this.wjP = 307200L;
    this.isStop = true;
    this.mimeType = "";
    this.wjQ = -1;
    this.ddo = 0;
    this.wjM = paramf;
    this.wjN = parama;
    int i;
    int j;
    if ((parama.wjG == 0L) && (parama.wjH == 0L) && (parama.endFlag == 0))
    {
      i = 1;
      if ((parama.wjI != 0L) || (parama.wjK != 0L) || (parama.wjJ != 0)) {
        break label154;
      }
      j = 1;
      label110:
      if ((i == 0) || (j == 0)) {
        break label160;
      }
      i = k;
      label122:
      if (i == 0) {
        break label165;
      }
      ad.e("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
    }
    for (;;)
    {
      this.ruo = ay.isWifi(aj.getContext());
      AppMethodBeat.o(137216);
      return;
      i = 0;
      break;
      label154:
      j = 0;
      break label110;
      label160:
      i = 0;
      break label122;
      label165:
      ad.i("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
    }
  }
  
  private HttpURLConnection C(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137219);
    Object localObject1;
    if (!TextUtils.isEmpty(this.wjL))
    {
      ad.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.wjL;
      localObject1 = null;
    }
    for (int i = 0;; i = 0)
    {
      for (;;)
      {
        if (localObject1 != null) {}
        try
        {
          ((HttpURLConnection)localObject1).getInputStream().close();
          ((HttpURLConnection)localObject1).disconnect();
          ad.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[] { paramString });
          Object localObject2 = k.dta().wkp;
          localObject1 = new URL(paramString);
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.plugin.music.e.a)localObject2).asB(paramString);
          }
          localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
          ((HttpURLConnection)localObject1).setRequestMethod("GET");
          ((HttpURLConnection)localObject1).setConnectTimeout(25000);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          paramString = paramMap.entrySet().iterator();
          while (paramString.hasNext())
          {
            localObject2 = (Map.Entry)paramString.next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.Music.MusicDownloadTask", localException.getMessage());
          }
          int j = ((HttpURLConnection)localObject1).getResponseCode();
          ad.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307))
          {
            Lg(j);
            paramString = ((HttpURLConnection)localObject1).getRequestMethod();
            if ((j == 307) && (!paramString.equals("GET")) && (!paramString.equals("HEAD")))
            {
              AppMethodBeat.o(137219);
              return localObject1;
            }
            paramString = ((HttpURLConnection)localObject1).getHeaderField("Location");
            if (paramString == null)
            {
              ad.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[] { Integer.valueOf(j) });
              AppMethodBeat.o(137219);
              return localObject1;
            }
            URL localURL = new URL(((HttpURLConnection)localObject1).getURL(), paramString);
            ad.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[] { paramString });
            ad.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[] { localURL.toString() });
            if ((!localURL.getProtocol().equals("https")) && (!localURL.getProtocol().equals("http")))
            {
              ad.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[] { Integer.valueOf(j) });
              AppMethodBeat.o(137219);
              return localObject1;
            }
            i += 1;
            if (i > 5)
            {
              ad.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: ".concat(String.valueOf(i)));
              AppMethodBeat.o(137219);
              return localObject1;
            }
            paramString = localURL.toString();
            this.wjL = paramString;
          }
          else
          {
            if ((j != 200) && (j != 206)) {
              this.wjL = null;
            }
            AppMethodBeat.o(137219);
            return localObject1;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  private static void Lg(int paramInt)
  {
    AppMethodBeat.i(137220);
    d locald = (d)com.tencent.mm.plugin.music.f.c.b.aQ(d.class);
    if (locald != null) {
      locald.Ll(paramInt);
    }
    AppMethodBeat.o(137220);
  }
  
  private void Lh(int paramInt)
  {
    AppMethodBeat.i(137221);
    this.wjL = null;
    aq.f(new a(paramInt));
    AppMethodBeat.o(137221);
  }
  
  private void Z(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(137223);
    if (this.ruo)
    {
      this.wjN.wjI = paramLong1;
      this.wjN.wjJ = 0;
      this.wjN.wjK = paramLong2;
      e.a(this.wjM.ihg, this.wjN);
    }
    for (;;)
    {
      aq.f(new a(3));
      AppMethodBeat.o(137223);
      return;
      this.wjN.wjG = paramLong1;
      this.wjN.endFlag = 0;
      this.wjN.wjH = paramLong2;
      e.a(this.wjM.ihg, this.wjN);
    }
  }
  
  private static long[] asz(String paramString)
  {
    AppMethodBeat.i(137224);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137224);
      return null;
    }
    try
    {
      paramString = paramString.replace("bytes", "").trim().split("-");
      long l1 = Long.valueOf(paramString[0]).longValue();
      paramString = paramString[1].split("/");
      long l2 = Long.valueOf(paramString[0]).longValue();
      long l3 = Long.valueOf(paramString[1]).longValue();
      AppMethodBeat.o(137224);
      return new long[] { l1, l2, l3 };
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(137224);
    }
    return null;
  }
  
  private void yk(long paramLong)
  {
    AppMethodBeat.i(137222);
    if (this.ruo)
    {
      this.wjN.wjI = paramLong;
      this.wjN.wjJ = 1;
      this.wjN.wjK = paramLong;
      e.a(this.wjM.ihg, this.wjN);
    }
    for (;;)
    {
      aq.f(new a(2));
      AppMethodBeat.o(137222);
      return;
      this.wjN.wjG = paramLong;
      this.wjN.endFlag = 1;
      this.wjN.wjH = paramLong;
      e.a(this.wjM.ihg, this.wjN);
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 373
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   10: ifeq +10 -> 20
    //   13: ldc_w 373
    //   16: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aconst_null
    //   21: astore 33
    //   23: aconst_null
    //   24: astore 34
    //   26: invokestatic 99	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   29: invokestatic 376	com/tencent/mm/sdk/platformtools/ay:isNetworkConnected	(Landroid/content/Context;)Z
    //   32: istore 32
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 59	com/tencent/mm/plugin/music/c/b:ddo	I
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 57	com/tencent/mm/plugin/music/c/b:wjQ	I
    //   44: invokestatic 153	com/tencent/mm/plugin/music/e/k:dta	()Lcom/tencent/mm/plugin/music/e/k;
    //   47: getfield 157	com/tencent/mm/plugin/music/e/k:wkp	Lcom/tencent/mm/plugin/music/e/a;
    //   50: astore 35
    //   52: iload 32
    //   54: ifeq +510 -> 564
    //   57: aload_0
    //   58: getfield 107	com/tencent/mm/plugin/music/c/b:ruo	Z
    //   61: ifeq +362 -> 423
    //   64: aload_0
    //   65: getfield 61	com/tencent/mm/plugin/music/c/b:wjM	Lcom/tencent/mm/az/f;
    //   68: getfield 379	com/tencent/mm/az/f:playUrl	Ljava/lang/String;
    //   71: invokestatic 384	com/tencent/mm/plugin/music/cache/g:asp	(Ljava/lang/String;)Z
    //   74: istore 32
    //   76: aload 34
    //   78: astore 33
    //   80: aload 35
    //   82: ifnull +19 -> 101
    //   85: aload 35
    //   87: aload_0
    //   88: getfield 61	com/tencent/mm/plugin/music/c/b:wjM	Lcom/tencent/mm/az/f;
    //   91: getfield 379	com/tencent/mm/az/f:playUrl	Ljava/lang/String;
    //   94: invokeinterface 387 2 0
    //   99: astore 33
    //   101: ldc 85
    //   103: ldc_w 389
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 33
    //   114: aastore
    //   115: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   122: getfield 77	com/tencent/mm/plugin/music/c/a:wjI	J
    //   125: lstore 6
    //   127: aload_0
    //   128: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   131: getfield 80	com/tencent/mm/plugin/music/c/a:wjK	J
    //   134: lstore 4
    //   136: lload 4
    //   138: lconst_0
    //   139: lcmp
    //   140: ifeq +13 -> 153
    //   143: aload_0
    //   144: lload 4
    //   146: ldc2_w 390
    //   149: ldiv
    //   150: putfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   153: lload 6
    //   155: aload_0
    //   156: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   159: lcmp
    //   160: ifge +233 -> 393
    //   163: aload_0
    //   164: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   167: lstore_2
    //   168: aload_0
    //   169: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   172: getfield 83	com/tencent/mm/plugin/music/c/a:wjJ	I
    //   175: iconst_1
    //   176: if_icmpne +238 -> 414
    //   179: iconst_1
    //   180: istore_1
    //   181: aload 33
    //   183: astore 40
    //   185: aload_0
    //   186: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   189: ldc2_w 392
    //   192: lcmp
    //   193: ifge +18 -> 211
    //   196: aload_0
    //   197: ldc2_w 392
    //   200: putfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   203: ldc 85
    //   205: ldc_w 395
    //   208: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: new 397	com/tencent/mm/vfs/e
    //   214: dup
    //   215: aload_0
    //   216: getfield 61	com/tencent/mm/plugin/music/c/b:wjM	Lcom/tencent/mm/az/f;
    //   219: getfield 320	com/tencent/mm/az/f:ihg	Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 107	com/tencent/mm/plugin/music/c/b:ruo	Z
    //   226: invokestatic 403	com/tencent/mm/plugin/music/h/b:bz	(Ljava/lang/String;Z)Ljava/lang/String;
    //   229: invokespecial 404	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   232: astore 52
    //   234: lload_2
    //   235: lstore 8
    //   237: lload 6
    //   239: lstore_2
    //   240: aload 52
    //   242: invokevirtual 407	com/tencent/mm/vfs/e:exists	()Z
    //   245: ifne +56 -> 301
    //   248: ldc 85
    //   250: ldc_w 409
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 52
    //   261: invokevirtual 412	com/tencent/mm/vfs/e:createNewFile	()Z
    //   264: invokestatic 417	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   267: aastore
    //   268: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: lconst_0
    //   272: lstore_2
    //   273: aload_0
    //   274: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   277: lstore 8
    //   279: iconst_0
    //   280: istore_1
    //   281: ldc 85
    //   283: ldc_w 419
    //   286: iconst_1
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: lload 8
    //   294: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   297: aastore
    //   298: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 85
    //   303: ldc_w 424
    //   306: iconst_3
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: lload_2
    //   313: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload 52
    //   321: invokevirtual 427	com/tencent/mm/vfs/e:length	()J
    //   324: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: aastore
    //   328: dup
    //   329: iconst_2
    //   330: lload 8
    //   332: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: aastore
    //   336: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: lload_2
    //   340: aload_0
    //   341: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   344: lcmp
    //   345: iflt +12 -> 357
    //   348: aload_0
    //   349: getfield 429	com/tencent/mm/plugin/music/c/b:wjO	F
    //   352: fconst_0
    //   353: fcmpl
    //   354: ifeq +7 -> 361
    //   357: iload_1
    //   358: ifeq +483 -> 841
    //   361: ldc 85
    //   363: ldc_w 431
    //   366: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_0
    //   370: iconst_1
    //   371: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   374: new 8	com/tencent/mm/plugin/music/c/b$a
    //   377: dup
    //   378: aload_0
    //   379: iconst_1
    //   380: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   383: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   386: ldc_w 373
    //   389: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: return
    //   393: lload 6
    //   395: l2f
    //   396: ldc_w 432
    //   399: aload_0
    //   400: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   403: getfield 80	com/tencent/mm/plugin/music/c/a:wjK	J
    //   406: l2f
    //   407: fmul
    //   408: fadd
    //   409: f2l
    //   410: lstore_2
    //   411: goto -243 -> 168
    //   414: iconst_0
    //   415: istore_1
    //   416: aload 33
    //   418: astore 40
    //   420: goto -235 -> 185
    //   423: aload 35
    //   425: ifnull +19 -> 444
    //   428: aload 35
    //   430: aload_0
    //   431: getfield 61	com/tencent/mm/plugin/music/c/b:wjM	Lcom/tencent/mm/az/f;
    //   434: getfield 379	com/tencent/mm/az/f:playUrl	Ljava/lang/String;
    //   437: invokeinterface 387 2 0
    //   442: astore 33
    //   444: ldc 85
    //   446: ldc_w 389
    //   449: iconst_1
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload 33
    //   457: aastore
    //   458: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   461: iconst_0
    //   462: istore 32
    //   464: aload_0
    //   465: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   468: getfield 68	com/tencent/mm/plugin/music/c/a:wjG	J
    //   471: lstore 6
    //   473: aload_0
    //   474: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   477: getfield 71	com/tencent/mm/plugin/music/c/a:wjH	J
    //   480: lstore 4
    //   482: lload 4
    //   484: lconst_0
    //   485: lcmp
    //   486: ifeq +13 -> 499
    //   489: aload_0
    //   490: lload 4
    //   492: ldc2_w 390
    //   495: ldiv
    //   496: putfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   499: lload 6
    //   501: aload_0
    //   502: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   505: lcmp
    //   506: ifge +28 -> 534
    //   509: aload_0
    //   510: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   513: lstore_2
    //   514: aload_0
    //   515: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   518: getfield 74	com/tencent/mm/plugin/music/c/a:endFlag	I
    //   521: iconst_1
    //   522: if_icmpne +33 -> 555
    //   525: iconst_1
    //   526: istore_1
    //   527: aload 33
    //   529: astore 40
    //   531: goto -346 -> 185
    //   534: lload 6
    //   536: l2f
    //   537: ldc_w 432
    //   540: aload_0
    //   541: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   544: getfield 71	com/tencent/mm/plugin/music/c/a:wjH	J
    //   547: l2f
    //   548: fmul
    //   549: fadd
    //   550: f2l
    //   551: lstore_2
    //   552: goto -38 -> 514
    //   555: iconst_0
    //   556: istore_1
    //   557: aload 33
    //   559: astore 40
    //   561: goto -376 -> 185
    //   564: aload_0
    //   565: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   568: getfield 77	com/tencent/mm/plugin/music/c/a:wjI	J
    //   571: lconst_0
    //   572: lcmp
    //   573: ifeq +102 -> 675
    //   576: aload_0
    //   577: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   580: getfield 77	com/tencent/mm/plugin/music/c/a:wjI	J
    //   583: aload_0
    //   584: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   587: lcmp
    //   588: ifge +21 -> 609
    //   591: aload_0
    //   592: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   595: getfield 77	com/tencent/mm/plugin/music/c/a:wjI	J
    //   598: aload_0
    //   599: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   602: getfield 80	com/tencent/mm/plugin/music/c/a:wjK	J
    //   605: lcmp
    //   606: ifne +69 -> 675
    //   609: aload_0
    //   610: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   613: getfield 77	com/tencent/mm/plugin/music/c/a:wjI	J
    //   616: l2f
    //   617: aload_0
    //   618: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   621: getfield 80	com/tencent/mm/plugin/music/c/a:wjK	J
    //   624: l2f
    //   625: fdiv
    //   626: aload_0
    //   627: getfield 429	com/tencent/mm/plugin/music/c/b:wjO	F
    //   630: fsub
    //   631: ldc_w 432
    //   634: fcmpl
    //   635: iflt +40 -> 675
    //   638: ldc 85
    //   640: ldc_w 431
    //   643: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 107	com/tencent/mm/plugin/music/c/b:ruo	Z
    //   656: new 8	com/tencent/mm/plugin/music/c/b$a
    //   659: dup
    //   660: aload_0
    //   661: iconst_1
    //   662: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   665: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   668: ldc_w 373
    //   671: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: return
    //   675: aload_0
    //   676: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   679: getfield 68	com/tencent/mm/plugin/music/c/a:wjG	J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifeq +102 -> 786
    //   687: aload_0
    //   688: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   691: getfield 68	com/tencent/mm/plugin/music/c/a:wjG	J
    //   694: aload_0
    //   695: getfield 49	com/tencent/mm/plugin/music/c/b:wjP	J
    //   698: lcmp
    //   699: ifge +21 -> 720
    //   702: aload_0
    //   703: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   706: getfield 68	com/tencent/mm/plugin/music/c/a:wjG	J
    //   709: aload_0
    //   710: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   713: getfield 71	com/tencent/mm/plugin/music/c/a:wjH	J
    //   716: lcmp
    //   717: ifne +69 -> 786
    //   720: aload_0
    //   721: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   724: getfield 68	com/tencent/mm/plugin/music/c/a:wjG	J
    //   727: l2f
    //   728: aload_0
    //   729: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   732: getfield 71	com/tencent/mm/plugin/music/c/a:wjH	J
    //   735: l2f
    //   736: fdiv
    //   737: aload_0
    //   738: getfield 429	com/tencent/mm/plugin/music/c/b:wjO	F
    //   741: fsub
    //   742: ldc_w 432
    //   745: fcmpl
    //   746: iflt +40 -> 786
    //   749: ldc 85
    //   751: ldc_w 431
    //   754: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_0
    //   758: iconst_1
    //   759: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   762: aload_0
    //   763: iconst_0
    //   764: putfield 107	com/tencent/mm/plugin/music/c/b:ruo	Z
    //   767: new 8	com/tencent/mm/plugin/music/c/b$a
    //   770: dup
    //   771: aload_0
    //   772: iconst_1
    //   773: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   776: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   779: ldc_w 373
    //   782: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: return
    //   786: ldc 85
    //   788: ldc_w 434
    //   791: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_0
    //   795: iconst_1
    //   796: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   799: aload_0
    //   800: iconst_4
    //   801: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   804: ldc_w 373
    //   807: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   810: return
    //   811: astore 33
    //   813: ldc 85
    //   815: aload 33
    //   817: ldc_w 438
    //   820: iconst_1
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 52
    //   828: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   831: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   834: aastore
    //   835: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   838: goto -567 -> 271
    //   841: aload 40
    //   843: invokestatic 334	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   846: ifeq +36 -> 882
    //   849: ldc 85
    //   851: ldc_w 454
    //   854: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: aload_0
    //   858: iconst_1
    //   859: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   862: new 8	com/tencent/mm/plugin/music/c/b$a
    //   865: dup
    //   866: aload_0
    //   867: bipush 254
    //   869: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   872: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   875: ldc_w 373
    //   878: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: aconst_null
    //   883: astore 42
    //   885: aconst_null
    //   886: astore 41
    //   888: aconst_null
    //   889: astore 44
    //   891: aconst_null
    //   892: astore 46
    //   894: aconst_null
    //   895: astore 45
    //   897: aconst_null
    //   898: astore 43
    //   900: aconst_null
    //   901: astore 33
    //   903: aconst_null
    //   904: astore 51
    //   906: aconst_null
    //   907: astore 47
    //   909: aconst_null
    //   910: astore 48
    //   912: aconst_null
    //   913: astore 50
    //   915: aconst_null
    //   916: astore 49
    //   918: aload 49
    //   920: astore 38
    //   922: aload 33
    //   924: astore 35
    //   926: aload 51
    //   928: astore 37
    //   930: aload 47
    //   932: astore 34
    //   934: aload 48
    //   936: astore 39
    //   938: aload 50
    //   940: astore 36
    //   942: aload 52
    //   944: invokevirtual 407	com/tencent/mm/vfs/e:exists	()Z
    //   947: ifne +334 -> 1281
    //   950: aload 49
    //   952: astore 38
    //   954: aload 33
    //   956: astore 35
    //   958: aload 51
    //   960: astore 37
    //   962: aload 47
    //   964: astore 34
    //   966: aload 48
    //   968: astore 39
    //   970: aload 50
    //   972: astore 36
    //   974: aload_0
    //   975: iconst_1
    //   976: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   979: aload 49
    //   981: astore 38
    //   983: aload 33
    //   985: astore 35
    //   987: aload 51
    //   989: astore 37
    //   991: aload 47
    //   993: astore 34
    //   995: aload 48
    //   997: astore 39
    //   999: aload 50
    //   1001: astore 36
    //   1003: ldc 85
    //   1005: ldc_w 456
    //   1008: iconst_1
    //   1009: anewarray 4	java/lang/Object
    //   1012: dup
    //   1013: iconst_0
    //   1014: aload 52
    //   1016: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   1019: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   1022: aastore
    //   1023: invokestatic 257	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1026: aload 49
    //   1028: astore 38
    //   1030: aload 33
    //   1032: astore 35
    //   1034: aload 51
    //   1036: astore 37
    //   1038: aload 47
    //   1040: astore 34
    //   1042: aload 48
    //   1044: astore 39
    //   1046: aload 50
    //   1048: astore 36
    //   1050: aload_0
    //   1051: bipush 19
    //   1053: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   1056: lload 4
    //   1058: lconst_0
    //   1059: lcmp
    //   1060: ifne +89 -> 1149
    //   1063: lload_2
    //   1064: lconst_0
    //   1065: lcmp
    //   1066: ifle +83 -> 1149
    //   1069: ldc 85
    //   1071: ldc_w 458
    //   1074: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1077: new 460	java/lang/NullPointerException
    //   1080: dup
    //   1081: invokespecial 461	java/lang/NullPointerException:<init>	()V
    //   1084: athrow
    //   1085: aload_0
    //   1086: lload_2
    //   1087: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   1090: lload_2
    //   1091: ldc2_w 392
    //   1094: lcmp
    //   1095: ifge +15 -> 1110
    //   1098: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1101: dup
    //   1102: aload_0
    //   1103: iconst_1
    //   1104: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1107: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   1110: aload_0
    //   1111: iconst_1
    //   1112: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   1115: ldc 85
    //   1117: ldc_w 465
    //   1120: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: ldc_w 373
    //   1126: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1129: return
    //   1130: astore 33
    //   1132: ldc 85
    //   1134: aload 33
    //   1136: ldc_w 467
    //   1139: iconst_0
    //   1140: anewarray 4	java/lang/Object
    //   1143: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1146: goto -61 -> 1085
    //   1149: lload 4
    //   1151: lconst_0
    //   1152: lcmp
    //   1153: ifeq +47 -> 1200
    //   1156: lload_2
    //   1157: lload 4
    //   1159: lcmp
    //   1160: ifeq +40 -> 1200
    //   1163: ldc 85
    //   1165: ldc_w 469
    //   1168: iconst_2
    //   1169: anewarray 4	java/lang/Object
    //   1172: dup
    //   1173: iconst_0
    //   1174: lload 4
    //   1176: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_1
    //   1182: lload_2
    //   1183: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1186: aastore
    //   1187: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1190: aload_0
    //   1191: lload_2
    //   1192: lload 4
    //   1194: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   1197: goto -87 -> 1110
    //   1200: lload 4
    //   1202: lconst_0
    //   1203: lcmp
    //   1204: ifeq +66 -> 1270
    //   1207: lload_2
    //   1208: lload 4
    //   1210: lcmp
    //   1211: ifne +59 -> 1270
    //   1214: ldc 85
    //   1216: ldc_w 473
    //   1219: iconst_2
    //   1220: anewarray 4	java/lang/Object
    //   1223: dup
    //   1224: iconst_0
    //   1225: lload 4
    //   1227: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_1
    //   1233: lload_2
    //   1234: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1237: aastore
    //   1238: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1241: aload_0
    //   1242: lload 4
    //   1244: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   1247: lload_2
    //   1248: ldc2_w 392
    //   1251: lcmp
    //   1252: ifge -142 -> 1110
    //   1255: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1258: dup
    //   1259: aload_0
    //   1260: iconst_1
    //   1261: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1264: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   1267: goto -157 -> 1110
    //   1270: ldc 85
    //   1272: ldc_w 475
    //   1275: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1278: goto -168 -> 1110
    //   1281: aload 49
    //   1283: astore 38
    //   1285: aload 33
    //   1287: astore 35
    //   1289: aload 51
    //   1291: astore 37
    //   1293: aload 47
    //   1295: astore 34
    //   1297: aload 48
    //   1299: astore 39
    //   1301: aload 50
    //   1303: astore 36
    //   1305: aload 52
    //   1307: getfield 479	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   1310: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   1313: iconst_1
    //   1314: invokestatic 485	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   1317: astore 33
    //   1319: aload 33
    //   1321: astore 38
    //   1323: aload 33
    //   1325: astore 35
    //   1327: aload 33
    //   1329: astore 37
    //   1331: aload 33
    //   1333: astore 34
    //   1335: aload 33
    //   1337: astore 39
    //   1339: aload 33
    //   1341: astore 36
    //   1343: ldc 85
    //   1345: ldc_w 487
    //   1348: iconst_1
    //   1349: anewarray 4	java/lang/Object
    //   1352: dup
    //   1353: iconst_0
    //   1354: aload 40
    //   1356: aastore
    //   1357: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1360: aload 33
    //   1362: astore 38
    //   1364: aload 33
    //   1366: astore 35
    //   1368: aload 33
    //   1370: astore 37
    //   1372: aload 33
    //   1374: astore 34
    //   1376: aload 33
    //   1378: astore 39
    //   1380: aload 33
    //   1382: astore 36
    //   1384: new 489	java/util/HashMap
    //   1387: dup
    //   1388: bipush 10
    //   1390: invokespecial 491	java/util/HashMap:<init>	(I)V
    //   1393: astore 47
    //   1395: aload 33
    //   1397: astore 38
    //   1399: aload 33
    //   1401: astore 35
    //   1403: aload 33
    //   1405: astore 37
    //   1407: aload 33
    //   1409: astore 34
    //   1411: aload 33
    //   1413: astore 39
    //   1415: aload 33
    //   1417: astore 36
    //   1419: aload 47
    //   1421: ldc_w 493
    //   1424: ldc_w 495
    //   1427: invokeinterface 499 3 0
    //   1432: pop
    //   1433: lload 8
    //   1435: lload_2
    //   1436: lcmp
    //   1437: ifle +117 -> 1554
    //   1440: aload 33
    //   1442: astore 38
    //   1444: aload 33
    //   1446: astore 35
    //   1448: aload 33
    //   1450: astore 37
    //   1452: aload 33
    //   1454: astore 34
    //   1456: aload 33
    //   1458: astore 39
    //   1460: aload 33
    //   1462: astore 36
    //   1464: ldc 85
    //   1466: ldc_w 501
    //   1469: iconst_2
    //   1470: anewarray 4	java/lang/Object
    //   1473: dup
    //   1474: iconst_0
    //   1475: lload_2
    //   1476: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1479: aastore
    //   1480: dup
    //   1481: iconst_1
    //   1482: lload 8
    //   1484: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1487: aastore
    //   1488: invokestatic 504	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1491: aload 33
    //   1493: astore 38
    //   1495: aload 33
    //   1497: astore 35
    //   1499: aload 33
    //   1501: astore 37
    //   1503: aload 33
    //   1505: astore 34
    //   1507: aload 33
    //   1509: astore 39
    //   1511: aload 33
    //   1513: astore 36
    //   1515: aload 47
    //   1517: ldc_w 506
    //   1520: new 508	java/lang/StringBuilder
    //   1523: dup
    //   1524: ldc_w 510
    //   1527: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1530: lload_2
    //   1531: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1534: ldc_w 345
    //   1537: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: lload 8
    //   1542: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1545: invokevirtual 519	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1548: invokeinterface 499 3 0
    //   1553: pop
    //   1554: iload 32
    //   1556: ifne +35 -> 1591
    //   1559: aload 33
    //   1561: astore 38
    //   1563: aload 33
    //   1565: astore 35
    //   1567: aload 33
    //   1569: astore 37
    //   1571: aload 33
    //   1573: astore 34
    //   1575: aload 33
    //   1577: astore 39
    //   1579: aload 33
    //   1581: astore 36
    //   1583: aload 40
    //   1585: invokestatic 524	com/tencent/mm/plugin/music/h/e:asR	(Ljava/lang/String;)Z
    //   1588: ifeq +35 -> 1623
    //   1591: aload 33
    //   1593: astore 38
    //   1595: aload 33
    //   1597: astore 35
    //   1599: aload 33
    //   1601: astore 37
    //   1603: aload 33
    //   1605: astore 34
    //   1607: aload 33
    //   1609: astore 39
    //   1611: aload 33
    //   1613: astore 36
    //   1615: ldc 85
    //   1617: ldc_w 526
    //   1620: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1623: aload 33
    //   1625: astore 38
    //   1627: aload 33
    //   1629: astore 35
    //   1631: aload 33
    //   1633: astore 37
    //   1635: aload 33
    //   1637: astore 34
    //   1639: aload 33
    //   1641: astore 39
    //   1643: aload 33
    //   1645: astore 36
    //   1647: aload 47
    //   1649: ldc_w 528
    //   1652: new 508	java/lang/StringBuilder
    //   1655: dup
    //   1656: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   1659: ldc_w 531
    //   1662: invokestatic 536	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1665: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: ldc_w 538
    //   1671: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: invokestatic 99	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1677: invokestatic 542	com/tencent/mm/plugin/music/h/e:fT	(Landroid/content/Context;)Ljava/lang/String;
    //   1680: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: invokevirtual 519	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokeinterface 499 3 0
    //   1691: pop
    //   1692: aload 33
    //   1694: astore 38
    //   1696: aload 33
    //   1698: astore 35
    //   1700: aload 33
    //   1702: astore 37
    //   1704: aload 33
    //   1706: astore 34
    //   1708: aload 33
    //   1710: astore 39
    //   1712: aload 33
    //   1714: astore 36
    //   1716: aload_0
    //   1717: aload 40
    //   1719: aload 47
    //   1721: invokespecial 544	com/tencent/mm/plugin/music/c/b:C	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   1724: astore 40
    //   1726: aload 40
    //   1728: astore 34
    //   1730: aload 33
    //   1732: astore 37
    //   1734: aload 34
    //   1736: astore 36
    //   1738: lload 4
    //   1740: lstore 8
    //   1742: lload_2
    //   1743: lstore 6
    //   1745: aload 45
    //   1747: astore 35
    //   1749: lload 4
    //   1751: lstore 28
    //   1753: lload_2
    //   1754: lstore 10
    //   1756: lload 4
    //   1758: lstore 20
    //   1760: lload_2
    //   1761: lstore 16
    //   1763: lload 4
    //   1765: lstore 26
    //   1767: lload_2
    //   1768: lstore 18
    //   1770: lload 4
    //   1772: lstore 22
    //   1774: lload_2
    //   1775: lstore 12
    //   1777: lload 4
    //   1779: lstore 24
    //   1781: lload_2
    //   1782: lstore 14
    //   1784: aload 34
    //   1786: invokevirtual 227	java/net/HttpURLConnection:getResponseCode	()I
    //   1789: istore_1
    //   1790: iload_1
    //   1791: sipush 200
    //   1794: if_icmpeq +544 -> 2338
    //   1797: iload_1
    //   1798: sipush 206
    //   1801: if_icmpeq +537 -> 2338
    //   1804: aload 33
    //   1806: astore 37
    //   1808: aload 34
    //   1810: astore 36
    //   1812: lload 4
    //   1814: lstore 8
    //   1816: lload_2
    //   1817: lstore 6
    //   1819: aload 45
    //   1821: astore 35
    //   1823: lload 4
    //   1825: lstore 28
    //   1827: lload_2
    //   1828: lstore 10
    //   1830: lload 4
    //   1832: lstore 20
    //   1834: lload_2
    //   1835: lstore 16
    //   1837: lload 4
    //   1839: lstore 26
    //   1841: lload_2
    //   1842: lstore 18
    //   1844: lload 4
    //   1846: lstore 22
    //   1848: lload_2
    //   1849: lstore 12
    //   1851: lload 4
    //   1853: lstore 24
    //   1855: lload_2
    //   1856: lstore 14
    //   1858: iload_1
    //   1859: invokestatic 238	com/tencent/mm/plugin/music/c/b:Lg	(I)V
    //   1862: aload 33
    //   1864: astore 37
    //   1866: aload 34
    //   1868: astore 36
    //   1870: lload 4
    //   1872: lstore 8
    //   1874: lload_2
    //   1875: lstore 6
    //   1877: aload 45
    //   1879: astore 35
    //   1881: lload 4
    //   1883: lstore 28
    //   1885: lload_2
    //   1886: lstore 10
    //   1888: lload 4
    //   1890: lstore 20
    //   1892: lload_2
    //   1893: lstore 16
    //   1895: lload 4
    //   1897: lstore 26
    //   1899: lload_2
    //   1900: lstore 18
    //   1902: lload 4
    //   1904: lstore 22
    //   1906: lload_2
    //   1907: lstore 12
    //   1909: lload 4
    //   1911: lstore 24
    //   1913: lload_2
    //   1914: lstore 14
    //   1916: ldc 85
    //   1918: ldc_w 546
    //   1921: iconst_1
    //   1922: anewarray 4	java/lang/Object
    //   1925: dup
    //   1926: iconst_0
    //   1927: iload_1
    //   1928: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1931: aastore
    //   1932: invokestatic 257	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1935: aload 33
    //   1937: astore 37
    //   1939: aload 34
    //   1941: astore 36
    //   1943: lload 4
    //   1945: lstore 8
    //   1947: lload_2
    //   1948: lstore 6
    //   1950: aload 45
    //   1952: astore 35
    //   1954: lload 4
    //   1956: lstore 28
    //   1958: lload_2
    //   1959: lstore 10
    //   1961: lload 4
    //   1963: lstore 20
    //   1965: lload_2
    //   1966: lstore 16
    //   1968: lload 4
    //   1970: lstore 26
    //   1972: lload_2
    //   1973: lstore 18
    //   1975: lload 4
    //   1977: lstore 22
    //   1979: lload_2
    //   1980: lstore 12
    //   1982: lload 4
    //   1984: lstore 24
    //   1986: lload_2
    //   1987: lstore 14
    //   1989: aload_0
    //   1990: iload_1
    //   1991: putfield 57	com/tencent/mm/plugin/music/c/b:wjQ	I
    //   1994: aload 33
    //   1996: astore 37
    //   1998: aload 34
    //   2000: astore 36
    //   2002: lload 4
    //   2004: lstore 8
    //   2006: lload_2
    //   2007: lstore 6
    //   2009: aload 45
    //   2011: astore 35
    //   2013: lload 4
    //   2015: lstore 28
    //   2017: lload_2
    //   2018: lstore 10
    //   2020: lload 4
    //   2022: lstore 20
    //   2024: lload_2
    //   2025: lstore 16
    //   2027: lload 4
    //   2029: lstore 26
    //   2031: lload_2
    //   2032: lstore 18
    //   2034: lload 4
    //   2036: lstore 22
    //   2038: lload_2
    //   2039: lstore 12
    //   2041: lload 4
    //   2043: lstore 24
    //   2045: lload_2
    //   2046: lstore 14
    //   2048: aload_0
    //   2049: iconst_m1
    //   2050: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   2053: lload 4
    //   2055: lconst_0
    //   2056: lcmp
    //   2057: ifne +115 -> 2172
    //   2060: lload_2
    //   2061: lconst_0
    //   2062: lcmp
    //   2063: ifle +109 -> 2172
    //   2066: ldc 85
    //   2068: ldc_w 458
    //   2071: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2074: aload 33
    //   2076: lload_2
    //   2077: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   2080: aload_0
    //   2081: lload_2
    //   2082: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   2085: lload_2
    //   2086: ldc2_w 392
    //   2089: lcmp
    //   2090: ifge +15 -> 2105
    //   2093: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2096: dup
    //   2097: aload_0
    //   2098: iconst_1
    //   2099: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2102: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   2105: aload 33
    //   2107: ifnull +8 -> 2115
    //   2110: aload 33
    //   2112: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   2115: aload 34
    //   2117: ifnull +16 -> 2133
    //   2120: aload 34
    //   2122: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2125: invokevirtual 139	java/io/InputStream:close	()V
    //   2128: aload 34
    //   2130: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   2133: aload_0
    //   2134: iconst_1
    //   2135: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   2138: ldc 85
    //   2140: ldc_w 465
    //   2143: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2146: ldc_w 373
    //   2149: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2152: return
    //   2153: astore 35
    //   2155: ldc 85
    //   2157: aload 35
    //   2159: ldc_w 467
    //   2162: iconst_0
    //   2163: anewarray 4	java/lang/Object
    //   2166: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2169: goto -89 -> 2080
    //   2172: lload 4
    //   2174: lconst_0
    //   2175: lcmp
    //   2176: ifeq +47 -> 2223
    //   2179: lload_2
    //   2180: lload 4
    //   2182: lcmp
    //   2183: ifeq +40 -> 2223
    //   2186: ldc 85
    //   2188: ldc_w 469
    //   2191: iconst_2
    //   2192: anewarray 4	java/lang/Object
    //   2195: dup
    //   2196: iconst_0
    //   2197: lload 4
    //   2199: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2202: aastore
    //   2203: dup
    //   2204: iconst_1
    //   2205: lload_2
    //   2206: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2209: aastore
    //   2210: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2213: aload_0
    //   2214: lload_2
    //   2215: lload 4
    //   2217: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   2220: goto -115 -> 2105
    //   2223: lload 4
    //   2225: lconst_0
    //   2226: lcmp
    //   2227: ifeq +66 -> 2293
    //   2230: lload_2
    //   2231: lload 4
    //   2233: lcmp
    //   2234: ifne +59 -> 2293
    //   2237: ldc 85
    //   2239: ldc_w 473
    //   2242: iconst_2
    //   2243: anewarray 4	java/lang/Object
    //   2246: dup
    //   2247: iconst_0
    //   2248: lload 4
    //   2250: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2253: aastore
    //   2254: dup
    //   2255: iconst_1
    //   2256: lload_2
    //   2257: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2260: aastore
    //   2261: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2264: aload_0
    //   2265: lload 4
    //   2267: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   2270: lload_2
    //   2271: ldc2_w 392
    //   2274: lcmp
    //   2275: ifge -170 -> 2105
    //   2278: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2281: dup
    //   2282: aload_0
    //   2283: iconst_1
    //   2284: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2287: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   2290: goto -185 -> 2105
    //   2293: ldc 85
    //   2295: ldc_w 475
    //   2298: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2301: goto -196 -> 2105
    //   2304: astore 33
    //   2306: ldc 85
    //   2308: aload 33
    //   2310: ldc_w 467
    //   2313: iconst_0
    //   2314: anewarray 4	java/lang/Object
    //   2317: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2320: goto -205 -> 2115
    //   2323: astore 33
    //   2325: ldc 85
    //   2327: aload 33
    //   2329: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2332: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2335: goto -207 -> 2128
    //   2338: aload 33
    //   2340: astore 37
    //   2342: aload 34
    //   2344: astore 36
    //   2346: lload 4
    //   2348: lstore 8
    //   2350: lload_2
    //   2351: lstore 6
    //   2353: aload 45
    //   2355: astore 35
    //   2357: lload 4
    //   2359: lstore 28
    //   2361: lload_2
    //   2362: lstore 10
    //   2364: lload 4
    //   2366: lstore 20
    //   2368: lload_2
    //   2369: lstore 16
    //   2371: lload 4
    //   2373: lstore 26
    //   2375: lload_2
    //   2376: lstore 18
    //   2378: lload 4
    //   2380: lstore 22
    //   2382: lload_2
    //   2383: lstore 12
    //   2385: lload 4
    //   2387: lstore 24
    //   2389: lload_2
    //   2390: lstore 14
    //   2392: ldc 85
    //   2394: ldc_w 554
    //   2397: iconst_1
    //   2398: anewarray 4	java/lang/Object
    //   2401: dup
    //   2402: iconst_0
    //   2403: iload_1
    //   2404: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2407: aastore
    //   2408: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2411: aload 33
    //   2413: astore 37
    //   2415: aload 34
    //   2417: astore 36
    //   2419: lload 4
    //   2421: lstore 8
    //   2423: lload_2
    //   2424: lstore 6
    //   2426: aload 45
    //   2428: astore 35
    //   2430: lload 4
    //   2432: lstore 28
    //   2434: lload_2
    //   2435: lstore 10
    //   2437: lload 4
    //   2439: lstore 20
    //   2441: lload_2
    //   2442: lstore 16
    //   2444: lload 4
    //   2446: lstore 26
    //   2448: lload_2
    //   2449: lstore 18
    //   2451: lload 4
    //   2453: lstore 22
    //   2455: lload_2
    //   2456: lstore 12
    //   2458: lload 4
    //   2460: lstore 24
    //   2462: lload_2
    //   2463: lstore 14
    //   2465: ldc 85
    //   2467: new 508	java/lang/StringBuilder
    //   2470: dup
    //   2471: ldc_w 556
    //   2474: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2477: aload 34
    //   2479: ldc_w 528
    //   2482: invokevirtual 559	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2485: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2488: invokevirtual 519	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2491: invokestatic 561	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2494: aload 33
    //   2496: astore 37
    //   2498: aload 34
    //   2500: astore 36
    //   2502: lload 4
    //   2504: lstore 8
    //   2506: lload_2
    //   2507: lstore 6
    //   2509: aload 45
    //   2511: astore 35
    //   2513: lload 4
    //   2515: lstore 28
    //   2517: lload_2
    //   2518: lstore 10
    //   2520: lload 4
    //   2522: lstore 20
    //   2524: lload_2
    //   2525: lstore 16
    //   2527: lload 4
    //   2529: lstore 26
    //   2531: lload_2
    //   2532: lstore 18
    //   2534: lload 4
    //   2536: lstore 22
    //   2538: lload_2
    //   2539: lstore 12
    //   2541: lload 4
    //   2543: lstore 24
    //   2545: lload_2
    //   2546: lstore 14
    //   2548: aload 34
    //   2550: invokevirtual 564	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2553: astore 38
    //   2555: aload 33
    //   2557: astore 37
    //   2559: aload 34
    //   2561: astore 36
    //   2563: lload 4
    //   2565: lstore 8
    //   2567: lload_2
    //   2568: lstore 6
    //   2570: aload 45
    //   2572: astore 35
    //   2574: lload 4
    //   2576: lstore 28
    //   2578: lload_2
    //   2579: lstore 10
    //   2581: lload 4
    //   2583: lstore 20
    //   2585: lload_2
    //   2586: lstore 16
    //   2588: lload 4
    //   2590: lstore 26
    //   2592: lload_2
    //   2593: lstore 18
    //   2595: lload 4
    //   2597: lstore 22
    //   2599: lload_2
    //   2600: lstore 12
    //   2602: lload 4
    //   2604: lstore 24
    //   2606: lload_2
    //   2607: lstore 14
    //   2609: ldc 85
    //   2611: ldc_w 566
    //   2614: iconst_1
    //   2615: anewarray 4	java/lang/Object
    //   2618: dup
    //   2619: iconst_0
    //   2620: aload 38
    //   2622: aastore
    //   2623: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2626: aload 33
    //   2628: astore 37
    //   2630: aload 34
    //   2632: astore 36
    //   2634: lload 4
    //   2636: lstore 8
    //   2638: lload_2
    //   2639: lstore 6
    //   2641: aload 45
    //   2643: astore 35
    //   2645: lload 4
    //   2647: lstore 28
    //   2649: lload_2
    //   2650: lstore 10
    //   2652: lload 4
    //   2654: lstore 20
    //   2656: lload_2
    //   2657: lstore 16
    //   2659: lload 4
    //   2661: lstore 26
    //   2663: lload_2
    //   2664: lstore 18
    //   2666: lload 4
    //   2668: lstore 22
    //   2670: lload_2
    //   2671: lstore 12
    //   2673: lload 4
    //   2675: lstore 24
    //   2677: lload_2
    //   2678: lstore 14
    //   2680: aload_0
    //   2681: aload 38
    //   2683: putfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2686: aload 33
    //   2688: astore 37
    //   2690: aload 34
    //   2692: astore 36
    //   2694: lload 4
    //   2696: lstore 8
    //   2698: lload_2
    //   2699: lstore 6
    //   2701: aload 45
    //   2703: astore 35
    //   2705: lload 4
    //   2707: lstore 28
    //   2709: lload_2
    //   2710: lstore 10
    //   2712: lload 4
    //   2714: lstore 20
    //   2716: lload_2
    //   2717: lstore 16
    //   2719: lload 4
    //   2721: lstore 26
    //   2723: lload_2
    //   2724: lstore 18
    //   2726: lload 4
    //   2728: lstore 22
    //   2730: lload_2
    //   2731: lstore 12
    //   2733: lload 4
    //   2735: lstore 24
    //   2737: lload_2
    //   2738: lstore 14
    //   2740: aload_0
    //   2741: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2744: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2747: ifne +390 -> 3137
    //   2750: aload 33
    //   2752: astore 37
    //   2754: aload 34
    //   2756: astore 36
    //   2758: lload 4
    //   2760: lstore 8
    //   2762: lload_2
    //   2763: lstore 6
    //   2765: aload 45
    //   2767: astore 35
    //   2769: lload 4
    //   2771: lstore 28
    //   2773: lload_2
    //   2774: lstore 10
    //   2776: lload 4
    //   2778: lstore 20
    //   2780: lload_2
    //   2781: lstore 16
    //   2783: lload 4
    //   2785: lstore 26
    //   2787: lload_2
    //   2788: lstore 18
    //   2790: lload 4
    //   2792: lstore 22
    //   2794: lload_2
    //   2795: lstore 12
    //   2797: lload 4
    //   2799: lstore 24
    //   2801: lload_2
    //   2802: lstore 14
    //   2804: aload_0
    //   2805: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   2808: getfield 567	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2811: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2814: ifeq +323 -> 3137
    //   2817: aload 33
    //   2819: astore 37
    //   2821: aload 34
    //   2823: astore 36
    //   2825: lload 4
    //   2827: lstore 8
    //   2829: lload_2
    //   2830: lstore 6
    //   2832: aload 45
    //   2834: astore 35
    //   2836: lload 4
    //   2838: lstore 28
    //   2840: lload_2
    //   2841: lstore 10
    //   2843: lload 4
    //   2845: lstore 20
    //   2847: lload_2
    //   2848: lstore 16
    //   2850: lload 4
    //   2852: lstore 26
    //   2854: lload_2
    //   2855: lstore 18
    //   2857: lload 4
    //   2859: lstore 22
    //   2861: lload_2
    //   2862: lstore 12
    //   2864: lload 4
    //   2866: lstore 24
    //   2868: lload_2
    //   2869: lstore 14
    //   2871: aload_0
    //   2872: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   2875: aload_0
    //   2876: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2879: putfield 567	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2882: aload 33
    //   2884: astore 37
    //   2886: aload 34
    //   2888: astore 36
    //   2890: lload 4
    //   2892: lstore 8
    //   2894: lload_2
    //   2895: lstore 6
    //   2897: aload 45
    //   2899: astore 35
    //   2901: lload 4
    //   2903: lstore 28
    //   2905: lload_2
    //   2906: lstore 10
    //   2908: lload 4
    //   2910: lstore 20
    //   2912: lload_2
    //   2913: lstore 16
    //   2915: lload 4
    //   2917: lstore 26
    //   2919: lload_2
    //   2920: lstore 18
    //   2922: lload 4
    //   2924: lstore 22
    //   2926: lload_2
    //   2927: lstore 12
    //   2929: lload 4
    //   2931: lstore 24
    //   2933: lload_2
    //   2934: lstore 14
    //   2936: aload_0
    //   2937: getfield 61	com/tencent/mm/plugin/music/c/b:wjM	Lcom/tencent/mm/az/f;
    //   2940: getfield 320	com/tencent/mm/az/f:ihg	Ljava/lang/String;
    //   2943: astore 38
    //   2945: aload 33
    //   2947: astore 37
    //   2949: aload 34
    //   2951: astore 36
    //   2953: lload 4
    //   2955: lstore 8
    //   2957: lload_2
    //   2958: lstore 6
    //   2960: aload 45
    //   2962: astore 35
    //   2964: lload 4
    //   2966: lstore 28
    //   2968: lload_2
    //   2969: lstore 10
    //   2971: lload 4
    //   2973: lstore 20
    //   2975: lload_2
    //   2976: lstore 16
    //   2978: lload 4
    //   2980: lstore 26
    //   2982: lload_2
    //   2983: lstore 18
    //   2985: lload 4
    //   2987: lstore 22
    //   2989: lload_2
    //   2990: lstore 12
    //   2992: lload 4
    //   2994: lstore 24
    //   2996: lload_2
    //   2997: lstore 14
    //   2999: aload_0
    //   3000: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   3003: astore 39
    //   3005: aload 33
    //   3007: astore 37
    //   3009: aload 34
    //   3011: astore 36
    //   3013: lload 4
    //   3015: lstore 8
    //   3017: lload_2
    //   3018: lstore 6
    //   3020: aload 45
    //   3022: astore 35
    //   3024: lload 4
    //   3026: lstore 28
    //   3028: lload_2
    //   3029: lstore 10
    //   3031: lload 4
    //   3033: lstore 20
    //   3035: lload_2
    //   3036: lstore 16
    //   3038: lload 4
    //   3040: lstore 26
    //   3042: lload_2
    //   3043: lstore 18
    //   3045: lload 4
    //   3047: lstore 22
    //   3049: lload_2
    //   3050: lstore 12
    //   3052: lload 4
    //   3054: lstore 24
    //   3056: lload_2
    //   3057: lstore 14
    //   3059: invokestatic 570	com/tencent/mm/plugin/music/cache/e:dsB	()Z
    //   3062: ifeq +1375 -> 4437
    //   3065: aload 33
    //   3067: astore 37
    //   3069: aload 34
    //   3071: astore 36
    //   3073: lload 4
    //   3075: lstore 8
    //   3077: lload_2
    //   3078: lstore 6
    //   3080: aload 45
    //   3082: astore 35
    //   3084: lload 4
    //   3086: lstore 28
    //   3088: lload_2
    //   3089: lstore 10
    //   3091: lload 4
    //   3093: lstore 20
    //   3095: lload_2
    //   3096: lstore 16
    //   3098: lload 4
    //   3100: lstore 26
    //   3102: lload_2
    //   3103: lstore 18
    //   3105: lload 4
    //   3107: lstore 22
    //   3109: lload_2
    //   3110: lstore 12
    //   3112: lload 4
    //   3114: lstore 24
    //   3116: lload_2
    //   3117: lstore 14
    //   3119: ldc_w 572
    //   3122: invokestatic 299	com/tencent/mm/plugin/music/f/c/b:aQ	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/music/f/c/a;
    //   3125: checkcast 572	com/tencent/mm/plugin/music/cache/c
    //   3128: aload 38
    //   3130: aload 39
    //   3132: invokeinterface 575 3 0
    //   3137: aload 33
    //   3139: astore 37
    //   3141: aload 34
    //   3143: astore 36
    //   3145: lload 4
    //   3147: lstore 8
    //   3149: lload_2
    //   3150: lstore 6
    //   3152: aload 45
    //   3154: astore 35
    //   3156: lload 4
    //   3158: lstore 28
    //   3160: lload_2
    //   3161: lstore 10
    //   3163: lload 4
    //   3165: lstore 20
    //   3167: lload_2
    //   3168: lstore 16
    //   3170: lload 4
    //   3172: lstore 26
    //   3174: lload_2
    //   3175: lstore 18
    //   3177: lload 4
    //   3179: lstore 22
    //   3181: lload_2
    //   3182: lstore 12
    //   3184: lload 4
    //   3186: lstore 24
    //   3188: lload_2
    //   3189: lstore 14
    //   3191: aload 34
    //   3193: ldc_w 577
    //   3196: invokevirtual 253	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3199: astore 38
    //   3201: aload 33
    //   3203: astore 37
    //   3205: aload 34
    //   3207: astore 36
    //   3209: lload 4
    //   3211: lstore 8
    //   3213: lload_2
    //   3214: lstore 6
    //   3216: aload 45
    //   3218: astore 35
    //   3220: lload 4
    //   3222: lstore 28
    //   3224: lload_2
    //   3225: lstore 10
    //   3227: lload 4
    //   3229: lstore 20
    //   3231: lload_2
    //   3232: lstore 16
    //   3234: lload 4
    //   3236: lstore 26
    //   3238: lload_2
    //   3239: lstore 18
    //   3241: lload 4
    //   3243: lstore 22
    //   3245: lload_2
    //   3246: lstore 12
    //   3248: lload 4
    //   3250: lstore 24
    //   3252: lload_2
    //   3253: lstore 14
    //   3255: aload 38
    //   3257: invokestatic 579	com/tencent/mm/plugin/music/c/b:asz	(Ljava/lang/String;)[J
    //   3260: astore 39
    //   3262: aload 33
    //   3264: astore 37
    //   3266: aload 34
    //   3268: astore 36
    //   3270: lload 4
    //   3272: lstore 8
    //   3274: lload_2
    //   3275: lstore 6
    //   3277: aload 45
    //   3279: astore 35
    //   3281: lload 4
    //   3283: lstore 28
    //   3285: lload_2
    //   3286: lstore 10
    //   3288: lload 4
    //   3290: lstore 20
    //   3292: lload_2
    //   3293: lstore 16
    //   3295: lload 4
    //   3297: lstore 26
    //   3299: lload_2
    //   3300: lstore 18
    //   3302: lload 4
    //   3304: lstore 22
    //   3306: lload_2
    //   3307: lstore 12
    //   3309: lload 4
    //   3311: lstore 24
    //   3313: lload_2
    //   3314: lstore 14
    //   3316: aload 34
    //   3318: ldc_w 581
    //   3321: invokevirtual 253	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3324: lconst_0
    //   3325: invokestatic 585	com/tencent/mm/sdk/platformtools/bt:getLong	(Ljava/lang/String;J)J
    //   3328: lstore 30
    //   3330: aload 33
    //   3332: astore 37
    //   3334: aload 34
    //   3336: astore 36
    //   3338: lload 4
    //   3340: lstore 8
    //   3342: lload_2
    //   3343: lstore 6
    //   3345: aload 45
    //   3347: astore 35
    //   3349: lload 4
    //   3351: lstore 28
    //   3353: lload_2
    //   3354: lstore 10
    //   3356: lload 4
    //   3358: lstore 20
    //   3360: lload_2
    //   3361: lstore 16
    //   3363: lload 4
    //   3365: lstore 26
    //   3367: lload_2
    //   3368: lstore 18
    //   3370: lload 4
    //   3372: lstore 22
    //   3374: lload_2
    //   3375: lstore 12
    //   3377: lload 4
    //   3379: lstore 24
    //   3381: lload_2
    //   3382: lstore 14
    //   3384: ldc 85
    //   3386: ldc_w 587
    //   3389: iconst_2
    //   3390: anewarray 4	java/lang/Object
    //   3393: dup
    //   3394: iconst_0
    //   3395: aload 38
    //   3397: aastore
    //   3398: dup
    //   3399: iconst_1
    //   3400: lload 30
    //   3402: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3405: aastore
    //   3406: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3409: aload 39
    //   3411: ifnonnull +1092 -> 4503
    //   3414: aload 33
    //   3416: astore 37
    //   3418: aload 34
    //   3420: astore 36
    //   3422: lload 4
    //   3424: lstore 8
    //   3426: lload_2
    //   3427: lstore 6
    //   3429: aload 45
    //   3431: astore 35
    //   3433: lload 4
    //   3435: lstore 28
    //   3437: lload_2
    //   3438: lstore 10
    //   3440: lload 4
    //   3442: lstore 20
    //   3444: lload_2
    //   3445: lstore 16
    //   3447: lload 4
    //   3449: lstore 26
    //   3451: lload_2
    //   3452: lstore 18
    //   3454: lload 4
    //   3456: lstore 22
    //   3458: lload_2
    //   3459: lstore 12
    //   3461: lload 4
    //   3463: lstore 24
    //   3465: lload_2
    //   3466: lstore 14
    //   3468: ldc 85
    //   3470: ldc_w 589
    //   3473: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3476: lload_2
    //   3477: lstore 4
    //   3479: lload_2
    //   3480: lconst_0
    //   3481: lcmp
    //   3482: ifeq +4381 -> 7863
    //   3485: lconst_0
    //   3486: lstore 4
    //   3488: goto +4375 -> 7863
    //   3491: aload 33
    //   3493: astore 37
    //   3495: aload 34
    //   3497: astore 36
    //   3499: lload 4
    //   3501: lstore 8
    //   3503: lload_2
    //   3504: lstore 6
    //   3506: aload 45
    //   3508: astore 35
    //   3510: lload 4
    //   3512: lstore 28
    //   3514: lload_2
    //   3515: lstore 10
    //   3517: lload 4
    //   3519: lstore 20
    //   3521: lload_2
    //   3522: lstore 16
    //   3524: lload 4
    //   3526: lstore 26
    //   3528: lload_2
    //   3529: lstore 18
    //   3531: lload 4
    //   3533: lstore 22
    //   3535: lload_2
    //   3536: lstore 12
    //   3538: lload 4
    //   3540: lstore 24
    //   3542: lload_2
    //   3543: lstore 14
    //   3545: ldc 85
    //   3547: ldc_w 591
    //   3550: iconst_3
    //   3551: anewarray 4	java/lang/Object
    //   3554: dup
    //   3555: iconst_0
    //   3556: lload 30
    //   3558: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3561: aastore
    //   3562: dup
    //   3563: iconst_1
    //   3564: lload_2
    //   3565: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3568: aastore
    //   3569: dup
    //   3570: iconst_2
    //   3571: aload_0
    //   3572: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3575: invokestatic 417	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3578: aastore
    //   3579: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3582: aload 33
    //   3584: astore 37
    //   3586: aload 34
    //   3588: astore 36
    //   3590: lload 4
    //   3592: lstore 8
    //   3594: lload_2
    //   3595: lstore 6
    //   3597: aload 45
    //   3599: astore 35
    //   3601: lload 4
    //   3603: lstore 28
    //   3605: lload_2
    //   3606: lstore 10
    //   3608: lload 4
    //   3610: lstore 20
    //   3612: lload_2
    //   3613: lstore 16
    //   3615: lload 4
    //   3617: lstore 26
    //   3619: lload_2
    //   3620: lstore 18
    //   3622: lload 4
    //   3624: lstore 22
    //   3626: lload_2
    //   3627: lstore 12
    //   3629: lload 4
    //   3631: lstore 24
    //   3633: lload_2
    //   3634: lstore 14
    //   3636: aload 33
    //   3638: lload 30
    //   3640: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   3643: aload 33
    //   3645: astore 37
    //   3647: aload 34
    //   3649: astore 36
    //   3651: lload 4
    //   3653: lstore 8
    //   3655: lload_2
    //   3656: lstore 6
    //   3658: aload 45
    //   3660: astore 35
    //   3662: lload 4
    //   3664: lstore 28
    //   3666: lload_2
    //   3667: lstore 10
    //   3669: lload 4
    //   3671: lstore 20
    //   3673: lload_2
    //   3674: lstore 16
    //   3676: lload 4
    //   3678: lstore 26
    //   3680: lload_2
    //   3681: lstore 18
    //   3683: lload 4
    //   3685: lstore 22
    //   3687: lload_2
    //   3688: lstore 12
    //   3690: lload 4
    //   3692: lstore 24
    //   3694: lload_2
    //   3695: lstore 14
    //   3697: aload 33
    //   3699: lload_2
    //   3700: invokevirtual 594	java/io/RandomAccessFile:seek	(J)V
    //   3703: aload 33
    //   3705: astore 37
    //   3707: aload 34
    //   3709: astore 36
    //   3711: lload 4
    //   3713: lstore 8
    //   3715: lload_2
    //   3716: lstore 6
    //   3718: aload 45
    //   3720: astore 35
    //   3722: lload 4
    //   3724: lstore 28
    //   3726: lload_2
    //   3727: lstore 10
    //   3729: lload 4
    //   3731: lstore 20
    //   3733: lload_2
    //   3734: lstore 16
    //   3736: lload 4
    //   3738: lstore 26
    //   3740: lload_2
    //   3741: lstore 18
    //   3743: lload 4
    //   3745: lstore 22
    //   3747: lload_2
    //   3748: lstore 12
    //   3750: lload 4
    //   3752: lstore 24
    //   3754: lload_2
    //   3755: lstore 14
    //   3757: aload 34
    //   3759: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3762: astore 38
    //   3764: aload 38
    //   3766: astore 35
    //   3768: lload_2
    //   3769: lstore 18
    //   3771: lload_2
    //   3772: lstore 16
    //   3774: aload 33
    //   3776: astore 37
    //   3778: aload 35
    //   3780: astore 39
    //   3782: aload 34
    //   3784: astore 36
    //   3786: lload 4
    //   3788: lstore 20
    //   3790: lload_2
    //   3791: lstore 8
    //   3793: lload_2
    //   3794: lstore 14
    //   3796: lload_2
    //   3797: lstore 12
    //   3799: lload_2
    //   3800: lstore 10
    //   3802: sipush 4096
    //   3805: newarray byte
    //   3807: astore 38
    //   3809: lload_2
    //   3810: lstore 18
    //   3812: lload_2
    //   3813: lstore 16
    //   3815: aload 33
    //   3817: astore 37
    //   3819: aload 35
    //   3821: astore 39
    //   3823: aload 34
    //   3825: astore 36
    //   3827: lload 4
    //   3829: lstore 20
    //   3831: lload_2
    //   3832: lstore 8
    //   3834: lload_2
    //   3835: lstore 14
    //   3837: lload_2
    //   3838: lstore 12
    //   3840: lload_2
    //   3841: lstore 10
    //   3843: aload_0
    //   3844: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3847: ifne +1479 -> 5326
    //   3850: lload_2
    //   3851: lstore 18
    //   3853: lload_2
    //   3854: lstore 16
    //   3856: aload 33
    //   3858: astore 37
    //   3860: aload 35
    //   3862: astore 39
    //   3864: aload 34
    //   3866: astore 36
    //   3868: lload 4
    //   3870: lstore 20
    //   3872: lload_2
    //   3873: lstore 8
    //   3875: lload_2
    //   3876: lstore 14
    //   3878: lload_2
    //   3879: lstore 12
    //   3881: lload_2
    //   3882: lstore 10
    //   3884: aload 35
    //   3886: aload 38
    //   3888: invokevirtual 598	java/io/InputStream:read	([B)I
    //   3891: istore_1
    //   3892: iload_1
    //   3893: ifle +1355 -> 5248
    //   3896: lload_2
    //   3897: lstore 18
    //   3899: lload_2
    //   3900: lstore 16
    //   3902: aload 33
    //   3904: astore 37
    //   3906: aload 35
    //   3908: astore 39
    //   3910: aload 34
    //   3912: astore 36
    //   3914: lload 4
    //   3916: lstore 20
    //   3918: lload_2
    //   3919: lstore 8
    //   3921: lload_2
    //   3922: lstore 14
    //   3924: lload_2
    //   3925: lstore 12
    //   3927: lload_2
    //   3928: lstore 10
    //   3930: aload 33
    //   3932: aload 38
    //   3934: iconst_0
    //   3935: iload_1
    //   3936: invokevirtual 602	java/io/RandomAccessFile:write	([BII)V
    //   3939: lload_2
    //   3940: iload_1
    //   3941: i2l
    //   3942: ladd
    //   3943: lstore 6
    //   3945: lload 6
    //   3947: lstore 18
    //   3949: lload 6
    //   3951: lstore 16
    //   3953: aload 33
    //   3955: astore 37
    //   3957: aload 35
    //   3959: astore 39
    //   3961: aload 34
    //   3963: astore 36
    //   3965: lload 4
    //   3967: lstore 20
    //   3969: lload 6
    //   3971: lstore 8
    //   3973: lload 6
    //   3975: lstore 14
    //   3977: lload 6
    //   3979: lstore 12
    //   3981: lload 6
    //   3983: lstore 10
    //   3985: ldc 85
    //   3987: ldc_w 604
    //   3990: iconst_2
    //   3991: anewarray 4	java/lang/Object
    //   3994: dup
    //   3995: iconst_0
    //   3996: lload 6
    //   3998: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4001: aastore
    //   4002: dup
    //   4003: iconst_1
    //   4004: lload 30
    //   4006: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4009: aastore
    //   4010: invokestatic 607	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4013: lload 6
    //   4015: lstore 18
    //   4017: lload 6
    //   4019: lstore 16
    //   4021: aload 33
    //   4023: astore 37
    //   4025: aload 35
    //   4027: astore 39
    //   4029: aload 34
    //   4031: astore 36
    //   4033: lload 4
    //   4035: lstore 20
    //   4037: lload 6
    //   4039: lstore 8
    //   4041: lload 6
    //   4043: lstore 14
    //   4045: lload 6
    //   4047: lstore 12
    //   4049: lload 6
    //   4051: lstore 10
    //   4053: aload_0
    //   4054: getfield 107	com/tencent/mm/plugin/music/c/b:ruo	Z
    //   4057: ifeq +877 -> 4934
    //   4060: lload 6
    //   4062: lstore 18
    //   4064: lload 6
    //   4066: lstore 16
    //   4068: aload 33
    //   4070: astore 37
    //   4072: aload 35
    //   4074: astore 39
    //   4076: aload 34
    //   4078: astore 36
    //   4080: lload 4
    //   4082: lstore 20
    //   4084: lload 6
    //   4086: lstore 8
    //   4088: lload 6
    //   4090: lstore 14
    //   4092: lload 6
    //   4094: lstore 12
    //   4096: lload 6
    //   4098: lstore 10
    //   4100: aload_0
    //   4101: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   4104: lload 6
    //   4106: putfield 77	com/tencent/mm/plugin/music/c/a:wjI	J
    //   4109: lload 6
    //   4111: lstore 18
    //   4113: lload 6
    //   4115: lstore 16
    //   4117: aload 33
    //   4119: astore 37
    //   4121: aload 35
    //   4123: astore 39
    //   4125: aload 34
    //   4127: astore 36
    //   4129: lload 4
    //   4131: lstore 20
    //   4133: lload 6
    //   4135: lstore 8
    //   4137: lload 6
    //   4139: lstore 14
    //   4141: lload 6
    //   4143: lstore 12
    //   4145: lload 6
    //   4147: lstore 10
    //   4149: aload_0
    //   4150: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   4153: lload 30
    //   4155: putfield 80	com/tencent/mm/plugin/music/c/a:wjK	J
    //   4158: lload 6
    //   4160: lstore_2
    //   4161: lload 6
    //   4163: ldc2_w 392
    //   4166: lcmp
    //   4167: iflt -358 -> 3809
    //   4170: lload 6
    //   4172: lstore 18
    //   4174: lload 6
    //   4176: lstore 16
    //   4178: aload 33
    //   4180: astore 37
    //   4182: aload 35
    //   4184: astore 39
    //   4186: aload 34
    //   4188: astore 36
    //   4190: lload 4
    //   4192: lstore 20
    //   4194: lload 6
    //   4196: lstore 8
    //   4198: lload 6
    //   4200: lstore 14
    //   4202: lload 6
    //   4204: lstore 12
    //   4206: lload 6
    //   4208: lstore 10
    //   4210: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4213: dup
    //   4214: aload_0
    //   4215: iconst_1
    //   4216: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4219: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4222: lload 6
    //   4224: lstore_2
    //   4225: goto -416 -> 3809
    //   4228: astore 38
    //   4230: lload 18
    //   4232: lstore_2
    //   4233: aload 33
    //   4235: astore 37
    //   4237: aload 35
    //   4239: astore 39
    //   4241: aload 34
    //   4243: astore 36
    //   4245: lload 4
    //   4247: lstore 20
    //   4249: lload_2
    //   4250: lstore 8
    //   4252: ldc 85
    //   4254: aload 38
    //   4256: ldc_w 609
    //   4259: iconst_1
    //   4260: anewarray 4	java/lang/Object
    //   4263: dup
    //   4264: iconst_0
    //   4265: aload 52
    //   4267: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   4270: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   4273: aastore
    //   4274: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4277: aload 33
    //   4279: astore 37
    //   4281: aload 35
    //   4283: astore 39
    //   4285: aload 34
    //   4287: astore 36
    //   4289: lload 4
    //   4291: lstore 20
    //   4293: lload_2
    //   4294: lstore 8
    //   4296: aload_0
    //   4297: sipush 750
    //   4300: putfield 59	com/tencent/mm/plugin/music/c/b:ddo	I
    //   4303: aload 33
    //   4305: astore 37
    //   4307: aload 35
    //   4309: astore 39
    //   4311: aload 34
    //   4313: astore 36
    //   4315: lload 4
    //   4317: lstore 20
    //   4319: lload_2
    //   4320: lstore 8
    //   4322: aload_0
    //   4323: iconst_5
    //   4324: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   4327: lload 4
    //   4329: lconst_0
    //   4330: lcmp
    //   4331: ifne +1384 -> 5715
    //   4334: lload_2
    //   4335: lconst_0
    //   4336: lcmp
    //   4337: ifle +1378 -> 5715
    //   4340: ldc 85
    //   4342: ldc_w 458
    //   4345: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4348: aload 33
    //   4350: lload_2
    //   4351: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   4354: aload_0
    //   4355: lload_2
    //   4356: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   4359: lload_2
    //   4360: ldc2_w 392
    //   4363: lcmp
    //   4364: ifge +15 -> 4379
    //   4367: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4370: dup
    //   4371: aload_0
    //   4372: iconst_1
    //   4373: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4376: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4379: aload 35
    //   4381: ifnull +8 -> 4389
    //   4384: aload 35
    //   4386: invokevirtual 139	java/io/InputStream:close	()V
    //   4389: aload 33
    //   4391: ifnull +8 -> 4399
    //   4394: aload 33
    //   4396: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   4399: aload 34
    //   4401: ifnull +16 -> 4417
    //   4404: aload 34
    //   4406: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4409: invokevirtual 139	java/io/InputStream:close	()V
    //   4412: aload 34
    //   4414: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   4417: aload_0
    //   4418: iconst_1
    //   4419: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4422: ldc 85
    //   4424: ldc_w 465
    //   4427: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4430: ldc_w 373
    //   4433: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4436: return
    //   4437: aload 33
    //   4439: astore 37
    //   4441: aload 34
    //   4443: astore 36
    //   4445: lload 4
    //   4447: lstore 8
    //   4449: lload_2
    //   4450: lstore 6
    //   4452: aload 45
    //   4454: astore 35
    //   4456: lload 4
    //   4458: lstore 28
    //   4460: lload_2
    //   4461: lstore 10
    //   4463: lload 4
    //   4465: lstore 20
    //   4467: lload_2
    //   4468: lstore 16
    //   4470: lload 4
    //   4472: lstore 26
    //   4474: lload_2
    //   4475: lstore 18
    //   4477: lload 4
    //   4479: lstore 22
    //   4481: lload_2
    //   4482: lstore 12
    //   4484: lload 4
    //   4486: lstore 24
    //   4488: lload_2
    //   4489: lstore 14
    //   4491: ldc_w 611
    //   4494: ldc_w 613
    //   4497: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4500: goto -1363 -> 3137
    //   4503: lload_2
    //   4504: lconst_0
    //   4505: lcmp
    //   4506: ifle +419 -> 4925
    //   4509: lload_2
    //   4510: aload 39
    //   4512: iconst_0
    //   4513: laload
    //   4514: lcmp
    //   4515: ifeq +410 -> 4925
    //   4518: aload 33
    //   4520: astore 37
    //   4522: aload 34
    //   4524: astore 36
    //   4526: lload 4
    //   4528: lstore 8
    //   4530: lload_2
    //   4531: lstore 6
    //   4533: aload 45
    //   4535: astore 35
    //   4537: lload 4
    //   4539: lstore 28
    //   4541: lload_2
    //   4542: lstore 10
    //   4544: lload 4
    //   4546: lstore 20
    //   4548: lload_2
    //   4549: lstore 16
    //   4551: lload 4
    //   4553: lstore 26
    //   4555: lload_2
    //   4556: lstore 18
    //   4558: lload 4
    //   4560: lstore 22
    //   4562: lload_2
    //   4563: lstore 12
    //   4565: lload 4
    //   4567: lstore 24
    //   4569: lload_2
    //   4570: lstore 14
    //   4572: ldc 85
    //   4574: ldc_w 615
    //   4577: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4580: aload 33
    //   4582: astore 37
    //   4584: aload 34
    //   4586: astore 36
    //   4588: lload 4
    //   4590: lstore 8
    //   4592: lload_2
    //   4593: lstore 6
    //   4595: aload 45
    //   4597: astore 35
    //   4599: lload 4
    //   4601: lstore 28
    //   4603: lload_2
    //   4604: lstore 10
    //   4606: lload 4
    //   4608: lstore 20
    //   4610: lload_2
    //   4611: lstore 16
    //   4613: lload 4
    //   4615: lstore 26
    //   4617: lload_2
    //   4618: lstore 18
    //   4620: lload 4
    //   4622: lstore 22
    //   4624: lload_2
    //   4625: lstore 12
    //   4627: lload 4
    //   4629: lstore 24
    //   4631: lload_2
    //   4632: lstore 14
    //   4634: aload_0
    //   4635: bipush 6
    //   4637: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   4640: lload 4
    //   4642: lconst_0
    //   4643: lcmp
    //   4644: ifne +115 -> 4759
    //   4647: lload_2
    //   4648: lconst_0
    //   4649: lcmp
    //   4650: ifle +109 -> 4759
    //   4653: ldc 85
    //   4655: ldc_w 458
    //   4658: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4661: aload 33
    //   4663: lload_2
    //   4664: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   4667: aload_0
    //   4668: lload_2
    //   4669: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   4672: lload_2
    //   4673: ldc2_w 392
    //   4676: lcmp
    //   4677: ifge +15 -> 4692
    //   4680: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4683: dup
    //   4684: aload_0
    //   4685: iconst_1
    //   4686: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4689: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4692: aload 33
    //   4694: ifnull +8 -> 4702
    //   4697: aload 33
    //   4699: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   4702: aload 34
    //   4704: ifnull +16 -> 4720
    //   4707: aload 34
    //   4709: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4712: invokevirtual 139	java/io/InputStream:close	()V
    //   4715: aload 34
    //   4717: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   4720: aload_0
    //   4721: iconst_1
    //   4722: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4725: ldc 85
    //   4727: ldc_w 465
    //   4730: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4733: ldc_w 373
    //   4736: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4739: return
    //   4740: astore 35
    //   4742: ldc 85
    //   4744: aload 35
    //   4746: ldc_w 467
    //   4749: iconst_0
    //   4750: anewarray 4	java/lang/Object
    //   4753: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4756: goto -89 -> 4667
    //   4759: lload 4
    //   4761: lconst_0
    //   4762: lcmp
    //   4763: ifeq +47 -> 4810
    //   4766: lload_2
    //   4767: lload 4
    //   4769: lcmp
    //   4770: ifeq +40 -> 4810
    //   4773: ldc 85
    //   4775: ldc_w 469
    //   4778: iconst_2
    //   4779: anewarray 4	java/lang/Object
    //   4782: dup
    //   4783: iconst_0
    //   4784: lload 4
    //   4786: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4789: aastore
    //   4790: dup
    //   4791: iconst_1
    //   4792: lload_2
    //   4793: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4796: aastore
    //   4797: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4800: aload_0
    //   4801: lload_2
    //   4802: lload 4
    //   4804: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   4807: goto -115 -> 4692
    //   4810: lload 4
    //   4812: lconst_0
    //   4813: lcmp
    //   4814: ifeq +66 -> 4880
    //   4817: lload_2
    //   4818: lload 4
    //   4820: lcmp
    //   4821: ifne +59 -> 4880
    //   4824: ldc 85
    //   4826: ldc_w 473
    //   4829: iconst_2
    //   4830: anewarray 4	java/lang/Object
    //   4833: dup
    //   4834: iconst_0
    //   4835: lload 4
    //   4837: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4840: aastore
    //   4841: dup
    //   4842: iconst_1
    //   4843: lload_2
    //   4844: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4847: aastore
    //   4848: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4851: aload_0
    //   4852: lload 4
    //   4854: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   4857: lload_2
    //   4858: ldc2_w 392
    //   4861: lcmp
    //   4862: ifge -170 -> 4692
    //   4865: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4868: dup
    //   4869: aload_0
    //   4870: iconst_1
    //   4871: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4874: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4877: goto -185 -> 4692
    //   4880: ldc 85
    //   4882: ldc_w 475
    //   4885: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4888: goto -196 -> 4692
    //   4891: astore 33
    //   4893: ldc 85
    //   4895: aload 33
    //   4897: ldc_w 467
    //   4900: iconst_0
    //   4901: anewarray 4	java/lang/Object
    //   4904: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4907: goto -205 -> 4702
    //   4910: astore 33
    //   4912: ldc 85
    //   4914: aload 33
    //   4916: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4919: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4922: goto -207 -> 4715
    //   4925: aload 39
    //   4927: iconst_2
    //   4928: laload
    //   4929: lstore 4
    //   4931: goto +2943 -> 7874
    //   4934: lload 6
    //   4936: lstore 18
    //   4938: lload 6
    //   4940: lstore 16
    //   4942: aload 33
    //   4944: astore 37
    //   4946: aload 35
    //   4948: astore 39
    //   4950: aload 34
    //   4952: astore 36
    //   4954: lload 4
    //   4956: lstore 20
    //   4958: lload 6
    //   4960: lstore 8
    //   4962: lload 6
    //   4964: lstore 14
    //   4966: lload 6
    //   4968: lstore 12
    //   4970: lload 6
    //   4972: lstore 10
    //   4974: aload_0
    //   4975: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   4978: lload 6
    //   4980: putfield 68	com/tencent/mm/plugin/music/c/a:wjG	J
    //   4983: lload 6
    //   4985: lstore 18
    //   4987: lload 6
    //   4989: lstore 16
    //   4991: aload 33
    //   4993: astore 37
    //   4995: aload 35
    //   4997: astore 39
    //   4999: aload 34
    //   5001: astore 36
    //   5003: lload 4
    //   5005: lstore 20
    //   5007: lload 6
    //   5009: lstore 8
    //   5011: lload 6
    //   5013: lstore 14
    //   5015: lload 6
    //   5017: lstore 12
    //   5019: lload 6
    //   5021: lstore 10
    //   5023: aload_0
    //   5024: getfield 63	com/tencent/mm/plugin/music/c/b:wjN	Lcom/tencent/mm/plugin/music/c/a;
    //   5027: lload 30
    //   5029: putfield 71	com/tencent/mm/plugin/music/c/a:wjH	J
    //   5032: goto -874 -> 4158
    //   5035: astore 38
    //   5037: aload 35
    //   5039: astore 39
    //   5041: lload 16
    //   5043: lstore_2
    //   5044: aload 33
    //   5046: astore 37
    //   5048: aload 34
    //   5050: astore 36
    //   5052: lload 4
    //   5054: lstore 8
    //   5056: lload_2
    //   5057: lstore 6
    //   5059: aload 39
    //   5061: astore 35
    //   5063: ldc 85
    //   5065: aload 38
    //   5067: ldc_w 609
    //   5070: iconst_1
    //   5071: anewarray 4	java/lang/Object
    //   5074: dup
    //   5075: iconst_0
    //   5076: aload 52
    //   5078: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   5081: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   5084: aastore
    //   5085: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5088: aload 33
    //   5090: astore 37
    //   5092: aload 34
    //   5094: astore 36
    //   5096: lload 4
    //   5098: lstore 8
    //   5100: lload_2
    //   5101: lstore 6
    //   5103: aload 39
    //   5105: astore 35
    //   5107: aload_0
    //   5108: sipush 751
    //   5111: putfield 59	com/tencent/mm/plugin/music/c/b:ddo	I
    //   5114: aload 33
    //   5116: astore 37
    //   5118: aload 34
    //   5120: astore 36
    //   5122: lload 4
    //   5124: lstore 8
    //   5126: lload_2
    //   5127: lstore 6
    //   5129: aload 39
    //   5131: astore 35
    //   5133: aload_0
    //   5134: iconst_5
    //   5135: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   5138: lload 4
    //   5140: lconst_0
    //   5141: lcmp
    //   5142: ifne +777 -> 5919
    //   5145: lload_2
    //   5146: lconst_0
    //   5147: lcmp
    //   5148: ifle +771 -> 5919
    //   5151: ldc 85
    //   5153: ldc_w 458
    //   5156: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5159: aload 33
    //   5161: lload_2
    //   5162: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   5165: aload_0
    //   5166: lload_2
    //   5167: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   5170: lload_2
    //   5171: ldc2_w 392
    //   5174: lcmp
    //   5175: ifge +15 -> 5190
    //   5178: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5181: dup
    //   5182: aload_0
    //   5183: iconst_1
    //   5184: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5187: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5190: aload 39
    //   5192: ifnull +8 -> 5200
    //   5195: aload 39
    //   5197: invokevirtual 139	java/io/InputStream:close	()V
    //   5200: aload 33
    //   5202: ifnull +8 -> 5210
    //   5205: aload 33
    //   5207: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   5210: aload 34
    //   5212: ifnull +16 -> 5228
    //   5215: aload 34
    //   5217: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5220: invokevirtual 139	java/io/InputStream:close	()V
    //   5223: aload 34
    //   5225: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   5228: aload_0
    //   5229: iconst_1
    //   5230: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5233: ldc 85
    //   5235: ldc_w 465
    //   5238: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5241: ldc_w 373
    //   5244: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5247: return
    //   5248: lload_2
    //   5249: lstore 18
    //   5251: lload_2
    //   5252: lstore 16
    //   5254: aload 33
    //   5256: astore 37
    //   5258: aload 35
    //   5260: astore 39
    //   5262: aload 34
    //   5264: astore 36
    //   5266: lload 4
    //   5268: lstore 20
    //   5270: lload_2
    //   5271: lstore 8
    //   5273: lload_2
    //   5274: lstore 14
    //   5276: lload_2
    //   5277: lstore 12
    //   5279: lload_2
    //   5280: lstore 10
    //   5282: ldc 85
    //   5284: ldc_w 617
    //   5287: iconst_4
    //   5288: anewarray 4	java/lang/Object
    //   5291: dup
    //   5292: iconst_0
    //   5293: iload_1
    //   5294: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5297: aastore
    //   5298: dup
    //   5299: iconst_1
    //   5300: aload_0
    //   5301: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5304: invokestatic 417	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5307: aastore
    //   5308: dup
    //   5309: iconst_2
    //   5310: lload_2
    //   5311: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5314: aastore
    //   5315: dup
    //   5316: iconst_3
    //   5317: lload 30
    //   5319: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5322: aastore
    //   5323: invokestatic 257	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5326: lload_2
    //   5327: lstore 18
    //   5329: lload_2
    //   5330: lstore 16
    //   5332: aload 33
    //   5334: astore 37
    //   5336: aload 35
    //   5338: astore 39
    //   5340: aload 34
    //   5342: astore 36
    //   5344: lload 4
    //   5346: lstore 20
    //   5348: lload_2
    //   5349: lstore 8
    //   5351: lload_2
    //   5352: lstore 14
    //   5354: lload_2
    //   5355: lstore 12
    //   5357: lload_2
    //   5358: lstore 10
    //   5360: ldc 85
    //   5362: ldc_w 619
    //   5365: iconst_1
    //   5366: anewarray 4	java/lang/Object
    //   5369: dup
    //   5370: iconst_0
    //   5371: aload_0
    //   5372: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5375: invokestatic 417	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5378: aastore
    //   5379: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5382: lload 4
    //   5384: lconst_0
    //   5385: lcmp
    //   5386: ifne +125 -> 5511
    //   5389: lload_2
    //   5390: lconst_0
    //   5391: lcmp
    //   5392: ifle +119 -> 5511
    //   5395: ldc 85
    //   5397: ldc_w 458
    //   5400: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5403: aload 33
    //   5405: lload_2
    //   5406: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   5409: aload_0
    //   5410: lload_2
    //   5411: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   5414: lload_2
    //   5415: ldc2_w 392
    //   5418: lcmp
    //   5419: ifge +15 -> 5434
    //   5422: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5425: dup
    //   5426: aload_0
    //   5427: iconst_1
    //   5428: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5431: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5434: aload 35
    //   5436: ifnull +8 -> 5444
    //   5439: aload 35
    //   5441: invokevirtual 139	java/io/InputStream:close	()V
    //   5444: aload 33
    //   5446: ifnull +8 -> 5454
    //   5449: aload 33
    //   5451: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   5454: aload 34
    //   5456: ifnull +16 -> 5472
    //   5459: aload 34
    //   5461: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5464: invokevirtual 139	java/io/InputStream:close	()V
    //   5467: aload 34
    //   5469: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   5472: aload_0
    //   5473: iconst_1
    //   5474: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5477: ldc 85
    //   5479: ldc_w 465
    //   5482: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5485: ldc_w 373
    //   5488: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5491: return
    //   5492: astore 36
    //   5494: ldc 85
    //   5496: aload 36
    //   5498: ldc_w 467
    //   5501: iconst_0
    //   5502: anewarray 4	java/lang/Object
    //   5505: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5508: goto -99 -> 5409
    //   5511: lload 4
    //   5513: lconst_0
    //   5514: lcmp
    //   5515: ifeq +47 -> 5562
    //   5518: lload_2
    //   5519: lload 4
    //   5521: lcmp
    //   5522: ifeq +40 -> 5562
    //   5525: ldc 85
    //   5527: ldc_w 469
    //   5530: iconst_2
    //   5531: anewarray 4	java/lang/Object
    //   5534: dup
    //   5535: iconst_0
    //   5536: lload 4
    //   5538: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5541: aastore
    //   5542: dup
    //   5543: iconst_1
    //   5544: lload_2
    //   5545: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5548: aastore
    //   5549: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5552: aload_0
    //   5553: lload_2
    //   5554: lload 4
    //   5556: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   5559: goto -125 -> 5434
    //   5562: lload 4
    //   5564: lconst_0
    //   5565: lcmp
    //   5566: ifeq +66 -> 5632
    //   5569: lload_2
    //   5570: lload 4
    //   5572: lcmp
    //   5573: ifne +59 -> 5632
    //   5576: ldc 85
    //   5578: ldc_w 473
    //   5581: iconst_2
    //   5582: anewarray 4	java/lang/Object
    //   5585: dup
    //   5586: iconst_0
    //   5587: lload 4
    //   5589: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5592: aastore
    //   5593: dup
    //   5594: iconst_1
    //   5595: lload_2
    //   5596: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5599: aastore
    //   5600: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5603: aload_0
    //   5604: lload 4
    //   5606: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   5609: lload_2
    //   5610: ldc2_w 392
    //   5613: lcmp
    //   5614: ifge -180 -> 5434
    //   5617: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5620: dup
    //   5621: aload_0
    //   5622: iconst_1
    //   5623: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5626: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5629: goto -195 -> 5434
    //   5632: ldc 85
    //   5634: ldc_w 475
    //   5637: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5640: goto -206 -> 5434
    //   5643: astore 35
    //   5645: ldc 85
    //   5647: aload 35
    //   5649: ldc_w 621
    //   5652: iconst_0
    //   5653: anewarray 4	java/lang/Object
    //   5656: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5659: goto -215 -> 5444
    //   5662: astore 33
    //   5664: ldc 85
    //   5666: aload 33
    //   5668: ldc_w 467
    //   5671: iconst_0
    //   5672: anewarray 4	java/lang/Object
    //   5675: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5678: goto -224 -> 5454
    //   5681: astore 33
    //   5683: ldc 85
    //   5685: aload 33
    //   5687: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5690: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5693: goto -226 -> 5467
    //   5696: astore 36
    //   5698: ldc 85
    //   5700: aload 36
    //   5702: ldc_w 467
    //   5705: iconst_0
    //   5706: anewarray 4	java/lang/Object
    //   5709: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5712: goto -1358 -> 4354
    //   5715: lload 4
    //   5717: lconst_0
    //   5718: lcmp
    //   5719: ifeq +47 -> 5766
    //   5722: lload_2
    //   5723: lload 4
    //   5725: lcmp
    //   5726: ifeq +40 -> 5766
    //   5729: ldc 85
    //   5731: ldc_w 469
    //   5734: iconst_2
    //   5735: anewarray 4	java/lang/Object
    //   5738: dup
    //   5739: iconst_0
    //   5740: lload 4
    //   5742: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5745: aastore
    //   5746: dup
    //   5747: iconst_1
    //   5748: lload_2
    //   5749: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5752: aastore
    //   5753: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5756: aload_0
    //   5757: lload_2
    //   5758: lload 4
    //   5760: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   5763: goto -1384 -> 4379
    //   5766: lload 4
    //   5768: lconst_0
    //   5769: lcmp
    //   5770: ifeq +66 -> 5836
    //   5773: lload_2
    //   5774: lload 4
    //   5776: lcmp
    //   5777: ifne +59 -> 5836
    //   5780: ldc 85
    //   5782: ldc_w 473
    //   5785: iconst_2
    //   5786: anewarray 4	java/lang/Object
    //   5789: dup
    //   5790: iconst_0
    //   5791: lload 4
    //   5793: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5796: aastore
    //   5797: dup
    //   5798: iconst_1
    //   5799: lload_2
    //   5800: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5803: aastore
    //   5804: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5807: aload_0
    //   5808: lload 4
    //   5810: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   5813: lload_2
    //   5814: ldc2_w 392
    //   5817: lcmp
    //   5818: ifge -1439 -> 4379
    //   5821: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5824: dup
    //   5825: aload_0
    //   5826: iconst_1
    //   5827: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5830: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5833: goto -1454 -> 4379
    //   5836: ldc 85
    //   5838: ldc_w 475
    //   5841: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5844: goto -1465 -> 4379
    //   5847: astore 35
    //   5849: ldc 85
    //   5851: aload 35
    //   5853: ldc_w 621
    //   5856: iconst_0
    //   5857: anewarray 4	java/lang/Object
    //   5860: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5863: goto -1474 -> 4389
    //   5866: astore 33
    //   5868: ldc 85
    //   5870: aload 33
    //   5872: ldc_w 467
    //   5875: iconst_0
    //   5876: anewarray 4	java/lang/Object
    //   5879: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5882: goto -1483 -> 4399
    //   5885: astore 33
    //   5887: ldc 85
    //   5889: aload 33
    //   5891: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5894: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5897: goto -1485 -> 4412
    //   5900: astore 35
    //   5902: ldc 85
    //   5904: aload 35
    //   5906: ldc_w 467
    //   5909: iconst_0
    //   5910: anewarray 4	java/lang/Object
    //   5913: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5916: goto -751 -> 5165
    //   5919: lload 4
    //   5921: lconst_0
    //   5922: lcmp
    //   5923: ifeq +47 -> 5970
    //   5926: lload_2
    //   5927: lload 4
    //   5929: lcmp
    //   5930: ifeq +40 -> 5970
    //   5933: ldc 85
    //   5935: ldc_w 469
    //   5938: iconst_2
    //   5939: anewarray 4	java/lang/Object
    //   5942: dup
    //   5943: iconst_0
    //   5944: lload 4
    //   5946: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5949: aastore
    //   5950: dup
    //   5951: iconst_1
    //   5952: lload_2
    //   5953: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5956: aastore
    //   5957: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5960: aload_0
    //   5961: lload_2
    //   5962: lload 4
    //   5964: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   5967: goto -777 -> 5190
    //   5970: lload 4
    //   5972: lconst_0
    //   5973: lcmp
    //   5974: ifeq +66 -> 6040
    //   5977: lload_2
    //   5978: lload 4
    //   5980: lcmp
    //   5981: ifne +59 -> 6040
    //   5984: ldc 85
    //   5986: ldc_w 473
    //   5989: iconst_2
    //   5990: anewarray 4	java/lang/Object
    //   5993: dup
    //   5994: iconst_0
    //   5995: lload 4
    //   5997: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6000: aastore
    //   6001: dup
    //   6002: iconst_1
    //   6003: lload_2
    //   6004: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6007: aastore
    //   6008: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6011: aload_0
    //   6012: lload 4
    //   6014: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   6017: lload_2
    //   6018: ldc2_w 392
    //   6021: lcmp
    //   6022: ifge -832 -> 5190
    //   6025: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6028: dup
    //   6029: aload_0
    //   6030: iconst_1
    //   6031: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6034: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6037: goto -847 -> 5190
    //   6040: ldc 85
    //   6042: ldc_w 475
    //   6045: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6048: goto -858 -> 5190
    //   6051: astore 35
    //   6053: ldc 85
    //   6055: aload 35
    //   6057: ldc_w 621
    //   6060: iconst_0
    //   6061: anewarray 4	java/lang/Object
    //   6064: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6067: goto -867 -> 5200
    //   6070: astore 33
    //   6072: ldc 85
    //   6074: aload 33
    //   6076: ldc_w 467
    //   6079: iconst_0
    //   6080: anewarray 4	java/lang/Object
    //   6083: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6086: goto -876 -> 5210
    //   6089: astore 33
    //   6091: ldc 85
    //   6093: aload 33
    //   6095: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6098: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6101: goto -878 -> 5223
    //   6104: astore 35
    //   6106: aconst_null
    //   6107: astore 34
    //   6109: aload 42
    //   6111: astore 39
    //   6113: aload 38
    //   6115: astore 33
    //   6117: aload 35
    //   6119: astore 38
    //   6121: aload 33
    //   6123: astore 37
    //   6125: aload 34
    //   6127: astore 36
    //   6129: lload 4
    //   6131: lstore 8
    //   6133: lload_2
    //   6134: lstore 6
    //   6136: aload 39
    //   6138: astore 35
    //   6140: ldc 85
    //   6142: aload 38
    //   6144: ldc_w 609
    //   6147: iconst_1
    //   6148: anewarray 4	java/lang/Object
    //   6151: dup
    //   6152: iconst_0
    //   6153: aload 52
    //   6155: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   6158: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   6161: aastore
    //   6162: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6165: aload 33
    //   6167: astore 37
    //   6169: aload 34
    //   6171: astore 36
    //   6173: lload 4
    //   6175: lstore 8
    //   6177: lload_2
    //   6178: lstore 6
    //   6180: aload 39
    //   6182: astore 35
    //   6184: aload_0
    //   6185: sipush 752
    //   6188: putfield 59	com/tencent/mm/plugin/music/c/b:ddo	I
    //   6191: aload 33
    //   6193: astore 37
    //   6195: aload 34
    //   6197: astore 36
    //   6199: lload 4
    //   6201: lstore 8
    //   6203: lload_2
    //   6204: lstore 6
    //   6206: aload 39
    //   6208: astore 35
    //   6210: aload_0
    //   6211: iconst_5
    //   6212: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   6215: lload 4
    //   6217: lconst_0
    //   6218: lcmp
    //   6219: ifne +125 -> 6344
    //   6222: lload_2
    //   6223: lconst_0
    //   6224: lcmp
    //   6225: ifle +119 -> 6344
    //   6228: ldc 85
    //   6230: ldc_w 458
    //   6233: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6236: aload 33
    //   6238: lload_2
    //   6239: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   6242: aload_0
    //   6243: lload_2
    //   6244: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   6247: lload_2
    //   6248: ldc2_w 392
    //   6251: lcmp
    //   6252: ifge +15 -> 6267
    //   6255: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6258: dup
    //   6259: aload_0
    //   6260: iconst_1
    //   6261: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6264: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6267: aload 39
    //   6269: ifnull +8 -> 6277
    //   6272: aload 39
    //   6274: invokevirtual 139	java/io/InputStream:close	()V
    //   6277: aload 33
    //   6279: ifnull +8 -> 6287
    //   6282: aload 33
    //   6284: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   6287: aload 34
    //   6289: ifnull +16 -> 6305
    //   6292: aload 34
    //   6294: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6297: invokevirtual 139	java/io/InputStream:close	()V
    //   6300: aload 34
    //   6302: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   6305: aload_0
    //   6306: iconst_1
    //   6307: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6310: ldc 85
    //   6312: ldc_w 465
    //   6315: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6318: ldc_w 373
    //   6321: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6324: return
    //   6325: astore 35
    //   6327: ldc 85
    //   6329: aload 35
    //   6331: ldc_w 467
    //   6334: iconst_0
    //   6335: anewarray 4	java/lang/Object
    //   6338: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6341: goto -99 -> 6242
    //   6344: lload 4
    //   6346: lconst_0
    //   6347: lcmp
    //   6348: ifeq +47 -> 6395
    //   6351: lload_2
    //   6352: lload 4
    //   6354: lcmp
    //   6355: ifeq +40 -> 6395
    //   6358: ldc 85
    //   6360: ldc_w 469
    //   6363: iconst_2
    //   6364: anewarray 4	java/lang/Object
    //   6367: dup
    //   6368: iconst_0
    //   6369: lload 4
    //   6371: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6374: aastore
    //   6375: dup
    //   6376: iconst_1
    //   6377: lload_2
    //   6378: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6381: aastore
    //   6382: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6385: aload_0
    //   6386: lload_2
    //   6387: lload 4
    //   6389: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   6392: goto -125 -> 6267
    //   6395: lload 4
    //   6397: lconst_0
    //   6398: lcmp
    //   6399: ifeq +66 -> 6465
    //   6402: lload_2
    //   6403: lload 4
    //   6405: lcmp
    //   6406: ifne +59 -> 6465
    //   6409: ldc 85
    //   6411: ldc_w 473
    //   6414: iconst_2
    //   6415: anewarray 4	java/lang/Object
    //   6418: dup
    //   6419: iconst_0
    //   6420: lload 4
    //   6422: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6425: aastore
    //   6426: dup
    //   6427: iconst_1
    //   6428: lload_2
    //   6429: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6432: aastore
    //   6433: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6436: aload_0
    //   6437: lload 4
    //   6439: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   6442: lload_2
    //   6443: ldc2_w 392
    //   6446: lcmp
    //   6447: ifge -180 -> 6267
    //   6450: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6453: dup
    //   6454: aload_0
    //   6455: iconst_1
    //   6456: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6459: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6462: goto -195 -> 6267
    //   6465: ldc 85
    //   6467: ldc_w 475
    //   6470: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6473: goto -206 -> 6267
    //   6476: astore 35
    //   6478: ldc 85
    //   6480: aload 35
    //   6482: ldc_w 621
    //   6485: iconst_0
    //   6486: anewarray 4	java/lang/Object
    //   6489: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6492: goto -215 -> 6277
    //   6495: astore 33
    //   6497: ldc 85
    //   6499: aload 33
    //   6501: ldc_w 467
    //   6504: iconst_0
    //   6505: anewarray 4	java/lang/Object
    //   6508: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6511: goto -224 -> 6287
    //   6514: astore 33
    //   6516: ldc 85
    //   6518: aload 33
    //   6520: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6523: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6526: goto -226 -> 6300
    //   6529: astore 38
    //   6531: aconst_null
    //   6532: astore 34
    //   6534: aload 41
    //   6536: astore 39
    //   6538: aload 35
    //   6540: astore 33
    //   6542: aload 33
    //   6544: astore 37
    //   6546: aload 34
    //   6548: astore 36
    //   6550: lload 4
    //   6552: lstore 8
    //   6554: lload_2
    //   6555: lstore 6
    //   6557: aload 39
    //   6559: astore 35
    //   6561: ldc 85
    //   6563: aload 38
    //   6565: ldc_w 609
    //   6568: iconst_1
    //   6569: anewarray 4	java/lang/Object
    //   6572: dup
    //   6573: iconst_0
    //   6574: aload 52
    //   6576: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   6579: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   6582: aastore
    //   6583: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6586: aload 33
    //   6588: astore 37
    //   6590: aload 34
    //   6592: astore 36
    //   6594: lload 4
    //   6596: lstore 8
    //   6598: lload_2
    //   6599: lstore 6
    //   6601: aload 39
    //   6603: astore 35
    //   6605: aload_0
    //   6606: sipush 753
    //   6609: putfield 59	com/tencent/mm/plugin/music/c/b:ddo	I
    //   6612: aload 33
    //   6614: astore 37
    //   6616: aload 34
    //   6618: astore 36
    //   6620: lload 4
    //   6622: lstore 8
    //   6624: lload_2
    //   6625: lstore 6
    //   6627: aload 39
    //   6629: astore 35
    //   6631: aload_0
    //   6632: iconst_5
    //   6633: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   6636: lload 4
    //   6638: lconst_0
    //   6639: lcmp
    //   6640: ifne +125 -> 6765
    //   6643: lload_2
    //   6644: lconst_0
    //   6645: lcmp
    //   6646: ifle +119 -> 6765
    //   6649: ldc 85
    //   6651: ldc_w 458
    //   6654: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6657: aload 33
    //   6659: lload_2
    //   6660: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   6663: aload_0
    //   6664: lload_2
    //   6665: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   6668: lload_2
    //   6669: ldc2_w 392
    //   6672: lcmp
    //   6673: ifge +15 -> 6688
    //   6676: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6679: dup
    //   6680: aload_0
    //   6681: iconst_1
    //   6682: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6685: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6688: aload 39
    //   6690: ifnull +8 -> 6698
    //   6693: aload 39
    //   6695: invokevirtual 139	java/io/InputStream:close	()V
    //   6698: aload 33
    //   6700: ifnull +8 -> 6708
    //   6703: aload 33
    //   6705: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   6708: aload 34
    //   6710: ifnull +16 -> 6726
    //   6713: aload 34
    //   6715: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6718: invokevirtual 139	java/io/InputStream:close	()V
    //   6721: aload 34
    //   6723: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   6726: aload_0
    //   6727: iconst_1
    //   6728: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6731: ldc 85
    //   6733: ldc_w 465
    //   6736: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6739: ldc_w 373
    //   6742: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6745: return
    //   6746: astore 35
    //   6748: ldc 85
    //   6750: aload 35
    //   6752: ldc_w 467
    //   6755: iconst_0
    //   6756: anewarray 4	java/lang/Object
    //   6759: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6762: goto -99 -> 6663
    //   6765: lload 4
    //   6767: lconst_0
    //   6768: lcmp
    //   6769: ifeq +47 -> 6816
    //   6772: lload_2
    //   6773: lload 4
    //   6775: lcmp
    //   6776: ifeq +40 -> 6816
    //   6779: ldc 85
    //   6781: ldc_w 469
    //   6784: iconst_2
    //   6785: anewarray 4	java/lang/Object
    //   6788: dup
    //   6789: iconst_0
    //   6790: lload 4
    //   6792: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6795: aastore
    //   6796: dup
    //   6797: iconst_1
    //   6798: lload_2
    //   6799: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6802: aastore
    //   6803: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6806: aload_0
    //   6807: lload_2
    //   6808: lload 4
    //   6810: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   6813: goto -125 -> 6688
    //   6816: lload 4
    //   6818: lconst_0
    //   6819: lcmp
    //   6820: ifeq +66 -> 6886
    //   6823: lload_2
    //   6824: lload 4
    //   6826: lcmp
    //   6827: ifne +59 -> 6886
    //   6830: ldc 85
    //   6832: ldc_w 473
    //   6835: iconst_2
    //   6836: anewarray 4	java/lang/Object
    //   6839: dup
    //   6840: iconst_0
    //   6841: lload 4
    //   6843: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6846: aastore
    //   6847: dup
    //   6848: iconst_1
    //   6849: lload_2
    //   6850: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6853: aastore
    //   6854: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6857: aload_0
    //   6858: lload 4
    //   6860: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   6863: lload_2
    //   6864: ldc2_w 392
    //   6867: lcmp
    //   6868: ifge -180 -> 6688
    //   6871: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6874: dup
    //   6875: aload_0
    //   6876: iconst_1
    //   6877: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6880: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6883: goto -195 -> 6688
    //   6886: ldc 85
    //   6888: ldc_w 475
    //   6891: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6894: goto -206 -> 6688
    //   6897: astore 35
    //   6899: ldc 85
    //   6901: aload 35
    //   6903: ldc_w 621
    //   6906: iconst_0
    //   6907: anewarray 4	java/lang/Object
    //   6910: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6913: goto -215 -> 6698
    //   6916: astore 33
    //   6918: ldc 85
    //   6920: aload 33
    //   6922: ldc_w 467
    //   6925: iconst_0
    //   6926: anewarray 4	java/lang/Object
    //   6929: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6932: goto -224 -> 6708
    //   6935: astore 33
    //   6937: ldc 85
    //   6939: aload 33
    //   6941: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6944: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6947: goto -226 -> 6721
    //   6950: astore 39
    //   6952: aconst_null
    //   6953: astore 34
    //   6955: aload 44
    //   6957: astore 38
    //   6959: aload 37
    //   6961: astore 33
    //   6963: aload 33
    //   6965: astore 37
    //   6967: aload 34
    //   6969: astore 36
    //   6971: lload 4
    //   6973: lstore 8
    //   6975: lload_2
    //   6976: lstore 6
    //   6978: aload 38
    //   6980: astore 35
    //   6982: ldc 85
    //   6984: aload 39
    //   6986: ldc_w 609
    //   6989: iconst_1
    //   6990: anewarray 4	java/lang/Object
    //   6993: dup
    //   6994: iconst_0
    //   6995: aload 52
    //   6997: invokevirtual 442	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   7000: invokestatic 448	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   7003: aastore
    //   7004: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7007: aload 33
    //   7009: astore 37
    //   7011: aload 34
    //   7013: astore 36
    //   7015: lload 4
    //   7017: lstore 8
    //   7019: lload_2
    //   7020: lstore 6
    //   7022: aload 38
    //   7024: astore 35
    //   7026: aload_0
    //   7027: sipush 754
    //   7030: putfield 59	com/tencent/mm/plugin/music/c/b:ddo	I
    //   7033: aload 33
    //   7035: astore 37
    //   7037: aload 34
    //   7039: astore 36
    //   7041: lload 4
    //   7043: lstore 8
    //   7045: lload_2
    //   7046: lstore 6
    //   7048: aload 38
    //   7050: astore 35
    //   7052: aload_0
    //   7053: iconst_5
    //   7054: invokespecial 436	com/tencent/mm/plugin/music/c/b:Lh	(I)V
    //   7057: lload 4
    //   7059: lconst_0
    //   7060: lcmp
    //   7061: ifne +125 -> 7186
    //   7064: lload_2
    //   7065: lconst_0
    //   7066: lcmp
    //   7067: ifle +119 -> 7186
    //   7070: ldc 85
    //   7072: ldc_w 458
    //   7075: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7078: aload 33
    //   7080: lload_2
    //   7081: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   7084: aload_0
    //   7085: lload_2
    //   7086: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   7089: lload_2
    //   7090: ldc2_w 392
    //   7093: lcmp
    //   7094: ifge +15 -> 7109
    //   7097: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7100: dup
    //   7101: aload_0
    //   7102: iconst_1
    //   7103: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7106: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7109: aload 38
    //   7111: ifnull +8 -> 7119
    //   7114: aload 38
    //   7116: invokevirtual 139	java/io/InputStream:close	()V
    //   7119: aload 33
    //   7121: ifnull +8 -> 7129
    //   7124: aload 33
    //   7126: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   7129: aload 34
    //   7131: ifnull +16 -> 7147
    //   7134: aload 34
    //   7136: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7139: invokevirtual 139	java/io/InputStream:close	()V
    //   7142: aload 34
    //   7144: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   7147: aload_0
    //   7148: iconst_1
    //   7149: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   7152: ldc 85
    //   7154: ldc_w 465
    //   7157: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7160: ldc_w 373
    //   7163: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7166: return
    //   7167: astore 35
    //   7169: ldc 85
    //   7171: aload 35
    //   7173: ldc_w 467
    //   7176: iconst_0
    //   7177: anewarray 4	java/lang/Object
    //   7180: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7183: goto -99 -> 7084
    //   7186: lload 4
    //   7188: lconst_0
    //   7189: lcmp
    //   7190: ifeq +47 -> 7237
    //   7193: lload_2
    //   7194: lload 4
    //   7196: lcmp
    //   7197: ifeq +40 -> 7237
    //   7200: ldc 85
    //   7202: ldc_w 469
    //   7205: iconst_2
    //   7206: anewarray 4	java/lang/Object
    //   7209: dup
    //   7210: iconst_0
    //   7211: lload 4
    //   7213: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7216: aastore
    //   7217: dup
    //   7218: iconst_1
    //   7219: lload_2
    //   7220: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7223: aastore
    //   7224: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7227: aload_0
    //   7228: lload_2
    //   7229: lload 4
    //   7231: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   7234: goto -125 -> 7109
    //   7237: lload 4
    //   7239: lconst_0
    //   7240: lcmp
    //   7241: ifeq +66 -> 7307
    //   7244: lload_2
    //   7245: lload 4
    //   7247: lcmp
    //   7248: ifne +59 -> 7307
    //   7251: ldc 85
    //   7253: ldc_w 473
    //   7256: iconst_2
    //   7257: anewarray 4	java/lang/Object
    //   7260: dup
    //   7261: iconst_0
    //   7262: lload 4
    //   7264: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7267: aastore
    //   7268: dup
    //   7269: iconst_1
    //   7270: lload_2
    //   7271: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7274: aastore
    //   7275: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7278: aload_0
    //   7279: lload 4
    //   7281: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   7284: lload_2
    //   7285: ldc2_w 392
    //   7288: lcmp
    //   7289: ifge -180 -> 7109
    //   7292: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7295: dup
    //   7296: aload_0
    //   7297: iconst_1
    //   7298: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7301: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7304: goto -195 -> 7109
    //   7307: ldc 85
    //   7309: ldc_w 475
    //   7312: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7315: goto -206 -> 7109
    //   7318: astore 35
    //   7320: ldc 85
    //   7322: aload 35
    //   7324: ldc_w 621
    //   7327: iconst_0
    //   7328: anewarray 4	java/lang/Object
    //   7331: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7334: goto -215 -> 7119
    //   7337: astore 33
    //   7339: ldc 85
    //   7341: aload 33
    //   7343: ldc_w 467
    //   7346: iconst_0
    //   7347: anewarray 4	java/lang/Object
    //   7350: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7353: goto -224 -> 7129
    //   7356: astore 33
    //   7358: ldc 85
    //   7360: aload 33
    //   7362: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7365: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7368: goto -226 -> 7142
    //   7371: astore 33
    //   7373: aconst_null
    //   7374: astore 36
    //   7376: aload 46
    //   7378: astore 35
    //   7380: lload 4
    //   7382: lconst_0
    //   7383: lcmp
    //   7384: ifne +127 -> 7511
    //   7387: lload_2
    //   7388: lconst_0
    //   7389: lcmp
    //   7390: ifle +121 -> 7511
    //   7393: ldc 85
    //   7395: ldc_w 458
    //   7398: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7401: aload 34
    //   7403: lload_2
    //   7404: invokevirtual 551	java/io/RandomAccessFile:setLength	(J)V
    //   7407: aload_0
    //   7408: lload_2
    //   7409: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   7412: lload_2
    //   7413: ldc2_w 392
    //   7416: lcmp
    //   7417: ifge +15 -> 7432
    //   7420: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7423: dup
    //   7424: aload_0
    //   7425: iconst_1
    //   7426: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7429: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7432: aload 35
    //   7434: ifnull +8 -> 7442
    //   7437: aload 35
    //   7439: invokevirtual 139	java/io/InputStream:close	()V
    //   7442: aload 34
    //   7444: ifnull +8 -> 7452
    //   7447: aload 34
    //   7449: invokevirtual 552	java/io/RandomAccessFile:close	()V
    //   7452: aload 36
    //   7454: ifnull +16 -> 7470
    //   7457: aload 36
    //   7459: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7462: invokevirtual 139	java/io/InputStream:close	()V
    //   7465: aload 36
    //   7467: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   7470: aload_0
    //   7471: iconst_1
    //   7472: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   7475: ldc 85
    //   7477: ldc_w 465
    //   7480: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7483: ldc_w 373
    //   7486: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7489: aload 33
    //   7491: athrow
    //   7492: astore 37
    //   7494: ldc 85
    //   7496: aload 37
    //   7498: ldc_w 467
    //   7501: iconst_0
    //   7502: anewarray 4	java/lang/Object
    //   7505: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7508: goto -101 -> 7407
    //   7511: lload 4
    //   7513: lconst_0
    //   7514: lcmp
    //   7515: ifeq +47 -> 7562
    //   7518: lload_2
    //   7519: lload 4
    //   7521: lcmp
    //   7522: ifeq +40 -> 7562
    //   7525: ldc 85
    //   7527: ldc_w 469
    //   7530: iconst_2
    //   7531: anewarray 4	java/lang/Object
    //   7534: dup
    //   7535: iconst_0
    //   7536: lload 4
    //   7538: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7541: aastore
    //   7542: dup
    //   7543: iconst_1
    //   7544: lload_2
    //   7545: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7548: aastore
    //   7549: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7552: aload_0
    //   7553: lload_2
    //   7554: lload 4
    //   7556: invokespecial 471	com/tencent/mm/plugin/music/c/b:Z	(JJ)V
    //   7559: goto -127 -> 7432
    //   7562: lload 4
    //   7564: lconst_0
    //   7565: lcmp
    //   7566: ifeq +66 -> 7632
    //   7569: lload_2
    //   7570: lload 4
    //   7572: lcmp
    //   7573: ifne +59 -> 7632
    //   7576: ldc 85
    //   7578: ldc_w 473
    //   7581: iconst_2
    //   7582: anewarray 4	java/lang/Object
    //   7585: dup
    //   7586: iconst_0
    //   7587: lload 4
    //   7589: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7592: aastore
    //   7593: dup
    //   7594: iconst_1
    //   7595: lload_2
    //   7596: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7599: aastore
    //   7600: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7603: aload_0
    //   7604: lload 4
    //   7606: invokespecial 463	com/tencent/mm/plugin/music/c/b:yk	(J)V
    //   7609: lload_2
    //   7610: ldc2_w 392
    //   7613: lcmp
    //   7614: ifge -182 -> 7432
    //   7617: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7620: dup
    //   7621: aload_0
    //   7622: iconst_1
    //   7623: invokespecial 307	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7626: invokestatic 313	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7629: goto -197 -> 7432
    //   7632: ldc 85
    //   7634: ldc_w 475
    //   7637: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7640: goto -208 -> 7432
    //   7643: astore 35
    //   7645: ldc 85
    //   7647: aload 35
    //   7649: ldc_w 621
    //   7652: iconst_0
    //   7653: anewarray 4	java/lang/Object
    //   7656: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7659: goto -217 -> 7442
    //   7662: astore 34
    //   7664: ldc 85
    //   7666: aload 34
    //   7668: ldc_w 467
    //   7671: iconst_0
    //   7672: anewarray 4	java/lang/Object
    //   7675: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7678: goto -226 -> 7452
    //   7681: astore 34
    //   7683: ldc 85
    //   7685: aload 34
    //   7687: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7690: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7693: goto -228 -> 7465
    //   7696: astore 33
    //   7698: aload 37
    //   7700: astore 34
    //   7702: lload 8
    //   7704: lstore 4
    //   7706: lload 6
    //   7708: lstore_2
    //   7709: goto -329 -> 7380
    //   7712: astore 33
    //   7714: aload 39
    //   7716: astore 35
    //   7718: aload 37
    //   7720: astore 34
    //   7722: lload 20
    //   7724: lstore 4
    //   7726: lload 8
    //   7728: lstore_2
    //   7729: goto -349 -> 7380
    //   7732: astore 39
    //   7734: lload 28
    //   7736: lstore 4
    //   7738: lload 10
    //   7740: lstore_2
    //   7741: aload 44
    //   7743: astore 38
    //   7745: goto -782 -> 6963
    //   7748: astore 39
    //   7750: lload 14
    //   7752: lstore_2
    //   7753: aload 35
    //   7755: astore 38
    //   7757: goto -794 -> 6963
    //   7760: astore 38
    //   7762: lload 20
    //   7764: lstore 4
    //   7766: lload 16
    //   7768: lstore_2
    //   7769: aload 41
    //   7771: astore 39
    //   7773: goto -1231 -> 6542
    //   7776: astore 38
    //   7778: lload 12
    //   7780: lstore_2
    //   7781: aload 35
    //   7783: astore 39
    //   7785: goto -1243 -> 6542
    //   7788: astore 38
    //   7790: lload 26
    //   7792: lstore 4
    //   7794: lload 18
    //   7796: lstore_2
    //   7797: aload 42
    //   7799: astore 39
    //   7801: goto -1680 -> 6121
    //   7804: astore 38
    //   7806: lload 10
    //   7808: lstore_2
    //   7809: aload 35
    //   7811: astore 39
    //   7813: goto -1692 -> 6121
    //   7816: astore 38
    //   7818: aconst_null
    //   7819: astore 34
    //   7821: aload 39
    //   7823: astore 33
    //   7825: aload 43
    //   7827: astore 39
    //   7829: goto -2785 -> 5044
    //   7832: astore 38
    //   7834: lload 22
    //   7836: lstore 4
    //   7838: lload 12
    //   7840: lstore_2
    //   7841: aload 43
    //   7843: astore 39
    //   7845: goto -2801 -> 5044
    //   7848: astore 38
    //   7850: aconst_null
    //   7851: astore 35
    //   7853: aconst_null
    //   7854: astore 34
    //   7856: aload 36
    //   7858: astore 33
    //   7860: goto -3627 -> 4233
    //   7863: lload 30
    //   7865: lstore 6
    //   7867: lload 4
    //   7869: lstore_2
    //   7870: lload 6
    //   7872: lstore 4
    //   7874: ldc2_w 622
    //   7877: lstore 30
    //   7879: lload 4
    //   7881: lconst_0
    //   7882: lcmp
    //   7883: ifeq -4392 -> 3491
    //   7886: lload 4
    //   7888: lstore 30
    //   7890: goto -4399 -> 3491
    //   7893: astore 38
    //   7895: aconst_null
    //   7896: astore 35
    //   7898: lload 24
    //   7900: lstore 4
    //   7902: lload 14
    //   7904: lstore_2
    //   7905: goto -3672 -> 4233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7908	0	this	b
    //   180	5114	1	i	int
    //   167	7738	2	l1	long
    //   134	7767	4	l2	long
    //   125	7746	6	l3	long
    //   235	7492	8	l4	long
    //   1754	6053	10	l5	long
    //   1775	6064	12	l6	long
    //   1782	6121	14	l7	long
    //   1761	6006	16	l8	long
    //   1768	6027	18	l9	long
    //   1758	6005	20	l10	long
    //   1772	6063	22	l11	long
    //   1779	6120	24	l12	long
    //   1765	6026	26	l13	long
    //   1751	5984	28	l14	long
    //   3328	4561	30	l15	long
    //   32	1523	32	bool	boolean
    //   21	537	33	localObject1	Object
    //   811	5	33	localIOException1	java.io.IOException
    //   901	130	33	localObject2	Object
    //   1130	156	33	localIOException2	java.io.IOException
    //   1317	794	33	localRandomAccessFile	java.io.RandomAccessFile
    //   2304	5	33	localIOException3	java.io.IOException
    //   2323	2375	33	localException1	Exception
    //   4891	5	33	localIOException4	java.io.IOException
    //   4910	540	33	localException2	Exception
    //   5662	5	33	localIOException5	java.io.IOException
    //   5681	5	33	localException3	Exception
    //   5866	5	33	localIOException6	java.io.IOException
    //   5885	5	33	localException4	Exception
    //   6070	5	33	localIOException7	java.io.IOException
    //   6089	5	33	localException5	Exception
    //   6115	168	33	localObject3	Object
    //   6495	5	33	localIOException8	java.io.IOException
    //   6514	5	33	localException6	Exception
    //   6540	164	33	localObject4	Object
    //   6916	5	33	localIOException9	java.io.IOException
    //   6935	5	33	localException7	Exception
    //   6961	164	33	localObject5	Object
    //   7337	5	33	localIOException10	java.io.IOException
    //   7356	5	33	localException8	Exception
    //   7371	119	33	localObject6	Object
    //   7696	1	33	localObject7	Object
    //   7712	1	33	localObject8	Object
    //   7823	36	33	localObject9	Object
    //   24	7424	34	localObject10	Object
    //   7662	5	34	localIOException11	java.io.IOException
    //   7681	5	34	localException9	Exception
    //   7700	155	34	localObject11	Object
    //   50	1962	35	localObject12	Object
    //   2153	5	35	localIOException12	java.io.IOException
    //   2355	2243	35	localObject13	Object
    //   4740	298	35	localIOException13	java.io.IOException
    //   5061	379	35	localObject14	Object
    //   5643	5	35	localIOException14	java.io.IOException
    //   5847	5	35	localIOException15	java.io.IOException
    //   5900	5	35	localIOException16	java.io.IOException
    //   6051	5	35	localIOException17	java.io.IOException
    //   6104	14	35	localUnknownServiceException1	java.net.UnknownServiceException
    //   6138	71	35	localObject15	Object
    //   6325	5	35	localIOException18	java.io.IOException
    //   6476	63	35	localIOException19	java.io.IOException
    //   6559	71	35	localObject16	Object
    //   6746	5	35	localIOException20	java.io.IOException
    //   6897	5	35	localIOException21	java.io.IOException
    //   6980	71	35	localObject17	Object
    //   7167	5	35	localIOException22	java.io.IOException
    //   7318	5	35	localIOException23	java.io.IOException
    //   7378	60	35	localObject18	Object
    //   7643	5	35	localIOException24	java.io.IOException
    //   7716	181	35	localObject19	Object
    //   940	4403	36	localObject20	Object
    //   5492	5	36	localIOException25	java.io.IOException
    //   5696	5	36	localIOException26	java.io.IOException
    //   6127	1730	36	localObject21	Object
    //   928	6108	37	localObject22	Object
    //   7492	227	37	localIOException27	java.io.IOException
    //   920	3013	38	localObject23	Object
    //   4228	27	38	localProtocolException1	java.net.ProtocolException
    //   5035	1079	38	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   6119	24	38	localUnknownServiceException2	java.net.UnknownServiceException
    //   6529	35	38	localIOException28	java.io.IOException
    //   6957	799	38	localObject24	Object
    //   7760	1	38	localIOException29	java.io.IOException
    //   7776	1	38	localIOException30	java.io.IOException
    //   7788	1	38	localUnknownServiceException3	java.net.UnknownServiceException
    //   7804	1	38	localUnknownServiceException4	java.net.UnknownServiceException
    //   7816	1	38	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   7832	1	38	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   7848	1	38	localProtocolException2	java.net.ProtocolException
    //   7893	1	38	localProtocolException3	java.net.ProtocolException
    //   936	5758	39	localObject25	Object
    //   6950	765	39	localException10	Exception
    //   7732	1	39	localException11	Exception
    //   7748	1	39	localException12	Exception
    //   7771	73	39	localObject26	Object
    //   183	1544	40	localObject27	Object
    //   886	6884	41	localObject28	Object
    //   883	6915	42	localObject29	Object
    //   898	6944	43	localObject30	Object
    //   889	6853	44	localObject31	Object
    //   895	3701	45	localObject32	Object
    //   892	6485	46	localObject33	Object
    //   907	813	47	localHashMap	java.util.HashMap
    //   910	388	48	localObject34	Object
    //   916	366	49	localObject35	Object
    //   913	389	50	localObject36	Object
    //   904	386	51	localObject37	Object
    //   232	6764	52	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   248	271	811	java/io/IOException
    //   1077	1085	1130	java/io/IOException
    //   2074	2080	2153	java/io/IOException
    //   2110	2115	2304	java/io/IOException
    //   2120	2128	2323	java/lang/Exception
    //   3802	3809	4228	java/net/ProtocolException
    //   3843	3850	4228	java/net/ProtocolException
    //   3884	3892	4228	java/net/ProtocolException
    //   3930	3939	4228	java/net/ProtocolException
    //   3985	4013	4228	java/net/ProtocolException
    //   4053	4060	4228	java/net/ProtocolException
    //   4100	4109	4228	java/net/ProtocolException
    //   4149	4158	4228	java/net/ProtocolException
    //   4210	4222	4228	java/net/ProtocolException
    //   4974	4983	4228	java/net/ProtocolException
    //   5023	5032	4228	java/net/ProtocolException
    //   5282	5326	4228	java/net/ProtocolException
    //   5360	5382	4228	java/net/ProtocolException
    //   4661	4667	4740	java/io/IOException
    //   4697	4702	4891	java/io/IOException
    //   4707	4715	4910	java/lang/Exception
    //   3802	3809	5035	java/net/NoRouteToHostException
    //   3843	3850	5035	java/net/NoRouteToHostException
    //   3884	3892	5035	java/net/NoRouteToHostException
    //   3930	3939	5035	java/net/NoRouteToHostException
    //   3985	4013	5035	java/net/NoRouteToHostException
    //   4053	4060	5035	java/net/NoRouteToHostException
    //   4100	4109	5035	java/net/NoRouteToHostException
    //   4149	4158	5035	java/net/NoRouteToHostException
    //   4210	4222	5035	java/net/NoRouteToHostException
    //   4974	4983	5035	java/net/NoRouteToHostException
    //   5023	5032	5035	java/net/NoRouteToHostException
    //   5282	5326	5035	java/net/NoRouteToHostException
    //   5360	5382	5035	java/net/NoRouteToHostException
    //   5403	5409	5492	java/io/IOException
    //   5439	5444	5643	java/io/IOException
    //   5449	5454	5662	java/io/IOException
    //   5459	5467	5681	java/lang/Exception
    //   4348	4354	5696	java/io/IOException
    //   4384	4389	5847	java/io/IOException
    //   4394	4399	5866	java/io/IOException
    //   4404	4412	5885	java/lang/Exception
    //   5159	5165	5900	java/io/IOException
    //   5195	5200	6051	java/io/IOException
    //   5205	5210	6070	java/io/IOException
    //   5215	5223	6089	java/lang/Exception
    //   942	950	6104	java/net/UnknownServiceException
    //   974	979	6104	java/net/UnknownServiceException
    //   1003	1026	6104	java/net/UnknownServiceException
    //   1050	1056	6104	java/net/UnknownServiceException
    //   1305	1319	6104	java/net/UnknownServiceException
    //   1343	1360	6104	java/net/UnknownServiceException
    //   1384	1395	6104	java/net/UnknownServiceException
    //   1419	1433	6104	java/net/UnknownServiceException
    //   1464	1491	6104	java/net/UnknownServiceException
    //   1515	1554	6104	java/net/UnknownServiceException
    //   1583	1591	6104	java/net/UnknownServiceException
    //   1615	1623	6104	java/net/UnknownServiceException
    //   1647	1692	6104	java/net/UnknownServiceException
    //   1716	1726	6104	java/net/UnknownServiceException
    //   6236	6242	6325	java/io/IOException
    //   6272	6277	6476	java/io/IOException
    //   6282	6287	6495	java/io/IOException
    //   6292	6300	6514	java/lang/Exception
    //   942	950	6529	java/io/IOException
    //   974	979	6529	java/io/IOException
    //   1003	1026	6529	java/io/IOException
    //   1050	1056	6529	java/io/IOException
    //   1305	1319	6529	java/io/IOException
    //   1343	1360	6529	java/io/IOException
    //   1384	1395	6529	java/io/IOException
    //   1419	1433	6529	java/io/IOException
    //   1464	1491	6529	java/io/IOException
    //   1515	1554	6529	java/io/IOException
    //   1583	1591	6529	java/io/IOException
    //   1615	1623	6529	java/io/IOException
    //   1647	1692	6529	java/io/IOException
    //   1716	1726	6529	java/io/IOException
    //   6657	6663	6746	java/io/IOException
    //   6693	6698	6897	java/io/IOException
    //   6703	6708	6916	java/io/IOException
    //   6713	6721	6935	java/lang/Exception
    //   942	950	6950	java/lang/Exception
    //   974	979	6950	java/lang/Exception
    //   1003	1026	6950	java/lang/Exception
    //   1050	1056	6950	java/lang/Exception
    //   1305	1319	6950	java/lang/Exception
    //   1343	1360	6950	java/lang/Exception
    //   1384	1395	6950	java/lang/Exception
    //   1419	1433	6950	java/lang/Exception
    //   1464	1491	6950	java/lang/Exception
    //   1515	1554	6950	java/lang/Exception
    //   1583	1591	6950	java/lang/Exception
    //   1615	1623	6950	java/lang/Exception
    //   1647	1692	6950	java/lang/Exception
    //   1716	1726	6950	java/lang/Exception
    //   7078	7084	7167	java/io/IOException
    //   7114	7119	7318	java/io/IOException
    //   7124	7129	7337	java/io/IOException
    //   7134	7142	7356	java/lang/Exception
    //   942	950	7371	finally
    //   974	979	7371	finally
    //   1003	1026	7371	finally
    //   1050	1056	7371	finally
    //   1305	1319	7371	finally
    //   1343	1360	7371	finally
    //   1384	1395	7371	finally
    //   1419	1433	7371	finally
    //   1464	1491	7371	finally
    //   1515	1554	7371	finally
    //   1583	1591	7371	finally
    //   1615	1623	7371	finally
    //   1647	1692	7371	finally
    //   1716	1726	7371	finally
    //   7401	7407	7492	java/io/IOException
    //   7437	7442	7643	java/io/IOException
    //   7447	7452	7662	java/io/IOException
    //   7457	7465	7681	java/lang/Exception
    //   1784	1790	7696	finally
    //   1858	1862	7696	finally
    //   1916	1935	7696	finally
    //   1989	1994	7696	finally
    //   2048	2053	7696	finally
    //   2392	2411	7696	finally
    //   2465	2494	7696	finally
    //   2548	2555	7696	finally
    //   2609	2626	7696	finally
    //   2680	2686	7696	finally
    //   2740	2750	7696	finally
    //   2804	2817	7696	finally
    //   2871	2882	7696	finally
    //   2936	2945	7696	finally
    //   2999	3005	7696	finally
    //   3059	3065	7696	finally
    //   3119	3137	7696	finally
    //   3191	3201	7696	finally
    //   3255	3262	7696	finally
    //   3316	3330	7696	finally
    //   3384	3409	7696	finally
    //   3468	3476	7696	finally
    //   3545	3582	7696	finally
    //   3636	3643	7696	finally
    //   3697	3703	7696	finally
    //   3757	3764	7696	finally
    //   4491	4500	7696	finally
    //   4572	4580	7696	finally
    //   4634	4640	7696	finally
    //   5063	5088	7696	finally
    //   5107	5114	7696	finally
    //   5133	5138	7696	finally
    //   6140	6165	7696	finally
    //   6184	6191	7696	finally
    //   6210	6215	7696	finally
    //   6561	6586	7696	finally
    //   6605	6612	7696	finally
    //   6631	6636	7696	finally
    //   6982	7007	7696	finally
    //   7026	7033	7696	finally
    //   7052	7057	7696	finally
    //   3802	3809	7712	finally
    //   3843	3850	7712	finally
    //   3884	3892	7712	finally
    //   3930	3939	7712	finally
    //   3985	4013	7712	finally
    //   4053	4060	7712	finally
    //   4100	4109	7712	finally
    //   4149	4158	7712	finally
    //   4210	4222	7712	finally
    //   4252	4277	7712	finally
    //   4296	4303	7712	finally
    //   4322	4327	7712	finally
    //   4974	4983	7712	finally
    //   5023	5032	7712	finally
    //   5282	5326	7712	finally
    //   5360	5382	7712	finally
    //   1784	1790	7732	java/lang/Exception
    //   1858	1862	7732	java/lang/Exception
    //   1916	1935	7732	java/lang/Exception
    //   1989	1994	7732	java/lang/Exception
    //   2048	2053	7732	java/lang/Exception
    //   2392	2411	7732	java/lang/Exception
    //   2465	2494	7732	java/lang/Exception
    //   2548	2555	7732	java/lang/Exception
    //   2609	2626	7732	java/lang/Exception
    //   2680	2686	7732	java/lang/Exception
    //   2740	2750	7732	java/lang/Exception
    //   2804	2817	7732	java/lang/Exception
    //   2871	2882	7732	java/lang/Exception
    //   2936	2945	7732	java/lang/Exception
    //   2999	3005	7732	java/lang/Exception
    //   3059	3065	7732	java/lang/Exception
    //   3119	3137	7732	java/lang/Exception
    //   3191	3201	7732	java/lang/Exception
    //   3255	3262	7732	java/lang/Exception
    //   3316	3330	7732	java/lang/Exception
    //   3384	3409	7732	java/lang/Exception
    //   3468	3476	7732	java/lang/Exception
    //   3545	3582	7732	java/lang/Exception
    //   3636	3643	7732	java/lang/Exception
    //   3697	3703	7732	java/lang/Exception
    //   3757	3764	7732	java/lang/Exception
    //   4491	4500	7732	java/lang/Exception
    //   4572	4580	7732	java/lang/Exception
    //   4634	4640	7732	java/lang/Exception
    //   3802	3809	7748	java/lang/Exception
    //   3843	3850	7748	java/lang/Exception
    //   3884	3892	7748	java/lang/Exception
    //   3930	3939	7748	java/lang/Exception
    //   3985	4013	7748	java/lang/Exception
    //   4053	4060	7748	java/lang/Exception
    //   4100	4109	7748	java/lang/Exception
    //   4149	4158	7748	java/lang/Exception
    //   4210	4222	7748	java/lang/Exception
    //   4974	4983	7748	java/lang/Exception
    //   5023	5032	7748	java/lang/Exception
    //   5282	5326	7748	java/lang/Exception
    //   5360	5382	7748	java/lang/Exception
    //   1784	1790	7760	java/io/IOException
    //   1858	1862	7760	java/io/IOException
    //   1916	1935	7760	java/io/IOException
    //   1989	1994	7760	java/io/IOException
    //   2048	2053	7760	java/io/IOException
    //   2392	2411	7760	java/io/IOException
    //   2465	2494	7760	java/io/IOException
    //   2548	2555	7760	java/io/IOException
    //   2609	2626	7760	java/io/IOException
    //   2680	2686	7760	java/io/IOException
    //   2740	2750	7760	java/io/IOException
    //   2804	2817	7760	java/io/IOException
    //   2871	2882	7760	java/io/IOException
    //   2936	2945	7760	java/io/IOException
    //   2999	3005	7760	java/io/IOException
    //   3059	3065	7760	java/io/IOException
    //   3119	3137	7760	java/io/IOException
    //   3191	3201	7760	java/io/IOException
    //   3255	3262	7760	java/io/IOException
    //   3316	3330	7760	java/io/IOException
    //   3384	3409	7760	java/io/IOException
    //   3468	3476	7760	java/io/IOException
    //   3545	3582	7760	java/io/IOException
    //   3636	3643	7760	java/io/IOException
    //   3697	3703	7760	java/io/IOException
    //   3757	3764	7760	java/io/IOException
    //   4491	4500	7760	java/io/IOException
    //   4572	4580	7760	java/io/IOException
    //   4634	4640	7760	java/io/IOException
    //   3802	3809	7776	java/io/IOException
    //   3843	3850	7776	java/io/IOException
    //   3884	3892	7776	java/io/IOException
    //   3930	3939	7776	java/io/IOException
    //   3985	4013	7776	java/io/IOException
    //   4053	4060	7776	java/io/IOException
    //   4100	4109	7776	java/io/IOException
    //   4149	4158	7776	java/io/IOException
    //   4210	4222	7776	java/io/IOException
    //   4974	4983	7776	java/io/IOException
    //   5023	5032	7776	java/io/IOException
    //   5282	5326	7776	java/io/IOException
    //   5360	5382	7776	java/io/IOException
    //   1784	1790	7788	java/net/UnknownServiceException
    //   1858	1862	7788	java/net/UnknownServiceException
    //   1916	1935	7788	java/net/UnknownServiceException
    //   1989	1994	7788	java/net/UnknownServiceException
    //   2048	2053	7788	java/net/UnknownServiceException
    //   2392	2411	7788	java/net/UnknownServiceException
    //   2465	2494	7788	java/net/UnknownServiceException
    //   2548	2555	7788	java/net/UnknownServiceException
    //   2609	2626	7788	java/net/UnknownServiceException
    //   2680	2686	7788	java/net/UnknownServiceException
    //   2740	2750	7788	java/net/UnknownServiceException
    //   2804	2817	7788	java/net/UnknownServiceException
    //   2871	2882	7788	java/net/UnknownServiceException
    //   2936	2945	7788	java/net/UnknownServiceException
    //   2999	3005	7788	java/net/UnknownServiceException
    //   3059	3065	7788	java/net/UnknownServiceException
    //   3119	3137	7788	java/net/UnknownServiceException
    //   3191	3201	7788	java/net/UnknownServiceException
    //   3255	3262	7788	java/net/UnknownServiceException
    //   3316	3330	7788	java/net/UnknownServiceException
    //   3384	3409	7788	java/net/UnknownServiceException
    //   3468	3476	7788	java/net/UnknownServiceException
    //   3545	3582	7788	java/net/UnknownServiceException
    //   3636	3643	7788	java/net/UnknownServiceException
    //   3697	3703	7788	java/net/UnknownServiceException
    //   3757	3764	7788	java/net/UnknownServiceException
    //   4491	4500	7788	java/net/UnknownServiceException
    //   4572	4580	7788	java/net/UnknownServiceException
    //   4634	4640	7788	java/net/UnknownServiceException
    //   3802	3809	7804	java/net/UnknownServiceException
    //   3843	3850	7804	java/net/UnknownServiceException
    //   3884	3892	7804	java/net/UnknownServiceException
    //   3930	3939	7804	java/net/UnknownServiceException
    //   3985	4013	7804	java/net/UnknownServiceException
    //   4053	4060	7804	java/net/UnknownServiceException
    //   4100	4109	7804	java/net/UnknownServiceException
    //   4149	4158	7804	java/net/UnknownServiceException
    //   4210	4222	7804	java/net/UnknownServiceException
    //   4974	4983	7804	java/net/UnknownServiceException
    //   5023	5032	7804	java/net/UnknownServiceException
    //   5282	5326	7804	java/net/UnknownServiceException
    //   5360	5382	7804	java/net/UnknownServiceException
    //   942	950	7816	java/net/NoRouteToHostException
    //   974	979	7816	java/net/NoRouteToHostException
    //   1003	1026	7816	java/net/NoRouteToHostException
    //   1050	1056	7816	java/net/NoRouteToHostException
    //   1305	1319	7816	java/net/NoRouteToHostException
    //   1343	1360	7816	java/net/NoRouteToHostException
    //   1384	1395	7816	java/net/NoRouteToHostException
    //   1419	1433	7816	java/net/NoRouteToHostException
    //   1464	1491	7816	java/net/NoRouteToHostException
    //   1515	1554	7816	java/net/NoRouteToHostException
    //   1583	1591	7816	java/net/NoRouteToHostException
    //   1615	1623	7816	java/net/NoRouteToHostException
    //   1647	1692	7816	java/net/NoRouteToHostException
    //   1716	1726	7816	java/net/NoRouteToHostException
    //   1784	1790	7832	java/net/NoRouteToHostException
    //   1858	1862	7832	java/net/NoRouteToHostException
    //   1916	1935	7832	java/net/NoRouteToHostException
    //   1989	1994	7832	java/net/NoRouteToHostException
    //   2048	2053	7832	java/net/NoRouteToHostException
    //   2392	2411	7832	java/net/NoRouteToHostException
    //   2465	2494	7832	java/net/NoRouteToHostException
    //   2548	2555	7832	java/net/NoRouteToHostException
    //   2609	2626	7832	java/net/NoRouteToHostException
    //   2680	2686	7832	java/net/NoRouteToHostException
    //   2740	2750	7832	java/net/NoRouteToHostException
    //   2804	2817	7832	java/net/NoRouteToHostException
    //   2871	2882	7832	java/net/NoRouteToHostException
    //   2936	2945	7832	java/net/NoRouteToHostException
    //   2999	3005	7832	java/net/NoRouteToHostException
    //   3059	3065	7832	java/net/NoRouteToHostException
    //   3119	3137	7832	java/net/NoRouteToHostException
    //   3191	3201	7832	java/net/NoRouteToHostException
    //   3255	3262	7832	java/net/NoRouteToHostException
    //   3316	3330	7832	java/net/NoRouteToHostException
    //   3384	3409	7832	java/net/NoRouteToHostException
    //   3468	3476	7832	java/net/NoRouteToHostException
    //   3545	3582	7832	java/net/NoRouteToHostException
    //   3636	3643	7832	java/net/NoRouteToHostException
    //   3697	3703	7832	java/net/NoRouteToHostException
    //   3757	3764	7832	java/net/NoRouteToHostException
    //   4491	4500	7832	java/net/NoRouteToHostException
    //   4572	4580	7832	java/net/NoRouteToHostException
    //   4634	4640	7832	java/net/NoRouteToHostException
    //   942	950	7848	java/net/ProtocolException
    //   974	979	7848	java/net/ProtocolException
    //   1003	1026	7848	java/net/ProtocolException
    //   1050	1056	7848	java/net/ProtocolException
    //   1305	1319	7848	java/net/ProtocolException
    //   1343	1360	7848	java/net/ProtocolException
    //   1384	1395	7848	java/net/ProtocolException
    //   1419	1433	7848	java/net/ProtocolException
    //   1464	1491	7848	java/net/ProtocolException
    //   1515	1554	7848	java/net/ProtocolException
    //   1583	1591	7848	java/net/ProtocolException
    //   1615	1623	7848	java/net/ProtocolException
    //   1647	1692	7848	java/net/ProtocolException
    //   1716	1726	7848	java/net/ProtocolException
    //   1784	1790	7893	java/net/ProtocolException
    //   1858	1862	7893	java/net/ProtocolException
    //   1916	1935	7893	java/net/ProtocolException
    //   1989	1994	7893	java/net/ProtocolException
    //   2048	2053	7893	java/net/ProtocolException
    //   2392	2411	7893	java/net/ProtocolException
    //   2465	2494	7893	java/net/ProtocolException
    //   2548	2555	7893	java/net/ProtocolException
    //   2609	2626	7893	java/net/ProtocolException
    //   2680	2686	7893	java/net/ProtocolException
    //   2740	2750	7893	java/net/ProtocolException
    //   2804	2817	7893	java/net/ProtocolException
    //   2871	2882	7893	java/net/ProtocolException
    //   2936	2945	7893	java/net/ProtocolException
    //   2999	3005	7893	java/net/ProtocolException
    //   3059	3065	7893	java/net/ProtocolException
    //   3119	3137	7893	java/net/ProtocolException
    //   3191	3201	7893	java/net/ProtocolException
    //   3255	3262	7893	java/net/ProtocolException
    //   3316	3330	7893	java/net/ProtocolException
    //   3384	3409	7893	java/net/ProtocolException
    //   3468	3476	7893	java/net/ProtocolException
    //   3545	3582	7893	java/net/ProtocolException
    //   3636	3643	7893	java/net/ProtocolException
    //   3697	3703	7893	java/net/ProtocolException
    //   3757	3764	7893	java/net/ProtocolException
    //   4491	4500	7893	java/net/ProtocolException
    //   4572	4580	7893	java/net/ProtocolException
    //   4634	4640	7893	java/net/ProtocolException
  }
  
  public final void start()
  {
    AppMethodBeat.i(137217);
    if (!this.isStop)
    {
      AppMethodBeat.o(137217);
      return;
    }
    this.isStop = false;
    com.tencent.mm.sdk.g.b.c(this, "music_download_thread");
    AppMethodBeat.o(137217);
  }
  
  final class a
    implements Runnable
  {
    int action;
    
    a(int paramInt)
    {
      this.action = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(137215);
      if (b.this.wjR != null) {
        b.this.wjR.Li(this.action);
      }
      AppMethodBeat.o(137215);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Li(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b
 * JD-Core Version:    0.7.0.1
 */