package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.d;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
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
  
  public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100415);
    Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mEn) });
    for (;;)
    {
      try
      {
        gLi();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.rsl == null) || (!this.ZA))
        {
          bLd();
          crn();
          if (this.rsq != null) {
            this.rsq.bgX();
          }
          AppMethodBeat.o(100415);
          return;
        }
        this.rsl.i(this.mSurface);
        if (!d.oD(23)) {
          break label208;
        }
        if (this.mEn)
        {
          this.rsl.start();
          this.mEn = false;
          continue;
        }
        this.mEo = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(100415);
        return;
      }
      this.mEm = 0L;
      this.rsl.setMute(true);
      this.rsl.start();
      continue;
      label208:
      if (this.mEn) {
        d(this.rsl.ejm(), true);
      } else {
        d(this.rsl.ejm(), false);
      }
    }
  }
  
  public final void bLd()
  {
    AppMethodBeat.i(100409);
    Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        Log.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(100409);
        return;
      }
      try
      {
        this.ZA = false;
        this.rsl = new j(Looper.getMainLooper());
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
          AppMethodBeat.o(100409);
          return;
          if (this.rsn) {
            this.rsl.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.rso != null) {
          this.rso.onError(-1, -1);
        }
        AppMethodBeat.o(100409);
        return;
      }
    }
  }
  
  public final void l(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(100416);
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
      Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.KwA.bLh();
      this.KwA = null;
    }
    this.mEm = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */