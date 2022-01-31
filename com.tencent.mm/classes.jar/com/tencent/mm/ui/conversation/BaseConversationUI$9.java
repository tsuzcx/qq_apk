package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class BaseConversationUI$9
  implements Animation.AnimationListener
{
  BaseConversationUI$9(BaseConversationUI paramBaseConversationUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    au.DS().cre();
    ai.Fd(0);
    BaseConversationUI.access$600(this.vPi);
    y.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    au.DS().crc();
    ai.Fd(-8);
    y.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
    this.vPi.onSettle(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.9
 * JD-Core Version:    0.7.0.1
 */