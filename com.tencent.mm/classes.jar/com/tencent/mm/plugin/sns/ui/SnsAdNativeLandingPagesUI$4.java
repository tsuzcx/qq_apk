package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.ui.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class SnsAdNativeLandingPagesUI$4
  implements a
{
  SnsAdNativeLandingPagesUI$4(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void aE(float paramFloat)
  {
    SnsAdNativeLandingPagesUI.F(this.oUU).setAlpha(1.0F - paramFloat);
  }
  
  public final void onAnimationEnd()
  {
    SnsAdNativeLandingPagesUI.G(this.oUU);
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim end");
    this.oUU.finish();
    this.oUU.overridePendingTransition(i.a.anim_not_change, i.a.anim_not_change);
    if (this.oUU.isSupportNavigationSwipeBack()) {
      this.oUU.getSwipeBackLayout().setEnableGesture(true);
    }
  }
  
  public final void onAnimationStart()
  {
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim start");
    SnsAdNativeLandingPagesUI.f(this.oUU).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.4
 * JD-Core Version:    0.7.0.1
 */