package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class SnsTimeLineUI$27
  implements Animation.AnimationListener
{
  SnsTimeLineUI$27(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    y.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.27
 * JD-Core Version:    0.7.0.1
 */