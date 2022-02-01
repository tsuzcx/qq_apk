package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.d.g;
import com.tencent.mm.plugin.thumbplayer.d.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMPLETE", "getCOMPLETE", "()I", "TAG", "", "currentPlayIndex", "getCurrentPlayIndex", "setCurrentPlayIndex", "(I)V", "currentPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getCurrentPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setCurrentPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "", "initPlayerTick", "", "isStop", "lastPauseMvPosition", "getLastPauseMvPosition", "()J", "setLastPauseMvPosition", "(J)V", "listener", "Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$IFirstFrameDrawListener;", "logFrameRender", "getLogFrameRender", "()Z", "setLogFrameRender", "(Z)V", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "mediaInfoList", "", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMediaInfoList", "()Ljava/util/List;", "setMediaInfoList", "(Ljava/util/List;)V", "mvMusicProxy", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getMvMusicProxy", "()Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "setMvMusicProxy", "(Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;)V", "onProgressUpdate", "Lkotlin/Function2;", "", "getOnProgressUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnProgressUpdate", "(Lkotlin/jvm/functions/Function2;)V", "pauseVideoOnPlay", "getPauseVideoOnPlay", "setPauseVideoOnPlay", "playTimer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getPlayTimer", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setPlayTimer", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "progressUpdateInterval", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;)V", "surfaceTexture", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "totalLength", "getTotalLength", "setTotalLength", "init", "initEffector", "initPlayer", "player", "initTextureView", "onCompletion", "onStart", "onStop", "onVideoContentUpdate", "pause", "playInfo", "recreatePlayer", "recreatePlayerSurface", "recycle", "removeCompleteTimer", "resume", "seekToIndex", "index", "seekToNext", "seekToTime", "timeMs", "setEnableEffect", "enable", "setFirstFrameDrawCallback", "setMediaInfo", "needReInitTextureView", "setProgressUpdateInterval", "interval", "start", "updateCompleteTimer", "needCorrection", "needLog", "IFirstFrameDrawListener", "SurfaceTextureListener", "plugin-thumbplayer_release"})
public final class MMMvVideoLayout
  extends FrameLayout
{
  private MMThumbPlayerTextureView AMp;
  private final int COMPLETE;
  private d Gjl;
  private com.tencent.mm.plugin.thumbplayer.e.c MQB;
  private c MSU;
  com.tencent.mm.plugin.thumbplayer.f.b MTP;
  private int MTQ;
  private List<? extends com.tencent.mm.plugin.thumbplayer.e.d> MTR;
  private MMHandler MTS;
  private g MTT;
  b MTV;
  private SurfaceTexture MTW;
  private Surface MTX;
  private long MTY;
  private m<? super Long, ? super Long, x> MTZ;
  private volatile boolean MUa;
  private volatile boolean MUb;
  private long MUc;
  private a MUd;
  long MUe;
  final String TAG;
  private long nHt;
  private SurfaceTexture surfaceTexture;
  private boolean vco;
  
  public MMMvVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190495);
    this.TAG = ("MicroMsg.TP.MMMvVideoLayout@" + hashCode());
    this.MTT = new g();
    this.vco = true;
    this.MTY = 200L;
    this.MQB = new com.tencent.mm.plugin.thumbplayer.e.c();
    this.MUc = -1L;
    this.MUe = -1L;
    init();
    AppMethodBeat.o(190495);
  }
  
  public MMMvVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190499);
    this.TAG = ("MicroMsg.TP.MMMvVideoLayout@" + hashCode());
    this.MTT = new g();
    this.vco = true;
    this.MTY = 200L;
    this.MQB = new com.tencent.mm.plugin.thumbplayer.e.c();
    this.MUc = -1L;
    this.MUe = -1L;
    init();
    AppMethodBeat.o(190499);
  }
  
  private final String eha()
  {
    AppMethodBeat.i(190490);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.MTP;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).eha();; localObject = null)
    {
      localObject = (String)localObject + " layout:" + hashCode() + " currentPlayIndex:" + this.MTQ;
      AppMethodBeat.o(190490);
      return localObject;
    }
  }
  
  private final void goS()
  {
    AppMethodBeat.i(190473);
    this.MTT.ai((a)new d(this));
    this.MTT.W((kotlin.g.a.b)new e(this));
    this.MTT.MQZ = ((g.b)new f(this));
    AppMethodBeat.o(190473);
  }
  
  private void init()
  {
    AppMethodBeat.i(190463);
    this.MQB.MSw = this.MTT.MRa;
    this.AMp = new MMThumbPlayerTextureView(getContext());
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView != null) {
      localMMThumbPlayerTextureView.setTextureListenerCallback((TextureView.SurfaceTextureListener)new b());
    }
    localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView != null) {
      localMMThumbPlayerTextureView.setAlpha(1.0F);
    }
    this.MTS = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new c(this));
    if (this.vco) {
      goS();
    }
    AppMethodBeat.o(190463);
  }
  
  public final int getCOMPLETE()
  {
    return this.COMPLETE;
  }
  
  public final int getCurrentPlayIndex()
  {
    return this.MTQ;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.f.b getCurrentPlayer()
  {
    return this.MTP;
  }
  
  public final g getEffector()
  {
    return this.MTT;
  }
  
  public final long getLastPauseMvPosition()
  {
    return this.MUe;
  }
  
  public final boolean getLogFrameRender()
  {
    return this.MUb;
  }
  
  public final d getMediaChangeListener()
  {
    return this.Gjl;
  }
  
  public final List<com.tencent.mm.plugin.thumbplayer.e.d> getMediaInfoList()
  {
    return this.MTR;
  }
  
  public final b getMvMusicProxy()
  {
    return this.MTV;
  }
  
  public final m<Long, Long, x> getOnProgressUpdate()
  {
    return this.MTZ;
  }
  
  public final boolean getPauseVideoOnPlay()
  {
    return this.MUa;
  }
  
  public final MMHandler getPlayTimer()
  {
    return this.MTS;
  }
  
  public final c getPlayerActionListener()
  {
    return this.MSU;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.c getReportInfo()
  {
    return this.MQB;
  }
  
  public final MMThumbPlayerTextureView getTextureView()
  {
    return this.AMp;
  }
  
  public final long getTotalLength()
  {
    return this.nHt;
  }
  
  public final void goT()
  {
    AppMethodBeat.i(190487);
    Log.i(this.TAG, "removeCompleteTimer");
    Object localObject = this.MTP;
    if (localObject != null) {
      com.tencent.mm.plugin.thumbplayer.f.b.a((com.tencent.mm.plugin.thumbplayer.f.b)localObject, null);
    }
    localObject = this.MTS;
    if (localObject != null)
    {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
      AppMethodBeat.o(190487);
      return;
    }
    AppMethodBeat.o(190487);
  }
  
  public final void setCurrentPlayIndex(int paramInt)
  {
    this.MTQ = paramInt;
  }
  
  public final void setCurrentPlayer(com.tencent.mm.plugin.thumbplayer.f.b paramb)
  {
    this.MTP = paramb;
  }
  
  public final void setEffector(g paramg)
  {
    AppMethodBeat.i(190438);
    p.k(paramg, "<set-?>");
    this.MTT = paramg;
    AppMethodBeat.o(190438);
  }
  
  public final void setEnableEffect(boolean paramBoolean)
  {
    AppMethodBeat.i(190467);
    Log.i(this.TAG, "setEnableEffect:" + paramBoolean + ", enableEffect:" + this.vco + ", surfaceTexture:" + this.surfaceTexture);
    if (this.vco != paramBoolean)
    {
      this.vco = paramBoolean;
      if (this.vco)
      {
        Object localObject = this.AMp;
        if (localObject != null)
        {
          MMThumbPlayerTextureView.a locala = MMThumbPlayerTextureView.MUw;
          ((MMThumbPlayerTextureView)localObject).setScaleType(MMThumbPlayerTextureView.gpa());
        }
        localObject = this.AMp;
        if (localObject != null)
        {
          localObject = ((MMThumbPlayerTextureView)localObject).getLayoutParams();
          if (localObject != null) {
            ((ViewGroup.LayoutParams)localObject).width = -1;
          }
        }
        localObject = this.AMp;
        if (localObject != null)
        {
          localObject = ((MMThumbPlayerTextureView)localObject).getLayoutParams();
          if (localObject != null) {
            ((ViewGroup.LayoutParams)localObject).height = -1;
          }
        }
        localObject = this.AMp;
        if (localObject != null) {
          ((MMThumbPlayerTextureView)localObject).requestLayout();
        }
        goS();
      }
    }
    AppMethodBeat.o(190467);
  }
  
  public final void setFirstFrameDrawCallback(a parama)
  {
    AppMethodBeat.i(190470);
    p.k(parama, "listener");
    this.MUd = parama;
    AppMethodBeat.o(190470);
  }
  
  public final void setLastPauseMvPosition(long paramLong)
  {
    this.MUe = paramLong;
  }
  
  public final void setLogFrameRender(boolean paramBoolean)
  {
    this.MUb = paramBoolean;
  }
  
  public final void setMediaChangeListener(d paramd)
  {
    this.Gjl = paramd;
  }
  
  public final void setMediaInfoList(List<? extends com.tencent.mm.plugin.thumbplayer.e.d> paramList)
  {
    this.MTR = paramList;
  }
  
  public final void setMvMusicProxy(b paramb)
  {
    this.MTV = paramb;
  }
  
  public final void setOnProgressUpdate(m<? super Long, ? super Long, x> paramm)
  {
    this.MTZ = paramm;
  }
  
  public final void setPauseVideoOnPlay(boolean paramBoolean)
  {
    this.MUa = paramBoolean;
  }
  
  public final void setPlayTimer(MMHandler paramMMHandler)
  {
    this.MTS = paramMMHandler;
  }
  
  public final void setPlayerActionListener(c paramc)
  {
    this.MSU = paramc;
  }
  
  public final void setProgressUpdateInterval(long paramLong)
  {
    if (paramLong > 0L) {
      this.MTY = paramLong;
    }
  }
  
  public final void setReportInfo(com.tencent.mm.plugin.thumbplayer.e.c paramc)
  {
    AppMethodBeat.i(190459);
    p.k(paramc, "<set-?>");
    this.MQB = paramc;
    AppMethodBeat.o(190459);
  }
  
  public final void setTextureView(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    this.AMp = paramMMThumbPlayerTextureView;
  }
  
  public final void setTotalLength(long paramLong)
  {
    this.nHt = paramLong;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$IFirstFrameDrawListener;", "", "onFirstFrameDraw", "", "plugin-thumbplayer_release"})
  public static abstract interface a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192707);
      String str = MMMvVideoLayout.a(this.MUf);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", enableEffect:" + MMMvVideoLayout.d(this.MUf));
        MMMvVideoLayout.a(this.MUf, paramSurfaceTexture);
        this.MUf.getEffector().ku(paramInt1, paramInt2);
        if (!MMMvVideoLayout.d(this.MUf)) {
          break;
        }
        if (paramSurfaceTexture == null) {
          break label225;
        }
        this.MUf.getEffector().p(paramSurfaceTexture);
        AppMethodBeat.o(192707);
        return;
      }
      MMMvVideoLayout.b(this.MUf, paramSurfaceTexture);
      if (MMMvVideoLayout.e(this.MUf) != null)
      {
        paramSurfaceTexture = MMMvVideoLayout.e(this.MUf);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      MMMvVideoLayout.a(this.MUf, new Surface(MMMvVideoLayout.f(this.MUf)));
      paramSurfaceTexture = this.MUf.getCurrentPlayer();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.b(MMMvVideoLayout.e(this.MUf), true);
        AppMethodBeat.o(192707);
        return;
      }
      label225:
      AppMethodBeat.o(192707);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192705);
      String str = MMMvVideoLayout.a(this.MUf);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ' ' + MMMvVideoLayout.c(this.MUf));
        MMMvVideoLayout.a(this.MUf, null);
        if (!MMMvVideoLayout.d(this.MUf))
        {
          paramSurfaceTexture = MMMvVideoLayout.e(this.MUf);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.release();
          }
        }
        paramSurfaceTexture = this.MUf.getCurrentPlayer();
        if (paramSurfaceTexture != null) {
          com.tencent.mm.plugin.thumbplayer.f.b.a(paramSurfaceTexture, null);
        }
        AppMethodBeat.o(192705);
        return true;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192701);
      Log.i(MMMvVideoLayout.a(this.MUf), "onSurfaceTextureSizeChanged " + paramSurfaceTexture + ", size:[" + paramInt1 + ',' + paramInt2 + ']');
      MMMvVideoLayout.a(this.MUf, paramSurfaceTexture);
      this.MUf.getEffector().ku(paramInt1, paramInt2);
      AppMethodBeat.o(192701);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192704);
      MMMvVideoLayout.b(this.MUf);
      MMMvVideoLayout.a(this.MUf, paramSurfaceTexture);
      AppMethodBeat.o(192704);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements MMHandler.Callback
  {
    c(MMMvVideoLayout paramMMMvVideoLayout) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(189509);
      if (paramMessage.what == this.MUf.getCOMPLETE()) {
        MMMvVideoLayout.a(this.MUf, this.MUf.getCurrentPlayer());
      }
      AppMethodBeat.o(189509);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(MMMvVideoLayout paramMMMvVideoLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timestamp", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    e(MMMvVideoLayout paramMMMvVideoLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$initEffector$3", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "currentPlayPosition", "", "plugin-thumbplayer_release"})
  public static final class f
    implements g.b
  {
    public final long goc()
    {
      AppMethodBeat.i(189961);
      com.tencent.mm.plugin.thumbplayer.f.b localb = this.MUf.getCurrentPlayer();
      if (localb != null)
      {
        long l = localb.getCurrentPositionMs();
        AppMethodBeat.o(189961);
        return l;
      }
      AppMethodBeat.o(189961);
      return -1L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$initPlayer$2", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "", "plugin-thumbplayer_release"})
  public static final class g
    implements e
  {
    g(com.tencent.mm.plugin.thumbplayer.f.b paramb) {}
    
    public final void a(com.tencent.mm.plugin.thumbplayer.e.d paramd, long paramLong)
    {
      AppMethodBeat.i(192919);
      MMMvVideoLayout.a(this.MUf, false, 3);
      Object localObject = this.HMA.MSO;
      long l1;
      long l2;
      label56:
      String str;
      if (localObject != null)
      {
        l1 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).MSF;
        localObject = this.HMA.MSO;
        if (localObject == null) {
          break label229;
        }
        l2 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject).MSG;
        str = MMMvVideoLayout.a(this.MUf);
        StringBuilder localStringBuilder = new StringBuilder("timeMs=").append(paramLong).append(", originOffset=");
        localObject = this.HMA.MSO;
        if (localObject == null) {
          break label235;
        }
        localObject = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject).MSG);
        label109:
        localStringBuilder = localStringBuilder.append(localObject).append(", length=");
        localObject = this.HMA.MSO;
        if (localObject == null) {
          break label241;
        }
        localObject = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject).MSF);
        label147:
        localObject = localStringBuilder.append(localObject).append(", media=");
        if (paramd == null) {
          break label247;
        }
      }
      label229:
      label235:
      label241:
      label247:
      for (int i = paramd.hashCode();; i = 0)
      {
        Log.w(str, i);
        paramd = this.MUf.getOnProgressUpdate();
        if (paramd == null) {
          break label253;
        }
        paramd.invoke(Long.valueOf(paramLong - l2), Long.valueOf(l1));
        AppMethodBeat.o(192919);
        return;
        l1 = 0L;
        break;
        l2 = 0L;
        break label56;
        localObject = null;
        break label109;
        localObject = null;
        break label147;
      }
      label253:
      AppMethodBeat.o(192919);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    h(MMMvVideoLayout paramMMMvVideoLayout, com.tencent.mm.plugin.thumbplayer.f.b paramb, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout
 * JD-Core Version:    0.7.0.1
 */