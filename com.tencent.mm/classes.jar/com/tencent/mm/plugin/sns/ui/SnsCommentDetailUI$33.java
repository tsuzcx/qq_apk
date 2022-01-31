package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentDetailUI$33
  implements Animation.AnimationListener
{
  SnsCommentDetailUI$33(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(38816);
    ab.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
    if (SnsCommentDetailUI.E(this.rPu) != null)
    {
      SnsCommentDetailUI.E(this.rPu).clearAnimation();
      SnsCommentDetailUI.E(this.rPu).setVisibility(8);
    }
    AppMethodBeat.o(38816);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.33
 * JD-Core Version:    0.7.0.1
 */