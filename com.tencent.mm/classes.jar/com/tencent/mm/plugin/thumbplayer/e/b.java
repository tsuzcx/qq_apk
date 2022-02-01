package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import android.view.Surface;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.g;
import com.tencent.mm.plugin.thumbplayer.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "audioStreamType", "", "getAudioStreamType", "()I", "setAudioStreamType", "(I)V", "getContext", "()Landroid/content/Context;", "currentPlayState", "getCurrentPlayState", "setCurrentPlayState", "enableProgressLog", "", "getEnableProgressLog", "()Z", "setEnableProgressLog", "(Z)V", "firstPlaySeekTimeMs", "", "getFirstPlaySeekTimeMs", "()J", "setFirstPlaySeekTimeMs", "(J)V", "fromExternResourceLoader", "isLoop", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRealStartDownloader", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isStartCdn", "setStartCdn", "isViewFocused", "setViewFocused", "media", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "getMedia", "()Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "setMedia", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;)V", "value", "Lkotlin/Function1;", "", "onAudioPlayStarted", "getOnAudioPlayStarted", "()Lkotlin/jvm/functions/Function1;", "setOnAudioPlayStarted", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function3;", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "getOnError", "()Lkotlin/jvm/functions/Function3;", "setOnError", "(Lkotlin/jvm/functions/Function3;)V", "onFirstFrameRendered", "getOnFirstFrameRendered", "setOnFirstFrameRendered", "onPlayCompleted", "getOnPlayCompleted", "setOnPlayCompleted", "onPlayStarted", "getOnPlayStarted", "setOnPlayStarted", "onPlayerStopListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;)V", "onPrepared", "getOnPrepared", "setOnPrepared", "onSeekCompleted", "onlyAudio", "getOnlyAudio", "setOnlyAudio", "playEnd", "getPlayEnd", "setPlayEnd", "playStart", "getPlayStart", "setPlayStart", "playWhenReady", "getPlayWhenReady", "setPlayWhenReady", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerListener", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "getPlayerListener", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "setPlayerListener", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;)V", "progressEnable", "progressFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "progressInterval", "progressListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;)V", "resourceLoader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "getResourceLoader", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "setResourceLoader", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;)V", "checkPlayRange", "checkProgressTimer", "createTPPlayerListener", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCurrentPositionMs", "invokeFirstFrameRenderedCallback", "invokeOnCompletedCallback", "invokeOnErrorCallback", "invokePlayStartedCallback", "invokePreparedCallback", "isIdle", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "pause", "stopDownload", "pauseWhileKeepDownload", "playInfo", "playWithSource", "source", "prepare", "prepareVideo", "realPlay", "recycle", "seekTo", "timeMs", "accurate", "callback", "setCdnResourceLoader", "loader", "mediaInfo", "setLoop", "looper", "setMediaInfo", "setMute", "mute", "setPlayRange", "startMs", "endMs", "setProgressListener", "listener", "interval", "setSurface", "surface", "Landroid/view/Surface;", "start", "setVolume", "volume", "", "startCdnDownload", "startProgressTimer", "startToPlay", "stop", "stopAsync", "stopCdnDownload", "finish", "Lkotlin/Function0;", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "MMTPResourceLoader", "TPPlayerListener", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
{
  public static final b.a TFa;
  public a Flb;
  private AtomicBoolean Flm;
  public boolean Flr;
  public boolean Flw;
  public long GmG;
  public final String TAG;
  kotlin.g.a.b<? super b, ah> TEe;
  public com.tencent.mm.plugin.thumbplayer.a.b TFb;
  private c TFc;
  public b TFd;
  public f TFe;
  kotlin.g.a.b<? super b, ah> TFf;
  public kotlin.g.a.b<? super ITPPlayer, ah> TFg;
  kotlin.g.a.b<? super ITPPlayer, ah> TFh;
  public kotlin.g.a.b<? super b, ah> TFi;
  private q<? super ITPPlayer, ? super Integer, ? super Integer, ah> TFj;
  public com.tencent.mm.plugin.thumbplayer.view.c TFk;
  private volatile com.tencent.mm.plugin.thumbplayer.view.e TFl;
  private long TFm;
  private boolean TFn;
  private com.tencent.threadpool.i.d<?> TFo;
  public long TFp;
  public int TFq;
  public boolean TFr;
  public boolean TFs;
  private kotlin.g.a.b<? super ITPPlayer, ah> TFt;
  public com.tencent.mm.plugin.thumbplayer.d.a TFu;
  public long TFv;
  public boolean akjm;
  boolean cFG;
  private final Context context;
  public volatile int currentPlayState;
  private boolean oYG;
  
  static
  {
    AppMethodBeat.i(272333);
    TFa = new b.a((byte)0);
    AppMethodBeat.o(272333);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(272170);
    this.context = paramContext;
    this.TAG = s.X("MicroMsg.TP.MMCdnTPPlayer@", Integer.valueOf(hashCode()));
    this.Flm = new AtomicBoolean(true);
    this.TFm = 200L;
    this.GmG = -1L;
    this.TFp = -1L;
    this.TFq = 3;
    this.TFu = new com.tencent.mm.plugin.thumbplayer.d.a();
    this.TFc = new c();
    paramContext = d.TFK;
    this.Flb = d.a.kr(this.context);
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnErrorListener((ITPPlayerListener.IOnErrorListener)this.TFc);
    }
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)this.TFc);
    }
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)this.TFc);
    }
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)this.TFc);
    }
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnInfoListener((ITPPlayerListener.IOnInfoListener)this.TFc);
    }
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)this.TFc);
    }
    paramContext = this.Flb;
    if (paramContext != null) {
      paramContext.setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)this.TFc);
    }
    this.TFv = -1L;
    AppMethodBeat.o(272170);
  }
  
  private final void hLe()
  {
    AppMethodBeat.i(272187);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.d(this));
    AppMethodBeat.o(272187);
  }
  
  private final void hLf()
  {
    AppMethodBeat.i(272192);
    kotlin.g.a.b localb = this.TFh;
    if (localb != null) {
      localb.invoke(this.Flb);
    }
    aH(null);
    AppMethodBeat.o(272192);
  }
  
  private final void hLg()
  {
    AppMethodBeat.i(272198);
    q localq = this.TFj;
    if (localq != null) {
      localq.invoke(this.Flb, Integer.valueOf(this.TFu.errCode), Integer.valueOf(this.TFu.errType));
    }
    AppMethodBeat.o(272198);
  }
  
  private final void hLj()
  {
    AppMethodBeat.i(272221);
    Log.i(this.TAG, "realPlay()");
    a locala = this.Flb;
    if (locala != null) {
      locala.start();
    }
    AppMethodBeat.o(272221);
  }
  
  private final void hLl()
  {
    AppMethodBeat.i(272241);
    long l1 = this.TFp;
    long l2 = this.GmG;
    if (0L <= l2) {
      if (l2 < l1)
      {
        i = 1;
        if ((i == 0) && (this.TFl == null)) {
          break label90;
        }
      }
    }
    label90:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (this.TFn)) {
        break label95;
      }
      this.TFn = true;
      if (!isPlaying()) {
        break label133;
      }
      hLn();
      AppMethodBeat.o(272241);
      return;
      i = 0;
      break;
      i = 0;
      break;
    }
    label95:
    if (i == 0)
    {
      eLO();
      com.tencent.threadpool.i.d locald = this.TFo;
      if (locald != null) {
        locald.cancel(false);
      }
      this.TFo = null;
      this.TFn = false;
    }
    label133:
    AppMethodBeat.o(272241);
  }
  
  private final void hLm()
  {
    long l2 = 0L;
    AppMethodBeat.i(272249);
    a locala = this.Flb;
    long l1;
    int i;
    if (locala == null)
    {
      l1 = 0L;
      long l3 = this.TFp;
      long l4 = this.GmG;
      if (0L > l4) {
        break label161;
      }
      if (l4 >= l3) {
        break label156;
      }
      i = 1;
      label51:
      if (i == 0) {
        break label247;
      }
      l3 = this.GmG;
      l4 = this.TFp;
      locala = this.Flb;
      if (locala != null) {
        break label166;
      }
      label78:
      if (l1 >= Math.min(l4, l2 - 34L)) {
        break label183;
      }
      if (l3 > l1) {
        break label178;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (this.oYG)
        {
          locala = this.Flb;
          if (locala == null) {
            break label247;
          }
          locala.seekTo((int)this.GmG, 3);
          AppMethodBeat.o(272249);
          return;
          l1 = locala.getCurrentPositionMs();
          break;
          label156:
          i = 0;
          break label51;
          label161:
          i = 0;
          break label51;
          label166:
          l2 = locala.getDurationMs();
          break label78;
          label178:
          i = 0;
          continue;
          label183:
          i = 0;
          continue;
        }
        Log.i(this.TAG, "checkPlayRange currentMs:" + l1 + " not in playRange:[" + this.GmG + ", " + this.TFp + ']');
        stop();
      }
    }
    label247:
    AppMethodBeat.o(272249);
  }
  
  private final void hLn()
  {
    AppMethodBeat.i(272256);
    Log.i(this.TAG, s.X("startProgressTimer ", hLo()));
    TimerTask localTimerTask = (TimerTask)new h(this);
    com.tencent.threadpool.i.d locald = this.TFo;
    if (locald != null) {
      locald.cancel(false);
    }
    this.TFo = com.tencent.threadpool.h.ahAA.b((Runnable)localTimerTask, this.TFm, this.TFm);
    AppMethodBeat.o(272256);
  }
  
  public final boolean RP(int paramInt)
  {
    AppMethodBeat.i(272474);
    Log.i(this.TAG, "playWithSource source=" + paramInt + ' ' + hLo() + ' ');
    if (!this.Flr)
    {
      Log.i(this.TAG, s.X("playWithSource() return for isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(272474);
      return false;
    }
    if (!hLi())
    {
      Log.i(this.TAG, s.X("playWithSource() return for currentState:", Integer.valueOf(this.currentPlayState)));
      AppMethodBeat.o(272474);
      return false;
    }
    boolean bool = isPlaying();
    if (!bool) {
      if (cxs()) {
        hLj();
      }
    }
    for (;;)
    {
      fjg();
      a locala = this.Flb;
      if (locala != null) {
        locala.resumeDownload();
      }
      AppMethodBeat.o(272474);
      return true;
      Log.i(this.TAG, s.X("playWithSource() return for isPlaying:", Boolean.valueOf(bool)));
    }
  }
  
  public final boolean RQ(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(272481);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo() source:").append(paramInt).append(" isMoovReady:");
    Object localObject1 = this.TFd;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" isAllCompleted:");
      localObject1 = this.TFd;
      if (localObject1 != null) {
        break label176;
      }
      localObject1 = null;
      label72:
      localStringBuilder = localStringBuilder.append(localObject1).append(" downloadUrl:");
      localObject1 = this.TFb;
      if (localObject1 != null) {
        break label187;
      }
    }
    label176:
    label187:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).url)
    {
      Log.i(str, localObject1 + ' ' + hLo());
      if ((!cxs()) && (!cNW())) {
        break label195;
      }
      Log.i(this.TAG, s.X("prepareVideo return for state:", Integer.valueOf(this.currentPlayState)));
      AppMethodBeat.o(272481);
      return false;
      localObject1 = Boolean.valueOf(((b)localObject1).EUK);
      break;
      localObject1 = Boolean.valueOf(((b)localObject1).TFw);
      break label72;
    }
    label195:
    localObject1 = this.TFd;
    if (localObject1 != null)
    {
      if ((!((b)localObject1).EUK) && (!((b)localObject1).TFw))
      {
        localObject2 = this.TFb;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).hJv != true)) {
          break label335;
        }
      }
      label335:
      for (paramInt = 1; (paramInt != 0) || (this.TFs) || (this.akjm); paramInt = 0)
      {
        Log.i(this.TAG, "real prepare player");
        localObject2 = this.Flb;
        if (localObject2 != null) {
          ((a)localObject2).setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, false));
        }
        localObject2 = this.Flb;
        if (localObject2 != null) {
          ((a)localObject2).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)localObject1);
        }
        localObject1 = this.Flb;
        if (localObject1 != null) {
          ((a)localObject1).prepareAsync();
        }
        AppMethodBeat.o(272481);
        return true;
      }
    }
    AppMethodBeat.o(272481);
    return false;
  }
  
  public final void a(int paramInt, boolean paramBoolean, kotlin.g.a.b<? super ITPPlayer, ah> paramb)
  {
    AppMethodBeat.i(272428);
    Log.i(this.TAG, "seekTo:" + paramInt + ", accurate:" + paramBoolean + ", isPause:" + aFF());
    this.TFt = paramb;
    if (paramBoolean)
    {
      paramb = this.Flb;
      if (paramb != null) {
        paramb.seekTo(paramInt, 3);
      }
    }
    for (;;)
    {
      if (isPlaying()) {
        RP(2);
      }
      AppMethodBeat.o(272428);
      return;
      paramb = this.Flb;
      if (paramb != null) {
        paramb.seekTo(paramInt);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.view.e parame, long paramLong)
  {
    AppMethodBeat.i(272390);
    this.TFl = parame;
    if (paramLong < 0L) {
      Log.w(this.TAG, s.X("setProgressListener: invalid interval ", Long.valueOf(paramLong)));
    }
    for (;;)
    {
      hLl();
      AppMethodBeat.o(272390);
      return;
      this.TFm = paramLong;
    }
  }
  
  public final void aF(kotlin.g.a.b<? super b, ah> paramb)
  {
    AppMethodBeat.i(272341);
    this.TEe = paramb;
    if ((isPlaying()) && (paramb != null)) {
      hLe();
    }
    AppMethodBeat.o(272341);
  }
  
  public final boolean aFF()
  {
    return this.currentPlayState == 6;
  }
  
  public final void aG(kotlin.g.a.b<? super b, ah> paramb)
  {
    AppMethodBeat.i(272348);
    this.TFf = paramb;
    if ((isPlaying()) && (paramb != null)) {
      hLe();
    }
    AppMethodBeat.o(272348);
  }
  
  public final void aH(kotlin.g.a.b<? super ITPPlayer, ah> paramb)
  {
    AppMethodBeat.i(272355);
    this.TFh = paramb;
    if (this.TFu.wNr > 0L) {
      hLf();
    }
    AppMethodBeat.o(272355);
  }
  
  public final void b(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(272544);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setSurface() surface:");
    if (paramSurface == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramSurface.hashCode()))
    {
      Log.i(str, localObject + ' ' + hLo());
      localObject = this.Flb;
      if (localObject != null) {
        ((a)localObject).setSurface(paramSurface);
      }
      if (paramBoolean) {
        RP(1);
      }
      AppMethodBeat.o(272544);
      return;
    }
  }
  
  public final void b(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(272396);
    kotlin.g.a.b localb = this.TFg;
    if (localb != null) {
      localb.invoke(paramITPPlayer);
    }
    AppMethodBeat.o(272396);
  }
  
  public void bD(final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(272495);
    s.u(parama, "finish");
    if (!this.Flw)
    {
      Log.i(this.TAG, s.X("stopCdnDownload() not start cdn ", hLo()));
      parama.invoke();
      AppMethodBeat.o(272495);
      return;
    }
    Log.i(this.TAG, "stopCdnDownload");
    com.tencent.mm.plugin.thumbplayer.b.a locala = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
    Object localObject = this.TFb;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      locala.a((String)localObject, (g)new k(this, parama));
      this.Flw = false;
      parama = this.TFd;
      if (parama != null) {
        parama.TFx = false;
      }
      AppMethodBeat.o(272495);
      return;
      localObject = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).mediaId;
      if (localObject == null) {
        localObject = "";
      }
    }
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272380);
    Log.i(this.TAG, "setPlayRange: " + paramLong1 + " - " + paramLong2);
    this.GmG = paramLong1;
    this.TFp = paramLong2;
    hLl();
    hLm();
    AppMethodBeat.o(272380);
  }
  
  public final boolean cNW()
  {
    return this.currentPlayState == 3;
  }
  
  public final boolean cxs()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final void eLO()
  {
    AppMethodBeat.i(272557);
    Log.i(this.TAG, s.X("stopProgressTimer ", hLo()));
    com.tencent.threadpool.i.d locald = this.TFo;
    if (locald != null) {
      locald.cancel(false);
    }
    this.TFo = null;
    AppMethodBeat.o(272557);
  }
  
  public void fjg()
  {
    AppMethodBeat.i(272488);
    if (this.Flw)
    {
      Log.i(this.TAG, s.X("startCdnDownload() already start cdn ", hLo()));
      AppMethodBeat.o(272488);
      return;
    }
    Object localObject = this.TFd;
    final com.tencent.mm.plugin.thumbplayer.a.b localb = this.TFb;
    if ((localObject != null) && (localb != null))
    {
      if ((!((b)localObject).TFw) && (!localb.hJv) && (!this.TFs))
      {
        Log.i(this.TAG, "startCdnDownload");
        com.tencent.mm.plugin.thumbplayer.b.a locala = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
        localObject = localb.mediaId;
        if (localObject == null) {
          localObject = "";
        }
        for (;;)
        {
          locala.a((String)localObject, (com.tencent.mm.plugin.thumbplayer.b.b)new f(this), (com.tencent.mm.plugin.thumbplayer.b.e)new g(this, localb));
          this.Flw = true;
          AppMethodBeat.o(272488);
          return;
        }
      }
      Log.i(this.TAG, "local file or complete or fromExternResourceLoader");
    }
    AppMethodBeat.o(272488);
  }
  
  public com.tencent.mm.g.h fvc()
  {
    AppMethodBeat.i(272512);
    Object localObject1 = com.tencent.mm.plugin.thumbplayer.b.TBI;
    localObject1 = this.TFb;
    Object localObject2;
    label36:
    Object localObject3;
    label52:
    Object localObject4;
    int i;
    label65:
    label81:
    Object localObject5;
    label97:
    Object localObject6;
    label113:
    Object localObject7;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = this.TFb;
      if (localObject2 != null) {
        break label183;
      }
      localObject2 = "";
      localObject3 = this.TFb;
      if (localObject3 != null) {
        break label204;
      }
      localObject3 = "";
      localObject4 = this.TFb;
      if (localObject4 != null) {
        break label228;
      }
      i = 2;
      localObject4 = this.TFb;
      if (localObject4 != null) {
        break label237;
      }
      localObject4 = "xV2";
      localObject5 = this.TFb;
      if (localObject5 != null) {
        break label261;
      }
      localObject5 = "";
      localObject6 = this.TFb;
      if (localObject6 != null) {
        break label285;
      }
      localObject6 = "";
      localObject7 = this.TFb;
      if (localObject7 != null) {
        break label309;
      }
      localObject7 = "";
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.thumbplayer.b.a((String)localObject1, (String)localObject2, (String)localObject3, i, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (h.a)this.TFd, this.TAG);
      AppMethodBeat.o(272512);
      return localObject1;
      localObject2 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label183:
      localObject3 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).url;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label36;
      }
      localObject2 = "";
      break label36;
      label204:
      localObject4 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject3).path;
      localObject3 = localObject4;
      if (localObject4 != null) {
        break label52;
      }
      localObject3 = "";
      break label52;
      label228:
      i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBJ;
      break label65;
      label237:
      localObject5 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).hVy;
      localObject4 = localObject5;
      if (localObject5 != null) {
        break label81;
      }
      localObject4 = "xV2";
      break label81;
      label261:
      localObject6 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject5).msf;
      localObject5 = localObject6;
      if (localObject6 != null) {
        break label97;
      }
      localObject5 = "";
      break label97;
      label285:
      localObject7 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject6).decodeKey;
      localObject6 = localObject7;
      if (localObject7 != null) {
        break label113;
      }
      localObject6 = "";
      break label113;
      label309:
      String str = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).videoFlag;
      localObject7 = str;
      if (str == null) {
        localObject7 = "";
      }
    }
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(272551);
    a locala = this.Flb;
    if (locala == null)
    {
      AppMethodBeat.o(272551);
      return 0L;
    }
    long l = locala.getCurrentPositionMs();
    AppMethodBeat.o(272551);
    return l;
  }
  
  public final void hLh()
  {
    AppMethodBeat.i(272419);
    if (hLi())
    {
      Log.i(this.TAG, s.X("already start ", hLo()));
      RP(3);
      if (isPlaying()) {
        hLe();
      }
      AppMethodBeat.o(272419);
      return;
    }
    this.cFG = true;
    prepare();
    AppMethodBeat.o(272419);
  }
  
  public final boolean hLi()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final void hLk()
  {
    AppMethodBeat.i(272502);
    Log.i(this.TAG, s.X("updateIsReaStartDownloader() isReaStartDownloader:", Boolean.TRUE));
    this.Flm.set(true);
    AppMethodBeat.o(272502);
  }
  
  public final String hLo()
  {
    Object localObject2 = null;
    AppMethodBeat.i(272564);
    StringBuilder localStringBuilder = new StringBuilder("mediaId:");
    Object localObject1 = this.TFb;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" isViewFocused:").append(this.Flr).append(" width:");
      localObject1 = this.TFb;
      if (localObject1 != null) {
        break label160;
      }
      localObject1 = null;
      label66:
      localStringBuilder = localStringBuilder.append(localObject1).append(" height:");
      localObject1 = this.TFb;
      if (localObject1 != null) {
        break label171;
      }
      localObject1 = null;
      label89:
      localStringBuilder = localStringBuilder.append(localObject1).append(" duration:");
      localObject1 = this.TFb;
      if (localObject1 != null) {
        break label182;
      }
      localObject1 = null;
      label112:
      localStringBuilder = localStringBuilder.append(localObject1).append(", timeOffset:");
      localObject1 = this.TFb;
      if (localObject1 != null) {
        break label193;
      }
    }
    label160:
    label171:
    label182:
    label193:
    for (localObject1 = localObject2;; localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).TBO))
    {
      localObject1 = localObject1;
      AppMethodBeat.o(272564);
      return localObject1;
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
      break;
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width);
      break label66;
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height);
      break label89;
      localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).vYw);
      break label112;
    }
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void j(q<? super ITPPlayer, ? super Integer, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(272361);
    this.TFj = paramq;
    if (this.TFu.hLa()) {
      hLg();
    }
    AppMethodBeat.o(272361);
  }
  
  public void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(272433);
    if ((hLi()) && (isPlaying()))
    {
      Object localObject = this.Flb;
      if (localObject != null) {
        ((a)localObject).pause();
      }
      if (paramBoolean)
      {
        localObject = this.Flb;
        if (localObject != null) {
          ((a)localObject).pauseDownload();
        }
      }
      if (!paramBoolean) {
        break label116;
      }
      if (this.TFs) {
        break label111;
      }
      localObject = this.TFb;
      if ((localObject == null) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject).hJv)) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label111;
      }
      c(this);
      AppMethodBeat.o(272433);
      return;
      cNW();
      break;
    }
    label111:
    this.Flw = false;
    label116:
    AppMethodBeat.o(272433);
  }
  
  public void prepare()
  {
    AppMethodBeat.i(272411);
    Object localObject3 = this.TFd;
    Object localObject1 = this.TFb;
    Object localObject2;
    if ((localObject3 != null) && (localObject1 != null))
    {
      localObject2 = y.n(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).path, false);
      Log.i(this.TAG, "startToPlay(), cache file:" + localObject2 + ", isLocal:" + ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv + ", isExists:" + y.ZC((String)localObject2) + ' ' + hLo());
      if ((!((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv) && (!((b)localObject3).TFw)) {
        break label209;
      }
      localObject3 = this.Flb;
      if (localObject3 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
        s.s(localObject1, "media.mediaId");
        ((a)localObject3).setMediaId((String)localObject1);
      }
      localObject1 = this.Flb;
      if (localObject1 != null) {
        ((a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildLong(302, this.TFq));
      }
      localObject1 = this.Flb;
      if (localObject1 != null) {
        ((a)localObject1).setDataSource((String)localObject2);
      }
    }
    for (;;)
    {
      RQ(1);
      this.TFu.moe = Util.currentTicks();
      AppMethodBeat.o(272411);
      return;
      label209:
      localObject2 = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject2).fileId(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId);
      ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
      localObject3 = this.Flb;
      if (localObject3 != null)
      {
        String str = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
        s.s(str, "media.mediaId");
        ((a)localObject3).setMediaId(str);
      }
      localObject3 = this.Flb;
      if (localObject3 != null) {
        ((a)localObject3).setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildLong(302, this.TFq));
      }
      localObject3 = this.Flb;
      if (localObject3 != null) {
        ((a)localObject3).setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
      }
      localObject2 = this.Flb;
      if (localObject2 != null) {
        ((a)localObject2).setDataSource(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).url);
      }
      fjg();
    }
  }
  
  public void recycle()
  {
    AppMethodBeat.i(272537);
    Log.i(this.TAG, s.X("recycle ", hLo()));
    b(null, false);
    com.tencent.mm.ae.d.e("TP.Player", (kotlin.g.a.a)new b.e(this));
    eLO();
    com.tencent.threadpool.i.d locald = this.TFo;
    if (locald != null) {
      locald.cancel(false);
    }
    this.TFo = null;
    this.TFn = false;
    this.TFk = null;
    AppMethodBeat.o(272537);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(272449);
    this.oYG = paramBoolean;
    a locala = this.Flb;
    if (locala != null) {
      locala.setLoopback(paramBoolean);
    }
    AppMethodBeat.o(272449);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(272368);
    s.u(paramb, "mediaInfo");
    this.TFb = paramb;
    Object localObject1 = this.TFd;
    Object localObject3;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!s.p(localObject1, paramb.mediaId))
      {
        localObject1 = paramb.mediaId;
        s.s(localObject1, "mediaInfo.mediaId");
        paramb = paramb.path;
        s.s(paramb, "mediaInfo.path");
        this.TFd = new b((String)localObject1, paramb);
      }
      localObject1 = this.TAG;
      paramb = new StringBuilder("setMediaInfo, resourceLoader:");
      localObject3 = this.TFd;
      if (localObject3 == null) {
        break label167;
      }
      i = localObject3.hashCode();
      label114:
      localObject3 = paramb.append(i).append(", isLocal:");
      paramb = this.TFb;
      if (paramb != null) {
        break label172;
      }
    }
    label167:
    label172:
    for (paramb = localObject2;; paramb = Boolean.valueOf(paramb.hJv))
    {
      Log.i((String)localObject1, paramb);
      AppMethodBeat.o(272368);
      return;
      localObject1 = ((b)localObject1).mediaId;
      break;
      i = 0;
      break label114;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272443);
    a locala = this.Flb;
    if (locala != null) {
      locala.setOutputMute(paramBoolean);
    }
    AppMethodBeat.o(272443);
  }
  
  public void stop()
  {
    AppMethodBeat.i(272520);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("stop() ").append(hLo()).append(", fromExternResourceLoader:").append(this.TFs).append(", isLocal:");
    Object localObject = this.TFb;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject).hJv))
    {
      Log.i(str, localObject);
      if (hLi()) {
        break;
      }
      Log.i(this.TAG, s.X("stop() return for isStartPlay. ", hLo()));
      localObject = this.TFe;
      if (localObject != null) {
        ((f)localObject).enr();
      }
      AppMethodBeat.o(272520);
      return;
    }
    eLO();
    this.TFl = null;
    this.TFk = null;
    this.TFv = -1L;
    this.akjm = false;
    localObject = this.Flb;
    if (localObject != null) {
      ((a)localObject).stop();
    }
    localObject = this.Flb;
    if (localObject != null) {
      ((a)localObject).reset();
    }
    int i;
    if (!this.TFs)
    {
      localObject = this.TFb;
      if ((localObject != null) && (!((com.tencent.mm.plugin.thumbplayer.a.b)localObject).hJv))
      {
        i = 1;
        if (i == 0) {
          break label248;
        }
        c(this);
      }
    }
    for (;;)
    {
      Log.i(this.TAG, s.X("stop() end ", hLo()));
      AppMethodBeat.o(272520);
      return;
      i = 0;
      break;
      label248:
      this.Flw = false;
    }
  }
  
  public final void stopAsync()
  {
    AppMethodBeat.i(272526);
    Log.i(this.TAG, s.X("stopAsync() ", hLo()));
    this.TFu.stop();
    com.tencent.mm.ae.d.e("TP.Player", (kotlin.g.a.a)new b.i(this));
    AppMethodBeat.o(272526);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "mediaId", "", "mediaPath", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;Ljava/lang/String;Ljava/lang/String;)V", "MAX_REQUETS_LENGTH", "", "getMAX_REQUETS_LENGTH", "()J", "isAllComplete", "", "()Z", "setAllComplete", "(Z)V", "isMoovReady", "setMoovReady", "isRequestingData", "setRequestingData", "getMediaId", "()Ljava/lang/String;", "getMediaPath", "onAllComplete", "Lkotlin/Function2;", "", "", "getOnAllComplete", "()Lkotlin/jvm/functions/Function2;", "setOnAllComplete", "(Lkotlin/jvm/functions/Function2;)V", "requestNumber", "getRequestNumber", "()I", "setRequestNumber", "(I)V", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "offset", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopCdnDownload", "onStopReadData", "requestId", "resourceInfo", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends k.a.a.a.a.a.a.a.a.a.a.a
    implements h.a
  {
    public boolean EUK;
    private int Gpx;
    public boolean TFw;
    public boolean TFx;
    public m<? super String, ? super Integer, ah> TFy;
    private final long TFz;
    public final String mediaId;
    private final String mediaPath;
    
    public b(String paramString)
    {
      AppMethodBeat.i(272090);
      this.mediaId = paramString;
      this.mediaPath = localObject;
      this.TFz = 1048576L;
      AppMethodBeat.o(272090);
    }
    
    private final String hLp()
    {
      AppMethodBeat.i(272097);
      String str = b.this.hLo() + " isMoovReady:" + this.EUK + " isAllComplete:" + this.TFw + " isRequestingData:" + this.TFx;
      AppMethodBeat.o(272097);
      return str;
    }
    
    public final void a(String paramString, int paramInt, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(272128);
      this.TFw = true;
      paramd = this.TFy;
      if (paramd != null) {
        paramd.invoke(paramString, Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(272128);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(272101);
      this.EUK = true;
      b.this.RQ(2);
      AppMethodBeat.o(272101);
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(272160);
      Log.i(b.d(b.this), "getContentType() fileId:" + paramInt + ", fileKey:" + paramString + " contentType:" + "video/mp4" + ' ' + hLp());
      AppMethodBeat.o(272160);
      return "video/mp4";
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(272153);
      paramString = y.n(this.mediaPath, false);
      AppMethodBeat.o(272153);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(272135);
      long l = y.bEl(this.mediaPath);
      Log.i(b.d(b.this), "getDataTotalSize() fileId:" + paramInt + ", fileKey:" + paramString + " fileLength:" + l + ' ' + hLp());
      AppMethodBeat.o(272135);
      return l;
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272117);
      Log.i(b.d(b.this), "onProgress mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2 + ' ' + hLp());
      AppMethodBeat.o(272117);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272110);
      Log.i(b.d(b.this), "onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + ' ' + hLp());
      this.TFx = false;
      AppMethodBeat.o(272110);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2) {}
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272148);
      long l1;
      if (this.TFw) {
        l1 = paramLong2;
      }
      for (;;)
      {
        if ((l1 == 0L) && (!this.TFx) && (this.EUK) && (b.this.Flw))
        {
          final long l2 = k.bS(paramLong2, this.TFz);
          paramInt = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)paramLong1, (int)l2, (com.tencent.mm.plugin.thumbplayer.b.c)new a(b.this, this, l2));
          if (paramInt > 0) {
            this.TFx = true;
          }
          Log.i(b.d(b.this), "requestVideoData requestDataRet:" + paramInt + " requestLength:" + l2);
        }
        if (l1 > 0L) {
          Log.i(b.d(b.this), "onReadData() offset:" + paramLong1 + " length:" + paramLong2 + " returnLength:" + l1 + ' ' + hLp());
        }
        for (;;)
        {
          paramInt = (int)l1;
          AppMethodBeat.o(272148);
          return paramInt;
          paramString = new long[2];
          if ((CdnLogic.queryContinuousSize(this.mediaId, paramLong1, paramString) != 0) || (paramString[0] <= 0L)) {
            break label316;
          }
          l1 = Math.min(paramString[0], paramLong2);
          break;
          Log.d(b.d(b.this), "onReadData() offset:" + paramLong1 + " length:" + paramLong2 + ' ' + hLp());
        }
        label316:
        l1 = 0L;
      }
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272169);
      Log.i(b.d(b.this), "onStartReadData() fileId:" + paramInt + ", fileKey:" + paramString + " requestStart:" + paramLong1 + " requestEnd:" + paramLong2 + ' ' + hLp());
      paramInt = this.Gpx;
      this.Gpx = (paramInt + 1);
      AppMethodBeat.o(272169);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(272178);
      Log.i(b.d(b.this), "onStopReadData() fileId:" + paramInt1 + ", fileKey:" + paramString + " requestId:" + paramInt2 + ' ' + hLp());
      paramInt1 = this.Gpx;
      AppMethodBeat.o(272178);
      return paramInt1;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      a(b paramb, b.b paramb1, long paramLong) {}
      
      public final void UA(int paramInt)
      {
        AppMethodBeat.i(272124);
        if (paramInt != 0)
        {
          Log.w(b.d(this.TFA), "requestedResource() requestVideoData fail, ret:" + paramInt + ' ' + this);
          jdField_this.TFx = false;
          AppMethodBeat.o(272124);
          return;
        }
        Log.i(b.d(this.TFA), "requestVideoData requestDataRet:" + paramInt + " requestLength:" + l2);
        AppMethodBeat.o(272124);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onSeekComplete", "onStateChange", "preState", "curState", "onVideoSizeChanged", "width", "height", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public c()
    {
      AppMethodBeat.i(272081);
      AppMethodBeat.o(272081);
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(272125);
      Log.i(b.d(this.TFA), "onCompletion");
      b.g(this.TFA);
      AppMethodBeat.o(272125);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272131);
      Log.i(b.d(this.TFA), "onError errorType:" + paramInt1 + " errorCode:" + paramInt2 + ' ' + this.TFA.hLo());
      this.TFA.TFu.errType = paramInt1;
      this.TFA.TFu.errCode = paramInt2;
      b.h(this.TFA);
      AppMethodBeat.o(272131);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(272107);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(272107);
        return;
        this.TFA.TFu.TEJ = Util.currentTicks();
        AppMethodBeat.o(272107);
        return;
        paramITPPlayer = this.TFA.TFu;
        if (paramITPPlayer.TEJ > 0L)
        {
          paramITPPlayer.TEH += 1;
          paramITPPlayer.TEI += Util.ticksToNow(paramITPPlayer.TEJ);
        }
        paramITPPlayer.TEJ = 0L;
        AppMethodBeat.o(272107);
        return;
        AppMethodBeat.o(272107);
        return;
        paramObject = this.TFA.TFu;
        paramObject.wNr = Util.ticksToNow(paramObject.moe);
        if (paramITPPlayer != null)
        {
          paramObject = this.TFA.TFh;
          if (paramObject != null) {
            paramObject.invoke(paramITPPlayer);
          }
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(272093);
      Log.i(b.d(this.TFA), "onPrepared");
      this.TFA.RP(0);
      if (this.TFA.TFb != null)
      {
        b localb = this.TFA;
        if (localb.TFv > 0L)
        {
          b.a(localb, (int)localb.TFv, true, 4);
          Log.i(b.d(localb), "seek to play " + localb.TFv + ' ' + localb.hLo());
        }
      }
      if (this.TFA.cFG) {
        this.TFA.RP(0);
      }
      b.a(this.TFA, paramITPPlayer);
      AppMethodBeat.o(272093);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(272141);
      Log.i(b.d(this.TFA), "onSeekComplete");
      kotlin.g.a.b localb = b.i(this.TFA);
      if (localb != null) {
        localb.invoke(paramITPPlayer);
      }
      b.j(this.TFA);
      AppMethodBeat.o(272141);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272120);
      Log.i(b.d(this.TFA), "onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + this.TFA.hLo());
      this.TFA.currentPlayState = paramInt2;
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (paramInt2 == 5) {
          b.e(this.TFA);
        }
        if (!this.TFA.isPlaying()) {
          break;
        }
        b.f(this.TFA);
        AppMethodBeat.o(272120);
        return;
        Log.i(b.d(this.TFA), s.X("onStateChange() player stop or idle ", this.TFA.hLo()));
        f localf = this.TFA.TFe;
        if (localf != null) {
          localf.enr();
        }
        this.TFA.TFe = null;
      }
      this.TFA.eLO();
      AppMethodBeat.o(272120);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    f(b paramb) {}
    
    public final com.tencent.mm.g.h aCq(String paramString)
    {
      AppMethodBeat.i(272095);
      s.u(paramString, "id");
      paramString = this.TFA.fvc();
      AppMethodBeat.o(272095);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStop", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    g(b paramb, com.tencent.mm.plugin.thumbplayer.a.b paramb1) {}
    
    public final void Rv(int paramInt)
    {
      AppMethodBeat.i(272099);
      Log.i(b.d(this.TFA), "startCdnDownload()#onStart " + this.TFA.hLo() + ' ' + paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(272099);
        return;
        this.TFA.hLk();
        AppMethodBeat.o(272099);
        return;
        Object localObject = this.TFA.TFd;
        if (localObject != null) {
          ((b.b)localObject).TFw = true;
        }
        localObject = this.TFA.TFd;
        if (localObject != null) {
          ((b.b)localObject).EUK = true;
        }
        localObject = this.TFA.TFd;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).TFy;
          if (localObject != null) {
            ((m)localObject).invoke(localb.mediaId, Integer.valueOf(0));
          }
        }
        this.TFA.RQ(4);
      }
    }
    
    public final void a(int paramInt, com.tencent.mm.g.h paramh)
    {
      AppMethodBeat.i(272104);
      String str = b.d(this.TFA);
      StringBuilder localStringBuilder = new StringBuilder("startCdnDownload() #onStop:").append(paramInt).append(", ");
      if (paramh == null) {}
      for (paramh = null;; paramh = paramh.field_mediaId)
      {
        Log.i(str, paramh);
        AppMethodBeat.o(272104);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class h
    extends TimerTask
  {
    public h(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(272118);
      Object localObject = this.TFA.Flb;
      if (localObject == null) {}
      for (long l = 0L;; l = ((a)localObject).getCurrentPositionMs())
      {
        if (this.TFA.TFr) {
          Log.d(b.d(this.TFA), s.X("onProgress currentMs:", Long.valueOf(l)));
        }
        localObject = b.k(this.TFA);
        if (localObject != null) {
          ((com.tencent.mm.plugin.thumbplayer.view.e)localObject).a(this.TFA.TFb, l);
        }
        b.l(this.TFA);
        AppMethodBeat.o(272118);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$stopCdnDownload$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements g
  {
    k(b paramb, kotlin.g.a.a<ah> parama) {}
    
    public final void a(int paramInt, com.tencent.mm.g.h paramh, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(272108);
      Log.i(b.d(this.TFA), "stopCdnDownload()#onStop(), real cancel download task " + this.TFA.hLo() + ' ' + paramInt);
      parama.invoke();
      AppMethodBeat.o(272108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.b
 * JD-Core Version:    0.7.0.1
 */