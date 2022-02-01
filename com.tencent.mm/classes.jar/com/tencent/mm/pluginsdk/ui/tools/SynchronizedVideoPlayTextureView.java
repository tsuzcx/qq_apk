package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

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
  
  protected final void bei()
  {
    AppMethodBeat.i(169161);
    ad.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.oNJ != null)
      {
        this.oNJ.tAl = null;
        this.oNJ.stop();
        this.oNJ.release();
        this.oNJ = null;
      }
      if (bt.isNullOrNil(this.path))
      {
        ad.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
        return;
      }
      try
      {
        this.WD = false;
        this.oNJ = new j(Looper.getMainLooper());
        this.oNJ.setPath(this.path);
        this.oNJ.setIOnlineCache(this.tzW);
        this.oNJ.setNeedResetExtractor(this.oNP);
        this.oNJ.setIsOnlineVideoType(this.oNQ);
        this.oNJ.tAl = this.oNT;
        this.oNJ.setSurface(this.mSurface);
        this.oNJ.nd(this.oNR);
        if (this.mSurface != null) {
          this.oNJ.cuQ();
        }
        for (;;)
        {
          AppMethodBeat.o(169161);
          return;
          if (this.oNL) {
            this.oNJ.cuQ();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.oNM != null) {
          this.oNM.onError(-1, -1);
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
        ad.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kuD) });
        try
        {
          eTg();
          super.i(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.oNJ != null) && (this.WD)) {
            continue;
          }
          bei();
          bGA();
          if (this.oNO != null) {
            this.oNO.aCw();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          ad.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.oNJ.j(this.mSurface);
        if (!d.lf(23)) {
          break label236;
        }
        if (this.kuD)
        {
          this.oNJ.start();
          this.kuD = false;
        }
      }
      this.kuE = true;
      this.kuC = 0L;
      this.oNJ.setMute(true);
      this.oNJ.start();
      continue;
      label236:
      if (this.kuD) {
        d(this.oNJ.cPu(), true);
      } else {
        d(this.oNJ.cPu(), false);
      }
    }
  }
  
  protected final void k(SurfaceTexture arg1)
  {
    AppMethodBeat.i(169168);
    synchronized (this.lock)
    {
      if ((d.lf(23)) && (this.kuE) && (this.kuC > 0L))
      {
        if (this.oNJ != null)
        {
          this.oNJ.pause();
          this.oNJ.setMute(this.fqj);
        }
        this.kuE = false;
      }
      if ((this.kuC > 0L) && (this.CnA != null))
      {
        ad.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.CnA.beo();
        this.CnA = null;
      }
      this.kuC = System.currentTimeMillis();
      AppMethodBeat.o(169168);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(169164);
    synchronized (this.lock)
    {
      super.pause();
      AppMethodBeat.o(169164);
      return;
    }
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(169165);
    synchronized (this.lock)
    {
      super.q(paramDouble);
      AppMethodBeat.o(169165);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */