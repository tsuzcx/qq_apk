package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$70
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatFooter$70(ChatFooter paramChatFooter) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(185810);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ChatFooter.aI(this.YiY).getLayoutParams().height = i;
    ChatFooter.aI(this.YiY).requestLayout();
    AppMethodBeat.o(185810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.70
 * JD-Core Version:    0.7.0.1
 */