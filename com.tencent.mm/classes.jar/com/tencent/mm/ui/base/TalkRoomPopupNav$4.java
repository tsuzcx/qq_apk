package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TalkRoomPopupNav$4
  implements Animation.AnimationListener
{
  public TalkRoomPopupNav$4(TalkRoomPopupNav paramTalkRoomPopupNav) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(30009);
    TalkRoomPopupNav.c(this.zpT).startAnimation(AnimationUtils.loadAnimation(this.zpT.getContext(), 2131034181));
    TalkRoomPopupNav.c(this.zpT).setVisibility(0);
    AppMethodBeat.o(30009);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav.4
 * JD-Core Version:    0.7.0.1
 */