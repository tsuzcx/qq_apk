package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class TalkRoomPopupNav$7
  implements Animation.AnimationListener
{
  TalkRoomPopupNav$7(TalkRoomPopupNav paramTalkRoomPopupNav) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    TalkRoomPopupNav.c(this.vbD).setVisibility(4);
    TalkRoomPopupNav.e(this.vbD).setVisibility(4);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav.7
 * JD-Core Version:    0.7.0.1
 */