package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class SnsAdNativeLandingPagesUI$6
  implements a
{
  SnsAdNativeLandingPagesUI$6(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void bd(float paramFloat)
  {
    AppMethodBeat.i(38631);
    SnsAdNativeLandingPagesUI.H(this.rMW).setAlpha(1.0F - paramFloat);
    AppMethodBeat.o(38631);
  }
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(38632);
    SnsAdNativeLandingPagesUI.I(this.rMW);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim end");
    SnsAdNativeLandingPagesUI.e(this.rMW).setVisibility(0);
    SnsAdNativeLandingPagesUI.i(this.rMW).setVisibility(0);
    SnsAdNativeLandingPagesUI.q(this.rMW);
    SnsAdNativeLandingPagesUI.J(this.rMW);
    if (this.rMW.isSupportNavigationSwipeBack()) {
      this.rMW.getSwipeBackLayout().setEnableGesture(true);
    }
    AppMethodBeat.o(38632);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(38630);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim start");
    AppMethodBeat.o(38630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.6
 * JD-Core Version:    0.7.0.1
 */