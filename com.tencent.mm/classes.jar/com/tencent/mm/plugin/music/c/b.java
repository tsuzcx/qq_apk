package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
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
  private String FPW;
  public f FPX;
  public a FPY;
  public float FPZ;
  private long FQa;
  public int FQb;
  public b FQc;
  public int fnU;
  public boolean isStop;
  public String mimeType;
  public boolean wIk;
  
  public b(f paramf, a parama)
  {
    AppMethodBeat.i(137216);
    this.FPW = null;
    this.FQa = 307200L;
    this.isStop = true;
    this.mimeType = "";
    this.FQb = -1;
    this.fnU = 0;
    this.FPX = paramf;
    this.FPY = parama;
    int i;
    int j;
    if ((parama.FPR == 0L) && (parama.FPS == 0L) && (parama.endFlag == 0))
    {
      i = 1;
      if ((parama.FPT != 0L) || (parama.FPV != 0L) || (parama.FPU != 0)) {
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
      Log.e("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
    }
    for (;;)
    {
      this.wIk = NetStatusUtil.isWifi(MMApplicationContext.getContext());
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
      Log.i("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
    }
  }
  
  private HttpURLConnection K(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137219);
    Object localObject1;
    if (!TextUtils.isEmpty(this.FPW))
    {
      Log.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.FPW;
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
          Log.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[] { paramString });
          Object localObject2 = k.fet().FQA;
          localObject1 = new URL(paramString);
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.plugin.music.e.a)localObject2).aRZ(paramString);
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
            Log.e("MicroMsg.Music.MusicDownloadTask", localException.getMessage());
          }
          int j = ((HttpURLConnection)localObject1).getResponseCode();
          Log.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307))
          {
            Zf(j);
            paramString = ((HttpURLConnection)localObject1).getRequestMethod();
            if ((j == 307) && (!paramString.equals("GET")) && (!paramString.equals("HEAD")))
            {
              AppMethodBeat.o(137219);
              return localObject1;
            }
            paramString = ((HttpURLConnection)localObject1).getHeaderField("Location");
            if (paramString == null)
            {
              Log.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[] { Integer.valueOf(j) });
              AppMethodBeat.o(137219);
              return localObject1;
            }
            URL localURL = new URL(((HttpURLConnection)localObject1).getURL(), paramString);
            Log.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[] { paramString });
            Log.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[] { localURL.toString() });
            if ((!localURL.getProtocol().equals("https")) && (!localURL.getProtocol().equals("http")))
            {
              Log.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[] { Integer.valueOf(j) });
              AppMethodBeat.o(137219);
              return localObject1;
            }
            i += 1;
            if (i > 5)
            {
              Log.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: ".concat(String.valueOf(i)));
              AppMethodBeat.o(137219);
              return localObject1;
            }
            paramString = localURL.toString();
            this.FPW = paramString;
          }
          else
          {
            if ((j != 200) && (j != 206)) {
              this.FPW = null;
            }
            AppMethodBeat.o(137219);
            return localObject1;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  private void OE(long paramLong)
  {
    AppMethodBeat.i(137222);
    if (this.wIk)
    {
      this.FPY.FPT = paramLong;
      this.FPY.FPU = 1;
      this.FPY.FPV = paramLong;
      e.a(this.FPX.lVt, this.FPY);
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new a(2));
      AppMethodBeat.o(137222);
      return;
      this.FPY.FPR = paramLong;
      this.FPY.endFlag = 1;
      this.FPY.FPS = paramLong;
      e.a(this.FPX.lVt, this.FPY);
    }
  }
  
  private static void Zf(int paramInt)
  {
    AppMethodBeat.i(137220);
    d locald = (d)com.tencent.mm.plugin.music.f.c.b.bm(d.class);
    if (locald != null) {
      locald.Zj(paramInt);
    }
    AppMethodBeat.o(137220);
  }
  
  private void Zg(int paramInt)
  {
    AppMethodBeat.i(137221);
    this.FPW = null;
    MMHandlerThread.postToMainThread(new a(paramInt));
    AppMethodBeat.o(137221);
  }
  
  private static long[] aRY(String paramString)
  {
    AppMethodBeat.i(137224);
    if (Util.isNullOrNil(paramString))
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
  
  private void ak(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(137223);
    if (this.wIk)
    {
      this.FPY.FPT = paramLong1;
      this.FPY.FPU = 0;
      this.FPY.FPV = paramLong2;
      e.a(this.FPX.lVt, this.FPY);
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new a(3));
      AppMethodBeat.o(137223);
      return;
      this.FPY.FPR = paramLong1;
      this.FPY.endFlag = 0;
      this.FPY.FPS = paramLong2;
      e.a(this.FPX.lVt, this.FPY);
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
    //   26: invokestatic 99	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   29: invokestatic 377	com/tencent/mm/sdk/platformtools/NetStatusUtil:isNetworkConnected	(Landroid/content/Context;)Z
    //   32: istore 32
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 59	com/tencent/mm/plugin/music/c/b:fnU	I
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 57	com/tencent/mm/plugin/music/c/b:FQb	I
    //   44: invokestatic 153	com/tencent/mm/plugin/music/e/k:fet	()Lcom/tencent/mm/plugin/music/e/k;
    //   47: getfield 157	com/tencent/mm/plugin/music/e/k:FQA	Lcom/tencent/mm/plugin/music/e/a;
    //   50: astore 35
    //   52: iload 32
    //   54: ifeq +510 -> 564
    //   57: aload_0
    //   58: getfield 107	com/tencent/mm/plugin/music/c/b:wIk	Z
    //   61: ifeq +358 -> 419
    //   64: aload_0
    //   65: getfield 61	com/tencent/mm/plugin/music/c/b:FPX	Lcom/tencent/mm/bb/f;
    //   68: getfield 380	com/tencent/mm/bb/f:playUrl	Ljava/lang/String;
    //   71: invokestatic 385	com/tencent/mm/plugin/music/cache/g:aRN	(Ljava/lang/String;)Z
    //   74: istore 32
    //   76: aload 35
    //   78: ifnull +19 -> 97
    //   81: aload 35
    //   83: aload_0
    //   84: getfield 61	com/tencent/mm/plugin/music/c/b:FPX	Lcom/tencent/mm/bb/f;
    //   87: getfield 380	com/tencent/mm/bb/f:playUrl	Ljava/lang/String;
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
    //   111: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   118: getfield 77	com/tencent/mm/plugin/music/c/a:FPT	J
    //   121: lstore 6
    //   123: aload_0
    //   124: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   127: getfield 80	com/tencent/mm/plugin/music/c/a:FPV	J
    //   130: lstore 4
    //   132: lload 4
    //   134: lconst_0
    //   135: lcmp
    //   136: ifeq +13 -> 149
    //   139: aload_0
    //   140: lload 4
    //   142: ldc2_w 391
    //   145: ldiv
    //   146: putfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   149: lload 6
    //   151: aload_0
    //   152: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   155: lcmp
    //   156: ifge +233 -> 389
    //   159: aload_0
    //   160: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   163: lstore_2
    //   164: aload_0
    //   165: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   168: getfield 83	com/tencent/mm/plugin/music/c/a:FPU	I
    //   171: iconst_1
    //   172: if_icmpne +238 -> 410
    //   175: iconst_1
    //   176: istore_1
    //   177: aload 33
    //   179: astore 40
    //   181: aload_0
    //   182: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   185: ldc2_w 393
    //   188: lcmp
    //   189: ifge +18 -> 207
    //   192: aload_0
    //   193: ldc2_w 393
    //   196: putfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   199: ldc 85
    //   201: ldc_w 396
    //   204: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: new 398	com/tencent/mm/vfs/q
    //   210: dup
    //   211: aload_0
    //   212: getfield 61	com/tencent/mm/plugin/music/c/b:FPX	Lcom/tencent/mm/bb/f;
    //   215: getfield 298	com/tencent/mm/bb/f:lVt	Ljava/lang/String;
    //   218: aload_0
    //   219: getfield 107	com/tencent/mm/plugin/music/c/b:wIk	Z
    //   222: invokestatic 404	com/tencent/mm/plugin/music/h/b:cc	(Ljava/lang/String;Z)Ljava/lang/String;
    //   225: invokespecial 405	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   228: astore 52
    //   230: lload_2
    //   231: lstore 8
    //   233: lload 6
    //   235: lstore_2
    //   236: aload 52
    //   238: invokevirtual 408	com/tencent/mm/vfs/q:ifE	()Z
    //   241: ifne +56 -> 297
    //   244: ldc 85
    //   246: ldc_w 410
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 52
    //   257: invokevirtual 413	com/tencent/mm/vfs/q:ifM	()Z
    //   260: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   263: aastore
    //   264: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: lconst_0
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
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
    //   294: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   317: invokevirtual 428	com/tencent/mm/vfs/q:length	()J
    //   320: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: dup
    //   325: iconst_2
    //   326: lload 8
    //   328: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: aastore
    //   332: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: lload_2
    //   336: aload_0
    //   337: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   340: lcmp
    //   341: iflt +12 -> 353
    //   344: aload_0
    //   345: getfield 430	com/tencent/mm/plugin/music/c/b:FPZ	F
    //   348: fconst_0
    //   349: fcmpl
    //   350: ifeq +7 -> 357
    //   353: iload_1
    //   354: ifeq +484 -> 838
    //   357: ldc 85
    //   359: ldc_w 432
    //   362: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: iconst_1
    //   367: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   370: new 8	com/tencent/mm/plugin/music/c/b$a
    //   373: dup
    //   374: aload_0
    //   375: iconst_1
    //   376: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   379: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   382: ldc_w 374
    //   385: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: return
    //   389: lload 6
    //   391: l2f
    //   392: ldc_w 433
    //   395: aload_0
    //   396: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   399: getfield 80	com/tencent/mm/plugin/music/c/a:FPV	J
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
    //   431: getfield 61	com/tencent/mm/plugin/music/c/b:FPX	Lcom/tencent/mm/bb/f;
    //   434: getfield 380	com/tencent/mm/bb/f:playUrl	Ljava/lang/String;
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
    //   458: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   461: iconst_0
    //   462: istore 32
    //   464: aload_0
    //   465: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   468: getfield 68	com/tencent/mm/plugin/music/c/a:FPR	J
    //   471: lstore 6
    //   473: aload_0
    //   474: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   477: getfield 71	com/tencent/mm/plugin/music/c/a:FPS	J
    //   480: lstore 4
    //   482: lload 4
    //   484: lconst_0
    //   485: lcmp
    //   486: ifeq +13 -> 499
    //   489: aload_0
    //   490: lload 4
    //   492: ldc2_w 391
    //   495: ldiv
    //   496: putfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   499: lload 6
    //   501: aload_0
    //   502: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   505: lcmp
    //   506: ifge +28 -> 534
    //   509: aload_0
    //   510: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   513: lstore_2
    //   514: aload_0
    //   515: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
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
    //   541: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   544: getfield 71	com/tencent/mm/plugin/music/c/a:FPS	J
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
    //   565: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   568: getfield 77	com/tencent/mm/plugin/music/c/a:FPT	J
    //   571: lconst_0
    //   572: lcmp
    //   573: ifeq +102 -> 675
    //   576: aload_0
    //   577: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   580: getfield 77	com/tencent/mm/plugin/music/c/a:FPT	J
    //   583: aload_0
    //   584: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   587: lcmp
    //   588: ifge +21 -> 609
    //   591: aload_0
    //   592: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   595: getfield 77	com/tencent/mm/plugin/music/c/a:FPT	J
    //   598: aload_0
    //   599: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   602: getfield 80	com/tencent/mm/plugin/music/c/a:FPV	J
    //   605: lcmp
    //   606: ifne +69 -> 675
    //   609: aload_0
    //   610: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   613: getfield 77	com/tencent/mm/plugin/music/c/a:FPT	J
    //   616: l2f
    //   617: aload_0
    //   618: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   621: getfield 80	com/tencent/mm/plugin/music/c/a:FPV	J
    //   624: l2f
    //   625: fdiv
    //   626: aload_0
    //   627: getfield 430	com/tencent/mm/plugin/music/c/b:FPZ	F
    //   630: fsub
    //   631: ldc_w 433
    //   634: fcmpl
    //   635: iflt +40 -> 675
    //   638: ldc 85
    //   640: ldc_w 432
    //   643: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 107	com/tencent/mm/plugin/music/c/b:wIk	Z
    //   656: new 8	com/tencent/mm/plugin/music/c/b$a
    //   659: dup
    //   660: aload_0
    //   661: iconst_1
    //   662: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   665: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   668: ldc_w 374
    //   671: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: return
    //   675: aload_0
    //   676: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   679: getfield 68	com/tencent/mm/plugin/music/c/a:FPR	J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifeq +102 -> 786
    //   687: aload_0
    //   688: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   691: getfield 68	com/tencent/mm/plugin/music/c/a:FPR	J
    //   694: aload_0
    //   695: getfield 49	com/tencent/mm/plugin/music/c/b:FQa	J
    //   698: lcmp
    //   699: ifge +21 -> 720
    //   702: aload_0
    //   703: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   706: getfield 68	com/tencent/mm/plugin/music/c/a:FPR	J
    //   709: aload_0
    //   710: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   713: getfield 71	com/tencent/mm/plugin/music/c/a:FPS	J
    //   716: lcmp
    //   717: ifne +69 -> 786
    //   720: aload_0
    //   721: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   724: getfield 68	com/tencent/mm/plugin/music/c/a:FPR	J
    //   727: l2f
    //   728: aload_0
    //   729: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   732: getfield 71	com/tencent/mm/plugin/music/c/a:FPS	J
    //   735: l2f
    //   736: fdiv
    //   737: aload_0
    //   738: getfield 430	com/tencent/mm/plugin/music/c/b:FPZ	F
    //   741: fsub
    //   742: ldc_w 433
    //   745: fcmpl
    //   746: iflt +40 -> 786
    //   749: ldc 85
    //   751: ldc_w 432
    //   754: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_0
    //   758: iconst_1
    //   759: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   762: aload_0
    //   763: iconst_0
    //   764: putfield 107	com/tencent/mm/plugin/music/c/b:wIk	Z
    //   767: new 8	com/tencent/mm/plugin/music/c/b$a
    //   770: dup
    //   771: aload_0
    //   772: iconst_1
    //   773: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   776: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   779: ldc_w 374
    //   782: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: return
    //   786: ldc 85
    //   788: ldc_w 435
    //   791: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_0
    //   795: iconst_1
    //   796: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   799: aload_0
    //   800: iconst_4
    //   801: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
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
    //   828: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   831: aastore
    //   832: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   835: goto -568 -> 267
    //   838: aload 40
    //   840: invokestatic 335	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   843: ifeq +36 -> 879
    //   846: ldc 85
    //   848: ldc_w 448
    //   851: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload_0
    //   855: iconst_1
    //   856: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   859: new 8	com/tencent/mm/plugin/music/c/b$a
    //   862: dup
    //   863: aload_0
    //   864: bipush 254
    //   866: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   869: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   872: ldc_w 374
    //   875: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   878: return
    //   879: aconst_null
    //   880: astore 42
    //   882: aconst_null
    //   883: astore 41
    //   885: aconst_null
    //   886: astore 43
    //   888: aconst_null
    //   889: astore 46
    //   891: aconst_null
    //   892: astore 45
    //   894: aconst_null
    //   895: astore 44
    //   897: aconst_null
    //   898: astore 49
    //   900: aconst_null
    //   901: astore 50
    //   903: aconst_null
    //   904: astore 51
    //   906: aconst_null
    //   907: astore 48
    //   909: aconst_null
    //   910: astore 47
    //   912: aconst_null
    //   913: astore 33
    //   915: aload 33
    //   917: astore 37
    //   919: aload 49
    //   921: astore 34
    //   923: aload 50
    //   925: astore 35
    //   927: aload 51
    //   929: astore 36
    //   931: aload 48
    //   933: astore 39
    //   935: aload 47
    //   937: astore 38
    //   939: aload 52
    //   941: invokevirtual 408	com/tencent/mm/vfs/q:ifE	()Z
    //   944: ifne +331 -> 1275
    //   947: aload 33
    //   949: astore 37
    //   951: aload 49
    //   953: astore 34
    //   955: aload 50
    //   957: astore 35
    //   959: aload 51
    //   961: astore 36
    //   963: aload 48
    //   965: astore 39
    //   967: aload 47
    //   969: astore 38
    //   971: aload_0
    //   972: iconst_1
    //   973: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   976: aload 33
    //   978: astore 37
    //   980: aload 49
    //   982: astore 34
    //   984: aload 50
    //   986: astore 35
    //   988: aload 51
    //   990: astore 36
    //   992: aload 48
    //   994: astore 39
    //   996: aload 47
    //   998: astore 38
    //   1000: ldc 85
    //   1002: ldc_w 450
    //   1005: iconst_1
    //   1006: anewarray 4	java/lang/Object
    //   1009: dup
    //   1010: iconst_0
    //   1011: aload 52
    //   1013: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   1016: aastore
    //   1017: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1020: aload 33
    //   1022: astore 37
    //   1024: aload 49
    //   1026: astore 34
    //   1028: aload 50
    //   1030: astore 35
    //   1032: aload 51
    //   1034: astore 36
    //   1036: aload 48
    //   1038: astore 39
    //   1040: aload 47
    //   1042: astore 38
    //   1044: aload_0
    //   1045: bipush 19
    //   1047: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   1050: lload 4
    //   1052: lconst_0
    //   1053: lcmp
    //   1054: ifne +89 -> 1143
    //   1057: lload_2
    //   1058: lconst_0
    //   1059: lcmp
    //   1060: ifle +83 -> 1143
    //   1063: ldc 85
    //   1065: ldc_w 452
    //   1068: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1071: new 454	java/lang/NullPointerException
    //   1074: dup
    //   1075: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   1078: athrow
    //   1079: aload_0
    //   1080: lload_2
    //   1081: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   1084: lload_2
    //   1085: ldc2_w 393
    //   1088: lcmp
    //   1089: ifge +15 -> 1104
    //   1092: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1095: dup
    //   1096: aload_0
    //   1097: iconst_1
    //   1098: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1101: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   1104: aload_0
    //   1105: iconst_1
    //   1106: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   1109: ldc 85
    //   1111: ldc_w 459
    //   1114: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1117: ldc_w 374
    //   1120: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1123: return
    //   1124: astore 33
    //   1126: ldc 85
    //   1128: aload 33
    //   1130: ldc_w 461
    //   1133: iconst_0
    //   1134: anewarray 4	java/lang/Object
    //   1137: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1140: goto -61 -> 1079
    //   1143: lload 4
    //   1145: lconst_0
    //   1146: lcmp
    //   1147: ifeq +47 -> 1194
    //   1150: lload_2
    //   1151: lload 4
    //   1153: lcmp
    //   1154: ifeq +40 -> 1194
    //   1157: ldc 85
    //   1159: ldc_w 463
    //   1162: iconst_2
    //   1163: anewarray 4	java/lang/Object
    //   1166: dup
    //   1167: iconst_0
    //   1168: lload 4
    //   1170: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1173: aastore
    //   1174: dup
    //   1175: iconst_1
    //   1176: lload_2
    //   1177: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1180: aastore
    //   1181: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1184: aload_0
    //   1185: lload_2
    //   1186: lload 4
    //   1188: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   1191: goto -87 -> 1104
    //   1194: lload 4
    //   1196: lconst_0
    //   1197: lcmp
    //   1198: ifeq +66 -> 1264
    //   1201: lload_2
    //   1202: lload 4
    //   1204: lcmp
    //   1205: ifne +59 -> 1264
    //   1208: ldc 85
    //   1210: ldc_w 467
    //   1213: iconst_2
    //   1214: anewarray 4	java/lang/Object
    //   1217: dup
    //   1218: iconst_0
    //   1219: lload 4
    //   1221: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1224: aastore
    //   1225: dup
    //   1226: iconst_1
    //   1227: lload_2
    //   1228: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1231: aastore
    //   1232: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1235: aload_0
    //   1236: lload 4
    //   1238: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   1241: lload_2
    //   1242: ldc2_w 393
    //   1245: lcmp
    //   1246: ifge -142 -> 1104
    //   1249: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1252: dup
    //   1253: aload_0
    //   1254: iconst_1
    //   1255: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1258: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   1261: goto -157 -> 1104
    //   1264: ldc 85
    //   1266: ldc_w 469
    //   1269: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1272: goto -168 -> 1104
    //   1275: aload 33
    //   1277: astore 37
    //   1279: aload 49
    //   1281: astore 34
    //   1283: aload 50
    //   1285: astore 35
    //   1287: aload 51
    //   1289: astore 36
    //   1291: aload 48
    //   1293: astore 39
    //   1295: aload 47
    //   1297: astore 38
    //   1299: aload 52
    //   1301: invokevirtual 472	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   1304: iconst_1
    //   1305: invokestatic 478	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   1308: astore 33
    //   1310: aload 33
    //   1312: astore 37
    //   1314: aload 33
    //   1316: astore 34
    //   1318: aload 33
    //   1320: astore 35
    //   1322: aload 33
    //   1324: astore 36
    //   1326: aload 33
    //   1328: astore 39
    //   1330: aload 33
    //   1332: astore 38
    //   1334: ldc 85
    //   1336: ldc_w 480
    //   1339: iconst_1
    //   1340: anewarray 4	java/lang/Object
    //   1343: dup
    //   1344: iconst_0
    //   1345: aload 40
    //   1347: aastore
    //   1348: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1351: aload 33
    //   1353: astore 37
    //   1355: aload 33
    //   1357: astore 34
    //   1359: aload 33
    //   1361: astore 35
    //   1363: aload 33
    //   1365: astore 36
    //   1367: aload 33
    //   1369: astore 39
    //   1371: aload 33
    //   1373: astore 38
    //   1375: new 482	java/util/HashMap
    //   1378: dup
    //   1379: bipush 10
    //   1381: invokespecial 484	java/util/HashMap:<init>	(I)V
    //   1384: astore 47
    //   1386: aload 33
    //   1388: astore 37
    //   1390: aload 33
    //   1392: astore 34
    //   1394: aload 33
    //   1396: astore 35
    //   1398: aload 33
    //   1400: astore 36
    //   1402: aload 33
    //   1404: astore 39
    //   1406: aload 33
    //   1408: astore 38
    //   1410: aload 47
    //   1412: ldc_w 486
    //   1415: ldc_w 488
    //   1418: invokeinterface 492 3 0
    //   1423: pop
    //   1424: lload 8
    //   1426: lload_2
    //   1427: lcmp
    //   1428: ifle +117 -> 1545
    //   1431: aload 33
    //   1433: astore 37
    //   1435: aload 33
    //   1437: astore 34
    //   1439: aload 33
    //   1441: astore 35
    //   1443: aload 33
    //   1445: astore 36
    //   1447: aload 33
    //   1449: astore 39
    //   1451: aload 33
    //   1453: astore 38
    //   1455: ldc 85
    //   1457: ldc_w 494
    //   1460: iconst_2
    //   1461: anewarray 4	java/lang/Object
    //   1464: dup
    //   1465: iconst_0
    //   1466: lload_2
    //   1467: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1470: aastore
    //   1471: dup
    //   1472: iconst_1
    //   1473: lload 8
    //   1475: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1478: aastore
    //   1479: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1482: aload 33
    //   1484: astore 37
    //   1486: aload 33
    //   1488: astore 34
    //   1490: aload 33
    //   1492: astore 35
    //   1494: aload 33
    //   1496: astore 36
    //   1498: aload 33
    //   1500: astore 39
    //   1502: aload 33
    //   1504: astore 38
    //   1506: aload 47
    //   1508: ldc_w 499
    //   1511: new 501	java/lang/StringBuilder
    //   1514: dup
    //   1515: ldc_w 503
    //   1518: invokespecial 504	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1521: lload_2
    //   1522: invokevirtual 508	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1525: ldc_w 346
    //   1528: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: lload 8
    //   1533: invokevirtual 508	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1536: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1539: invokeinterface 492 3 0
    //   1544: pop
    //   1545: iload 32
    //   1547: ifne +35 -> 1582
    //   1550: aload 33
    //   1552: astore 37
    //   1554: aload 33
    //   1556: astore 34
    //   1558: aload 33
    //   1560: astore 35
    //   1562: aload 33
    //   1564: astore 36
    //   1566: aload 33
    //   1568: astore 39
    //   1570: aload 33
    //   1572: astore 38
    //   1574: aload 40
    //   1576: invokestatic 517	com/tencent/mm/plugin/music/h/e:aSw	(Ljava/lang/String;)Z
    //   1579: ifeq +35 -> 1614
    //   1582: aload 33
    //   1584: astore 37
    //   1586: aload 33
    //   1588: astore 34
    //   1590: aload 33
    //   1592: astore 35
    //   1594: aload 33
    //   1596: astore 36
    //   1598: aload 33
    //   1600: astore 39
    //   1602: aload 33
    //   1604: astore 38
    //   1606: ldc 85
    //   1608: ldc_w 519
    //   1611: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1614: aload 33
    //   1616: astore 37
    //   1618: aload 33
    //   1620: astore 34
    //   1622: aload 33
    //   1624: astore 35
    //   1626: aload 33
    //   1628: astore 36
    //   1630: aload 33
    //   1632: astore 39
    //   1634: aload 33
    //   1636: astore 38
    //   1638: aload 47
    //   1640: ldc_w 521
    //   1643: new 501	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 522	java/lang/StringBuilder:<init>	()V
    //   1650: ldc_w 524
    //   1653: invokestatic 529	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1656: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: ldc_w 531
    //   1662: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: invokestatic 99	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1668: invokestatic 535	com/tencent/mm/plugin/music/h/e:hE	(Landroid/content/Context;)Ljava/lang/String;
    //   1671: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: invokeinterface 492 3 0
    //   1682: pop
    //   1683: aload 33
    //   1685: astore 37
    //   1687: aload 33
    //   1689: astore 34
    //   1691: aload 33
    //   1693: astore 35
    //   1695: aload 33
    //   1697: astore 36
    //   1699: aload 33
    //   1701: astore 39
    //   1703: aload 33
    //   1705: astore 38
    //   1707: aload_0
    //   1708: aload 40
    //   1710: aload 47
    //   1712: invokespecial 537	com/tencent/mm/plugin/music/c/b:K	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   1715: astore 40
    //   1717: aload 40
    //   1719: astore 34
    //   1721: aload 33
    //   1723: astore 37
    //   1725: aload 34
    //   1727: astore 36
    //   1729: lload 4
    //   1731: lstore 8
    //   1733: lload_2
    //   1734: lstore 6
    //   1736: aload 45
    //   1738: astore 35
    //   1740: lload 4
    //   1742: lstore 20
    //   1744: lload_2
    //   1745: lstore 14
    //   1747: lload 4
    //   1749: lstore 24
    //   1751: lload_2
    //   1752: lstore 18
    //   1754: lload 4
    //   1756: lstore 26
    //   1758: lload_2
    //   1759: lstore 16
    //   1761: lload 4
    //   1763: lstore 22
    //   1765: lload_2
    //   1766: lstore 10
    //   1768: lload 4
    //   1770: lstore 28
    //   1772: lload_2
    //   1773: lstore 12
    //   1775: aload 34
    //   1777: invokevirtual 227	java/net/HttpURLConnection:getResponseCode	()I
    //   1780: istore_1
    //   1781: iload_1
    //   1782: sipush 200
    //   1785: if_icmpeq +544 -> 2329
    //   1788: iload_1
    //   1789: sipush 206
    //   1792: if_icmpeq +537 -> 2329
    //   1795: aload 33
    //   1797: astore 37
    //   1799: aload 34
    //   1801: astore 36
    //   1803: lload 4
    //   1805: lstore 8
    //   1807: lload_2
    //   1808: lstore 6
    //   1810: aload 45
    //   1812: astore 35
    //   1814: lload 4
    //   1816: lstore 20
    //   1818: lload_2
    //   1819: lstore 14
    //   1821: lload 4
    //   1823: lstore 24
    //   1825: lload_2
    //   1826: lstore 18
    //   1828: lload 4
    //   1830: lstore 26
    //   1832: lload_2
    //   1833: lstore 16
    //   1835: lload 4
    //   1837: lstore 22
    //   1839: lload_2
    //   1840: lstore 10
    //   1842: lload 4
    //   1844: lstore 28
    //   1846: lload_2
    //   1847: lstore 12
    //   1849: iload_1
    //   1850: invokestatic 238	com/tencent/mm/plugin/music/c/b:Zf	(I)V
    //   1853: aload 33
    //   1855: astore 37
    //   1857: aload 34
    //   1859: astore 36
    //   1861: lload 4
    //   1863: lstore 8
    //   1865: lload_2
    //   1866: lstore 6
    //   1868: aload 45
    //   1870: astore 35
    //   1872: lload 4
    //   1874: lstore 20
    //   1876: lload_2
    //   1877: lstore 14
    //   1879: lload 4
    //   1881: lstore 24
    //   1883: lload_2
    //   1884: lstore 18
    //   1886: lload 4
    //   1888: lstore 26
    //   1890: lload_2
    //   1891: lstore 16
    //   1893: lload 4
    //   1895: lstore 22
    //   1897: lload_2
    //   1898: lstore 10
    //   1900: lload 4
    //   1902: lstore 28
    //   1904: lload_2
    //   1905: lstore 12
    //   1907: ldc 85
    //   1909: ldc_w 539
    //   1912: iconst_1
    //   1913: anewarray 4	java/lang/Object
    //   1916: dup
    //   1917: iconst_0
    //   1918: iload_1
    //   1919: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1922: aastore
    //   1923: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1926: aload 33
    //   1928: astore 37
    //   1930: aload 34
    //   1932: astore 36
    //   1934: lload 4
    //   1936: lstore 8
    //   1938: lload_2
    //   1939: lstore 6
    //   1941: aload 45
    //   1943: astore 35
    //   1945: lload 4
    //   1947: lstore 20
    //   1949: lload_2
    //   1950: lstore 14
    //   1952: lload 4
    //   1954: lstore 24
    //   1956: lload_2
    //   1957: lstore 18
    //   1959: lload 4
    //   1961: lstore 26
    //   1963: lload_2
    //   1964: lstore 16
    //   1966: lload 4
    //   1968: lstore 22
    //   1970: lload_2
    //   1971: lstore 10
    //   1973: lload 4
    //   1975: lstore 28
    //   1977: lload_2
    //   1978: lstore 12
    //   1980: aload_0
    //   1981: iload_1
    //   1982: putfield 57	com/tencent/mm/plugin/music/c/b:FQb	I
    //   1985: aload 33
    //   1987: astore 37
    //   1989: aload 34
    //   1991: astore 36
    //   1993: lload 4
    //   1995: lstore 8
    //   1997: lload_2
    //   1998: lstore 6
    //   2000: aload 45
    //   2002: astore 35
    //   2004: lload 4
    //   2006: lstore 20
    //   2008: lload_2
    //   2009: lstore 14
    //   2011: lload 4
    //   2013: lstore 24
    //   2015: lload_2
    //   2016: lstore 18
    //   2018: lload 4
    //   2020: lstore 26
    //   2022: lload_2
    //   2023: lstore 16
    //   2025: lload 4
    //   2027: lstore 22
    //   2029: lload_2
    //   2030: lstore 10
    //   2032: lload 4
    //   2034: lstore 28
    //   2036: lload_2
    //   2037: lstore 12
    //   2039: aload_0
    //   2040: iconst_m1
    //   2041: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   2044: lload 4
    //   2046: lconst_0
    //   2047: lcmp
    //   2048: ifne +115 -> 2163
    //   2051: lload_2
    //   2052: lconst_0
    //   2053: lcmp
    //   2054: ifle +109 -> 2163
    //   2057: ldc 85
    //   2059: ldc_w 452
    //   2062: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2065: aload 33
    //   2067: lload_2
    //   2068: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   2071: aload_0
    //   2072: lload_2
    //   2073: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   2076: lload_2
    //   2077: ldc2_w 393
    //   2080: lcmp
    //   2081: ifge +15 -> 2096
    //   2084: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2087: dup
    //   2088: aload_0
    //   2089: iconst_1
    //   2090: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2093: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   2096: aload 33
    //   2098: ifnull +8 -> 2106
    //   2101: aload 33
    //   2103: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   2106: aload 34
    //   2108: ifnull +16 -> 2124
    //   2111: aload 34
    //   2113: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2116: invokevirtual 139	java/io/InputStream:close	()V
    //   2119: aload 34
    //   2121: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   2124: aload_0
    //   2125: iconst_1
    //   2126: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   2129: ldc 85
    //   2131: ldc_w 459
    //   2134: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2137: ldc_w 374
    //   2140: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2143: return
    //   2144: astore 35
    //   2146: ldc 85
    //   2148: aload 35
    //   2150: ldc_w 461
    //   2153: iconst_0
    //   2154: anewarray 4	java/lang/Object
    //   2157: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2160: goto -89 -> 2071
    //   2163: lload 4
    //   2165: lconst_0
    //   2166: lcmp
    //   2167: ifeq +47 -> 2214
    //   2170: lload_2
    //   2171: lload 4
    //   2173: lcmp
    //   2174: ifeq +40 -> 2214
    //   2177: ldc 85
    //   2179: ldc_w 463
    //   2182: iconst_2
    //   2183: anewarray 4	java/lang/Object
    //   2186: dup
    //   2187: iconst_0
    //   2188: lload 4
    //   2190: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2193: aastore
    //   2194: dup
    //   2195: iconst_1
    //   2196: lload_2
    //   2197: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2200: aastore
    //   2201: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2204: aload_0
    //   2205: lload_2
    //   2206: lload 4
    //   2208: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   2211: goto -115 -> 2096
    //   2214: lload 4
    //   2216: lconst_0
    //   2217: lcmp
    //   2218: ifeq +66 -> 2284
    //   2221: lload_2
    //   2222: lload 4
    //   2224: lcmp
    //   2225: ifne +59 -> 2284
    //   2228: ldc 85
    //   2230: ldc_w 467
    //   2233: iconst_2
    //   2234: anewarray 4	java/lang/Object
    //   2237: dup
    //   2238: iconst_0
    //   2239: lload 4
    //   2241: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2244: aastore
    //   2245: dup
    //   2246: iconst_1
    //   2247: lload_2
    //   2248: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2251: aastore
    //   2252: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2255: aload_0
    //   2256: lload 4
    //   2258: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   2261: lload_2
    //   2262: ldc2_w 393
    //   2265: lcmp
    //   2266: ifge -170 -> 2096
    //   2269: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2272: dup
    //   2273: aload_0
    //   2274: iconst_1
    //   2275: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2278: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   2281: goto -185 -> 2096
    //   2284: ldc 85
    //   2286: ldc_w 469
    //   2289: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2292: goto -196 -> 2096
    //   2295: astore 33
    //   2297: ldc 85
    //   2299: aload 33
    //   2301: ldc_w 461
    //   2304: iconst_0
    //   2305: anewarray 4	java/lang/Object
    //   2308: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2311: goto -205 -> 2106
    //   2314: astore 33
    //   2316: ldc 85
    //   2318: aload 33
    //   2320: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2323: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2326: goto -207 -> 2119
    //   2329: aload 33
    //   2331: astore 37
    //   2333: aload 34
    //   2335: astore 36
    //   2337: lload 4
    //   2339: lstore 8
    //   2341: lload_2
    //   2342: lstore 6
    //   2344: aload 45
    //   2346: astore 35
    //   2348: lload 4
    //   2350: lstore 20
    //   2352: lload_2
    //   2353: lstore 14
    //   2355: lload 4
    //   2357: lstore 24
    //   2359: lload_2
    //   2360: lstore 18
    //   2362: lload 4
    //   2364: lstore 26
    //   2366: lload_2
    //   2367: lstore 16
    //   2369: lload 4
    //   2371: lstore 22
    //   2373: lload_2
    //   2374: lstore 10
    //   2376: lload 4
    //   2378: lstore 28
    //   2380: lload_2
    //   2381: lstore 12
    //   2383: ldc 85
    //   2385: ldc_w 547
    //   2388: iconst_1
    //   2389: anewarray 4	java/lang/Object
    //   2392: dup
    //   2393: iconst_0
    //   2394: iload_1
    //   2395: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2398: aastore
    //   2399: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2402: aload 33
    //   2404: astore 37
    //   2406: aload 34
    //   2408: astore 36
    //   2410: lload 4
    //   2412: lstore 8
    //   2414: lload_2
    //   2415: lstore 6
    //   2417: aload 45
    //   2419: astore 35
    //   2421: lload 4
    //   2423: lstore 20
    //   2425: lload_2
    //   2426: lstore 14
    //   2428: lload 4
    //   2430: lstore 24
    //   2432: lload_2
    //   2433: lstore 18
    //   2435: lload 4
    //   2437: lstore 26
    //   2439: lload_2
    //   2440: lstore 16
    //   2442: lload 4
    //   2444: lstore 22
    //   2446: lload_2
    //   2447: lstore 10
    //   2449: lload 4
    //   2451: lstore 28
    //   2453: lload_2
    //   2454: lstore 12
    //   2456: ldc 85
    //   2458: new 501	java/lang/StringBuilder
    //   2461: dup
    //   2462: ldc_w 549
    //   2465: invokespecial 504	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2468: aload 34
    //   2470: ldc_w 521
    //   2473: invokevirtual 552	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2476: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2479: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2482: invokestatic 554	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2485: aload 33
    //   2487: astore 37
    //   2489: aload 34
    //   2491: astore 36
    //   2493: lload 4
    //   2495: lstore 8
    //   2497: lload_2
    //   2498: lstore 6
    //   2500: aload 45
    //   2502: astore 35
    //   2504: lload 4
    //   2506: lstore 20
    //   2508: lload_2
    //   2509: lstore 14
    //   2511: lload 4
    //   2513: lstore 24
    //   2515: lload_2
    //   2516: lstore 18
    //   2518: lload 4
    //   2520: lstore 26
    //   2522: lload_2
    //   2523: lstore 16
    //   2525: lload 4
    //   2527: lstore 22
    //   2529: lload_2
    //   2530: lstore 10
    //   2532: lload 4
    //   2534: lstore 28
    //   2536: lload_2
    //   2537: lstore 12
    //   2539: aload 34
    //   2541: invokevirtual 557	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2544: astore 38
    //   2546: aload 33
    //   2548: astore 37
    //   2550: aload 34
    //   2552: astore 36
    //   2554: lload 4
    //   2556: lstore 8
    //   2558: lload_2
    //   2559: lstore 6
    //   2561: aload 45
    //   2563: astore 35
    //   2565: lload 4
    //   2567: lstore 20
    //   2569: lload_2
    //   2570: lstore 14
    //   2572: lload 4
    //   2574: lstore 24
    //   2576: lload_2
    //   2577: lstore 18
    //   2579: lload 4
    //   2581: lstore 26
    //   2583: lload_2
    //   2584: lstore 16
    //   2586: lload 4
    //   2588: lstore 22
    //   2590: lload_2
    //   2591: lstore 10
    //   2593: lload 4
    //   2595: lstore 28
    //   2597: lload_2
    //   2598: lstore 12
    //   2600: ldc 85
    //   2602: ldc_w 559
    //   2605: iconst_1
    //   2606: anewarray 4	java/lang/Object
    //   2609: dup
    //   2610: iconst_0
    //   2611: aload 38
    //   2613: aastore
    //   2614: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2617: aload 33
    //   2619: astore 37
    //   2621: aload 34
    //   2623: astore 36
    //   2625: lload 4
    //   2627: lstore 8
    //   2629: lload_2
    //   2630: lstore 6
    //   2632: aload 45
    //   2634: astore 35
    //   2636: lload 4
    //   2638: lstore 20
    //   2640: lload_2
    //   2641: lstore 14
    //   2643: lload 4
    //   2645: lstore 24
    //   2647: lload_2
    //   2648: lstore 18
    //   2650: lload 4
    //   2652: lstore 26
    //   2654: lload_2
    //   2655: lstore 16
    //   2657: lload 4
    //   2659: lstore 22
    //   2661: lload_2
    //   2662: lstore 10
    //   2664: lload 4
    //   2666: lstore 28
    //   2668: lload_2
    //   2669: lstore 12
    //   2671: aload_0
    //   2672: aload 38
    //   2674: putfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2677: aload 33
    //   2679: astore 37
    //   2681: aload 34
    //   2683: astore 36
    //   2685: lload 4
    //   2687: lstore 8
    //   2689: lload_2
    //   2690: lstore 6
    //   2692: aload 45
    //   2694: astore 35
    //   2696: lload 4
    //   2698: lstore 20
    //   2700: lload_2
    //   2701: lstore 14
    //   2703: lload 4
    //   2705: lstore 24
    //   2707: lload_2
    //   2708: lstore 18
    //   2710: lload 4
    //   2712: lstore 26
    //   2714: lload_2
    //   2715: lstore 16
    //   2717: lload 4
    //   2719: lstore 22
    //   2721: lload_2
    //   2722: lstore 10
    //   2724: lload 4
    //   2726: lstore 28
    //   2728: lload_2
    //   2729: lstore 12
    //   2731: aload_0
    //   2732: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2735: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2738: ifne +390 -> 3128
    //   2741: aload 33
    //   2743: astore 37
    //   2745: aload 34
    //   2747: astore 36
    //   2749: lload 4
    //   2751: lstore 8
    //   2753: lload_2
    //   2754: lstore 6
    //   2756: aload 45
    //   2758: astore 35
    //   2760: lload 4
    //   2762: lstore 20
    //   2764: lload_2
    //   2765: lstore 14
    //   2767: lload 4
    //   2769: lstore 24
    //   2771: lload_2
    //   2772: lstore 18
    //   2774: lload 4
    //   2776: lstore 26
    //   2778: lload_2
    //   2779: lstore 16
    //   2781: lload 4
    //   2783: lstore 22
    //   2785: lload_2
    //   2786: lstore 10
    //   2788: lload 4
    //   2790: lstore 28
    //   2792: lload_2
    //   2793: lstore 12
    //   2795: aload_0
    //   2796: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   2799: getfield 560	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2802: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2805: ifeq +323 -> 3128
    //   2808: aload 33
    //   2810: astore 37
    //   2812: aload 34
    //   2814: astore 36
    //   2816: lload 4
    //   2818: lstore 8
    //   2820: lload_2
    //   2821: lstore 6
    //   2823: aload 45
    //   2825: astore 35
    //   2827: lload 4
    //   2829: lstore 20
    //   2831: lload_2
    //   2832: lstore 14
    //   2834: lload 4
    //   2836: lstore 24
    //   2838: lload_2
    //   2839: lstore 18
    //   2841: lload 4
    //   2843: lstore 26
    //   2845: lload_2
    //   2846: lstore 16
    //   2848: lload 4
    //   2850: lstore 22
    //   2852: lload_2
    //   2853: lstore 10
    //   2855: lload 4
    //   2857: lstore 28
    //   2859: lload_2
    //   2860: lstore 12
    //   2862: aload_0
    //   2863: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   2866: aload_0
    //   2867: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2870: putfield 560	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
    //   2873: aload 33
    //   2875: astore 37
    //   2877: aload 34
    //   2879: astore 36
    //   2881: lload 4
    //   2883: lstore 8
    //   2885: lload_2
    //   2886: lstore 6
    //   2888: aload 45
    //   2890: astore 35
    //   2892: lload 4
    //   2894: lstore 20
    //   2896: lload_2
    //   2897: lstore 14
    //   2899: lload 4
    //   2901: lstore 24
    //   2903: lload_2
    //   2904: lstore 18
    //   2906: lload 4
    //   2908: lstore 26
    //   2910: lload_2
    //   2911: lstore 16
    //   2913: lload 4
    //   2915: lstore 22
    //   2917: lload_2
    //   2918: lstore 10
    //   2920: lload 4
    //   2922: lstore 28
    //   2924: lload_2
    //   2925: lstore 12
    //   2927: aload_0
    //   2928: getfield 61	com/tencent/mm/plugin/music/c/b:FPX	Lcom/tencent/mm/bb/f;
    //   2931: getfield 298	com/tencent/mm/bb/f:lVt	Ljava/lang/String;
    //   2934: astore 38
    //   2936: aload 33
    //   2938: astore 37
    //   2940: aload 34
    //   2942: astore 36
    //   2944: lload 4
    //   2946: lstore 8
    //   2948: lload_2
    //   2949: lstore 6
    //   2951: aload 45
    //   2953: astore 35
    //   2955: lload 4
    //   2957: lstore 20
    //   2959: lload_2
    //   2960: lstore 14
    //   2962: lload 4
    //   2964: lstore 24
    //   2966: lload_2
    //   2967: lstore 18
    //   2969: lload 4
    //   2971: lstore 26
    //   2973: lload_2
    //   2974: lstore 16
    //   2976: lload 4
    //   2978: lstore 22
    //   2980: lload_2
    //   2981: lstore 10
    //   2983: lload 4
    //   2985: lstore 28
    //   2987: lload_2
    //   2988: lstore 12
    //   2990: aload_0
    //   2991: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2994: astore 39
    //   2996: aload 33
    //   2998: astore 37
    //   3000: aload 34
    //   3002: astore 36
    //   3004: lload 4
    //   3006: lstore 8
    //   3008: lload_2
    //   3009: lstore 6
    //   3011: aload 45
    //   3013: astore 35
    //   3015: lload 4
    //   3017: lstore 20
    //   3019: lload_2
    //   3020: lstore 14
    //   3022: lload 4
    //   3024: lstore 24
    //   3026: lload_2
    //   3027: lstore 18
    //   3029: lload 4
    //   3031: lstore 26
    //   3033: lload_2
    //   3034: lstore 16
    //   3036: lload 4
    //   3038: lstore 22
    //   3040: lload_2
    //   3041: lstore 10
    //   3043: lload 4
    //   3045: lstore 28
    //   3047: lload_2
    //   3048: lstore 12
    //   3050: invokestatic 563	com/tencent/mm/plugin/music/cache/e:fdV	()Z
    //   3053: ifeq +1372 -> 4425
    //   3056: aload 33
    //   3058: astore 37
    //   3060: aload 34
    //   3062: astore 36
    //   3064: lload 4
    //   3066: lstore 8
    //   3068: lload_2
    //   3069: lstore 6
    //   3071: aload 45
    //   3073: astore 35
    //   3075: lload 4
    //   3077: lstore 20
    //   3079: lload_2
    //   3080: lstore 14
    //   3082: lload 4
    //   3084: lstore 24
    //   3086: lload_2
    //   3087: lstore 18
    //   3089: lload 4
    //   3091: lstore 26
    //   3093: lload_2
    //   3094: lstore 16
    //   3096: lload 4
    //   3098: lstore 22
    //   3100: lload_2
    //   3101: lstore 10
    //   3103: lload 4
    //   3105: lstore 28
    //   3107: lload_2
    //   3108: lstore 12
    //   3110: ldc_w 565
    //   3113: invokestatic 321	com/tencent/mm/plugin/music/f/c/b:bm	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/music/f/c/a;
    //   3116: checkcast 565	com/tencent/mm/plugin/music/cache/c
    //   3119: aload 38
    //   3121: aload 39
    //   3123: invokeinterface 568 3 0
    //   3128: aload 33
    //   3130: astore 37
    //   3132: aload 34
    //   3134: astore 36
    //   3136: lload 4
    //   3138: lstore 8
    //   3140: lload_2
    //   3141: lstore 6
    //   3143: aload 45
    //   3145: astore 35
    //   3147: lload 4
    //   3149: lstore 20
    //   3151: lload_2
    //   3152: lstore 14
    //   3154: lload 4
    //   3156: lstore 24
    //   3158: lload_2
    //   3159: lstore 18
    //   3161: lload 4
    //   3163: lstore 26
    //   3165: lload_2
    //   3166: lstore 16
    //   3168: lload 4
    //   3170: lstore 22
    //   3172: lload_2
    //   3173: lstore 10
    //   3175: lload 4
    //   3177: lstore 28
    //   3179: lload_2
    //   3180: lstore 12
    //   3182: aload 34
    //   3184: ldc_w 570
    //   3187: invokevirtual 253	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3190: astore 38
    //   3192: aload 33
    //   3194: astore 37
    //   3196: aload 34
    //   3198: astore 36
    //   3200: lload 4
    //   3202: lstore 8
    //   3204: lload_2
    //   3205: lstore 6
    //   3207: aload 45
    //   3209: astore 35
    //   3211: lload 4
    //   3213: lstore 20
    //   3215: lload_2
    //   3216: lstore 14
    //   3218: lload 4
    //   3220: lstore 24
    //   3222: lload_2
    //   3223: lstore 18
    //   3225: lload 4
    //   3227: lstore 26
    //   3229: lload_2
    //   3230: lstore 16
    //   3232: lload 4
    //   3234: lstore 22
    //   3236: lload_2
    //   3237: lstore 10
    //   3239: lload 4
    //   3241: lstore 28
    //   3243: lload_2
    //   3244: lstore 12
    //   3246: aload 38
    //   3248: invokestatic 572	com/tencent/mm/plugin/music/c/b:aRY	(Ljava/lang/String;)[J
    //   3251: astore 39
    //   3253: aload 33
    //   3255: astore 37
    //   3257: aload 34
    //   3259: astore 36
    //   3261: lload 4
    //   3263: lstore 8
    //   3265: lload_2
    //   3266: lstore 6
    //   3268: aload 45
    //   3270: astore 35
    //   3272: lload 4
    //   3274: lstore 20
    //   3276: lload_2
    //   3277: lstore 14
    //   3279: lload 4
    //   3281: lstore 24
    //   3283: lload_2
    //   3284: lstore 18
    //   3286: lload 4
    //   3288: lstore 26
    //   3290: lload_2
    //   3291: lstore 16
    //   3293: lload 4
    //   3295: lstore 22
    //   3297: lload_2
    //   3298: lstore 10
    //   3300: lload 4
    //   3302: lstore 28
    //   3304: lload_2
    //   3305: lstore 12
    //   3307: aload 34
    //   3309: ldc_w 574
    //   3312: invokevirtual 253	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3315: lconst_0
    //   3316: invokestatic 578	com/tencent/mm/sdk/platformtools/Util:getLong	(Ljava/lang/String;J)J
    //   3319: lstore 30
    //   3321: aload 33
    //   3323: astore 37
    //   3325: aload 34
    //   3327: astore 36
    //   3329: lload 4
    //   3331: lstore 8
    //   3333: lload_2
    //   3334: lstore 6
    //   3336: aload 45
    //   3338: astore 35
    //   3340: lload 4
    //   3342: lstore 20
    //   3344: lload_2
    //   3345: lstore 14
    //   3347: lload 4
    //   3349: lstore 24
    //   3351: lload_2
    //   3352: lstore 18
    //   3354: lload 4
    //   3356: lstore 26
    //   3358: lload_2
    //   3359: lstore 16
    //   3361: lload 4
    //   3363: lstore 22
    //   3365: lload_2
    //   3366: lstore 10
    //   3368: lload 4
    //   3370: lstore 28
    //   3372: lload_2
    //   3373: lstore 12
    //   3375: ldc 85
    //   3377: ldc_w 580
    //   3380: iconst_2
    //   3381: anewarray 4	java/lang/Object
    //   3384: dup
    //   3385: iconst_0
    //   3386: aload 38
    //   3388: aastore
    //   3389: dup
    //   3390: iconst_1
    //   3391: lload 30
    //   3393: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3396: aastore
    //   3397: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3400: aload 39
    //   3402: ifnonnull +1089 -> 4491
    //   3405: aload 33
    //   3407: astore 37
    //   3409: aload 34
    //   3411: astore 36
    //   3413: lload 4
    //   3415: lstore 8
    //   3417: lload_2
    //   3418: lstore 6
    //   3420: aload 45
    //   3422: astore 35
    //   3424: lload 4
    //   3426: lstore 20
    //   3428: lload_2
    //   3429: lstore 14
    //   3431: lload 4
    //   3433: lstore 24
    //   3435: lload_2
    //   3436: lstore 18
    //   3438: lload 4
    //   3440: lstore 26
    //   3442: lload_2
    //   3443: lstore 16
    //   3445: lload 4
    //   3447: lstore 22
    //   3449: lload_2
    //   3450: lstore 10
    //   3452: lload 4
    //   3454: lstore 28
    //   3456: lload_2
    //   3457: lstore 12
    //   3459: ldc 85
    //   3461: ldc_w 582
    //   3464: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3467: lload_2
    //   3468: lstore 4
    //   3470: lload_2
    //   3471: lconst_0
    //   3472: lcmp
    //   3473: ifeq +4382 -> 7855
    //   3476: lconst_0
    //   3477: lstore 4
    //   3479: goto +4376 -> 7855
    //   3482: aload 33
    //   3484: astore 37
    //   3486: aload 34
    //   3488: astore 36
    //   3490: lload 4
    //   3492: lstore 8
    //   3494: lload_2
    //   3495: lstore 6
    //   3497: aload 45
    //   3499: astore 35
    //   3501: lload 4
    //   3503: lstore 20
    //   3505: lload_2
    //   3506: lstore 14
    //   3508: lload 4
    //   3510: lstore 24
    //   3512: lload_2
    //   3513: lstore 18
    //   3515: lload 4
    //   3517: lstore 26
    //   3519: lload_2
    //   3520: lstore 16
    //   3522: lload 4
    //   3524: lstore 22
    //   3526: lload_2
    //   3527: lstore 10
    //   3529: lload 4
    //   3531: lstore 28
    //   3533: lload_2
    //   3534: lstore 12
    //   3536: ldc 85
    //   3538: ldc_w 584
    //   3541: iconst_3
    //   3542: anewarray 4	java/lang/Object
    //   3545: dup
    //   3546: iconst_0
    //   3547: lload 30
    //   3549: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3552: aastore
    //   3553: dup
    //   3554: iconst_1
    //   3555: lload_2
    //   3556: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3559: aastore
    //   3560: dup
    //   3561: iconst_2
    //   3562: aload_0
    //   3563: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3566: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3569: aastore
    //   3570: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3573: aload 33
    //   3575: astore 37
    //   3577: aload 34
    //   3579: astore 36
    //   3581: lload 4
    //   3583: lstore 8
    //   3585: lload_2
    //   3586: lstore 6
    //   3588: aload 45
    //   3590: astore 35
    //   3592: lload 4
    //   3594: lstore 20
    //   3596: lload_2
    //   3597: lstore 14
    //   3599: lload 4
    //   3601: lstore 24
    //   3603: lload_2
    //   3604: lstore 18
    //   3606: lload 4
    //   3608: lstore 26
    //   3610: lload_2
    //   3611: lstore 16
    //   3613: lload 4
    //   3615: lstore 22
    //   3617: lload_2
    //   3618: lstore 10
    //   3620: lload 4
    //   3622: lstore 28
    //   3624: lload_2
    //   3625: lstore 12
    //   3627: aload 33
    //   3629: lload 30
    //   3631: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   3634: aload 33
    //   3636: astore 37
    //   3638: aload 34
    //   3640: astore 36
    //   3642: lload 4
    //   3644: lstore 8
    //   3646: lload_2
    //   3647: lstore 6
    //   3649: aload 45
    //   3651: astore 35
    //   3653: lload 4
    //   3655: lstore 20
    //   3657: lload_2
    //   3658: lstore 14
    //   3660: lload 4
    //   3662: lstore 24
    //   3664: lload_2
    //   3665: lstore 18
    //   3667: lload 4
    //   3669: lstore 26
    //   3671: lload_2
    //   3672: lstore 16
    //   3674: lload 4
    //   3676: lstore 22
    //   3678: lload_2
    //   3679: lstore 10
    //   3681: lload 4
    //   3683: lstore 28
    //   3685: lload_2
    //   3686: lstore 12
    //   3688: aload 33
    //   3690: lload_2
    //   3691: invokevirtual 587	java/io/RandomAccessFile:seek	(J)V
    //   3694: aload 33
    //   3696: astore 37
    //   3698: aload 34
    //   3700: astore 36
    //   3702: lload 4
    //   3704: lstore 8
    //   3706: lload_2
    //   3707: lstore 6
    //   3709: aload 45
    //   3711: astore 35
    //   3713: lload 4
    //   3715: lstore 20
    //   3717: lload_2
    //   3718: lstore 14
    //   3720: lload 4
    //   3722: lstore 24
    //   3724: lload_2
    //   3725: lstore 18
    //   3727: lload 4
    //   3729: lstore 26
    //   3731: lload_2
    //   3732: lstore 16
    //   3734: lload 4
    //   3736: lstore 22
    //   3738: lload_2
    //   3739: lstore 10
    //   3741: lload 4
    //   3743: lstore 28
    //   3745: lload_2
    //   3746: lstore 12
    //   3748: aload 34
    //   3750: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3753: astore 38
    //   3755: aload 38
    //   3757: astore 35
    //   3759: lload_2
    //   3760: lstore 18
    //   3762: lload_2
    //   3763: lstore 16
    //   3765: aload 33
    //   3767: astore 37
    //   3769: aload 35
    //   3771: astore 38
    //   3773: aload 34
    //   3775: astore 36
    //   3777: lload 4
    //   3779: lstore 20
    //   3781: lload_2
    //   3782: lstore 8
    //   3784: lload_2
    //   3785: lstore 10
    //   3787: lload_2
    //   3788: lstore 12
    //   3790: lload_2
    //   3791: lstore 14
    //   3793: sipush 4096
    //   3796: newarray byte
    //   3798: astore 39
    //   3800: lload_2
    //   3801: lstore 18
    //   3803: lload_2
    //   3804: lstore 16
    //   3806: aload 33
    //   3808: astore 37
    //   3810: aload 35
    //   3812: astore 38
    //   3814: aload 34
    //   3816: astore 36
    //   3818: lload 4
    //   3820: lstore 20
    //   3822: lload_2
    //   3823: lstore 8
    //   3825: lload_2
    //   3826: lstore 10
    //   3828: lload_2
    //   3829: lstore 12
    //   3831: lload_2
    //   3832: lstore 14
    //   3834: aload_0
    //   3835: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3838: ifne +1473 -> 5311
    //   3841: lload_2
    //   3842: lstore 18
    //   3844: lload_2
    //   3845: lstore 16
    //   3847: aload 33
    //   3849: astore 37
    //   3851: aload 35
    //   3853: astore 38
    //   3855: aload 34
    //   3857: astore 36
    //   3859: lload 4
    //   3861: lstore 20
    //   3863: lload_2
    //   3864: lstore 8
    //   3866: lload_2
    //   3867: lstore 10
    //   3869: lload_2
    //   3870: lstore 12
    //   3872: lload_2
    //   3873: lstore 14
    //   3875: aload 35
    //   3877: aload 39
    //   3879: invokevirtual 591	java/io/InputStream:read	([B)I
    //   3882: istore_1
    //   3883: iload_1
    //   3884: ifle +1349 -> 5233
    //   3887: lload_2
    //   3888: lstore 18
    //   3890: lload_2
    //   3891: lstore 16
    //   3893: aload 33
    //   3895: astore 37
    //   3897: aload 35
    //   3899: astore 38
    //   3901: aload 34
    //   3903: astore 36
    //   3905: lload 4
    //   3907: lstore 20
    //   3909: lload_2
    //   3910: lstore 8
    //   3912: lload_2
    //   3913: lstore 10
    //   3915: lload_2
    //   3916: lstore 12
    //   3918: lload_2
    //   3919: lstore 14
    //   3921: aload 33
    //   3923: aload 39
    //   3925: iconst_0
    //   3926: iload_1
    //   3927: invokevirtual 595	java/io/RandomAccessFile:write	([BII)V
    //   3930: lload_2
    //   3931: iload_1
    //   3932: i2l
    //   3933: ladd
    //   3934: lstore 6
    //   3936: lload 6
    //   3938: lstore 18
    //   3940: lload 6
    //   3942: lstore 16
    //   3944: aload 33
    //   3946: astore 37
    //   3948: aload 35
    //   3950: astore 38
    //   3952: aload 34
    //   3954: astore 36
    //   3956: lload 4
    //   3958: lstore 20
    //   3960: lload 6
    //   3962: lstore 8
    //   3964: lload 6
    //   3966: lstore 10
    //   3968: lload 6
    //   3970: lstore 12
    //   3972: lload 6
    //   3974: lstore 14
    //   3976: ldc 85
    //   3978: ldc_w 597
    //   3981: iconst_2
    //   3982: anewarray 4	java/lang/Object
    //   3985: dup
    //   3986: iconst_0
    //   3987: lload 6
    //   3989: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3992: aastore
    //   3993: dup
    //   3994: iconst_1
    //   3995: lload 30
    //   3997: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4000: aastore
    //   4001: invokestatic 600	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4004: lload 6
    //   4006: lstore 18
    //   4008: lload 6
    //   4010: lstore 16
    //   4012: aload 33
    //   4014: astore 37
    //   4016: aload 35
    //   4018: astore 38
    //   4020: aload 34
    //   4022: astore 36
    //   4024: lload 4
    //   4026: lstore 20
    //   4028: lload 6
    //   4030: lstore 8
    //   4032: lload 6
    //   4034: lstore 10
    //   4036: lload 6
    //   4038: lstore 12
    //   4040: lload 6
    //   4042: lstore 14
    //   4044: aload_0
    //   4045: getfield 107	com/tencent/mm/plugin/music/c/b:wIk	Z
    //   4048: ifeq +874 -> 4922
    //   4051: lload 6
    //   4053: lstore 18
    //   4055: lload 6
    //   4057: lstore 16
    //   4059: aload 33
    //   4061: astore 37
    //   4063: aload 35
    //   4065: astore 38
    //   4067: aload 34
    //   4069: astore 36
    //   4071: lload 4
    //   4073: lstore 20
    //   4075: lload 6
    //   4077: lstore 8
    //   4079: lload 6
    //   4081: lstore 10
    //   4083: lload 6
    //   4085: lstore 12
    //   4087: lload 6
    //   4089: lstore 14
    //   4091: aload_0
    //   4092: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   4095: lload 6
    //   4097: putfield 77	com/tencent/mm/plugin/music/c/a:FPT	J
    //   4100: lload 6
    //   4102: lstore 18
    //   4104: lload 6
    //   4106: lstore 16
    //   4108: aload 33
    //   4110: astore 37
    //   4112: aload 35
    //   4114: astore 38
    //   4116: aload 34
    //   4118: astore 36
    //   4120: lload 4
    //   4122: lstore 20
    //   4124: lload 6
    //   4126: lstore 8
    //   4128: lload 6
    //   4130: lstore 10
    //   4132: lload 6
    //   4134: lstore 12
    //   4136: lload 6
    //   4138: lstore 14
    //   4140: aload_0
    //   4141: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   4144: lload 30
    //   4146: putfield 80	com/tencent/mm/plugin/music/c/a:FPV	J
    //   4149: lload 6
    //   4151: lstore_2
    //   4152: lload 6
    //   4154: ldc2_w 393
    //   4157: lcmp
    //   4158: iflt -358 -> 3800
    //   4161: lload 6
    //   4163: lstore 18
    //   4165: lload 6
    //   4167: lstore 16
    //   4169: aload 33
    //   4171: astore 37
    //   4173: aload 35
    //   4175: astore 38
    //   4177: aload 34
    //   4179: astore 36
    //   4181: lload 4
    //   4183: lstore 20
    //   4185: lload 6
    //   4187: lstore 8
    //   4189: lload 6
    //   4191: lstore 10
    //   4193: lload 6
    //   4195: lstore 12
    //   4197: lload 6
    //   4199: lstore 14
    //   4201: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4204: dup
    //   4205: aload_0
    //   4206: iconst_1
    //   4207: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4210: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4213: lload 6
    //   4215: lstore_2
    //   4216: goto -416 -> 3800
    //   4219: astore 39
    //   4221: lload 18
    //   4223: lstore_2
    //   4224: aload 33
    //   4226: astore 37
    //   4228: aload 35
    //   4230: astore 38
    //   4232: aload 34
    //   4234: astore 36
    //   4236: lload 4
    //   4238: lstore 20
    //   4240: lload_2
    //   4241: lstore 8
    //   4243: ldc 85
    //   4245: aload 39
    //   4247: ldc_w 602
    //   4250: iconst_1
    //   4251: anewarray 4	java/lang/Object
    //   4254: dup
    //   4255: iconst_0
    //   4256: aload 52
    //   4258: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   4261: aastore
    //   4262: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4265: aload 33
    //   4267: astore 37
    //   4269: aload 35
    //   4271: astore 38
    //   4273: aload 34
    //   4275: astore 36
    //   4277: lload 4
    //   4279: lstore 20
    //   4281: lload_2
    //   4282: lstore 8
    //   4284: aload_0
    //   4285: sipush 750
    //   4288: putfield 59	com/tencent/mm/plugin/music/c/b:fnU	I
    //   4291: aload 33
    //   4293: astore 37
    //   4295: aload 35
    //   4297: astore 38
    //   4299: aload 34
    //   4301: astore 36
    //   4303: lload 4
    //   4305: lstore 20
    //   4307: lload_2
    //   4308: lstore 8
    //   4310: aload_0
    //   4311: iconst_5
    //   4312: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   4315: lload 4
    //   4317: lconst_0
    //   4318: lcmp
    //   4319: ifne +1381 -> 5700
    //   4322: lload_2
    //   4323: lconst_0
    //   4324: lcmp
    //   4325: ifle +1375 -> 5700
    //   4328: ldc 85
    //   4330: ldc_w 452
    //   4333: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4336: aload 33
    //   4338: lload_2
    //   4339: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   4342: aload_0
    //   4343: lload_2
    //   4344: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   4347: lload_2
    //   4348: ldc2_w 393
    //   4351: lcmp
    //   4352: ifge +15 -> 4367
    //   4355: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4358: dup
    //   4359: aload_0
    //   4360: iconst_1
    //   4361: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4364: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4367: aload 35
    //   4369: ifnull +8 -> 4377
    //   4372: aload 35
    //   4374: invokevirtual 139	java/io/InputStream:close	()V
    //   4377: aload 33
    //   4379: ifnull +8 -> 4387
    //   4382: aload 33
    //   4384: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   4387: aload 34
    //   4389: ifnull +16 -> 4405
    //   4392: aload 34
    //   4394: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4397: invokevirtual 139	java/io/InputStream:close	()V
    //   4400: aload 34
    //   4402: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   4405: aload_0
    //   4406: iconst_1
    //   4407: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4410: ldc 85
    //   4412: ldc_w 459
    //   4415: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4418: ldc_w 374
    //   4421: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4424: return
    //   4425: aload 33
    //   4427: astore 37
    //   4429: aload 34
    //   4431: astore 36
    //   4433: lload 4
    //   4435: lstore 8
    //   4437: lload_2
    //   4438: lstore 6
    //   4440: aload 45
    //   4442: astore 35
    //   4444: lload 4
    //   4446: lstore 20
    //   4448: lload_2
    //   4449: lstore 14
    //   4451: lload 4
    //   4453: lstore 24
    //   4455: lload_2
    //   4456: lstore 18
    //   4458: lload 4
    //   4460: lstore 26
    //   4462: lload_2
    //   4463: lstore 16
    //   4465: lload 4
    //   4467: lstore 22
    //   4469: lload_2
    //   4470: lstore 10
    //   4472: lload 4
    //   4474: lstore 28
    //   4476: lload_2
    //   4477: lstore 12
    //   4479: ldc_w 604
    //   4482: ldc_w 606
    //   4485: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4488: goto -1360 -> 3128
    //   4491: lload_2
    //   4492: lconst_0
    //   4493: lcmp
    //   4494: ifle +419 -> 4913
    //   4497: lload_2
    //   4498: aload 39
    //   4500: iconst_0
    //   4501: laload
    //   4502: lcmp
    //   4503: ifeq +410 -> 4913
    //   4506: aload 33
    //   4508: astore 37
    //   4510: aload 34
    //   4512: astore 36
    //   4514: lload 4
    //   4516: lstore 8
    //   4518: lload_2
    //   4519: lstore 6
    //   4521: aload 45
    //   4523: astore 35
    //   4525: lload 4
    //   4527: lstore 20
    //   4529: lload_2
    //   4530: lstore 14
    //   4532: lload 4
    //   4534: lstore 24
    //   4536: lload_2
    //   4537: lstore 18
    //   4539: lload 4
    //   4541: lstore 26
    //   4543: lload_2
    //   4544: lstore 16
    //   4546: lload 4
    //   4548: lstore 22
    //   4550: lload_2
    //   4551: lstore 10
    //   4553: lload 4
    //   4555: lstore 28
    //   4557: lload_2
    //   4558: lstore 12
    //   4560: ldc 85
    //   4562: ldc_w 608
    //   4565: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4568: aload 33
    //   4570: astore 37
    //   4572: aload 34
    //   4574: astore 36
    //   4576: lload 4
    //   4578: lstore 8
    //   4580: lload_2
    //   4581: lstore 6
    //   4583: aload 45
    //   4585: astore 35
    //   4587: lload 4
    //   4589: lstore 20
    //   4591: lload_2
    //   4592: lstore 14
    //   4594: lload 4
    //   4596: lstore 24
    //   4598: lload_2
    //   4599: lstore 18
    //   4601: lload 4
    //   4603: lstore 26
    //   4605: lload_2
    //   4606: lstore 16
    //   4608: lload 4
    //   4610: lstore 22
    //   4612: lload_2
    //   4613: lstore 10
    //   4615: lload 4
    //   4617: lstore 28
    //   4619: lload_2
    //   4620: lstore 12
    //   4622: aload_0
    //   4623: bipush 6
    //   4625: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   4628: lload 4
    //   4630: lconst_0
    //   4631: lcmp
    //   4632: ifne +115 -> 4747
    //   4635: lload_2
    //   4636: lconst_0
    //   4637: lcmp
    //   4638: ifle +109 -> 4747
    //   4641: ldc 85
    //   4643: ldc_w 452
    //   4646: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4649: aload 33
    //   4651: lload_2
    //   4652: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   4655: aload_0
    //   4656: lload_2
    //   4657: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   4660: lload_2
    //   4661: ldc2_w 393
    //   4664: lcmp
    //   4665: ifge +15 -> 4680
    //   4668: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4671: dup
    //   4672: aload_0
    //   4673: iconst_1
    //   4674: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4677: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4680: aload 33
    //   4682: ifnull +8 -> 4690
    //   4685: aload 33
    //   4687: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   4690: aload 34
    //   4692: ifnull +16 -> 4708
    //   4695: aload 34
    //   4697: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4700: invokevirtual 139	java/io/InputStream:close	()V
    //   4703: aload 34
    //   4705: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   4708: aload_0
    //   4709: iconst_1
    //   4710: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   4713: ldc 85
    //   4715: ldc_w 459
    //   4718: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4721: ldc_w 374
    //   4724: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4727: return
    //   4728: astore 35
    //   4730: ldc 85
    //   4732: aload 35
    //   4734: ldc_w 461
    //   4737: iconst_0
    //   4738: anewarray 4	java/lang/Object
    //   4741: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4744: goto -89 -> 4655
    //   4747: lload 4
    //   4749: lconst_0
    //   4750: lcmp
    //   4751: ifeq +47 -> 4798
    //   4754: lload_2
    //   4755: lload 4
    //   4757: lcmp
    //   4758: ifeq +40 -> 4798
    //   4761: ldc 85
    //   4763: ldc_w 463
    //   4766: iconst_2
    //   4767: anewarray 4	java/lang/Object
    //   4770: dup
    //   4771: iconst_0
    //   4772: lload 4
    //   4774: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4777: aastore
    //   4778: dup
    //   4779: iconst_1
    //   4780: lload_2
    //   4781: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4784: aastore
    //   4785: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4788: aload_0
    //   4789: lload_2
    //   4790: lload 4
    //   4792: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   4795: goto -115 -> 4680
    //   4798: lload 4
    //   4800: lconst_0
    //   4801: lcmp
    //   4802: ifeq +66 -> 4868
    //   4805: lload_2
    //   4806: lload 4
    //   4808: lcmp
    //   4809: ifne +59 -> 4868
    //   4812: ldc 85
    //   4814: ldc_w 467
    //   4817: iconst_2
    //   4818: anewarray 4	java/lang/Object
    //   4821: dup
    //   4822: iconst_0
    //   4823: lload 4
    //   4825: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4828: aastore
    //   4829: dup
    //   4830: iconst_1
    //   4831: lload_2
    //   4832: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4835: aastore
    //   4836: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4839: aload_0
    //   4840: lload 4
    //   4842: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   4845: lload_2
    //   4846: ldc2_w 393
    //   4849: lcmp
    //   4850: ifge -170 -> 4680
    //   4853: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4856: dup
    //   4857: aload_0
    //   4858: iconst_1
    //   4859: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4862: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4865: goto -185 -> 4680
    //   4868: ldc 85
    //   4870: ldc_w 469
    //   4873: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4876: goto -196 -> 4680
    //   4879: astore 33
    //   4881: ldc 85
    //   4883: aload 33
    //   4885: ldc_w 461
    //   4888: iconst_0
    //   4889: anewarray 4	java/lang/Object
    //   4892: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4895: goto -205 -> 4690
    //   4898: astore 33
    //   4900: ldc 85
    //   4902: aload 33
    //   4904: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4907: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4910: goto -207 -> 4703
    //   4913: aload 39
    //   4915: iconst_2
    //   4916: laload
    //   4917: lstore 4
    //   4919: goto +2947 -> 7866
    //   4922: lload 6
    //   4924: lstore 18
    //   4926: lload 6
    //   4928: lstore 16
    //   4930: aload 33
    //   4932: astore 37
    //   4934: aload 35
    //   4936: astore 38
    //   4938: aload 34
    //   4940: astore 36
    //   4942: lload 4
    //   4944: lstore 20
    //   4946: lload 6
    //   4948: lstore 8
    //   4950: lload 6
    //   4952: lstore 10
    //   4954: lload 6
    //   4956: lstore 12
    //   4958: lload 6
    //   4960: lstore 14
    //   4962: aload_0
    //   4963: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   4966: lload 6
    //   4968: putfield 68	com/tencent/mm/plugin/music/c/a:FPR	J
    //   4971: lload 6
    //   4973: lstore 18
    //   4975: lload 6
    //   4977: lstore 16
    //   4979: aload 33
    //   4981: astore 37
    //   4983: aload 35
    //   4985: astore 38
    //   4987: aload 34
    //   4989: astore 36
    //   4991: lload 4
    //   4993: lstore 20
    //   4995: lload 6
    //   4997: lstore 8
    //   4999: lload 6
    //   5001: lstore 10
    //   5003: lload 6
    //   5005: lstore 12
    //   5007: lload 6
    //   5009: lstore 14
    //   5011: aload_0
    //   5012: getfield 63	com/tencent/mm/plugin/music/c/b:FPY	Lcom/tencent/mm/plugin/music/c/a;
    //   5015: lload 30
    //   5017: putfield 71	com/tencent/mm/plugin/music/c/a:FPS	J
    //   5020: goto -871 -> 4149
    //   5023: astore 38
    //   5025: aload 35
    //   5027: astore 39
    //   5029: lload 16
    //   5031: lstore_2
    //   5032: aload 33
    //   5034: astore 37
    //   5036: aload 34
    //   5038: astore 36
    //   5040: lload 4
    //   5042: lstore 8
    //   5044: lload_2
    //   5045: lstore 6
    //   5047: aload 39
    //   5049: astore 35
    //   5051: ldc 85
    //   5053: aload 38
    //   5055: ldc_w 602
    //   5058: iconst_1
    //   5059: anewarray 4	java/lang/Object
    //   5062: dup
    //   5063: iconst_0
    //   5064: aload 52
    //   5066: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   5069: aastore
    //   5070: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5073: aload 33
    //   5075: astore 37
    //   5077: aload 34
    //   5079: astore 36
    //   5081: lload 4
    //   5083: lstore 8
    //   5085: lload_2
    //   5086: lstore 6
    //   5088: aload 39
    //   5090: astore 35
    //   5092: aload_0
    //   5093: sipush 751
    //   5096: putfield 59	com/tencent/mm/plugin/music/c/b:fnU	I
    //   5099: aload 33
    //   5101: astore 37
    //   5103: aload 34
    //   5105: astore 36
    //   5107: lload 4
    //   5109: lstore 8
    //   5111: lload_2
    //   5112: lstore 6
    //   5114: aload 39
    //   5116: astore 35
    //   5118: aload_0
    //   5119: iconst_5
    //   5120: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   5123: lload 4
    //   5125: lconst_0
    //   5126: lcmp
    //   5127: ifne +777 -> 5904
    //   5130: lload_2
    //   5131: lconst_0
    //   5132: lcmp
    //   5133: ifle +771 -> 5904
    //   5136: ldc 85
    //   5138: ldc_w 452
    //   5141: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5144: aload 33
    //   5146: lload_2
    //   5147: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   5150: aload_0
    //   5151: lload_2
    //   5152: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   5155: lload_2
    //   5156: ldc2_w 393
    //   5159: lcmp
    //   5160: ifge +15 -> 5175
    //   5163: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5166: dup
    //   5167: aload_0
    //   5168: iconst_1
    //   5169: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5172: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5175: aload 39
    //   5177: ifnull +8 -> 5185
    //   5180: aload 39
    //   5182: invokevirtual 139	java/io/InputStream:close	()V
    //   5185: aload 33
    //   5187: ifnull +8 -> 5195
    //   5190: aload 33
    //   5192: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   5195: aload 34
    //   5197: ifnull +16 -> 5213
    //   5200: aload 34
    //   5202: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5205: invokevirtual 139	java/io/InputStream:close	()V
    //   5208: aload 34
    //   5210: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   5213: aload_0
    //   5214: iconst_1
    //   5215: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5218: ldc 85
    //   5220: ldc_w 459
    //   5223: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5226: ldc_w 374
    //   5229: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5232: return
    //   5233: lload_2
    //   5234: lstore 18
    //   5236: lload_2
    //   5237: lstore 16
    //   5239: aload 33
    //   5241: astore 37
    //   5243: aload 35
    //   5245: astore 38
    //   5247: aload 34
    //   5249: astore 36
    //   5251: lload 4
    //   5253: lstore 20
    //   5255: lload_2
    //   5256: lstore 8
    //   5258: lload_2
    //   5259: lstore 10
    //   5261: lload_2
    //   5262: lstore 12
    //   5264: lload_2
    //   5265: lstore 14
    //   5267: ldc 85
    //   5269: ldc_w 610
    //   5272: iconst_4
    //   5273: anewarray 4	java/lang/Object
    //   5276: dup
    //   5277: iconst_0
    //   5278: iload_1
    //   5279: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5282: aastore
    //   5283: dup
    //   5284: iconst_1
    //   5285: aload_0
    //   5286: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5289: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5292: aastore
    //   5293: dup
    //   5294: iconst_2
    //   5295: lload_2
    //   5296: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5299: aastore
    //   5300: dup
    //   5301: iconst_3
    //   5302: lload 30
    //   5304: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5307: aastore
    //   5308: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5311: lload_2
    //   5312: lstore 18
    //   5314: lload_2
    //   5315: lstore 16
    //   5317: aload 33
    //   5319: astore 37
    //   5321: aload 35
    //   5323: astore 38
    //   5325: aload 34
    //   5327: astore 36
    //   5329: lload 4
    //   5331: lstore 20
    //   5333: lload_2
    //   5334: lstore 8
    //   5336: lload_2
    //   5337: lstore 10
    //   5339: lload_2
    //   5340: lstore 12
    //   5342: lload_2
    //   5343: lstore 14
    //   5345: ldc 85
    //   5347: ldc_w 612
    //   5350: iconst_1
    //   5351: anewarray 4	java/lang/Object
    //   5354: dup
    //   5355: iconst_0
    //   5356: aload_0
    //   5357: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5360: invokestatic 418	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5363: aastore
    //   5364: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5367: lload 4
    //   5369: lconst_0
    //   5370: lcmp
    //   5371: ifne +125 -> 5496
    //   5374: lload_2
    //   5375: lconst_0
    //   5376: lcmp
    //   5377: ifle +119 -> 5496
    //   5380: ldc 85
    //   5382: ldc_w 452
    //   5385: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5388: aload 33
    //   5390: lload_2
    //   5391: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   5394: aload_0
    //   5395: lload_2
    //   5396: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   5399: lload_2
    //   5400: ldc2_w 393
    //   5403: lcmp
    //   5404: ifge +15 -> 5419
    //   5407: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5410: dup
    //   5411: aload_0
    //   5412: iconst_1
    //   5413: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5416: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5419: aload 35
    //   5421: ifnull +8 -> 5429
    //   5424: aload 35
    //   5426: invokevirtual 139	java/io/InputStream:close	()V
    //   5429: aload 33
    //   5431: ifnull +8 -> 5439
    //   5434: aload 33
    //   5436: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   5439: aload 34
    //   5441: ifnull +16 -> 5457
    //   5444: aload 34
    //   5446: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5449: invokevirtual 139	java/io/InputStream:close	()V
    //   5452: aload 34
    //   5454: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   5457: aload_0
    //   5458: iconst_1
    //   5459: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5462: ldc 85
    //   5464: ldc_w 459
    //   5467: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5470: ldc_w 374
    //   5473: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5476: return
    //   5477: astore 36
    //   5479: ldc 85
    //   5481: aload 36
    //   5483: ldc_w 461
    //   5486: iconst_0
    //   5487: anewarray 4	java/lang/Object
    //   5490: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5493: goto -99 -> 5394
    //   5496: lload 4
    //   5498: lconst_0
    //   5499: lcmp
    //   5500: ifeq +47 -> 5547
    //   5503: lload_2
    //   5504: lload 4
    //   5506: lcmp
    //   5507: ifeq +40 -> 5547
    //   5510: ldc 85
    //   5512: ldc_w 463
    //   5515: iconst_2
    //   5516: anewarray 4	java/lang/Object
    //   5519: dup
    //   5520: iconst_0
    //   5521: lload 4
    //   5523: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5526: aastore
    //   5527: dup
    //   5528: iconst_1
    //   5529: lload_2
    //   5530: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5533: aastore
    //   5534: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5537: aload_0
    //   5538: lload_2
    //   5539: lload 4
    //   5541: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   5544: goto -125 -> 5419
    //   5547: lload 4
    //   5549: lconst_0
    //   5550: lcmp
    //   5551: ifeq +66 -> 5617
    //   5554: lload_2
    //   5555: lload 4
    //   5557: lcmp
    //   5558: ifne +59 -> 5617
    //   5561: ldc 85
    //   5563: ldc_w 467
    //   5566: iconst_2
    //   5567: anewarray 4	java/lang/Object
    //   5570: dup
    //   5571: iconst_0
    //   5572: lload 4
    //   5574: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5577: aastore
    //   5578: dup
    //   5579: iconst_1
    //   5580: lload_2
    //   5581: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5584: aastore
    //   5585: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5588: aload_0
    //   5589: lload 4
    //   5591: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   5594: lload_2
    //   5595: ldc2_w 393
    //   5598: lcmp
    //   5599: ifge -180 -> 5419
    //   5602: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5605: dup
    //   5606: aload_0
    //   5607: iconst_1
    //   5608: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5611: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5614: goto -195 -> 5419
    //   5617: ldc 85
    //   5619: ldc_w 469
    //   5622: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5625: goto -206 -> 5419
    //   5628: astore 35
    //   5630: ldc 85
    //   5632: aload 35
    //   5634: ldc_w 614
    //   5637: iconst_0
    //   5638: anewarray 4	java/lang/Object
    //   5641: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5644: goto -215 -> 5429
    //   5647: astore 33
    //   5649: ldc 85
    //   5651: aload 33
    //   5653: ldc_w 461
    //   5656: iconst_0
    //   5657: anewarray 4	java/lang/Object
    //   5660: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5663: goto -224 -> 5439
    //   5666: astore 33
    //   5668: ldc 85
    //   5670: aload 33
    //   5672: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5675: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5678: goto -226 -> 5452
    //   5681: astore 36
    //   5683: ldc 85
    //   5685: aload 36
    //   5687: ldc_w 461
    //   5690: iconst_0
    //   5691: anewarray 4	java/lang/Object
    //   5694: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5697: goto -1355 -> 4342
    //   5700: lload 4
    //   5702: lconst_0
    //   5703: lcmp
    //   5704: ifeq +47 -> 5751
    //   5707: lload_2
    //   5708: lload 4
    //   5710: lcmp
    //   5711: ifeq +40 -> 5751
    //   5714: ldc 85
    //   5716: ldc_w 463
    //   5719: iconst_2
    //   5720: anewarray 4	java/lang/Object
    //   5723: dup
    //   5724: iconst_0
    //   5725: lload 4
    //   5727: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5730: aastore
    //   5731: dup
    //   5732: iconst_1
    //   5733: lload_2
    //   5734: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5737: aastore
    //   5738: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5741: aload_0
    //   5742: lload_2
    //   5743: lload 4
    //   5745: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   5748: goto -1381 -> 4367
    //   5751: lload 4
    //   5753: lconst_0
    //   5754: lcmp
    //   5755: ifeq +66 -> 5821
    //   5758: lload_2
    //   5759: lload 4
    //   5761: lcmp
    //   5762: ifne +59 -> 5821
    //   5765: ldc 85
    //   5767: ldc_w 467
    //   5770: iconst_2
    //   5771: anewarray 4	java/lang/Object
    //   5774: dup
    //   5775: iconst_0
    //   5776: lload 4
    //   5778: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5781: aastore
    //   5782: dup
    //   5783: iconst_1
    //   5784: lload_2
    //   5785: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5788: aastore
    //   5789: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5792: aload_0
    //   5793: lload 4
    //   5795: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   5798: lload_2
    //   5799: ldc2_w 393
    //   5802: lcmp
    //   5803: ifge -1436 -> 4367
    //   5806: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5809: dup
    //   5810: aload_0
    //   5811: iconst_1
    //   5812: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5815: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5818: goto -1451 -> 4367
    //   5821: ldc 85
    //   5823: ldc_w 469
    //   5826: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5829: goto -1462 -> 4367
    //   5832: astore 35
    //   5834: ldc 85
    //   5836: aload 35
    //   5838: ldc_w 614
    //   5841: iconst_0
    //   5842: anewarray 4	java/lang/Object
    //   5845: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5848: goto -1471 -> 4377
    //   5851: astore 33
    //   5853: ldc 85
    //   5855: aload 33
    //   5857: ldc_w 461
    //   5860: iconst_0
    //   5861: anewarray 4	java/lang/Object
    //   5864: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5867: goto -1480 -> 4387
    //   5870: astore 33
    //   5872: ldc 85
    //   5874: aload 33
    //   5876: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5879: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5882: goto -1482 -> 4400
    //   5885: astore 35
    //   5887: ldc 85
    //   5889: aload 35
    //   5891: ldc_w 461
    //   5894: iconst_0
    //   5895: anewarray 4	java/lang/Object
    //   5898: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5901: goto -751 -> 5150
    //   5904: lload 4
    //   5906: lconst_0
    //   5907: lcmp
    //   5908: ifeq +47 -> 5955
    //   5911: lload_2
    //   5912: lload 4
    //   5914: lcmp
    //   5915: ifeq +40 -> 5955
    //   5918: ldc 85
    //   5920: ldc_w 463
    //   5923: iconst_2
    //   5924: anewarray 4	java/lang/Object
    //   5927: dup
    //   5928: iconst_0
    //   5929: lload 4
    //   5931: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5934: aastore
    //   5935: dup
    //   5936: iconst_1
    //   5937: lload_2
    //   5938: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5941: aastore
    //   5942: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5945: aload_0
    //   5946: lload_2
    //   5947: lload 4
    //   5949: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   5952: goto -777 -> 5175
    //   5955: lload 4
    //   5957: lconst_0
    //   5958: lcmp
    //   5959: ifeq +66 -> 6025
    //   5962: lload_2
    //   5963: lload 4
    //   5965: lcmp
    //   5966: ifne +59 -> 6025
    //   5969: ldc 85
    //   5971: ldc_w 467
    //   5974: iconst_2
    //   5975: anewarray 4	java/lang/Object
    //   5978: dup
    //   5979: iconst_0
    //   5980: lload 4
    //   5982: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5985: aastore
    //   5986: dup
    //   5987: iconst_1
    //   5988: lload_2
    //   5989: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5992: aastore
    //   5993: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5996: aload_0
    //   5997: lload 4
    //   5999: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   6002: lload_2
    //   6003: ldc2_w 393
    //   6006: lcmp
    //   6007: ifge -832 -> 5175
    //   6010: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6013: dup
    //   6014: aload_0
    //   6015: iconst_1
    //   6016: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6019: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6022: goto -847 -> 5175
    //   6025: ldc 85
    //   6027: ldc_w 469
    //   6030: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6033: goto -858 -> 5175
    //   6036: astore 35
    //   6038: ldc 85
    //   6040: aload 35
    //   6042: ldc_w 614
    //   6045: iconst_0
    //   6046: anewarray 4	java/lang/Object
    //   6049: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6052: goto -867 -> 5185
    //   6055: astore 33
    //   6057: ldc 85
    //   6059: aload 33
    //   6061: ldc_w 461
    //   6064: iconst_0
    //   6065: anewarray 4	java/lang/Object
    //   6068: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6071: goto -876 -> 5195
    //   6074: astore 33
    //   6076: ldc 85
    //   6078: aload 33
    //   6080: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6083: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6086: goto -878 -> 5208
    //   6089: astore 39
    //   6091: aconst_null
    //   6092: astore 34
    //   6094: aload 42
    //   6096: astore 38
    //   6098: aload 37
    //   6100: astore 33
    //   6102: aload 33
    //   6104: astore 37
    //   6106: aload 34
    //   6108: astore 36
    //   6110: lload 4
    //   6112: lstore 8
    //   6114: lload_2
    //   6115: lstore 6
    //   6117: aload 38
    //   6119: astore 35
    //   6121: ldc 85
    //   6123: aload 39
    //   6125: ldc_w 602
    //   6128: iconst_1
    //   6129: anewarray 4	java/lang/Object
    //   6132: dup
    //   6133: iconst_0
    //   6134: aload 52
    //   6136: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   6139: aastore
    //   6140: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6143: aload 33
    //   6145: astore 37
    //   6147: aload 34
    //   6149: astore 36
    //   6151: lload 4
    //   6153: lstore 8
    //   6155: lload_2
    //   6156: lstore 6
    //   6158: aload 38
    //   6160: astore 35
    //   6162: aload_0
    //   6163: sipush 752
    //   6166: putfield 59	com/tencent/mm/plugin/music/c/b:fnU	I
    //   6169: aload 33
    //   6171: astore 37
    //   6173: aload 34
    //   6175: astore 36
    //   6177: lload 4
    //   6179: lstore 8
    //   6181: lload_2
    //   6182: lstore 6
    //   6184: aload 38
    //   6186: astore 35
    //   6188: aload_0
    //   6189: iconst_5
    //   6190: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   6193: lload 4
    //   6195: lconst_0
    //   6196: lcmp
    //   6197: ifne +125 -> 6322
    //   6200: lload_2
    //   6201: lconst_0
    //   6202: lcmp
    //   6203: ifle +119 -> 6322
    //   6206: ldc 85
    //   6208: ldc_w 452
    //   6211: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6214: aload 33
    //   6216: lload_2
    //   6217: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   6220: aload_0
    //   6221: lload_2
    //   6222: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   6225: lload_2
    //   6226: ldc2_w 393
    //   6229: lcmp
    //   6230: ifge +15 -> 6245
    //   6233: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6236: dup
    //   6237: aload_0
    //   6238: iconst_1
    //   6239: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6242: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6245: aload 38
    //   6247: ifnull +8 -> 6255
    //   6250: aload 38
    //   6252: invokevirtual 139	java/io/InputStream:close	()V
    //   6255: aload 33
    //   6257: ifnull +8 -> 6265
    //   6260: aload 33
    //   6262: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   6265: aload 34
    //   6267: ifnull +16 -> 6283
    //   6270: aload 34
    //   6272: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6275: invokevirtual 139	java/io/InputStream:close	()V
    //   6278: aload 34
    //   6280: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   6283: aload_0
    //   6284: iconst_1
    //   6285: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6288: ldc 85
    //   6290: ldc_w 459
    //   6293: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6296: ldc_w 374
    //   6299: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6302: return
    //   6303: astore 35
    //   6305: ldc 85
    //   6307: aload 35
    //   6309: ldc_w 461
    //   6312: iconst_0
    //   6313: anewarray 4	java/lang/Object
    //   6316: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6319: goto -99 -> 6220
    //   6322: lload 4
    //   6324: lconst_0
    //   6325: lcmp
    //   6326: ifeq +47 -> 6373
    //   6329: lload_2
    //   6330: lload 4
    //   6332: lcmp
    //   6333: ifeq +40 -> 6373
    //   6336: ldc 85
    //   6338: ldc_w 463
    //   6341: iconst_2
    //   6342: anewarray 4	java/lang/Object
    //   6345: dup
    //   6346: iconst_0
    //   6347: lload 4
    //   6349: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6352: aastore
    //   6353: dup
    //   6354: iconst_1
    //   6355: lload_2
    //   6356: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6359: aastore
    //   6360: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6363: aload_0
    //   6364: lload_2
    //   6365: lload 4
    //   6367: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   6370: goto -125 -> 6245
    //   6373: lload 4
    //   6375: lconst_0
    //   6376: lcmp
    //   6377: ifeq +66 -> 6443
    //   6380: lload_2
    //   6381: lload 4
    //   6383: lcmp
    //   6384: ifne +59 -> 6443
    //   6387: ldc 85
    //   6389: ldc_w 467
    //   6392: iconst_2
    //   6393: anewarray 4	java/lang/Object
    //   6396: dup
    //   6397: iconst_0
    //   6398: lload 4
    //   6400: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6403: aastore
    //   6404: dup
    //   6405: iconst_1
    //   6406: lload_2
    //   6407: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6410: aastore
    //   6411: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6414: aload_0
    //   6415: lload 4
    //   6417: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   6420: lload_2
    //   6421: ldc2_w 393
    //   6424: lcmp
    //   6425: ifge -180 -> 6245
    //   6428: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6431: dup
    //   6432: aload_0
    //   6433: iconst_1
    //   6434: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6437: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6440: goto -195 -> 6245
    //   6443: ldc 85
    //   6445: ldc_w 469
    //   6448: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6451: goto -206 -> 6245
    //   6454: astore 35
    //   6456: ldc 85
    //   6458: aload 35
    //   6460: ldc_w 614
    //   6463: iconst_0
    //   6464: anewarray 4	java/lang/Object
    //   6467: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6470: goto -215 -> 6255
    //   6473: astore 33
    //   6475: ldc 85
    //   6477: aload 33
    //   6479: ldc_w 461
    //   6482: iconst_0
    //   6483: anewarray 4	java/lang/Object
    //   6486: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6489: goto -224 -> 6265
    //   6492: astore 33
    //   6494: ldc 85
    //   6496: aload 33
    //   6498: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6501: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6504: goto -226 -> 6278
    //   6507: astore 40
    //   6509: aconst_null
    //   6510: astore 33
    //   6512: aload 41
    //   6514: astore 39
    //   6516: aload 34
    //   6518: astore 38
    //   6520: aload 38
    //   6522: astore 37
    //   6524: aload 33
    //   6526: astore 36
    //   6528: lload 4
    //   6530: lstore 8
    //   6532: lload_2
    //   6533: lstore 6
    //   6535: aload 39
    //   6537: astore 35
    //   6539: ldc 85
    //   6541: aload 40
    //   6543: ldc_w 602
    //   6546: iconst_1
    //   6547: anewarray 4	java/lang/Object
    //   6550: dup
    //   6551: iconst_0
    //   6552: aload 52
    //   6554: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   6557: aastore
    //   6558: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6561: aload 38
    //   6563: astore 37
    //   6565: aload 33
    //   6567: astore 36
    //   6569: lload 4
    //   6571: lstore 8
    //   6573: lload_2
    //   6574: lstore 6
    //   6576: aload 39
    //   6578: astore 35
    //   6580: aload_0
    //   6581: sipush 753
    //   6584: putfield 59	com/tencent/mm/plugin/music/c/b:fnU	I
    //   6587: aload 38
    //   6589: astore 37
    //   6591: aload 33
    //   6593: astore 36
    //   6595: lload 4
    //   6597: lstore 8
    //   6599: lload_2
    //   6600: lstore 6
    //   6602: aload 39
    //   6604: astore 35
    //   6606: aload_0
    //   6607: iconst_5
    //   6608: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   6611: lload 4
    //   6613: lconst_0
    //   6614: lcmp
    //   6615: ifne +125 -> 6740
    //   6618: lload_2
    //   6619: lconst_0
    //   6620: lcmp
    //   6621: ifle +119 -> 6740
    //   6624: ldc 85
    //   6626: ldc_w 452
    //   6629: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6632: aload 38
    //   6634: lload_2
    //   6635: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   6638: aload_0
    //   6639: lload_2
    //   6640: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   6643: lload_2
    //   6644: ldc2_w 393
    //   6647: lcmp
    //   6648: ifge +15 -> 6663
    //   6651: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6654: dup
    //   6655: aload_0
    //   6656: iconst_1
    //   6657: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6660: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6663: aload 39
    //   6665: ifnull +8 -> 6673
    //   6668: aload 39
    //   6670: invokevirtual 139	java/io/InputStream:close	()V
    //   6673: aload 38
    //   6675: ifnull +8 -> 6683
    //   6678: aload 38
    //   6680: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   6683: aload 33
    //   6685: ifnull +16 -> 6701
    //   6688: aload 33
    //   6690: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6693: invokevirtual 139	java/io/InputStream:close	()V
    //   6696: aload 33
    //   6698: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   6701: aload_0
    //   6702: iconst_1
    //   6703: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6706: ldc 85
    //   6708: ldc_w 459
    //   6711: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6714: ldc_w 374
    //   6717: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6720: return
    //   6721: astore 34
    //   6723: ldc 85
    //   6725: aload 34
    //   6727: ldc_w 461
    //   6730: iconst_0
    //   6731: anewarray 4	java/lang/Object
    //   6734: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6737: goto -99 -> 6638
    //   6740: lload 4
    //   6742: lconst_0
    //   6743: lcmp
    //   6744: ifeq +47 -> 6791
    //   6747: lload_2
    //   6748: lload 4
    //   6750: lcmp
    //   6751: ifeq +40 -> 6791
    //   6754: ldc 85
    //   6756: ldc_w 463
    //   6759: iconst_2
    //   6760: anewarray 4	java/lang/Object
    //   6763: dup
    //   6764: iconst_0
    //   6765: lload 4
    //   6767: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6770: aastore
    //   6771: dup
    //   6772: iconst_1
    //   6773: lload_2
    //   6774: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6777: aastore
    //   6778: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6781: aload_0
    //   6782: lload_2
    //   6783: lload 4
    //   6785: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   6788: goto -125 -> 6663
    //   6791: lload 4
    //   6793: lconst_0
    //   6794: lcmp
    //   6795: ifeq +66 -> 6861
    //   6798: lload_2
    //   6799: lload 4
    //   6801: lcmp
    //   6802: ifne +59 -> 6861
    //   6805: ldc 85
    //   6807: ldc_w 467
    //   6810: iconst_2
    //   6811: anewarray 4	java/lang/Object
    //   6814: dup
    //   6815: iconst_0
    //   6816: lload 4
    //   6818: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6821: aastore
    //   6822: dup
    //   6823: iconst_1
    //   6824: lload_2
    //   6825: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6828: aastore
    //   6829: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6832: aload_0
    //   6833: lload 4
    //   6835: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   6838: lload_2
    //   6839: ldc2_w 393
    //   6842: lcmp
    //   6843: ifge -180 -> 6663
    //   6846: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6849: dup
    //   6850: aload_0
    //   6851: iconst_1
    //   6852: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6855: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6858: goto -195 -> 6663
    //   6861: ldc 85
    //   6863: ldc_w 469
    //   6866: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6869: goto -206 -> 6663
    //   6872: astore 34
    //   6874: ldc 85
    //   6876: aload 34
    //   6878: ldc_w 614
    //   6881: iconst_0
    //   6882: anewarray 4	java/lang/Object
    //   6885: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6888: goto -215 -> 6673
    //   6891: astore 34
    //   6893: ldc 85
    //   6895: aload 34
    //   6897: ldc_w 461
    //   6900: iconst_0
    //   6901: anewarray 4	java/lang/Object
    //   6904: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6907: goto -224 -> 6683
    //   6910: astore 34
    //   6912: ldc 85
    //   6914: aload 34
    //   6916: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6919: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6922: goto -226 -> 6696
    //   6925: astore 38
    //   6927: aconst_null
    //   6928: astore 34
    //   6930: aload 43
    //   6932: astore 39
    //   6934: aload 35
    //   6936: astore 33
    //   6938: aload 33
    //   6940: astore 37
    //   6942: aload 34
    //   6944: astore 36
    //   6946: lload 4
    //   6948: lstore 8
    //   6950: lload_2
    //   6951: lstore 6
    //   6953: aload 39
    //   6955: astore 35
    //   6957: ldc 85
    //   6959: aload 38
    //   6961: ldc_w 602
    //   6964: iconst_1
    //   6965: anewarray 4	java/lang/Object
    //   6968: dup
    //   6969: iconst_0
    //   6970: aload 52
    //   6972: invokevirtual 442	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   6975: aastore
    //   6976: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6979: aload 33
    //   6981: astore 37
    //   6983: aload 34
    //   6985: astore 36
    //   6987: lload 4
    //   6989: lstore 8
    //   6991: lload_2
    //   6992: lstore 6
    //   6994: aload 39
    //   6996: astore 35
    //   6998: aload_0
    //   6999: sipush 754
    //   7002: putfield 59	com/tencent/mm/plugin/music/c/b:fnU	I
    //   7005: aload 33
    //   7007: astore 37
    //   7009: aload 34
    //   7011: astore 36
    //   7013: lload 4
    //   7015: lstore 8
    //   7017: lload_2
    //   7018: lstore 6
    //   7020: aload 39
    //   7022: astore 35
    //   7024: aload_0
    //   7025: iconst_5
    //   7026: invokespecial 437	com/tencent/mm/plugin/music/c/b:Zg	(I)V
    //   7029: lload 4
    //   7031: lconst_0
    //   7032: lcmp
    //   7033: ifne +125 -> 7158
    //   7036: lload_2
    //   7037: lconst_0
    //   7038: lcmp
    //   7039: ifle +119 -> 7158
    //   7042: ldc 85
    //   7044: ldc_w 452
    //   7047: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7050: aload 33
    //   7052: lload_2
    //   7053: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   7056: aload_0
    //   7057: lload_2
    //   7058: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   7061: lload_2
    //   7062: ldc2_w 393
    //   7065: lcmp
    //   7066: ifge +15 -> 7081
    //   7069: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7072: dup
    //   7073: aload_0
    //   7074: iconst_1
    //   7075: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7078: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7081: aload 39
    //   7083: ifnull +8 -> 7091
    //   7086: aload 39
    //   7088: invokevirtual 139	java/io/InputStream:close	()V
    //   7091: aload 33
    //   7093: ifnull +8 -> 7101
    //   7096: aload 33
    //   7098: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   7101: aload 34
    //   7103: ifnull +16 -> 7119
    //   7106: aload 34
    //   7108: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7111: invokevirtual 139	java/io/InputStream:close	()V
    //   7114: aload 34
    //   7116: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   7119: aload_0
    //   7120: iconst_1
    //   7121: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   7124: ldc 85
    //   7126: ldc_w 459
    //   7129: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7132: ldc_w 374
    //   7135: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7138: return
    //   7139: astore 35
    //   7141: ldc 85
    //   7143: aload 35
    //   7145: ldc_w 461
    //   7148: iconst_0
    //   7149: anewarray 4	java/lang/Object
    //   7152: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7155: goto -99 -> 7056
    //   7158: lload 4
    //   7160: lconst_0
    //   7161: lcmp
    //   7162: ifeq +47 -> 7209
    //   7165: lload_2
    //   7166: lload 4
    //   7168: lcmp
    //   7169: ifeq +40 -> 7209
    //   7172: ldc 85
    //   7174: ldc_w 463
    //   7177: iconst_2
    //   7178: anewarray 4	java/lang/Object
    //   7181: dup
    //   7182: iconst_0
    //   7183: lload 4
    //   7185: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7188: aastore
    //   7189: dup
    //   7190: iconst_1
    //   7191: lload_2
    //   7192: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7195: aastore
    //   7196: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7199: aload_0
    //   7200: lload_2
    //   7201: lload 4
    //   7203: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   7206: goto -125 -> 7081
    //   7209: lload 4
    //   7211: lconst_0
    //   7212: lcmp
    //   7213: ifeq +66 -> 7279
    //   7216: lload_2
    //   7217: lload 4
    //   7219: lcmp
    //   7220: ifne +59 -> 7279
    //   7223: ldc 85
    //   7225: ldc_w 467
    //   7228: iconst_2
    //   7229: anewarray 4	java/lang/Object
    //   7232: dup
    //   7233: iconst_0
    //   7234: lload 4
    //   7236: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7239: aastore
    //   7240: dup
    //   7241: iconst_1
    //   7242: lload_2
    //   7243: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7246: aastore
    //   7247: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7250: aload_0
    //   7251: lload 4
    //   7253: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   7256: lload_2
    //   7257: ldc2_w 393
    //   7260: lcmp
    //   7261: ifge -180 -> 7081
    //   7264: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7267: dup
    //   7268: aload_0
    //   7269: iconst_1
    //   7270: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7273: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7276: goto -195 -> 7081
    //   7279: ldc 85
    //   7281: ldc_w 469
    //   7284: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7287: goto -206 -> 7081
    //   7290: astore 35
    //   7292: ldc 85
    //   7294: aload 35
    //   7296: ldc_w 614
    //   7299: iconst_0
    //   7300: anewarray 4	java/lang/Object
    //   7303: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7306: goto -215 -> 7091
    //   7309: astore 33
    //   7311: ldc 85
    //   7313: aload 33
    //   7315: ldc_w 461
    //   7318: iconst_0
    //   7319: anewarray 4	java/lang/Object
    //   7322: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7325: goto -224 -> 7101
    //   7328: astore 33
    //   7330: ldc 85
    //   7332: aload 33
    //   7334: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7337: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7340: goto -226 -> 7114
    //   7343: astore 33
    //   7345: aconst_null
    //   7346: astore 34
    //   7348: aload 46
    //   7350: astore 35
    //   7352: aload 36
    //   7354: astore 37
    //   7356: lload 4
    //   7358: lconst_0
    //   7359: lcmp
    //   7360: ifne +127 -> 7487
    //   7363: lload_2
    //   7364: lconst_0
    //   7365: lcmp
    //   7366: ifle +121 -> 7487
    //   7369: ldc 85
    //   7371: ldc_w 452
    //   7374: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7377: aload 37
    //   7379: lload_2
    //   7380: invokevirtual 544	java/io/RandomAccessFile:setLength	(J)V
    //   7383: aload_0
    //   7384: lload_2
    //   7385: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   7388: lload_2
    //   7389: ldc2_w 393
    //   7392: lcmp
    //   7393: ifge +15 -> 7408
    //   7396: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7399: dup
    //   7400: aload_0
    //   7401: iconst_1
    //   7402: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7405: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7408: aload 35
    //   7410: ifnull +8 -> 7418
    //   7413: aload 35
    //   7415: invokevirtual 139	java/io/InputStream:close	()V
    //   7418: aload 37
    //   7420: ifnull +8 -> 7428
    //   7423: aload 37
    //   7425: invokevirtual 545	java/io/RandomAccessFile:close	()V
    //   7428: aload 34
    //   7430: ifnull +16 -> 7446
    //   7433: aload 34
    //   7435: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7438: invokevirtual 139	java/io/InputStream:close	()V
    //   7441: aload 34
    //   7443: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   7446: aload_0
    //   7447: iconst_1
    //   7448: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   7451: ldc 85
    //   7453: ldc_w 459
    //   7456: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7459: ldc_w 374
    //   7462: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7465: aload 33
    //   7467: athrow
    //   7468: astore 36
    //   7470: ldc 85
    //   7472: aload 36
    //   7474: ldc_w 461
    //   7477: iconst_0
    //   7478: anewarray 4	java/lang/Object
    //   7481: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7484: goto -101 -> 7383
    //   7487: lload 4
    //   7489: lconst_0
    //   7490: lcmp
    //   7491: ifeq +47 -> 7538
    //   7494: lload_2
    //   7495: lload 4
    //   7497: lcmp
    //   7498: ifeq +40 -> 7538
    //   7501: ldc 85
    //   7503: ldc_w 463
    //   7506: iconst_2
    //   7507: anewarray 4	java/lang/Object
    //   7510: dup
    //   7511: iconst_0
    //   7512: lload 4
    //   7514: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7517: aastore
    //   7518: dup
    //   7519: iconst_1
    //   7520: lload_2
    //   7521: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7524: aastore
    //   7525: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7528: aload_0
    //   7529: lload_2
    //   7530: lload 4
    //   7532: invokespecial 465	com/tencent/mm/plugin/music/c/b:ak	(JJ)V
    //   7535: goto -127 -> 7408
    //   7538: lload 4
    //   7540: lconst_0
    //   7541: lcmp
    //   7542: ifeq +66 -> 7608
    //   7545: lload_2
    //   7546: lload 4
    //   7548: lcmp
    //   7549: ifne +59 -> 7608
    //   7552: ldc 85
    //   7554: ldc_w 467
    //   7557: iconst_2
    //   7558: anewarray 4	java/lang/Object
    //   7561: dup
    //   7562: iconst_0
    //   7563: lload 4
    //   7565: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7568: aastore
    //   7569: dup
    //   7570: iconst_1
    //   7571: lload_2
    //   7572: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7575: aastore
    //   7576: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7579: aload_0
    //   7580: lload 4
    //   7582: invokespecial 457	com/tencent/mm/plugin/music/c/b:OE	(J)V
    //   7585: lload_2
    //   7586: ldc2_w 393
    //   7589: lcmp
    //   7590: ifge -182 -> 7408
    //   7593: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7596: dup
    //   7597: aload_0
    //   7598: iconst_1
    //   7599: invokespecial 306	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7602: invokestatic 312	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7605: goto -197 -> 7408
    //   7608: ldc 85
    //   7610: ldc_w 469
    //   7613: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7616: goto -208 -> 7408
    //   7619: astore 35
    //   7621: ldc 85
    //   7623: aload 35
    //   7625: ldc_w 614
    //   7628: iconst_0
    //   7629: anewarray 4	java/lang/Object
    //   7632: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7635: goto -217 -> 7418
    //   7638: astore 35
    //   7640: ldc 85
    //   7642: aload 35
    //   7644: ldc_w 461
    //   7647: iconst_0
    //   7648: anewarray 4	java/lang/Object
    //   7651: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7654: goto -226 -> 7428
    //   7657: astore 35
    //   7659: ldc 85
    //   7661: aload 35
    //   7663: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7666: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7669: goto -228 -> 7441
    //   7672: astore 33
    //   7674: aload 36
    //   7676: astore 34
    //   7678: lload 8
    //   7680: lstore 4
    //   7682: lload 6
    //   7684: lstore_2
    //   7685: goto -329 -> 7356
    //   7688: astore 33
    //   7690: aload 38
    //   7692: astore 35
    //   7694: aload 36
    //   7696: astore 34
    //   7698: lload 20
    //   7700: lstore 4
    //   7702: lload 8
    //   7704: lstore_2
    //   7705: goto -349 -> 7356
    //   7708: astore 38
    //   7710: lload 20
    //   7712: lstore 4
    //   7714: lload 14
    //   7716: lstore_2
    //   7717: aload 43
    //   7719: astore 39
    //   7721: goto -783 -> 6938
    //   7724: astore 38
    //   7726: lload 10
    //   7728: lstore_2
    //   7729: aload 35
    //   7731: astore 39
    //   7733: goto -795 -> 6938
    //   7736: astore 40
    //   7738: aload 33
    //   7740: astore 38
    //   7742: aload 34
    //   7744: astore 33
    //   7746: lload 24
    //   7748: lstore 4
    //   7750: lload 18
    //   7752: lstore_2
    //   7753: aload 41
    //   7755: astore 39
    //   7757: goto -1237 -> 6520
    //   7760: astore 40
    //   7762: aload 33
    //   7764: astore 38
    //   7766: aload 34
    //   7768: astore 33
    //   7770: lload 12
    //   7772: lstore_2
    //   7773: aload 35
    //   7775: astore 39
    //   7777: goto -1257 -> 6520
    //   7780: astore 39
    //   7782: lload 26
    //   7784: lstore 4
    //   7786: lload 16
    //   7788: lstore_2
    //   7789: aload 42
    //   7791: astore 38
    //   7793: goto -1691 -> 6102
    //   7796: astore 39
    //   7798: lload 14
    //   7800: lstore_2
    //   7801: aload 35
    //   7803: astore 38
    //   7805: goto -1703 -> 6102
    //   7808: astore 38
    //   7810: aconst_null
    //   7811: astore 34
    //   7813: aload 39
    //   7815: astore 33
    //   7817: aload 44
    //   7819: astore 39
    //   7821: goto -2789 -> 5032
    //   7824: astore 38
    //   7826: lload 22
    //   7828: lstore 4
    //   7830: lload 10
    //   7832: lstore_2
    //   7833: aload 44
    //   7835: astore 39
    //   7837: goto -2805 -> 5032
    //   7840: astore 39
    //   7842: aconst_null
    //   7843: astore 35
    //   7845: aconst_null
    //   7846: astore 34
    //   7848: aload 38
    //   7850: astore 33
    //   7852: goto -3628 -> 4224
    //   7855: lload 30
    //   7857: lstore 6
    //   7859: lload 4
    //   7861: lstore_2
    //   7862: lload 6
    //   7864: lstore 4
    //   7866: ldc2_w 615
    //   7869: lstore 30
    //   7871: lload 4
    //   7873: lconst_0
    //   7874: lcmp
    //   7875: ifeq -4393 -> 3482
    //   7878: lload 4
    //   7880: lstore 30
    //   7882: goto -4400 -> 3482
    //   7885: astore 39
    //   7887: aconst_null
    //   7888: astore 35
    //   7890: lload 28
    //   7892: lstore 4
    //   7894: lload 12
    //   7896: lstore_2
    //   7897: goto -3673 -> 4224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7900	0	this	b
    //   176	5103	1	i	int
    //   163	7734	2	l1	long
    //   130	7763	4	l2	long
    //   121	7742	6	l3	long
    //   231	7472	8	l4	long
    //   1766	6065	10	l5	long
    //   1773	6122	12	l6	long
    //   1745	6054	14	l7	long
    //   1759	6028	16	l8	long
    //   1752	5999	18	l9	long
    //   1742	5969	20	l10	long
    //   1763	6064	22	l11	long
    //   1749	5998	24	l12	long
    //   1756	6027	26	l13	long
    //   1770	6121	28	l14	long
    //   3319	4562	30	l15	long
    //   32	1514	32	bool	boolean
    //   24	534	33	localObject1	Object
    //   811	5	33	localIOException1	java.io.IOException
    //   913	108	33	localObject2	Object
    //   1124	152	33	localIOException2	java.io.IOException
    //   1308	794	33	localRandomAccessFile	java.io.RandomAccessFile
    //   2295	5	33	localIOException3	java.io.IOException
    //   2314	2372	33	localException1	Exception
    //   4879	5	33	localIOException4	java.io.IOException
    //   4898	537	33	localException2	Exception
    //   5647	5	33	localIOException5	java.io.IOException
    //   5666	5	33	localException3	Exception
    //   5851	5	33	localIOException6	java.io.IOException
    //   5870	5	33	localException4	Exception
    //   6055	5	33	localIOException7	java.io.IOException
    //   6074	5	33	localException5	Exception
    //   6100	161	33	localObject3	Object
    //   6473	5	33	localIOException8	java.io.IOException
    //   6492	5	33	localException6	Exception
    //   6510	587	33	localObject4	Object
    //   7309	5	33	localIOException9	java.io.IOException
    //   7328	5	33	localException7	Exception
    //   7343	123	33	localObject5	Object
    //   7672	1	33	localObject6	Object
    //   7688	51	33	localObject7	Object
    //   7744	107	33	localObject8	Object
    //   21	6496	34	localObject9	Object
    //   6721	5	34	localIOException10	java.io.IOException
    //   6872	5	34	localIOException11	java.io.IOException
    //   6891	5	34	localIOException12	java.io.IOException
    //   6910	5	34	localException8	Exception
    //   6928	919	34	localObject10	Object
    //   50	1953	35	localObject11	Object
    //   2144	5	35	localIOException13	java.io.IOException
    //   2346	2240	35	localObject12	Object
    //   4728	298	35	localIOException14	java.io.IOException
    //   5049	376	35	localObject13	Object
    //   5628	5	35	localIOException15	java.io.IOException
    //   5832	5	35	localIOException16	java.io.IOException
    //   5885	5	35	localIOException17	java.io.IOException
    //   6036	5	35	localIOException18	java.io.IOException
    //   6119	68	35	localObject14	Object
    //   6303	5	35	localIOException19	java.io.IOException
    //   6454	5	35	localIOException20	java.io.IOException
    //   6537	486	35	localObject15	Object
    //   7139	5	35	localIOException21	java.io.IOException
    //   7290	5	35	localIOException22	java.io.IOException
    //   7350	64	35	localObject16	Object
    //   7619	5	35	localIOException23	java.io.IOException
    //   7638	5	35	localIOException24	java.io.IOException
    //   7657	5	35	localException9	Exception
    //   7692	197	35	localObject17	Object
    //   929	4399	36	localObject18	Object
    //   5477	5	36	localIOException25	java.io.IOException
    //   5681	5	36	localIOException26	java.io.IOException
    //   6108	1245	36	localObject19	Object
    //   7468	227	36	localIOException27	java.io.IOException
    //   917	6507	37	localObject20	Object
    //   937	4049	38	localObject21	Object
    //   5023	31	38	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   5245	1434	38	localObject22	Object
    //   6925	766	38	localException10	Exception
    //   7708	1	38	localException11	Exception
    //   7724	1	38	localException12	Exception
    //   7740	64	38	localObject23	Object
    //   7808	1	38	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   7824	25	38	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   933	2991	39	localObject24	Object
    //   4219	695	39	localProtocolException1	java.net.ProtocolException
    //   5027	154	39	localIOException28	java.io.IOException
    //   6089	35	39	localUnknownServiceException1	java.net.UnknownServiceException
    //   6514	1262	39	localObject25	Object
    //   7780	1	39	localUnknownServiceException2	java.net.UnknownServiceException
    //   7796	18	39	localUnknownServiceException3	java.net.UnknownServiceException
    //   7819	17	39	localObject26	Object
    //   7840	1	39	localProtocolException2	java.net.ProtocolException
    //   7885	1	39	localProtocolException3	java.net.ProtocolException
    //   179	1539	40	localObject27	Object
    //   6507	35	40	localIOException29	java.io.IOException
    //   7736	1	40	localIOException30	java.io.IOException
    //   7760	1	40	localIOException31	java.io.IOException
    //   883	6871	41	localObject28	Object
    //   880	6910	42	localObject29	Object
    //   886	6832	43	localObject30	Object
    //   895	6939	44	localObject31	Object
    //   892	3692	45	localObject32	Object
    //   889	6460	46	localObject33	Object
    //   910	801	47	localHashMap	java.util.HashMap
    //   907	385	48	localObject34	Object
    //   898	382	49	localObject35	Object
    //   901	383	50	localObject36	Object
    //   904	384	51	localObject37	Object
    //   228	6743	52	localq	com.tencent.mm.vfs.q
    // Exception table:
    //   from	to	target	type
    //   244	267	811	java/io/IOException
    //   1071	1079	1124	java/io/IOException
    //   2065	2071	2144	java/io/IOException
    //   2101	2106	2295	java/io/IOException
    //   2111	2119	2314	java/lang/Exception
    //   3793	3800	4219	java/net/ProtocolException
    //   3834	3841	4219	java/net/ProtocolException
    //   3875	3883	4219	java/net/ProtocolException
    //   3921	3930	4219	java/net/ProtocolException
    //   3976	4004	4219	java/net/ProtocolException
    //   4044	4051	4219	java/net/ProtocolException
    //   4091	4100	4219	java/net/ProtocolException
    //   4140	4149	4219	java/net/ProtocolException
    //   4201	4213	4219	java/net/ProtocolException
    //   4962	4971	4219	java/net/ProtocolException
    //   5011	5020	4219	java/net/ProtocolException
    //   5267	5311	4219	java/net/ProtocolException
    //   5345	5367	4219	java/net/ProtocolException
    //   4649	4655	4728	java/io/IOException
    //   4685	4690	4879	java/io/IOException
    //   4695	4703	4898	java/lang/Exception
    //   3793	3800	5023	java/net/NoRouteToHostException
    //   3834	3841	5023	java/net/NoRouteToHostException
    //   3875	3883	5023	java/net/NoRouteToHostException
    //   3921	3930	5023	java/net/NoRouteToHostException
    //   3976	4004	5023	java/net/NoRouteToHostException
    //   4044	4051	5023	java/net/NoRouteToHostException
    //   4091	4100	5023	java/net/NoRouteToHostException
    //   4140	4149	5023	java/net/NoRouteToHostException
    //   4201	4213	5023	java/net/NoRouteToHostException
    //   4962	4971	5023	java/net/NoRouteToHostException
    //   5011	5020	5023	java/net/NoRouteToHostException
    //   5267	5311	5023	java/net/NoRouteToHostException
    //   5345	5367	5023	java/net/NoRouteToHostException
    //   5388	5394	5477	java/io/IOException
    //   5424	5429	5628	java/io/IOException
    //   5434	5439	5647	java/io/IOException
    //   5444	5452	5666	java/lang/Exception
    //   4336	4342	5681	java/io/IOException
    //   4372	4377	5832	java/io/IOException
    //   4382	4387	5851	java/io/IOException
    //   4392	4400	5870	java/lang/Exception
    //   5144	5150	5885	java/io/IOException
    //   5180	5185	6036	java/io/IOException
    //   5190	5195	6055	java/io/IOException
    //   5200	5208	6074	java/lang/Exception
    //   939	947	6089	java/net/UnknownServiceException
    //   971	976	6089	java/net/UnknownServiceException
    //   1000	1020	6089	java/net/UnknownServiceException
    //   1044	1050	6089	java/net/UnknownServiceException
    //   1299	1310	6089	java/net/UnknownServiceException
    //   1334	1351	6089	java/net/UnknownServiceException
    //   1375	1386	6089	java/net/UnknownServiceException
    //   1410	1424	6089	java/net/UnknownServiceException
    //   1455	1482	6089	java/net/UnknownServiceException
    //   1506	1545	6089	java/net/UnknownServiceException
    //   1574	1582	6089	java/net/UnknownServiceException
    //   1606	1614	6089	java/net/UnknownServiceException
    //   1638	1683	6089	java/net/UnknownServiceException
    //   1707	1717	6089	java/net/UnknownServiceException
    //   6214	6220	6303	java/io/IOException
    //   6250	6255	6454	java/io/IOException
    //   6260	6265	6473	java/io/IOException
    //   6270	6278	6492	java/lang/Exception
    //   939	947	6507	java/io/IOException
    //   971	976	6507	java/io/IOException
    //   1000	1020	6507	java/io/IOException
    //   1044	1050	6507	java/io/IOException
    //   1299	1310	6507	java/io/IOException
    //   1334	1351	6507	java/io/IOException
    //   1375	1386	6507	java/io/IOException
    //   1410	1424	6507	java/io/IOException
    //   1455	1482	6507	java/io/IOException
    //   1506	1545	6507	java/io/IOException
    //   1574	1582	6507	java/io/IOException
    //   1606	1614	6507	java/io/IOException
    //   1638	1683	6507	java/io/IOException
    //   1707	1717	6507	java/io/IOException
    //   6632	6638	6721	java/io/IOException
    //   6668	6673	6872	java/io/IOException
    //   6678	6683	6891	java/io/IOException
    //   6688	6696	6910	java/lang/Exception
    //   939	947	6925	java/lang/Exception
    //   971	976	6925	java/lang/Exception
    //   1000	1020	6925	java/lang/Exception
    //   1044	1050	6925	java/lang/Exception
    //   1299	1310	6925	java/lang/Exception
    //   1334	1351	6925	java/lang/Exception
    //   1375	1386	6925	java/lang/Exception
    //   1410	1424	6925	java/lang/Exception
    //   1455	1482	6925	java/lang/Exception
    //   1506	1545	6925	java/lang/Exception
    //   1574	1582	6925	java/lang/Exception
    //   1606	1614	6925	java/lang/Exception
    //   1638	1683	6925	java/lang/Exception
    //   1707	1717	6925	java/lang/Exception
    //   7050	7056	7139	java/io/IOException
    //   7086	7091	7290	java/io/IOException
    //   7096	7101	7309	java/io/IOException
    //   7106	7114	7328	java/lang/Exception
    //   939	947	7343	finally
    //   971	976	7343	finally
    //   1000	1020	7343	finally
    //   1044	1050	7343	finally
    //   1299	1310	7343	finally
    //   1334	1351	7343	finally
    //   1375	1386	7343	finally
    //   1410	1424	7343	finally
    //   1455	1482	7343	finally
    //   1506	1545	7343	finally
    //   1574	1582	7343	finally
    //   1606	1614	7343	finally
    //   1638	1683	7343	finally
    //   1707	1717	7343	finally
    //   7377	7383	7468	java/io/IOException
    //   7413	7418	7619	java/io/IOException
    //   7423	7428	7638	java/io/IOException
    //   7433	7441	7657	java/lang/Exception
    //   1775	1781	7672	finally
    //   1849	1853	7672	finally
    //   1907	1926	7672	finally
    //   1980	1985	7672	finally
    //   2039	2044	7672	finally
    //   2383	2402	7672	finally
    //   2456	2485	7672	finally
    //   2539	2546	7672	finally
    //   2600	2617	7672	finally
    //   2671	2677	7672	finally
    //   2731	2741	7672	finally
    //   2795	2808	7672	finally
    //   2862	2873	7672	finally
    //   2927	2936	7672	finally
    //   2990	2996	7672	finally
    //   3050	3056	7672	finally
    //   3110	3128	7672	finally
    //   3182	3192	7672	finally
    //   3246	3253	7672	finally
    //   3307	3321	7672	finally
    //   3375	3400	7672	finally
    //   3459	3467	7672	finally
    //   3536	3573	7672	finally
    //   3627	3634	7672	finally
    //   3688	3694	7672	finally
    //   3748	3755	7672	finally
    //   4479	4488	7672	finally
    //   4560	4568	7672	finally
    //   4622	4628	7672	finally
    //   5051	5073	7672	finally
    //   5092	5099	7672	finally
    //   5118	5123	7672	finally
    //   6121	6143	7672	finally
    //   6162	6169	7672	finally
    //   6188	6193	7672	finally
    //   6539	6561	7672	finally
    //   6580	6587	7672	finally
    //   6606	6611	7672	finally
    //   6957	6979	7672	finally
    //   6998	7005	7672	finally
    //   7024	7029	7672	finally
    //   3793	3800	7688	finally
    //   3834	3841	7688	finally
    //   3875	3883	7688	finally
    //   3921	3930	7688	finally
    //   3976	4004	7688	finally
    //   4044	4051	7688	finally
    //   4091	4100	7688	finally
    //   4140	4149	7688	finally
    //   4201	4213	7688	finally
    //   4243	4265	7688	finally
    //   4284	4291	7688	finally
    //   4310	4315	7688	finally
    //   4962	4971	7688	finally
    //   5011	5020	7688	finally
    //   5267	5311	7688	finally
    //   5345	5367	7688	finally
    //   1775	1781	7708	java/lang/Exception
    //   1849	1853	7708	java/lang/Exception
    //   1907	1926	7708	java/lang/Exception
    //   1980	1985	7708	java/lang/Exception
    //   2039	2044	7708	java/lang/Exception
    //   2383	2402	7708	java/lang/Exception
    //   2456	2485	7708	java/lang/Exception
    //   2539	2546	7708	java/lang/Exception
    //   2600	2617	7708	java/lang/Exception
    //   2671	2677	7708	java/lang/Exception
    //   2731	2741	7708	java/lang/Exception
    //   2795	2808	7708	java/lang/Exception
    //   2862	2873	7708	java/lang/Exception
    //   2927	2936	7708	java/lang/Exception
    //   2990	2996	7708	java/lang/Exception
    //   3050	3056	7708	java/lang/Exception
    //   3110	3128	7708	java/lang/Exception
    //   3182	3192	7708	java/lang/Exception
    //   3246	3253	7708	java/lang/Exception
    //   3307	3321	7708	java/lang/Exception
    //   3375	3400	7708	java/lang/Exception
    //   3459	3467	7708	java/lang/Exception
    //   3536	3573	7708	java/lang/Exception
    //   3627	3634	7708	java/lang/Exception
    //   3688	3694	7708	java/lang/Exception
    //   3748	3755	7708	java/lang/Exception
    //   4479	4488	7708	java/lang/Exception
    //   4560	4568	7708	java/lang/Exception
    //   4622	4628	7708	java/lang/Exception
    //   3793	3800	7724	java/lang/Exception
    //   3834	3841	7724	java/lang/Exception
    //   3875	3883	7724	java/lang/Exception
    //   3921	3930	7724	java/lang/Exception
    //   3976	4004	7724	java/lang/Exception
    //   4044	4051	7724	java/lang/Exception
    //   4091	4100	7724	java/lang/Exception
    //   4140	4149	7724	java/lang/Exception
    //   4201	4213	7724	java/lang/Exception
    //   4962	4971	7724	java/lang/Exception
    //   5011	5020	7724	java/lang/Exception
    //   5267	5311	7724	java/lang/Exception
    //   5345	5367	7724	java/lang/Exception
    //   1775	1781	7736	java/io/IOException
    //   1849	1853	7736	java/io/IOException
    //   1907	1926	7736	java/io/IOException
    //   1980	1985	7736	java/io/IOException
    //   2039	2044	7736	java/io/IOException
    //   2383	2402	7736	java/io/IOException
    //   2456	2485	7736	java/io/IOException
    //   2539	2546	7736	java/io/IOException
    //   2600	2617	7736	java/io/IOException
    //   2671	2677	7736	java/io/IOException
    //   2731	2741	7736	java/io/IOException
    //   2795	2808	7736	java/io/IOException
    //   2862	2873	7736	java/io/IOException
    //   2927	2936	7736	java/io/IOException
    //   2990	2996	7736	java/io/IOException
    //   3050	3056	7736	java/io/IOException
    //   3110	3128	7736	java/io/IOException
    //   3182	3192	7736	java/io/IOException
    //   3246	3253	7736	java/io/IOException
    //   3307	3321	7736	java/io/IOException
    //   3375	3400	7736	java/io/IOException
    //   3459	3467	7736	java/io/IOException
    //   3536	3573	7736	java/io/IOException
    //   3627	3634	7736	java/io/IOException
    //   3688	3694	7736	java/io/IOException
    //   3748	3755	7736	java/io/IOException
    //   4479	4488	7736	java/io/IOException
    //   4560	4568	7736	java/io/IOException
    //   4622	4628	7736	java/io/IOException
    //   3793	3800	7760	java/io/IOException
    //   3834	3841	7760	java/io/IOException
    //   3875	3883	7760	java/io/IOException
    //   3921	3930	7760	java/io/IOException
    //   3976	4004	7760	java/io/IOException
    //   4044	4051	7760	java/io/IOException
    //   4091	4100	7760	java/io/IOException
    //   4140	4149	7760	java/io/IOException
    //   4201	4213	7760	java/io/IOException
    //   4962	4971	7760	java/io/IOException
    //   5011	5020	7760	java/io/IOException
    //   5267	5311	7760	java/io/IOException
    //   5345	5367	7760	java/io/IOException
    //   1775	1781	7780	java/net/UnknownServiceException
    //   1849	1853	7780	java/net/UnknownServiceException
    //   1907	1926	7780	java/net/UnknownServiceException
    //   1980	1985	7780	java/net/UnknownServiceException
    //   2039	2044	7780	java/net/UnknownServiceException
    //   2383	2402	7780	java/net/UnknownServiceException
    //   2456	2485	7780	java/net/UnknownServiceException
    //   2539	2546	7780	java/net/UnknownServiceException
    //   2600	2617	7780	java/net/UnknownServiceException
    //   2671	2677	7780	java/net/UnknownServiceException
    //   2731	2741	7780	java/net/UnknownServiceException
    //   2795	2808	7780	java/net/UnknownServiceException
    //   2862	2873	7780	java/net/UnknownServiceException
    //   2927	2936	7780	java/net/UnknownServiceException
    //   2990	2996	7780	java/net/UnknownServiceException
    //   3050	3056	7780	java/net/UnknownServiceException
    //   3110	3128	7780	java/net/UnknownServiceException
    //   3182	3192	7780	java/net/UnknownServiceException
    //   3246	3253	7780	java/net/UnknownServiceException
    //   3307	3321	7780	java/net/UnknownServiceException
    //   3375	3400	7780	java/net/UnknownServiceException
    //   3459	3467	7780	java/net/UnknownServiceException
    //   3536	3573	7780	java/net/UnknownServiceException
    //   3627	3634	7780	java/net/UnknownServiceException
    //   3688	3694	7780	java/net/UnknownServiceException
    //   3748	3755	7780	java/net/UnknownServiceException
    //   4479	4488	7780	java/net/UnknownServiceException
    //   4560	4568	7780	java/net/UnknownServiceException
    //   4622	4628	7780	java/net/UnknownServiceException
    //   3793	3800	7796	java/net/UnknownServiceException
    //   3834	3841	7796	java/net/UnknownServiceException
    //   3875	3883	7796	java/net/UnknownServiceException
    //   3921	3930	7796	java/net/UnknownServiceException
    //   3976	4004	7796	java/net/UnknownServiceException
    //   4044	4051	7796	java/net/UnknownServiceException
    //   4091	4100	7796	java/net/UnknownServiceException
    //   4140	4149	7796	java/net/UnknownServiceException
    //   4201	4213	7796	java/net/UnknownServiceException
    //   4962	4971	7796	java/net/UnknownServiceException
    //   5011	5020	7796	java/net/UnknownServiceException
    //   5267	5311	7796	java/net/UnknownServiceException
    //   5345	5367	7796	java/net/UnknownServiceException
    //   939	947	7808	java/net/NoRouteToHostException
    //   971	976	7808	java/net/NoRouteToHostException
    //   1000	1020	7808	java/net/NoRouteToHostException
    //   1044	1050	7808	java/net/NoRouteToHostException
    //   1299	1310	7808	java/net/NoRouteToHostException
    //   1334	1351	7808	java/net/NoRouteToHostException
    //   1375	1386	7808	java/net/NoRouteToHostException
    //   1410	1424	7808	java/net/NoRouteToHostException
    //   1455	1482	7808	java/net/NoRouteToHostException
    //   1506	1545	7808	java/net/NoRouteToHostException
    //   1574	1582	7808	java/net/NoRouteToHostException
    //   1606	1614	7808	java/net/NoRouteToHostException
    //   1638	1683	7808	java/net/NoRouteToHostException
    //   1707	1717	7808	java/net/NoRouteToHostException
    //   1775	1781	7824	java/net/NoRouteToHostException
    //   1849	1853	7824	java/net/NoRouteToHostException
    //   1907	1926	7824	java/net/NoRouteToHostException
    //   1980	1985	7824	java/net/NoRouteToHostException
    //   2039	2044	7824	java/net/NoRouteToHostException
    //   2383	2402	7824	java/net/NoRouteToHostException
    //   2456	2485	7824	java/net/NoRouteToHostException
    //   2539	2546	7824	java/net/NoRouteToHostException
    //   2600	2617	7824	java/net/NoRouteToHostException
    //   2671	2677	7824	java/net/NoRouteToHostException
    //   2731	2741	7824	java/net/NoRouteToHostException
    //   2795	2808	7824	java/net/NoRouteToHostException
    //   2862	2873	7824	java/net/NoRouteToHostException
    //   2927	2936	7824	java/net/NoRouteToHostException
    //   2990	2996	7824	java/net/NoRouteToHostException
    //   3050	3056	7824	java/net/NoRouteToHostException
    //   3110	3128	7824	java/net/NoRouteToHostException
    //   3182	3192	7824	java/net/NoRouteToHostException
    //   3246	3253	7824	java/net/NoRouteToHostException
    //   3307	3321	7824	java/net/NoRouteToHostException
    //   3375	3400	7824	java/net/NoRouteToHostException
    //   3459	3467	7824	java/net/NoRouteToHostException
    //   3536	3573	7824	java/net/NoRouteToHostException
    //   3627	3634	7824	java/net/NoRouteToHostException
    //   3688	3694	7824	java/net/NoRouteToHostException
    //   3748	3755	7824	java/net/NoRouteToHostException
    //   4479	4488	7824	java/net/NoRouteToHostException
    //   4560	4568	7824	java/net/NoRouteToHostException
    //   4622	4628	7824	java/net/NoRouteToHostException
    //   939	947	7840	java/net/ProtocolException
    //   971	976	7840	java/net/ProtocolException
    //   1000	1020	7840	java/net/ProtocolException
    //   1044	1050	7840	java/net/ProtocolException
    //   1299	1310	7840	java/net/ProtocolException
    //   1334	1351	7840	java/net/ProtocolException
    //   1375	1386	7840	java/net/ProtocolException
    //   1410	1424	7840	java/net/ProtocolException
    //   1455	1482	7840	java/net/ProtocolException
    //   1506	1545	7840	java/net/ProtocolException
    //   1574	1582	7840	java/net/ProtocolException
    //   1606	1614	7840	java/net/ProtocolException
    //   1638	1683	7840	java/net/ProtocolException
    //   1707	1717	7840	java/net/ProtocolException
    //   1775	1781	7885	java/net/ProtocolException
    //   1849	1853	7885	java/net/ProtocolException
    //   1907	1926	7885	java/net/ProtocolException
    //   1980	1985	7885	java/net/ProtocolException
    //   2039	2044	7885	java/net/ProtocolException
    //   2383	2402	7885	java/net/ProtocolException
    //   2456	2485	7885	java/net/ProtocolException
    //   2539	2546	7885	java/net/ProtocolException
    //   2600	2617	7885	java/net/ProtocolException
    //   2671	2677	7885	java/net/ProtocolException
    //   2731	2741	7885	java/net/ProtocolException
    //   2795	2808	7885	java/net/ProtocolException
    //   2862	2873	7885	java/net/ProtocolException
    //   2927	2936	7885	java/net/ProtocolException
    //   2990	2996	7885	java/net/ProtocolException
    //   3050	3056	7885	java/net/ProtocolException
    //   3110	3128	7885	java/net/ProtocolException
    //   3182	3192	7885	java/net/ProtocolException
    //   3246	3253	7885	java/net/ProtocolException
    //   3307	3321	7885	java/net/ProtocolException
    //   3375	3400	7885	java/net/ProtocolException
    //   3459	3467	7885	java/net/ProtocolException
    //   3536	3573	7885	java/net/ProtocolException
    //   3627	3634	7885	java/net/ProtocolException
    //   3688	3694	7885	java/net/ProtocolException
    //   3748	3755	7885	java/net/ProtocolException
    //   4479	4488	7885	java/net/ProtocolException
    //   4560	4568	7885	java/net/ProtocolException
    //   4622	4628	7885	java/net/ProtocolException
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
    ThreadPool.post(this, "music_download_thread");
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
      if (b.this.FQc != null) {
        b.this.FQc.Zh(this.action);
      }
      AppMethodBeat.o(137215);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Zh(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b
 * JD-Core Version:    0.7.0.1
 */