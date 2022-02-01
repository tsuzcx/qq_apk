package com.tencent.scanlib.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$i
  extends b.d
{
  private f ahvH;
  private SurfaceTexture surfaceTexture;
  
  public b$i(f paramf, SurfaceTexture paramSurfaceTexture)
  {
    this.ahvH = paramf;
    this.surfaceTexture = paramSurfaceTexture;
  }
  
  private Void cni()
  {
    AppMethodBeat.i(174588);
    try
    {
      if ((this.ahvH.isOpen()) && (!this.ahvH.boa()))
      {
        Log.i("CameraTask.DefaultStartPreviewTask", "start preview");
        this.ahvH.w(this.surfaceTexture);
      }
      AppMethodBeat.o(174588);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("CameraTask.DefaultStartPreviewTask", "start preview failed! %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.a.b.i
 * JD-Core Version:    0.7.0.1
 */