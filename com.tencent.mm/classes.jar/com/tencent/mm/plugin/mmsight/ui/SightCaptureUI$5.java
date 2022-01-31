package com.tencent.mm.plugin.mmsight.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.e.c;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;

final class SightCaptureUI$5
  implements MMSightCaptureTouchView.a
{
  SightCaptureUI$5(SightCaptureUI paramSightCaptureUI) {}
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55184);
    if ((SightCaptureUI.g(this.oQf) != 0) && (SightCaptureUI.g(this.oQf) != 3) && (SightCaptureUI.g(this.oQf) != 4) && (SightCaptureUI.x(this.oQf) != null))
    {
      SightCaptureUI.j(this.oQf).b(paramFloat1, paramFloat2, SightCaptureUI.x(this.oQf).getWidth(), SightCaptureUI.x(this.oQf).getHeight());
      SightCaptureUI localSightCaptureUI = this.oQf;
      if (localSightCaptureUI.oPu != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localSightCaptureUI.oPu.getLayoutParams();
        localLayoutParams.leftMargin = ((int)paramFloat1 - localSightCaptureUI.oPu.mWidth / 2);
        localLayoutParams.topMargin = ((int)paramFloat2 - localSightCaptureUI.oPu.mHeight / 2);
        localSightCaptureUI.oPu.setLayoutParams(localLayoutParams);
        localSightCaptureUI.oPu.bRM();
      }
    }
    AppMethodBeat.o(55184);
  }
  
  public final void asQ()
  {
    AppMethodBeat.i(55186);
    if ((SightCaptureUI.g(this.oQf) != 0) && (SightCaptureUI.j(this.oQf) != null)) {
      SightCaptureUI.j(this.oQf).d(true, false, 1);
    }
    AppMethodBeat.o(55186);
  }
  
  public final void asR()
  {
    AppMethodBeat.i(55187);
    if ((SightCaptureUI.g(this.oQf) != 0) && (SightCaptureUI.j(this.oQf) != null)) {
      SightCaptureUI.j(this.oQf).d(false, false, 1);
    }
    AppMethodBeat.o(55187);
  }
  
  public final void bpb()
  {
    AppMethodBeat.i(55185);
    if ((SightCaptureUI.g(this.oQf) != 0) && (SightCaptureUI.y(this.oQf) > 1))
    {
      SightCaptureUI.j(this.oQf).oHo.removeMessages(4354);
      SightCaptureUI.d(this.oQf);
    }
    AppMethodBeat.o(55185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.5
 * JD-Core Version:    0.7.0.1
 */