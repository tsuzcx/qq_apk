package com.tencent.mm.plugin.thumbplayer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.e;
import com.tencent.mm.plugin.thumbplayer.c.i;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.plugin.thumbplayer.g.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.b;
import com.tencent.mm.pluginsdk.ui.tools.k.c;
import com.tencent.mm.pluginsdk.ui.tools.k.d;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.pluginsdk.ui.tools.y;
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
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callbacks", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$Callbacks;", "delayBufferingAction", "Ljava/lang/Runnable;", "firstFrameNotified", "", "isLoop", "isOnlineVideo", "()Z", "setOnlineVideo", "(Z)V", "loopStartCallback", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnLoopStartCallback;", "getLoopStartCallback", "()Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnLoopStartCallback;", "setLoopStartCallback", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnLoopStartCallback;)V", "muted", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerListeners", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$PlayerListeners;", "progressJob", "Lkotlinx/coroutines/Job;", "value", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnProgressListener;", "progressListener", "getProgressListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnProgressListener;", "setProgressListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnProgressListener;)V", "reporters", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/PlayerReporter;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "scaleType", "getScaleType", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setScaleType", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;)V", "seekTarget", "", "Ljava/lang/Double;", "seekTime", "", "shouldPlayAfterSeek", "sizeCache", "Lcom/tencent/mm/pluginsdk/ui/tools/ViewSizeCache;", "state", "state$annotations", "()V", "surfaceListener", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$SurfaceListener;", "videoDegree", "videoHeight", "videoPath", "", "videoWidth", "addReporter", "", "reporter", "clearReporters", "createPlayer", "getCurrentPosition", "getDuration", "getLastProgresstime", "getLastSurfaceUpdateTime", "getVideoPath", "isInitialized", "isPause", "isPlaying", "isPrepared", "onDetach", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "pause", "prepare", "release", "report", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "rotateVideoSurface", "measureWidth", "measureHeight", "seekTo", "time", "afterSeekPlay", "setForceScaleFullScreen", "forceScale", "setLoop", "loop", "setMute", "mute", "setOnInfoCallback", "callback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;", "setOnSeekCompleteCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;", "setOnSurfaceCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "setOneTimeVideoTextureUpdateCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;", "setPlayProgressCallback", "isTrue", "setResourceDownloader", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "setThumb", "bmp", "Landroid/graphics/Bitmap;", "setVideoCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "setVideoCenter", "setVideoPath", "path", "setVideoSize", "width", "height", "start", "force", "startProgress", "stop", "stopProgress", "tryNotifyFirstFrameRendered", "Callbacks", "Companion", "OnLoopStartCallback", "OnProgressListener", "PlayerListeners", "SurfaceListener", "plugin-thumbplayer_release"})
public final class ThumbPlayerVideoView
  extends MMTextureView
  implements k
{
  public static final ThumbPlayerVideoView.b MUM;
  private com.tencent.mm.plugin.thumbplayer.f.a AMn;
  private i.e HKU;
  private boolean MUA;
  private Double MUB;
  private final e MUC;
  private final a MUD;
  private final f MUE;
  private boolean MUF;
  private long MUG;
  private Runnable MUH;
  private ThumbPlayerVideoView.c MUI;
  private by MUJ;
  private ThumbPlayerVideoView.d MUK;
  public final ArrayList<c> MUL;
  private int MUn;
  private boolean mfK;
  private boolean muted;
  private y sTV;
  public int state;
  public boolean uXY;
  int videoHeight;
  private String videoPath;
  int videoWidth;
  
  static
  {
    AppMethodBeat.i(192655);
    MUM = new ThumbPlayerVideoView.b((byte)0);
    AppMethodBeat.o(192655);
  }
  
  public ThumbPlayerVideoView(Context paramContext)
  {
    this(paramContext, null, 6, (byte)0);
  }
  
  public ThumbPlayerVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public ThumbPlayerVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192647);
    this.MUC = new e();
    this.MUD = new a();
    this.MUE = new f();
    this.state = 1;
    this.sTV = new y();
    this.HKU = i.e.RcE;
    this.MUL = new ArrayList();
    setOpaque(true);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.MUE);
    AppMethodBeat.o(192647);
  }
  
  private final void Y(b<? super c, x> paramb)
  {
    AppMethodBeat.i(192645);
    Iterator localIterator = ((Iterable)j.p((Iterable)this.MUL)).iterator();
    while (localIterator.hasNext()) {
      paramb.invoke(localIterator.next());
    }
    AppMethodBeat.o(192645);
  }
  
  private final void gpc()
  {
    AppMethodBeat.i(192597);
    Log.i("MicroMsg.ThumbPlayerVideoView", "stopProgress");
    by localby = this.MUJ;
    if (localby != null) {
      localby.a(null);
    }
    this.MUJ = null;
    AppMethodBeat.o(192597);
  }
  
  private final void gpd()
  {
    boolean bool = true;
    AppMethodBeat.i(192602);
    by localby = this.MUJ;
    if ((localby != null) && (localby.isActive() == true)) {}
    for (;;)
    {
      Log.i("MicroMsg.ThumbPlayerVideoView", "startProgress: isActive=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      AppMethodBeat.o(192602);
      return;
      bool = false;
    }
    localby = this.MUJ;
    if (localby != null) {
      localby.a(null);
    }
    this.MUJ = g.b((ak)br.abxo, (f)bc.iRr(), (m)new ThumbPlayerVideoView.m(this, null), 2);
    AppMethodBeat.o(192602);
  }
  
  private final com.tencent.mm.plugin.thumbplayer.f.a gpe()
  {
    AppMethodBeat.i(192642);
    if (this.AMn == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Previous player instance hasn't been released".toString());
      AppMethodBeat.o(192642);
      throw ((Throwable)localObject);
    }
    Object localObject = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getApplicationContext();
    p.j(localObject, "context.applicationContext");
    localObject = d.a.iz((Context)localObject);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnErrorListener((ITPPlayerListener.IOnErrorListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOnInfoListener((ITPPlayerListener.IOnInfoListener)this.MUC);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setOutputMute(this.muted);
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setLoopback(this.mfK);
    Log.i("MicroMsg.ThumbPlayerVideoView", "created a new player instance: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(192642);
    return localObject;
  }
  
  private final void release()
  {
    AppMethodBeat.i(192593);
    Log.i("MicroMsg.ThumbPlayerVideoView", "release");
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null)
    {
      AppMethodBeat.o(192593);
      return;
    }
    if (this.MUH != null)
    {
      removeCallbacks(this.MUH);
      this.MUH = null;
    }
    this.MUF = false;
    this.AMn = null;
    this.videoPath = null;
    this.uXY = false;
    this.state = 11;
    gpc();
    this.MUL.clear();
    com.tencent.mm.ae.d.c("MicroMsg.ThumbPlayerVideoView_release", (kotlin.g.a.a)new ThumbPlayerVideoView.h(locala));
    AppMethodBeat.o(192593);
  }
  
  public final boolean I(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(192587);
    paramBoolean = start();
    AppMethodBeat.o(192587);
    return paramBoolean;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(192552);
    p.k(paramc, "reporter");
    if (this.MUL.contains(paramc))
    {
      AppMethodBeat.o(192552);
      return;
    }
    this.MUL.add(paramc);
    AppMethodBeat.o(192552);
  }
  
  public final boolean ayN()
  {
    switch (this.state)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final void b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(192625);
    Log.i("MicroMsg.ThumbPlayerVideoView", "seekTo: time=" + paramDouble + ", afterSeekPlay=" + paramBoolean + ", isPrepared=" + ayN());
    this.MUA = paramBoolean;
    if (this.MUE.surface == null)
    {
      this.MUB = Double.valueOf(paramDouble);
      Log.w("MicroMsg.ThumbPlayerVideoView", "surface is not ready, post execute seek operation");
      AppMethodBeat.o(192625);
      return;
    }
    this.MUB = null;
    this.MUG = Util.nowMilliSecond();
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    int j;
    if (locala != null)
    {
      j = (int)paramDouble;
      if (!paramBoolean) {
        break label158;
      }
    }
    label158:
    for (int i = 3;; i = 1)
    {
      locala.seekTo(j, i);
      Y((b)new ThumbPlayerVideoView.i(paramDouble));
      AppMethodBeat.o(192625);
      return;
    }
  }
  
  final void cEw()
  {
    AppMethodBeat.i(192560);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams == null)
    {
      AppMethodBeat.o(192560);
      return;
    }
    if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
    {
      if ((Build.VERSION.SDK_INT >= 23) && (((RelativeLayout.LayoutParams)localLayoutParams).getRule(13) == -1))
      {
        AppMethodBeat.o(192560);
        return;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(13);
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(192560);
      return;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        ((FrameLayout.LayoutParams)localLayoutParams).gravity = 17;
      }
      else
      {
        if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
          break;
        }
        ((LinearLayout.LayoutParams)localLayoutParams).gravity = 17;
      }
    }
    AppMethodBeat.o(192560);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(192612);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null)
    {
      int i = (int)locala.getCurrentPositionMs();
      AppMethodBeat.o(192612);
      return i;
    }
    AppMethodBeat.o(192612);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(192614);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null)
    {
      int i = (int)locala.getDurationMs();
      AppMethodBeat.o(192614);
      return i;
    }
    AppMethodBeat.o(192614);
    return 0;
  }
  
  public final double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public final long getLastSurfaceUpdateTime()
  {
    return this.MUE.MVa;
  }
  
  public final ThumbPlayerVideoView.c getLoopStartCallback()
  {
    return this.MUI;
  }
  
  public final ThumbPlayerVideoView.d getProgressListener()
  {
    return this.MUK;
  }
  
  public final i.e getScaleType()
  {
    return this.HKU;
  }
  
  public final String getVideoPath()
  {
    return this.videoPath;
  }
  
  public final boolean isInitialized()
  {
    return this.AMn != null;
  }
  
  public final boolean isPlaying()
  {
    return this.state == 5;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(192607);
    Log.i("MicroMsg.ThumbPlayerVideoView", "onDetach()");
    AppMethodBeat.o(192607);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192546);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(192546);
      return;
    }
    paramInt1 = MMTextureView.getDefaultSize(1, paramInt1);
    paramInt2 = MMTextureView.getDefaultSize(1, paramInt2);
    int i = this.videoWidth;
    int j = this.videoHeight;
    this.sTV.A(paramInt1, paramInt2, i, j);
    paramInt1 = this.sTV.pEl;
    paramInt2 = this.sTV.pEm;
    if ((this.MUn == 90) || (this.MUn == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.MUn, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(192546);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(192605);
    Log.i("MicroMsg.ThumbPlayerVideoView", "pause()");
    this.MUA = false;
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null) {
      locala.pause();
    }
    this.state = 6;
    Y((b)ThumbPlayerVideoView.g.MVb);
    gpc();
    AppMethodBeat.o(192605);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(192584);
    Log.i("MicroMsg.ThumbPlayerVideoView", "prepare()");
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null)
    {
      locala.prepareAsync();
      AppMethodBeat.o(192584);
      return;
    }
    AppMethodBeat.o(192584);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(192618);
    b(paramDouble, false);
    AppMethodBeat.o(192618);
  }
  
  public final void setForceScaleFullScreen(boolean paramBoolean)
  {
    AppMethodBeat.i(192629);
    this.sTV.pDp = paramBoolean;
    requestLayout();
    AppMethodBeat.o(192629);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(192610);
    Log.i("MicroMsg.ThumbPlayerVideoView", "setLoop(" + paramBoolean + ')');
    this.mfK = paramBoolean;
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null)
    {
      locala.setLoopback(paramBoolean);
      AppMethodBeat.o(192610);
      return;
    }
    AppMethodBeat.o(192610);
  }
  
  public final void setLoopStartCallback(ThumbPlayerVideoView.c paramc)
  {
    this.MUI = paramc;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(192639);
    Log.i("MicroMsg.ThumbPlayerVideoView", "setMute(" + paramBoolean + ')');
    this.muted = paramBoolean;
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null)
    {
      locala.setOutputMute(paramBoolean);
      AppMethodBeat.o(192639);
      return;
    }
    AppMethodBeat.o(192639);
  }
  
  public final void setOnInfoCallback(k.b paramb)
  {
    this.MUD.MUO = paramb;
  }
  
  public final void setOnSeekCompleteCallback(k.c paramc)
  {
    this.MUD.MUR = paramc;
  }
  
  public final void setOnSurfaceCallback(k.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(192567);
    if (paramd != null)
    {
      Surface localSurface = this.MUE.surface;
      if ((localSurface == null) || (localSurface.isValid() != true)) {
        break label57;
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramd.bqp();
      }
      this.MUD.MUN = paramd;
      AppMethodBeat.o(192567);
      return;
      label57:
      i = 0;
    }
  }
  
  public final void setOneTimeVideoTextureUpdateCallback(k.e parame)
  {
    this.MUF = false;
    this.MUD.MUP = parame;
  }
  
  public final void setOnlineVideo(boolean paramBoolean)
  {
    this.uXY = paramBoolean;
  }
  
  public final void setPlayProgressCallback(boolean paramBoolean) {}
  
  public final void setProgressListener(ThumbPlayerVideoView.d paramd)
  {
    AppMethodBeat.i(192539);
    this.MUK = paramd;
    if (this.MUK == null) {
      gpc();
    }
    AppMethodBeat.o(192539);
  }
  
  public final void setResourceDownloader(i parami)
  {
    AppMethodBeat.i(192582);
    p.k(parami, "downloader");
    this.uXY = true;
    this.videoPath = null;
    if (this.AMn == null) {
      this.AMn = gpe();
    }
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null)
    {
      AppMethodBeat.o(192582);
      return;
    }
    this.videoPath = parami.gnQ();
    locala.setVideoInfo(new TPVideoInfo.Builder().fileId(parami.getMediaId()).downloadParam(new TPDownloadParamData(11)).build());
    locala.enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)new e(parami));
    String str = parami.getMediaId();
    if (str == null) {
      p.iCn();
    }
    locala.setMediaId(str);
    locala.setDataSource("http://127.0.0.1:1234/mock_url");
    this.state = 3;
    Y((b)new ThumbPlayerVideoView.j(parami));
    AppMethodBeat.o(192582);
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(192540);
    p.k(parame, "value");
    this.HKU = parame;
    if (this.sTV.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(192540);
  }
  
  public final void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(192616);
    Log.w("MicroMsg.ThumbPlayerVideoView", "setThumb but not support");
    AppMethodBeat.o(192616);
  }
  
  public final void setVideoCallback(k.a parama)
  {
    this.MUD.MUQ = parama;
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(192576);
    Log.i("MicroMsg.ThumbPlayerVideoView", "setVideoPath: ".concat(String.valueOf(paramString)));
    this.videoPath = paramString;
    this.uXY = false;
    if (paramString == null)
    {
      Log.w("MicroMsg.ThumbPlayerVideoView", "null video path");
      AppMethodBeat.o(192576);
      return;
    }
    if (this.AMn == null) {
      this.AMn = gpe();
    }
    if (!u.agG(paramString))
    {
      paramString = (Throwable)new IllegalStateException("File doesn't exists: ".concat(String.valueOf(paramString)).toString());
      AppMethodBeat.o(192576);
      throw paramString;
    }
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null)
    {
      AppMethodBeat.o(192576);
      return;
    }
    locala.setDataSource(u.n(paramString, false));
    locala.enableTPAssetResourceLoader(null);
    locala.prepareAsync();
    this.state = 3;
    Y((b)new ThumbPlayerVideoView.k(paramString));
    AppMethodBeat.o(192576);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(192585);
    Log.i("MicroMsg.ThumbPlayerVideoView", "start()");
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null) {
      locala.start();
    }
    locala = this.AMn;
    if (locala != null) {
      locala.resumeDownload();
    }
    Y((b)ThumbPlayerVideoView.l.MVf);
    gpd();
    AppMethodBeat.o(192585);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(192592);
    Log.i("MicroMsg.ThumbPlayerVideoView", "stop()");
    this.state = 8;
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala != null) {
      locala.stop();
    }
    locala = this.AMn;
    if (locala != null) {
      locala.reset();
    }
    this.sTV.reset();
    Y((b)ThumbPlayerVideoView.n.MVg);
    release();
    AppMethodBeat.o(192592);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$Callbacks;", "", "()V", "firstFrameRendered", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;", "getFirstFrameRendered", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;", "setFirstFrameRendered", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;)V", "info", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;", "getInfo", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;", "setInfo", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;)V", "seekCompletion", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;", "getSeekCompletion", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;", "setSeekCompletion", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;)V", "surface", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "getSurface", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "setSurface", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;)V", "video", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "getVideo", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "setVideo", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;)V", "plugin-thumbplayer_release"})
  static final class a
  {
    k.d MUN;
    k.b MUO;
    k.e MUP;
    k.a MUQ;
    k.c MUR;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$PlayerListeners;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onSeekComplete", "onStateChange", "preState", "curState", "onVideoSizeChanged", "width", "height", "plugin-thumbplayer_release"})
  final class e
    implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(193015);
      p.k(paramITPPlayer, "player");
      Log.i("MicroMsg.ThumbPlayerVideoView", "onCompletion");
      ThumbPlayerVideoView.i(this.MUS);
      ThumbPlayerVideoView.a(this.MUS, (b)ThumbPlayerVideoView.e.a.MUT);
      paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUQ;
      if (paramITPPlayer != null)
      {
        paramITPPlayer.onCompletion();
        AppMethodBeat.o(193015);
        return;
      }
      AppMethodBeat.o(193015);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(193011);
      Log.e("MicroMsg.ThumbPlayerVideoView", "onError: type=" + paramInt1 + ", code=" + paramInt2 + ", " + paramLong1 + ", " + paramLong2);
      paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUQ;
      if (paramITPPlayer != null) {
        paramITPPlayer.onError(paramInt2, paramInt1);
      }
      ThumbPlayerVideoView.a(this.MUS, (b)new ThumbPlayerVideoView.e.b(paramInt2));
      ThumbPlayerVideoView.h(this.MUS);
      AppMethodBeat.o(193011);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(193036);
      switch (paramInt)
      {
      default: 
        Log.i("MicroMsg.ThumbPlayerVideoView", "unhandled event: what=" + paramInt + ", (" + paramLong1 + ", " + paramLong2 + ')');
      }
      for (;;)
      {
        ThumbPlayerVideoView.a(this.MUS, (b)new ThumbPlayerVideoView.e.f(paramInt, paramLong1, paramLong2));
        AppMethodBeat.o(193036);
        return;
        long l = Util.milliSecondsToNow(ThumbPlayerVideoView.k(this.MUS));
        boolean bool;
        if (l <= 300L)
        {
          bool = true;
          label168:
          Log.d("MicroMsg.ThumbPlayerVideoView", "buffering start: shouldDebounce=".concat(String.valueOf(bool)));
          if (!bool) {
            break label249;
          }
          ThumbPlayerVideoView.a(this.MUS, (Runnable)new c(this));
          this.MUS.postDelayed(ThumbPlayerVideoView.l(this.MUS), 300L - l);
        }
        for (;;)
        {
          ThumbPlayerVideoView.a(this.MUS, (b)ThumbPlayerVideoView.e.d.MUV);
          break;
          bool = false;
          break label168;
          label249:
          paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUO;
          if (paramITPPlayer != null) {
            paramITPPlayer.eN(701, 0);
          }
        }
        Log.d("MicroMsg.ThumbPlayerVideoView", "buffering end, delayBufferingAction=" + ThumbPlayerVideoView.l(this.MUS));
        if (ThumbPlayerVideoView.l(this.MUS) != null)
        {
          this.MUS.removeCallbacks(ThumbPlayerVideoView.l(this.MUS));
          ThumbPlayerVideoView.a(this.MUS, null);
        }
        for (;;)
        {
          ThumbPlayerVideoView.a(this.MUS, (b)ThumbPlayerVideoView.e.e.MUW);
          break;
          paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUO;
          if (paramITPPlayer != null) {
            paramITPPlayer.eN(702, 0);
          }
        }
        Log.i("MicroMsg.ThumbPlayerVideoView", "loop start");
        paramITPPlayer = this.MUS.getLoopStartCallback();
        if (paramITPPlayer != null)
        {
          paramITPPlayer.fUv();
          continue;
          Log.i("MicroMsg.ThumbPlayerVideoView", "first video frame rendered");
          ThumbPlayerVideoView.m(this.MUS);
          continue;
          Log.i("MicroMsg.ThumbPlayerVideoView", "first audio frame rendered");
          continue;
          Log.i("MicroMsg.ThumbPlayerVideoView", "download progress updated");
          continue;
          Log.i("MicroMsg.ThumbPlayerVideoView", "player stopped");
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(193023);
      Log.i("MicroMsg.ThumbPlayerVideoView", "onPrepared");
      Surface localSurface = ThumbPlayerVideoView.j(this.MUS).surface;
      if ((localSurface != null) && (paramITPPlayer != null)) {
        paramITPPlayer.setSurface(localSurface);
      }
      paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUQ;
      if (paramITPPlayer != null)
      {
        paramITPPlayer.qX();
        AppMethodBeat.o(193023);
        return;
      }
      AppMethodBeat.o(193023);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(193020);
      Log.i("MicroMsg.ThumbPlayerVideoView", "onSeekComplete: shouldPlay=" + ThumbPlayerVideoView.e(this.MUS) + ", isPlaying=" + this.MUS.isPlaying());
      if (ThumbPlayerVideoView.e(this.MUS)) {
        this.MUS.start();
      }
      ThumbPlayerVideoView.a(this.MUS, (b)ThumbPlayerVideoView.e.g.MUZ);
      paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUR;
      if (paramITPPlayer != null) {
        paramITPPlayer.gz(ThumbPlayerVideoView.e(this.MUS));
      }
      ThumbPlayerVideoView.f(this.MUS);
      AppMethodBeat.o(193020);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193003);
      Log.i("MicroMsg.ThumbPlayerVideoView", "preState=" + paramInt1 + ", curState=" + paramInt2);
      ThumbPlayerVideoView.a(this.MUS, paramInt2);
      AppMethodBeat.o(193003);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(193054);
      Log.i("MicroMsg.ThumbPlayerVideoView", "onVideoSizeChanged: " + paramLong1 + " x " + paramLong2);
      paramITPPlayer = this.MUS;
      int i = (int)paramLong1;
      int j = (int)paramLong2;
      Log.i("MicroMsg.ThumbPlayerVideoView", "setVideoSize: videoWidth=" + paramITPPlayer.videoWidth + ", videoHeight=" + paramITPPlayer.videoHeight + ", width=" + i + ", height=" + j);
      if ((paramITPPlayer.videoWidth != i) || (paramITPPlayer.videoHeight != j))
      {
        paramITPPlayer.videoWidth = i;
        paramITPPlayer.videoHeight = j;
        paramITPPlayer.cEw();
        paramITPPlayer.requestLayout();
      }
      paramITPPlayer = ThumbPlayerVideoView.g(this.MUS).MUQ;
      if (paramITPPlayer != null)
      {
        paramITPPlayer.eM(i, j);
        AppMethodBeat.o(193054);
        return;
      }
      AppMethodBeat.o(193054);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(ThumbPlayerVideoView.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(189433);
        ThumbPlayerVideoView.a(this.MUU.MUS, null);
        k.b localb = ThumbPlayerVideoView.g(this.MUU.MUS).MUO;
        if (localb != null)
        {
          localb.eN(701, 0);
          AppMethodBeat.o(189433);
          return;
        }
        AppMethodBeat.o(189433);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$SurfaceListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;)V", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceUpdateTime", "", "getSurfaceUpdateTime", "()J", "setSurfaceUpdateTime", "(J)V", "isSurfaceAvailable", "", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  final class f
    implements TextureView.SurfaceTextureListener
  {
    long MVa = -1L;
    Surface surface;
    
    @SuppressLint({"Recycle"})
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191440);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.ThumbPlayerVideoView", "onSurfaceTextureAvailable： " + paramSurfaceTexture + '(' + paramInt1 + " x " + paramInt2 + ')');
      if (this.surface != null)
      {
        Log.w("MicroMsg.ThumbPlayerVideoView", "surface is already valid");
        AppMethodBeat.o(191440);
        return;
      }
      Surface localSurface = this.surface;
      if (localSurface != null) {
        localSurface.release();
      }
      this.surface = new Surface(paramSurfaceTexture);
      paramSurfaceTexture = ThumbPlayerVideoView.a(this.MUS);
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.setSurface(this.surface);
      }
      ThumbPlayerVideoView.b(this.MUS);
      ThumbPlayerVideoView.c(this.MUS);
      paramSurfaceTexture = ThumbPlayerVideoView.d(this.MUS);
      if (paramSurfaceTexture != null)
      {
        double d = ((Number)paramSurfaceTexture).doubleValue();
        this.MUS.b(d, ThumbPlayerVideoView.e(this.MUS));
        AppMethodBeat.o(191440);
        return;
      }
      AppMethodBeat.o(191440);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(191445);
      Log.w("MicroMsg.ThumbPlayerVideoView", "onSurfaceTextureDestroyed");
      paramSurfaceTexture = this.surface;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.release();
      }
      this.surface = null;
      ThumbPlayerVideoView.b(this.MUS);
      AppMethodBeat.o(191445);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191444);
      Log.i("MicroMsg.ThumbPlayerVideoView", "onSurfaceTextureSizeChanged: " + paramInt1 + " x " + paramInt2);
      AppMethodBeat.o(191444);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(191446);
      p.k(paramSurfaceTexture, "surface");
      this.MVa = paramSurfaceTexture.getTimestamp();
      AppMethodBeat.o(191446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */