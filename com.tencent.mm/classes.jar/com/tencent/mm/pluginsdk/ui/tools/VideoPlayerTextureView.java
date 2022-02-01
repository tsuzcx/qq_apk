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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView
  extends MMTextureView
  implements h
{
  protected h.e CnA;
  private h.c CnB;
  protected int Cnz;
  protected boolean WD;
  protected long bjw;
  protected FileDescriptor fd;
  protected boolean fqj;
  protected long kuC;
  protected boolean kuD;
  protected boolean kuE;
  private TextureView.SurfaceTextureListener kuG;
  protected boolean kuu;
  protected long length;
  protected Surface mSurface;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected u nng;
  protected j oNJ;
  protected boolean oNK;
  protected boolean oNL;
  protected h.a oNM;
  protected h.d oNO;
  protected boolean oNP;
  protected boolean oNQ;
  protected boolean oNR;
  protected d oNT;
  protected String path;
  protected b tzW;
  
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
    this.Cnz = 0;
    this.WD = false;
    this.oNK = true;
    this.kuC = 0L;
    this.kuu = false;
    this.oNL = false;
    this.oNP = false;
    this.oNQ = false;
    this.oNR = false;
    this.kuD = false;
    this.kuE = false;
    this.oNT = new d()
    {
      public final void W(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(134034);
        ad.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.this.nng.reset();
        VideoPlayerTextureView.this.Cnz = paramAnonymousInt3;
        VideoPlayerTextureView.this.mVideoWidth = paramAnonymousInt1;
        VideoPlayerTextureView.this.mVideoHeight = paramAnonymousInt2;
        VideoPlayerTextureView.this.bGA();
        if (VideoPlayerTextureView.this.oNM != null) {
          VideoPlayerTextureView.this.oNM.dY(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
        }
        AppMethodBeat.o(134034);
      }
      
      public final void bYy()
      {
        AppMethodBeat.i(134033);
        if (VideoPlayerTextureView.a(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.a(VideoPlayerTextureView.this).ey(VideoPlayerTextureView.this.oNK);
        }
        if (!VideoPlayerTextureView.this.oNK)
        {
          ad.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.this.oNK = true;
          AppMethodBeat.o(134033);
          return;
        }
        if (VideoPlayerTextureView.this.oNJ != null)
        {
          ad.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.this.oNJ.info() });
          VideoPlayerTextureView.this.oNJ.start();
        }
        AppMethodBeat.o(134033);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(134031);
        if (VideoPlayerTextureView.this.oNM != null) {
          VideoPlayerTextureView.this.oNM.onCompletion();
        }
        AppMethodBeat.o(134031);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134032);
        if (VideoPlayerTextureView.this.oNM != null) {
          VideoPlayerTextureView.this.oNM.onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134032);
      }
      
      public final void rq()
      {
        AppMethodBeat.i(134030);
        ad.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath() });
        VideoPlayerTextureView.this.WD = true;
        VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.fqj);
        if (VideoPlayerTextureView.this.oNM != null) {
          VideoPlayerTextureView.this.oNM.rq();
        }
        VideoPlayerTextureView.this.requestLayout();
        AppMethodBeat.o(134030);
      }
    };
    this.kuG = new TextureView.SurfaceTextureListener()
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
        ad.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.this.i(VideoPlayerTextureView.this.mSurface);
        VideoPlayerTextureView.this.mSurface = null;
        VideoPlayerTextureView.this.kuD = false;
        VideoPlayerTextureView.this.kuE = false;
        if (VideoPlayerTextureView.this.oNJ != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.this.kuD = true;
            VideoPlayerTextureView.this.oNJ.pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134037);
          return false;
          VideoPlayerTextureView.this.kuD = false;
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134036);
        ad.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.this.bGA();
        AppMethodBeat.o(134036);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134038);
        VideoPlayerTextureView.this.k(paramAnonymousSurfaceTexture);
        AppMethodBeat.o(134038);
      }
    };
    this.nng = new u();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.kuG);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134040);
  }
  
  public final boolean Nb()
  {
    AppMethodBeat.i(134045);
    if (this.oNJ != null)
    {
      j localj = this.oNJ;
      if (localj.tAk != null)
      {
        boolean bool = e.GB(localj.tAk.state);
        AppMethodBeat.o(134045);
        return bool;
      }
      AppMethodBeat.o(134045);
      return false;
    }
    AppMethodBeat.o(134045);
    return false;
  }
  
  protected void bGA()
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
  
  protected void bei()
  {
    AppMethodBeat.i(134056);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", new Object[] { Integer.valueOf(hashCode()), this.path, this.mSurface });
    if (this.oNJ != null)
    {
      this.oNJ.tAl = null;
      this.oNJ.stop();
      this.oNJ.release();
      this.oNJ = null;
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
        this.WD = false;
        this.oNJ = new j(Looper.getMainLooper());
        if (!bt.isNullOrNil(this.path))
        {
          this.oNJ.setPath(this.path);
          this.oNJ.setIOnlineCache(this.tzW);
          this.oNJ.setNeedResetExtractor(this.oNP);
          this.oNJ.setIsOnlineVideoType(this.oNQ);
          this.oNJ.tAl = this.oNT;
          this.oNJ.setSurface(this.mSurface);
          this.oNJ.nd(this.oNR);
          if (this.mSurface == null) {
            break;
          }
          this.oNJ.cuQ();
          AppMethodBeat.o(134056);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.oNM != null) {
          this.oNM.onError(-1, -1);
        }
        AppMethodBeat.o(134056);
        return;
      }
      if ((this.fd != null) && (this.fd.valid()))
      {
        j localj = this.oNJ;
        FileDescriptor localFileDescriptor = this.fd;
        long l1 = this.bjw;
        long l2 = this.length;
        localj.tAk.tAt.a(localFileDescriptor, l1, l2);
      }
    }
    if (this.oNL) {
      this.oNJ.cuQ();
    }
    AppMethodBeat.o(134056);
  }
  
  public final void bej()
  {
    AppMethodBeat.i(134057);
    if ((this.oNJ != null) && (this.WD) && (this.mSurface != null))
    {
      ad.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      j localj = this.oNJ;
      if (localj.tAk != null) {
        localj.tAk.bej();
      }
    }
    AppMethodBeat.o(134057);
  }
  
  protected void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134058);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kuD) });
    for (;;)
    {
      try
      {
        eTg();
        i(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.oNJ == null) || (!this.WD))
        {
          bei();
          bGA();
          if (this.oNO != null) {
            this.oNO.aCw();
          }
          AppMethodBeat.o(134058);
          return;
        }
        this.oNJ.j(this.mSurface);
        if (this.kuD)
        {
          this.oNJ.start();
          this.kuD = false;
          continue;
        }
        this.kuE = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(134058);
        return;
      }
      this.kuC = 0L;
      this.oNJ.setMute(true);
      this.oNJ.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134054);
    this.oNK = paramBoolean;
    q(paramDouble);
    AppMethodBeat.o(134054);
  }
  
  public final boolean eAU()
  {
    if (this.mSurface == null) {}
    while (this.kuE) {
      return false;
    }
    return true;
  }
  
  public final void eAV()
  {
    AppMethodBeat.i(134047);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(hashCode()) });
    if (this.oNJ != null)
    {
      j localj = this.oNJ;
      if (localj.tAk != null) {
        localj.tAk.cPv();
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
    if (this.oNJ != null)
    {
      int i = this.oNJ.cPu();
      AppMethodBeat.o(134052);
      return i;
    }
    AppMethodBeat.o(134052);
    return 0;
  }
  
  public int getDuration()
  {
    if (this.oNJ != null) {
      return (int)this.oNJ.tAk.bjp;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.kuC;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  protected final void i(final Surface paramSurface)
  {
    AppMethodBeat.i(134060);
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134039);
        try
        {
          if ((paramSurface != null) && (paramSurface.isValid()))
          {
            ad.i("MicroMsg.VideoPlayerTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramSurface.hashCode()) });
            paramSurface.release();
          }
          AppMethodBeat.o(134039);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "release Surface error", new Object[0]);
          AppMethodBeat.o(134039);
        }
      }
    });
    AppMethodBeat.o(134060);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134044);
    if (this.oNJ != null)
    {
      boolean bool = this.oNJ.isPlaying();
      AppMethodBeat.o(134044);
      return bool;
    }
    AppMethodBeat.o(134044);
    return false;
  }
  
  protected void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(134059);
    if ((this.kuE) && (this.kuC > 0L) && (this.oNJ != null))
    {
      this.oNJ.pause();
      this.oNJ.setMute(this.fqj);
      this.kuE = false;
    }
    if ((this.kuC > 0L) && (this.CnA != null))
    {
      ad.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.CnA.beo();
      this.CnA = null;
    }
    this.kuC = System.currentTimeMillis();
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
    this.nng.x(paramInt1, paramInt2, i, j);
    paramInt1 = this.nng.kvp;
    paramInt2 = this.nng.kvq;
    if ((this.Cnz == 90) || (this.Cnz == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.Cnz, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(134063);
  }
  
  public void pause()
  {
    AppMethodBeat.i(134051);
    if ((this.oNJ != null) && (this.oNJ.isPlaying())) {
      this.oNJ.pause();
    }
    this.kuD = false;
    AppMethodBeat.o(134051);
  }
  
  public void q(double paramDouble)
  {
    AppMethodBeat.i(134053);
    if (this.oNJ != null) {
      this.oNJ.GI((int)paramDouble);
    }
    AppMethodBeat.o(134053);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.kuu = paramBoolean;
    this.nng.kuu = this.kuu;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.tzW = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(134043);
    this.oNQ = paramBoolean;
    if (this.oNJ != null) {
      this.oNJ.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(134043);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134055);
    this.fqj = paramBoolean;
    if (this.oNJ != null)
    {
      ad.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
      this.oNJ.setMute(paramBoolean);
    }
    AppMethodBeat.o(134055);
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(134042);
    this.oNP = paramBoolean;
    if (this.oNJ != null) {
      this.oNJ.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(134042);
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.CnB = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.oNO = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.CnA = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.oNL = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(134062);
    if (this.nng.a(parame)) {
      requestLayout();
    }
    AppMethodBeat.o(134062);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.oNJ != null) {
      this.oNR = paramBoolean;
    }
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.oNM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134046);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    bei();
    requestLayout();
    AppMethodBeat.o(134046);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(134048);
    if ((this.oNJ != null) && (this.WD))
    {
      i = hashCode();
      boolean bool2 = this.kuE;
      boolean bool3 = this.kuD;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.kuD = true;
        AppMethodBeat.o(134048);
        return true;
      }
      if (this.kuE)
      {
        this.kuD = true;
        this.kuE = false;
        setMute(this.fqj);
        AppMethodBeat.o(134048);
        return true;
      }
      this.oNJ.start();
      AppMethodBeat.o(134048);
      return true;
    }
    int i = hashCode();
    if (this.oNJ == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.WD) });
      AppMethodBeat.o(134048);
      return false;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(134050);
    ad.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    if (this.oNJ != null)
    {
      this.oNJ.tAl = null;
      this.oNJ.stop();
      this.oNJ.release();
      this.oNJ = null;
    }
    this.Cnz = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.nng.reset();
    this.WD = false;
    this.path = null;
    this.fd = null;
    this.kuC = 0L;
    AppMethodBeat.o(134050);
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134049);
    paramBoolean = start();
    AppMethodBeat.o(134049);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */