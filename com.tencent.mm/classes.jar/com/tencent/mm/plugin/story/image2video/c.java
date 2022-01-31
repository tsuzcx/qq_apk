package com.tencent.mm.plugin.story.image2video;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.i.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  ak handler;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  HandlerThread rYn;
  public j ssR;
  b.b ssS;
  private int viewportHeight;
  private int viewportWidth;
  
  public c(SurfaceTexture paramSurfaceTexture, j paramj)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
    this.ssR = paramj;
  }
  
  public c(Surface paramSurface, j paramj)
  {
    this.mSurface = paramSurface;
    this.ssR = paramj;
  }
  
  public final void FD(int paramInt)
  {
    long l = 1000 / paramInt;
    this.ssR.suc = l;
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    this.viewportWidth = paramInt1;
    this.viewportHeight = paramInt2;
    j localj = this.ssR;
    localj.mWidth = paramInt1;
    localj.mHeight = paramInt2;
  }
  
  public final void postJob(Runnable paramRunnable)
  {
    AppMethodBeat.i(150933);
    ab.i("MicroMsg.Story.GLThread", "postJob");
    if (this.handler == null)
    {
      ab.i("MicroMsg.Story.GLThread", "postJob but handler is null");
      AppMethodBeat.o(150933);
      return;
    }
    this.handler.post(paramRunnable);
    AppMethodBeat.o(150933);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(150934);
    ab.i("MicroMsg.Story.GLThread", "requestRender");
    if (this.handler == null)
    {
      ab.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
      AppMethodBeat.o(150934);
      return;
    }
    this.handler.post(new c.2(this));
    AppMethodBeat.o(150934);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150932);
    this.rYn = d.ey("CameraPreviewTextureView_renderThread" + hashCode(), -2);
    this.rYn.start();
    this.handler = new ak(this.rYn.getLooper());
    this.handler.post(new c.1(this));
    AppMethodBeat.o(150932);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(150935);
    if (this.handler == null)
    {
      ab.i("MicroMsg.Story.GLThread", "stop but handler is null");
      AppMethodBeat.o(150935);
      return;
    }
    this.handler.removeCallbacksAndMessages(null);
    this.handler.post(new c.3(this));
    AppMethodBeat.o(150935);
  }
  
  public final void swapBuffers()
  {
    AppMethodBeat.i(150936);
    b.a locala = b.eZw;
    b.a.a(this.ssS.eZx, this.ssS.eZy);
    AppMethodBeat.o(150936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.c
 * JD-Core Version:    0.7.0.1
 */