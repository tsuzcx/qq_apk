package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class SightCaptureUI$26
  implements View.OnClickListener
{
  SightCaptureUI$26(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    if (SightCaptureUI.e(this.mqB) == 4) {
      SightCaptureUI.s(this.mqB);
    }
    while (SightCaptureUI.e(this.mqB) != 3) {
      return;
    }
    SightCaptureUI.t(this.mqB);
    SightCaptureUI.a(this.mqB, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.26
 * JD-Core Version:    0.7.0.1
 */