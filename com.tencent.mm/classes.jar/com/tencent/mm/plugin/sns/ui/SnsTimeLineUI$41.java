package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsTimeLineUI$41
  implements Animation.AnimationListener
{
  SnsTimeLineUI$41(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(203701);
    Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
    AppMethodBeat.o(203701);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(203700);
    Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
    AppMethodBeat.o(203700);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(203699);
    Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
    AppMethodBeat.o(203699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.41
 * JD-Core Version:    0.7.0.1
 */