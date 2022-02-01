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
  
  protected final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169167);
    for (;;)
    {
      synchronized (this.lock)
      {
        ad.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lsR) });
        try
        {
          fzf();
          super.h(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.pUJ != null) && (this.Zn)) {
            continue;
          }
          boN();
          bSn();
          if (this.pUO != null) {
            this.pUO.aMx();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          ad.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.pUJ.i(this.mSurface);
        if (!d.ly(23)) {
          break label236;
        }
        if (this.lsR)
        {
          this.pUJ.start();
          this.lsR = false;
        }
      }
      this.lsS = true;
      this.lsQ = 0L;
      this.pUJ.setMute(true);
      this.pUJ.start();
      continue;
      label236:
      if (this.lsR) {
        d(this.pUJ.dmz(), true);
      } else {
        d(this.pUJ.dmz(), false);
      }
    }
  }
  
  protected final void boN()
  {
    AppMethodBeat.i(169161);
    ad.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.pUJ != null)
      {
        this.pUJ.vLN = null;
        this.pUJ.stop();
        this.pUJ.release();
        this.pUJ = null;
      }
      if (bt.isNullOrNil(this.path))
      {
        ad.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
        return;
      }
      try
      {
        this.Zn = false;
        this.pUJ = new j(Looper.getMainLooper(), getBusinessType());
        this.pUJ.setPath(this.path);
        this.pUJ.setIOnlineCache(this.vLz);
        this.pUJ.setNeedResetExtractor(this.pUP);
        this.pUJ.setIsOnlineVideoType(this.pUQ);
        this.pUJ.vLN = this.pUT;
        this.pUJ.setSurface(this.mSurface);
        this.pUJ.oq(this.pUR);
        if (this.mSurface != null) {
          this.pUJ.cQr();
        }
        for (;;)
        {
          AppMethodBeat.o(169161);
          return;
          if (this.pUL) {
            this.pUJ.cQr();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.pUM != null) {
          this.pUM.onError(-1, -1);
        }
        AppMethodBeat.o(169161);
        return;
      }
    }
  }
  
  protected int getBusinessType()
  {
    return 0;
  }
  
  protected final void k(SurfaceTexture arg1)
  {
    AppMethodBeat.i(169168);
    synchronized (this.lock)
    {
      if ((d.ly(23)) && (this.lsS) && (this.lsQ > 0L))
      {
        if (this.pUJ != null)
        {
          this.pUJ.pause();
          this.pUJ.setMute(this.fMP);
        }
        this.lsS = false;
      }
      if ((this.lsQ > 0L) && (this.FkY != null))
      {
        ad.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.FkY.boT();
        this.FkY = null;
      }
      this.lsQ = System.currentTimeMillis();
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
      this.pUK = false;
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
      this.pUK = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */