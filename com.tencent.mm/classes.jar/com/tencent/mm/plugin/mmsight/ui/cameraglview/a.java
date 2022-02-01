package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public g hxv;
  MMSightCameraGLSurfaceView wjB;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(94764);
    this.hxv = new g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(94762);
        if (a.this.wjB != null)
        {
          MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = a.this.wjB;
          if ((paramAnonymousArrayOfByte == null) || (localMMSightCameraGLSurfaceView.wjD == null) || (localMMSightCameraGLSurfaceView.wjD.jxm)) {
            break label76;
          }
          localMMSightCameraGLSurfaceView.wjD.b(paramAnonymousArrayOfByte, localMMSightCameraGLSurfaceView.jxn, localMMSightCameraGLSurfaceView.jxo, localMMSightCameraGLSurfaceView.hwV, false);
          localMMSightCameraGLSurfaceView.requestRender();
        }
        for (;;)
        {
          AppMethodBeat.o(94762);
          return false;
          label76:
          ae.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
        }
      }
    };
    this.wjB = paramMMSightCameraGLSurfaceView;
    AppMethodBeat.o(94764);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94763);
    if (this.wjB != null) {
      this.wjB.e(paramArrayOfByte, paramInt, paramBoolean);
    }
    AppMethodBeat.o(94763);
  }
  
  public final void al(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94765);
    ae.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + paramInt1 + " cameraPreviewHeight : " + paramInt2 + " rotate : " + paramInt3);
    if (this.wjB != null) {
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
      this.wjB.al(i, paramInt1, paramInt3);
      AppMethodBeat.o(94765);
      return;
    }
  }
  
  public final void amC()
  {
    AppMethodBeat.i(94766);
    if (this.wjB != null) {
      this.wjB.amC();
    }
    AppMethodBeat.o(94766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */