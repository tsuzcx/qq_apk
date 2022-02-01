package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SnsCommentDetailUI$38
  implements Animation.AnimationListener
{
  SnsCommentDetailUI$38(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(219870);
    ae.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
    if (SnsCommentDetailUI.H(this.AsY) != null)
    {
      SnsCommentDetailUI.H(this.AsY).clearAnimation();
      SnsCommentDetailUI.H(this.AsY).setVisibility(8);
    }
    AppMethodBeat.o(219870);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.38
 * JD-Core Version:    0.7.0.1
 */