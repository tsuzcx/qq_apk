package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTimeLineUI$35
  implements Animation.AnimationListener
{
  SnsTimeLineUI$35(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(155745);
    ab.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
    AppMethodBeat.o(155745);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(155744);
    ab.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
    AppMethodBeat.o(155744);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(155743);
    ab.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
    AppMethodBeat.o(155743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.35
 * JD-Core Version:    0.7.0.1
 */