package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.b;

final class SightCaptureUI$2
  implements View.OnClickListener
{
  SightCaptureUI$2(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    if (SightCaptureUI.u(this.mqB) != null) {
      SightCaptureUI.u(this.mqB).zE();
    }
    SightCaptureUI.q(this.mqB);
    SightCaptureUI.a(this.mqB, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.2
 * JD-Core Version:    0.7.0.1
 */