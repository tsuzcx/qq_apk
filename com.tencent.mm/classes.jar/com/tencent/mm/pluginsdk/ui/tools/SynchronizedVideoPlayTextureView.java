package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.n.j;
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
  
  protected final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169167);
    for (;;)
    {
      synchronized (this.lock)
      {
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mEn) });
        try
        {
          gLi();
          super.h(this.mSurface);
          this.mSurface = new Surface(paramSurfaceTexture);
          if ((this.rsl != null) && (this.ZA)) {
            continue;
          }
          bLd();
          crn();
          if (this.rsq != null) {
            this.rsq.bgX();
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
          continue;
        }
        AppMethodBeat.o(169167);
        return;
        this.rsl.i(this.mSurface);
        if (!d.oD(23)) {
          break label236;
        }
        if (this.mEn)
        {
          this.rsl.start();
          this.mEn = false;
        }
      }
      this.mEo = true;
      this.mEm = 0L;
      this.rsl.setMute(true);
      this.rsl.start();
      continue;
      label236:
      if (this.mEn) {
        d(this.rsl.ejm(), true);
      } else {
        d(this.rsl.ejm(), false);
      }
    }
  }
  
  protected final void bLd()
  {
    AppMethodBeat.i(169161);
    Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.rsl != null)
      {
        this.rsl.zrT = null;
        this.rsl.stop();
        this.rsl.release();
        this.rsl = null;
      }
      if (Util.isNullOrNil(this.path))
      {
        Log.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(169161);
        return;
      }
      try
      {
        this.ZA = false;
        this.rsl = new j(Looper.getMainLooper(), getBusinessType());
        this.rsl.setPath(this.path);
        this.rsl.setIOnlineCache(this.zrF);
        this.rsl.setNeedResetExtractor(this.rsr);
        this.rsl.setIsOnlineVideoType(this.rss);
        this.rsl.zrT = this.rsv;
        this.rsl.setSurface(this.mSurface);
        this.rsl.ra(this.rst);
        if (this.mSurface != null) {
          this.rsl.prepare();
        }
        for (;;)
        {
          AppMethodBeat.o(169161);
          return;
          if (this.rsn) {
            this.rsl.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.rso != null) {
          this.rso.onError(-1, -1);
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
  
  protected final void l(SurfaceTexture arg1)
  {
    AppMethodBeat.i(169168);
    synchronized (this.lock)
    {
      if ((d.oD(23)) && (this.mEo) && (this.mEm > 0L))
      {
        if (this.rsl != null)
        {
          this.rsl.pause();
          this.rsl.setMute(this.guh);
        }
        this.mEo = false;
      }
      if ((this.mEm > 0L) && (this.KwA != null))
      {
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
        this.KwA.bLh();
        this.KwA = null;
      }
      this.mEm = System.currentTimeMillis();
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
      this.rsm = false;
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
      this.rsm = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */