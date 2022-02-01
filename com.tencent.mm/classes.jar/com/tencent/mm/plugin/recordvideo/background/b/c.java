package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.blur.e;

public final class c
{
  HandlerThread Bbu;
  public h HHA;
  boolean HHB = false;
  private int bnQ;
  private int bnR;
  MMHandler handler;
  c.b jUB;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  
  public c(SurfaceTexture paramSurfaceTexture, h paramh)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.HHA = paramh;
  }
  
  public c(Surface paramSurface, h paramh)
  {
    this.mSurface = paramSurface;
    this.HHA = paramh;
  }
  
  public final void aD(Runnable paramRunnable)
  {
    AppMethodBeat.i(75007);
    Log.i("MicroMsg.Story.GLThread", "postJob");
    if (this.handler == null)
    {
      Log.i("MicroMsg.Story.GLThread", "postJob but handler is null");
      AppMethodBeat.o(75007);
      return;
    }
    this.handler.post(paramRunnable);
    AppMethodBeat.o(75007);
  }
  
  public final void ej(int paramInt1, int paramInt2)
  {
    this.bnQ = paramInt1;
    this.bnR = paramInt2;
    h localh = this.HHA;
    localh.mWidth = paramInt1;
    localh.mHeight = paramInt2;
  }
  
  public final void fvn()
  {
    AppMethodBeat.i(75010);
    c.a locala = com.tencent.mm.media.k.c.lar;
    c.a.a(this.jUB.las, this.jUB.eglSurface);
    AppMethodBeat.o(75010);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(75008);
    Log.i("MicroMsg.Story.GLThread", "requestRender");
    if (this.handler == null)
    {
      Log.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
      AppMethodBeat.o(75008);
      return;
    }
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75004);
        c localc = c.this;
        Log.i("MicroMsg.Story.GLThread", "draw");
        if (localc.HHA != null) {
          localc.HHA.onDrawFrame();
        }
        localc.fvn();
        AppMethodBeat.o(75004);
      }
    });
    AppMethodBeat.o(75008);
  }
  
  public final void setFrameRate(int paramInt)
  {
    long l = 1000 / paramInt;
    this.HHA.HIt = l;
  }
  
  public final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(216984);
    if (this.jUB != null) {
      EGLExt.eglPresentationTimeANDROID(this.jUB.las, this.jUB.eglSurface, paramLong);
    }
    AppMethodBeat.o(216984);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75006);
    this.Bbu = d.ij("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.Bbu.start();
    this.handler = new MMHandler(this.Bbu.getLooper());
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75003);
        Object localObject1 = c.this;
        Log.i("MicroMsg.Story.GLThread", "initGL");
        Object localObject2 = com.tencent.mm.media.k.c.lar;
        ((c)localObject1).jUB = c.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
        if (((c)localObject1).HHA != null)
        {
          localObject1 = ((c)localObject1).HHA;
          Log.i(h.TAG, "initGL");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          ((h)localObject1).HIu.HIa = ((h)localObject1).HIw;
          localObject2 = ((h)localObject1).HIu;
          ((g)localObject2).HHY.fvl();
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          e locale = ((g)localObject2).HHZ;
          if (locale != null) {
            locale.destroy();
          }
          ((g)localObject2).HHZ = new e(MMApplicationContext.getContext());
          ((h)localObject1).fvs();
          ((h)localObject1).HIv.fvl();
        }
        Log.i("MicroMsg.Story.GLThread", "initGL succ");
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
      Log.i("MicroMsg.Story.GLThread", "stop but handler is null");
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
        Log.i("MicroMsg.Story.GLThread", "destoryGL");
        c.a locala = com.tencent.mm.media.k.c.lar;
        c.a.a(localc.jUB);
        localc.Bbu.quit();
        localc.HHA.fvs();
        AppMethodBeat.o(75005);
      }
    });
    AppMethodBeat.o(75009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.c
 * JD-Core Version:    0.7.0.1
 */