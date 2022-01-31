package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$7
  implements b
{
  SightCaptureUI$7(SightCaptureUI paramSightCaptureUI) {}
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramSurfaceTexture });
    SightCaptureUI.a(this.mqB, paramSurfaceTexture);
    if (SightCaptureUI.I(this.mqB))
    {
      SightCaptureUI.g(this.mqB, 1);
      return;
    }
    SightCaptureUI.g(this.mqB, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.7
 * JD-Core Version:    0.7.0.1
 */