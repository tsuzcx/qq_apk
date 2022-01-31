package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class SnsCommentDetailUI$32
  implements Animation.AnimationListener
{
  SnsCommentDetailUI$32(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
    if (SnsCommentDetailUI.F(this.oWW) != null)
    {
      SnsCommentDetailUI.F(this.oWW).clearAnimation();
      SnsCommentDetailUI.F(this.oWW).setVisibility(8);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.32
 * JD-Core Version:    0.7.0.1
 */