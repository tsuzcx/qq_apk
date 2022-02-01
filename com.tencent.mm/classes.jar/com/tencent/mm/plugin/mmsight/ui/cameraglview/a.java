package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public g iqW;
  MMSightCameraGLSurfaceView zEa;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(94764);
    this.iqW = new g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(94762);
        if (a.this.zEa != null)
        {
          MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = a.this.zEa;
          if ((paramAnonymousArrayOfByte == null) || (localMMSightCameraGLSurfaceView.zEc == null) || (localMMSightCameraGLSurfaceView.zEc.kxV)) {
            break label76;
          }
          localMMSightCameraGLSurfaceView.zEc.b(paramAnonymousArrayOfByte, localMMSightCameraGLSurfaceView.kxW, localMMSightCameraGLSurfaceView.kxX, localMMSightCameraGLSurfaceView.iqx, false);
          localMMSightCameraGLSurfaceView.requestRender();
        }
        for (;;)
        {
          AppMethodBeat.o(94762);
          return false;
          label76:
          Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
        }
      }
    };
    this.zEa = paramMMSightCameraGLSurfaceView;
    AppMethodBeat.o(94764);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94763);
    if (this.zEa != null) {
      this.zEa.e(paramArrayOfByte, paramInt, paramBoolean);
    }
    AppMethodBeat.o(94763);
  }
  
  public final void aEy()
  {
    AppMethodBeat.i(94766);
    if (this.zEa != null) {
      this.zEa.aEy();
    }
    AppMethodBeat.o(94766);
  }
  
  public final void aq(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94765);
    Log.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + paramInt1 + " cameraPreviewHeight : " + paramInt2 + " rotate : " + paramInt3);
    if (this.zEa != null) {
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
      this.zEa.aq(i, paramInt1, paramInt3);
      AppMethodBeat.o(94765);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */