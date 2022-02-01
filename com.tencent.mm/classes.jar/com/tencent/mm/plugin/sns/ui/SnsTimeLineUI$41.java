package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class SnsTimeLineUI$41
  implements Animation.AnimationListener
{
  SnsTimeLineUI$41(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(198437);
    ad.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
    AppMethodBeat.o(198437);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(198436);
    ad.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
    AppMethodBeat.o(198436);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(198435);
    ad.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
    AppMethodBeat.o(198435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.41
 * JD-Core Version:    0.7.0.1
 */