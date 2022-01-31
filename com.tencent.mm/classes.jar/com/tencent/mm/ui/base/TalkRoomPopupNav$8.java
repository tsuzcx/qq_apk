package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public final class TalkRoomPopupNav$8
  implements Animation.AnimationListener
{
  public TalkRoomPopupNav$8(TalkRoomPopupNav paramTalkRoomPopupNav) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (TalkRoomPopupNav.f(this.vbD) != null) {
      TalkRoomPopupNav.g(this.vbD).startAnimation(TalkRoomPopupNav.f(this.vbD));
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav.8
 * JD-Core Version:    0.7.0.1
 */