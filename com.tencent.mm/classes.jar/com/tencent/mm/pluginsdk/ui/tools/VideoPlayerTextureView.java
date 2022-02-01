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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.n.d;
import com.tencent.mm.plugin.n.e;
import com.tencent.mm.plugin.n.k;
import com.tencent.mm.plugin.n.l;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements j
{
  protected j.e KwA;
  private j.c KwB;
  protected int Kwz;
  protected boolean ZA;
  protected long buq;
  protected FileDescriptor fd;
  protected boolean guh;
  protected long length;
  protected boolean mEe;
  protected long mEm;
  protected boolean mEn;
  protected boolean mEo;
  private TextureView.SurfaceTextureListener mEq;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected w pMX;
  protected String path;
  protected com.tencent.mm.plugin.n.j rsl;
  protected boolean rsm;
  protected boolean rsn;
  protected j.a rso;
  protected j.d rsq;
  protected boolean rsr;
  protected boolean rss;
  protected boolean rst;
  protected d rsv;
  protected b zrF;
  
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
    this.Kwz = 0;
    this.ZA = false;
    this.rsm = true;
    this.mEm = 0L;
    this.mEe = false;
    this.rsn = false;
    this.rsr = false;
    this.rss = false;
    this.rst = false;
    this.mEn = false;
    this.mEo = false;
    this.rsv = new d()
    {
      public final void aa(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        Log.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.pMX.reset();
        VideoPlayerTextureView.this.Kwz = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.crn();
        if (VideoPlayerTextureView.this.rso != null) {
          VideoPlayerTextureView.this.rso.eo(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void cJH()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).fN(VideoPlayerTextureView.this.rsm);
        }
        if (!VideoPlayerTextureView.this.rsm)
        {
          Log.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.rsm = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.rsl != null)
        {
          Log.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.rsl.info() });
          VideoPlayerTextureView.this.rsl.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.rso != null) {
          VideoPlayerTextureView.this.rso.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.rso != null) {
          VideoPlayerTextureView.this.rso.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
      
      public final void tf()
      {
        AppMethodBeat.i(134030);
        Log.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.ZA = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.guh);
        if (VideoPlayerTextureView.this.rso != null) {
          VideoPlayerTextureView.this.rso.tf();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
    };
    this.mEq = new TextureView.SurfaceTextureListener()
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
        Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.h(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.mEn = false;
        VideoPlayerTextureView.this.mEo = false;
        if (VideoPlayerTextureView.this.rsl != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.mEn = true;
            VideoPlayerTextureView.this.rsl.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.mEn = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        Log.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.crn();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.l(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.pMX = new w();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.mEq);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134040);
  }
  
  public final boolean E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134049);
    paramBoolean = start();
    AppMethodBeat.o(134049);
    return paramBoolean;
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(134045);
    if (this.rsl != null)
    {
      com.tencent.mm.plugin.n.j localj = this.rsl;
      if (localj.zrS != null)
      {
        boolean bool = e.Qv(localj.zrS.state);
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
    Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mEn) });
    for (;;)
    {
      try
      {
        gLi();
        h(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.rsl == null) || (!this.ZA))
        {
          bLd();
          crn();
          if (this.rsq != null) {
            this.rsq.bgX();
          }
          AppMethodBeat.o(134058);
          return;
        }
        this.rsl.i(this.mSurface);
        if (this.mEn)
        {
          this.rsl.start();
          this.mEn = false;
          continue;
        }
        this.mEo = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      this.mEm = 0L;
      this.rsl.setMute(true);
      this.rsl.start();
    }
  }
  
  protected void bLd()
  {
    AppMethodBeat.i(134056);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.rsl != null)
    {
      this.rsl.zrT = null;
      this.rsl.stop();
      this.rsl.release();
      this.rsl = null;
    }
    if (((Util.isNullOrNil(this.path)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      Log.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134056);
      return;
    }
    for (;;)
    {
      try
      {
        this.ZA = false;
        this.rsl = new com.tencent.mm.plugin.n.j(Looper.getMainLooper());
        if (!Util.isNullOrNil(this.path))
        {
          this.rsl.setPath(this.path);
          this.rsl.setIOnlineCache(this.zrF);
          this.rsl.setNeedResetExtractor(this.rsr);
          this.rsl.setIsOnlineVideoType(this.rss);
          this.rsl.zrT = this.rsv;
          this.rsl.setSurface(this.mSurface);
          this.rsl.ra(this.rst);
          if (this.mSurface == null) {
            break;
          }
          this.rsl.prepare();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.rso != null) {
          this.rso.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.fd != null) && (this.fd.valid()))
      {
        com.tencent.mm.plugin.n.j localj = this.rsl;
        FileDescriptor localFileDescriptor = this.fd;
        long l1 = this.buq;
        long l2 = this.length;
        localj.zrS.zsb.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.rsn) {
      this.rsl.prepare();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void bLe()
  {
    AppMethodBeat.i(134057);
    if ((this.rsl != null) && (this.ZA) && (this.mSurface != null))
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      com.tencent.mm.plugin.n.j localj = this.rsl;
      if (localj.zrS != null) {
        localj.zrS.bLe();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  protected void crn()
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
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134054);
    this.rsm = paramBoolean;
    q(paramDouble);
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
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134052);
    if (this.rsl != null)
    {
      int i = this.rsl.ejm();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.rsl != null) {
      return (int)this.rsl.zrS.durationMs;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.mEm;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  public final boolean gsG()
  {
    if (this.mSurface == null) {}
    while (this.mEo) {
      return false;
    }
    return true;
  }
  
  public final void gsH()
  {
    AppMethodBeat.i(134047);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.rsl != null)
    {
      com.tencent.mm.plugin.n.j localj = this.rsl;
      if (localj.zrS != null) {
        localj.zrS.ejn();
      }
    }
    AppMethodBeat.o(134047);
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    h.RTc.aX(new VideoPlayerTextureView.3(this, paramSurface));
    AppMethodBeat.o(134060);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.rsl != null)
    {
      boolean bool = this.rsl.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected void l(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.mEo) && (this.mEm > 0L) && (this.rsl != null))
    {
      this.rsl.pause();
      this.rsl.setMute(this.guh);
      this.mEo = false;
    }
    if ((this.mEm > 0L) && (this.KwA != null))
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.KwA.bLh();
      this.KwA = null;
    }
    this.mEm = System.currentTimeMillis();
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
    this.pMX.y(paramInt1, paramInt2, i, j);
    paramInt1 = this.pMX.mEZ;
    paramInt2 = this.pMX.mFa;
    if ((this.Kwz == 90) || (this.Kwz == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.Kwz, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.rsl != null) && (this.rsl.isPlaying())) {
      this.rsl.pause();
    }
    this.mEn = false;
    AppMethodBeat.o(134051);
  }
  
  public void q(double paramDouble)
  {
    AppMethodBeat.i(134053);
    if (this.rsl != null) {
      this.rsl.QC((int)paramDouble);
    }
    AppMethodBeat.o(134053);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.mEe = paramBoolean;
    this.pMX.mEe = this.mEe;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.zrF = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.rss = paramBoolean;
    if (this.rsl != null) {
      this.rsl.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.guh = paramBoolean;
    try
    {
      if (this.rsl != null)
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
        this.rsl.setMute(paramBoolean);
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
    this.rsr = paramBoolean;
    if (this.rsl != null) {
      this.rsl.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(j.b paramb) {}
  
  public void setOnSeekCompleteCallback(j.c paramc)
  {
    this.KwB = paramc;
  }
  
  public void setOnSurfaceCallback(j.d paramd)
  {
    this.rsq = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(j.e parame)
  {
    this.KwA = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.rsn = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.pMX.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.rsl != null) {
      this.rst = paramBoolean;
    }
  }
  
  public void setVideoCallback(j.a parama)
  {
    this.rso = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    bLd();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.rsl != null) && (this.ZA))
    {
      i = hashCode();
      boolean bool2 = this.mEo;
      boolean bool3 = this.mEn;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.mEn = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.mEo)
      {
        this.mEn = true;
        this.mEo = false;
        setMute(this.guh);
        AppMethodBeat.o(134048);
        return true;
      }
      this.rsl.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.rsl == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.ZA) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    if (this.rsl != null)
    {
      this.rsl.zrT = null;
      this.rsl.stop();
      this.rsl.release();
      this.rsl = null;
    }
    this.Kwz = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.pMX.reset();
    this.ZA = false;
    this.path = null;
    this.fd = null;
    this.mEm = 0L;
    AppMethodBeat.o(134050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */