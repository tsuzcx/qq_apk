package com.tencent.mm.plugin.recordvideo.background.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.blur.e;

public final class c
{
  c.b fZL;
  ao handler;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  HandlerThread rZs;
  private int viewportHeight;
  private int viewportWidth;
  public h wny;
  boolean wnz = false;
  
  public c(SurfaceTexture paramSurfaceTexture, h paramh)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.wny = paramh;
  }
  
  public c(Surface paramSurface, h paramh)
  {
    this.mSurface = paramSurface;
    this.wny = paramh;
  }
  
  public final void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(75007);
    ac.i("MicroMsg.Story.GLThread", "postJob");
    if (this.handler == null)
    {
      ac.i("MicroMsg.Story.GLThread", "postJob but handler is null");
      AppMethodBeat.o(75007);
      return;
    }
    this.handler.post(paramRunnable);
    AppMethodBeat.o(75007);
  }
  
  public final void duK()
  {
    AppMethodBeat.i(75010);
    c.a locala = com.tencent.mm.media.j.c.gWJ;
    c.a.a(this.fZL.gWK, this.fZL.eglSurface);
    AppMethodBeat.o(75010);
  }
  
  public final void dz(int paramInt1, int paramInt2)
  {
    this.viewportWidth = paramInt1;
    this.viewportHeight = paramInt2;
    h localh = this.wny;
    localh.mWidth = paramInt1;
    localh.mHeight = paramInt2;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(75008);
    ac.i("MicroMsg.Story.GLThread", "requestRender");
    if (this.handler == null)
    {
      ac.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
      AppMethodBeat.o(75008);
      return;
    }
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75004);
        c localc = c.this;
        ac.i("MicroMsg.Story.GLThread", "draw");
        if (localc.wny != null) {
          localc.wny.onDrawFrame();
        }
        localc.duK();
        AppMethodBeat.o(75004);
      }
    });
    AppMethodBeat.o(75008);
  }
  
  public final void setFrameRate(int paramInt)
  {
    long l = 1000 / paramInt;
    this.wny.woo = l;
  }
  
  public final void start()
  {
    AppMethodBeat.i(75006);
    this.rZs = d.gy("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.rZs.start();
    this.handler = new ao(this.rZs.getLooper());
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75003);
        Object localObject1 = c.this;
        ac.i("MicroMsg.Story.GLThread", "initGL");
        Object localObject2 = com.tencent.mm.media.j.c.gWJ;
        ((c)localObject1).fZL = c.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
        if (((c)localObject1).wny != null)
        {
          localObject1 = ((c)localObject1).wny;
          ac.i(h.TAG, "initGL");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          ((h)localObject1).wop.wnV = ((h)localObject1).wor;
          localObject2 = ((h)localObject1).wop;
          ((g)localObject2).wnU.duI();
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          e locale = ((g)localObject2).rbR;
          if (locale != null) {
            locale.destroy();
          }
          ((g)localObject2).rbR = new e(ai.getContext());
          ((h)localObject1).duP();
          ((h)localObject1).woq.duI();
        }
        ac.i("MicroMsg.Story.GLThread", "initGL succ");
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
      ac.i("MicroMsg.Story.GLThread", "stop but handler is null");
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
        ac.i("MicroMsg.Story.GLThread", "destoryGL");
        c.a locala = com.tencent.mm.media.j.c.gWJ;
        c.a.a(localc.fZL);
        localc.rZs.quit();
        localc.wny.duP();
        AppMethodBeat.o(75005);
      }
    });
    AppMethodBeat.o(75009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.c
 * JD-Core Version:    0.7.0.1
 */