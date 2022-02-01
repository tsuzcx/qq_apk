package com.tencent.mm.plugin.thumbplayer.c;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.xlabeffect.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.i;
import com.tencent.mm.xeffect.effect.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "", "()V", "TAG", "", "blur", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "currentMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "currentMediaInfoIndex", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "gradientBlur", "Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "gradientBlurContentOffsetPercent", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handlerThread", "Landroid/os/HandlerThread;", "hasGradientBlur", "", "height", "initFinished", "lastRenderTimestampMs", "", "lastRenderTimestampNs", "mediaInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFrameDraw", "Lkotlin/Function1;", "", "outputSizeChanged", "outputTexHeight", "outputTexIsInited", "outputTexWidth", "playerInfoProxy", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "getPlayerInfoProxy", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "setPlayerInfoProxy", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;)V", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "requestSnapShot", "rotateProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "scaleType", "screenOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "screenRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "snapshotCallback", "Landroid/graphics/Bitmap;", "surface", "Landroid/graphics/SurfaceTexture;", "totalDurationMs", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "videoHeight", "videoPlayTexture", "videoTexture", "videoWidth", "width", "allocOutputTexMem", "outputTexId", "attachSurface", "bindToPlayer", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "calcOutputTexSize", "checkCreateEffectManager", "clearEffects", "createEGLThread", "createGLEnvironment", "createOutputTexture", "createVideoTexture", "afterCreated", "Lkotlin/ParameterName;", "name", "detachSurface", "detachSurfaceImpl", "getEffectManager", "getVideoPlaySurfaceTexture", "init", "afterInit", "Lkotlin/Function0;", "onVideoPlayTextureUpdate", "timestampNs", "queue", "r", "refreshFrame", "release", "removePendingTasks", "requestSnapshot", "callback", "selectMediaAtIndex", "index", "setBlurEffect", "blurRadius", "setBlurFadeEffectChain", "setBlurFadeEffectFromMediaList", "", "blurContentOffsetPercent", "setCurrentVideoSizeAndUpdateTimestampMs", "timestampMs", "setGradientBlurEffect", "contentOffsetPercent", "setMediaInfo", "mediaInfo", "setOnFrameDrawCallback", "setScaleType", "updateSize", "centerInside", "Landroid/graphics/Rect;", "target", "Companion", "PlayerInfoProxy", "plugin-thumbplayer_release"})
public final class a
{
  private static final int Ghk;
  public static final a.a Ghl;
  private VLogDirector AsI;
  private boolean AsJ;
  public a.b GgO;
  private com.tencent.mm.media.g.d GgP;
  private SurfaceTexture GgQ;
  private e GgR;
  private com.tencent.mm.media.g.d GgS;
  private boolean GgT;
  private int GgU;
  private int GgV;
  private com.tencent.mm.xeffect.effect.l GgW;
  private com.tencent.mm.xeffect.effect.b GgX;
  private ArrayList<com.tencent.mm.plugin.thumbplayer.d.a> GgY;
  public com.tencent.mm.plugin.thumbplayer.d.a GgZ;
  private int Gha;
  public long Ghb;
  private long Ghc;
  private long Ghd;
  private boolean Ghe;
  private float Ghf;
  private kotlin.g.a.b<? super Long, x> Ghg;
  private volatile boolean Ghh;
  public volatile boolean Ghi;
  public kotlin.g.a.b<? super Bitmap, x> Ghj;
  public final String TAG;
  public com.tencent.mm.plugin.thumbplayer.d.c UsW;
  private com.tencent.mm.media.j.b.c UsX;
  private MMHandler handler;
  private HandlerThread handlerThread;
  private volatile int height;
  private c.b ilw;
  public int scaleType;
  public volatile int videoHeight;
  public volatile int videoWidth;
  public EffectManager wet;
  private volatile int width;
  private SurfaceTexture zCV;
  
