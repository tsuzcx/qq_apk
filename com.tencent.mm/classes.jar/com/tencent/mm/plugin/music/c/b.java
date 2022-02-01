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
  public int cUB;
  public boolean isStop;
  public String mimeType;
  public boolean qbG;
  private String tVH;
  public f tVI;
  public a tVJ;
  public float tVK;
  private long tVL;
  public int tVM;
  public b tVN;
  
  public b(f paramf, a parama)
  {
    AppMethodBeat.i(137216);
    this.tVH = null;
    this.tVL = 307200L;
    this.isStop = true;
    this.mimeType = "";
    this.tVM = -1;
    this.cUB = 0;
    this.tVI = paramf;
    this.tVJ = parama;
    int i;
    int j;
    if ((parama.tVC == 0L) && (parama.tVD == 0L) && (parama.endFlag == 0))
    {
      i = 1;
      if ((parama.tVE != 0L) || (parama.tVG != 0L) || (parama.tVF != 0)) {
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
      this.qbG = ay.isWifi(aj.getContext());
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
  
  private static void HF(int paramInt)
  {
    AppMethodBeat.i(137220);
    d locald = (d)com.tencent.mm.plugin.music.f.c.b.aP(d.class);
    if (locald != null) {
      locald.HK(paramInt);
    }
    AppMethodBeat.o(137220);
  }
  
  private void HG(int paramInt)
  {
    AppMethodBeat.i(137221);
    this.tVH = null;
    aq.f(new a(paramInt));
    AppMethodBeat.o(137221);
  }
  
  private void ab(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(137223);
    if (this.qbG)
    {
      this.tVJ.tVE = paramLong1;
      this.tVJ.tVF = 0;
      this.tVJ.tVG = paramLong2;
      e.a(this.tVI.hnp, this.tVJ);
    }
    for (;;)
    {
      aq.f(new a(3));
      AppMethodBeat.o(137223);
      return;
      this.tVJ.tVC = paramLong1;
      this.tVJ.endFlag = 0;
      this.tVJ.tVD = paramLong2;
      e.a(this.tVI.hnp, this.tVJ);
    }
  }
  
  private static long[] aiF(String paramString)
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
  
  private void ry(long paramLong)
  {
    AppMethodBeat.i(137222);
    if (this.qbG)
    {
      this.tVJ.tVE = paramLong;
      this.tVJ.tVF = 1;
      this.tVJ.tVG = paramLong;
      e.a(this.tVI.hnp, this.tVJ);
    }
    for (;;)
    {
      aq.f(new a(2));
      AppMethodBeat.o(137222);
      return;
      this.tVJ.tVC = paramLong;
      this.tVJ.endFlag = 1;
      this.tVJ.tVD = paramLong;
      e.a(this.tVI.hnp, this.tVJ);
    }
  }
  
  private HttpURLConnection z(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137219);
    Object localObject1;
    if (!TextUtils.isEmpty(this.tVH))
    {
      ad.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.tVH;
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
          Object localObject2 = k.cVi().tWk;
          localObject1 = new URL(paramString);
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.plugin.music.e.a)localObject2).aiH(paramString);
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
            HF(j);
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
            this.tVH = paramString;
          }
          else
          {
            if ((j != 200) && (j != 206)) {
              this.tVH = null;
            }
            AppMethodBeat.o(137219);
            return localObject1;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 374
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   10: ifeq +10 -> 20
    //   13: ldc_w 374
    //   16: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aconst_null
    //   21: astore 34
    //   23: aconst_null
    //   24: astore 33
    //   26: invokestatic 99	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   29: invokestatic 377	com/tencent/mm/sdk/platformtools/ay:isNetworkConnected	(Landroid/content/Context;)Z
    //   32: istore 32
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 59	com/tencent/mm/plugin/music/c/b:cUB	I
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 57	com/tencent/mm/plugin/music/c/b:tVM	I
    //   44: invokestatic 232	com/tencent/mm/plugin/music/e/k:cVi	()Lcom/tencent/mm/plugin/music/e/k;
    //   47: getfield 236	com/tencent/mm/plugin/music/e/k:tWk	Lcom/tencent/mm/plugin/music/e/a;
    //   50: astore 35
    //   52: iload 32
    //   54: ifeq +510 -> 564
    //   57: aload_0
    //   58: getfield 107	com/tencent/mm/plugin/music/c/b:qbG	Z
    //   61: ifeq +358 -> 419
    //   64: aload_0
    //   65: getfield 61	com/tencent/mm/plugin/music/c/b:tVI	Lcom/tencent/mm/az/f;
    //   68: getfield 380	com/tencent/mm/az/f:playUrl	Ljava/lang/String;
    //   71: invokestatic 385	com/tencent/mm/plugin/music/cache/g:aiv	(Ljava/lang/String;)Z
    //   74: istore 32
    //   76: aload 35
    //   78: ifnull +19 -> 97
    //   81: aload 35
    //   83: aload_0
    //   84: getfield 61	com/tencent/mm/plugin/music/c/b:tVI	Lcom/tencent/mm/az/f;
    //   87: getfield 380	com/tencent/mm/az/f:playUrl	Ljava/lang/String;
    //   90: invokeinterface 388 2 0
    //   95: astore 33
    //   97: ldc 85
    //   99: ldc_w 390
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload 33
    //   110: aastore
    //   111: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   118: getfield 77	com/tencent/mm/plugin/music/c/a:tVE	J
    //   121: lstore 6
    //   123: aload_0
    //   124: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   127: getfield 80	com/tencent/mm/plugin/music/c/a:tVG	J
    //   130: lstore 4
    //   132: lload 4
    //   134: lconst_0
    //   135: lcmp
    //   136: ifeq +13 -> 149
    //   139: aload_0
    //   140: lload 4
    //   142: ldc2_w 391
    //   145: ldiv
    //   146: putfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   149: lload 6
    //   151: aload_0
    //   152: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   155: lcmp
    //   156: ifge +233 -> 389
    //   159: aload_0
    //   160: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   163: lstore_2
    //   164: aload_0
    //   165: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   168: getfield 83	com/tencent/mm/plugin/music/c/a:tVF	I
    //   171: iconst_1
    //   172: if_icmpne +238 -> 410
    //   175: iconst_1
    //   176: istore_1
    //   177: aload 33
    //   179: astore 40
    //   181: aload_0
    //   182: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   185: ldc2_w 393
    //   188: lcmp
    //   189: ifge +18 -> 207
    //   192: aload_0
    //   193: ldc2_w 393
    //   196: putfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   199: ldc 85
    //   201: ldc_w 396
    //   204: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: new 398	com/tencent/mm/vfs/e
    //   210: dup
    //   211: aload_0
    //   212: getfield 61	com/tencent/mm/plugin/music/c/b:tVI	Lcom/tencent/mm/az/f;
    //   215: getfield 147	com/tencent/mm/az/f:hnp	Ljava/lang/String;
    //   218: aload_0
    //   219: getfield 107	com/tencent/mm/plugin/music/c/b:qbG	Z
    //   222: invokestatic 404	com/tencent/mm/plugin/music/h/b:bl	(Ljava/lang/String;Z)Ljava/lang/String;
    //   225: invokespecial 405	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   228: astore 52
    //   230: lload_2
    //   231: lstore 8
    //   233: lload 6
    //   235: lstore_2
    //   236: aload 52
    //   238: invokevirtual 408	com/tencent/mm/vfs/e:exists	()Z
    //   241: ifne +56 -> 297
    //   244: ldc 85
    //   246: ldc_w 410
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 52
    //   257: invokevirtual 413	com/tencent/mm/vfs/e:createNewFile	()Z
    //   260: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   263: aastore
    //   264: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: lconst_0
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   273: lstore 8
    //   275: iconst_0
    //   276: istore_1
    //   277: ldc 85
    //   279: ldc_w 420
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: lload 8
    //   290: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   293: aastore
    //   294: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: ldc 85
    //   299: ldc_w 425
    //   302: iconst_3
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: lload_2
    //   309: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: aload 52
    //   317: invokevirtual 428	com/tencent/mm/vfs/e:length	()J
    //   320: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: dup
    //   325: iconst_2
    //   326: lload 8
    //   328: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: aastore
    //   332: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: lload_2
    //   336: aload_0
    //   337: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   340: lcmp
    //   341: iflt +12 -> 353
    //   344: aload_0
    //   345: getfield 430	com/tencent/mm/plugin/music/c/b:tVK	F
    //   348: fconst_0
    //   349: fcmpl
    //   350: ifeq +7 -> 357
    //   353: iload_1
    //   354: ifeq +487 -> 841
    //   357: ldc 85
    //   359: ldc_w 432
    //   362: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: iconst_1
    //   367: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   370: new 8	com/tencent/mm/plugin/music/c/b$a
    //   373: dup
    //   374: aload_0
    //   375: iconst_1
    //   376: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   379: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   382: ldc_w 374
    //   385: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: return
    //   389: lload 6
    //   391: l2f
    //   392: ldc_w 433
    //   395: aload_0
    //   396: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   399: getfield 80	com/tencent/mm/plugin/music/c/a:tVG	J
    //   402: l2f
    //   403: fmul
    //   404: fadd
    //   405: f2l
    //   406: lstore_2
    //   407: goto -243 -> 164
    //   410: iconst_0
    //   411: istore_1
    //   412: aload 33
    //   414: astore 40
    //   416: goto -235 -> 181
    //   419: aload 34
    //   421: astore 33
    //   423: aload 35
    //   425: ifnull +19 -> 444
    //   428: aload 35
    //   430: aload_0
    //   431: getfield 61	com/tencent/mm/plugin/music/c/b:tVI	Lcom/tencent/mm/az/f;
    //   434: getfield 380	com/tencent/mm/az/f:playUrl	Ljava/lang/String;
    //   437: invokeinterface 388 2 0
    //   442: astore 33
    //   444: ldc 85
    //   446: ldc_w 390
    //   449: iconst_1
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload 33
    //   457: aastore
    //   458: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   461: iconst_0
    //   462: istore 32
    //   464: aload_0
    //   465: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   468: getfield 68	com/tencent/mm/plugin/music/c/a:tVC	J
    //   471: lstore 6
    //   473: aload_0
    //   474: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   477: getfield 71	com/tencent/mm/plugin/music/c/a:tVD	J
    //   480: lstore 4
    //   482: lload 4
    //   484: lconst_0
    //   485: lcmp
    //   486: ifeq +13 -> 499
    //   489: aload_0
    //   490: lload 4
    //   492: ldc2_w 391
    //   495: ldiv
    //   496: putfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   499: lload 6
    //   501: aload_0
    //   502: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   505: lcmp
    //   506: ifge +28 -> 534
    //   509: aload_0
    //   510: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   513: lstore_2
    //   514: aload_0
    //   515: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   518: getfield 74	com/tencent/mm/plugin/music/c/a:endFlag	I
    //   521: iconst_1
    //   522: if_icmpne +33 -> 555
    //   525: iconst_1
    //   526: istore_1
    //   527: aload 33
    //   529: astore 40
    //   531: goto -350 -> 181
    //   534: lload 6
    //   536: l2f
    //   537: ldc_w 433
    //   540: aload_0
    //   541: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   544: getfield 71	com/tencent/mm/plugin/music/c/a:tVD	J
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
    //   561: goto -380 -> 181
    //   564: aload_0
    //   565: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   568: getfield 77	com/tencent/mm/plugin/music/c/a:tVE	J
    //   571: lconst_0
    //   572: lcmp
    //   573: ifeq +102 -> 675
    //   576: aload_0
    //   577: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   580: getfield 77	com/tencent/mm/plugin/music/c/a:tVE	J
    //   583: aload_0
    //   584: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   587: lcmp
    //   588: ifge +21 -> 609
    //   591: aload_0
    //   592: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   595: getfield 77	com/tencent/mm/plugin/music/c/a:tVE	J
    //   598: aload_0
    //   599: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   602: getfield 80	com/tencent/mm/plugin/music/c/a:tVG	J
    //   605: lcmp
    //   606: ifne +69 -> 675
    //   609: aload_0
    //   610: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   613: getfield 77	com/tencent/mm/plugin/music/c/a:tVE	J
    //   616: l2f
    //   617: aload_0
    //   618: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   621: getfield 80	com/tencent/mm/plugin/music/c/a:tVG	J
    //   624: l2f
    //   625: fdiv
    //   626: aload_0
    //   627: getfield 430	com/tencent/mm/plugin/music/c/b:tVK	F
    //   630: fsub
    //   631: ldc_w 433
    //   634: fcmpl
    //   635: iflt +40 -> 675
    //   638: ldc 85
    //   640: ldc_w 432
    //   643: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 107	com/tencent/mm/plugin/music/c/b:qbG	Z
    //   656: new 8	com/tencent/mm/plugin/music/c/b$a
    //   659: dup
    //   660: aload_0
    //   661: iconst_1
    //   662: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   665: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   668: ldc_w 374
    //   671: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: return
    //   675: aload_0
    //   676: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   679: getfield 68	com/tencent/mm/plugin/music/c/a:tVC	J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifeq +102 -> 786
    //   687: aload_0
    //   688: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   691: getfield 68	com/tencent/mm/plugin/music/c/a:tVC	J
    //   694: aload_0
    //   695: getfield 49	com/tencent/mm/plugin/music/c/b:tVL	J
    //   698: lcmp
    //   699: ifge +21 -> 720
    //   702: aload_0
    //   703: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   706: getfield 68	com/tencent/mm/plugin/music/c/a:tVC	J
    //   709: aload_0
    //   710: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   713: getfield 71	com/tencent/mm/plugin/music/c/a:tVD	J
    //   716: lcmp
    //   717: ifne +69 -> 786
    //   720: aload_0
    //   721: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   724: getfield 68	com/tencent/mm/plugin/music/c/a:tVC	J
    //   727: l2f
    //   728: aload_0
    //   729: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   732: getfield 71	com/tencent/mm/plugin/music/c/a:tVD	J
    //   735: l2f
    //   736: fdiv
    //   737: aload_0
    //   738: getfield 430	com/tencent/mm/plugin/music/c/b:tVK	F
    //   741: fsub
    //   742: ldc_w 433
    //   745: fcmpl
    //   746: iflt +40 -> 786
    //   749: ldc 85
    //   751: ldc_w 432
    //   754: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_0
    //   758: iconst_1
    //   759: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   762: aload_0
    //   763: iconst_0
    //   764: putfield 107	com/tencent/mm/plugin/music/c/b:qbG	Z
    //   767: new 8	com/tencent/mm/plugin/music/c/b$a
    //   770: dup
    //   771: aload_0
    //   772: iconst_1
    //   773: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   776: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   779: ldc_w 374
    //   782: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: return
    //   786: ldc 85
    //   788: ldc_w 435
    //   791: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_0
    //   795: iconst_1
    //   796: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   799: aload_0
    //   800: iconst_4
    //   801: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   804: ldc_w 374
    //   807: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   810: return
    //   811: astore 33
    //   813: ldc 85
    //   815: aload 33
    //   817: ldc_w 439
    //   820: iconst_1
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 52
    //   828: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   831: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   834: aastore
    //   835: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   838: goto -571 -> 267
    //   841: aload 40
    //   843: invokestatic 163	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   846: ifeq +36 -> 882
    //   849: ldc 85
    //   851: ldc_w 455
    //   854: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: aload_0
    //   858: iconst_1
    //   859: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   862: new 8	com/tencent/mm/plugin/music/c/b$a
    //   865: dup
    //   866: aload_0
    //   867: bipush 254
    //   869: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   872: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   875: ldc_w 374
    //   878: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: aconst_null
    //   883: astore 44
    //   885: aconst_null
    //   886: astore 42
    //   888: aconst_null
    //   889: astore 43
    //   891: aconst_null
    //   892: astore 46
    //   894: aconst_null
    //   895: astore 45
    //   897: aconst_null
    //   898: astore 41
    //   900: aconst_null
    //   901: astore 49
    //   903: aconst_null
    //   904: astore 47
    //   906: aconst_null
    //   907: astore 51
    //   909: aconst_null
    //   910: astore 48
    //   912: aconst_null
    //   913: astore 50
    //   915: aconst_null
    //   916: astore 33
    //   918: aload 33
    //   920: astore 37
    //   922: aload 49
    //   924: astore 38
    //   926: aload 47
    //   928: astore 35
    //   930: aload 51
    //   932: astore 36
    //   934: aload 48
    //   936: astore 39
    //   938: aload 50
    //   940: astore 34
    //   942: aload 52
    //   944: invokevirtual 408	com/tencent/mm/vfs/e:exists	()Z
    //   947: ifne +334 -> 1281
    //   950: aload 33
    //   952: astore 37
    //   954: aload 49
    //   956: astore 38
    //   958: aload 47
    //   960: astore 35
    //   962: aload 51
    //   964: astore 36
    //   966: aload 48
    //   968: astore 39
    //   970: aload 50
    //   972: astore 34
    //   974: aload_0
    //   975: iconst_1
    //   976: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   979: aload 33
    //   981: astore 37
    //   983: aload 49
    //   985: astore 38
    //   987: aload 47
    //   989: astore 35
    //   991: aload 51
    //   993: astore 36
    //   995: aload 48
    //   997: astore 39
    //   999: aload 50
    //   1001: astore 34
    //   1003: ldc 85
    //   1005: ldc_w 457
    //   1008: iconst_1
    //   1009: anewarray 4	java/lang/Object
    //   1012: dup
    //   1013: iconst_0
    //   1014: aload 52
    //   1016: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   1019: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   1022: aastore
    //   1023: invokestatic 331	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1026: aload 33
    //   1028: astore 37
    //   1030: aload 49
    //   1032: astore 38
    //   1034: aload 47
    //   1036: astore 35
    //   1038: aload 51
    //   1040: astore 36
    //   1042: aload 48
    //   1044: astore 39
    //   1046: aload 50
    //   1048: astore 34
    //   1050: aload_0
    //   1051: bipush 19
    //   1053: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   1056: lload 4
    //   1058: lconst_0
    //   1059: lcmp
    //   1060: ifne +89 -> 1149
    //   1063: lload_2
    //   1064: lconst_0
    //   1065: lcmp
    //   1066: ifle +83 -> 1149
    //   1069: ldc 85
    //   1071: ldc_w 459
    //   1074: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1077: new 461	java/lang/NullPointerException
    //   1080: dup
    //   1081: invokespecial 462	java/lang/NullPointerException:<init>	()V
    //   1084: athrow
    //   1085: aload_0
    //   1086: lload_2
    //   1087: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   1090: lload_2
    //   1091: ldc2_w 393
    //   1094: lcmp
    //   1095: ifge +15 -> 1110
    //   1098: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1101: dup
    //   1102: aload_0
    //   1103: iconst_1
    //   1104: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1107: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   1110: aload_0
    //   1111: iconst_1
    //   1112: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   1115: ldc 85
    //   1117: ldc_w 466
    //   1120: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: ldc_w 374
    //   1126: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1129: return
    //   1130: astore 33
    //   1132: ldc 85
    //   1134: aload 33
    //   1136: ldc_w 468
    //   1139: iconst_0
    //   1140: anewarray 4	java/lang/Object
    //   1143: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1165: ldc_w 470
    //   1168: iconst_2
    //   1169: anewarray 4	java/lang/Object
    //   1172: dup
    //   1173: iconst_0
    //   1174: lload 4
    //   1176: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_1
    //   1182: lload_2
    //   1183: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1186: aastore
    //   1187: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1190: aload_0
    //   1191: lload_2
    //   1192: lload 4
    //   1194: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
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
    //   1216: ldc_w 474
    //   1219: iconst_2
    //   1220: anewarray 4	java/lang/Object
    //   1223: dup
    //   1224: iconst_0
    //   1225: lload 4
    //   1227: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_1
    //   1233: lload_2
    //   1234: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1237: aastore
    //   1238: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1241: aload_0
    //   1242: lload 4
    //   1244: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   1247: lload_2
    //   1248: ldc2_w 393
    //   1251: lcmp
    //   1252: ifge -142 -> 1110
    //   1255: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1258: dup
    //   1259: aload_0
    //   1260: iconst_1
    //   1261: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1264: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   1267: goto -157 -> 1110
    //   1270: ldc 85
    //   1272: ldc_w 476
    //   1275: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1278: goto -168 -> 1110
    //   1281: aload 33
    //   1283: astore 37
    //   1285: aload 49
    //   1287: astore 38
    //   1289: aload 47
    //   1291: astore 35
    //   1293: aload 51
    //   1295: astore 36
    //   1297: aload 48
    //   1299: astore 39
    //   1301: aload 50
    //   1303: astore 34
    //   1305: aload 52
    //   1307: getfield 480	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   1310: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   1313: iconst_1
    //   1314: invokestatic 486	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   1317: astore 33
    //   1319: aload 33
    //   1321: astore 37
    //   1323: aload 33
    //   1325: astore 38
    //   1327: aload 33
    //   1329: astore 35
    //   1331: aload 33
    //   1333: astore 36
    //   1335: aload 33
    //   1337: astore 39
    //   1339: aload 33
    //   1341: astore 34
    //   1343: ldc 85
    //   1345: ldc_w 488
    //   1348: iconst_1
    //   1349: anewarray 4	java/lang/Object
    //   1352: dup
    //   1353: iconst_0
    //   1354: aload 40
    //   1356: aastore
    //   1357: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1360: aload 33
    //   1362: astore 37
    //   1364: aload 33
    //   1366: astore 38
    //   1368: aload 33
    //   1370: astore 35
    //   1372: aload 33
    //   1374: astore 36
    //   1376: aload 33
    //   1378: astore 39
    //   1380: aload 33
    //   1382: astore 34
    //   1384: new 490	java/util/HashMap
    //   1387: dup
    //   1388: bipush 10
    //   1390: invokespecial 492	java/util/HashMap:<init>	(I)V
    //   1393: astore 47
    //   1395: aload 33
    //   1397: astore 37
    //   1399: aload 33
    //   1401: astore 38
    //   1403: aload 33
    //   1405: astore 35
    //   1407: aload 33
    //   1409: astore 36
    //   1411: aload 33
    //   1413: astore 39
    //   1415: aload 33
    //   1417: astore 34
    //   1419: aload 47
    //   1421: ldc_w 494
    //   1424: ldc_w 496
    //   1427: invokeinterface 500 3 0
    //   1432: pop
    //   1433: lload 8
    //   1435: lload_2
    //   1436: lcmp
    //   1437: ifle +116 -> 1553
    //   1440: aload 33
    //   1442: astore 37
    //   1444: aload 33
    //   1446: astore 38
    //   1448: aload 33
    //   1450: astore 35
    //   1452: aload 33
    //   1454: astore 36
    //   1456: aload 33
    //   1458: astore 39
    //   1460: aload 33
    //   1462: astore 34
    //   1464: ldc 85
    //   1466: ldc_w 502
    //   1469: iconst_2
    //   1470: anewarray 4	java/lang/Object
    //   1473: dup
    //   1474: iconst_0
    //   1475: lload_2
    //   1476: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1479: aastore
    //   1480: dup
    //   1481: iconst_1
    //   1482: lload 8
    //   1484: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1487: aastore
    //   1488: invokestatic 505	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1491: aload 33
    //   1493: astore 37
    //   1495: aload 33
    //   1497: astore 38
    //   1499: aload 33
    //   1501: astore 35
    //   1503: aload 33
    //   1505: astore 36
    //   1507: aload 33
    //   1509: astore 39
    //   1511: aload 33
    //   1513: astore 34
    //   1515: aload 47
    //   1517: ldc_w 507
    //   1520: new 509	java/lang/StringBuilder
    //   1523: dup
    //   1524: ldc_w 511
    //   1527: invokespecial 512	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1530: lload_2
    //   1531: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1534: ldc 177
    //   1536: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: lload 8
    //   1541: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1544: invokevirtual 520	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1547: invokeinterface 500 3 0
    //   1552: pop
    //   1553: iload 32
    //   1555: ifne +35 -> 1590
    //   1558: aload 33
    //   1560: astore 37
    //   1562: aload 33
    //   1564: astore 38
    //   1566: aload 33
    //   1568: astore 35
    //   1570: aload 33
    //   1572: astore 36
    //   1574: aload 33
    //   1576: astore 39
    //   1578: aload 33
    //   1580: astore 34
    //   1582: aload 40
    //   1584: invokestatic 525	com/tencent/mm/plugin/music/h/e:aiW	(Ljava/lang/String;)Z
    //   1587: ifeq +35 -> 1622
    //   1590: aload 33
    //   1592: astore 37
    //   1594: aload 33
    //   1596: astore 38
    //   1598: aload 33
    //   1600: astore 35
    //   1602: aload 33
    //   1604: astore 36
    //   1606: aload 33
    //   1608: astore 39
    //   1610: aload 33
    //   1612: astore 34
    //   1614: ldc 85
    //   1616: ldc_w 527
    //   1619: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1622: aload 33
    //   1624: astore 37
    //   1626: aload 33
    //   1628: astore 38
    //   1630: aload 33
    //   1632: astore 35
    //   1634: aload 33
    //   1636: astore 36
    //   1638: aload 33
    //   1640: astore 39
    //   1642: aload 33
    //   1644: astore 34
    //   1646: aload 47
    //   1648: ldc_w 529
    //   1651: new 509	java/lang/StringBuilder
    //   1654: dup
    //   1655: invokespecial 530	java/lang/StringBuilder:<init>	()V
    //   1658: ldc_w 532
    //   1661: invokestatic 537	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1664: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: ldc_w 539
    //   1670: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: invokestatic 99	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1676: invokestatic 543	com/tencent/mm/plugin/music/h/e:fC	(Landroid/content/Context;)Ljava/lang/String;
    //   1679: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: invokevirtual 520	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1685: invokeinterface 500 3 0
    //   1690: pop
    //   1691: aload 33
    //   1693: astore 37
    //   1695: aload 33
    //   1697: astore 38
    //   1699: aload 33
    //   1701: astore 35
    //   1703: aload 33
    //   1705: astore 36
    //   1707: aload 33
    //   1709: astore 39
    //   1711: aload 33
    //   1713: astore 34
    //   1715: aload_0
    //   1716: aload 40
    //   1718: aload 47
    //   1720: invokespecial 545	com/tencent/mm/plugin/music/c/b:z	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   1723: astore 40
    //   1725: aload 40
    //   1727: astore 34
    //   1729: aload 33
    //   1731: astore 37
    //   1733: aload 34
    //   1735: astore 36
    //   1737: lload 4
    //   1739: lstore 8
    //   1741: lload_2
    //   1742: lstore 6
    //   1744: aload 45
    //   1746: astore 35
    //   1748: lload 4
    //   1750: lstore 20
    //   1752: lload_2
    //   1753: lstore 12
    //   1755: lload 4
    //   1757: lstore 26
    //   1759: lload_2
    //   1760: lstore 10
    //   1762: lload 4
    //   1764: lstore 28
    //   1766: lload_2
    //   1767: lstore 18
    //   1769: lload 4
    //   1771: lstore 24
    //   1773: lload_2
    //   1774: lstore 16
    //   1776: lload 4
    //   1778: lstore 22
    //   1780: lload_2
    //   1781: lstore 14
    //   1783: aload 34
    //   1785: invokevirtual 303	java/net/HttpURLConnection:getResponseCode	()I
    //   1788: istore_1
    //   1789: iload_1
    //   1790: sipush 200
    //   1793: if_icmpeq +544 -> 2337
    //   1796: iload_1
    //   1797: sipush 206
    //   1800: if_icmpeq +537 -> 2337
    //   1803: aload 33
    //   1805: astore 37
    //   1807: aload 34
    //   1809: astore 36
    //   1811: lload 4
    //   1813: lstore 8
    //   1815: lload_2
    //   1816: lstore 6
    //   1818: aload 45
    //   1820: astore 35
    //   1822: lload 4
    //   1824: lstore 20
    //   1826: lload_2
    //   1827: lstore 12
    //   1829: lload 4
    //   1831: lstore 26
    //   1833: lload_2
    //   1834: lstore 10
    //   1836: lload 4
    //   1838: lstore 28
    //   1840: lload_2
    //   1841: lstore 18
    //   1843: lload 4
    //   1845: lstore 24
    //   1847: lload_2
    //   1848: lstore 16
    //   1850: lload 4
    //   1852: lstore 22
    //   1854: lload_2
    //   1855: lstore 14
    //   1857: iload_1
    //   1858: invokestatic 312	com/tencent/mm/plugin/music/c/b:HF	(I)V
    //   1861: aload 33
    //   1863: astore 37
    //   1865: aload 34
    //   1867: astore 36
    //   1869: lload 4
    //   1871: lstore 8
    //   1873: lload_2
    //   1874: lstore 6
    //   1876: aload 45
    //   1878: astore 35
    //   1880: lload 4
    //   1882: lstore 20
    //   1884: lload_2
    //   1885: lstore 12
    //   1887: lload 4
    //   1889: lstore 26
    //   1891: lload_2
    //   1892: lstore 10
    //   1894: lload 4
    //   1896: lstore 28
    //   1898: lload_2
    //   1899: lstore 18
    //   1901: lload 4
    //   1903: lstore 24
    //   1905: lload_2
    //   1906: lstore 16
    //   1908: lload 4
    //   1910: lstore 22
    //   1912: lload_2
    //   1913: lstore 14
    //   1915: ldc 85
    //   1917: ldc_w 547
    //   1920: iconst_1
    //   1921: anewarray 4	java/lang/Object
    //   1924: dup
    //   1925: iconst_0
    //   1926: iload_1
    //   1927: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1930: aastore
    //   1931: invokestatic 331	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1934: aload 33
    //   1936: astore 37
    //   1938: aload 34
    //   1940: astore 36
    //   1942: lload 4
    //   1944: lstore 8
    //   1946: lload_2
    //   1947: lstore 6
    //   1949: aload 45
    //   1951: astore 35
    //   1953: lload 4
    //   1955: lstore 20
    //   1957: lload_2
    //   1958: lstore 12
    //   1960: lload 4
    //   1962: lstore 26
    //   1964: lload_2
    //   1965: lstore 10
    //   1967: lload 4
    //   1969: lstore 28
    //   1971: lload_2
    //   1972: lstore 18
    //   1974: lload 4
    //   1976: lstore 24
    //   1978: lload_2
    //   1979: lstore 16
    //   1981: lload 4
    //   1983: lstore 22
    //   1985: lload_2
    //   1986: lstore 14
    //   1988: aload_0
    //   1989: iload_1
    //   1990: putfield 57	com/tencent/mm/plugin/music/c/b:tVM	I
    //   1993: aload 33
    //   1995: astore 37
    //   1997: aload 34
    //   1999: astore 36
    //   2001: lload 4
    //   2003: lstore 8
    //   2005: lload_2
    //   2006: lstore 6
    //   2008: aload 45
    //   2010: astore 35
    //   2012: lload 4
    //   2014: lstore 20
    //   2016: lload_2
    //   2017: lstore 12
    //   2019: lload 4
    //   2021: lstore 26
    //   2023: lload_2
    //   2024: lstore 10
    //   2026: lload 4
    //   2028: lstore 28
    //   2030: lload_2
    //   2031: lstore 18
    //   2033: lload 4
    //   2035: lstore 24
    //   2037: lload_2
    //   2038: lstore 16
    //   2040: lload 4
    //   2042: lstore 22
    //   2044: lload_2
    //   2045: lstore 14
    //   2047: aload_0
    //   2048: iconst_m1
    //   2049: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   2052: lload 4
    //   2054: lconst_0
    //   2055: lcmp
    //   2056: ifne +115 -> 2171
    //   2059: lload_2
    //   2060: lconst_0
    //   2061: lcmp
    //   2062: ifle +109 -> 2171
    //   2065: ldc 85
    //   2067: ldc_w 459
    //   2070: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2073: aload 33
    //   2075: lload_2
    //   2076: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   2079: aload_0
    //   2080: lload_2
    //   2081: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   2084: lload_2
    //   2085: ldc2_w 393
    //   2088: lcmp
    //   2089: ifge +15 -> 2104
    //   2092: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2095: dup
    //   2096: aload_0
    //   2097: iconst_1
    //   2098: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2101: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   2104: aload 33
    //   2106: ifnull +8 -> 2114
    //   2109: aload 33
    //   2111: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   2114: aload 34
    //   2116: ifnull +16 -> 2132
    //   2119: aload 34
    //   2121: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2124: invokevirtual 218	java/io/InputStream:close	()V
    //   2127: aload 34
    //   2129: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   2132: aload_0
    //   2133: iconst_1
    //   2134: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   2137: ldc 85
    //   2139: ldc_w 466
    //   2142: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2145: ldc_w 374
    //   2148: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2151: return
    //   2152: astore 35
    //   2154: ldc 85
    //   2156: aload 35
    //   2158: ldc_w 468
    //   2161: iconst_0
    //   2162: anewarray 4	java/lang/Object
    //   2165: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2168: goto -89 -> 2079
    //   2171: lload 4
    //   2173: lconst_0
    //   2174: lcmp
    //   2175: ifeq +47 -> 2222
    //   2178: lload_2
    //   2179: lload 4
    //   2181: lcmp
    //   2182: ifeq +40 -> 2222
    //   2185: ldc 85
    //   2187: ldc_w 470
    //   2190: iconst_2
    //   2191: anewarray 4	java/lang/Object
    //   2194: dup
    //   2195: iconst_0
    //   2196: lload 4
    //   2198: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2201: aastore
    //   2202: dup
    //   2203: iconst_1
    //   2204: lload_2
    //   2205: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2208: aastore
    //   2209: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2212: aload_0
    //   2213: lload_2
    //   2214: lload 4
    //   2216: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   2219: goto -115 -> 2104
    //   2222: lload 4
    //   2224: lconst_0
    //   2225: lcmp
    //   2226: ifeq +66 -> 2292
    //   2229: lload_2
    //   2230: lload 4
    //   2232: lcmp
    //   2233: ifne +59 -> 2292
    //   2236: ldc 85
    //   2238: ldc_w 474
    //   2241: iconst_2
    //   2242: anewarray 4	java/lang/Object
    //   2245: dup
    //   2246: iconst_0
    //   2247: lload 4
    //   2249: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2252: aastore
    //   2253: dup
    //   2254: iconst_1
    //   2255: lload_2
    //   2256: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2259: aastore
    //   2260: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2263: aload_0
    //   2264: lload 4
    //   2266: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   2269: lload_2
    //   2270: ldc2_w 393
    //   2273: lcmp
    //   2274: ifge -170 -> 2104
    //   2277: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2280: dup
    //   2281: aload_0
    //   2282: iconst_1
    //   2283: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2286: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   2289: goto -185 -> 2104
    //   2292: ldc 85
    //   2294: ldc_w 476
    //   2297: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2300: goto -196 -> 2104
    //   2303: astore 33
    //   2305: ldc 85
    //   2307: aload 33
    //   2309: ldc_w 468
    //   2312: iconst_0
    //   2313: anewarray 4	java/lang/Object
    //   2316: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2319: goto -205 -> 2114
    //   2322: astore 33
    //   2324: ldc 85
    //   2326: aload 33
    //   2328: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2331: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2334: goto -207 -> 2127
    //   2337: aload 33
    //   2339: astore 37
    //   2341: aload 34
    //   2343: astore 36
    //   2345: lload 4
    //   2347: lstore 8
    //   2349: lload_2
    //   2350: lstore 6
    //   2352: aload 45
    //   2354: astore 35
    //   2356: lload 4
    //   2358: lstore 20
    //   2360: lload_2
    //   2361: lstore 12
    //   2363: lload 4
    //   2365: lstore 26
    //   2367: lload_2
    //   2368: lstore 10
    //   2370: lload 4
    //   2372: lstore 28
    //   2374: lload_2
    //   2375: lstore 18
    //   2377: lload 4
    //   2379: lstore 24
    //   2381: lload_2
    //   2382: lstore 16
    //   2384: lload 4
    //   2386: lstore 22
    //   2388: lload_2
    //   2389: lstore 14
    //   2391: ldc 85
    //   2393: ldc_w 555
    //   2396: iconst_1
    //   2397: anewarray 4	java/lang/Object
    //   2400: dup
    //   2401: iconst_0
    //   2402: iload_1
    //   2403: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2406: aastore
    //   2407: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2410: aload 33
    //   2412: astore 37
    //   2414: aload 34
    //   2416: astore 36
    //   2418: lload 4
    //   2420: lstore 8
    //   2422: lload_2
    //   2423: lstore 6
    //   2425: aload 45
    //   2427: astore 35
    //   2429: lload 4
    //   2431: lstore 20
    //   2433: lload_2
    //   2434: lstore 12
    //   2436: lload 4
    //   2438: lstore 26
    //   2440: lload_2
    //   2441: lstore 10
    //   2443: lload 4
    //   2445: lstore 28
    //   2447: lload_2
    //   2448: lstore 18
    //   2450: lload 4
    //   2452: lstore 24
    //   2454: lload_2
    //   2455: lstore 16
    //   2457: lload 4
    //   2459: lstore 22
    //   2461: lload_2
    //   2462: lstore 14
    //   2464: ldc 85
    //   2466: new 509	java/lang/StringBuilder
    //   2469: dup
    //   2470: ldc_w 557
    //   2473: invokespecial 512	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2476: aload 34
    //   2478: ldc_w 529
    //   2481: invokevirtual 560	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2484: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: invokevirtual 520	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2490: invokestatic 562	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2493: aload 33
    //   2495: astore 37
    //   2497: aload 34
    //   2499: astore 36
    //   2501: lload 4
    //   2503: lstore 8
    //   2505: lload_2
    //   2506: lstore 6
    //   2508: aload 45
    //   2510: astore 35
    //   2512: lload 4
    //   2514: lstore 20
    //   2516: lload_2
    //   2517: lstore 12
    //   2519: lload 4
    //   2521: lstore 26
    //   2523: lload_2
    //   2524: lstore 10
    //   2526: lload 4
    //   2528: lstore 28
    //   2530: lload_2
    //   2531: lstore 18
    //   2533: lload 4
    //   2535: lstore 24
    //   2537: lload_2
    //   2538: lstore 16
    //   2540: lload 4
    //   2542: lstore 22
    //   2544: lload_2
    //   2545: lstore 14
    //   2547: aload 34
    //   2549: invokevirtual 565	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2552: astore 38
    //   2554: aload 33
    //   2556: astore 37
    //   2558: aload 34
    //   2560: astore 36
    //   2562: lload 4
    //   2564: lstore 8
    //   2566: lload_2
    //   2567: lstore 6
    //   2569: aload 45
    //   2571: astore 35
    //   2573: lload 4
    //   2575: lstore 20
    //   2577: lload_2
    //   2578: lstore 12
    //   2580: lload 4
    //   2582: lstore 26
    //   2584: lload_2
    //   2585: lstore 10
    //   2587: lload 4
    //   2589: lstore 28
    //   2591: lload_2
    //   2592: lstore 18
    //   2594: lload 4
    //   2596: lstore 24
    //   2598: lload_2
    //   2599: lstore 16
    //   2601: lload 4
    //   2603: lstore 22
    //   2605: lload_2
    //   2606: lstore 14
    //   2608: ldc 85
    //   2610: ldc_w 567
    //   2613: iconst_1
    //   2614: anewarray 4	java/lang/Object
    //   2617: dup
    //   2618: iconst_0
    //   2619: aload 38
    //   2621: aastore
    //   2622: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2625: aload 33
    //   2627: astore 37
    //   2629: aload 34
    //   2631: astore 36
    //   2633: lload 4
    //   2635: lstore 8
    //   2637: lload_2
    //   2638: lstore 6
    //   2640: aload 45
    //   2642: astore 35
    //   2644: lload 4
    //   2646: lstore 20
    //   2648: lload_2
    //   2649: lstore 12
    //   2651: lload 4
    //   2653: lstore 26
    //   2655: lload_2
    //   2656: lstore 10
    //   2658: lload 4
    //   2660: lstore 28
    //   2662: lload_2
    //   2663: lstore 18
    //   2665: lload 4
    //   2667: lstore 24
    //   2669: lload_2
    //   2670: lstore 16
    //   2672: lload 4
    //   2674: lstore 22
    //   2676: lload_2
    //   2677: lstore 14
    //   2679: aload_0
    //   2680: aload 38
    //   2682: putfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2685: aload 33
    //   2687: astore 37
    //   2689: aload 34
    //   2691: astore 36
    //   2693: lload 4
    //   2695: lstore 8
    //   2697: lload_2
    //   2698: lstore 6
    //   2700: aload 45
    //   2702: astore 35
    //   2704: lload 4
    //   2706: lstore 20
    //   2708: lload_2
    //   2709: lstore 12
    //   2711: lload 4
    //   2713: lstore 26
    //   2715: lload_2
    //   2716: lstore 10
    //   2718: lload 4
    //   2720: lstore 28
    //   2722: lload_2
    //   2723: lstore 18
    //   2725: lload 4
    //   2727: lstore 24
    //   2729: lload_2
    //   2730: lstore 16
    //   2732: lload 4
    //   2734: lstore 22
    //   2736: lload_2
    //   2737: lstore 14
    //   2739: aload_0
    //   2740: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2743: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2746: ifne +390 -> 3136
    //   2749: aload 33
    //   2751: astore 37
    //   2753: aload 34
    //   2755: astore 36
    //   2757: lload 4
    //   2759: lstore 8
    //   2761: lload_2
    //   2762: lstore 6
    //   2764: aload 45
    //   2766: astore 35
    //   2768: lload 4
    //   2770: lstore 20
    //   2772: lload_2
    //   2773: lstore 12
    //   2775: lload 4
    //   2777: lstore 26
    //   2779: lload_2
    //   2780: lstore 10
    //   2782: lload 4
    //   2784: lstore 28
    //   2786: lload_2
    //   2787: lstore 18
    //   2789: lload 4
    //   2791: lstore 24
    //   2793: lload_2
    //   2794: lstore 16
    //   2796: lload 4
    //   2798: lstore 22
    //   2800: lload_2
    //   2801: lstore 14
    //   2803: aload_0
    //   2804: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   2807: getfield 568	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2810: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2813: ifeq +323 -> 3136
    //   2816: aload 33
    //   2818: astore 37
    //   2820: aload 34
    //   2822: astore 36
    //   2824: lload 4
    //   2826: lstore 8
    //   2828: lload_2
    //   2829: lstore 6
    //   2831: aload 45
    //   2833: astore 35
    //   2835: lload 4
    //   2837: lstore 20
    //   2839: lload_2
    //   2840: lstore 12
    //   2842: lload 4
    //   2844: lstore 26
    //   2846: lload_2
    //   2847: lstore 10
    //   2849: lload 4
    //   2851: lstore 28
    //   2853: lload_2
    //   2854: lstore 18
    //   2856: lload 4
    //   2858: lstore 24
    //   2860: lload_2
    //   2861: lstore 16
    //   2863: lload 4
    //   2865: lstore 22
    //   2867: lload_2
    //   2868: lstore 14
    //   2870: aload_0
    //   2871: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   2874: aload_0
    //   2875: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2878: putfield 568	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2881: aload 33
    //   2883: astore 37
    //   2885: aload 34
    //   2887: astore 36
    //   2889: lload 4
    //   2891: lstore 8
    //   2893: lload_2
    //   2894: lstore 6
    //   2896: aload 45
    //   2898: astore 35
    //   2900: lload 4
    //   2902: lstore 20
    //   2904: lload_2
    //   2905: lstore 12
    //   2907: lload 4
    //   2909: lstore 26
    //   2911: lload_2
    //   2912: lstore 10
    //   2914: lload 4
    //   2916: lstore 28
    //   2918: lload_2
    //   2919: lstore 18
    //   2921: lload 4
    //   2923: lstore 24
    //   2925: lload_2
    //   2926: lstore 16
    //   2928: lload 4
    //   2930: lstore 22
    //   2932: lload_2
    //   2933: lstore 14
    //   2935: aload_0
    //   2936: getfield 61	com/tencent/mm/plugin/music/c/b:tVI	Lcom/tencent/mm/az/f;
    //   2939: getfield 147	com/tencent/mm/az/f:hnp	Ljava/lang/String;
    //   2942: astore 39
    //   2944: aload 33
    //   2946: astore 37
    //   2948: aload 34
    //   2950: astore 36
    //   2952: lload 4
    //   2954: lstore 8
    //   2956: lload_2
    //   2957: lstore 6
    //   2959: aload 45
    //   2961: astore 35
    //   2963: lload 4
    //   2965: lstore 20
    //   2967: lload_2
    //   2968: lstore 12
    //   2970: lload 4
    //   2972: lstore 26
    //   2974: lload_2
    //   2975: lstore 10
    //   2977: lload 4
    //   2979: lstore 28
    //   2981: lload_2
    //   2982: lstore 18
    //   2984: lload 4
    //   2986: lstore 24
    //   2988: lload_2
    //   2989: lstore 16
    //   2991: lload 4
    //   2993: lstore 22
    //   2995: lload_2
    //   2996: lstore 14
    //   2998: aload_0
    //   2999: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   3002: astore 38
    //   3004: aload 33
    //   3006: astore 37
    //   3008: aload 34
    //   3010: astore 36
    //   3012: lload 4
    //   3014: lstore 8
    //   3016: lload_2
    //   3017: lstore 6
    //   3019: aload 45
    //   3021: astore 35
    //   3023: lload 4
    //   3025: lstore 20
    //   3027: lload_2
    //   3028: lstore 12
    //   3030: lload 4
    //   3032: lstore 26
    //   3034: lload_2
    //   3035: lstore 10
    //   3037: lload 4
    //   3039: lstore 28
    //   3041: lload_2
    //   3042: lstore 18
    //   3044: lload 4
    //   3046: lstore 24
    //   3048: lload_2
    //   3049: lstore 16
    //   3051: lload 4
    //   3053: lstore 22
    //   3055: lload_2
    //   3056: lstore 14
    //   3058: invokestatic 571	com/tencent/mm/plugin/music/cache/e:cUJ	()Z
    //   3061: ifeq +1375 -> 4436
    //   3064: aload 33
    //   3066: astore 37
    //   3068: aload 34
    //   3070: astore 36
    //   3072: lload 4
    //   3074: lstore 8
    //   3076: lload_2
    //   3077: lstore 6
    //   3079: aload 45
    //   3081: astore 35
    //   3083: lload 4
    //   3085: lstore 20
    //   3087: lload_2
    //   3088: lstore 12
    //   3090: lload 4
    //   3092: lstore 26
    //   3094: lload_2
    //   3095: lstore 10
    //   3097: lload 4
    //   3099: lstore 28
    //   3101: lload_2
    //   3102: lstore 18
    //   3104: lload 4
    //   3106: lstore 24
    //   3108: lload_2
    //   3109: lstore 16
    //   3111: lload 4
    //   3113: lstore 22
    //   3115: lload_2
    //   3116: lstore 14
    //   3118: ldc_w 573
    //   3121: invokestatic 125	com/tencent/mm/plugin/music/f/c/b:aP	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/music/f/c/a;
    //   3124: checkcast 573	com/tencent/mm/plugin/music/cache/c
    //   3127: aload 39
    //   3129: aload 38
    //   3131: invokeinterface 576 3 0
    //   3136: aload 33
    //   3138: astore 37
    //   3140: aload 34
    //   3142: astore 36
    //   3144: lload 4
    //   3146: lstore 8
    //   3148: lload_2
    //   3149: lstore 6
    //   3151: aload 45
    //   3153: astore 35
    //   3155: lload 4
    //   3157: lstore 20
    //   3159: lload_2
    //   3160: lstore 12
    //   3162: lload 4
    //   3164: lstore 26
    //   3166: lload_2
    //   3167: lstore 10
    //   3169: lload 4
    //   3171: lstore 28
    //   3173: lload_2
    //   3174: lstore 18
    //   3176: lload 4
    //   3178: lstore 24
    //   3180: lload_2
    //   3181: lstore 16
    //   3183: lload 4
    //   3185: lstore 22
    //   3187: lload_2
    //   3188: lstore 14
    //   3190: aload 34
    //   3192: ldc_w 578
    //   3195: invokevirtual 327	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3198: astore 39
    //   3200: aload 33
    //   3202: astore 37
    //   3204: aload 34
    //   3206: astore 36
    //   3208: lload 4
    //   3210: lstore 8
    //   3212: lload_2
    //   3213: lstore 6
    //   3215: aload 45
    //   3217: astore 35
    //   3219: lload 4
    //   3221: lstore 20
    //   3223: lload_2
    //   3224: lstore 12
    //   3226: lload 4
    //   3228: lstore 26
    //   3230: lload_2
    //   3231: lstore 10
    //   3233: lload 4
    //   3235: lstore 28
    //   3237: lload_2
    //   3238: lstore 18
    //   3240: lload 4
    //   3242: lstore 24
    //   3244: lload_2
    //   3245: lstore 16
    //   3247: lload 4
    //   3249: lstore 22
    //   3251: lload_2
    //   3252: lstore 14
    //   3254: aload 39
    //   3256: invokestatic 580	com/tencent/mm/plugin/music/c/b:aiF	(Ljava/lang/String;)[J
    //   3259: astore 38
    //   3261: aload 33
    //   3263: astore 37
    //   3265: aload 34
    //   3267: astore 36
    //   3269: lload 4
    //   3271: lstore 8
    //   3273: lload_2
    //   3274: lstore 6
    //   3276: aload 45
    //   3278: astore 35
    //   3280: lload 4
    //   3282: lstore 20
    //   3284: lload_2
    //   3285: lstore 12
    //   3287: lload 4
    //   3289: lstore 26
    //   3291: lload_2
    //   3292: lstore 10
    //   3294: lload 4
    //   3296: lstore 28
    //   3298: lload_2
    //   3299: lstore 18
    //   3301: lload 4
    //   3303: lstore 24
    //   3305: lload_2
    //   3306: lstore 16
    //   3308: lload 4
    //   3310: lstore 22
    //   3312: lload_2
    //   3313: lstore 14
    //   3315: aload 34
    //   3317: ldc_w 582
    //   3320: invokevirtual 327	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3323: lconst_0
    //   3324: invokestatic 586	com/tencent/mm/sdk/platformtools/bt:getLong	(Ljava/lang/String;J)J
    //   3327: lstore 30
    //   3329: aload 33
    //   3331: astore 37
    //   3333: aload 34
    //   3335: astore 36
    //   3337: lload 4
    //   3339: lstore 8
    //   3341: lload_2
    //   3342: lstore 6
    //   3344: aload 45
    //   3346: astore 35
    //   3348: lload 4
    //   3350: lstore 20
    //   3352: lload_2
    //   3353: lstore 12
    //   3355: lload 4
    //   3357: lstore 26
    //   3359: lload_2
    //   3360: lstore 10
    //   3362: lload 4
    //   3364: lstore 28
    //   3366: lload_2
    //   3367: lstore 18
    //   3369: lload 4
    //   3371: lstore 24
    //   3373: lload_2
    //   3374: lstore 16
    //   3376: lload 4
    //   3378: lstore 22
    //   3380: lload_2
    //   3381: lstore 14
    //   3383: ldc 85
    //   3385: ldc_w 588
    //   3388: iconst_2
    //   3389: anewarray 4	java/lang/Object
    //   3392: dup
    //   3393: iconst_0
    //   3394: aload 39
    //   3396: aastore
    //   3397: dup
    //   3398: iconst_1
    //   3399: lload 30
    //   3401: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3404: aastore
    //   3405: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3408: aload 38
    //   3410: ifnonnull +1092 -> 4502
    //   3413: aload 33
    //   3415: astore 37
    //   3417: aload 34
    //   3419: astore 36
    //   3421: lload 4
    //   3423: lstore 8
    //   3425: lload_2
    //   3426: lstore 6
    //   3428: aload 45
    //   3430: astore 35
    //   3432: lload 4
    //   3434: lstore 20
    //   3436: lload_2
    //   3437: lstore 12
    //   3439: lload 4
    //   3441: lstore 26
    //   3443: lload_2
    //   3444: lstore 10
    //   3446: lload 4
    //   3448: lstore 28
    //   3450: lload_2
    //   3451: lstore 18
    //   3453: lload 4
    //   3455: lstore 24
    //   3457: lload_2
    //   3458: lstore 16
    //   3460: lload 4
    //   3462: lstore 22
    //   3464: lload_2
    //   3465: lstore 14
    //   3467: ldc 85
    //   3469: ldc_w 590
    //   3472: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3475: lload_2
    //   3476: lstore 4
    //   3478: lload_2
    //   3479: lconst_0
    //   3480: lcmp
    //   3481: ifeq +4389 -> 7870
    //   3484: lconst_0
    //   3485: lstore 4
    //   3487: goto +4383 -> 7870
    //   3490: aload 33
    //   3492: astore 37
    //   3494: aload 34
    //   3496: astore 36
    //   3498: lload 4
    //   3500: lstore 8
    //   3502: lload_2
    //   3503: lstore 6
    //   3505: aload 45
    //   3507: astore 35
    //   3509: lload 4
    //   3511: lstore 20
    //   3513: lload_2
    //   3514: lstore 12
    //   3516: lload 4
    //   3518: lstore 26
    //   3520: lload_2
    //   3521: lstore 10
    //   3523: lload 4
    //   3525: lstore 28
    //   3527: lload_2
    //   3528: lstore 18
    //   3530: lload 4
    //   3532: lstore 24
    //   3534: lload_2
    //   3535: lstore 16
    //   3537: lload 4
    //   3539: lstore 22
    //   3541: lload_2
    //   3542: lstore 14
    //   3544: ldc 85
    //   3546: ldc_w 592
    //   3549: iconst_3
    //   3550: anewarray 4	java/lang/Object
    //   3553: dup
    //   3554: iconst_0
    //   3555: lload 30
    //   3557: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3560: aastore
    //   3561: dup
    //   3562: iconst_1
    //   3563: lload_2
    //   3564: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3567: aastore
    //   3568: dup
    //   3569: iconst_2
    //   3570: aload_0
    //   3571: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3574: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3577: aastore
    //   3578: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3581: aload 33
    //   3583: astore 37
    //   3585: aload 34
    //   3587: astore 36
    //   3589: lload 4
    //   3591: lstore 8
    //   3593: lload_2
    //   3594: lstore 6
    //   3596: aload 45
    //   3598: astore 35
    //   3600: lload 4
    //   3602: lstore 20
    //   3604: lload_2
    //   3605: lstore 12
    //   3607: lload 4
    //   3609: lstore 26
    //   3611: lload_2
    //   3612: lstore 10
    //   3614: lload 4
    //   3616: lstore 28
    //   3618: lload_2
    //   3619: lstore 18
    //   3621: lload 4
    //   3623: lstore 24
    //   3625: lload_2
    //   3626: lstore 16
    //   3628: lload 4
    //   3630: lstore 22
    //   3632: lload_2
    //   3633: lstore 14
    //   3635: aload 33
    //   3637: lload 30
    //   3639: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   3642: aload 33
    //   3644: astore 37
    //   3646: aload 34
    //   3648: astore 36
    //   3650: lload 4
    //   3652: lstore 8
    //   3654: lload_2
    //   3655: lstore 6
    //   3657: aload 45
    //   3659: astore 35
    //   3661: lload 4
    //   3663: lstore 20
    //   3665: lload_2
    //   3666: lstore 12
    //   3668: lload 4
    //   3670: lstore 26
    //   3672: lload_2
    //   3673: lstore 10
    //   3675: lload 4
    //   3677: lstore 28
    //   3679: lload_2
    //   3680: lstore 18
    //   3682: lload 4
    //   3684: lstore 24
    //   3686: lload_2
    //   3687: lstore 16
    //   3689: lload 4
    //   3691: lstore 22
    //   3693: lload_2
    //   3694: lstore 14
    //   3696: aload 33
    //   3698: lload_2
    //   3699: invokevirtual 595	java/io/RandomAccessFile:seek	(J)V
    //   3702: aload 33
    //   3704: astore 37
    //   3706: aload 34
    //   3708: astore 36
    //   3710: lload 4
    //   3712: lstore 8
    //   3714: lload_2
    //   3715: lstore 6
    //   3717: aload 45
    //   3719: astore 35
    //   3721: lload 4
    //   3723: lstore 20
    //   3725: lload_2
    //   3726: lstore 12
    //   3728: lload 4
    //   3730: lstore 26
    //   3732: lload_2
    //   3733: lstore 10
    //   3735: lload 4
    //   3737: lstore 28
    //   3739: lload_2
    //   3740: lstore 18
    //   3742: lload 4
    //   3744: lstore 24
    //   3746: lload_2
    //   3747: lstore 16
    //   3749: lload 4
    //   3751: lstore 22
    //   3753: lload_2
    //   3754: lstore 14
    //   3756: aload 34
    //   3758: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3761: astore 38
    //   3763: aload 38
    //   3765: astore 35
    //   3767: lload_2
    //   3768: lstore 18
    //   3770: lload_2
    //   3771: lstore 16
    //   3773: aload 33
    //   3775: astore 37
    //   3777: aload 35
    //   3779: astore 39
    //   3781: aload 34
    //   3783: astore 36
    //   3785: lload 4
    //   3787: lstore 20
    //   3789: lload_2
    //   3790: lstore 8
    //   3792: lload_2
    //   3793: lstore 10
    //   3795: lload_2
    //   3796: lstore 12
    //   3798: lload_2
    //   3799: lstore 14
    //   3801: sipush 4096
    //   3804: newarray byte
    //   3806: astore 38
    //   3808: lload_2
    //   3809: lstore 18
    //   3811: lload_2
    //   3812: lstore 16
    //   3814: aload 33
    //   3816: astore 37
    //   3818: aload 35
    //   3820: astore 39
    //   3822: aload 34
    //   3824: astore 36
    //   3826: lload 4
    //   3828: lstore 20
    //   3830: lload_2
    //   3831: lstore 8
    //   3833: lload_2
    //   3834: lstore 10
    //   3836: lload_2
    //   3837: lstore 12
    //   3839: lload_2
    //   3840: lstore 14
    //   3842: aload_0
    //   3843: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3846: ifne +1479 -> 5325
    //   3849: lload_2
    //   3850: lstore 18
    //   3852: lload_2
    //   3853: lstore 16
    //   3855: aload 33
    //   3857: astore 37
    //   3859: aload 35
    //   3861: astore 39
    //   3863: aload 34
    //   3865: astore 36
    //   3867: lload 4
    //   3869: lstore 20
    //   3871: lload_2
    //   3872: lstore 8
    //   3874: lload_2
    //   3875: lstore 10
    //   3877: lload_2
    //   3878: lstore 12
    //   3880: lload_2
    //   3881: lstore 14
    //   3883: aload 35
    //   3885: aload 38
    //   3887: invokevirtual 599	java/io/InputStream:read	([B)I
    //   3890: istore_1
    //   3891: iload_1
    //   3892: ifle +1355 -> 5247
    //   3895: lload_2
    //   3896: lstore 18
    //   3898: lload_2
    //   3899: lstore 16
    //   3901: aload 33
    //   3903: astore 37
    //   3905: aload 35
    //   3907: astore 39
    //   3909: aload 34
    //   3911: astore 36
    //   3913: lload 4
    //   3915: lstore 20
    //   3917: lload_2
    //   3918: lstore 8
    //   3920: lload_2
    //   3921: lstore 10
    //   3923: lload_2
    //   3924: lstore 12
    //   3926: lload_2
    //   3927: lstore 14
    //   3929: aload 33
    //   3931: aload 38
    //   3933: iconst_0
    //   3934: iload_1
    //   3935: invokevirtual 603	java/io/RandomAccessFile:write	([BII)V
    //   3938: lload_2
    //   3939: iload_1
    //   3940: i2l
    //   3941: ladd
    //   3942: lstore 6
    //   3944: lload 6
    //   3946: lstore 18
    //   3948: lload 6
    //   3950: lstore 16
    //   3952: aload 33
    //   3954: astore 37
    //   3956: aload 35
    //   3958: astore 39
    //   3960: aload 34
    //   3962: astore 36
    //   3964: lload 4
    //   3966: lstore 20
    //   3968: lload 6
    //   3970: lstore 8
    //   3972: lload 6
    //   3974: lstore 10
    //   3976: lload 6
    //   3978: lstore 12
    //   3980: lload 6
    //   3982: lstore 14
    //   3984: ldc 85
    //   3986: ldc_w 605
    //   3989: iconst_2
    //   3990: anewarray 4	java/lang/Object
    //   3993: dup
    //   3994: iconst_0
    //   3995: lload 6
    //   3997: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4000: aastore
    //   4001: dup
    //   4002: iconst_1
    //   4003: lload 30
    //   4005: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4008: aastore
    //   4009: invokestatic 608	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4012: lload 6
    //   4014: lstore 18
    //   4016: lload 6
    //   4018: lstore 16
    //   4020: aload 33
    //   4022: astore 37
    //   4024: aload 35
    //   4026: astore 39
    //   4028: aload 34
    //   4030: astore 36
    //   4032: lload 4
    //   4034: lstore 20
    //   4036: lload 6
    //   4038: lstore 8
    //   4040: lload 6
    //   4042: lstore 10
    //   4044: lload 6
    //   4046: lstore 12
    //   4048: lload 6
    //   4050: lstore 14
    //   4052: aload_0
    //   4053: getfield 107	com/tencent/mm/plugin/music/c/b:qbG	Z
    //   4056: ifeq +877 -> 4933
    //   4059: lload 6
    //   4061: lstore 18
    //   4063: lload 6
    //   4065: lstore 16
    //   4067: aload 33
    //   4069: astore 37
    //   4071: aload 35
    //   4073: astore 39
    //   4075: aload 34
    //   4077: astore 36
    //   4079: lload 4
    //   4081: lstore 20
    //   4083: lload 6
    //   4085: lstore 8
    //   4087: lload 6
    //   4089: lstore 10
    //   4091: lload 6
    //   4093: lstore 12
    //   4095: lload 6
    //   4097: lstore 14
    //   4099: aload_0
    //   4100: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   4103: lload 6
    //   4105: putfield 77	com/tencent/mm/plugin/music/c/a:tVE	J
    //   4108: lload 6
    //   4110: lstore 18
    //   4112: lload 6
    //   4114: lstore 16
    //   4116: aload 33
    //   4118: astore 37
    //   4120: aload 35
    //   4122: astore 39
    //   4124: aload 34
    //   4126: astore 36
    //   4128: lload 4
    //   4130: lstore 20
    //   4132: lload 6
    //   4134: lstore 8
    //   4136: lload 6
    //   4138: lstore 10
    //   4140: lload 6
    //   4142: lstore 12
    //   4144: lload 6
    //   4146: lstore 14
    //   4148: aload_0
    //   4149: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   4152: lload 30
    //   4154: putfield 80	com/tencent/mm/plugin/music/c/a:tVG	J
    //   4157: lload 6
    //   4159: lstore_2
    //   4160: lload 6
    //   4162: ldc2_w 393
    //   4165: lcmp
    //   4166: iflt -358 -> 3808
    //   4169: lload 6
    //   4171: lstore 18
    //   4173: lload 6
    //   4175: lstore 16
    //   4177: aload 33
    //   4179: astore 37
    //   4181: aload 35
    //   4183: astore 39
    //   4185: aload 34
    //   4187: astore 36
    //   4189: lload 4
    //   4191: lstore 20
    //   4193: lload 6
    //   4195: lstore 8
    //   4197: lload 6
    //   4199: lstore 10
    //   4201: lload 6
    //   4203: lstore 12
    //   4205: lload 6
    //   4207: lstore 14
    //   4209: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4212: dup
    //   4213: aload_0
    //   4214: iconst_1
    //   4215: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4218: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4221: lload 6
    //   4223: lstore_2
    //   4224: goto -416 -> 3808
    //   4227: astore 38
    //   4229: lload 18
    //   4231: lstore_2
    //   4232: aload 33
    //   4234: astore 37
    //   4236: aload 35
    //   4238: astore 39
    //   4240: aload 34
    //   4242: astore 36
    //   4244: lload 4
    //   4246: lstore 20
    //   4248: lload_2
    //   4249: lstore 8
    //   4251: ldc 85
    //   4253: aload 38
    //   4255: ldc_w 610
    //   4258: iconst_1
    //   4259: anewarray 4	java/lang/Object
    //   4262: dup
    //   4263: iconst_0
    //   4264: aload 52
    //   4266: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   4269: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   4272: aastore
    //   4273: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4276: aload 33
    //   4278: astore 37
    //   4280: aload 35
    //   4282: astore 39
    //   4284: aload 34
    //   4286: astore 36
    //   4288: lload 4
    //   4290: lstore 20
    //   4292: lload_2
    //   4293: lstore 8
    //   4295: aload_0
    //   4296: sipush 750
    //   4299: putfield 59	com/tencent/mm/plugin/music/c/b:cUB	I
    //   4302: aload 33
    //   4304: astore 37
    //   4306: aload 35
    //   4308: astore 39
    //   4310: aload 34
    //   4312: astore 36
    //   4314: lload 4
    //   4316: lstore 20
    //   4318: lload_2
    //   4319: lstore 8
    //   4321: aload_0
    //   4322: iconst_5
    //   4323: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   4326: lload 4
    //   4328: lconst_0
    //   4329: lcmp
    //   4330: ifne +1384 -> 5714
    //   4333: lload_2
    //   4334: lconst_0
    //   4335: lcmp
    //   4336: ifle +1378 -> 5714
    //   4339: ldc 85
    //   4341: ldc_w 459
    //   4344: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4347: aload 33
    //   4349: lload_2
    //   4350: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   4353: aload_0
    //   4354: lload_2
    //   4355: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   4358: lload_2
    //   4359: ldc2_w 393
    //   4362: lcmp
    //   4363: ifge +15 -> 4378
    //   4366: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4369: dup
    //   4370: aload_0
    //   4371: iconst_1
    //   4372: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4375: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4378: aload 35
    //   4380: ifnull +8 -> 4388
    //   4383: aload 35
    //   4385: invokevirtual 218	java/io/InputStream:close	()V
    //   4388: aload 33
    //   4390: ifnull +8 -> 4398
    //   4393: aload 33
    //   4395: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   4398: aload 34
    //   4400: ifnull +16 -> 4416
    //   4403: aload 34
    //   4405: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4408: invokevirtual 218	java/io/InputStream:close	()V
    //   4411: aload 34
    //   4413: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   4416: aload_0
    //   4417: iconst_1
    //   4418: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4421: ldc 85
    //   4423: ldc_w 466
    //   4426: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4429: ldc_w 374
    //   4432: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4435: return
    //   4436: aload 33
    //   4438: astore 37
    //   4440: aload 34
    //   4442: astore 36
    //   4444: lload 4
    //   4446: lstore 8
    //   4448: lload_2
    //   4449: lstore 6
    //   4451: aload 45
    //   4453: astore 35
    //   4455: lload 4
    //   4457: lstore 20
    //   4459: lload_2
    //   4460: lstore 12
    //   4462: lload 4
    //   4464: lstore 26
    //   4466: lload_2
    //   4467: lstore 10
    //   4469: lload 4
    //   4471: lstore 28
    //   4473: lload_2
    //   4474: lstore 18
    //   4476: lload 4
    //   4478: lstore 24
    //   4480: lload_2
    //   4481: lstore 16
    //   4483: lload 4
    //   4485: lstore 22
    //   4487: lload_2
    //   4488: lstore 14
    //   4490: ldc_w 612
    //   4493: ldc_w 614
    //   4496: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4499: goto -1363 -> 3136
    //   4502: lload_2
    //   4503: lconst_0
    //   4504: lcmp
    //   4505: ifle +419 -> 4924
    //   4508: lload_2
    //   4509: aload 38
    //   4511: iconst_0
    //   4512: laload
    //   4513: lcmp
    //   4514: ifeq +410 -> 4924
    //   4517: aload 33
    //   4519: astore 37
    //   4521: aload 34
    //   4523: astore 36
    //   4525: lload 4
    //   4527: lstore 8
    //   4529: lload_2
    //   4530: lstore 6
    //   4532: aload 45
    //   4534: astore 35
    //   4536: lload 4
    //   4538: lstore 20
    //   4540: lload_2
    //   4541: lstore 12
    //   4543: lload 4
    //   4545: lstore 26
    //   4547: lload_2
    //   4548: lstore 10
    //   4550: lload 4
    //   4552: lstore 28
    //   4554: lload_2
    //   4555: lstore 18
    //   4557: lload 4
    //   4559: lstore 24
    //   4561: lload_2
    //   4562: lstore 16
    //   4564: lload 4
    //   4566: lstore 22
    //   4568: lload_2
    //   4569: lstore 14
    //   4571: ldc 85
    //   4573: ldc_w 616
    //   4576: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4579: aload 33
    //   4581: astore 37
    //   4583: aload 34
    //   4585: astore 36
    //   4587: lload 4
    //   4589: lstore 8
    //   4591: lload_2
    //   4592: lstore 6
    //   4594: aload 45
    //   4596: astore 35
    //   4598: lload 4
    //   4600: lstore 20
    //   4602: lload_2
    //   4603: lstore 12
    //   4605: lload 4
    //   4607: lstore 26
    //   4609: lload_2
    //   4610: lstore 10
    //   4612: lload 4
    //   4614: lstore 28
    //   4616: lload_2
    //   4617: lstore 18
    //   4619: lload 4
    //   4621: lstore 24
    //   4623: lload_2
    //   4624: lstore 16
    //   4626: lload 4
    //   4628: lstore 22
    //   4630: lload_2
    //   4631: lstore 14
    //   4633: aload_0
    //   4634: bipush 6
    //   4636: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   4639: lload 4
    //   4641: lconst_0
    //   4642: lcmp
    //   4643: ifne +115 -> 4758
    //   4646: lload_2
    //   4647: lconst_0
    //   4648: lcmp
    //   4649: ifle +109 -> 4758
    //   4652: ldc 85
    //   4654: ldc_w 459
    //   4657: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4660: aload 33
    //   4662: lload_2
    //   4663: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   4666: aload_0
    //   4667: lload_2
    //   4668: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   4671: lload_2
    //   4672: ldc2_w 393
    //   4675: lcmp
    //   4676: ifge +15 -> 4691
    //   4679: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4682: dup
    //   4683: aload_0
    //   4684: iconst_1
    //   4685: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4688: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4691: aload 33
    //   4693: ifnull +8 -> 4701
    //   4696: aload 33
    //   4698: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   4701: aload 34
    //   4703: ifnull +16 -> 4719
    //   4706: aload 34
    //   4708: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4711: invokevirtual 218	java/io/InputStream:close	()V
    //   4714: aload 34
    //   4716: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   4719: aload_0
    //   4720: iconst_1
    //   4721: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4724: ldc 85
    //   4726: ldc_w 466
    //   4729: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4732: ldc_w 374
    //   4735: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4738: return
    //   4739: astore 35
    //   4741: ldc 85
    //   4743: aload 35
    //   4745: ldc_w 468
    //   4748: iconst_0
    //   4749: anewarray 4	java/lang/Object
    //   4752: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4755: goto -89 -> 4666
    //   4758: lload 4
    //   4760: lconst_0
    //   4761: lcmp
    //   4762: ifeq +47 -> 4809
    //   4765: lload_2
    //   4766: lload 4
    //   4768: lcmp
    //   4769: ifeq +40 -> 4809
    //   4772: ldc 85
    //   4774: ldc_w 470
    //   4777: iconst_2
    //   4778: anewarray 4	java/lang/Object
    //   4781: dup
    //   4782: iconst_0
    //   4783: lload 4
    //   4785: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4788: aastore
    //   4789: dup
    //   4790: iconst_1
    //   4791: lload_2
    //   4792: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4795: aastore
    //   4796: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4799: aload_0
    //   4800: lload_2
    //   4801: lload 4
    //   4803: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   4806: goto -115 -> 4691
    //   4809: lload 4
    //   4811: lconst_0
    //   4812: lcmp
    //   4813: ifeq +66 -> 4879
    //   4816: lload_2
    //   4817: lload 4
    //   4819: lcmp
    //   4820: ifne +59 -> 4879
    //   4823: ldc 85
    //   4825: ldc_w 474
    //   4828: iconst_2
    //   4829: anewarray 4	java/lang/Object
    //   4832: dup
    //   4833: iconst_0
    //   4834: lload 4
    //   4836: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4839: aastore
    //   4840: dup
    //   4841: iconst_1
    //   4842: lload_2
    //   4843: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4846: aastore
    //   4847: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4850: aload_0
    //   4851: lload 4
    //   4853: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   4856: lload_2
    //   4857: ldc2_w 393
    //   4860: lcmp
    //   4861: ifge -170 -> 4691
    //   4864: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4867: dup
    //   4868: aload_0
    //   4869: iconst_1
    //   4870: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4873: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   4876: goto -185 -> 4691
    //   4879: ldc 85
    //   4881: ldc_w 476
    //   4884: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4887: goto -196 -> 4691
    //   4890: astore 33
    //   4892: ldc 85
    //   4894: aload 33
    //   4896: ldc_w 468
    //   4899: iconst_0
    //   4900: anewarray 4	java/lang/Object
    //   4903: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4906: goto -205 -> 4701
    //   4909: astore 33
    //   4911: ldc 85
    //   4913: aload 33
    //   4915: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4918: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4921: goto -207 -> 4714
    //   4924: aload 38
    //   4926: iconst_2
    //   4927: laload
    //   4928: lstore 4
    //   4930: goto +2951 -> 7881
    //   4933: lload 6
    //   4935: lstore 18
    //   4937: lload 6
    //   4939: lstore 16
    //   4941: aload 33
    //   4943: astore 37
    //   4945: aload 35
    //   4947: astore 39
    //   4949: aload 34
    //   4951: astore 36
    //   4953: lload 4
    //   4955: lstore 20
    //   4957: lload 6
    //   4959: lstore 8
    //   4961: lload 6
    //   4963: lstore 10
    //   4965: lload 6
    //   4967: lstore 12
    //   4969: lload 6
    //   4971: lstore 14
    //   4973: aload_0
    //   4974: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   4977: lload 6
    //   4979: putfield 68	com/tencent/mm/plugin/music/c/a:tVC	J
    //   4982: lload 6
    //   4984: lstore 18
    //   4986: lload 6
    //   4988: lstore 16
    //   4990: aload 33
    //   4992: astore 37
    //   4994: aload 35
    //   4996: astore 39
    //   4998: aload 34
    //   5000: astore 36
    //   5002: lload 4
    //   5004: lstore 20
    //   5006: lload 6
    //   5008: lstore 8
    //   5010: lload 6
    //   5012: lstore 10
    //   5014: lload 6
    //   5016: lstore 12
    //   5018: lload 6
    //   5020: lstore 14
    //   5022: aload_0
    //   5023: getfield 63	com/tencent/mm/plugin/music/c/b:tVJ	Lcom/tencent/mm/plugin/music/c/a;
    //   5026: lload 30
    //   5028: putfield 71	com/tencent/mm/plugin/music/c/a:tVD	J
    //   5031: goto -874 -> 4157
    //   5034: astore 38
    //   5036: aload 35
    //   5038: astore 39
    //   5040: lload 16
    //   5042: lstore_2
    //   5043: aload 33
    //   5045: astore 37
    //   5047: aload 34
    //   5049: astore 36
    //   5051: lload 4
    //   5053: lstore 8
    //   5055: lload_2
    //   5056: lstore 6
    //   5058: aload 39
    //   5060: astore 35
    //   5062: ldc 85
    //   5064: aload 38
    //   5066: ldc_w 610
    //   5069: iconst_1
    //   5070: anewarray 4	java/lang/Object
    //   5073: dup
    //   5074: iconst_0
    //   5075: aload 52
    //   5077: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   5080: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   5083: aastore
    //   5084: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5087: aload 33
    //   5089: astore 37
    //   5091: aload 34
    //   5093: astore 36
    //   5095: lload 4
    //   5097: lstore 8
    //   5099: lload_2
    //   5100: lstore 6
    //   5102: aload 39
    //   5104: astore 35
    //   5106: aload_0
    //   5107: sipush 751
    //   5110: putfield 59	com/tencent/mm/plugin/music/c/b:cUB	I
    //   5113: aload 33
    //   5115: astore 37
    //   5117: aload 34
    //   5119: astore 36
    //   5121: lload 4
    //   5123: lstore 8
    //   5125: lload_2
    //   5126: lstore 6
    //   5128: aload 39
    //   5130: astore 35
    //   5132: aload_0
    //   5133: iconst_5
    //   5134: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   5137: lload 4
    //   5139: lconst_0
    //   5140: lcmp
    //   5141: ifne +777 -> 5918
    //   5144: lload_2
    //   5145: lconst_0
    //   5146: lcmp
    //   5147: ifle +771 -> 5918
    //   5150: ldc 85
    //   5152: ldc_w 459
    //   5155: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5158: aload 33
    //   5160: lload_2
    //   5161: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   5164: aload_0
    //   5165: lload_2
    //   5166: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   5169: lload_2
    //   5170: ldc2_w 393
    //   5173: lcmp
    //   5174: ifge +15 -> 5189
    //   5177: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5180: dup
    //   5181: aload_0
    //   5182: iconst_1
    //   5183: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5186: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5189: aload 39
    //   5191: ifnull +8 -> 5199
    //   5194: aload 39
    //   5196: invokevirtual 218	java/io/InputStream:close	()V
    //   5199: aload 33
    //   5201: ifnull +8 -> 5209
    //   5204: aload 33
    //   5206: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   5209: aload 34
    //   5211: ifnull +16 -> 5227
    //   5214: aload 34
    //   5216: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5219: invokevirtual 218	java/io/InputStream:close	()V
    //   5222: aload 34
    //   5224: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   5227: aload_0
    //   5228: iconst_1
    //   5229: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5232: ldc 85
    //   5234: ldc_w 466
    //   5237: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5240: ldc_w 374
    //   5243: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5246: return
    //   5247: lload_2
    //   5248: lstore 18
    //   5250: lload_2
    //   5251: lstore 16
    //   5253: aload 33
    //   5255: astore 37
    //   5257: aload 35
    //   5259: astore 39
    //   5261: aload 34
    //   5263: astore 36
    //   5265: lload 4
    //   5267: lstore 20
    //   5269: lload_2
    //   5270: lstore 8
    //   5272: lload_2
    //   5273: lstore 10
    //   5275: lload_2
    //   5276: lstore 12
    //   5278: lload_2
    //   5279: lstore 14
    //   5281: ldc 85
    //   5283: ldc_w 618
    //   5286: iconst_4
    //   5287: anewarray 4	java/lang/Object
    //   5290: dup
    //   5291: iconst_0
    //   5292: iload_1
    //   5293: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5296: aastore
    //   5297: dup
    //   5298: iconst_1
    //   5299: aload_0
    //   5300: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5303: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5306: aastore
    //   5307: dup
    //   5308: iconst_2
    //   5309: lload_2
    //   5310: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5313: aastore
    //   5314: dup
    //   5315: iconst_3
    //   5316: lload 30
    //   5318: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5321: aastore
    //   5322: invokestatic 331	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5325: lload_2
    //   5326: lstore 18
    //   5328: lload_2
    //   5329: lstore 16
    //   5331: aload 33
    //   5333: astore 37
    //   5335: aload 35
    //   5337: astore 39
    //   5339: aload 34
    //   5341: astore 36
    //   5343: lload 4
    //   5345: lstore 20
    //   5347: lload_2
    //   5348: lstore 8
    //   5350: lload_2
    //   5351: lstore 10
    //   5353: lload_2
    //   5354: lstore 12
    //   5356: lload_2
    //   5357: lstore 14
    //   5359: ldc 85
    //   5361: ldc_w 620
    //   5364: iconst_1
    //   5365: anewarray 4	java/lang/Object
    //   5368: dup
    //   5369: iconst_0
    //   5370: aload_0
    //   5371: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5374: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5377: aastore
    //   5378: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5381: lload 4
    //   5383: lconst_0
    //   5384: lcmp
    //   5385: ifne +125 -> 5510
    //   5388: lload_2
    //   5389: lconst_0
    //   5390: lcmp
    //   5391: ifle +119 -> 5510
    //   5394: ldc 85
    //   5396: ldc_w 459
    //   5399: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5402: aload 33
    //   5404: lload_2
    //   5405: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   5408: aload_0
    //   5409: lload_2
    //   5410: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   5413: lload_2
    //   5414: ldc2_w 393
    //   5417: lcmp
    //   5418: ifge +15 -> 5433
    //   5421: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5424: dup
    //   5425: aload_0
    //   5426: iconst_1
    //   5427: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5430: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5433: aload 35
    //   5435: ifnull +8 -> 5443
    //   5438: aload 35
    //   5440: invokevirtual 218	java/io/InputStream:close	()V
    //   5443: aload 33
    //   5445: ifnull +8 -> 5453
    //   5448: aload 33
    //   5450: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   5453: aload 34
    //   5455: ifnull +16 -> 5471
    //   5458: aload 34
    //   5460: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5463: invokevirtual 218	java/io/InputStream:close	()V
    //   5466: aload 34
    //   5468: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   5471: aload_0
    //   5472: iconst_1
    //   5473: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5476: ldc 85
    //   5478: ldc_w 466
    //   5481: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5484: ldc_w 374
    //   5487: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5490: return
    //   5491: astore 36
    //   5493: ldc 85
    //   5495: aload 36
    //   5497: ldc_w 468
    //   5500: iconst_0
    //   5501: anewarray 4	java/lang/Object
    //   5504: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5507: goto -99 -> 5408
    //   5510: lload 4
    //   5512: lconst_0
    //   5513: lcmp
    //   5514: ifeq +47 -> 5561
    //   5517: lload_2
    //   5518: lload 4
    //   5520: lcmp
    //   5521: ifeq +40 -> 5561
    //   5524: ldc 85
    //   5526: ldc_w 470
    //   5529: iconst_2
    //   5530: anewarray 4	java/lang/Object
    //   5533: dup
    //   5534: iconst_0
    //   5535: lload 4
    //   5537: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5540: aastore
    //   5541: dup
    //   5542: iconst_1
    //   5543: lload_2
    //   5544: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5547: aastore
    //   5548: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5551: aload_0
    //   5552: lload_2
    //   5553: lload 4
    //   5555: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   5558: goto -125 -> 5433
    //   5561: lload 4
    //   5563: lconst_0
    //   5564: lcmp
    //   5565: ifeq +66 -> 5631
    //   5568: lload_2
    //   5569: lload 4
    //   5571: lcmp
    //   5572: ifne +59 -> 5631
    //   5575: ldc 85
    //   5577: ldc_w 474
    //   5580: iconst_2
    //   5581: anewarray 4	java/lang/Object
    //   5584: dup
    //   5585: iconst_0
    //   5586: lload 4
    //   5588: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5591: aastore
    //   5592: dup
    //   5593: iconst_1
    //   5594: lload_2
    //   5595: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5598: aastore
    //   5599: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5602: aload_0
    //   5603: lload 4
    //   5605: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   5608: lload_2
    //   5609: ldc2_w 393
    //   5612: lcmp
    //   5613: ifge -180 -> 5433
    //   5616: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5619: dup
    //   5620: aload_0
    //   5621: iconst_1
    //   5622: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5625: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5628: goto -195 -> 5433
    //   5631: ldc 85
    //   5633: ldc_w 476
    //   5636: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5639: goto -206 -> 5433
    //   5642: astore 35
    //   5644: ldc 85
    //   5646: aload 35
    //   5648: ldc_w 622
    //   5651: iconst_0
    //   5652: anewarray 4	java/lang/Object
    //   5655: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5658: goto -215 -> 5443
    //   5661: astore 33
    //   5663: ldc 85
    //   5665: aload 33
    //   5667: ldc_w 468
    //   5670: iconst_0
    //   5671: anewarray 4	java/lang/Object
    //   5674: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5677: goto -224 -> 5453
    //   5680: astore 33
    //   5682: ldc 85
    //   5684: aload 33
    //   5686: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5689: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5692: goto -226 -> 5466
    //   5695: astore 36
    //   5697: ldc 85
    //   5699: aload 36
    //   5701: ldc_w 468
    //   5704: iconst_0
    //   5705: anewarray 4	java/lang/Object
    //   5708: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5711: goto -1358 -> 4353
    //   5714: lload 4
    //   5716: lconst_0
    //   5717: lcmp
    //   5718: ifeq +47 -> 5765
    //   5721: lload_2
    //   5722: lload 4
    //   5724: lcmp
    //   5725: ifeq +40 -> 5765
    //   5728: ldc 85
    //   5730: ldc_w 470
    //   5733: iconst_2
    //   5734: anewarray 4	java/lang/Object
    //   5737: dup
    //   5738: iconst_0
    //   5739: lload 4
    //   5741: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5744: aastore
    //   5745: dup
    //   5746: iconst_1
    //   5747: lload_2
    //   5748: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5751: aastore
    //   5752: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5755: aload_0
    //   5756: lload_2
    //   5757: lload 4
    //   5759: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   5762: goto -1384 -> 4378
    //   5765: lload 4
    //   5767: lconst_0
    //   5768: lcmp
    //   5769: ifeq +66 -> 5835
    //   5772: lload_2
    //   5773: lload 4
    //   5775: lcmp
    //   5776: ifne +59 -> 5835
    //   5779: ldc 85
    //   5781: ldc_w 474
    //   5784: iconst_2
    //   5785: anewarray 4	java/lang/Object
    //   5788: dup
    //   5789: iconst_0
    //   5790: lload 4
    //   5792: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5795: aastore
    //   5796: dup
    //   5797: iconst_1
    //   5798: lload_2
    //   5799: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5802: aastore
    //   5803: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5806: aload_0
    //   5807: lload 4
    //   5809: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   5812: lload_2
    //   5813: ldc2_w 393
    //   5816: lcmp
    //   5817: ifge -1439 -> 4378
    //   5820: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5823: dup
    //   5824: aload_0
    //   5825: iconst_1
    //   5826: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5829: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   5832: goto -1454 -> 4378
    //   5835: ldc 85
    //   5837: ldc_w 476
    //   5840: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5843: goto -1465 -> 4378
    //   5846: astore 35
    //   5848: ldc 85
    //   5850: aload 35
    //   5852: ldc_w 622
    //   5855: iconst_0
    //   5856: anewarray 4	java/lang/Object
    //   5859: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5862: goto -1474 -> 4388
    //   5865: astore 33
    //   5867: ldc 85
    //   5869: aload 33
    //   5871: ldc_w 468
    //   5874: iconst_0
    //   5875: anewarray 4	java/lang/Object
    //   5878: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5881: goto -1483 -> 4398
    //   5884: astore 33
    //   5886: ldc 85
    //   5888: aload 33
    //   5890: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5893: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5896: goto -1485 -> 4411
    //   5899: astore 35
    //   5901: ldc 85
    //   5903: aload 35
    //   5905: ldc_w 468
    //   5908: iconst_0
    //   5909: anewarray 4	java/lang/Object
    //   5912: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5915: goto -751 -> 5164
    //   5918: lload 4
    //   5920: lconst_0
    //   5921: lcmp
    //   5922: ifeq +47 -> 5969
    //   5925: lload_2
    //   5926: lload 4
    //   5928: lcmp
    //   5929: ifeq +40 -> 5969
    //   5932: ldc 85
    //   5934: ldc_w 470
    //   5937: iconst_2
    //   5938: anewarray 4	java/lang/Object
    //   5941: dup
    //   5942: iconst_0
    //   5943: lload 4
    //   5945: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5948: aastore
    //   5949: dup
    //   5950: iconst_1
    //   5951: lload_2
    //   5952: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5955: aastore
    //   5956: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5959: aload_0
    //   5960: lload_2
    //   5961: lload 4
    //   5963: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   5966: goto -777 -> 5189
    //   5969: lload 4
    //   5971: lconst_0
    //   5972: lcmp
    //   5973: ifeq +66 -> 6039
    //   5976: lload_2
    //   5977: lload 4
    //   5979: lcmp
    //   5980: ifne +59 -> 6039
    //   5983: ldc 85
    //   5985: ldc_w 474
    //   5988: iconst_2
    //   5989: anewarray 4	java/lang/Object
    //   5992: dup
    //   5993: iconst_0
    //   5994: lload 4
    //   5996: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5999: aastore
    //   6000: dup
    //   6001: iconst_1
    //   6002: lload_2
    //   6003: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6006: aastore
    //   6007: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6010: aload_0
    //   6011: lload 4
    //   6013: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   6016: lload_2
    //   6017: ldc2_w 393
    //   6020: lcmp
    //   6021: ifge -832 -> 5189
    //   6024: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6027: dup
    //   6028: aload_0
    //   6029: iconst_1
    //   6030: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6033: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6036: goto -847 -> 5189
    //   6039: ldc 85
    //   6041: ldc_w 476
    //   6044: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6047: goto -858 -> 5189
    //   6050: astore 35
    //   6052: ldc 85
    //   6054: aload 35
    //   6056: ldc_w 622
    //   6059: iconst_0
    //   6060: anewarray 4	java/lang/Object
    //   6063: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6066: goto -867 -> 5199
    //   6069: astore 33
    //   6071: ldc 85
    //   6073: aload 33
    //   6075: ldc_w 468
    //   6078: iconst_0
    //   6079: anewarray 4	java/lang/Object
    //   6082: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6085: goto -876 -> 5209
    //   6088: astore 33
    //   6090: ldc 85
    //   6092: aload 33
    //   6094: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6097: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6100: goto -878 -> 5222
    //   6103: astore 38
    //   6105: aconst_null
    //   6106: astore 34
    //   6108: aload 44
    //   6110: astore 39
    //   6112: aload 37
    //   6114: astore 33
    //   6116: aload 33
    //   6118: astore 37
    //   6120: aload 34
    //   6122: astore 36
    //   6124: lload 4
    //   6126: lstore 8
    //   6128: lload_2
    //   6129: lstore 6
    //   6131: aload 39
    //   6133: astore 35
    //   6135: ldc 85
    //   6137: aload 38
    //   6139: ldc_w 610
    //   6142: iconst_1
    //   6143: anewarray 4	java/lang/Object
    //   6146: dup
    //   6147: iconst_0
    //   6148: aload 52
    //   6150: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   6153: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   6156: aastore
    //   6157: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6160: aload 33
    //   6162: astore 37
    //   6164: aload 34
    //   6166: astore 36
    //   6168: lload 4
    //   6170: lstore 8
    //   6172: lload_2
    //   6173: lstore 6
    //   6175: aload 39
    //   6177: astore 35
    //   6179: aload_0
    //   6180: sipush 752
    //   6183: putfield 59	com/tencent/mm/plugin/music/c/b:cUB	I
    //   6186: aload 33
    //   6188: astore 37
    //   6190: aload 34
    //   6192: astore 36
    //   6194: lload 4
    //   6196: lstore 8
    //   6198: lload_2
    //   6199: lstore 6
    //   6201: aload 39
    //   6203: astore 35
    //   6205: aload_0
    //   6206: iconst_5
    //   6207: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   6210: lload 4
    //   6212: lconst_0
    //   6213: lcmp
    //   6214: ifne +125 -> 6339
    //   6217: lload_2
    //   6218: lconst_0
    //   6219: lcmp
    //   6220: ifle +119 -> 6339
    //   6223: ldc 85
    //   6225: ldc_w 459
    //   6228: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6231: aload 33
    //   6233: lload_2
    //   6234: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   6237: aload_0
    //   6238: lload_2
    //   6239: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   6242: lload_2
    //   6243: ldc2_w 393
    //   6246: lcmp
    //   6247: ifge +15 -> 6262
    //   6250: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6253: dup
    //   6254: aload_0
    //   6255: iconst_1
    //   6256: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6259: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6262: aload 39
    //   6264: ifnull +8 -> 6272
    //   6267: aload 39
    //   6269: invokevirtual 218	java/io/InputStream:close	()V
    //   6272: aload 33
    //   6274: ifnull +8 -> 6282
    //   6277: aload 33
    //   6279: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   6282: aload 34
    //   6284: ifnull +16 -> 6300
    //   6287: aload 34
    //   6289: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6292: invokevirtual 218	java/io/InputStream:close	()V
    //   6295: aload 34
    //   6297: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   6300: aload_0
    //   6301: iconst_1
    //   6302: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6305: ldc 85
    //   6307: ldc_w 466
    //   6310: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6313: ldc_w 374
    //   6316: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6319: return
    //   6320: astore 35
    //   6322: ldc 85
    //   6324: aload 35
    //   6326: ldc_w 468
    //   6329: iconst_0
    //   6330: anewarray 4	java/lang/Object
    //   6333: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6336: goto -99 -> 6237
    //   6339: lload 4
    //   6341: lconst_0
    //   6342: lcmp
    //   6343: ifeq +47 -> 6390
    //   6346: lload_2
    //   6347: lload 4
    //   6349: lcmp
    //   6350: ifeq +40 -> 6390
    //   6353: ldc 85
    //   6355: ldc_w 470
    //   6358: iconst_2
    //   6359: anewarray 4	java/lang/Object
    //   6362: dup
    //   6363: iconst_0
    //   6364: lload 4
    //   6366: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6369: aastore
    //   6370: dup
    //   6371: iconst_1
    //   6372: lload_2
    //   6373: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6376: aastore
    //   6377: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6380: aload_0
    //   6381: lload_2
    //   6382: lload 4
    //   6384: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   6387: goto -125 -> 6262
    //   6390: lload 4
    //   6392: lconst_0
    //   6393: lcmp
    //   6394: ifeq +66 -> 6460
    //   6397: lload_2
    //   6398: lload 4
    //   6400: lcmp
    //   6401: ifne +59 -> 6460
    //   6404: ldc 85
    //   6406: ldc_w 474
    //   6409: iconst_2
    //   6410: anewarray 4	java/lang/Object
    //   6413: dup
    //   6414: iconst_0
    //   6415: lload 4
    //   6417: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6420: aastore
    //   6421: dup
    //   6422: iconst_1
    //   6423: lload_2
    //   6424: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6427: aastore
    //   6428: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6431: aload_0
    //   6432: lload 4
    //   6434: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   6437: lload_2
    //   6438: ldc2_w 393
    //   6441: lcmp
    //   6442: ifge -180 -> 6262
    //   6445: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6448: dup
    //   6449: aload_0
    //   6450: iconst_1
    //   6451: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6454: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6457: goto -195 -> 6262
    //   6460: ldc 85
    //   6462: ldc_w 476
    //   6465: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6468: goto -206 -> 6262
    //   6471: astore 35
    //   6473: ldc 85
    //   6475: aload 35
    //   6477: ldc_w 622
    //   6480: iconst_0
    //   6481: anewarray 4	java/lang/Object
    //   6484: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6487: goto -215 -> 6272
    //   6490: astore 33
    //   6492: ldc 85
    //   6494: aload 33
    //   6496: ldc_w 468
    //   6499: iconst_0
    //   6500: anewarray 4	java/lang/Object
    //   6503: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6506: goto -224 -> 6282
    //   6509: astore 33
    //   6511: ldc 85
    //   6513: aload 33
    //   6515: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6518: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6521: goto -226 -> 6295
    //   6524: astore 35
    //   6526: aconst_null
    //   6527: astore 34
    //   6529: aload 42
    //   6531: astore 39
    //   6533: aload 38
    //   6535: astore 33
    //   6537: aload 35
    //   6539: astore 38
    //   6541: aload 33
    //   6543: astore 37
    //   6545: aload 34
    //   6547: astore 36
    //   6549: lload 4
    //   6551: lstore 8
    //   6553: lload_2
    //   6554: lstore 6
    //   6556: aload 39
    //   6558: astore 35
    //   6560: ldc 85
    //   6562: aload 38
    //   6564: ldc_w 610
    //   6567: iconst_1
    //   6568: anewarray 4	java/lang/Object
    //   6571: dup
    //   6572: iconst_0
    //   6573: aload 52
    //   6575: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   6578: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   6581: aastore
    //   6582: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6585: aload 33
    //   6587: astore 37
    //   6589: aload 34
    //   6591: astore 36
    //   6593: lload 4
    //   6595: lstore 8
    //   6597: lload_2
    //   6598: lstore 6
    //   6600: aload 39
    //   6602: astore 35
    //   6604: aload_0
    //   6605: sipush 753
    //   6608: putfield 59	com/tencent/mm/plugin/music/c/b:cUB	I
    //   6611: aload 33
    //   6613: astore 37
    //   6615: aload 34
    //   6617: astore 36
    //   6619: lload 4
    //   6621: lstore 8
    //   6623: lload_2
    //   6624: lstore 6
    //   6626: aload 39
    //   6628: astore 35
    //   6630: aload_0
    //   6631: iconst_5
    //   6632: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   6635: lload 4
    //   6637: lconst_0
    //   6638: lcmp
    //   6639: ifne +125 -> 6764
    //   6642: lload_2
    //   6643: lconst_0
    //   6644: lcmp
    //   6645: ifle +119 -> 6764
    //   6648: ldc 85
    //   6650: ldc_w 459
    //   6653: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6656: aload 33
    //   6658: lload_2
    //   6659: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   6662: aload_0
    //   6663: lload_2
    //   6664: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   6667: lload_2
    //   6668: ldc2_w 393
    //   6671: lcmp
    //   6672: ifge +15 -> 6687
    //   6675: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6678: dup
    //   6679: aload_0
    //   6680: iconst_1
    //   6681: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6684: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6687: aload 39
    //   6689: ifnull +8 -> 6697
    //   6692: aload 39
    //   6694: invokevirtual 218	java/io/InputStream:close	()V
    //   6697: aload 33
    //   6699: ifnull +8 -> 6707
    //   6702: aload 33
    //   6704: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   6707: aload 34
    //   6709: ifnull +16 -> 6725
    //   6712: aload 34
    //   6714: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6717: invokevirtual 218	java/io/InputStream:close	()V
    //   6720: aload 34
    //   6722: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   6725: aload_0
    //   6726: iconst_1
    //   6727: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6730: ldc 85
    //   6732: ldc_w 466
    //   6735: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6738: ldc_w 374
    //   6741: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6744: return
    //   6745: astore 35
    //   6747: ldc 85
    //   6749: aload 35
    //   6751: ldc_w 468
    //   6754: iconst_0
    //   6755: anewarray 4	java/lang/Object
    //   6758: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6761: goto -99 -> 6662
    //   6764: lload 4
    //   6766: lconst_0
    //   6767: lcmp
    //   6768: ifeq +47 -> 6815
    //   6771: lload_2
    //   6772: lload 4
    //   6774: lcmp
    //   6775: ifeq +40 -> 6815
    //   6778: ldc 85
    //   6780: ldc_w 470
    //   6783: iconst_2
    //   6784: anewarray 4	java/lang/Object
    //   6787: dup
    //   6788: iconst_0
    //   6789: lload 4
    //   6791: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6794: aastore
    //   6795: dup
    //   6796: iconst_1
    //   6797: lload_2
    //   6798: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6801: aastore
    //   6802: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6805: aload_0
    //   6806: lload_2
    //   6807: lload 4
    //   6809: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   6812: goto -125 -> 6687
    //   6815: lload 4
    //   6817: lconst_0
    //   6818: lcmp
    //   6819: ifeq +66 -> 6885
    //   6822: lload_2
    //   6823: lload 4
    //   6825: lcmp
    //   6826: ifne +59 -> 6885
    //   6829: ldc 85
    //   6831: ldc_w 474
    //   6834: iconst_2
    //   6835: anewarray 4	java/lang/Object
    //   6838: dup
    //   6839: iconst_0
    //   6840: lload 4
    //   6842: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6845: aastore
    //   6846: dup
    //   6847: iconst_1
    //   6848: lload_2
    //   6849: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6852: aastore
    //   6853: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6856: aload_0
    //   6857: lload 4
    //   6859: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   6862: lload_2
    //   6863: ldc2_w 393
    //   6866: lcmp
    //   6867: ifge -180 -> 6687
    //   6870: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6873: dup
    //   6874: aload_0
    //   6875: iconst_1
    //   6876: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6879: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   6882: goto -195 -> 6687
    //   6885: ldc 85
    //   6887: ldc_w 476
    //   6890: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6893: goto -206 -> 6687
    //   6896: astore 35
    //   6898: ldc 85
    //   6900: aload 35
    //   6902: ldc_w 622
    //   6905: iconst_0
    //   6906: anewarray 4	java/lang/Object
    //   6909: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6912: goto -215 -> 6697
    //   6915: astore 33
    //   6917: ldc 85
    //   6919: aload 33
    //   6921: ldc_w 468
    //   6924: iconst_0
    //   6925: anewarray 4	java/lang/Object
    //   6928: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6931: goto -224 -> 6707
    //   6934: astore 33
    //   6936: ldc 85
    //   6938: aload 33
    //   6940: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6943: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6946: goto -226 -> 6720
    //   6949: astore 38
    //   6951: aconst_null
    //   6952: astore 34
    //   6954: aload 43
    //   6956: astore 39
    //   6958: aload 35
    //   6960: astore 33
    //   6962: aload 33
    //   6964: astore 37
    //   6966: aload 34
    //   6968: astore 36
    //   6970: lload 4
    //   6972: lstore 8
    //   6974: lload_2
    //   6975: lstore 6
    //   6977: aload 39
    //   6979: astore 35
    //   6981: ldc 85
    //   6983: aload 38
    //   6985: ldc_w 610
    //   6988: iconst_1
    //   6989: anewarray 4	java/lang/Object
    //   6992: dup
    //   6993: iconst_0
    //   6994: aload 52
    //   6996: invokevirtual 443	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   6999: invokestatic 449	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   7002: aastore
    //   7003: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7006: aload 33
    //   7008: astore 37
    //   7010: aload 34
    //   7012: astore 36
    //   7014: lload 4
    //   7016: lstore 8
    //   7018: lload_2
    //   7019: lstore 6
    //   7021: aload 39
    //   7023: astore 35
    //   7025: aload_0
    //   7026: sipush 754
    //   7029: putfield 59	com/tencent/mm/plugin/music/c/b:cUB	I
    //   7032: aload 33
    //   7034: astore 37
    //   7036: aload 34
    //   7038: astore 36
    //   7040: lload 4
    //   7042: lstore 8
    //   7044: lload_2
    //   7045: lstore 6
    //   7047: aload 39
    //   7049: astore 35
    //   7051: aload_0
    //   7052: iconst_5
    //   7053: invokespecial 437	com/tencent/mm/plugin/music/c/b:HG	(I)V
    //   7056: lload 4
    //   7058: lconst_0
    //   7059: lcmp
    //   7060: ifne +125 -> 7185
    //   7063: lload_2
    //   7064: lconst_0
    //   7065: lcmp
    //   7066: ifle +119 -> 7185
    //   7069: ldc 85
    //   7071: ldc_w 459
    //   7074: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7077: aload 33
    //   7079: lload_2
    //   7080: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   7083: aload_0
    //   7084: lload_2
    //   7085: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   7088: lload_2
    //   7089: ldc2_w 393
    //   7092: lcmp
    //   7093: ifge +15 -> 7108
    //   7096: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7099: dup
    //   7100: aload_0
    //   7101: iconst_1
    //   7102: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7105: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7108: aload 39
    //   7110: ifnull +8 -> 7118
    //   7113: aload 39
    //   7115: invokevirtual 218	java/io/InputStream:close	()V
    //   7118: aload 33
    //   7120: ifnull +8 -> 7128
    //   7123: aload 33
    //   7125: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   7128: aload 34
    //   7130: ifnull +16 -> 7146
    //   7133: aload 34
    //   7135: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7138: invokevirtual 218	java/io/InputStream:close	()V
    //   7141: aload 34
    //   7143: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   7146: aload_0
    //   7147: iconst_1
    //   7148: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   7151: ldc 85
    //   7153: ldc_w 466
    //   7156: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7159: ldc_w 374
    //   7162: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7165: return
    //   7166: astore 35
    //   7168: ldc 85
    //   7170: aload 35
    //   7172: ldc_w 468
    //   7175: iconst_0
    //   7176: anewarray 4	java/lang/Object
    //   7179: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7182: goto -99 -> 7083
    //   7185: lload 4
    //   7187: lconst_0
    //   7188: lcmp
    //   7189: ifeq +47 -> 7236
    //   7192: lload_2
    //   7193: lload 4
    //   7195: lcmp
    //   7196: ifeq +40 -> 7236
    //   7199: ldc 85
    //   7201: ldc_w 470
    //   7204: iconst_2
    //   7205: anewarray 4	java/lang/Object
    //   7208: dup
    //   7209: iconst_0
    //   7210: lload 4
    //   7212: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7215: aastore
    //   7216: dup
    //   7217: iconst_1
    //   7218: lload_2
    //   7219: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7222: aastore
    //   7223: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7226: aload_0
    //   7227: lload_2
    //   7228: lload 4
    //   7230: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   7233: goto -125 -> 7108
    //   7236: lload 4
    //   7238: lconst_0
    //   7239: lcmp
    //   7240: ifeq +66 -> 7306
    //   7243: lload_2
    //   7244: lload 4
    //   7246: lcmp
    //   7247: ifne +59 -> 7306
    //   7250: ldc 85
    //   7252: ldc_w 474
    //   7255: iconst_2
    //   7256: anewarray 4	java/lang/Object
    //   7259: dup
    //   7260: iconst_0
    //   7261: lload 4
    //   7263: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7266: aastore
    //   7267: dup
    //   7268: iconst_1
    //   7269: lload_2
    //   7270: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7273: aastore
    //   7274: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7277: aload_0
    //   7278: lload 4
    //   7280: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   7283: lload_2
    //   7284: ldc2_w 393
    //   7287: lcmp
    //   7288: ifge -180 -> 7108
    //   7291: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7294: dup
    //   7295: aload_0
    //   7296: iconst_1
    //   7297: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7300: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7303: goto -195 -> 7108
    //   7306: ldc 85
    //   7308: ldc_w 476
    //   7311: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7314: goto -206 -> 7108
    //   7317: astore 35
    //   7319: ldc 85
    //   7321: aload 35
    //   7323: ldc_w 622
    //   7326: iconst_0
    //   7327: anewarray 4	java/lang/Object
    //   7330: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7333: goto -215 -> 7118
    //   7336: astore 33
    //   7338: ldc 85
    //   7340: aload 33
    //   7342: ldc_w 468
    //   7345: iconst_0
    //   7346: anewarray 4	java/lang/Object
    //   7349: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7352: goto -224 -> 7128
    //   7355: astore 33
    //   7357: ldc 85
    //   7359: aload 33
    //   7361: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7364: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7367: goto -226 -> 7141
    //   7370: astore 33
    //   7372: aconst_null
    //   7373: astore 34
    //   7375: aload 46
    //   7377: astore 35
    //   7379: aload 36
    //   7381: astore 37
    //   7383: lload 4
    //   7385: lconst_0
    //   7386: lcmp
    //   7387: ifne +127 -> 7514
    //   7390: lload_2
    //   7391: lconst_0
    //   7392: lcmp
    //   7393: ifle +121 -> 7514
    //   7396: ldc 85
    //   7398: ldc_w 459
    //   7401: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7404: aload 37
    //   7406: lload_2
    //   7407: invokevirtual 552	java/io/RandomAccessFile:setLength	(J)V
    //   7410: aload_0
    //   7411: lload_2
    //   7412: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   7415: lload_2
    //   7416: ldc2_w 393
    //   7419: lcmp
    //   7420: ifge +15 -> 7435
    //   7423: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7426: dup
    //   7427: aload_0
    //   7428: iconst_1
    //   7429: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7432: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7435: aload 35
    //   7437: ifnull +8 -> 7445
    //   7440: aload 35
    //   7442: invokevirtual 218	java/io/InputStream:close	()V
    //   7445: aload 37
    //   7447: ifnull +8 -> 7455
    //   7450: aload 37
    //   7452: invokevirtual 553	java/io/RandomAccessFile:close	()V
    //   7455: aload 34
    //   7457: ifnull +16 -> 7473
    //   7460: aload 34
    //   7462: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7465: invokevirtual 218	java/io/InputStream:close	()V
    //   7468: aload 34
    //   7470: invokevirtual 221	java/net/HttpURLConnection:disconnect	()V
    //   7473: aload_0
    //   7474: iconst_1
    //   7475: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   7478: ldc 85
    //   7480: ldc_w 466
    //   7483: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7486: ldc_w 374
    //   7489: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7492: aload 33
    //   7494: athrow
    //   7495: astore 36
    //   7497: ldc 85
    //   7499: aload 36
    //   7501: ldc_w 468
    //   7504: iconst_0
    //   7505: anewarray 4	java/lang/Object
    //   7508: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7511: goto -101 -> 7410
    //   7514: lload 4
    //   7516: lconst_0
    //   7517: lcmp
    //   7518: ifeq +47 -> 7565
    //   7521: lload_2
    //   7522: lload 4
    //   7524: lcmp
    //   7525: ifeq +40 -> 7565
    //   7528: ldc 85
    //   7530: ldc_w 470
    //   7533: iconst_2
    //   7534: anewarray 4	java/lang/Object
    //   7537: dup
    //   7538: iconst_0
    //   7539: lload 4
    //   7541: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7544: aastore
    //   7545: dup
    //   7546: iconst_1
    //   7547: lload_2
    //   7548: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7551: aastore
    //   7552: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7555: aload_0
    //   7556: lload_2
    //   7557: lload 4
    //   7559: invokespecial 472	com/tencent/mm/plugin/music/c/b:ab	(JJ)V
    //   7562: goto -127 -> 7435
    //   7565: lload 4
    //   7567: lconst_0
    //   7568: lcmp
    //   7569: ifeq +66 -> 7635
    //   7572: lload_2
    //   7573: lload 4
    //   7575: lcmp
    //   7576: ifne +59 -> 7635
    //   7579: ldc 85
    //   7581: ldc_w 474
    //   7584: iconst_2
    //   7585: anewarray 4	java/lang/Object
    //   7588: dup
    //   7589: iconst_0
    //   7590: lload 4
    //   7592: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7595: aastore
    //   7596: dup
    //   7597: iconst_1
    //   7598: lload_2
    //   7599: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7602: aastore
    //   7603: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7606: aload_0
    //   7607: lload 4
    //   7609: invokespecial 464	com/tencent/mm/plugin/music/c/b:ry	(J)V
    //   7612: lload_2
    //   7613: ldc2_w 393
    //   7616: lcmp
    //   7617: ifge -182 -> 7435
    //   7620: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7623: dup
    //   7624: aload_0
    //   7625: iconst_1
    //   7626: invokespecial 133	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7629: invokestatic 139	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   7632: goto -197 -> 7435
    //   7635: ldc 85
    //   7637: ldc_w 476
    //   7640: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7643: goto -208 -> 7435
    //   7646: astore 35
    //   7648: ldc 85
    //   7650: aload 35
    //   7652: ldc_w 622
    //   7655: iconst_0
    //   7656: anewarray 4	java/lang/Object
    //   7659: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7662: goto -217 -> 7445
    //   7665: astore 35
    //   7667: ldc 85
    //   7669: aload 35
    //   7671: ldc_w 468
    //   7674: iconst_0
    //   7675: anewarray 4	java/lang/Object
    //   7678: invokestatic 453	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7681: goto -226 -> 7455
    //   7684: astore 35
    //   7686: ldc 85
    //   7688: aload 35
    //   7690: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7693: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7696: goto -228 -> 7468
    //   7699: astore 33
    //   7701: aload 36
    //   7703: astore 34
    //   7705: lload 8
    //   7707: lstore 4
    //   7709: lload 6
    //   7711: lstore_2
    //   7712: goto -329 -> 7383
    //   7715: astore 33
    //   7717: aload 39
    //   7719: astore 35
    //   7721: aload 36
    //   7723: astore 34
    //   7725: lload 20
    //   7727: lstore 4
    //   7729: lload 8
    //   7731: lstore_2
    //   7732: goto -349 -> 7383
    //   7735: astore 38
    //   7737: lload 20
    //   7739: lstore 4
    //   7741: lload 12
    //   7743: lstore_2
    //   7744: aload 43
    //   7746: astore 39
    //   7748: goto -786 -> 6962
    //   7751: astore 38
    //   7753: lload 10
    //   7755: lstore_2
    //   7756: aload 35
    //   7758: astore 39
    //   7760: goto -798 -> 6962
    //   7763: astore 38
    //   7765: lload 26
    //   7767: lstore 4
    //   7769: lload 10
    //   7771: lstore_2
    //   7772: aload 42
    //   7774: astore 39
    //   7776: goto -1235 -> 6541
    //   7779: astore 38
    //   7781: lload 12
    //   7783: lstore_2
    //   7784: aload 35
    //   7786: astore 39
    //   7788: goto -1247 -> 6541
    //   7791: astore 38
    //   7793: lload 28
    //   7795: lstore 4
    //   7797: lload 18
    //   7799: lstore_2
    //   7800: aload 44
    //   7802: astore 39
    //   7804: goto -1688 -> 6116
    //   7807: astore 38
    //   7809: lload 14
    //   7811: lstore_2
    //   7812: aload 35
    //   7814: astore 39
    //   7816: goto -1700 -> 6116
    //   7819: astore 38
    //   7821: aconst_null
    //   7822: astore 34
    //   7824: aload 39
    //   7826: astore 33
    //   7828: aload 41
    //   7830: astore 39
    //   7832: goto -2789 -> 5043
    //   7835: astore 38
    //   7837: lload 24
    //   7839: lstore 4
    //   7841: lload 16
    //   7843: lstore_2
    //   7844: aload 41
    //   7846: astore 39
    //   7848: goto -2805 -> 5043
    //   7851: astore 38
    //   7853: aconst_null
    //   7854: astore 35
    //   7856: aconst_null
    //   7857: astore 36
    //   7859: aload 34
    //   7861: astore 33
    //   7863: aload 36
    //   7865: astore 34
    //   7867: goto -3635 -> 4232
    //   7870: lload 30
    //   7872: lstore 6
    //   7874: lload 4
    //   7876: lstore_2
    //   7877: lload 6
    //   7879: lstore 4
    //   7881: ldc2_w 623
    //   7884: lstore 30
    //   7886: lload 4
    //   7888: lconst_0
    //   7889: lcmp
    //   7890: ifeq -4400 -> 3490
    //   7893: lload 4
    //   7895: lstore 30
    //   7897: goto -4407 -> 3490
    //   7900: astore 38
    //   7902: aconst_null
    //   7903: astore 35
    //   7905: lload 22
    //   7907: lstore 4
    //   7909: lload 14
    //   7911: lstore_2
    //   7912: goto -3680 -> 4232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7915	0	this	b
    //   176	5117	1	i	int
    //   163	7749	2	l1	long
    //   130	7778	4	l2	long
    //   121	7757	6	l3	long
    //   231	7499	8	l4	long
    //   1760	6010	10	l5	long
    //   1753	6029	12	l6	long
    //   1781	6129	14	l7	long
    //   1774	6068	16	l8	long
    //   1767	6031	18	l9	long
    //   1750	5988	20	l10	long
    //   1778	6128	22	l11	long
    //   1771	6067	24	l12	long
    //   1757	6009	26	l13	long
    //   1764	6030	28	l14	long
    //   3327	4569	30	l15	long
    //   32	1522	32	bool	boolean
    //   24	534	33	localObject1	Object
    //   811	5	33	localIOException1	java.io.IOException
    //   916	111	33	localObject2	Object
    //   1130	152	33	localIOException2	java.io.IOException
    //   1317	793	33	localRandomAccessFile	java.io.RandomAccessFile
    //   2303	5	33	localIOException3	java.io.IOException
    //   2322	2375	33	localException1	Exception
    //   4890	5	33	localIOException4	java.io.IOException
    //   4909	540	33	localException2	Exception
    //   5661	5	33	localIOException5	java.io.IOException
    //   5680	5	33	localException3	Exception
    //   5865	5	33	localIOException6	java.io.IOException
    //   5884	5	33	localException4	Exception
    //   6069	5	33	localIOException7	java.io.IOException
    //   6088	5	33	localException5	Exception
    //   6114	164	33	localObject3	Object
    //   6490	5	33	localIOException8	java.io.IOException
    //   6509	5	33	localException6	Exception
    //   6535	168	33	localObject4	Object
    //   6915	5	33	localIOException9	java.io.IOException
    //   6934	5	33	localException7	Exception
    //   6960	164	33	localObject5	Object
    //   7336	5	33	localIOException10	java.io.IOException
    //   7355	5	33	localException8	Exception
    //   7370	123	33	localObject6	Object
    //   7699	1	33	localObject7	Object
    //   7715	1	33	localObject8	Object
    //   7826	36	33	localObject9	Object
    //   21	7845	34	localObject10	Object
    //   50	1961	35	localObject11	Object
    //   2152	5	35	localIOException11	java.io.IOException
    //   2354	2243	35	localObject12	Object
    //   4739	298	35	localIOException12	java.io.IOException
    //   5060	379	35	localObject13	Object
    //   5642	5	35	localIOException13	java.io.IOException
    //   5846	5	35	localIOException14	java.io.IOException
    //   5899	5	35	localIOException15	java.io.IOException
    //   6050	5	35	localIOException16	java.io.IOException
    //   6133	71	35	localObject14	Object
    //   6320	5	35	localIOException17	java.io.IOException
    //   6471	5	35	localIOException18	java.io.IOException
    //   6524	14	35	localIOException19	java.io.IOException
    //   6558	71	35	localObject15	Object
    //   6745	5	35	localIOException20	java.io.IOException
    //   6896	63	35	localIOException21	java.io.IOException
    //   6979	71	35	localObject16	Object
    //   7166	5	35	localIOException22	java.io.IOException
    //   7317	5	35	localIOException23	java.io.IOException
    //   7377	64	35	localObject17	Object
    //   7646	5	35	localIOException24	java.io.IOException
    //   7665	5	35	localIOException25	java.io.IOException
    //   7684	5	35	localException9	Exception
    //   7719	185	35	localObject18	Object
    //   932	4410	36	localObject19	Object
    //   5491	5	36	localIOException26	java.io.IOException
    //   5695	5	36	localIOException27	java.io.IOException
    //   6122	1258	36	localObject20	Object
    //   7495	227	36	localIOException28	java.io.IOException
    //   7857	7	36	localObject21	Object
    //   920	6531	37	localObject22	Object
    //   924	3008	38	localObject23	Object
    //   4227	698	38	localProtocolException1	java.net.ProtocolException
    //   5034	31	38	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   6103	431	38	localUnknownServiceException1	java.net.UnknownServiceException
    //   6539	24	38	localIOException29	java.io.IOException
    //   6949	35	38	localException10	Exception
    //   7735	1	38	localException11	Exception
    //   7751	1	38	localException12	Exception
    //   7763	1	38	localIOException30	java.io.IOException
    //   7779	1	38	localIOException31	java.io.IOException
    //   7791	1	38	localUnknownServiceException2	java.net.UnknownServiceException
    //   7807	1	38	localUnknownServiceException3	java.net.UnknownServiceException
    //   7819	1	38	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   7835	1	38	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   7851	1	38	localProtocolException2	java.net.ProtocolException
    //   7900	1	38	localProtocolException3	java.net.ProtocolException
    //   936	6911	39	localObject24	Object
    //   179	1547	40	localObject25	Object
    //   898	6947	41	localObject26	Object
    //   886	6887	42	localObject27	Object
    //   889	6856	43	localObject28	Object
    //   883	6918	44	localObject29	Object
    //   895	3700	45	localObject30	Object
    //   892	6484	46	localObject31	Object
    //   904	815	47	localHashMap	java.util.HashMap
    //   910	388	48	localObject32	Object
    //   901	385	49	localObject33	Object
    //   913	389	50	localObject34	Object
    //   907	387	51	localObject35	Object
    //   228	6767	52	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   244	267	811	java/io/IOException
    //   1077	1085	1130	java/io/IOException
    //   2073	2079	2152	java/io/IOException
    //   2109	2114	2303	java/io/IOException
    //   2119	2127	2322	java/lang/Exception
    //   3801	3808	4227	java/net/ProtocolException
    //   3842	3849	4227	java/net/ProtocolException
    //   3883	3891	4227	java/net/ProtocolException
    //   3929	3938	4227	java/net/ProtocolException
    //   3984	4012	4227	java/net/ProtocolException
    //   4052	4059	4227	java/net/ProtocolException
    //   4099	4108	4227	java/net/ProtocolException
    //   4148	4157	4227	java/net/ProtocolException
    //   4209	4221	4227	java/net/ProtocolException
    //   4973	4982	4227	java/net/ProtocolException
    //   5022	5031	4227	java/net/ProtocolException
    //   5281	5325	4227	java/net/ProtocolException
    //   5359	5381	4227	java/net/ProtocolException
    //   4660	4666	4739	java/io/IOException
    //   4696	4701	4890	java/io/IOException
    //   4706	4714	4909	java/lang/Exception
    //   3801	3808	5034	java/net/NoRouteToHostException
    //   3842	3849	5034	java/net/NoRouteToHostException
    //   3883	3891	5034	java/net/NoRouteToHostException
    //   3929	3938	5034	java/net/NoRouteToHostException
    //   3984	4012	5034	java/net/NoRouteToHostException
    //   4052	4059	5034	java/net/NoRouteToHostException
    //   4099	4108	5034	java/net/NoRouteToHostException
    //   4148	4157	5034	java/net/NoRouteToHostException
    //   4209	4221	5034	java/net/NoRouteToHostException
    //   4973	4982	5034	java/net/NoRouteToHostException
    //   5022	5031	5034	java/net/NoRouteToHostException
    //   5281	5325	5034	java/net/NoRouteToHostException
    //   5359	5381	5034	java/net/NoRouteToHostException
    //   5402	5408	5491	java/io/IOException
    //   5438	5443	5642	java/io/IOException
    //   5448	5453	5661	java/io/IOException
    //   5458	5466	5680	java/lang/Exception
    //   4347	4353	5695	java/io/IOException
    //   4383	4388	5846	java/io/IOException
    //   4393	4398	5865	java/io/IOException
    //   4403	4411	5884	java/lang/Exception
    //   5158	5164	5899	java/io/IOException
    //   5194	5199	6050	java/io/IOException
    //   5204	5209	6069	java/io/IOException
    //   5214	5222	6088	java/lang/Exception
    //   942	950	6103	java/net/UnknownServiceException
    //   974	979	6103	java/net/UnknownServiceException
    //   1003	1026	6103	java/net/UnknownServiceException
    //   1050	1056	6103	java/net/UnknownServiceException
    //   1305	1319	6103	java/net/UnknownServiceException
    //   1343	1360	6103	java/net/UnknownServiceException
    //   1384	1395	6103	java/net/UnknownServiceException
    //   1419	1433	6103	java/net/UnknownServiceException
    //   1464	1491	6103	java/net/UnknownServiceException
    //   1515	1553	6103	java/net/UnknownServiceException
    //   1582	1590	6103	java/net/UnknownServiceException
    //   1614	1622	6103	java/net/UnknownServiceException
    //   1646	1691	6103	java/net/UnknownServiceException
    //   1715	1725	6103	java/net/UnknownServiceException
    //   6231	6237	6320	java/io/IOException
    //   6267	6272	6471	java/io/IOException
    //   6277	6282	6490	java/io/IOException
    //   6287	6295	6509	java/lang/Exception
    //   942	950	6524	java/io/IOException
    //   974	979	6524	java/io/IOException
    //   1003	1026	6524	java/io/IOException
    //   1050	1056	6524	java/io/IOException
    //   1305	1319	6524	java/io/IOException
    //   1343	1360	6524	java/io/IOException
    //   1384	1395	6524	java/io/IOException
    //   1419	1433	6524	java/io/IOException
    //   1464	1491	6524	java/io/IOException
    //   1515	1553	6524	java/io/IOException
    //   1582	1590	6524	java/io/IOException
    //   1614	1622	6524	java/io/IOException
    //   1646	1691	6524	java/io/IOException
    //   1715	1725	6524	java/io/IOException
    //   6656	6662	6745	java/io/IOException
    //   6692	6697	6896	java/io/IOException
    //   6702	6707	6915	java/io/IOException
    //   6712	6720	6934	java/lang/Exception
    //   942	950	6949	java/lang/Exception
    //   974	979	6949	java/lang/Exception
    //   1003	1026	6949	java/lang/Exception
    //   1050	1056	6949	java/lang/Exception
    //   1305	1319	6949	java/lang/Exception
    //   1343	1360	6949	java/lang/Exception
    //   1384	1395	6949	java/lang/Exception
    //   1419	1433	6949	java/lang/Exception
    //   1464	1491	6949	java/lang/Exception
    //   1515	1553	6949	java/lang/Exception
    //   1582	1590	6949	java/lang/Exception
    //   1614	1622	6949	java/lang/Exception
    //   1646	1691	6949	java/lang/Exception
    //   1715	1725	6949	java/lang/Exception
    //   7077	7083	7166	java/io/IOException
    //   7113	7118	7317	java/io/IOException
    //   7123	7128	7336	java/io/IOException
    //   7133	7141	7355	java/lang/Exception
    //   942	950	7370	finally
    //   974	979	7370	finally
    //   1003	1026	7370	finally
    //   1050	1056	7370	finally
    //   1305	1319	7370	finally
    //   1343	1360	7370	finally
    //   1384	1395	7370	finally
    //   1419	1433	7370	finally
    //   1464	1491	7370	finally
    //   1515	1553	7370	finally
    //   1582	1590	7370	finally
    //   1614	1622	7370	finally
    //   1646	1691	7370	finally
    //   1715	1725	7370	finally
    //   7404	7410	7495	java/io/IOException
    //   7440	7445	7646	java/io/IOException
    //   7450	7455	7665	java/io/IOException
    //   7460	7468	7684	java/lang/Exception
    //   1783	1789	7699	finally
    //   1857	1861	7699	finally
    //   1915	1934	7699	finally
    //   1988	1993	7699	finally
    //   2047	2052	7699	finally
    //   2391	2410	7699	finally
    //   2464	2493	7699	finally
    //   2547	2554	7699	finally
    //   2608	2625	7699	finally
    //   2679	2685	7699	finally
    //   2739	2749	7699	finally
    //   2803	2816	7699	finally
    //   2870	2881	7699	finally
    //   2935	2944	7699	finally
    //   2998	3004	7699	finally
    //   3058	3064	7699	finally
    //   3118	3136	7699	finally
    //   3190	3200	7699	finally
    //   3254	3261	7699	finally
    //   3315	3329	7699	finally
    //   3383	3408	7699	finally
    //   3467	3475	7699	finally
    //   3544	3581	7699	finally
    //   3635	3642	7699	finally
    //   3696	3702	7699	finally
    //   3756	3763	7699	finally
    //   4490	4499	7699	finally
    //   4571	4579	7699	finally
    //   4633	4639	7699	finally
    //   5062	5087	7699	finally
    //   5106	5113	7699	finally
    //   5132	5137	7699	finally
    //   6135	6160	7699	finally
    //   6179	6186	7699	finally
    //   6205	6210	7699	finally
    //   6560	6585	7699	finally
    //   6604	6611	7699	finally
    //   6630	6635	7699	finally
    //   6981	7006	7699	finally
    //   7025	7032	7699	finally
    //   7051	7056	7699	finally
    //   3801	3808	7715	finally
    //   3842	3849	7715	finally
    //   3883	3891	7715	finally
    //   3929	3938	7715	finally
    //   3984	4012	7715	finally
    //   4052	4059	7715	finally
    //   4099	4108	7715	finally
    //   4148	4157	7715	finally
    //   4209	4221	7715	finally
    //   4251	4276	7715	finally
    //   4295	4302	7715	finally
    //   4321	4326	7715	finally
    //   4973	4982	7715	finally
    //   5022	5031	7715	finally
    //   5281	5325	7715	finally
    //   5359	5381	7715	finally
    //   1783	1789	7735	java/lang/Exception
    //   1857	1861	7735	java/lang/Exception
    //   1915	1934	7735	java/lang/Exception
    //   1988	1993	7735	java/lang/Exception
    //   2047	2052	7735	java/lang/Exception
    //   2391	2410	7735	java/lang/Exception
    //   2464	2493	7735	java/lang/Exception
    //   2547	2554	7735	java/lang/Exception
    //   2608	2625	7735	java/lang/Exception
    //   2679	2685	7735	java/lang/Exception
    //   2739	2749	7735	java/lang/Exception
    //   2803	2816	7735	java/lang/Exception
    //   2870	2881	7735	java/lang/Exception
    //   2935	2944	7735	java/lang/Exception
    //   2998	3004	7735	java/lang/Exception
    //   3058	3064	7735	java/lang/Exception
    //   3118	3136	7735	java/lang/Exception
    //   3190	3200	7735	java/lang/Exception
    //   3254	3261	7735	java/lang/Exception
    //   3315	3329	7735	java/lang/Exception
    //   3383	3408	7735	java/lang/Exception
    //   3467	3475	7735	java/lang/Exception
    //   3544	3581	7735	java/lang/Exception
    //   3635	3642	7735	java/lang/Exception
    //   3696	3702	7735	java/lang/Exception
    //   3756	3763	7735	java/lang/Exception
    //   4490	4499	7735	java/lang/Exception
    //   4571	4579	7735	java/lang/Exception
    //   4633	4639	7735	java/lang/Exception
    //   3801	3808	7751	java/lang/Exception
    //   3842	3849	7751	java/lang/Exception
    //   3883	3891	7751	java/lang/Exception
    //   3929	3938	7751	java/lang/Exception
    //   3984	4012	7751	java/lang/Exception
    //   4052	4059	7751	java/lang/Exception
    //   4099	4108	7751	java/lang/Exception
    //   4148	4157	7751	java/lang/Exception
    //   4209	4221	7751	java/lang/Exception
    //   4973	4982	7751	java/lang/Exception
    //   5022	5031	7751	java/lang/Exception
    //   5281	5325	7751	java/lang/Exception
    //   5359	5381	7751	java/lang/Exception
    //   1783	1789	7763	java/io/IOException
    //   1857	1861	7763	java/io/IOException
    //   1915	1934	7763	java/io/IOException
    //   1988	1993	7763	java/io/IOException
    //   2047	2052	7763	java/io/IOException
    //   2391	2410	7763	java/io/IOException
    //   2464	2493	7763	java/io/IOException
    //   2547	2554	7763	java/io/IOException
    //   2608	2625	7763	java/io/IOException
    //   2679	2685	7763	java/io/IOException
    //   2739	2749	7763	java/io/IOException
    //   2803	2816	7763	java/io/IOException
    //   2870	2881	7763	java/io/IOException
    //   2935	2944	7763	java/io/IOException
    //   2998	3004	7763	java/io/IOException
    //   3058	3064	7763	java/io/IOException
    //   3118	3136	7763	java/io/IOException
    //   3190	3200	7763	java/io/IOException
    //   3254	3261	7763	java/io/IOException
    //   3315	3329	7763	java/io/IOException
    //   3383	3408	7763	java/io/IOException
    //   3467	3475	7763	java/io/IOException
    //   3544	3581	7763	java/io/IOException
    //   3635	3642	7763	java/io/IOException
    //   3696	3702	7763	java/io/IOException
    //   3756	3763	7763	java/io/IOException
    //   4490	4499	7763	java/io/IOException
    //   4571	4579	7763	java/io/IOException
    //   4633	4639	7763	java/io/IOException
    //   3801	3808	7779	java/io/IOException
    //   3842	3849	7779	java/io/IOException
    //   3883	3891	7779	java/io/IOException
    //   3929	3938	7779	java/io/IOException
    //   3984	4012	7779	java/io/IOException
    //   4052	4059	7779	java/io/IOException
    //   4099	4108	7779	java/io/IOException
    //   4148	4157	7779	java/io/IOException
    //   4209	4221	7779	java/io/IOException
    //   4973	4982	7779	java/io/IOException
    //   5022	5031	7779	java/io/IOException
    //   5281	5325	7779	java/io/IOException
    //   5359	5381	7779	java/io/IOException
    //   1783	1789	7791	java/net/UnknownServiceException
    //   1857	1861	7791	java/net/UnknownServiceException
    //   1915	1934	7791	java/net/UnknownServiceException
    //   1988	1993	7791	java/net/UnknownServiceException
    //   2047	2052	7791	java/net/UnknownServiceException
    //   2391	2410	7791	java/net/UnknownServiceException
    //   2464	2493	7791	java/net/UnknownServiceException
    //   2547	2554	7791	java/net/UnknownServiceException
    //   2608	2625	7791	java/net/UnknownServiceException
    //   2679	2685	7791	java/net/UnknownServiceException
    //   2739	2749	7791	java/net/UnknownServiceException
    //   2803	2816	7791	java/net/UnknownServiceException
    //   2870	2881	7791	java/net/UnknownServiceException
    //   2935	2944	7791	java/net/UnknownServiceException
    //   2998	3004	7791	java/net/UnknownServiceException
    //   3058	3064	7791	java/net/UnknownServiceException
    //   3118	3136	7791	java/net/UnknownServiceException
    //   3190	3200	7791	java/net/UnknownServiceException
    //   3254	3261	7791	java/net/UnknownServiceException
    //   3315	3329	7791	java/net/UnknownServiceException
    //   3383	3408	7791	java/net/UnknownServiceException
    //   3467	3475	7791	java/net/UnknownServiceException
    //   3544	3581	7791	java/net/UnknownServiceException
    //   3635	3642	7791	java/net/UnknownServiceException
    //   3696	3702	7791	java/net/UnknownServiceException
    //   3756	3763	7791	java/net/UnknownServiceException
    //   4490	4499	7791	java/net/UnknownServiceException
    //   4571	4579	7791	java/net/UnknownServiceException
    //   4633	4639	7791	java/net/UnknownServiceException
    //   3801	3808	7807	java/net/UnknownServiceException
    //   3842	3849	7807	java/net/UnknownServiceException
    //   3883	3891	7807	java/net/UnknownServiceException
    //   3929	3938	7807	java/net/UnknownServiceException
    //   3984	4012	7807	java/net/UnknownServiceException
    //   4052	4059	7807	java/net/UnknownServiceException
    //   4099	4108	7807	java/net/UnknownServiceException
    //   4148	4157	7807	java/net/UnknownServiceException
    //   4209	4221	7807	java/net/UnknownServiceException
    //   4973	4982	7807	java/net/UnknownServiceException
    //   5022	5031	7807	java/net/UnknownServiceException
    //   5281	5325	7807	java/net/UnknownServiceException
    //   5359	5381	7807	java/net/UnknownServiceException
    //   942	950	7819	java/net/NoRouteToHostException
    //   974	979	7819	java/net/NoRouteToHostException
    //   1003	1026	7819	java/net/NoRouteToHostException
    //   1050	1056	7819	java/net/NoRouteToHostException
    //   1305	1319	7819	java/net/NoRouteToHostException
    //   1343	1360	7819	java/net/NoRouteToHostException
    //   1384	1395	7819	java/net/NoRouteToHostException
    //   1419	1433	7819	java/net/NoRouteToHostException
    //   1464	1491	7819	java/net/NoRouteToHostException
    //   1515	1553	7819	java/net/NoRouteToHostException
    //   1582	1590	7819	java/net/NoRouteToHostException
    //   1614	1622	7819	java/net/NoRouteToHostException
    //   1646	1691	7819	java/net/NoRouteToHostException
    //   1715	1725	7819	java/net/NoRouteToHostException
    //   1783	1789	7835	java/net/NoRouteToHostException
    //   1857	1861	7835	java/net/NoRouteToHostException
    //   1915	1934	7835	java/net/NoRouteToHostException
    //   1988	1993	7835	java/net/NoRouteToHostException
    //   2047	2052	7835	java/net/NoRouteToHostException
    //   2391	2410	7835	java/net/NoRouteToHostException
    //   2464	2493	7835	java/net/NoRouteToHostException
    //   2547	2554	7835	java/net/NoRouteToHostException
    //   2608	2625	7835	java/net/NoRouteToHostException
    //   2679	2685	7835	java/net/NoRouteToHostException
    //   2739	2749	7835	java/net/NoRouteToHostException
    //   2803	2816	7835	java/net/NoRouteToHostException
    //   2870	2881	7835	java/net/NoRouteToHostException
    //   2935	2944	7835	java/net/NoRouteToHostException
    //   2998	3004	7835	java/net/NoRouteToHostException
    //   3058	3064	7835	java/net/NoRouteToHostException
    //   3118	3136	7835	java/net/NoRouteToHostException
    //   3190	3200	7835	java/net/NoRouteToHostException
    //   3254	3261	7835	java/net/NoRouteToHostException
    //   3315	3329	7835	java/net/NoRouteToHostException
    //   3383	3408	7835	java/net/NoRouteToHostException
    //   3467	3475	7835	java/net/NoRouteToHostException
    //   3544	3581	7835	java/net/NoRouteToHostException
    //   3635	3642	7835	java/net/NoRouteToHostException
    //   3696	3702	7835	java/net/NoRouteToHostException
    //   3756	3763	7835	java/net/NoRouteToHostException
    //   4490	4499	7835	java/net/NoRouteToHostException
    //   4571	4579	7835	java/net/NoRouteToHostException
    //   4633	4639	7835	java/net/NoRouteToHostException
    //   942	950	7851	java/net/ProtocolException
    //   974	979	7851	java/net/ProtocolException
    //   1003	1026	7851	java/net/ProtocolException
    //   1050	1056	7851	java/net/ProtocolException
    //   1305	1319	7851	java/net/ProtocolException
    //   1343	1360	7851	java/net/ProtocolException
    //   1384	1395	7851	java/net/ProtocolException
    //   1419	1433	7851	java/net/ProtocolException
    //   1464	1491	7851	java/net/ProtocolException
    //   1515	1553	7851	java/net/ProtocolException
    //   1582	1590	7851	java/net/ProtocolException
    //   1614	1622	7851	java/net/ProtocolException
    //   1646	1691	7851	java/net/ProtocolException
    //   1715	1725	7851	java/net/ProtocolException
    //   1783	1789	7900	java/net/ProtocolException
    //   1857	1861	7900	java/net/ProtocolException
    //   1915	1934	7900	java/net/ProtocolException
    //   1988	1993	7900	java/net/ProtocolException
    //   2047	2052	7900	java/net/ProtocolException
    //   2391	2410	7900	java/net/ProtocolException
    //   2464	2493	7900	java/net/ProtocolException
    //   2547	2554	7900	java/net/ProtocolException
    //   2608	2625	7900	java/net/ProtocolException
    //   2679	2685	7900	java/net/ProtocolException
    //   2739	2749	7900	java/net/ProtocolException
    //   2803	2816	7900	java/net/ProtocolException
    //   2870	2881	7900	java/net/ProtocolException
    //   2935	2944	7900	java/net/ProtocolException
    //   2998	3004	7900	java/net/ProtocolException
    //   3058	3064	7900	java/net/ProtocolException
    //   3118	3136	7900	java/net/ProtocolException
    //   3190	3200	7900	java/net/ProtocolException
    //   3254	3261	7900	java/net/ProtocolException
    //   3315	3329	7900	java/net/ProtocolException
    //   3383	3408	7900	java/net/ProtocolException
    //   3467	3475	7900	java/net/ProtocolException
    //   3544	3581	7900	java/net/ProtocolException
    //   3635	3642	7900	java/net/ProtocolException
    //   3696	3702	7900	java/net/ProtocolException
    //   3756	3763	7900	java/net/ProtocolException
    //   4490	4499	7900	java/net/ProtocolException
    //   4571	4579	7900	java/net/ProtocolException
    //   4633	4639	7900	java/net/ProtocolException
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
      if (b.this.tVN != null) {
        b.this.tVN.HH(this.action);
      }
      AppMethodBeat.o(137215);
    }
  }
  
  public static abstract interface b
  {
    public abstract void HH(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b
 * JD-Core Version:    0.7.0.1
 */