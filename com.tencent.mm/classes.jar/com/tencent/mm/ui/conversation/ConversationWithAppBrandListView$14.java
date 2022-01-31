package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;

final class ConversationWithAppBrandListView$14
  implements ValueAnimator.AnimatorUpdateListener
{
  ConversationWithAppBrandListView$14(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    ConversationWithAppBrandListView.m(this.vRV).setAlpha(i);
    this.vRV.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.14
 * JD-Core Version:    0.7.0.1
 */