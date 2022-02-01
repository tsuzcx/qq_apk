package com.tencent.mm.plugin.thumbplayer.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.xlabeffect.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "", "()V", "TAG", "", "blur", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "currentMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "currentMediaInfoIndex", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "gradientBlur", "Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "gradientBlurContentOffsetPercent", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handlerThread", "Landroid/os/HandlerThread;", "hasGradientBlur", "", "height", "initFinished", "lastRenderTimestampMs", "", "lastRenderTimestampNs", "mediaInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFrameDraw", "Lkotlin/Function1;", "", "outputSizeChanged", "outputTexHeight", "outputTexIsInited", "outputTexWidth", "playerInfoProxy", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "getPlayerInfoProxy", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "setPlayerInfoProxy", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;)V", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "requestSnapShot", "scaleType", "screenOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "screenRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "snapshotCallback", "Landroid/graphics/Bitmap;", "surface", "Landroid/graphics/SurfaceTexture;", "totalDurationMs", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "videoHeight", "videoPlayTexture", "videoTexture", "videoWidth", "width", "allocOutputTexMem", "outputTexId", "attachSurface", "bindToPlayer", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "calcOutputTexSize", "checkCreateEffectManager", "clearEffects", "createEGLThread", "createGLEnvironment", "createOutputTexture", "createVideoTexture", "afterCreated", "Lkotlin/ParameterName;", "name", "detachSurface", "detachSurfaceImpl", "getEffectManager", "getVideoPlaySurfaceTexture", "init", "afterInit", "Lkotlin/Function0;", "onVideoPlayTextureUpdate", "timestampNs", "queue", "r", "refreshFrame", "timestamp", "release", "removePendingTasks", "requestSnapshot", "callback", "resetSnapshot", "selectMediaAtIndex", "index", "setBlurEffect", "blurRadius", "setBlurFadeEffectChain", "setBlurFadeEffectFromMediaList", "", "blurContentOffsetPercent", "setCurrentVideoSizeAndUpdateTimestampMs", "timestampMs", "setGradientBlurEffect", "contentOffsetPercent", "setMediaInfo", "mediaInfo", "setOnFrameDrawCallback", "setScaleType", "updateSize", "centerInside", "Landroid/graphics/Rect;", "target", "Companion", "PlayerInfoProxy", "plugin-thumbplayer_release"})
public final class g
{
  private static final int MRv;
  public static final g.a MRw;
  private EffectManager ANo;
  private SurfaceTexture FhU;
  private VLogDirector GhL;
  private boolean GhM;
  public b MQZ;
  public com.tencent.mm.plugin.thumbplayer.e.b MRa;
  private com.tencent.mm.media.g.d MRb;
  private SurfaceTexture MRc;
  private com.tencent.mm.media.j.b.e MRd;
  private com.tencent.mm.media.g.d MRe;
  private boolean MRf;
  private int MRg;
  private int MRh;
  private com.tencent.mm.xeffect.effect.l MRi;
  private ArrayList<com.tencent.mm.plugin.thumbplayer.e.d> MRj;
  public com.tencent.mm.plugin.thumbplayer.e.d MRk;
  private int MRl;
  public long MRm;
  private long MRn;
  private long MRo;
  private boolean MRp;
  private float MRq;
  private kotlin.g.a.b<? super Long, x> MRr;
  private volatile boolean MRs;
  public volatile boolean MRt;
  public kotlin.g.a.b<? super Bitmap, x> MRu;
  public final String TAG;
  private MMHandler handler;
  private HandlerThread handlerThread;
  private volatile int height;
  private int kYn;
  private c.b lav;
  public volatile int videoHeight;
  public volatile int videoWidth;
  private volatile int width;
  
  static
  {
    AppMethodBeat.i(192429);
    MRw = new g.a((byte)0);
    MRv = Color.parseColor("#4c4c4c");
    e.a locala = com.tencent.mm.plugin.xlabeffect.e.QQp;
    e.a.tryLoadLibrary();
    AppMethodBeat.o(192429);
  }
  
  public g()
  {
    AppMethodBeat.i(192424);
    this.TAG = ("MicroMsg.TPPlayerEffector@" + hashCode());
    this.MRa = new com.tencent.mm.plugin.thumbplayer.e.b();
    this.GhL = new VLogDirector();
    this.kYn = 1;
    this.MRj = new ArrayList();
    this.MRl = -1;
    this.MRm = -1L;
    this.MRn = -1L;
    this.MRo = -1L;
    this.MRq = -1.0F;
    AppMethodBeat.o(192424);
  }
  
