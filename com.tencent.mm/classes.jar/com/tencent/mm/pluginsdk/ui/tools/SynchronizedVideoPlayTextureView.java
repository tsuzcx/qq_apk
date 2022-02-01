package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class SynchronizedVideoPlayTextureView
  extends VideoPlayerTextureView
{
  private final Object lock;
  
  public SynchronizedVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(169157);
    this.lock = new Object();
    AppMethodBeat.o(169157);
  }
  
  public SynchronizedVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(169158);
    this.lock = new Object();
    AppMethodBeat.o(169158);
  }
  
  public SynchronizedVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169159);
    this.lock = new Object();
    AppMethodBeat.o(169159);
  }
  
  protected final void blc()
  {
    AppMethodBeat.i(169161);
    ac.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        ac.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
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
          AppMethodBeat.o(169161);
          return;
          if (this.prf) {
            this.prd.cIc();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.prg != null) {
          this.prg.onError(-1, -1);
        }
        AppMethodBeat.o(169161);
        return;
      }
    }
  }
  
  protected final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169167);
    for (;;)
    {
      synchronized (this.lock)
      {
        ac.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kVS) });
        try
        {
          fiQ();
          super.h(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.prd != null) && (this.Xy)) {
            continue;
          }
          blc();
          bNN();
          if (this.pri != null) {
            this.pri.aJn();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          ac.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.prd.i(this.mSurface);
        if (!d.kZ(23)) {
          break label236;
        }
        if (this.kVS)
        {
          this.prd.start();
          this.kVS = false;
        }
      }
      this.kVT = true;
      this.kVR = 0L;
      this.prd.setMute(true);
      this.prd.start();
      continue;
      label236:
      if (this.kVS) {
        d(this.prd.ddd(), true);
      } else {
        d(this.prd.ddd(), false);
      }
    }
  }
  
  protected final void k(SurfaceTexture arg1)
  {
    AppMethodBeat.i(169168);
    synchronized (this.lock)
    {
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
        ac.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.DFT.bli();
        this.DFT = null;
      }
      this.kVR = System.currentTimeMillis();
      AppMethodBeat.o(169168);
      return;
    }
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(169165);
    synchronized (this.lock)
    {
      super.p(paramDouble);
      AppMethodBeat.o(169165);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(169164);
    synchronized (this.lock)
    {
      super.pause();
      this.pre = false;
      AppMethodBeat.o(169164);
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(169166);
    synchronized (this.lock)
    {
      super.setMute(paramBoolean);
      AppMethodBeat.o(169166);
      return;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(169160);
    synchronized (this.lock)
    {
      super.setVideoPath(paramString);
      AppMethodBeat.o(169160);
      return;
    }
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(169163);
    synchronized (this.lock)
    {
      this.pre = true;
      boolean bool = super.start();
      AppMethodBeat.o(169163);
      return bool;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(169162);
    synchronized (this.lock)
    {
      super.stop();
      AppMethodBeat.o(169162);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */