package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.e;

final class SnsCommentFooter$1$1
  implements Animation.AnimationListener
{
  SnsCommentFooter$1$1(SnsCommentFooter.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    SnsCommentFooter.q(this.oXR.oXQ).setImageResource(i.e.chatting_setmode_heart_btn);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.1.1
 * JD-Core Version:    0.7.0.1
 */