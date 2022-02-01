package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$83
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatFooter$83(ChatFooter paramChatFooter) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(245432);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((ViewGroup.MarginLayoutParams)ChatFooter.aI(this.YiY).getLayoutParams()).width = i;
    ChatFooter.aI(this.YiY).requestLayout();
    AppMethodBeat.o(245432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.83
 * JD-Core Version:    0.7.0.1
 */