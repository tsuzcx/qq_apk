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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.o.b;
import com.tencent.mm.plugin.o.d;
import com.tencent.mm.plugin.o.e;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.plugin.o.k;
import com.tencent.mm.plugin.o.l;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements h
{
  protected int FDv;
  protected h.e FDw;
  private h.c FDx;
  protected boolean Zn;
  protected long buw;
  protected boolean fOX;
  protected FileDescriptor fd;
  protected long length;
  protected boolean lxh;
  protected long lxp;
  protected boolean lxq;
  protected boolean lxr;
  private TextureView.SurfaceTextureListener lxt;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected u ozo;
  protected String path;
  protected j qbo;
  protected boolean qbp;
  protected boolean qbq;
  protected h.a qbr;
  protected h.d qbt;
  protected boolean qbu;
  protected boolean qbv;
  protected boolean qbw;
  protected d qby;
  protected b vXD;
  
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
    this.FDv = 0;
    this.Zn = false;
    this.qbp = true;
    this.lxp = 0L;
    this.lxh = false;
    this.qbq = false;
    this.qbu = false;
    this.qbv = false;
    this.qbw = false;
    this.lxq = false;
    this.lxr = false;
    this.qby = new d()
    {
      public final void Z(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        ae.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.ozo.reset();
        VideoPlayerTextureView.this.FDv = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.bTA();
        if (VideoPlayerTextureView.this.qbr != null) {
          VideoPlayerTextureView.this.qbr.eb(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void clF()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).eX(VideoPlayerTextureView.this.qbp);
        }
        if (!VideoPlayerTextureView.this.qbp)
        {
          ae.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.qbp = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.qbo != null)
        {
          ae.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.qbo.info() });
          VideoPlayerTextureView.this.qbo.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.qbr != null) {
          VideoPlayerTextureView.this.qbr.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.qbr != null) {
          VideoPlayerTextureView.this.qbr.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(134030);
        ae.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.Zn = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.fOX);
        if (VideoPlayerTextureView.this.qbr != null) {
          VideoPlayerTextureView.this.qbr.ta();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
    };
    this.lxt = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134035);
        VideoPlayerTextureView.this.b(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(134035);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134037);
        ae.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.h(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.lxq = false;
        VideoPlayerTextureView.this.lxr = false;
        if (VideoPlayerTextureView.this.qbo != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.lxq = true;
            VideoPlayerTextureView.this.qbo.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.lxq = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        ae.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.bTA();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.k(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.ozo = new u();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.lxt);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134040);
  }
  
  public final boolean B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134049);
    paramBoolean = start();
    AppMethodBeat.o(134049);
    return paramBoolean;
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(134045);
    if (this.qbo != null)
    {
      j localj = this.qbo;
      if (localj.vXQ != null)
      {
        boolean bool = e.Ku(localj.vXQ.state);
        AppMethodBeat.o(134045);
        return bool;
      }
      AppMethodBeat.o(134045);
      return false;
    }
    AppMethodBeat.o(134045);
    return false;
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134058);
    ae.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lxq) });
    for (;;)
    {
      try
      {
        fDh();
        h(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.qbo == null) || (!this.Zn))
        {
          bpx();
          bTA();
          if (this.qbt != null) {
            this.qbt.aMV();
          }
          AppMethodBeat.o(134058);
          return;
        }
        this.qbo.i(this.mSurface);
        if (this.lxq)
        {
          this.qbo.start();
          this.lxq = false;
          continue;
        }
        this.lxr = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ae.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      this.lxp = 0L;
      this.qbo.setMute(true);
      this.qbo.start();
    }
  }
  
  protected void bTA()
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
  
  protected void bpx()
  {
    AppMethodBeat.i(134056);
    ae.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.qbo != null)
    {
      this.qbo.vXR = null;
      this.qbo.stop();
      this.qbo.release();
      this.qbo = null;
    }
    if (((bu.isNullOrNil(this.path)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      ae.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134056);
      return;
    }
    for (;;)
    {
      try
      {
        this.Zn = false;
        this.qbo = new j(Looper.getMainLooper());
        if (!bu.isNullOrNil(this.path))
        {
          this.qbo.setPath(this.path);
          this.qbo.setIOnlineCache(this.vXD);
          this.qbo.setNeedResetExtractor(this.qbu);
          this.qbo.setIsOnlineVideoType(this.qbv);
          this.qbo.vXR = this.qby;
          this.qbo.setSurface(this.mSurface);
          this.qbo.ov(this.qbw);
          if (this.mSurface == null) {
            break;
          }
          this.qbo.cSW();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.qbr != null) {
          this.qbr.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.fd != null) && (this.fd.valid()))
      {
        j localj = this.qbo;
        FileDescriptor localFileDescriptor = this.fd;
        long l1 = this.buw;
        long l2 = this.length;
        localj.vXQ.vXZ.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.qbq) {
      this.qbo.cSW();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void bpy()
  {
    AppMethodBeat.i(134057);
    if ((this.qbo != null) && (this.Zn) && (this.mSurface != null))
    {
      ae.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      j localj = this.qbo;
      if (localj.vXQ != null) {
        localj.vXQ.bpy();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134054);
    this.qbp = paramBoolean;
    p(paramDouble);
    AppMethodBeat.o(134054);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134041);
    if ((this.mSurface != null) && (this.mSurface.isValid())) {
      this.mSurface.release();
    }
    AppMethodBeat.o(134041);
  }
  
  public final boolean fjg()
  {
    if (this.mSurface == null) {}
    while (this.lxr) {
      return false;
    }
    return true;
  }
  
  public final void fjh()
  {
    AppMethodBeat.i(134047);
    ae.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.qbo != null)
    {
      j localj = this.qbo;
      if (localj.vXQ != null) {
        localj.vXQ.dpy();
      }
    }
    AppMethodBeat.o(134047);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134052);
    if (this.qbo != null)
    {
      int i = this.qbo.dpx();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.qbo != null) {
      return (int)this.qbo.vXQ.bup;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.lxp;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    com.tencent.e.h.MqF.aO(new VideoPlayerTextureView.3(this, paramSurface));
    AppMethodBeat.o(134060);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.qbo != null)
    {
      boolean bool = this.qbo.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.lxr) && (this.lxp > 0L) && (this.qbo != null))
    {
      this.qbo.pause();
      this.qbo.setMute(this.fOX);
      this.lxr = false;
    }
    if ((this.lxp > 0L) && (this.FDw != null))
    {
      ae.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.FDw.bpD();
      this.FDw = null;
    }
    this.lxp = System.currentTimeMillis();
    AppMethodBeat.o(134059);
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134063);
    ae.d("MicroMsg.VideoPlayerTextureView", "onMeasure video size[%d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight), Integer.valueOf(getDefaultSize(1, paramInt1)), Integer.valueOf(getDefaultSize(1, paramInt2)) });
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
    this.ozo.y(paramInt1, paramInt2, i, j);
    paramInt1 = this.ozo.lyb;
    paramInt2 = this.ozo.lyc;
    if ((this.FDv == 90) || (this.FDv == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.FDv, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void p(double paramDouble)
  {
    AppMethodBeat.i(134053);
    if (this.qbo != null) {
      this.qbo.KB((int)paramDouble);
    }
    AppMethodBeat.o(134053);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.qbo != null) && (this.qbo.isPlaying())) {
      this.qbo.pause();
    }
    this.lxq = false;
    AppMethodBeat.o(134051);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.lxh = paramBoolean;
    this.ozo.lxh = this.lxh;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.vXD = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.qbv = paramBoolean;
    if (this.qbo != null) {
      this.qbo.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.fOX = paramBoolean;
    try
    {
      if (this.qbo != null)
      {
        ae.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
        this.qbo.setMute(paramBoolean);
      }
      AppMethodBeat.o(134055);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(134055);
    }
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(134042);
    this.qbu = paramBoolean;
    if (this.qbo != null) {
      this.qbo.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.FDx = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.qbt = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.FDw = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.qbq = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.ozo.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.qbo != null) {
      this.qbw = paramBoolean;
    }
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.qbr = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    ae.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    bpx();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.qbo != null) && (this.Zn))
    {
      i = hashCode();
      boolean bool2 = this.lxr;
      boolean bool3 = this.lxq;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ae.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.lxq = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.lxr)
      {
        this.lxq = true;
        this.lxr = false;
        setMute(this.fOX);
        AppMethodBeat.o(134048);
        return true;
      }
      this.qbo.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.qbo == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.Zn) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    ae.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    if (this.qbo != null)
    {
      this.qbo.vXR = null;
      this.qbo.stop();
      this.qbo.release();
      this.qbo = null;
    }
    this.FDv = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.ozo.reset();
    this.Zn = false;
    this.path = null;
    this.fd = null;
    this.lxp = 0L;
    AppMethodBeat.o(134050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */