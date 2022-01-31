package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements f
{
  a$1(a parama) {}
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55309);
    if (this.oQP.oQO != null)
    {
      MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = this.oQP.oQO;
      if ((paramArrayOfByte == null) || (localMMSightCameraGLSurfaceView.oQQ == null) || (localMMSightCameraGLSurfaceView.oQQ.gNz)) {
        break label76;
      }
      localMMSightCameraGLSurfaceView.oQQ.b(paramArrayOfByte, localMMSightCameraGLSurfaceView.gNA, localMMSightCameraGLSurfaceView.gNB, localMMSightCameraGLSurfaceView.fbz, false);
      localMMSightCameraGLSurfaceView.requestRender();
    }
    for (;;)
    {
      AppMethodBeat.o(55309);
      return false;
      label76:
      ab.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a.1
 * JD-Core Version:    0.7.0.1
 */