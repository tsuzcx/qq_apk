package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.a.b;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMPLETE", "getCOMPLETE", "()I", "TAG", "", "currentPlayIndex", "getCurrentPlayIndex", "setCurrentPlayIndex", "(I)V", "currentPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getCurrentPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setCurrentPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "", "lastPauseMvPosition", "", "getLastPauseMvPosition", "()J", "setLastPauseMvPosition", "(J)V", "logFrameRender", "getLogFrameRender", "()Z", "setLogFrameRender", "(Z)V", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "mediaInfoList", "", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMediaInfoList", "()Ljava/util/List;", "setMediaInfoList", "(Ljava/util/List;)V", "mvMusicProxy", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getMvMusicProxy", "()Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "setMvMusicProxy", "(Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;)V", "onProgressUpdate", "Lkotlin/Function2;", "", "getOnProgressUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnProgressUpdate", "(Lkotlin/jvm/functions/Function2;)V", "pauseVideoOnPlay", "getPauseVideoOnPlay", "setPauseVideoOnPlay", "playTimer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getPlayTimer", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setPlayTimer", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "progressUpdateInterval", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;)V", "surfaceTexture", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "totalLength", "getTotalLength", "setTotalLength", "init", "initEffector", "initPlayer", "player", "initTextureView", "onCompletion", "onVideoContentUpdate", "pause", "playInfo", "recreatePlayer", "recreatePlayerSurface", "recycle", "removeCompleteTimer", "resume", "seekToIndex", "index", "seekToNext", "seekToTime", "timeMs", "setEnableEffect", "enable", "setMediaInfo", "needReInitTextureView", "setProgressUpdateInterval", "interval", "start", "updateCompleteTimer", "needCorrection", "needLog", "SurfaceTextureListener", "plugin-thumbplayer_release"})
public final class MMMvVideoLayout
  extends FrameLayout
{
  private d Atz;
  private final int COMPLETE;
  public com.tencent.mm.plugin.thumbplayer.e.b Gic;
  public int Gid;
  public List<com.tencent.mm.plugin.thumbplayer.d.a> Gie;
  private MMHandler Gif;
  private com.tencent.mm.plugin.thumbplayer.c.a Gig;
  public c Gih;
  private SurfaceTexture Gii;
  private Surface Gij;
  private long Gik;
  private m<? super Long, ? super Long, x> Gil;
  private volatile boolean Gim;
  private long Gin;
  public final String TAG;
  private g Utq;
  private volatile boolean Uts;
  private com.tencent.mm.plugin.thumbplayer.d.d Utt;
  private long kNt;
  private boolean rwI;
  private SurfaceTexture surfaceTexture;
  private MMThumbPlayerTextureView wdE;
  
  public MMMvVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(238779);
    this.TAG = ("MicroMsg.TP.MMMvVideoLayout@" + hashCode());
    this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    this.rwI = true;
    this.Gik = 200L;
    this.Utt = new com.tencent.mm.plugin.thumbplayer.d.d();
    this.Gin = -1L;
    init();
    AppMethodBeat.o(238779);
  }
  
  public MMMvVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(238780);
    this.TAG = ("MicroMsg.TP.MMMvVideoLayout@" + hashCode());
    this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    this.rwI = true;
    this.Gik = 200L;
    this.Utt = new com.tencent.mm.plugin.thumbplayer.d.d();
    this.Gin = -1L;
    init();
    AppMethodBeat.o(238780);
  }
  
  public MMMvVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238781);
    this.TAG = ("MicroMsg.TP.MMMvVideoLayout@" + hashCode());
    this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    this.rwI = true;
    this.Gik = 200L;
    this.Utt = new com.tencent.mm.plugin.thumbplayer.d.d();
    this.Gin = -1L;
    init();
    AppMethodBeat.o(238781);
  }
  
  private final void fxc()
  {
    AppMethodBeat.i(238767);
    this.Gig.aq((kotlin.g.a.a)new c(this));
    this.Gig.M((kotlin.g.a.b)new d(this));
    this.Gig.GgO = ((a.b)new e(this));
    AppMethodBeat.o(238767);
  }
  
  private void fxe()
  {
    AppMethodBeat.i(238775);
    Log.i(this.TAG, "removeCompleteTimer");
    Object localObject = this.Gic;
    if (localObject != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
    }
    localObject = this.Gif;
    if (localObject != null)
    {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
      AppMethodBeat.o(238775);
      return;
    }
    AppMethodBeat.o(238775);
  }
  
  private final void h(final com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    AppMethodBeat.i(238777);
    long l = Util.currentTicks();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("initPlayer ").append(dFm()).append(", playerSurface:");
    Surface localSurface = this.Gij;
    int i;
    label81:
    boolean bool;
    if (localSurface != null)
    {
      i = localSurface.hashCode();
      localObject2 = ((StringBuilder)localObject2).append(i).append(", player:");
      if (paramb == null) {
        break label313;
      }
      i = paramb.hashCode();
      Log.i((String)localObject1, i);
      if (paramb != null) {
        paramb.wcA = true;
      }
      if (paramb != null) {
        paramb.fwW();
      }
      if (paramb != null)
      {
        localObject1 = paramb.Ghy;
        if (localObject1 == null) {
          break label318;
        }
        bool = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).loop;
        label134:
        paramb.setLoop(bool);
      }
      if (paramb != null)
      {
        localObject1 = paramb.Ghy;
        if (localObject1 != null)
        {
          paramb.GhK = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghw;
          localObject2 = this.Atz;
          if (localObject2 != null) {
            ((d)localObject2).a(this.Gid, (com.tencent.mm.plugin.thumbplayer.d.a)localObject1);
          }
        }
      }
      if (paramb != null) {
        paramb.a((e)new f(this, paramb), this.Gik);
      }
      i(paramb);
      this.Uts = false;
      if (paramb != null) {
        paramb.Utq = this.Utq;
      }
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("initPlayer ");
      if (paramb == null) {
        break label324;
      }
    }
    label313:
    label318:
    label324:
    for (paramb = paramb.dFm();; paramb = null)
    {
      Log.i((String)localObject1, paramb + ", currentPlayIndex:" + this.Gid + ", cost:" + Util.ticksToNow(l));
      AppMethodBeat.o(238777);
      return;
      i = 0;
      break;
      i = 0;
      break label81;
      bool = false;
      break label134;
    }
  }
  
  private final void i(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    AppMethodBeat.i(258226);
    Surface localSurface = this.Gij;
    if (localSurface != null) {
      localSurface.release();
    }
    this.Gij = null;
    this.Gii = null;
    this.Gig.L((kotlin.g.a.b)new MMMvVideoLayout.i(this, paramb));
    AppMethodBeat.o(258226);
  }
  
  private void init()
  {
    AppMethodBeat.i(238763);
    this.Utt.Utk = this.Gig.UsW;
    this.wdE = new MMThumbPlayerTextureView(getContext());
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.wdE;
    if (localMMThumbPlayerTextureView != null) {
      localMMThumbPlayerTextureView.setTextureListenerCallback((TextureView.SurfaceTextureListener)new a());
    }
    localMMThumbPlayerTextureView = this.wdE;
    if (localMMThumbPlayerTextureView != null) {
      localMMThumbPlayerTextureView.setAlpha(1.0F);
    }
    this.Gif = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    if (this.rwI) {
      fxc();
    }
    AppMethodBeat.o(238763);
  }
  
  private void ws(boolean paramBoolean)
  {
    AppMethodBeat.i(238773);
    Object localObject1 = this.Gih;
    if (localObject1 != null)
    {
      Object localObject2 = this.Gic;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Ghy;
        if (localObject2 != null)
        {
          long l1 = ((c)localObject1).getCurrentPosition();
          long l2 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv;
          if (paramBoolean)
          {
            if (l2 > l1)
            {
              localObject1 = this.Gif;
              if (localObject1 != null) {
                ((MMHandler)localObject1).removeCallbacksAndMessages(null);
              }
              localObject1 = this.Gif;
              if (localObject1 != null)
              {
                ((MMHandler)localObject1).sendEmptyMessageAtTime(this.COMPLETE, l2 - l1 + SystemClock.uptimeMillis());
                AppMethodBeat.o(238773);
                return;
              }
              AppMethodBeat.o(238773);
            }
          }
          else
          {
            l1 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv;
            localObject1 = this.Gif;
            if (localObject1 != null) {
              ((MMHandler)localObject1).removeCallbacksAndMessages(null);
            }
            localObject1 = this.Gif;
            if (localObject1 != null)
            {
              ((MMHandler)localObject1).sendEmptyMessageAtTime(this.COMPLETE, l1 + SystemClock.uptimeMillis());
              AppMethodBeat.o(238773);
              return;
            }
          }
          AppMethodBeat.o(238773);
          return;
        }
      }
      AppMethodBeat.o(238773);
      return;
    }
    AppMethodBeat.o(238773);
  }
  
  public final void KG(long paramLong)
  {
    AppMethodBeat.i(238772);
    Log.d(this.TAG, "seekToTime:".concat(String.valueOf(paramLong)));
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = this.Gie;
    int i;
    int j;
    if (localObject3 != null)
    {
      localObject1 = (Iterable)localObject3;
      i = 0;
      localObject3 = ((Iterable)localObject1).iterator();
      j = 0;
      for (;;)
      {
        k = j;
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject3).next();
        k = i + 1;
        if (i < 0) {
          j.hxH();
        }
        localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a)localObject1;
        if ((((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghu <= paramLong) && (((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghu + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghv >= paramLong))
        {
          localObject1 = this.Gie;
          if (localObject1 != null) {}
          for (localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a)((List)localObject1).get(i);; localObject1 = null)
          {
            j = i;
            i = k;
            localObject2 = localObject1;
            break;
          }
        }
        i = k;
      }
    }
    int k = 0;
    localObject2 = this.Gie;
    long l2;
    long l3;
    label251:
    long l1;
    if (localObject2 != null)
    {
      localObject2 = (com.tencent.mm.plugin.thumbplayer.d.a)j.ku((List)localObject2);
      if (localObject2 != null)
      {
        l2 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu;
        localObject2 = this.Gie;
        if (localObject2 == null) {
          break label876;
        }
        localObject2 = (com.tencent.mm.plugin.thumbplayer.d.a)j.ku((List)localObject2);
        if (localObject2 == null) {
          break label876;
        }
        l3 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv;
        localObject2 = localObject1;
        l1 = paramLong;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          l1 = paramLong;
          if (paramLong >= l3 + l2)
          {
            Log.i(this.TAG, "cannot found targetInfo, maybe seek exceed to end");
            localObject1 = this.Gie;
            if (localObject1 == null) {
              break label882;
            }
            localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a)j.ks((List)localObject1);
            label311:
            l1 = 0L;
            localObject2 = localObject1;
          }
        }
        localObject3 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("seekToTime targetInfo:");
        if (localObject2 == null) {
          break label888;
        }
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).mediaId;
        label348:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" targetPlayIndex:").append(k).append(" targetSeekTimeMs:").append(l1).append(", offsetInMv:");
        if (localObject2 == null) {
          break label894;
        }
        localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu);
        label400:
        localStringBuilder = localStringBuilder.append(localObject1).append(", offsetInClips:");
        if (localObject2 == null) {
          break label900;
        }
        localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw);
        label430:
        localStringBuilder = localStringBuilder.append(localObject1).append(", duration:");
        if (localObject2 == null) {
          break label906;
        }
        localObject1 = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).pLQ);
        label460:
        localStringBuilder = localStringBuilder.append(localObject1).append(", currentPlayer.media:");
        localObject1 = this.Gic;
        if (localObject1 == null) {
          break label912;
        }
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Ghy;
        label493:
        Log.i((String)localObject3, localObject1);
        if (localObject2 == null) {
          break label1061;
        }
        paramLong = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu;
        l2 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw + (l1 - paramLong);
        i = 1;
        j = 1;
        paramLong = l2;
        if (l2 > ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).pLQ)
        {
          Log.i(this.TAG, "seekToTime larger than duration realSeekTimeMs " + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).pLQ + ", timeOffset:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw);
          i = j;
          if (((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ght)
          {
            Log.i(this.TAG, "defaultVideo no need to updateTimer");
            i = 0;
          }
          if (((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw >= ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).pLQ) {
            break label918;
          }
          paramLong = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw;
        }
        label635:
        l2 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv;
        l3 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu;
        this.Gid = k;
        localObject1 = this.Gic;
        if (localObject1 == null) {
          break label923;
        }
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Ghy;
        if (localObject1 == null) {
          break label923;
        }
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).mediaId;
        label685:
        if (!(p.j(localObject1, ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).mediaId) ^ true)) {
          break label929;
        }
        fxd();
        localObject1 = this.Gic;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setMediaInfo((com.tencent.mm.plugin.thumbplayer.d.a)localObject2);
        }
        h(this.Gic);
        localObject1 = this.Gic;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).GhK = paramLong;
        }
        localObject1 = this.Gic;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).fwU();
        }
        localObject1 = "switch to " + k + " media";
      }
    }
    for (;;)
    {
      if (i != 0) {
        a(this, false, 3);
      }
      Log.i(this.TAG, "seekToTime realSeekTimeMs:" + paramLong + " playTimeMs:" + (l2 - (l1 - l3)) + " source:" + (String)localObject1 + ' ' + dFm());
      AppMethodBeat.o(238772);
      return;
      l2 = 0L;
      break;
      label876:
      l3 = 0L;
      break label251;
      label882:
      localObject1 = null;
      break label311;
      label888:
      localObject1 = null;
      break label348;
      label894:
      localObject1 = null;
      break label400;
      label900:
      localObject1 = null;
      break label430;
      label906:
      localObject1 = null;
      break label460;
      label912:
      localObject1 = null;
      break label493;
      label918:
      paramLong = 0L;
      break label635;
      label923:
      localObject1 = null;
      break label685;
      label929:
      localObject1 = this.Gic;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).YY() == true))
      {
        localObject1 = this.Gic;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).YX((int)paramLong);
        }
        localObject1 = this.Gic;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).fwU();
        }
        localObject1 = "current media play";
      }
      else
      {
        localObject1 = this.Gic;
        if ((localObject1 != null) && (!((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).asa()))
        {
          localObject1 = this.Gic;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).GhK = paramLong;
          }
          localObject1 = "current media prepare seek when play";
        }
        else
        {
          localObject1 = this.Gic;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).YX((int)paramLong);
          }
          localObject1 = "current media play direct seek";
        }
      }
    }
    label1061:
    AppMethodBeat.o(238772);
  }
  
  public final String dFm()
  {
    AppMethodBeat.i(238778);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.Gic;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).dFm();; localObject = null)
    {
      localObject = (String)localObject + " layout:" + hashCode() + " currentPlayIndex:" + this.Gid;
      AppMethodBeat.o(238778);
      return localObject;
    }
  }
  
  public final void fxd()
  {
    AppMethodBeat.i(238771);
    long l = Util.currentTicks();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("recreatePlayer currentPlayer:").append(this.Gic).append(", playerSurface:");
    Surface localSurface = this.Gij;
    if (localSurface != null) {}
    for (int i = localSurface.hashCode();; i = 0)
    {
      Log.i((String)localObject, i);
      localObject = this.Gic;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Uto = null;
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).dFs();
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).dFp();
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
        this.Utt.a(this.Gid, ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Utr);
      }
      fxe();
      localObject = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = d.a.hu((Context)localObject);
      this.Gig.j((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      this.Gic = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      Log.i(this.TAG, "recreatePlayer finished, cost:" + Util.ticksToNow(l));
      AppMethodBeat.o(238771);
      return;
    }
  }
  
  public final int getCOMPLETE()
  {
    return this.COMPLETE;
  }
  
  public final int getCurrentPlayIndex()
  {
    return this.Gid;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.b getCurrentPlayer()
  {
    return this.Gic;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.c.a getEffector()
  {
    return this.Gig;
  }
  
  public final long getLastPauseMvPosition()
  {
    return this.Gin;
  }
  
  public final boolean getLogFrameRender()
  {
    return this.Uts;
  }
  
  public final d getMediaChangeListener()
  {
    return this.Atz;
  }
  
  public final List<com.tencent.mm.plugin.thumbplayer.d.a> getMediaInfoList()
  {
    return this.Gie;
  }
  
  public final c getMvMusicProxy()
  {
    return this.Gih;
  }
  
  public final m<Long, Long, x> getOnProgressUpdate()
  {
    return this.Gil;
  }
  
  public final boolean getPauseVideoOnPlay()
  {
    return this.Gim;
  }
  
  public final MMHandler getPlayTimer()
  {
    return this.Gif;
  }
  
  public final g getPlayerActionListener()
  {
    return this.Utq;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.d.d getReportInfo()
  {
    return this.Utt;
  }
  
  public final MMThumbPlayerTextureView getTextureView()
  {
    return this.wdE;
  }
  
  public final long getTotalLength()
  {
    return this.kNt;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(238769);
    Object localObject = this.Gih;
    if (localObject != null)
    {
      this.Gin = ((c)localObject).getCurrentPosition();
      localObject = this.Gic;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).pause();
      }
      fxe();
    }
    Log.i(this.TAG, "pause lastPauseMvPosition:" + this.Gin);
    AppMethodBeat.o(238769);
  }
  
  public final void q(List<com.tencent.mm.plugin.thumbplayer.d.a> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(238764);
    p.h(paramList, "mediaInfoList");
    this.Gie = paramList;
    Object localObject1 = this.Gie;
    Object localObject2;
    label107:
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a)j.kt((List)localObject1);
      if (localObject1 != null)
      {
        localObject2 = this.Gic;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.d.a)localObject1);
        }
        if (!paramBoolean)
        {
          localObject1 = this.wdE;
          if (localObject1 == null) {
            break label335;
          }
          localObject1 = ((MMThumbPlayerTextureView)localObject1).getParent();
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = this.wdE;
          if (localObject1 == null) {
            break label341;
          }
          localObject1 = ((MMThumbPlayerTextureView)localObject1).getParent();
          if (localObject1 != null) {
            removeView((View)this.wdE);
          }
          i = com.tencent.mm.cb.a.jn(getContext());
          j = com.tencent.mm.cb.a.jo(getContext());
          localObject1 = this.wdE;
          if (localObject1 != null) {
            ((MMThumbPlayerTextureView)localObject1).jk(i, j);
          }
          if (!this.rwI) {
            break label347;
          }
          localObject1 = this.wdE;
          if (localObject1 != null)
          {
            localObject2 = MMThumbPlayerTextureView.GiC;
            ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.fxj());
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.wdE;
      if (localObject1 != null) {
        ((MMThumbPlayerTextureView)localObject1).setOpaque(false);
      }
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      addView((View)this.wdE, (ViewGroup.LayoutParams)localObject1);
      Log.i(this.TAG, "initTextureView() " + dFm());
      this.kNt = 0L;
      localObject1 = this.Gie;
      if (localObject1 == null) {
        break label407;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.thumbplayer.d.a)((Iterator)localObject1).next();
        this.kNt += ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv;
      }
      label335:
      localObject1 = null;
      break;
      label341:
      localObject1 = null;
      break label107;
      label347:
      if (j > i)
      {
        localObject1 = this.wdE;
        if (localObject1 != null)
        {
          localObject2 = MMThumbPlayerTextureView.GiC;
          ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.fxh());
        }
      }
      else
      {
        localObject1 = this.wdE;
        if (localObject1 != null)
        {
          localObject2 = MMThumbPlayerTextureView.GiC;
          ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.fxi());
        }
      }
    }
    label407:
    this.Gig.hI(paramList);
    AppMethodBeat.o(238764);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(238776);
    Log.i(this.TAG, "recycle");
    Object localObject = this.Gic;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
    }
    localObject = this.Gic;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
    }
    localObject = this.Gic;
    if (localObject != null) {
      this.Utt.a(this.Gid, ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Utr);
    }
    localObject = this.Gif;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.Gif;
    if (localObject != null) {
      ((MMHandler)localObject).quit();
    }
    this.Gig.release();
    this.Gij = null;
    AppMethodBeat.o(238776);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(238770);
    Object localObject = this.Gih;
    long l;
    if (localObject != null)
    {
      l = ((c)localObject).getCurrentPosition();
      if (this.Gin != l) {
        break label91;
      }
      localObject = this.Gic;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).fwU();
      }
      a(this, false, 3);
    }
    for (;;)
    {
      Log.i(this.TAG, "resume lastPauseMvPosition:" + this.Gin);
      this.Gin = -1L;
      AppMethodBeat.o(238770);
      return;
      label91:
      KG(l);
    }
  }
  
  public final void setCurrentPlayIndex(int paramInt)
  {
    this.Gid = paramInt;
  }
  
  public final void setCurrentPlayer(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    this.Gic = paramb;
  }
  
  public final void setEffector(com.tencent.mm.plugin.thumbplayer.c.a parama)
  {
    AppMethodBeat.i(238762);
    p.h(parama, "<set-?>");
    this.Gig = parama;
    AppMethodBeat.o(238762);
  }
  
  public final void setEnableEffect(boolean paramBoolean)
  {
    AppMethodBeat.i(238766);
    Log.i(this.TAG, "setEnableEffect:" + paramBoolean + ", enableEffect:" + this.rwI + ", surfaceTexture:" + this.surfaceTexture);
    if (this.rwI != paramBoolean)
    {
      this.rwI = paramBoolean;
      if (this.rwI)
      {
        Object localObject = this.wdE;
        if (localObject != null)
        {
          MMThumbPlayerTextureView.a locala = MMThumbPlayerTextureView.GiC;
          ((MMThumbPlayerTextureView)localObject).setScaleType(MMThumbPlayerTextureView.fxj());
        }
        localObject = this.wdE;
        if (localObject != null)
        {
          localObject = ((MMThumbPlayerTextureView)localObject).getLayoutParams();
          if (localObject != null) {
            ((ViewGroup.LayoutParams)localObject).width = -1;
          }
        }
        localObject = this.wdE;
        if (localObject != null)
        {
          localObject = ((MMThumbPlayerTextureView)localObject).getLayoutParams();
          if (localObject != null) {
            ((ViewGroup.LayoutParams)localObject).height = -1;
          }
        }
        localObject = this.wdE;
        if (localObject != null) {
          ((MMThumbPlayerTextureView)localObject).requestLayout();
        }
        fxc();
      }
    }
    AppMethodBeat.o(238766);
  }
  
  public final void setLastPauseMvPosition(long paramLong)
  {
    this.Gin = paramLong;
  }
  
  public final void setLogFrameRender(boolean paramBoolean)
  {
    this.Uts = paramBoolean;
  }
  
  public final void setMediaChangeListener(d paramd)
  {
    this.Atz = paramd;
  }
  
  public final void setMediaInfoList(List<com.tencent.mm.plugin.thumbplayer.d.a> paramList)
  {
    this.Gie = paramList;
  }
  
  public final void setMvMusicProxy(c paramc)
  {
    this.Gih = paramc;
  }
  
  public final void setOnProgressUpdate(m<? super Long, ? super Long, x> paramm)
  {
    this.Gil = paramm;
  }
  
  public final void setPauseVideoOnPlay(boolean paramBoolean)
  {
    this.Gim = paramBoolean;
  }
  
  public final void setPlayTimer(MMHandler paramMMHandler)
  {
    this.Gif = paramMMHandler;
  }
  
  public final void setPlayerActionListener(g paramg)
  {
    this.Utq = paramg;
  }
  
  public final void setProgressUpdateInterval(long paramLong)
  {
    if (paramLong > 0L) {
      this.Gik = paramLong;
    }
  }
  
  public final void setReportInfo(com.tencent.mm.plugin.thumbplayer.d.d paramd)
  {
    AppMethodBeat.i(258721);
    p.h(paramd, "<set-?>");
    this.Utt = paramd;
    AppMethodBeat.o(258721);
  }
  
  public final void setTextureView(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    this.wdE = paramMMThumbPlayerTextureView;
  }
  
  public final void setTotalLength(long paramLong)
  {
    this.kNt = paramLong;
  }
  
  public final void start()
  {
    AppMethodBeat.i(238768);
    h(this.Gic);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.Gic;
    if (localb != null) {
      localb.fwU();
    }
    a(this, false, 2);
    Log.i(this.TAG, "start play " + dFm());
    this.Utt.gXF = Util.currentTicks();
    AppMethodBeat.o(238768);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238754);
      String str = MMMvVideoLayout.a(this.Gio);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", enableEffect:" + MMMvVideoLayout.d(this.Gio));
        MMMvVideoLayout.a(this.Gio, paramSurfaceTexture);
        this.Gio.getEffector().jj(paramInt1, paramInt2);
        if (!MMMvVideoLayout.d(this.Gio)) {
          break;
        }
        if (paramSurfaceTexture == null) {
          break label225;
        }
        this.Gio.getEffector().m(paramSurfaceTexture);
        AppMethodBeat.o(238754);
        return;
      }
      MMMvVideoLayout.b(this.Gio, paramSurfaceTexture);
      if (MMMvVideoLayout.e(this.Gio) != null)
      {
        paramSurfaceTexture = MMMvVideoLayout.e(this.Gio);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      MMMvVideoLayout.a(this.Gio, new Surface(MMMvVideoLayout.f(this.Gio)));
      paramSurfaceTexture = this.Gio.getCurrentPlayer();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.b(MMMvVideoLayout.e(this.Gio), true);
        AppMethodBeat.o(238754);
        return;
      }
      label225:
      AppMethodBeat.o(238754);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(238753);
      String str = MMMvVideoLayout.a(this.Gio);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ' ' + MMMvVideoLayout.c(this.Gio));
        MMMvVideoLayout.a(this.Gio, null);
        if (!MMMvVideoLayout.d(this.Gio))
        {
          paramSurfaceTexture = MMMvVideoLayout.e(this.Gio);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.release();
          }
        }
        paramSurfaceTexture = this.Gio.getCurrentPlayer();
        if (paramSurfaceTexture != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.a(paramSurfaceTexture, null);
        }
        AppMethodBeat.o(238753);
        return true;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238751);
      Log.i(MMMvVideoLayout.a(this.Gio), "onSurfaceTextureSizeChanged " + paramSurfaceTexture + ", size:[" + paramInt1 + ',' + paramInt2 + ']');
      MMMvVideoLayout.a(this.Gio, paramSurfaceTexture);
      this.Gio.getEffector().jj(paramInt1, paramInt2);
      AppMethodBeat.o(238751);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(238752);
      MMMvVideoLayout.b(this.Gio);
      MMMvVideoLayout.a(this.Gio, paramSurfaceTexture);
      AppMethodBeat.o(238752);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(MMMvVideoLayout paramMMMvVideoLayout) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(238755);
      if (paramMessage.what == this.Gio.getCOMPLETE()) {
        MMMvVideoLayout.a(this.Gio, this.Gio.getCurrentPlayer());
      }
      AppMethodBeat.o(238755);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(MMMvVideoLayout paramMMMvVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timestamp", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    d(MMMvVideoLayout paramMMMvVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$initEffector$3", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "currentPlayPosition", "", "plugin-thumbplayer_release"})
  public static final class e
    implements a.b
  {
    public final long fwR()
    {
      AppMethodBeat.i(238758);
      Object localObject = this.Gio.getCurrentPlayer();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).wdC;
        if (localObject != null)
        {
          long l = ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).getCurrentPositionMs();
          AppMethodBeat.o(238758);
          return l;
        }
        AppMethodBeat.o(238758);
        return 0L;
      }
      AppMethodBeat.o(238758);
      return -1L;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$initPlayer$2", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "", "plugin-thumbplayer_release"})
  public static final class f
    implements e
  {
    f(com.tencent.mm.plugin.thumbplayer.e.b paramb) {}
    
    public final void Hv(long paramLong)
    {
      long l2 = 0L;
      AppMethodBeat.i(238759);
      MMMvVideoLayout.a(this.Gio, false, 3);
      Object localObject = paramb.Ghy;
      if (localObject != null) {}
      for (long l1 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).Ghv;; l1 = 0L)
      {
        localObject = paramb.Ghy;
        if (localObject != null) {
          l2 = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject).Ghw;
        }
        localObject = this.Gio.getOnProgressUpdate();
        if (localObject == null) {
          break;
        }
        ((m)localObject).invoke(Long.valueOf(paramLong - l2), Long.valueOf(l1));
        AppMethodBeat.o(238759);
        return;
      }
      AppMethodBeat.o(238759);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout
 * JD-Core Version:    0.7.0.1
 */