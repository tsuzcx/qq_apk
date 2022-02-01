package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.i;
import com.tencent.mm.media.i.d.c;
import com.tencent.mm.media.i.d.d;
import com.tencent.mm.media.i.d.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Z)V", "canPlaying", "didCheckCrop", "lastSurfaceUpdatedTime", "", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "prepareLock", "Ljava/lang/Object;", "seekLock", "seekTime", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoIsPrepared", "checkCropRect", "", "enableMute", "isMirror", "isOES", "isPlaying", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "release", "resume", "start", "stop", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends b
{
  public static final k.a UdJ;
  private long THh;
  private final Object UdK;
  private final Object UdL;
  private volatile boolean UdM;
  private volatile boolean UdN;
  private boolean UdO;
  private long sIJ;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private com.tencent.mm.plugin.u.j ykf;
  private com.tencent.mm.plugin.u.d ykp;
  
  static
  {
    AppMethodBeat.i(111004);
    UdJ = new k.a((byte)0);
    AppMethodBeat.o(111004);
  }
  
  public k(int paramInt1, int paramInt2, int paramInt3, ak paramak, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, (com.tencent.mm.plugin.vlog.model.s)paramak, paramBoolean);
    AppMethodBeat.i(111003);
    this.UdK = new Object();
    this.UdL = new Object();
    this.ykp = ((com.tencent.mm.plugin.u.d)new k.c(this));
    AppMethodBeat.o(111003);
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(281198);
    kotlin.g.b.s.u(paramk, "this$0");
    Log.i("MicroMsg.VLogVideoPlayer", paramk.hashCode() + ' ' + paramk.UcR.path + " start do check crop rect");
    final long l = Util.currentTicks();
    Object localObject = new com.tencent.mm.media.f.a(paramk.UcR.path);
    locald = new com.tencent.mm.media.i.d((com.tencent.mm.media.f.a)localObject, (byte)0);
    localm = (m)new b(paramk, l, (com.tencent.mm.media.f.a)localObject);
    locald.mgM = localm;
    for (;;)
    {
      try
      {
        if (!com.tencent.mm.compatible.util.d.rb(23)) {
          continue;
        }
        localObject = (com.tencent.mm.media.d.f)new com.tencent.mm.media.d.j(locald.nBM.getDuration() / 1000, locald.nBM, (kotlin.g.a.b)new d.c(locald));
        locald.nBN = ((com.tencent.mm.media.d.f)localObject);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(locald.TAG, (Throwable)localException, "start check init decoder error", new Object[0]);
        com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bsb();
        localm.invoke(null, locald);
        continue;
      }
      locald.nBP = com.tencent.mm.ae.d.f("MediaCodecCheckVideoCropRect_decode", (kotlin.g.a.a)new d.e(locald));
      Log.i("MicroMsg.VLogVideoPlayer", paramk.hashCode() + " checkCropRect finish cost " + Util.ticksToNow(l) + "ms");
      AppMethodBeat.o(281198);
      return;
      localObject = (com.tencent.mm.media.d.f)new i(locald.nBM.getDuration() / 1000, locald.nBM, (kotlin.g.a.b)new d.d(locald));
    }
  }
  
  private boolean start()
  {
    boolean bool = false;
    AppMethodBeat.i(110994);
    if ((this.ykf != null) && (this.UdN))
    {
      Object localObject = kotlin.g.b.s.X("%d player start surface[%b], seekTime:", Long.valueOf(this.THh));
      i = hashCode();
      if (this.surface != null) {
        bool = true;
      }
      Log.i("MicroMsg.VLogVideoPlayer", (String)localObject, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = this.ykf;
      if (localObject != null) {
        ((com.tencent.mm.plugin.u.j)localObject).start();
      }
      AppMethodBeat.o(110994);
      return true;
    }
    int i = hashCode();
    if (this.ykf == null) {}
    for (bool = true;; bool = false)
    {
      Log.w("MicroMsg.VLogVideoPlayer", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Boolean.valueOf(this.UdN) });
      AppMethodBeat.o(110994);
      return false;
    }
  }
  
  public final void FP(boolean paramBoolean)
  {
    AppMethodBeat.i(111002);
    if (hRX() != paramBoolean)
    {
      com.tencent.mm.plugin.u.j localj = this.ykf;
      if (localj != null) {
        localj.setMute(paramBoolean);
      }
    }
    setMute(paramBoolean);
    AppMethodBeat.o(111002);
  }
  
  public final void Z(long paramLong, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(111000);
    this.UdM = true;
    Object localObject = this.ykf;
    if ((localObject != null) && (!((com.tencent.mm.plugin.u.j)localObject).isPlaying())) {}
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " playing start now");
        start();
      }
      if (!paramBoolean) {
        break label143;
      }
      try
      {
        localObject = this.surfaceTexture;
        if (localObject == null) {
          break label143;
        }
        ((SurfaceTexture)localObject).updateTexImage();
        AppMethodBeat.o(111000);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " updateTexImage error", new Object[0]);
      }
      i = 0;
    }
    label143:
    AppMethodBeat.o(111000);
  }
  
  public final void pause()
  {
    int i = 1;
    AppMethodBeat.i(110997);
    com.tencent.mm.plugin.u.j localj = this.ykf;
    if ((localj != null) && (localj.isPlaying() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localj = this.ykf;
        if (localj != null) {
          localj.pause();
        }
      }
      AppMethodBeat.o(110997);
      return;
      i = 0;
    }
  }
  
  public final void prepare()
  {
    int i = 1;
    AppMethodBeat.i(111001);
    long l1 = Util.currentTicks();
    if ((Util.isNullOrNil(this.UcR.path)) || (!y.ZC(this.UcR.path))) {
      Log.e("MicroMsg.VLogVideoPlayer", hashCode() + " prepare file not exist or is null");
    }
    this.cGv = true;
    Object localObject = e.Udl;
    localObject = e.bfl(this.UcR.path);
    if (localObject != null)
    {
      Log.i("MicroMsg.VLogVideoPlayer", "prepare get info from cache");
      th(((a)localObject).hYK);
      this.width = ((a)localObject).width;
      this.height = ((a)localObject).height;
      this.cropLeft = ((a)localObject).cropLeft;
      this.cropTop = ((a)localObject).cropTop;
      this.cropRight = ((a)localObject).cropRight;
      this.cropBottom = ((a)localObject).cropBottom;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.VLogVideoPlayer", "prepare finish get from cache");
        Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video, rotate = " + hRY() + ", width = " + this.width + ", height = " + this.height + ", startTime = " + this.UcR.startTime + ", endTime = " + this.UcR.endTime + ", videoStartTime = " + ((ak)this.UcR).Ubf + ", videoEndTime = " + ((ak)this.UcR).Ubg + ", cost:" + Util.ticksToNow(l1) + "ms");
        AppMethodBeat.o(111001);
        return;
      }
      for (;;)
      {
        try
        {
          Log.printInfoStack("MicroMsg.VLogVideoPlayer", hashCode() + " start prepare " + this.UcR.path, new Object[0]);
          th(-1);
          long l2 = Util.currentTicks();
          localObject = new MediaExtractor();
          ((MediaExtractor)localObject).setDataSource(this.UcR.path);
          int k = ((MediaExtractor)localObject).getTrackCount();
          int j;
          if (k > 0)
          {
            i = 0;
            j = i + 1;
            MediaFormat localMediaFormat = ((MediaExtractor)localObject).getTrackFormat(i);
            kotlin.g.b.s.s(localMediaFormat, "mediaExtractor.getTrackFormat(i)");
            String str = localMediaFormat.getString("mime");
            kotlin.g.b.s.checkNotNull(str);
            kotlin.g.b.s.s(str, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
            if (!n.U(str, "video", false)) {
              continue;
            }
            this.width = localMediaFormat.getInteger("width");
            this.height = localMediaFormat.getInteger("height");
            if ((com.tencent.mm.compatible.util.d.rb(23)) && (localMediaFormat.containsKey("rotation-degrees"))) {
              th(localMediaFormat.getInteger("rotation-degrees"));
            }
          }
          ((MediaExtractor)localObject).release();
          Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get width/height cost:" + Util.ticksToNow(l2) + "ms, try-get rotate:" + hRY());
          if (hRY() < 0)
          {
            l2 = Util.currentTicks();
            th(SightVideoJNI.getMp4RotateVFS(this.UcR.path));
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get rotate cost:" + Util.ticksToNow(l2) + "ms");
          }
          if (hRY() == 90)
          {
            th(3);
            Log.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video, rotate = " + hRY() + ", width = " + this.width + ", height = " + this.height + ", startTime = " + this.UcR.startTime + ", endTime = " + this.UcR.endTime + ", videoStartTime = " + ((ak)this.UcR).Ubf + ", videoEndTime = " + ((ak)this.UcR).Ubg + ", cost:" + Util.ticksToNow(l1) + "ms");
            localObject = e.Udl;
            e.s(this.UcR.path, this.width, this.height, hRY());
            AppMethodBeat.o(111001);
            return;
            if (j >= k) {
              continue;
            }
            i = j;
            continue;
          }
          if (hRY() == 180)
          {
            th(2);
            continue;
          }
          if (hRY() != 270) {
            continue;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " prepare error", new Object[0]);
          AppMethodBeat.o(111001);
          return;
        }
        th(1);
      }
      i = 0;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(110996);
    Log.i("MicroMsg.VLogVideoPlayer", "%d player release [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.UcS = false;
    Object localObject = this.ykf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).KTf = null;
    }
    localObject = this.ykf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).stop();
    }
    localObject = this.ykf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).release();
    }
    this.ykf = null;
    this.UdN = false;
    this.sIJ = 0L;
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
    this.cGv = false;
    AppMethodBeat.o(110996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(110998);
    com.tencent.mm.plugin.u.j localj = this.ykf;
    if ((localj != null) && (!localj.isPlaying())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        start();
      }
      AppMethodBeat.o(110998);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(110995);
    this.UcS = false;
    Object localObject = this.ykf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).KTf = null;
    }
    localObject = this.ykf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).stop();
    }
    localObject = this.ykf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.u.j)localObject).release();
    }
    this.ykf = null;
    this.UdN = false;
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
  
  /* Error */
  public final void wG(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 569
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 552	com/tencent/mm/plugin/vlog/player/b:UcS	Z
    //   10: ifeq +18 -> 28
    //   13: ldc 138
    //   15: ldc_w 571
    //   18: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 569
    //   24: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 552	com/tencent/mm/plugin/vlog/player/b:UcS	Z
    //   33: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   36: lstore 4
    //   38: ldc 138
    //   40: new 140	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 573
    //   47: invokespecial 574	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 577	com/tencent/mm/plugin/vlog/player/b:TXY	I
    //   54: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 579
    //   60: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: lload_1
    //   64: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 581
    //   70: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: invokevirtual 440	com/tencent/mm/plugin/vlog/player/k:hRY	()I
    //   77: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: iconst_2
    //   84: anewarray 117	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   93: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_0
    //   100: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   103: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   114: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   117: invokestatic 376	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   120: ifne +16 -> 136
    //   123: aload_0
    //   124: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   127: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   130: invokestatic 381	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   133: ifne +32 -> 165
    //   136: ldc 138
    //   138: ldc_w 583
    //   141: iconst_1
    //   142: anewarray 117	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   151: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aastore
    //   155: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: ldc_w 569
    //   161: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: ldc 138
    //   167: ldc_w 585
    //   170: iconst_2
    //   171: anewarray 117	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_0
    //   177: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   180: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload_0
    //   187: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   190: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 587	com/tencent/mm/plugin/vlog/player/k:UdO	Z
    //   201: ifne +128 -> 329
    //   204: ldc 138
    //   206: new 140	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   213: aload_0
    //   214: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   217: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: bipush 32
    //   222: invokevirtual 152	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   229: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   232: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 589
    //   238: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 413	com/tencent/mm/plugin/vlog/player/b:width	I
    //   245: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc_w 591
    //   251: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 417	com/tencent/mm/plugin/vlog/player/b:height	I
    //   258: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: getfield 413	com/tencent/mm/plugin/vlog/player/b:width	I
    //   271: ifeq +10 -> 281
    //   274: aload_0
    //   275: getfield 417	com/tencent/mm/plugin/vlog/player/b:height	I
    //   278: ifne +462 -> 740
    //   281: ldc 138
    //   283: new 140	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   290: aload_0
    //   291: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   294: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: bipush 32
    //   299: invokevirtual 152	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   306: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   309: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 593
    //   315: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_0
    //   325: iconst_0
    //   326: putfield 587	com/tencent/mm/plugin/vlog/player/k:UdO	Z
    //   329: aload_0
    //   330: new 363	android/graphics/SurfaceTexture
    //   333: dup
    //   334: aload_0
    //   335: getfield 577	com/tencent/mm/plugin/vlog/player/b:TXY	I
    //   338: invokespecial 595	android/graphics/SurfaceTexture:<init>	(I)V
    //   341: putfield 361	com/tencent/mm/plugin/vlog/player/k:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   344: aload_0
    //   345: new 562	android/view/Surface
    //   348: dup
    //   349: aload_0
    //   350: getfield 361	com/tencent/mm/plugin/vlog/player/k:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   353: invokespecial 598	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   356: putfield 319	com/tencent/mm/plugin/vlog/player/k:surface	Landroid/view/Surface;
    //   359: aload_0
    //   360: iconst_0
    //   361: putfield 295	com/tencent/mm/plugin/vlog/player/k:UdN	Z
    //   364: aload_0
    //   365: new 334	com/tencent/mm/plugin/u/j
    //   368: dup
    //   369: invokestatic 604	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   372: invokespecial 607	com/tencent/mm/plugin/u/j:<init>	(Landroid/os/Looper;)V
    //   375: putfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   378: aload_0
    //   379: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   382: astore 6
    //   384: aload 6
    //   386: ifnull +15 -> 401
    //   389: aload 6
    //   391: aload_0
    //   392: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   395: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   398: invokevirtual 610	com/tencent/mm/plugin/u/j:setPath	(Ljava/lang/String;)V
    //   401: aload_0
    //   402: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   405: astore 6
    //   407: aload 6
    //   409: ifnull +12 -> 421
    //   412: aload 6
    //   414: aload_0
    //   415: getfield 131	com/tencent/mm/plugin/vlog/player/k:ykp	Lcom/tencent/mm/plugin/u/d;
    //   418: putfield 555	com/tencent/mm/plugin/u/j:KTf	Lcom/tencent/mm/plugin/u/d;
    //   421: aload_0
    //   422: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +12 -> 441
    //   432: aload 6
    //   434: aload_0
    //   435: getfield 319	com/tencent/mm/plugin/vlog/player/k:surface	Landroid/view/Surface;
    //   438: invokevirtual 614	com/tencent/mm/plugin/u/j:setSurface	(Landroid/view/Surface;)V
    //   441: aload_0
    //   442: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   445: astore 6
    //   447: aload 6
    //   449: ifnull +12 -> 461
    //   452: aload 6
    //   454: aload_0
    //   455: invokevirtual 347	com/tencent/mm/plugin/vlog/player/k:hRX	()Z
    //   458: invokevirtual 350	com/tencent/mm/plugin/u/j:setMute	(Z)V
    //   461: aload_0
    //   462: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   465: astore 6
    //   467: aload 6
    //   469: ifnull +9 -> 478
    //   472: aload 6
    //   474: iconst_0
    //   475: invokevirtual 617	com/tencent/mm/plugin/u/j:setNeedResetExtractor	(Z)V
    //   478: aload_0
    //   479: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   482: astore 6
    //   484: aload 6
    //   486: ifnull +9 -> 495
    //   489: aload 6
    //   491: iconst_0
    //   492: invokevirtual 620	com/tencent/mm/plugin/u/j:setIsOnlineVideoType	(Z)V
    //   495: aload_0
    //   496: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   499: astore 6
    //   501: aload 6
    //   503: ifnull +9 -> 512
    //   506: aload 6
    //   508: invokevirtual 622	com/tencent/mm/plugin/u/j:prepare	()Z
    //   511: pop
    //   512: aload_0
    //   513: lload_1
    //   514: putfield 307	com/tencent/mm/plugin/vlog/player/k:THh	J
    //   517: ldc 138
    //   519: new 140	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   526: aload_0
    //   527: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   530: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: ldc_w 624
    //   536: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload_0
    //   546: getfield 121	com/tencent/mm/plugin/vlog/player/k:UdK	Ljava/lang/Object;
    //   549: astore 6
    //   551: aload 6
    //   553: monitorenter
    //   554: aload_0
    //   555: getfield 121	com/tencent/mm/plugin/vlog/player/k:UdK	Ljava/lang/Object;
    //   558: invokevirtual 627	java/lang/Object:wait	()V
    //   561: getstatic 633	kotlin/ah:aiuX	Lkotlin/ah;
    //   564: astore 7
    //   566: aload 6
    //   568: monitorexit
    //   569: aload_0
    //   570: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   573: checkcast 458	com/tencent/mm/plugin/vlog/model/ak
    //   576: getfield 461	com/tencent/mm/plugin/vlog/model/ak:Ubf	J
    //   579: lload_1
    //   580: ladd
    //   581: l2i
    //   582: istore_3
    //   583: iload_3
    //   584: ifle +615 -> 1199
    //   587: aload_0
    //   588: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   591: astore 6
    //   593: aload 6
    //   595: ifnull +9 -> 604
    //   598: aload 6
    //   600: iload_3
    //   601: invokevirtual 636	com/tencent/mm/plugin/u/j:seek	(I)V
    //   604: aload_0
    //   605: getfield 123	com/tencent/mm/plugin/vlog/player/k:UdL	Ljava/lang/Object;
    //   608: astore 6
    //   610: aload 6
    //   612: monitorenter
    //   613: ldc 138
    //   615: new 140	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   622: aload_0
    //   623: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   626: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   629: ldc_w 638
    //   632: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload_3
    //   636: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload_0
    //   646: getfield 123	com/tencent/mm/plugin/vlog/player/k:UdL	Ljava/lang/Object;
    //   649: ldc2_w 639
    //   652: invokevirtual 642	java/lang/Object:wait	(J)V
    //   655: getstatic 633	kotlin/ah:aiuX	Lkotlin/ah;
    //   658: astore 7
    //   660: aload 6
    //   662: monitorexit
    //   663: ldc 138
    //   665: new 140	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   672: aload_0
    //   673: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   676: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   679: ldc_w 644
    //   682: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: ldc 138
    //   693: new 140	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   700: aload_0
    //   701: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   704: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: ldc_w 646
    //   710: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: lload 4
    //   715: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   718: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   721: ldc_w 258
    //   724: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: ldc_w 569
    //   736: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   739: return
    //   740: aload_0
    //   741: getfield 413	com/tencent/mm/plugin/vlog/player/b:width	I
    //   744: bipush 16
    //   746: irem
    //   747: ifne +13 -> 760
    //   750: aload_0
    //   751: getfield 417	com/tencent/mm/plugin/vlog/player/b:height	I
    //   754: bipush 16
    //   756: irem
    //   757: ifeq +268 -> 1025
    //   760: getstatic 394	com/tencent/mm/plugin/vlog/player/e:Udl	Lcom/tencent/mm/plugin/vlog/player/e;
    //   763: astore 6
    //   765: aload_0
    //   766: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   769: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   772: invokestatic 398	com/tencent/mm/plugin/vlog/player/e:bfl	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   775: astore 6
    //   777: aload 6
    //   779: ifnull +529 -> 1308
    //   782: aload 6
    //   784: getfield 420	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   787: iflt +521 -> 1308
    //   790: aload 6
    //   792: getfield 424	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   795: iflt +513 -> 1308
    //   798: aload_0
    //   799: getfield 429	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   802: iflt +506 -> 1308
    //   805: aload 6
    //   807: getfield 432	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   810: iflt +498 -> 1308
    //   813: ldc 138
    //   815: ldc_w 648
    //   818: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload_0
    //   822: aload 6
    //   824: getfield 406	com/tencent/mm/plugin/vlog/player/a:hYK	I
    //   827: invokevirtual 409	com/tencent/mm/plugin/vlog/player/k:th	(I)V
    //   830: aload_0
    //   831: aload 6
    //   833: getfield 412	com/tencent/mm/plugin/vlog/player/a:width	I
    //   836: putfield 413	com/tencent/mm/plugin/vlog/player/b:width	I
    //   839: aload_0
    //   840: aload 6
    //   842: getfield 416	com/tencent/mm/plugin/vlog/player/a:height	I
    //   845: putfield 417	com/tencent/mm/plugin/vlog/player/b:height	I
    //   848: aload_0
    //   849: aload 6
    //   851: getfield 420	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   854: putfield 421	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   857: aload_0
    //   858: aload 6
    //   860: getfield 424	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   863: putfield 425	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   866: aload_0
    //   867: aload 6
    //   869: getfield 428	com/tencent/mm/plugin/vlog/player/a:cropRight	I
    //   872: putfield 429	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   875: aload_0
    //   876: aload 6
    //   878: getfield 432	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   881: putfield 433	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   884: ldc 138
    //   886: new 140	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   893: aload_0
    //   894: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   897: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   900: bipush 32
    //   902: invokevirtual 152	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   905: aload_0
    //   906: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   909: getfield 160	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   912: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: ldc_w 650
    //   918: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: aload_0
    //   922: getfield 421	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   925: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   928: ldc_w 652
    //   931: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_0
    //   935: getfield 425	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   938: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   941: ldc_w 652
    //   944: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload_0
    //   948: getfield 429	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   951: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: ldc_w 652
    //   957: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload_0
    //   961: getfield 433	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   964: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   967: ldc_w 654
    //   970: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload_0
    //   974: getfield 413	com/tencent/mm/plugin/vlog/player/b:width	I
    //   977: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   980: ldc_w 656
    //   983: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_0
    //   987: getfield 417	com/tencent/mm/plugin/vlog/player/b:height	I
    //   990: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   993: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: iconst_1
    //   1000: istore_3
    //   1001: iload_3
    //   1002: ifne -673 -> 329
    //   1005: getstatic 662	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   1008: new 664	com/tencent/mm/plugin/vlog/player/k$$ExternalSyntheticLambda0
    //   1011: dup
    //   1012: aload_0
    //   1013: invokespecial 665	com/tencent/mm/plugin/vlog/player/k$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/vlog/player/k;)V
    //   1016: ldc_w 667
    //   1019: invokeinterface 673 3 0
    //   1024: pop
    //   1025: aload_0
    //   1026: iconst_1
    //   1027: putfield 587	com/tencent/mm/plugin/vlog/player/k:UdO	Z
    //   1030: goto -701 -> 329
    //   1033: astore 7
    //   1035: ldc 138
    //   1037: aload 7
    //   1039: checkcast 269	java/lang/Throwable
    //   1042: new 140	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1049: aload_0
    //   1050: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   1053: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1056: ldc_w 675
    //   1059: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: iconst_0
    //   1066: anewarray 117	java/lang/Object
    //   1069: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1072: goto -511 -> 561
    //   1075: astore 7
    //   1077: aload 6
    //   1079: monitorexit
    //   1080: ldc_w 569
    //   1083: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1086: aload 7
    //   1088: athrow
    //   1089: astore 6
    //   1091: ldc 138
    //   1093: aload 6
    //   1095: checkcast 269	java/lang/Throwable
    //   1098: new 140	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1105: aload_0
    //   1106: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   1109: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1112: ldc_w 677
    //   1115: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: iconst_1
    //   1122: anewarray 117	java/lang/Object
    //   1125: dup
    //   1126: iconst_0
    //   1127: aload 6
    //   1129: invokevirtual 680	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1132: aastore
    //   1133: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1136: ldc_w 569
    //   1139: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1142: return
    //   1143: astore 7
    //   1145: ldc 138
    //   1147: aload 7
    //   1149: checkcast 269	java/lang/Throwable
    //   1152: new 140	java/lang/StringBuilder
    //   1155: dup
    //   1156: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1159: aload_0
    //   1160: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   1163: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: ldc_w 682
    //   1169: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: iconst_0
    //   1176: anewarray 117	java/lang/Object
    //   1179: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1182: goto -527 -> 655
    //   1185: astore 7
    //   1187: aload 6
    //   1189: monitorexit
    //   1190: ldc_w 569
    //   1193: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1196: aload 7
    //   1198: athrow
    //   1199: ldc 138
    //   1201: new 140	java/lang/StringBuilder
    //   1204: dup
    //   1205: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1208: aload_0
    //   1209: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   1212: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1215: ldc_w 684
    //   1218: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: iload_3
    //   1222: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: ldc_w 686
    //   1228: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1237: aload_0
    //   1238: iconst_1
    //   1239: putfield 292	com/tencent/mm/plugin/vlog/player/k:UdM	Z
    //   1242: aload_0
    //   1243: getfield 301	com/tencent/mm/plugin/vlog/player/k:ykf	Lcom/tencent/mm/plugin/u/j;
    //   1246: astore 6
    //   1248: aload 6
    //   1250: ifnull +53 -> 1303
    //   1253: aload 6
    //   1255: invokevirtual 355	com/tencent/mm/plugin/u/j:isPlaying	()Z
    //   1258: ifne +45 -> 1303
    //   1261: iconst_1
    //   1262: istore_3
    //   1263: iload_3
    //   1264: ifeq -573 -> 691
    //   1267: ldc 138
    //   1269: new 140	java/lang/StringBuilder
    //   1272: dup
    //   1273: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1276: aload_0
    //   1277: invokevirtual 145	com/tencent/mm/plugin/vlog/player/k:hashCode	()I
    //   1280: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1283: ldc_w 688
    //   1286: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1292: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1295: aload_0
    //   1296: invokespecial 359	com/tencent/mm/plugin/vlog/player/k:start	()Z
    //   1299: pop
    //   1300: goto -609 -> 691
    //   1303: iconst_0
    //   1304: istore_3
    //   1305: goto -42 -> 1263
    //   1308: iconst_0
    //   1309: istore_3
    //   1310: goto -309 -> 1001
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1313	0	this	k
    //   0	1313	1	paramLong	long
    //   582	728	3	i	int
    //   36	678	4	l	long
    //   1089	99	6	localException1	Exception
    //   1246	8	6	localj	com.tencent.mm.plugin.u.j
    //   564	95	7	localah	ah
    //   1033	5	7	localException2	Exception
    //   1075	12	7	localObject2	Object
    //   1143	5	7	localException3	Exception
    //   1185	12	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   554	561	1033	java/lang/Exception
    //   554	561	1075	finally
    //   561	566	1075	finally
    //   1035	1072	1075	finally
    //   329	384	1089	java/lang/Exception
    //   389	401	1089	java/lang/Exception
    //   401	407	1089	java/lang/Exception
    //   412	421	1089	java/lang/Exception
    //   421	427	1089	java/lang/Exception
    //   432	441	1089	java/lang/Exception
    //   441	447	1089	java/lang/Exception
    //   452	461	1089	java/lang/Exception
    //   461	467	1089	java/lang/Exception
    //   472	478	1089	java/lang/Exception
    //   478	484	1089	java/lang/Exception
    //   489	495	1089	java/lang/Exception
    //   495	501	1089	java/lang/Exception
    //   506	512	1089	java/lang/Exception
    //   512	554	1089	java/lang/Exception
    //   566	583	1089	java/lang/Exception
    //   587	593	1089	java/lang/Exception
    //   598	604	1089	java/lang/Exception
    //   604	613	1089	java/lang/Exception
    //   660	691	1089	java/lang/Exception
    //   691	733	1089	java/lang/Exception
    //   1077	1089	1089	java/lang/Exception
    //   1187	1199	1089	java/lang/Exception
    //   1199	1248	1089	java/lang/Exception
    //   1253	1261	1089	java/lang/Exception
    //   1267	1300	1089	java/lang/Exception
    //   613	655	1143	java/lang/Exception
    //   613	655	1185	finally
    //   655	660	1185	finally
    //   1145	1182	1185	finally
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "checker", "Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<MediaFormat, com.tencent.mm.media.i.d, ah>
  {
    b(k paramk, long paramLong, com.tencent.mm.media.f.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.k
 * JD-Core Version:    0.7.0.1
 */