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
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public class VideoPlayerTextureView
  extends MMTextureView
  implements f
{
  public boolean PT = false;
  protected boolean dnJ;
  public i joI;
  protected boolean joJ = true;
  public long joK = 0L;
  public boolean joL = false;
  public f.a joM;
  public f.d joP;
  public boolean joQ = false;
  public boolean joR = false;
  public boolean joS = false;
  public boolean joT = false;
  protected boolean joU = false;
  public c joV = new VideoPlayerTextureView.1(this);
  public Surface mSurface;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  public b mes;
  public String path;
  private int sng = 0;
  protected boolean snh = false;
  public f.e sni;
  private f.c snj;
  private TextureView.SurfaceTextureListener snk = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      VideoPlayerTextureView.this.b(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      y.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
      VideoPlayerTextureView.this.mSurface = null;
      VideoPlayerTextureView.this.joT = false;
      VideoPlayerTextureView.this.joU = false;
      if (VideoPlayerTextureView.this.joI != null)
      {
        if (VideoPlayerTextureView.this.isPlaying())
        {
          VideoPlayerTextureView.this.joT = true;
          VideoPlayerTextureView.this.joI.pause();
        }
        return false;
      }
      VideoPlayerTextureView.this.joT = false;
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      y.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      VideoPlayerTextureView.this.cor();
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      VideoPlayerTextureView.this.cVo();
    }
  };
  private p snl = new p();
  
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
    setSurfaceTextureListener(this.snk);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  public void aKM()
  {
    y.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    if (this.joI != null)
    {
      this.joI.meF = null;
      this.joI.meE.stop();
      this.joI.release();
      this.joI = null;
    }
    if ((bk.bl(this.path)) || (this.mSurface == null)) {
      y.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
    }
    do
    {
      do
      {
        return;
        try
        {
          this.PT = false;
          this.joI = new i(Looper.getMainLooper());
          this.joI.setPath(this.path);
          this.joI.setIOnlineCache(this.mes);
          this.joI.setNeedResetExtractor(this.joQ);
          this.joI.setIsOnlineVideoType(this.joR);
          this.joI.meF = this.joV;
          this.joI.setSurface(this.mSurface);
          this.joI.hr(this.joS);
          if (this.mSurface == null) {
            break;
          }
          this.joI.prepare();
          return;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        }
      } while (this.joM == null);
      this.joM.onError(-1, -1);
      return;
    } while (!this.joL);
    this.joI.prepare();
  }
  
  public void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.joT) });
    for (;;)
    {
      try
      {
        cBe();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.joI == null) || (!this.PT))
        {
          aKM();
          cor();
          if (this.joP == null) {
            break;
          }
          this.joP.Sh();
          return;
        }
        this.joI.d(this.mSurface);
        if (this.joT)
        {
          this.joI.start();
          this.joT = false;
          continue;
        }
        this.joU = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        y.printErrStackTrace("MicroMsg.VideoPlayerTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        return;
      }
      this.joK = 0L;
      this.joI.setMute(true);
      this.joI.start();
    }
  }
  
  public final void biz()
  {
    if ((this.joI != null) && (this.PT) && (this.mSurface != null))
    {
      y.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      i locali = this.joI;
      if (locali.meE != null) {
        locali.meE.biz();
      }
    }
  }
  
  public void cVo()
  {
    if ((this.joU) && (this.joK > 0L))
    {
      this.joI.pause();
      this.joI.setMute(this.dnJ);
      this.joU = false;
    }
    if ((this.joK > 0L) && (this.sni != null))
    {
      y.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.sni.bkk();
      this.sni = null;
    }
    this.joK = System.currentTimeMillis();
  }
  
  public final boolean coq()
  {
    if (this.mSurface == null) {}
    while (this.joU) {
      return false;
    }
    return true;
  }
  
  public final void cor()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    this.joJ = paramBoolean;
    x(paramDouble);
  }
  
  public int getCurrentPosition()
  {
    if (this.joI != null) {
      return this.joI.bix();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.joI != null) {
      return (int)this.joI.meE.aGU;
    }
    return 0;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.joK;
  }
  
  public String getVideoPath()
  {
    return this.path;
  }
  
  public final boolean isPlaying()
  {
    if (this.joI != null) {
      return this.joI.isPlaying();
    }
    return false;
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.snl.B(paramInt1, paramInt2, i, j);
    paramInt1 = this.snl.gHT;
    paramInt2 = this.snl.gHU;
    if ((this.sng == 90) || (this.sng == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
        localMatrix.setScale(getScaleX(), getScaleY(), f1, f2);
      }
      localMatrix.postRotate(this.sng, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void pause()
  {
    if ((this.joI != null) && (this.joI.isPlaying())) {
      this.joI.pause();
    }
    this.joT = false;
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    return start();
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.snh = paramBoolean;
    this.snl.snh = this.snh;
  }
  
  public void setIOnlineCache(b paramb)
  {
    this.mes = paramb;
  }
  
  public void setIsOnlineVideoType(boolean paramBoolean)
  {
    this.joR = paramBoolean;
    if (this.joI != null) {
      this.joI.setIsOnlineVideoType(paramBoolean);
    }
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setMute(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
    if (this.joI != null)
    {
      y.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
      this.joI.setMute(paramBoolean);
    }
  }
  
  public void setNeedResetExtractor(boolean paramBoolean)
  {
    this.joQ = paramBoolean;
    if (this.joI != null) {
      this.joI.setNeedResetExtractor(paramBoolean);
    }
  }
  
  public void setOnInfoCallback(f.b paramb) {}
  
  public void setOnSeekCompleteCallback(f.c paramc)
  {
    this.snj = paramc;
  }
  
  public void setOnSurfaceCallback(f.d paramd)
  {
    this.joP = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(f.e parame)
  {
    this.sni = parame;
  }
  
  public void setOpenWithNoneSurface(boolean paramBoolean)
  {
    this.joL = paramBoolean;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(h.d paramd)
  {
    this.snl.setScaleType(paramd);
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setUseMp4Extrator(boolean paramBoolean)
  {
    if (this.joI != null) {
      this.joS = paramBoolean;
    }
  }
  
  public void setVideoCallback(f.a parama)
  {
    this.joM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    y.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    aKM();
    requestLayout();
  }
  
  public boolean start()
  {
    if ((this.joI != null) && (this.PT))
    {
      i = hashCode();
      boolean bool2 = this.joU;
      boolean bool3 = this.joT;
      if (this.mSurface != null) {}
      for (bool1 = true;; bool1 = false)
      {
        y.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.mSurface != null) {
          break;
        }
        this.joT = true;
        return true;
      }
      if (this.joU)
      {
        this.joT = true;
        this.joU = false;
        setMute(this.dnJ);
        return true;
      }
      this.joI.start();
      return true;
    }
    int i = hashCode();
    if (this.joI == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.PT) });
      return false;
    }
  }
  
  public void stop()
  {
    y.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    if (this.joI != null)
    {
      this.joI.meF = null;
      this.joI.meE.stop();
      this.joI.release();
      this.joI = null;
    }
    this.sng = 0;
    this.mVideoHeight = 0;
    this.mVideoWidth = 0;
    this.snl.reset();
    this.PT = false;
    this.path = null;
    this.joK = 0L;
  }
  
  public void x(double paramDouble)
  {
    if (this.joI != null) {
      this.joI.tP((int)paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */