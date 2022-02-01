package com.tencent.mm.plugin.thumbplayer.c;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.plugin.xlabeffect.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.l;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "", "()V", "TAG", "", "blur", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "currentMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "currentMediaInfoIndex", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "gradientBlur", "Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "gradientBlurContentOffsetPercent", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handlerThread", "Landroid/os/HandlerThread;", "hasGradientBlur", "", "height", "initFinished", "lastRenderTimestampMs", "", "lastRenderTimestampNs", "mediaInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFrameDraw", "Lkotlin/Function1;", "", "outputSizeChanged", "outputTexHeight", "outputTexIsInited", "outputTexWidth", "playerInfoProxy", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "getPlayerInfoProxy", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "setPlayerInfoProxy", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;)V", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "requestSnapShot", "scaleType", "screenOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "screenRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "snapshotCallback", "Landroid/graphics/Bitmap;", "surface", "Landroid/graphics/SurfaceTexture;", "totalDurationMs", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "videoHeight", "videoPlayTexture", "videoTexture", "videoWidth", "width", "allocOutputTexMem", "outputTexId", "attachSurface", "bindToPlayer", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "calcOutputTexSize", "checkCreateEffectManager", "clearEffects", "createEGLThread", "createGLEnvironment", "createOutputTexture", "createVideoTexture", "afterCreated", "Lkotlin/ParameterName;", "name", "detachSurface", "detachSurfaceImpl", "getEffectManager", "getVideoPlaySurfaceTexture", "init", "afterInit", "Lkotlin/Function0;", "onVideoPlayTextureUpdate", "timestampNs", "queue", "r", "refreshFrame", "timestamp", "release", "removePendingTasks", "requestSnapshot", "callback", "resetSnapshot", "selectMediaAtIndex", "index", "setBlurEffect", "blurRadius", "setBlurFadeEffectChain", "setBlurFadeEffectFromMediaList", "", "blurContentOffsetPercent", "setCurrentVideoSizeAndUpdateTimestampMs", "timestampMs", "setGradientBlurEffect", "contentOffsetPercent", "setMediaInfo", "mediaInfo", "setOnFrameDrawCallback", "setScaleType", "updateSize", "centerInside", "Landroid/graphics/Rect;", "target", "Companion", "PlayerInfoProxy", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a TDA;
  private static final int TDV;
  private EffectManager GpO;
  private VLogDirector GvX;
  private boolean GvY;
  private SurfaceTexture Ldt;
  public final String TAG;
  public b TDB;
  public com.tencent.mm.plugin.thumbplayer.d.b TDC;
  private com.tencent.mm.media.g.d TDD;
  private SurfaceTexture TDE;
  private com.tencent.mm.media.j.b.e TDF;
  private com.tencent.mm.media.g.d TDG;
  private boolean TDH;
  private l TDI;
  private ArrayList<com.tencent.mm.plugin.thumbplayer.a.b> TDJ;
  public com.tencent.mm.plugin.thumbplayer.a.b TDK;
  private int TDL;
  public long TDM;
  private long TDN;
  private long TDO;
  private boolean TDP;
  private float TDQ;
  private kotlin.g.a.b<? super Long, ah> TDR;
  private volatile boolean TDS;
  public volatile boolean TDT;
  public kotlin.g.a.b<? super Bitmap, ah> TDU;
  private MMHandler handler;
  private HandlerThread handlerThread;
  private volatile int height;
  private int nDl;
  private c.b nFD;
  private int nJF;
  private int nJG;
  public volatile int videoHeight;
  public volatile int videoWidth;
  private volatile int width;
  
  static
  {
    AppMethodBeat.i(272677);
    TDA = new e.a((byte)0);
    TDV = Color.parseColor("#4c4c4c");
    k.a locala = k.XKT;
    k.a.tryLoadLibrary();
    AppMethodBeat.o(272677);
  }
  
  public e()
  {
    AppMethodBeat.i(272497);
    this.TAG = s.X("MicroMsg.TPPlayerEffector@", Integer.valueOf(hashCode()));
    this.TDC = new com.tencent.mm.plugin.thumbplayer.d.b();
    this.GvX = new VLogDirector();
    this.nDl = 1;
    this.TDJ = new ArrayList();
    this.TDL = -1;
    this.TDM = -1L;
    this.TDN = -1L;
    this.TDO = -1L;
    this.TDQ = -1.0F;
    AppMethodBeat.o(272497);
  }
  
  private static final void a(e parame, Bitmap paramBitmap)
  {
    AppMethodBeat.i(272530);
    s.u(parame, "this$0");
    s.u(paramBitmap, "$bitmap");
    parame = parame.TDU;
    if (parame != null) {
      parame.invoke(paramBitmap);
    }
    AppMethodBeat.o(272530);
  }
  
  private static final void bT(a parama)
  {
    AppMethodBeat.i(272540);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(272540);
  }
  
  private final void hKP()
  {
    AppMethodBeat.i(272525);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(272525);
  }
  
  private final long wo(long paramLong)
  {
    long l1 = 0L;
    int j = 0;
    AppMethodBeat.i(272517);
    Object localObject;
    int i;
    if (this.TDJ.size() > 0)
    {
      localObject = this.TDK;
      if (localObject != null)
      {
        l1 = 0L + (paramLong - ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).TBO);
        localObject = this.TDK;
        if (localObject == null)
        {
          i = 0;
          this.videoWidth = i;
          localObject = this.TDK;
          if (localObject != null) {
            break label261;
          }
          i = 0;
          label75:
          this.videoHeight = i;
        }
      }
      else
      {
        int k = this.TDL;
        if (k <= 0) {
          break label296;
        }
        i = j;
        label94:
        j = i + 1;
        l1 += ((com.tencent.mm.plugin.thumbplayer.a.b)this.TDJ.get(i)).TBN;
        if (j < k) {
          break label290;
        }
      }
    }
    label261:
    label270:
    label290:
    label296:
    for (;;)
    {
      if (l1 > this.TDM)
      {
        localObject = this.TDB;
        if (localObject != null) {
          break label270;
        }
      }
      for (long l2 = -1L;; l2 = ((b)localObject).hKQ())
      {
        Log.i(this.TAG, "accumulateTimestamp exceed totalDuration, accumulateTimestamp:" + l1 + ", totalDurationMs:" + this.TDM + ", timestampMs:" + paramLong + ", index:" + this.TDL + ", mediaInfo:" + this.TDJ.get(this.TDL) + ", playPositionMs:" + l2);
        AppMethodBeat.o(272517);
        return l1;
        i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).width;
        break;
        i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).height;
        break label75;
      }
      AppMethodBeat.o(272517);
      return paramLong;
      i = j;
      break label94;
    }
  }
  
  public final void K(a<ah> parama)
  {
    AppMethodBeat.i(272708);
    s.u(parama, "r");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.post(new e..ExternalSyntheticLambda1(parama));
    }
    AppMethodBeat.o(272708);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    AppMethodBeat.i(272696);
    s.u(paramb, "player");
    paramb.aF((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(272696);
  }
  
  public final void aD(kotlin.g.a.b<? super Long, ah> paramb)
  {
    AppMethodBeat.i(272689);
    s.u(paramb, "callback");
    this.TDR = paramb;
    AppMethodBeat.o(272689);
  }
  
  public final void aE(final kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    AppMethodBeat.i(272692);
    K((a)new f(this, paramb));
    AppMethodBeat.o(272692);
  }
  
  public final void bS(final a<ah> parama)
  {
    AppMethodBeat.i(272685);
    Log.i(this.TAG, "init without surfaceTexture");
    if (this.nFD == null)
    {
      Log.i(this.TAG, "createEGLThread");
      HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jv("TPPlayerEffector", -4);
      localHandlerThread.start();
      this.handler = new MMHandler(localHandlerThread.getLooper());
      ah localah = ah.aiuX;
      this.handlerThread = localHandlerThread;
      K((a)new e(this));
      K((a)new g(this, parama));
    }
    this.TDN = -1L;
    AppMethodBeat.o(272685);
  }
  
  public final void mh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272702);
    if ((paramInt1 != this.width) || (paramInt2 != this.height)) {
      this.GvY = true;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    Log.i(this.TAG, "updateSize:[" + paramInt1 + ',' + paramInt2 + "], outputSizeChanged:" + this.GvY + ", surface:" + this.Ldt);
    if (this.GvY)
    {
      if ((this.width <= this.height) || (this.width <= 1080)) {
        break label206;
      }
      this.nJF = 1080;
      this.nJG = ((int)(this.nJF * (this.height * 1.0F / this.width)));
    }
    for (;;)
    {
      Log.i(this.TAG, "calcOutputTexSize:[" + this.nJF + ',' + this.nJG + ']');
      AppMethodBeat.o(272702);
      return;
      label206:
      if ((this.height > this.width) && (this.height > 1920))
      {
        this.nJG = 1920;
        this.nJF = ((int)(this.nJG * (this.width * 1.0F / this.height)));
      }
      else
      {
        this.nJF = this.width;
        this.nJG = this.height;
      }
    }
  }
  
  public final void r(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272687);
    s.u(paramSurfaceTexture, "surface");
    Log.i(this.TAG, s.X("attachSurface:", Integer.valueOf(paramSurfaceTexture.hashCode())));
    Object localObject = this.nFD;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = (e)this;
        Log.i(((e)localObject).TAG, "attach surface current not create GLEnvironment now");
        ((e)localObject).Ldt = paramSurfaceTexture;
      }
      AppMethodBeat.o(272687);
      return;
      K((a)new c(this, paramSurfaceTexture, (c.b)localObject));
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(272710);
    hKP();
    K((a)new h(this));
    AppMethodBeat.o(272710);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "", "currentPlayPosition", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract long hKQ();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(e parame, SurfaceTexture paramSurfaceTexture, c.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, ah>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(e parame, kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
    {
      super();
    }
    
    private static final void a(kotlin.g.a.b paramb, e parame)
    {
      AppMethodBeat.i(272560);
      s.u(parame, "this$0");
      if (paramb != null) {
        paramb.invoke(e.i(parame));
      }
      AppMethodBeat.o(272560);
    }
    
    private static final void c(final e parame, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272554);
      s.u(parame, "this$0");
      Looper localLooper = Looper.myLooper();
      Object localObject = e.h(parame);
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        if (s.p(localLooper, localObject)) {
          try
          {
            paramSurfaceTexture.updateTexImage();
            e.a(parame, paramSurfaceTexture.getTimestamp());
            AppMethodBeat.o(272554);
            return;
            localObject = ((MMHandler)localObject).getLooper();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace(e.d(parame), (Throwable)localException, "updateTexImage error", new Object[0]);
            }
          }
        }
      }
      parame.K((a)new a(paramSurfaceTexture, parame));
      AppMethodBeat.o(272554);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(SurfaceTexture paramSurfaceTexture, e parame)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<ah>
  {
    g(e parame, a<ah> parama)
    {
      super();
    }
    
    private static final void bU(a parama)
    {
      AppMethodBeat.i(272565);
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(272565);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<ah>
  {
    h(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.e
 * JD-Core Version:    0.7.0.1
 */