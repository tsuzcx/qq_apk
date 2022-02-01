package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$85
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatFooter$85(ChatFooter paramChatFooter) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(245436);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((ViewGroup.MarginLayoutParams)ChatFooter.aI(this.YiY).getLayoutParams()).height = i;
    ChatFooter.aI(this.YiY).requestLayout();
    AppMethodBeat.o(245436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.85
 * JD-Core Version:    0.7.0.1
 */