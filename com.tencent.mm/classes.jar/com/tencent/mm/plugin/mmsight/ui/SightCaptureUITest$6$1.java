package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.sdk.g.d;

final class SightCaptureUITest$6$1
  implements Runnable
{
  SightCaptureUITest$6$1(SightCaptureUITest.6 param6, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(150451);
    SightCaptureUITest.c(this.oQs.oQq).stopPreview();
    SightCaptureUITest.a(this.oQs.oQq, d.h(new SightCaptureUITest.6.1.1(this), "SightCaptureUI_saveCaptureBitmap"));
    SightCaptureUITest.w(this.oQs.oQq).start();
    SightCaptureUITest.x(this.oQs.oQq).setVisibility(0);
    SightCaptureUITest.x(this.oQs.oQq).setImageBitmap(this.oQr);
    SightCaptureUITest.s(this.oQs.oQq).setVisibility(8);
    SightCaptureUITest.a(this.oQs.oQq, 3);
    SightCaptureUITest.z(this.oQs.oQq).post(new SightCaptureUITest.6.1.2(this));
    AppMethodBeat.o(150451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.6.1
 * JD-Core Version:    0.7.0.1
 */