package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class BaseConversationUI$6$1
  implements Animation.AnimationListener
{
  BaseConversationUI$6$1(BaseConversationUI.6 param6) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    BaseConversationUI.access$802(this.vPj.vPi, false);
    y.i("MicroMsg.BaseConversationUI", "klem animationEnd");
    BaseConversationUI.access$1000(this.vPj.vPi);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.i("MicroMsg.BaseConversationUI", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.vPj.start) });
    BaseConversationUI.access$802(this.vPj.vPi, true);
    BaseConversationUI.access$900(this.vPj.vPi);
    this.vPj.vPi.onSettle(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.6.1
 * JD-Core Version:    0.7.0.1
 */