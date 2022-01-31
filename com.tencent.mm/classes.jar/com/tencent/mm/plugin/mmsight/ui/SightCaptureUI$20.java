package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class SightCaptureUI$20
  implements View.OnClickListener
{
  SightCaptureUI$20(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    if (SightCaptureUI.e(this.mqB) == 3) {
      SightCaptureUI.f(this.mqB);
    }
    while (SightCaptureUI.e(this.mqB) != 4) {
      return;
    }
    SightCaptureUI.g(this.mqB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.20
 * JD-Core Version:    0.7.0.1
 */