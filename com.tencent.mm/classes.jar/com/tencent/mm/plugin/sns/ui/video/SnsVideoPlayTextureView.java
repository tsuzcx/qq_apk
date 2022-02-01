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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

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
  
  public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100415);
    ae.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lxq) });
    for (;;)
    {
      try
      {
        fDh();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.qbo == null) || (!this.Zn))
        {
          bpx();
          bTA();
          if (this.qbt != null) {
            this.qbt.aMV();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.qbo.i(this.mSurface);
        if (!d.lA(23)) {
          break label208;
        }
        if (this.lxq)
        {
          this.qbo.start();
          this.lxq = false;
          continue;
        }
        this.lxr = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ae.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.lxp = 0L;
      this.qbo.setMute(true);
      this.qbo.start();
      continue;
      label208:
      if (this.lxq) {
        d(this.qbo.dpx(), true);
      } else {
        d(this.qbo.dpx(), false);
      }
    }
  }
  
  public final void bpx()
  {
    AppMethodBeat.i(100409);
    ae.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        ae.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
        return;
      }
      try
      {
        this.Zn = false;
        this.qbo = new j(Looper.getMainLooper());
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
          AppMethodBeat.o(100409);
          return;
          if (this.qbq) {
            this.qbo.cSW();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.qbr != null) {
          this.qbr.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
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
      ae.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.FDw.bpD();
      this.FDw = null;
    }
    this.lxp = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */