package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsTimeLineUI$48
  implements Animation.AnimationListener
{
  SnsTimeLineUI$48(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(308306);
    Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
    AppMethodBeat.o(308306);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(308304);
    Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
    AppMethodBeat.o(308304);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(308300);
    Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
    AppMethodBeat.o(308300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.48
 * JD-Core Version:    0.7.0.1
 */