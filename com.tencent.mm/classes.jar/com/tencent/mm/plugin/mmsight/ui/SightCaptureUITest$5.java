package com.tencent.mm.plugin.mmsight.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;

final class SightCaptureUITest$5
  implements MMSightCaptureTouchView.a
{
  SightCaptureUITest$5(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150445);
    if ((SightCaptureUITest.e(this.oQq) != 0) && (SightCaptureUITest.e(this.oQq) != 3) && (SightCaptureUITest.e(this.oQq) != 4) && (SightCaptureUITest.s(this.oQq) != null))
    {
      SightCaptureUITest.c(this.oQq).b(paramFloat1, paramFloat2, SightCaptureUITest.s(this.oQq).getWidth(), SightCaptureUITest.s(this.oQq).getHeight());
      SightCaptureUITest localSightCaptureUITest = this.oQq;
      if (localSightCaptureUITest.oPu != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localSightCaptureUITest.oPu.getLayoutParams();
        localLayoutParams.leftMargin = ((int)paramFloat1 - localSightCaptureUITest.oPu.mWidth / 2);
        localLayoutParams.topMargin = ((int)paramFloat2 - localSightCaptureUITest.oPu.mHeight / 2);
        localSightCaptureUITest.oPu.setLayoutParams(localLayoutParams);
        localSightCaptureUITest.oPu.bRM();
      }
    }
    AppMethodBeat.o(150445);
  }
  
  public final void asQ()
  {
    AppMethodBeat.i(150447);
    if ((SightCaptureUITest.e(this.oQq) != 0) && (SightCaptureUITest.c(this.oQq) != null)) {
      SightCaptureUITest.c(this.oQq).a(true, false, 1);
    }
    AppMethodBeat.o(150447);
  }
  
  public final void asR()
  {
    AppMethodBeat.i(150448);
    if ((SightCaptureUITest.e(this.oQq) != 0) && (SightCaptureUITest.c(this.oQq) != null)) {
      SightCaptureUITest.c(this.oQq).a(false, false, 1);
    }
    AppMethodBeat.o(150448);
  }
  
  public final void bpb()
  {
    AppMethodBeat.i(150446);
    if ((SightCaptureUITest.e(this.oQq) != 0) && (SightCaptureUITest.t(this.oQq) > 1))
    {
      SightCaptureUITest.c(this.oQq).WW();
      SightCaptureUITest.c(this.oQq).WN();
    }
    AppMethodBeat.o(150446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.5
 * JD-Core Version:    0.7.0.1
 */