package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.k;
import com.tencent.mm.media.i.e.c;
import com.tencent.mm.media.i.e.d;
import com.tencent.mm.media.i.e.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Z)V", "canPlaying", "didCheckCrop", "lastSurfaceUpdatedTime", "", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "prepareLock", "Ljava/lang/Object;", "seekLock", "seekTime", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoIsPrepared", "checkCropRect", "", "enableMute", "isMirror", "isOES", "isPlaying", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "release", "resume", "start", "stop", "Companion", "plugin-vlog_release"})
public final class l
  extends b
{
  public static final a NpY;
  private long MUG;
  private final Object NpT;
  private final Object NpU;
  private volatile boolean NpV;
  private volatile boolean NpW;
  private boolean NpX;
  private long pDx;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private com.tencent.mm.plugin.u.j uXR;
  private com.tencent.mm.plugin.u.d uYb;
  
  static
  {
    AppMethodBeat.i(111004);
    NpY = new a((byte)0);
    AppMethodBeat.o(111004);
  }
  
  public l(int paramInt1, int paramInt2, int paramInt3, aj paramaj, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, (s)paramaj, paramBoolean);
    AppMethodBeat.i(111003);
    this.NpT = new Object();
    this.NpU = new Object();
    this.uYb = ((com.tencent.mm.plugin.u.d)new c(this));
    AppMethodBeat.o(111003);
  }
  
  private boolean start()
  {
    boolean bool = false;
    AppMethodBeat.i(110994);
    if ((this.uXR != null) && (this.NpW))
    {
      Object localObject = "%d player start surface[%b], seekTime:" + this.MUG;
      i = hashCode();
      if (this.surface != null) {
        bool = true;
      }
      Log.i("MicroMsg.VLogVideoPlayer", (String)localObject, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = this.uXR;
      if (localObject != null) {
        ((com.tencent.mm.plugin.u.j)localObject).start();
      }
      AppMethodBeat.o(110994);
      return true;
    }
    int i = hashCode();
    if (this.uXR == null) {}
    for (bool = true;; bool = false)
    {
      Log.w("MicroMsg.VLogVideoPlayer", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Boolean.valueOf(this.NpW) });
      AppMethodBeat.o(110994);
      return false;
    }
  }
  
  public final void Aq(boolean paramBoolean)
  {
    AppMethodBeat.i(111002);
    if (guj() != paramBoolean)
    {
      com.tencent.mm.plugin.u.j localj = this.uXR;
      if (localj != null) {
        localj.setMute(paramBoolean);
      }
    }
    setMute(paramBoolean);
    AppMethodBeat.o(111002);
  }
  
  public final void O(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(111000);
    this.NpV = true;
    Object localObject = this.uXR;
    if ((localObject != null) && (!((com.tencent.mm.plugin.u.j)localObject).isPlaying()))
    {
      Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " playing start now");
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
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " updateTexImage error", new Object[0]);
      }
    }
    AppMethodBeat.o(111000);
  }
  
  /* Error */
  public final void Ss(long paramLong)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 243	com/tencent/mm/plugin/vlog/player/b:NoX	Z
    //   9: ifeq +16 -> 25
    //   12: ldc 166
    //   14: ldc 245
    //   16: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 240
    //   21: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 243	com/tencent/mm/plugin/vlog/player/b:NoX	Z
    //   30: invokestatic 251	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   33: lstore 4
    //   35: ldc 166
    //   37: new 143	java/lang/StringBuilder
    //   40: dup
    //   41: ldc 253
    //   43: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 257	com/tencent/mm/plugin/vlog/player/b:NkK	I
    //   50: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc_w 259
    //   56: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload_1
    //   60: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc_w 261
    //   66: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 264	com/tencent/mm/plugin/vlog/player/l:aVr	()I
    //   73: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: iconst_2
    //   80: anewarray 113	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   89: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_0
    //   96: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   99: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   110: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   113: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   116: ifne +16 -> 132
    //   119: aload_0
    //   120: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   123: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   126: invokestatic 281	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   129: ifne +31 -> 160
    //   132: ldc 166
    //   134: ldc_w 283
    //   137: iconst_1
    //   138: anewarray 113	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   147: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: ldc 240
    //   156: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: return
    //   160: ldc 166
    //   162: ldc_w 285
    //   165: iconst_2
    //   166: anewarray 113	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_0
    //   172: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   175: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_0
    //   182: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   185: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: getfield 287	com/tencent/mm/plugin/vlog/player/l:NpX	Z
    //   196: ifne +128 -> 324
    //   199: ldc 166
    //   201: new 143	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   208: aload_0
    //   209: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   212: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: bipush 32
    //   217: invokevirtual 290	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   224: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   227: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 292
    //   233: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 295	com/tencent/mm/plugin/vlog/player/b:width	I
    //   240: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc_w 297
    //   246: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 300	com/tencent/mm/plugin/vlog/player/b:height	I
    //   253: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 295	com/tencent/mm/plugin/vlog/player/b:width	I
    //   266: ifeq +10 -> 276
    //   269: aload_0
    //   270: getfield 300	com/tencent/mm/plugin/vlog/player/b:height	I
    //   273: ifne +375 -> 648
    //   276: ldc 166
    //   278: new 143	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   285: aload_0
    //   286: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   289: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: bipush 32
    //   294: invokevirtual 290	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   301: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   304: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 302
    //   310: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_0
    //   320: iconst_0
    //   321: putfield 287	com/tencent/mm/plugin/vlog/player/l:NpX	Z
    //   324: aload_0
    //   325: new 226	android/graphics/SurfaceTexture
    //   328: dup
    //   329: aload_0
    //   330: getfield 257	com/tencent/mm/plugin/vlog/player/b:NkK	I
    //   333: invokespecial 304	android/graphics/SurfaceTexture:<init>	(I)V
    //   336: putfield 224	com/tencent/mm/plugin/vlog/player/l:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   339: aload_0
    //   340: new 306	android/view/Surface
    //   343: dup
    //   344: aload_0
    //   345: getfield 224	com/tencent/mm/plugin/vlog/player/l:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   348: invokespecial 309	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   351: putfield 164	com/tencent/mm/plugin/vlog/player/l:surface	Landroid/view/Surface;
    //   354: aload_0
    //   355: iconst_0
    //   356: putfield 132	com/tencent/mm/plugin/vlog/player/l:NpW	Z
    //   359: aload_0
    //   360: new 184	com/tencent/mm/plugin/u/j
    //   363: dup
    //   364: invokestatic 315	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   367: invokespecial 318	com/tencent/mm/plugin/u/j:<init>	(Landroid/os/Looper;)V
    //   370: putfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   373: aload_0
    //   374: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   377: astore 6
    //   379: aload 6
    //   381: ifnull +15 -> 396
    //   384: aload 6
    //   386: aload_0
    //   387: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   390: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   393: invokevirtual 321	com/tencent/mm/plugin/u/j:setPath	(Ljava/lang/String;)V
    //   396: aload_0
    //   397: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   400: astore 6
    //   402: aload 6
    //   404: ifnull +12 -> 416
    //   407: aload 6
    //   409: aload_0
    //   410: getfield 126	com/tencent/mm/plugin/vlog/player/l:uYb	Lcom/tencent/mm/plugin/u/d;
    //   413: invokevirtual 324	com/tencent/mm/plugin/u/j:a	(Lcom/tencent/mm/plugin/u/d;)V
    //   416: aload_0
    //   417: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   420: astore 6
    //   422: aload 6
    //   424: ifnull +12 -> 436
    //   427: aload 6
    //   429: aload_0
    //   430: getfield 164	com/tencent/mm/plugin/vlog/player/l:surface	Landroid/view/Surface;
    //   433: invokevirtual 328	com/tencent/mm/plugin/u/j:setSurface	(Landroid/view/Surface;)V
    //   436: aload_0
    //   437: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   440: astore 6
    //   442: aload 6
    //   444: ifnull +12 -> 456
    //   447: aload 6
    //   449: aload_0
    //   450: invokevirtual 197	com/tencent/mm/plugin/vlog/player/l:guj	()Z
    //   453: invokevirtual 200	com/tencent/mm/plugin/u/j:setMute	(Z)V
    //   456: aload_0
    //   457: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   460: astore 6
    //   462: aload 6
    //   464: ifnull +9 -> 473
    //   467: aload 6
    //   469: iconst_0
    //   470: invokevirtual 331	com/tencent/mm/plugin/u/j:setNeedResetExtractor	(Z)V
    //   473: aload_0
    //   474: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   477: astore 6
    //   479: aload 6
    //   481: ifnull +9 -> 490
    //   484: aload 6
    //   486: iconst_0
    //   487: invokevirtual 334	com/tencent/mm/plugin/u/j:setIsOnlineVideoType	(Z)V
    //   490: aload_0
    //   491: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   494: astore 6
    //   496: aload 6
    //   498: ifnull +9 -> 507
    //   501: aload 6
    //   503: invokevirtual 336	com/tencent/mm/plugin/u/j:prepare	()Z
    //   506: pop
    //   507: aload_0
    //   508: lload_1
    //   509: putfield 150	com/tencent/mm/plugin/vlog/player/l:MUG	J
    //   512: ldc 166
    //   514: new 143	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   521: aload_0
    //   522: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   525: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: ldc_w 338
    //   531: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload_0
    //   541: getfield 117	com/tencent/mm/plugin/vlog/player/l:NpT	Ljava/lang/Object;
    //   544: astore 6
    //   546: aload 6
    //   548: monitorenter
    //   549: aload_0
    //   550: getfield 117	com/tencent/mm/plugin/vlog/player/l:NpT	Ljava/lang/Object;
    //   553: invokevirtual 341	java/lang/Object:wait	()V
    //   556: getstatic 347	kotlin/x:aazN	Lkotlin/x;
    //   559: astore 7
    //   561: aload 6
    //   563: monitorexit
    //   564: aload_0
    //   565: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   568: astore 6
    //   570: aload 6
    //   572: ifnonnull +432 -> 1004
    //   575: new 349	kotlin/t
    //   578: dup
    //   579: ldc_w 351
    //   582: invokespecial 352	kotlin/t:<init>	(Ljava/lang/String;)V
    //   585: astore 6
    //   587: ldc 240
    //   589: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   592: aload 6
    //   594: athrow
    //   595: astore 6
    //   597: ldc 166
    //   599: aload 6
    //   601: checkcast 231	java/lang/Throwable
    //   604: new 143	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   611: aload_0
    //   612: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   615: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: ldc_w 354
    //   621: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: iconst_1
    //   628: anewarray 113	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: aload 6
    //   635: invokevirtual 357	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   638: aastore
    //   639: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   642: ldc 240
    //   644: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   647: return
    //   648: aload_0
    //   649: getfield 295	com/tencent/mm/plugin/vlog/player/b:width	I
    //   652: bipush 16
    //   654: irem
    //   655: ifne +13 -> 668
    //   658: aload_0
    //   659: getfield 300	com/tencent/mm/plugin/vlog/player/b:height	I
    //   662: bipush 16
    //   664: irem
    //   665: ifeq +271 -> 936
    //   668: getstatic 363	com/tencent/mm/plugin/vlog/player/e:Nps	Lcom/tencent/mm/plugin/vlog/player/e;
    //   671: astore 6
    //   673: aload_0
    //   674: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   677: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   680: invokestatic 367	com/tencent/mm/plugin/vlog/player/e:bfE	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   683: astore 6
    //   685: aload 6
    //   687: ifnull +257 -> 944
    //   690: aload 6
    //   692: getfield 372	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   695: iflt +249 -> 944
    //   698: aload 6
    //   700: getfield 375	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   703: iflt +241 -> 944
    //   706: aload_0
    //   707: getfield 378	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   710: iflt +234 -> 944
    //   713: aload 6
    //   715: getfield 381	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   718: iflt +226 -> 944
    //   721: ldc 166
    //   723: ldc_w 383
    //   726: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   729: aload_0
    //   730: aload 6
    //   732: getfield 386	com/tencent/mm/plugin/vlog/player/a:fSM	I
    //   735: invokevirtual 389	com/tencent/mm/plugin/vlog/player/l:tm	(I)V
    //   738: aload_0
    //   739: aload 6
    //   741: getfield 390	com/tencent/mm/plugin/vlog/player/a:width	I
    //   744: putfield 295	com/tencent/mm/plugin/vlog/player/b:width	I
    //   747: aload_0
    //   748: aload 6
    //   750: getfield 391	com/tencent/mm/plugin/vlog/player/a:height	I
    //   753: putfield 300	com/tencent/mm/plugin/vlog/player/b:height	I
    //   756: aload_0
    //   757: aload 6
    //   759: getfield 372	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   762: putfield 392	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   765: aload_0
    //   766: aload 6
    //   768: getfield 375	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   771: putfield 393	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   774: aload_0
    //   775: aload 6
    //   777: getfield 394	com/tencent/mm/plugin/vlog/player/a:cropRight	I
    //   780: putfield 378	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   783: aload_0
    //   784: aload 6
    //   786: getfield 381	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   789: putfield 395	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   792: ldc 166
    //   794: new 143	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   801: aload_0
    //   802: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   805: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: bipush 32
    //   810: invokevirtual 290	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   813: aload_0
    //   814: getfield 268	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   817: getfield 272	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   820: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: ldc_w 397
    //   826: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload_0
    //   830: getfield 392	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   833: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   836: ldc_w 399
    //   839: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload_0
    //   843: getfield 393	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   846: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   849: ldc_w 399
    //   852: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_0
    //   856: getfield 378	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   859: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: ldc_w 399
    //   865: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_0
    //   869: getfield 395	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   872: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   875: ldc_w 401
    //   878: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload_0
    //   882: getfield 295	com/tencent/mm/plugin/vlog/player/b:width	I
    //   885: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: ldc_w 403
    //   891: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload_0
    //   895: getfield 300	com/tencent/mm/plugin/vlog/player/b:height	I
    //   898: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: iconst_1
    //   908: istore_3
    //   909: iload_3
    //   910: ifne -586 -> 324
    //   913: getstatic 409	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   916: new 9	com/tencent/mm/plugin/vlog/player/l$b
    //   919: dup
    //   920: aload_0
    //   921: invokespecial 410	com/tencent/mm/plugin/vlog/player/l$b:<init>	(Lcom/tencent/mm/plugin/vlog/player/l;)V
    //   924: checkcast 412	java/lang/Runnable
    //   927: ldc_w 414
    //   930: invokeinterface 419 3 0
    //   935: pop
    //   936: aload_0
    //   937: iconst_1
    //   938: putfield 287	com/tencent/mm/plugin/vlog/player/l:NpX	Z
    //   941: goto -617 -> 324
    //   944: iconst_0
    //   945: istore_3
    //   946: goto -37 -> 909
    //   949: astore 7
    //   951: ldc 166
    //   953: aload 7
    //   955: checkcast 231	java/lang/Throwable
    //   958: new 143	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   965: aload_0
    //   966: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   969: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   972: ldc_w 421
    //   975: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: iconst_0
    //   982: anewarray 113	java/lang/Object
    //   985: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   988: goto -432 -> 556
    //   991: astore 7
    //   993: aload 6
    //   995: monitorexit
    //   996: ldc 240
    //   998: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1001: aload 7
    //   1003: athrow
    //   1004: aload 6
    //   1006: checkcast 423	com/tencent/mm/plugin/vlog/model/aj
    //   1009: getfield 426	com/tencent/mm/plugin/vlog/model/aj:NnC	J
    //   1012: lload_1
    //   1013: ladd
    //   1014: l2i
    //   1015: istore_3
    //   1016: iload_3
    //   1017: ifle +210 -> 1227
    //   1020: aload_0
    //   1021: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   1024: astore 6
    //   1026: aload 6
    //   1028: ifnull +9 -> 1037
    //   1031: aload 6
    //   1033: iload_3
    //   1034: invokevirtual 429	com/tencent/mm/plugin/u/j:seek	(I)V
    //   1037: aload_0
    //   1038: getfield 119	com/tencent/mm/plugin/vlog/player/l:NpU	Ljava/lang/Object;
    //   1041: astore 6
    //   1043: aload 6
    //   1045: monitorenter
    //   1046: ldc 166
    //   1048: new 143	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1055: aload_0
    //   1056: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1059: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1062: ldc_w 431
    //   1065: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: iload_3
    //   1069: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: aload_0
    //   1079: getfield 119	com/tencent/mm/plugin/vlog/player/l:NpU	Ljava/lang/Object;
    //   1082: ldc2_w 432
    //   1085: invokevirtual 435	java/lang/Object:wait	(J)V
    //   1088: getstatic 347	kotlin/x:aazN	Lkotlin/x;
    //   1091: astore 7
    //   1093: aload 6
    //   1095: monitorexit
    //   1096: ldc 166
    //   1098: new 143	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1105: aload_0
    //   1106: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1109: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1112: ldc_w 437
    //   1115: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1124: ldc 166
    //   1126: new 143	java/lang/StringBuilder
    //   1129: dup
    //   1130: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1133: aload_0
    //   1134: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1137: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1140: ldc_w 439
    //   1143: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: lload 4
    //   1148: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1151: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1154: ldc_w 445
    //   1157: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: ldc 240
    //   1168: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1171: return
    //   1172: astore 7
    //   1174: ldc 166
    //   1176: aload 7
    //   1178: checkcast 231	java/lang/Throwable
    //   1181: new 143	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1188: aload_0
    //   1189: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1192: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1195: ldc_w 447
    //   1198: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: iconst_0
    //   1205: anewarray 113	java/lang/Object
    //   1208: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1211: goto -123 -> 1088
    //   1214: astore 7
    //   1216: aload 6
    //   1218: monitorexit
    //   1219: ldc 240
    //   1221: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1224: aload 7
    //   1226: athrow
    //   1227: ldc 166
    //   1229: new 143	java/lang/StringBuilder
    //   1232: dup
    //   1233: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1236: aload_0
    //   1237: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1240: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: ldc_w 449
    //   1246: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: iload_3
    //   1250: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: ldc_w 451
    //   1256: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: aload_0
    //   1266: iconst_1
    //   1267: putfield 129	com/tencent/mm/plugin/vlog/player/l:NpV	Z
    //   1270: aload_0
    //   1271: getfield 138	com/tencent/mm/plugin/vlog/player/l:uXR	Lcom/tencent/mm/plugin/u/j;
    //   1274: astore 6
    //   1276: aload 6
    //   1278: ifnull -154 -> 1124
    //   1281: aload 6
    //   1283: invokevirtual 208	com/tencent/mm/plugin/u/j:isPlaying	()Z
    //   1286: ifne -162 -> 1124
    //   1289: ldc 166
    //   1291: new 143	java/lang/StringBuilder
    //   1294: dup
    //   1295: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1298: aload_0
    //   1299: invokevirtual 162	com/tencent/mm/plugin/vlog/player/l:hashCode	()I
    //   1302: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1305: ldc_w 453
    //   1308: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1314: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1317: aload_0
    //   1318: invokespecial 222	com/tencent/mm/plugin/vlog/player/l:start	()Z
    //   1321: pop
    //   1322: goto -198 -> 1124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1325	0	this	l
    //   0	1325	1	paramLong	long
    //   908	342	3	i	int
    //   33	1114	4	l	long
    //   595	39	6	localException1	Exception
    //   559	1	7	localx1	x
    //   949	5	7	localException2	Exception
    //   991	11	7	localObject3	Object
    //   1091	1	7	localx2	x
    //   1172	5	7	localException3	Exception
    //   1214	11	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   324	379	595	java/lang/Exception
    //   384	396	595	java/lang/Exception
    //   396	402	595	java/lang/Exception
    //   407	416	595	java/lang/Exception
    //   416	422	595	java/lang/Exception
    //   427	436	595	java/lang/Exception
    //   436	442	595	java/lang/Exception
    //   447	456	595	java/lang/Exception
    //   456	462	595	java/lang/Exception
    //   467	473	595	java/lang/Exception
    //   473	479	595	java/lang/Exception
    //   484	490	595	java/lang/Exception
    //   490	496	595	java/lang/Exception
    //   501	507	595	java/lang/Exception
    //   507	549	595	java/lang/Exception
    //   561	570	595	java/lang/Exception
    //   575	595	595	java/lang/Exception
    //   993	1004	595	java/lang/Exception
    //   1004	1016	595	java/lang/Exception
    //   1020	1026	595	java/lang/Exception
    //   1031	1037	595	java/lang/Exception
    //   1037	1046	595	java/lang/Exception
    //   1093	1124	595	java/lang/Exception
    //   1124	1166	595	java/lang/Exception
    //   1216	1227	595	java/lang/Exception
    //   1227	1276	595	java/lang/Exception
    //   1281	1322	595	java/lang/Exception
    //   549	556	949	java/lang/Exception
    //   549	556	991	finally
    //   556	561	991	finally
    //   951	988	991	finally
    //   1046	1088	1172	java/lang/Exception
    //   1046	1088	1214	finally
    //   1088	1093	1214	finally
    //   1174	1211	1214	finally
  }
  
  public final void pause()
  {
    AppMethodBeat.i(110997);
    com.tencent.mm.plugin.u.j localj = this.uXR;
    if (localj != null)
    {
      if (localj.isPlaying() == true)
      {
        localj = this.uXR;
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
    long l1 = Util.currentTicks();
    if ((Util.isNullOrNil(this.NoY.path)) || (!u.agG(this.NoY.path))) {
      Log.e("MicroMsg.VLogVideoPlayer", hashCode() + " prepare file not exist or is null");
    }
    this.aMy = true;
    Object localObject1 = e.Nps;
    localObject1 = e.bfE(this.NoY.path);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.VLogVideoPlayer", "prepare get info from cache");
      tm(((a)localObject1).fSM);
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
      Log.i("MicroMsg.VLogVideoPlayer", "prepare finish get from cache");
      localObject1 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(aVr()).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.NoY.startTime).append(", endTime = ").append(this.NoY.endTime).append(", videoStartTime = ");
      localObject2 = this.NoY;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(111001);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        Log.i("MicroMsg.VLogVideoPlayer", ((aj)localObject2).NnC + ", videoEndTime = " + ((aj)this.NoY).NnD + ", cost:" + Util.ticksToNow(l1) + "ms");
        AppMethodBeat.o(111001);
        return;
      }
    }
    for (;;)
    {
      try
      {
        Log.printInfoStack("MicroMsg.VLogVideoPlayer", hashCode() + " start prepare " + this.NoY.path, new Object[0]);
        tm(-1);
        long l2 = Util.currentTicks();
        localObject1 = new MediaExtractor();
        ((MediaExtractor)localObject1).setDataSource(this.NoY.path);
        int j = ((MediaExtractor)localObject1).getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject2 = ((MediaExtractor)localObject1).getTrackFormat(i);
          p.j(localObject2, "mediaExtractor.getTrackFormat(i)");
          String str = ((MediaFormat)localObject2).getString("mime");
          p.j(str, "mediaFormat.getString(MediaFormat.KEY_MIME)");
          if (!n.M(str, "video", false)) {
            break label866;
          }
          this.width = ((MediaFormat)localObject2).getInteger("width");
          this.height = ((MediaFormat)localObject2).getInteger("height");
          if ((com.tencent.mm.compatible.util.d.qV(23)) && (((MediaFormat)localObject2).containsKey("rotation-degrees"))) {
            tm(((MediaFormat)localObject2).getInteger("rotation-degrees"));
          }
        }
        ((MediaExtractor)localObject1).release();
        Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get width/height cost:" + Util.ticksToNow(l2) + "ms, try-get rotate:" + aVr());
        if (aVr() < 0)
        {
          l2 = Util.currentTicks();
          tm(SightVideoJNI.getMp4RotateVFS(this.NoY.path));
          Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get rotate cost:" + Util.ticksToNow(l2) + "ms");
        }
        if (aVr() != 90) {
          break label873;
        }
        tm(3);
        localObject1 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(aVr()).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.NoY.startTime).append(", endTime = ").append(this.NoY.endTime).append(", videoStartTime = ");
        localObject2 = this.NoY;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(111001);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " prepare error", new Object[0]);
        AppMethodBeat.o(111001);
        return;
      }
      label866:
      i += 1;
      continue;
      label873:
      if (aVr() == 180) {
        tm(2);
      } else if (aVr() == 270) {
        tm(1);
      }
    }
    Log.i("MicroMsg.VLogVideoPlayer", ((aj)localObject2).NnC + ", videoEndTime = " + ((aj)this.NoY).NnD + ", cost:" + Util.ticksToNow(l1) + "ms");
    e locale = e.Nps;
    e.s(this.NoY.path, this.width, this.height, aVr());
    AppMethodBeat.o(111001);
  }
  
  public final void release()
  {
    AppMethodBeat.i(110996);
    Log.i("MicroMsg.VLogVideoPlayer", "%d player release [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.NoX = false;
    Object localObject = this.uXR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).a(null);
    }
    localObject = this.uXR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).stop();
    }
    localObject = this.uXR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).release();
    }
    this.uXR = null;
    this.NpW = false;
    this.pDx = 0L;
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
    this.aMy = false;
    AppMethodBeat.o(110996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(110998);
    com.tencent.mm.plugin.u.j localj = this.uXR;
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
  
  public final void stop()
  {
    AppMethodBeat.i(110995);
    this.NoX = false;
    Object localObject = this.uXR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).a(null);
    }
    localObject = this.uXR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).stop();
    }
    localObject = this.uXR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).release();
    }
    this.uXR = null;
    this.NpW = false;
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(110989);
      Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + ' ' + this.NpZ.NoY.path + " start do check crop rect");
      final long l = Util.currentTicks();
      Object localObject = new com.tencent.mm.media.f.a(this.NpZ.NoY.path);
      locale = new com.tencent.mm.media.i.e((com.tencent.mm.media.f.a)localObject, (byte)0);
      localm = (m)new q(l) {};
      locale.jHk = localm;
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.compatible.util.d.qV(23)) {
            continue;
          }
          localObject = (com.tencent.mm.media.d.f)new k(locale.kWy.getDuration() / 1000, locale.kWy, (kotlin.g.a.b)new e.c(locale));
          locale.kWu = ((com.tencent.mm.media.d.f)localObject);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(locale.TAG, (Throwable)localException, "start check init decoder error", new Object[0]);
          com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aXt();
          localm.invoke(null, locale);
          continue;
        }
        locale.kWw = com.tencent.mm.ae.d.a("MediaCodecCheckVideoCropRect_decode", false, (kotlin.g.a.a)new e.e(locale));
        Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + " checkCropRect finish cost " + Util.ticksToNow(l) + "ms");
        AppMethodBeat.o(110989);
        return;
        localObject = (com.tencent.mm.media.d.f)new com.tencent.mm.media.d.j(locale.kWy.getDuration() / 1000, locale.kWy, (kotlin.g.a.b)new e.d(locale));
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/player/VLogVideoPlayer$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-vlog_release"})
  public static final class c
    implements com.tencent.mm.plugin.u.d
  {
    public final void ab(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(110993);
      Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + " video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(110993);
    }
    
    public final void cYp()
    {
      AppMethodBeat.i(110992);
      Object localObject2 = this.NpZ.hashCode() + " %s player seek done";
      ??? = l.d(this.NpZ);
      if (??? != null) {
        ??? = ((com.tencent.mm.plugin.u.j)???).info();
      }
      for (;;)
      {
        Log.d("MicroMsg.VLogVideoPlayer", (String)localObject2, new Object[] { ??? });
        synchronized (l.e(this.NpZ))
        {
          try
          {
            Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + " player seek notifyAll");
            l.e(this.NpZ).notifyAll();
            localObject2 = x.aazN;
            AppMethodBeat.o(110992);
            return;
            ??? = null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, this.NpZ.hashCode() + " notify seekLock error", new Object[0]);
            }
          }
        }
      }
    }
    
    public final void onCompletion() {}
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(110991);
      Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + " onError what:" + paramInt1 + " error :" + paramInt2);
      AppMethodBeat.o(110991);
    }
    
    public final void qX()
    {
      AppMethodBeat.i(110990);
      Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + " onPrepared, canPlaying:" + l.a(this.NpZ) + ", notify all");
      l.b(this.NpZ);
      synchronized (l.c(this.NpZ))
      {
        try
        {
          Log.i("MicroMsg.VLogVideoPlayer", this.NpZ.hashCode() + " onPrepared notifyAll");
          l.c(this.NpZ).notifyAll();
          x localx = x.aazN;
          AppMethodBeat.o(110990);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "prepare lock notify error", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.l
 * JD-Core Version:    0.7.0.1
 */