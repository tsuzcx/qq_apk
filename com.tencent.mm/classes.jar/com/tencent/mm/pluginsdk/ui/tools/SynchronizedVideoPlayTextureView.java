package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

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
        ae.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lxq) });
        try
        {
          fDh();
          super.h(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.qbo != null) && (this.Zn)) {
            continue;
          }
          bpx();
          bTA();
          if (this.qbt != null) {
            this.qbt.aMV();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          ae.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.qbo.i(this.mSurface);
        if (!d.lA(23)) {
          break label236;
        }
        if (this.lxq)
        {
          this.qbo.start();
          this.lxq = false;
        }
      }
      this.lxr = true;
      this.lxp = 0L;
      this.qbo.setMute(true);
      this.qbo.start();
      continue;
      label236:
      if (this.lxq) {
        d(this.qbo.dpx(), true);
      } else {
        d(this.qbo.dpx(), false);
      }
    }
  }
  
  protected final void bpx()
  {
    AppMethodBeat.i(169161);
    ae.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.qbo != null)
      {
        this.qbo.vXR = null;
        this.qbo.stop();
        this.qbo.release();
        this.qbo = null;
      }
      if (bu.isNullOrNil(this.path))
      {
        ae.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
        return;
      }
      try
      {
        this.Zn = false;
        this.qbo = new j(Looper.getMainLooper(), getBusinessType());
        this.qbo.setPath(this.path);
        this.qbo.setIOnlineCache(this.vXD);
        this.qbo.setNeedResetExtractor(this.qbu);
        this.qbo.setIsOnlineVideoType(this.qbv);
        this.qbo.vXR = this.qby;
        this.qbo.setSurface(this.mSurface);
        this.qbo.ov(this.qbw);
        if (this.mSurface != null) {
          this.qbo.cSW();
        }
        for (;;)
        {
          AppMethodBeat.o(169161);
          return;
          if (this.qbq) {
            this.qbo.cSW();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.qbr != null) {
          this.qbr.onError(-1, -1);
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
      if ((d.lA(23)) && (this.lxr) && (this.lxp > 0L))
      {
        if (this.qbo != null)
        {
          this.qbo.pause();
          this.qbo.setMute(this.fOX);
        }
        this.lxr = false;
      }
      if ((this.lxp > 0L) && (this.FDw != null))
      {
        ae.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.FDw.bpD();
        this.FDw = null;
      }
      this.lxp = System.currentTimeMillis();
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
      this.qbp = false;
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
      this.qbp = true;
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