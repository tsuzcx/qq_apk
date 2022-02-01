package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  MMSightCameraGLSurfaceView Lew;
  public g nKM;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(94764);
    this.nKM = new g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(94762);
        if (a.this.Lew != null)
        {
          MMSightCameraGLSurfaceView localMMSightCameraGLSurfaceView = a.this.Lew;
          if ((paramAnonymousArrayOfByte == null) || (localMMSightCameraGLSurfaceView.Ley == null) || (localMMSightCameraGLSurfaceView.Ley.qpC)) {
            break label76;
          }
          localMMSightCameraGLSurfaceView.Ley.b(paramAnonymousArrayOfByte, localMMSightCameraGLSurfaceView.qpD, localMMSightCameraGLSurfaceView.qpE, localMMSightCameraGLSurfaceView.nKn, false);
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
    this.Lew = paramMMSightCameraGLSurfaceView;
    AppMethodBeat.o(94764);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94763);
    if (this.Lew != null) {
      this.Lew.e(paramArrayOfByte, paramInt, paramBoolean);
    }
    AppMethodBeat.o(94763);
  }
  
  public final void aT(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94765);
    Log.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + paramInt1 + " cameraPreviewHeight : " + paramInt2 + " rotate : " + paramInt3);
    if (this.Lew != null) {
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
      this.Lew.aT(i, paramInt1, paramInt3);
      AppMethodBeat.o(94765);
      return;
    }
  }
  
  public final void bgx()
  {
    AppMethodBeat.i(94766);
    if (this.Lew != null) {
      this.Lew.bgx();
    }
    AppMethodBeat.o(94766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */