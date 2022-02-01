package com.tencent.mm.plugin.thumbplayer.c.a;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.effect.h.c;
import com.tencent.mm.xeffect.InputAnimation;
import com.tencent.mm.xeffect.LayoutInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaImagePlayer;", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "()V", "TAG", "", "animation", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "bitmapJob", "Lkotlinx/coroutines/Job;", "currentPlayTimeMs", "", "decodeKey", "fakePlayHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "fakePlayThread", "Landroid/os/HandlerThread;", "imageBitmap", "Landroid/graphics/Bitmap;", "imageHeight", "", "imagePath", "imageRotate", "imageUrl", "imageWidth", "isInvokeOnPlayFinished", "", "isInvokeOnPlayStarted", "isPlaying", "isReleased", "isStarted", "lastPostUpdateMsgTick", "loop", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "playDurationMs", "playRangeEnd", "playRangeStart", "updateProgressTask", "Ljava/lang/Runnable;", "urlToken", "ensureImageBitmap", "", "r", "Lkotlin/Function0;", "fakeStart", "getAnimation", "getCurrentPlayTimeMs", "getImageBitmap", "getMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaInfo;", "invokeOnPlayFinished", "invokeOnPlayStarted", "isPrepared", "loadImageBitmap", "onFinished", "mediaType", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "onPlayToEnd", "pause", "preloadMedia", "release", "resume", "saveImageBitmapAndSetEffect", "scheduleNextUpdateProgressTask", "seek", "timeMs", "onSeekFinished", "setImagePath", "path", "url", "setInputSurface", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setLoop", "setMediaInfo", "setPlayRange", "startMs", "endMs", "setTargetSize", "width", "height", "start", "stop", "tryGetImageFromLocalCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnimation", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final c.a TEm;
  private com.tencent.mm.plugin.thumbplayer.a.b GvR;
  private final String TAG;
  private long TEn;
  public final h.c TEo;
  private MMHandler TEp;
  private HandlerThread TEq;
  private volatile long TEr;
  private long TEs;
  private long TEt;
  private volatile boolean TEu;
  private volatile boolean TEv;
  private cb TEw;
  private final Runnable TEx;
  private long TEy;
  private String decodeKey;
  private volatile boolean hLy;
  public Bitmap imageBitmap;
  private String imagePath;
  private String imageUrl;
  private volatile boolean isReleased;
  private volatile boolean isStarted;
  private boolean loop;
  private aq mainScope;
  private String msf;
  
  static
  {
    AppMethodBeat.i(272712);
    TEm = new c.a((byte)0);
    AppMethodBeat.o(272712);
  }
  
  public c()
  {
    AppMethodBeat.i(272641);
    this.TAG = s.X("MicroMsg.MultiMediaImagePlayer@", Integer.valueOf(hashCode()));
    this.imagePath = "";
    this.imageUrl = "";
    this.decodeKey = "";
    this.msf = "";
    this.TEo = new h.c(new LayoutInfo(), new LayoutInfo(), new InputAnimation());
    this.mainScope = ar.d((f)bg.kCh());
    this.TEx = new c..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(272641);
  }
  
  private final void Ni()
  {
    AppMethodBeat.i(272643);
    Object localObject1 = this.TEo.agEW;
    Object localObject2 = this.TEo.agEY;
    ((LayoutInfo)localObject1).centerX = (hKT() / 2);
    ((LayoutInfo)localObject1).centerY = (hKU() / 2);
    ((LayoutInfo)localObject1).agXz = 1;
    ((LayoutInfo)localObject1).scale = 1.0F;
    Object localObject3 = this.imageBitmap;
    localObject1 = this.GvR;
    if ((localObject1 instanceof com.tencent.mm.plugin.thumbplayer.d.d)) {}
    for (localObject1 = (com.tencent.mm.plugin.thumbplayer.d.d)localObject1;; localObject1 = null)
    {
      if ((localObject3 != null) && (localObject1 != null))
      {
        int i = ((Bitmap)localObject3).getWidth();
        int j = ((Bitmap)localObject3).getHeight();
        localObject3 = com.tencent.mm.plugin.thumbplayer.c.a.TCz;
        localObject1 = com.tencent.mm.plugin.thumbplayer.c.a.aoD(((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEZ);
        ((InputAnimation)localObject2).startMs = hKV();
        ((InputAnimation)localObject2).endMs = hKW();
        localObject2 = com.tencent.mm.plugin.thumbplayer.c.a.TCz;
        com.tencent.mm.plugin.thumbplayer.c.a.a(this.TEo, hKT(), hKU(), i, j, (a.a)localObject1);
      }
      AppMethodBeat.o(272643);
      return;
    }
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(272664);
    s.u(paramc, "this$0");
    long l2 = paramc.TEr;
    if (paramc.TEy > 0L) {}
    for (long l1 = Util.currentTicks() - paramc.TEy;; l1 = 33L)
    {
      paramc.TEr = (l1 + l2);
      localObject = paramc.TEf;
      if (localObject != null) {
        ((m)localObject).invoke(Long.valueOf(paramc.TEr), paramc);
      }
      if (paramc.TEr >= paramc.TEn)
      {
        if ((!paramc.loop) || (!paramc.hLy)) {
          break;
        }
        Log.i(paramc.TAG, "updateProgressTask loop to first");
        paramc.TEr = 0L;
      }
      if (paramc.hLy) {
        paramc.hKZ();
      }
      AppMethodBeat.o(272664);
      return;
    }
    Log.i(paramc.TAG, "updateProgressTask play to end");
    Object localObject = paramc.TEp;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = paramc.TEq;
    if (localObject != null) {
      ((HandlerThread)localObject).quit();
    }
    paramc.TEq = null;
    paramc.TEp = null;
    paramc.hKY();
    AppMethodBeat.o(272664);
  }
  
  private final void bV(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(272651);
    cb localcb = this.TEw;
    if ((localcb != null) && (localcb.isActive()))
    {
      Log.i(this.TAG, "bitmap is loading, ignore this request");
      if (parama != null) {
        j.a(this.mainScope, null, null, (m)new c.f(localcb, this, parama, null), 3);
      }
      AppMethodBeat.o(272651);
      return;
    }
    this.TEw = j.a(this.mainScope, null, null, (m)new c.g(this, parama, null), 3);
    AppMethodBeat.o(272651);
  }
  
  private final void bW(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(272656);
    parama = (kotlin.g.a.a)new c.c(this, parama);
    if (this.imageBitmap == null)
    {
      bV((kotlin.g.a.a)new c.b(parama));
      AppMethodBeat.o(272656);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(272656);
  }
  
  private final void hKX()
  {
    try
    {
      AppMethodBeat.i(272659);
      if (!this.TEv)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.e(this));
        this.TEv = true;
      }
      AppMethodBeat.o(272659);
      return;
    }
    finally {}
  }
  
  private final void hKY()
  {
    try
    {
      AppMethodBeat.i(272660);
      if (!this.TEu)
      {
        Log.i(this.TAG, "invokeOnPlayFinished");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.d(this));
        this.TEu = true;
      }
      AppMethodBeat.o(272660);
      return;
    }
    finally {}
  }
  
  private final void hKZ()
  {
    AppMethodBeat.i(272662);
    this.TEy = Util.currentTicks();
    MMHandler localMMHandler = this.TEp;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacks(this.TEx);
    }
    localMMHandler = this.TEp;
    if (localMMHandler != null) {
      localMMHandler.postDelayed(this.TEx, 33L);
    }
    AppMethodBeat.o(272662);
  }
  
  public final void L(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(272729);
    s.u(paramString1, "path");
    s.u(paramString2, "url");
    Log.i(this.TAG, "setImagePath:" + paramString1 + ", url:" + paramString2);
    this.imagePath = paramString1;
    this.imageUrl = paramString2;
    this.decodeKey = paramString3;
    this.msf = paramString4;
    AppMethodBeat.o(272729);
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272722);
    Log.i(this.TAG, "setPlayRange:[" + paramLong1 + ',' + paramLong2 + ']');
    this.TEn = (paramLong2 - paramLong1);
    this.TEs = paramLong1;
    this.TEt = paramLong2;
    AppMethodBeat.o(272722);
  }
  
  public final boolean cxs()
  {
    return this.imageBitmap != null;
  }
  
  public final void d(long paramLong, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(272754);
    Log.i(this.TAG, s.X("seek:", Long.valueOf(paramLong)));
    pause();
    this.TEr = paramLong;
    start();
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(272754);
  }
  
  public final b hKR()
  {
    return b.TEj;
  }
  
  public final void hKS()
  {
    AppMethodBeat.i(272735);
    Log.i(this.TAG, "preloadMedia");
    bV(null);
    AppMethodBeat.o(272735);
  }
  
  public final boolean isPlaying()
  {
    return this.hLy;
  }
  
  public final boolean isStarted()
  {
    return this.isStarted;
  }
  
  public final void mi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272725);
    super.mi(paramInt1, paramInt2);
    Ni();
    AppMethodBeat.o(272725);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(272750);
    Log.i(this.TAG, "pause");
    this.TEy = 0L;
    this.hLy = false;
    MMHandler localMMHandler = this.TEp;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    this.isStarted = false;
    AppMethodBeat.o(272750);
  }
  
  public final void release()
  {
    AppMethodBeat.i(272756);
    Log.i(this.TAG, "release");
    stop();
    this.imageBitmap = null;
    this.isReleased = true;
    AppMethodBeat.o(272756);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(272743);
    Log.i(this.TAG, "resume, isPlaying:" + this.hLy + ", isStarted:" + this.isStarted);
    if (!this.hLy) {
      bW((kotlin.g.a.a)new h(this));
    }
    AppMethodBeat.o(272743);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(272757);
    Log.i(this.TAG, s.X("setLoop:", Boolean.valueOf(paramBoolean)));
    this.loop = paramBoolean;
    AppMethodBeat.o(272757);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(272731);
    s.u(paramb, "mediaInfo");
    Log.i(this.TAG, s.X("setMediaInfo:", paramb));
    this.GvR = paramb;
    AppMethodBeat.o(272731);
  }
  
  public final void start()
  {
    AppMethodBeat.i(272739);
    Log.i(this.TAG, "start, isPlaying:" + this.hLy + ", isStarted:" + this.isStarted);
    if ((this.isStarted) || (this.hLy))
    {
      AppMethodBeat.o(272739);
      return;
    }
    bW((kotlin.g.a.a)new i(this));
    this.isStarted = true;
    this.TEu = false;
    this.TEv = false;
    AppMethodBeat.o(272739);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272752);
    Log.i(this.TAG, "stop");
    this.hLy = false;
    Object localObject = this.TEp;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.TEq;
    if (localObject != null) {
      ((HandlerThread)localObject).quit();
    }
    this.TEq = null;
    this.TEp = null;
    this.isStarted = false;
    this.TEr = 0L;
    AppMethodBeat.o(272752);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.c
 * JD-Core Version:    0.7.0.1
 */