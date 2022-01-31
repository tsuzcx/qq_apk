package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUI$8
  implements b
{
  SightCaptureUI$8(SightCaptureUI paramSightCaptureUI) {}
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(55192);
    ab.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramSurfaceTexture });
    SightCaptureUI.a(this.oQf, paramSurfaceTexture);
    if (SightCaptureUI.J(this.oQf))
    {
      SightCaptureUI.g(this.oQf, 1);
      AppMethodBeat.o(55192);
      return;
    }
    SightCaptureUI.g(this.oQf, 8);
    AppMethodBeat.o(55192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.8
 * JD-Core Version:    0.7.0.1
 */