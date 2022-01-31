package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.ui.widget.a.d;

final class SnsAdNativeLandingPagesUI$17
  implements View.OnClickListener
{
  SnsAdNativeLandingPagesUI$17(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new d(this.oUU, 1, false);
    paramView.phH = new SnsAdNativeLandingPagesUI.17.1(this);
    paramView.wmU = new SnsAdNativeLandingPagesUI.17.2(this);
    paramView.phI = new SnsAdNativeLandingPagesUI.17.3(this);
    if (SnsAdNativeLandingPagesUI.C(this.oUU)) {
      paramView.rxb = true;
    }
    if (!SnsAdNativeLandingPagesUI.D(this.oUU))
    {
      this.oUU.XM();
      SnsAdNativeLandingPagesUI.E(this.oUU).postDelayed(new SnsAdNativeLandingPagesUI.17.4(this, paramView), 300L);
      return;
    }
    paramView.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.17
 * JD-Core Version:    0.7.0.1
 */