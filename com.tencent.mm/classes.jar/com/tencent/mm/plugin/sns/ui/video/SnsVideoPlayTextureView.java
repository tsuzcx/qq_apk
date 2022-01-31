package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class SnsVideoPlayTextureView
  extends VideoPlayerTextureView
{
  private Object lock;
  
  public SnsVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145760);
    this.lock = new Object();
    AppMethodBeat.o(145760);
  }
  
  public SnsVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145761);
    this.lock = new Object();
    AppMethodBeat.o(145761);
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(145767);
    synchronized (this.lock)
    {
      super.A(paramDouble);
      AppMethodBeat.o(145767);
      return;
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145769);
    ab.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lxH) });
    for (;;)
    {
      try
      {
        dEs();
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.lxw == null) || (!this.Pz))
        {
          boV();
          dpH();
          if (this.lxD != null) {
            this.lxD.alr();
          }
          AppMethodBeat.o(145769);
          return;
        }
        this.lxw.f(this.mSurface);
        if (!d.fv(23)) {
          break label208;
        }
        if (this.lxH)
        {
          this.lxw.start();
          this.lxH = false;
          continue;
        }
        this.lxI = true;
      }
      catch (Exception paramSurfaceTexture)
      {
        ab.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(145769);
        return;
      }
      this.lxy = 0L;
      this.lxw.setMute(true);
      this.lxw.start();
      continue;
      label208:
      if (this.lxH) {
        e(this.lxw.bQz(), true);
      } else {
        e(this.lxw.bQz(), false);
      }
    }
  }
  
  public final void boV()
  {
    AppMethodBeat.i(145763);
    ab.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    synchronized (this.lock)
    {
      if (this.lxw != null)
      {
        this.lxw.oFe = null;
        this.lxw.oFd.stop();
        this.lxw.release();
        this.lxw = null;
      }
      if (bo.isNullOrNil(this.path))
      {
        ab.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(145763);
        return;
      }
      try
      {
        this.Pz = false;
        this.lxw = new i(Looper.getMainLooper());
        this.lxw.setPath(this.path);
        this.lxw.setIOnlineCache(this.oEQ);
        this.lxw.setNeedResetExtractor(this.lxE);
        this.lxw.setIsOnlineVideoType(this.lxF);
        this.lxw.oFe = this.lxK;
        this.lxw.setSurface(this.mSurface);
        this.lxw.jl(this.lxG);
        if (this.mSurface != null) {
          this.lxw.prepare();
        }
        for (;;)
        {
          AppMethodBeat.o(145763);
          return;
          if (this.lxz) {
            this.lxw.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.lxA != null) {
          this.lxA.onError(-1, -1);
        }
        AppMethodBeat.o(145763);
        return;
      }
    }
  }
  
  public final void j(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(145770);
    if ((d.fv(23)) && (this.lxI) && (this.lxy > 0L))
    {
      if (this.lxw != null)
      {
        this.lxw.pause();
        this.lxw.setMute(this.efg);
      }
      this.lxI = false;
    }
    if ((this.lxy > 0L) && (this.wfD != null))
    {
      ab.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.wfD.bSk();
      this.wfD = null;
    }
    this.lxy = System.currentTimeMillis();
    AppMethodBeat.o(145770);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(145766);
    synchronized (this.lock)
    {
      super.pause();
      AppMethodBeat.o(145766);
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(145768);
    synchronized (this.lock)
    {
      super.setMute(paramBoolean);
      AppMethodBeat.o(145768);
      return;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(145762);
    super.setVideoPath(paramString);
    AppMethodBeat.o(145762);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(145765);
    synchronized (this.lock)
    {
      boolean bool = super.start();
      AppMethodBeat.o(145765);
      return bool;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(145764);
    synchronized (this.lock)
    {
      super.stop();
      AppMethodBeat.o(145764);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */