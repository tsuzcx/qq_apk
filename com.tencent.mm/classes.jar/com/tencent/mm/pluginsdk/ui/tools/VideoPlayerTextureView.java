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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements h
{
  protected int FkX;
  protected h.e FkY;
  private h.c FkZ;
  protected boolean Zn;
  protected long buw;
  protected boolean fMP;
  protected FileDescriptor fd;
  protected long length;
  protected boolean lsI;
  protected long lsQ;
  protected boolean lsR;
  protected boolean lsS;
  private TextureView.SurfaceTextureListener lsU;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected u osN;
  protected j pUJ;
  protected boolean pUK;
  protected boolean pUL;
  protected h.a pUM;
  protected h.d pUO;
  protected boolean pUP;
  protected boolean pUQ;
  protected boolean pUR;
  protected d pUT;
  protected String path;
  protected b vLz;
  
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
    this.FkX = 0;
    this.Zn = false;
    this.pUK = true;
    this.lsQ = 0L;
    this.lsI = false;
    this.pUL = false;
    this.pUP = false;
    this.pUQ = false;
    this.pUR = false;
    this.lsR = false;
    this.lsS = false;
    this.pUT = new d()
    {
      public final void Z(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        ad.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.osN.reset();
        VideoPlayerTextureView.this.FkX = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.bSn();
        if (VideoPlayerTextureView.this.pUM != null) {
          VideoPlayerTextureView.this.pUM.eb(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void ckp()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).eU(VideoPlayerTextureView.this.pUK);
        }
        if (!VideoPlayerTextureView.this.pUK)
        {
          ad.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.pUK = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.pUJ != null)
        {
          ad.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.pUJ.info() });
          VideoPlayerTextureView.this.pUJ.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.pUM != null) {
          VideoPlayerTextureView.this.pUM.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.pUM != null) {
          VideoPlayerTextureView.this.pUM.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(134030);
        ad.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.Zn = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.fMP);
        if (VideoPlayerTextureView.this.pUM != null) {
          VideoPlayerTextureView.this.pUM.ta();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
    };
    this.lsU = new TextureView.SurfaceTextureListener()
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
        ad.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.h(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.lsR = false;
        VideoPlayerTextureView.this.lsS = false;
        if (VideoPlayerTextureView.this.pUJ != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.lsR = true;
            VideoPlayerTextureView.this.pUJ.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.lsR = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        ad.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.bSn();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.k(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.osN = new u();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.lsU);
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
  
  public final boolean OI()
  {
    AppMethodBeat.i(134045);
    if (this.pUJ != null)
    {
      j localj = this.pUJ;
      if (localj.vLM != null)
      {
        boolean bool = e.JU(localj.vLM.state);
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
    ad.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lsR) });
    for (;;)
    {
      try
      {
        fzf();
        h(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.pUJ == null) || (!this.Zn))
        {
          boN();
          bSn();
          if (this.pUO != null) {
            this.pUO.aMx();
          }
          AppMethodBeat.o(134058);
          return;
        }
        this.pUJ.i(this.mSurface);
        if (this.lsR)
        {
          this.pUJ.start();
          this.lsR = false;
          continue;
        }
        this.lsS = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      this.lsQ = 0L;
      this.pUJ.setMute(true);
      this.pUJ.start();
    }
  }
  
  protected void bSn()
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
  
  protected void boN()
  {
    AppMethodBeat.i(134056);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.pUJ != null)
    {
      this.pUJ.vLN = null;
      this.pUJ.stop();
      this.pUJ.release();
      this.pUJ = null;
    }
    if (((bt.isNullOrNil(this.path)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      ad.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134056);
      return;
    }
    for (;;)
    {
      try
      {
        this.Zn = false;
        this.pUJ = new j(Looper.getMainLooper());
        if (!bt.isNullOrNil(this.path))
        {
          this.pUJ.setPath(this.path);
          this.pUJ.setIOnlineCache(this.vLz);
          this.pUJ.setNeedResetExtractor(this.pUP);
          this.pUJ.setIsOnlineVideoType(this.pUQ);
          this.pUJ.vLN = this.pUT;
          this.pUJ.setSurface(this.mSurface);
          this.pUJ.oq(this.pUR);
          if (this.mSurface == null) {
            break;
          }
          this.pUJ.cQr();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.pUM != null) {
          this.pUM.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.fd != null) && (this.fd.valid()))
      {
        j localj = this.pUJ;
        FileDescriptor localFileDescriptor = this.fd;
        long l1 = this.buw;
        long l2 = this.length;
        localj.vLM.vLV.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.pUL) {
      this.pUJ.cQr();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void boO()
  {
    AppMethodBeat.i(134057);
    if ((this.pUJ != null) && (this.Zn) && (this.mSurface != null))
    {
      ad.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      j localj = this.pUJ;
      if (localj.vLM != null) {
        localj.vLM.boO();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134054);
    this.pUK = paramBoolean;
    p(paramDouble);
    AppMethodBeat.o(134054);
  }
  
  public final boolean ffq()
  {
    if (this.mSurface == null) {}
    while (this.lsS) {
      return false;
    }
    return true;
  }
  
  public final void ffr()
  {
    AppMethodBeat.i(134047);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pUJ != null)
    {
      j localj = this.pUJ;
      if (localj.vLM != null) {
        localj.vLM.dmA();
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
    if (this.pUJ != null)
    {
      int i = this.pUJ.dmz();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.pUJ != null) {
      return (int)this.pUJ.vLM.bup;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.lsQ;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    com.tencent.e.h.LTJ.aR(new VideoPlayerTextureView.3(this, paramSurface));
    AppMethodBeat.o(134060);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.pUJ != null)
    {
      boolean bool = this.pUJ.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.lsS) && (this.lsQ > 0L) && (this.pUJ != null))
    {
      this.pUJ.pause();
      this.pUJ.setMute(this.fMP);
      this.lsS = false;
    }
    if ((this.lsQ > 0L) && (this.FkY != null))
    {
      ad.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.FkY.boT();
      this.FkY = null;
    }
    this.lsQ = System.currentTimeMillis();
    AppMethodBeat.o(134059);
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134063);
    ad.d("MicroMsg.VideoPlayerTextureView", "onMeasure video size[%d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight), Integer.valueOf(getDefaultSize(1, paramInt1)), Integer.valueOf(getDefaultSize(1, paramInt2)) });
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
    this.osN.y(paramInt1, paramInt2, i, j);
    paramInt1 = this.osN.ltC;
    paramInt2 = this.osN.ltD;
    if ((this.FkX == 90) || (this.FkX == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.FkX, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void p(double paramDouble)
  {
    AppMethodBeat.i(134053);
    if (this.pUJ != null) {
      this.pUJ.Kb((int)paramDouble);
    }
    AppMethodBeat.o(134053);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.pUJ != null) && (this.pUJ.isPlaying())) {
      this.pUJ.pause();
    }
    this.lsR = false;
    AppMethodBeat.o(134051);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.lsI = paramBoolean;
    this.osN.lsI = this.lsI;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.vLz = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.pUQ = paramBoolean;
    if (this.pUJ != null) {
      this.pUJ.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.fMP = paramBoolean;
    if (this.pUJ != null)
    {
      ad.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
      this.pUJ.setMute(paramBoolean);
    }
    AppMethodBeat.o(134055);
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(134042);
    this.pUP = paramBoolean;
    if (this.pUJ != null) {
      this.pUJ.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.FkZ = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.pUO = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.FkY = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.pUL = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.osN.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.pUJ != null) {
      this.pUR = paramBoolean;
    }
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.pUM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    boN();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.pUJ != null) && (this.Zn))
    {
      i = hashCode();
      boolean bool2 = this.lsS;
      boolean bool3 = this.lsR;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.lsR = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.lsS)
      {
        this.lsR = true;
        this.lsS = false;
        setMute(this.fMP);
        AppMethodBeat.o(134048);
        return true;
      }
      this.pUJ.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.pUJ == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.Zn) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    if (this.pUJ != null)
    {
      this.pUJ.vLN = null;
      this.pUJ.stop();
      this.pUJ.release();
      this.pUJ = null;
    }
    this.FkX = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.osN.reset();
    this.Zn = false;
    this.path = null;
    this.fd = null;
    this.lsQ = 0L;
    AppMethodBeat.o(134050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */