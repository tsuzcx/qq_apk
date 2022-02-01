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
  
  public final void bei()
  {
    AppMethodBeat.i(100409);
    ad.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        ad.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
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
          AppMethodBeat.o(100409);
          return;
          if (this.oNL) {
            this.oNJ.cuQ();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.oNM != null) {
          this.oNM.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100415);
    ad.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.kuD) });
    for (;;)
    {
      try
      {
        eTg();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.oNJ == null) || (!this.WD))
        {
          bei();
          bGA();
          if (this.oNO != null) {
            this.oNO.aCw();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.oNJ.j(this.mSurface);
        if (!d.lf(23)) {
          break label208;
        }
        if (this.kuD)
        {
          this.oNJ.start();
          this.kuD = false;
          continue;
        }
        this.kuE = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.kuC = 0L;
      this.oNJ.setMute(true);
      this.oNJ.start();
      continue;
      label208:
      if (this.kuD) {
        d(this.oNJ.cPu(), true);
      } else {
        d(this.oNJ.cPu(), false);
      }
    }
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
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
      ad.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.CnA.beo();
      this.CnA = null;
    }
    this.kuC = System.currentTimeMillis();
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