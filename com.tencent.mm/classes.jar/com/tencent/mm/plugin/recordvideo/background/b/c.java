package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.blur.e;

public final class c
{
  c.b gth;
  ap handler;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  HandlerThread sWo;
  private int viewportHeight;
  private int viewportWidth;
  public h xvo;
  boolean xvp = false;
  
  public c(SurfaceTexture paramSurfaceTexture, h paramh)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.xvo = paramh;
  }
  
  public c(Surface paramSurface, h paramh)
  {
    this.mSurface = paramSurface;
    this.xvo = paramh;
  }
  
  public final void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(75007);
    ad.i("MicroMsg.Story.GLThread", "postJob");
    if (this.handler == null)
    {
      ad.i("MicroMsg.Story.GLThread", "postJob but handler is null");
      AppMethodBeat.o(75007);
      return;
    }
    this.handler.post(paramRunnable);
    AppMethodBeat.o(75007);
  }
  
  public final void dB(int paramInt1, int paramInt2)
  {
    this.viewportWidth = paramInt1;
    this.viewportHeight = paramInt2;
    h localh = this.xvo;
    localh.mWidth = paramInt1;
    localh.mHeight = paramInt2;
  }
  
  public final void dFg()
  {
    AppMethodBeat.i(75010);
    c.a locala = com.tencent.mm.media.k.c.hoP;
    c.a.a(this.gth.hoQ, this.gth.eglSurface);
    AppMethodBeat.o(75010);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(75008);
    ad.i("MicroMsg.Story.GLThread", "requestRender");
    if (this.handler == null)
    {
      ad.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
      AppMethodBeat.o(75008);
      return;
    }
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75004);
        c localc = c.this;
        ad.i("MicroMsg.Story.GLThread", "draw");
        if (localc.xvo != null) {
          localc.xvo.onDrawFrame();
        }
        localc.dFg();
        AppMethodBeat.o(75004);
      }
    });
    AppMethodBeat.o(75008);
  }
  
  public final void setFrameRate(int paramInt)
  {
    long l = 1000 / paramInt;
    this.xvo.xwe = l;
  }
  
  public final void start()
  {
    AppMethodBeat.i(75006);
    this.sWo = d.gW("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.sWo.start();
    this.handler = new ap(this.sWo.getLooper());
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75003);
        Object localObject1 = c.this;
        ad.i("MicroMsg.Story.GLThread", "initGL");
        Object localObject2 = com.tencent.mm.media.k.c.hoP;
        ((c)localObject1).gth = c.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
        if (((c)localObject1).xvo != null)
        {
          localObject1 = ((c)localObject1).xvo;
          ad.i(h.TAG, "initGL");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          ((h)localObject1).xwf.xvL = ((h)localObject1).xwh;
          localObject2 = ((h)localObject1).xwf;
          ((g)localObject2).xvK.dFe();
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          e locale = ((g)localObject2).rOE;
          if (locale != null) {
            locale.destroy();
          }
          ((g)localObject2).rOE = new e(aj.getContext());
          ((h)localObject1).dFl();
          ((h)localObject1).xwg.dFe();
        }
        ad.i("MicroMsg.Story.GLThread", "initGL succ");
        AppMethodBeat.o(75003);
      }
    });
    AppMethodBeat.o(75006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(75009);
    if (this.handler == null)
    {
      ad.i("MicroMsg.Story.GLThread", "stop but handler is null");
      AppMethodBeat.o(75009);
      return;
    }
    this.handler.removeCallbacksAndMessages(null);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75005);
        c localc = c.this;
        ad.i("MicroMsg.Story.GLThread", "destoryGL");
        c.a locala = com.tencent.mm.media.k.c.hoP;
        c.a.a(localc.gth);
        localc.sWo.quit();
        localc.xvo.dFl();
        AppMethodBeat.o(75005);
      }
    });
    AppMethodBeat.o(75009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.c
 * JD-Core Version:    0.7.0.1
 */