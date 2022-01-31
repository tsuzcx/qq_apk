package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.plugin.n.k;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements e
{
  protected boolean Pz;
  protected long aNW;
  protected long aPF;
  protected boolean efg;
  protected FileDescriptor fd;
  protected e.a lxA;
  protected e.d lxD;
  protected boolean lxE;
  protected boolean lxF;
  protected boolean lxG;
  protected boolean lxH;
  protected boolean lxI;
  protected c lxK;
  protected i lxw;
  protected boolean lxx;
  protected long lxy;
  protected boolean lxz;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected b oEQ;
  protected String path;
  private TextureView.SurfaceTextureListener rBp;
  protected int wfB;
  protected boolean wfC;
  protected e.e wfD;
  private e.c wfE;
  protected r wfF;
  
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
    AppMethodBeat.i(117988);
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.wfB = 0;
    this.Pz = false;
    this.lxx = true;
    this.lxy = 0L;
    this.wfC = false;
    this.lxz = false;
    this.lxE = false;
    this.lxF = false;
    this.lxG = false;
    this.lxH = false;
    this.lxI = false;
    this.lxK = new VideoPlayerTextureView.1(this);
    this.rBp = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(117984);
        VideoPlayerTextureView.this.a(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(117984);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(117986);
        ab.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.h(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.lxH = false;
        VideoPlayerTextureView.this.lxI = false;
        if (VideoPlayerTextureView.this.lxw != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.lxH = true;
            VideoPlayerTextureView.this.lxw.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(117986);
          return false;
          VideoPlayerTextureView.this.lxH = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(117985);
        ab.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.dpH();
        AppMethodBeat.o(117985);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(117987);
        VideoPlayerTextureView.this.j(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(117987);
      }
    };
    this.wfF = new r();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.rBp);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(117988);
  }
  
  public void A(double paramDouble)
  {
    AppMethodBeat.i(117999);
    if (this.lxw != null) {
      this.lxw.zi((int)paramDouble);
    }
    AppMethodBeat.o(117999);
  }
  
  public final boolean Ds()
  {
    AppMethodBeat.i(146028);
    if (this.lxw != null)
    {
      i locali = this.lxw;
      if (locali.oFd != null)
      {
        boolean bool = com.tencent.mm.plugin.n.d.zb(locali.oFd.state);
        AppMethodBeat.o(146028);
        return bool;
      }
      AppMethodBeat.o(146028);
      return false;
    }
    AppMethodBeat.o(146028);
    return false;
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118004);
    ab.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lxH) });
    for (;;)
    {
      try
      {
        dEs();
        h(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.lxw == null) || (!this.Pz))
        {
          boV();
          dpH();
          if (this.lxD != null) {
            this.lxD.alr();
          }
          AppMethodBeat.o(118004);
          return;
        }
        this.lxw.f(this.mSurface);
        if (this.lxH)
        {
          this.lxw.start();
          this.lxH = false;
          continue;
        }
        this.lxI = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(118004);
        return;
      }
      this.lxy = 0L;
      this.lxw.setMute(true);
      this.lxw.start();
    }
  }
  
  public final void bQB()
  {
    AppMethodBeat.i(118003);
    if ((this.lxw != null) && (this.Pz) && (this.mSurface != null))
    {
      ab.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      i locali = this.lxw;
      if (locali.oFd != null) {
        locali.oFd.bQB();
      }
    }
    AppMethodBeat.o(118003);
  }
  
  protected void boV()
  {
    AppMethodBeat.i(118002);
    ab.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.lxw != null)
    {
      this.lxw.oFe = null;
      this.lxw.oFd.stop();
      this.lxw.release();
      this.lxw = null;
    }
    if (((bo.isNullOrNil(this.path)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      ab.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(118002);
      return;
    }
    for (;;)
    {
      try
      {
        this.Pz = false;
        this.lxw = new i(Looper.getMainLooper());
        if (!bo.isNullOrNil(this.path))
        {
          this.lxw.setPath(this.path);
          this.lxw.setIOnlineCache(this.oEQ);
          this.lxw.setNeedResetExtractor(this.lxE);
          this.lxw.setIsOnlineVideoType(this.lxF);
          this.lxw.oFe = this.lxK;
          this.lxw.setSurface(this.mSurface);
          this.lxw.jl(this.lxG);
          if (this.mSurface == null) {
            break;
          }
          this.lxw.prepare();
          AppMethodBeat.o(118002);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.lxA != null) {
          this.lxA.onError(-1, -1);
        }
        AppMethodBeat.o(118002);
        return;
      }
      if ((this.fd != null) && (this.fd.valid()))
      {
        i locali = this.lxw;
        FileDescriptor localFileDescriptor = this.fd;
        long l1 = this.aNW;
        long l2 = this.aPF;
        locali.oFd.oFm.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.lxz) {
      this.lxw.prepare();
    }
    AppMethodBeat.o(118002);
  }
  
  public final void dpG()
  {
    AppMethodBeat.i(117993);
    ab.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.lxw != null)
    {
      i locali = this.lxw;
      if (locali.oFd != null) {
        locali.oFd.bQA();
      }
    }
    AppMethodBeat.o(117993);
  }
  
  protected final void dpH()
  {
    AppMethodBeat.i(118006);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(118006);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(118000);
    this.lxx = paramBoolean;
    A(paramDouble);
    AppMethodBeat.o(118000);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(138351);
    if ((this.mSurface != null) && (this.mSurface.isValid())) {
      this.mSurface.release();
    }
    AppMethodBeat.o(138351);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(117998);
    if (this.lxw != null)
    {
      int i = this.lxw.bQz();
      AppMethodBeat.o(117998);
      return i;
    }
    AppMethodBeat.o(117998);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.lxw != null) {
      return (int)this.lxw.oFd.aNP;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.lxy;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  protected final void h(final Surface paramSurface)
  {
    AppMethodBeat.i(146029);
    com.tencent.mm.sdk.g.d.ysm.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146027);
        try
        {
          if ((paramSurface != null) && (paramSurface.isValid()))
          {
            ab.i("MicroMsg.VideoPlayerTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramSurface.hashCode()) });
            paramSurface.release();
          }
          AppMethodBeat.o(146027);
          return;
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "release Surface error", new Object[0]);
          AppMethodBeat.o(146027);
        }
      }
    });
    AppMethodBeat.o(146029);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(117991);
    if (this.lxw != null)
    {
      boolean bool = this.lxw.isPlaying();
      AppMethodBeat.o(117991);
      return bool;
    }
    AppMethodBeat.o(117991);
    return false;
  }
  
  protected void j(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(118005);
    if ((this.lxI) && (this.lxy > 0L) && (this.lxw != null))
    {
      this.lxw.pause();
      this.lxw.setMute(this.efg);
      this.lxI = false;
    }
    if ((this.lxy > 0L) && (this.wfD != null))
    {
      ab.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.wfD.bSk();
      this.wfD = null;
    }
    this.lxy = System.currentTimeMillis();
    AppMethodBeat.o(118005);
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118008);
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(118008);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.wfF.H(paramInt1, paramInt2, i, j);
    paramInt1 = this.wfF.iiY;
    paramInt2 = this.wfF.iiZ;
    if ((this.wfB == 90) || (this.wfB == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.wfB, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(118008);
  }
  
  public void pause()
  {
    AppMethodBeat.i(117997);
    if ((this.lxw != null) && (this.lxw.isPlaying())) {
      this.lxw.pause();
    }
    this.lxH = false;
    AppMethodBeat.o(117997);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.wfC = paramBoolean;
    this.wfF.wfC = this.wfC;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.oEQ = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(117990);
    this.lxF = paramBoolean;
    if (this.lxw != null) {
      this.lxw.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(117990);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(118001);
    this.efg = paramBoolean;
    if (this.lxw != null)
    {
      ab.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
      this.lxw.setMute(paramBoolean);
    }
    AppMethodBeat.o(118001);
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(117989);
    this.lxE = paramBoolean;
    if (this.lxw != null) {
      this.lxw.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(117989);
  }
  
  public void setOnInfoCallback(e.b paramb) {}
  
  public void setOnSeekCompleteCallback(e.c paramc)
  {
    this.wfE = paramc;
  }
  
  public void setOnSurfaceCallback(e.d paramd)
  {
    this.lxD = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(e.e parame)
  {
    this.wfD = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.lxz = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(118007);
    this.wfF.setScaleType(paramd);
    requestLayout();
    AppMethodBeat.o(118007);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.lxw != null) {
      this.lxG = paramBoolean;
    }
  }
  
  public void setVideoCallback(e.a parama)
  {
    this.lxA = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(117992);
    ab.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    boV();
    requestLayout();
    AppMethodBeat.o(117992);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(117994);
    if ((this.lxw != null) && (this.Pz))
    {
      i = hashCode();
      boolean bool2 = this.lxI;
      boolean bool3 = this.lxH;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ab.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.lxH = true;
        AppMethodBeat.o(117994);
        return true;
      }
      if (this.lxI)
      {
        this.lxH = true;
        this.lxI = false;
        setMute(this.efg);
        AppMethodBeat.o(117994);
        return true;
      }
      this.lxw.start();
      AppMethodBeat.o(117994);
      return true;
    }
    int i = hashCode();
    if (this.lxw == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.Pz) });
      AppMethodBeat.o(117994);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(117996);
    ab.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    if (this.lxw != null)
    {
      this.lxw.oFe = null;
      this.lxw.oFd.stop();
      this.lxw.release();
      this.lxw = null;
    }
    this.wfB = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.wfF.reset();
    this.Pz = false;
    this.path = null;
    this.fd = null;
    this.lxy = 0L;
    AppMethodBeat.o(117996);
  }
  
  public final boolean w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(117995);
    paramBoolean = start();
    AppMethodBeat.o(117995);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */