package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class SnsCommentDetailUI$38
  implements Animation.AnimationListener
{
  SnsCommentDetailUI$38(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(198335);
    ad.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
    if (SnsCommentDetailUI.H(this.AbL) != null)
    {
      SnsCommentDetailUI.H(this.AbL).clearAnimation();
      SnsCommentDetailUI.H(this.AbL).setVisibility(8);
    }
    AppMethodBeat.o(198335);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.38
 * JD-Core Version:    0.7.0.1
 */