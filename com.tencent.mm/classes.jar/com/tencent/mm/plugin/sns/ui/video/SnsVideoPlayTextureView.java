package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.d;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

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
  
  public final void bXd()
  {
    AppMethodBeat.i(100409);
    Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        Log.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
        return;
      }
      try
      {
        this.gX = false;
        this.uXR = new j(Looper.getMainLooper());
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
          AppMethodBeat.o(100409);
          return;
          if (this.uXT) {
            this.uXR.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.uXU != null) {
          this.uXU.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100415);
    Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.pDy) });
    for (;;)
    {
      try
      {
        hKg();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.uXR == null) || (!this.gX))
        {
          bXd();
          cEw();
          if (this.uXW != null) {
            this.uXW.bqp();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.uXR.m(this.mSurface);
        if (!d.qV(23)) {
          break label208;
        }
        if (this.pDy)
        {
          this.uXR.start();
          this.pDy = false;
          continue;
        }
        this.pDz = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.pDx = 0L;
      this.uXR.setMute(true);
      this.uXR.start();
      continue;
      label208:
      if (this.pDy) {
        b(this.uXR.eST(), true);
      } else {
        b(this.uXR.eST(), false);
      }
    }
  }
  
  public final void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
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
      Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.RxR.bXh();
      this.RxR = null;
    }
    this.pDx = System.currentTimeMillis();
    AppMethodBeat.o(100416);
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
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(100413);
    synchronized (this.lock)
    {
      super.q(paramDouble);
      AppMethodBeat.o(100413);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */