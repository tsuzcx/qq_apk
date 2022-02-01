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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.blur.e;

public final class c
{
  c.b gvO;
  aq handler;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  HandlerThread thB;
  private int viewportHeight;
  private int viewportWidth;
  public h xLl;
  boolean xLm = false;
  
  public c(SurfaceTexture paramSurfaceTexture, h paramh)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.xLl = paramh;
  }
  
  public c(Surface paramSurface, h paramh)
  {
    this.mSurface = paramSurface;
    this.xLl = paramh;
  }
  
  public final void an(Runnable paramRunnable)
  {
    AppMethodBeat.i(75007);
    ae.i("MicroMsg.Story.GLThread", "postJob");
    if (this.handler == null)
    {
      ae.i("MicroMsg.Story.GLThread", "postJob but handler is null");
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
    h localh = this.xLl;
    localh.mWidth = paramInt1;
    localh.mHeight = paramInt2;
  }
  
  public final void dIx()
  {
    AppMethodBeat.i(75010);
    c.a locala = com.tencent.mm.media.k.c.hrD;
    c.a.a(this.gvO.hrE, this.gvO.eglSurface);
    AppMethodBeat.o(75010);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(75008);
    ae.i("MicroMsg.Story.GLThread", "requestRender");
    if (this.handler == null)
    {
      ae.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
      AppMethodBeat.o(75008);
      return;
    }
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75004);
        c localc = c.this;
        ae.i("MicroMsg.Story.GLThread", "draw");
        if (localc.xLl != null) {
          localc.xLl.onDrawFrame();
        }
        localc.dIx();
        AppMethodBeat.o(75004);
      }
    });
    AppMethodBeat.o(75008);
  }
  
  public final void setFrameRate(int paramInt)
  {
    long l = 1000 / paramInt;
    this.xLl.xMb = l;
  }
  
  public final void start()
  {
    AppMethodBeat.i(75006);
    this.thB = d.hf("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.thB.start();
    this.handler = new aq(this.thB.getLooper());
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75003);
        Object localObject1 = c.this;
        ae.i("MicroMsg.Story.GLThread", "initGL");
        Object localObject2 = com.tencent.mm.media.k.c.hrD;
        ((c)localObject1).gvO = c.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
        if (((c)localObject1).xLl != null)
        {
          localObject1 = ((c)localObject1).xLl;
          ae.i(h.TAG, "initGL");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          ((h)localObject1).xMc.xLI = ((h)localObject1).xMe;
          localObject2 = ((h)localObject1).xMc;
          ((g)localObject2).xLH.dIv();
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          e locale = ((g)localObject2).rXe;
          if (locale != null) {
            locale.destroy();
          }
          ((g)localObject2).rXe = new e(ak.getContext());
          ((h)localObject1).dIC();
          ((h)localObject1).xMd.dIv();
        }
        ae.i("MicroMsg.Story.GLThread", "initGL succ");
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
      ae.i("MicroMsg.Story.GLThread", "stop but handler is null");
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
        ae.i("MicroMsg.Story.GLThread", "destoryGL");
        c.a locala = com.tencent.mm.media.k.c.hrD;
        c.a.a(localc.gvO);
        localc.thB.quit();
        localc.xLl.dIC();
        AppMethodBeat.o(75005);
      }
    });
    AppMethodBeat.o(75009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.c
 * JD-Core Version:    0.7.0.1
 */