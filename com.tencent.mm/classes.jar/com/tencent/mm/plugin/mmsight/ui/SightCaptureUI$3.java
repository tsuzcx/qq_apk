package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.u.a.a;

final class SightCaptureUI$3
  implements View.OnClickListener
{
  SightCaptureUI$3(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    if (!SightCaptureUI.v(this.mqB)) {
      return;
    }
    this.mqB.finish();
    this.mqB.overridePendingTransition(-1, a.a.sight_slide_bottom_out);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.3
 * JD-Core Version:    0.7.0.1
 */