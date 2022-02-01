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
  
  public final void H(double paramDouble)
  {
    AppMethodBeat.i(169165);
    synchronized (this.lock)
    {
      super.H(paramDouble);
      AppMethodBeat.o(169165);
      return;
    }
  }
  
  protected final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169167);
    for (;;)
    {
      synchronized (this.lock)
      {
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.sIK) });
        try
        {
          jmM();
          super.n(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.ykf != null) && (this.hS)) {
            continue;
          }
          cxo();
          dYi();
          if (this.ykk != null) {
            this.ykk.bNV();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.ykf.r(this.mSurface);
        if (!d.rb(23)) {
          break label236;
        }
        if (this.sIK)
        {
          this.ykf.start();
          this.sIK = false;
        }
      }
      this.sIL = true;
      this.sIJ = 0L;
      this.ykf.setMute(true);
      this.ykf.start();
      continue;
      label236:
      if (this.sIK) {
        c(this.ykf.gbM(), true);
      } else {
        c(this.ykf.gbM(), false);
      }
    }
  }
  
  protected final void cxo()
  {
    AppMethodBeat.i(169161);
    Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.ykf != null)
      {
        this.ykf.KTf = null;
        this.ykf.stop();
        this.ykf.release();
        this.ykf = null;
      }
      if (Util.isNullOrNil(this.path))
      {
        Log.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
        return;
      }
      try
      {
        this.hS = false;
        this.ykf = new j(Looper.getMainLooper(), getBusinessType());
        this.ykf.setPath(this.path);
        this.ykf.setIOnlineCache(this.KSQ);
        this.ykf.setNeedResetExtractor(this.ykl);
        this.ykf.setIsOnlineVideoType(this.ykm);
        this.ykf.KTf = this.ykp;
        this.ykf.setSurface(this.mSurface);
        this.ykf.yr(this.ykn);
        if (this.mSurface != null) {
          this.ykf.prepare();
        }
        for (;;)
        {
          AppMethodBeat.o(169161);
          return;
          if (this.ykh) {
            this.ykf.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.yki != null) {
          this.yki.onError(-1, -1);
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
  
  protected final void o(SurfaceTexture arg1)
  {
    AppMethodBeat.i(169168);
    synchronized (this.lock)
    {
      if ((d.rb(23)) && (this.sIL) && (this.sIJ > 0L))
      {
        if (this.ykf != null)
        {
          this.ykf.pause();
          this.ykf.setMute(this.lAj);
        }
        this.sIL = false;
      }
      if ((this.sIJ > 0L) && (this.Yum != null))
      {
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.Yum.onTextureUpdate();
        this.Yum = null;
      }
      this.sIJ = System.currentTimeMillis();
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
      this.ykg = false;
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
      this.ykg = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */