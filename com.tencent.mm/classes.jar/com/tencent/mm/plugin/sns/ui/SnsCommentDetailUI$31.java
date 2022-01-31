package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;

final class SnsCommentDetailUI$31
  implements View.OnClickListener
{
  SnsCommentDetailUI$31(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38814);
    if ((SnsCommentDetailUI.x(this.rPu) != null) && (this.rFG.field_likeFlag == 0)) {
      SnsCommentDetailUI.x(this.rPu).lk(this.rFG.field_snsId);
    }
    SnsCommentDetailUI localSnsCommentDetailUI = this.rPu;
    paramView = (LinearLayout)paramView;
    ImageView localImageView = (ImageView)paramView.findViewById(2131827923);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.5F, 0.9F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(400L);
    localScaleAnimation.setStartOffset(100L);
    localScaleAnimation.setRepeatCount(0);
    localImageView.clearAnimation();
    localImageView.startAnimation(localScaleAnimation);
    localScaleAnimation.setAnimationListener(new SnsCommentDetailUI.35(localSnsCommentDetailUI, paramView));
    SnsCommentDetailUI.F(this.rPu);
    AppMethodBeat.o(38814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.31
 * JD-Core Version:    0.7.0.1
 */