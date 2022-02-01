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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements h
{
  protected int DFS;
  protected h.e DFT;
  private h.c DFU;
  protected boolean Xy;
  protected long bkb;
  protected FileDescriptor fd;
  protected boolean ftN;
  protected boolean kVJ;
  protected long kVR;
  protected boolean kVS;
  protected boolean kVT;
  private TextureView.SurfaceTextureListener kVV;
  protected long length;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected u nQg;
  protected String path;
  protected j prd;
  protected boolean pre;
  protected boolean prf;
  protected h.a prg;
  protected h.d pri;
  protected boolean prj;
  protected boolean prk;
  protected boolean prl;
  protected d prn;
  protected b uIt;
  
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
    this.DFS = 0;
    this.Xy = false;
    this.pre = true;
    this.kVR = 0L;
    this.kVJ = false;
    this.prf = false;
    this.prj = false;
    this.prk = false;
    this.prl = false;
    this.kVS = false;
    this.kVT = false;
    this.prn = new d()
    {
      public final void X(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        ac.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.nQg.reset();
        VideoPlayerTextureView.this.DFS = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.bNN();
        if (VideoPlayerTextureView.this.prg != null) {
          VideoPlayerTextureView.this.prg.dZ(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void cfM()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).eS(VideoPlayerTextureView.this.pre);
        }
        if (!VideoPlayerTextureView.this.pre)
        {
          ac.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.pre = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.prd != null)
        {
          ac.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.prd.info() });
          VideoPlayerTextureView.this.prd.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.prg != null) {
          VideoPlayerTextureView.this.prg.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.prg != null) {
          VideoPlayerTextureView.this.prg.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
      
      public final void rB()
      {
        AppMethodBeat.i(134030);
        ac.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.Xy = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.ftN);
        if (VideoPlayerTextureView.this.prg != null) {
          VideoPlayerTextureView.this.prg.rB();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
    };
    this.kVV = new TextureView.SurfaceTextureListener()
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
        ac.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.h(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.kVS = false;
        VideoPlayerTextureView.this.kVT = false;
        if (VideoPlayerTextureView.this.prd != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.kVS = true;
            VideoPlayerTextureView.this.prd.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.kVS = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        ac.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.bNN();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.k(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.nQg = new u();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.kVV);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134040);
  }
  
  public final boolean MZ()
  {
    AppMethodBeat.i(134045);
    if (this.prd != null)
    {
      j localj = this.prd;
      if (localj.uIG != null)
      {
        boolean bool = e.Ix(localj.uIG.state);
        AppMethodBeat.o(134045);
        return bool;
      }
      AppMethodBeat.o(134045);
      return false;
    }
    AppMethodBeat.o(134045);
    return false;
  }
  
  protected void bNN()
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
  
  protected void blc()
  {
    AppMethodBeat.i(134056);
    ac.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.prd != null)
    {
      this.prd.uIH = null;
      this.prd.stop();
      this.prd.release();
      this.prd = null;
    }
    if (((bs.isNullOrNil(this.path)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      ac.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134056);
      return;
    }
    for (;;)
    {
      try
      {
        this.Xy = false;
        this.prd = new j(Looper.getMainLooper());
        if (!bs.isNullOrNil(this.path))
        {
          this.prd.setPath(this.path);
          this.prd.setIOnlineCache(this.uIt);
          this.prd.setNeedResetExtractor(this.prj);
          this.prd.setIsOnlineVideoType(this.prk);
          this.prd.uIH = this.prn;
          this.prd.setSurface(this.mSurface);
          this.prd.nW(this.prl);
          if (this.mSurface == null) {
            break;
          }
          this.prd.cIc();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.prg != null) {
          this.prg.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.fd != null) && (this.fd.valid()))
      {
        j localj = this.prd;
        FileDescriptor localFileDescriptor = this.fd;
        long l1 = this.bkb;
        long l2 = this.length;
        localj.uIG.uIP.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.prf) {
      this.prd.cIc();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void bld()
  {
    AppMethodBeat.i(134057);
    if ((this.prd != null) && (this.Xy) && (this.mSurface != null))
    {
      ac.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      j localj = this.prd;
      if (localj.uIG != null) {
        localj.uIG.bld();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  protected void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134058);
    ac.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kVS) });
    for (;;)
    {
      try
      {
        fiQ();
        h(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.prd == null) || (!this.Xy))
        {
          blc();
          bNN();
          if (this.pri != null) {
            this.pri.aJn();
          }
          AppMethodBeat.o(134058);
          return;
        }
        this.prd.i(this.mSurface);
        if (this.kVS)
        {
          this.prd.start();
          this.kVS = false;
          continue;
        }
        this.kVT = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ac.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      this.kVR = 0L;
      this.prd.setMute(true);
      this.prd.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134054);
    this.pre = paramBoolean;
    p(paramDouble);
    AppMethodBeat.o(134054);
  }
  
  public final boolean eQo()
  {
    if (this.mSurface == null) {}
    while (this.kVT) {
      return false;
    }
    return true;
  }
  
  public final void eQp()
  {
    AppMethodBeat.i(134047);
    ac.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.prd != null)
    {
      j localj = this.prd;
      if (localj.uIG != null) {
        localj.uIG.dde();
      }
    }
    AppMethodBeat.o(134047);
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
    if (this.prd != null)
    {
      int i = this.prd.ddd();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.prd != null) {
      return (int)this.prd.uIG.bjU;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.kVR;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  protected final void h(final Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134039);
        try
        {
          if ((paramSurface != null) && (paramSurface.isValid()))
          {
            ac.i("MicroMsg.VideoPlayerTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramSurface.hashCode()) });
            paramSurface.release();
          }
          AppMethodBeat.o(134039);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "release Surface error", new Object[0]);
          AppMethodBeat.o(134039);
        }
      }
    });
    AppMethodBeat.o(134060);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.prd != null)
    {
      boolean bool = this.prd.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.kVT) && (this.kVR > 0L) && (this.prd != null))
    {
      this.prd.pause();
      this.prd.setMute(this.ftN);
      this.kVT = false;
    }
    if ((this.kVR > 0L) && (this.DFT != null))
    {
      ac.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.DFT.bli();
      this.DFT = null;
    }
    this.kVR = System.currentTimeMillis();
    AppMethodBeat.o(134059);
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134063);
    ac.d("MicroMsg.VideoPlayerTextureView", "onMeasure video size[%d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight), Integer.valueOf(getDefaultSize(1, paramInt1)), Integer.valueOf(getDefaultSize(1, paramInt2)) });
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
    this.nQg.x(paramInt1, paramInt2, i, j);
    paramInt1 = this.nQg.kWD;
    paramInt2 = this.nQg.kWE;
    if ((this.DFS == 90) || (this.DFS == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.DFS, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void p(double paramDouble)
  {
    AppMethodBeat.i(134053);
    if (this.prd != null) {
      this.prd.IE((int)paramDouble);
    }
    AppMethodBeat.o(134053);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.prd != null) && (this.prd.isPlaying())) {
      this.prd.pause();
    }
    this.kVS = false;
    AppMethodBeat.o(134051);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.kVJ = paramBoolean;
    this.nQg.kVJ = this.kVJ;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.uIt = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.prk = paramBoolean;
    if (this.prd != null) {
      this.prd.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.ftN = paramBoolean;
    if (this.prd != null)
    {
      ac.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
      this.prd.setMute(paramBoolean);
    }
    AppMethodBeat.o(134055);
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(134042);
    this.prj = paramBoolean;
    if (this.prd != null) {
      this.prd.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.DFU = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.pri = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.DFT = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.prf = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.nQg.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.prd != null) {
      this.prl = paramBoolean;
    }
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.prg = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    ac.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    blc();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.prd != null) && (this.Xy))
    {
      i = hashCode();
      boolean bool2 = this.kVT;
      boolean bool3 = this.kVS;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ac.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.kVS = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.kVT)
      {
        this.kVS = true;
        this.kVT = false;
        setMute(this.ftN);
        AppMethodBeat.o(134048);
        return true;
      }
      this.prd.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.prd == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.Xy) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    ac.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    if (this.prd != null)
    {
      this.prd.uIH = null;
      this.prd.stop();
      this.prd.release();
      this.prd = null;
    }
    this.DFS = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.nQg.reset();
    this.Xy = false;
    this.path = null;
    this.fd = null;
    this.kVR = 0L;
    AppMethodBeat.o(134050);
  }
  
  public final boolean z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134049);
    paramBoolean = start();
    AppMethodBeat.o(134049);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */