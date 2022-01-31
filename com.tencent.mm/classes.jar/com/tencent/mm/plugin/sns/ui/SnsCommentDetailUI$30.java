package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.n;

final class SnsCommentDetailUI$30
  implements View.OnClickListener
{
  SnsCommentDetailUI$30(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    if ((SnsCommentDetailUI.E(this.oWW) != null) && (this.oNX.field_likeFlag == 0)) {
      SnsCommentDetailUI.E(this.oWW).fH(this.oNX.field_snsId);
    }
    SnsCommentDetailUI localSnsCommentDetailUI = this.oWW;
    paramView = (LinearLayout)paramView;
    ImageView localImageView = (ImageView)paramView.findViewById(i.f.album_like_icon);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.5F, 0.9F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(400L);
    localScaleAnimation.setStartOffset(100L);
    localScaleAnimation.setRepeatCount(0);
    localImageView.clearAnimation();
    localImageView.startAnimation(localScaleAnimation);
    localScaleAnimation.setAnimationListener(new SnsCommentDetailUI.33(localSnsCommentDetailUI, paramView));
    SnsCommentDetailUI.z(this.oWW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.30
 * JD-Core Version:    0.7.0.1
 */