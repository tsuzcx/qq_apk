package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class TopStoryVideoPlayTextureView
  extends VideoPlayerTextureView
{
  private Object lock = new Object();
  
  public TopStoryVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TopStoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TopStoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void aKM()
  {
    y.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.joI != null)
      {
        this.joI.meF = null;
        this.joI.meE.stop();
        this.joI.release();
        this.joI = null;
      }
      if (bk.bl(this.path))
      {
        y.w("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
    }
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
      if (this.mSurface != null) {
        this.joI.prepare();
      }
      for (;;)
      {
        return;
        localObject2 = finally;
        throw localObject2;
        if (this.joL) {
          this.joI.prepare();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.joM != null) {
        this.joM.onError(-1, -1);
      }
    }
  }
  
  protected final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.joT) });
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
          d(this.joI.bix(), true);
          this.joT = false;
        }
        else
        {
          d(this.joI.bix(), false);
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        y.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        return;
      }
    }
  }
  
  protected final void cVo()
  {
    if ((this.joK > 0L) && (this.sni != null))
    {
      y.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.sni.bkk();
      this.sni = null;
    }
    this.joK = System.currentTimeMillis();
  }
  
  public final void pause()
  {
    synchronized (this.lock)
    {
      super.pause();
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      super.setMute(paramBoolean);
      return;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    super.setVideoPath(paramString);
  }
  
  public final boolean start()
  {
    synchronized (this.lock)
    {
      boolean bool = super.start();
      return bool;
    }
  }
  
  public final void stop()
  {
    e.post(new TopStoryVideoPlayTextureView.1(this), "player-stop");
  }
  
  public final void x(double paramDouble)
  {
    synchronized (this.lock)
    {
      super.x(paramDouble);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */