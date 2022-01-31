package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class TopStoryVideoPlayTextureView
  extends VideoPlayerTextureView
{
  private Object lock;
  
  public TopStoryVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(1779);
    this.lock = new Object();
    AppMethodBeat.o(1779);
  }
  
  public TopStoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(1780);
    this.lock = new Object();
    AppMethodBeat.o(1780);
  }
  
  public TopStoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(1781);
    this.lock = new Object();
    AppMethodBeat.o(1781);
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(1787);
    synchronized (this.lock)
    {
      super.A(paramDouble);
      AppMethodBeat.o(1787);
      return;
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1789);
    ab.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurfaceTexture.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.lxH) });
    for (;;)
    {
      try
      {
        dEs();
        super.h(this.mSurface);
        this.mSurface = new Surface(paramSurfaceTexture);
        if ((this.lxw == null) || (!this.Pz))
        {
          boV();
          dpH();
          if (this.lxD != null) {
            this.lxD.alr();
          }
          AppMethodBeat.o(1789);
          return;
        }
        this.lxw.f(this.mSurface);
        if (!com.tencent.mm.compatible.util.d.fv(23)) {
          break label219;
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
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", paramSurfaceTexture, "onSurfaceTextureAvailable failed", new Object[0]);
        AppMethodBeat.o(1789);
        return;
      }
      this.lxy = 0L;
      this.lxw.setMute(true);
      this.lxw.start();
      continue;
      label219:
      if (this.lxH) {
        e(this.lxw.bQz(), true);
      } else {
        e(this.lxw.bQz(), false);
      }
    }
  }
  
  public final void boV()
  {
    AppMethodBeat.i(1783);
    ab.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
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
        ab.w("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video but path is null.", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(1783);
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
          AppMethodBeat.o(1783);
          return;
          if (this.lxz) {
            this.lxw.prepare();
          }
        }
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
        if (this.lxA != null) {
          this.lxA.onError(-1, -1);
        }
        AppMethodBeat.o(1783);
        return;
      }
    }
  }
  
  public final void j(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(1790);
    if ((com.tencent.mm.compatible.util.d.fv(23)) && (this.lxI) && (this.lxy > 0L))
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
      ab.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      this.wfD.bSk();
      this.wfD = null;
    }
    this.lxy = System.currentTimeMillis();
    AppMethodBeat.o(1790);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(1786);
    synchronized (this.lock)
    {
      super.pause();
      AppMethodBeat.o(1786);
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(1788);
    synchronized (this.lock)
    {
      super.setMute(paramBoolean);
      AppMethodBeat.o(1788);
      return;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(1782);
    super.setVideoPath(paramString);
    AppMethodBeat.o(1782);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(1785);
    synchronized (this.lock)
    {
      boolean bool = super.start();
      AppMethodBeat.o(1785);
      return bool;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(1784);
    com.tencent.mm.sdk.g.d.post(new TopStoryVideoPlayTextureView.1(this), "player-stop");
    AppMethodBeat.o(1784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */