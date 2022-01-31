package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.R.a;

public final class TalkRoomPopupNav$4
  implements Animation.AnimationListener
{
  public TalkRoomPopupNav$4(TalkRoomPopupNav paramTalkRoomPopupNav) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    TalkRoomPopupNav.c(this.vbD).startAnimation(AnimationUtils.loadAnimation(this.vbD.getContext(), R.a.fast_faded_in));
    TalkRoomPopupNav.c(this.vbD).setVisibility(0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav.4
 * JD-Core Version:    0.7.0.1
 */