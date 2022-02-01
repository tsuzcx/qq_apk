package com.tencent.mm.plugin.thumbplayer.d.a;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.d.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.effect.g.c;
import com.tencent.mm.xeffect.InputAnimation;
import com.tencent.mm.xeffect.LayoutInfo;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.f;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.by;
import kotlinx.coroutines.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaImagePlayer;", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "()V", "TAG", "", "animation", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "bitmapJob", "Lkotlinx/coroutines/Job;", "currentPlayTimeMs", "", "decodeKey", "fakePlayHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "fakePlayThread", "Landroid/os/HandlerThread;", "imageBitmap", "Landroid/graphics/Bitmap;", "imageHeight", "", "imagePath", "imageRotate", "imageUrl", "imageWidth", "isInvokeOnPlayFinished", "", "isInvokeOnPlayStarted", "isPlaying", "isReleased", "isStarted", "lastPostUpdateMsgTick", "loop", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "playDurationMs", "playRangeEnd", "playRangeStart", "updateProgressTask", "Ljava/lang/Runnable;", "urlToken", "ensureImageBitmap", "", "r", "Lkotlin/Function0;", "fakeStart", "getAnimation", "getCurrentPlayTimeMs", "getImageBitmap", "getMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaInfo;", "invokeOnPlayFinished", "invokeOnPlayStarted", "isPrepared", "loadImageBitmap", "onFinished", "mediaType", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "onPlayToEnd", "pause", "preloadMedia", "release", "resume", "saveImageBitmapAndSetEffect", "scheduleNextUpdateProgressTask", "seek", "timeMs", "onSeekFinished", "setImagePath", "path", "url", "setInputSurface", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setLoop", "setMediaInfo", "setPlayRange", "startMs", "endMs", "setTargetSize", "width", "height", "start", "stop", "tryGetImageFromLocalCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnimation", "Companion", "plugin-thumbplayer_release"})
public final class c
  extends a
{
  public static final a MSb;
  private com.tencent.mm.plugin.thumbplayer.e.d GhE;
  private long MRP;
  public final g.c MRQ;
  private MMHandler MRR;
  private HandlerThread MRS;
  private volatile long MRT;
  private long MRU;
  private long MRV;
  private volatile boolean MRW;
  private volatile boolean MRX;
  private by MRY;
  private final Runnable MRZ;
  private long MSa;
  private final String TAG;
  private String decodeKey;
  private volatile boolean fGh;
  public Bitmap imageBitmap;
  private String imagePath;
  private String imageUrl;
  private volatile boolean isReleased;
  private volatile boolean isStarted;
  private boolean loop;
  private ak oDi;
  private String zZu;
  
  static
  {
    AppMethodBeat.i(191532);
    MSb = new a((byte)0);
    AppMethodBeat.o(191532);
  }
  
  public c()
  {
    AppMethodBeat.i(191531);
    this.TAG = ("MicroMsg.MultiMediaImagePlayer@" + hashCode());
    this.imagePath = "";
    this.imageUrl = "";
    this.decodeKey = "";
    this.zZu = "";
    this.MRQ = new g.c(new LayoutInfo(), new LayoutInfo(), new InputAnimation());
    this.oDi = al.c((f)bc.iRr());
    this.MRZ = ((Runnable)new k(this));
    AppMethodBeat.o(191531);
  }
  
  private final void aj(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(191484);
    final by localby = this.MRY;
    if ((localby != null) && (localby.isActive()))
    {
      Log.i(this.TAG, "bitmap is loading, ignore this request");
      if (parama != null) {
        kotlinx.coroutines.g.b(this.oDi, null, (m)new f(this, localby, parama, null), 3);
      }
      AppMethodBeat.o(191484);
      return;
    }
    this.MRY = kotlinx.coroutines.g.b(this.oDi, null, (m)new g(this, parama, null), 3);
    AppMethodBeat.o(191484);
  }
  
  private final void ak(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(191488);
    parama = (kotlin.g.a.a)new c(this, parama);
    if (this.imageBitmap == null)
    {
      aj((kotlin.g.a.a)new b(parama));
      AppMethodBeat.o(191488);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(191488);
  }
  
  private final void goj()
  {
    AppMethodBeat.i(191475);
    Object localObject1 = this.MRQ.YJd;
    InputAnimation localInputAnimation = this.MRQ.YJf;
    ((LayoutInfo)localObject1).centerX = (gof() / 2);
    ((LayoutInfo)localObject1).centerY = (gog() / 2);
    ((LayoutInfo)localObject1).YZo = 1;
    ((LayoutInfo)localObject1).scale = 1.0F;
    Bitmap localBitmap = this.imageBitmap;
    Object localObject2 = this.GhE;
    localObject1 = localObject2;
    if (!(localObject2 instanceof com.tencent.mm.plugin.thumbplayer.e.e)) {
      localObject1 = null;
    }
    localObject1 = (com.tencent.mm.plugin.thumbplayer.e.e)localObject1;
    if ((localBitmap != null) && (localObject1 != null))
    {
      int i = localBitmap.getWidth();
      int j = localBitmap.getHeight();
      localObject2 = com.tencent.mm.plugin.thumbplayer.d.a.MPX;
      localObject1 = com.tencent.mm.plugin.thumbplayer.d.a.ajp(((com.tencent.mm.plugin.thumbplayer.e.e)localObject1).MSM);
      localInputAnimation.gcH = goh();
      localInputAnimation.dgn = goi();
      localObject2 = com.tencent.mm.plugin.thumbplayer.d.a.MPX;
      com.tencent.mm.plugin.thumbplayer.d.a.a(this.MRQ, gof(), gog(), i, j, (a.a)localObject1);
    }
    AppMethodBeat.o(191475);
  }
  
  private final void gok()
  {
    try
    {
      AppMethodBeat.i(191499);
      if (!this.MRX)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
        this.MRX = true;
      }
      AppMethodBeat.o(191499);
      return;
    }
    finally {}
  }
  
  private final void gol()
  {
    try
    {
      AppMethodBeat.i(191502);
      if (!this.MRW)
      {
        Log.i(this.TAG, "invokeOnPlayFinished");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
        this.MRW = true;
      }
      AppMethodBeat.o(191502);
      return;
    }
    finally {}
  }
  
  private final void gom()
  {
    AppMethodBeat.i(191511);
    this.MSa = Util.currentTicks();
    MMHandler localMMHandler = this.MRR;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacks(this.MRZ);
    }
    localMMHandler = this.MRR;
    if (localMMHandler != null)
    {
      localMMHandler.postDelayed(this.MRZ, 33L);
      AppMethodBeat.o(191511);
      return;
    }
    AppMethodBeat.o(191511);
  }
  
  public final void J(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(191462);
    p.k(paramString1, "path");
    p.k(paramString2, "url");
    Log.i(this.TAG, "setImagePath:" + paramString1 + ", url:" + paramString2);
    this.imagePath = paramString1;
    this.imageUrl = paramString2;
    this.decodeKey = paramString3;
    this.zZu = paramString4;
    AppMethodBeat.o(191462);
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191458);
    Log.i(this.TAG, "setPlayRange:[" + paramLong1 + ',' + paramLong2 + ']');
    this.MRP = (paramLong2 - paramLong1);
    this.MRU = paramLong1;
    this.MRV = paramLong2;
    AppMethodBeat.o(191458);
  }
  
  public final boolean ayN()
  {
    return this.imageBitmap != null;
  }
  
  public final void b(long paramLong, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(191521);
    Log.i(this.TAG, "seek:".concat(String.valueOf(paramLong)));
    pause();
    this.MRT = paramLong;
    start();
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(191521);
      return;
    }
    AppMethodBeat.o(191521);
  }
  
  public final b god()
  {
    return b.MRM;
  }
  
  public final void goe()
  {
    AppMethodBeat.i(191479);
    Log.i(this.TAG, "preloadMedia");
    aj(null);
    AppMethodBeat.o(191479);
  }
  
  public final boolean isPlaying()
  {
    return this.fGh;
  }
  
  public final boolean isStarted()
  {
    return this.isStarted;
  }
  
  public final void kv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191459);
    super.kv(paramInt1, paramInt2);
    goj();
    AppMethodBeat.o(191459);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(191515);
    Log.i(this.TAG, "pause");
    this.MSa = 0L;
    this.fGh = false;
    MMHandler localMMHandler = this.MRR;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    this.isStarted = false;
    AppMethodBeat.o(191515);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191523);
    Log.i(this.TAG, "release");
    stop();
    this.imageBitmap = null;
    this.isReleased = true;
    AppMethodBeat.o(191523);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(191497);
    Log.i(this.TAG, "resume, isPlaying:" + this.fGh + ", isStarted:" + this.isStarted);
    if (!this.fGh) {
      ak((kotlin.g.a.a)new h(this));
    }
    AppMethodBeat.o(191497);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(191526);
    Log.i(this.TAG, "setLoop:".concat(String.valueOf(paramBoolean)));
    this.loop = paramBoolean;
    AppMethodBeat.o(191526);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    AppMethodBeat.i(191468);
    p.k(paramd, "mediaInfo");
    Log.i(this.TAG, "setMediaInfo:".concat(String.valueOf(paramd)));
    this.GhE = paramd;
    AppMethodBeat.o(191468);
  }
  
  public final void start()
  {
    AppMethodBeat.i(191493);
    Log.i(this.TAG, "start, isPlaying:" + this.fGh + ", isStarted:" + this.isStarted);
    if ((this.isStarted) || (this.fGh))
    {
      AppMethodBeat.o(191493);
      return;
    }
    ak((kotlin.g.a.a)new i(this));
    this.isStarted = true;
    this.MRW = false;
    this.MRX = false;
    AppMethodBeat.o(191493);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191517);
    Log.i(this.TAG, "stop");
    this.fGh = false;
    Object localObject = this.MRR;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.MRS;
    if (localObject != null) {
      ((HandlerThread)localObject).quit();
    }
    this.MRS = null;
    this.MRR = null;
    this.isStarted = false;
    this.MRT = 0L;
    AppMethodBeat.o(191517);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaImagePlayer$Companion;", "", "()V", "ProgressTimeUpdateInterval", "", "plugin-thumbplayer_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(c paramc, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    f(c paramc, by paramby, kotlin.g.a.a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(190041);
      p.k(paramd, "completion");
      paramd = new f(this.MSd, localby, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(190041);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(190044);
      paramObject1 = ((f)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(190044);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(190040);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190040);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        if (localby.isCompleted())
        {
          Log.i(c.a(this.MSd), "bitmap loading job has been already finished");
          parama.invoke();
        }
        break;
      }
      for (;;)
      {
        paramObject = x.aazN;
        AppMethodBeat.o(190040);
        return paramObject;
        Log.i(c.a(this.MSd), "joins the bitmap loading job");
        by localby = localby;
        this.L$0 = paramObject;
        this.label = 1;
        if (localby.o(this) == locala)
        {
          AppMethodBeat.o(190040);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        Log.i(c.a(this.MSd), "bitmap loading job has been finished");
        parama.invoke();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class g
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    boolean pdt;
    
    g(c paramc, kotlin.g.a.a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(191939);
      p.k(paramd, "completion");
      paramd = new g(this.MSd, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(191939);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191944);
      paramObject1 = ((g)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(191944);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(191931);
      Object localObject4 = kotlin.d.a.a.aaAA;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191931);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = this.MSd;
        this.L$0 = paramObject;
        this.label = 1;
        localObject3 = i.a((f)bc.iRs(), (m)new c.j((c)localObject1, null), this);
        localObject1 = localObject3;
        if (localObject3 == localObject4)
        {
          AppMethodBeat.o(191931);
          return localObject4;
        }
      case 1: 
        localObject3 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject3;
        boolean bool = ((Boolean)localObject1).booleanValue();
        if (bool)
        {
          c.b(this.MSd);
          paramObject = parama;
          if (paramObject != null) {
            paramObject.invoke();
          }
          paramObject = x.aazN;
          AppMethodBeat.o(191931);
          return paramObject;
        }
        Log.i(c.a(this.MSd), "do loadImageBitmap");
        localObject1 = this.MSd;
        this.L$0 = paramObject;
        this.pdt = bool;
        this.oDA = this;
        this.pGq = localObject1;
        this.label = 2;
        paramObject = new h(kotlin.d.a.b.k(this));
        localObject3 = (kotlin.d.d)paramObject;
        com.tencent.mm.plugin.thumbplayer.c.b localb = com.tencent.mm.plugin.thumbplayer.c.b.MPE;
        com.tencent.mm.plugin.thumbplayer.c.b.dJe().bQ(new com.tencent.mm.plugin.thumbplayer.c.g(c.d(this.MSd), c.e(this.MSd), c.f(this.MSd), c.g(this.MSd))).a((com.tencent.mm.loader.f.e)new a((kotlin.d.d)localObject3, this)).aRr();
        paramObject = paramObject.iBS();
        if (paramObject == kotlin.d.a.a.aaAA) {
          p.k(this, "frame");
        }
        if (paramObject != localObject4) {
          break label523;
        }
        AppMethodBeat.o(191931);
        return localObject4;
      }
      Object localObject1 = (c)this.pGq;
      ResultKt.throwOnFailure(paramObject);
      label523:
      for (;;)
      {
        c.a((c)localObject1, (Bitmap)paramObject);
        if (c.c(this.MSd) == null) {
          break;
        }
        c.b(this.MSd);
        localObject1 = c.a(this.MSd);
        localObject3 = new StringBuilder("loadImageBitmap:").append(c.c(this.MSd)).append(" from network, size:[");
        paramObject = c.c(this.MSd);
        if (paramObject != null) {}
        for (paramObject = Integer.valueOf(paramObject.getWidth());; paramObject = null)
        {
          localObject3 = ((StringBuilder)localObject3).append(paramObject).append(", ");
          localObject4 = c.c(this.MSd);
          paramObject = localObject2;
          if (localObject4 != null) {
            paramObject = Integer.valueOf(((Bitmap)localObject4).getHeight());
          }
          Log.i((String)localObject1, paramObject + ']');
          paramObject = parama;
          if (paramObject == null) {
            break;
          }
          paramObject.invoke();
          break;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaImagePlayer$loadImageBitmap$2$1$1"})
    static final class a<T, R>
      implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.thumbplayer.c.g, Bitmap>
    {
      a(kotlin.d.d paramd, c.g paramg) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class j
    extends j
    implements m<ak, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    private ak p$;
    
    j(c paramc, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(191160);
      p.k(paramd, "completion");
      paramd = new j(this.MSd, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(191160);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191162);
      paramObject1 = ((j)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(191162);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(191156);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191156);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (u.agG(c.e(this.MSd)))
      {
        c.a(this.MSd, BitmapUtil.decodeFileWithSample(c.e(this.MSd)));
        localObject2 = c.a(this.MSd);
        StringBuilder localStringBuilder = new StringBuilder("loadImageBitmap file already exist: ").append(c.c(this.MSd)).append(", size:[");
        paramObject = c.c(this.MSd);
        if (paramObject != null) {}
        for (paramObject = Integer.valueOf(paramObject.getWidth());; paramObject = null)
        {
          localStringBuilder = localStringBuilder.append(paramObject).append(", ");
          Bitmap localBitmap = c.c(this.MSd);
          paramObject = localObject1;
          if (localBitmap != null) {
            paramObject = Integer.valueOf(localBitmap.getHeight());
          }
          Log.i((String)localObject2, paramObject + "], path:" + c.e(this.MSd));
          if (c.c(this.MSd) == null) {
            break;
          }
          paramObject = Boolean.TRUE;
          AppMethodBeat.o(191156);
          return paramObject;
        }
      }
      paramObject = Boolean.FALSE;
      AppMethodBeat.o(191156);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(191767);
      Object localObject = this.MSd;
      long l2 = c.p((c)localObject);
      if (c.q(this.MSd) > 0L) {}
      for (long l1 = Util.currentTicks() - c.q(this.MSd);; l1 = 33L)
      {
        c.a((c)localObject, l1 + l2);
        localObject = this.MSd.MRI;
        if (localObject != null) {
          ((m)localObject).invoke(Long.valueOf(c.p(this.MSd)), this.MSd);
        }
        if (c.p(this.MSd) >= c.r(this.MSd))
        {
          if ((!c.s(this.MSd)) || (!c.k(this.MSd))) {
            break;
          }
          Log.i(c.a(this.MSd), "updateProgressTask loop to first");
          c.a(this.MSd, 0L);
        }
        if (c.k(this.MSd)) {
          c.u(this.MSd);
        }
        AppMethodBeat.o(191767);
        return;
      }
      Log.i(c.a(this.MSd), "updateProgressTask play to end");
      c.t(this.MSd);
      AppMethodBeat.o(191767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.a.c
 * JD-Core Version:    0.7.0.1
 */