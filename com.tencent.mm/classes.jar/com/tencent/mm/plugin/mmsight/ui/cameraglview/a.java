package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public g hcz;
  MMSightCameraGLSurfaceView uUn;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(94764);
    this.hcz = new g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(94762);
        if (a.this.uUn != null)
        {
          MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = a.this.uUn;
          if ((paramAnonymousArrayOfByte == null) || (localMMSightCameraGLSurfaceView.uUp == null) || (localMMSightCameraGLSurfaceView.uUp.jbi)) {
            break label76;
          }
          localMMSightCameraGLSurfaceView.uUp.b(paramAnonymousArrayOfByte, localMMSightCameraGLSurfaceView.jbj, localMMSightCameraGLSurfaceView.jbk, localMMSightCameraGLSurfaceView.hbZ, false);
          localMMSightCameraGLSurfaceView.requestRender();
        }
        for (;;)
        {
          AppMethodBeat.o(94762);
          return false;
          label76:
          ac.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
        }
      }
    };
    this.uUn = paramMMSightCameraGLSurfaceView;
    AppMethodBeat.o(94764);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94763);
    if (this.uUn != null) {
      this.uUn.e(paramArrayOfByte, paramInt, paramBoolean);
    }
    AppMethodBeat.o(94763);
  }
  
  public final void ajB()
  {
    AppMethodBeat.i(94766);
    if (this.uUn != null) {
      this.uUn.ajB();
    }
    AppMethodBeat.o(94766);
  }
  
  public final void al(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94765);
    ac.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + paramInt1 + " cameraPreviewHeight : " + paramInt2 + " rotate : " + paramInt3);
    if (this.uUn != null) {
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
      this.uUn.al(i, paramInt1, paramInt3);
      AppMethodBeat.o(94765);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */