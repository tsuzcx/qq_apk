package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

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
  
  protected final void bXd()
  {
    AppMethodBeat.i(169161);
    Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.uXR != null)
      {
        this.uXR.EXu = null;
        this.uXR.stop();
        this.uXR.release();
        this.uXR = null;
      }
      if (Util.isNullOrNil(this.path))
      {
        Log.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
        return;
      }
      try
      {
        this.gX = false;
        this.uXR = new j(Looper.getMainLooper(), getBusinessType());
        this.uXR.setPath(this.path);
        this.uXR.setIOnlineCache(this.EXe);
        this.uXR.setNeedResetExtractor(this.uXX);
        this.uXR.setIsOnlineVideoType(this.uXY);
        this.uXR.EXu = this.uYb;
        this.uXR.setSurface(this.mSurface);
        this.uXR.ud(this.uXZ);
        if (this.mSurface != null) {
          this.uXR.prepare();
        }
        for (;;)
        {
          AppMethodBeat.o(169161);
          return;
          if (this.uXT) {
            this.uXR.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.uXU != null) {
          this.uXU.onError(-1, -1);
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
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.pDy) });
        try
        {
          hKg();
          super.j(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.uXR != null) && (this.gX)) {
            continue;
          }
          bXd();
          cEw();
          if (this.uXW != null) {
            this.uXW.bqp();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.uXR.m(this.mSurface);
        if (!d.qV(23)) {
          break label236;
        }
        if (this.pDy)
        {
          this.uXR.start();
          this.pDy = false;
        }
      }
      this.pDz = true;
      this.pDx = 0L;
      this.uXR.setMute(true);
      this.uXR.start();
      continue;
      label236:
      if (this.pDy) {
        b(this.uXR.eST(), true);
      } else {
        b(this.uXR.eST(), false);
      }
    }
  }
  
  protected int getBusinessType()
  {
    return 0;
  }
  
  protected final void o(SurfaceTexture arg1)
  {
    AppMethodBeat.i(169168);
    synchronized (this.lock)
    {
      if ((d.qV(23)) && (this.pDz) && (this.pDx > 0L))
      {
        if (this.uXR != null)
        {
          this.uXR.pause();
          this.uXR.setMute(this.iYs);
        }
        this.pDz = false;
      }
      if ((this.pDx > 0L) && (this.RxR != null))
      {
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.RxR.bXh();
        this.RxR = null;
      }
      this.pDx = System.currentTimeMillis();
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
      this.uXS = false;
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
      this.uXS = true;
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