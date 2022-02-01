package com.tencent.mm.plugin.thumbplayer.f;

import android.content.Context;
import android.view.Surface;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.g;
import com.tencent.mm.plugin.thumbplayer.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "currentPlayState", "", "getCurrentPlayState", "()I", "setCurrentPlayState", "(I)V", "enableProgressLog", "", "getEnableProgressLog", "()Z", "setEnableProgressLog", "(Z)V", "firstPlaySeekTimeMs", "", "getFirstPlaySeekTimeMs", "()J", "setFirstPlaySeekTimeMs", "(J)V", "fromExternResourceLoader", "isLoop", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRealStartDownloader", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isStartCdn", "setStartCdn", "isViewFocused", "setViewFocused", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMedia", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "setMedia", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "onPlayCompleted", "Lkotlin/Function1;", "", "getOnPlayCompleted", "()Lkotlin/jvm/functions/Function1;", "setOnPlayCompleted", "(Lkotlin/jvm/functions/Function1;)V", "onPlayStarted", "getOnPlayStarted", "setOnPlayStarted", "onPlayerStopListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;)V", "onPrepared", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getOnPrepared", "setOnPrepared", "onSeekCompleted", "playEnd", "playStart", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerListener", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "getPlayerListener", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "setPlayerListener", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;)V", "progressEnable", "progressFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "progressInterval", "progressListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;)V", "resourceLoader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "getResourceLoader", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "setResourceLoader", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;)V", "checkPlayRange", "checkProgressTimer", "createTPPlayerListener", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCurrentPositionMs", "invokeOnCompletedCallback", "invokePlayStartedCallback", "invokePreparedCallback", "isIdle", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "pause", "playInfo", "playWithSource", "source", "prepareVideo", "realPlay", "recycle", "seekTo", "timeMs", "accurate", "callback", "setCdnResourceLoader", "loader", "mediaInfo", "setLoop", "looper", "setMediaInfo", "setMute", "mute", "setPlayRange", "startMs", "endMs", "setProgressListener", "listener", "interval", "setSurface", "surface", "Landroid/view/Surface;", "start", "startCdnDownload", "startProgressTimer", "startToPlay", "stop", "stopAsync", "stopCdnDownload", "finish", "Lkotlin/Function0;", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "MMTPResourceLoader", "TPPlayerListener", "plugin-thumbplayer_release"})
public class b
{
  public static final b.a MTf;
  private long AJV;
  public boolean ALj;
  private AtomicBoolean AMD;
  public boolean AMJ;
  public a AMn;
  public kotlin.g.a.b<? super b, x> MRH;
  public com.tencent.mm.plugin.thumbplayer.e.d MSO;
  private c MSP;
  public b MSQ;
  public f MSR;
  private kotlin.g.a.b<? super ITPPlayer, x> MSS;
  public kotlin.g.a.b<? super b, x> MST;
  public com.tencent.mm.plugin.thumbplayer.view.c MSU;
  private volatile com.tencent.mm.plugin.thumbplayer.view.e MSV;
  private long MSW;
  private boolean MSX;
  private com.tencent.e.i.d<?> MSY;
  private long MSZ;
  public boolean MTa;
  public boolean MTb;
  private kotlin.g.a.b<? super ITPPlayer, x> MTc;
  public com.tencent.mm.plugin.thumbplayer.e.a MTd;
  public long MTe;
  public final String TAG;
  private final Context context;
  volatile int currentPlayState;
  private boolean mfK;
  
  static
  {
    AppMethodBeat.i(190237);
    MTf = new b.a((byte)0);
    AppMethodBeat.o(190237);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(190235);
    this.context = paramContext;
    this.TAG = ("MicroMsg.TP.MMCdnTPPlayer@" + hashCode());
    this.AMD = new AtomicBoolean(true);
    this.MSW = 200L;
    this.AJV = -1L;
    this.MSZ = -1L;
    this.MTd = new com.tencent.mm.plugin.thumbplayer.e.a();
    this.MSP = new c();
    paramContext = d.MTv;
    this.AMn = d.a.iz(this.context);
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnErrorListener((ITPPlayerListener.IOnErrorListener)this.MSP);
    }
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)this.MSP);
    }
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)this.MSP);
    }
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)this.MSP);
    }
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnInfoListener((ITPPlayerListener.IOnInfoListener)this.MSP);
    }
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)this.MSP);
    }
    paramContext = this.AMn;
    if (paramContext != null) {
      paramContext.setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)this.MSP);
    }
    this.MTe = -1L;
    AppMethodBeat.o(190235);
  }
  
  private final boolean Rt(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(190158);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo() source:").append(paramInt).append(" isMoovReady:");
    Object localObject1 = this.MSQ;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).zKm);
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("isAllCompleted:");
      localObject1 = this.MSQ;
      if (localObject1 == null) {
        break label207;
      }
    }
    label207:
    for (localObject1 = Boolean.valueOf(((b)localObject1).MTg);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("downloadUrl:");
      com.tencent.mm.plugin.thumbplayer.e.d locald = this.MSO;
      localObject1 = localObject2;
      if (locald != null) {
        localObject1 = locald.url;
      }
      Log.i(str, (String)localObject1 + ' ' + eha());
      if ((!ayN()) && (!cmp())) {
        break label212;
      }
      Log.i(this.TAG, "prepareVideo return for state:" + this.currentPlayState);
      AppMethodBeat.o(190158);
      return false;
      localObject1 = null;
      break;
    }
    label212:
    localObject1 = this.MSQ;
    if (localObject1 != null) {
      if ((!((b)localObject1).zKm) && (!((b)localObject1).MTg))
      {
        localObject2 = this.MSO;
        if (((localObject2 == null) || (((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).fEF != true)) && (!this.MTb)) {}
      }
      else
      {
        Log.i(this.TAG, "real prepare player");
        localObject2 = this.AMn;
        if (localObject2 != null) {
          ((a)localObject2).setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, false));
        }
        localObject2 = this.AMn;
        if (localObject2 != null) {
          ((a)localObject2).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)localObject1);
        }
        localObject1 = this.AMn;
        if (localObject1 != null) {
          ((a)localObject1).prepareAsync();
        }
        AppMethodBeat.o(190158);
        return true;
      }
    }
    AppMethodBeat.o(190158);
    return false;
  }
  
  private boolean adH()
  {
    return this.currentPlayState == 6;
  }
  
  private void al(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(190171);
    p.k(parama, "finish");
    if (!this.AMJ)
    {
      Log.i(this.TAG, "stopCdnDownload() not start cdn " + eha());
      parama.invoke();
      AppMethodBeat.o(190171);
      return;
    }
    Log.i(this.TAG, "stopCdnDownload");
    com.tencent.mm.plugin.thumbplayer.b.a locala = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController();
    Object localObject = this.MSO;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).mediaId;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      locala.a((String)localObject, (g)new k(this, parama));
      this.AMJ = false;
      parama = this.MSQ;
      if (parama != null)
      {
        parama.MTh = false;
        AppMethodBeat.o(190171);
        return;
      }
      AppMethodBeat.o(190171);
      return;
    }
  }
  
  private boolean ayN()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean cmp()
  {
    return this.currentPlayState == 3;
  }
  
  private final void ehb()
  {
    AppMethodBeat.i(190162);
    Log.i(this.TAG, "realPlay()");
    a locala = this.AMn;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(190162);
      return;
    }
    AppMethodBeat.o(190162);
  }
  
  private void ehc()
  {
    AppMethodBeat.i(190168);
    if (this.AMJ)
    {
      Log.i(this.TAG, "startCdnDownload() already start cdn " + eha());
      AppMethodBeat.o(190168);
      return;
    }
    Object localObject = this.MSQ;
    com.tencent.mm.plugin.thumbplayer.e.d locald = this.MSO;
    com.tencent.mm.plugin.thumbplayer.b.a locala;
    if ((localObject != null) && (locald != null)) {
      if ((!((b)localObject).MTg) && (!locald.fEF) && (!this.MTb))
      {
        Log.i(this.TAG, "startCdnDownload");
        locala = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController();
        localObject = locald.mediaId;
        if (localObject != null) {
          break label180;
        }
        localObject = "";
      }
    }
    label180:
    for (;;)
    {
      locala.a((String)localObject, (com.tencent.mm.plugin.thumbplayer.b.b)new f(this), (com.tencent.mm.plugin.thumbplayer.b.e)new g(locald, this));
      this.AMJ = true;
      AppMethodBeat.o(190168);
      return;
      Log.i(this.TAG, "local file or complete or fromExternResourceLoader");
      AppMethodBeat.o(190168);
      return;
    }
  }
  
  private final void gor()
  {
    AppMethodBeat.i(190100);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(190100);
  }
  
  private boolean got()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void gov()
  {
    AppMethodBeat.i(190206);
    long l1 = this.MSZ;
    long l2 = this.AJV;
    if (((0L <= l2) && (l1 > l2)) || (this.MSV != null)) {}
    for (int i = 1; (i != 0) && (!this.MSX); i = 0)
    {
      this.MSX = true;
      if (!isPlaying()) {
        break label117;
      }
      gox();
      AppMethodBeat.o(190206);
      return;
    }
    if (i == 0)
    {
      ehf();
      com.tencent.e.i.d locald = this.MSY;
      if (locald != null) {
        locald.cancel(false);
      }
      this.MSY = null;
      this.MSX = false;
    }
    label117:
    AppMethodBeat.o(190206);
  }
  
  private final void gow()
  {
    AppMethodBeat.i(190210);
    a locala = this.AMn;
    if (locala != null) {}
    long l2;
    long l3;
    for (long l1 = locala.getCurrentPositionMs();; l1 = 0L)
    {
      l2 = this.MSZ;
      l3 = this.AJV;
      if (0L <= l3) {
        break;
      }
      AppMethodBeat.o(190210);
      return;
    }
    if (l2 > l3)
    {
      l2 = this.AJV;
      l3 = this.MSZ;
      if ((l2 > l1) || (l3 <= l1))
      {
        if (this.mfK)
        {
          locala = this.AMn;
          if (locala != null)
          {
            locala.seekTo((int)this.AJV, 3);
            AppMethodBeat.o(190210);
            return;
          }
          AppMethodBeat.o(190210);
          return;
        }
        Log.i(this.TAG, "checkPlayRange currentMs:" + l1 + " not in playRange:[" + this.AJV + ", " + this.MSZ + ']');
        stop();
      }
    }
    AppMethodBeat.o(190210);
  }
  
  private final void gox()
  {
    AppMethodBeat.i(190213);
    Log.i(this.TAG, "startProgressTimer " + eha());
    TimerTask localTimerTask = (TimerTask)new h(this);
    this.MSY = com.tencent.e.h.ZvG.b((Runnable)localTimerTask, this.MSW, this.MSW);
    AppMethodBeat.o(190213);
  }
  
  public final boolean Rs(int paramInt)
  {
    AppMethodBeat.i(190153);
    Log.i(this.TAG, "playWithSource source=" + paramInt + ' ' + eha() + ' ');
    if (!this.ALj)
    {
      Log.i(this.TAG, "playWithSource() return for isViewFocused:" + this.ALj);
      AppMethodBeat.o(190153);
      return false;
    }
    if (!got())
    {
      Log.i(this.TAG, "playWithSource() return for currentState:" + this.currentPlayState);
      AppMethodBeat.o(190153);
      return false;
    }
    boolean bool = isPlaying();
    if (!bool) {
      if (ayN()) {
        ehb();
      }
    }
    for (;;)
    {
      ehc();
      a locala = this.AMn;
      if (locala != null) {
        locala.resumeDownload();
      }
      AppMethodBeat.o(190153);
      return true;
      Log.i(this.TAG, "playWithSource() return for isPlaying:".concat(String.valueOf(bool)));
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, kotlin.g.a.b<? super ITPPlayer, x> paramb)
  {
    AppMethodBeat.i(190123);
    Log.i(this.TAG, "seekTo:" + paramInt + ", accurate:" + paramBoolean + ", isPause:" + adH());
    this.MTc = paramb;
    if (paramBoolean)
    {
      paramb = this.AMn;
      if (paramb != null) {
        paramb.seekTo(paramInt, 3);
      }
    }
    for (;;)
    {
      if (isPlaying()) {
        Rs(2);
      }
      AppMethodBeat.o(190123);
      return;
      paramb = this.AMn;
      if (paramb != null) {
        paramb.seekTo(paramInt);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.view.e parame, long paramLong)
  {
    AppMethodBeat.i(190095);
    this.MSV = parame;
    if (paramLong < 0L) {
      Log.w(this.TAG, "setProgressListener: invalid interval ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      gov();
      AppMethodBeat.o(190095);
      return;
      this.MSW = paramLong;
    }
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190093);
    Log.i(this.TAG, "setPlayRange: " + paramLong1 + " - " + paramLong2);
    this.AJV = paramLong1;
    this.MSZ = paramLong2;
    gov();
    gow();
    AppMethodBeat.o(190093);
  }
  
  public final void b(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(190198);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setSurface() surface:");
    if (paramSurface != null) {}
    for (Object localObject = Integer.valueOf(paramSurface.hashCode());; localObject = null)
    {
      Log.i(str, localObject + ' ' + eha());
      localObject = this.AMn;
      if (localObject != null) {
        ((a)localObject).setSurface(paramSurface);
      }
      if (paramBoolean) {
        Rs(1);
      }
      AppMethodBeat.o(190198);
      return;
    }
  }
  
  public final String eha()
  {
    Object localObject2 = null;
    AppMethodBeat.i(190229);
    StringBuilder localStringBuilder = new StringBuilder("mediaId:");
    Object localObject1 = this.MSO;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId;
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" isViewFocused:").append(this.ALj).append(" width:");
      localObject1 = this.MSO;
      if (localObject1 == null) {
        break label189;
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).width);
      label75:
      localStringBuilder = localStringBuilder.append(localObject1).append(" height:");
      localObject1 = this.MSO;
      if (localObject1 == null) {
        break label194;
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).height);
      label104:
      localStringBuilder = localStringBuilder.append(localObject1).append(" duration:");
      localObject1 = this.MSO;
      if (localObject1 == null) {
        break label199;
      }
    }
    label189:
    label194:
    label199:
    for (localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", timeOffset:");
      com.tencent.mm.plugin.thumbplayer.e.d locald = this.MSO;
      localObject1 = localObject2;
      if (locald != null) {
        localObject1 = Long.valueOf(locald.MSG);
      }
      localObject1 = localObject1;
      AppMethodBeat.o(190229);
      return localObject1;
      localObject1 = null;
      break;
      localObject1 = null;
      break label75;
      localObject1 = null;
      break label104;
    }
  }
  
  public final void ehf()
  {
    AppMethodBeat.i(190221);
    Log.i(this.TAG, "stopProgressTimer " + eha());
    com.tencent.e.i.d locald = this.MSY;
    if (locald != null) {
      locald.cancel(false);
    }
    this.MSY = null;
    AppMethodBeat.o(190221);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(190216);
    a locala = this.AMn;
    if (locala != null)
    {
      long l = locala.getCurrentPositionMs();
      AppMethodBeat.o(190216);
      return l;
    }
    AppMethodBeat.o(190216);
    return 0L;
  }
  
  public final void gos()
  {
    AppMethodBeat.i(190116);
    if (got())
    {
      Log.i(this.TAG, "already start " + eha());
      Rs(3);
      gor();
      AppMethodBeat.o(190116);
      return;
    }
    Object localObject3 = this.MSQ;
    Object localObject1 = this.MSO;
    Object localObject2;
    if ((localObject3 != null) && (localObject1 != null))
    {
      localObject2 = u.n(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).path, false);
      Log.i(this.TAG, "startToPlay(), cache file:" + (String)localObject2 + ", isLocal:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF + ", isExists:" + u.agG((String)localObject2) + ' ' + eha());
      if ((!((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF) && (!((b)localObject3).MTg)) {
        break label218;
      }
      localObject3 = this.AMn;
      if (localObject3 != null) {
        ((a)localObject3).setMediaId(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId);
      }
      localObject1 = this.AMn;
      if (localObject1 != null) {
        ((a)localObject1).setDataSource((String)localObject2);
      }
    }
    for (;;)
    {
      Rt(1);
      this.MTd.jID = Util.currentTicks();
      AppMethodBeat.o(190116);
      return;
      label218:
      localObject2 = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject2).fileId(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId);
      ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
      localObject3 = this.AMn;
      if (localObject3 != null) {
        ((a)localObject3).setMediaId(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId);
      }
      localObject3 = this.AMn;
      if (localObject3 != null) {
        ((a)localObject3).setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L));
      }
      localObject3 = this.AMn;
      if (localObject3 != null) {
        ((a)localObject3).setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
      }
      localObject2 = this.AMn;
      if (localObject2 != null) {
        ((a)localObject2).setDataSource(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).url);
      }
      ehc();
    }
  }
  
  public final void gou()
  {
    AppMethodBeat.i(190177);
    Log.i(this.TAG, "updateIsReaStartDownloader() isReaStartDownloader:true");
    this.AMD.set(true);
    AppMethodBeat.o(190177);
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(190131);
    Object localObject;
    if (isPlaying())
    {
      localObject = this.AMn;
      if (localObject != null) {
        ((a)localObject).pause();
      }
      localObject = this.AMn;
      if (localObject != null) {
        ((a)localObject).pauseDownload();
      }
    }
    while (!this.MTb)
    {
      localObject = this.MSO;
      if ((localObject == null) || (((com.tencent.mm.plugin.thumbplayer.e.d)localObject).fEF)) {
        break;
      }
      b(this);
      AppMethodBeat.o(190131);
      return;
      cmp();
    }
    this.AMJ = false;
    AppMethodBeat.o(190131);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(190194);
    Log.i(this.TAG, "recycle " + eha());
    b(null, false);
    com.tencent.mm.ae.d.c("TP.Player", (kotlin.g.a.a)new e(this));
    ehf();
    com.tencent.e.i.d locald = this.MSY;
    if (locald != null) {
      locald.cancel(false);
    }
    this.MSY = null;
    this.MSX = false;
    this.MSU = null;
    AppMethodBeat.o(190194);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(190137);
    this.mfK = paramBoolean;
    a locala = this.AMn;
    if (locala != null)
    {
      locala.setLoopback(paramBoolean);
      AppMethodBeat.o(190137);
      return;
    }
    AppMethodBeat.o(190137);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    Object localObject2 = null;
    AppMethodBeat.i(190089);
    p.k(paramd, "mediaInfo");
    this.MSO = paramd;
    Object localObject1 = this.MSQ;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).mediaId;
      if ((p.h(localObject1, paramd.mediaId) ^ true)) {
        this.MSQ = new b(paramd.mediaId);
      }
      localObject1 = this.TAG;
      paramd = new StringBuilder("setMediaInfo, resourceLoader:");
      localObject3 = this.MSQ;
      if (localObject3 == null) {
        break label158;
      }
    }
    label158:
    for (int i = localObject3.hashCode();; i = 0)
    {
      localObject3 = paramd.append(i).append(", isLocal:");
      com.tencent.mm.plugin.thumbplayer.e.d locald = this.MSO;
      paramd = localObject2;
      if (locald != null) {
        paramd = Boolean.valueOf(locald.fEF);
      }
      Log.i((String)localObject1, paramd);
      AppMethodBeat.o(190089);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(190134);
    a locala = this.AMn;
    if (locala != null)
    {
      locala.setOutputMute(paramBoolean);
      AppMethodBeat.o(190134);
      return;
    }
    AppMethodBeat.o(190134);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(190185);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("stop() ").append(eha()).append(", fromExternResourceLoader:").append(this.MTb).append(", isLocal:");
    Object localObject = this.MSO;
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject).fEF);; localObject = null)
    {
      Log.i(str, localObject);
      if (got()) {
        break label145;
      }
      Log.i(this.TAG, "stop() return for isStartPlay. " + eha());
      localObject = this.MSR;
      if (localObject == null) {
        break;
      }
      ((f)localObject).ehC();
      AppMethodBeat.o(190185);
      return;
    }
    AppMethodBeat.o(190185);
    return;
    label145:
    ehf();
    this.MSV = null;
    this.MSU = null;
    this.MTe = -1L;
    localObject = this.AMn;
    if (localObject != null) {
      ((a)localObject).stop();
    }
    localObject = this.AMn;
    if (localObject != null) {
      ((a)localObject).reset();
    }
    if (!this.MTb)
    {
      localObject = this.MSO;
      if ((localObject != null) && (!((com.tencent.mm.plugin.thumbplayer.e.d)localObject).fEF)) {
        b(this);
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "stop() end " + eha());
      AppMethodBeat.o(190185);
      return;
      this.AMJ = false;
    }
  }
  
  public final void stopAsync()
  {
    AppMethodBeat.i(190189);
    Log.i(this.TAG, "stopAsync() " + eha());
    this.MTd.stop();
    com.tencent.mm.ae.d.c("TP.Player", (kotlin.g.a.a)new b.i(this));
    AppMethodBeat.o(190189);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "mediaId", "", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;Ljava/lang/String;)V", "MAX_REQUETS_LENGTH", "", "getMAX_REQUETS_LENGTH", "()J", "isAllComplete", "", "()Z", "setAllComplete", "(Z)V", "isMoovReady", "setMoovReady", "isRequestingData", "setRequestingData", "getMediaId", "()Ljava/lang/String;", "onAllComplete", "Lkotlin/Function2;", "", "", "getOnAllComplete", "()Lkotlin/jvm/functions/Function2;", "setOnAllComplete", "(Lkotlin/jvm/functions/Function2;)V", "requestNumber", "getRequestNumber", "()I", "setRequestNumber", "(I)V", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "offset", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopCdnDownload", "onStopReadData", "requestId", "resourceInfo", "plugin-thumbplayer_release"})
  public final class b
    extends h.a.a.a.a.a.a.a.a.a.a.a
    implements h.a
  {
    private int AMU;
    public boolean MTg;
    boolean MTh;
    public m<? super String, ? super Integer, x> MTi;
    private final long MTj;
    public final String mediaId;
    public boolean zKm;
    
    public b()
    {
      AppMethodBeat.i(189921);
      this.mediaId = localObject;
      this.MTj = 1048576L;
      AppMethodBeat.o(189921);
    }
    
    private final String goy()
    {
      AppMethodBeat.i(189875);
      String str = b.this.eha() + " isMoovReady:" + this.zKm + " isAllComplete:" + this.MTg + " isRequestingData:" + this.MTh;
      AppMethodBeat.o(189875);
      return str;
    }
    
    public final void Kj(String paramString) {}
    
    public final String Rv(int paramInt)
    {
      AppMethodBeat.i(189904);
      Object localObject = b.this.MSO;
      if (localObject != null)
      {
        String str = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).path;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localObject = u.n((String)localObject, false);
      AppMethodBeat.o(189904);
      return localObject;
    }
    
    public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(189886);
      this.MTg = true;
      paramd = this.MTi;
      if (paramd != null)
      {
        paramd.invoke(paramString, Integer.valueOf(paramInt));
        AppMethodBeat.o(189886);
        return;
      }
      AppMethodBeat.o(189886);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(189876);
      this.zKm = true;
      b.a(b.this, 2);
      AppMethodBeat.o(189876);
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(189910);
      Log.i(b.c(b.this), "getContentType() fileId:" + paramInt + ", fileKey:" + paramString + " contentType:" + "video/mp4" + ' ' + goy());
      AppMethodBeat.o(189910);
      return "video/mp4";
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(189891);
      Object localObject = b.this.MSO;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).path;; localObject = null)
      {
        long l = u.bBQ((String)localObject);
        Log.i(b.c(b.this), "getDataTotalSize() fileId:" + paramInt + ", fileKey:" + paramString + " fileLength:" + l + ' ' + goy());
        AppMethodBeat.o(189891);
        return l;
      }
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189883);
      Log.i(b.c(b.this), "onProgress mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2 + ' ' + goy());
      AppMethodBeat.o(189883);
    }
    
    public final int n(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189900);
      long l1;
      if (this.MTg) {
        l1 = paramLong2;
      }
      for (;;)
      {
        if ((l1 == 0L) && (!this.MTh) && (this.zKm) && (b.this.AMJ))
        {
          final long l2 = kotlin.k.i.bf(paramLong2, this.MTj);
          paramInt = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)paramLong1, (int)l2, (com.tencent.mm.plugin.thumbplayer.b.c)new a(this, l2));
          if (paramInt > 0) {
            this.MTh = true;
          }
          Log.i(b.c(b.this), "requestVideoData requestDataRet:" + paramInt + " requestLength:" + l2);
        }
        if (l1 > 0L) {
          Log.i(b.c(b.this), "onReadData() offset:" + paramLong1 + " length:" + paramLong2 + " returnLength:" + l1 + ' ' + goy());
        }
        for (;;)
        {
          paramInt = (int)l1;
          AppMethodBeat.o(189900);
          return paramInt;
          long[] arrayOfLong = new long[2];
          if ((CdnLogic.queryContinuousSize(this.mediaId, paramLong1, arrayOfLong) != 0) || (arrayOfLong[0] <= 0L)) {
            break label316;
          }
          l1 = Math.min(arrayOfLong[0], paramLong2);
          break;
          Log.d(b.c(b.this), "onReadData() offset:" + paramLong1 + " length:" + paramLong2 + ' ' + goy());
        }
        label316:
        l1 = 0L;
      }
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189880);
      Log.i(b.c(b.this), "onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + ' ' + goy());
      this.MTh = false;
      AppMethodBeat.o(189880);
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189913);
      Log.i(b.c(b.this), "onStartReadData() fileId:" + paramInt + ", fileKey:" + paramString + " requestStart:" + paramLong1 + " requestEnd:" + paramLong2 + ' ' + goy());
      paramInt = this.AMU;
      this.AMU = (paramInt + 1);
      AppMethodBeat.o(189913);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(189919);
      Log.i(b.c(b.this), "onStopReadData() fileId:" + paramInt1 + ", fileKey:" + paramString + " requestId:" + paramInt2 + ' ' + goy());
      paramInt1 = this.AMU;
      AppMethodBeat.o(189919);
      return paramInt1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-thumbplayer_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      a(long paramLong) {}
      
      public final void Rw(int paramInt)
      {
        AppMethodBeat.i(192956);
        if (paramInt != 0)
        {
          Log.w(b.c(this.MTl.MTk), "requestedResource() requestVideoData fail, ret:" + paramInt + ' ' + this);
          this.MTl.MTh = false;
          AppMethodBeat.o(192956);
          return;
        }
        Log.i(b.c(this.MTl.MTk), "requestVideoData requestDataRet:" + paramInt + " requestLength:" + l2);
        AppMethodBeat.o(192956);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onSeekComplete", "onStateChange", "preState", "curState", "onVideoSizeChanged", "width", "height", "plugin-thumbplayer_release"})
  public final class c
    implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(193291);
      Log.i(b.c(this.MTk), "onCompletion");
      b.f(this.MTk);
      AppMethodBeat.o(193291);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(193295);
      Log.i(b.c(this.MTk), "onError errorType:" + paramInt1 + " errorCode:" + paramInt2 + ' ' + this.MTk.eha());
      this.MTk.MTd.errType = paramInt1;
      this.MTk.MTd.errCode = paramInt2;
      AppMethodBeat.o(193295);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(193280);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(193280);
        return;
        this.MTk.MTd.MSp = Util.currentTicks();
        AppMethodBeat.o(193280);
        return;
        paramITPPlayer = this.MTk.MTd;
        if (paramITPPlayer.MSp > 0L)
        {
          paramITPPlayer.MSn += 1;
          paramITPPlayer.MSo += Util.ticksToNow(paramITPPlayer.MSp);
        }
        paramITPPlayer.MSp = 0L;
        AppMethodBeat.o(193280);
        return;
        AppMethodBeat.o(193280);
        return;
        paramITPPlayer = this.MTk.MTd;
        paramITPPlayer.tJV = Util.ticksToNow(paramITPPlayer.jID);
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(193273);
      Log.i(b.c(this.MTk), "onPrepared");
      this.MTk.Rs(0);
      if ((this.MTk.MSO != null) && (this.MTk.MTe > 0L))
      {
        b.a(this.MTk, (int)this.MTk.MTe, true, 4);
        Log.i(b.c(this.MTk), "seek to play " + this.MTk.MTe + ' ' + this.MTk.eha());
      }
      b.a(this.MTk, paramITPPlayer);
      AppMethodBeat.o(193273);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(193299);
      Log.i(b.c(this.MTk), "onSeekComplete");
      kotlin.g.a.b localb = b.g(this.MTk);
      if (localb != null) {
        localb.invoke(paramITPPlayer);
      }
      b.h(this.MTk);
      AppMethodBeat.o(193299);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193287);
      Log.i(b.c(this.MTk), "onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + this.MTk.eha());
      this.MTk.currentPlayState = paramInt2;
      if ((paramInt2 == 9) || (paramInt2 == 1))
      {
        Log.i(b.c(this.MTk), "onStateChange() player stop or idle " + this.MTk.eha());
        f localf = this.MTk.MSR;
        if (localf != null) {
          localf.ehC();
        }
        this.MTk.MSR = null;
      }
      if (paramInt2 == 5) {
        b.d(this.MTk);
      }
      if (this.MTk.isPlaying())
      {
        b.e(this.MTk);
        AppMethodBeat.o(193287);
        return;
      }
      this.MTk.ehf();
      AppMethodBeat.o(193287);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-thumbplayer_release"})
  public static final class f
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    f(b paramb) {}
    
    public final com.tencent.mm.i.h aGj(String paramString)
    {
      AppMethodBeat.i(191595);
      p.k(paramString, "id");
      b localb = this.MTk;
      paramString = com.tencent.mm.plugin.thumbplayer.b.MPi;
      paramString = localb.MSO;
      if (paramString != null)
      {
        localObject1 = paramString.mediaId;
        paramString = (String)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramString = "";
      }
      Object localObject1 = localb.MSO;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).url;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localb.MSO;
      if (localObject2 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).path;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      Object localObject3 = localb.MSO;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject3).MSA;
        if (localObject3 == null) {}
      }
      for (int i = ((Integer)localObject3).intValue();; i = 2)
      {
        localObject3 = localb.MSO;
        if (localObject3 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject3).fPD;
          localObject3 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject3 = "xV2";
        }
        Object localObject4 = localb.MSO;
        if (localObject4 != null)
        {
          localObject5 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).zZu;
          localObject4 = localObject5;
          if (localObject5 != null) {}
        }
        else
        {
          localObject4 = "";
        }
        Object localObject5 = localb.MSO;
        if (localObject5 != null)
        {
          localObject6 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject5).decodeKey;
          localObject5 = localObject6;
          if (localObject6 != null) {}
        }
        else
        {
          localObject5 = "";
        }
        Object localObject6 = localb.MSO;
        if (localObject6 != null)
        {
          String str = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject6).videoFlag;
          localObject6 = str;
          if (str != null) {}
        }
        else
        {
          localObject6 = "";
        }
        paramString = com.tencent.mm.plugin.thumbplayer.b.a(paramString, (String)localObject1, (String)localObject2, i, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (h.a)localb.MSQ, localb.TAG);
        AppMethodBeat.o(191595);
        return paramString;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStop", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-thumbplayer_release"})
  public static final class g
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    g(com.tencent.mm.plugin.thumbplayer.e.d paramd, b paramb) {}
    
    public final void OT(int paramInt)
    {
      AppMethodBeat.i(191055);
      Log.i(b.c(jdField_this), "startCdnDownload()#onStart " + jdField_this.eha() + ' ' + paramInt);
      if (paramInt == 0)
      {
        b.i(jdField_this);
        AppMethodBeat.o(191055);
        return;
      }
      if (paramInt == 1)
      {
        Object localObject = jdField_this.MSQ;
        if (localObject != null) {
          ((b.b)localObject).MTg = true;
        }
        localObject = jdField_this.MSQ;
        if (localObject != null) {
          ((b.b)localObject).zKm = true;
        }
        localObject = jdField_this.MSQ;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).MTi;
          if (localObject != null) {
            ((m)localObject).invoke(this.MTn.mediaId, Integer.valueOf(0));
          }
        }
        b.a(jdField_this, 4);
      }
      AppMethodBeat.o(191055);
    }
    
    public final void a(int paramInt, com.tencent.mm.i.h paramh)
    {
      AppMethodBeat.i(191058);
      String str = b.c(jdField_this);
      StringBuilder localStringBuilder = new StringBuilder("startCdnDownload() #onStop:").append(paramInt).append(", ");
      if (paramh != null) {}
      for (paramh = paramh.field_mediaId;; paramh = null)
      {
        Log.i(str, paramh);
        AppMethodBeat.o(191058);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class h
    extends TimerTask
  {
    public h(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(191832);
      Object localObject = this.MTk.AMn;
      if (localObject != null) {}
      for (long l = ((a)localObject).getCurrentPositionMs();; l = 0L)
      {
        if (this.MTk.MTa) {
          Log.d(b.c(this.MTk), "onProgress currentMs:".concat(String.valueOf(l)));
        }
        localObject = b.j(this.MTk);
        if (localObject != null) {
          ((com.tencent.mm.plugin.thumbplayer.view.e)localObject).a(this.MTk.MSO, l);
        }
        b.k(this.MTk);
        AppMethodBeat.o(191832);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$stopCdnDownload$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-thumbplayer_release"})
  public static final class k
    implements g
  {
    k(kotlin.g.a.a parama) {}
    
    public final void a(int paramInt, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(189449);
      Log.i(b.c(this.MTk), "stopCdnDownload()#onStop(), real cancel download task " + this.MTk.eha() + ' ' + paramInt);
      parama.invoke();
      AppMethodBeat.o(189449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.f.b
 * JD-Core Version:    0.7.0.1
 */