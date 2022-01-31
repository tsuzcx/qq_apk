package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class SnsCommentDetailUI$33
  implements Animation.AnimationListener
{
  boolean oXl = false;
  
  SnsCommentDetailUI$33(SnsCommentDetailUI paramSnsCommentDetailUI, LinearLayout paramLinearLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.oXm != null) {
      this.oXm.setPressed(false);
    }
    if (!this.oXl)
    {
      this.oXl = true;
      if (SnsCommentDetailUI.F(this.oWW) != null)
      {
        SnsCommentDetailUI.F(this.oWW).clearAnimation();
        SnsCommentDetailUI.F(this.oWW).setVisibility(8);
      }
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.33
 * JD-Core Version:    0.7.0.1
 */