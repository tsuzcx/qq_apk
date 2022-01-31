package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
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
  public int cfE;
  public boolean isStop;
  public String mimeType;
  public boolean muY;
  private String oYA;
  public com.tencent.mm.aw.e oYB;
  public a oYC;
  public float oYD;
  private long oYE;
  public int oYF;
  public b.b oYG;
  
  public b(com.tencent.mm.aw.e parame, a parama)
  {
    AppMethodBeat.i(137466);
    this.oYA = null;
    this.oYE = 307200L;
    this.isStop = true;
    this.mimeType = "";
    this.oYF = -1;
    this.cfE = 0;
    this.oYB = parame;
    this.oYC = parama;
    int i;
    int j;
    if ((parama.oYv == 0L) && (parama.oYw == 0L) && (parama.endFlag == 0))
    {
      i = 1;
      if ((parama.oYx != 0L) || (parama.oYz != 0L) || (parama.oYy != 0)) {
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
      ab.e("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
    }
    for (;;)
    {
      this.muY = at.isWifi(ah.getContext());
      AppMethodBeat.o(137466);
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
      ab.i("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
    }
  }
  
  private static void Ab(int paramInt)
  {
    AppMethodBeat.i(137470);
    com.tencent.mm.plugin.music.e.d locald = (com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.d.class);
    if (locald != null) {
      locald.Ag(paramInt);
    }
    AppMethodBeat.o(137470);
  }
  
  private void Ac(int paramInt)
  {
    AppMethodBeat.i(137471);
    this.oYA = null;
    al.d(new b.a(this, paramInt));
    AppMethodBeat.o(137471);
  }
  
  private void R(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(137473);
    if (this.muY)
    {
      this.oYC.oYx = paramLong1;
      this.oYC.oYy = 0;
      this.oYC.oYz = paramLong2;
      com.tencent.mm.plugin.music.cache.e.a(this.oYB.fKj, this.oYC);
    }
    for (;;)
    {
      al.d(new b.a(this, 3));
      AppMethodBeat.o(137473);
      return;
      this.oYC.oYv = paramLong1;
      this.oYC.endFlag = 0;
      this.oYC.oYw = paramLong2;
      com.tencent.mm.plugin.music.cache.e.a(this.oYB.fKj, this.oYC);
    }
  }
  
  private static long[] Vt(String paramString)
  {
    AppMethodBeat.i(137474);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137474);
      return null;
    }
    try
    {
      paramString = paramString.replace("bytes", "").trim().split("-");
      long l1 = Long.valueOf(paramString[0]).longValue();
      paramString = paramString[1].split("/");
      long l2 = Long.valueOf(paramString[0]).longValue();
      long l3 = Long.valueOf(paramString[1]).longValue();
      AppMethodBeat.o(137474);
      return new long[] { l1, l2, l3 };
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(137474);
    }
    return null;
  }
  
  private void kJ(long paramLong)
  {
    AppMethodBeat.i(137472);
    if (this.muY)
    {
      this.oYC.oYx = paramLong;
      this.oYC.oYy = 1;
      this.oYC.oYz = paramLong;
      com.tencent.mm.plugin.music.cache.e.a(this.oYB.fKj, this.oYC);
    }
    for (;;)
    {
      al.d(new b.a(this, 2));
      AppMethodBeat.o(137472);
      return;
      this.oYC.oYv = paramLong;
      this.oYC.endFlag = 1;
      this.oYC.oYw = paramLong;
      com.tencent.mm.plugin.music.cache.e.a(this.oYB.fKj, this.oYC);
    }
  }
  
  private HttpURLConnection u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137469);
    Object localObject1;
    if (!TextUtils.isEmpty(this.oYA))
    {
      ab.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.oYA;
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
          ab.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[] { paramString });
          Object localObject2 = k.bVH().oZe;
          localObject1 = new URL(paramString);
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.plugin.music.e.a)localObject2).Vv(paramString);
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
            ab.e("MicroMsg.Music.MusicDownloadTask", localException.getMessage());
          }
          int j = ((HttpURLConnection)localObject1).getResponseCode();
          ab.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307))
          {
            Ab(j);
            paramString = ((HttpURLConnection)localObject1).getRequestMethod();
            if ((j == 307) && (!paramString.equals("GET")) && (!paramString.equals("HEAD")))
            {
              AppMethodBeat.o(137469);
              return localObject1;
            }
            paramString = ((HttpURLConnection)localObject1).getHeaderField("Location");
            if (paramString == null)
            {
              ab.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[] { Integer.valueOf(j) });
              AppMethodBeat.o(137469);
              return localObject1;
            }
            URL localURL = new URL(((HttpURLConnection)localObject1).getURL(), paramString);
            ab.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[] { paramString });
            ab.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[] { localURL.toString() });
            if ((!localURL.getProtocol().equals("https")) && (!localURL.getProtocol().equals("http")))
            {
              ab.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[] { Integer.valueOf(j) });
              AppMethodBeat.o(137469);
              return localObject1;
            }
            i += 1;
            if (i > 5)
            {
              ab.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: ".concat(String.valueOf(i)));
              AppMethodBeat.o(137469);
              return localObject1;
            }
            paramString = localURL.toString();
            this.oYA = paramString;
          }
          else
          {
            if ((j != 200) && (j != 206)) {
              this.oYA = null;
            }
            AppMethodBeat.o(137469);
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
    //   0: ldc_w 373
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   10: ifeq +10 -> 20
    //   13: ldc_w 373
    //   16: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aconst_null
    //   21: astore 33
    //   23: aconst_null
    //   24: astore 34
    //   26: invokestatic 97	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   29: invokestatic 376	com/tencent/mm/sdk/platformtools/at:isNetworkConnected	(Landroid/content/Context;)Z
    //   32: istore 32
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 57	com/tencent/mm/plugin/music/c/b:cfE	I
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 55	com/tencent/mm/plugin/music/c/b:oYF	I
    //   44: invokestatic 231	com/tencent/mm/plugin/music/e/k:bVH	()Lcom/tencent/mm/plugin/music/e/k;
    //   47: getfield 235	com/tencent/mm/plugin/music/e/k:oZe	Lcom/tencent/mm/plugin/music/e/a;
    //   50: astore 35
    //   52: iload 32
    //   54: ifeq +510 -> 564
    //   57: aload_0
    //   58: getfield 105	com/tencent/mm/plugin/music/c/b:muY	Z
    //   61: ifeq +362 -> 423
    //   64: aload_0
    //   65: getfield 59	com/tencent/mm/plugin/music/c/b:oYB	Lcom/tencent/mm/aw/e;
    //   68: getfield 379	com/tencent/mm/aw/e:playUrl	Ljava/lang/String;
    //   71: invokestatic 384	com/tencent/mm/plugin/music/cache/g:Vk	(Ljava/lang/String;)Z
    //   74: istore 32
    //   76: aload 34
    //   78: astore 33
    //   80: aload 35
    //   82: ifnull +19 -> 101
    //   85: aload 35
    //   87: aload_0
    //   88: getfield 59	com/tencent/mm/plugin/music/c/b:oYB	Lcom/tencent/mm/aw/e;
    //   91: getfield 379	com/tencent/mm/aw/e:playUrl	Ljava/lang/String;
    //   94: invokeinterface 387 2 0
    //   99: astore 33
    //   101: ldc 83
    //   103: ldc_w 389
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 33
    //   114: aastore
    //   115: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   122: getfield 75	com/tencent/mm/plugin/music/c/a:oYx	J
    //   125: lstore 6
    //   127: aload_0
    //   128: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   131: getfield 78	com/tencent/mm/plugin/music/c/a:oYz	J
    //   134: lstore 4
    //   136: lload 4
    //   138: lconst_0
    //   139: lcmp
    //   140: ifeq +13 -> 153
    //   143: aload_0
    //   144: lload 4
    //   146: ldc2_w 390
    //   149: ldiv
    //   150: putfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   153: lload 6
    //   155: aload_0
    //   156: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   159: lcmp
    //   160: ifge +233 -> 393
    //   163: aload_0
    //   164: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   167: lstore_2
    //   168: aload_0
    //   169: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   172: getfield 81	com/tencent/mm/plugin/music/c/a:oYy	I
    //   175: iconst_1
    //   176: if_icmpne +238 -> 414
    //   179: iconst_1
    //   180: istore_1
    //   181: aload 33
    //   183: astore 34
    //   185: aload_0
    //   186: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   189: ldc2_w 392
    //   192: lcmp
    //   193: ifge +18 -> 211
    //   196: aload_0
    //   197: ldc2_w 392
    //   200: putfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   203: ldc 83
    //   205: ldc_w 395
    //   208: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: new 397	java/io/File
    //   214: dup
    //   215: aload_0
    //   216: getfield 59	com/tencent/mm/plugin/music/c/b:oYB	Lcom/tencent/mm/aw/e;
    //   219: getfield 145	com/tencent/mm/aw/e:fKj	Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 105	com/tencent/mm/plugin/music/c/b:muY	Z
    //   226: invokestatic 403	com/tencent/mm/plugin/music/h/b:bc	(Ljava/lang/String;Z)Ljava/lang/String;
    //   229: invokespecial 404	java/io/File:<init>	(Ljava/lang/String;)V
    //   232: astore 43
    //   234: lload_2
    //   235: lstore 8
    //   237: lload 6
    //   239: lstore_2
    //   240: aload 43
    //   242: invokevirtual 407	java/io/File:exists	()Z
    //   245: ifne +56 -> 301
    //   248: ldc 83
    //   250: ldc_w 409
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 43
    //   261: invokevirtual 412	java/io/File:createNewFile	()Z
    //   264: invokestatic 417	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   267: aastore
    //   268: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: lconst_0
    //   272: lstore_2
    //   273: aload_0
    //   274: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   277: lstore 8
    //   279: iconst_0
    //   280: istore_1
    //   281: ldc 83
    //   283: ldc_w 419
    //   286: iconst_1
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: lload 8
    //   294: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   297: aastore
    //   298: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 83
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
    //   319: aload 43
    //   321: invokevirtual 427	java/io/File:length	()J
    //   324: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: aastore
    //   328: dup
    //   329: iconst_2
    //   330: lload 8
    //   332: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: aastore
    //   336: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: lload_2
    //   340: aload_0
    //   341: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   344: lcmp
    //   345: iflt +12 -> 357
    //   348: aload_0
    //   349: getfield 429	com/tencent/mm/plugin/music/c/b:oYD	F
    //   352: fconst_0
    //   353: fcmpl
    //   354: ifeq +7 -> 361
    //   357: iload_1
    //   358: ifeq +480 -> 838
    //   361: ldc 83
    //   363: ldc_w 431
    //   366: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_0
    //   370: iconst_1
    //   371: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   374: new 8	com/tencent/mm/plugin/music/c/b$a
    //   377: dup
    //   378: aload_0
    //   379: iconst_1
    //   380: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   383: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   386: ldc_w 373
    //   389: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: return
    //   393: lload 6
    //   395: l2f
    //   396: ldc_w 432
    //   399: aload_0
    //   400: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   403: getfield 78	com/tencent/mm/plugin/music/c/a:oYz	J
    //   406: l2f
    //   407: fmul
    //   408: fadd
    //   409: f2l
    //   410: lstore_2
    //   411: goto -243 -> 168
    //   414: iconst_0
    //   415: istore_1
    //   416: aload 33
    //   418: astore 34
    //   420: goto -235 -> 185
    //   423: aload 35
    //   425: ifnull +19 -> 444
    //   428: aload 35
    //   430: aload_0
    //   431: getfield 59	com/tencent/mm/plugin/music/c/b:oYB	Lcom/tencent/mm/aw/e;
    //   434: getfield 379	com/tencent/mm/aw/e:playUrl	Ljava/lang/String;
    //   437: invokeinterface 387 2 0
    //   442: astore 33
    //   444: ldc 83
    //   446: ldc_w 389
    //   449: iconst_1
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload 33
    //   457: aastore
    //   458: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   461: iconst_0
    //   462: istore 32
    //   464: aload_0
    //   465: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   468: getfield 66	com/tencent/mm/plugin/music/c/a:oYv	J
    //   471: lstore 6
    //   473: aload_0
    //   474: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   477: getfield 69	com/tencent/mm/plugin/music/c/a:oYw	J
    //   480: lstore 4
    //   482: lload 4
    //   484: lconst_0
    //   485: lcmp
    //   486: ifeq +13 -> 499
    //   489: aload_0
    //   490: lload 4
    //   492: ldc2_w 390
    //   495: ldiv
    //   496: putfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   499: lload 6
    //   501: aload_0
    //   502: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   505: lcmp
    //   506: ifge +28 -> 534
    //   509: aload_0
    //   510: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   513: lstore_2
    //   514: aload_0
    //   515: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   518: getfield 72	com/tencent/mm/plugin/music/c/a:endFlag	I
    //   521: iconst_1
    //   522: if_icmpne +33 -> 555
    //   525: iconst_1
    //   526: istore_1
    //   527: aload 33
    //   529: astore 34
    //   531: goto -346 -> 185
    //   534: lload 6
    //   536: l2f
    //   537: ldc_w 432
    //   540: aload_0
    //   541: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   544: getfield 69	com/tencent/mm/plugin/music/c/a:oYw	J
    //   547: l2f
    //   548: fmul
    //   549: fadd
    //   550: f2l
    //   551: lstore_2
    //   552: goto -38 -> 514
    //   555: iconst_0
    //   556: istore_1
    //   557: aload 33
    //   559: astore 34
    //   561: goto -376 -> 185
    //   564: aload_0
    //   565: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   568: getfield 75	com/tencent/mm/plugin/music/c/a:oYx	J
    //   571: lconst_0
    //   572: lcmp
    //   573: ifeq +102 -> 675
    //   576: aload_0
    //   577: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   580: getfield 75	com/tencent/mm/plugin/music/c/a:oYx	J
    //   583: aload_0
    //   584: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   587: lcmp
    //   588: ifge +21 -> 609
    //   591: aload_0
    //   592: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   595: getfield 75	com/tencent/mm/plugin/music/c/a:oYx	J
    //   598: aload_0
    //   599: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   602: getfield 78	com/tencent/mm/plugin/music/c/a:oYz	J
    //   605: lcmp
    //   606: ifne +69 -> 675
    //   609: aload_0
    //   610: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   613: getfield 75	com/tencent/mm/plugin/music/c/a:oYx	J
    //   616: l2f
    //   617: aload_0
    //   618: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   621: getfield 78	com/tencent/mm/plugin/music/c/a:oYz	J
    //   624: l2f
    //   625: fdiv
    //   626: aload_0
    //   627: getfield 429	com/tencent/mm/plugin/music/c/b:oYD	F
    //   630: fsub
    //   631: ldc_w 432
    //   634: fcmpl
    //   635: iflt +40 -> 675
    //   638: ldc 83
    //   640: ldc_w 431
    //   643: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 105	com/tencent/mm/plugin/music/c/b:muY	Z
    //   656: new 8	com/tencent/mm/plugin/music/c/b$a
    //   659: dup
    //   660: aload_0
    //   661: iconst_1
    //   662: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   665: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   668: ldc_w 373
    //   671: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: return
    //   675: aload_0
    //   676: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   679: getfield 66	com/tencent/mm/plugin/music/c/a:oYv	J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifeq +102 -> 786
    //   687: aload_0
    //   688: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   691: getfield 66	com/tencent/mm/plugin/music/c/a:oYv	J
    //   694: aload_0
    //   695: getfield 47	com/tencent/mm/plugin/music/c/b:oYE	J
    //   698: lcmp
    //   699: ifge +21 -> 720
    //   702: aload_0
    //   703: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   706: getfield 66	com/tencent/mm/plugin/music/c/a:oYv	J
    //   709: aload_0
    //   710: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   713: getfield 69	com/tencent/mm/plugin/music/c/a:oYw	J
    //   716: lcmp
    //   717: ifne +69 -> 786
    //   720: aload_0
    //   721: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   724: getfield 66	com/tencent/mm/plugin/music/c/a:oYv	J
    //   727: l2f
    //   728: aload_0
    //   729: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   732: getfield 69	com/tencent/mm/plugin/music/c/a:oYw	J
    //   735: l2f
    //   736: fdiv
    //   737: aload_0
    //   738: getfield 429	com/tencent/mm/plugin/music/c/b:oYD	F
    //   741: fsub
    //   742: ldc_w 432
    //   745: fcmpl
    //   746: iflt +40 -> 786
    //   749: ldc 83
    //   751: ldc_w 431
    //   754: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_0
    //   758: iconst_1
    //   759: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   762: aload_0
    //   763: iconst_0
    //   764: putfield 105	com/tencent/mm/plugin/music/c/b:muY	Z
    //   767: new 8	com/tencent/mm/plugin/music/c/b$a
    //   770: dup
    //   771: aload_0
    //   772: iconst_1
    //   773: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   776: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   779: ldc_w 373
    //   782: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: return
    //   786: ldc 83
    //   788: ldc_w 434
    //   791: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_0
    //   795: iconst_1
    //   796: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   799: aload_0
    //   800: iconst_4
    //   801: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   804: ldc_w 373
    //   807: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   810: return
    //   811: astore 33
    //   813: ldc 83
    //   815: aload 33
    //   817: ldc_w 438
    //   820: iconst_1
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 43
    //   828: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   831: aastore
    //   832: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   835: goto -564 -> 271
    //   838: aload 34
    //   840: invokestatic 162	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   843: ifeq +36 -> 879
    //   846: ldc 83
    //   848: ldc_w 447
    //   851: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload_0
    //   855: iconst_1
    //   856: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   859: new 8	com/tencent/mm/plugin/music/c/b$a
    //   862: dup
    //   863: aload_0
    //   864: bipush 254
    //   866: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   869: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   872: ldc_w 373
    //   875: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   878: return
    //   879: aconst_null
    //   880: astore 40
    //   882: aconst_null
    //   883: astore 41
    //   885: aconst_null
    //   886: astore 39
    //   888: aconst_null
    //   889: astore 35
    //   891: aconst_null
    //   892: astore 38
    //   894: aconst_null
    //   895: astore 42
    //   897: aconst_null
    //   898: astore 37
    //   900: aload 43
    //   902: invokevirtual 407	java/io/File:exists	()Z
    //   905: ifne +259 -> 1164
    //   908: aload_0
    //   909: iconst_1
    //   910: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   913: ldc 83
    //   915: ldc_w 449
    //   918: iconst_1
    //   919: anewarray 4	java/lang/Object
    //   922: dup
    //   923: iconst_0
    //   924: aload 43
    //   926: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   929: aastore
    //   930: invokestatic 330	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   933: aload_0
    //   934: bipush 19
    //   936: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   939: lload 4
    //   941: lconst_0
    //   942: lcmp
    //   943: ifne +89 -> 1032
    //   946: lload_2
    //   947: lconst_0
    //   948: lcmp
    //   949: ifle +83 -> 1032
    //   952: ldc 83
    //   954: ldc_w 451
    //   957: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   960: new 453	java/lang/NullPointerException
    //   963: dup
    //   964: invokespecial 454	java/lang/NullPointerException:<init>	()V
    //   967: athrow
    //   968: aload_0
    //   969: lload_2
    //   970: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   973: lload_2
    //   974: ldc2_w 392
    //   977: lcmp
    //   978: ifge +15 -> 993
    //   981: new 8	com/tencent/mm/plugin/music/c/b$a
    //   984: dup
    //   985: aload_0
    //   986: iconst_1
    //   987: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   990: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   993: aload_0
    //   994: iconst_1
    //   995: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   998: ldc 83
    //   1000: ldc_w 458
    //   1003: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1006: ldc_w 373
    //   1009: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1012: return
    //   1013: astore 33
    //   1015: ldc 83
    //   1017: aload 33
    //   1019: ldc_w 460
    //   1022: iconst_0
    //   1023: anewarray 4	java/lang/Object
    //   1026: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1029: goto -61 -> 968
    //   1032: lload 4
    //   1034: lconst_0
    //   1035: lcmp
    //   1036: ifeq +47 -> 1083
    //   1039: lload_2
    //   1040: lload 4
    //   1042: lcmp
    //   1043: ifeq +40 -> 1083
    //   1046: ldc 83
    //   1048: ldc_w 462
    //   1051: iconst_2
    //   1052: anewarray 4	java/lang/Object
    //   1055: dup
    //   1056: iconst_0
    //   1057: lload 4
    //   1059: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1062: aastore
    //   1063: dup
    //   1064: iconst_1
    //   1065: lload_2
    //   1066: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1069: aastore
    //   1070: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aload_0
    //   1074: lload_2
    //   1075: lload 4
    //   1077: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   1080: goto -87 -> 993
    //   1083: lload 4
    //   1085: lconst_0
    //   1086: lcmp
    //   1087: ifeq +66 -> 1153
    //   1090: lload_2
    //   1091: lload 4
    //   1093: lcmp
    //   1094: ifne +59 -> 1153
    //   1097: ldc 83
    //   1099: ldc_w 466
    //   1102: iconst_2
    //   1103: anewarray 4	java/lang/Object
    //   1106: dup
    //   1107: iconst_0
    //   1108: lload 4
    //   1110: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1113: aastore
    //   1114: dup
    //   1115: iconst_1
    //   1116: lload_2
    //   1117: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1120: aastore
    //   1121: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1124: aload_0
    //   1125: lload 4
    //   1127: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   1130: lload_2
    //   1131: ldc2_w 392
    //   1134: lcmp
    //   1135: ifge -142 -> 993
    //   1138: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1141: dup
    //   1142: aload_0
    //   1143: iconst_1
    //   1144: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1147: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   1150: goto -157 -> 993
    //   1153: ldc 83
    //   1155: ldc_w 468
    //   1158: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1161: goto -168 -> 993
    //   1164: new 470	java/io/RandomAccessFile
    //   1167: dup
    //   1168: aload 43
    //   1170: ldc_w 472
    //   1173: invokespecial 475	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1176: astore 33
    //   1178: ldc 83
    //   1180: ldc_w 477
    //   1183: iconst_1
    //   1184: anewarray 4	java/lang/Object
    //   1187: dup
    //   1188: iconst_0
    //   1189: aload 34
    //   1191: aastore
    //   1192: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1195: new 479	java/util/HashMap
    //   1198: dup
    //   1199: bipush 10
    //   1201: invokespecial 481	java/util/HashMap:<init>	(I)V
    //   1204: astore 36
    //   1206: aload 36
    //   1208: ldc_w 483
    //   1211: ldc_w 485
    //   1214: invokeinterface 489 3 0
    //   1219: pop
    //   1220: lload 8
    //   1222: lload_2
    //   1223: lcmp
    //   1224: ifle +68 -> 1292
    //   1227: ldc 83
    //   1229: ldc_w 491
    //   1232: iconst_2
    //   1233: anewarray 4	java/lang/Object
    //   1236: dup
    //   1237: iconst_0
    //   1238: lload_2
    //   1239: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1242: aastore
    //   1243: dup
    //   1244: iconst_1
    //   1245: lload 8
    //   1247: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1250: aastore
    //   1251: invokestatic 493	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1254: aload 36
    //   1256: ldc_w 495
    //   1259: new 497	java/lang/StringBuilder
    //   1262: dup
    //   1263: ldc_w 499
    //   1266: invokespecial 500	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1269: lload_2
    //   1270: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1273: ldc 176
    //   1275: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: lload 8
    //   1280: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 508	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokeinterface 489 3 0
    //   1291: pop
    //   1292: iload 32
    //   1294: ifne +11 -> 1305
    //   1297: aload 34
    //   1299: invokestatic 513	com/tencent/mm/plugin/music/h/e:VJ	(Ljava/lang/String;)Z
    //   1302: ifeq +39 -> 1341
    //   1305: ldc 83
    //   1307: ldc_w 515
    //   1310: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1313: aload 36
    //   1315: ldc_w 517
    //   1318: ldc_w 519
    //   1321: invokeinterface 489 3 0
    //   1326: pop
    //   1327: aload 36
    //   1329: ldc_w 521
    //   1332: ldc_w 523
    //   1335: invokeinterface 489 3 0
    //   1340: pop
    //   1341: aload 36
    //   1343: ldc_w 525
    //   1346: new 497	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 526	java/lang/StringBuilder:<init>	()V
    //   1353: ldc_w 528
    //   1356: invokestatic 533	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1359: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: ldc_w 535
    //   1365: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokestatic 97	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1371: invokestatic 539	com/tencent/mm/plugin/music/h/e:eH	(Landroid/content/Context;)Ljava/lang/String;
    //   1374: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: invokevirtual 508	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1380: invokeinterface 489 3 0
    //   1385: pop
    //   1386: aload_0
    //   1387: aload 34
    //   1389: aload 36
    //   1391: invokespecial 541	com/tencent/mm/plugin/music/c/b:u	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   1394: astore 34
    //   1396: aload 34
    //   1398: astore 37
    //   1400: lload 4
    //   1402: lstore 8
    //   1404: lload_2
    //   1405: lstore 6
    //   1407: aload 33
    //   1409: astore 36
    //   1411: aload 38
    //   1413: astore 35
    //   1415: lload 4
    //   1417: lstore 26
    //   1419: lload_2
    //   1420: lstore 18
    //   1422: lload 4
    //   1424: lstore 20
    //   1426: lload_2
    //   1427: lstore 14
    //   1429: lload 4
    //   1431: lstore 22
    //   1433: lload_2
    //   1434: lstore 12
    //   1436: lload 4
    //   1438: lstore 24
    //   1440: lload_2
    //   1441: lstore 16
    //   1443: lload 4
    //   1445: lstore 28
    //   1447: lload_2
    //   1448: lstore 10
    //   1450: aload 34
    //   1452: invokevirtual 302	java/net/HttpURLConnection:getResponseCode	()I
    //   1455: istore_1
    //   1456: iload_1
    //   1457: sipush 200
    //   1460: if_icmpeq +539 -> 1999
    //   1463: iload_1
    //   1464: sipush 206
    //   1467: if_icmpeq +532 -> 1999
    //   1470: aload 34
    //   1472: astore 37
    //   1474: lload 4
    //   1476: lstore 8
    //   1478: lload_2
    //   1479: lstore 6
    //   1481: aload 33
    //   1483: astore 36
    //   1485: aload 38
    //   1487: astore 35
    //   1489: lload 4
    //   1491: lstore 26
    //   1493: lload_2
    //   1494: lstore 18
    //   1496: lload 4
    //   1498: lstore 20
    //   1500: lload_2
    //   1501: lstore 14
    //   1503: lload 4
    //   1505: lstore 22
    //   1507: lload_2
    //   1508: lstore 12
    //   1510: lload 4
    //   1512: lstore 24
    //   1514: lload_2
    //   1515: lstore 16
    //   1517: lload 4
    //   1519: lstore 28
    //   1521: lload_2
    //   1522: lstore 10
    //   1524: iload_1
    //   1525: invokestatic 311	com/tencent/mm/plugin/music/c/b:Ab	(I)V
    //   1528: aload 34
    //   1530: astore 37
    //   1532: lload 4
    //   1534: lstore 8
    //   1536: lload_2
    //   1537: lstore 6
    //   1539: aload 33
    //   1541: astore 36
    //   1543: aload 38
    //   1545: astore 35
    //   1547: lload 4
    //   1549: lstore 26
    //   1551: lload_2
    //   1552: lstore 18
    //   1554: lload 4
    //   1556: lstore 20
    //   1558: lload_2
    //   1559: lstore 14
    //   1561: lload 4
    //   1563: lstore 22
    //   1565: lload_2
    //   1566: lstore 12
    //   1568: lload 4
    //   1570: lstore 24
    //   1572: lload_2
    //   1573: lstore 16
    //   1575: lload 4
    //   1577: lstore 28
    //   1579: lload_2
    //   1580: lstore 10
    //   1582: ldc 83
    //   1584: ldc_w 543
    //   1587: iconst_1
    //   1588: anewarray 4	java/lang/Object
    //   1591: dup
    //   1592: iconst_0
    //   1593: iload_1
    //   1594: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: aastore
    //   1598: invokestatic 330	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1601: aload 34
    //   1603: astore 37
    //   1605: lload 4
    //   1607: lstore 8
    //   1609: lload_2
    //   1610: lstore 6
    //   1612: aload 33
    //   1614: astore 36
    //   1616: aload 38
    //   1618: astore 35
    //   1620: lload 4
    //   1622: lstore 26
    //   1624: lload_2
    //   1625: lstore 18
    //   1627: lload 4
    //   1629: lstore 20
    //   1631: lload_2
    //   1632: lstore 14
    //   1634: lload 4
    //   1636: lstore 22
    //   1638: lload_2
    //   1639: lstore 12
    //   1641: lload 4
    //   1643: lstore 24
    //   1645: lload_2
    //   1646: lstore 16
    //   1648: lload 4
    //   1650: lstore 28
    //   1652: lload_2
    //   1653: lstore 10
    //   1655: aload_0
    //   1656: iload_1
    //   1657: putfield 55	com/tencent/mm/plugin/music/c/b:oYF	I
    //   1660: aload 34
    //   1662: astore 37
    //   1664: lload 4
    //   1666: lstore 8
    //   1668: lload_2
    //   1669: lstore 6
    //   1671: aload 33
    //   1673: astore 36
    //   1675: aload 38
    //   1677: astore 35
    //   1679: lload 4
    //   1681: lstore 26
    //   1683: lload_2
    //   1684: lstore 18
    //   1686: lload 4
    //   1688: lstore 20
    //   1690: lload_2
    //   1691: lstore 14
    //   1693: lload 4
    //   1695: lstore 22
    //   1697: lload_2
    //   1698: lstore 12
    //   1700: lload 4
    //   1702: lstore 24
    //   1704: lload_2
    //   1705: lstore 16
    //   1707: lload 4
    //   1709: lstore 28
    //   1711: lload_2
    //   1712: lstore 10
    //   1714: aload_0
    //   1715: iconst_m1
    //   1716: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   1719: lload 4
    //   1721: lconst_0
    //   1722: lcmp
    //   1723: ifne +110 -> 1833
    //   1726: lload_2
    //   1727: lconst_0
    //   1728: lcmp
    //   1729: ifle +104 -> 1833
    //   1732: ldc 83
    //   1734: ldc_w 451
    //   1737: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1740: aload 33
    //   1742: lload_2
    //   1743: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   1746: aload_0
    //   1747: lload_2
    //   1748: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   1751: lload_2
    //   1752: ldc2_w 392
    //   1755: lcmp
    //   1756: ifge +15 -> 1771
    //   1759: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1762: dup
    //   1763: aload_0
    //   1764: iconst_1
    //   1765: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1768: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   1771: aload 33
    //   1773: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   1776: aload 34
    //   1778: ifnull +16 -> 1794
    //   1781: aload 34
    //   1783: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1786: invokevirtual 217	java/io/InputStream:close	()V
    //   1789: aload 34
    //   1791: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   1794: aload_0
    //   1795: iconst_1
    //   1796: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   1799: ldc 83
    //   1801: ldc_w 458
    //   1804: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1807: ldc_w 373
    //   1810: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1813: return
    //   1814: astore 35
    //   1816: ldc 83
    //   1818: aload 35
    //   1820: ldc_w 460
    //   1823: iconst_0
    //   1824: anewarray 4	java/lang/Object
    //   1827: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1830: goto -84 -> 1746
    //   1833: lload 4
    //   1835: lconst_0
    //   1836: lcmp
    //   1837: ifeq +47 -> 1884
    //   1840: lload_2
    //   1841: lload 4
    //   1843: lcmp
    //   1844: ifeq +40 -> 1884
    //   1847: ldc 83
    //   1849: ldc_w 462
    //   1852: iconst_2
    //   1853: anewarray 4	java/lang/Object
    //   1856: dup
    //   1857: iconst_0
    //   1858: lload 4
    //   1860: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1863: aastore
    //   1864: dup
    //   1865: iconst_1
    //   1866: lload_2
    //   1867: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1870: aastore
    //   1871: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1874: aload_0
    //   1875: lload_2
    //   1876: lload 4
    //   1878: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   1881: goto -110 -> 1771
    //   1884: lload 4
    //   1886: lconst_0
    //   1887: lcmp
    //   1888: ifeq +66 -> 1954
    //   1891: lload_2
    //   1892: lload 4
    //   1894: lcmp
    //   1895: ifne +59 -> 1954
    //   1898: ldc 83
    //   1900: ldc_w 466
    //   1903: iconst_2
    //   1904: anewarray 4	java/lang/Object
    //   1907: dup
    //   1908: iconst_0
    //   1909: lload 4
    //   1911: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1914: aastore
    //   1915: dup
    //   1916: iconst_1
    //   1917: lload_2
    //   1918: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1921: aastore
    //   1922: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1925: aload_0
    //   1926: lload 4
    //   1928: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   1931: lload_2
    //   1932: ldc2_w 392
    //   1935: lcmp
    //   1936: ifge -165 -> 1771
    //   1939: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1942: dup
    //   1943: aload_0
    //   1944: iconst_1
    //   1945: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1948: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   1951: goto -180 -> 1771
    //   1954: ldc 83
    //   1956: ldc_w 468
    //   1959: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1962: goto -191 -> 1771
    //   1965: astore 33
    //   1967: ldc 83
    //   1969: aload 33
    //   1971: ldc_w 460
    //   1974: iconst_0
    //   1975: anewarray 4	java/lang/Object
    //   1978: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1981: goto -205 -> 1776
    //   1984: astore 33
    //   1986: ldc 83
    //   1988: aload 33
    //   1990: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1993: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1996: goto -207 -> 1789
    //   1999: aload 34
    //   2001: astore 37
    //   2003: lload 4
    //   2005: lstore 8
    //   2007: lload_2
    //   2008: lstore 6
    //   2010: aload 33
    //   2012: astore 36
    //   2014: aload 38
    //   2016: astore 35
    //   2018: lload 4
    //   2020: lstore 26
    //   2022: lload_2
    //   2023: lstore 18
    //   2025: lload 4
    //   2027: lstore 20
    //   2029: lload_2
    //   2030: lstore 14
    //   2032: lload 4
    //   2034: lstore 22
    //   2036: lload_2
    //   2037: lstore 12
    //   2039: lload 4
    //   2041: lstore 24
    //   2043: lload_2
    //   2044: lstore 16
    //   2046: lload 4
    //   2048: lstore 28
    //   2050: lload_2
    //   2051: lstore 10
    //   2053: ldc 83
    //   2055: ldc_w 549
    //   2058: iconst_1
    //   2059: anewarray 4	java/lang/Object
    //   2062: dup
    //   2063: iconst_0
    //   2064: iload_1
    //   2065: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2068: aastore
    //   2069: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2072: aload 34
    //   2074: astore 37
    //   2076: lload 4
    //   2078: lstore 8
    //   2080: lload_2
    //   2081: lstore 6
    //   2083: aload 33
    //   2085: astore 36
    //   2087: aload 38
    //   2089: astore 35
    //   2091: lload 4
    //   2093: lstore 26
    //   2095: lload_2
    //   2096: lstore 18
    //   2098: lload 4
    //   2100: lstore 20
    //   2102: lload_2
    //   2103: lstore 14
    //   2105: lload 4
    //   2107: lstore 22
    //   2109: lload_2
    //   2110: lstore 12
    //   2112: lload 4
    //   2114: lstore 24
    //   2116: lload_2
    //   2117: lstore 16
    //   2119: lload 4
    //   2121: lstore 28
    //   2123: lload_2
    //   2124: lstore 10
    //   2126: ldc 83
    //   2128: new 497	java/lang/StringBuilder
    //   2131: dup
    //   2132: ldc_w 551
    //   2135: invokespecial 500	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2138: aload 34
    //   2140: ldc_w 525
    //   2143: invokevirtual 554	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2146: invokevirtual 507	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: invokevirtual 508	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2152: invokestatic 556	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2155: aload 34
    //   2157: astore 37
    //   2159: lload 4
    //   2161: lstore 8
    //   2163: lload_2
    //   2164: lstore 6
    //   2166: aload 33
    //   2168: astore 36
    //   2170: aload 38
    //   2172: astore 35
    //   2174: lload 4
    //   2176: lstore 26
    //   2178: lload_2
    //   2179: lstore 18
    //   2181: lload 4
    //   2183: lstore 20
    //   2185: lload_2
    //   2186: lstore 14
    //   2188: lload 4
    //   2190: lstore 22
    //   2192: lload_2
    //   2193: lstore 12
    //   2195: lload 4
    //   2197: lstore 24
    //   2199: lload_2
    //   2200: lstore 16
    //   2202: lload 4
    //   2204: lstore 28
    //   2206: lload_2
    //   2207: lstore 10
    //   2209: aload 34
    //   2211: invokevirtual 559	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2214: astore 44
    //   2216: aload 34
    //   2218: astore 37
    //   2220: lload 4
    //   2222: lstore 8
    //   2224: lload_2
    //   2225: lstore 6
    //   2227: aload 33
    //   2229: astore 36
    //   2231: aload 38
    //   2233: astore 35
    //   2235: lload 4
    //   2237: lstore 26
    //   2239: lload_2
    //   2240: lstore 18
    //   2242: lload 4
    //   2244: lstore 20
    //   2246: lload_2
    //   2247: lstore 14
    //   2249: lload 4
    //   2251: lstore 22
    //   2253: lload_2
    //   2254: lstore 12
    //   2256: lload 4
    //   2258: lstore 24
    //   2260: lload_2
    //   2261: lstore 16
    //   2263: lload 4
    //   2265: lstore 28
    //   2267: lload_2
    //   2268: lstore 10
    //   2270: ldc 83
    //   2272: ldc_w 561
    //   2275: iconst_1
    //   2276: anewarray 4	java/lang/Object
    //   2279: dup
    //   2280: iconst_0
    //   2281: aload 44
    //   2283: aastore
    //   2284: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2287: aload 34
    //   2289: astore 37
    //   2291: lload 4
    //   2293: lstore 8
    //   2295: lload_2
    //   2296: lstore 6
    //   2298: aload 33
    //   2300: astore 36
    //   2302: aload 38
    //   2304: astore 35
    //   2306: lload 4
    //   2308: lstore 26
    //   2310: lload_2
    //   2311: lstore 18
    //   2313: lload 4
    //   2315: lstore 20
    //   2317: lload_2
    //   2318: lstore 14
    //   2320: lload 4
    //   2322: lstore 22
    //   2324: lload_2
    //   2325: lstore 12
    //   2327: lload 4
    //   2329: lstore 24
    //   2331: lload_2
    //   2332: lstore 16
    //   2334: lload 4
    //   2336: lstore 28
    //   2338: lload_2
    //   2339: lstore 10
    //   2341: aload_0
    //   2342: aload 44
    //   2344: putfield 53	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2347: aload 34
    //   2349: astore 37
    //   2351: lload 4
    //   2353: lstore 8
    //   2355: lload_2
    //   2356: lstore 6
    //   2358: aload 33
    //   2360: astore 36
    //   2362: aload 38
    //   2364: astore 35
    //   2366: lload 4
    //   2368: lstore 26
    //   2370: lload_2
    //   2371: lstore 18
    //   2373: lload 4
    //   2375: lstore 20
    //   2377: lload_2
    //   2378: lstore 14
    //   2380: lload 4
    //   2382: lstore 22
    //   2384: lload_2
    //   2385: lstore 12
    //   2387: lload 4
    //   2389: lstore 24
    //   2391: lload_2
    //   2392: lstore 16
    //   2394: lload 4
    //   2396: lstore 28
    //   2398: lload_2
    //   2399: lstore 10
    //   2401: aload_0
    //   2402: getfield 53	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2405: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2408: ifne +390 -> 2798
    //   2411: aload 34
    //   2413: astore 37
    //   2415: lload 4
    //   2417: lstore 8
    //   2419: lload_2
    //   2420: lstore 6
    //   2422: aload 33
    //   2424: astore 36
    //   2426: aload 38
    //   2428: astore 35
    //   2430: lload 4
    //   2432: lstore 26
    //   2434: lload_2
    //   2435: lstore 18
    //   2437: lload 4
    //   2439: lstore 20
    //   2441: lload_2
    //   2442: lstore 14
    //   2444: lload 4
    //   2446: lstore 22
    //   2448: lload_2
    //   2449: lstore 12
    //   2451: lload 4
    //   2453: lstore 24
    //   2455: lload_2
    //   2456: lstore 16
    //   2458: lload 4
    //   2460: lstore 28
    //   2462: lload_2
    //   2463: lstore 10
    //   2465: aload_0
    //   2466: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   2469: getfield 562	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2472: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2475: ifeq +323 -> 2798
    //   2478: aload 34
    //   2480: astore 37
    //   2482: lload 4
    //   2484: lstore 8
    //   2486: lload_2
    //   2487: lstore 6
    //   2489: aload 33
    //   2491: astore 36
    //   2493: aload 38
    //   2495: astore 35
    //   2497: lload 4
    //   2499: lstore 26
    //   2501: lload_2
    //   2502: lstore 18
    //   2504: lload 4
    //   2506: lstore 20
    //   2508: lload_2
    //   2509: lstore 14
    //   2511: lload 4
    //   2513: lstore 22
    //   2515: lload_2
    //   2516: lstore 12
    //   2518: lload 4
    //   2520: lstore 24
    //   2522: lload_2
    //   2523: lstore 16
    //   2525: lload 4
    //   2527: lstore 28
    //   2529: lload_2
    //   2530: lstore 10
    //   2532: aload_0
    //   2533: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   2536: aload_0
    //   2537: getfield 53	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2540: putfield 562	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2543: aload 34
    //   2545: astore 37
    //   2547: lload 4
    //   2549: lstore 8
    //   2551: lload_2
    //   2552: lstore 6
    //   2554: aload 33
    //   2556: astore 36
    //   2558: aload 38
    //   2560: astore 35
    //   2562: lload 4
    //   2564: lstore 26
    //   2566: lload_2
    //   2567: lstore 18
    //   2569: lload 4
    //   2571: lstore 20
    //   2573: lload_2
    //   2574: lstore 14
    //   2576: lload 4
    //   2578: lstore 22
    //   2580: lload_2
    //   2581: lstore 12
    //   2583: lload 4
    //   2585: lstore 24
    //   2587: lload_2
    //   2588: lstore 16
    //   2590: lload 4
    //   2592: lstore 28
    //   2594: lload_2
    //   2595: lstore 10
    //   2597: aload_0
    //   2598: getfield 59	com/tencent/mm/plugin/music/c/b:oYB	Lcom/tencent/mm/aw/e;
    //   2601: getfield 145	com/tencent/mm/aw/e:fKj	Ljava/lang/String;
    //   2604: astore 45
    //   2606: aload 34
    //   2608: astore 37
    //   2610: lload 4
    //   2612: lstore 8
    //   2614: lload_2
    //   2615: lstore 6
    //   2617: aload 33
    //   2619: astore 36
    //   2621: aload 38
    //   2623: astore 35
    //   2625: lload 4
    //   2627: lstore 26
    //   2629: lload_2
    //   2630: lstore 18
    //   2632: lload 4
    //   2634: lstore 20
    //   2636: lload_2
    //   2637: lstore 14
    //   2639: lload 4
    //   2641: lstore 22
    //   2643: lload_2
    //   2644: lstore 12
    //   2646: lload 4
    //   2648: lstore 24
    //   2650: lload_2
    //   2651: lstore 16
    //   2653: lload 4
    //   2655: lstore 28
    //   2657: lload_2
    //   2658: lstore 10
    //   2660: aload_0
    //   2661: getfield 53	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2664: astore 44
    //   2666: aload 34
    //   2668: astore 37
    //   2670: lload 4
    //   2672: lstore 8
    //   2674: lload_2
    //   2675: lstore 6
    //   2677: aload 33
    //   2679: astore 36
    //   2681: aload 38
    //   2683: astore 35
    //   2685: lload 4
    //   2687: lstore 26
    //   2689: lload_2
    //   2690: lstore 18
    //   2692: lload 4
    //   2694: lstore 20
    //   2696: lload_2
    //   2697: lstore 14
    //   2699: lload 4
    //   2701: lstore 22
    //   2703: lload_2
    //   2704: lstore 12
    //   2706: lload 4
    //   2708: lstore 24
    //   2710: lload_2
    //   2711: lstore 16
    //   2713: lload 4
    //   2715: lstore 28
    //   2717: lload_2
    //   2718: lstore 10
    //   2720: invokestatic 565	com/tencent/mm/plugin/music/cache/e:bVi	()Z
    //   2723: ifeq +1161 -> 3884
    //   2726: aload 34
    //   2728: astore 37
    //   2730: lload 4
    //   2732: lstore 8
    //   2734: lload_2
    //   2735: lstore 6
    //   2737: aload 33
    //   2739: astore 36
    //   2741: aload 38
    //   2743: astore 35
    //   2745: lload 4
    //   2747: lstore 26
    //   2749: lload_2
    //   2750: lstore 18
    //   2752: lload 4
    //   2754: lstore 20
    //   2756: lload_2
    //   2757: lstore 14
    //   2759: lload 4
    //   2761: lstore 22
    //   2763: lload_2
    //   2764: lstore 12
    //   2766: lload 4
    //   2768: lstore 24
    //   2770: lload_2
    //   2771: lstore 16
    //   2773: lload 4
    //   2775: lstore 28
    //   2777: lload_2
    //   2778: lstore 10
    //   2780: ldc_w 567
    //   2783: invokestatic 123	com/tencent/mm/plugin/music/f/c/b:am	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/music/f/c/a;
    //   2786: checkcast 567	com/tencent/mm/plugin/music/cache/c
    //   2789: aload 45
    //   2791: aload 44
    //   2793: invokeinterface 570 3 0
    //   2798: aload 34
    //   2800: astore 37
    //   2802: lload 4
    //   2804: lstore 8
    //   2806: lload_2
    //   2807: lstore 6
    //   2809: aload 33
    //   2811: astore 36
    //   2813: aload 38
    //   2815: astore 35
    //   2817: lload 4
    //   2819: lstore 26
    //   2821: lload_2
    //   2822: lstore 18
    //   2824: lload 4
    //   2826: lstore 20
    //   2828: lload_2
    //   2829: lstore 14
    //   2831: lload 4
    //   2833: lstore 22
    //   2835: lload_2
    //   2836: lstore 12
    //   2838: lload 4
    //   2840: lstore 24
    //   2842: lload_2
    //   2843: lstore 16
    //   2845: lload 4
    //   2847: lstore 28
    //   2849: lload_2
    //   2850: lstore 10
    //   2852: aload 34
    //   2854: ldc_w 572
    //   2857: invokevirtual 326	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2860: astore 45
    //   2862: aload 34
    //   2864: astore 37
    //   2866: lload 4
    //   2868: lstore 8
    //   2870: lload_2
    //   2871: lstore 6
    //   2873: aload 33
    //   2875: astore 36
    //   2877: aload 38
    //   2879: astore 35
    //   2881: lload 4
    //   2883: lstore 26
    //   2885: lload_2
    //   2886: lstore 18
    //   2888: lload 4
    //   2890: lstore 20
    //   2892: lload_2
    //   2893: lstore 14
    //   2895: lload 4
    //   2897: lstore 22
    //   2899: lload_2
    //   2900: lstore 12
    //   2902: lload 4
    //   2904: lstore 24
    //   2906: lload_2
    //   2907: lstore 16
    //   2909: lload 4
    //   2911: lstore 28
    //   2913: lload_2
    //   2914: lstore 10
    //   2916: aload 45
    //   2918: invokestatic 574	com/tencent/mm/plugin/music/c/b:Vt	(Ljava/lang/String;)[J
    //   2921: astore 44
    //   2923: aload 34
    //   2925: astore 37
    //   2927: lload 4
    //   2929: lstore 8
    //   2931: lload_2
    //   2932: lstore 6
    //   2934: aload 33
    //   2936: astore 36
    //   2938: aload 38
    //   2940: astore 35
    //   2942: lload 4
    //   2944: lstore 26
    //   2946: lload_2
    //   2947: lstore 18
    //   2949: lload 4
    //   2951: lstore 20
    //   2953: lload_2
    //   2954: lstore 14
    //   2956: lload 4
    //   2958: lstore 22
    //   2960: lload_2
    //   2961: lstore 12
    //   2963: lload 4
    //   2965: lstore 24
    //   2967: lload_2
    //   2968: lstore 16
    //   2970: lload 4
    //   2972: lstore 28
    //   2974: lload_2
    //   2975: lstore 10
    //   2977: aload 34
    //   2979: ldc_w 576
    //   2982: invokevirtual 326	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2985: lconst_0
    //   2986: invokestatic 580	com/tencent/mm/sdk/platformtools/bo:getLong	(Ljava/lang/String;J)J
    //   2989: lstore 30
    //   2991: aload 34
    //   2993: astore 37
    //   2995: lload 4
    //   2997: lstore 8
    //   2999: lload_2
    //   3000: lstore 6
    //   3002: aload 33
    //   3004: astore 36
    //   3006: aload 38
    //   3008: astore 35
    //   3010: lload 4
    //   3012: lstore 26
    //   3014: lload_2
    //   3015: lstore 18
    //   3017: lload 4
    //   3019: lstore 20
    //   3021: lload_2
    //   3022: lstore 14
    //   3024: lload 4
    //   3026: lstore 22
    //   3028: lload_2
    //   3029: lstore 12
    //   3031: lload 4
    //   3033: lstore 24
    //   3035: lload_2
    //   3036: lstore 16
    //   3038: lload 4
    //   3040: lstore 28
    //   3042: lload_2
    //   3043: lstore 10
    //   3045: ldc 83
    //   3047: ldc_w 582
    //   3050: iconst_2
    //   3051: anewarray 4	java/lang/Object
    //   3054: dup
    //   3055: iconst_0
    //   3056: aload 45
    //   3058: aastore
    //   3059: dup
    //   3060: iconst_1
    //   3061: lload 30
    //   3063: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3066: aastore
    //   3067: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3070: aload 44
    //   3072: ifnonnull +878 -> 3950
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
    //   3096: lstore 26
    //   3098: lload_2
    //   3099: lstore 18
    //   3101: lload 4
    //   3103: lstore 20
    //   3105: lload_2
    //   3106: lstore 14
    //   3108: lload 4
    //   3110: lstore 22
    //   3112: lload_2
    //   3113: lstore 12
    //   3115: lload 4
    //   3117: lstore 24
    //   3119: lload_2
    //   3120: lstore 16
    //   3122: lload 4
    //   3124: lstore 28
    //   3126: lload_2
    //   3127: lstore 10
    //   3129: ldc 83
    //   3131: ldc_w 584
    //   3134: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3137: lload_2
    //   3138: lstore 4
    //   3140: lload_2
    //   3141: lconst_0
    //   3142: lcmp
    //   3143: ifeq +4084 -> 7227
    //   3146: lconst_0
    //   3147: lstore 4
    //   3149: goto +4078 -> 7227
    //   3152: aload 34
    //   3154: astore 37
    //   3156: lload 4
    //   3158: lstore 8
    //   3160: lload_2
    //   3161: lstore 6
    //   3163: aload 33
    //   3165: astore 36
    //   3167: aload 38
    //   3169: astore 35
    //   3171: lload 4
    //   3173: lstore 26
    //   3175: lload_2
    //   3176: lstore 18
    //   3178: lload 4
    //   3180: lstore 20
    //   3182: lload_2
    //   3183: lstore 14
    //   3185: lload 4
    //   3187: lstore 22
    //   3189: lload_2
    //   3190: lstore 12
    //   3192: lload 4
    //   3194: lstore 24
    //   3196: lload_2
    //   3197: lstore 16
    //   3199: lload 4
    //   3201: lstore 28
    //   3203: lload_2
    //   3204: lstore 10
    //   3206: ldc 83
    //   3208: ldc_w 586
    //   3211: iconst_2
    //   3212: anewarray 4	java/lang/Object
    //   3215: dup
    //   3216: iconst_0
    //   3217: lload 30
    //   3219: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3222: aastore
    //   3223: dup
    //   3224: iconst_1
    //   3225: lload_2
    //   3226: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3229: aastore
    //   3230: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3233: aload 34
    //   3235: astore 37
    //   3237: lload 4
    //   3239: lstore 8
    //   3241: lload_2
    //   3242: lstore 6
    //   3244: aload 33
    //   3246: astore 36
    //   3248: aload 38
    //   3250: astore 35
    //   3252: lload 4
    //   3254: lstore 26
    //   3256: lload_2
    //   3257: lstore 18
    //   3259: lload 4
    //   3261: lstore 20
    //   3263: lload_2
    //   3264: lstore 14
    //   3266: lload 4
    //   3268: lstore 22
    //   3270: lload_2
    //   3271: lstore 12
    //   3273: lload 4
    //   3275: lstore 24
    //   3277: lload_2
    //   3278: lstore 16
    //   3280: lload 4
    //   3282: lstore 28
    //   3284: lload_2
    //   3285: lstore 10
    //   3287: aload 33
    //   3289: lload 30
    //   3291: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   3294: aload 34
    //   3296: astore 37
    //   3298: lload 4
    //   3300: lstore 8
    //   3302: lload_2
    //   3303: lstore 6
    //   3305: aload 33
    //   3307: astore 36
    //   3309: aload 38
    //   3311: astore 35
    //   3313: lload 4
    //   3315: lstore 26
    //   3317: lload_2
    //   3318: lstore 18
    //   3320: lload 4
    //   3322: lstore 20
    //   3324: lload_2
    //   3325: lstore 14
    //   3327: lload 4
    //   3329: lstore 22
    //   3331: lload_2
    //   3332: lstore 12
    //   3334: lload 4
    //   3336: lstore 24
    //   3338: lload_2
    //   3339: lstore 16
    //   3341: lload 4
    //   3343: lstore 28
    //   3345: lload_2
    //   3346: lstore 10
    //   3348: aload 33
    //   3350: lload_2
    //   3351: invokevirtual 589	java/io/RandomAccessFile:seek	(J)V
    //   3354: aload 34
    //   3356: astore 37
    //   3358: lload 4
    //   3360: lstore 8
    //   3362: lload_2
    //   3363: lstore 6
    //   3365: aload 33
    //   3367: astore 36
    //   3369: aload 38
    //   3371: astore 35
    //   3373: lload 4
    //   3375: lstore 26
    //   3377: lload_2
    //   3378: lstore 18
    //   3380: lload 4
    //   3382: lstore 20
    //   3384: lload_2
    //   3385: lstore 14
    //   3387: lload 4
    //   3389: lstore 22
    //   3391: lload_2
    //   3392: lstore 12
    //   3394: lload 4
    //   3396: lstore 24
    //   3398: lload_2
    //   3399: lstore 16
    //   3401: lload 4
    //   3403: lstore 28
    //   3405: lload_2
    //   3406: lstore 10
    //   3408: aload 34
    //   3410: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3413: astore 38
    //   3415: aload 38
    //   3417: astore 35
    //   3419: lload_2
    //   3420: lstore 16
    //   3422: lload_2
    //   3423: lstore 18
    //   3425: lload_2
    //   3426: lstore 12
    //   3428: lload_2
    //   3429: lstore 14
    //   3431: lload_2
    //   3432: lstore 8
    //   3434: lload_2
    //   3435: lstore 10
    //   3437: sipush 4096
    //   3440: newarray byte
    //   3442: astore 36
    //   3444: lload_2
    //   3445: lstore 16
    //   3447: lload_2
    //   3448: lstore 18
    //   3450: lload_2
    //   3451: lstore 12
    //   3453: lload_2
    //   3454: lstore 14
    //   3456: lload_2
    //   3457: lstore 8
    //   3459: lload_2
    //   3460: lstore 10
    //   3462: aload_0
    //   3463: getfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3466: ifne +1251 -> 4717
    //   3469: lload_2
    //   3470: lstore 16
    //   3472: lload_2
    //   3473: lstore 18
    //   3475: lload_2
    //   3476: lstore 12
    //   3478: lload_2
    //   3479: lstore 14
    //   3481: lload_2
    //   3482: lstore 8
    //   3484: lload_2
    //   3485: lstore 10
    //   3487: aload 35
    //   3489: aload 36
    //   3491: invokevirtual 593	java/io/InputStream:read	([B)I
    //   3494: istore_1
    //   3495: iload_1
    //   3496: ifle +1159 -> 4655
    //   3499: lload_2
    //   3500: lstore 16
    //   3502: lload_2
    //   3503: lstore 18
    //   3505: lload_2
    //   3506: lstore 12
    //   3508: lload_2
    //   3509: lstore 14
    //   3511: lload_2
    //   3512: lstore 8
    //   3514: lload_2
    //   3515: lstore 10
    //   3517: aload 33
    //   3519: aload 36
    //   3521: iconst_0
    //   3522: iload_1
    //   3523: invokevirtual 597	java/io/RandomAccessFile:write	([BII)V
    //   3526: lload_2
    //   3527: iload_1
    //   3528: i2l
    //   3529: ladd
    //   3530: lstore 6
    //   3532: lload 6
    //   3534: lstore 16
    //   3536: lload 6
    //   3538: lstore 18
    //   3540: lload 6
    //   3542: lstore 12
    //   3544: lload 6
    //   3546: lstore 14
    //   3548: lload 6
    //   3550: lstore 8
    //   3552: lload 6
    //   3554: lstore 10
    //   3556: ldc 83
    //   3558: ldc_w 599
    //   3561: iconst_2
    //   3562: anewarray 4	java/lang/Object
    //   3565: dup
    //   3566: iconst_0
    //   3567: lload 6
    //   3569: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3572: aastore
    //   3573: dup
    //   3574: iconst_1
    //   3575: lload 30
    //   3577: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3580: aastore
    //   3581: invokestatic 602	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3584: lload 6
    //   3586: lstore 16
    //   3588: lload 6
    //   3590: lstore 18
    //   3592: lload 6
    //   3594: lstore 12
    //   3596: lload 6
    //   3598: lstore 14
    //   3600: lload 6
    //   3602: lstore 8
    //   3604: lload 6
    //   3606: lstore 10
    //   3608: aload_0
    //   3609: getfield 105	com/tencent/mm/plugin/music/c/b:muY	Z
    //   3612: ifeq +764 -> 4376
    //   3615: lload 6
    //   3617: lstore 16
    //   3619: lload 6
    //   3621: lstore 18
    //   3623: lload 6
    //   3625: lstore 12
    //   3627: lload 6
    //   3629: lstore 14
    //   3631: lload 6
    //   3633: lstore 8
    //   3635: lload 6
    //   3637: lstore 10
    //   3639: aload_0
    //   3640: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   3643: lload 6
    //   3645: putfield 75	com/tencent/mm/plugin/music/c/a:oYx	J
    //   3648: lload 6
    //   3650: lstore 16
    //   3652: lload 6
    //   3654: lstore 18
    //   3656: lload 6
    //   3658: lstore 12
    //   3660: lload 6
    //   3662: lstore 14
    //   3664: lload 6
    //   3666: lstore 8
    //   3668: lload 6
    //   3670: lstore 10
    //   3672: aload_0
    //   3673: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   3676: lload 30
    //   3678: putfield 78	com/tencent/mm/plugin/music/c/a:oYz	J
    //   3681: lload 6
    //   3683: lstore_2
    //   3684: lload 6
    //   3686: ldc2_w 392
    //   3689: lcmp
    //   3690: iflt -246 -> 3444
    //   3693: lload 6
    //   3695: lstore 16
    //   3697: lload 6
    //   3699: lstore 18
    //   3701: lload 6
    //   3703: lstore 12
    //   3705: lload 6
    //   3707: lstore 14
    //   3709: lload 6
    //   3711: lstore 8
    //   3713: lload 6
    //   3715: lstore 10
    //   3717: new 8	com/tencent/mm/plugin/music/c/b$a
    //   3720: dup
    //   3721: aload_0
    //   3722: iconst_1
    //   3723: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   3726: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   3729: lload 6
    //   3731: lstore_2
    //   3732: goto -288 -> 3444
    //   3735: astore 36
    //   3737: lload 16
    //   3739: lstore_2
    //   3740: ldc 83
    //   3742: aload 36
    //   3744: ldc_w 604
    //   3747: iconst_1
    //   3748: anewarray 4	java/lang/Object
    //   3751: dup
    //   3752: iconst_0
    //   3753: aload 43
    //   3755: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3758: aastore
    //   3759: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3762: aload_0
    //   3763: sipush 750
    //   3766: putfield 57	com/tencent/mm/plugin/music/c/b:cfE	I
    //   3769: aload_0
    //   3770: iconst_5
    //   3771: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   3774: lload 4
    //   3776: lconst_0
    //   3777: lcmp
    //   3778: ifne +1267 -> 5045
    //   3781: lload_2
    //   3782: lconst_0
    //   3783: lcmp
    //   3784: ifle +1261 -> 5045
    //   3787: ldc 83
    //   3789: ldc_w 451
    //   3792: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3795: aload 33
    //   3797: lload_2
    //   3798: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   3801: aload_0
    //   3802: lload_2
    //   3803: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   3806: lload_2
    //   3807: ldc2_w 392
    //   3810: lcmp
    //   3811: ifge +15 -> 3826
    //   3814: new 8	com/tencent/mm/plugin/music/c/b$a
    //   3817: dup
    //   3818: aload_0
    //   3819: iconst_1
    //   3820: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   3823: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   3826: aload 35
    //   3828: ifnull +8 -> 3836
    //   3831: aload 35
    //   3833: invokevirtual 217	java/io/InputStream:close	()V
    //   3836: aload 33
    //   3838: ifnull +8 -> 3846
    //   3841: aload 33
    //   3843: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   3846: aload 34
    //   3848: ifnull +16 -> 3864
    //   3851: aload 34
    //   3853: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3856: invokevirtual 217	java/io/InputStream:close	()V
    //   3859: aload 34
    //   3861: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   3864: aload_0
    //   3865: iconst_1
    //   3866: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3869: ldc 83
    //   3871: ldc_w 458
    //   3874: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3877: ldc_w 373
    //   3880: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3883: return
    //   3884: aload 34
    //   3886: astore 37
    //   3888: lload 4
    //   3890: lstore 8
    //   3892: lload_2
    //   3893: lstore 6
    //   3895: aload 33
    //   3897: astore 36
    //   3899: aload 38
    //   3901: astore 35
    //   3903: lload 4
    //   3905: lstore 26
    //   3907: lload_2
    //   3908: lstore 18
    //   3910: lload 4
    //   3912: lstore 20
    //   3914: lload_2
    //   3915: lstore 14
    //   3917: lload 4
    //   3919: lstore 22
    //   3921: lload_2
    //   3922: lstore 12
    //   3924: lload 4
    //   3926: lstore 24
    //   3928: lload_2
    //   3929: lstore 16
    //   3931: lload 4
    //   3933: lstore 28
    //   3935: lload_2
    //   3936: lstore 10
    //   3938: ldc_w 606
    //   3941: ldc_w 608
    //   3944: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3947: goto -1149 -> 2798
    //   3950: lload_2
    //   3951: lconst_0
    //   3952: lcmp
    //   3953: ifle +414 -> 4367
    //   3956: lload_2
    //   3957: aload 44
    //   3959: iconst_0
    //   3960: laload
    //   3961: lcmp
    //   3962: ifeq +405 -> 4367
    //   3965: aload 34
    //   3967: astore 37
    //   3969: lload 4
    //   3971: lstore 8
    //   3973: lload_2
    //   3974: lstore 6
    //   3976: aload 33
    //   3978: astore 36
    //   3980: aload 38
    //   3982: astore 35
    //   3984: lload 4
    //   3986: lstore 26
    //   3988: lload_2
    //   3989: lstore 18
    //   3991: lload 4
    //   3993: lstore 20
    //   3995: lload_2
    //   3996: lstore 14
    //   3998: lload 4
    //   4000: lstore 22
    //   4002: lload_2
    //   4003: lstore 12
    //   4005: lload 4
    //   4007: lstore 24
    //   4009: lload_2
    //   4010: lstore 16
    //   4012: lload 4
    //   4014: lstore 28
    //   4016: lload_2
    //   4017: lstore 10
    //   4019: ldc 83
    //   4021: ldc_w 610
    //   4024: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4027: aload 34
    //   4029: astore 37
    //   4031: lload 4
    //   4033: lstore 8
    //   4035: lload_2
    //   4036: lstore 6
    //   4038: aload 33
    //   4040: astore 36
    //   4042: aload 38
    //   4044: astore 35
    //   4046: lload 4
    //   4048: lstore 26
    //   4050: lload_2
    //   4051: lstore 18
    //   4053: lload 4
    //   4055: lstore 20
    //   4057: lload_2
    //   4058: lstore 14
    //   4060: lload 4
    //   4062: lstore 22
    //   4064: lload_2
    //   4065: lstore 12
    //   4067: lload 4
    //   4069: lstore 24
    //   4071: lload_2
    //   4072: lstore 16
    //   4074: lload 4
    //   4076: lstore 28
    //   4078: lload_2
    //   4079: lstore 10
    //   4081: aload_0
    //   4082: bipush 6
    //   4084: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   4087: lload 4
    //   4089: lconst_0
    //   4090: lcmp
    //   4091: ifne +110 -> 4201
    //   4094: lload_2
    //   4095: lconst_0
    //   4096: lcmp
    //   4097: ifle +104 -> 4201
    //   4100: ldc 83
    //   4102: ldc_w 451
    //   4105: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4108: aload 33
    //   4110: lload_2
    //   4111: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   4114: aload_0
    //   4115: lload_2
    //   4116: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   4119: lload_2
    //   4120: ldc2_w 392
    //   4123: lcmp
    //   4124: ifge +15 -> 4139
    //   4127: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4130: dup
    //   4131: aload_0
    //   4132: iconst_1
    //   4133: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4136: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   4139: aload 33
    //   4141: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   4144: aload 34
    //   4146: ifnull +16 -> 4162
    //   4149: aload 34
    //   4151: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4154: invokevirtual 217	java/io/InputStream:close	()V
    //   4157: aload 34
    //   4159: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   4162: aload_0
    //   4163: iconst_1
    //   4164: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4167: ldc 83
    //   4169: ldc_w 458
    //   4172: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4175: ldc_w 373
    //   4178: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4181: return
    //   4182: astore 35
    //   4184: ldc 83
    //   4186: aload 35
    //   4188: ldc_w 460
    //   4191: iconst_0
    //   4192: anewarray 4	java/lang/Object
    //   4195: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4198: goto -84 -> 4114
    //   4201: lload 4
    //   4203: lconst_0
    //   4204: lcmp
    //   4205: ifeq +47 -> 4252
    //   4208: lload_2
    //   4209: lload 4
    //   4211: lcmp
    //   4212: ifeq +40 -> 4252
    //   4215: ldc 83
    //   4217: ldc_w 462
    //   4220: iconst_2
    //   4221: anewarray 4	java/lang/Object
    //   4224: dup
    //   4225: iconst_0
    //   4226: lload 4
    //   4228: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4231: aastore
    //   4232: dup
    //   4233: iconst_1
    //   4234: lload_2
    //   4235: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4238: aastore
    //   4239: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4242: aload_0
    //   4243: lload_2
    //   4244: lload 4
    //   4246: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   4249: goto -110 -> 4139
    //   4252: lload 4
    //   4254: lconst_0
    //   4255: lcmp
    //   4256: ifeq +66 -> 4322
    //   4259: lload_2
    //   4260: lload 4
    //   4262: lcmp
    //   4263: ifne +59 -> 4322
    //   4266: ldc 83
    //   4268: ldc_w 466
    //   4271: iconst_2
    //   4272: anewarray 4	java/lang/Object
    //   4275: dup
    //   4276: iconst_0
    //   4277: lload 4
    //   4279: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4282: aastore
    //   4283: dup
    //   4284: iconst_1
    //   4285: lload_2
    //   4286: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4289: aastore
    //   4290: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4293: aload_0
    //   4294: lload 4
    //   4296: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   4299: lload_2
    //   4300: ldc2_w 392
    //   4303: lcmp
    //   4304: ifge -165 -> 4139
    //   4307: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4310: dup
    //   4311: aload_0
    //   4312: iconst_1
    //   4313: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4316: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   4319: goto -180 -> 4139
    //   4322: ldc 83
    //   4324: ldc_w 468
    //   4327: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4330: goto -191 -> 4139
    //   4333: astore 33
    //   4335: ldc 83
    //   4337: aload 33
    //   4339: ldc_w 460
    //   4342: iconst_0
    //   4343: anewarray 4	java/lang/Object
    //   4346: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4349: goto -205 -> 4144
    //   4352: astore 33
    //   4354: ldc 83
    //   4356: aload 33
    //   4358: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4361: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4364: goto -207 -> 4157
    //   4367: aload 44
    //   4369: iconst_2
    //   4370: laload
    //   4371: lstore 4
    //   4373: goto +2865 -> 7238
    //   4376: lload 6
    //   4378: lstore 16
    //   4380: lload 6
    //   4382: lstore 18
    //   4384: lload 6
    //   4386: lstore 12
    //   4388: lload 6
    //   4390: lstore 14
    //   4392: lload 6
    //   4394: lstore 8
    //   4396: lload 6
    //   4398: lstore 10
    //   4400: aload_0
    //   4401: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   4404: lload 6
    //   4406: putfield 66	com/tencent/mm/plugin/music/c/a:oYv	J
    //   4409: lload 6
    //   4411: lstore 16
    //   4413: lload 6
    //   4415: lstore 18
    //   4417: lload 6
    //   4419: lstore 12
    //   4421: lload 6
    //   4423: lstore 14
    //   4425: lload 6
    //   4427: lstore 8
    //   4429: lload 6
    //   4431: lstore 10
    //   4433: aload_0
    //   4434: getfield 61	com/tencent/mm/plugin/music/c/b:oYC	Lcom/tencent/mm/plugin/music/c/a;
    //   4437: lload 30
    //   4439: putfield 69	com/tencent/mm/plugin/music/c/a:oYw	J
    //   4442: goto -761 -> 3681
    //   4445: astore 38
    //   4447: aload 35
    //   4449: astore 39
    //   4451: lload 18
    //   4453: lstore_2
    //   4454: aload 34
    //   4456: astore 37
    //   4458: lload 4
    //   4460: lstore 8
    //   4462: lload_2
    //   4463: lstore 6
    //   4465: aload 33
    //   4467: astore 36
    //   4469: aload 39
    //   4471: astore 35
    //   4473: ldc 83
    //   4475: aload 38
    //   4477: ldc_w 604
    //   4480: iconst_1
    //   4481: anewarray 4	java/lang/Object
    //   4484: dup
    //   4485: iconst_0
    //   4486: aload 43
    //   4488: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4491: aastore
    //   4492: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4495: aload 34
    //   4497: astore 37
    //   4499: lload 4
    //   4501: lstore 8
    //   4503: lload_2
    //   4504: lstore 6
    //   4506: aload 33
    //   4508: astore 36
    //   4510: aload 39
    //   4512: astore 35
    //   4514: aload_0
    //   4515: sipush 751
    //   4518: putfield 57	com/tencent/mm/plugin/music/c/b:cfE	I
    //   4521: aload 34
    //   4523: astore 37
    //   4525: lload 4
    //   4527: lstore 8
    //   4529: lload_2
    //   4530: lstore 6
    //   4532: aload 33
    //   4534: astore 36
    //   4536: aload 39
    //   4538: astore 35
    //   4540: aload_0
    //   4541: iconst_5
    //   4542: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   4545: lload 4
    //   4547: lconst_0
    //   4548: lcmp
    //   4549: ifne +700 -> 5249
    //   4552: lload_2
    //   4553: lconst_0
    //   4554: lcmp
    //   4555: ifle +694 -> 5249
    //   4558: ldc 83
    //   4560: ldc_w 451
    //   4563: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4566: aload 33
    //   4568: lload_2
    //   4569: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   4572: aload_0
    //   4573: lload_2
    //   4574: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   4577: lload_2
    //   4578: ldc2_w 392
    //   4581: lcmp
    //   4582: ifge +15 -> 4597
    //   4585: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4588: dup
    //   4589: aload_0
    //   4590: iconst_1
    //   4591: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4594: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   4597: aload 39
    //   4599: ifnull +8 -> 4607
    //   4602: aload 39
    //   4604: invokevirtual 217	java/io/InputStream:close	()V
    //   4607: aload 33
    //   4609: ifnull +8 -> 4617
    //   4612: aload 33
    //   4614: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   4617: aload 34
    //   4619: ifnull +16 -> 4635
    //   4622: aload 34
    //   4624: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4627: invokevirtual 217	java/io/InputStream:close	()V
    //   4630: aload 34
    //   4632: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   4635: aload_0
    //   4636: iconst_1
    //   4637: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4640: ldc 83
    //   4642: ldc_w 458
    //   4645: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4648: ldc_w 373
    //   4651: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4654: return
    //   4655: lload_2
    //   4656: lstore 16
    //   4658: lload_2
    //   4659: lstore 18
    //   4661: lload_2
    //   4662: lstore 12
    //   4664: lload_2
    //   4665: lstore 14
    //   4667: lload_2
    //   4668: lstore 8
    //   4670: lload_2
    //   4671: lstore 10
    //   4673: ldc 83
    //   4675: ldc_w 612
    //   4678: iconst_4
    //   4679: anewarray 4	java/lang/Object
    //   4682: dup
    //   4683: iconst_0
    //   4684: iload_1
    //   4685: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4688: aastore
    //   4689: dup
    //   4690: iconst_1
    //   4691: aload_0
    //   4692: getfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4695: invokestatic 417	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4698: aastore
    //   4699: dup
    //   4700: iconst_2
    //   4701: lload_2
    //   4702: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4705: aastore
    //   4706: dup
    //   4707: iconst_3
    //   4708: lload 30
    //   4710: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4713: aastore
    //   4714: invokestatic 330	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4717: lload 4
    //   4719: lconst_0
    //   4720: lcmp
    //   4721: ifne +120 -> 4841
    //   4724: lload_2
    //   4725: lconst_0
    //   4726: lcmp
    //   4727: ifle +114 -> 4841
    //   4730: ldc 83
    //   4732: ldc_w 451
    //   4735: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4738: aload 33
    //   4740: lload_2
    //   4741: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   4744: aload_0
    //   4745: lload_2
    //   4746: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   4749: lload_2
    //   4750: ldc2_w 392
    //   4753: lcmp
    //   4754: ifge +15 -> 4769
    //   4757: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4760: dup
    //   4761: aload_0
    //   4762: iconst_1
    //   4763: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4766: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   4769: aload 35
    //   4771: ifnull +8 -> 4779
    //   4774: aload 35
    //   4776: invokevirtual 217	java/io/InputStream:close	()V
    //   4779: aload 33
    //   4781: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   4784: aload 34
    //   4786: ifnull +16 -> 4802
    //   4789: aload 34
    //   4791: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4794: invokevirtual 217	java/io/InputStream:close	()V
    //   4797: aload 34
    //   4799: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   4802: aload_0
    //   4803: iconst_1
    //   4804: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4807: ldc 83
    //   4809: ldc_w 458
    //   4812: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4815: ldc_w 373
    //   4818: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4821: return
    //   4822: astore 36
    //   4824: ldc 83
    //   4826: aload 36
    //   4828: ldc_w 460
    //   4831: iconst_0
    //   4832: anewarray 4	java/lang/Object
    //   4835: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4838: goto -94 -> 4744
    //   4841: lload 4
    //   4843: lconst_0
    //   4844: lcmp
    //   4845: ifeq +47 -> 4892
    //   4848: lload_2
    //   4849: lload 4
    //   4851: lcmp
    //   4852: ifeq +40 -> 4892
    //   4855: ldc 83
    //   4857: ldc_w 462
    //   4860: iconst_2
    //   4861: anewarray 4	java/lang/Object
    //   4864: dup
    //   4865: iconst_0
    //   4866: lload 4
    //   4868: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4871: aastore
    //   4872: dup
    //   4873: iconst_1
    //   4874: lload_2
    //   4875: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4878: aastore
    //   4879: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4882: aload_0
    //   4883: lload_2
    //   4884: lload 4
    //   4886: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   4889: goto -120 -> 4769
    //   4892: lload 4
    //   4894: lconst_0
    //   4895: lcmp
    //   4896: ifeq +66 -> 4962
    //   4899: lload_2
    //   4900: lload 4
    //   4902: lcmp
    //   4903: ifne +59 -> 4962
    //   4906: ldc 83
    //   4908: ldc_w 466
    //   4911: iconst_2
    //   4912: anewarray 4	java/lang/Object
    //   4915: dup
    //   4916: iconst_0
    //   4917: lload 4
    //   4919: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4922: aastore
    //   4923: dup
    //   4924: iconst_1
    //   4925: lload_2
    //   4926: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4929: aastore
    //   4930: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4933: aload_0
    //   4934: lload 4
    //   4936: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   4939: lload_2
    //   4940: ldc2_w 392
    //   4943: lcmp
    //   4944: ifge -175 -> 4769
    //   4947: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4950: dup
    //   4951: aload_0
    //   4952: iconst_1
    //   4953: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4956: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   4959: goto -190 -> 4769
    //   4962: ldc 83
    //   4964: ldc_w 468
    //   4967: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4970: goto -201 -> 4769
    //   4973: astore 35
    //   4975: ldc 83
    //   4977: aload 35
    //   4979: ldc_w 614
    //   4982: iconst_0
    //   4983: anewarray 4	java/lang/Object
    //   4986: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4989: goto -210 -> 4779
    //   4992: astore 33
    //   4994: ldc 83
    //   4996: aload 33
    //   4998: ldc_w 460
    //   5001: iconst_0
    //   5002: anewarray 4	java/lang/Object
    //   5005: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5008: goto -224 -> 4784
    //   5011: astore 33
    //   5013: ldc 83
    //   5015: aload 33
    //   5017: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5020: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5023: goto -226 -> 4797
    //   5026: astore 36
    //   5028: ldc 83
    //   5030: aload 36
    //   5032: ldc_w 460
    //   5035: iconst_0
    //   5036: anewarray 4	java/lang/Object
    //   5039: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5042: goto -1241 -> 3801
    //   5045: lload 4
    //   5047: lconst_0
    //   5048: lcmp
    //   5049: ifeq +47 -> 5096
    //   5052: lload_2
    //   5053: lload 4
    //   5055: lcmp
    //   5056: ifeq +40 -> 5096
    //   5059: ldc 83
    //   5061: ldc_w 462
    //   5064: iconst_2
    //   5065: anewarray 4	java/lang/Object
    //   5068: dup
    //   5069: iconst_0
    //   5070: lload 4
    //   5072: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5075: aastore
    //   5076: dup
    //   5077: iconst_1
    //   5078: lload_2
    //   5079: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5082: aastore
    //   5083: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5086: aload_0
    //   5087: lload_2
    //   5088: lload 4
    //   5090: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   5093: goto -1267 -> 3826
    //   5096: lload 4
    //   5098: lconst_0
    //   5099: lcmp
    //   5100: ifeq +66 -> 5166
    //   5103: lload_2
    //   5104: lload 4
    //   5106: lcmp
    //   5107: ifne +59 -> 5166
    //   5110: ldc 83
    //   5112: ldc_w 466
    //   5115: iconst_2
    //   5116: anewarray 4	java/lang/Object
    //   5119: dup
    //   5120: iconst_0
    //   5121: lload 4
    //   5123: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5126: aastore
    //   5127: dup
    //   5128: iconst_1
    //   5129: lload_2
    //   5130: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5133: aastore
    //   5134: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5137: aload_0
    //   5138: lload 4
    //   5140: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   5143: lload_2
    //   5144: ldc2_w 392
    //   5147: lcmp
    //   5148: ifge -1322 -> 3826
    //   5151: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5154: dup
    //   5155: aload_0
    //   5156: iconst_1
    //   5157: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5160: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   5163: goto -1337 -> 3826
    //   5166: ldc 83
    //   5168: ldc_w 468
    //   5171: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5174: goto -1348 -> 3826
    //   5177: astore 35
    //   5179: ldc 83
    //   5181: aload 35
    //   5183: ldc_w 614
    //   5186: iconst_0
    //   5187: anewarray 4	java/lang/Object
    //   5190: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5193: goto -1357 -> 3836
    //   5196: astore 33
    //   5198: ldc 83
    //   5200: aload 33
    //   5202: ldc_w 460
    //   5205: iconst_0
    //   5206: anewarray 4	java/lang/Object
    //   5209: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5212: goto -1366 -> 3846
    //   5215: astore 33
    //   5217: ldc 83
    //   5219: aload 33
    //   5221: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5224: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5227: goto -1368 -> 3859
    //   5230: astore 35
    //   5232: ldc 83
    //   5234: aload 35
    //   5236: ldc_w 460
    //   5239: iconst_0
    //   5240: anewarray 4	java/lang/Object
    //   5243: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5246: goto -674 -> 4572
    //   5249: lload 4
    //   5251: lconst_0
    //   5252: lcmp
    //   5253: ifeq +47 -> 5300
    //   5256: lload_2
    //   5257: lload 4
    //   5259: lcmp
    //   5260: ifeq +40 -> 5300
    //   5263: ldc 83
    //   5265: ldc_w 462
    //   5268: iconst_2
    //   5269: anewarray 4	java/lang/Object
    //   5272: dup
    //   5273: iconst_0
    //   5274: lload 4
    //   5276: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5279: aastore
    //   5280: dup
    //   5281: iconst_1
    //   5282: lload_2
    //   5283: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5286: aastore
    //   5287: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5290: aload_0
    //   5291: lload_2
    //   5292: lload 4
    //   5294: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   5297: goto -700 -> 4597
    //   5300: lload 4
    //   5302: lconst_0
    //   5303: lcmp
    //   5304: ifeq +66 -> 5370
    //   5307: lload_2
    //   5308: lload 4
    //   5310: lcmp
    //   5311: ifne +59 -> 5370
    //   5314: ldc 83
    //   5316: ldc_w 466
    //   5319: iconst_2
    //   5320: anewarray 4	java/lang/Object
    //   5323: dup
    //   5324: iconst_0
    //   5325: lload 4
    //   5327: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5330: aastore
    //   5331: dup
    //   5332: iconst_1
    //   5333: lload_2
    //   5334: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5337: aastore
    //   5338: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5341: aload_0
    //   5342: lload 4
    //   5344: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   5347: lload_2
    //   5348: ldc2_w 392
    //   5351: lcmp
    //   5352: ifge -755 -> 4597
    //   5355: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5358: dup
    //   5359: aload_0
    //   5360: iconst_1
    //   5361: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5364: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   5367: goto -770 -> 4597
    //   5370: ldc 83
    //   5372: ldc_w 468
    //   5375: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5378: goto -781 -> 4597
    //   5381: astore 35
    //   5383: ldc 83
    //   5385: aload 35
    //   5387: ldc_w 614
    //   5390: iconst_0
    //   5391: anewarray 4	java/lang/Object
    //   5394: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5397: goto -790 -> 4607
    //   5400: astore 33
    //   5402: ldc 83
    //   5404: aload 33
    //   5406: ldc_w 460
    //   5409: iconst_0
    //   5410: anewarray 4	java/lang/Object
    //   5413: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5416: goto -799 -> 4617
    //   5419: astore 33
    //   5421: ldc 83
    //   5423: aload 33
    //   5425: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5428: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5431: goto -801 -> 4630
    //   5434: astore 38
    //   5436: aconst_null
    //   5437: astore 33
    //   5439: aconst_null
    //   5440: astore 34
    //   5442: aload 40
    //   5444: astore 39
    //   5446: aload 34
    //   5448: astore 37
    //   5450: lload 4
    //   5452: lstore 8
    //   5454: lload_2
    //   5455: lstore 6
    //   5457: aload 33
    //   5459: astore 36
    //   5461: aload 39
    //   5463: astore 35
    //   5465: ldc 83
    //   5467: aload 38
    //   5469: ldc_w 604
    //   5472: iconst_1
    //   5473: anewarray 4	java/lang/Object
    //   5476: dup
    //   5477: iconst_0
    //   5478: aload 43
    //   5480: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5483: aastore
    //   5484: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5487: aload 34
    //   5489: astore 37
    //   5491: lload 4
    //   5493: lstore 8
    //   5495: lload_2
    //   5496: lstore 6
    //   5498: aload 33
    //   5500: astore 36
    //   5502: aload 39
    //   5504: astore 35
    //   5506: aload_0
    //   5507: sipush 752
    //   5510: putfield 57	com/tencent/mm/plugin/music/c/b:cfE	I
    //   5513: aload 34
    //   5515: astore 37
    //   5517: lload 4
    //   5519: lstore 8
    //   5521: lload_2
    //   5522: lstore 6
    //   5524: aload 33
    //   5526: astore 36
    //   5528: aload 39
    //   5530: astore 35
    //   5532: aload_0
    //   5533: iconst_5
    //   5534: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   5537: lload 4
    //   5539: lconst_0
    //   5540: lcmp
    //   5541: ifne +125 -> 5666
    //   5544: lload_2
    //   5545: lconst_0
    //   5546: lcmp
    //   5547: ifle +119 -> 5666
    //   5550: ldc 83
    //   5552: ldc_w 451
    //   5555: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5558: aload 33
    //   5560: lload_2
    //   5561: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   5564: aload_0
    //   5565: lload_2
    //   5566: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   5569: lload_2
    //   5570: ldc2_w 392
    //   5573: lcmp
    //   5574: ifge +15 -> 5589
    //   5577: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5580: dup
    //   5581: aload_0
    //   5582: iconst_1
    //   5583: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5586: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   5589: aload 39
    //   5591: ifnull +8 -> 5599
    //   5594: aload 39
    //   5596: invokevirtual 217	java/io/InputStream:close	()V
    //   5599: aload 33
    //   5601: ifnull +8 -> 5609
    //   5604: aload 33
    //   5606: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   5609: aload 34
    //   5611: ifnull +16 -> 5627
    //   5614: aload 34
    //   5616: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5619: invokevirtual 217	java/io/InputStream:close	()V
    //   5622: aload 34
    //   5624: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   5627: aload_0
    //   5628: iconst_1
    //   5629: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5632: ldc 83
    //   5634: ldc_w 458
    //   5637: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5640: ldc_w 373
    //   5643: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5646: return
    //   5647: astore 35
    //   5649: ldc 83
    //   5651: aload 35
    //   5653: ldc_w 460
    //   5656: iconst_0
    //   5657: anewarray 4	java/lang/Object
    //   5660: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5663: goto -99 -> 5564
    //   5666: lload 4
    //   5668: lconst_0
    //   5669: lcmp
    //   5670: ifeq +47 -> 5717
    //   5673: lload_2
    //   5674: lload 4
    //   5676: lcmp
    //   5677: ifeq +40 -> 5717
    //   5680: ldc 83
    //   5682: ldc_w 462
    //   5685: iconst_2
    //   5686: anewarray 4	java/lang/Object
    //   5689: dup
    //   5690: iconst_0
    //   5691: lload 4
    //   5693: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5696: aastore
    //   5697: dup
    //   5698: iconst_1
    //   5699: lload_2
    //   5700: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5703: aastore
    //   5704: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5707: aload_0
    //   5708: lload_2
    //   5709: lload 4
    //   5711: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   5714: goto -125 -> 5589
    //   5717: lload 4
    //   5719: lconst_0
    //   5720: lcmp
    //   5721: ifeq +66 -> 5787
    //   5724: lload_2
    //   5725: lload 4
    //   5727: lcmp
    //   5728: ifne +59 -> 5787
    //   5731: ldc 83
    //   5733: ldc_w 466
    //   5736: iconst_2
    //   5737: anewarray 4	java/lang/Object
    //   5740: dup
    //   5741: iconst_0
    //   5742: lload 4
    //   5744: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5747: aastore
    //   5748: dup
    //   5749: iconst_1
    //   5750: lload_2
    //   5751: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5754: aastore
    //   5755: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5758: aload_0
    //   5759: lload 4
    //   5761: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   5764: lload_2
    //   5765: ldc2_w 392
    //   5768: lcmp
    //   5769: ifge -180 -> 5589
    //   5772: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5775: dup
    //   5776: aload_0
    //   5777: iconst_1
    //   5778: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5781: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   5784: goto -195 -> 5589
    //   5787: ldc 83
    //   5789: ldc_w 468
    //   5792: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5795: goto -206 -> 5589
    //   5798: astore 35
    //   5800: ldc 83
    //   5802: aload 35
    //   5804: ldc_w 614
    //   5807: iconst_0
    //   5808: anewarray 4	java/lang/Object
    //   5811: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5814: goto -215 -> 5599
    //   5817: astore 33
    //   5819: ldc 83
    //   5821: aload 33
    //   5823: ldc_w 460
    //   5826: iconst_0
    //   5827: anewarray 4	java/lang/Object
    //   5830: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5833: goto -224 -> 5609
    //   5836: astore 33
    //   5838: ldc 83
    //   5840: aload 33
    //   5842: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5845: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5848: goto -226 -> 5622
    //   5851: astore 38
    //   5853: aconst_null
    //   5854: astore 33
    //   5856: aconst_null
    //   5857: astore 34
    //   5859: aload 41
    //   5861: astore 39
    //   5863: aload 34
    //   5865: astore 37
    //   5867: lload 4
    //   5869: lstore 8
    //   5871: lload_2
    //   5872: lstore 6
    //   5874: aload 33
    //   5876: astore 36
    //   5878: aload 39
    //   5880: astore 35
    //   5882: ldc 83
    //   5884: aload 38
    //   5886: ldc_w 604
    //   5889: iconst_1
    //   5890: anewarray 4	java/lang/Object
    //   5893: dup
    //   5894: iconst_0
    //   5895: aload 43
    //   5897: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5900: aastore
    //   5901: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5904: aload 34
    //   5906: astore 37
    //   5908: lload 4
    //   5910: lstore 8
    //   5912: lload_2
    //   5913: lstore 6
    //   5915: aload 33
    //   5917: astore 36
    //   5919: aload 39
    //   5921: astore 35
    //   5923: aload_0
    //   5924: sipush 753
    //   5927: putfield 57	com/tencent/mm/plugin/music/c/b:cfE	I
    //   5930: aload 34
    //   5932: astore 37
    //   5934: lload 4
    //   5936: lstore 8
    //   5938: lload_2
    //   5939: lstore 6
    //   5941: aload 33
    //   5943: astore 36
    //   5945: aload 39
    //   5947: astore 35
    //   5949: aload_0
    //   5950: iconst_5
    //   5951: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   5954: lload 4
    //   5956: lconst_0
    //   5957: lcmp
    //   5958: ifne +125 -> 6083
    //   5961: lload_2
    //   5962: lconst_0
    //   5963: lcmp
    //   5964: ifle +119 -> 6083
    //   5967: ldc 83
    //   5969: ldc_w 451
    //   5972: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5975: aload 33
    //   5977: lload_2
    //   5978: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   5981: aload_0
    //   5982: lload_2
    //   5983: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   5986: lload_2
    //   5987: ldc2_w 392
    //   5990: lcmp
    //   5991: ifge +15 -> 6006
    //   5994: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5997: dup
    //   5998: aload_0
    //   5999: iconst_1
    //   6000: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6003: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   6006: aload 39
    //   6008: ifnull +8 -> 6016
    //   6011: aload 39
    //   6013: invokevirtual 217	java/io/InputStream:close	()V
    //   6016: aload 33
    //   6018: ifnull +8 -> 6026
    //   6021: aload 33
    //   6023: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   6026: aload 34
    //   6028: ifnull +16 -> 6044
    //   6031: aload 34
    //   6033: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6036: invokevirtual 217	java/io/InputStream:close	()V
    //   6039: aload 34
    //   6041: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   6044: aload_0
    //   6045: iconst_1
    //   6046: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6049: ldc 83
    //   6051: ldc_w 458
    //   6054: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6057: ldc_w 373
    //   6060: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6063: return
    //   6064: astore 35
    //   6066: ldc 83
    //   6068: aload 35
    //   6070: ldc_w 460
    //   6073: iconst_0
    //   6074: anewarray 4	java/lang/Object
    //   6077: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6080: goto -99 -> 5981
    //   6083: lload 4
    //   6085: lconst_0
    //   6086: lcmp
    //   6087: ifeq +47 -> 6134
    //   6090: lload_2
    //   6091: lload 4
    //   6093: lcmp
    //   6094: ifeq +40 -> 6134
    //   6097: ldc 83
    //   6099: ldc_w 462
    //   6102: iconst_2
    //   6103: anewarray 4	java/lang/Object
    //   6106: dup
    //   6107: iconst_0
    //   6108: lload 4
    //   6110: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6113: aastore
    //   6114: dup
    //   6115: iconst_1
    //   6116: lload_2
    //   6117: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6120: aastore
    //   6121: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6124: aload_0
    //   6125: lload_2
    //   6126: lload 4
    //   6128: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   6131: goto -125 -> 6006
    //   6134: lload 4
    //   6136: lconst_0
    //   6137: lcmp
    //   6138: ifeq +66 -> 6204
    //   6141: lload_2
    //   6142: lload 4
    //   6144: lcmp
    //   6145: ifne +59 -> 6204
    //   6148: ldc 83
    //   6150: ldc_w 466
    //   6153: iconst_2
    //   6154: anewarray 4	java/lang/Object
    //   6157: dup
    //   6158: iconst_0
    //   6159: lload 4
    //   6161: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6164: aastore
    //   6165: dup
    //   6166: iconst_1
    //   6167: lload_2
    //   6168: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6171: aastore
    //   6172: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6175: aload_0
    //   6176: lload 4
    //   6178: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   6181: lload_2
    //   6182: ldc2_w 392
    //   6185: lcmp
    //   6186: ifge -180 -> 6006
    //   6189: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6192: dup
    //   6193: aload_0
    //   6194: iconst_1
    //   6195: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6198: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   6201: goto -195 -> 6006
    //   6204: ldc 83
    //   6206: ldc_w 468
    //   6209: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6212: goto -206 -> 6006
    //   6215: astore 35
    //   6217: ldc 83
    //   6219: aload 35
    //   6221: ldc_w 614
    //   6224: iconst_0
    //   6225: anewarray 4	java/lang/Object
    //   6228: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6231: goto -215 -> 6016
    //   6234: astore 33
    //   6236: ldc 83
    //   6238: aload 33
    //   6240: ldc_w 460
    //   6243: iconst_0
    //   6244: anewarray 4	java/lang/Object
    //   6247: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6250: goto -224 -> 6026
    //   6253: astore 33
    //   6255: ldc 83
    //   6257: aload 33
    //   6259: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6262: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6265: goto -226 -> 6039
    //   6268: astore 38
    //   6270: aconst_null
    //   6271: astore 33
    //   6273: aconst_null
    //   6274: astore 34
    //   6276: aload 34
    //   6278: astore 37
    //   6280: lload 4
    //   6282: lstore 8
    //   6284: lload_2
    //   6285: lstore 6
    //   6287: aload 33
    //   6289: astore 36
    //   6291: aload 39
    //   6293: astore 35
    //   6295: ldc 83
    //   6297: aload 38
    //   6299: ldc_w 604
    //   6302: iconst_1
    //   6303: anewarray 4	java/lang/Object
    //   6306: dup
    //   6307: iconst_0
    //   6308: aload 43
    //   6310: invokevirtual 441	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6313: aastore
    //   6314: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6317: aload 34
    //   6319: astore 37
    //   6321: lload 4
    //   6323: lstore 8
    //   6325: lload_2
    //   6326: lstore 6
    //   6328: aload 33
    //   6330: astore 36
    //   6332: aload 39
    //   6334: astore 35
    //   6336: aload_0
    //   6337: sipush 754
    //   6340: putfield 57	com/tencent/mm/plugin/music/c/b:cfE	I
    //   6343: aload 34
    //   6345: astore 37
    //   6347: lload 4
    //   6349: lstore 8
    //   6351: lload_2
    //   6352: lstore 6
    //   6354: aload 33
    //   6356: astore 36
    //   6358: aload 39
    //   6360: astore 35
    //   6362: aload_0
    //   6363: iconst_5
    //   6364: invokespecial 436	com/tencent/mm/plugin/music/c/b:Ac	(I)V
    //   6367: lload 4
    //   6369: lconst_0
    //   6370: lcmp
    //   6371: ifne +125 -> 6496
    //   6374: lload_2
    //   6375: lconst_0
    //   6376: lcmp
    //   6377: ifle +119 -> 6496
    //   6380: ldc 83
    //   6382: ldc_w 451
    //   6385: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6388: aload 33
    //   6390: lload_2
    //   6391: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   6394: aload_0
    //   6395: lload_2
    //   6396: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   6399: lload_2
    //   6400: ldc2_w 392
    //   6403: lcmp
    //   6404: ifge +15 -> 6419
    //   6407: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6410: dup
    //   6411: aload_0
    //   6412: iconst_1
    //   6413: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6416: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   6419: aload 39
    //   6421: ifnull +8 -> 6429
    //   6424: aload 39
    //   6426: invokevirtual 217	java/io/InputStream:close	()V
    //   6429: aload 33
    //   6431: ifnull +8 -> 6439
    //   6434: aload 33
    //   6436: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   6439: aload 34
    //   6441: ifnull +16 -> 6457
    //   6444: aload 34
    //   6446: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6449: invokevirtual 217	java/io/InputStream:close	()V
    //   6452: aload 34
    //   6454: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   6457: aload_0
    //   6458: iconst_1
    //   6459: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6462: ldc 83
    //   6464: ldc_w 458
    //   6467: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6470: ldc_w 373
    //   6473: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6476: return
    //   6477: astore 35
    //   6479: ldc 83
    //   6481: aload 35
    //   6483: ldc_w 460
    //   6486: iconst_0
    //   6487: anewarray 4	java/lang/Object
    //   6490: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6493: goto -99 -> 6394
    //   6496: lload 4
    //   6498: lconst_0
    //   6499: lcmp
    //   6500: ifeq +47 -> 6547
    //   6503: lload_2
    //   6504: lload 4
    //   6506: lcmp
    //   6507: ifeq +40 -> 6547
    //   6510: ldc 83
    //   6512: ldc_w 462
    //   6515: iconst_2
    //   6516: anewarray 4	java/lang/Object
    //   6519: dup
    //   6520: iconst_0
    //   6521: lload 4
    //   6523: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6526: aastore
    //   6527: dup
    //   6528: iconst_1
    //   6529: lload_2
    //   6530: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6533: aastore
    //   6534: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6537: aload_0
    //   6538: lload_2
    //   6539: lload 4
    //   6541: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   6544: goto -125 -> 6419
    //   6547: lload 4
    //   6549: lconst_0
    //   6550: lcmp
    //   6551: ifeq +66 -> 6617
    //   6554: lload_2
    //   6555: lload 4
    //   6557: lcmp
    //   6558: ifne +59 -> 6617
    //   6561: ldc 83
    //   6563: ldc_w 466
    //   6566: iconst_2
    //   6567: anewarray 4	java/lang/Object
    //   6570: dup
    //   6571: iconst_0
    //   6572: lload 4
    //   6574: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6577: aastore
    //   6578: dup
    //   6579: iconst_1
    //   6580: lload_2
    //   6581: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6584: aastore
    //   6585: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6588: aload_0
    //   6589: lload 4
    //   6591: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   6594: lload_2
    //   6595: ldc2_w 392
    //   6598: lcmp
    //   6599: ifge -180 -> 6419
    //   6602: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6605: dup
    //   6606: aload_0
    //   6607: iconst_1
    //   6608: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6611: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   6614: goto -195 -> 6419
    //   6617: ldc 83
    //   6619: ldc_w 468
    //   6622: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6625: goto -206 -> 6419
    //   6628: astore 35
    //   6630: ldc 83
    //   6632: aload 35
    //   6634: ldc_w 614
    //   6637: iconst_0
    //   6638: anewarray 4	java/lang/Object
    //   6641: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6644: goto -215 -> 6429
    //   6647: astore 33
    //   6649: ldc 83
    //   6651: aload 33
    //   6653: ldc_w 460
    //   6656: iconst_0
    //   6657: anewarray 4	java/lang/Object
    //   6660: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6663: goto -224 -> 6439
    //   6666: astore 33
    //   6668: ldc 83
    //   6670: aload 33
    //   6672: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6675: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6678: goto -226 -> 6452
    //   6681: astore 38
    //   6683: aconst_null
    //   6684: astore 33
    //   6686: aconst_null
    //   6687: astore 34
    //   6689: lload 4
    //   6691: lconst_0
    //   6692: lcmp
    //   6693: ifne +127 -> 6820
    //   6696: lload_2
    //   6697: lconst_0
    //   6698: lcmp
    //   6699: ifle +121 -> 6820
    //   6702: ldc 83
    //   6704: ldc_w 451
    //   6707: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6710: aload 33
    //   6712: lload_2
    //   6713: invokevirtual 546	java/io/RandomAccessFile:setLength	(J)V
    //   6716: aload_0
    //   6717: lload_2
    //   6718: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   6721: lload_2
    //   6722: ldc2_w 392
    //   6725: lcmp
    //   6726: ifge +15 -> 6741
    //   6729: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6732: dup
    //   6733: aload_0
    //   6734: iconst_1
    //   6735: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6738: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   6741: aload 35
    //   6743: ifnull +8 -> 6751
    //   6746: aload 35
    //   6748: invokevirtual 217	java/io/InputStream:close	()V
    //   6751: aload 33
    //   6753: ifnull +8 -> 6761
    //   6756: aload 33
    //   6758: invokevirtual 547	java/io/RandomAccessFile:close	()V
    //   6761: aload 34
    //   6763: ifnull +16 -> 6779
    //   6766: aload 34
    //   6768: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6771: invokevirtual 217	java/io/InputStream:close	()V
    //   6774: aload 34
    //   6776: invokevirtual 220	java/net/HttpURLConnection:disconnect	()V
    //   6779: aload_0
    //   6780: iconst_1
    //   6781: putfield 49	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6784: ldc 83
    //   6786: ldc_w 458
    //   6789: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6792: ldc_w 373
    //   6795: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6798: aload 38
    //   6800: athrow
    //   6801: astore 36
    //   6803: ldc 83
    //   6805: aload 36
    //   6807: ldc_w 460
    //   6810: iconst_0
    //   6811: anewarray 4	java/lang/Object
    //   6814: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6817: goto -101 -> 6716
    //   6820: lload 4
    //   6822: lconst_0
    //   6823: lcmp
    //   6824: ifeq +47 -> 6871
    //   6827: lload_2
    //   6828: lload 4
    //   6830: lcmp
    //   6831: ifeq +40 -> 6871
    //   6834: ldc 83
    //   6836: ldc_w 462
    //   6839: iconst_2
    //   6840: anewarray 4	java/lang/Object
    //   6843: dup
    //   6844: iconst_0
    //   6845: lload 4
    //   6847: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6850: aastore
    //   6851: dup
    //   6852: iconst_1
    //   6853: lload_2
    //   6854: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6857: aastore
    //   6858: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6861: aload_0
    //   6862: lload_2
    //   6863: lload 4
    //   6865: invokespecial 464	com/tencent/mm/plugin/music/c/b:R	(JJ)V
    //   6868: goto -127 -> 6741
    //   6871: lload 4
    //   6873: lconst_0
    //   6874: lcmp
    //   6875: ifeq +66 -> 6941
    //   6878: lload_2
    //   6879: lload 4
    //   6881: lcmp
    //   6882: ifne +59 -> 6941
    //   6885: ldc 83
    //   6887: ldc_w 466
    //   6890: iconst_2
    //   6891: anewarray 4	java/lang/Object
    //   6894: dup
    //   6895: iconst_0
    //   6896: lload 4
    //   6898: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6901: aastore
    //   6902: dup
    //   6903: iconst_1
    //   6904: lload_2
    //   6905: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6908: aastore
    //   6909: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6912: aload_0
    //   6913: lload 4
    //   6915: invokespecial 456	com/tencent/mm/plugin/music/c/b:kJ	(J)V
    //   6918: lload_2
    //   6919: ldc2_w 392
    //   6922: lcmp
    //   6923: ifge -182 -> 6741
    //   6926: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6929: dup
    //   6930: aload_0
    //   6931: iconst_1
    //   6932: invokespecial 131	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6935: invokestatic 137	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   6938: goto -197 -> 6741
    //   6941: ldc 83
    //   6943: ldc_w 468
    //   6946: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6949: goto -208 -> 6741
    //   6952: astore 35
    //   6954: ldc 83
    //   6956: aload 35
    //   6958: ldc_w 614
    //   6961: iconst_0
    //   6962: anewarray 4	java/lang/Object
    //   6965: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6968: goto -217 -> 6751
    //   6971: astore 33
    //   6973: ldc 83
    //   6975: aload 33
    //   6977: ldc_w 460
    //   6980: iconst_0
    //   6981: anewarray 4	java/lang/Object
    //   6984: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6987: goto -226 -> 6761
    //   6990: astore 33
    //   6992: ldc 83
    //   6994: aload 33
    //   6996: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6999: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7002: goto -228 -> 6774
    //   7005: astore 38
    //   7007: aconst_null
    //   7008: astore 34
    //   7010: goto -321 -> 6689
    //   7013: astore 38
    //   7015: aload 37
    //   7017: astore 34
    //   7019: lload 8
    //   7021: lstore 4
    //   7023: lload 6
    //   7025: lstore_2
    //   7026: aload 36
    //   7028: astore 33
    //   7030: goto -341 -> 6689
    //   7033: astore 38
    //   7035: lload 12
    //   7037: lstore_2
    //   7038: goto -349 -> 6689
    //   7041: astore 38
    //   7043: goto -354 -> 6689
    //   7046: astore 38
    //   7048: aconst_null
    //   7049: astore 34
    //   7051: goto -775 -> 6276
    //   7054: astore 38
    //   7056: lload 26
    //   7058: lstore 4
    //   7060: lload 18
    //   7062: lstore_2
    //   7063: goto -787 -> 6276
    //   7066: astore 38
    //   7068: lload 14
    //   7070: lstore_2
    //   7071: aload 35
    //   7073: astore 39
    //   7075: goto -799 -> 6276
    //   7078: astore 38
    //   7080: aconst_null
    //   7081: astore 34
    //   7083: aload 41
    //   7085: astore 39
    //   7087: goto -1224 -> 5863
    //   7090: astore 38
    //   7092: lload 20
    //   7094: lstore 4
    //   7096: lload 14
    //   7098: lstore_2
    //   7099: aload 41
    //   7101: astore 39
    //   7103: goto -1240 -> 5863
    //   7106: astore 38
    //   7108: lload 8
    //   7110: lstore_2
    //   7111: aload 35
    //   7113: astore 39
    //   7115: goto -1252 -> 5863
    //   7118: astore 38
    //   7120: aconst_null
    //   7121: astore 34
    //   7123: aload 40
    //   7125: astore 39
    //   7127: goto -1681 -> 5446
    //   7130: astore 38
    //   7132: lload 22
    //   7134: lstore 4
    //   7136: lload 12
    //   7138: lstore_2
    //   7139: aload 40
    //   7141: astore 39
    //   7143: goto -1697 -> 5446
    //   7146: astore 38
    //   7148: lload 10
    //   7150: lstore_2
    //   7151: aload 35
    //   7153: astore 39
    //   7155: goto -1709 -> 5446
    //   7158: astore 38
    //   7160: aconst_null
    //   7161: astore 33
    //   7163: aconst_null
    //   7164: astore 34
    //   7166: aload 42
    //   7168: astore 39
    //   7170: goto -2716 -> 4454
    //   7173: astore 38
    //   7175: aconst_null
    //   7176: astore 34
    //   7178: aload 42
    //   7180: astore 39
    //   7182: goto -2728 -> 4454
    //   7185: astore 38
    //   7187: lload 24
    //   7189: lstore 4
    //   7191: lload 16
    //   7193: lstore_2
    //   7194: aload 42
    //   7196: astore 39
    //   7198: goto -2744 -> 4454
    //   7201: astore 36
    //   7203: aconst_null
    //   7204: astore 35
    //   7206: aconst_null
    //   7207: astore 34
    //   7209: aload 37
    //   7211: astore 33
    //   7213: goto -3473 -> 3740
    //   7216: astore 36
    //   7218: aconst_null
    //   7219: astore 35
    //   7221: aconst_null
    //   7222: astore 34
    //   7224: goto -3484 -> 3740
    //   7227: lload 30
    //   7229: lstore 6
    //   7231: lload 4
    //   7233: lstore_2
    //   7234: lload 6
    //   7236: lstore 4
    //   7238: ldc2_w 615
    //   7241: lstore 30
    //   7243: lload 4
    //   7245: lconst_0
    //   7246: lcmp
    //   7247: ifeq -4095 -> 3152
    //   7250: lload 4
    //   7252: lstore 30
    //   7254: goto -4102 -> 3152
    //   7257: astore 36
    //   7259: aconst_null
    //   7260: astore 35
    //   7262: lload 28
    //   7264: lstore 4
    //   7266: lload 10
    //   7268: lstore_2
    //   7269: goto -3529 -> 3740
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7272	0	this	b
    //   180	4505	1	i	int
    //   167	7102	2	l1	long
    //   134	7131	4	l2	long
    //   125	7110	6	l3	long
    //   235	6874	8	l4	long
    //   1448	5819	10	l5	long
    //   1434	5703	12	l6	long
    //   1427	5670	14	l7	long
    //   1441	5751	16	l8	long
    //   1420	5641	18	l9	long
    //   1424	5669	20	l10	long
    //   1431	5702	22	l11	long
    //   1438	5750	24	l12	long
    //   1417	5640	26	l13	long
    //   1445	5818	28	l14	long
    //   2989	4264	30	l15	long
    //   32	1261	32	bool	boolean
    //   21	537	33	localObject1	Object
    //   811	5	33	localIOException1	java.io.IOException
    //   1013	5	33	localIOException2	java.io.IOException
    //   1176	596	33	localRandomAccessFile	java.io.RandomAccessFile
    //   1965	5	33	localIOException3	java.io.IOException
    //   1984	2156	33	localException1	Exception
    //   4333	5	33	localIOException4	java.io.IOException
    //   4352	428	33	localException2	Exception
    //   4992	5	33	localIOException5	java.io.IOException
    //   5011	5	33	localException3	Exception
    //   5196	5	33	localIOException6	java.io.IOException
    //   5215	5	33	localException4	Exception
    //   5400	5	33	localIOException7	java.io.IOException
    //   5419	5	33	localException5	Exception
    //   5437	168	33	localObject2	Object
    //   5817	5	33	localIOException8	java.io.IOException
    //   5836	5	33	localException6	Exception
    //   5854	168	33	localObject3	Object
    //   6234	5	33	localIOException9	java.io.IOException
    //   6253	5	33	localException7	Exception
    //   6271	164	33	localObject4	Object
    //   6647	5	33	localIOException10	java.io.IOException
    //   6666	5	33	localException8	Exception
    //   6684	73	33	localObject5	Object
    //   6971	5	33	localIOException11	java.io.IOException
    //   6990	5	33	localException9	Exception
    //   7028	184	33	localObject6	Object
    //   24	7199	34	localObject7	Object
    //   50	1628	35	localObject8	Object
    //   1814	5	35	localIOException12	java.io.IOException
    //   2016	2029	35	localObject9	Object
    //   4182	266	35	localIOException13	java.io.IOException
    //   4471	304	35	localObject10	Object
    //   4973	5	35	localIOException14	java.io.IOException
    //   5177	5	35	localIOException15	java.io.IOException
    //   5230	5	35	localIOException16	java.io.IOException
    //   5381	5	35	localIOException17	java.io.IOException
    //   5463	68	35	localObject11	Object
    //   5647	5	35	localIOException18	java.io.IOException
    //   5798	5	35	localIOException19	java.io.IOException
    //   5880	68	35	localObject12	Object
    //   6064	5	35	localIOException20	java.io.IOException
    //   6215	5	35	localIOException21	java.io.IOException
    //   6293	68	35	localObject13	Object
    //   6477	5	35	localIOException22	java.io.IOException
    //   6628	119	35	localIOException23	java.io.IOException
    //   6952	200	35	localIOException24	java.io.IOException
    //   7204	57	35	localObject14	Object
    //   1204	2316	36	localObject15	Object
    //   3735	8	36	localProtocolException1	java.net.ProtocolException
    //   3897	638	36	localException10	Exception
    //   4822	5	36	localIOException25	java.io.IOException
    //   5026	5	36	localIOException26	java.io.IOException
    //   5459	898	36	localObject16	Object
    //   6801	226	36	localIOException27	java.io.IOException
    //   7201	1	36	localProtocolException2	java.net.ProtocolException
    //   7216	1	36	localProtocolException3	java.net.ProtocolException
    //   7257	1	36	localProtocolException4	java.net.ProtocolException
    //   898	6312	37	localObject17	Object
    //   892	3151	38	localInputStream	InputStream
    //   4445	31	38	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   5434	34	38	localUnknownServiceException1	java.net.UnknownServiceException
    //   5851	34	38	localIOException28	java.io.IOException
    //   6268	30	38	localException11	Exception
    //   6681	118	38	localObject18	Object
    //   7005	1	38	localObject19	Object
    //   7013	1	38	localObject20	Object
    //   7033	1	38	localObject21	Object
    //   7041	1	38	localObject22	Object
    //   7046	1	38	localException12	Exception
    //   7054	1	38	localException13	Exception
    //   7066	1	38	localException14	Exception
    //   7078	1	38	localIOException29	java.io.IOException
    //   7090	1	38	localIOException30	java.io.IOException
    //   7106	1	38	localIOException31	java.io.IOException
    //   7118	1	38	localUnknownServiceException2	java.net.UnknownServiceException
    //   7130	1	38	localUnknownServiceException3	java.net.UnknownServiceException
    //   7146	1	38	localUnknownServiceException4	java.net.UnknownServiceException
    //   7158	1	38	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   7173	1	38	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   7185	1	38	localNoRouteToHostException4	java.net.NoRouteToHostException
    //   886	6311	39	localObject23	Object
    //   880	6260	40	localObject24	Object
    //   883	6217	41	localObject25	Object
    //   895	6300	42	localObject26	Object
    //   232	6077	43	localFile	java.io.File
    //   2214	2154	44	localObject27	Object
    //   2604	453	45	str	String
    // Exception table:
    //   from	to	target	type
    //   248	271	811	java/io/IOException
    //   960	968	1013	java/io/IOException
    //   1740	1746	1814	java/io/IOException
    //   1771	1776	1965	java/io/IOException
    //   1781	1789	1984	java/lang/Exception
    //   3437	3444	3735	java/net/ProtocolException
    //   3462	3469	3735	java/net/ProtocolException
    //   3487	3495	3735	java/net/ProtocolException
    //   3517	3526	3735	java/net/ProtocolException
    //   3556	3584	3735	java/net/ProtocolException
    //   3608	3615	3735	java/net/ProtocolException
    //   3639	3648	3735	java/net/ProtocolException
    //   3672	3681	3735	java/net/ProtocolException
    //   3717	3729	3735	java/net/ProtocolException
    //   4400	4409	3735	java/net/ProtocolException
    //   4433	4442	3735	java/net/ProtocolException
    //   4673	4717	3735	java/net/ProtocolException
    //   4108	4114	4182	java/io/IOException
    //   4139	4144	4333	java/io/IOException
    //   4149	4157	4352	java/lang/Exception
    //   3437	3444	4445	java/net/NoRouteToHostException
    //   3462	3469	4445	java/net/NoRouteToHostException
    //   3487	3495	4445	java/net/NoRouteToHostException
    //   3517	3526	4445	java/net/NoRouteToHostException
    //   3556	3584	4445	java/net/NoRouteToHostException
    //   3608	3615	4445	java/net/NoRouteToHostException
    //   3639	3648	4445	java/net/NoRouteToHostException
    //   3672	3681	4445	java/net/NoRouteToHostException
    //   3717	3729	4445	java/net/NoRouteToHostException
    //   4400	4409	4445	java/net/NoRouteToHostException
    //   4433	4442	4445	java/net/NoRouteToHostException
    //   4673	4717	4445	java/net/NoRouteToHostException
    //   4738	4744	4822	java/io/IOException
    //   4774	4779	4973	java/io/IOException
    //   4779	4784	4992	java/io/IOException
    //   4789	4797	5011	java/lang/Exception
    //   3795	3801	5026	java/io/IOException
    //   3831	3836	5177	java/io/IOException
    //   3841	3846	5196	java/io/IOException
    //   3851	3859	5215	java/lang/Exception
    //   4566	4572	5230	java/io/IOException
    //   4602	4607	5381	java/io/IOException
    //   4612	4617	5400	java/io/IOException
    //   4622	4630	5419	java/lang/Exception
    //   900	939	5434	java/net/UnknownServiceException
    //   1164	1178	5434	java/net/UnknownServiceException
    //   5558	5564	5647	java/io/IOException
    //   5594	5599	5798	java/io/IOException
    //   5604	5609	5817	java/io/IOException
    //   5614	5622	5836	java/lang/Exception
    //   900	939	5851	java/io/IOException
    //   1164	1178	5851	java/io/IOException
    //   5975	5981	6064	java/io/IOException
    //   6011	6016	6215	java/io/IOException
    //   6021	6026	6234	java/io/IOException
    //   6031	6039	6253	java/lang/Exception
    //   900	939	6268	java/lang/Exception
    //   1164	1178	6268	java/lang/Exception
    //   6388	6394	6477	java/io/IOException
    //   6424	6429	6628	java/io/IOException
    //   6434	6439	6647	java/io/IOException
    //   6444	6452	6666	java/lang/Exception
    //   900	939	6681	finally
    //   1164	1178	6681	finally
    //   6710	6716	6801	java/io/IOException
    //   6746	6751	6952	java/io/IOException
    //   6756	6761	6971	java/io/IOException
    //   6766	6774	6990	java/lang/Exception
    //   1178	1220	7005	finally
    //   1227	1292	7005	finally
    //   1297	1305	7005	finally
    //   1305	1341	7005	finally
    //   1341	1396	7005	finally
    //   1450	1456	7013	finally
    //   1524	1528	7013	finally
    //   1582	1601	7013	finally
    //   1655	1660	7013	finally
    //   1714	1719	7013	finally
    //   2053	2072	7013	finally
    //   2126	2155	7013	finally
    //   2209	2216	7013	finally
    //   2270	2287	7013	finally
    //   2341	2347	7013	finally
    //   2401	2411	7013	finally
    //   2465	2478	7013	finally
    //   2532	2543	7013	finally
    //   2597	2606	7013	finally
    //   2660	2666	7013	finally
    //   2720	2726	7013	finally
    //   2780	2798	7013	finally
    //   2852	2862	7013	finally
    //   2916	2923	7013	finally
    //   2977	2991	7013	finally
    //   3045	3070	7013	finally
    //   3129	3137	7013	finally
    //   3206	3233	7013	finally
    //   3287	3294	7013	finally
    //   3348	3354	7013	finally
    //   3408	3415	7013	finally
    //   3938	3947	7013	finally
    //   4019	4027	7013	finally
    //   4081	4087	7013	finally
    //   4473	4495	7013	finally
    //   4514	4521	7013	finally
    //   4540	4545	7013	finally
    //   5465	5487	7013	finally
    //   5506	5513	7013	finally
    //   5532	5537	7013	finally
    //   5882	5904	7013	finally
    //   5923	5930	7013	finally
    //   5949	5954	7013	finally
    //   6295	6317	7013	finally
    //   6336	6343	7013	finally
    //   6362	6367	7013	finally
    //   3437	3444	7033	finally
    //   3462	3469	7033	finally
    //   3487	3495	7033	finally
    //   3517	3526	7033	finally
    //   3556	3584	7033	finally
    //   3608	3615	7033	finally
    //   3639	3648	7033	finally
    //   3672	3681	7033	finally
    //   3717	3729	7033	finally
    //   4400	4409	7033	finally
    //   4433	4442	7033	finally
    //   4673	4717	7033	finally
    //   3740	3774	7041	finally
    //   1178	1220	7046	java/lang/Exception
    //   1227	1292	7046	java/lang/Exception
    //   1297	1305	7046	java/lang/Exception
    //   1305	1341	7046	java/lang/Exception
    //   1341	1396	7046	java/lang/Exception
    //   1450	1456	7054	java/lang/Exception
    //   1524	1528	7054	java/lang/Exception
    //   1582	1601	7054	java/lang/Exception
    //   1655	1660	7054	java/lang/Exception
    //   1714	1719	7054	java/lang/Exception
    //   2053	2072	7054	java/lang/Exception
    //   2126	2155	7054	java/lang/Exception
    //   2209	2216	7054	java/lang/Exception
    //   2270	2287	7054	java/lang/Exception
    //   2341	2347	7054	java/lang/Exception
    //   2401	2411	7054	java/lang/Exception
    //   2465	2478	7054	java/lang/Exception
    //   2532	2543	7054	java/lang/Exception
    //   2597	2606	7054	java/lang/Exception
    //   2660	2666	7054	java/lang/Exception
    //   2720	2726	7054	java/lang/Exception
    //   2780	2798	7054	java/lang/Exception
    //   2852	2862	7054	java/lang/Exception
    //   2916	2923	7054	java/lang/Exception
    //   2977	2991	7054	java/lang/Exception
    //   3045	3070	7054	java/lang/Exception
    //   3129	3137	7054	java/lang/Exception
    //   3206	3233	7054	java/lang/Exception
    //   3287	3294	7054	java/lang/Exception
    //   3348	3354	7054	java/lang/Exception
    //   3408	3415	7054	java/lang/Exception
    //   3938	3947	7054	java/lang/Exception
    //   4019	4027	7054	java/lang/Exception
    //   4081	4087	7054	java/lang/Exception
    //   3437	3444	7066	java/lang/Exception
    //   3462	3469	7066	java/lang/Exception
    //   3487	3495	7066	java/lang/Exception
    //   3517	3526	7066	java/lang/Exception
    //   3556	3584	7066	java/lang/Exception
    //   3608	3615	7066	java/lang/Exception
    //   3639	3648	7066	java/lang/Exception
    //   3672	3681	7066	java/lang/Exception
    //   3717	3729	7066	java/lang/Exception
    //   4400	4409	7066	java/lang/Exception
    //   4433	4442	7066	java/lang/Exception
    //   4673	4717	7066	java/lang/Exception
    //   1178	1220	7078	java/io/IOException
    //   1227	1292	7078	java/io/IOException
    //   1297	1305	7078	java/io/IOException
    //   1305	1341	7078	java/io/IOException
    //   1341	1396	7078	java/io/IOException
    //   1450	1456	7090	java/io/IOException
    //   1524	1528	7090	java/io/IOException
    //   1582	1601	7090	java/io/IOException
    //   1655	1660	7090	java/io/IOException
    //   1714	1719	7090	java/io/IOException
    //   2053	2072	7090	java/io/IOException
    //   2126	2155	7090	java/io/IOException
    //   2209	2216	7090	java/io/IOException
    //   2270	2287	7090	java/io/IOException
    //   2341	2347	7090	java/io/IOException
    //   2401	2411	7090	java/io/IOException
    //   2465	2478	7090	java/io/IOException
    //   2532	2543	7090	java/io/IOException
    //   2597	2606	7090	java/io/IOException
    //   2660	2666	7090	java/io/IOException
    //   2720	2726	7090	java/io/IOException
    //   2780	2798	7090	java/io/IOException
    //   2852	2862	7090	java/io/IOException
    //   2916	2923	7090	java/io/IOException
    //   2977	2991	7090	java/io/IOException
    //   3045	3070	7090	java/io/IOException
    //   3129	3137	7090	java/io/IOException
    //   3206	3233	7090	java/io/IOException
    //   3287	3294	7090	java/io/IOException
    //   3348	3354	7090	java/io/IOException
    //   3408	3415	7090	java/io/IOException
    //   3938	3947	7090	java/io/IOException
    //   4019	4027	7090	java/io/IOException
    //   4081	4087	7090	java/io/IOException
    //   3437	3444	7106	java/io/IOException
    //   3462	3469	7106	java/io/IOException
    //   3487	3495	7106	java/io/IOException
    //   3517	3526	7106	java/io/IOException
    //   3556	3584	7106	java/io/IOException
    //   3608	3615	7106	java/io/IOException
    //   3639	3648	7106	java/io/IOException
    //   3672	3681	7106	java/io/IOException
    //   3717	3729	7106	java/io/IOException
    //   4400	4409	7106	java/io/IOException
    //   4433	4442	7106	java/io/IOException
    //   4673	4717	7106	java/io/IOException
    //   1178	1220	7118	java/net/UnknownServiceException
    //   1227	1292	7118	java/net/UnknownServiceException
    //   1297	1305	7118	java/net/UnknownServiceException
    //   1305	1341	7118	java/net/UnknownServiceException
    //   1341	1396	7118	java/net/UnknownServiceException
    //   1450	1456	7130	java/net/UnknownServiceException
    //   1524	1528	7130	java/net/UnknownServiceException
    //   1582	1601	7130	java/net/UnknownServiceException
    //   1655	1660	7130	java/net/UnknownServiceException
    //   1714	1719	7130	java/net/UnknownServiceException
    //   2053	2072	7130	java/net/UnknownServiceException
    //   2126	2155	7130	java/net/UnknownServiceException
    //   2209	2216	7130	java/net/UnknownServiceException
    //   2270	2287	7130	java/net/UnknownServiceException
    //   2341	2347	7130	java/net/UnknownServiceException
    //   2401	2411	7130	java/net/UnknownServiceException
    //   2465	2478	7130	java/net/UnknownServiceException
    //   2532	2543	7130	java/net/UnknownServiceException
    //   2597	2606	7130	java/net/UnknownServiceException
    //   2660	2666	7130	java/net/UnknownServiceException
    //   2720	2726	7130	java/net/UnknownServiceException
    //   2780	2798	7130	java/net/UnknownServiceException
    //   2852	2862	7130	java/net/UnknownServiceException
    //   2916	2923	7130	java/net/UnknownServiceException
    //   2977	2991	7130	java/net/UnknownServiceException
    //   3045	3070	7130	java/net/UnknownServiceException
    //   3129	3137	7130	java/net/UnknownServiceException
    //   3206	3233	7130	java/net/UnknownServiceException
    //   3287	3294	7130	java/net/UnknownServiceException
    //   3348	3354	7130	java/net/UnknownServiceException
    //   3408	3415	7130	java/net/UnknownServiceException
    //   3938	3947	7130	java/net/UnknownServiceException
    //   4019	4027	7130	java/net/UnknownServiceException
    //   4081	4087	7130	java/net/UnknownServiceException
    //   3437	3444	7146	java/net/UnknownServiceException
    //   3462	3469	7146	java/net/UnknownServiceException
    //   3487	3495	7146	java/net/UnknownServiceException
    //   3517	3526	7146	java/net/UnknownServiceException
    //   3556	3584	7146	java/net/UnknownServiceException
    //   3608	3615	7146	java/net/UnknownServiceException
    //   3639	3648	7146	java/net/UnknownServiceException
    //   3672	3681	7146	java/net/UnknownServiceException
    //   3717	3729	7146	java/net/UnknownServiceException
    //   4400	4409	7146	java/net/UnknownServiceException
    //   4433	4442	7146	java/net/UnknownServiceException
    //   4673	4717	7146	java/net/UnknownServiceException
    //   900	939	7158	java/net/NoRouteToHostException
    //   1164	1178	7158	java/net/NoRouteToHostException
    //   1178	1220	7173	java/net/NoRouteToHostException
    //   1227	1292	7173	java/net/NoRouteToHostException
    //   1297	1305	7173	java/net/NoRouteToHostException
    //   1305	1341	7173	java/net/NoRouteToHostException
    //   1341	1396	7173	java/net/NoRouteToHostException
    //   1450	1456	7185	java/net/NoRouteToHostException
    //   1524	1528	7185	java/net/NoRouteToHostException
    //   1582	1601	7185	java/net/NoRouteToHostException
    //   1655	1660	7185	java/net/NoRouteToHostException
    //   1714	1719	7185	java/net/NoRouteToHostException
    //   2053	2072	7185	java/net/NoRouteToHostException
    //   2126	2155	7185	java/net/NoRouteToHostException
    //   2209	2216	7185	java/net/NoRouteToHostException
    //   2270	2287	7185	java/net/NoRouteToHostException
    //   2341	2347	7185	java/net/NoRouteToHostException
    //   2401	2411	7185	java/net/NoRouteToHostException
    //   2465	2478	7185	java/net/NoRouteToHostException
    //   2532	2543	7185	java/net/NoRouteToHostException
    //   2597	2606	7185	java/net/NoRouteToHostException
    //   2660	2666	7185	java/net/NoRouteToHostException
    //   2720	2726	7185	java/net/NoRouteToHostException
    //   2780	2798	7185	java/net/NoRouteToHostException
    //   2852	2862	7185	java/net/NoRouteToHostException
    //   2916	2923	7185	java/net/NoRouteToHostException
    //   2977	2991	7185	java/net/NoRouteToHostException
    //   3045	3070	7185	java/net/NoRouteToHostException
    //   3129	3137	7185	java/net/NoRouteToHostException
    //   3206	3233	7185	java/net/NoRouteToHostException
    //   3287	3294	7185	java/net/NoRouteToHostException
    //   3348	3354	7185	java/net/NoRouteToHostException
    //   3408	3415	7185	java/net/NoRouteToHostException
    //   3938	3947	7185	java/net/NoRouteToHostException
    //   4019	4027	7185	java/net/NoRouteToHostException
    //   4081	4087	7185	java/net/NoRouteToHostException
    //   900	939	7201	java/net/ProtocolException
    //   1164	1178	7201	java/net/ProtocolException
    //   1178	1220	7216	java/net/ProtocolException
    //   1227	1292	7216	java/net/ProtocolException
    //   1297	1305	7216	java/net/ProtocolException
    //   1305	1341	7216	java/net/ProtocolException
    //   1341	1396	7216	java/net/ProtocolException
    //   1450	1456	7257	java/net/ProtocolException
    //   1524	1528	7257	java/net/ProtocolException
    //   1582	1601	7257	java/net/ProtocolException
    //   1655	1660	7257	java/net/ProtocolException
    //   1714	1719	7257	java/net/ProtocolException
    //   2053	2072	7257	java/net/ProtocolException
    //   2126	2155	7257	java/net/ProtocolException
    //   2209	2216	7257	java/net/ProtocolException
    //   2270	2287	7257	java/net/ProtocolException
    //   2341	2347	7257	java/net/ProtocolException
    //   2401	2411	7257	java/net/ProtocolException
    //   2465	2478	7257	java/net/ProtocolException
    //   2532	2543	7257	java/net/ProtocolException
    //   2597	2606	7257	java/net/ProtocolException
    //   2660	2666	7257	java/net/ProtocolException
    //   2720	2726	7257	java/net/ProtocolException
    //   2780	2798	7257	java/net/ProtocolException
    //   2852	2862	7257	java/net/ProtocolException
    //   2916	2923	7257	java/net/ProtocolException
    //   2977	2991	7257	java/net/ProtocolException
    //   3045	3070	7257	java/net/ProtocolException
    //   3129	3137	7257	java/net/ProtocolException
    //   3206	3233	7257	java/net/ProtocolException
    //   3287	3294	7257	java/net/ProtocolException
    //   3348	3354	7257	java/net/ProtocolException
    //   3408	3415	7257	java/net/ProtocolException
    //   3938	3947	7257	java/net/ProtocolException
    //   4019	4027	7257	java/net/ProtocolException
    //   4081	4087	7257	java/net/ProtocolException
  }
  
  public final void start()
  {
    AppMethodBeat.i(137467);
    if (!this.isStop)
    {
      AppMethodBeat.o(137467);
      return;
    }
    this.isStop = false;
    com.tencent.mm.sdk.g.d.post(this, "music_download_thread");
    AppMethodBeat.o(137467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b
 * JD-Core Version:    0.7.0.1
 */