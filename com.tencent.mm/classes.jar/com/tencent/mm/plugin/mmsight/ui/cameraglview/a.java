package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public f mqZ = new a.1(this);
  MMSightCameraGLSurfaceView mra;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    this.mra = paramMMSightCameraGLSurfaceView;
  }
  
  public final void P(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mra != null) {
      if ((paramInt3 != 0) && (paramInt3 != 180)) {
        break label98;
      }
    }
    label98:
    for (int i = paramInt1;; i = paramInt2)
    {
      if ((paramInt3 == 0) || (paramInt3 == 180)) {
        paramInt1 = paramInt2;
      }
      MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = this.mra;
      y.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), localMMSightCameraGLSurfaceView });
      localMMSightCameraGLSurfaceView.fvY = i;
      localMMSightCameraGLSurfaceView.fvZ = paramInt1;
      localMMSightCameraGLSurfaceView.fwu = paramInt3;
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    if (this.mra != null)
    {
      MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = this.mra;
      if ((paramArrayOfByte != null) && (localMMSightCameraGLSurfaceView.mrc != null) && (!localMMSightCameraGLSurfaceView.mrc.brU))
      {
        localMMSightCameraGLSurfaceView.mrc.b(paramArrayOfByte, localMMSightCameraGLSurfaceView.fvY, localMMSightCameraGLSurfaceView.fvZ, paramInt, paramBoolean);
        localMMSightCameraGLSurfaceView.requestRender();
      }
    }
    else
    {
      return;
    }
    y.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
  }
  
  public final void aKW()
  {
    if (this.mra != null)
    {
      MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = this.mra;
      if (localMMSightCameraGLSurfaceView.mrc != null)
      {
        localMMSightCameraGLSurfaceView.mrc.fwn = true;
        localMMSightCameraGLSurfaceView.requestRender();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */