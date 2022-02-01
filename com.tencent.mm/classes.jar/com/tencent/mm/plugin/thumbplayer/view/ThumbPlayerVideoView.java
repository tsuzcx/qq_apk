package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.thumbplayer.downloader.e;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.b;
import com.tencent.mm.pluginsdk.ui.tools.i.c;
import com.tencent.mm.pluginsdk.ui.tools.i.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
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
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "autoFixRotation", "", "callbacks", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$Callbacks;", "delayBufferingAction", "Ljava/lang/Runnable;", "firstFrameNotified", "fixRotation", "isLoop", "isOnlineVideo", "()Z", "setOnlineVideo", "(Z)V", "loopStartCallback", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnLoopStartCallback;", "getLoopStartCallback", "()Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnLoopStartCallback;", "setLoopStartCallback", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnLoopStartCallback;)V", "muted", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerListeners", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$PlayerListeners;", "progressJob", "Lkotlinx/coroutines/Job;", "value", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnProgressListener;", "progressListener", "getProgressListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnProgressListener;", "setProgressListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$OnProgressListener;)V", "reporters", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/PlayerReporter;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "scaleType", "getScaleType", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setScaleType", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;)V", "seekTarget", "", "Ljava/lang/Double;", "seekTime", "", "shouldPlayAfterSeek", "sizeCache", "Lcom/tencent/mm/pluginsdk/ui/tools/ViewSizeCache;", "state", "getState$annotations", "()V", "surfaceListener", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$SurfaceListener;", "videoDegree", "videoHeight", "videoPath", "videoWidth", "addReporter", "", "reporter", "clearReporters", "createPlayer", "getCurrentPosition", "getDuration", "getLastProgresstime", "getLastSurfaceUpdateTime", "getVideoPath", "isInitialized", "isPause", "isPlaying", "isPrepared", "onDetach", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "pause", "prepare", "release", "report", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "rotateVideoSurface", "measureWidth", "measureHeight", "seekTo", "time", "afterSeekPlay", "setAutoFixRotation", "setForceScaleFullScreen", "forceScale", "setLoop", "loop", "setMute", "mute", "setOnInfoCallback", "callback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;", "setOnSeekCompleteCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;", "setOnSurfaceCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "setOneTimeVideoTextureUpdateCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;", "setPlayProgressCallback", "isTrue", "setResourceDownloader", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "setThumb", "bmp", "Landroid/graphics/Bitmap;", "setVideoCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "setVideoCenter", "setVideoPath", "path", "setVideoSize", "width", "height", "start", "force", "startProgress", "stop", "stopProgress", "tryFixRotate", "Landroid/util/Size;", "screenWidth", "screenHeight", "tryNotifyFirstFrameRendered", "Callbacks", "Companion", "OnLoopStartCallback", "OnProgressListener", "PlayerListeners", "SurfaceListener", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ThumbPlayerVideoView
  extends MMTextureView
  implements com.tencent.mm.pluginsdk.ui.tools.i
{
  public static final ThumbPlayerVideoView.b THa;
  private com.tencent.mm.plugin.thumbplayer.e.a Flb;
  private com.tencent.mm.pluginsdk.ui.i.e NHS;
  final String TAG;
  private int TFO;
  private boolean THb;
  private Double THc;
  private final e THd;
  private final a THe;
  private final f THf;
  private boolean THg;
  private long THh;
  private Runnable THi;
  private boolean THj;
  private int THk;
  private ThumbPlayerVideoView.c THl;
  private cb THm;
  private ThumbPlayerVideoView.d THn;
  public final CopyOnWriteArrayList<com.tencent.mm.plugin.thumbplayer.f.c> THo;
  private boolean muted;
  private boolean oYG;
  public int state;
  private x vZi;
  int videoHeight;
  private String videoPath;
  int videoWidth;
  public boolean ykm;
  
  static
  {
    AppMethodBeat.i(272632);
    THa = new ThumbPlayerVideoView.b((byte)0);
    AppMethodBeat.o(272632);
  }
  
  public ThumbPlayerVideoView(Context paramContext)
  {
    this(paramContext, null, 6, (byte)0);
    AppMethodBeat.i(272545);
    AppMethodBeat.o(272545);
  }
  
  public ThumbPlayerVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(272538);
    AppMethodBeat.o(272538);
  }
  
  public ThumbPlayerVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272476);
    this.TAG = s.X("MicroMsg.ThumbPlayerVideoView@", Integer.valueOf(hashCode()));
    this.THd = new e();
    this.THe = new a();
    this.THf = new f();
    this.state = 1;
    this.vZi = new x();
    this.NHS = com.tencent.mm.pluginsdk.ui.i.e.XYK;
    this.THo = new CopyOnWriteArrayList();
    setOpaque(true);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.THf);
    AppMethodBeat.o(272476);
  }
  
  private final void aI(b<? super com.tencent.mm.plugin.thumbplayer.f.c, ah> paramb)
  {
    AppMethodBeat.i(272528);
    Iterator localIterator = ((Iterable)this.THo).iterator();
    while (localIterator.hasNext()) {
      paramb.invoke(localIterator.next());
    }
    AppMethodBeat.o(272528);
  }
  
  private final void hLP()
  {
    AppMethodBeat.i(272499);
    Log.i(this.TAG, "stopProgress");
    cb localcb = this.THm;
    if (localcb != null) {
      localcb.a(null);
    }
    this.THm = null;
    AppMethodBeat.o(272499);
  }
  
  private final void hLQ()
  {
    boolean bool = true;
    AppMethodBeat.i(272510);
    cb localcb = this.THm;
    if ((localcb != null) && (localcb.isActive() == true)) {}
    for (;;)
    {
      Log.i(this.TAG, s.X("startProgress: isActive=", Boolean.valueOf(bool)));
      if (!bool) {
        break;
      }
      AppMethodBeat.o(272510);
      return;
      bool = false;
    }
    localcb = this.THm;
    if (localcb != null) {
      localcb.a(null);
    }
    this.THm = j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new ThumbPlayerVideoView.m(this, null), 2);
    AppMethodBeat.o(272510);
  }
  
  private final com.tencent.mm.plugin.thumbplayer.e.a hcE()
  {
    boolean bool = true;
    AppMethodBeat.i(272523);
    if (this.Flb == null) {}
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Previous player instance hasn't been released".toString());
      AppMethodBeat.o(272523);
      throw ((Throwable)localObject);
    }
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvz, false)) {}
    for (;;)
    {
      localObject = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
      localObject = getContext().getApplicationContext();
      s.s(localObject, "context.applicationContext");
      localObject = d.a.kr((Context)localObject);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnErrorListener((ITPPlayerListener.IOnErrorListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOnInfoListener((ITPPlayerListener.IOnInfoListener)this.THd);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setOutputMute(this.muted);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setLoopback(this.oYG);
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setPlayerOptionalParam(new TPOptionalParam().buildBoolean(411, bool));
      Log.i(this.TAG, s.X("created a new player instance: ", localObject));
      AppMethodBeat.o(272523);
      return localObject;
      bool = false;
    }
  }
  
  private final void release()
  {
    AppMethodBeat.i(272494);
    Log.i(this.TAG, "release");
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala == null)
    {
      AppMethodBeat.o(272494);
      return;
    }
    if (this.THi != null)
    {
      removeCallbacks(this.THi);
      this.THi = null;
    }
    this.THg = false;
    this.Flb = null;
    this.videoPath = null;
    this.ykm = false;
    this.state = 11;
    hLP();
    this.THo.clear();
    com.tencent.mm.ae.d.e(s.X(this.TAG, "_release"), (kotlin.g.a.a)new h(locala, this));
    AppMethodBeat.o(272494);
  }
  
  public final void H(double paramDouble)
  {
    AppMethodBeat.i(272733);
    c(paramDouble, false);
    AppMethodBeat.o(272733);
  }
  
  public final boolean P(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(272700);
    paramBoolean = start();
    AppMethodBeat.o(272700);
    return paramBoolean;
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.f.c paramc)
  {
    AppMethodBeat.i(272663);
    s.u(paramc, "reporter");
    this.THo.addIfAbsent(paramc);
    AppMethodBeat.o(272663);
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(272738);
    Log.i(this.TAG, "seekTo: time=" + paramDouble + ", afterSeekPlay=" + paramBoolean + ", isPrepared=" + cxs());
    this.THb = paramBoolean;
    if (this.THf.surface == null)
    {
      this.THc = Double.valueOf(paramDouble);
      Log.w(this.TAG, "surface is not ready, post execute seek operation");
      AppMethodBeat.o(272738);
      return;
    }
    this.THc = null;
    this.THh = Util.nowMilliSecond();
    int j = getCurrentPosition();
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    int k;
    if (locala != null)
    {
      k = (int)paramDouble;
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (int i = 3;; i = 1)
    {
      locala.seekTo(k, i);
      aI((b)new ThumbPlayerVideoView.i(j, paramDouble));
      AppMethodBeat.o(272738);
      return;
    }
  }
  
  public final boolean cxs()
  {
    switch (this.state)
    {
    default: 
      return false;
    }
    return true;
  }
  
  final void dYi()
  {
    AppMethodBeat.i(272667);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams == null)
    {
      AppMethodBeat.o(272667);
      return;
    }
    if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
    {
      if ((Build.VERSION.SDK_INT >= 23) && (((RelativeLayout.LayoutParams)localLayoutParams).getRule(13) == -1))
      {
        AppMethodBeat.o(272667);
        return;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(13);
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(272667);
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
    AppMethodBeat.o(272667);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(272724);
    Object localObject = this.Flb;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf((int)((com.tencent.mm.plugin.thumbplayer.e.a)localObject).getCurrentPositionMs()))
    {
      AppMethodBeat.o(272724);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(272724);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(272727);
    Object localObject = this.Flb;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf((int)((com.tencent.mm.plugin.thumbplayer.e.a)localObject).getDurationMs()))
    {
      AppMethodBeat.o(272727);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(272727);
    return i;
  }
  
  public final double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public final long getLastSurfaceUpdateTime()
  {
    return this.THf.THC;
  }
  
  public final ThumbPlayerVideoView.c getLoopStartCallback()
  {
    return this.THl;
  }
  
  public final ThumbPlayerVideoView.d getProgressListener()
  {
    return this.THn;
  }
  
  public final com.tencent.mm.pluginsdk.ui.i.e getScaleType()
  {
    return this.NHS;
  }
  
  public final String getVideoPath()
  {
    return this.videoPath;
  }
  
  public final boolean isInitialized()
  {
    return this.Flb != null;
  }
  
  public final boolean isPlaying()
  {
    return this.state == 5;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(272714);
    Log.i(this.TAG, "onDetach()");
    AppMethodBeat.o(272714);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272661);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(272661);
      return;
    }
    int i = MMTextureView.getDefaultSize(1, paramInt1);
    paramInt2 = MMTextureView.getDefaultSize(1, paramInt2);
    paramInt1 = this.videoWidth;
    int j = this.videoHeight;
    this.vZi.G(i, paramInt2, paramInt1, j);
    j = this.vZi.sJw;
    int k = this.vZi.sJx;
    Object localObject;
    float f1;
    float f2;
    float f3;
    label174:
    label303:
    Matrix localMatrix;
    if ((this.TFO == 90) || (this.TFO == 270))
    {
      localObject = new Matrix();
      ((Matrix)localObject).set(getMatrix());
      f1 = j / 2.0F;
      f2 = k / 2.0F;
      f3 = k / j;
      if (getScaleX() == 1.0F)
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          if (getScaleY() != 1.0F) {
            break label449;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {}
        }
        else
        {
          ((Matrix)localObject).setScale(getScaleX(), getScaleY(), f1, f2);
        }
        ((Matrix)localObject).postRotate(this.TFO, f1, f2);
        ((Matrix)localObject).postScale(1.0F / f3, f3, f1, f2);
        setTransform((Matrix)localObject);
      }
    }
    else
    {
      if (!this.THj) {
        break label488;
      }
      localObject = new Size(j, k);
      if ((this.THk == 90) || (this.THk == 270))
      {
        f1 = k / j;
        if (i <= paramInt2) {
          break label454;
        }
        localObject = new Size((int)(k * f1), (int)(j * f1));
        localMatrix = new Matrix();
        localMatrix.set(getMatrix());
        f2 = ((Size)localObject).getWidth() / 2.0F;
        f3 = ((Size)localObject).getHeight() / 2.0F;
        if (getScaleX() != 1.0F) {
          break label478;
        }
        paramInt1 = 1;
        label352:
        if (paramInt1 != 0) {
          if (getScaleY() != 1.0F) {
            break label483;
          }
        }
      }
    }
    label449:
    label454:
    label478:
    label483:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        localMatrix.setScale(getScaleX(), getScaleY(), f2, f3);
      }
      localMatrix.postRotate(this.THk, f2, f3);
      localMatrix.postScale(f1, 1.0F / f1, f2, f3);
      setTransform(localMatrix);
      setMeasuredDimension(((Size)localObject).getWidth(), ((Size)localObject).getHeight());
      AppMethodBeat.o(272661);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label174;
      localObject = new Size((int)(k / f1), (int)(j / f1));
      break label303;
      paramInt1 = 0;
      break label352;
    }
    label488:
    setMeasuredDimension(j, k);
    AppMethodBeat.o(272661);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(272709);
    Log.i(this.TAG, s.X("pause(): player=", this.Flb));
    if (this.Flb == null)
    {
      AppMethodBeat.o(272709);
      return;
    }
    this.THb = false;
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala != null) {
      locala.pause();
    }
    this.state = 6;
    aI((b)ThumbPlayerVideoView.g.THD);
    hLP();
    AppMethodBeat.o(272709);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(272693);
    Log.i(this.TAG, s.X("prepare(): videoPath=", this.videoPath));
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala != null) {
      locala.prepareAsync();
    }
    AppMethodBeat.o(272693);
  }
  
  public final void setAutoFixRotation(boolean paramBoolean)
  {
    this.THj = paramBoolean;
  }
  
  public final void setForceScaleFullScreen(boolean paramBoolean)
  {
    AppMethodBeat.i(272741);
    this.vZi.sIB = paramBoolean;
    requestLayout();
    AppMethodBeat.o(272741);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(272718);
    Log.i(this.TAG, "setLoop(" + paramBoolean + ')');
    this.oYG = paramBoolean;
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala != null) {
      locala.setLoopback(paramBoolean);
    }
    AppMethodBeat.o(272718);
  }
  
  public final void setLoopStartCallback(ThumbPlayerVideoView.c paramc)
  {
    this.THl = paramc;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272753);
    Log.i(this.TAG, "setMute(" + paramBoolean + ')');
    this.muted = paramBoolean;
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala != null) {
      locala.setOutputMute(paramBoolean);
    }
    AppMethodBeat.o(272753);
  }
  
  public final void setOnInfoCallback(i.b paramb)
  {
    this.THe.THq = paramb;
  }
  
  public final void setOnSeekCompleteCallback(i.c paramc)
  {
    this.THe.THt = paramc;
  }
  
  public final void setOnSurfaceCallback(i.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(272678);
    if (paramd != null)
    {
      Surface localSurface = this.THf.surface;
      if ((localSurface == null) || (localSurface.isValid() != true)) {
        break label57;
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramd.bNV();
      }
      this.THe.THp = paramd;
      AppMethodBeat.o(272678);
      return;
      label57:
      i = 0;
    }
  }
  
  public final void setOneTimeVideoTextureUpdateCallback(com.tencent.mm.pluginsdk.ui.tools.i.e parame)
  {
    this.THg = false;
    this.THe.THr = parame;
  }
  
  public final void setOnlineVideo(boolean paramBoolean)
  {
    this.ykm = paramBoolean;
  }
  
  public final void setPlayProgressCallback(boolean paramBoolean) {}
  
  public final void setProgressListener(ThumbPlayerVideoView.d paramd)
  {
    AppMethodBeat.i(272647);
    this.THn = paramd;
    if (this.THn == null) {
      hLP();
    }
    AppMethodBeat.o(272647);
  }
  
  public final void setResourceDownloader(com.tencent.mm.plugin.thumbplayer.downloader.i parami)
  {
    AppMethodBeat.i(272690);
    s.u(parami, "downloader");
    this.ykm = true;
    this.videoPath = null;
    if (this.Flb == null) {
      this.Flb = hcE();
    }
    Log.i(this.TAG, s.X("setResourceDownloader: downloader=", parami));
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala == null)
    {
      AppMethodBeat.o(272690);
      return;
    }
    this.videoPath = parami.hKD();
    locala.setVideoInfo(new TPVideoInfo.Builder().fileId(parami.getMediaId()).downloadParam(new TPDownloadParamData(11)).build());
    locala.enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)new e(parami));
    parami = parami.getMediaId();
    s.checkNotNull(parami);
    locala.setMediaId(parami);
    locala.setDataSource("http://127.0.0.1:1234/mock_url");
    this.state = 3;
    aI((b)new ThumbPlayerVideoView.j(this));
    AppMethodBeat.o(272690);
  }
  
  public final void setScaleType(com.tencent.mm.pluginsdk.ui.i.e parame)
  {
    AppMethodBeat.i(272655);
    s.u(parame, "value");
    this.NHS = parame;
    if (this.vZi.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(272655);
  }
  
  public final void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(272730);
    Log.w(this.TAG, "setThumb but not support");
    AppMethodBeat.o(272730);
  }
  
  public final void setVideoCallback(i.a parama)
  {
    this.THe.THs = parama;
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(272682);
    Log.i(this.TAG, s.X("setVideoPath: ", paramString));
    this.videoPath = paramString;
    this.ykm = false;
    if (paramString == null)
    {
      Log.w(this.TAG, "null video path");
      AppMethodBeat.o(272682);
      return;
    }
    if (this.Flb == null) {
      this.Flb = hcE();
    }
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala == null)
    {
      AppMethodBeat.o(272682);
      return;
    }
    locala.setDataSource(y.n(paramString, false));
    locala.enableTPAssetResourceLoader(null);
    locala.prepareAsync();
    this.state = 3;
    aI((b)new ThumbPlayerVideoView.k(paramString));
    AppMethodBeat.o(272682);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(272697);
    Log.i(this.TAG, s.X("start(), videPath=", this.videoPath));
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala != null) {
      locala.start();
    }
    locala = this.Flb;
    if (locala != null) {
      locala.resumeDownload();
    }
    aI((b)ThumbPlayerVideoView.l.THH);
    hLQ();
    AppMethodBeat.o(272697);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272706);
    Log.i(this.TAG, "stop()");
    this.state = 8;
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala != null) {
      locala.stop();
    }
    locala = this.Flb;
    if (locala != null) {
      locala.reset();
    }
    this.vZi.reset();
    aI((b)ThumbPlayerVideoView.n.THI);
    release();
    AppMethodBeat.o(272706);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$Callbacks;", "", "()V", "firstFrameRendered", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;", "getFirstFrameRendered", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;", "setFirstFrameRendered", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OneTimeOnVideoTextureUpdateCallback;)V", "info", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;", "getInfo", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;", "setInfo", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnInfoCallback;)V", "seekCompletion", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;", "getSeekCompletion", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;", "setSeekCompletion", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSeekCompleteCallback;)V", "surface", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "getSurface", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "setSurface", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;)V", "video", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "getVideo", "()Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "setVideo", "(Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;)V", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    i.d THp;
    i.b THq;
    com.tencent.mm.pluginsdk.ui.tools.i.e THr;
    i.a THs;
    i.c THt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$PlayerListeners;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onSeekComplete", "onStateChange", "preState", "curState", "onVideoSizeChanged", "width", "height", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class e
    implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public e()
    {
      AppMethodBeat.i(272363);
      AppMethodBeat.o(272363);
    }
    
    private static final void p(ThumbPlayerVideoView paramThumbPlayerVideoView)
    {
      AppMethodBeat.i(272370);
      s.u(paramThumbPlayerVideoView, "this$0");
      ThumbPlayerVideoView.a(paramThumbPlayerVideoView, null);
      paramThumbPlayerVideoView = ThumbPlayerVideoView.i(paramThumbPlayerVideoView).THq;
      if (paramThumbPlayerVideoView != null) {
        paramThumbPlayerVideoView.onInfo(701, 0);
      }
      AppMethodBeat.o(272370);
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(272403);
      s.u(paramITPPlayer, "player");
      Log.i(ThumbPlayerVideoView.b(this.THu), "onCompletion");
      ThumbPlayerVideoView.j(this.THu);
      ThumbPlayerVideoView.a(this.THu, (b)ThumbPlayerVideoView.e.a.THv);
      paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THs;
      if (paramITPPlayer != null) {
        paramITPPlayer.onCompletion();
      }
      AppMethodBeat.o(272403);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272397);
      Log.e(ThumbPlayerVideoView.b(this.THu), "onError: type=" + paramInt1 + ", code=" + paramInt2 + ", " + paramLong1 + ", " + paramLong2);
      ThumbPlayerVideoView.a(this.THu, (b)new ThumbPlayerVideoView.e.b(paramInt2));
      ThumbPlayerVideoView.h(this.THu);
      paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THs;
      if (paramITPPlayer != null) {
        paramITPPlayer.onError(paramInt2, paramInt1);
      }
      AppMethodBeat.o(272397);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(272436);
      switch (paramInt)
      {
      default: 
        Log.i(ThumbPlayerVideoView.b(this.THu), "unhandled event: what=" + paramInt + ", (" + paramLong1 + ", " + paramLong2 + ')');
      }
      for (;;)
      {
        ThumbPlayerVideoView.a(this.THu, (b)new ThumbPlayerVideoView.e.e(paramInt, paramLong1, paramLong2));
        AppMethodBeat.o(272436);
        return;
        long l = Util.milliSecondsToNow(ThumbPlayerVideoView.m(this.THu));
        boolean bool;
        if (l <= 300L)
        {
          bool = true;
          label173:
          Log.d(ThumbPlayerVideoView.b(this.THu), s.X("buffering start: shouldDebounce=", Boolean.valueOf(bool)));
          if (!bool) {
            break label259;
          }
          ThumbPlayerVideoView.a(this.THu, new ThumbPlayerVideoView.e..ExternalSyntheticLambda0(this.THu));
          this.THu.postDelayed(ThumbPlayerVideoView.n(this.THu), 300L - l);
        }
        for (;;)
        {
          ThumbPlayerVideoView.a(this.THu, (b)ThumbPlayerVideoView.e.c.THw);
          break;
          bool = false;
          break label173;
          label259:
          paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THq;
          if (paramITPPlayer != null) {
            paramITPPlayer.onInfo(701, 0);
          }
        }
        Log.d(ThumbPlayerVideoView.b(this.THu), s.X("buffering end, delayBufferingAction=", ThumbPlayerVideoView.n(this.THu)));
        if (ThumbPlayerVideoView.n(this.THu) != null)
        {
          this.THu.removeCallbacks(ThumbPlayerVideoView.n(this.THu));
          ThumbPlayerVideoView.a(this.THu, null);
        }
        for (;;)
        {
          ThumbPlayerVideoView.a(this.THu, (b)ThumbPlayerVideoView.e.d.THx);
          break;
          paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THq;
          if (paramITPPlayer != null) {
            paramITPPlayer.onInfo(702, 0);
          }
        }
        Log.i(ThumbPlayerVideoView.b(this.THu), "loop start");
        paramITPPlayer = this.THu.getLoopStartCallback();
        if (paramITPPlayer != null)
        {
          paramITPPlayer.hmP();
          continue;
          Log.i(ThumbPlayerVideoView.b(this.THu), "first video frame rendered");
          ThumbPlayerVideoView.o(this.THu);
          continue;
          Log.i(ThumbPlayerVideoView.b(this.THu), "first audio frame rendered");
          continue;
          Log.i(ThumbPlayerVideoView.b(this.THu), "download progress updated");
          continue;
          Log.i(ThumbPlayerVideoView.b(this.THu), "player stopped");
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(272421);
      Log.i(ThumbPlayerVideoView.b(this.THu), "onPrepared");
      if (paramITPPlayer != null)
      {
        long l = paramITPPlayer.getPropertyLong(205);
        ThumbPlayerVideoView.b(this.THu, (int)((Number)Long.valueOf(l)).longValue());
      }
      Surface localSurface = ThumbPlayerVideoView.l(this.THu).surface;
      if ((localSurface != null) && (paramITPPlayer != null)) {
        paramITPPlayer.setSurface(localSurface, 1);
      }
      paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THs;
      if (paramITPPlayer != null) {
        paramITPPlayer.Qz();
      }
      AppMethodBeat.o(272421);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(272413);
      Log.i(ThumbPlayerVideoView.b(this.THu), "onSeekComplete: shouldPlay=" + ThumbPlayerVideoView.g(this.THu) + ", isPlaying=" + this.THu.isPlaying());
      if (ThumbPlayerVideoView.g(this.THu)) {
        this.THu.start();
      }
      ThumbPlayerVideoView.a(this.THu, (b)ThumbPlayerVideoView.e.f.THB);
      paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THt;
      if (paramITPPlayer != null) {
        paramITPPlayer.onSeekComplete(ThumbPlayerVideoView.g(this.THu));
      }
      ThumbPlayerVideoView.k(this.THu);
      AppMethodBeat.o(272413);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272388);
      Log.i(ThumbPlayerVideoView.b(this.THu), "preState=" + paramInt1 + ", curState=" + paramInt2);
      ThumbPlayerVideoView.a(this.THu, paramInt2);
      AppMethodBeat.o(272388);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(272442);
      Log.i(ThumbPlayerVideoView.b(this.THu), "onVideoSizeChanged: " + paramLong1 + " x " + paramLong2);
      paramITPPlayer = this.THu;
      int i = (int)paramLong1;
      int j = (int)paramLong2;
      Log.i(paramITPPlayer.TAG, "setVideoSize: videoWidth=" + paramITPPlayer.videoWidth + ", videoHeight=" + paramITPPlayer.videoHeight + ", width=" + i + ", height=" + j);
      if ((paramITPPlayer.videoWidth != i) || (paramITPPlayer.videoHeight != j))
      {
        paramITPPlayer.videoWidth = i;
        paramITPPlayer.videoHeight = j;
        paramITPPlayer.dYi();
        paramITPPlayer.requestLayout();
      }
      paramITPPlayer = ThumbPlayerVideoView.i(this.THu).THs;
      if (paramITPPlayer != null) {
        paramITPPlayer.fG(i, j);
      }
      AppMethodBeat.o(272442);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView$SurfaceListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;)V", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceUpdateTime", "", "getSurfaceUpdateTime", "()J", "setSurfaceUpdateTime", "(J)V", "isSurfaceAvailable", "", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class f
    implements TextureView.SurfaceTextureListener
  {
    long THC;
    Surface surface;
    
    public f()
    {
      AppMethodBeat.i(272359);
      this.THC = -1L;
      AppMethodBeat.o(272359);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272367);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(ThumbPlayerVideoView.b(this.THu), "onSurfaceTextureAvailable： " + paramSurfaceTexture + '(' + paramInt1 + " x " + paramInt2 + ')');
      if (this.surface != null)
      {
        Log.w(ThumbPlayerVideoView.b(this.THu), "surface is already valid");
        AppMethodBeat.o(272367);
        return;
      }
      Object localObject = this.surface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      this.surface = new Surface(paramSurfaceTexture);
      paramSurfaceTexture = ThumbPlayerVideoView.c(this.THu);
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.setSurface(this.surface, 1);
      }
      ThumbPlayerVideoView.d(this.THu);
      ThumbPlayerVideoView.e(this.THu);
      paramSurfaceTexture = ThumbPlayerVideoView.f(this.THu);
      if (paramSurfaceTexture != null)
      {
        localObject = this.THu;
        ((ThumbPlayerVideoView)localObject).c(((Number)paramSurfaceTexture).doubleValue(), ThumbPlayerVideoView.g((ThumbPlayerVideoView)localObject));
      }
      AppMethodBeat.o(272367);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272386);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.w(ThumbPlayerVideoView.b(this.THu), "onSurfaceTextureDestroyed");
      paramSurfaceTexture = this.surface;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.release();
      }
      this.surface = null;
      ThumbPlayerVideoView.d(this.THu);
      AppMethodBeat.o(272386);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272378);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(ThumbPlayerVideoView.b(this.THu), "onSurfaceTextureSizeChanged: " + paramInt1 + " x " + paramInt2);
      AppMethodBeat.o(272378);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272394);
      s.u(paramSurfaceTexture, "surface");
      this.THC = paramSurfaceTexture.getTimestamp();
      AppMethodBeat.o(272394);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(com.tencent.mm.plugin.thumbplayer.e.a parama, ThumbPlayerVideoView paramThumbPlayerVideoView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */