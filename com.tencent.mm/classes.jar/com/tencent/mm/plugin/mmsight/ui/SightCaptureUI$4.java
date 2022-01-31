package com.tencent.mm.plugin.mmsight.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;

final class SightCaptureUI$4
  implements MMSightCaptureTouchView.a
{
  SightCaptureUI$4(SightCaptureUI paramSightCaptureUI) {}
  
  public final void O(float paramFloat1, float paramFloat2)
  {
    if ((SightCaptureUI.e(this.mqB) != 0) && (SightCaptureUI.e(this.mqB) != 3) && (SightCaptureUI.e(this.mqB) != 4) && (SightCaptureUI.w(this.mqB) != null))
    {
      SightCaptureUI.h(this.mqB).b(paramFloat1, paramFloat2, SightCaptureUI.w(this.mqB).getWidth(), SightCaptureUI.w(this.mqB).getHeight());
      SightCaptureUI localSightCaptureUI = this.mqB;
      if (localSightCaptureUI.mpU != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localSightCaptureUI.mpU.getLayoutParams();
        localLayoutParams.leftMargin = ((int)paramFloat1 - localSightCaptureUI.mpU.mWidth / 2);
        localLayoutParams.topMargin = ((int)paramFloat2 - localSightCaptureUI.mpU.mHeight / 2);
        localSightCaptureUI.mpU.setLayoutParams(localLayoutParams);
        localSightCaptureUI.mpU.bjZ();
      }
    }
  }
  
  public final void Zh()
  {
    if ((SightCaptureUI.e(this.mqB) != 0) && (SightCaptureUI.h(this.mqB) != null)) {
      SightCaptureUI.h(this.mqB).c(true, false, 1);
    }
  }
  
  public final void Zi()
  {
    if ((SightCaptureUI.e(this.mqB) != 0) && (SightCaptureUI.h(this.mqB) != null)) {
      SightCaptureUI.h(this.mqB).c(false, false, 1);
    }
  }
  
  public final void aKT()
  {
    if ((SightCaptureUI.e(this.mqB) != 0) && (SightCaptureUI.x(this.mqB) > 1))
    {
      SightCaptureUI.h(this.mqB).aJP();
      SightCaptureUI.r(this.mqB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.4
 * JD-Core Version:    0.7.0.1
 */