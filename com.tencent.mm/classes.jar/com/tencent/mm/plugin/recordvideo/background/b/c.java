package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.blur.e;
import com.tencent.threadpool.c.d;

public final class c
{
  HandlerThread GDF;
  public h NET;
  boolean NEU = false;
  private int dhK;
  private int dhL;
  public MMHandler handler;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  c.b muS;
  
  public c(SurfaceTexture paramSurfaceTexture, h paramh)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.NET = paramh;
  }
  
  public c(Surface paramSurface, h paramh)
  {
    this.mSurface = paramSurface;
    this.NET = paramh;
  }
  
  public final void aM(Runnable paramRunnable)
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
  
  public final void fd(int paramInt1, int paramInt2)
  {
    this.dhK = paramInt1;
    this.dhL = paramInt2;
    h localh = this.NET;
    localh.mWidth = paramInt1;
    localh.mHeight = paramInt2;
  }
  
  public final void gHd()
  {
    AppMethodBeat.i(75010);
    c.a locala = com.tencent.mm.media.util.c.nFs;
    c.a.a(this.muS.nFB, this.muS.eglSurface);
    AppMethodBeat.o(75010);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75006);
    this.GDF = d.jv("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.GDF.start();
    this.handler = new MMHandler(this.GDF.getLooper());
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75003);
        Object localObject1 = c.this;
        Log.i("MicroMsg.Story.GLThread", "initGL");
        Object localObject2 = com.tencent.mm.media.util.c.nFs;
        ((c)localObject1).muS = c.a.a(((c)localObject1).mSurface, ((c)localObject1).mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
        if (((c)localObject1).NET != null)
        {
          localObject1 = ((c)localObject1).NET;
          Log.i(h.TAG, "initGL");
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          ((h)localObject1).NFN.NFt = ((h)localObject1).NFP;
          localObject2 = ((h)localObject1).NFN;
          ((g)localObject2).NFr.gHc();
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          e locale = ((g)localObject2).NFs;
          if (locale != null) {
            locale.destroy();
          }
          ((g)localObject2).NFs = new e(MMApplicationContext.getContext());
          ((h)localObject1).gHi();
          ((h)localObject1).NFO.gHc();
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
        c.a locala = com.tencent.mm.media.util.c.nFs;
        c.a.a(localc.muS);
        localc.GDF.quit();
        localc.NET.gHi();
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