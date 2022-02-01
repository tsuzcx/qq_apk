package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.logic.d;
import com.tencent.mm.plugin.music.logic.j;
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
  public boolean Aey;
  private String LKS;
  public f LKT;
  public a LKU;
  public float LKV;
  private long LKW;
  public int LKX;
  public b LKY;
  public int hsf;
  public boolean isStop;
  public String mimeType;
  
  public b(f paramf, a parama)
  {
    AppMethodBeat.i(137216);
    this.LKS = null;
    this.LKW = 307200L;
    this.isStop = true;
    this.mimeType = "";
    this.LKX = -1;
    this.hsf = 0;
    this.LKT = paramf;
    this.LKU = parama;
    int i;
    int j;
    if ((parama.LKN == 0L) && (parama.LKO == 0L) && (parama.endFlag == 0))
    {
      i = 1;
      if ((parama.LKP != 0L) || (parama.LKR != 0L) || (parama.LKQ != 0)) {
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
      this.Aey = NetStatusUtil.isWifi(MMApplicationContext.getContext());
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
  
  private HttpURLConnection S(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137219);
    Object localObject1;
    if (!TextUtils.isEmpty(this.LKS))
    {
      Log.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.LKS;
      localObject1 = null;
    }
    for (int i = 0;; i = 0)
    {
      if (localObject1 != null) {}
      for (;;)
      {
        try
        {
          ((HttpURLConnection)localObject1).getInputStream().close();
          ((HttpURLConnection)localObject1).disconnect();
          Log.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[] { paramString });
          Object localObject2 = j.gnw().LLw;
          localObject1 = new URL(paramString);
          str = ((URL)localObject1).getHost();
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.music.logic.a)localObject2).aOR(paramString);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (!paramString.equalsIgnoreCase(((URL)localObject2).toString()))
              {
                Log.i("MicroMsg.Music.MusicDownloadTask", "getRedirectURL, srcUrl:%s", new Object[] { ((URL)localObject2).toString() });
                j = 1;
                localObject1 = localObject2;
                localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
                ((HttpURLConnection)localObject1).setRequestMethod("GET");
                ((HttpURLConnection)localObject1).setConnectTimeout(25000);
                ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
                paramString = paramMap.entrySet().iterator();
                if (paramString.hasNext())
                {
                  localObject2 = (Map.Entry)paramString.next();
                  ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
                  continue;
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          String str;
          Log.e("MicroMsg.Music.MusicDownloadTask", localException.getMessage());
          continue;
          if ((j != 0) && (!TextUtils.isEmpty(str)))
          {
            ((HttpURLConnection)localObject1).setRequestProperty("Host", str);
            Log.i("MicroMsg.Music.MusicDownloadTask", "use host :%s", new Object[] { str });
          }
          j = ((HttpURLConnection)localObject1).getResponseCode();
          Log.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307))
          {
            adq(j);
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
            this.LKS = paramString;
            break;
          }
          if ((j != 200) && (j != 206)) {
            this.LKS = null;
          }
          AppMethodBeat.o(137219);
          return localObject1;
        }
        int j = 0;
      }
      localObject1 = null;
    }
  }
  
  private static long[] aOQ(String paramString)
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
  
  private void aT(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(137223);
    if (this.Aey)
    {
      this.LKU.LKP = paramLong1;
      this.LKU.LKQ = 0;
      this.LKU.LKR = paramLong2;
      e.a(this.LKT.oOv, this.LKU);
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new a(3));
      AppMethodBeat.o(137223);
      return;
      this.LKU.LKN = paramLong1;
      this.LKU.endFlag = 0;
      this.LKU.LKO = paramLong2;
      e.a(this.LKT.oOv, this.LKU);
    }
  }
  
  private static void adq(int paramInt)
  {
    AppMethodBeat.i(137220);
    d locald = (d)com.tencent.mm.plugin.music.e.c.b.bU(d.class);
    if (locald != null) {
      locald.adv(paramInt);
    }
    AppMethodBeat.o(137220);
  }
  
  private void adr(int paramInt)
  {
    AppMethodBeat.i(137221);
    this.LKS = null;
    MMHandlerThread.postToMainThread(new a(paramInt));
    AppMethodBeat.o(137221);
  }
  
  private void sB(long paramLong)
  {
    AppMethodBeat.i(137222);
    if (this.Aey)
    {
      this.LKU.LKP = paramLong;
      this.LKU.LKQ = 1;
      this.LKU.LKR = paramLong;
      e.a(this.LKT.oOv, this.LKU);
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new a(2));
      AppMethodBeat.o(137222);
      return;
      this.LKU.LKN = paramLong;
      this.LKU.endFlag = 1;
      this.LKU.LKO = paramLong;
      e.a(this.LKT.oOv, this.LKU);
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 386
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   10: ifeq +10 -> 20
    //   13: ldc_w 386
    //   16: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aconst_null
    //   21: astore 34
    //   23: aconst_null
    //   24: astore 33
    //   26: invokestatic 99	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   29: invokestatic 389	com/tencent/mm/sdk/platformtools/NetStatusUtil:isNetworkConnected	(Landroid/content/Context;)Z
    //   32: istore 32
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 59	com/tencent/mm/plugin/music/c/b:hsf	I
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 57	com/tencent/mm/plugin/music/c/b:LKX	I
    //   44: invokestatic 153	com/tencent/mm/plugin/music/logic/j:gnw	()Lcom/tencent/mm/plugin/music/logic/j;
    //   47: getfield 157	com/tencent/mm/plugin/music/logic/j:LLw	Lcom/tencent/mm/plugin/music/logic/a;
    //   50: astore 35
    //   52: iload 32
    //   54: ifeq +510 -> 564
    //   57: aload_0
    //   58: getfield 107	com/tencent/mm/plugin/music/c/b:Aey	Z
    //   61: ifeq +358 -> 419
    //   64: aload_0
    //   65: getfield 61	com/tencent/mm/plugin/music/c/b:LKT	Lcom/tencent/mm/aw/f;
    //   68: getfield 392	com/tencent/mm/aw/f:playUrl	Ljava/lang/String;
    //   71: invokestatic 397	com/tencent/mm/plugin/music/cache/g:aOF	(Ljava/lang/String;)Z
    //   74: istore 32
    //   76: aload 35
    //   78: ifnull +19 -> 97
    //   81: aload 35
    //   83: aload_0
    //   84: getfield 61	com/tencent/mm/plugin/music/c/b:LKT	Lcom/tencent/mm/aw/f;
    //   87: getfield 392	com/tencent/mm/aw/f:playUrl	Ljava/lang/String;
    //   90: invokeinterface 400 2 0
    //   95: astore 33
    //   97: ldc 85
    //   99: ldc_w 402
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload 33
    //   110: aastore
    //   111: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   118: getfield 77	com/tencent/mm/plugin/music/c/a:LKP	J
    //   121: lstore 6
    //   123: aload_0
    //   124: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   127: getfield 80	com/tencent/mm/plugin/music/c/a:LKR	J
    //   130: lstore 4
    //   132: lload 4
    //   134: lconst_0
    //   135: lcmp
    //   136: ifeq +13 -> 149
    //   139: aload_0
    //   140: lload 4
    //   142: ldc2_w 403
    //   145: ldiv
    //   146: putfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   149: lload 6
    //   151: aload_0
    //   152: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   155: lcmp
    //   156: ifge +233 -> 389
    //   159: aload_0
    //   160: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   163: lstore_2
    //   164: aload_0
    //   165: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   168: getfield 83	com/tencent/mm/plugin/music/c/a:LKQ	I
    //   171: iconst_1
    //   172: if_icmpne +238 -> 410
    //   175: iconst_1
    //   176: istore_1
    //   177: aload 33
    //   179: astore 40
    //   181: aload_0
    //   182: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   185: ldc2_w 405
    //   188: lcmp
    //   189: ifge +18 -> 207
    //   192: aload_0
    //   193: ldc2_w 405
    //   196: putfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   199: ldc 85
    //   201: ldc_w 408
    //   204: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: new 410	com/tencent/mm/vfs/u
    //   210: dup
    //   211: aload_0
    //   212: getfield 61	com/tencent/mm/plugin/music/c/b:LKT	Lcom/tencent/mm/aw/f;
    //   215: getfield 345	com/tencent/mm/aw/f:oOv	Ljava/lang/String;
    //   218: aload_0
    //   219: getfield 107	com/tencent/mm/plugin/music/c/b:Aey	Z
    //   222: invokestatic 416	com/tencent/mm/plugin/music/h/b:cy	(Ljava/lang/String;Z)Ljava/lang/String;
    //   225: invokespecial 417	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   228: astore 52
    //   230: lload_2
    //   231: lstore 8
    //   233: lload 6
    //   235: lstore_2
    //   236: aload 52
    //   238: invokevirtual 420	com/tencent/mm/vfs/u:jKS	()Z
    //   241: ifne +56 -> 297
    //   244: ldc 85
    //   246: ldc_w 422
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 52
    //   257: invokevirtual 425	com/tencent/mm/vfs/u:jKZ	()Z
    //   260: invokestatic 430	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   263: aastore
    //   264: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: lconst_0
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   273: lstore 8
    //   275: iconst_0
    //   276: istore_1
    //   277: ldc 85
    //   279: ldc_w 432
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: lload 8
    //   290: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   293: aastore
    //   294: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: ldc 85
    //   299: ldc_w 437
    //   302: iconst_3
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: lload_2
    //   309: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: aload 52
    //   317: invokevirtual 440	com/tencent/mm/vfs/u:length	()J
    //   320: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: dup
    //   325: iconst_2
    //   326: lload 8
    //   328: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: aastore
    //   332: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: lload_2
    //   336: aload_0
    //   337: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   340: lcmp
    //   341: iflt +12 -> 353
    //   344: aload_0
    //   345: getfield 442	com/tencent/mm/plugin/music/c/b:LKV	F
    //   348: fconst_0
    //   349: fcmpl
    //   350: ifeq +7 -> 357
    //   353: iload_1
    //   354: ifeq +487 -> 841
    //   357: ldc 85
    //   359: ldc_w 444
    //   362: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: iconst_1
    //   367: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   370: new 8	com/tencent/mm/plugin/music/c/b$a
    //   373: dup
    //   374: aload_0
    //   375: iconst_1
    //   376: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   379: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   382: ldc_w 386
    //   385: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: return
    //   389: lload 6
    //   391: l2f
    //   392: ldc_w 445
    //   395: aload_0
    //   396: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   399: getfield 80	com/tencent/mm/plugin/music/c/a:LKR	J
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
    //   431: getfield 61	com/tencent/mm/plugin/music/c/b:LKT	Lcom/tencent/mm/aw/f;
    //   434: getfield 392	com/tencent/mm/aw/f:playUrl	Ljava/lang/String;
    //   437: invokeinterface 400 2 0
    //   442: astore 33
    //   444: ldc 85
    //   446: ldc_w 402
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
    //   465: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   468: getfield 68	com/tencent/mm/plugin/music/c/a:LKN	J
    //   471: lstore 6
    //   473: aload_0
    //   474: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   477: getfield 71	com/tencent/mm/plugin/music/c/a:LKO	J
    //   480: lstore 4
    //   482: lload 4
    //   484: lconst_0
    //   485: lcmp
    //   486: ifeq +13 -> 499
    //   489: aload_0
    //   490: lload 4
    //   492: ldc2_w 403
    //   495: ldiv
    //   496: putfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   499: lload 6
    //   501: aload_0
    //   502: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   505: lcmp
    //   506: ifge +28 -> 534
    //   509: aload_0
    //   510: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   513: lstore_2
    //   514: aload_0
    //   515: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
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
    //   537: ldc_w 445
    //   540: aload_0
    //   541: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   544: getfield 71	com/tencent/mm/plugin/music/c/a:LKO	J
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
    //   565: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   568: getfield 77	com/tencent/mm/plugin/music/c/a:LKP	J
    //   571: lconst_0
    //   572: lcmp
    //   573: ifeq +102 -> 675
    //   576: aload_0
    //   577: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   580: getfield 77	com/tencent/mm/plugin/music/c/a:LKP	J
    //   583: aload_0
    //   584: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   587: lcmp
    //   588: ifge +21 -> 609
    //   591: aload_0
    //   592: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   595: getfield 77	com/tencent/mm/plugin/music/c/a:LKP	J
    //   598: aload_0
    //   599: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   602: getfield 80	com/tencent/mm/plugin/music/c/a:LKR	J
    //   605: lcmp
    //   606: ifne +69 -> 675
    //   609: aload_0
    //   610: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   613: getfield 77	com/tencent/mm/plugin/music/c/a:LKP	J
    //   616: l2f
    //   617: aload_0
    //   618: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   621: getfield 80	com/tencent/mm/plugin/music/c/a:LKR	J
    //   624: l2f
    //   625: fdiv
    //   626: aload_0
    //   627: getfield 442	com/tencent/mm/plugin/music/c/b:LKV	F
    //   630: fsub
    //   631: ldc_w 445
    //   634: fcmpl
    //   635: iflt +40 -> 675
    //   638: ldc 85
    //   640: ldc_w 444
    //   643: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 107	com/tencent/mm/plugin/music/c/b:Aey	Z
    //   656: new 8	com/tencent/mm/plugin/music/c/b$a
    //   659: dup
    //   660: aload_0
    //   661: iconst_1
    //   662: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   665: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   668: ldc_w 386
    //   671: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: return
    //   675: aload_0
    //   676: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   679: getfield 68	com/tencent/mm/plugin/music/c/a:LKN	J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifeq +102 -> 786
    //   687: aload_0
    //   688: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   691: getfield 68	com/tencent/mm/plugin/music/c/a:LKN	J
    //   694: aload_0
    //   695: getfield 49	com/tencent/mm/plugin/music/c/b:LKW	J
    //   698: lcmp
    //   699: ifge +21 -> 720
    //   702: aload_0
    //   703: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   706: getfield 68	com/tencent/mm/plugin/music/c/a:LKN	J
    //   709: aload_0
    //   710: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   713: getfield 71	com/tencent/mm/plugin/music/c/a:LKO	J
    //   716: lcmp
    //   717: ifne +69 -> 786
    //   720: aload_0
    //   721: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   724: getfield 68	com/tencent/mm/plugin/music/c/a:LKN	J
    //   727: l2f
    //   728: aload_0
    //   729: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   732: getfield 71	com/tencent/mm/plugin/music/c/a:LKO	J
    //   735: l2f
    //   736: fdiv
    //   737: aload_0
    //   738: getfield 442	com/tencent/mm/plugin/music/c/b:LKV	F
    //   741: fsub
    //   742: ldc_w 445
    //   745: fcmpl
    //   746: iflt +40 -> 786
    //   749: ldc 85
    //   751: ldc_w 444
    //   754: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_0
    //   758: iconst_1
    //   759: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   762: aload_0
    //   763: iconst_0
    //   764: putfield 107	com/tencent/mm/plugin/music/c/b:Aey	Z
    //   767: new 8	com/tencent/mm/plugin/music/c/b$a
    //   770: dup
    //   771: aload_0
    //   772: iconst_1
    //   773: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   776: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   779: ldc_w 386
    //   782: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: return
    //   786: ldc 85
    //   788: ldc_w 447
    //   791: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_0
    //   795: iconst_1
    //   796: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   799: aload_0
    //   800: iconst_4
    //   801: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   804: ldc_w 386
    //   807: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   810: return
    //   811: astore 33
    //   813: ldc 85
    //   815: aload 33
    //   817: ldc_w 451
    //   820: iconst_1
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 52
    //   828: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   831: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   834: aastore
    //   835: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   838: goto -571 -> 267
    //   841: aload 40
    //   843: invokestatic 311	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   846: ifeq +36 -> 882
    //   849: ldc 85
    //   851: ldc_w 467
    //   854: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: aload_0
    //   858: iconst_1
    //   859: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   862: new 8	com/tencent/mm/plugin/music/c/b$a
    //   865: dup
    //   866: aload_0
    //   867: bipush 254
    //   869: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   872: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   875: ldc_w 386
    //   878: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: aconst_null
    //   883: astore 43
    //   885: aconst_null
    //   886: astore 41
    //   888: aconst_null
    //   889: astore 44
    //   891: aconst_null
    //   892: astore 46
    //   894: aconst_null
    //   895: astore 45
    //   897: aconst_null
    //   898: astore 42
    //   900: aconst_null
    //   901: astore 51
    //   903: aconst_null
    //   904: astore 47
    //   906: aconst_null
    //   907: astore 50
    //   909: aconst_null
    //   910: astore 49
    //   912: aconst_null
    //   913: astore 48
    //   915: aconst_null
    //   916: astore 33
    //   918: aload 33
    //   920: astore 38
    //   922: aload 51
    //   924: astore 34
    //   926: aload 47
    //   928: astore 35
    //   930: aload 50
    //   932: astore 37
    //   934: aload 49
    //   936: astore 39
    //   938: aload 48
    //   940: astore 36
    //   942: aload 52
    //   944: invokevirtual 420	com/tencent/mm/vfs/u:jKS	()Z
    //   947: ifne +334 -> 1281
    //   950: aload 33
    //   952: astore 38
    //   954: aload 51
    //   956: astore 34
    //   958: aload 47
    //   960: astore 35
    //   962: aload 50
    //   964: astore 37
    //   966: aload 49
    //   968: astore 39
    //   970: aload 48
    //   972: astore 36
    //   974: aload_0
    //   975: iconst_1
    //   976: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   979: aload 33
    //   981: astore 38
    //   983: aload 51
    //   985: astore 34
    //   987: aload 47
    //   989: astore 35
    //   991: aload 50
    //   993: astore 37
    //   995: aload 49
    //   997: astore 39
    //   999: aload 48
    //   1001: astore 36
    //   1003: ldc 85
    //   1005: ldc_w 469
    //   1008: iconst_1
    //   1009: anewarray 4	java/lang/Object
    //   1012: dup
    //   1013: iconst_0
    //   1014: aload 52
    //   1016: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   1019: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   1022: aastore
    //   1023: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1026: aload 33
    //   1028: astore 38
    //   1030: aload 51
    //   1032: astore 34
    //   1034: aload 47
    //   1036: astore 35
    //   1038: aload 50
    //   1040: astore 37
    //   1042: aload 49
    //   1044: astore 39
    //   1046: aload 48
    //   1048: astore 36
    //   1050: aload_0
    //   1051: bipush 19
    //   1053: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   1056: lload 4
    //   1058: lconst_0
    //   1059: lcmp
    //   1060: ifne +89 -> 1149
    //   1063: lload_2
    //   1064: lconst_0
    //   1065: lcmp
    //   1066: ifle +83 -> 1149
    //   1069: ldc 85
    //   1071: ldc_w 471
    //   1074: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1077: new 473	java/lang/NullPointerException
    //   1080: dup
    //   1081: invokespecial 474	java/lang/NullPointerException:<init>	()V
    //   1084: athrow
    //   1085: aload_0
    //   1086: lload_2
    //   1087: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   1090: lload_2
    //   1091: ldc2_w 405
    //   1094: lcmp
    //   1095: ifge +15 -> 1110
    //   1098: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1101: dup
    //   1102: aload_0
    //   1103: iconst_1
    //   1104: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1107: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   1110: aload_0
    //   1111: iconst_1
    //   1112: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   1115: ldc 85
    //   1117: ldc_w 478
    //   1120: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: ldc_w 386
    //   1126: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1129: return
    //   1130: astore 33
    //   1132: ldc 85
    //   1134: aload 33
    //   1136: ldc_w 480
    //   1139: iconst_0
    //   1140: anewarray 4	java/lang/Object
    //   1143: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1165: ldc_w 482
    //   1168: iconst_2
    //   1169: anewarray 4	java/lang/Object
    //   1172: dup
    //   1173: iconst_0
    //   1174: lload 4
    //   1176: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_1
    //   1182: lload_2
    //   1183: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1186: aastore
    //   1187: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1190: aload_0
    //   1191: lload_2
    //   1192: lload 4
    //   1194: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   1216: ldc_w 486
    //   1219: iconst_2
    //   1220: anewarray 4	java/lang/Object
    //   1223: dup
    //   1224: iconst_0
    //   1225: lload 4
    //   1227: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_1
    //   1233: lload_2
    //   1234: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1237: aastore
    //   1238: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1241: aload_0
    //   1242: lload 4
    //   1244: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   1247: lload_2
    //   1248: ldc2_w 405
    //   1251: lcmp
    //   1252: ifge -142 -> 1110
    //   1255: new 8	com/tencent/mm/plugin/music/c/b$a
    //   1258: dup
    //   1259: aload_0
    //   1260: iconst_1
    //   1261: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   1264: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   1267: goto -157 -> 1110
    //   1270: ldc 85
    //   1272: ldc_w 488
    //   1275: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1278: goto -168 -> 1110
    //   1281: aload 33
    //   1283: astore 38
    //   1285: aload 51
    //   1287: astore 34
    //   1289: aload 47
    //   1291: astore 35
    //   1293: aload 50
    //   1295: astore 37
    //   1297: aload 49
    //   1299: astore 39
    //   1301: aload 48
    //   1303: astore 36
    //   1305: aload 52
    //   1307: getfield 492	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   1310: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   1313: iconst_1
    //   1314: invokestatic 498	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   1317: astore 33
    //   1319: aload 33
    //   1321: astore 38
    //   1323: aload 33
    //   1325: astore 34
    //   1327: aload 33
    //   1329: astore 35
    //   1331: aload 33
    //   1333: astore 37
    //   1335: aload 33
    //   1337: astore 39
    //   1339: aload 33
    //   1341: astore 36
    //   1343: ldc 85
    //   1345: ldc_w 500
    //   1348: iconst_1
    //   1349: anewarray 4	java/lang/Object
    //   1352: dup
    //   1353: iconst_0
    //   1354: aload 40
    //   1356: aastore
    //   1357: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1360: aload 33
    //   1362: astore 38
    //   1364: aload 33
    //   1366: astore 34
    //   1368: aload 33
    //   1370: astore 35
    //   1372: aload 33
    //   1374: astore 37
    //   1376: aload 33
    //   1378: astore 39
    //   1380: aload 33
    //   1382: astore 36
    //   1384: new 502	java/util/HashMap
    //   1387: dup
    //   1388: bipush 10
    //   1390: invokespecial 504	java/util/HashMap:<init>	(I)V
    //   1393: astore 47
    //   1395: aload 33
    //   1397: astore 38
    //   1399: aload 33
    //   1401: astore 34
    //   1403: aload 33
    //   1405: astore 35
    //   1407: aload 33
    //   1409: astore 37
    //   1411: aload 33
    //   1413: astore 39
    //   1415: aload 33
    //   1417: astore 36
    //   1419: aload 47
    //   1421: ldc_w 506
    //   1424: ldc_w 508
    //   1427: invokeinterface 512 3 0
    //   1432: pop
    //   1433: lload 8
    //   1435: lload_2
    //   1436: lcmp
    //   1437: ifle +117 -> 1554
    //   1440: aload 33
    //   1442: astore 38
    //   1444: aload 33
    //   1446: astore 34
    //   1448: aload 33
    //   1450: astore 35
    //   1452: aload 33
    //   1454: astore 37
    //   1456: aload 33
    //   1458: astore 39
    //   1460: aload 33
    //   1462: astore 36
    //   1464: ldc 85
    //   1466: ldc_w 514
    //   1469: iconst_2
    //   1470: anewarray 4	java/lang/Object
    //   1473: dup
    //   1474: iconst_0
    //   1475: lload_2
    //   1476: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1479: aastore
    //   1480: dup
    //   1481: iconst_1
    //   1482: lload 8
    //   1484: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1487: aastore
    //   1488: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1491: aload 33
    //   1493: astore 38
    //   1495: aload 33
    //   1497: astore 34
    //   1499: aload 33
    //   1501: astore 35
    //   1503: aload 33
    //   1505: astore 37
    //   1507: aload 33
    //   1509: astore 39
    //   1511: aload 33
    //   1513: astore 36
    //   1515: aload 47
    //   1517: ldc_w 519
    //   1520: new 521	java/lang/StringBuilder
    //   1523: dup
    //   1524: ldc_w 523
    //   1527: invokespecial 524	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1530: lload_2
    //   1531: invokevirtual 528	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1534: ldc_w 322
    //   1537: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: lload 8
    //   1542: invokevirtual 528	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1545: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1548: invokeinterface 512 3 0
    //   1553: pop
    //   1554: iload 32
    //   1556: ifne +35 -> 1591
    //   1559: aload 33
    //   1561: astore 38
    //   1563: aload 33
    //   1565: astore 34
    //   1567: aload 33
    //   1569: astore 35
    //   1571: aload 33
    //   1573: astore 37
    //   1575: aload 33
    //   1577: astore 39
    //   1579: aload 33
    //   1581: astore 36
    //   1583: aload 40
    //   1585: invokestatic 537	com/tencent/mm/plugin/music/h/e:aPq	(Ljava/lang/String;)Z
    //   1588: ifeq +35 -> 1623
    //   1591: aload 33
    //   1593: astore 38
    //   1595: aload 33
    //   1597: astore 34
    //   1599: aload 33
    //   1601: astore 35
    //   1603: aload 33
    //   1605: astore 37
    //   1607: aload 33
    //   1609: astore 39
    //   1611: aload 33
    //   1613: astore 36
    //   1615: ldc 85
    //   1617: ldc_w 539
    //   1620: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1623: aload 33
    //   1625: astore 38
    //   1627: aload 33
    //   1629: astore 34
    //   1631: aload 33
    //   1633: astore 35
    //   1635: aload 33
    //   1637: astore 37
    //   1639: aload 33
    //   1641: astore 39
    //   1643: aload 33
    //   1645: astore 36
    //   1647: aload 47
    //   1649: ldc_w 541
    //   1652: new 521	java/lang/StringBuilder
    //   1655: dup
    //   1656: invokespecial 542	java/lang/StringBuilder:<init>	()V
    //   1659: ldc_w 544
    //   1662: invokestatic 549	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1665: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: ldc_w 551
    //   1671: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: invokestatic 99	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1677: invokestatic 555	com/tencent/mm/plugin/music/h/e:jf	(Landroid/content/Context;)Ljava/lang/String;
    //   1680: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokeinterface 512 3 0
    //   1691: pop
    //   1692: aload 33
    //   1694: astore 38
    //   1696: aload 33
    //   1698: astore 34
    //   1700: aload 33
    //   1702: astore 35
    //   1704: aload 33
    //   1706: astore 37
    //   1708: aload 33
    //   1710: astore 39
    //   1712: aload 33
    //   1714: astore 36
    //   1716: aload_0
    //   1717: aload 40
    //   1719: aload 47
    //   1721: invokespecial 557	com/tencent/mm/plugin/music/c/b:S	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
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
    //   1751: lstore 20
    //   1753: lload_2
    //   1754: lstore 12
    //   1756: lload 4
    //   1758: lstore 22
    //   1760: lload_2
    //   1761: lstore 10
    //   1763: lload 4
    //   1765: lstore 24
    //   1767: lload_2
    //   1768: lstore 14
    //   1770: lload 4
    //   1772: lstore 26
    //   1774: lload_2
    //   1775: lstore 18
    //   1777: lload 4
    //   1779: lstore 28
    //   1781: lload_2
    //   1782: lstore 16
    //   1784: aload 34
    //   1786: invokevirtual 243	java/net/HttpURLConnection:getResponseCode	()I
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
    //   1825: lstore 20
    //   1827: lload_2
    //   1828: lstore 12
    //   1830: lload 4
    //   1832: lstore 22
    //   1834: lload_2
    //   1835: lstore 10
    //   1837: lload 4
    //   1839: lstore 24
    //   1841: lload_2
    //   1842: lstore 14
    //   1844: lload 4
    //   1846: lstore 26
    //   1848: lload_2
    //   1849: lstore 18
    //   1851: lload 4
    //   1853: lstore 28
    //   1855: lload_2
    //   1856: lstore 16
    //   1858: iload_1
    //   1859: invokestatic 254	com/tencent/mm/plugin/music/c/b:adq	(I)V
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
    //   1883: lstore 20
    //   1885: lload_2
    //   1886: lstore 12
    //   1888: lload 4
    //   1890: lstore 22
    //   1892: lload_2
    //   1893: lstore 10
    //   1895: lload 4
    //   1897: lstore 24
    //   1899: lload_2
    //   1900: lstore 14
    //   1902: lload 4
    //   1904: lstore 26
    //   1906: lload_2
    //   1907: lstore 18
    //   1909: lload 4
    //   1911: lstore 28
    //   1913: lload_2
    //   1914: lstore 16
    //   1916: ldc 85
    //   1918: ldc_w 559
    //   1921: iconst_1
    //   1922: anewarray 4	java/lang/Object
    //   1925: dup
    //   1926: iconst_0
    //   1927: iload_1
    //   1928: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1931: aastore
    //   1932: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1956: lstore 20
    //   1958: lload_2
    //   1959: lstore 12
    //   1961: lload 4
    //   1963: lstore 22
    //   1965: lload_2
    //   1966: lstore 10
    //   1968: lload 4
    //   1970: lstore 24
    //   1972: lload_2
    //   1973: lstore 14
    //   1975: lload 4
    //   1977: lstore 26
    //   1979: lload_2
    //   1980: lstore 18
    //   1982: lload 4
    //   1984: lstore 28
    //   1986: lload_2
    //   1987: lstore 16
    //   1989: aload_0
    //   1990: iload_1
    //   1991: putfield 57	com/tencent/mm/plugin/music/c/b:LKX	I
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
    //   2015: lstore 20
    //   2017: lload_2
    //   2018: lstore 12
    //   2020: lload 4
    //   2022: lstore 22
    //   2024: lload_2
    //   2025: lstore 10
    //   2027: lload 4
    //   2029: lstore 24
    //   2031: lload_2
    //   2032: lstore 14
    //   2034: lload 4
    //   2036: lstore 26
    //   2038: lload_2
    //   2039: lstore 18
    //   2041: lload 4
    //   2043: lstore 28
    //   2045: lload_2
    //   2046: lstore 16
    //   2048: aload_0
    //   2049: iconst_m1
    //   2050: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   2053: lload 4
    //   2055: lconst_0
    //   2056: lcmp
    //   2057: ifne +115 -> 2172
    //   2060: lload_2
    //   2061: lconst_0
    //   2062: lcmp
    //   2063: ifle +109 -> 2172
    //   2066: ldc 85
    //   2068: ldc_w 471
    //   2071: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2074: aload 33
    //   2076: lload_2
    //   2077: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   2080: aload_0
    //   2081: lload_2
    //   2082: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   2085: lload_2
    //   2086: ldc2_w 405
    //   2089: lcmp
    //   2090: ifge +15 -> 2105
    //   2093: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2096: dup
    //   2097: aload_0
    //   2098: iconst_1
    //   2099: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2102: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   2105: aload 33
    //   2107: ifnull +8 -> 2115
    //   2110: aload 33
    //   2112: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   2140: ldc_w 478
    //   2143: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2146: ldc_w 386
    //   2149: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2152: return
    //   2153: astore 35
    //   2155: ldc 85
    //   2157: aload 35
    //   2159: ldc_w 480
    //   2162: iconst_0
    //   2163: anewarray 4	java/lang/Object
    //   2166: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   2188: ldc_w 482
    //   2191: iconst_2
    //   2192: anewarray 4	java/lang/Object
    //   2195: dup
    //   2196: iconst_0
    //   2197: lload 4
    //   2199: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2202: aastore
    //   2203: dup
    //   2204: iconst_1
    //   2205: lload_2
    //   2206: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2209: aastore
    //   2210: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2213: aload_0
    //   2214: lload_2
    //   2215: lload 4
    //   2217: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   2239: ldc_w 486
    //   2242: iconst_2
    //   2243: anewarray 4	java/lang/Object
    //   2246: dup
    //   2247: iconst_0
    //   2248: lload 4
    //   2250: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2253: aastore
    //   2254: dup
    //   2255: iconst_1
    //   2256: lload_2
    //   2257: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2260: aastore
    //   2261: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2264: aload_0
    //   2265: lload 4
    //   2267: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   2270: lload_2
    //   2271: ldc2_w 405
    //   2274: lcmp
    //   2275: ifge -170 -> 2105
    //   2278: new 8	com/tencent/mm/plugin/music/c/b$a
    //   2281: dup
    //   2282: aload_0
    //   2283: iconst_1
    //   2284: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   2287: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   2290: goto -185 -> 2105
    //   2293: ldc 85
    //   2295: ldc_w 488
    //   2298: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2301: goto -196 -> 2105
    //   2304: astore 33
    //   2306: ldc 85
    //   2308: aload 33
    //   2310: ldc_w 480
    //   2313: iconst_0
    //   2314: anewarray 4	java/lang/Object
    //   2317: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2320: goto -205 -> 2115
    //   2323: astore 33
    //   2325: ldc 85
    //   2327: aload 33
    //   2329: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2332: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   2359: lstore 20
    //   2361: lload_2
    //   2362: lstore 12
    //   2364: lload 4
    //   2366: lstore 22
    //   2368: lload_2
    //   2369: lstore 10
    //   2371: lload 4
    //   2373: lstore 24
    //   2375: lload_2
    //   2376: lstore 14
    //   2378: lload 4
    //   2380: lstore 26
    //   2382: lload_2
    //   2383: lstore 18
    //   2385: lload 4
    //   2387: lstore 28
    //   2389: lload_2
    //   2390: lstore 16
    //   2392: ldc 85
    //   2394: ldc_w 567
    //   2397: iconst_1
    //   2398: anewarray 4	java/lang/Object
    //   2401: dup
    //   2402: iconst_0
    //   2403: iload_1
    //   2404: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2407: aastore
    //   2408: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   2432: lstore 20
    //   2434: lload_2
    //   2435: lstore 12
    //   2437: lload 4
    //   2439: lstore 22
    //   2441: lload_2
    //   2442: lstore 10
    //   2444: lload 4
    //   2446: lstore 24
    //   2448: lload_2
    //   2449: lstore 14
    //   2451: lload 4
    //   2453: lstore 26
    //   2455: lload_2
    //   2456: lstore 18
    //   2458: lload 4
    //   2460: lstore 28
    //   2462: lload_2
    //   2463: lstore 16
    //   2465: ldc 85
    //   2467: new 521	java/lang/StringBuilder
    //   2470: dup
    //   2471: ldc_w 569
    //   2474: invokespecial 524	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2477: aload 34
    //   2479: ldc_w 541
    //   2482: invokevirtual 572	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   2485: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2488: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2491: invokestatic 574	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   2515: lstore 20
    //   2517: lload_2
    //   2518: lstore 12
    //   2520: lload 4
    //   2522: lstore 22
    //   2524: lload_2
    //   2525: lstore 10
    //   2527: lload 4
    //   2529: lstore 24
    //   2531: lload_2
    //   2532: lstore 14
    //   2534: lload 4
    //   2536: lstore 26
    //   2538: lload_2
    //   2539: lstore 18
    //   2541: lload 4
    //   2543: lstore 28
    //   2545: lload_2
    //   2546: lstore 16
    //   2548: aload 34
    //   2550: invokevirtual 577	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
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
    //   2576: lstore 20
    //   2578: lload_2
    //   2579: lstore 12
    //   2581: lload 4
    //   2583: lstore 22
    //   2585: lload_2
    //   2586: lstore 10
    //   2588: lload 4
    //   2590: lstore 24
    //   2592: lload_2
    //   2593: lstore 14
    //   2595: lload 4
    //   2597: lstore 26
    //   2599: lload_2
    //   2600: lstore 18
    //   2602: lload 4
    //   2604: lstore 28
    //   2606: lload_2
    //   2607: lstore 16
    //   2609: ldc 85
    //   2611: ldc_w 579
    //   2614: iconst_1
    //   2615: anewarray 4	java/lang/Object
    //   2618: dup
    //   2619: iconst_0
    //   2620: aload 38
    //   2622: aastore
    //   2623: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   2647: lstore 20
    //   2649: lload_2
    //   2650: lstore 12
    //   2652: lload 4
    //   2654: lstore 22
    //   2656: lload_2
    //   2657: lstore 10
    //   2659: lload 4
    //   2661: lstore 24
    //   2663: lload_2
    //   2664: lstore 14
    //   2666: lload 4
    //   2668: lstore 26
    //   2670: lload_2
    //   2671: lstore 18
    //   2673: lload 4
    //   2675: lstore 28
    //   2677: lload_2
    //   2678: lstore 16
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
    //   2707: lstore 20
    //   2709: lload_2
    //   2710: lstore 12
    //   2712: lload 4
    //   2714: lstore 22
    //   2716: lload_2
    //   2717: lstore 10
    //   2719: lload 4
    //   2721: lstore 24
    //   2723: lload_2
    //   2724: lstore 14
    //   2726: lload 4
    //   2728: lstore 26
    //   2730: lload_2
    //   2731: lstore 18
    //   2733: lload 4
    //   2735: lstore 28
    //   2737: lload_2
    //   2738: lstore 16
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
    //   2771: lstore 20
    //   2773: lload_2
    //   2774: lstore 12
    //   2776: lload 4
    //   2778: lstore 22
    //   2780: lload_2
    //   2781: lstore 10
    //   2783: lload 4
    //   2785: lstore 24
    //   2787: lload_2
    //   2788: lstore 14
    //   2790: lload 4
    //   2792: lstore 26
    //   2794: lload_2
    //   2795: lstore 18
    //   2797: lload 4
    //   2799: lstore 28
    //   2801: lload_2
    //   2802: lstore 16
    //   2804: aload_0
    //   2805: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   2808: getfield 580	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
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
    //   2838: lstore 20
    //   2840: lload_2
    //   2841: lstore 12
    //   2843: lload 4
    //   2845: lstore 22
    //   2847: lload_2
    //   2848: lstore 10
    //   2850: lload 4
    //   2852: lstore 24
    //   2854: lload_2
    //   2855: lstore 14
    //   2857: lload 4
    //   2859: lstore 26
    //   2861: lload_2
    //   2862: lstore 18
    //   2864: lload 4
    //   2866: lstore 28
    //   2868: lload_2
    //   2869: lstore 16
    //   2871: aload_0
    //   2872: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   2875: aload_0
    //   2876: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   2879: putfield 580	com/tencent/mm/plugin/music/c/a:mimeType	Ljava/lang/String;
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
    //   2903: lstore 20
    //   2905: lload_2
    //   2906: lstore 12
    //   2908: lload 4
    //   2910: lstore 22
    //   2912: lload_2
    //   2913: lstore 10
    //   2915: lload 4
    //   2917: lstore 24
    //   2919: lload_2
    //   2920: lstore 14
    //   2922: lload 4
    //   2924: lstore 26
    //   2926: lload_2
    //   2927: lstore 18
    //   2929: lload 4
    //   2931: lstore 28
    //   2933: lload_2
    //   2934: lstore 16
    //   2936: aload_0
    //   2937: getfield 61	com/tencent/mm/plugin/music/c/b:LKT	Lcom/tencent/mm/aw/f;
    //   2940: getfield 345	com/tencent/mm/aw/f:oOv	Ljava/lang/String;
    //   2943: astore 39
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
    //   2966: lstore 20
    //   2968: lload_2
    //   2969: lstore 12
    //   2971: lload 4
    //   2973: lstore 22
    //   2975: lload_2
    //   2976: lstore 10
    //   2978: lload 4
    //   2980: lstore 24
    //   2982: lload_2
    //   2983: lstore 14
    //   2985: lload 4
    //   2987: lstore 26
    //   2989: lload_2
    //   2990: lstore 18
    //   2992: lload 4
    //   2994: lstore 28
    //   2996: lload_2
    //   2997: lstore 16
    //   2999: aload_0
    //   3000: getfield 55	com/tencent/mm/plugin/music/c/b:mimeType	Ljava/lang/String;
    //   3003: astore 38
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
    //   3026: lstore 20
    //   3028: lload_2
    //   3029: lstore 12
    //   3031: lload 4
    //   3033: lstore 22
    //   3035: lload_2
    //   3036: lstore 10
    //   3038: lload 4
    //   3040: lstore 24
    //   3042: lload_2
    //   3043: lstore 14
    //   3045: lload 4
    //   3047: lstore 26
    //   3049: lload_2
    //   3050: lstore 18
    //   3052: lload 4
    //   3054: lstore 28
    //   3056: lload_2
    //   3057: lstore 16
    //   3059: invokestatic 583	com/tencent/mm/plugin/music/cache/e:gmX	()Z
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
    //   3086: lstore 20
    //   3088: lload_2
    //   3089: lstore 12
    //   3091: lload 4
    //   3093: lstore 22
    //   3095: lload_2
    //   3096: lstore 10
    //   3098: lload 4
    //   3100: lstore 24
    //   3102: lload_2
    //   3103: lstore 14
    //   3105: lload 4
    //   3107: lstore 26
    //   3109: lload_2
    //   3110: lstore 18
    //   3112: lload 4
    //   3114: lstore 28
    //   3116: lload_2
    //   3117: lstore 16
    //   3119: ldc_w 585
    //   3122: invokestatic 368	com/tencent/mm/plugin/music/e/c/b:bU	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/music/e/c/a;
    //   3125: checkcast 585	com/tencent/mm/plugin/music/cache/c
    //   3128: aload 39
    //   3130: aload 38
    //   3132: invokeinterface 588 3 0
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
    //   3158: lstore 20
    //   3160: lload_2
    //   3161: lstore 12
    //   3163: lload 4
    //   3165: lstore 22
    //   3167: lload_2
    //   3168: lstore 10
    //   3170: lload 4
    //   3172: lstore 24
    //   3174: lload_2
    //   3175: lstore 14
    //   3177: lload 4
    //   3179: lstore 26
    //   3181: lload_2
    //   3182: lstore 18
    //   3184: lload 4
    //   3186: lstore 28
    //   3188: lload_2
    //   3189: lstore 16
    //   3191: aload 34
    //   3193: ldc_w 590
    //   3196: invokevirtual 269	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
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
    //   3222: lstore 20
    //   3224: lload_2
    //   3225: lstore 12
    //   3227: lload 4
    //   3229: lstore 22
    //   3231: lload_2
    //   3232: lstore 10
    //   3234: lload 4
    //   3236: lstore 24
    //   3238: lload_2
    //   3239: lstore 14
    //   3241: lload 4
    //   3243: lstore 26
    //   3245: lload_2
    //   3246: lstore 18
    //   3248: lload 4
    //   3250: lstore 28
    //   3252: lload_2
    //   3253: lstore 16
    //   3255: aload 38
    //   3257: invokestatic 592	com/tencent/mm/plugin/music/c/b:aOQ	(Ljava/lang/String;)[J
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
    //   3283: lstore 20
    //   3285: lload_2
    //   3286: lstore 12
    //   3288: lload 4
    //   3290: lstore 22
    //   3292: lload_2
    //   3293: lstore 10
    //   3295: lload 4
    //   3297: lstore 24
    //   3299: lload_2
    //   3300: lstore 14
    //   3302: lload 4
    //   3304: lstore 26
    //   3306: lload_2
    //   3307: lstore 18
    //   3309: lload 4
    //   3311: lstore 28
    //   3313: lload_2
    //   3314: lstore 16
    //   3316: aload 34
    //   3318: ldc_w 594
    //   3321: invokevirtual 269	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3324: lconst_0
    //   3325: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:getLong	(Ljava/lang/String;J)J
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
    //   3351: lstore 20
    //   3353: lload_2
    //   3354: lstore 12
    //   3356: lload 4
    //   3358: lstore 22
    //   3360: lload_2
    //   3361: lstore 10
    //   3363: lload 4
    //   3365: lstore 24
    //   3367: lload_2
    //   3368: lstore 14
    //   3370: lload 4
    //   3372: lstore 26
    //   3374: lload_2
    //   3375: lstore 18
    //   3377: lload 4
    //   3379: lstore 28
    //   3381: lload_2
    //   3382: lstore 16
    //   3384: ldc 85
    //   3386: ldc_w 600
    //   3389: iconst_2
    //   3390: anewarray 4	java/lang/Object
    //   3393: dup
    //   3394: iconst_0
    //   3395: aload 38
    //   3397: aastore
    //   3398: dup
    //   3399: iconst_1
    //   3400: lload 30
    //   3402: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3405: aastore
    //   3406: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   3435: lstore 20
    //   3437: lload_2
    //   3438: lstore 12
    //   3440: lload 4
    //   3442: lstore 22
    //   3444: lload_2
    //   3445: lstore 10
    //   3447: lload 4
    //   3449: lstore 24
    //   3451: lload_2
    //   3452: lstore 14
    //   3454: lload 4
    //   3456: lstore 26
    //   3458: lload_2
    //   3459: lstore 18
    //   3461: lload 4
    //   3463: lstore 28
    //   3465: lload_2
    //   3466: lstore 16
    //   3468: ldc 85
    //   3470: ldc_w 602
    //   3473: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3476: lload_2
    //   3477: lstore 4
    //   3479: lload_2
    //   3480: lconst_0
    //   3481: lcmp
    //   3482: ifeq +4389 -> 7871
    //   3485: lconst_0
    //   3486: lstore 4
    //   3488: goto +4383 -> 7871
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
    //   3512: lstore 20
    //   3514: lload_2
    //   3515: lstore 12
    //   3517: lload 4
    //   3519: lstore 22
    //   3521: lload_2
    //   3522: lstore 10
    //   3524: lload 4
    //   3526: lstore 24
    //   3528: lload_2
    //   3529: lstore 14
    //   3531: lload 4
    //   3533: lstore 26
    //   3535: lload_2
    //   3536: lstore 18
    //   3538: lload 4
    //   3540: lstore 28
    //   3542: lload_2
    //   3543: lstore 16
    //   3545: ldc 85
    //   3547: ldc_w 604
    //   3550: iconst_3
    //   3551: anewarray 4	java/lang/Object
    //   3554: dup
    //   3555: iconst_0
    //   3556: lload 30
    //   3558: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3561: aastore
    //   3562: dup
    //   3563: iconst_1
    //   3564: lload_2
    //   3565: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3568: aastore
    //   3569: dup
    //   3570: iconst_2
    //   3571: aload_0
    //   3572: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   3575: invokestatic 430	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3578: aastore
    //   3579: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   3603: lstore 20
    //   3605: lload_2
    //   3606: lstore 12
    //   3608: lload 4
    //   3610: lstore 22
    //   3612: lload_2
    //   3613: lstore 10
    //   3615: lload 4
    //   3617: lstore 24
    //   3619: lload_2
    //   3620: lstore 14
    //   3622: lload 4
    //   3624: lstore 26
    //   3626: lload_2
    //   3627: lstore 18
    //   3629: lload 4
    //   3631: lstore 28
    //   3633: lload_2
    //   3634: lstore 16
    //   3636: aload 33
    //   3638: lload 30
    //   3640: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
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
    //   3664: lstore 20
    //   3666: lload_2
    //   3667: lstore 12
    //   3669: lload 4
    //   3671: lstore 22
    //   3673: lload_2
    //   3674: lstore 10
    //   3676: lload 4
    //   3678: lstore 24
    //   3680: lload_2
    //   3681: lstore 14
    //   3683: lload 4
    //   3685: lstore 26
    //   3687: lload_2
    //   3688: lstore 18
    //   3690: lload 4
    //   3692: lstore 28
    //   3694: lload_2
    //   3695: lstore 16
    //   3697: aload 33
    //   3699: lload_2
    //   3700: invokevirtual 607	java/io/RandomAccessFile:seek	(J)V
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
    //   3724: lstore 20
    //   3726: lload_2
    //   3727: lstore 12
    //   3729: lload 4
    //   3731: lstore 22
    //   3733: lload_2
    //   3734: lstore 10
    //   3736: lload 4
    //   3738: lstore 24
    //   3740: lload_2
    //   3741: lstore 14
    //   3743: lload 4
    //   3745: lstore 26
    //   3747: lload_2
    //   3748: lstore 18
    //   3750: lload 4
    //   3752: lstore 28
    //   3754: lload_2
    //   3755: lstore 16
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
    //   3794: lstore 10
    //   3796: lload_2
    //   3797: lstore 12
    //   3799: lload_2
    //   3800: lstore 14
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
    //   3835: lstore 10
    //   3837: lload_2
    //   3838: lstore 12
    //   3840: lload_2
    //   3841: lstore 14
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
    //   3876: lstore 10
    //   3878: lload_2
    //   3879: lstore 12
    //   3881: lload_2
    //   3882: lstore 14
    //   3884: aload 35
    //   3886: aload 38
    //   3888: invokevirtual 611	java/io/InputStream:read	([B)I
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
    //   3922: lstore 10
    //   3924: lload_2
    //   3925: lstore 12
    //   3927: lload_2
    //   3928: lstore 14
    //   3930: aload 33
    //   3932: aload 38
    //   3934: iconst_0
    //   3935: iload_1
    //   3936: invokevirtual 615	java/io/RandomAccessFile:write	([BII)V
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
    //   3975: lstore 10
    //   3977: lload 6
    //   3979: lstore 12
    //   3981: lload 6
    //   3983: lstore 14
    //   3985: ldc 85
    //   3987: ldc_w 617
    //   3990: iconst_2
    //   3991: anewarray 4	java/lang/Object
    //   3994: dup
    //   3995: iconst_0
    //   3996: lload 6
    //   3998: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4001: aastore
    //   4002: dup
    //   4003: iconst_1
    //   4004: lload 30
    //   4006: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4009: aastore
    //   4010: invokestatic 619	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   4043: lstore 10
    //   4045: lload 6
    //   4047: lstore 12
    //   4049: lload 6
    //   4051: lstore 14
    //   4053: aload_0
    //   4054: getfield 107	com/tencent/mm/plugin/music/c/b:Aey	Z
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
    //   4090: lstore 10
    //   4092: lload 6
    //   4094: lstore 12
    //   4096: lload 6
    //   4098: lstore 14
    //   4100: aload_0
    //   4101: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   4104: lload 6
    //   4106: putfield 77	com/tencent/mm/plugin/music/c/a:LKP	J
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
    //   4139: lstore 10
    //   4141: lload 6
    //   4143: lstore 12
    //   4145: lload 6
    //   4147: lstore 14
    //   4149: aload_0
    //   4150: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   4153: lload 30
    //   4155: putfield 80	com/tencent/mm/plugin/music/c/a:LKR	J
    //   4158: lload 6
    //   4160: lstore_2
    //   4161: lload 6
    //   4163: ldc2_w 405
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
    //   4200: lstore 10
    //   4202: lload 6
    //   4204: lstore 12
    //   4206: lload 6
    //   4208: lstore 14
    //   4210: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4213: dup
    //   4214: aload_0
    //   4215: iconst_1
    //   4216: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4219: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
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
    //   4256: ldc_w 621
    //   4259: iconst_1
    //   4260: anewarray 4	java/lang/Object
    //   4263: dup
    //   4264: iconst_0
    //   4265: aload 52
    //   4267: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   4270: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   4273: aastore
    //   4274: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   4300: putfield 59	com/tencent/mm/plugin/music/c/b:hsf	I
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
    //   4324: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   4327: lload 4
    //   4329: lconst_0
    //   4330: lcmp
    //   4331: ifne +1384 -> 5715
    //   4334: lload_2
    //   4335: lconst_0
    //   4336: lcmp
    //   4337: ifle +1378 -> 5715
    //   4340: ldc 85
    //   4342: ldc_w 471
    //   4345: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4348: aload 33
    //   4350: lload_2
    //   4351: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   4354: aload_0
    //   4355: lload_2
    //   4356: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   4359: lload_2
    //   4360: ldc2_w 405
    //   4363: lcmp
    //   4364: ifge +15 -> 4379
    //   4367: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4370: dup
    //   4371: aload_0
    //   4372: iconst_1
    //   4373: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4376: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4379: aload 35
    //   4381: ifnull +8 -> 4389
    //   4384: aload 35
    //   4386: invokevirtual 139	java/io/InputStream:close	()V
    //   4389: aload 33
    //   4391: ifnull +8 -> 4399
    //   4394: aload 33
    //   4396: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   4424: ldc_w 478
    //   4427: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4430: ldc_w 386
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
    //   4458: lstore 20
    //   4460: lload_2
    //   4461: lstore 12
    //   4463: lload 4
    //   4465: lstore 22
    //   4467: lload_2
    //   4468: lstore 10
    //   4470: lload 4
    //   4472: lstore 24
    //   4474: lload_2
    //   4475: lstore 14
    //   4477: lload 4
    //   4479: lstore 26
    //   4481: lload_2
    //   4482: lstore 18
    //   4484: lload 4
    //   4486: lstore 28
    //   4488: lload_2
    //   4489: lstore 16
    //   4491: ldc_w 623
    //   4494: ldc_w 625
    //   4497: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   4539: lstore 20
    //   4541: lload_2
    //   4542: lstore 12
    //   4544: lload 4
    //   4546: lstore 22
    //   4548: lload_2
    //   4549: lstore 10
    //   4551: lload 4
    //   4553: lstore 24
    //   4555: lload_2
    //   4556: lstore 14
    //   4558: lload 4
    //   4560: lstore 26
    //   4562: lload_2
    //   4563: lstore 18
    //   4565: lload 4
    //   4567: lstore 28
    //   4569: lload_2
    //   4570: lstore 16
    //   4572: ldc 85
    //   4574: ldc_w 627
    //   4577: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   4601: lstore 20
    //   4603: lload_2
    //   4604: lstore 12
    //   4606: lload 4
    //   4608: lstore 22
    //   4610: lload_2
    //   4611: lstore 10
    //   4613: lload 4
    //   4615: lstore 24
    //   4617: lload_2
    //   4618: lstore 14
    //   4620: lload 4
    //   4622: lstore 26
    //   4624: lload_2
    //   4625: lstore 18
    //   4627: lload 4
    //   4629: lstore 28
    //   4631: lload_2
    //   4632: lstore 16
    //   4634: aload_0
    //   4635: bipush 6
    //   4637: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   4640: lload 4
    //   4642: lconst_0
    //   4643: lcmp
    //   4644: ifne +115 -> 4759
    //   4647: lload_2
    //   4648: lconst_0
    //   4649: lcmp
    //   4650: ifle +109 -> 4759
    //   4653: ldc 85
    //   4655: ldc_w 471
    //   4658: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4661: aload 33
    //   4663: lload_2
    //   4664: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   4667: aload_0
    //   4668: lload_2
    //   4669: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   4672: lload_2
    //   4673: ldc2_w 405
    //   4676: lcmp
    //   4677: ifge +15 -> 4692
    //   4680: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4683: dup
    //   4684: aload_0
    //   4685: iconst_1
    //   4686: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4689: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4692: aload 33
    //   4694: ifnull +8 -> 4702
    //   4697: aload 33
    //   4699: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   4727: ldc_w 478
    //   4730: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4733: ldc_w 386
    //   4736: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4739: return
    //   4740: astore 35
    //   4742: ldc 85
    //   4744: aload 35
    //   4746: ldc_w 480
    //   4749: iconst_0
    //   4750: anewarray 4	java/lang/Object
    //   4753: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   4775: ldc_w 482
    //   4778: iconst_2
    //   4779: anewarray 4	java/lang/Object
    //   4782: dup
    //   4783: iconst_0
    //   4784: lload 4
    //   4786: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4789: aastore
    //   4790: dup
    //   4791: iconst_1
    //   4792: lload_2
    //   4793: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4796: aastore
    //   4797: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4800: aload_0
    //   4801: lload_2
    //   4802: lload 4
    //   4804: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   4826: ldc_w 486
    //   4829: iconst_2
    //   4830: anewarray 4	java/lang/Object
    //   4833: dup
    //   4834: iconst_0
    //   4835: lload 4
    //   4837: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4840: aastore
    //   4841: dup
    //   4842: iconst_1
    //   4843: lload_2
    //   4844: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4847: aastore
    //   4848: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4851: aload_0
    //   4852: lload 4
    //   4854: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   4857: lload_2
    //   4858: ldc2_w 405
    //   4861: lcmp
    //   4862: ifge -170 -> 4692
    //   4865: new 8	com/tencent/mm/plugin/music/c/b$a
    //   4868: dup
    //   4869: aload_0
    //   4870: iconst_1
    //   4871: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   4874: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   4877: goto -185 -> 4692
    //   4880: ldc 85
    //   4882: ldc_w 488
    //   4885: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4888: goto -196 -> 4692
    //   4891: astore 33
    //   4893: ldc 85
    //   4895: aload 33
    //   4897: ldc_w 480
    //   4900: iconst_0
    //   4901: anewarray 4	java/lang/Object
    //   4904: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4907: goto -205 -> 4702
    //   4910: astore 33
    //   4912: ldc 85
    //   4914: aload 33
    //   4916: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4919: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4922: goto -207 -> 4715
    //   4925: aload 39
    //   4927: iconst_2
    //   4928: laload
    //   4929: lstore 4
    //   4931: goto +2951 -> 7882
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
    //   4964: lstore 10
    //   4966: lload 6
    //   4968: lstore 12
    //   4970: lload 6
    //   4972: lstore 14
    //   4974: aload_0
    //   4975: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   4978: lload 6
    //   4980: putfield 68	com/tencent/mm/plugin/music/c/a:LKN	J
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
    //   5013: lstore 10
    //   5015: lload 6
    //   5017: lstore 12
    //   5019: lload 6
    //   5021: lstore 14
    //   5023: aload_0
    //   5024: getfield 63	com/tencent/mm/plugin/music/c/b:LKU	Lcom/tencent/mm/plugin/music/c/a;
    //   5027: lload 30
    //   5029: putfield 71	com/tencent/mm/plugin/music/c/a:LKO	J
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
    //   5067: ldc_w 621
    //   5070: iconst_1
    //   5071: anewarray 4	java/lang/Object
    //   5074: dup
    //   5075: iconst_0
    //   5076: aload 52
    //   5078: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   5081: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   5084: aastore
    //   5085: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   5111: putfield 59	com/tencent/mm/plugin/music/c/b:hsf	I
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
    //   5135: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   5138: lload 4
    //   5140: lconst_0
    //   5141: lcmp
    //   5142: ifne +777 -> 5919
    //   5145: lload_2
    //   5146: lconst_0
    //   5147: lcmp
    //   5148: ifle +771 -> 5919
    //   5151: ldc 85
    //   5153: ldc_w 471
    //   5156: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5159: aload 33
    //   5161: lload_2
    //   5162: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   5165: aload_0
    //   5166: lload_2
    //   5167: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   5170: lload_2
    //   5171: ldc2_w 405
    //   5174: lcmp
    //   5175: ifge +15 -> 5190
    //   5178: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5181: dup
    //   5182: aload_0
    //   5183: iconst_1
    //   5184: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5187: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5190: aload 39
    //   5192: ifnull +8 -> 5200
    //   5195: aload 39
    //   5197: invokevirtual 139	java/io/InputStream:close	()V
    //   5200: aload 33
    //   5202: ifnull +8 -> 5210
    //   5205: aload 33
    //   5207: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   5235: ldc_w 478
    //   5238: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5241: ldc_w 386
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
    //   5274: lstore 10
    //   5276: lload_2
    //   5277: lstore 12
    //   5279: lload_2
    //   5280: lstore 14
    //   5282: ldc 85
    //   5284: ldc_w 629
    //   5287: iconst_4
    //   5288: anewarray 4	java/lang/Object
    //   5291: dup
    //   5292: iconst_0
    //   5293: iload_1
    //   5294: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5297: aastore
    //   5298: dup
    //   5299: iconst_1
    //   5300: aload_0
    //   5301: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5304: invokestatic 430	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5307: aastore
    //   5308: dup
    //   5309: iconst_2
    //   5310: lload_2
    //   5311: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5314: aastore
    //   5315: dup
    //   5316: iconst_3
    //   5317: lload 30
    //   5319: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5322: aastore
    //   5323: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   5352: lstore 10
    //   5354: lload_2
    //   5355: lstore 12
    //   5357: lload_2
    //   5358: lstore 14
    //   5360: ldc 85
    //   5362: ldc_w 631
    //   5365: iconst_1
    //   5366: anewarray 4	java/lang/Object
    //   5369: dup
    //   5370: iconst_0
    //   5371: aload_0
    //   5372: getfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   5375: invokestatic 430	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5378: aastore
    //   5379: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5382: lload 4
    //   5384: lconst_0
    //   5385: lcmp
    //   5386: ifne +125 -> 5511
    //   5389: lload_2
    //   5390: lconst_0
    //   5391: lcmp
    //   5392: ifle +119 -> 5511
    //   5395: ldc 85
    //   5397: ldc_w 471
    //   5400: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5403: aload 33
    //   5405: lload_2
    //   5406: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   5409: aload_0
    //   5410: lload_2
    //   5411: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   5414: lload_2
    //   5415: ldc2_w 405
    //   5418: lcmp
    //   5419: ifge +15 -> 5434
    //   5422: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5425: dup
    //   5426: aload_0
    //   5427: iconst_1
    //   5428: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5431: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5434: aload 35
    //   5436: ifnull +8 -> 5444
    //   5439: aload 35
    //   5441: invokevirtual 139	java/io/InputStream:close	()V
    //   5444: aload 33
    //   5446: ifnull +8 -> 5454
    //   5449: aload 33
    //   5451: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   5479: ldc_w 478
    //   5482: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5485: ldc_w 386
    //   5488: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5491: return
    //   5492: astore 36
    //   5494: ldc 85
    //   5496: aload 36
    //   5498: ldc_w 480
    //   5501: iconst_0
    //   5502: anewarray 4	java/lang/Object
    //   5505: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   5527: ldc_w 482
    //   5530: iconst_2
    //   5531: anewarray 4	java/lang/Object
    //   5534: dup
    //   5535: iconst_0
    //   5536: lload 4
    //   5538: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5541: aastore
    //   5542: dup
    //   5543: iconst_1
    //   5544: lload_2
    //   5545: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5548: aastore
    //   5549: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5552: aload_0
    //   5553: lload_2
    //   5554: lload 4
    //   5556: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   5578: ldc_w 486
    //   5581: iconst_2
    //   5582: anewarray 4	java/lang/Object
    //   5585: dup
    //   5586: iconst_0
    //   5587: lload 4
    //   5589: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5592: aastore
    //   5593: dup
    //   5594: iconst_1
    //   5595: lload_2
    //   5596: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5599: aastore
    //   5600: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5603: aload_0
    //   5604: lload 4
    //   5606: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   5609: lload_2
    //   5610: ldc2_w 405
    //   5613: lcmp
    //   5614: ifge -180 -> 5434
    //   5617: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5620: dup
    //   5621: aload_0
    //   5622: iconst_1
    //   5623: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5626: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5629: goto -195 -> 5434
    //   5632: ldc 85
    //   5634: ldc_w 488
    //   5637: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5640: goto -206 -> 5434
    //   5643: astore 35
    //   5645: ldc 85
    //   5647: aload 35
    //   5649: ldc_w 633
    //   5652: iconst_0
    //   5653: anewarray 4	java/lang/Object
    //   5656: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5659: goto -215 -> 5444
    //   5662: astore 33
    //   5664: ldc 85
    //   5666: aload 33
    //   5668: ldc_w 480
    //   5671: iconst_0
    //   5672: anewarray 4	java/lang/Object
    //   5675: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5678: goto -224 -> 5454
    //   5681: astore 33
    //   5683: ldc 85
    //   5685: aload 33
    //   5687: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5690: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5693: goto -226 -> 5467
    //   5696: astore 36
    //   5698: ldc 85
    //   5700: aload 36
    //   5702: ldc_w 480
    //   5705: iconst_0
    //   5706: anewarray 4	java/lang/Object
    //   5709: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   5731: ldc_w 482
    //   5734: iconst_2
    //   5735: anewarray 4	java/lang/Object
    //   5738: dup
    //   5739: iconst_0
    //   5740: lload 4
    //   5742: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5745: aastore
    //   5746: dup
    //   5747: iconst_1
    //   5748: lload_2
    //   5749: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5752: aastore
    //   5753: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5756: aload_0
    //   5757: lload_2
    //   5758: lload 4
    //   5760: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   5782: ldc_w 486
    //   5785: iconst_2
    //   5786: anewarray 4	java/lang/Object
    //   5789: dup
    //   5790: iconst_0
    //   5791: lload 4
    //   5793: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5796: aastore
    //   5797: dup
    //   5798: iconst_1
    //   5799: lload_2
    //   5800: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5803: aastore
    //   5804: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5807: aload_0
    //   5808: lload 4
    //   5810: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   5813: lload_2
    //   5814: ldc2_w 405
    //   5817: lcmp
    //   5818: ifge -1439 -> 4379
    //   5821: new 8	com/tencent/mm/plugin/music/c/b$a
    //   5824: dup
    //   5825: aload_0
    //   5826: iconst_1
    //   5827: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   5830: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   5833: goto -1454 -> 4379
    //   5836: ldc 85
    //   5838: ldc_w 488
    //   5841: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5844: goto -1465 -> 4379
    //   5847: astore 35
    //   5849: ldc 85
    //   5851: aload 35
    //   5853: ldc_w 633
    //   5856: iconst_0
    //   5857: anewarray 4	java/lang/Object
    //   5860: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5863: goto -1474 -> 4389
    //   5866: astore 33
    //   5868: ldc 85
    //   5870: aload 33
    //   5872: ldc_w 480
    //   5875: iconst_0
    //   5876: anewarray 4	java/lang/Object
    //   5879: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5882: goto -1483 -> 4399
    //   5885: astore 33
    //   5887: ldc 85
    //   5889: aload 33
    //   5891: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5894: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5897: goto -1485 -> 4412
    //   5900: astore 35
    //   5902: ldc 85
    //   5904: aload 35
    //   5906: ldc_w 480
    //   5909: iconst_0
    //   5910: anewarray 4	java/lang/Object
    //   5913: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   5935: ldc_w 482
    //   5938: iconst_2
    //   5939: anewarray 4	java/lang/Object
    //   5942: dup
    //   5943: iconst_0
    //   5944: lload 4
    //   5946: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5949: aastore
    //   5950: dup
    //   5951: iconst_1
    //   5952: lload_2
    //   5953: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5956: aastore
    //   5957: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5960: aload_0
    //   5961: lload_2
    //   5962: lload 4
    //   5964: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   5986: ldc_w 486
    //   5989: iconst_2
    //   5990: anewarray 4	java/lang/Object
    //   5993: dup
    //   5994: iconst_0
    //   5995: lload 4
    //   5997: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6000: aastore
    //   6001: dup
    //   6002: iconst_1
    //   6003: lload_2
    //   6004: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6007: aastore
    //   6008: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6011: aload_0
    //   6012: lload 4
    //   6014: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   6017: lload_2
    //   6018: ldc2_w 405
    //   6021: lcmp
    //   6022: ifge -832 -> 5190
    //   6025: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6028: dup
    //   6029: aload_0
    //   6030: iconst_1
    //   6031: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6034: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6037: goto -847 -> 5190
    //   6040: ldc 85
    //   6042: ldc_w 488
    //   6045: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6048: goto -858 -> 5190
    //   6051: astore 35
    //   6053: ldc 85
    //   6055: aload 35
    //   6057: ldc_w 633
    //   6060: iconst_0
    //   6061: anewarray 4	java/lang/Object
    //   6064: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6067: goto -867 -> 5200
    //   6070: astore 33
    //   6072: ldc 85
    //   6074: aload 33
    //   6076: ldc_w 480
    //   6079: iconst_0
    //   6080: anewarray 4	java/lang/Object
    //   6083: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6086: goto -876 -> 5210
    //   6089: astore 33
    //   6091: ldc 85
    //   6093: aload 33
    //   6095: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6098: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6101: goto -878 -> 5223
    //   6104: astore 35
    //   6106: aconst_null
    //   6107: astore 34
    //   6109: aload 43
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
    //   6144: ldc_w 621
    //   6147: iconst_1
    //   6148: anewarray 4	java/lang/Object
    //   6151: dup
    //   6152: iconst_0
    //   6153: aload 52
    //   6155: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   6158: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   6161: aastore
    //   6162: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   6188: putfield 59	com/tencent/mm/plugin/music/c/b:hsf	I
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
    //   6212: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   6215: lload 4
    //   6217: lconst_0
    //   6218: lcmp
    //   6219: ifne +125 -> 6344
    //   6222: lload_2
    //   6223: lconst_0
    //   6224: lcmp
    //   6225: ifle +119 -> 6344
    //   6228: ldc 85
    //   6230: ldc_w 471
    //   6233: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6236: aload 33
    //   6238: lload_2
    //   6239: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   6242: aload_0
    //   6243: lload_2
    //   6244: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   6247: lload_2
    //   6248: ldc2_w 405
    //   6251: lcmp
    //   6252: ifge +15 -> 6267
    //   6255: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6258: dup
    //   6259: aload_0
    //   6260: iconst_1
    //   6261: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6264: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6267: aload 39
    //   6269: ifnull +8 -> 6277
    //   6272: aload 39
    //   6274: invokevirtual 139	java/io/InputStream:close	()V
    //   6277: aload 33
    //   6279: ifnull +8 -> 6287
    //   6282: aload 33
    //   6284: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   6312: ldc_w 478
    //   6315: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6318: ldc_w 386
    //   6321: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6324: return
    //   6325: astore 35
    //   6327: ldc 85
    //   6329: aload 35
    //   6331: ldc_w 480
    //   6334: iconst_0
    //   6335: anewarray 4	java/lang/Object
    //   6338: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   6360: ldc_w 482
    //   6363: iconst_2
    //   6364: anewarray 4	java/lang/Object
    //   6367: dup
    //   6368: iconst_0
    //   6369: lload 4
    //   6371: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6374: aastore
    //   6375: dup
    //   6376: iconst_1
    //   6377: lload_2
    //   6378: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6381: aastore
    //   6382: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6385: aload_0
    //   6386: lload_2
    //   6387: lload 4
    //   6389: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   6411: ldc_w 486
    //   6414: iconst_2
    //   6415: anewarray 4	java/lang/Object
    //   6418: dup
    //   6419: iconst_0
    //   6420: lload 4
    //   6422: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6425: aastore
    //   6426: dup
    //   6427: iconst_1
    //   6428: lload_2
    //   6429: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6432: aastore
    //   6433: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6436: aload_0
    //   6437: lload 4
    //   6439: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   6442: lload_2
    //   6443: ldc2_w 405
    //   6446: lcmp
    //   6447: ifge -180 -> 6267
    //   6450: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6453: dup
    //   6454: aload_0
    //   6455: iconst_1
    //   6456: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6459: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6462: goto -195 -> 6267
    //   6465: ldc 85
    //   6467: ldc_w 488
    //   6470: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6473: goto -206 -> 6267
    //   6476: astore 35
    //   6478: ldc 85
    //   6480: aload 35
    //   6482: ldc_w 633
    //   6485: iconst_0
    //   6486: anewarray 4	java/lang/Object
    //   6489: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6492: goto -215 -> 6277
    //   6495: astore 33
    //   6497: ldc 85
    //   6499: aload 33
    //   6501: ldc_w 480
    //   6504: iconst_0
    //   6505: anewarray 4	java/lang/Object
    //   6508: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6511: goto -224 -> 6287
    //   6514: astore 33
    //   6516: ldc 85
    //   6518: aload 33
    //   6520: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6523: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6526: goto -226 -> 6300
    //   6529: astore 40
    //   6531: aconst_null
    //   6532: astore 33
    //   6534: aload 41
    //   6536: astore 39
    //   6538: aload 34
    //   6540: astore 38
    //   6542: aload 38
    //   6544: astore 37
    //   6546: aload 33
    //   6548: astore 36
    //   6550: lload 4
    //   6552: lstore 8
    //   6554: lload_2
    //   6555: lstore 6
    //   6557: aload 39
    //   6559: astore 35
    //   6561: ldc 85
    //   6563: aload 40
    //   6565: ldc_w 621
    //   6568: iconst_1
    //   6569: anewarray 4	java/lang/Object
    //   6572: dup
    //   6573: iconst_0
    //   6574: aload 52
    //   6576: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   6579: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   6582: aastore
    //   6583: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6586: aload 38
    //   6588: astore 37
    //   6590: aload 33
    //   6592: astore 36
    //   6594: lload 4
    //   6596: lstore 8
    //   6598: lload_2
    //   6599: lstore 6
    //   6601: aload 39
    //   6603: astore 35
    //   6605: aload_0
    //   6606: sipush 753
    //   6609: putfield 59	com/tencent/mm/plugin/music/c/b:hsf	I
    //   6612: aload 38
    //   6614: astore 37
    //   6616: aload 33
    //   6618: astore 36
    //   6620: lload 4
    //   6622: lstore 8
    //   6624: lload_2
    //   6625: lstore 6
    //   6627: aload 39
    //   6629: astore 35
    //   6631: aload_0
    //   6632: iconst_5
    //   6633: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   6636: lload 4
    //   6638: lconst_0
    //   6639: lcmp
    //   6640: ifne +125 -> 6765
    //   6643: lload_2
    //   6644: lconst_0
    //   6645: lcmp
    //   6646: ifle +119 -> 6765
    //   6649: ldc 85
    //   6651: ldc_w 471
    //   6654: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6657: aload 38
    //   6659: lload_2
    //   6660: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   6663: aload_0
    //   6664: lload_2
    //   6665: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   6668: lload_2
    //   6669: ldc2_w 405
    //   6672: lcmp
    //   6673: ifge +15 -> 6688
    //   6676: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6679: dup
    //   6680: aload_0
    //   6681: iconst_1
    //   6682: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6685: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6688: aload 39
    //   6690: ifnull +8 -> 6698
    //   6693: aload 39
    //   6695: invokevirtual 139	java/io/InputStream:close	()V
    //   6698: aload 38
    //   6700: ifnull +8 -> 6708
    //   6703: aload 38
    //   6705: invokevirtual 565	java/io/RandomAccessFile:close	()V
    //   6708: aload 33
    //   6710: ifnull +16 -> 6726
    //   6713: aload 33
    //   6715: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6718: invokevirtual 139	java/io/InputStream:close	()V
    //   6721: aload 33
    //   6723: invokevirtual 142	java/net/HttpURLConnection:disconnect	()V
    //   6726: aload_0
    //   6727: iconst_1
    //   6728: putfield 51	com/tencent/mm/plugin/music/c/b:isStop	Z
    //   6731: ldc 85
    //   6733: ldc_w 478
    //   6736: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6739: ldc_w 386
    //   6742: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6745: return
    //   6746: astore 34
    //   6748: ldc 85
    //   6750: aload 34
    //   6752: ldc_w 480
    //   6755: iconst_0
    //   6756: anewarray 4	java/lang/Object
    //   6759: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   6781: ldc_w 482
    //   6784: iconst_2
    //   6785: anewarray 4	java/lang/Object
    //   6788: dup
    //   6789: iconst_0
    //   6790: lload 4
    //   6792: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6795: aastore
    //   6796: dup
    //   6797: iconst_1
    //   6798: lload_2
    //   6799: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6802: aastore
    //   6803: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6806: aload_0
    //   6807: lload_2
    //   6808: lload 4
    //   6810: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   6832: ldc_w 486
    //   6835: iconst_2
    //   6836: anewarray 4	java/lang/Object
    //   6839: dup
    //   6840: iconst_0
    //   6841: lload 4
    //   6843: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6846: aastore
    //   6847: dup
    //   6848: iconst_1
    //   6849: lload_2
    //   6850: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6853: aastore
    //   6854: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6857: aload_0
    //   6858: lload 4
    //   6860: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   6863: lload_2
    //   6864: ldc2_w 405
    //   6867: lcmp
    //   6868: ifge -180 -> 6688
    //   6871: new 8	com/tencent/mm/plugin/music/c/b$a
    //   6874: dup
    //   6875: aload_0
    //   6876: iconst_1
    //   6877: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   6880: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   6883: goto -195 -> 6688
    //   6886: ldc 85
    //   6888: ldc_w 488
    //   6891: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6894: goto -206 -> 6688
    //   6897: astore 34
    //   6899: ldc 85
    //   6901: aload 34
    //   6903: ldc_w 633
    //   6906: iconst_0
    //   6907: anewarray 4	java/lang/Object
    //   6910: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6913: goto -215 -> 6698
    //   6916: astore 34
    //   6918: ldc 85
    //   6920: aload 34
    //   6922: ldc_w 480
    //   6925: iconst_0
    //   6926: anewarray 4	java/lang/Object
    //   6929: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6932: goto -224 -> 6708
    //   6935: astore 34
    //   6937: ldc 85
    //   6939: aload 34
    //   6941: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6944: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6947: goto -226 -> 6721
    //   6950: astore 38
    //   6952: aconst_null
    //   6953: astore 34
    //   6955: aload 44
    //   6957: astore 39
    //   6959: aload 35
    //   6961: astore 33
    //   6963: aload 33
    //   6965: astore 37
    //   6967: aload 34
    //   6969: astore 36
    //   6971: lload 4
    //   6973: lstore 8
    //   6975: lload_2
    //   6976: lstore 6
    //   6978: aload 39
    //   6980: astore 35
    //   6982: ldc 85
    //   6984: aload 38
    //   6986: ldc_w 621
    //   6989: iconst_1
    //   6990: anewarray 4	java/lang/Object
    //   6993: dup
    //   6994: iconst_0
    //   6995: aload 52
    //   6997: invokevirtual 455	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   7000: invokestatic 461	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   7003: aastore
    //   7004: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7007: aload 33
    //   7009: astore 37
    //   7011: aload 34
    //   7013: astore 36
    //   7015: lload 4
    //   7017: lstore 8
    //   7019: lload_2
    //   7020: lstore 6
    //   7022: aload 39
    //   7024: astore 35
    //   7026: aload_0
    //   7027: sipush 754
    //   7030: putfield 59	com/tencent/mm/plugin/music/c/b:hsf	I
    //   7033: aload 33
    //   7035: astore 37
    //   7037: aload 34
    //   7039: astore 36
    //   7041: lload 4
    //   7043: lstore 8
    //   7045: lload_2
    //   7046: lstore 6
    //   7048: aload 39
    //   7050: astore 35
    //   7052: aload_0
    //   7053: iconst_5
    //   7054: invokespecial 449	com/tencent/mm/plugin/music/c/b:adr	(I)V
    //   7057: lload 4
    //   7059: lconst_0
    //   7060: lcmp
    //   7061: ifne +125 -> 7186
    //   7064: lload_2
    //   7065: lconst_0
    //   7066: lcmp
    //   7067: ifle +119 -> 7186
    //   7070: ldc 85
    //   7072: ldc_w 471
    //   7075: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7078: aload 33
    //   7080: lload_2
    //   7081: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   7084: aload_0
    //   7085: lload_2
    //   7086: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   7089: lload_2
    //   7090: ldc2_w 405
    //   7093: lcmp
    //   7094: ifge +15 -> 7109
    //   7097: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7100: dup
    //   7101: aload_0
    //   7102: iconst_1
    //   7103: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7106: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7109: aload 39
    //   7111: ifnull +8 -> 7119
    //   7114: aload 39
    //   7116: invokevirtual 139	java/io/InputStream:close	()V
    //   7119: aload 33
    //   7121: ifnull +8 -> 7129
    //   7124: aload 33
    //   7126: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   7154: ldc_w 478
    //   7157: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7160: ldc_w 386
    //   7163: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7166: return
    //   7167: astore 35
    //   7169: ldc 85
    //   7171: aload 35
    //   7173: ldc_w 480
    //   7176: iconst_0
    //   7177: anewarray 4	java/lang/Object
    //   7180: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   7202: ldc_w 482
    //   7205: iconst_2
    //   7206: anewarray 4	java/lang/Object
    //   7209: dup
    //   7210: iconst_0
    //   7211: lload 4
    //   7213: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7216: aastore
    //   7217: dup
    //   7218: iconst_1
    //   7219: lload_2
    //   7220: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7223: aastore
    //   7224: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7227: aload_0
    //   7228: lload_2
    //   7229: lload 4
    //   7231: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   7253: ldc_w 486
    //   7256: iconst_2
    //   7257: anewarray 4	java/lang/Object
    //   7260: dup
    //   7261: iconst_0
    //   7262: lload 4
    //   7264: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7267: aastore
    //   7268: dup
    //   7269: iconst_1
    //   7270: lload_2
    //   7271: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7274: aastore
    //   7275: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7278: aload_0
    //   7279: lload 4
    //   7281: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   7284: lload_2
    //   7285: ldc2_w 405
    //   7288: lcmp
    //   7289: ifge -180 -> 7109
    //   7292: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7295: dup
    //   7296: aload_0
    //   7297: iconst_1
    //   7298: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7301: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7304: goto -195 -> 7109
    //   7307: ldc 85
    //   7309: ldc_w 488
    //   7312: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7315: goto -206 -> 7109
    //   7318: astore 35
    //   7320: ldc 85
    //   7322: aload 35
    //   7324: ldc_w 633
    //   7327: iconst_0
    //   7328: anewarray 4	java/lang/Object
    //   7331: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7334: goto -215 -> 7119
    //   7337: astore 33
    //   7339: ldc 85
    //   7341: aload 33
    //   7343: ldc_w 480
    //   7346: iconst_0
    //   7347: anewarray 4	java/lang/Object
    //   7350: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7353: goto -224 -> 7129
    //   7356: astore 33
    //   7358: ldc 85
    //   7360: aload 33
    //   7362: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7365: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   7395: ldc_w 471
    //   7398: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7401: aload 37
    //   7403: lload_2
    //   7404: invokevirtual 564	java/io/RandomAccessFile:setLength	(J)V
    //   7407: aload_0
    //   7408: lload_2
    //   7409: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   7412: lload_2
    //   7413: ldc2_w 405
    //   7416: lcmp
    //   7417: ifge +15 -> 7432
    //   7420: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7423: dup
    //   7424: aload_0
    //   7425: iconst_1
    //   7426: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7429: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7432: aload 35
    //   7434: ifnull +8 -> 7442
    //   7437: aload 35
    //   7439: invokevirtual 139	java/io/InputStream:close	()V
    //   7442: aload 37
    //   7444: ifnull +8 -> 7452
    //   7447: aload 37
    //   7449: invokevirtual 565	java/io/RandomAccessFile:close	()V
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
    //   7477: ldc_w 478
    //   7480: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7483: ldc_w 386
    //   7486: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7489: aload 33
    //   7491: athrow
    //   7492: astore 34
    //   7494: ldc 85
    //   7496: aload 34
    //   7498: ldc_w 480
    //   7501: iconst_0
    //   7502: anewarray 4	java/lang/Object
    //   7505: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   7527: ldc_w 482
    //   7530: iconst_2
    //   7531: anewarray 4	java/lang/Object
    //   7534: dup
    //   7535: iconst_0
    //   7536: lload 4
    //   7538: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7541: aastore
    //   7542: dup
    //   7543: iconst_1
    //   7544: lload_2
    //   7545: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7548: aastore
    //   7549: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7552: aload_0
    //   7553: lload_2
    //   7554: lload 4
    //   7556: invokespecial 484	com/tencent/mm/plugin/music/c/b:aT	(JJ)V
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
    //   7578: ldc_w 486
    //   7581: iconst_2
    //   7582: anewarray 4	java/lang/Object
    //   7585: dup
    //   7586: iconst_0
    //   7587: lload 4
    //   7589: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7592: aastore
    //   7593: dup
    //   7594: iconst_1
    //   7595: lload_2
    //   7596: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7599: aastore
    //   7600: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7603: aload_0
    //   7604: lload 4
    //   7606: invokespecial 476	com/tencent/mm/plugin/music/c/b:sB	(J)V
    //   7609: lload_2
    //   7610: ldc2_w 405
    //   7613: lcmp
    //   7614: ifge -182 -> 7432
    //   7617: new 8	com/tencent/mm/plugin/music/c/b$a
    //   7620: dup
    //   7621: aload_0
    //   7622: iconst_1
    //   7623: invokespecial 353	com/tencent/mm/plugin/music/c/b$a:<init>	(Lcom/tencent/mm/plugin/music/c/b;I)V
    //   7626: invokestatic 359	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   7629: goto -197 -> 7432
    //   7632: ldc 85
    //   7634: ldc_w 488
    //   7637: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7640: goto -208 -> 7432
    //   7643: astore 34
    //   7645: ldc 85
    //   7647: aload 34
    //   7649: ldc_w 633
    //   7652: iconst_0
    //   7653: anewarray 4	java/lang/Object
    //   7656: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7659: goto -217 -> 7442
    //   7662: astore 34
    //   7664: ldc 85
    //   7666: aload 34
    //   7668: ldc_w 480
    //   7671: iconst_0
    //   7672: anewarray 4	java/lang/Object
    //   7675: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7678: goto -226 -> 7452
    //   7681: astore 34
    //   7683: ldc 85
    //   7685: aload 34
    //   7687: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7690: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7693: goto -228 -> 7465
    //   7696: astore 33
    //   7698: lload 8
    //   7700: lstore 4
    //   7702: lload 6
    //   7704: lstore_2
    //   7705: goto -325 -> 7380
    //   7708: astore 33
    //   7710: aload 39
    //   7712: astore 35
    //   7714: lload 20
    //   7716: lstore 4
    //   7718: lload 8
    //   7720: lstore_2
    //   7721: goto -341 -> 7380
    //   7724: astore 38
    //   7726: lload 20
    //   7728: lstore 4
    //   7730: lload 12
    //   7732: lstore_2
    //   7733: aload 44
    //   7735: astore 39
    //   7737: goto -774 -> 6963
    //   7740: astore 38
    //   7742: lload 10
    //   7744: lstore_2
    //   7745: aload 35
    //   7747: astore 39
    //   7749: goto -786 -> 6963
    //   7752: astore 40
    //   7754: aload 33
    //   7756: astore 38
    //   7758: aload 34
    //   7760: astore 33
    //   7762: lload 22
    //   7764: lstore 4
    //   7766: lload 10
    //   7768: lstore_2
    //   7769: aload 41
    //   7771: astore 39
    //   7773: goto -1231 -> 6542
    //   7776: astore 40
    //   7778: aload 33
    //   7780: astore 38
    //   7782: aload 34
    //   7784: astore 33
    //   7786: lload 12
    //   7788: lstore_2
    //   7789: aload 35
    //   7791: astore 39
    //   7793: goto -1251 -> 6542
    //   7796: astore 38
    //   7798: lload 24
    //   7800: lstore 4
    //   7802: lload 14
    //   7804: lstore_2
    //   7805: aload 43
    //   7807: astore 39
    //   7809: goto -1688 -> 6121
    //   7812: astore 38
    //   7814: lload 14
    //   7816: lstore_2
    //   7817: aload 35
    //   7819: astore 39
    //   7821: goto -1700 -> 6121
    //   7824: astore 38
    //   7826: aconst_null
    //   7827: astore 34
    //   7829: aload 39
    //   7831: astore 33
    //   7833: aload 42
    //   7835: astore 39
    //   7837: goto -2793 -> 5044
    //   7840: astore 38
    //   7842: lload 26
    //   7844: lstore 4
    //   7846: lload 18
    //   7848: lstore_2
    //   7849: aload 42
    //   7851: astore 39
    //   7853: goto -2809 -> 5044
    //   7856: astore 38
    //   7858: aconst_null
    //   7859: astore 35
    //   7861: aconst_null
    //   7862: astore 34
    //   7864: aload 36
    //   7866: astore 33
    //   7868: goto -3635 -> 4233
    //   7871: lload 30
    //   7873: lstore 6
    //   7875: lload 4
    //   7877: lstore_2
    //   7878: lload 6
    //   7880: lstore 4
    //   7882: ldc2_w 634
    //   7885: lstore 30
    //   7887: lload 4
    //   7889: lconst_0
    //   7890: lcmp
    //   7891: ifeq -4400 -> 3491
    //   7894: lload 4
    //   7896: lstore 30
    //   7898: goto -4407 -> 3491
    //   7901: astore 38
    //   7903: aconst_null
    //   7904: astore 35
    //   7906: lload 28
    //   7908: lstore 4
    //   7910: lload 16
    //   7912: lstore_2
    //   7913: goto -3680 -> 4233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7916	0	this	b
    //   176	5118	1	i	int
    //   163	7750	2	l1	long
    //   130	7779	4	l2	long
    //   121	7758	6	l3	long
    //   231	7488	8	l4	long
    //   1761	6006	10	l5	long
    //   1754	6033	12	l6	long
    //   1768	6047	14	l7	long
    //   1782	6129	16	l8	long
    //   1775	6072	18	l9	long
    //   1751	5976	20	l10	long
    //   1758	6005	22	l11	long
    //   1765	6034	24	l12	long
    //   1772	6071	26	l13	long
    //   1779	6128	28	l14	long
    //   3328	4569	30	l15	long
    //   32	1523	32	bool	boolean
    //   24	534	33	localObject1	Object
    //   811	5	33	localIOException1	java.io.IOException
    //   916	111	33	localObject2	Object
    //   1130	152	33	localIOException2	java.io.IOException
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
    //   6532	593	33	localObject4	Object
    //   7337	5	33	localIOException9	java.io.IOException
    //   7356	5	33	localException7	Exception
    //   7371	119	33	localObject5	Object
    //   7696	1	33	localObject6	Object
    //   7708	47	33	localObject7	Object
    //   7760	107	33	localObject8	Object
    //   21	6518	34	localObject9	Object
    //   6746	5	34	localIOException10	java.io.IOException
    //   6897	5	34	localIOException11	java.io.IOException
    //   6916	5	34	localIOException12	java.io.IOException
    //   6935	5	34	localException8	Exception
    //   6953	190	34	localObject10	Object
    //   7492	5	34	localIOException13	java.io.IOException
    //   7643	5	34	localIOException14	java.io.IOException
    //   7662	5	34	localIOException15	java.io.IOException
    //   7681	102	34	localException9	Exception
    //   7827	36	34	localObject11	Object
    //   50	1962	35	localObject12	Object
    //   2153	5	35	localIOException16	java.io.IOException
    //   2355	2243	35	localObject13	Object
    //   4740	298	35	localIOException17	java.io.IOException
    //   5061	379	35	localObject14	Object
    //   5643	5	35	localIOException18	java.io.IOException
    //   5847	5	35	localIOException19	java.io.IOException
    //   5900	5	35	localIOException20	java.io.IOException
    //   6051	5	35	localIOException21	java.io.IOException
    //   6104	14	35	localUnknownServiceException1	java.net.UnknownServiceException
    //   6138	71	35	localObject15	Object
    //   6325	5	35	localIOException22	java.io.IOException
    //   6476	5	35	localIOException23	java.io.IOException
    //   6559	492	35	localObject16	Object
    //   7167	5	35	localIOException24	java.io.IOException
    //   7318	5	35	localIOException25	java.io.IOException
    //   7378	527	35	localObject17	Object
    //   940	4403	36	localObject18	Object
    //   5492	5	36	localIOException26	java.io.IOException
    //   5696	5	36	localIOException27	java.io.IOException
    //   6127	1738	36	localObject19	Object
    //   932	6516	37	localObject20	Object
    //   920	3013	38	localObject21	Object
    //   4228	27	38	localProtocolException1	java.net.ProtocolException
    //   5035	1079	38	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   6119	585	38	localObject22	Object
    //   6950	35	38	localException10	Exception
    //   7724	1	38	localException11	Exception
    //   7740	1	38	localException12	Exception
    //   7756	25	38	localObject23	Object
    //   7796	1	38	localUnknownServiceException2	java.net.UnknownServiceException
    //   7812	1	38	localUnknownServiceException3	java.net.UnknownServiceException
    //   7824	1	38	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   7840	1	38	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   7856	1	38	localProtocolException2	java.net.ProtocolException
    //   7901	1	38	localProtocolException3	java.net.ProtocolException
    //   936	6916	39	localObject24	Object
    //   179	1548	40	localObject25	Object
    //   6529	35	40	localIOException28	java.io.IOException
    //   7752	1	40	localIOException29	java.io.IOException
    //   7776	1	40	localIOException30	java.io.IOException
    //   886	6884	41	localObject26	Object
    //   898	6952	42	localObject27	Object
    //   883	6923	43	localObject28	Object
    //   889	6845	44	localObject29	Object
    //   895	3701	45	localObject30	Object
    //   892	6485	46	localObject31	Object
    //   904	816	47	localHashMap	java.util.HashMap
    //   913	389	48	localObject32	Object
    //   910	388	49	localObject33	Object
    //   907	387	50	localObject34	Object
    //   901	385	51	localObject35	Object
    //   228	6768	52	localu	com.tencent.mm.vfs.u
    // Exception table:
    //   from	to	target	type
    //   244	267	811	java/io/IOException
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
    //   3802	3809	7708	finally
    //   3843	3850	7708	finally
    //   3884	3892	7708	finally
    //   3930	3939	7708	finally
    //   3985	4013	7708	finally
    //   4053	4060	7708	finally
    //   4100	4109	7708	finally
    //   4149	4158	7708	finally
    //   4210	4222	7708	finally
    //   4252	4277	7708	finally
    //   4296	4303	7708	finally
    //   4322	4327	7708	finally
    //   4974	4983	7708	finally
    //   5023	5032	7708	finally
    //   5282	5326	7708	finally
    //   5360	5382	7708	finally
    //   1784	1790	7724	java/lang/Exception
    //   1858	1862	7724	java/lang/Exception
    //   1916	1935	7724	java/lang/Exception
    //   1989	1994	7724	java/lang/Exception
    //   2048	2053	7724	java/lang/Exception
    //   2392	2411	7724	java/lang/Exception
    //   2465	2494	7724	java/lang/Exception
    //   2548	2555	7724	java/lang/Exception
    //   2609	2626	7724	java/lang/Exception
    //   2680	2686	7724	java/lang/Exception
    //   2740	2750	7724	java/lang/Exception
    //   2804	2817	7724	java/lang/Exception
    //   2871	2882	7724	java/lang/Exception
    //   2936	2945	7724	java/lang/Exception
    //   2999	3005	7724	java/lang/Exception
    //   3059	3065	7724	java/lang/Exception
    //   3119	3137	7724	java/lang/Exception
    //   3191	3201	7724	java/lang/Exception
    //   3255	3262	7724	java/lang/Exception
    //   3316	3330	7724	java/lang/Exception
    //   3384	3409	7724	java/lang/Exception
    //   3468	3476	7724	java/lang/Exception
    //   3545	3582	7724	java/lang/Exception
    //   3636	3643	7724	java/lang/Exception
    //   3697	3703	7724	java/lang/Exception
    //   3757	3764	7724	java/lang/Exception
    //   4491	4500	7724	java/lang/Exception
    //   4572	4580	7724	java/lang/Exception
    //   4634	4640	7724	java/lang/Exception
    //   3802	3809	7740	java/lang/Exception
    //   3843	3850	7740	java/lang/Exception
    //   3884	3892	7740	java/lang/Exception
    //   3930	3939	7740	java/lang/Exception
    //   3985	4013	7740	java/lang/Exception
    //   4053	4060	7740	java/lang/Exception
    //   4100	4109	7740	java/lang/Exception
    //   4149	4158	7740	java/lang/Exception
    //   4210	4222	7740	java/lang/Exception
    //   4974	4983	7740	java/lang/Exception
    //   5023	5032	7740	java/lang/Exception
    //   5282	5326	7740	java/lang/Exception
    //   5360	5382	7740	java/lang/Exception
    //   1784	1790	7752	java/io/IOException
    //   1858	1862	7752	java/io/IOException
    //   1916	1935	7752	java/io/IOException
    //   1989	1994	7752	java/io/IOException
    //   2048	2053	7752	java/io/IOException
    //   2392	2411	7752	java/io/IOException
    //   2465	2494	7752	java/io/IOException
    //   2548	2555	7752	java/io/IOException
    //   2609	2626	7752	java/io/IOException
    //   2680	2686	7752	java/io/IOException
    //   2740	2750	7752	java/io/IOException
    //   2804	2817	7752	java/io/IOException
    //   2871	2882	7752	java/io/IOException
    //   2936	2945	7752	java/io/IOException
    //   2999	3005	7752	java/io/IOException
    //   3059	3065	7752	java/io/IOException
    //   3119	3137	7752	java/io/IOException
    //   3191	3201	7752	java/io/IOException
    //   3255	3262	7752	java/io/IOException
    //   3316	3330	7752	java/io/IOException
    //   3384	3409	7752	java/io/IOException
    //   3468	3476	7752	java/io/IOException
    //   3545	3582	7752	java/io/IOException
    //   3636	3643	7752	java/io/IOException
    //   3697	3703	7752	java/io/IOException
    //   3757	3764	7752	java/io/IOException
    //   4491	4500	7752	java/io/IOException
    //   4572	4580	7752	java/io/IOException
    //   4634	4640	7752	java/io/IOException
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
    //   1784	1790	7796	java/net/UnknownServiceException
    //   1858	1862	7796	java/net/UnknownServiceException
    //   1916	1935	7796	java/net/UnknownServiceException
    //   1989	1994	7796	java/net/UnknownServiceException
    //   2048	2053	7796	java/net/UnknownServiceException
    //   2392	2411	7796	java/net/UnknownServiceException
    //   2465	2494	7796	java/net/UnknownServiceException
    //   2548	2555	7796	java/net/UnknownServiceException
    //   2609	2626	7796	java/net/UnknownServiceException
    //   2680	2686	7796	java/net/UnknownServiceException
    //   2740	2750	7796	java/net/UnknownServiceException
    //   2804	2817	7796	java/net/UnknownServiceException
    //   2871	2882	7796	java/net/UnknownServiceException
    //   2936	2945	7796	java/net/UnknownServiceException
    //   2999	3005	7796	java/net/UnknownServiceException
    //   3059	3065	7796	java/net/UnknownServiceException
    //   3119	3137	7796	java/net/UnknownServiceException
    //   3191	3201	7796	java/net/UnknownServiceException
    //   3255	3262	7796	java/net/UnknownServiceException
    //   3316	3330	7796	java/net/UnknownServiceException
    //   3384	3409	7796	java/net/UnknownServiceException
    //   3468	3476	7796	java/net/UnknownServiceException
    //   3545	3582	7796	java/net/UnknownServiceException
    //   3636	3643	7796	java/net/UnknownServiceException
    //   3697	3703	7796	java/net/UnknownServiceException
    //   3757	3764	7796	java/net/UnknownServiceException
    //   4491	4500	7796	java/net/UnknownServiceException
    //   4572	4580	7796	java/net/UnknownServiceException
    //   4634	4640	7796	java/net/UnknownServiceException
    //   3802	3809	7812	java/net/UnknownServiceException
    //   3843	3850	7812	java/net/UnknownServiceException
    //   3884	3892	7812	java/net/UnknownServiceException
    //   3930	3939	7812	java/net/UnknownServiceException
    //   3985	4013	7812	java/net/UnknownServiceException
    //   4053	4060	7812	java/net/UnknownServiceException
    //   4100	4109	7812	java/net/UnknownServiceException
    //   4149	4158	7812	java/net/UnknownServiceException
    //   4210	4222	7812	java/net/UnknownServiceException
    //   4974	4983	7812	java/net/UnknownServiceException
    //   5023	5032	7812	java/net/UnknownServiceException
    //   5282	5326	7812	java/net/UnknownServiceException
    //   5360	5382	7812	java/net/UnknownServiceException
    //   942	950	7824	java/net/NoRouteToHostException
    //   974	979	7824	java/net/NoRouteToHostException
    //   1003	1026	7824	java/net/NoRouteToHostException
    //   1050	1056	7824	java/net/NoRouteToHostException
    //   1305	1319	7824	java/net/NoRouteToHostException
    //   1343	1360	7824	java/net/NoRouteToHostException
    //   1384	1395	7824	java/net/NoRouteToHostException
    //   1419	1433	7824	java/net/NoRouteToHostException
    //   1464	1491	7824	java/net/NoRouteToHostException
    //   1515	1554	7824	java/net/NoRouteToHostException
    //   1583	1591	7824	java/net/NoRouteToHostException
    //   1615	1623	7824	java/net/NoRouteToHostException
    //   1647	1692	7824	java/net/NoRouteToHostException
    //   1716	1726	7824	java/net/NoRouteToHostException
    //   1784	1790	7840	java/net/NoRouteToHostException
    //   1858	1862	7840	java/net/NoRouteToHostException
    //   1916	1935	7840	java/net/NoRouteToHostException
    //   1989	1994	7840	java/net/NoRouteToHostException
    //   2048	2053	7840	java/net/NoRouteToHostException
    //   2392	2411	7840	java/net/NoRouteToHostException
    //   2465	2494	7840	java/net/NoRouteToHostException
    //   2548	2555	7840	java/net/NoRouteToHostException
    //   2609	2626	7840	java/net/NoRouteToHostException
    //   2680	2686	7840	java/net/NoRouteToHostException
    //   2740	2750	7840	java/net/NoRouteToHostException
    //   2804	2817	7840	java/net/NoRouteToHostException
    //   2871	2882	7840	java/net/NoRouteToHostException
    //   2936	2945	7840	java/net/NoRouteToHostException
    //   2999	3005	7840	java/net/NoRouteToHostException
    //   3059	3065	7840	java/net/NoRouteToHostException
    //   3119	3137	7840	java/net/NoRouteToHostException
    //   3191	3201	7840	java/net/NoRouteToHostException
    //   3255	3262	7840	java/net/NoRouteToHostException
    //   3316	3330	7840	java/net/NoRouteToHostException
    //   3384	3409	7840	java/net/NoRouteToHostException
    //   3468	3476	7840	java/net/NoRouteToHostException
    //   3545	3582	7840	java/net/NoRouteToHostException
    //   3636	3643	7840	java/net/NoRouteToHostException
    //   3697	3703	7840	java/net/NoRouteToHostException
    //   3757	3764	7840	java/net/NoRouteToHostException
    //   4491	4500	7840	java/net/NoRouteToHostException
    //   4572	4580	7840	java/net/NoRouteToHostException
    //   4634	4640	7840	java/net/NoRouteToHostException
    //   942	950	7856	java/net/ProtocolException
    //   974	979	7856	java/net/ProtocolException
    //   1003	1026	7856	java/net/ProtocolException
    //   1050	1056	7856	java/net/ProtocolException
    //   1305	1319	7856	java/net/ProtocolException
    //   1343	1360	7856	java/net/ProtocolException
    //   1384	1395	7856	java/net/ProtocolException
    //   1419	1433	7856	java/net/ProtocolException
    //   1464	1491	7856	java/net/ProtocolException
    //   1515	1554	7856	java/net/ProtocolException
    //   1583	1591	7856	java/net/ProtocolException
    //   1615	1623	7856	java/net/ProtocolException
    //   1647	1692	7856	java/net/ProtocolException
    //   1716	1726	7856	java/net/ProtocolException
    //   1784	1790	7901	java/net/ProtocolException
    //   1858	1862	7901	java/net/ProtocolException
    //   1916	1935	7901	java/net/ProtocolException
    //   1989	1994	7901	java/net/ProtocolException
    //   2048	2053	7901	java/net/ProtocolException
    //   2392	2411	7901	java/net/ProtocolException
    //   2465	2494	7901	java/net/ProtocolException
    //   2548	2555	7901	java/net/ProtocolException
    //   2609	2626	7901	java/net/ProtocolException
    //   2680	2686	7901	java/net/ProtocolException
    //   2740	2750	7901	java/net/ProtocolException
    //   2804	2817	7901	java/net/ProtocolException
    //   2871	2882	7901	java/net/ProtocolException
    //   2936	2945	7901	java/net/ProtocolException
    //   2999	3005	7901	java/net/ProtocolException
    //   3059	3065	7901	java/net/ProtocolException
    //   3119	3137	7901	java/net/ProtocolException
    //   3191	3201	7901	java/net/ProtocolException
    //   3255	3262	7901	java/net/ProtocolException
    //   3316	3330	7901	java/net/ProtocolException
    //   3384	3409	7901	java/net/ProtocolException
    //   3468	3476	7901	java/net/ProtocolException
    //   3545	3582	7901	java/net/ProtocolException
    //   3636	3643	7901	java/net/ProtocolException
    //   3697	3703	7901	java/net/ProtocolException
    //   3757	3764	7901	java/net/ProtocolException
    //   4491	4500	7901	java/net/ProtocolException
    //   4572	4580	7901	java/net/ProtocolException
    //   4634	4640	7901	java/net/ProtocolException
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
      if (b.this.LKY != null) {
        b.this.LKY.ads(this.action);
      }
      AppMethodBeat.o(137215);
    }
  }
  
  public static abstract interface b
  {
    public abstract void ads(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b
 * JD-Core Version:    0.7.0.1
 */