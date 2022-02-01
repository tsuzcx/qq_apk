package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.media.h.e;
import com.tencent.mm.media.h.e.c;
import com.tencent.mm.media.h.e.d;
import com.tencent.mm.media.h.e.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.n.n;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogVideoPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Z)V", "canPlaying", "didCheckCrop", "lastSurfaceUpdatedTime", "", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "prepareLock", "Ljava/lang/Object;", "seekLock", "seekTime", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoIsPrepared", "checkCropRect", "", "enableMute", "isMirror", "isOES", "isPlaying", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "release", "resume", "start", "stop", "Companion", "plugin-vlog_release"})
public final class m
  extends b
{
  public static final m.a AqF;
  private final Object AqA;
  private final Object AqB;
  private volatile boolean AqC;
  private volatile boolean AqD;
  private boolean AqE;
  private long Aqz;
  private long kVR;
  private com.tencent.mm.plugin.o.j prd;
  private com.tencent.mm.plugin.o.d prn;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(111004);
    AqF = new m.a((byte)0);
    AppMethodBeat.o(111004);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, z paramz, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, (com.tencent.mm.plugin.vlog.model.i)paramz, paramBoolean);
    AppMethodBeat.i(111003);
    this.AqA = new Object();
    this.AqB = new Object();
    this.prn = ((com.tencent.mm.plugin.o.d)new c(this));
    AppMethodBeat.o(111003);
  }
  
  private boolean start()
  {
    boolean bool = false;
    AppMethodBeat.i(110994);
    if ((this.prd != null) && (this.AqD))
    {
      Object localObject = "%d player start surface[%b], seekTime:" + this.Aqz;
      i = hashCode();
      if (this.surface != null) {
        bool = true;
      }
      ac.i("MicroMsg.VLogVideoPlayer", (String)localObject, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = this.prd;
      if (localObject != null) {
        ((com.tencent.mm.plugin.o.j)localObject).start();
      }
      AppMethodBeat.o(110994);
      return true;
    }
    int i = hashCode();
    if (this.prd == null) {}
    for (bool = true;; bool = false)
    {
      ac.w("MicroMsg.VLogVideoPlayer", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Boolean.valueOf(this.AqD) });
      AppMethodBeat.o(110994);
      return false;
    }
  }
  
  public final void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(111000);
    this.AqC = true;
    Object localObject = this.prd;
    if ((localObject != null) && (!((com.tencent.mm.plugin.o.j)localObject).isPlaying()))
    {
      ac.i("MicroMsg.VLogVideoPlayer", hashCode() + " playing start now");
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
        ac.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " updateTexImage error", new Object[0]);
      }
    }
    AppMethodBeat.o(111000);
  }
  
  public final boolean isOES()
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(110997);
    com.tencent.mm.plugin.o.j localj = this.prd;
    if (localj != null)
    {
      if (localj.isPlaying() == true)
      {
        localj = this.prd;
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
    long l1 = bs.Gn();
    if ((bs.isNullOrNil(this.Apt.path)) || (!com.tencent.mm.vfs.i.eA(this.Apt.path))) {
      ac.e("MicroMsg.VLogVideoPlayer", hashCode() + " prepare file not exist or is null");
    }
    this.aSG = true;
    Object localObject1 = f.ApY;
    localObject1 = f.aym(this.Apt.path);
    if (localObject1 != null)
    {
      ac.i("MicroMsg.VLogVideoPlayer", "prepare get info from cache");
      this.duc = ((a)localObject1).duc;
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
      ac.i("MicroMsg.VLogVideoPlayer", "prepare finish get from cache");
      localObject1 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(this.duc).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.Apt.startTime).append(", endTime = ").append(this.Apt.endTime).append(", videoStartTime = ");
      localObject2 = this.Apt;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(111001);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        ac.i("MicroMsg.VLogVideoPlayer", ((z)localObject2).Apa + ", videoEndTime = " + ((z)this.Apt).Apb + ", cost:" + bs.aO(l1) + "ms");
        AppMethodBeat.o(111001);
        return;
      }
    }
    for (;;)
    {
      try
      {
        ac.m("MicroMsg.VLogVideoPlayer", hashCode() + " start prepare " + this.Apt.path, new Object[0]);
        this.duc = -1;
        long l2 = bs.Gn();
        localObject1 = new MediaExtractor();
        ((MediaExtractor)localObject1).setDataSource(this.Apt.path);
        int j = ((MediaExtractor)localObject1).getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject2 = ((MediaExtractor)localObject1).getTrackFormat(i);
          String str = ((MediaFormat)localObject2).getString("mime");
          k.g(str, "mediaFormat.getString(MediaFormat.KEY_MIME)");
          if (!n.nb(str, "video")) {
            break label852;
          }
          this.width = ((MediaFormat)localObject2).getInteger("width");
          this.height = ((MediaFormat)localObject2).getInteger("height");
          if ((com.tencent.mm.compatible.util.d.kZ(23)) && (((MediaFormat)localObject2).containsKey("rotation-degrees"))) {
            this.duc = ((MediaFormat)localObject2).getInteger("rotation-degrees");
          }
        }
        ((MediaExtractor)localObject1).release();
        ac.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get width/height cost:" + bs.aO(l2) + "ms, try-get rotate:" + this.duc);
        if (this.duc < 0)
        {
          l2 = bs.Gn();
          this.duc = SightVideoJNI.getMp4RotateVFS(this.Apt.path);
          ac.i("MicroMsg.VLogVideoPlayer", hashCode() + " prepare video get rotate cost:" + bs.aO(l2) + "ms");
        }
        if (this.duc != 90) {
          break label859;
        }
        this.duc = 3;
        localObject1 = new StringBuilder().append(hashCode()).append(" prepare video, rotate = ").append(this.duc).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.Apt.startTime).append(", endTime = ").append(this.Apt.endTime).append(", videoStartTime = ");
        localObject2 = this.Apt;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(111001);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, hashCode() + " prepare error", new Object[0]);
        AppMethodBeat.o(111001);
        return;
      }
      label852:
      i += 1;
      continue;
      label859:
      if (this.duc == 180) {
        this.duc = 2;
      } else if (this.duc == 270) {
        this.duc = 1;
      }
    }
    ac.i("MicroMsg.VLogVideoPlayer", ((z)localObject2).Apa + ", videoEndTime = " + ((z)this.Apt).Apb + ", cost:" + bs.aO(l1) + "ms");
    f localf = f.ApY;
    f.o(this.Apt.path, this.width, this.height, this.duc);
    AppMethodBeat.o(111001);
  }
  
  public final void release()
  {
    AppMethodBeat.i(110996);
    ac.i("MicroMsg.VLogVideoPlayer", "%d player release [%s]", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    this.Apr = false;
    Object localObject = this.prd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).a(null);
    }
    localObject = this.prd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).stop();
    }
    localObject = this.prd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).release();
    }
    this.prd = null;
    this.AqD = false;
    this.kVR = 0L;
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
    this.aSG = false;
    AppMethodBeat.o(110996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(110998);
    com.tencent.mm.plugin.o.j localj = this.prd;
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
  
  public final void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(111002);
    if (this.hdh != paramBoolean)
    {
      com.tencent.mm.plugin.o.j localj = this.prd;
      if (localj != null) {
        localj.setMute(paramBoolean);
      }
    }
    this.hdh = paramBoolean;
    AppMethodBeat.o(111002);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(110995);
    this.Apr = false;
    Object localObject = this.prd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).a(null);
    }
    localObject = this.prd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).stop();
    }
    localObject = this.prd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.o.j)localObject).release();
    }
    this.prd = null;
    this.AqD = false;
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
  public final void yJ(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 457
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 431	com/tencent/mm/plugin/vlog/player/b:Apr	Z
    //   10: ifeq +18 -> 28
    //   13: ldc 166
    //   15: ldc_w 459
    //   18: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 457
    //   24: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 431	com/tencent/mm/plugin/vlog/player/b:Apr	Z
    //   33: invokestatic 237	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   36: lstore 4
    //   38: ldc 166
    //   40: new 143	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 461
    //   47: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 464	com/tencent/mm/plugin/vlog/player/b:Aps	I
    //   54: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 466
    //   60: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: lload_1
    //   64: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 468
    //   70: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 280	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   77: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: iconst_2
    //   84: anewarray 112	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   93: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_0
    //   100: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   103: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 182	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   114: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   117: invokestatic 249	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   120: ifne +16 -> 136
    //   123: aload_0
    //   124: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   127: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   130: invokestatic 254	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   133: ifne +32 -> 165
    //   136: ldc 166
    //   138: ldc_w 470
    //   141: iconst_1
    //   142: anewarray 112	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   151: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aastore
    //   155: invokestatic 191	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: ldc_w 457
    //   161: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: ldc 166
    //   167: ldc_w 472
    //   170: iconst_2
    //   171: anewarray 112	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_0
    //   177: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   180: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload_0
    //   187: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   190: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 182	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 474	com/tencent/mm/plugin/vlog/player/m:AqE	Z
    //   201: ifne +128 -> 329
    //   204: ldc 166
    //   206: new 143	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   213: aload_0
    //   214: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   217: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: bipush 32
    //   222: invokevirtual 477	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   229: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   232: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 479
    //   238: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 284	com/tencent/mm/plugin/vlog/player/b:width	I
    //   245: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc_w 481
    //   251: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 288	com/tencent/mm/plugin/vlog/player/b:height	I
    //   258: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: getfield 284	com/tencent/mm/plugin/vlog/player/b:width	I
    //   271: ifeq +10 -> 281
    //   274: aload_0
    //   275: getfield 288	com/tencent/mm/plugin/vlog/player/b:height	I
    //   278: ifne +377 -> 655
    //   281: ldc 166
    //   283: new 143	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   290: aload_0
    //   291: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   294: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: bipush 32
    //   299: invokevirtual 477	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   306: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   309: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 483
    //   315: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_0
    //   325: iconst_0
    //   326: putfield 474	com/tencent/mm/plugin/vlog/player/m:AqE	Z
    //   329: aload_0
    //   330: new 216	android/graphics/SurfaceTexture
    //   333: dup
    //   334: aload_0
    //   335: getfield 464	com/tencent/mm/plugin/vlog/player/b:Aps	I
    //   338: invokespecial 485	android/graphics/SurfaceTexture:<init>	(I)V
    //   341: putfield 214	com/tencent/mm/plugin/vlog/player/m:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   344: aload_0
    //   345: new 441	android/view/Surface
    //   348: dup
    //   349: aload_0
    //   350: getfield 214	com/tencent/mm/plugin/vlog/player/m:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   353: invokespecial 488	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   356: putfield 164	com/tencent/mm/plugin/vlog/player/m:surface	Landroid/view/Surface;
    //   359: aload_0
    //   360: iconst_0
    //   361: putfield 132	com/tencent/mm/plugin/vlog/player/m:AqD	Z
    //   364: aload_0
    //   365: new 184	com/tencent/mm/plugin/o/j
    //   368: dup
    //   369: invokestatic 494	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   372: invokespecial 497	com/tencent/mm/plugin/o/j:<init>	(Landroid/os/Looper;)V
    //   375: putfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   378: aload_0
    //   379: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   382: astore 6
    //   384: aload 6
    //   386: ifnull +15 -> 401
    //   389: aload 6
    //   391: aload_0
    //   392: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   395: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   398: invokevirtual 500	com/tencent/mm/plugin/o/j:setPath	(Ljava/lang/String;)V
    //   401: aload_0
    //   402: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   405: astore 6
    //   407: aload 6
    //   409: ifnull +12 -> 421
    //   412: aload 6
    //   414: aload_0
    //   415: getfield 125	com/tencent/mm/plugin/vlog/player/m:prn	Lcom/tencent/mm/plugin/o/d;
    //   418: invokevirtual 434	com/tencent/mm/plugin/o/j:a	(Lcom/tencent/mm/plugin/o/d;)V
    //   421: aload_0
    //   422: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +12 -> 441
    //   432: aload 6
    //   434: aload_0
    //   435: getfield 164	com/tencent/mm/plugin/vlog/player/m:surface	Landroid/view/Surface;
    //   438: invokevirtual 504	com/tencent/mm/plugin/o/j:setSurface	(Landroid/view/Surface;)V
    //   441: aload_0
    //   442: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   445: astore 6
    //   447: aload 6
    //   449: ifnull +12 -> 461
    //   452: aload 6
    //   454: aload_0
    //   455: getfield 450	com/tencent/mm/plugin/vlog/player/b:hdh	Z
    //   458: invokevirtual 453	com/tencent/mm/plugin/o/j:setMute	(Z)V
    //   461: aload_0
    //   462: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   465: astore 6
    //   467: aload 6
    //   469: ifnull +9 -> 478
    //   472: aload 6
    //   474: iconst_0
    //   475: invokevirtual 507	com/tencent/mm/plugin/o/j:setNeedResetExtractor	(Z)V
    //   478: aload_0
    //   479: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   482: astore 6
    //   484: aload 6
    //   486: ifnull +9 -> 495
    //   489: aload 6
    //   491: iconst_0
    //   492: invokevirtual 510	com/tencent/mm/plugin/o/j:setIsOnlineVideoType	(Z)V
    //   495: aload_0
    //   496: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   499: astore 6
    //   501: aload 6
    //   503: ifnull +9 -> 512
    //   506: aload 6
    //   508: invokevirtual 513	com/tencent/mm/plugin/o/j:cIc	()Z
    //   511: pop
    //   512: aload_0
    //   513: lload_1
    //   514: putfield 150	com/tencent/mm/plugin/vlog/player/m:Aqz	J
    //   517: ldc 166
    //   519: new 143	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   526: aload_0
    //   527: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   530: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: ldc_w 515
    //   536: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload_0
    //   546: getfield 116	com/tencent/mm/plugin/vlog/player/m:AqA	Ljava/lang/Object;
    //   549: astore 6
    //   551: aload 6
    //   553: monitorenter
    //   554: aload_0
    //   555: getfield 116	com/tencent/mm/plugin/vlog/player/m:AqA	Ljava/lang/Object;
    //   558: invokevirtual 518	java/lang/Object:wait	()V
    //   561: getstatic 524	d/y:KTp	Ld/y;
    //   564: astore 7
    //   566: aload 6
    //   568: monitorexit
    //   569: aload_0
    //   570: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   573: astore 6
    //   575: aload 6
    //   577: ifnonnull +435 -> 1012
    //   580: new 326	d/v
    //   583: dup
    //   584: ldc_w 328
    //   587: invokespecial 329	d/v:<init>	(Ljava/lang/String;)V
    //   590: astore 6
    //   592: ldc_w 457
    //   595: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   598: aload 6
    //   600: athrow
    //   601: astore 6
    //   603: ldc 166
    //   605: aload 6
    //   607: checkcast 221	java/lang/Throwable
    //   610: new 143	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   617: aload_0
    //   618: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   621: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: ldc_w 526
    //   627: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: iconst_1
    //   634: anewarray 112	java/lang/Object
    //   637: dup
    //   638: iconst_0
    //   639: aload 6
    //   641: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   644: aastore
    //   645: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: ldc_w 457
    //   651: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   654: return
    //   655: aload_0
    //   656: getfield 284	com/tencent/mm/plugin/vlog/player/b:width	I
    //   659: bipush 16
    //   661: irem
    //   662: ifne +13 -> 675
    //   665: aload_0
    //   666: getfield 288	com/tencent/mm/plugin/vlog/player/b:height	I
    //   669: bipush 16
    //   671: irem
    //   672: ifeq +271 -> 943
    //   675: getstatic 267	com/tencent/mm/plugin/vlog/player/f:ApY	Lcom/tencent/mm/plugin/vlog/player/f;
    //   678: astore 6
    //   680: aload_0
    //   681: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   684: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   687: invokestatic 271	com/tencent/mm/plugin/vlog/player/f:aym	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   690: astore 6
    //   692: aload 6
    //   694: ifnull +257 -> 951
    //   697: aload 6
    //   699: getfield 291	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   702: iflt +249 -> 951
    //   705: aload 6
    //   707: getfield 295	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   710: iflt +241 -> 951
    //   713: aload_0
    //   714: getfield 300	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   717: iflt +234 -> 951
    //   720: aload 6
    //   722: getfield 303	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   725: iflt +226 -> 951
    //   728: ldc 166
    //   730: ldc_w 531
    //   733: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: aload_0
    //   737: aload 6
    //   739: getfield 279	com/tencent/mm/plugin/vlog/player/a:duc	I
    //   742: putfield 280	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   745: aload_0
    //   746: aload 6
    //   748: getfield 283	com/tencent/mm/plugin/vlog/player/a:width	I
    //   751: putfield 284	com/tencent/mm/plugin/vlog/player/b:width	I
    //   754: aload_0
    //   755: aload 6
    //   757: getfield 287	com/tencent/mm/plugin/vlog/player/a:height	I
    //   760: putfield 288	com/tencent/mm/plugin/vlog/player/b:height	I
    //   763: aload_0
    //   764: aload 6
    //   766: getfield 291	com/tencent/mm/plugin/vlog/player/a:cropLeft	I
    //   769: putfield 292	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   772: aload_0
    //   773: aload 6
    //   775: getfield 295	com/tencent/mm/plugin/vlog/player/a:cropTop	I
    //   778: putfield 296	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   781: aload_0
    //   782: aload 6
    //   784: getfield 299	com/tencent/mm/plugin/vlog/player/a:cropRight	I
    //   787: putfield 300	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   790: aload_0
    //   791: aload 6
    //   793: getfield 303	com/tencent/mm/plugin/vlog/player/a:cropBottom	I
    //   796: putfield 304	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   799: ldc 166
    //   801: new 143	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   808: aload_0
    //   809: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   812: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   815: bipush 32
    //   817: invokevirtual 477	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   820: aload_0
    //   821: getfield 241	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   824: getfield 245	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   827: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 533
    //   833: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_0
    //   837: getfield 292	com/tencent/mm/plugin/vlog/player/b:cropLeft	I
    //   840: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 535
    //   846: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_0
    //   850: getfield 296	com/tencent/mm/plugin/vlog/player/b:cropTop	I
    //   853: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc_w 535
    //   859: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_0
    //   863: getfield 300	com/tencent/mm/plugin/vlog/player/b:cropRight	I
    //   866: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   869: ldc_w 535
    //   872: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload_0
    //   876: getfield 304	com/tencent/mm/plugin/vlog/player/b:cropBottom	I
    //   879: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: ldc_w 537
    //   885: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload_0
    //   889: getfield 284	com/tencent/mm/plugin/vlog/player/b:width	I
    //   892: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   895: ldc_w 539
    //   898: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload_0
    //   902: getfield 288	com/tencent/mm/plugin/vlog/player/b:height	I
    //   905: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   908: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: iconst_1
    //   915: istore_3
    //   916: iload_3
    //   917: ifne -588 -> 329
    //   920: getstatic 545	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   923: new 8	com/tencent/mm/plugin/vlog/player/m$b
    //   926: dup
    //   927: aload_0
    //   928: invokespecial 546	com/tencent/mm/plugin/vlog/player/m$b:<init>	(Lcom/tencent/mm/plugin/vlog/player/m;)V
    //   931: checkcast 548	java/lang/Runnable
    //   934: ldc_w 550
    //   937: invokeinterface 556 3 0
    //   942: pop
    //   943: aload_0
    //   944: iconst_1
    //   945: putfield 474	com/tencent/mm/plugin/vlog/player/m:AqE	Z
    //   948: goto -619 -> 329
    //   951: iconst_0
    //   952: istore_3
    //   953: goto -37 -> 916
    //   956: astore 7
    //   958: ldc 166
    //   960: aload 7
    //   962: checkcast 221	java/lang/Throwable
    //   965: new 143	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   972: aload_0
    //   973: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   976: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: ldc_w 558
    //   982: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: iconst_0
    //   989: anewarray 112	java/lang/Object
    //   992: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   995: goto -434 -> 561
    //   998: astore 7
    //   1000: aload 6
    //   1002: monitorexit
    //   1003: ldc_w 457
    //   1006: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1009: aload 7
    //   1011: athrow
    //   1012: aload 6
    //   1014: checkcast 331	com/tencent/mm/plugin/vlog/model/z
    //   1017: getfield 334	com/tencent/mm/plugin/vlog/model/z:Apa	J
    //   1020: lload_1
    //   1021: ladd
    //   1022: l2i
    //   1023: istore_3
    //   1024: iload_3
    //   1025: ifle +212 -> 1237
    //   1028: aload_0
    //   1029: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   1032: astore 6
    //   1034: aload 6
    //   1036: ifnull +9 -> 1045
    //   1039: aload 6
    //   1041: iload_3
    //   1042: invokevirtual 561	com/tencent/mm/plugin/o/j:seek	(I)V
    //   1045: aload_0
    //   1046: getfield 118	com/tencent/mm/plugin/vlog/player/m:AqB	Ljava/lang/Object;
    //   1049: astore 6
    //   1051: aload 6
    //   1053: monitorenter
    //   1054: ldc 166
    //   1056: new 143	java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1063: aload_0
    //   1064: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   1067: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1070: ldc_w 563
    //   1073: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: iload_3
    //   1077: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1080: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1083: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1086: aload_0
    //   1087: getfield 118	com/tencent/mm/plugin/vlog/player/m:AqB	Ljava/lang/Object;
    //   1090: ldc2_w 564
    //   1093: invokevirtual 567	java/lang/Object:wait	(J)V
    //   1096: getstatic 524	d/y:KTp	Ld/y;
    //   1099: astore 7
    //   1101: aload 6
    //   1103: monitorexit
    //   1104: ldc 166
    //   1106: new 143	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1113: aload_0
    //   1114: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   1117: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 569
    //   1123: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1132: ldc 166
    //   1134: new 143	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1141: aload_0
    //   1142: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   1145: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1148: ldc_w 571
    //   1151: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: lload 4
    //   1156: invokestatic 345	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   1159: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1162: ldc_w 347
    //   1165: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1171: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1174: ldc_w 457
    //   1177: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1180: return
    //   1181: astore 7
    //   1183: ldc 166
    //   1185: aload 7
    //   1187: checkcast 221	java/lang/Throwable
    //   1190: new 143	java/lang/StringBuilder
    //   1193: dup
    //   1194: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1197: aload_0
    //   1198: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   1201: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: ldc_w 573
    //   1207: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1213: iconst_0
    //   1214: anewarray 112	java/lang/Object
    //   1217: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1220: goto -124 -> 1096
    //   1223: astore 7
    //   1225: aload 6
    //   1227: monitorexit
    //   1228: ldc_w 457
    //   1231: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1234: aload 7
    //   1236: athrow
    //   1237: ldc 166
    //   1239: new 143	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1246: aload_0
    //   1247: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   1250: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: ldc_w 575
    //   1256: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: iload_3
    //   1260: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1263: ldc_w 577
    //   1266: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1275: aload_0
    //   1276: iconst_1
    //   1277: putfield 129	com/tencent/mm/plugin/vlog/player/m:AqC	Z
    //   1280: aload_0
    //   1281: getfield 138	com/tencent/mm/plugin/vlog/player/m:prd	Lcom/tencent/mm/plugin/o/j;
    //   1284: astore 6
    //   1286: aload 6
    //   1288: ifnull -156 -> 1132
    //   1291: aload 6
    //   1293: invokevirtual 198	com/tencent/mm/plugin/o/j:isPlaying	()Z
    //   1296: ifne -164 -> 1132
    //   1299: ldc 166
    //   1301: new 143	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1308: aload_0
    //   1309: invokevirtual 162	com/tencent/mm/plugin/vlog/player/m:hashCode	()I
    //   1312: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1315: ldc_w 579
    //   1318: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 210	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1327: aload_0
    //   1328: invokespecial 212	com/tencent/mm/plugin/vlog/player/m:start	()Z
    //   1331: pop
    //   1332: goto -200 -> 1132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1335	0	this	m
    //   0	1335	1	paramLong	long
    //   915	345	3	i	int
    //   36	1119	4	l	long
    //   601	39	6	localException1	Exception
    //   564	1	7	localy1	y
    //   956	5	7	localException2	Exception
    //   998	12	7	localObject3	Object
    //   1099	1	7	localy2	y
    //   1181	5	7	localException3	Exception
    //   1223	12	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   329	384	601	java/lang/Exception
    //   389	401	601	java/lang/Exception
    //   401	407	601	java/lang/Exception
    //   412	421	601	java/lang/Exception
    //   421	427	601	java/lang/Exception
    //   432	441	601	java/lang/Exception
    //   441	447	601	java/lang/Exception
    //   452	461	601	java/lang/Exception
    //   461	467	601	java/lang/Exception
    //   472	478	601	java/lang/Exception
    //   478	484	601	java/lang/Exception
    //   489	495	601	java/lang/Exception
    //   495	501	601	java/lang/Exception
    //   506	512	601	java/lang/Exception
    //   512	554	601	java/lang/Exception
    //   566	575	601	java/lang/Exception
    //   580	601	601	java/lang/Exception
    //   1000	1012	601	java/lang/Exception
    //   1012	1024	601	java/lang/Exception
    //   1028	1034	601	java/lang/Exception
    //   1039	1045	601	java/lang/Exception
    //   1045	1054	601	java/lang/Exception
    //   1101	1132	601	java/lang/Exception
    //   1132	1174	601	java/lang/Exception
    //   1225	1237	601	java/lang/Exception
    //   1237	1286	601	java/lang/Exception
    //   1291	1332	601	java/lang/Exception
    //   554	561	956	java/lang/Exception
    //   554	561	998	finally
    //   561	566	998	finally
    //   958	995	998	finally
    //   1054	1096	1181	java/lang/Exception
    //   1054	1096	1223	finally
    //   1096	1101	1223	finally
    //   1183	1220	1223	finally
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(110989);
      ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + ' ' + this.AqG.Apt.path + " start do check crop rect");
      final long l = bs.Gn();
      Object localObject = new com.tencent.mm.media.e.a(this.AqG.Apt.path);
      locale = new e((com.tencent.mm.media.e.a)localObject, (byte)0);
      localm = (d.g.a.m)new d.g.b.l(l) {};
      locale.fPF = localm;
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.compatible.util.d.kZ(23)) {
            continue;
          }
          localObject = (com.tencent.mm.media.c.f)new com.tencent.mm.media.c.j(locale.gTA.getDuration() / 1000, locale.gTA, (d.g.a.b)new e.c(locale));
          locale.gTw = ((com.tencent.mm.media.c.f)localObject);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace(locale.TAG, (Throwable)localException, "start check init decoder error", new Object[0]);
          com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.ata();
          localm.n(null, locale);
          continue;
        }
        locale.gTy = c.a("MediaCodecCheckVideoCropRect_decode", false, (d.g.a.a)new e.e(locale));
        ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + " checkCropRect finish cost " + bs.aO(l) + "ms");
        AppMethodBeat.o(110989);
        return;
        localObject = (com.tencent.mm.media.c.f)new com.tencent.mm.media.c.i(locale.gTA.getDuration() / 1000, locale.gTA, (d.g.a.b)new e.d(locale));
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/player/VLogVideoPlayer$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-vlog_release"})
  public static final class c
    implements com.tencent.mm.plugin.o.d
  {
    public final void X(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(110993);
      ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + " video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(110993);
    }
    
    public final void cfM()
    {
      AppMethodBeat.i(110992);
      Object localObject2 = this.AqG.hashCode() + " %s player seek done";
      ??? = m.d(this.AqG);
      if (??? != null) {
        ??? = ((com.tencent.mm.plugin.o.j)???).info();
      }
      for (;;)
      {
        ac.d("MicroMsg.VLogVideoPlayer", (String)localObject2, new Object[] { ??? });
        synchronized (m.e(this.AqG))
        {
          try
          {
            ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + " player seek notifyAll");
            m.e(this.AqG).notifyAll();
            localObject2 = y.KTp;
            AppMethodBeat.o(110992);
            return;
            ??? = null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, this.AqG.hashCode() + " notify seekLock error", new Object[0]);
            }
          }
        }
      }
    }
    
    public final void onCompletion() {}
    
    public final void onError(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(110991);
      ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + " onError what:" + paramInt1 + " error :" + paramInt2);
      AppMethodBeat.o(110991);
    }
    
    public final void rB()
    {
      AppMethodBeat.i(110990);
      ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + " onPrepared, canPlaying:" + m.a(this.AqG) + ", notify all");
      m.b(this.AqG);
      synchronized (m.c(this.AqG))
      {
        try
        {
          ac.i("MicroMsg.VLogVideoPlayer", this.AqG.hashCode() + " onPrepared notifyAll");
          m.c(this.AqG).notifyAll();
          y localy = y.KTp;
          AppMethodBeat.o(110990);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "prepare lock notify error", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.m
 * JD-Core Version:    0.7.0.1
 */