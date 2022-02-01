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
import com.tencent.mm.plugin.thumbplayer.c.e.b;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMPLETE", "getCOMPLETE", "()I", "TAG", "", "currentPlayIndex", "getCurrentPlayIndex", "setCurrentPlayIndex", "(I)V", "currentPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getCurrentPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setCurrentPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "", "initPlayerTick", "", "isStop", "lastPauseMvPosition", "getLastPauseMvPosition", "()J", "setLastPauseMvPosition", "(J)V", "listener", "Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$IFirstFrameDrawListener;", "logFrameRender", "getLogFrameRender", "()Z", "setLogFrameRender", "(Z)V", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "mediaInfoList", "", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "getMediaInfoList", "()Ljava/util/List;", "setMediaInfoList", "(Ljava/util/List;)V", "mvMusicProxy", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getMvMusicProxy", "()Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "setMvMusicProxy", "(Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;)V", "onProgressUpdate", "Lkotlin/Function2;", "", "getOnProgressUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnProgressUpdate", "(Lkotlin/jvm/functions/Function2;)V", "pauseVideoOnPlay", "getPauseVideoOnPlay", "setPauseVideoOnPlay", "playTimer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getPlayTimer", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setPlayTimer", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "progressUpdateInterval", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;)V", "surfaceTexture", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "totalLength", "getTotalLength", "setTotalLength", "init", "initEffector", "initPlayer", "player", "initTextureView", "onCompletion", "onStart", "onStop", "onVideoContentUpdate", "pause", "playInfo", "recreatePlayer", "recreatePlayerSurface", "recycle", "removeCompleteTimer", "resume", "seekToIndex", "index", "seekToNext", "seekToTime", "timeMs", "setEnableEffect", "enable", "setFirstFrameDrawCallback", "setMediaInfo", "needReInitTextureView", "setProgressUpdateInterval", "interval", "start", "updateCompleteTimer", "needCorrection", "needLog", "IFirstFrameDrawListener", "SurfaceTextureListener", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMMvVideoLayout
  extends FrameLayout
{
  private final int COMPLETE;
  private MMThumbPlayerTextureView Fld;
  private Surface HkH;
  private d Meq;
  final String TAG;
  private com.tencent.mm.plugin.thumbplayer.d.c TDf;
  private c TFk;
  private com.tencent.mm.plugin.thumbplayer.c.e TGA;
  b TGB;
  private SurfaceTexture TGC;
  private long TGD;
  private m<? super Long, ? super Long, ah> TGE;
  private volatile boolean TGF;
  private volatile boolean TGG;
  private long TGH;
  private MMMvVideoLayout.a TGI;
  long TGJ;
  private com.tencent.mm.plugin.thumbplayer.e.b TGw;
  private int TGx;
  private List<? extends com.tencent.mm.plugin.thumbplayer.a.b> TGy;
  private MMHandler TGz;
  private long qHg;
  private SurfaceTexture surfaceTexture;
  private boolean yoh;
  
  public MMMvVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272310);
    this.TAG = s.X("MicroMsg.TP.MMMvVideoLayout@", Integer.valueOf(hashCode()));
    this.TGA = new com.tencent.mm.plugin.thumbplayer.c.e();
    this.yoh = true;
    this.TGD = 200L;
    this.TDf = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.TGH = -1L;
    this.TGJ = -1L;
    init();
    AppMethodBeat.o(272310);
  }
  
  public MMMvVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272317);
    this.TAG = s.X("MicroMsg.TP.MMMvVideoLayout@", Integer.valueOf(hashCode()));
    this.TGA = new com.tencent.mm.plugin.thumbplayer.c.e();
    this.yoh = true;
    this.TGD = 200L;
    this.TDf = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.TGH = -1L;
    this.TGJ = -1L;
    init();
    AppMethodBeat.o(272317);
  }
  
  private static final boolean a(MMMvVideoLayout paramMMMvVideoLayout, final Message paramMessage)
  {
    AppMethodBeat.i(272375);
    s.u(paramMMMvVideoLayout, "this$0");
    s.u(paramMessage, "it");
    long l1;
    Object localObject1;
    Object localObject2;
    int i;
    label281:
    label418:
    boolean bool;
    if (paramMessage.what == paramMMMvVideoLayout.getCOMPLETE())
    {
      paramMessage = paramMMMvVideoLayout.getCurrentPlayer();
      Log.i(paramMMMvVideoLayout.TAG, "onCompletion " + paramMessage + ' ' + paramMMMvVideoLayout.hLo());
      Log.i(paramMMMvVideoLayout.TAG, s.X("seekToNext ", paramMMMvVideoLayout.hLo()));
      l1 = Util.currentTicks();
      paramMessage = paramMMMvVideoLayout.TAG;
      localObject1 = new StringBuilder("recreatePlayer currentPlayer:").append(paramMMMvVideoLayout.TGw).append(", playerSurface:");
      localObject2 = paramMMMvVideoLayout.HkH;
      if (localObject2 == null) {
        break label743;
      }
      i = localObject2.hashCode();
      Log.i(paramMessage, i);
      paramMessage = paramMMMvVideoLayout.TGw;
      if (paramMessage != null)
      {
        paramMessage.aF(null);
        paramMessage.eLO();
        com.tencent.mm.plugin.thumbplayer.e.b.c(paramMessage);
        paramMessage.stopAsync();
        paramMessage.recycle();
        paramMMMvVideoLayout.getReportInfo().a(paramMMMvVideoLayout.getCurrentPlayIndex(), paramMessage.TFu);
      }
      paramMMMvVideoLayout.hLM();
      paramMessage = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
      paramMessage = paramMMMvVideoLayout.getContext();
      s.s(paramMessage, "context");
      paramMessage = d.a.ks(paramMessage);
      paramMMMvVideoLayout.getEffector().a(paramMessage);
      localObject1 = ah.aiuX;
      paramMMMvVideoLayout.TGw = paramMessage;
      Log.i(paramMMMvVideoLayout.TAG, s.X("recreatePlayer finished, cost:", Long.valueOf(Util.ticksToNow(l1))));
      paramMMMvVideoLayout.TGx += 1;
      paramMessage = paramMMMvVideoLayout.TGy;
      if (paramMessage != null) {
        break label748;
      }
      i = 0;
      if (i <= paramMMMvVideoLayout.TGx) {
        paramMMMvVideoLayout.TGx = 0;
      }
      paramMessage = paramMMMvVideoLayout.TGy;
      if (paramMessage != null)
      {
        paramMessage = (com.tencent.mm.plugin.thumbplayer.a.b)paramMessage.get(paramMMMvVideoLayout.TGx);
        if (paramMessage != null)
        {
          localObject1 = paramMMMvVideoLayout.getCurrentPlayer();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setMediaInfo(paramMessage);
          }
          paramMessage = paramMMMvVideoLayout.TGw;
          l1 = Util.currentTicks();
          localObject1 = paramMMMvVideoLayout.TAG;
          localObject2 = new StringBuilder("initPlayer ").append(paramMMMvVideoLayout.hLo()).append(", playerSurface:");
          Surface localSurface = paramMMMvVideoLayout.HkH;
          if (localSurface == null) {
            break label758;
          }
          i = localSurface.hashCode();
          label395:
          localObject2 = ((StringBuilder)localObject2).append(i).append(", player:");
          if (paramMessage == null) {
            break label763;
          }
          i = paramMessage.hashCode();
          Log.i((String)localObject1, i);
          if (paramMessage != null) {
            paramMessage.Flr = true;
          }
          if (paramMessage != null) {
            paramMessage.setMute(true);
          }
          if (paramMessage != null)
          {
            if (paramMessage != null) {
              break label768;
            }
            bool = false;
            label461:
            paramMessage.setLoop(bool);
          }
          if (paramMessage != null)
          {
            localObject1 = paramMessage.TFb;
            if (localObject1 != null)
            {
              paramMessage.TFv = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).TBO;
              localObject2 = paramMMMvVideoLayout.getMediaChangeListener();
              if (localObject2 != null) {
                ((d)localObject2).a(paramMMMvVideoLayout.getCurrentPlayIndex(), (com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
              }
            }
          }
          if (paramMessage != null) {
            paramMessage.a((e)new f(paramMMMvVideoLayout, paramMessage), paramMMMvVideoLayout.TGD);
          }
          Log.i(paramMMMvVideoLayout.TAG, "start recreatePlayerSurface");
          final long l2 = Util.currentTicks();
          localObject1 = paramMMMvVideoLayout.HkH;
          if (localObject1 != null) {
            ((Surface)localObject1).release();
          }
          paramMMMvVideoLayout.HkH = null;
          paramMMMvVideoLayout.TGC = null;
          paramMMMvVideoLayout.TGA.aE((kotlin.g.a.b)new g(paramMMMvVideoLayout, paramMessage, l2));
          paramMMMvVideoLayout.TGG = false;
          if (paramMessage != null) {
            paramMessage.TFk = paramMMMvVideoLayout.TFk;
          }
          localObject1 = paramMMMvVideoLayout.TAG;
          localObject2 = new StringBuilder("initPlayer ");
          if (paramMessage != null) {
            break label795;
          }
        }
      }
    }
    label768:
    label795:
    for (paramMessage = null;; paramMessage = paramMessage.hLo())
    {
      Log.i((String)localObject1, paramMessage + ", currentPlayIndex:" + paramMMMvVideoLayout.TGx + ", cost:" + Util.ticksToNow(l1));
      paramMMMvVideoLayout.TGH = Util.currentTicks();
      paramMessage = paramMMMvVideoLayout.TGw;
      if (paramMessage != null) {
        paramMessage.hLh();
      }
      a(paramMMMvVideoLayout, false, 2);
      Log.i(paramMMMvVideoLayout.TAG, s.X("start play ", paramMMMvVideoLayout.hLo()));
      paramMMMvVideoLayout.TDf.moe = Util.currentTicks();
      AppMethodBeat.o(272375);
      return false;
      label743:
      i = 0;
      break;
      label748:
      i = paramMessage.size();
      break label281;
      label758:
      i = 0;
      break label395;
      label763:
      i = 0;
      break label418;
      localObject1 = paramMessage.TFb;
      if (localObject1 == null)
      {
        bool = false;
        break label461;
      }
      bool = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).loop;
      break label461;
    }
  }
  
  private final void hLL()
  {
    AppMethodBeat.i(272335);
    this.TGA.bS((a)new c(this));
    this.TGA.aD((kotlin.g.a.b)new d(this));
    this.TGA.TDB = ((e.b)new e(this));
    AppMethodBeat.o(272335);
  }
  
  private final String hLo()
  {
    AppMethodBeat.i(272354);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.TGw;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hLo())
    {
      localObject = localObject + " layout:" + hashCode() + " currentPlayIndex:" + this.TGx;
      AppMethodBeat.o(272354);
      return localObject;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(272328);
    this.TDf.TEQ = this.TGA.TDC;
    this.Fld = new MMThumbPlayerTextureView(getContext());
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.Fld;
    if (localMMThumbPlayerTextureView != null) {
      localMMThumbPlayerTextureView.setTextureListenerCallback((TextureView.SurfaceTextureListener)new b());
    }
    localMMThumbPlayerTextureView = this.Fld;
    if (localMMThumbPlayerTextureView != null) {
      localMMThumbPlayerTextureView.setAlpha(1.0F);
    }
    this.TGz = new MMHandler(Looper.getMainLooper(), new MMMvVideoLayout..ExternalSyntheticLambda0(this));
    if (this.yoh) {
      hLL();
    }
    AppMethodBeat.o(272328);
  }
  
  public final int getCOMPLETE()
  {
    return this.COMPLETE;
  }
  
  public final int getCurrentPlayIndex()
  {
    return this.TGx;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.b getCurrentPlayer()
  {
    return this.TGw;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.c.e getEffector()
  {
    return this.TGA;
  }
  
  public final long getLastPauseMvPosition()
  {
    return this.TGJ;
  }
  
  public final boolean getLogFrameRender()
  {
    return this.TGG;
  }
  
  public final d getMediaChangeListener()
  {
    return this.Meq;
  }
  
  public final List<com.tencent.mm.plugin.thumbplayer.a.b> getMediaInfoList()
  {
    return this.TGy;
  }
  
  public final b getMvMusicProxy()
  {
    return this.TGB;
  }
  
  public final m<Long, Long, ah> getOnProgressUpdate()
  {
    return this.TGE;
  }
  
  public final boolean getPauseVideoOnPlay()
  {
    return this.TGF;
  }
  
  public final MMHandler getPlayTimer()
  {
    return this.TGz;
  }
  
  public final c getPlayerActionListener()
  {
    return this.TFk;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.d.c getReportInfo()
  {
    return this.TDf;
  }
  
  public final MMThumbPlayerTextureView getTextureView()
  {
    return this.Fld;
  }
  
  public final long getTotalLength()
  {
    return this.qHg;
  }
  
  public final void hLM()
  {
    AppMethodBeat.i(272624);
    Log.i(this.TAG, "removeCompleteTimer");
    Object localObject = this.TGw;
    if (localObject != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)localObject, null);
    }
    localObject = this.TGz;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(272624);
  }
  
  public final void setCurrentPlayIndex(int paramInt)
  {
    this.TGx = paramInt;
  }
  
  public final void setCurrentPlayer(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    this.TGw = paramb;
  }
  
  public final void setEffector(com.tencent.mm.plugin.thumbplayer.c.e parame)
  {
    AppMethodBeat.i(272529);
    s.u(parame, "<set-?>");
    this.TGA = parame;
    AppMethodBeat.o(272529);
  }
  
  public final void setEnableEffect(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(272607);
    Log.i(this.TAG, "setEnableEffect:" + paramBoolean + ", enableEffect:" + this.yoh + ", surfaceTexture:" + this.surfaceTexture);
    if (this.yoh != paramBoolean)
    {
      this.yoh = paramBoolean;
      if (this.yoh)
      {
        localObject1 = this.Fld;
        if (localObject1 != null) {
          ((MMThumbPlayerTextureView)localObject1).setScaleType(2);
        }
        localObject1 = this.Fld;
        if (localObject1 != null) {
          break label156;
        }
        localObject1 = null;
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).width = -1;
        }
        localObject1 = this.Fld;
        if (localObject1 != null) {
          break label164;
        }
      }
    }
    label156:
    label164:
    for (Object localObject1 = localObject2;; localObject1 = ((MMThumbPlayerTextureView)localObject1).getLayoutParams())
    {
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).height = -1;
      }
      localObject1 = this.Fld;
      if (localObject1 != null) {
        ((MMThumbPlayerTextureView)localObject1).requestLayout();
      }
      hLL();
      AppMethodBeat.o(272607);
      return;
      localObject1 = ((MMThumbPlayerTextureView)localObject1).getLayoutParams();
      break;
    }
  }
  
  public final void setFirstFrameDrawCallback(MMMvVideoLayout.a parama)
  {
    AppMethodBeat.i(272612);
    s.u(parama, "listener");
    this.TGI = parama;
    AppMethodBeat.o(272612);
  }
  
  public final void setLastPauseMvPosition(long paramLong)
  {
    this.TGJ = paramLong;
  }
  
  public final void setLogFrameRender(boolean paramBoolean)
  {
    this.TGG = paramBoolean;
  }
  
  public final void setMediaChangeListener(d paramd)
  {
    this.Meq = paramd;
  }
  
  public final void setMediaInfoList(List<? extends com.tencent.mm.plugin.thumbplayer.a.b> paramList)
  {
    this.TGy = paramList;
  }
  
  public final void setMvMusicProxy(b paramb)
  {
    this.TGB = paramb;
  }
  
  public final void setOnProgressUpdate(m<? super Long, ? super Long, ah> paramm)
  {
    this.TGE = paramm;
  }
  
  public final void setPauseVideoOnPlay(boolean paramBoolean)
  {
    this.TGF = paramBoolean;
  }
  
  public final void setPlayTimer(MMHandler paramMMHandler)
  {
    this.TGz = paramMMHandler;
  }
  
  public final void setPlayerActionListener(c paramc)
  {
    this.TFk = paramc;
  }
  
  public final void setProgressUpdateInterval(long paramLong)
  {
    if (paramLong > 0L) {
      this.TGD = paramLong;
    }
  }
  
  public final void setReportInfo(com.tencent.mm.plugin.thumbplayer.d.c paramc)
  {
    AppMethodBeat.i(272599);
    s.u(paramc, "<set-?>");
    this.TDf = paramc;
    AppMethodBeat.o(272599);
  }
  
  public final void setTextureView(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    this.Fld = paramMMThumbPlayerTextureView;
  }
  
  public final void setTotalLength(long paramLong)
  {
    this.qHg = paramLong;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements TextureView.SurfaceTextureListener
  {
    public b()
    {
      AppMethodBeat.i(272402);
      AppMethodBeat.o(272402);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272437);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MMMvVideoLayout.a(this.TGK), "onSurfaceTextureAvailable, surface:" + paramSurfaceTexture.hashCode() + ", width:" + paramInt1 + ", height:" + paramInt2 + ", enableEffect:" + MMMvVideoLayout.g(this.TGK));
      MMMvVideoLayout.a(this.TGK, paramSurfaceTexture);
      this.TGK.getEffector().mh(paramInt1, paramInt2);
      if (MMMvVideoLayout.g(this.TGK))
      {
        this.TGK.getEffector().r(paramSurfaceTexture);
        AppMethodBeat.o(272437);
        return;
      }
      MMMvVideoLayout.b(this.TGK, paramSurfaceTexture);
      if (MMMvVideoLayout.h(this.TGK) != null)
      {
        paramSurfaceTexture = MMMvVideoLayout.h(this.TGK);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      MMMvVideoLayout.a(this.TGK, new Surface(MMMvVideoLayout.i(this.TGK)));
      paramSurfaceTexture = this.TGK.getCurrentPlayer();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.b(MMMvVideoLayout.h(this.TGK), true);
      }
      AppMethodBeat.o(272437);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272429);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MMMvVideoLayout.a(this.TGK), "onSurfaceTextureDestroyed, surface:" + paramSurfaceTexture.hashCode() + ' ' + MMMvVideoLayout.f(this.TGK));
      MMMvVideoLayout.a(this.TGK, null);
      if (!MMMvVideoLayout.g(this.TGK))
      {
        paramSurfaceTexture = MMMvVideoLayout.h(this.TGK);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      paramSurfaceTexture = this.TGK.getCurrentPlayer();
      if (paramSurfaceTexture != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.a(paramSurfaceTexture, null);
      }
      AppMethodBeat.o(272429);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272412);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MMMvVideoLayout.a(this.TGK), "onSurfaceTextureSizeChanged " + paramSurfaceTexture + ", size:[" + paramInt1 + ',' + paramInt2 + ']');
      MMMvVideoLayout.a(this.TGK, paramSurfaceTexture);
      this.TGK.getEffector().mh(paramInt1, paramInt2);
      AppMethodBeat.o(272412);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272420);
      s.u(paramSurfaceTexture, "surface");
      MMMvVideoLayout.b(this.TGK);
      MMMvVideoLayout.a(this.TGK, paramSurfaceTexture);
      AppMethodBeat.o(272420);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(MMMvVideoLayout paramMMMvVideoLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "timestamp", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    d(MMMvVideoLayout paramMMMvVideoLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$initEffector$3", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector$PlayerInfoProxy;", "currentPlayPosition", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e.b
  {
    e(MMMvVideoLayout paramMMMvVideoLayout) {}
    
    public final long hKQ()
    {
      AppMethodBeat.i(272409);
      com.tencent.mm.plugin.thumbplayer.e.b localb = this.TGK.getCurrentPlayer();
      if (localb == null)
      {
        AppMethodBeat.o(272409);
        return -1L;
      }
      long l = localb.getCurrentPositionMs();
      AppMethodBeat.o(272409);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout$initPlayer$2", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "timeMs", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements e
  {
    f(MMMvVideoLayout paramMMMvVideoLayout, com.tencent.mm.plugin.thumbplayer.e.b paramb) {}
    
    public final void a(com.tencent.mm.plugin.thumbplayer.a.b paramb, long paramLong)
    {
      AppMethodBeat.i(272426);
      MMMvVideoLayout.a(this.TGK, false, 3);
      Object localObject = paramMessage.TFb;
      long l1;
      long l2;
      label48:
      String str;
      if (localObject == null)
      {
        l1 = 0L;
        localObject = paramMessage.TFb;
        if (localObject != null) {
          break label211;
        }
        l2 = 0L;
        str = MMMvVideoLayout.a(this.TGK);
        StringBuilder localStringBuilder = new StringBuilder("timeMs=").append(paramLong).append(", originOffset=");
        localObject = paramMessage.TFb;
        if (localObject != null) {
          break label221;
        }
        localObject = null;
        label94:
        localStringBuilder = localStringBuilder.append(localObject).append(", length=");
        localObject = paramMessage.TFb;
        if (localObject != null) {
          break label234;
        }
        localObject = null;
        label125:
        localObject = localStringBuilder.append(localObject).append(", media=");
        if (paramb == null) {
          break label247;
        }
      }
      label211:
      label221:
      label234:
      label247:
      for (int i = paramb.hashCode();; i = 0)
      {
        Log.w(str, i);
        paramb = this.TGK.getOnProgressUpdate();
        if (paramb != null) {
          paramb.invoke(Long.valueOf(paramLong - l2), Long.valueOf(l1));
        }
        AppMethodBeat.o(272426);
        return;
        l1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).TBN;
        break;
        l2 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).TBO;
        break label48;
        localObject = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject).TBO);
        break label94;
        localObject = Long.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject).TBN);
        break label125;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    g(MMMvVideoLayout paramMMMvVideoLayout, com.tencent.mm.plugin.thumbplayer.e.b paramb, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout
 * JD-Core Version:    0.7.0.1
 */