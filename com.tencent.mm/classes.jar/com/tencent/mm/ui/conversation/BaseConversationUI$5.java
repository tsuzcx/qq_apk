package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class BaseConversationUI$5
  implements Runnable
{
  BaseConversationUI$5(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    au.DS().cre();
    ai.Fd(0);
    this.vPi.onSwipe(1.0F);
    if ((BaseConversationUI.access$200(this.vPi) != null) && (BaseConversationUI.access$100(this.vPi) != null)) {
      BaseConversationUI.access$200(this.vPi).cJm();
    }
    BaseConversationUI.access$500(this.vPi).cyU();
    BaseConversationUI.access$600(this.vPi);
  }
  
  public final String toString()
  {
    return super.toString() + "|chattingView_onAnimationEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.5
 * JD-Core Version:    0.7.0.1
 */