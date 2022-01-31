package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentDetailUI$35
  implements Animation.AnimationListener
{
  boolean rPJ = false;
  
  SnsCommentDetailUI$35(SnsCommentDetailUI paramSnsCommentDetailUI, LinearLayout paramLinearLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(38819);
    if (this.rPK != null) {
      this.rPK.setPressed(false);
    }
    if (!this.rPJ)
    {
      this.rPJ = true;
      if (SnsCommentDetailUI.E(this.rPu) != null)
      {
        SnsCommentDetailUI.E(this.rPu).clearAnimation();
        SnsCommentDetailUI.E(this.rPu).setVisibility(8);
      }
    }
    AppMethodBeat.o(38819);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.35
 * JD-Core Version:    0.7.0.1
 */