  private final long Sc(long paramLong)
  {
    long l1 = 0L;
    int j = 0;
    AppMethodBeat.i(192398);
    if (this.MRj.size() > 0)
    {
      Object localObject = this.MRk;
      if (localObject != null)
      {
        l1 = 0L + (paramLong - ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).MSG);
        localObject = this.MRk;
        if (localObject == null) {
          break label129;
        }
        i = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).width;
        this.videoWidth = i;
        localObject = this.MRk;
        if (localObject == null) {
          break label134;
        }
      }
      label129:
      label134:
      for (int i = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).height;; i = 0)
      {
        this.videoHeight = i;
        int k = this.MRl;
        i = j;
        while (i < k)
        {
          l1 += ((com.tencent.mm.plugin.thumbplayer.e.d)this.MRj.get(i)).MSF;
          i += 1;
        }
        i = 0;
        break;
      }
      if (l1 > this.MRm)
      {
        localObject = this.MQZ;
        if (localObject == null) {
          break label273;
        }
      }
      label273:
      for (long l2 = ((b)localObject).goc();; l2 = -1L)
      {
        Log.i(this.TAG, "accumulateTimestamp exceed totalDuration, accumulateTimestamp:" + l1 + ", totalDurationMs:" + this.MRm + ", timestampMs:" + paramLong + ", index:" + this.MRl + ", mediaInfo:" + (com.tencent.mm.plugin.thumbplayer.e.d)this.MRj.get(this.MRl) + ", playPositionMs:" + l2);
        AppMethodBeat.o(192398);
        return l1;
      }
    }
    AppMethodBeat.o(192398);
    return paramLong;
  }
  
  private final void gob()
  {
    AppMethodBeat.i(192419);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.removeCallbacksAndMessages(null);
      AppMethodBeat.o(192419);
      return;
    }
    AppMethodBeat.o(192419);
  }
  
  public final void W(kotlin.g.a.b<? super Long, x> paramb)
  {
    AppMethodBeat.i(192362);
    p.k(paramb, "callback");
    this.MRr = paramb;
    AppMethodBeat.o(192362);
  }
  
  public final void X(final kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    AppMethodBeat.i(192379);
    j((a)new f(this, paramb));
    AppMethodBeat.o(192379);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(192401);
    p.k(paramb, "player");
    paramb.MRH = ((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(192401);
  }
  
  public final void ai(final a<x> parama)
  {
    AppMethodBeat.i(192351);
    Log.i(this.TAG, "init without surfaceTexture");
    if (this.lav == null)
    {
      Log.i(this.TAG, "createEGLThread");
      HandlerThread localHandlerThread = com.tencent.e.c.d.ij("TPPlayerEffector", -4);
      localHandlerThread.start();
      this.handler = new MMHandler(localHandlerThread.getLooper());
      this.handlerThread = localHandlerThread;
      j((a)new e(this));
      j((a)new g(this, parama));
    }
    this.MRn = -1L;
    AppMethodBeat.o(192351);
  }
  
  public final void j(a<x> parama)
  {
    AppMethodBeat.i(192416);
    p.k(parama, "r");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new h(parama));
      AppMethodBeat.o(192416);
      return;
    }
    AppMethodBeat.o(192416);
  }
  
  public final void ku(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192414);
    if ((paramInt1 != this.width) || (paramInt2 != this.height)) {
      this.GhM = true;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    Log.i(this.TAG, "updateSize:[" + paramInt1 + ',' + paramInt2 + "], outputSizeChanged:" + this.GhM + ", surface:" + this.FhU);
    if (this.GhM)
    {
      if ((this.width <= this.height) || (this.width <= 1080)) {
        break label206;
      }
      this.MRg = 1080;
      this.MRh = ((int)(this.MRg * (this.height * 1.0F / this.width)));
    }
    for (;;)
    {
      Log.i(this.TAG, "calcOutputTexSize:[" + this.MRg + ',' + this.MRh + ']');
      AppMethodBeat.o(192414);
      return;
      label206:
      if ((this.height > this.width) && (this.height > 1920))
      {
        this.MRh = 1920;
        this.MRg = ((int)(this.MRh * (this.width * 1.0F / this.height)));
      }
      else
      {
        this.MRg = this.width;
        this.MRh = this.height;
      }
    }
  }
  
  public final void p(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(192358);
    p.k(paramSurfaceTexture, "surface");
    Log.i(this.TAG, "attachSurface:" + paramSurfaceTexture.hashCode());
    Object localObject = this.lav;
    if (localObject != null)
    {
      j((a)new c((c.b)localObject, this, paramSurfaceTexture));
      AppMethodBeat.o(192358);
      return;
    }
    localObject = (g)this;
    Log.i(((g)localObject).TAG, "attach surface current not create GLEnvironment now");
    ((g)localObject).FhU = paramSurfaceTexture;
    AppMethodBeat.o(192358);
  }
  
  public final void release()
  {
    AppMethodBeat.i(192420);
    gob();
    j((a)new i(this));
    AppMethodBeat.o(192420);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "", "currentPlayPosition", "", "plugin-thumbplayer_release"})
  public static abstract interface b
  {
    public abstract long goc();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$attachSurface$1$1"})
  static final class c
    extends q
    implements a<x>
  {
    c(c.b paramb, g paramg, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.f.b, x>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(g paramg, kotlin.g.a.b paramb)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$createVideoTexture$1$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(g.f paramf) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(193308);
        Looper localLooper = Looper.myLooper();
        Object localObject = g.l(this.MRA.MRx);
        if (localObject != null) {
          localObject = ((MMHandler)localObject).getLooper();
        }
        for (;;)
        {
          if (p.h(localLooper, localObject)) {
            try
            {
              paramSurfaceTexture.updateTexImage();
              localObject = this.MRA.MRx;
              p.j(paramSurfaceTexture, "surface");
              g.a((g)localObject, paramSurfaceTexture.getTimestamp());
              AppMethodBeat.o(193308);
              return;
              localObject = null;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace(g.d(this.MRA.MRx), (Throwable)localException, "updateTexImage error", new Object[0]);
              }
            }
          }
        }
        this.MRA.MRx.j((a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(193308);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$createVideoTexture$1$1$2"})
    static final class b
      implements Runnable
    {
      b(g.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(189460);
        kotlin.g.a.b localb = this.MRA.MRz;
        if (localb != null)
        {
          localb.invoke(g.k(this.MRA.MRx));
          AppMethodBeat.o(189460);
          return;
        }
        AppMethodBeat.o(189460);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(g paramg, a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(g paramg, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(192745);
      kotlin.g.a.b localb = g.n(this.MRx);
      if (localb != null)
      {
        localb.invoke(this.cLr);
        AppMethodBeat.o(192745);
        return;
      }
      AppMethodBeat.o(192745);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.g
 * JD-Core Version:    0.7.0.1
 */