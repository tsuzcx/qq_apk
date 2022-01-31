package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

public final class TalkRoomPopupNav$5
  implements Animation.AnimationListener
{
  public TalkRoomPopupNav$5(TalkRoomPopupNav paramTalkRoomPopupNav) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    TalkRoomPopupNav.d(this.vbD).setVisibility(8);
    TalkRoomPopupNav.d(this.vbD).setClickable(false);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav.5
 * JD-Core Version:    0.7.0.1
 */