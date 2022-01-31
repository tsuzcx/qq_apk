package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public f fbW;
  MMSightCameraGLSurfaceView oQO;
  
  public a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(55311);
    this.fbW = new a.1(this);
    this.oQO = paramMMSightCameraGLSurfaceView;
    AppMethodBeat.o(55311);
  }
  
  public final void Xl()
  {
    AppMethodBeat.i(55313);
    if (this.oQO != null) {
      this.oQO.Xl();
    }
    AppMethodBeat.o(55313);
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(55310);
    if (this.oQO != null) {
      this.oQO.g(paramArrayOfByte, paramInt, paramBoolean);
    }
    AppMethodBeat.o(55310);
  }
  
  public final void aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(55312);
    ab.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + paramInt1 + " cameraPreviewHeight : " + paramInt2 + " rotate : " + paramInt3);
    if (this.oQO != null) {
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
      this.oQO.aa(i, paramInt1, paramInt3);
      AppMethodBeat.o(55312);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.a
 * JD-Core Version:    0.7.0.1
 */