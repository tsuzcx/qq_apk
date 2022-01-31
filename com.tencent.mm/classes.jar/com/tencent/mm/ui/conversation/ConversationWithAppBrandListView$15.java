package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConversationWithAppBrandListView$15
  implements ValueAnimator.AnimatorUpdateListener
{
  ConversationWithAppBrandListView$15(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(34282);
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    ConversationWithAppBrandListView.m(this.AjJ).setAlpha(i);
    this.AjJ.invalidate();
    AppMethodBeat.o(34282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.15
 * JD-Core Version:    0.7.0.1
 */