  static
  {
    AppMethodBeat.i(238670);
    Ghl = new a.a((byte)0);
    Ghk = Color.parseColor("#4c4c4c");
    b.a locala = com.tencent.mm.plugin.xlabeffect.b.JRv;
    b.a.tryLoadLibrary();
    AppMethodBeat.o(238670);
  }
  
  public a()
  {
    AppMethodBeat.i(238669);
    this.TAG = ("MicroMsg.TPPlayerEffector@" + hashCode());
    this.UsW = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.AsI = new VLogDirector();
    this.scaleType = 1;
    this.GgY = new ArrayList();
    this.Gha = -1;
    this.Ghb = -1L;
    this.Ghc = -1L;
    this.Ghd = -1L;
    this.Ghf = -1.0F;
    AppMethodBeat.o(238669);
  }
  
  private final long KF(long paramLong)
  {
    long l1 = 0L;
    int j = 0;
    AppMethodBeat.i(238663);
    if (this.GgY.size() > 0)
    {
      Object localObject = this.GgZ;
      if (localObject != null)
      {
        l1 = 0L + (paramLong - ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).Ghw);
        localObject = this.GgZ;
        if (localObject == null) {
          break label129;
        }
        i = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).width;
        this.videoWidth = i;
        localObject = this.GgZ;
        if (localObject == null) {
          break label134;
        }
      }
      label129:
      label134:
      for (int i = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).height;; i = 0)
      {
        this.videoHeight = i;
        int k = this.Gha;
        i = j;
        while (i < k)
        {
          l1 += ((com.tencent.mm.plugin.thumbplayer.d.a)this.GgY.get(i)).Ghv;
          i += 1;
        }
        i = 0;
        break;
      }
      if (l1 > this.Ghb)
      {
        localObject = this.GgO;
        if (localObject == null) {
          break label273;
        }
      }
      label273:
      for (long l2 = ((a.b)localObject).fwR();; l2 = -1L)
      {
        Log.i(this.TAG, "accumulateTimestamp exceed totalDuration, accumulateTimestamp:" + l1 + ", totalDurationMs:" + this.Ghb + ", timestampMs:" + paramLong + ", index:" + this.Gha + ", mediaInfo:" + (com.tencent.mm.plugin.thumbplayer.d.a)this.GgY.get(this.Gha) + ", playPositionMs:" + l2);
        AppMethodBeat.o(238663);
        return l1;
      }
    }
    AppMethodBeat.o(238663);
    return paramLong;
  }
  
  private final void fwO()
  {
    AppMethodBeat.i(238660);
    if (this.wet == null) {
      this.wet = new EffectManager();
    }
    AppMethodBeat.o(238660);
  }
  
  private final void fwP()
  {
    AppMethodBeat.i(238662);
    fwO();
    Object localObject1 = this.wet;
    if (localObject1 != null) {
      ((EffectManager)localObject1).hiv();
    }
    localObject1 = this.wet;
    Object localObject2;
    int i;
    label167:
    Object localObject4;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.Ryh);
      localObject2 = localObject1;
      if (!(localObject1 instanceof com.tencent.mm.xeffect.effect.l)) {
        localObject2 = null;
      }
      this.GgW = ((com.tencent.mm.xeffect.effect.l)localObject2);
      localObject1 = this.GgW;
      if (localObject1 != null) {
        ((com.tencent.mm.xeffect.effect.l)localObject1).setRadius(20.0F);
      }
      localObject1 = this.GgW;
      if (localObject1 != null) {
        ((com.tencent.mm.xeffect.effect.l)localObject1).aH(0L, this.Ghb);
      }
      localObject1 = this.GgW;
      if (localObject1 != null) {
        ((com.tencent.mm.xeffect.effect.l)localObject1).hix();
      }
      localObject1 = this.wet;
      if (localObject1 != null) {
        ((EffectManager)localObject1).a((ad)this.GgW);
      }
      Log.i(this.TAG, "gradientBlurContentOffsetPercent:" + this.Ghf);
      int j = this.GgY.size();
      i = 0;
      if (i >= j - 1) {
        break label712;
      }
      localObject1 = this.GgY.get(i);
      p.g(localObject1, "mediaInfoList[i]");
      localObject4 = (com.tencent.mm.plugin.thumbplayer.d.a)localObject1;
      localObject1 = this.GgY.get(i + 1);
      p.g(localObject1, "mediaInfoList[i + 1]");
      localObject3 = (com.tencent.mm.plugin.thumbplayer.d.a)localObject1;
      if (!((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ght)
      {
        localObject1 = this.wet;
        if (localObject1 == null) {
          break label682;
        }
        localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.Ryi);
        label245:
        localObject2 = localObject1;
        if (!(localObject1 instanceof k)) {
          localObject2 = null;
        }
        localObject2 = (k)localObject2;
        if (localObject2 != null) {
          ((k)localObject2).aE(1.0F, 0.1F);
        }
        if (localObject2 != null) {
          ((k)localObject2).aH(Math.max(0L, ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghu + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghv - 1000L), Math.max(0L, ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghu + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghv));
        }
        if (localObject2 != null) {
          ((k)localObject2).aqr(Ghk);
        }
        localObject4 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("set FadeOut time:[");
        if (localObject2 == null) {
          break label687;
        }
        localObject1 = ((ad)localObject2).RyZ;
        if (localObject1 == null) {
          break label687;
        }
        localObject1 = Long.valueOf(((i)localObject1).start);
        label377:
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        if (localObject2 == null) {
          break label692;
        }
        localObject1 = ((ad)localObject2).RyZ;
        if (localObject1 == null) {
          break label692;
        }
        localObject1 = Long.valueOf(((i)localObject1).boX);
        label413:
        Log.i((String)localObject4, localObject1 + ']');
        localObject1 = this.wet;
        if (localObject1 != null) {
          ((EffectManager)localObject1).a((ad)localObject2);
        }
      }
      if (!((com.tencent.mm.plugin.thumbplayer.d.a)localObject3).Ght)
      {
        localObject1 = this.wet;
        if (localObject1 == null) {
          break label697;
        }
        localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.Ryi);
        label476:
        localObject2 = localObject1;
        if (!(localObject1 instanceof k)) {
          localObject2 = null;
        }
        localObject2 = (k)localObject2;
        if (localObject2 != null) {
          ((k)localObject2).aE(0.1F, 1.0F);
        }
        if (localObject2 != null) {
          ((k)localObject2).aH(Math.max(0L, ((com.tencent.mm.plugin.thumbplayer.d.a)localObject3).Ghu), Math.max(0L, ((com.tencent.mm.plugin.thumbplayer.d.a)localObject3).Ghu + 1000L));
        }
        if (localObject2 != null) {
          ((k)localObject2).aqr(Ghk);
        }
        localObject3 = this.TAG;
        localObject4 = new StringBuilder("set FadeIn time:[");
        if (localObject2 == null) {
          break label702;
        }
        localObject1 = ((ad)localObject2).RyZ;
        if (localObject1 == null) {
          break label702;
        }
        localObject1 = Long.valueOf(((i)localObject1).start);
        label596:
        localObject4 = ((StringBuilder)localObject4).append(localObject1).append(',');
        if (localObject2 == null) {
          break label707;
        }
        localObject1 = ((ad)localObject2).RyZ;
        if (localObject1 == null) {
          break label707;
        }
      }
    }
    label682:
    label687:
    label692:
    label697:
    label702:
    label707:
    for (localObject1 = Long.valueOf(((i)localObject1).boX);; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1 + ']');
      localObject1 = this.wet;
      if (localObject1 != null) {
        ((EffectManager)localObject1).a((ad)localObject2);
      }
      i += 1;
      break label167;
      localObject1 = null;
      break;
      localObject1 = null;
      break label245;
      localObject1 = null;
      break label377;
      localObject1 = null;
      break label413;
      localObject1 = null;
      break label476;
      localObject1 = null;
      break label596;
    }
    label712:
    this.Ghe = true;
    AppMethodBeat.o(238662);
  }
  
  private final void fwQ()
  {
    AppMethodBeat.i(238667);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.removeCallbacksAndMessages(null);
      AppMethodBeat.o(238667);
      return;
    }
    AppMethodBeat.o(238667);
  }
  
  public final void L(final kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    AppMethodBeat.i(258223);
    k((kotlin.g.a.a)new e(this, paramb));
    AppMethodBeat.o(258223);
  }
  
  public final void M(kotlin.g.a.b<? super Long, x> paramb)
  {
    AppMethodBeat.i(238656);
    p.h(paramb, "callback");
    this.Ghg = paramb;
    AppMethodBeat.o(238656);
  }
  
  public final void aq(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(258222);
    Log.i(this.TAG, "init without surfaceTexture");
    if (this.ilw == null)
    {
      Log.i(this.TAG, "createEGLThread");
      HandlerThread localHandlerThread = com.tencent.f.c.d.hz("TPPlayerEffector", -4);
      localHandlerThread.start();
      this.handler = new MMHandler(localHandlerThread.getLooper());
      this.handlerThread = localHandlerThread;
      k((kotlin.g.a.a)new d(this));
      k((kotlin.g.a.a)new f(this, parama));
    }
    this.Ghc = -1L;
    AppMethodBeat.o(258222);
  }
  
  public final void fwM()
  {
    AppMethodBeat.i(238658);
    fwO();
    Object localObject = this.wet;
    if (localObject != null) {
      ((EffectManager)localObject).hiv();
    }
    localObject = this.wet;
    if (localObject != null) {}
    for (localObject = ((EffectManager)localObject).a(com.tencent.mm.xeffect.effect.j.Ryj); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.BlurEffect");
      AppMethodBeat.o(238658);
      throw ((Throwable)localObject);
    }
    this.GgX = ((com.tencent.mm.xeffect.effect.b)localObject);
    localObject = this.GgX;
    if (localObject != null) {
      ((com.tencent.mm.xeffect.effect.b)localObject).setRadius(3.5F);
    }
    this.Ghe = false;
    localObject = this.wet;
    if (localObject != null)
    {
      ((EffectManager)localObject).a((ad)this.GgX);
      AppMethodBeat.o(238658);
      return;
    }
    AppMethodBeat.o(238658);
  }
  
  public final void fwN()
  {
    AppMethodBeat.i(238659);
    fwO();
    EffectManager localEffectManager = this.wet;
    if (localEffectManager != null)
    {
      localEffectManager.hiv();
      AppMethodBeat.o(238659);
      return;
    }
    AppMethodBeat.o(238659);
  }
  
  public final void hI(List<com.tencent.mm.plugin.thumbplayer.d.a> paramList)
  {
    int j = 0;
    AppMethodBeat.i(238661);
    p.h(paramList, "mediaInfoList");
    this.GgY.clear();
    this.GgY.addAll((Collection)paramList);
    this.Ghb = 0L;
    paramList = ((Iterable)this.GgY).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.thumbplayer.d.a locala = (com.tencent.mm.plugin.thumbplayer.d.a)paramList.next();
      if (locala.Ghw > locala.pLQ) {
        locala.Ghw = 0L;
      }
      this.Ghb += locala.Ghv;
    }
    paramList = (List)this.GgY;
    if (paramList.size() > 1) {
      kotlin.a.j.a(paramList, (Comparator)new a.i());
    }
    this.GgZ = ((com.tencent.mm.plugin.thumbplayer.d.a)this.GgY.get(0));
    this.Gha = 0;
    paramList = this.GgZ;
    if (paramList != null) {}
    for (int i = paramList.width;; i = 0)
    {
      this.videoWidth = i;
      paramList = this.GgZ;
      i = j;
      if (paramList != null) {
        i = paramList.height;
      }
      this.videoHeight = i;
      Log.i(this.TAG, "setEffectByMediaList, totalDurationMs:" + this.Ghb);
      this.Ghf = 0.42F;
      fwP();
      AppMethodBeat.o(238661);
      return;
    }
  }
  
  public final void j(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    AppMethodBeat.i(258710);
    p.h(paramb, "player");
    paramb.Uto = ((kotlin.g.a.b)new a.j(this));
    AppMethodBeat.o(258710);
  }
  
  public final void jj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238665);
    if ((paramInt1 != this.width) || (paramInt2 != this.height)) {
      this.AsJ = true;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    Log.i(this.TAG, "updateSize:[" + paramInt1 + ',' + paramInt2 + "], outputSizeChanged:" + this.AsJ + ", surface:" + this.zCV);
    if (this.AsJ)
    {
      if ((this.width <= this.height) || (this.width <= 1080)) {
        break label206;
      }
      this.GgU = 1080;
      this.GgV = ((int)(this.GgU * (this.height * 1.0F / this.width)));
    }
    for (;;)
    {
      Log.i(this.TAG, "calcOutputTexSize:[" + this.GgU + ',' + this.GgV + ']');
      AppMethodBeat.o(238665);
      return;
      label206:
      if ((this.height > this.width) && (this.height > 1920))
      {
        this.GgV = 1920;
        this.GgU = ((int)(this.GgV * (this.width * 1.0F / this.height)));
      }
      else
      {
        this.GgU = this.width;
        this.GgV = this.height;
      }
    }
  }
  
  public final void k(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(238666);
    p.h(parama, "r");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new b(parama));
      AppMethodBeat.o(238666);
      return;
    }
    AppMethodBeat.o(238666);
  }
  
  public final void m(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(238655);
    p.h(paramSurfaceTexture, "surface");
    Log.i(this.TAG, "attachSurface:" + paramSurfaceTexture.hashCode());
    Object localObject = this.ilw;
    if (localObject != null)
    {
      k((kotlin.g.a.a)new c((c.b)localObject, this, paramSurfaceTexture));
      AppMethodBeat.o(238655);
      return;
    }
    localObject = (a)this;
    Log.i(((a)localObject).TAG, "attach surface current not create GLEnvironment now");
    ((a)localObject).zCV = paramSurfaceTexture;
    AppMethodBeat.o(238655);
  }
  
  public final void release()
  {
    AppMethodBeat.i(238668);
    fwQ();
    k((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(238668);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$attachSurface$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(c.b paramb, a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(a parama, kotlin.g.a.b paramb)
    {
      super();
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$createVideoTexture$1$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(a.e parame) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(238646);
        Looper localLooper = Looper.myLooper();
        Object localObject = a.k(this.Ghp.Ghm);
        if (localObject != null) {
          localObject = ((MMHandler)localObject).getLooper();
        }
        for (;;)
        {
          if (p.j(localLooper, localObject)) {
            try
            {
              paramSurfaceTexture.updateTexImage();
              localObject = this.Ghp.Ghm;
              p.g(paramSurfaceTexture, "surface");
              a.a((a)localObject, paramSurfaceTexture.getTimestamp());
              AppMethodBeat.o(238646);
              return;
              localObject = null;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace(a.c(this.Ghp.Ghm), (Throwable)localException, "updateTexImage error", new Object[0]);
              }
            }
          }
        }
        this.Ghp.Ghm.k((kotlin.g.a.a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(238646);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$createVideoTexture$1$1$2"})
    static final class b
      implements Runnable
    {
      b(a.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(238647);
        kotlin.g.a.b localb = this.Ghp.Gho;
        if (localb != null)
        {
          localb.invoke(a.j(this.Ghp.Ghm));
          AppMethodBeat.o(238647);
          return;
        }
        AppMethodBeat.o(238647);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(a parama, kotlin.g.a.a parama1)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(238650);
      kotlin.g.a.b localb = a.n(this.Ghm);
      if (localb != null)
      {
        localb.invoke(this.cKG);
        AppMethodBeat.o(238650);
        return;
      }
      AppMethodBeat.o(238650);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */