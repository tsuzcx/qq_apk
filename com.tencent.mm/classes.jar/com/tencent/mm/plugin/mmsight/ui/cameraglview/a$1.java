package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements f
{
  a$1(a parama) {}
  
  public final boolean M(byte[] paramArrayOfByte)
  {
    if (this.mrb.mra != null)
    {
      MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = this.mrb.mra;
      if ((paramArrayOfByte != null) && (localMMSightCameraGLSurfaceView.mrc != null) && (!localMMSightCameraGLSurfaceView.mrc.brU))
      {
        localMMSightCameraGLSurfaceView.mrc.b(paramArrayOfByte, localMMSightCameraGLSurfaceView.fvY, localMMSightCameraGLSurfaceView.fvZ, localMMSightCameraGLSurfaceView.fwu, false);
        localMMSightCameraGLSurfaceView.requestRender();
      }
    }
    else
    {
      return false;
    }
    y.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a.1
 * JD-Core Version:    0.7.0.1
 */