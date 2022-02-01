package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.media.d.f;
import com.tencent.mm.media.i.e.c;
import com.tencent.mm.media.i.e.d;
import com.tencent.mm.media.i.e.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.n.n;
import d.v;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Z)V", "canPlaying", "didCheckCrop", "lastSurfaceUpdatedTime", "", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "prepareLock", "Ljava/lang/Object;", "seekLock", "seekTime", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoIsPrepared", "checkCropRect", "", "enableMute", "isMirror", "isOES", "isPlaying", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "release", "resume", "start", "stop", "Companion", "plugin-vlog_release"})
public final class l
  extends b
{
  public static final a BJc;
  private long BIW;
  private final Object BIX;
  private final Object BIY;
  private volatile boolean BIZ;
  private volatile boolean BJa;
  private boolean BJb;
  private long lsQ;
  private com.tencent.mm.plugin.o.j pUJ;
  private com.tencent.mm.plugin.o.d pUT;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(111004);
    BJc = new a((byte)0);
    AppMethodBeat.o(111004);
  }
  
  public l(int paramInt1, int paramInt2, int paramInt3, ab paramab, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, (com.tencent.mm.plugin.vlog.model.l)paramab, paramBoolean);
    AppMethodBeat.i(111003);
    this.BIX = new Object();
    this.BIY = new Object();
    this.pUT = ((com.tencent.mm.plugin.o.d)new c(this));
    AppMethodBeat.o(111003);
  }
  
  private boolean start()
  {
    boolean bool = false;
    AppMethodBeat.i(110994);
    if ((this.pUJ != null) && (this.BJa))
    {
      Object localObject = "%d player start surface[%b], seekTime:" + this.BIW;
      i = hashCode();
      if (this.surface != null) {
        bool = true;
      }
      ad.i("MicroMsg.VLogVideoPlayer", (String)localObject, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = this.pUJ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.o.j)localObject).start();
      }
      AppMethodBeat.o(110994);
      return true;
    }
    int i = hashCode();
    if (this.pUJ == null) {}
    for (bool = true;; bool = false)
    {
      ad.w("MicroMsg.VLogVideoPlayer", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Boolean.valueOf(this.BJa) });
      AppMethodBeat.o(110994);
      return false;
    }
  }
  
  /* Error */
  public final void Bm(long paramLong)
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 199	com/tencent/mm/plugin/vlog/player/b:BHY	Z
    //   9: ifeq +16 -> 25
    //   12: ldc 166
    //   14: ldc 201
    //   16: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 196
    //   21: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 199	com/tencent/mm/plugin/vlog/player/b:BHY	Z
    //   30: invokestatic 210	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   33: lstore 4
    //   35: ldc 166
    //   37: new 143	java/lang/StringBuilder
    //   40: dup
    //   41: ldc 212
    //   43: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 216	com/tencent/mm/plugin/vlog/player/b:BHZ	I
    //   50: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 221
    //   55: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: lload_1
    //   59: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 226
    //   64: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 229	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   71: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: iconst_2
    //   78: anewarray 113	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   87: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_0
    //   94: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   97: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_0
    //   105: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   108: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   111: invokestatic 241	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   114: ifne +16 -> 130
    //   117: aload_0
    //   118: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   121: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   124: invokestatic 246	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   127: ifne +30 -> 157
    //   130: ldc 166
    //   132: ldc 248
    //   134: iconst_1
    //   135: anewarray 113	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   144: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: ldc 196
    //   153: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: ldc 166
    //   159: ldc 250
    //   161: iconst_2
    //   162: anewarray 113	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_0
    //   168: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   171: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_0
    //   178: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   181: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_0
    //   189: getfield 252	com/tencent/mm/plugin/vlog/player/l:BJb	Z
    //   192: ifne +128 -> 320
    //   195: ldc 166
    //   197: new 143	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   204: aload_0
    //   205: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   208: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: bipush 32
    //   213: invokevirtual 256	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   220: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   223: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 258
    //   229: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: getfield 261	com/tencent/mm/plugin/vlog/player/b:width	I
    //   236: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: ldc_w 263
    //   242: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_0
    //   246: getfield 266	com/tencent/mm/plugin/vlog/player/b:height	I
    //   249: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 261	com/tencent/mm/plugin/vlog/player/b:width	I
    //   262: ifeq +10 -> 272
    //   265: aload_0
    //   266: getfield 266	com/tencent/mm/plugin/vlog/player/b:height	I
    //   269: ifne +375 -> 644
    //   272: ldc 166
    //   274: new 143	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   281: aload_0
    //   282: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   285: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: bipush 32
    //   290: invokevirtual 256	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   297: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   300: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 268
    //   306: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_0
    //   316: iconst_0
    //   317: putfield 252	com/tencent/mm/plugin/vlog/player/l:BJb	Z
    //   320: aload_0
    //   321: new 270	android/graphics/SurfaceTexture
    //   324: dup
    //   325: aload_0
    //   326: getfield 216	com/tencent/mm/plugin/vlog/player/b:BHZ	I
    //   329: invokespecial 272	android/graphics/SurfaceTexture:<init>	(I)V
    //   332: putfield 274	com/tencent/mm/plugin/vlog/player/l:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   335: aload_0
    //   336: new 276	android/view/Surface
    //   339: dup
    //   340: aload_0
    //   341: getfield 274	com/tencent/mm/plugin/vlog/player/l:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   344: invokespecial 279	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   347: putfield 164	com/tencent/mm/plugin/vlog/player/l:surface	Landroid/view/Surface;
    //   350: aload_0
    //   351: iconst_0
    //   352: putfield 132	com/tencent/mm/plugin/vlog/player/l:BJa	Z
    //   355: aload_0
    //   356: new 184	com/tencent/mm/plugin/o/j
    //   359: dup
    //   360: invokestatic 285	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   363: invokespecial 288	com/tencent/mm/plugin/o/j:<init>	(Landroid/os/Looper;)V
    //   366: putfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   369: aload_0
    //   370: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   373: astore 6
    //   375: aload 6
    //   377: ifnull +15 -> 392
    //   380: aload 6
    //   382: aload_0
    //   383: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   386: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   389: invokevirtual 291	com/tencent/mm/plugin/o/j:setPath	(Ljava/lang/String;)V
    //   392: aload_0
    //   393: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   396: astore 6
    //   398: aload 6
    //   400: ifnull +12 -> 412
    //   403: aload 6
    //   405: aload_0
    //   406: getfield 126	com/tencent/mm/plugin/vlog/player/l:pUT	Lcom/tencent/mm/plugin/o/d;
    //   409: invokevirtual 294	com/tencent/mm/plugin/o/j:a	(Lcom/tencent/mm/plugin/o/d;)V
    //   412: aload_0
    //   413: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   416: astore 6
    //   418: aload 6
    //   420: ifnull +12 -> 432
    //   423: aload 6
    //   425: aload_0
    //   426: getfield 164	com/tencent/mm/plugin/vlog/player/l:surface	Landroid/view/Surface;
    //   429: invokevirtual 298	com/tencent/mm/plugin/o/j:setSurface	(Landroid/view/Surface;)V
    //   432: aload_0
    //   433: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   436: astore 6
    //   438: aload 6
    //   440: ifnull +12 -> 452
    //   443: aload 6
    //   445: aload_0
    //   446: getfield 301	com/tencent/mm/plugin/vlog/player/b:hvp	Z
    //   449: invokevirtual 305	com/tencent/mm/plugin/o/j:setMute	(Z)V
    //   452: aload_0
    //   453: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   456: astore 6
    //   458: aload 6
    //   460: ifnull +9 -> 469
    //   463: aload 6
    //   465: iconst_0
    //   466: invokevirtual 308	com/tencent/mm/plugin/o/j:setNeedResetExtractor	(Z)V
    //   469: aload_0
    //   470: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   473: astore 6
    //   475: aload 6
    //   477: ifnull +9 -> 486
    //   480: aload 6
    //   482: iconst_0
    //   483: invokevirtual 311	com/tencent/mm/plugin/o/j:setIsOnlineVideoType	(Z)V
    //   486: aload_0
    //   487: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   490: astore 6
    //   492: aload 6
    //   494: ifnull +9 -> 503
    //   497: aload 6
    //   499: invokevirtual 314	com/tencent/mm/plugin/o/j:cQr	()Z
    //   502: pop
    //   503: aload_0
    //   504: lload_1
    //   505: putfield 150	com/tencent/mm/plugin/vlog/player/l:BIW	J
    //   508: ldc 166
    //   510: new 143	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   517: aload_0
    //   518: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   521: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: ldc_w 316
    //   527: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload_0
    //   537: getfield 117	com/tencent/mm/plugin/vlog/player/l:BIX	Ljava/lang/Object;
    //   540: astore 6
    //   542: aload 6
    //   544: monitorenter
    //   545: aload_0
    //   546: getfield 117	com/tencent/mm/plugin/vlog/player/l:BIX	Ljava/lang/Object;
    //   549: invokevirtual 319	java/lang/Object:wait	()V
    //   552: getstatic 325	d/z:MKo	Ld/z;
    //   555: astore 7
    //   557: aload 6
    //   559: monitorexit
    //   560: aload_0
    //   561: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   564: astore 6
    //   566: aload 6
    //   568: ifnonnull +432 -> 1000
    //   571: new 327	d/v
    //   574: dup
    //   575: ldc_w 329
    //   578: invokespecial 330	d/v:<init>	(Ljava/lang/String;)V
    //   581: astore 6
    //   583: ldc 196
    //   585: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aload 6
    //   590: athrow
    //   591: astore 6
    //   593: ldc 166
    //   595: aload 6
    //   597: checkcast 332	java/lang/Throwable
    //   600: new 143	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   607: aload_0
    //   608: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   611: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   614: ldc_w 334
    //   617: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: iconst_1
    //   624: anewarray 113	java/lang/Object
    //   627: dup
    //   628: iconst_0
    //   629: aload 6
    //   631: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   634: aastore
    //   635: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   638: ldc 196
    //   640: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: return
    //   644: aload_0
    //   645: getfield 261	com/tencent/mm/plugin/vlog/player/b:width	I
    //   648: bipush 16
    //   650: irem
    //   651: ifne +13 -> 664
    //   654: aload_0
    //   655: getfield 266	com/tencent/mm/plugin/vlog/player/b:height	I
    //   658: bipush 16
    //   660: irem
    //   661: ifeq +271 -> 932
    //   664: getstatic 347	com/tencent/mm/plugin/vlog/player/e:BIv	Lcom/tencent/mm/plugin/vlog/player/e;
    //   667: astore 6
    //   669: aload_0
    //   670: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   673: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   676: invokestatic 351	com/tencent/mm/plugin/vlog/player/e:aDs	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   679: astore 6
    //   681: aload 6
    //   683: ifnull +257 -> 940
    //   686: aload 6
    //   688: getfield 356	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   691: iflt +249 -> 940
    //   694: aload 6
    //   696: getfield 359	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   699: iflt +241 -> 940
    //   702: aload_0
    //   703: getfield 362	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   706: iflt +234 -> 940
    //   709: aload 6
    //   711: getfield 365	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   714: iflt +226 -> 940
    //   717: ldc 166
    //   719: ldc_w 367
    //   722: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   725: aload_0
    //   726: aload 6
    //   728: getfield 368	com/tencent/mm/plugin/vlog/player/a:dGc	I
    //   731: putfield 229	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   734: aload_0
    //   735: aload 6
    //   737: getfield 369	com/tencent/mm/plugin/vlog/player/a:width	I
    //   740: putfield 261	com/tencent/mm/plugin/vlog/player/b:width	I
    //   743: aload_0
    //   744: aload 6
    //   746: getfield 370	com/tencent/mm/plugin/vlog/player/a:height	I
    //   749: putfield 266	com/tencent/mm/plugin/vlog/player/b:height	I
    //   752: aload_0
    //   753: aload 6
    //   755: getfield 356	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   758: putfield 371	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   761: aload_0
    //   762: aload 6
    //   764: getfield 359	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   767: putfield 372	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   770: aload_0
    //   771: aload 6
    //   773: getfield 373	com/tencent/mm/plugin/vlog/player/a:cropRight	I
    //   776: putfield 362	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   779: aload_0
    //   780: aload 6
    //   782: getfield 365	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   785: putfield 374	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   788: ldc 166
    //   790: new 143	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   797: aload_0
    //   798: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   801: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   804: bipush 32
    //   806: invokevirtual 256	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   809: aload_0
    //   810: getfield 233	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   813: getfield 237	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   816: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 376
    //   822: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload_0
    //   826: getfield 371	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   829: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: ldc_w 378
    //   835: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload_0
    //   839: getfield 372	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   842: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   845: ldc_w 378
    //   848: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: aload_0
    //   852: getfield 362	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   855: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   858: ldc_w 378
    //   861: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload_0
    //   865: getfield 374	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   868: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   871: ldc_w 380
    //   874: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload_0
    //   878: getfield 261	com/tencent/mm/plugin/vlog/player/b:width	I
    //   881: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: ldc_w 382
    //   887: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_0
    //   891: getfield 266	com/tencent/mm/plugin/vlog/player/b:height	I
    //   894: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   897: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: iconst_1
    //   904: istore_3
    //   905: iload_3
    //   906: ifne -586 -> 320
    //   909: getstatic 388	com/tencent/e/h:LTJ	Lcom/tencent/e/i;
    //   912: new 9	com/tencent/mm/plugin/vlog/player/l$b
    //   915: dup
    //   916: aload_0
    //   917: invokespecial 389	com/tencent/mm/plugin/vlog/player/l$b:<init>	(Lcom/tencent/mm/plugin/vlog/player/l;)V
    //   920: checkcast 391	java/lang/Runnable
    //   923: ldc_w 393
    //   926: invokeinterface 399 3 0
    //   931: pop
    //   932: aload_0
    //   933: iconst_1
    //   934: putfield 252	com/tencent/mm/plugin/vlog/player/l:BJb	Z
    //   937: goto -617 -> 320
    //   940: iconst_0
    //   941: istore_3
    //   942: goto -37 -> 905
    //   945: astore 7
    //   947: ldc 166
    //   949: aload 7
    //   951: checkcast 332	java/lang/Throwable
    //   954: new 143	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   961: aload_0
    //   962: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   965: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   968: ldc_w 401
    //   971: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: iconst_0
    //   978: anewarray 113	java/lang/Object
    //   981: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   984: goto -432 -> 552
    //   987: astore 7
    //   989: aload 6
    //   991: monitorexit
    //   992: ldc 196
    //   994: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   997: aload 7
    //   999: athrow
    //   1000: aload 6
    //   1002: checkcast 403	com/tencent/mm/plugin/vlog/model/ab
    //   1005: getfield 406	com/tencent/mm/plugin/vlog/model/ab:BGQ	J
    //   1008: lload_1
    //   1009: ladd
    //   1010: l2i
    //   1011: istore_3
    //   1012: iload_3
    //   1013: ifle +210 -> 1223
    //   1016: aload_0
    //   1017: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   1020: astore 6
    //   1022: aload 6
    //   1024: ifnull +9 -> 1033
    //   1027: aload 6
    //   1029: iload_3
    //   1030: invokevirtual 409	com/tencent/mm/plugin/o/j:seek	(I)V
    //   1033: aload_0
    //   1034: getfield 119	com/tencent/mm/plugin/vlog/player/l:BIY	Ljava/lang/Object;
    //   1037: astore 6
    //   1039: aload 6
    //   1041: monitorenter
    //   1042: ldc 166
    //   1044: new 143	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   1051: aload_0
    //   1052: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1055: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: ldc_w 411
    //   1061: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: iload_3
    //   1065: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1074: aload_0
    //   1075: getfield 119	com/tencent/mm/plugin/vlog/player/l:BIY	Ljava/lang/Object;
    //   1078: ldc2_w 412
    //   1081: invokevirtual 415	java/lang/Object:wait	(J)V
    //   1084: getstatic 325	d/z:MKo	Ld/z;
    //   1087: astore 7
    //   1089: aload 6
    //   1091: monitorexit
    //   1092: ldc 166
    //   1094: new 143	java/lang/StringBuilder
    //   1097: dup
    //   1098: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   1101: aload_0
    //   1102: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1105: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1108: ldc_w 417
    //   1111: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: ldc 166
    //   1122: new 143	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   1129: aload_0
    //   1130: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1133: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1136: ldc_w 419
    //   1139: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: lload 4
    //   1144: invokestatic 423	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   1147: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1150: ldc_w 425
    //   1153: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1162: ldc 196
    //   1164: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1167: return
    //   1168: astore 7
    //   1170: ldc 166
    //   1172: aload 7
    //   1174: checkcast 332	java/lang/Throwable
    //   1177: new 143	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   1184: aload_0
    //   1185: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1188: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1191: ldc_w 427
    //   1194: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: iconst_0
    //   1201: anewarray 113	java/lang/Object
    //   1204: invokestatic 341	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1207: goto -123 -> 1084
    //   1210: astore 7
    //   1212: aload 6
    //   1214: monitorexit
    //   1215: ldc 196
    //   1217: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1220: aload 7
    //   1222: athrow
    //   1223: ldc 166
    //   1225: new 143	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   1232: aload_0
    //   1233: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1236: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1239: ldc_w 429
    //   1242: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: iload_3
    //   1246: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1249: ldc_w 431
    //   1252: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1258: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1261: aload_0
    //   1262: iconst_1
    //   1263: putfield 129	com/tencent/mm/plugin/vlog/player/l:BIZ	Z
    //   1266: aload_0
    //   1267: getfield 138	com/tencent/mm/plugin/vlog/player/l:pUJ	Lcom/tencent/mm/plugin/o/j;
    //   1270: astore 6
    //   1272: aload 6
    //   1274: ifnull -154 -> 1120
    //   1277: aload 6
    //   1279: invokevirtual 433	com/tencent/mm/plugin/o/j:isPlaying	()Z
    //   1282: ifne -162 -> 1120
    //   1285: ldc 166
    //   1287: new 143	java/lang/StringBuilder
    //   1290: dup
    //   1291: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   1294: aload_0
    //   1295: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1298: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: ldc_w 435
    //   1304: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1313: aload_0
    //   1314: invokespecial 437	com/tencent/mm/plugin/vlog/player/l:start	()Z
    //   1317: pop
    //   1318: goto -198 -> 1120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1321	0	this	l
    //   0	1321	1	paramLong	long
    //   904	342	3	i	int
    //   33	1110	4	l	long
    //   591	39	6	localException1	Exception
    //   555	1	7	localz1	z
    //   945	5	7	localException2	Exception
    //   987	11	7	localObject3	Object
    //   1087	1	7	localz2	z
    //   1168	5	7	localException3	Exception
    //   1210	11	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   320	375	591	java/lang/Exception
    //   380	392	591	java/lang/Exception
    //   392	398	591	java/lang/Exception
    //   403	412	591	java/lang/Exception
    //   412	418	591	java/lang/Exception
    //   423	432	591	java/lang/Exception
    //   432	438	591	java/lang/Exception
    //   443	452	591	java/lang/Exception
    //   452	458	591	java/lang/Exception
    //   463	469	591	java/lang/Exception
    //   469	475	591	java/lang/Exception
    //   480	486	591	java/lang/Exception
    //   486	492	591	java/lang/Exception
    //   497	503	591	java/lang/Exception
    //   503	545	591	java/lang/Exception
    //   557	566	591	java/lang/Exception
    //   571	591	591	java/lang/Exception
    //   989	1000	591	java/lang/Exception
    //   1000	1012	591	java/lang/Exception
    //   1016	1022	591	java/lang/Exception
    //   1027	1033	591	java/lang/Exception
    //   1033	1042	591	java/lang/Exception
    //   1089	1120	591	java/lang/Exception
    //   1120	1162	591	java/lang/Exception
    //   1212	1223	591	java/lang/Exception
    //   1223	1272	591	java/lang/Exception
    //   1277	1318	591	java/lang/Exception
    //   545	552	945	java/lang/Exception
    //   545	552	987	finally
    //   552	557	987	finally
    //   947	984	987	finally
    //   1042	1084	1168	java/lang/Exception
    //   1042	1084	1210	finally
    //   1084	1089	1210	finally
    //   1170	1207	1210	finally
  }
  
  public final void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(111000);
    this.BIZ = true;
    Object localObject = this.pUJ;
    if ((localObject != null) && (!((com.tencent.mm.plugin.o.j)localObject).isPlaying()))
    {
      ad.i("MicroMsg.VLogVideoPlayer", hashCode() + " playing start now");
      start();
    }
    if (paramBoolean) {
      try
      {
        localObject = this.surfaceTexture;
        if (localObject != null)
        {
          ((SurfaceTexture)localObject).updateTexImage();
          AppMethodBeat.o(111000);
          return;
        }
        AppMethodBeat.o(111000);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " updateTexImage error", new Object[0]);
      }
    }
    AppMethodBeat.o(111000);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(110997);
    com.tencent.mm.plugin.o.j localj = this.pUJ;
    if (localj != null)
    {
      if (localj.isPlaying() == true)
      {
        localj = this.pUJ;
        if (localj != null)
        {
          localj.pause();
          AppMethodBeat.o(110997);
        }
      }
    }
    else
    {
      AppMethodBeat.o(110997);
      return;
    }
    AppMethodBeat.o(110997);
  }
  
  public final void prepare()
  {
    int i = 1;
    AppMethodBeat.i(111001);
    long l1 = bt.HI();
    if ((bt.isNullOrNil(this.BIa.path)) || (!com.tencent.mm.vfs.i.fv(this.BIa.path))) {
      ad.e("MicroMsg.VLogVideoPlayer", hashCode() + " prepare file not exist or is null");
    }
    this.bdb = true;
    Object localObject1 = e.BIv;
    localObject1 = e.aDs(this.BIa.path);
    if (localObject1 != null)
    {
      ad.i("MicroMsg.VLogVideoPlayer", "prepare get info from cache");
      this.dGc = ((a)localObject1).dGc;
      this.width = ((a)localObject1).width;
      this.height = ((a)localObject1).height;
      this.cropLeft = ((a)localObject1).cropLeft;
      this.cropTop = ((a)localObject1).cropTop;
      this.cropRight = ((a)localObject1).cropRight;
      this.cropBottom = ((a)localObject1).cropBottom;
    }
    Object localObject2;
    while (i != 0)
    {
      ad.i("MicroMsg.VLogVideoPlayer", "prepare finish get from cache");
      localObject1 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(this.dGc).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.BIa.startTime).append(", endTime = ").append(this.BIa.endTime).append(", videoStartTime = ");
      localObject2 = this.BIa;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(111001);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        ad.i("MicroMsg.VLogVideoPlayer", ((ab)localObject2).BGQ + ", videoEndTime = " + ((ab)this.BIa).BGR + ", cost:" + bt.aO(l1) + "ms");
        AppMethodBeat.o(111001);
        return;
      }
    }
    for (;;)
    {
      try
      {
        ad.m("MicroMsg.VLogVideoPlayer", hashCode() + " start prepare " + this.BIa.path, new Object[0]);
        this.dGc = -1;
        long l2 = bt.HI();
        localObject1 = new MediaExtractor();
        ((MediaExtractor)localObject1).setDataSource(this.BIa.path);
        int j = ((MediaExtractor)localObject1).getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject2 = ((MediaExtractor)localObject1).getTrackFormat(i);
          String str = ((MediaFormat)localObject2).getString("mime");
          p.g(str, "mediaFormat.getString(MediaFormat.KEY_MIME)");
          if (!n.nz(str, "video")) {
            break label857;
          }
          this.width = ((MediaFormat)localObject2).getInteger("width");
          this.height = ((MediaFormat)localObject2).getInteger("height");
          if ((com.tencent.mm.compatible.util.d.ly(23)) && (((MediaFormat)localObject2).containsKey("rotation-degrees"))) {
            this.dGc = ((MediaFormat)localObject2).getInteger("rotation-degrees");
          }
        }
        ((MediaExtractor)localObject1).release();
        ad.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get width/height cost:" + bt.aO(l2) + "ms, try-get rotate:" + this.dGc);
        if (this.dGc < 0)
        {
          l2 = bt.HI();
          this.dGc = SightVideoJNI.getMp4RotateVFS(this.BIa.path);
          ad.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get rotate cost:" + bt.aO(l2) + "ms");
        }
        if (this.dGc != 90) {
          break label864;
        }
        this.dGc = 3;
        localObject1 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(this.dGc).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.BIa.startTime).append(", endTime = ").append(this.BIa.endTime).append(", videoStartTime = ");
        localObject2 = this.BIa;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(111001);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " prepare error", new Object[0]);
        AppMethodBeat.o(111001);
        return;
      }
      label857:
      i += 1;
      continue;
      label864:
      if (this.dGc == 180) {
        this.dGc = 2;
      } else if (this.dGc == 270) {
        this.dGc = 1;
      }
    }
    ad.i("MicroMsg.VLogVideoPlayer", ((ab)localObject2).BGQ + ", videoEndTime = " + ((ab)this.BIa).BGR + ", cost:" + bt.aO(l1) + "ms");
    e locale = e.BIv;
    e.o(this.BIa.path, this.width, this.height, this.dGc);
    AppMethodBeat.o(111001);
  }
  
  public final void release()
  {
    AppMethodBeat.i(110996);
    ad.i("MicroMsg.VLogVideoPlayer", "%d player release [%s]", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    this.BHY = false;
    Object localObject = this.pUJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).a(null);
    }
    localObject = this.pUJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).stop();
    }
    localObject = this.pUJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).release();
    }
    this.pUJ = null;
    this.BJa = false;
    this.lsQ = 0L;
    localObject = this.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    localObject = this.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).release();
    }
    this.surfaceTexture = null;
    this.surface = null;
    this.bdb = false;
    AppMethodBeat.o(110996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(110998);
    com.tencent.mm.plugin.o.j localj = this.pUJ;
    if (localj != null)
    {
      if (!localj.isPlaying()) {
        start();
      }
      AppMethodBeat.o(110998);
      return;
    }
    AppMethodBeat.o(110998);
  }
  
  public final void sR(boolean paramBoolean)
  {
    AppMethodBeat.i(111002);
    if (this.hvp != paramBoolean)
    {
      com.tencent.mm.plugin.o.j localj = this.pUJ;
      if (localj != null) {
        localj.setMute(paramBoolean);
      }
    }
    this.hvp = paramBoolean;
    AppMethodBeat.o(111002);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(110995);
    this.BHY = false;
    Object localObject = this.pUJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).a(null);
    }
    localObject = this.pUJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).stop();
    }
    localObject = this.pUJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).release();
    }
    this.pUJ = null;
    this.BJa = false;
    localObject = this.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    localObject = this.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).release();
    }
    this.surfaceTexture = null;
    this.surface = null;
    AppMethodBeat.o(110995);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(110989);
      ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + ' ' + this.BJd.BIa.path + " start do check crop rect");
      final long l = bt.HI();
      Object localObject = new com.tencent.mm.media.f.a(this.BJd.BIa.path);
      locale = new com.tencent.mm.media.i.e((com.tencent.mm.media.f.a)localObject, (byte)0);
      localm = (m)new q(l) {};
      locale.gjf = localm;
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.compatible.util.d.ly(23)) {
            continue;
          }
          localObject = (f)new com.tencent.mm.media.d.j(locale.hlB.getDuration() / 1000, locale.hlB, (d.g.a.b)new e.c(locale));
          locale.hlx = ((f)localObject);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace(locale.TAG, (Throwable)localException, "start check init decoder error", new Object[0]);
          com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avN();
          localm.p(null, locale);
          continue;
        }
        locale.hlz = c.a("MediaCodecCheckVideoCropRect_decode", false, (d.g.a.a)new e.e(locale));
        ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + " checkCropRect finish cost " + bt.aO(l) + "ms");
        AppMethodBeat.o(110989);
        return;
        localObject = (f)new com.tencent.mm.media.d.i(locale.hlB.getDuration() / 1000, locale.hlB, (d.g.a.b)new e.d(locale));
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/player/VLogVideoPlayer$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-vlog_release"})
  public static final class c
    implements com.tencent.mm.plugin.o.d
  {
    public final void Z(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(110993);
      ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + " video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(110993);
    }
    
    public final void ckp()
    {
      AppMethodBeat.i(110992);
      Object localObject2 = this.BJd.hashCode() + " %s player seek done";
      ??? = l.d(this.BJd);
      if (??? != null) {
        ??? = ((com.tencent.mm.plugin.o.j)???).info();
      }
      for (;;)
      {
        ad.d("MicroMsg.VLogVideoPlayer", (String)localObject2, new Object[] { ??? });
        synchronized (l.e(this.BJd))
        {
          try
          {
            ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + " player seek notifyAll");
            l.e(this.BJd).notifyAll();
            localObject2 = z.MKo;
            AppMethodBeat.o(110992);
            return;
            ??? = null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, this.BJd.hashCode() + " notify seekLock error", new Object[0]);
            }
          }
        }
      }
    }
    
    public final void onCompletion() {}
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(110991);
      ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + " onError what:" + paramInt1 + " error :" + paramInt2);
      AppMethodBeat.o(110991);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(110990);
      ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + " onPrepared, canPlaying:" + l.a(this.BJd) + ", notify all");
      l.b(this.BJd);
      synchronized (l.c(this.BJd))
      {
        try
        {
          ad.i("MicroMsg.VLogVideoPlayer", this.BJd.hashCode() + " onPrepared notifyAll");
          l.c(this.BJd).notifyAll();
          z localz = z.MKo;
          AppMethodBeat.o(110990);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "prepare lock notify error", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.l
 * JD-Core Version:    0.7.0.1
 */