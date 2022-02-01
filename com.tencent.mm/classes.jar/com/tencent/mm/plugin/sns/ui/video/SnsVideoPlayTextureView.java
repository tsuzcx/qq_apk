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
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.d;
import com.tencent.mm.pluginsdk.ui.tools.i.e;
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
  
  public final void H(double paramDouble)
  {
    AppMethodBeat.i(100413);
    synchronized (this.lock)
    {
      super.H(paramDouble);
      AppMethodBeat.o(100413);
      return;
    }
  }
  
  public final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100415);
    Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.sIK) });
    for (;;)
    {
      try
      {
        jmM();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.ykf == null) || (!this.hS))
        {
          cxo();
          dYi();
          if (this.ykk != null) {
            this.ykk.bNV();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.ykf.r(this.mSurface);
        if (!d.rb(23)) {
          break label208;
        }
        if (this.sIK)
        {
          this.ykf.start();
          this.sIK = false;
          continue;
        }
        this.sIL = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.sIJ = 0L;
      this.ykf.setMute(true);
      this.ykf.start();
      continue;
      label208:
      if (this.sIK) {
        c(this.ykf.gbM(), true);
      } else {
        c(this.ykf.gbM(), false);
      }
    }
  }
  
  public final void cxo()
  {
    AppMethodBeat.i(100409);
    Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        Log.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
        return;
      }
      try
      {
        this.hS = false;
        this.ykf = new j(Looper.getMainLooper());
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
          AppMethodBeat.o(100409);
          return;
          if (this.ykh) {
            this.ykf.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.yki != null) {
          this.yki.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
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
      Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.Yum.onTextureUpdate();
      this.Yum = null;
    }
    this.sIJ = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */