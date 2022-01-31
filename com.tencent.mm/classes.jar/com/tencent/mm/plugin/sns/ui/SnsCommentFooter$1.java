package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.e;

final class SnsCommentFooter$1
  implements View.OnClickListener
{
  SnsCommentFooter$1(SnsCommentFooter paramSnsCommentFooter, SnsCommentFooter.b paramb) {}
  
  public final void onClick(View paramView)
  {
    SnsCommentFooter.q(this.oXQ).setImageResource(i.e.chatting_setmode_heart_btn_pressed);
    paramView = new ScaleAnimation(0.9F, 1.3F, 0.9F, 1.3F, 1, 0.5F, 1, 0.5F);
    paramView.setDuration(400L);
    paramView.setStartOffset(100L);
    paramView.setRepeatCount(0);
    SnsCommentFooter.q(this.oXQ).startAnimation(paramView);
    paramView.setAnimationListener(new SnsCommentFooter.1.1(this));
    this.oXP.bIH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.1
 * JD-Core Version:    0.7.0.1
 */