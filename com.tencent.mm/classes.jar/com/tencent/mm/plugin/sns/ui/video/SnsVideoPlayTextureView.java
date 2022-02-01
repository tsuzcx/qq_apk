package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.d;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class SnsVideoPlayTextureView
  extends VideoPlayerTextureView
{
  private Object lock;
  
  public SnsVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100406);
    this.lock = new Object();
    AppMethodBeat.o(100406);
  }
  
  public SnsVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100407);
    this.lock = new Object();
    AppMethodBeat.o(100407);
  }
  
  public final void blc()
  {
    AppMethodBeat.i(100409);
    ac.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.prd != null)
      {
        this.prd.uIH = null;
        this.prd.stop();
        this.prd.release();
        this.prd = null;
      }
      if (bs.isNullOrNil(this.path))
      {
        ac.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
        return;
      }
      try
      {
        this.Xy = false;
        this.prd = new j(Looper.getMainLooper());
        this.prd.setPath(this.path);
        this.prd.setIOnlineCache(this.uIt);
        this.prd.setNeedResetExtractor(this.prj);
        this.prd.setIsOnlineVideoType(this.prk);
        this.prd.uIH = this.prn;
        this.prd.setSurface(this.mSurface);
        this.prd.nW(this.prl);
        if (this.mSurface != null) {
          this.prd.cIc();
        }
        for (;;)
        {
          AppMethodBeat.o(100409);
          return;
          if (this.prf) {
            this.prd.cIc();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.prg != null) {
          this.prg.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100415);
    ac.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kVS) });
    for (;;)
    {
      try
      {
        fiQ();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.prd == null) || (!this.Xy))
        {
          blc();
          bNN();
          if (this.pri != null) {
            this.pri.aJn();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.prd.i(this.mSurface);
        if (!d.kZ(23)) {
          break label208;
        }
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
        ac.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.kVR = 0L;
      this.prd.setMute(true);
      this.prd.start();
      continue;
      label208:
      if (this.kVS) {
        d(this.prd.ddd(), true);
      } else {
        d(this.prd.ddd(), false);
      }
    }
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
    if ((d.kZ(23)) && (this.kVT) && (this.kVR > 0L))
    {
      if (this.prd != null)
      {
        this.prd.pause();
        this.prd.setMute(this.ftN);
      }
      this.kVT = false;
    }
    if ((this.kVR > 0L) && (this.DFT != null))
    {
      ac.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.DFT.bli();
      this.DFT = null;
    }
    this.kVR = System.currentTimeMillis();
    AppMethodBeat.o(100416);
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(100413);
    synchronized (this.lock)
    {
      super.p(paramDouble);
      AppMethodBeat.o(100413);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(100412);
    synchronized (this.lock)
    {
      super.pause();
      AppMethodBeat.o(100412);
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(100414);
    synchronized (this.lock)
    {
      super.setMute(paramBoolean);
      AppMethodBeat.o(100414);
      return;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(100408);
    super.setVideoPath(paramString);
    AppMethodBeat.o(100408);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(100411);
    synchronized (this.lock)
    {
      boolean bool = super.start();
      AppMethodBeat.o(100411);
      return bool;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(100410);
    synchronized (this.lock)
    {
      super.stop();
      AppMethodBeat.o(100410);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */