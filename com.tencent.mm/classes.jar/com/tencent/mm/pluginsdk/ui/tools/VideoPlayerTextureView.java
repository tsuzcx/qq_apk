package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.u.b;
import com.tencent.mm.plugin.u.d;
import com.tencent.mm.plugin.u.e;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.plugin.u.k;
import com.tencent.mm.plugin.u.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.threadpool.h;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements i
{
  protected FileDescriptor KSO;
  protected b KSQ;
  protected int Yul;
  protected i.e Yum;
  private i.c Yun;
  protected boolean Yuo;
  protected long cXM;
  protected boolean hS;
  protected boolean lAj;
  protected long length;
  protected Surface mSurface;
  protected SurfaceTexture mSurfaceTexture;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected String path;
  protected boolean sIB;
  protected long sIJ;
  protected boolean sIK;
  protected boolean sIL;
  private TextureView.SurfaceTextureListener sIN;
  protected x vZi;
  protected j ykf;
  protected boolean ykg;
  protected boolean ykh;
  protected i.a yki;
  protected i.d ykk;
  protected boolean ykl;
  protected boolean ykm;
  protected boolean ykn;
  protected d ykp;
  
  public VideoPlayerTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134040);
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.Yul = 0;
    this.hS = false;
    this.ykg = true;
    this.sIJ = 0L;
    this.sIB = false;
    this.ykh = false;
    this.ykl = false;
    this.ykm = false;
    this.ykn = false;
    this.sIK = false;
    this.sIL = false;
    this.Yuo = false;
    this.ykp = new d()
    {
      public final void Qz()
      {
        AppMethodBeat.i(134030);
        Log.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.hS = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.lAj);
        if (VideoPlayerTextureView.this.yki != null) {
          VideoPlayerTextureView.this.yki.Qz();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
      
      public final void as(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        Log.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.vZi.reset();
        VideoPlayerTextureView.this.Yul = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.dYi();
        if (VideoPlayerTextureView.this.yki != null) {
          VideoPlayerTextureView.this.yki.fG(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void dEH()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).onSeekComplete(VideoPlayerTextureView.this.ykg);
        }
        if (!VideoPlayerTextureView.this.ykg)
        {
          Log.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.ykg = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.ykf != null)
        {
          Log.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.ykf.info() });
          VideoPlayerTextureView.this.ykf.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.yki != null) {
          VideoPlayerTextureView.this.yki.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.yki != null) {
          VideoPlayerTextureView.this.yki.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
    };
    this.sIN = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134035);
        VideoPlayerTextureView.this.c(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(134035);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134037);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.n(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.sIK = false;
        VideoPlayerTextureView.this.sIL = false;
        if (VideoPlayerTextureView.this.ykf != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.sIK = true;
            VideoPlayerTextureView.this.ykf.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.sIK = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        Log.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.dYi();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.o(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.vZi = new x();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.sIN);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134040);
  }
  
  public void H(double paramDouble)
  {
    AppMethodBeat.i(134053);
    c(paramDouble, true);
    AppMethodBeat.o(134053);
  }
  
  public final boolean P(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134049);
    paramBoolean = start();
    AppMethodBeat.o(134049);
    return paramBoolean;
  }
  
  public final boolean aFF()
  {
    AppMethodBeat.i(134045);
    if (this.ykf != null)
    {
      j localj = this.ykf;
      if (localj.KTe != null)
      {
        boolean bool = e.aaK(localj.KTe.state);
        AppMethodBeat.o(134045);
        return bool;
      }
      AppMethodBeat.o(134045);
      return false;
    }
    AppMethodBeat.o(134045);
    return false;
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(134054);
    int i = hashCode();
    if (this.ykf == null) {}
    for (;;)
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d seekTo:%f  play is null?[%b", new Object[] { Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(bool) });
      this.ykg = paramBoolean;
      if (this.ykf != null) {
        this.ykf.aaS((int)paramDouble);
      }
      AppMethodBeat.o(134054);
      return;
      bool = false;
    }
  }
  
  protected void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134058);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.sIK) });
    for (;;)
    {
      try
      {
        jmM();
        n(this.mSurface);
        try
        {
          boolean bool = this.Yuo;
          if (bool) {
            continue;
          }
        }
        finally
        {
          Log.e("MicroMsg.VideoPlayerTextureView", localObject.toString());
          continue;
        }
        if ((!this.Yuo) || (this.mSurfaceTexture == null)) {
          break label235;
        }
        this.mSurface = new Surface(this.mSurfaceTexture);
        if ((this.ykf != null) && (this.hS)) {
          break;
        }
        cxo();
        dYi();
        if (this.ykk != null) {
          this.ykk.bNV();
        }
        AppMethodBeat.o(134058);
        return;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      if (paramSurfaceTexture != null) {
        if (this.mSurfaceTexture == null)
        {
          Log.i("MicroMsg.VideoPlayerTextureView", "first time to onSurfaceTextureAvailable");
          this.mSurfaceTexture = paramSurfaceTexture;
        }
        else
        {
          Log.i("MicroMsg.VideoPlayerTextureView", "video view onSurfaceTextureAvailable from detach to attach");
          setSurfaceTexture(this.mSurfaceTexture);
          continue;
          label235:
          this.mSurface = new Surface(paramSurfaceTexture);
        }
      }
    }
    this.ykf.r(this.mSurface);
    if (this.sIK) {
      this.ykf.start();
    }
    for (;;)
    {
      this.sIK = false;
      break;
      this.sIL = true;
      this.sIJ = 0L;
      this.ykf.setMute(true);
      this.ykf.start();
    }
  }
  
  protected void cxo()
  {
    AppMethodBeat.i(134056);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.ykf != null)
    {
      this.ykf.KTf = null;
      this.ykf.stop();
      this.ykf.release();
      this.ykf = null;
    }
    if (((Util.isNullOrNil(this.path)) && ((this.KSO == null) || (!this.KSO.valid()))) || (this.mSurface == null))
    {
      Log.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134056);
      return;
    }
    for (;;)
    {
      try
      {
        this.hS = false;
        this.ykf = new j(Looper.getMainLooper());
        if (!Util.isNullOrNil(this.path))
        {
          this.ykf.setPath(this.path);
          this.ykf.setIOnlineCache(this.KSQ);
          this.ykf.setNeedResetExtractor(this.ykl);
          this.ykf.setIsOnlineVideoType(this.ykm);
          this.ykf.KTf = this.ykp;
          this.ykf.setSurface(this.mSurface);
          this.ykf.yr(this.ykn);
          if (this.mSurface == null) {
            break;
          }
          this.ykf.prepare();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.yki != null) {
          this.yki.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.KSO != null) && (this.KSO.valid()))
      {
        j localj = this.ykf;
        FileDescriptor localFileDescriptor = this.KSO;
        long l1 = this.cXM;
        long l2 = this.length;
        localj.KTe.KTn.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.ykh) {
      this.ykf.prepare();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void cxp()
  {
    AppMethodBeat.i(134057);
    if ((this.ykf != null) && (this.hS) && (this.mSurface != null))
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      j localj = this.ykf;
      if (localj.KTe != null) {
        localj.KTe.cxp();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  protected void dYi()
  {
    AppMethodBeat.i(134061);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (localLayoutParams.getRule(13) == -1))
      {
        AppMethodBeat.o(134061);
        return;
      }
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(134061);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134041);
    if ((this.mSurface != null) && (this.mSurface.isValid())) {
      this.mSurface.release();
    }
    AppMethodBeat.o(134041);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134052);
    if (this.ykf != null)
    {
      int i = this.ykf.gbM();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.ykf != null) {
      return (int)this.ykf.KTe.durationMs;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.sIJ;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  public final boolean iOH()
  {
    if (this.mSurface == null) {}
    while (this.sIL) {
      return false;
    }
    return true;
  }
  
  public final void iOI()
  {
    AppMethodBeat.i(134047);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ykf != null)
    {
      j localj = this.ykf;
      if (localj.KTe != null) {
        localj.KTe.gbN();
      }
    }
    AppMethodBeat.o(134047);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.ykf != null)
    {
      boolean bool = this.ykf.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected final void n(Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    h.ahAA.bm(new VideoPlayerTextureView.3(this, paramSurface));
    AppMethodBeat.o(134060);
  }
  
  protected void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.sIL) && (this.sIJ > 0L) && (this.ykf != null))
    {
      this.ykf.pause();
      this.ykf.setMute(this.lAj);
      this.sIL = false;
    }
    if ((this.sIJ > 0L) && (this.Yum != null))
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.Yum.onTextureUpdate();
      this.Yum = null;
    }
    this.sIJ = System.currentTimeMillis();
    AppMethodBeat.o(134059);
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134063);
    Log.d("MicroMsg.VideoPlayerTextureView", "onMeasure video size[%d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight), Integer.valueOf(getDefaultSize(1, paramInt1)), Integer.valueOf(getDefaultSize(1, paramInt2)) });
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(134063);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.vZi.G(paramInt1, paramInt2, i, j);
    paramInt1 = this.vZi.sJw;
    paramInt2 = this.vZi.sJx;
    if ((this.Yul == 90) || (this.Yul == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.Yul, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.ykf != null) && (this.ykf.isPlaying())) {
      this.ykf.pause();
    }
    this.sIK = false;
    this.ykg = false;
    AppMethodBeat.o(134051);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(245583);
    try
    {
      boolean bool = this.Yuo;
      if (!bool)
      {
        AppMethodBeat.o(245583);
        return;
      }
      if (this.mSurfaceTexture == null) {
        break label95;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        if (this.mSurfaceTexture.isReleased()) {
          break label95;
        }
        this.mSurfaceTexture.release();
        this.mSurfaceTexture = null;
        AppMethodBeat.o(245583);
        return;
      }
    }
    finally
    {
      Log.e("MicroMsg.VideoPlayerTextureView", localObject.toString());
      AppMethodBeat.o(245583);
      return;
    }
    this.mSurfaceTexture.release();
    this.mSurfaceTexture = null;
    label95:
    AppMethodBeat.o(245583);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.sIB = paramBoolean;
    this.vZi.sIB = this.sIB;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.KSQ = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.ykm = paramBoolean;
    if (this.ykf != null) {
      this.ykf.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.lAj = paramBoolean;
    try
    {
      if (this.ykf != null)
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
        this.ykf.setMute(paramBoolean);
      }
      AppMethodBeat.o(134055);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(134055);
    }
  }
  
  public void setNeedOperateSurfaceTexture(boolean paramBoolean)
  {
    this.Yuo = paramBoolean;
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(134042);
    this.ykl = paramBoolean;
    if (this.ykf != null) {
      this.ykf.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(i.b paramb) {}
  
  public void setOnSeekCompleteCallback(i.c paramc)
  {
    this.Yun = paramc;
  }
  
  public void setOnSurfaceCallback(i.d paramd)
  {
    this.ykk = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(i.e parame)
  {
    this.Yum = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.ykh = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(com.tencent.mm.pluginsdk.ui.i.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.vZi.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.ykf != null) {
      this.ykn = paramBoolean;
    }
  }
  
  public void setVideoCallback(i.a parama)
  {
    this.yki = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    cxo();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.ykf != null) && (this.hS))
    {
      i = hashCode();
      boolean bool2 = this.sIL;
      boolean bool3 = this.sIK;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.sIK = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.sIL)
      {
        this.sIK = true;
        this.sIL = false;
        setMute(this.lAj);
        AppMethodBeat.o(134048);
        return true;
      }
      this.ykf.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.ykf == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.hS) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    if (this.ykf != null)
    {
      this.ykf.KTf = null;
      this.ykf.stop();
      this.ykf.release();
      this.ykf = null;
    }
    this.Yul = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.vZi.reset();
    this.hS = false;
    this.path = null;
    this.KSO = null;
    this.sIJ = 0L;
    AppMethodBeat.o(134050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */