package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentDetailUI$39
  implements Animation.AnimationListener
{
  boolean Ace = false;
  
  SnsCommentDetailUI$39(SnsCommentDetailUI paramSnsCommentDetailUI, LinearLayout paramLinearLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(198336);
    if (this.Acf != null) {
      this.Acf.setPressed(false);
    }
    if (!this.Ace)
    {
      this.Ace = true;
      if (SnsCommentDetailUI.H(this.AbL) != null)
      {
        SnsCommentDetailUI.H(this.AbL).clearAnimation();
        SnsCommentDetailUI.H(this.AbL).setVisibility(8);
      }
    }
    AppMethodBeat.o(198336);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.39
 * JD-Core Version:    0.7.0.1
 */