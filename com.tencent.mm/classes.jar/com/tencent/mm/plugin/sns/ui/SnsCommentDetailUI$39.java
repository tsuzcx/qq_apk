package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentDetailUI$39
  implements Animation.AnimationListener
{
  boolean Atr = false;
  
  SnsCommentDetailUI$39(SnsCommentDetailUI paramSnsCommentDetailUI, LinearLayout paramLinearLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(219871);
    if (this.Ats != null) {
      this.Ats.setPressed(false);
    }
    if (!this.Atr)
    {
      this.Atr = true;
      if (SnsCommentDetailUI.H(this.AsY) != null)
      {
        SnsCommentDetailUI.H(this.AsY).clearAnimation();
        SnsCommentDetailUI.H(this.AsY).setVisibility(8);
      }
    }
    AppMethodBeat.o(219871);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.39
 * JD-Core Version:    0.7.0.1
 */