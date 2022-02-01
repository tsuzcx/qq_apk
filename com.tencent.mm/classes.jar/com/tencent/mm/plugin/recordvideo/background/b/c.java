package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.blur.e;

public final class c
{
  public h BLp;
  boolean BLq = false;
  MMHandler handler;
  c.b hiD;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  private int viewportHeight;
  private int viewportWidth;
  HandlerThread wpM;
  
  public c(SurfaceTexture paramSurfaceTexture, h paramh)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.BLp = paramh;
  }
  
  public c(Surface paramSurface, h paramh)
  {
    this.mSurface = paramSurface;
    this.BLp = paramh;
  }
  
  public final void ax(Runnable paramRunnable)
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
  
  public final void dL(int paramInt1, int paramInt2)
  {
    this.viewportWidth = paramInt1;
    this.viewportHeight = paramInt2;
    h localh = this.BLp;
    localh.mWidth = paramInt1;
    localh.mHeight = paramInt2;
  }
  
  public final void eJk()
  {
    AppMethodBeat.i(75010);
    c.a locala = com.tencent.mm.media.k.c.ilt;
    c.a.a(this.hiD.ilu, this.hiD.eglSurface);
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
        if (localc.BLp != null) {
          localc.BLp.onDrawFrame();
        }
        localc.eJk();
        AppMethodBeat.o(75004);
      }
    });
    AppMethodBeat.o(75008);
  }
  
  public final void setFrameRate(int paramInt)
  {
    long l = 1000 / paramInt;
    this.BLp.BMh = l;
  }
  
  public final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(237198);
    if (this.hiD != null) {
      EGLExt.eglPresentationTimeANDROID(this.hiD.ilu, this.hiD.eglSurface, paramLong);
    }
    AppMethodBeat.o(237198);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75006);
    this.wpM = d.hz("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.wpM.start();
    this.handler = new MMHandler(this.wpM.getLooper());
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75003);
        Object localObject1 = c.this;
        Log.i("MicroMsg.Story.GLThread", "initGL");
        Object localObject2 = com.tencent.mm.media.k.c.ilt;
        ((c)localObject1).hiD = c.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
        if (((c)localObject1).BLp != null)
        {
          localObject1 = ((c)localObject1).BLp;
          Log.i(h.TAG, "initGL");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          ((h)localObject1).BMi.BLP = ((h)localObject1).BMk;
          localObject2 = ((h)localObject1).BMi;
          ((g)localObject2).BLN.eJi();
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          e locale = ((g)localObject2).BLO;
          if (locale != null) {
            locale.destroy();
          }
          ((g)localObject2).BLO = new e(MMApplicationContext.getContext());
          ((h)localObject1).eJp();
          ((h)localObject1).BMj.eJi();
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
        c.a locala = com.tencent.mm.media.k.c.ilt;
        c.a.a(localc.hiD);
        localc.wpM.quit();
        localc.BLp.eJp();
        AppMethodBeat.o(75005);
      }
    });
    AppMethodBeat.o(75009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.c
 * JD-Core Version:    0.7.0.1
 */