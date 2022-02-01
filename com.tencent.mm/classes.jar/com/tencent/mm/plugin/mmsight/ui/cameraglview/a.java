package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public g gCb;
  MMSightCameraGLSurfaceView tLJ;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(94764);
    this.gCb = new g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(94762);
        if (a.this.tLJ != null)
        {
          MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = a.this.tLJ;
          if ((paramAnonymousArrayOfByte == null) || (localMMSightCameraGLSurfaceView.tLL == null) || (localMMSightCameraGLSurfaceView.tLL.iBh)) {
            break label76;
          }
          localMMSightCameraGLSurfaceView.tLL.b(paramAnonymousArrayOfByte, localMMSightCameraGLSurfaceView.iBi, localMMSightCameraGLSurfaceView.iBj, localMMSightCameraGLSurfaceView.gBD, false);
          localMMSightCameraGLSurfaceView.requestRender();
        }
        for (;;)
        {
          AppMethodBeat.o(94762);
          return false;
          label76:
          ad.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
        }
      }
    };
    this.tLJ = paramMMSightCameraGLSurfaceView;
    AppMethodBeat.o(94764);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94763);
    if (this.tLJ != null) {
      this.tLJ.e(paramArrayOfByte, paramInt, paramBoolean);
    }
    AppMethodBeat.o(94763);
  }
  
  public final void aj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94765);
    ad.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + paramInt1 + " cameraPreviewHeight : " + paramInt2 + " rotate : " + paramInt3);
    if (this.tLJ != null) {
      if ((paramInt3 != 0) && (paramInt3 != 180)) {
        break label95;
      }
    }
    label95:
    for (int i = paramInt1;; i = paramInt2)
    {
      if ((paramInt3 == 0) || (paramInt3 == 180)) {
        paramInt1 = paramInt2;
      }
      this.tLJ.aj(i, paramInt1, paramInt3);
      AppMethodBeat.o(94765);
      return;
    }
  }
  
  public final void anT()
  {
    AppMethodBeat.i(94766);
    if (this.tLJ != null) {
      this.tLJ.anT();
    }
    AppMethodBeat.o(94766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */