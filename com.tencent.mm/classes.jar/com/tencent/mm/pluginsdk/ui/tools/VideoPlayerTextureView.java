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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.u.b;
import com.tencent.mm.plugin.u.d;
import com.tencent.mm.plugin.u.e;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.plugin.u.l;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements k
{
  protected FileDescriptor EXc;
  protected b EXe;
  protected int RxQ;
  protected k.e RxR;
  private k.c RxS;
  protected long aFL;
  protected long bdS;
  protected boolean gX;
  protected boolean iYs;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  private TextureView.SurfaceTextureListener pDB;
  protected boolean pDp;
  protected long pDx;
  protected boolean pDy;
  protected boolean pDz;
  protected String path;
  protected y sTV;
  protected j uXR;
  protected boolean uXS;
  protected boolean uXT;
  protected k.a uXU;
  protected k.d uXW;
  protected boolean uXX;
  protected boolean uXY;
  protected boolean uXZ;
  protected d uYb;
  
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
    this.RxQ = 0;
    this.gX = false;
    this.uXS = true;
    this.pDx = 0L;
    this.pDp = false;
    this.uXT = false;
    this.uXX = false;
    this.uXY = false;
    this.uXZ = false;
    this.pDy = false;
    this.pDz = false;
    this.uYb = new d()
    {
      public final void ab(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        Log.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.sTV.reset();
        VideoPlayerTextureView.this.RxQ = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.cEw();
        if (VideoPlayerTextureView.this.uXU != null) {
          VideoPlayerTextureView.this.uXU.eM(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void cYp()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).gz(VideoPlayerTextureView.this.uXS);
        }
        if (!VideoPlayerTextureView.this.uXS)
        {
          Log.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.uXS = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.uXR != null)
        {
          Log.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.uXR.info() });
          VideoPlayerTextureView.this.uXR.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.uXU != null) {
          VideoPlayerTextureView.this.uXU.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.uXU != null) {
          VideoPlayerTextureView.this.uXU.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
      
      public final void qX()
      {
        AppMethodBeat.i(134030);
        Log.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.gX = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.iYs);
        if (VideoPlayerTextureView.this.uXU != null) {
          VideoPlayerTextureView.this.uXU.qX();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
    };
    this.pDB = new TextureView.SurfaceTextureListener()
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
        VideoPlayerTextureView.this.j(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.pDy = false;
        VideoPlayerTextureView.this.pDz = false;
        if (VideoPlayerTextureView.this.uXR != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.pDy = true;
            VideoPlayerTextureView.this.uXR.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.pDy = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        Log.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.cEw();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.o(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.sTV = new y();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.pDB);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134040);
  }
  
  public final boolean I(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134049);
    paramBoolean = start();
    AppMethodBeat.o(134049);
    return paramBoolean;
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(134045);
    if (this.uXR != null)
    {
      j localj = this.uXR;
      if (localj.EXt != null)
      {
        boolean bool = e.WI(localj.EXt.state);
        AppMethodBeat.o(134045);
        return bool;
      }
      AppMethodBeat.o(134045);
      return false;
    }
    AppMethodBeat.o(134045);
    return false;
  }
  
  public final void b(double paramDouble, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(134054);
    int i = hashCode();
    if (this.uXR == null) {}
    for (;;)
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d seekTo:%f  play is null?[%b", new Object[] { Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(bool) });
      this.uXS = paramBoolean;
      if (this.uXR != null) {
        this.uXR.WQ((int)paramDouble);
      }
      AppMethodBeat.o(134054);
      return;
      bool = false;
    }
  }
  
  protected void bXd()
  {
    AppMethodBeat.i(134056);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.uXR != null)
    {
      this.uXR.EXu = null;
      this.uXR.stop();
      this.uXR.release();
      this.uXR = null;
    }
    if (((Util.isNullOrNil(this.path)) && ((this.EXc == null) || (!this.EXc.valid()))) || (this.mSurface == null))
    {
      Log.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134056);
      return;
    }
    for (;;)
    {
      try
      {
        this.gX = false;
        this.uXR = new j(Looper.getMainLooper());
        if (!Util.isNullOrNil(this.path))
        {
          this.uXR.setPath(this.path);
          this.uXR.setIOnlineCache(this.EXe);
          this.uXR.setNeedResetExtractor(this.uXX);
          this.uXR.setIsOnlineVideoType(this.uXY);
          this.uXR.EXu = this.uYb;
          this.uXR.setSurface(this.mSurface);
          this.uXR.ud(this.uXZ);
          if (this.mSurface == null) {
            break;
          }
          this.uXR.prepare();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.uXU != null) {
          this.uXU.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.EXc != null) && (this.EXc.valid()))
      {
        j localj = this.uXR;
        FileDescriptor localFileDescriptor = this.EXc;
        long l1 = this.bdS;
        long l2 = this.aFL;
        localj.EXt.EXC.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.uXT) {
      this.uXR.prepare();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void bXe()
  {
    AppMethodBeat.i(134057);
    if ((this.uXR != null) && (this.gX) && (this.mSurface != null))
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      j localj = this.uXR;
      if (localj.EXt != null) {
        localj.EXt.bXe();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  protected void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134058);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.pDy) });
    for (;;)
    {
      try
      {
        hKg();
        j(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.uXR == null) || (!this.gX))
        {
          bXd();
          cEw();
          if (this.uXW != null) {
            this.uXW.bqp();
          }
          AppMethodBeat.o(134058);
          return;
        }
        this.uXR.m(this.mSurface);
        if (this.pDy)
        {
          this.uXR.start();
          this.pDy = false;
          continue;
        }
        this.pDz = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      this.pDx = 0L;
      this.uXR.setMute(true);
      this.uXR.start();
    }
  }
  
  protected void cEw()
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
    if (this.uXR != null)
    {
      int i = this.uXR.eST();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.uXR != null) {
      return (int)this.uXR.EXt.durationMs;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.pDx;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  public final boolean hnO()
  {
    if (this.mSurface == null) {}
    while (this.pDz) {
      return false;
    }
    return true;
  }
  
  public final void hnP()
  {
    AppMethodBeat.i(134047);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.uXR != null)
    {
      j localj = this.uXR;
      if (localj.EXt != null) {
        localj.EXt.eSU();
      }
    }
    AppMethodBeat.o(134047);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.uXR != null)
    {
      boolean bool = this.uXR.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected final void j(final Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134039);
        try
        {
          if ((paramSurface != null) && (paramSurface.isValid()))
          {
            Log.i("MicroMsg.VideoPlayerTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramSurface.hashCode()) });
            paramSurface.release();
          }
          AppMethodBeat.o(134039);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "release Surface error", new Object[0]);
          AppMethodBeat.o(134039);
        }
      }
    });
    AppMethodBeat.o(134060);
  }
  
  protected void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.pDz) && (this.pDx > 0L) && (this.uXR != null))
    {
      this.uXR.pause();
      this.uXR.setMute(this.iYs);
      this.pDz = false;
    }
    if ((this.pDx > 0L) && (this.RxR != null))
    {
      Log.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.RxR.bXh();
      this.RxR = null;
    }
    this.pDx = System.currentTimeMillis();
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
    this.sTV.A(paramInt1, paramInt2, i, j);
    paramInt1 = this.sTV.pEl;
    paramInt2 = this.sTV.pEm;
    if ((this.RxQ == 90) || (this.RxQ == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.RxQ, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.uXR != null) && (this.uXR.isPlaying())) {
      this.uXR.pause();
    }
    this.pDy = false;
    this.uXS = false;
    AppMethodBeat.o(134051);
  }
  
  public void q(double paramDouble)
  {
    AppMethodBeat.i(134053);
    b(paramDouble, true);
    AppMethodBeat.o(134053);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.pDp = paramBoolean;
    this.sTV.pDp = this.pDp;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.EXe = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.uXY = paramBoolean;
    if (this.uXR != null) {
      this.uXR.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.iYs = paramBoolean;
    try
    {
      if (this.uXR != null)
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
        this.uXR.setMute(paramBoolean);
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
    this.uXX = paramBoolean;
    if (this.uXR != null) {
      this.uXR.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(k.b paramb) {}
  
  public void setOnSeekCompleteCallback(k.c paramc)
  {
    this.RxS = paramc;
  }
  
  public void setOnSurfaceCallback(k.d paramd)
  {
    this.uXW = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(k.e parame)
  {
    this.RxR = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.uXT = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.sTV.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.uXR != null) {
      this.uXZ = paramBoolean;
    }
  }
  
  public void setVideoCallback(k.a parama)
  {
    this.uXU = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    bXd();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.uXR != null) && (this.gX))
    {
      i = hashCode();
      boolean bool2 = this.pDz;
      boolean bool3 = this.pDy;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.pDy = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.pDz)
      {
        this.pDy = true;
        this.pDz = false;
        setMute(this.iYs);
        AppMethodBeat.o(134048);
        return true;
      }
      this.uXR.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.uXR == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.gX) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    Log.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    if (this.uXR != null)
    {
      this.uXR.EXu = null;
      this.uXR.stop();
      this.uXR.release();
      this.uXR = null;
    }
    this.RxQ = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.sTV.reset();
    this.gX = false;
    this.path = null;
    this.EXc = null;
    this.pDx = 0L;
    AppMethodBeat.o(134050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */