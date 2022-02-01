package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import android.view.Surface;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.c;
import com.tencent.mm.plugin.thumbplayer.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "currentPlayState", "", "getCurrentPlayState", "()I", "setCurrentPlayState", "(I)V", "enableProgressLog", "", "getEnableProgressLog", "()Z", "setEnableProgressLog", "(Z)V", "firstPlaySeekTimeMs", "", "getFirstPlaySeekTimeMs", "()J", "setFirstPlaySeekTimeMs", "(J)V", "fromExternResourceLoader", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRealStartDownloader", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isStartCdn", "setStartCdn", "isViewFocused", "setViewFocused", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMedia", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "setMedia", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "onPlayStarted", "Lkotlin/Function1;", "", "getOnPlayStarted", "()Lkotlin/jvm/functions/Function1;", "setOnPlayStarted", "(Lkotlin/jvm/functions/Function1;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;)V", "onPrepared", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getOnPrepared", "setOnPrepared", "playEnd", "playStart", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerListener", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "getPlayerListener", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "setPlayerListener", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;)V", "progressInterval", "progressListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "progressTimer", "Ljava/util/Timer;", "progressTimerTask", "Ljava/util/TimerTask;", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;)V", "resourceLoader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "getResourceLoader", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "setResourceLoader", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;)V", "checkPlayRange", "checkProgressTimer", "createTPPlayerListener", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCurrentPositionMs", "invokePlayStartedCallback", "invokePreparedCallback", "isIdle", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "pause", "playInfo", "playWithSource", "source", "prepareVideo", "realPlay", "recycle", "seekTo", "timeMs", "accurate", "setCdnResourceLoader", "loader", "mediaInfo", "setLoop", "looper", "setMediaInfo", "setMute", "mute", "setPlayRange", "startMs", "endMs", "setProgressListener", "listener", "interval", "setSurface", "surface", "Landroid/view/Surface;", "start", "startCdnDownload", "startProgressTimer", "startToPlay", "stop", "stopAsync", "stopCdnDownload", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "MMTPResourceLoader", "TPPlayerListener", "plugin-thumbplayer_release"})
public final class b
{
  public static final a GhL;
  public b GhA;
  f GhB;
  private volatile com.tencent.mm.plugin.thumbplayer.view.e GhD;
  private long GhE;
  private Timer GhF;
  private TimerTask GhG;
  private long GhH;
  public boolean GhI;
  public boolean GhJ;
  public long GhK;
  public com.tencent.mm.plugin.thumbplayer.d.a Ghy;
  private c Ghz;
  public final String TAG;
  public kotlin.g.a.b<? super b, x> Uto;
  private kotlin.g.a.b<? super ITPPlayer, x> Utp;
  public com.tencent.mm.plugin.thumbplayer.view.g Utq;
  public com.tencent.mm.plugin.thumbplayer.d.b Utr;
  private final Context context;
  volatile int currentPlayState;
  private long wbl;
  public boolean wcA;
  public a wdC;
  private AtomicBoolean wdQ;
  public boolean wdU;
  
  static
  {
    AppMethodBeat.i(238731);
    GhL = new a((byte)0);
    AppMethodBeat.o(238731);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(238730);
    this.context = paramContext;
    this.TAG = ("MicroMsg.TP.MMCdnTPPlayer@" + hashCode());
    this.wdQ = new AtomicBoolean(true);
    this.GhE = 200L;
    this.wbl = -1L;
    this.GhH = -1L;
    this.Utr = new com.tencent.mm.plugin.thumbplayer.d.b();
    this.Ghz = new c();
    paramContext = d.GhZ;
    this.wdC = d.a.ht(this.context);
    paramContext = this.wdC;
    if (paramContext != null) {
      paramContext.setOnErrorListener((ITPPlayerListener.IOnErrorListener)this.Ghz);
    }
    paramContext = this.wdC;
    if (paramContext != null) {
      paramContext.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)this.Ghz);
    }
    paramContext = this.wdC;
    if (paramContext != null) {
      paramContext.setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)this.Ghz);
    }
    paramContext = this.wdC;
    if (paramContext != null) {
      paramContext.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)this.Ghz);
    }
    paramContext = this.wdC;
    if (paramContext != null) {
      paramContext.setOnInfoListener((ITPPlayerListener.IOnInfoListener)this.Ghz);
    }
    paramContext = this.wdC;
    if (paramContext != null) {
      paramContext.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)this.Ghz);
    }
    this.GhK = -1L;
    AppMethodBeat.o(238730);
  }
  
  private final boolean Md(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(238715);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo() source:").append(paramInt).append(" isMoovReady:");
    Object localObject1 = this.GhA;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).uTW);
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("isAllCompleted:");
      localObject1 = this.GhA;
      if (localObject1 == null) {
        break label207;
      }
    }
    label207:
    for (localObject1 = Boolean.valueOf(((b)localObject1).GhM);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("downloadUrl:");
      com.tencent.mm.plugin.thumbplayer.d.a locala = this.Ghy;
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = locala.url;
      }
      Log.i(str, (String)localObject1 + ' ' + dFm());
      if ((!asa()) && (!dFr())) {
        break label212;
      }
      Log.i(this.TAG, "prepareVideo return for state:" + this.currentPlayState);
      AppMethodBeat.o(238715);
      return false;
      localObject1 = null;
      break;
    }
    label212:
    localObject1 = this.GhA;
    if (localObject1 != null) {
      if ((!((b)localObject1).uTW) && (!((b)localObject1).GhM))
      {
        localObject2 = this.Ghy;
        if (((localObject2 == null) || (((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).dLQ != true)) && (!this.GhJ)) {}
      }
      else
      {
        Log.i(this.TAG, "real prepare player");
        localObject2 = this.wdC;
        if (localObject2 != null) {
          ((a)localObject2).setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, false));
        }
        localObject2 = this.wdC;
        if (localObject2 != null) {
          ((a)localObject2).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)localObject1);
        }
        localObject1 = this.wdC;
        if (localObject1 != null) {
          ((a)localObject1).prepareAsync();
        }
        AppMethodBeat.o(238715);
        return true;
      }
    }
    AppMethodBeat.o(238715);
    return false;
  }
  
  private final void dFn()
  {
    AppMethodBeat.i(238716);
    Log.i(this.TAG, "realPlay()");
    a locala = this.wdC;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(238716);
      return;
    }
    AppMethodBeat.o(238716);
  }
  
  private final void dFo()
  {
    AppMethodBeat.i(238717);
    if (this.wdU)
    {
      Log.i(this.TAG, "startCdnDownload() already start cdn " + dFm());
      AppMethodBeat.o(238717);
      return;
    }
    Object localObject2 = this.GhA;
    Object localObject1 = this.Ghy;
    if ((localObject2 != null) && (localObject1 != null)) {
      if ((!((b)localObject2).GhM) && (!((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ) && (!this.GhJ))
      {
        Log.i(this.TAG, "startCdnDownload");
        localObject2 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).mediaId;
        if (localObject1 != null) {
          break label179;
        }
        localObject1 = "";
      }
    }
    label179:
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.b.a)localObject2).a((String)localObject1, (com.tencent.mm.plugin.thumbplayer.b.b)new e(this), (com.tencent.mm.plugin.thumbplayer.b.e)new f(this));
      this.wdU = true;
      AppMethodBeat.o(238717);
      return;
      Log.i(this.TAG, "local file or complete or fromExternResourceLoader");
      AppMethodBeat.o(238717);
      return;
    }
  }
  
  private boolean dFr()
  {
    return this.currentPlayState == 3;
  }
  
  private final void fwT()
  {
    AppMethodBeat.i(238708);
    kotlin.g.a.b localb = this.Uto;
    if (localb != null) {
      localb.invoke(this);
    }
    this.Uto = null;
    AppMethodBeat.o(238708);
  }
  
  private boolean fwV()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void fwY()
  {
    AppMethodBeat.i(238725);
    long l1 = this.GhH;
    long l2 = this.wbl;
    if (((0L <= l2) && (l1 > l2)) || (this.GhD != null)) {}
    for (int i = 1; (i != 0) && (this.GhF == null); i = 0)
    {
      this.GhF = new Timer(this.TAG + "-progress");
      if (!isPlaying()) {
        break label137;
      }
      fxa();
      AppMethodBeat.o(238725);
      return;
    }
    if (i == 0)
    {
      dFs();
      Timer localTimer = this.GhF;
      if (localTimer != null) {
        localTimer.cancel();
      }
      this.GhF = null;
    }
    label137:
    AppMethodBeat.o(238725);
  }
  
  private final void fwZ()
  {
    AppMethodBeat.i(238726);
    a locala = this.wdC;
    if (locala != null) {}
    long l2;
    long l3;
    for (long l1 = locala.getCurrentPositionMs();; l1 = 0L)
    {
      l2 = this.GhH;
      l3 = this.wbl;
      if (0L <= l3) {
        break;
      }
      AppMethodBeat.o(238726);
      return;
    }
    if (l2 > l3)
    {
      l2 = this.wbl;
      l3 = this.GhH;
      if ((l2 > l1) || (l3 <= l1))
      {
        locala = this.wdC;
        if (locala != null)
        {
          locala.seekTo((int)this.wbl, 3);
          AppMethodBeat.o(238726);
          return;
        }
      }
    }
    AppMethodBeat.o(238726);
  }
  
  private final void fxa()
  {
    AppMethodBeat.i(238727);
    Log.i(this.TAG, "startProgressTimer " + dFm());
    this.GhG = ((TimerTask)new g(this));
    Timer localTimer = this.GhF;
    if (localTimer != null)
    {
      localTimer.schedule(this.GhG, this.GhE, this.GhE);
      AppMethodBeat.o(238727);
      return;
    }
    AppMethodBeat.o(238727);
  }
  
  public final boolean Mc(int paramInt)
  {
    AppMethodBeat.i(238714);
    Log.i(this.TAG, "playWithSource source=" + paramInt + ' ' + dFm() + ' ');
    if (!this.wcA)
    {
      Log.i(this.TAG, "playWithSource() return for isViewFocused:" + this.wcA);
      AppMethodBeat.o(238714);
      return false;
    }
    if (!fwV())
    {
      Log.i(this.TAG, "playWithSource() return for currentState:" + this.currentPlayState);
      AppMethodBeat.o(238714);
      return false;
    }
    boolean bool = isPlaying();
    if (!bool) {
      if (asa()) {
        dFn();
      }
    }
    for (;;)
    {
      dFo();
      a locala = this.wdC;
      if (locala != null) {
        locala.resumeDownload();
      }
      AppMethodBeat.o(238714);
      return true;
      Log.i(this.TAG, "playWithSource() return for isPlaying:".concat(String.valueOf(bool)));
    }
  }
  
  public final void YX(int paramInt)
  {
    AppMethodBeat.i(238710);
    Log.i(this.TAG, "seekTo:" + paramInt + ", accurate:true, isPause:" + YY());
    a locala = this.wdC;
    if (locala != null) {
      locala.seekTo(paramInt, 3);
    }
    if (YY()) {
      Mc(2);
    }
    AppMethodBeat.o(238710);
  }
  
  public final boolean YY()
  {
    return this.currentPlayState == 6;
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.view.e parame, long paramLong)
  {
    AppMethodBeat.i(238706);
    this.GhD = parame;
    if (paramLong < 0L) {
      Log.w(this.TAG, "setProgressListener: invalid interval ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      fwY();
      AppMethodBeat.o(238706);
      return;
      this.GhE = paramLong;
    }
  }
  
  public final boolean asa()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(238705);
    Log.i(this.TAG, "setPlayRange: " + paramLong1 + " - " + paramLong2);
    this.wbl = paramLong1;
    this.GhH = paramLong2;
    fwY();
    fwZ();
    AppMethodBeat.o(238705);
  }
  
  public final void b(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(238723);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setSurface() surface:");
    if (paramSurface != null) {}
    for (Object localObject = Integer.valueOf(paramSurface.hashCode());; localObject = null)
    {
      Log.i(str, localObject + ' ' + dFm());
      localObject = this.wdC;
      if (localObject != null) {
        ((a)localObject).setSurface(paramSurface);
      }
      if (paramBoolean) {
        Mc(1);
      }
      AppMethodBeat.o(238723);
      return;
    }
  }
  
  public final String dFm()
  {
    Object localObject2 = null;
    AppMethodBeat.i(238729);
    StringBuilder localStringBuilder = new StringBuilder("mediaId:");
    Object localObject1 = this.Ghy;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).mediaId;
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" isViewFocused:").append(this.wcA).append(" width:");
      localObject1 = this.Ghy;
      if (localObject1 == null) {
        break label189;
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).width);
      label75:
      localStringBuilder = localStringBuilder.append(localObject1).append(" height:");
      localObject1 = this.Ghy;
      if (localObject1 == null) {
        break label194;
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).height);
      label104:
      localStringBuilder = localStringBuilder.append(localObject1).append(" duration:");
      localObject1 = this.Ghy;
      if (localObject1 == null) {
        break label199;
      }
    }
    label189:
    label194:
    label199:
    for (localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).pLQ);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", timeOffset:");
      com.tencent.mm.plugin.thumbplayer.d.a locala = this.Ghy;
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = Long.valueOf(locala.Ghw);
      }
      localObject1 = localObject1;
      AppMethodBeat.o(238729);
      return localObject1;
      localObject1 = null;
      break;
      localObject1 = null;
      break label75;
      localObject1 = null;
      break label104;
    }
  }
  
  public final void dFp()
  {
    AppMethodBeat.i(238718);
    if (!this.wdU)
    {
      Log.i(this.TAG, "stopCdnDownload() not start cdn " + dFm());
      AppMethodBeat.o(238718);
      return;
    }
    Log.i(this.TAG, "stopCdnDownload");
    com.tencent.mm.plugin.thumbplayer.b.a locala = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
    Object localObject = this.Ghy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).mediaId;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      locala.a((String)localObject, (com.tencent.mm.plugin.thumbplayer.b.g)new i(this));
      this.wdU = false;
      localObject = this.GhA;
      if (localObject != null)
      {
        ((b)localObject).GhN = false;
        AppMethodBeat.o(238718);
        return;
      }
      AppMethodBeat.o(238718);
      return;
    }
  }
  
  public final void dFs()
  {
    AppMethodBeat.i(238728);
    Log.i(this.TAG, "stopProgressTimer " + dFm());
    TimerTask localTimerTask = this.GhG;
    if (localTimerTask != null) {
      localTimerTask.cancel();
    }
    this.GhG = null;
    AppMethodBeat.o(238728);
  }
  
  public final void fwU()
  {
    AppMethodBeat.i(238709);
    if (fwV())
    {
      Log.i(this.TAG, "already start " + dFm());
      Mc(3);
      fwT();
      AppMethodBeat.o(238709);
      return;
    }
    Object localObject3 = this.GhA;
    Object localObject1 = this.Ghy;
    Object localObject2;
    if ((localObject3 != null) && (localObject1 != null))
    {
      localObject2 = s.k(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).path, false);
      Log.i(this.TAG, "startToPlay(), cache file:" + (String)localObject2 + ", isLocal:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ + ", isExists:" + s.YS((String)localObject2) + ' ' + dFm());
      if ((!((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ) && (!((b)localObject3).GhM)) {
        break label218;
      }
      localObject3 = this.wdC;
      if (localObject3 != null) {
        ((a)localObject3).setMediaId(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).mediaId);
      }
      localObject1 = this.wdC;
      if (localObject1 != null) {
        ((a)localObject1).setDataSource((String)localObject2);
      }
    }
    for (;;)
    {
      Md(1);
      this.Utr.gXF = Util.currentTicks();
      AppMethodBeat.o(238709);
      return;
      label218:
      localObject2 = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject2).fileId(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).mediaId);
      ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
      localObject3 = this.wdC;
      if (localObject3 != null) {
        ((a)localObject3).setMediaId(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).mediaId);
      }
      localObject3 = this.wdC;
      if (localObject3 != null) {
        ((a)localObject3).setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L));
      }
      localObject3 = this.wdC;
      if (localObject3 != null) {
        ((a)localObject3).setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
      }
      localObject2 = this.wdC;
      if (localObject2 != null) {
        ((a)localObject2).setDataSource(((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).url);
      }
      dFo();
    }
  }
  
  public final void fwW()
  {
    AppMethodBeat.i(238712);
    a locala = this.wdC;
    if (locala != null)
    {
      locala.setOutputMute(true);
      AppMethodBeat.o(238712);
      return;
    }
    AppMethodBeat.o(238712);
  }
  
  public final void fwX()
  {
    AppMethodBeat.i(238719);
    Log.i(this.TAG, "updateIsReaStartDownloader() isReaStartDownloader:true");
    this.wdQ.set(true);
    AppMethodBeat.o(238719);
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(238711);
    Object localObject;
    if (isPlaying())
    {
      localObject = this.wdC;
      if (localObject != null) {
        ((a)localObject).pause();
      }
      localObject = this.wdC;
      if (localObject != null) {
        ((a)localObject).pauseDownload();
      }
    }
    if (!this.GhJ)
    {
      localObject = this.Ghy;
      if ((localObject != null) && (!((com.tencent.mm.plugin.thumbplayer.d.a)localObject).dLQ))
      {
        dFp();
        AppMethodBeat.o(238711);
        return;
      }
    }
    this.wdU = false;
    AppMethodBeat.o(238711);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(238722);
    Log.i(this.TAG, "recycle " + dFm());
    b(null, false);
    com.tencent.mm.ac.d.c("TP.Player", (kotlin.g.a.a)new d(this));
    dFs();
    Timer localTimer = this.GhF;
    if (localTimer != null) {
      localTimer.cancel();
    }
    this.GhF = null;
    this.Utq = null;
    AppMethodBeat.o(238722);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(238713);
    a locala = this.wdC;
    if (locala != null)
    {
      locala.setLoopback(paramBoolean);
      AppMethodBeat.o(238713);
      return;
    }
    AppMethodBeat.o(238713);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.d.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(238704);
    p.h(parama, "mediaInfo");
    this.Ghy = parama;
    Object localObject1 = this.GhA;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).mediaId;
      if ((p.j(localObject1, parama.mediaId) ^ true)) {
        this.GhA = new b(parama.mediaId);
      }
      localObject1 = this.TAG;
      parama = new StringBuilder("setMediaInfo, resourceLoader:");
      localObject3 = this.GhA;
      if (localObject3 == null) {
        break label158;
      }
    }
    label158:
    for (int i = localObject3.hashCode();; i = 0)
    {
      localObject3 = parama.append(i).append(", isLocal:");
      com.tencent.mm.plugin.thumbplayer.d.a locala = this.Ghy;
      parama = localObject2;
      if (locala != null) {
        parama = Boolean.valueOf(locala.dLQ);
      }
      Log.i((String)localObject1, parama);
      AppMethodBeat.o(238704);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(238720);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("stop() ").append(dFm()).append(", fromExternResourceLoader:").append(this.GhJ).append(", isLocal:");
    Object localObject = this.Ghy;
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject).dLQ);; localObject = null)
    {
      Log.i(str, localObject);
      if (fwV()) {
        break;
      }
      Log.i(this.TAG, "stop() return for isStartPlay. " + dFm());
      AppMethodBeat.o(238720);
      return;
    }
    dFs();
    this.GhD = null;
    this.Utq = null;
    this.GhK = -1L;
    localObject = this.wdC;
    if (localObject != null) {
      ((a)localObject).stop();
    }
    localObject = this.wdC;
    if (localObject != null) {
      ((a)localObject).reset();
    }
    if (!this.GhJ)
    {
      localObject = this.Ghy;
      if ((localObject != null) && (!((com.tencent.mm.plugin.thumbplayer.d.a)localObject).dLQ)) {
        dFp();
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "stop() end " + dFm());
      AppMethodBeat.o(238720);
      return;
      this.wdU = false;
    }
  }
  
  public final void stopAsync()
  {
    AppMethodBeat.i(238721);
    Log.i(this.TAG, "stopAsync() " + dFm());
    this.Utr.stop();
    com.tencent.mm.ac.d.c("TP.Player", (kotlin.g.a.a)new h(this));
    AppMethodBeat.o(238721);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$Companion;", "", "()V", "DEFAULT_PROGRESS_INTERVAL", "", "plugin-thumbplayer_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "mediaId", "", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;Ljava/lang/String;)V", "MAX_REQUETS_LENGTH", "", "getMAX_REQUETS_LENGTH", "()J", "isAllComplete", "", "()Z", "setAllComplete", "(Z)V", "isMoovReady", "setMoovReady", "isRequestingData", "setRequestingData", "getMediaId", "()Ljava/lang/String;", "onAllComplete", "Lkotlin/Function2;", "", "", "getOnAllComplete", "()Lkotlin/jvm/functions/Function2;", "setOnAllComplete", "(Lkotlin/jvm/functions/Function2;)V", "requestNumber", "getRequestNumber", "()I", "setRequestNumber", "(I)V", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "offset", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopCdnDownload", "onStopReadData", "requestId", "resourceInfo", "plugin-thumbplayer_release"})
  public final class b
    extends h.a.a.a.a.a.a.a.a.a.a.a
    implements h.a
  {
    public boolean GhM;
    boolean GhN;
    public m<? super String, ? super Integer, x> GhO;
    private final long GhP;
    public final String mediaId;
    public boolean uTW;
    private int wed;
    
    public b()
    {
      AppMethodBeat.i(238693);
      this.mediaId = localObject;
      this.GhP = 1048576L;
      AppMethodBeat.o(238693);
    }
    
    private final String fxb()
    {
      AppMethodBeat.i(238682);
      String str = b.this.dFm() + " isMoovReady:" + this.uTW + " isAllComplete:" + this.GhM + " isRequestingData:" + this.GhN;
      AppMethodBeat.o(238682);
      return str;
    }
    
    public final void Ds(String paramString) {}
    
    public final String Mf(int paramInt)
    {
      AppMethodBeat.i(238689);
      Object localObject = b.this.Ghy;
      if (localObject != null)
      {
        String str = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).path;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localObject = s.k((String)localObject, false);
      AppMethodBeat.o(238689);
      return localObject;
    }
    
    public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(238686);
      this.GhM = true;
      paramd = this.GhO;
      if (paramd != null)
      {
        paramd.invoke(paramString, Integer.valueOf(paramInt));
        AppMethodBeat.o(238686);
        return;
      }
      AppMethodBeat.o(238686);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(238683);
      this.uTW = true;
      b.a(b.this, 2);
      AppMethodBeat.o(238683);
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(238690);
      Log.i(b.b(b.this), "getContentType() fileId:" + paramInt + ", fileKey:" + paramString + " contentType:" + "video/mp4" + ' ' + fxb());
      AppMethodBeat.o(238690);
      return "video/mp4";
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(238687);
      Object localObject = b.this.Ghy;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).path;; localObject = null)
      {
        long l = s.boW((String)localObject);
        Log.i(b.b(b.this), "getDataTotalSize() fileId:" + paramInt + ", fileKey:" + paramString + " fileLength:" + l + ' ' + fxb());
        AppMethodBeat.o(238687);
        return l;
      }
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(238685);
      Log.i(b.b(b.this), "onProgress mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2 + ' ' + fxb());
      AppMethodBeat.o(238685);
    }
    
    public final int k(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(238688);
      long l1;
      if (this.GhM) {
        l1 = paramLong2;
      }
      for (;;)
      {
        if ((l1 == 0L) && (!this.GhN) && (this.uTW) && (b.this.wdU))
        {
          final long l2 = j.aN(paramLong2, this.GhP);
          paramInt = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)paramLong1, (int)l2, (c)new a(this, l2));
          if (paramInt > 0) {
            this.GhN = true;
          }
          Log.i(b.b(b.this), "requestVideoData requestDataRet:" + paramInt + " requestLength:" + l2);
        }
        if (l1 > 0L) {
          Log.i(b.b(b.this), "onReadData() offset:" + paramLong1 + " length:" + paramLong2 + " returnLength:" + l1 + ' ' + fxb());
        }
        for (;;)
        {
          paramInt = (int)l1;
          AppMethodBeat.o(238688);
          return paramInt;
          long[] arrayOfLong = new long[2];
          if ((CdnLogic.queryContinuousSize(this.mediaId, paramLong1, arrayOfLong) != 0) || (arrayOfLong[0] <= 0L)) {
            break label315;
          }
          l1 = Math.min(arrayOfLong[0], paramLong2);
          break;
          Log.d(b.b(b.this), "onReadData() offset:" + paramLong1 + " length:" + paramLong2 + ' ' + fxb());
        }
        label315:
        l1 = 0L;
      }
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(238684);
      Log.i(b.b(b.this), "onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + ' ' + fxb());
      this.GhN = false;
      AppMethodBeat.o(238684);
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(238691);
      Log.i(b.b(b.this), "onStartReadData() fileId:" + paramInt + ", fileKey:" + paramString + " requestStart:" + paramLong1 + " requestEnd:" + paramLong2 + ' ' + fxb());
      paramInt = this.wed;
      this.wed = (paramInt + 1);
      AppMethodBeat.o(238691);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(238692);
      Log.i(b.b(b.this), "onStopReadData() fileId:" + paramInt1 + ", fileKey:" + paramString + " requestId:" + paramInt2 + ' ' + fxb());
      paramInt1 = this.wed;
      AppMethodBeat.o(238692);
      return paramInt1;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-thumbplayer_release"})
    public static final class a
      implements c
    {
      a(long paramLong) {}
      
      public final void Mg(int paramInt)
      {
        AppMethodBeat.i(238681);
        if (paramInt != 0)
        {
          Log.w(b.b(this.GhR.GhQ), "requestedResource() requestVideoData fail, ret:" + paramInt + ' ' + this);
          this.GhR.GhN = false;
          AppMethodBeat.o(238681);
          return;
        }
        Log.i(b.b(this.GhR.GhQ), "requestVideoData requestDataRet:" + paramInt + " requestLength:" + l2);
        AppMethodBeat.o(238681);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onStateChange", "preState", "curState", "onVideoSizeChanged", "width", "height", "plugin-thumbplayer_release"})
  public final class c
    implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(238696);
      Log.i(b.b(this.GhQ), "onCompletion");
      AppMethodBeat.o(238696);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(238697);
      Log.i(b.b(this.GhQ), "onError errorType:" + paramInt1 + " errorCode:" + paramInt2 + ' ' + this.GhQ.dFm());
      this.GhQ.Utr.errType = paramInt1;
      this.GhQ.Utr.errCode = paramInt2;
      AppMethodBeat.o(238697);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(258719);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(258719);
        return;
        this.GhQ.Utr.Utb = Util.currentTicks();
        AppMethodBeat.o(258719);
        return;
        paramITPPlayer = this.GhQ.Utr;
        if (paramITPPlayer.Utb > 0L)
        {
          paramITPPlayer.UsZ += 1;
          paramITPPlayer.Uta += Util.ticksToNow(paramITPPlayer.Utb);
        }
        paramITPPlayer.Utb = 0L;
        AppMethodBeat.o(258719);
        return;
        AppMethodBeat.o(258719);
        return;
        paramITPPlayer = this.GhQ.Utr;
        paramITPPlayer.UsY = Util.ticksToNow(paramITPPlayer.gXF);
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(238694);
      this.GhQ.Mc(0);
      if ((this.GhQ.Ghy != null) && (this.GhQ.GhK > 0L))
      {
        this.GhQ.YX((int)this.GhQ.GhK);
        Log.i(b.b(this.GhQ), "seek to play " + this.GhQ.GhK + ' ' + this.GhQ.dFm());
      }
      b.a(this.GhQ, paramITPPlayer);
      AppMethodBeat.o(238694);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238695);
      Log.i(b.b(this.GhQ), "onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + this.GhQ.dFm());
      this.GhQ.currentPlayState = paramInt2;
      if ((paramInt2 == 9) || (paramInt2 == 1))
      {
        Log.i(b.b(this.GhQ), "onStateChange() player stop or idle " + this.GhQ.dFm());
        this.GhQ.GhB = null;
      }
      com.tencent.mm.plugin.thumbplayer.d.a locala;
      com.tencent.mm.plugin.thumbplayer.view.g localg;
      if (paramInt2 == 5)
      {
        b.c(this.GhQ);
        locala = this.GhQ.Ghy;
        if (locala != null)
        {
          localg = this.GhQ.Utq;
          if (localg != null) {
            localg.b(locala);
          }
        }
      }
      if (paramInt2 == 6)
      {
        locala = this.GhQ.Ghy;
        if (locala != null)
        {
          localg = this.GhQ.Utq;
          if (localg != null) {
            localg.a(locala);
          }
        }
      }
      if (this.GhQ.isPlaying())
      {
        b.d(this.GhQ);
        AppMethodBeat.o(238695);
        return;
      }
      this.GhQ.dFs();
      AppMethodBeat.o(238695);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-thumbplayer_release"})
  public static final class e
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    e(b paramb) {}
    
    public final h awH(String paramString)
    {
      AppMethodBeat.i(238699);
      p.h(paramString, "id");
      b localb = this.GhQ;
      paramString = com.tencent.mm.plugin.thumbplayer.a.Ggt;
      paramString = localb.Ghy;
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
      Object localObject1 = localb.Ghy;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).url;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localb.Ghy;
      if (localObject2 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).path;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      Object localObject3 = localb.Ghy;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject3).Ghr;
        if (localObject3 == null) {}
      }
      for (int i = ((Integer)localObject3).intValue();; i = 2)
      {
        localObject3 = localb.Ghy;
        if (localObject3 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject3).viB;
          localObject3 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject3 = "";
        }
        Object localObject4 = localb.Ghy;
        if (localObject4 != null)
        {
          String str = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).decodeKey;
          localObject4 = str;
          if (str != null) {}
        }
        else
        {
          localObject4 = "";
        }
        paramString = com.tencent.mm.plugin.thumbplayer.a.a(paramString, (String)localObject1, (String)localObject2, i, "xV2", (String)localObject3, (String)localObject4, (h.a)localb.GhA, localb.TAG);
        AppMethodBeat.o(238699);
        return paramString;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-thumbplayer_release"})
  public static final class f
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    f(b paramb) {}
    
    public final void JS(int paramInt)
    {
      AppMethodBeat.i(238700);
      Log.i(b.b(this.GhQ), "startCdnDownload()#onStart " + this.GhQ.dFm() + ' ' + paramInt);
      if (paramInt == 0)
      {
        b.e(this.GhQ);
        AppMethodBeat.o(238700);
        return;
      }
      if (paramInt == 1)
      {
        b.b localb = this.GhQ.GhA;
        if (localb != null) {
          localb.GhM = true;
        }
        localb = this.GhQ.GhA;
        if (localb != null) {
          localb.uTW = true;
        }
        b.a(this.GhQ, 4);
      }
      AppMethodBeat.o(238700);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class g
    extends TimerTask
  {
    public g(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(238701);
      Object localObject = this.GhQ.wdC;
      if (localObject != null) {}
      for (long l = ((a)localObject).getCurrentPositionMs();; l = 0L)
      {
        if (this.GhQ.GhI) {
          Log.d(b.b(this.GhQ), "onProgress currentMs:".concat(String.valueOf(l)));
        }
        localObject = b.f(this.GhQ);
        if (localObject != null) {
          ((com.tencent.mm.plugin.thumbplayer.view.e)localObject).Hv(l);
        }
        b.g(this.GhQ);
        AppMethodBeat.o(238701);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$stopCdnDownload$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-thumbplayer_release"})
  public static final class i
    implements com.tencent.mm.plugin.thumbplayer.b.g
  {
    public final void a(int paramInt, h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(238703);
      Log.i(b.b(this.GhQ), "stopCdnDownload()#onStop(), real cancel download task " + this.GhQ.dFm() + ' ' + paramInt);
      AppMethodBeat.o(238703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.b
 * JD-Core Version:    0.7.0.1
 */