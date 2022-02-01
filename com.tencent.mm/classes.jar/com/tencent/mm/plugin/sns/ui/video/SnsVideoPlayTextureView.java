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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

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
    ad.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lsR) });
    for (;;)
    {
      try
      {
        fzf();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.pUJ == null) || (!this.Zn))
        {
          boN();
          bSn();
          if (this.pUO != null) {
            this.pUO.aMx();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.pUJ.i(this.mSurface);
        if (!d.ly(23)) {
          break label208;
        }
        if (this.lsR)
        {
          this.pUJ.start();
          this.lsR = false;
          continue;
        }
        this.lsS = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.lsQ = 0L;
      this.pUJ.setMute(true);
      this.pUJ.start();
      continue;
      label208:
      if (this.lsR) {
        d(this.pUJ.dmz(), true);
      } else {
        d(this.pUJ.dmz(), false);
      }
    }
  }
  
  public final void boN()
  {
    AppMethodBeat.i(100409);
    ad.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        ad.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
        return;
      }
      try
      {
        this.Zn = false;
        this.pUJ = new j(Looper.getMainLooper());
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
          AppMethodBeat.o(100409);
          return;
          if (this.pUL) {
            this.pUJ.cQr();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.pUM != null) {
          this.pUM.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
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
      ad.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.FkY.boT();
      this.FkY = null;
    }
    this.lsQ = System.currentTimeMillis();
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