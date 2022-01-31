package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements Runnable
{
  public int dUg = 0;
  public boolean isStop = true;
  public boolean kaC;
  public String mimeType = "";
  private String myt = null;
  public com.tencent.mm.av.e myu;
  public a myv;
  public float myw;
  private long myx = 307200L;
  public int myy = -1;
  public b.b myz;
  
  public b(com.tencent.mm.av.e parame, a parama)
  {
    this.myu = parame;
    this.myv = parama;
    int i;
    int j;
    if ((parama.myo == 0L) && (parama.myp == 0L) && (parama.endFlag == 0))
    {
      i = 1;
      if ((parama.myq != 0L) || (parama.mys != 0L) || (parama.myr != 0)) {
        break label144;
      }
      j = 1;
      label105:
      if ((i == 0) || (j == 0)) {
        break label150;
      }
      i = k;
      label117:
      if (i == 0) {
        break label155;
      }
      y.e("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
    }
    for (;;)
    {
      this.kaC = aq.isWifi(ae.getContext());
      return;
      i = 0;
      break;
      label144:
      j = 0;
      break label105;
      label150:
      i = 0;
      break label117;
      label155:
      y.i("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
    }
  }
  
  private void F(long paramLong1, long paramLong2)
  {
    if (this.kaC)
    {
      this.myv.myq = paramLong1;
      this.myv.myr = 0;
      this.myv.mys = paramLong2;
      com.tencent.mm.plugin.music.cache.e.a(this.myu.eux, this.myv);
    }
    for (;;)
    {
      ai.d(new b.a(this, 3));
      return;
      this.myv.myo = paramLong1;
      this.myv.endFlag = 0;
      this.myv.myp = paramLong2;
      com.tencent.mm.plugin.music.cache.e.a(this.myu.eux, this.myv);
    }
  }
  
  private static long[] Jv(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      paramString = paramString.replace("bytes", "").trim().split("-");
      long l1 = Long.valueOf(paramString[0]).longValue();
      paramString = paramString[1].split("/");
      long l2 = Long.valueOf(paramString[0]).longValue();
      long l3 = Long.valueOf(paramString[1]).longValue();
      return new long[] { l1, l2, l3 };
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void fl(long paramLong)
  {
    if (this.kaC)
    {
      this.myv.myq = paramLong;
      this.myv.myr = 1;
      this.myv.mys = paramLong;
      com.tencent.mm.plugin.music.cache.e.a(this.myu.eux, this.myv);
    }
    for (;;)
    {
      ai.d(new b.a(this, 2));
      return;
      this.myv.myo = paramLong;
      this.myv.endFlag = 1;
      this.myv.myp = paramLong;
      com.tencent.mm.plugin.music.cache.e.a(this.myu.eux, this.myv);
    }
  }
  
  private HttpURLConnection o(String paramString, Map<String, String> paramMap)
  {
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(this.myt))
    {
      y.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.myt;
      localObject1 = null;
      i = 0;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((HttpURLConnection)localObject1).disconnect();
      }
      y.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[] { paramString });
      Object localObject2 = k.bnl().myY;
      localObject1 = new URL(paramString);
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.music.e.a)localObject2).Jx(paramString);
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
      int j = ((HttpURLConnection)localObject1).getResponseCode();
      y.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307))
      {
        uF(j);
        paramString = ((HttpURLConnection)localObject1).getRequestMethod();
        if ((j != 307) || (paramString.equals("GET")) || (paramString.equals("HEAD"))) {}
      }
      while ((j == 200) || (j == 206))
      {
        return localObject1;
        paramString = ((HttpURLConnection)localObject1).getHeaderField("Location");
        if (paramString == null)
        {
          y.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[] { Integer.valueOf(j) });
          return localObject1;
        }
        localObject2 = new URL(((HttpURLConnection)localObject1).getURL(), paramString);
        y.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[] { paramString });
        y.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[] { ((URL)localObject2).toString() });
        if ((!((URL)localObject2).getProtocol().equals("https")) && (!((URL)localObject2).getProtocol().equals("http")))
        {
          y.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[] { Integer.valueOf(j) });
          return localObject1;
        }
        i += 1;
        if (i > 5)
        {
          y.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: " + i);
          return localObject1;
        }
        paramString = ((URL)localObject2).toString();
        this.myt = paramString;
        break;
      }
      this.myt = null;
      return localObject1;
      localObject1 = null;
      i = 0;
    }
  }
  
  private static void uF(int paramInt)
  {
    d locald = (d)com.tencent.mm.plugin.music.f.c.b.Q(d.class);
    if (locald != null) {
      locald.uK(paramInt);
    }
  }
  
  private void uG(int paramInt)
  {
    this.myt = null;
    ai.d(new b.a(this, paramInt));
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 33
    //   11: aconst_null
    //   12: astore 34
    //   14: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   17: invokestatic 350	com/tencent/mm/sdk/platformtools/aq:isNetworkConnected	(Landroid/content/Context;)Z
    //   20: istore 32
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 50	com/tencent/mm/plugin/music/c/b:dUg	I
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 48	com/tencent/mm/plugin/music/c/b:myy	I
    //   32: invokestatic 193	com/tencent/mm/plugin/music/e/k:bnl	()Lcom/tencent/mm/plugin/music/e/k;
    //   35: getfield 197	com/tencent/mm/plugin/music/e/k:myY	Lcom/tencent/mm/plugin/music/e/a;
    //   38: astore 35
    //   40: iload 32
    //   42: ifeq +504 -> 546
    //   45: aload_0
    //   46: getfield 98	com/tencent/mm/plugin/music/c/b:kaC	Z
    //   49: ifeq +356 -> 405
    //   52: aload_0
    //   53: getfield 52	com/tencent/mm/plugin/music/c/b:myu	Lcom/tencent/mm/av/e;
    //   56: getfield 353	com/tencent/mm/av/e:playUrl	Ljava/lang/String;
    //   59: invokestatic 358	com/tencent/mm/plugin/music/cache/g:Jn	(Ljava/lang/String;)Z
    //   62: istore 32
    //   64: aload 34
    //   66: astore 33
    //   68: aload 35
    //   70: ifnull +19 -> 89
    //   73: aload 35
    //   75: aload_0
    //   76: getfield 52	com/tencent/mm/plugin/music/c/b:myu	Lcom/tencent/mm/av/e;
    //   79: getfield 353	com/tencent/mm/av/e:playUrl	Ljava/lang/String;
    //   82: invokeinterface 361 2 0
    //   87: astore 33
    //   89: ldc 76
    //   91: ldc_w 363
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload 33
    //   102: aastore
    //   103: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   110: getfield 68	com/tencent/mm/plugin/music/c/a:myq	J
    //   113: lstore 6
    //   115: aload_0
    //   116: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   119: getfield 71	com/tencent/mm/plugin/music/c/a:mys	J
    //   122: lstore 4
    //   124: lload 4
    //   126: lconst_0
    //   127: lcmp
    //   128: ifeq +13 -> 141
    //   131: aload_0
    //   132: lload 4
    //   134: ldc2_w 364
    //   137: ldiv
    //   138: putfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   141: lload 6
    //   143: aload_0
    //   144: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   147: lcmp
    //   148: ifge +227 -> 375
    //   151: aload_0
    //   152: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   155: lstore_2
    //   156: aload_0
    //   157: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   160: getfield 74	com/tencent/mm/plugin/music/c/a:myr	I
    //   163: iconst_1
    //   164: if_icmpne +232 -> 396
    //   167: iconst_1
    //   168: istore_1
    //   169: aload 33
    //   171: astore 34
    //   173: aload_0
    //   174: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   177: ldc2_w 366
    //   180: lcmp
    //   181: ifge +18 -> 199
    //   184: aload_0
    //   185: ldc2_w 366
    //   188: putfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   191: ldc 76
    //   193: ldc_w 369
    //   196: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: new 371	java/io/File
    //   202: dup
    //   203: aload_0
    //   204: getfield 52	com/tencent/mm/plugin/music/c/b:myu	Lcom/tencent/mm/av/e;
    //   207: getfield 110	com/tencent/mm/av/e:eux	Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 98	com/tencent/mm/plugin/music/c/b:kaC	Z
    //   214: invokestatic 377	com/tencent/mm/plugin/music/h/b:aN	(Ljava/lang/String;Z)Ljava/lang/String;
    //   217: invokespecial 378	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: astore 43
    //   222: lload_2
    //   223: lstore 8
    //   225: lload 6
    //   227: lstore_2
    //   228: aload 43
    //   230: invokevirtual 381	java/io/File:exists	()Z
    //   233: ifne +56 -> 289
    //   236: ldc 76
    //   238: ldc_w 383
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload 43
    //   249: invokevirtual 386	java/io/File:createNewFile	()Z
    //   252: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   255: aastore
    //   256: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: lconst_0
    //   260: lstore_2
    //   261: aload_0
    //   262: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   265: lstore 8
    //   267: iconst_0
    //   268: istore_1
    //   269: ldc 76
    //   271: ldc_w 393
    //   274: iconst_1
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: lload 8
    //   282: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   285: aastore
    //   286: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: ldc 76
    //   291: ldc_w 398
    //   294: iconst_3
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: lload_2
    //   301: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: aload 43
    //   309: invokevirtual 401	java/io/File:length	()J
    //   312: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   315: aastore
    //   316: dup
    //   317: iconst_2
    //   318: lload 8
    //   320: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: lload_2
    //   328: aload_0
    //   329: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   332: lcmp
    //   333: iflt +12 -> 345
    //   336: aload_0
    //   337: getfield 403	com/tencent/mm/plugin/music/c/b:myw	F
    //   340: fconst_0
    //   341: fcmpl
    //   342: ifeq +7 -> 349
    //   345: iload_1
    //   346: ifeq +456 -> 802
    //   349: ldc 76
    //   351: ldc_w 405
    //   354: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_0
    //   358: iconst_1
    //   359: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   362: new 8	com/tencent/mm/plugin/music/c/b$a
    //   365: dup
    //   366: aload_0
    //   367: iconst_1
    //   368: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   371: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   374: return
    //   375: lload 6
    //   377: l2f
    //   378: ldc_w 406
    //   381: aload_0
    //   382: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   385: getfield 71	com/tencent/mm/plugin/music/c/a:mys	J
    //   388: l2f
    //   389: fmul
    //   390: fadd
    //   391: f2l
    //   392: lstore_2
    //   393: goto -237 -> 156
    //   396: iconst_0
    //   397: istore_1
    //   398: aload 33
    //   400: astore 34
    //   402: goto -229 -> 173
    //   405: aload 35
    //   407: ifnull +19 -> 426
    //   410: aload 35
    //   412: aload_0
    //   413: getfield 52	com/tencent/mm/plugin/music/c/b:myu	Lcom/tencent/mm/av/e;
    //   416: getfield 353	com/tencent/mm/av/e:playUrl	Ljava/lang/String;
    //   419: invokeinterface 361 2 0
    //   424: astore 33
    //   426: ldc 76
    //   428: ldc_w 363
    //   431: iconst_1
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: aload 33
    //   439: aastore
    //   440: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: iconst_0
    //   444: istore 32
    //   446: aload_0
    //   447: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   450: getfield 59	com/tencent/mm/plugin/music/c/a:myo	J
    //   453: lstore 6
    //   455: aload_0
    //   456: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   459: getfield 62	com/tencent/mm/plugin/music/c/a:myp	J
    //   462: lstore 4
    //   464: lload 4
    //   466: lconst_0
    //   467: lcmp
    //   468: ifeq +13 -> 481
    //   471: aload_0
    //   472: lload 4
    //   474: ldc2_w 364
    //   477: ldiv
    //   478: putfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   481: lload 6
    //   483: aload_0
    //   484: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   487: lcmp
    //   488: ifge +28 -> 516
    //   491: aload_0
    //   492: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   495: lstore_2
    //   496: aload_0
    //   497: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   500: getfield 65	com/tencent/mm/plugin/music/c/a:endFlag	I
    //   503: iconst_1
    //   504: if_icmpne +33 -> 537
    //   507: iconst_1
    //   508: istore_1
    //   509: aload 33
    //   511: astore 34
    //   513: goto -340 -> 173
    //   516: lload 6
    //   518: l2f
    //   519: ldc_w 406
    //   522: aload_0
    //   523: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   526: getfield 62	com/tencent/mm/plugin/music/c/a:myp	J
    //   529: l2f
    //   530: fmul
    //   531: fadd
    //   532: f2l
    //   533: lstore_2
    //   534: goto -38 -> 496
    //   537: iconst_0
    //   538: istore_1
    //   539: aload 33
    //   541: astore 34
    //   543: goto -370 -> 173
    //   546: aload_0
    //   547: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   550: getfield 68	com/tencent/mm/plugin/music/c/a:myq	J
    //   553: lconst_0
    //   554: lcmp
    //   555: ifeq +96 -> 651
    //   558: aload_0
    //   559: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   562: getfield 68	com/tencent/mm/plugin/music/c/a:myq	J
    //   565: aload_0
    //   566: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   569: lcmp
    //   570: ifge +21 -> 591
    //   573: aload_0
    //   574: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   577: getfield 68	com/tencent/mm/plugin/music/c/a:myq	J
    //   580: aload_0
    //   581: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   584: getfield 71	com/tencent/mm/plugin/music/c/a:mys	J
    //   587: lcmp
    //   588: ifne +63 -> 651
    //   591: aload_0
    //   592: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   595: getfield 68	com/tencent/mm/plugin/music/c/a:myq	J
    //   598: l2f
    //   599: aload_0
    //   600: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   603: getfield 71	com/tencent/mm/plugin/music/c/a:mys	J
    //   606: l2f
    //   607: fdiv
    //   608: aload_0
    //   609: getfield 403	com/tencent/mm/plugin/music/c/b:myw	F
    //   612: fsub
    //   613: ldc_w 406
    //   616: fcmpl
    //   617: iflt +34 -> 651
    //   620: ldc 76
    //   622: ldc_w 405
    //   625: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload_0
    //   629: iconst_1
    //   630: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   633: aload_0
    //   634: iconst_1
    //   635: putfield 98	com/tencent/mm/plugin/music/c/b:kaC	Z
    //   638: new 8	com/tencent/mm/plugin/music/c/b$a
    //   641: dup
    //   642: aload_0
    //   643: iconst_1
    //   644: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   647: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   650: return
    //   651: aload_0
    //   652: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   655: getfield 59	com/tencent/mm/plugin/music/c/a:myo	J
    //   658: lconst_0
    //   659: lcmp
    //   660: ifeq +96 -> 756
    //   663: aload_0
    //   664: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   667: getfield 59	com/tencent/mm/plugin/music/c/a:myo	J
    //   670: aload_0
    //   671: getfield 40	com/tencent/mm/plugin/music/c/b:myx	J
    //   674: lcmp
    //   675: ifge +21 -> 696
    //   678: aload_0
    //   679: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   682: getfield 59	com/tencent/mm/plugin/music/c/a:myo	J
    //   685: aload_0
    //   686: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   689: getfield 62	com/tencent/mm/plugin/music/c/a:myp	J
    //   692: lcmp
    //   693: ifne +63 -> 756
    //   696: aload_0
    //   697: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   700: getfield 59	com/tencent/mm/plugin/music/c/a:myo	J
    //   703: l2f
    //   704: aload_0
    //   705: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   708: getfield 62	com/tencent/mm/plugin/music/c/a:myp	J
    //   711: l2f
    //   712: fdiv
    //   713: aload_0
    //   714: getfield 403	com/tencent/mm/plugin/music/c/b:myw	F
    //   717: fsub
    //   718: ldc_w 406
    //   721: fcmpl
    //   722: iflt +34 -> 756
    //   725: ldc 76
    //   727: ldc_w 405
    //   730: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload_0
    //   734: iconst_1
    //   735: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   738: aload_0
    //   739: iconst_0
    //   740: putfield 98	com/tencent/mm/plugin/music/c/b:kaC	Z
    //   743: new 8	com/tencent/mm/plugin/music/c/b$a
    //   746: dup
    //   747: aload_0
    //   748: iconst_1
    //   749: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   752: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   755: return
    //   756: ldc 76
    //   758: ldc_w 408
    //   761: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload_0
    //   765: iconst_1
    //   766: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   769: aload_0
    //   770: iconst_4
    //   771: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   774: return
    //   775: astore 33
    //   777: ldc 76
    //   779: aload 33
    //   781: ldc_w 412
    //   784: iconst_1
    //   785: anewarray 4	java/lang/Object
    //   788: dup
    //   789: iconst_0
    //   790: aload 43
    //   792: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   795: aastore
    //   796: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   799: goto -540 -> 259
    //   802: aload 34
    //   804: invokestatic 135	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   807: ifeq +30 -> 837
    //   810: ldc 76
    //   812: ldc_w 421
    //   815: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: aload_0
    //   819: iconst_1
    //   820: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   823: new 8	com/tencent/mm/plugin/music/c/b$a
    //   826: dup
    //   827: aload_0
    //   828: bipush 254
    //   830: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   833: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   836: return
    //   837: aconst_null
    //   838: astore 41
    //   840: aconst_null
    //   841: astore 40
    //   843: aconst_null
    //   844: astore 39
    //   846: aconst_null
    //   847: astore 35
    //   849: aconst_null
    //   850: astore 38
    //   852: aconst_null
    //   853: astore 42
    //   855: aconst_null
    //   856: astore 37
    //   858: aload 43
    //   860: invokevirtual 381	java/io/File:exists	()Z
    //   863: ifne +253 -> 1116
    //   866: aload_0
    //   867: iconst_1
    //   868: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   871: ldc 76
    //   873: ldc_w 423
    //   876: iconst_1
    //   877: anewarray 4	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: aload 43
    //   884: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   887: aastore
    //   888: invokestatic 291	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   891: aload_0
    //   892: bipush 19
    //   894: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   897: lload 4
    //   899: lconst_0
    //   900: lcmp
    //   901: ifne +83 -> 984
    //   904: lload_2
    //   905: lconst_0
    //   906: lcmp
    //   907: ifle +77 -> 984
    //   910: ldc 76
    //   912: ldc_w 425
    //   915: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   918: new 427	java/lang/NullPointerException
    //   921: dup
    //   922: invokespecial 428	java/lang/NullPointerException:<init>	()V
    //   925: athrow
    //   926: aload_0
    //   927: lload_2
    //   928: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   931: lload_2
    //   932: ldc2_w 366
    //   935: lcmp
    //   936: ifge +15 -> 951
    //   939: new 8	com/tencent/mm/plugin/music/c/b$a
    //   942: dup
    //   943: aload_0
    //   944: iconst_1
    //   945: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   948: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   951: aload_0
    //   952: iconst_1
    //   953: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   956: ldc 76
    //   958: ldc_w 432
    //   961: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: return
    //   965: astore 33
    //   967: ldc 76
    //   969: aload 33
    //   971: ldc_w 434
    //   974: iconst_0
    //   975: anewarray 4	java/lang/Object
    //   978: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   981: goto -55 -> 926
    //   984: lload 4
    //   986: lconst_0
    //   987: lcmp
    //   988: ifeq +47 -> 1035
    //   991: lload_2
    //   992: lload 4
    //   994: lcmp
    //   995: ifeq +40 -> 1035
    //   998: ldc 76
    //   1000: ldc_w 436
    //   1003: iconst_2
    //   1004: anewarray 4	java/lang/Object
    //   1007: dup
    //   1008: iconst_0
    //   1009: lload 4
    //   1011: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1014: aastore
    //   1015: dup
    //   1016: iconst_1
    //   1017: lload_2
    //   1018: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1021: aastore
    //   1022: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: aload_0
    //   1026: lload_2
    //   1027: lload 4
    //   1029: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   1032: goto -81 -> 951
    //   1035: lload 4
    //   1037: lconst_0
    //   1038: lcmp
    //   1039: ifeq +66 -> 1105
    //   1042: lload_2
    //   1043: lload 4
    //   1045: lcmp
    //   1046: ifne +59 -> 1105
    //   1049: ldc 76
    //   1051: ldc_w 440
    //   1054: iconst_2
    //   1055: anewarray 4	java/lang/Object
    //   1058: dup
    //   1059: iconst_0
    //   1060: lload 4
    //   1062: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1065: aastore
    //   1066: dup
    //   1067: iconst_1
    //   1068: lload_2
    //   1069: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1072: aastore
    //   1073: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1076: aload_0
    //   1077: lload 4
    //   1079: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   1082: lload_2
    //   1083: ldc2_w 366
    //   1086: lcmp
    //   1087: ifge -136 -> 951
    //   1090: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1093: dup
    //   1094: aload_0
    //   1095: iconst_1
    //   1096: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1099: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   1102: goto -151 -> 951
    //   1105: ldc 76
    //   1107: ldc_w 442
    //   1110: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: goto -162 -> 951
    //   1116: new 444	java/io/RandomAccessFile
    //   1119: dup
    //   1120: aload 43
    //   1122: ldc_w 446
    //   1125: invokespecial 449	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1128: astore 33
    //   1130: ldc 76
    //   1132: ldc_w 451
    //   1135: iconst_1
    //   1136: anewarray 4	java/lang/Object
    //   1139: dup
    //   1140: iconst_0
    //   1141: aload 34
    //   1143: aastore
    //   1144: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1147: new 453	java/util/HashMap
    //   1150: dup
    //   1151: bipush 10
    //   1153: invokespecial 455	java/util/HashMap:<init>	(I)V
    //   1156: astore 36
    //   1158: aload 36
    //   1160: ldc_w 457
    //   1163: ldc_w 459
    //   1166: invokeinterface 463 3 0
    //   1171: pop
    //   1172: lload 8
    //   1174: lload_2
    //   1175: lcmp
    //   1176: ifle +68 -> 1244
    //   1179: ldc 76
    //   1181: ldc_w 465
    //   1184: iconst_2
    //   1185: anewarray 4	java/lang/Object
    //   1188: dup
    //   1189: iconst_0
    //   1190: lload_2
    //   1191: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1194: aastore
    //   1195: dup
    //   1196: iconst_1
    //   1197: lload 8
    //   1199: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1202: aastore
    //   1203: invokestatic 467	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1206: aload 36
    //   1208: ldc_w 469
    //   1211: new 316	java/lang/StringBuilder
    //   1214: dup
    //   1215: ldc_w 471
    //   1218: invokespecial 319	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1221: lload_2
    //   1222: invokevirtual 474	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1225: ldc 149
    //   1227: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: lload 8
    //   1232: invokevirtual 474	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1235: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1238: invokeinterface 463 3 0
    //   1243: pop
    //   1244: iload 32
    //   1246: ifne +11 -> 1257
    //   1249: aload 34
    //   1251: invokestatic 482	com/tencent/mm/plugin/music/h/e:JK	(Ljava/lang/String;)Z
    //   1254: ifeq +39 -> 1293
    //   1257: ldc 76
    //   1259: ldc_w 484
    //   1262: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: aload 36
    //   1267: ldc_w 486
    //   1270: ldc_w 488
    //   1273: invokeinterface 463 3 0
    //   1278: pop
    //   1279: aload 36
    //   1281: ldc_w 490
    //   1284: ldc_w 492
    //   1287: invokeinterface 463 3 0
    //   1292: pop
    //   1293: aload 36
    //   1295: ldc_w 494
    //   1298: new 316	java/lang/StringBuilder
    //   1301: dup
    //   1302: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1305: ldc_w 497
    //   1308: invokestatic 502	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1311: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: ldc_w 504
    //   1317: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1323: invokestatic 508	com/tencent/mm/plugin/music/h/e:dT	(Landroid/content/Context;)Ljava/lang/String;
    //   1326: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1332: invokeinterface 463 3 0
    //   1337: pop
    //   1338: aload_0
    //   1339: aload 34
    //   1341: aload 36
    //   1343: invokespecial 510	com/tencent/mm/plugin/music/c/b:o	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   1346: astore 34
    //   1348: aload 34
    //   1350: astore 37
    //   1352: lload 4
    //   1354: lstore 8
    //   1356: lload_2
    //   1357: lstore 6
    //   1359: aload 33
    //   1361: astore 36
    //   1363: aload 38
    //   1365: astore 35
    //   1367: lload 4
    //   1369: lstore 24
    //   1371: lload_2
    //   1372: lstore 14
    //   1374: lload 4
    //   1376: lstore 22
    //   1378: lload_2
    //   1379: lstore 12
    //   1381: lload 4
    //   1383: lstore 20
    //   1385: lload_2
    //   1386: lstore 18
    //   1388: lload 4
    //   1390: lstore 26
    //   1392: lload_2
    //   1393: lstore 10
    //   1395: lload 4
    //   1397: lstore 28
    //   1399: lload_2
    //   1400: lstore 16
    //   1402: aload 34
    //   1404: invokevirtual 262	java/net/HttpURLConnection:getResponseCode	()I
    //   1407: istore_1
    //   1408: iload_1
    //   1409: sipush 200
    //   1412: if_icmpeq +510 -> 1922
    //   1415: iload_1
    //   1416: sipush 206
    //   1419: if_icmpeq +503 -> 1922
    //   1422: aload 34
    //   1424: astore 37
    //   1426: lload 4
    //   1428: lstore 8
    //   1430: lload_2
    //   1431: lstore 6
    //   1433: aload 33
    //   1435: astore 36
    //   1437: aload 38
    //   1439: astore 35
    //   1441: lload 4
    //   1443: lstore 24
    //   1445: lload_2
    //   1446: lstore 14
    //   1448: lload 4
    //   1450: lstore 22
    //   1452: lload_2
    //   1453: lstore 12
    //   1455: lload 4
    //   1457: lstore 20
    //   1459: lload_2
    //   1460: lstore 18
    //   1462: lload 4
    //   1464: lstore 26
    //   1466: lload_2
    //   1467: lstore 10
    //   1469: lload 4
    //   1471: lstore 28
    //   1473: lload_2
    //   1474: lstore 16
    //   1476: iload_1
    //   1477: invokestatic 272	com/tencent/mm/plugin/music/c/b:uF	(I)V
    //   1480: aload 34
    //   1482: astore 37
    //   1484: lload 4
    //   1486: lstore 8
    //   1488: lload_2
    //   1489: lstore 6
    //   1491: aload 33
    //   1493: astore 36
    //   1495: aload 38
    //   1497: astore 35
    //   1499: lload 4
    //   1501: lstore 24
    //   1503: lload_2
    //   1504: lstore 14
    //   1506: lload 4
    //   1508: lstore 22
    //   1510: lload_2
    //   1511: lstore 12
    //   1513: lload 4
    //   1515: lstore 20
    //   1517: lload_2
    //   1518: lstore 18
    //   1520: lload 4
    //   1522: lstore 26
    //   1524: lload_2
    //   1525: lstore 10
    //   1527: lload 4
    //   1529: lstore 28
    //   1531: lload_2
    //   1532: lstore 16
    //   1534: ldc 76
    //   1536: ldc_w 512
    //   1539: iconst_1
    //   1540: anewarray 4	java/lang/Object
    //   1543: dup
    //   1544: iconst_0
    //   1545: iload_1
    //   1546: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1549: aastore
    //   1550: invokestatic 291	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1553: aload 34
    //   1555: astore 37
    //   1557: lload 4
    //   1559: lstore 8
    //   1561: lload_2
    //   1562: lstore 6
    //   1564: aload 33
    //   1566: astore 36
    //   1568: aload 38
    //   1570: astore 35
    //   1572: lload 4
    //   1574: lstore 24
    //   1576: lload_2
    //   1577: lstore 14
    //   1579: lload 4
    //   1581: lstore 22
    //   1583: lload_2
    //   1584: lstore 12
    //   1586: lload 4
    //   1588: lstore 20
    //   1590: lload_2
    //   1591: lstore 18
    //   1593: lload 4
    //   1595: lstore 26
    //   1597: lload_2
    //   1598: lstore 10
    //   1600: lload 4
    //   1602: lstore 28
    //   1604: lload_2
    //   1605: lstore 16
    //   1607: aload_0
    //   1608: iload_1
    //   1609: putfield 48	com/tencent/mm/plugin/music/c/b:myy	I
    //   1612: aload 34
    //   1614: astore 37
    //   1616: lload 4
    //   1618: lstore 8
    //   1620: lload_2
    //   1621: lstore 6
    //   1623: aload 33
    //   1625: astore 36
    //   1627: aload 38
    //   1629: astore 35
    //   1631: lload 4
    //   1633: lstore 24
    //   1635: lload_2
    //   1636: lstore 14
    //   1638: lload 4
    //   1640: lstore 22
    //   1642: lload_2
    //   1643: lstore 12
    //   1645: lload 4
    //   1647: lstore 20
    //   1649: lload_2
    //   1650: lstore 18
    //   1652: lload 4
    //   1654: lstore 26
    //   1656: lload_2
    //   1657: lstore 10
    //   1659: lload 4
    //   1661: lstore 28
    //   1663: lload_2
    //   1664: lstore 16
    //   1666: aload_0
    //   1667: iconst_m1
    //   1668: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   1671: lload 4
    //   1673: lconst_0
    //   1674: lcmp
    //   1675: ifne +96 -> 1771
    //   1678: lload_2
    //   1679: lconst_0
    //   1680: lcmp
    //   1681: ifle +90 -> 1771
    //   1684: ldc 76
    //   1686: ldc_w 425
    //   1689: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1692: aload 33
    //   1694: lload_2
    //   1695: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   1698: aload_0
    //   1699: lload_2
    //   1700: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   1703: lload_2
    //   1704: ldc2_w 366
    //   1707: lcmp
    //   1708: ifge +15 -> 1723
    //   1711: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1714: dup
    //   1715: aload_0
    //   1716: iconst_1
    //   1717: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1720: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   1723: aload 33
    //   1725: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   1728: aload 34
    //   1730: ifnull +8 -> 1738
    //   1733: aload 34
    //   1735: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   1738: aload_0
    //   1739: iconst_1
    //   1740: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   1743: ldc 76
    //   1745: ldc_w 432
    //   1748: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1751: return
    //   1752: astore 35
    //   1754: ldc 76
    //   1756: aload 35
    //   1758: ldc_w 434
    //   1761: iconst_0
    //   1762: anewarray 4	java/lang/Object
    //   1765: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1768: goto -70 -> 1698
    //   1771: lload 4
    //   1773: lconst_0
    //   1774: lcmp
    //   1775: ifeq +47 -> 1822
    //   1778: lload_2
    //   1779: lload 4
    //   1781: lcmp
    //   1782: ifeq +40 -> 1822
    //   1785: ldc 76
    //   1787: ldc_w 436
    //   1790: iconst_2
    //   1791: anewarray 4	java/lang/Object
    //   1794: dup
    //   1795: iconst_0
    //   1796: lload 4
    //   1798: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1801: aastore
    //   1802: dup
    //   1803: iconst_1
    //   1804: lload_2
    //   1805: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1808: aastore
    //   1809: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1812: aload_0
    //   1813: lload_2
    //   1814: lload 4
    //   1816: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   1819: goto -96 -> 1723
    //   1822: lload 4
    //   1824: lconst_0
    //   1825: lcmp
    //   1826: ifeq +66 -> 1892
    //   1829: lload_2
    //   1830: lload 4
    //   1832: lcmp
    //   1833: ifne +59 -> 1892
    //   1836: ldc 76
    //   1838: ldc_w 440
    //   1841: iconst_2
    //   1842: anewarray 4	java/lang/Object
    //   1845: dup
    //   1846: iconst_0
    //   1847: lload 4
    //   1849: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1852: aastore
    //   1853: dup
    //   1854: iconst_1
    //   1855: lload_2
    //   1856: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1859: aastore
    //   1860: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1863: aload_0
    //   1864: lload 4
    //   1866: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   1869: lload_2
    //   1870: ldc2_w 366
    //   1873: lcmp
    //   1874: ifge -151 -> 1723
    //   1877: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1880: dup
    //   1881: aload_0
    //   1882: iconst_1
    //   1883: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1886: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   1889: goto -166 -> 1723
    //   1892: ldc 76
    //   1894: ldc_w 442
    //   1897: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1900: goto -177 -> 1723
    //   1903: astore 33
    //   1905: ldc 76
    //   1907: aload 33
    //   1909: ldc_w 434
    //   1912: iconst_0
    //   1913: anewarray 4	java/lang/Object
    //   1916: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1919: goto -191 -> 1728
    //   1922: aload 34
    //   1924: astore 37
    //   1926: lload 4
    //   1928: lstore 8
    //   1930: lload_2
    //   1931: lstore 6
    //   1933: aload 33
    //   1935: astore 36
    //   1937: aload 38
    //   1939: astore 35
    //   1941: lload 4
    //   1943: lstore 24
    //   1945: lload_2
    //   1946: lstore 14
    //   1948: lload 4
    //   1950: lstore 22
    //   1952: lload_2
    //   1953: lstore 12
    //   1955: lload 4
    //   1957: lstore 20
    //   1959: lload_2
    //   1960: lstore 18
    //   1962: lload 4
    //   1964: lstore 26
    //   1966: lload_2
    //   1967: lstore 10
    //   1969: lload 4
    //   1971: lstore 28
    //   1973: lload_2
    //   1974: lstore 16
    //   1976: ldc 76
    //   1978: ldc_w 520
    //   1981: iconst_1
    //   1982: anewarray 4	java/lang/Object
    //   1985: dup
    //   1986: iconst_0
    //   1987: iload_1
    //   1988: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1991: aastore
    //   1992: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1995: aload 34
    //   1997: astore 37
    //   1999: lload 4
    //   2001: lstore 8
    //   2003: lload_2
    //   2004: lstore 6
    //   2006: aload 33
    //   2008: astore 36
    //   2010: aload 38
    //   2012: astore 35
    //   2014: lload 4
    //   2016: lstore 24
    //   2018: lload_2
    //   2019: lstore 14
    //   2021: lload 4
    //   2023: lstore 22
    //   2025: lload_2
    //   2026: lstore 12
    //   2028: lload 4
    //   2030: lstore 20
    //   2032: lload_2
    //   2033: lstore 18
    //   2035: lload 4
    //   2037: lstore 26
    //   2039: lload_2
    //   2040: lstore 10
    //   2042: lload 4
    //   2044: lstore 28
    //   2046: lload_2
    //   2047: lstore 16
    //   2049: ldc 76
    //   2051: new 316	java/lang/StringBuilder
    //   2054: dup
    //   2055: ldc_w 522
    //   2058: invokespecial 319	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2061: aload 34
    //   2063: ldc_w 494
    //   2066: invokevirtual 525	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2069: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2075: invokestatic 527	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2078: aload 34
    //   2080: astore 37
    //   2082: lload 4
    //   2084: lstore 8
    //   2086: lload_2
    //   2087: lstore 6
    //   2089: aload 33
    //   2091: astore 36
    //   2093: aload 38
    //   2095: astore 35
    //   2097: lload 4
    //   2099: lstore 24
    //   2101: lload_2
    //   2102: lstore 14
    //   2104: lload 4
    //   2106: lstore 22
    //   2108: lload_2
    //   2109: lstore 12
    //   2111: lload 4
    //   2113: lstore 20
    //   2115: lload_2
    //   2116: lstore 18
    //   2118: lload 4
    //   2120: lstore 26
    //   2122: lload_2
    //   2123: lstore 10
    //   2125: lload 4
    //   2127: lstore 28
    //   2129: lload_2
    //   2130: lstore 16
    //   2132: aload 34
    //   2134: invokevirtual 530	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2137: astore 44
    //   2139: aload 34
    //   2141: astore 37
    //   2143: lload 4
    //   2145: lstore 8
    //   2147: lload_2
    //   2148: lstore 6
    //   2150: aload 33
    //   2152: astore 36
    //   2154: aload 38
    //   2156: astore 35
    //   2158: lload 4
    //   2160: lstore 24
    //   2162: lload_2
    //   2163: lstore 14
    //   2165: lload 4
    //   2167: lstore 22
    //   2169: lload_2
    //   2170: lstore 12
    //   2172: lload 4
    //   2174: lstore 20
    //   2176: lload_2
    //   2177: lstore 18
    //   2179: lload 4
    //   2181: lstore 26
    //   2183: lload_2
    //   2184: lstore 10
    //   2186: lload 4
    //   2188: lstore 28
    //   2190: lload_2
    //   2191: lstore 16
    //   2193: ldc 76
    //   2195: ldc_w 532
    //   2198: iconst_1
    //   2199: anewarray 4	java/lang/Object
    //   2202: dup
    //   2203: iconst_0
    //   2204: aload 44
    //   2206: aastore
    //   2207: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2210: aload 34
    //   2212: astore 37
    //   2214: lload 4
    //   2216: lstore 8
    //   2218: lload_2
    //   2219: lstore 6
    //   2221: aload 33
    //   2223: astore 36
    //   2225: aload 38
    //   2227: astore 35
    //   2229: lload 4
    //   2231: lstore 24
    //   2233: lload_2
    //   2234: lstore 14
    //   2236: lload 4
    //   2238: lstore 22
    //   2240: lload_2
    //   2241: lstore 12
    //   2243: lload 4
    //   2245: lstore 20
    //   2247: lload_2
    //   2248: lstore 18
    //   2250: lload 4
    //   2252: lstore 26
    //   2254: lload_2
    //   2255: lstore 10
    //   2257: lload 4
    //   2259: lstore 28
    //   2261: lload_2
    //   2262: lstore 16
    //   2264: aload_0
    //   2265: aload 44
    //   2267: putfield 46	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2270: aload 34
    //   2272: astore 37
    //   2274: lload 4
    //   2276: lstore 8
    //   2278: lload_2
    //   2279: lstore 6
    //   2281: aload 33
    //   2283: astore 36
    //   2285: aload 38
    //   2287: astore 35
    //   2289: lload 4
    //   2291: lstore 24
    //   2293: lload_2
    //   2294: lstore 14
    //   2296: lload 4
    //   2298: lstore 22
    //   2300: lload_2
    //   2301: lstore 12
    //   2303: lload 4
    //   2305: lstore 20
    //   2307: lload_2
    //   2308: lstore 18
    //   2310: lload 4
    //   2312: lstore 26
    //   2314: lload_2
    //   2315: lstore 10
    //   2317: lload 4
    //   2319: lstore 28
    //   2321: lload_2
    //   2322: lstore 16
    //   2324: aload_0
    //   2325: getfield 46	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2328: invokestatic 175	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2331: ifne +390 -> 2721
    //   2334: aload 34
    //   2336: astore 37
    //   2338: lload 4
    //   2340: lstore 8
    //   2342: lload_2
    //   2343: lstore 6
    //   2345: aload 33
    //   2347: astore 36
    //   2349: aload 38
    //   2351: astore 35
    //   2353: lload 4
    //   2355: lstore 24
    //   2357: lload_2
    //   2358: lstore 14
    //   2360: lload 4
    //   2362: lstore 22
    //   2364: lload_2
    //   2365: lstore 12
    //   2367: lload 4
    //   2369: lstore 20
    //   2371: lload_2
    //   2372: lstore 18
    //   2374: lload 4
    //   2376: lstore 26
    //   2378: lload_2
    //   2379: lstore 10
    //   2381: lload 4
    //   2383: lstore 28
    //   2385: lload_2
    //   2386: lstore 16
    //   2388: aload_0
    //   2389: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   2392: getfield 533	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2395: invokestatic 175	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2398: ifeq +323 -> 2721
    //   2401: aload 34
    //   2403: astore 37
    //   2405: lload 4
    //   2407: lstore 8
    //   2409: lload_2
    //   2410: lstore 6
    //   2412: aload 33
    //   2414: astore 36
    //   2416: aload 38
    //   2418: astore 35
    //   2420: lload 4
    //   2422: lstore 24
    //   2424: lload_2
    //   2425: lstore 14
    //   2427: lload 4
    //   2429: lstore 22
    //   2431: lload_2
    //   2432: lstore 12
    //   2434: lload 4
    //   2436: lstore 20
    //   2438: lload_2
    //   2439: lstore 18
    //   2441: lload 4
    //   2443: lstore 26
    //   2445: lload_2
    //   2446: lstore 10
    //   2448: lload 4
    //   2450: lstore 28
    //   2452: lload_2
    //   2453: lstore 16
    //   2455: aload_0
    //   2456: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   2459: aload_0
    //   2460: getfield 46	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2463: putfield 533	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2466: aload 34
    //   2468: astore 37
    //   2470: lload 4
    //   2472: lstore 8
    //   2474: lload_2
    //   2475: lstore 6
    //   2477: aload 33
    //   2479: astore 36
    //   2481: aload 38
    //   2483: astore 35
    //   2485: lload 4
    //   2487: lstore 24
    //   2489: lload_2
    //   2490: lstore 14
    //   2492: lload 4
    //   2494: lstore 22
    //   2496: lload_2
    //   2497: lstore 12
    //   2499: lload 4
    //   2501: lstore 20
    //   2503: lload_2
    //   2504: lstore 18
    //   2506: lload 4
    //   2508: lstore 26
    //   2510: lload_2
    //   2511: lstore 10
    //   2513: lload 4
    //   2515: lstore 28
    //   2517: lload_2
    //   2518: lstore 16
    //   2520: aload_0
    //   2521: getfield 52	com/tencent/mm/plugin/music/c/b:myu	Lcom/tencent/mm/av/e;
    //   2524: getfield 110	com/tencent/mm/av/e:eux	Ljava/lang/String;
    //   2527: astore 45
    //   2529: aload 34
    //   2531: astore 37
    //   2533: lload 4
    //   2535: lstore 8
    //   2537: lload_2
    //   2538: lstore 6
    //   2540: aload 33
    //   2542: astore 36
    //   2544: aload 38
    //   2546: astore 35
    //   2548: lload 4
    //   2550: lstore 24
    //   2552: lload_2
    //   2553: lstore 14
    //   2555: lload 4
    //   2557: lstore 22
    //   2559: lload_2
    //   2560: lstore 12
    //   2562: lload 4
    //   2564: lstore 20
    //   2566: lload_2
    //   2567: lstore 18
    //   2569: lload 4
    //   2571: lstore 26
    //   2573: lload_2
    //   2574: lstore 10
    //   2576: lload 4
    //   2578: lstore 28
    //   2580: lload_2
    //   2581: lstore 16
    //   2583: aload_0
    //   2584: getfield 46	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2587: astore 44
    //   2589: aload 34
    //   2591: astore 37
    //   2593: lload 4
    //   2595: lstore 8
    //   2597: lload_2
    //   2598: lstore 6
    //   2600: aload 33
    //   2602: astore 36
    //   2604: aload 38
    //   2606: astore 35
    //   2608: lload 4
    //   2610: lstore 24
    //   2612: lload_2
    //   2613: lstore 14
    //   2615: lload 4
    //   2617: lstore 22
    //   2619: lload_2
    //   2620: lstore 12
    //   2622: lload 4
    //   2624: lstore 20
    //   2626: lload_2
    //   2627: lstore 18
    //   2629: lload 4
    //   2631: lstore 26
    //   2633: lload_2
    //   2634: lstore 10
    //   2636: lload 4
    //   2638: lstore 28
    //   2640: lload_2
    //   2641: lstore 16
    //   2643: invokestatic 536	com/tencent/mm/plugin/music/cache/e:bmM	()Z
    //   2646: ifeq +1147 -> 3793
    //   2649: aload 34
    //   2651: astore 37
    //   2653: lload 4
    //   2655: lstore 8
    //   2657: lload_2
    //   2658: lstore 6
    //   2660: aload 33
    //   2662: astore 36
    //   2664: aload 38
    //   2666: astore 35
    //   2668: lload 4
    //   2670: lstore 24
    //   2672: lload_2
    //   2673: lstore 14
    //   2675: lload 4
    //   2677: lstore 22
    //   2679: lload_2
    //   2680: lstore 12
    //   2682: lload 4
    //   2684: lstore 20
    //   2686: lload_2
    //   2687: lstore 18
    //   2689: lload 4
    //   2691: lstore 26
    //   2693: lload_2
    //   2694: lstore 10
    //   2696: lload 4
    //   2698: lstore 28
    //   2700: lload_2
    //   2701: lstore 16
    //   2703: ldc_w 538
    //   2706: invokestatic 334	com/tencent/mm/plugin/music/f/c/b:Q	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/music/f/c/a;
    //   2709: checkcast 538	com/tencent/mm/plugin/music/cache/c
    //   2712: aload 45
    //   2714: aload 44
    //   2716: invokeinterface 541 3 0
    //   2721: aload 34
    //   2723: astore 37
    //   2725: lload 4
    //   2727: lstore 8
    //   2729: lload_2
    //   2730: lstore 6
    //   2732: aload 33
    //   2734: astore 36
    //   2736: aload 38
    //   2738: astore 35
    //   2740: lload 4
    //   2742: lstore 24
    //   2744: lload_2
    //   2745: lstore 14
    //   2747: lload 4
    //   2749: lstore 22
    //   2751: lload_2
    //   2752: lstore 12
    //   2754: lload 4
    //   2756: lstore 20
    //   2758: lload_2
    //   2759: lstore 18
    //   2761: lload 4
    //   2763: lstore 26
    //   2765: lload_2
    //   2766: lstore 10
    //   2768: lload 4
    //   2770: lstore 28
    //   2772: lload_2
    //   2773: lstore 16
    //   2775: aload 34
    //   2777: ldc_w 543
    //   2780: invokevirtual 287	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2783: astore 45
    //   2785: aload 34
    //   2787: astore 37
    //   2789: lload 4
    //   2791: lstore 8
    //   2793: lload_2
    //   2794: lstore 6
    //   2796: aload 33
    //   2798: astore 36
    //   2800: aload 38
    //   2802: astore 35
    //   2804: lload 4
    //   2806: lstore 24
    //   2808: lload_2
    //   2809: lstore 14
    //   2811: lload 4
    //   2813: lstore 22
    //   2815: lload_2
    //   2816: lstore 12
    //   2818: lload 4
    //   2820: lstore 20
    //   2822: lload_2
    //   2823: lstore 18
    //   2825: lload 4
    //   2827: lstore 26
    //   2829: lload_2
    //   2830: lstore 10
    //   2832: lload 4
    //   2834: lstore 28
    //   2836: lload_2
    //   2837: lstore 16
    //   2839: aload 45
    //   2841: invokestatic 545	com/tencent/mm/plugin/music/c/b:Jv	(Ljava/lang/String;)[J
    //   2844: astore 44
    //   2846: aload 34
    //   2848: astore 37
    //   2850: lload 4
    //   2852: lstore 8
    //   2854: lload_2
    //   2855: lstore 6
    //   2857: aload 33
    //   2859: astore 36
    //   2861: aload 38
    //   2863: astore 35
    //   2865: lload 4
    //   2867: lstore 24
    //   2869: lload_2
    //   2870: lstore 14
    //   2872: lload 4
    //   2874: lstore 22
    //   2876: lload_2
    //   2877: lstore 12
    //   2879: lload 4
    //   2881: lstore 20
    //   2883: lload_2
    //   2884: lstore 18
    //   2886: lload 4
    //   2888: lstore 26
    //   2890: lload_2
    //   2891: lstore 10
    //   2893: lload 4
    //   2895: lstore 28
    //   2897: lload_2
    //   2898: lstore 16
    //   2900: aload 34
    //   2902: ldc_w 547
    //   2905: invokevirtual 287	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2908: lconst_0
    //   2909: invokestatic 551	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   2912: lstore 30
    //   2914: aload 34
    //   2916: astore 37
    //   2918: lload 4
    //   2920: lstore 8
    //   2922: lload_2
    //   2923: lstore 6
    //   2925: aload 33
    //   2927: astore 36
    //   2929: aload 38
    //   2931: astore 35
    //   2933: lload 4
    //   2935: lstore 24
    //   2937: lload_2
    //   2938: lstore 14
    //   2940: lload 4
    //   2942: lstore 22
    //   2944: lload_2
    //   2945: lstore 12
    //   2947: lload 4
    //   2949: lstore 20
    //   2951: lload_2
    //   2952: lstore 18
    //   2954: lload 4
    //   2956: lstore 26
    //   2958: lload_2
    //   2959: lstore 10
    //   2961: lload 4
    //   2963: lstore 28
    //   2965: lload_2
    //   2966: lstore 16
    //   2968: ldc 76
    //   2970: ldc_w 553
    //   2973: iconst_2
    //   2974: anewarray 4	java/lang/Object
    //   2977: dup
    //   2978: iconst_0
    //   2979: aload 45
    //   2981: aastore
    //   2982: dup
    //   2983: iconst_1
    //   2984: lload 30
    //   2986: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2989: aastore
    //   2990: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2993: aload 44
    //   2995: ifnonnull +864 -> 3859
    //   2998: aload 34
    //   3000: astore 37
    //   3002: lload 4
    //   3004: lstore 8
    //   3006: lload_2
    //   3007: lstore 6
    //   3009: aload 33
    //   3011: astore 36
    //   3013: aload 38
    //   3015: astore 35
    //   3017: lload 4
    //   3019: lstore 24
    //   3021: lload_2
    //   3022: lstore 14
    //   3024: lload 4
    //   3026: lstore 22
    //   3028: lload_2
    //   3029: lstore 12
    //   3031: lload 4
    //   3033: lstore 20
    //   3035: lload_2
    //   3036: lstore 18
    //   3038: lload 4
    //   3040: lstore 26
    //   3042: lload_2
    //   3043: lstore 10
    //   3045: lload 4
    //   3047: lstore 28
    //   3049: lload_2
    //   3050: lstore 16
    //   3052: ldc 76
    //   3054: ldc_w 555
    //   3057: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3060: lload_2
    //   3061: lstore 4
    //   3063: lload_2
    //   3064: lconst_0
    //   3065: lcmp
    //   3066: ifeq +3852 -> 6918
    //   3069: lconst_0
    //   3070: lstore 4
    //   3072: goto +3846 -> 6918
    //   3075: aload 34
    //   3077: astore 37
    //   3079: lload 4
    //   3081: lstore 8
    //   3083: lload_2
    //   3084: lstore 6
    //   3086: aload 33
    //   3088: astore 36
    //   3090: aload 38
    //   3092: astore 35
    //   3094: lload 4
    //   3096: lstore 24
    //   3098: lload_2
    //   3099: lstore 14
    //   3101: lload 4
    //   3103: lstore 22
    //   3105: lload_2
    //   3106: lstore 12
    //   3108: lload 4
    //   3110: lstore 20
    //   3112: lload_2
    //   3113: lstore 18
    //   3115: lload 4
    //   3117: lstore 26
    //   3119: lload_2
    //   3120: lstore 10
    //   3122: lload 4
    //   3124: lstore 28
    //   3126: lload_2
    //   3127: lstore 16
    //   3129: ldc 76
    //   3131: ldc_w 557
    //   3134: iconst_2
    //   3135: anewarray 4	java/lang/Object
    //   3138: dup
    //   3139: iconst_0
    //   3140: lload 30
    //   3142: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3145: aastore
    //   3146: dup
    //   3147: iconst_1
    //   3148: lload_2
    //   3149: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3152: aastore
    //   3153: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3156: aload 34
    //   3158: astore 37
    //   3160: lload 4
    //   3162: lstore 8
    //   3164: lload_2
    //   3165: lstore 6
    //   3167: aload 33
    //   3169: astore 36
    //   3171: aload 38
    //   3173: astore 35
    //   3175: lload 4
    //   3177: lstore 24
    //   3179: lload_2
    //   3180: lstore 14
    //   3182: lload 4
    //   3184: lstore 22
    //   3186: lload_2
    //   3187: lstore 12
    //   3189: lload 4
    //   3191: lstore 20
    //   3193: lload_2
    //   3194: lstore 18
    //   3196: lload 4
    //   3198: lstore 26
    //   3200: lload_2
    //   3201: lstore 10
    //   3203: lload 4
    //   3205: lstore 28
    //   3207: lload_2
    //   3208: lstore 16
    //   3210: aload 33
    //   3212: lload 30
    //   3214: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   3217: aload 34
    //   3219: astore 37
    //   3221: lload 4
    //   3223: lstore 8
    //   3225: lload_2
    //   3226: lstore 6
    //   3228: aload 33
    //   3230: astore 36
    //   3232: aload 38
    //   3234: astore 35
    //   3236: lload 4
    //   3238: lstore 24
    //   3240: lload_2
    //   3241: lstore 14
    //   3243: lload 4
    //   3245: lstore 22
    //   3247: lload_2
    //   3248: lstore 12
    //   3250: lload 4
    //   3252: lstore 20
    //   3254: lload_2
    //   3255: lstore 18
    //   3257: lload 4
    //   3259: lstore 26
    //   3261: lload_2
    //   3262: lstore 10
    //   3264: lload 4
    //   3266: lstore 28
    //   3268: lload_2
    //   3269: lstore 16
    //   3271: aload 33
    //   3273: lload_2
    //   3274: invokevirtual 560	java/io/RandomAccessFile:seek	(J)V
    //   3277: aload 34
    //   3279: astore 37
    //   3281: lload 4
    //   3283: lstore 8
    //   3285: lload_2
    //   3286: lstore 6
    //   3288: aload 33
    //   3290: astore 36
    //   3292: aload 38
    //   3294: astore 35
    //   3296: lload 4
    //   3298: lstore 24
    //   3300: lload_2
    //   3301: lstore 14
    //   3303: lload 4
    //   3305: lstore 22
    //   3307: lload_2
    //   3308: lstore 12
    //   3310: lload 4
    //   3312: lstore 20
    //   3314: lload_2
    //   3315: lstore 18
    //   3317: lload 4
    //   3319: lstore 26
    //   3321: lload_2
    //   3322: lstore 10
    //   3324: lload 4
    //   3326: lstore 28
    //   3328: lload_2
    //   3329: lstore 16
    //   3331: aload 34
    //   3333: invokevirtual 564	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3336: astore 38
    //   3338: aload 38
    //   3340: astore 35
    //   3342: lload_2
    //   3343: lstore 18
    //   3345: lload_2
    //   3346: lstore 16
    //   3348: lload_2
    //   3349: lstore 14
    //   3351: lload_2
    //   3352: lstore 10
    //   3354: lload_2
    //   3355: lstore 8
    //   3357: lload_2
    //   3358: lstore 12
    //   3360: sipush 4096
    //   3363: newarray byte
    //   3365: astore 36
    //   3367: lload_2
    //   3368: lstore 18
    //   3370: lload_2
    //   3371: lstore 16
    //   3373: lload_2
    //   3374: lstore 14
    //   3376: lload_2
    //   3377: lstore 10
    //   3379: lload_2
    //   3380: lstore 8
    //   3382: lload_2
    //   3383: lstore 12
    //   3385: aload_0
    //   3386: getfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3389: ifne +1194 -> 4583
    //   3392: lload_2
    //   3393: lstore 18
    //   3395: lload_2
    //   3396: lstore 16
    //   3398: lload_2
    //   3399: lstore 14
    //   3401: lload_2
    //   3402: lstore 10
    //   3404: lload_2
    //   3405: lstore 8
    //   3407: lload_2
    //   3408: lstore 12
    //   3410: aload 35
    //   3412: aload 36
    //   3414: invokevirtual 570	java/io/InputStream:read	([B)I
    //   3417: istore_1
    //   3418: iload_1
    //   3419: ifle +1102 -> 4521
    //   3422: lload_2
    //   3423: lstore 18
    //   3425: lload_2
    //   3426: lstore 16
    //   3428: lload_2
    //   3429: lstore 14
    //   3431: lload_2
    //   3432: lstore 10
    //   3434: lload_2
    //   3435: lstore 8
    //   3437: lload_2
    //   3438: lstore 12
    //   3440: aload 33
    //   3442: aload 36
    //   3444: iconst_0
    //   3445: iload_1
    //   3446: invokevirtual 574	java/io/RandomAccessFile:write	([BII)V
    //   3449: lload_2
    //   3450: iload_1
    //   3451: i2l
    //   3452: ladd
    //   3453: lstore 6
    //   3455: lload 6
    //   3457: lstore 18
    //   3459: lload 6
    //   3461: lstore 16
    //   3463: lload 6
    //   3465: lstore 14
    //   3467: lload 6
    //   3469: lstore 10
    //   3471: lload 6
    //   3473: lstore 8
    //   3475: lload 6
    //   3477: lstore 12
    //   3479: ldc 76
    //   3481: ldc_w 576
    //   3484: iconst_2
    //   3485: anewarray 4	java/lang/Object
    //   3488: dup
    //   3489: iconst_0
    //   3490: lload 6
    //   3492: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3495: aastore
    //   3496: dup
    //   3497: iconst_1
    //   3498: lload 30
    //   3500: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3503: aastore
    //   3504: invokestatic 579	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3507: lload 6
    //   3509: lstore 18
    //   3511: lload 6
    //   3513: lstore 16
    //   3515: lload 6
    //   3517: lstore 14
    //   3519: lload 6
    //   3521: lstore 10
    //   3523: lload 6
    //   3525: lstore 8
    //   3527: lload 6
    //   3529: lstore 12
    //   3531: aload_0
    //   3532: getfield 98	com/tencent/mm/plugin/music/c/b:kaC	Z
    //   3535: ifeq +721 -> 4256
    //   3538: lload 6
    //   3540: lstore 18
    //   3542: lload 6
    //   3544: lstore 16
    //   3546: lload 6
    //   3548: lstore 14
    //   3550: lload 6
    //   3552: lstore 10
    //   3554: lload 6
    //   3556: lstore 8
    //   3558: lload 6
    //   3560: lstore 12
    //   3562: aload_0
    //   3563: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   3566: lload 6
    //   3568: putfield 68	com/tencent/mm/plugin/music/c/a:myq	J
    //   3571: lload 6
    //   3573: lstore 18
    //   3575: lload 6
    //   3577: lstore 16
    //   3579: lload 6
    //   3581: lstore 14
    //   3583: lload 6
    //   3585: lstore 10
    //   3587: lload 6
    //   3589: lstore 8
    //   3591: lload 6
    //   3593: lstore 12
    //   3595: aload_0
    //   3596: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   3599: lload 30
    //   3601: putfield 71	com/tencent/mm/plugin/music/c/a:mys	J
    //   3604: lload 6
    //   3606: lstore_2
    //   3607: lload 6
    //   3609: ldc2_w 366
    //   3612: lcmp
    //   3613: iflt -246 -> 3367
    //   3616: lload 6
    //   3618: lstore 18
    //   3620: lload 6
    //   3622: lstore 16
    //   3624: lload 6
    //   3626: lstore 14
    //   3628: lload 6
    //   3630: lstore 10
    //   3632: lload 6
    //   3634: lstore 8
    //   3636: lload 6
    //   3638: lstore 12
    //   3640: new 8	com/tencent/mm/plugin/music/c/b$a
    //   3643: dup
    //   3644: aload_0
    //   3645: iconst_1
    //   3646: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   3649: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   3652: lload 6
    //   3654: lstore_2
    //   3655: goto -288 -> 3367
    //   3658: astore 36
    //   3660: lload 18
    //   3662: lstore_2
    //   3663: ldc 76
    //   3665: aload 36
    //   3667: ldc_w 581
    //   3670: iconst_1
    //   3671: anewarray 4	java/lang/Object
    //   3674: dup
    //   3675: iconst_0
    //   3676: aload 43
    //   3678: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3681: aastore
    //   3682: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3685: aload_0
    //   3686: sipush 750
    //   3689: putfield 50	com/tencent/mm/plugin/music/c/b:dUg	I
    //   3692: aload_0
    //   3693: iconst_5
    //   3694: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   3697: lload 4
    //   3699: lconst_0
    //   3700: lcmp
    //   3701: ifne +1181 -> 4882
    //   3704: lload_2
    //   3705: lconst_0
    //   3706: lcmp
    //   3707: ifle +1175 -> 4882
    //   3710: ldc 76
    //   3712: ldc_w 425
    //   3715: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3718: aload 33
    //   3720: lload_2
    //   3721: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   3724: aload_0
    //   3725: lload_2
    //   3726: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   3729: lload_2
    //   3730: ldc2_w 366
    //   3733: lcmp
    //   3734: ifge +15 -> 3749
    //   3737: new 8	com/tencent/mm/plugin/music/c/b$a
    //   3740: dup
    //   3741: aload_0
    //   3742: iconst_1
    //   3743: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   3746: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   3749: aload 35
    //   3751: ifnull +8 -> 3759
    //   3754: aload 35
    //   3756: invokevirtual 582	java/io/InputStream:close	()V
    //   3759: aload 33
    //   3761: ifnull +8 -> 3769
    //   3764: aload 33
    //   3766: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   3769: aload 34
    //   3771: ifnull +8 -> 3779
    //   3774: aload 34
    //   3776: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   3779: aload_0
    //   3780: iconst_1
    //   3781: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3784: ldc 76
    //   3786: ldc_w 432
    //   3789: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3792: return
    //   3793: aload 34
    //   3795: astore 37
    //   3797: lload 4
    //   3799: lstore 8
    //   3801: lload_2
    //   3802: lstore 6
    //   3804: aload 33
    //   3806: astore 36
    //   3808: aload 38
    //   3810: astore 35
    //   3812: lload 4
    //   3814: lstore 24
    //   3816: lload_2
    //   3817: lstore 14
    //   3819: lload 4
    //   3821: lstore 22
    //   3823: lload_2
    //   3824: lstore 12
    //   3826: lload 4
    //   3828: lstore 20
    //   3830: lload_2
    //   3831: lstore 18
    //   3833: lload 4
    //   3835: lstore 26
    //   3837: lload_2
    //   3838: lstore 10
    //   3840: lload 4
    //   3842: lstore 28
    //   3844: lload_2
    //   3845: lstore 16
    //   3847: ldc_w 584
    //   3850: ldc_w 586
    //   3853: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3856: goto -1135 -> 2721
    //   3859: lload_2
    //   3860: lconst_0
    //   3861: lcmp
    //   3862: ifle +385 -> 4247
    //   3865: lload_2
    //   3866: aload 44
    //   3868: iconst_0
    //   3869: laload
    //   3870: lcmp
    //   3871: ifeq +376 -> 4247
    //   3874: aload 34
    //   3876: astore 37
    //   3878: lload 4
    //   3880: lstore 8
    //   3882: lload_2
    //   3883: lstore 6
    //   3885: aload 33
    //   3887: astore 36
    //   3889: aload 38
    //   3891: astore 35
    //   3893: lload 4
    //   3895: lstore 24
    //   3897: lload_2
    //   3898: lstore 14
    //   3900: lload 4
    //   3902: lstore 22
    //   3904: lload_2
    //   3905: lstore 12
    //   3907: lload 4
    //   3909: lstore 20
    //   3911: lload_2
    //   3912: lstore 18
    //   3914: lload 4
    //   3916: lstore 26
    //   3918: lload_2
    //   3919: lstore 10
    //   3921: lload 4
    //   3923: lstore 28
    //   3925: lload_2
    //   3926: lstore 16
    //   3928: ldc 76
    //   3930: ldc_w 588
    //   3933: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3936: aload 34
    //   3938: astore 37
    //   3940: lload 4
    //   3942: lstore 8
    //   3944: lload_2
    //   3945: lstore 6
    //   3947: aload 33
    //   3949: astore 36
    //   3951: aload 38
    //   3953: astore 35
    //   3955: lload 4
    //   3957: lstore 24
    //   3959: lload_2
    //   3960: lstore 14
    //   3962: lload 4
    //   3964: lstore 22
    //   3966: lload_2
    //   3967: lstore 12
    //   3969: lload 4
    //   3971: lstore 20
    //   3973: lload_2
    //   3974: lstore 18
    //   3976: lload 4
    //   3978: lstore 26
    //   3980: lload_2
    //   3981: lstore 10
    //   3983: lload 4
    //   3985: lstore 28
    //   3987: lload_2
    //   3988: lstore 16
    //   3990: aload_0
    //   3991: bipush 6
    //   3993: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   3996: lload 4
    //   3998: lconst_0
    //   3999: lcmp
    //   4000: ifne +96 -> 4096
    //   4003: lload_2
    //   4004: lconst_0
    //   4005: lcmp
    //   4006: ifle +90 -> 4096
    //   4009: ldc 76
    //   4011: ldc_w 425
    //   4014: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4017: aload 33
    //   4019: lload_2
    //   4020: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   4023: aload_0
    //   4024: lload_2
    //   4025: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   4028: lload_2
    //   4029: ldc2_w 366
    //   4032: lcmp
    //   4033: ifge +15 -> 4048
    //   4036: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4039: dup
    //   4040: aload_0
    //   4041: iconst_1
    //   4042: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4045: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   4048: aload 33
    //   4050: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   4053: aload 34
    //   4055: ifnull +8 -> 4063
    //   4058: aload 34
    //   4060: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   4063: aload_0
    //   4064: iconst_1
    //   4065: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4068: ldc 76
    //   4070: ldc_w 432
    //   4073: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4076: return
    //   4077: astore 35
    //   4079: ldc 76
    //   4081: aload 35
    //   4083: ldc_w 434
    //   4086: iconst_0
    //   4087: anewarray 4	java/lang/Object
    //   4090: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4093: goto -70 -> 4023
    //   4096: lload 4
    //   4098: lconst_0
    //   4099: lcmp
    //   4100: ifeq +47 -> 4147
    //   4103: lload_2
    //   4104: lload 4
    //   4106: lcmp
    //   4107: ifeq +40 -> 4147
    //   4110: ldc 76
    //   4112: ldc_w 436
    //   4115: iconst_2
    //   4116: anewarray 4	java/lang/Object
    //   4119: dup
    //   4120: iconst_0
    //   4121: lload 4
    //   4123: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4126: aastore
    //   4127: dup
    //   4128: iconst_1
    //   4129: lload_2
    //   4130: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4133: aastore
    //   4134: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4137: aload_0
    //   4138: lload_2
    //   4139: lload 4
    //   4141: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   4144: goto -96 -> 4048
    //   4147: lload 4
    //   4149: lconst_0
    //   4150: lcmp
    //   4151: ifeq +66 -> 4217
    //   4154: lload_2
    //   4155: lload 4
    //   4157: lcmp
    //   4158: ifne +59 -> 4217
    //   4161: ldc 76
    //   4163: ldc_w 440
    //   4166: iconst_2
    //   4167: anewarray 4	java/lang/Object
    //   4170: dup
    //   4171: iconst_0
    //   4172: lload 4
    //   4174: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4177: aastore
    //   4178: dup
    //   4179: iconst_1
    //   4180: lload_2
    //   4181: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4184: aastore
    //   4185: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4188: aload_0
    //   4189: lload 4
    //   4191: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   4194: lload_2
    //   4195: ldc2_w 366
    //   4198: lcmp
    //   4199: ifge -151 -> 4048
    //   4202: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4205: dup
    //   4206: aload_0
    //   4207: iconst_1
    //   4208: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4211: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   4214: goto -166 -> 4048
    //   4217: ldc 76
    //   4219: ldc_w 442
    //   4222: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4225: goto -177 -> 4048
    //   4228: astore 33
    //   4230: ldc 76
    //   4232: aload 33
    //   4234: ldc_w 434
    //   4237: iconst_0
    //   4238: anewarray 4	java/lang/Object
    //   4241: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4244: goto -191 -> 4053
    //   4247: aload 44
    //   4249: iconst_2
    //   4250: laload
    //   4251: lstore 4
    //   4253: goto +2676 -> 6929
    //   4256: lload 6
    //   4258: lstore 18
    //   4260: lload 6
    //   4262: lstore 16
    //   4264: lload 6
    //   4266: lstore 14
    //   4268: lload 6
    //   4270: lstore 10
    //   4272: lload 6
    //   4274: lstore 8
    //   4276: lload 6
    //   4278: lstore 12
    //   4280: aload_0
    //   4281: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   4284: lload 6
    //   4286: putfield 59	com/tencent/mm/plugin/music/c/a:myo	J
    //   4289: lload 6
    //   4291: lstore 18
    //   4293: lload 6
    //   4295: lstore 16
    //   4297: lload 6
    //   4299: lstore 14
    //   4301: lload 6
    //   4303: lstore 10
    //   4305: lload 6
    //   4307: lstore 8
    //   4309: lload 6
    //   4311: lstore 12
    //   4313: aload_0
    //   4314: getfield 54	com/tencent/mm/plugin/music/c/b:myv	Lcom/tencent/mm/plugin/music/c/a;
    //   4317: lload 30
    //   4319: putfield 62	com/tencent/mm/plugin/music/c/a:myp	J
    //   4322: goto -718 -> 3604
    //   4325: astore 38
    //   4327: aload 35
    //   4329: astore 39
    //   4331: lload 16
    //   4333: lstore_2
    //   4334: aload 34
    //   4336: astore 37
    //   4338: lload 4
    //   4340: lstore 8
    //   4342: lload_2
    //   4343: lstore 6
    //   4345: aload 33
    //   4347: astore 36
    //   4349: aload 39
    //   4351: astore 35
    //   4353: ldc 76
    //   4355: aload 38
    //   4357: ldc_w 581
    //   4360: iconst_1
    //   4361: anewarray 4	java/lang/Object
    //   4364: dup
    //   4365: iconst_0
    //   4366: aload 43
    //   4368: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4371: aastore
    //   4372: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4375: aload 34
    //   4377: astore 37
    //   4379: lload 4
    //   4381: lstore 8
    //   4383: lload_2
    //   4384: lstore 6
    //   4386: aload 33
    //   4388: astore 36
    //   4390: aload 39
    //   4392: astore 35
    //   4394: aload_0
    //   4395: sipush 751
    //   4398: putfield 50	com/tencent/mm/plugin/music/c/b:dUg	I
    //   4401: aload 34
    //   4403: astore 37
    //   4405: lload 4
    //   4407: lstore 8
    //   4409: lload_2
    //   4410: lstore 6
    //   4412: aload 33
    //   4414: astore 36
    //   4416: aload 39
    //   4418: astore 35
    //   4420: aload_0
    //   4421: iconst_5
    //   4422: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   4425: lload 4
    //   4427: lconst_0
    //   4428: lcmp
    //   4429: ifne +642 -> 5071
    //   4432: lload_2
    //   4433: lconst_0
    //   4434: lcmp
    //   4435: ifle +636 -> 5071
    //   4438: ldc 76
    //   4440: ldc_w 425
    //   4443: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4446: aload 33
    //   4448: lload_2
    //   4449: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   4452: aload_0
    //   4453: lload_2
    //   4454: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   4457: lload_2
    //   4458: ldc2_w 366
    //   4461: lcmp
    //   4462: ifge +15 -> 4477
    //   4465: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4468: dup
    //   4469: aload_0
    //   4470: iconst_1
    //   4471: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4474: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   4477: aload 39
    //   4479: ifnull +8 -> 4487
    //   4482: aload 39
    //   4484: invokevirtual 582	java/io/InputStream:close	()V
    //   4487: aload 33
    //   4489: ifnull +8 -> 4497
    //   4492: aload 33
    //   4494: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   4497: aload 34
    //   4499: ifnull +8 -> 4507
    //   4502: aload 34
    //   4504: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   4507: aload_0
    //   4508: iconst_1
    //   4509: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4512: ldc 76
    //   4514: ldc_w 432
    //   4517: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4520: return
    //   4521: lload_2
    //   4522: lstore 18
    //   4524: lload_2
    //   4525: lstore 16
    //   4527: lload_2
    //   4528: lstore 14
    //   4530: lload_2
    //   4531: lstore 10
    //   4533: lload_2
    //   4534: lstore 8
    //   4536: lload_2
    //   4537: lstore 12
    //   4539: ldc 76
    //   4541: ldc_w 590
    //   4544: iconst_4
    //   4545: anewarray 4	java/lang/Object
    //   4548: dup
    //   4549: iconst_0
    //   4550: iload_1
    //   4551: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4554: aastore
    //   4555: dup
    //   4556: iconst_1
    //   4557: aload_0
    //   4558: getfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4561: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4564: aastore
    //   4565: dup
    //   4566: iconst_2
    //   4567: lload_2
    //   4568: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4571: aastore
    //   4572: dup
    //   4573: iconst_3
    //   4574: lload 30
    //   4576: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4579: aastore
    //   4580: invokestatic 291	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4583: lload 4
    //   4585: lconst_0
    //   4586: lcmp
    //   4587: ifne +106 -> 4693
    //   4590: lload_2
    //   4591: lconst_0
    //   4592: lcmp
    //   4593: ifle +100 -> 4693
    //   4596: ldc 76
    //   4598: ldc_w 425
    //   4601: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4604: aload 33
    //   4606: lload_2
    //   4607: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   4610: aload_0
    //   4611: lload_2
    //   4612: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   4615: lload_2
    //   4616: ldc2_w 366
    //   4619: lcmp
    //   4620: ifge +15 -> 4635
    //   4623: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4626: dup
    //   4627: aload_0
    //   4628: iconst_1
    //   4629: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4632: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   4635: aload 35
    //   4637: ifnull +8 -> 4645
    //   4640: aload 35
    //   4642: invokevirtual 582	java/io/InputStream:close	()V
    //   4645: aload 33
    //   4647: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   4650: aload 34
    //   4652: ifnull +8 -> 4660
    //   4655: aload 34
    //   4657: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   4660: aload_0
    //   4661: iconst_1
    //   4662: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4665: ldc 76
    //   4667: ldc_w 432
    //   4670: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4673: return
    //   4674: astore 36
    //   4676: ldc 76
    //   4678: aload 36
    //   4680: ldc_w 434
    //   4683: iconst_0
    //   4684: anewarray 4	java/lang/Object
    //   4687: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4690: goto -80 -> 4610
    //   4693: lload 4
    //   4695: lconst_0
    //   4696: lcmp
    //   4697: ifeq +47 -> 4744
    //   4700: lload_2
    //   4701: lload 4
    //   4703: lcmp
    //   4704: ifeq +40 -> 4744
    //   4707: ldc 76
    //   4709: ldc_w 436
    //   4712: iconst_2
    //   4713: anewarray 4	java/lang/Object
    //   4716: dup
    //   4717: iconst_0
    //   4718: lload 4
    //   4720: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4723: aastore
    //   4724: dup
    //   4725: iconst_1
    //   4726: lload_2
    //   4727: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4730: aastore
    //   4731: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4734: aload_0
    //   4735: lload_2
    //   4736: lload 4
    //   4738: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   4741: goto -106 -> 4635
    //   4744: lload 4
    //   4746: lconst_0
    //   4747: lcmp
    //   4748: ifeq +66 -> 4814
    //   4751: lload_2
    //   4752: lload 4
    //   4754: lcmp
    //   4755: ifne +59 -> 4814
    //   4758: ldc 76
    //   4760: ldc_w 440
    //   4763: iconst_2
    //   4764: anewarray 4	java/lang/Object
    //   4767: dup
    //   4768: iconst_0
    //   4769: lload 4
    //   4771: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4774: aastore
    //   4775: dup
    //   4776: iconst_1
    //   4777: lload_2
    //   4778: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4781: aastore
    //   4782: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4785: aload_0
    //   4786: lload 4
    //   4788: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   4791: lload_2
    //   4792: ldc2_w 366
    //   4795: lcmp
    //   4796: ifge -161 -> 4635
    //   4799: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4802: dup
    //   4803: aload_0
    //   4804: iconst_1
    //   4805: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4808: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   4811: goto -176 -> 4635
    //   4814: ldc 76
    //   4816: ldc_w 442
    //   4819: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4822: goto -187 -> 4635
    //   4825: astore 35
    //   4827: ldc 76
    //   4829: aload 35
    //   4831: ldc_w 592
    //   4834: iconst_0
    //   4835: anewarray 4	java/lang/Object
    //   4838: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4841: goto -196 -> 4645
    //   4844: astore 33
    //   4846: ldc 76
    //   4848: aload 33
    //   4850: ldc_w 434
    //   4853: iconst_0
    //   4854: anewarray 4	java/lang/Object
    //   4857: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4860: goto -210 -> 4650
    //   4863: astore 36
    //   4865: ldc 76
    //   4867: aload 36
    //   4869: ldc_w 434
    //   4872: iconst_0
    //   4873: anewarray 4	java/lang/Object
    //   4876: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4879: goto -1155 -> 3724
    //   4882: lload 4
    //   4884: lconst_0
    //   4885: lcmp
    //   4886: ifeq +47 -> 4933
    //   4889: lload_2
    //   4890: lload 4
    //   4892: lcmp
    //   4893: ifeq +40 -> 4933
    //   4896: ldc 76
    //   4898: ldc_w 436
    //   4901: iconst_2
    //   4902: anewarray 4	java/lang/Object
    //   4905: dup
    //   4906: iconst_0
    //   4907: lload 4
    //   4909: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4912: aastore
    //   4913: dup
    //   4914: iconst_1
    //   4915: lload_2
    //   4916: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4919: aastore
    //   4920: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4923: aload_0
    //   4924: lload_2
    //   4925: lload 4
    //   4927: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   4930: goto -1181 -> 3749
    //   4933: lload 4
    //   4935: lconst_0
    //   4936: lcmp
    //   4937: ifeq +66 -> 5003
    //   4940: lload_2
    //   4941: lload 4
    //   4943: lcmp
    //   4944: ifne +59 -> 5003
    //   4947: ldc 76
    //   4949: ldc_w 440
    //   4952: iconst_2
    //   4953: anewarray 4	java/lang/Object
    //   4956: dup
    //   4957: iconst_0
    //   4958: lload 4
    //   4960: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4963: aastore
    //   4964: dup
    //   4965: iconst_1
    //   4966: lload_2
    //   4967: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4970: aastore
    //   4971: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4974: aload_0
    //   4975: lload 4
    //   4977: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   4980: lload_2
    //   4981: ldc2_w 366
    //   4984: lcmp
    //   4985: ifge -1236 -> 3749
    //   4988: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4991: dup
    //   4992: aload_0
    //   4993: iconst_1
    //   4994: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4997: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   5000: goto -1251 -> 3749
    //   5003: ldc 76
    //   5005: ldc_w 442
    //   5008: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5011: goto -1262 -> 3749
    //   5014: astore 35
    //   5016: ldc 76
    //   5018: aload 35
    //   5020: ldc_w 592
    //   5023: iconst_0
    //   5024: anewarray 4	java/lang/Object
    //   5027: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5030: goto -1271 -> 3759
    //   5033: astore 33
    //   5035: ldc 76
    //   5037: aload 33
    //   5039: ldc_w 434
    //   5042: iconst_0
    //   5043: anewarray 4	java/lang/Object
    //   5046: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5049: goto -1280 -> 3769
    //   5052: astore 35
    //   5054: ldc 76
    //   5056: aload 35
    //   5058: ldc_w 434
    //   5061: iconst_0
    //   5062: anewarray 4	java/lang/Object
    //   5065: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5068: goto -616 -> 4452
    //   5071: lload 4
    //   5073: lconst_0
    //   5074: lcmp
    //   5075: ifeq +47 -> 5122
    //   5078: lload_2
    //   5079: lload 4
    //   5081: lcmp
    //   5082: ifeq +40 -> 5122
    //   5085: ldc 76
    //   5087: ldc_w 436
    //   5090: iconst_2
    //   5091: anewarray 4	java/lang/Object
    //   5094: dup
    //   5095: iconst_0
    //   5096: lload 4
    //   5098: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5101: aastore
    //   5102: dup
    //   5103: iconst_1
    //   5104: lload_2
    //   5105: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5108: aastore
    //   5109: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5112: aload_0
    //   5113: lload_2
    //   5114: lload 4
    //   5116: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   5119: goto -642 -> 4477
    //   5122: lload 4
    //   5124: lconst_0
    //   5125: lcmp
    //   5126: ifeq +66 -> 5192
    //   5129: lload_2
    //   5130: lload 4
    //   5132: lcmp
    //   5133: ifne +59 -> 5192
    //   5136: ldc 76
    //   5138: ldc_w 440
    //   5141: iconst_2
    //   5142: anewarray 4	java/lang/Object
    //   5145: dup
    //   5146: iconst_0
    //   5147: lload 4
    //   5149: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5152: aastore
    //   5153: dup
    //   5154: iconst_1
    //   5155: lload_2
    //   5156: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5159: aastore
    //   5160: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5163: aload_0
    //   5164: lload 4
    //   5166: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   5169: lload_2
    //   5170: ldc2_w 366
    //   5173: lcmp
    //   5174: ifge -697 -> 4477
    //   5177: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5180: dup
    //   5181: aload_0
    //   5182: iconst_1
    //   5183: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5186: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   5189: goto -712 -> 4477
    //   5192: ldc 76
    //   5194: ldc_w 442
    //   5197: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5200: goto -723 -> 4477
    //   5203: astore 35
    //   5205: ldc 76
    //   5207: aload 35
    //   5209: ldc_w 592
    //   5212: iconst_0
    //   5213: anewarray 4	java/lang/Object
    //   5216: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5219: goto -732 -> 4487
    //   5222: astore 33
    //   5224: ldc 76
    //   5226: aload 33
    //   5228: ldc_w 434
    //   5231: iconst_0
    //   5232: anewarray 4	java/lang/Object
    //   5235: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5238: goto -741 -> 4497
    //   5241: astore 38
    //   5243: aconst_null
    //   5244: astore 33
    //   5246: aconst_null
    //   5247: astore 34
    //   5249: aload 41
    //   5251: astore 39
    //   5253: aload 34
    //   5255: astore 37
    //   5257: lload 4
    //   5259: lstore 8
    //   5261: lload_2
    //   5262: lstore 6
    //   5264: aload 33
    //   5266: astore 36
    //   5268: aload 39
    //   5270: astore 35
    //   5272: ldc 76
    //   5274: aload 38
    //   5276: ldc_w 581
    //   5279: iconst_1
    //   5280: anewarray 4	java/lang/Object
    //   5283: dup
    //   5284: iconst_0
    //   5285: aload 43
    //   5287: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5290: aastore
    //   5291: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5294: aload 34
    //   5296: astore 37
    //   5298: lload 4
    //   5300: lstore 8
    //   5302: lload_2
    //   5303: lstore 6
    //   5305: aload 33
    //   5307: astore 36
    //   5309: aload 39
    //   5311: astore 35
    //   5313: aload_0
    //   5314: sipush 752
    //   5317: putfield 50	com/tencent/mm/plugin/music/c/b:dUg	I
    //   5320: aload 34
    //   5322: astore 37
    //   5324: lload 4
    //   5326: lstore 8
    //   5328: lload_2
    //   5329: lstore 6
    //   5331: aload 33
    //   5333: astore 36
    //   5335: aload 39
    //   5337: astore 35
    //   5339: aload_0
    //   5340: iconst_5
    //   5341: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   5344: lload 4
    //   5346: lconst_0
    //   5347: lcmp
    //   5348: ifne +111 -> 5459
    //   5351: lload_2
    //   5352: lconst_0
    //   5353: lcmp
    //   5354: ifle +105 -> 5459
    //   5357: ldc 76
    //   5359: ldc_w 425
    //   5362: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5365: aload 33
    //   5367: lload_2
    //   5368: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   5371: aload_0
    //   5372: lload_2
    //   5373: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   5376: lload_2
    //   5377: ldc2_w 366
    //   5380: lcmp
    //   5381: ifge +15 -> 5396
    //   5384: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5387: dup
    //   5388: aload_0
    //   5389: iconst_1
    //   5390: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5393: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   5396: aload 39
    //   5398: ifnull +8 -> 5406
    //   5401: aload 39
    //   5403: invokevirtual 582	java/io/InputStream:close	()V
    //   5406: aload 33
    //   5408: ifnull +8 -> 5416
    //   5411: aload 33
    //   5413: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   5416: aload 34
    //   5418: ifnull +8 -> 5426
    //   5421: aload 34
    //   5423: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   5426: aload_0
    //   5427: iconst_1
    //   5428: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5431: ldc 76
    //   5433: ldc_w 432
    //   5436: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5439: return
    //   5440: astore 35
    //   5442: ldc 76
    //   5444: aload 35
    //   5446: ldc_w 434
    //   5449: iconst_0
    //   5450: anewarray 4	java/lang/Object
    //   5453: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5456: goto -85 -> 5371
    //   5459: lload 4
    //   5461: lconst_0
    //   5462: lcmp
    //   5463: ifeq +47 -> 5510
    //   5466: lload_2
    //   5467: lload 4
    //   5469: lcmp
    //   5470: ifeq +40 -> 5510
    //   5473: ldc 76
    //   5475: ldc_w 436
    //   5478: iconst_2
    //   5479: anewarray 4	java/lang/Object
    //   5482: dup
    //   5483: iconst_0
    //   5484: lload 4
    //   5486: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5489: aastore
    //   5490: dup
    //   5491: iconst_1
    //   5492: lload_2
    //   5493: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5496: aastore
    //   5497: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5500: aload_0
    //   5501: lload_2
    //   5502: lload 4
    //   5504: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   5507: goto -111 -> 5396
    //   5510: lload 4
    //   5512: lconst_0
    //   5513: lcmp
    //   5514: ifeq +66 -> 5580
    //   5517: lload_2
    //   5518: lload 4
    //   5520: lcmp
    //   5521: ifne +59 -> 5580
    //   5524: ldc 76
    //   5526: ldc_w 440
    //   5529: iconst_2
    //   5530: anewarray 4	java/lang/Object
    //   5533: dup
    //   5534: iconst_0
    //   5535: lload 4
    //   5537: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5540: aastore
    //   5541: dup
    //   5542: iconst_1
    //   5543: lload_2
    //   5544: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5547: aastore
    //   5548: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5551: aload_0
    //   5552: lload 4
    //   5554: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   5557: lload_2
    //   5558: ldc2_w 366
    //   5561: lcmp
    //   5562: ifge -166 -> 5396
    //   5565: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5568: dup
    //   5569: aload_0
    //   5570: iconst_1
    //   5571: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5574: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   5577: goto -181 -> 5396
    //   5580: ldc 76
    //   5582: ldc_w 442
    //   5585: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5588: goto -192 -> 5396
    //   5591: astore 35
    //   5593: ldc 76
    //   5595: aload 35
    //   5597: ldc_w 592
    //   5600: iconst_0
    //   5601: anewarray 4	java/lang/Object
    //   5604: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5607: goto -201 -> 5406
    //   5610: astore 33
    //   5612: ldc 76
    //   5614: aload 33
    //   5616: ldc_w 434
    //   5619: iconst_0
    //   5620: anewarray 4	java/lang/Object
    //   5623: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5626: goto -210 -> 5416
    //   5629: astore 38
    //   5631: aconst_null
    //   5632: astore 33
    //   5634: aconst_null
    //   5635: astore 34
    //   5637: aload 40
    //   5639: astore 39
    //   5641: aload 34
    //   5643: astore 37
    //   5645: lload 4
    //   5647: lstore 8
    //   5649: lload_2
    //   5650: lstore 6
    //   5652: aload 33
    //   5654: astore 36
    //   5656: aload 39
    //   5658: astore 35
    //   5660: ldc 76
    //   5662: aload 38
    //   5664: ldc_w 581
    //   5667: iconst_1
    //   5668: anewarray 4	java/lang/Object
    //   5671: dup
    //   5672: iconst_0
    //   5673: aload 43
    //   5675: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5678: aastore
    //   5679: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5682: aload 34
    //   5684: astore 37
    //   5686: lload 4
    //   5688: lstore 8
    //   5690: lload_2
    //   5691: lstore 6
    //   5693: aload 33
    //   5695: astore 36
    //   5697: aload 39
    //   5699: astore 35
    //   5701: aload_0
    //   5702: sipush 753
    //   5705: putfield 50	com/tencent/mm/plugin/music/c/b:dUg	I
    //   5708: aload 34
    //   5710: astore 37
    //   5712: lload 4
    //   5714: lstore 8
    //   5716: lload_2
    //   5717: lstore 6
    //   5719: aload 33
    //   5721: astore 36
    //   5723: aload 39
    //   5725: astore 35
    //   5727: aload_0
    //   5728: iconst_5
    //   5729: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   5732: lload 4
    //   5734: lconst_0
    //   5735: lcmp
    //   5736: ifne +111 -> 5847
    //   5739: lload_2
    //   5740: lconst_0
    //   5741: lcmp
    //   5742: ifle +105 -> 5847
    //   5745: ldc 76
    //   5747: ldc_w 425
    //   5750: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5753: aload 33
    //   5755: lload_2
    //   5756: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   5759: aload_0
    //   5760: lload_2
    //   5761: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   5764: lload_2
    //   5765: ldc2_w 366
    //   5768: lcmp
    //   5769: ifge +15 -> 5784
    //   5772: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5775: dup
    //   5776: aload_0
    //   5777: iconst_1
    //   5778: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5781: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   5784: aload 39
    //   5786: ifnull +8 -> 5794
    //   5789: aload 39
    //   5791: invokevirtual 582	java/io/InputStream:close	()V
    //   5794: aload 33
    //   5796: ifnull +8 -> 5804
    //   5799: aload 33
    //   5801: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   5804: aload 34
    //   5806: ifnull +8 -> 5814
    //   5809: aload 34
    //   5811: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   5814: aload_0
    //   5815: iconst_1
    //   5816: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5819: ldc 76
    //   5821: ldc_w 432
    //   5824: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5827: return
    //   5828: astore 35
    //   5830: ldc 76
    //   5832: aload 35
    //   5834: ldc_w 434
    //   5837: iconst_0
    //   5838: anewarray 4	java/lang/Object
    //   5841: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5844: goto -85 -> 5759
    //   5847: lload 4
    //   5849: lconst_0
    //   5850: lcmp
    //   5851: ifeq +47 -> 5898
    //   5854: lload_2
    //   5855: lload 4
    //   5857: lcmp
    //   5858: ifeq +40 -> 5898
    //   5861: ldc 76
    //   5863: ldc_w 436
    //   5866: iconst_2
    //   5867: anewarray 4	java/lang/Object
    //   5870: dup
    //   5871: iconst_0
    //   5872: lload 4
    //   5874: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5877: aastore
    //   5878: dup
    //   5879: iconst_1
    //   5880: lload_2
    //   5881: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5884: aastore
    //   5885: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5888: aload_0
    //   5889: lload_2
    //   5890: lload 4
    //   5892: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   5895: goto -111 -> 5784
    //   5898: lload 4
    //   5900: lconst_0
    //   5901: lcmp
    //   5902: ifeq +66 -> 5968
    //   5905: lload_2
    //   5906: lload 4
    //   5908: lcmp
    //   5909: ifne +59 -> 5968
    //   5912: ldc 76
    //   5914: ldc_w 440
    //   5917: iconst_2
    //   5918: anewarray 4	java/lang/Object
    //   5921: dup
    //   5922: iconst_0
    //   5923: lload 4
    //   5925: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5928: aastore
    //   5929: dup
    //   5930: iconst_1
    //   5931: lload_2
    //   5932: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5935: aastore
    //   5936: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5939: aload_0
    //   5940: lload 4
    //   5942: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   5945: lload_2
    //   5946: ldc2_w 366
    //   5949: lcmp
    //   5950: ifge -166 -> 5784
    //   5953: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5956: dup
    //   5957: aload_0
    //   5958: iconst_1
    //   5959: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5962: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   5965: goto -181 -> 5784
    //   5968: ldc 76
    //   5970: ldc_w 442
    //   5973: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5976: goto -192 -> 5784
    //   5979: astore 35
    //   5981: ldc 76
    //   5983: aload 35
    //   5985: ldc_w 592
    //   5988: iconst_0
    //   5989: anewarray 4	java/lang/Object
    //   5992: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5995: goto -201 -> 5794
    //   5998: astore 33
    //   6000: ldc 76
    //   6002: aload 33
    //   6004: ldc_w 434
    //   6007: iconst_0
    //   6008: anewarray 4	java/lang/Object
    //   6011: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6014: goto -210 -> 5804
    //   6017: astore 38
    //   6019: aconst_null
    //   6020: astore 33
    //   6022: aconst_null
    //   6023: astore 34
    //   6025: aload 34
    //   6027: astore 37
    //   6029: lload 4
    //   6031: lstore 8
    //   6033: lload_2
    //   6034: lstore 6
    //   6036: aload 33
    //   6038: astore 36
    //   6040: aload 39
    //   6042: astore 35
    //   6044: ldc 76
    //   6046: aload 38
    //   6048: ldc_w 581
    //   6051: iconst_1
    //   6052: anewarray 4	java/lang/Object
    //   6055: dup
    //   6056: iconst_0
    //   6057: aload 43
    //   6059: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6062: aastore
    //   6063: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6066: aload 34
    //   6068: astore 37
    //   6070: lload 4
    //   6072: lstore 8
    //   6074: lload_2
    //   6075: lstore 6
    //   6077: aload 33
    //   6079: astore 36
    //   6081: aload 39
    //   6083: astore 35
    //   6085: aload_0
    //   6086: sipush 754
    //   6089: putfield 50	com/tencent/mm/plugin/music/c/b:dUg	I
    //   6092: aload 34
    //   6094: astore 37
    //   6096: lload 4
    //   6098: lstore 8
    //   6100: lload_2
    //   6101: lstore 6
    //   6103: aload 33
    //   6105: astore 36
    //   6107: aload 39
    //   6109: astore 35
    //   6111: aload_0
    //   6112: iconst_5
    //   6113: invokespecial 410	com/tencent/mm/plugin/music/c/b:uG	(I)V
    //   6116: lload 4
    //   6118: lconst_0
    //   6119: lcmp
    //   6120: ifne +111 -> 6231
    //   6123: lload_2
    //   6124: lconst_0
    //   6125: lcmp
    //   6126: ifle +105 -> 6231
    //   6129: ldc 76
    //   6131: ldc_w 425
    //   6134: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6137: aload 33
    //   6139: lload_2
    //   6140: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   6143: aload_0
    //   6144: lload_2
    //   6145: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   6148: lload_2
    //   6149: ldc2_w 366
    //   6152: lcmp
    //   6153: ifge +15 -> 6168
    //   6156: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6159: dup
    //   6160: aload_0
    //   6161: iconst_1
    //   6162: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6165: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   6168: aload 39
    //   6170: ifnull +8 -> 6178
    //   6173: aload 39
    //   6175: invokevirtual 582	java/io/InputStream:close	()V
    //   6178: aload 33
    //   6180: ifnull +8 -> 6188
    //   6183: aload 33
    //   6185: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   6188: aload 34
    //   6190: ifnull +8 -> 6198
    //   6193: aload 34
    //   6195: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   6198: aload_0
    //   6199: iconst_1
    //   6200: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6203: ldc 76
    //   6205: ldc_w 432
    //   6208: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6211: return
    //   6212: astore 35
    //   6214: ldc 76
    //   6216: aload 35
    //   6218: ldc_w 434
    //   6221: iconst_0
    //   6222: anewarray 4	java/lang/Object
    //   6225: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6228: goto -85 -> 6143
    //   6231: lload 4
    //   6233: lconst_0
    //   6234: lcmp
    //   6235: ifeq +47 -> 6282
    //   6238: lload_2
    //   6239: lload 4
    //   6241: lcmp
    //   6242: ifeq +40 -> 6282
    //   6245: ldc 76
    //   6247: ldc_w 436
    //   6250: iconst_2
    //   6251: anewarray 4	java/lang/Object
    //   6254: dup
    //   6255: iconst_0
    //   6256: lload 4
    //   6258: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6261: aastore
    //   6262: dup
    //   6263: iconst_1
    //   6264: lload_2
    //   6265: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6268: aastore
    //   6269: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6272: aload_0
    //   6273: lload_2
    //   6274: lload 4
    //   6276: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   6279: goto -111 -> 6168
    //   6282: lload 4
    //   6284: lconst_0
    //   6285: lcmp
    //   6286: ifeq +66 -> 6352
    //   6289: lload_2
    //   6290: lload 4
    //   6292: lcmp
    //   6293: ifne +59 -> 6352
    //   6296: ldc 76
    //   6298: ldc_w 440
    //   6301: iconst_2
    //   6302: anewarray 4	java/lang/Object
    //   6305: dup
    //   6306: iconst_0
    //   6307: lload 4
    //   6309: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6312: aastore
    //   6313: dup
    //   6314: iconst_1
    //   6315: lload_2
    //   6316: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6319: aastore
    //   6320: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6323: aload_0
    //   6324: lload 4
    //   6326: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   6329: lload_2
    //   6330: ldc2_w 366
    //   6333: lcmp
    //   6334: ifge -166 -> 6168
    //   6337: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6340: dup
    //   6341: aload_0
    //   6342: iconst_1
    //   6343: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6346: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   6349: goto -181 -> 6168
    //   6352: ldc 76
    //   6354: ldc_w 442
    //   6357: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6360: goto -192 -> 6168
    //   6363: astore 35
    //   6365: ldc 76
    //   6367: aload 35
    //   6369: ldc_w 592
    //   6372: iconst_0
    //   6373: anewarray 4	java/lang/Object
    //   6376: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6379: goto -201 -> 6178
    //   6382: astore 33
    //   6384: ldc 76
    //   6386: aload 33
    //   6388: ldc_w 434
    //   6391: iconst_0
    //   6392: anewarray 4	java/lang/Object
    //   6395: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6398: goto -210 -> 6188
    //   6401: astore 38
    //   6403: aconst_null
    //   6404: astore 33
    //   6406: aconst_null
    //   6407: astore 34
    //   6409: lload 4
    //   6411: lconst_0
    //   6412: lcmp
    //   6413: ifne +113 -> 6526
    //   6416: lload_2
    //   6417: lconst_0
    //   6418: lcmp
    //   6419: ifle +107 -> 6526
    //   6422: ldc 76
    //   6424: ldc_w 425
    //   6427: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6430: aload 33
    //   6432: lload_2
    //   6433: invokevirtual 515	java/io/RandomAccessFile:setLength	(J)V
    //   6436: aload_0
    //   6437: lload_2
    //   6438: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   6441: lload_2
    //   6442: ldc2_w 366
    //   6445: lcmp
    //   6446: ifge +15 -> 6461
    //   6449: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6452: dup
    //   6453: aload_0
    //   6454: iconst_1
    //   6455: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6458: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   6461: aload 35
    //   6463: ifnull +8 -> 6471
    //   6466: aload 35
    //   6468: invokevirtual 582	java/io/InputStream:close	()V
    //   6471: aload 33
    //   6473: ifnull +8 -> 6481
    //   6476: aload 33
    //   6478: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   6481: aload 34
    //   6483: ifnull +8 -> 6491
    //   6486: aload 34
    //   6488: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   6491: aload_0
    //   6492: iconst_1
    //   6493: putfield 42	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6496: ldc 76
    //   6498: ldc_w 432
    //   6501: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6504: aload 38
    //   6506: athrow
    //   6507: astore 36
    //   6509: ldc 76
    //   6511: aload 36
    //   6513: ldc_w 434
    //   6516: iconst_0
    //   6517: anewarray 4	java/lang/Object
    //   6520: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6523: goto -87 -> 6436
    //   6526: lload 4
    //   6528: lconst_0
    //   6529: lcmp
    //   6530: ifeq +47 -> 6577
    //   6533: lload_2
    //   6534: lload 4
    //   6536: lcmp
    //   6537: ifeq +40 -> 6577
    //   6540: ldc 76
    //   6542: ldc_w 436
    //   6545: iconst_2
    //   6546: anewarray 4	java/lang/Object
    //   6549: dup
    //   6550: iconst_0
    //   6551: lload 4
    //   6553: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6556: aastore
    //   6557: dup
    //   6558: iconst_1
    //   6559: lload_2
    //   6560: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6563: aastore
    //   6564: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6567: aload_0
    //   6568: lload_2
    //   6569: lload 4
    //   6571: invokespecial 438	com/tencent/mm/plugin/music/c/b:F	(JJ)V
    //   6574: goto -113 -> 6461
    //   6577: lload 4
    //   6579: lconst_0
    //   6580: lcmp
    //   6581: ifeq +66 -> 6647
    //   6584: lload_2
    //   6585: lload 4
    //   6587: lcmp
    //   6588: ifne +59 -> 6647
    //   6591: ldc 76
    //   6593: ldc_w 440
    //   6596: iconst_2
    //   6597: anewarray 4	java/lang/Object
    //   6600: dup
    //   6601: iconst_0
    //   6602: lload 4
    //   6604: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6607: aastore
    //   6608: dup
    //   6609: iconst_1
    //   6610: lload_2
    //   6611: invokestatic 396	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6614: aastore
    //   6615: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6618: aload_0
    //   6619: lload 4
    //   6621: invokespecial 430	com/tencent/mm/plugin/music/c/b:fl	(J)V
    //   6624: lload_2
    //   6625: ldc2_w 366
    //   6628: lcmp
    //   6629: ifge -168 -> 6461
    //   6632: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6635: dup
    //   6636: aload_0
    //   6637: iconst_1
    //   6638: invokespecial 119	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6641: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   6644: goto -183 -> 6461
    //   6647: ldc 76
    //   6649: ldc_w 442
    //   6652: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6655: goto -194 -> 6461
    //   6658: astore 35
    //   6660: ldc 76
    //   6662: aload 35
    //   6664: ldc_w 592
    //   6667: iconst_0
    //   6668: anewarray 4	java/lang/Object
    //   6671: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6674: goto -203 -> 6471
    //   6677: astore 33
    //   6679: ldc 76
    //   6681: aload 33
    //   6683: ldc_w 434
    //   6686: iconst_0
    //   6687: anewarray 4	java/lang/Object
    //   6690: invokestatic 419	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6693: goto -212 -> 6481
    //   6696: astore 38
    //   6698: aconst_null
    //   6699: astore 34
    //   6701: goto -292 -> 6409
    //   6704: astore 38
    //   6706: aload 37
    //   6708: astore 34
    //   6710: lload 8
    //   6712: lstore 4
    //   6714: lload 6
    //   6716: lstore_2
    //   6717: aload 36
    //   6719: astore 33
    //   6721: goto -312 -> 6409
    //   6724: astore 38
    //   6726: lload 14
    //   6728: lstore_2
    //   6729: goto -320 -> 6409
    //   6732: astore 38
    //   6734: goto -325 -> 6409
    //   6737: astore 38
    //   6739: aconst_null
    //   6740: astore 34
    //   6742: goto -717 -> 6025
    //   6745: astore 38
    //   6747: lload 24
    //   6749: lstore 4
    //   6751: lload 14
    //   6753: lstore_2
    //   6754: goto -729 -> 6025
    //   6757: astore 38
    //   6759: lload 10
    //   6761: lstore_2
    //   6762: aload 35
    //   6764: astore 39
    //   6766: goto -741 -> 6025
    //   6769: astore 38
    //   6771: aconst_null
    //   6772: astore 34
    //   6774: aload 40
    //   6776: astore 39
    //   6778: goto -1137 -> 5641
    //   6781: astore 38
    //   6783: lload 22
    //   6785: lstore 4
    //   6787: lload 12
    //   6789: lstore_2
    //   6790: aload 40
    //   6792: astore 39
    //   6794: goto -1153 -> 5641
    //   6797: astore 38
    //   6799: lload 8
    //   6801: lstore_2
    //   6802: aload 35
    //   6804: astore 39
    //   6806: goto -1165 -> 5641
    //   6809: astore 38
    //   6811: aconst_null
    //   6812: astore 34
    //   6814: aload 41
    //   6816: astore 39
    //   6818: goto -1565 -> 5253
    //   6821: astore 38
    //   6823: lload 20
    //   6825: lstore 4
    //   6827: lload 18
    //   6829: lstore_2
    //   6830: aload 41
    //   6832: astore 39
    //   6834: goto -1581 -> 5253
    //   6837: astore 38
    //   6839: lload 12
    //   6841: lstore_2
    //   6842: aload 35
    //   6844: astore 39
    //   6846: goto -1593 -> 5253
    //   6849: astore 38
    //   6851: aconst_null
    //   6852: astore 33
    //   6854: aconst_null
    //   6855: astore 34
    //   6857: aload 42
    //   6859: astore 39
    //   6861: goto -2527 -> 4334
    //   6864: astore 38
    //   6866: aconst_null
    //   6867: astore 34
    //   6869: aload 42
    //   6871: astore 39
    //   6873: goto -2539 -> 4334
    //   6876: astore 38
    //   6878: lload 26
    //   6880: lstore 4
    //   6882: lload 10
    //   6884: lstore_2
    //   6885: aload 42
    //   6887: astore 39
    //   6889: goto -2555 -> 4334
    //   6892: astore 36
    //   6894: aconst_null
    //   6895: astore 35
    //   6897: aconst_null
    //   6898: astore 34
    //   6900: aload 37
    //   6902: astore 33
    //   6904: goto -3241 -> 3663
    //   6907: astore 36
    //   6909: aconst_null
    //   6910: astore 35
    //   6912: aconst_null
    //   6913: astore 34
    //   6915: goto -3252 -> 3663
    //   6918: lload 30
    //   6920: lstore 6
    //   6922: lload 4
    //   6924: lstore_2
    //   6925: lload 6
    //   6927: lstore 4
    //   6929: ldc2_w 593
    //   6932: lstore 30
    //   6934: lload 4
    //   6936: lconst_0
    //   6937: lcmp
    //   6938: ifeq -3863 -> 3075
    //   6941: lload 4
    //   6943: lstore 30
    //   6945: goto -3870 -> 3075
    //   6948: astore 36
    //   6950: aconst_null
    //   6951: astore 35
    //   6953: lload 28
    //   6955: lstore 4
    //   6957: lload 16
    //   6959: lstore_2
    //   6960: goto -3297 -> 3663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6963	0	this	b
    //   168	4383	1	i	int
    //   155	6805	2	l1	long
    //   122	6834	4	l2	long
    //   113	6813	6	l3	long
    //   223	6577	8	l4	long
    //   1393	5490	10	l5	long
    //   1379	5461	12	l6	long
    //   1372	5380	14	l7	long
    //   1400	5558	16	l8	long
    //   1386	5442	18	l9	long
    //   1383	5441	20	l10	long
    //   1376	5408	22	l11	long
    //   1369	5379	24	l12	long
    //   1390	5489	26	l13	long
    //   1397	5557	28	l14	long
    //   2912	4032	30	l15	long
    //   20	1225	32	bool	boolean
    //   9	531	33	localObject1	Object
    //   775	5	33	localIOException1	java.io.IOException
    //   965	5	33	localIOException2	java.io.IOException
    //   1128	596	33	localRandomAccessFile	java.io.RandomAccessFile
    //   1903	2146	33	localIOException3	java.io.IOException
    //   4228	418	33	localIOException4	java.io.IOException
    //   4844	5	33	localIOException5	java.io.IOException
    //   5033	5	33	localIOException6	java.io.IOException
    //   5222	5	33	localIOException7	java.io.IOException
    //   5244	168	33	localObject2	Object
    //   5610	5	33	localIOException8	java.io.IOException
    //   5632	168	33	localObject3	Object
    //   5998	5	33	localIOException9	java.io.IOException
    //   6020	164	33	localObject4	Object
    //   6382	5	33	localIOException10	java.io.IOException
    //   6404	73	33	localObject5	Object
    //   6677	5	33	localIOException11	java.io.IOException
    //   6719	184	33	localObject6	Object
    //   12	6902	34	localObject7	Object
    //   38	1592	35	localObject8	Object
    //   1752	5	35	localIOException12	java.io.IOException
    //   1939	2015	35	localObject9	Object
    //   4077	251	35	localIOException13	java.io.IOException
    //   4351	290	35	localObject10	Object
    //   4825	5	35	localIOException14	java.io.IOException
    //   5014	5	35	localIOException15	java.io.IOException
    //   5052	5	35	localIOException16	java.io.IOException
    //   5203	5	35	localIOException17	java.io.IOException
    //   5270	68	35	localObject11	Object
    //   5440	5	35	localIOException18	java.io.IOException
    //   5591	5	35	localIOException19	java.io.IOException
    //   5658	68	35	localObject12	Object
    //   5828	5	35	localIOException20	java.io.IOException
    //   5979	5	35	localIOException21	java.io.IOException
    //   6042	68	35	localObject13	Object
    //   6212	5	35	localIOException22	java.io.IOException
    //   6363	104	35	localIOException23	java.io.IOException
    //   6658	185	35	localIOException24	java.io.IOException
    //   6895	57	35	localObject14	Object
    //   1156	2287	36	localObject15	Object
    //   3658	8	36	localProtocolException1	java.net.ProtocolException
    //   3806	609	36	localIOException25	java.io.IOException
    //   4674	5	36	localIOException26	java.io.IOException
    //   4863	5	36	localIOException27	java.io.IOException
    //   5266	840	36	localObject16	Object
    //   6507	211	36	localIOException28	java.io.IOException
    //   6892	1	36	localProtocolException2	java.net.ProtocolException
    //   6907	1	36	localProtocolException3	java.net.ProtocolException
    //   6948	1	36	localProtocolException4	java.net.ProtocolException
    //   856	6045	37	localObject17	Object
    //   850	3102	38	localInputStream	java.io.InputStream
    //   4325	31	38	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   5241	34	38	localUnknownServiceException1	java.net.UnknownServiceException
    //   5629	34	38	localIOException29	java.io.IOException
    //   6017	30	38	localException1	Exception
    //   6401	104	38	localObject18	Object
    //   6696	1	38	localObject19	Object
    //   6704	1	38	localObject20	Object
    //   6724	1	38	localObject21	Object
    //   6732	1	38	localObject22	Object
    //   6737	1	38	localException2	Exception
    //   6745	1	38	localException3	Exception
    //   6757	1	38	localException4	Exception
    //   6769	1	38	localIOException30	java.io.IOException
    //   6781	1	38	localIOException31	java.io.IOException
    //   6797	1	38	localIOException32	java.io.IOException
    //   6809	1	38	localUnknownServiceException2	java.net.UnknownServiceException
    //   6821	1	38	localUnknownServiceException3	java.net.UnknownServiceException
    //   6837	1	38	localUnknownServiceException4	java.net.UnknownServiceException
    //   6849	1	38	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   6864	1	38	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   6876	1	38	localNoRouteToHostException4	java.net.NoRouteToHostException
    //   844	6044	39	localObject23	Object
    //   841	5950	40	localObject24	Object
    //   838	5993	41	localObject25	Object
    //   853	6033	42	localObject26	Object
    //   220	5838	43	localFile	java.io.File
    //   2137	2111	44	localObject27	Object
    //   2527	453	45	str	String
    // Exception table:
    //   from	to	target	type
    //   236	259	775	java/io/IOException
    //   918	926	965	java/io/IOException
    //   1692	1698	1752	java/io/IOException
    //   1723	1728	1903	java/io/IOException
    //   3360	3367	3658	java/net/ProtocolException
    //   3385	3392	3658	java/net/ProtocolException
    //   3410	3418	3658	java/net/ProtocolException
    //   3440	3449	3658	java/net/ProtocolException
    //   3479	3507	3658	java/net/ProtocolException
    //   3531	3538	3658	java/net/ProtocolException
    //   3562	3571	3658	java/net/ProtocolException
    //   3595	3604	3658	java/net/ProtocolException
    //   3640	3652	3658	java/net/ProtocolException
    //   4280	4289	3658	java/net/ProtocolException
    //   4313	4322	3658	java/net/ProtocolException
    //   4539	4583	3658	java/net/ProtocolException
    //   4017	4023	4077	java/io/IOException
    //   4048	4053	4228	java/io/IOException
    //   3360	3367	4325	java/net/NoRouteToHostException
    //   3385	3392	4325	java/net/NoRouteToHostException
    //   3410	3418	4325	java/net/NoRouteToHostException
    //   3440	3449	4325	java/net/NoRouteToHostException
    //   3479	3507	4325	java/net/NoRouteToHostException
    //   3531	3538	4325	java/net/NoRouteToHostException
    //   3562	3571	4325	java/net/NoRouteToHostException
    //   3595	3604	4325	java/net/NoRouteToHostException
    //   3640	3652	4325	java/net/NoRouteToHostException
    //   4280	4289	4325	java/net/NoRouteToHostException
    //   4313	4322	4325	java/net/NoRouteToHostException
    //   4539	4583	4325	java/net/NoRouteToHostException
    //   4604	4610	4674	java/io/IOException
    //   4640	4645	4825	java/io/IOException
    //   4645	4650	4844	java/io/IOException
    //   3718	3724	4863	java/io/IOException
    //   3754	3759	5014	java/io/IOException
    //   3764	3769	5033	java/io/IOException
    //   4446	4452	5052	java/io/IOException
    //   4482	4487	5203	java/io/IOException
    //   4492	4497	5222	java/io/IOException
    //   858	897	5241	java/net/UnknownServiceException
    //   1116	1130	5241	java/net/UnknownServiceException
    //   5365	5371	5440	java/io/IOException
    //   5401	5406	5591	java/io/IOException
    //   5411	5416	5610	java/io/IOException
    //   858	897	5629	java/io/IOException
    //   1116	1130	5629	java/io/IOException
    //   5753	5759	5828	java/io/IOException
    //   5789	5794	5979	java/io/IOException
    //   5799	5804	5998	java/io/IOException
    //   858	897	6017	java/lang/Exception
    //   1116	1130	6017	java/lang/Exception
    //   6137	6143	6212	java/io/IOException
    //   6173	6178	6363	java/io/IOException
    //   6183	6188	6382	java/io/IOException
    //   858	897	6401	finally
    //   1116	1130	6401	finally
    //   6430	6436	6507	java/io/IOException
    //   6466	6471	6658	java/io/IOException
    //   6476	6481	6677	java/io/IOException
    //   1130	1172	6696	finally
    //   1179	1244	6696	finally
    //   1249	1257	6696	finally
    //   1257	1293	6696	finally
    //   1293	1348	6696	finally
    //   1402	1408	6704	finally
    //   1476	1480	6704	finally
    //   1534	1553	6704	finally
    //   1607	1612	6704	finally
    //   1666	1671	6704	finally
    //   1976	1995	6704	finally
    //   2049	2078	6704	finally
    //   2132	2139	6704	finally
    //   2193	2210	6704	finally
    //   2264	2270	6704	finally
    //   2324	2334	6704	finally
    //   2388	2401	6704	finally
    //   2455	2466	6704	finally
    //   2520	2529	6704	finally
    //   2583	2589	6704	finally
    //   2643	2649	6704	finally
    //   2703	2721	6704	finally
    //   2775	2785	6704	finally
    //   2839	2846	6704	finally
    //   2900	2914	6704	finally
    //   2968	2993	6704	finally
    //   3052	3060	6704	finally
    //   3129	3156	6704	finally
    //   3210	3217	6704	finally
    //   3271	3277	6704	finally
    //   3331	3338	6704	finally
    //   3847	3856	6704	finally
    //   3928	3936	6704	finally
    //   3990	3996	6704	finally
    //   4353	4375	6704	finally
    //   4394	4401	6704	finally
    //   4420	4425	6704	finally
    //   5272	5294	6704	finally
    //   5313	5320	6704	finally
    //   5339	5344	6704	finally
    //   5660	5682	6704	finally
    //   5701	5708	6704	finally
    //   5727	5732	6704	finally
    //   6044	6066	6704	finally
    //   6085	6092	6704	finally
    //   6111	6116	6704	finally
    //   3360	3367	6724	finally
    //   3385	3392	6724	finally
    //   3410	3418	6724	finally
    //   3440	3449	6724	finally
    //   3479	3507	6724	finally
    //   3531	3538	6724	finally
    //   3562	3571	6724	finally
    //   3595	3604	6724	finally
    //   3640	3652	6724	finally
    //   4280	4289	6724	finally
    //   4313	4322	6724	finally
    //   4539	4583	6724	finally
    //   3663	3697	6732	finally
    //   1130	1172	6737	java/lang/Exception
    //   1179	1244	6737	java/lang/Exception
    //   1249	1257	6737	java/lang/Exception
    //   1257	1293	6737	java/lang/Exception
    //   1293	1348	6737	java/lang/Exception
    //   1402	1408	6745	java/lang/Exception
    //   1476	1480	6745	java/lang/Exception
    //   1534	1553	6745	java/lang/Exception
    //   1607	1612	6745	java/lang/Exception
    //   1666	1671	6745	java/lang/Exception
    //   1976	1995	6745	java/lang/Exception
    //   2049	2078	6745	java/lang/Exception
    //   2132	2139	6745	java/lang/Exception
    //   2193	2210	6745	java/lang/Exception
    //   2264	2270	6745	java/lang/Exception
    //   2324	2334	6745	java/lang/Exception
    //   2388	2401	6745	java/lang/Exception
    //   2455	2466	6745	java/lang/Exception
    //   2520	2529	6745	java/lang/Exception
    //   2583	2589	6745	java/lang/Exception
    //   2643	2649	6745	java/lang/Exception
    //   2703	2721	6745	java/lang/Exception
    //   2775	2785	6745	java/lang/Exception
    //   2839	2846	6745	java/lang/Exception
    //   2900	2914	6745	java/lang/Exception
    //   2968	2993	6745	java/lang/Exception
    //   3052	3060	6745	java/lang/Exception
    //   3129	3156	6745	java/lang/Exception
    //   3210	3217	6745	java/lang/Exception
    //   3271	3277	6745	java/lang/Exception
    //   3331	3338	6745	java/lang/Exception
    //   3847	3856	6745	java/lang/Exception
    //   3928	3936	6745	java/lang/Exception
    //   3990	3996	6745	java/lang/Exception
    //   3360	3367	6757	java/lang/Exception
    //   3385	3392	6757	java/lang/Exception
    //   3410	3418	6757	java/lang/Exception
    //   3440	3449	6757	java/lang/Exception
    //   3479	3507	6757	java/lang/Exception
    //   3531	3538	6757	java/lang/Exception
    //   3562	3571	6757	java/lang/Exception
    //   3595	3604	6757	java/lang/Exception
    //   3640	3652	6757	java/lang/Exception
    //   4280	4289	6757	java/lang/Exception
    //   4313	4322	6757	java/lang/Exception
    //   4539	4583	6757	java/lang/Exception
    //   1130	1172	6769	java/io/IOException
    //   1179	1244	6769	java/io/IOException
    //   1249	1257	6769	java/io/IOException
    //   1257	1293	6769	java/io/IOException
    //   1293	1348	6769	java/io/IOException
    //   1402	1408	6781	java/io/IOException
    //   1476	1480	6781	java/io/IOException
    //   1534	1553	6781	java/io/IOException
    //   1607	1612	6781	java/io/IOException
    //   1666	1671	6781	java/io/IOException
    //   1976	1995	6781	java/io/IOException
    //   2049	2078	6781	java/io/IOException
    //   2132	2139	6781	java/io/IOException
    //   2193	2210	6781	java/io/IOException
    //   2264	2270	6781	java/io/IOException
    //   2324	2334	6781	java/io/IOException
    //   2388	2401	6781	java/io/IOException
    //   2455	2466	6781	java/io/IOException
    //   2520	2529	6781	java/io/IOException
    //   2583	2589	6781	java/io/IOException
    //   2643	2649	6781	java/io/IOException
    //   2703	2721	6781	java/io/IOException
    //   2775	2785	6781	java/io/IOException
    //   2839	2846	6781	java/io/IOException
    //   2900	2914	6781	java/io/IOException
    //   2968	2993	6781	java/io/IOException
    //   3052	3060	6781	java/io/IOException
    //   3129	3156	6781	java/io/IOException
    //   3210	3217	6781	java/io/IOException
    //   3271	3277	6781	java/io/IOException
    //   3331	3338	6781	java/io/IOException
    //   3847	3856	6781	java/io/IOException
    //   3928	3936	6781	java/io/IOException
    //   3990	3996	6781	java/io/IOException
    //   3360	3367	6797	java/io/IOException
    //   3385	3392	6797	java/io/IOException
    //   3410	3418	6797	java/io/IOException
    //   3440	3449	6797	java/io/IOException
    //   3479	3507	6797	java/io/IOException
    //   3531	3538	6797	java/io/IOException
    //   3562	3571	6797	java/io/IOException
    //   3595	3604	6797	java/io/IOException
    //   3640	3652	6797	java/io/IOException
    //   4280	4289	6797	java/io/IOException
    //   4313	4322	6797	java/io/IOException
    //   4539	4583	6797	java/io/IOException
    //   1130	1172	6809	java/net/UnknownServiceException
    //   1179	1244	6809	java/net/UnknownServiceException
    //   1249	1257	6809	java/net/UnknownServiceException
    //   1257	1293	6809	java/net/UnknownServiceException
    //   1293	1348	6809	java/net/UnknownServiceException
    //   1402	1408	6821	java/net/UnknownServiceException
    //   1476	1480	6821	java/net/UnknownServiceException
    //   1534	1553	6821	java/net/UnknownServiceException
    //   1607	1612	6821	java/net/UnknownServiceException
    //   1666	1671	6821	java/net/UnknownServiceException
    //   1976	1995	6821	java/net/UnknownServiceException
    //   2049	2078	6821	java/net/UnknownServiceException
    //   2132	2139	6821	java/net/UnknownServiceException
    //   2193	2210	6821	java/net/UnknownServiceException
    //   2264	2270	6821	java/net/UnknownServiceException
    //   2324	2334	6821	java/net/UnknownServiceException
    //   2388	2401	6821	java/net/UnknownServiceException
    //   2455	2466	6821	java/net/UnknownServiceException
    //   2520	2529	6821	java/net/UnknownServiceException
    //   2583	2589	6821	java/net/UnknownServiceException
    //   2643	2649	6821	java/net/UnknownServiceException
    //   2703	2721	6821	java/net/UnknownServiceException
    //   2775	2785	6821	java/net/UnknownServiceException
    //   2839	2846	6821	java/net/UnknownServiceException
    //   2900	2914	6821	java/net/UnknownServiceException
    //   2968	2993	6821	java/net/UnknownServiceException
    //   3052	3060	6821	java/net/UnknownServiceException
    //   3129	3156	6821	java/net/UnknownServiceException
    //   3210	3217	6821	java/net/UnknownServiceException
    //   3271	3277	6821	java/net/UnknownServiceException
    //   3331	3338	6821	java/net/UnknownServiceException
    //   3847	3856	6821	java/net/UnknownServiceException
    //   3928	3936	6821	java/net/UnknownServiceException
    //   3990	3996	6821	java/net/UnknownServiceException
    //   3360	3367	6837	java/net/UnknownServiceException
    //   3385	3392	6837	java/net/UnknownServiceException
    //   3410	3418	6837	java/net/UnknownServiceException
    //   3440	3449	6837	java/net/UnknownServiceException
    //   3479	3507	6837	java/net/UnknownServiceException
    //   3531	3538	6837	java/net/UnknownServiceException
    //   3562	3571	6837	java/net/UnknownServiceException
    //   3595	3604	6837	java/net/UnknownServiceException
    //   3640	3652	6837	java/net/UnknownServiceException
    //   4280	4289	6837	java/net/UnknownServiceException
    //   4313	4322	6837	java/net/UnknownServiceException
    //   4539	4583	6837	java/net/UnknownServiceException
    //   858	897	6849	java/net/NoRouteToHostException
    //   1116	1130	6849	java/net/NoRouteToHostException
    //   1130	1172	6864	java/net/NoRouteToHostException
    //   1179	1244	6864	java/net/NoRouteToHostException
    //   1249	1257	6864	java/net/NoRouteToHostException
    //   1257	1293	6864	java/net/NoRouteToHostException
    //   1293	1348	6864	java/net/NoRouteToHostException
    //   1402	1408	6876	java/net/NoRouteToHostException
    //   1476	1480	6876	java/net/NoRouteToHostException
    //   1534	1553	6876	java/net/NoRouteToHostException
    //   1607	1612	6876	java/net/NoRouteToHostException
    //   1666	1671	6876	java/net/NoRouteToHostException
    //   1976	1995	6876	java/net/NoRouteToHostException
    //   2049	2078	6876	java/net/NoRouteToHostException
    //   2132	2139	6876	java/net/NoRouteToHostException
    //   2193	2210	6876	java/net/NoRouteToHostException
    //   2264	2270	6876	java/net/NoRouteToHostException
    //   2324	2334	6876	java/net/NoRouteToHostException
    //   2388	2401	6876	java/net/NoRouteToHostException
    //   2455	2466	6876	java/net/NoRouteToHostException
    //   2520	2529	6876	java/net/NoRouteToHostException
    //   2583	2589	6876	java/net/NoRouteToHostException
    //   2643	2649	6876	java/net/NoRouteToHostException
    //   2703	2721	6876	java/net/NoRouteToHostException
    //   2775	2785	6876	java/net/NoRouteToHostException
    //   2839	2846	6876	java/net/NoRouteToHostException
    //   2900	2914	6876	java/net/NoRouteToHostException
    //   2968	2993	6876	java/net/NoRouteToHostException
    //   3052	3060	6876	java/net/NoRouteToHostException
    //   3129	3156	6876	java/net/NoRouteToHostException
    //   3210	3217	6876	java/net/NoRouteToHostException
    //   3271	3277	6876	java/net/NoRouteToHostException
    //   3331	3338	6876	java/net/NoRouteToHostException
    //   3847	3856	6876	java/net/NoRouteToHostException
    //   3928	3936	6876	java/net/NoRouteToHostException
    //   3990	3996	6876	java/net/NoRouteToHostException
    //   858	897	6892	java/net/ProtocolException
    //   1116	1130	6892	java/net/ProtocolException
    //   1130	1172	6907	java/net/ProtocolException
    //   1179	1244	6907	java/net/ProtocolException
    //   1249	1257	6907	java/net/ProtocolException
    //   1257	1293	6907	java/net/ProtocolException
    //   1293	1348	6907	java/net/ProtocolException
    //   1402	1408	6948	java/net/ProtocolException
    //   1476	1480	6948	java/net/ProtocolException
    //   1534	1553	6948	java/net/ProtocolException
    //   1607	1612	6948	java/net/ProtocolException
    //   1666	1671	6948	java/net/ProtocolException
    //   1976	1995	6948	java/net/ProtocolException
    //   2049	2078	6948	java/net/ProtocolException
    //   2132	2139	6948	java/net/ProtocolException
    //   2193	2210	6948	java/net/ProtocolException
    //   2264	2270	6948	java/net/ProtocolException
    //   2324	2334	6948	java/net/ProtocolException
    //   2388	2401	6948	java/net/ProtocolException
    //   2455	2466	6948	java/net/ProtocolException
    //   2520	2529	6948	java/net/ProtocolException
    //   2583	2589	6948	java/net/ProtocolException
    //   2643	2649	6948	java/net/ProtocolException
    //   2703	2721	6948	java/net/ProtocolException
    //   2775	2785	6948	java/net/ProtocolException
    //   2839	2846	6948	java/net/ProtocolException
    //   2900	2914	6948	java/net/ProtocolException
    //   2968	2993	6948	java/net/ProtocolException
    //   3052	3060	6948	java/net/ProtocolException
    //   3129	3156	6948	java/net/ProtocolException
    //   3210	3217	6948	java/net/ProtocolException
    //   3271	3277	6948	java/net/ProtocolException
    //   3331	3338	6948	java/net/ProtocolException
    //   3847	3856	6948	java/net/ProtocolException
    //   3928	3936	6948	java/net/ProtocolException
    //   3990	3996	6948	java/net/ProtocolException
  }
  
  public final void start()
  {
    if (!this.isStop) {
      return;
    }
    this.isStop = false;
    com.tencent.mm.sdk.f.e.post(this, "music_download_thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b
 * JD-Core Version:    0.7.0.1
 */