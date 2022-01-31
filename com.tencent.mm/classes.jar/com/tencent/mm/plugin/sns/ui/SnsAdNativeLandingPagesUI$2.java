package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.ui.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class SnsAdNativeLandingPagesUI$2
  implements a
{
  SnsAdNativeLandingPagesUI$2(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void aE(float paramFloat)
  {
    SnsAdNativeLandingPagesUI.F(this.oUU).setAlpha(1.0F - paramFloat);
  }
  
  public final void onAnimationEnd()
  {
    SnsAdNativeLandingPagesUI.G(this.oUU);
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim end");
    SnsAdNativeLandingPagesUI.f(this.oUU).setVisibility(0);
    SnsAdNativeLandingPagesUI.p(this.oUU);
    SnsAdNativeLandingPagesUI.H(this.oUU);
    if (this.oUU.isSupportNavigationSwipeBack()) {
      this.oUU.getSwipeBackLayout().setEnableGesture(true);
    }
  }
  
  public final void onAnimationStart()
  {
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.2
 * JD-Core Version:    0.7.0.1
 */