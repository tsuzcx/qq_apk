package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.a;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;

final class SightCaptureUI$21
  implements b
{
  SightCaptureUI$21(SightCaptureUI paramSightCaptureUI) {}
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(55218);
    SightCaptureUI.e(this.oQf).Xl();
    SightCaptureUI.f(this.oQf).setTextureChangeCallback(null);
    AppMethodBeat.o(55218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.21
 * JD-Core Version:    0.7.0.1
 */