package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class BaseConversationUI$6
  implements OnLayoutChangedLinearLayout.a
{
  long start = 0L;
  
  BaseConversationUI$6(BaseConversationUI paramBaseConversationUI) {}
  
  public final void cAa()
  {
    if (BaseConversationUI.access$700(this.vPi) == null)
    {
      BaseConversationUI.access$702(this.vPi, AnimationUtils.loadAnimation(this.vPi, MMFragmentActivity.a.uOe));
      BaseConversationUI.access$700(this.vPi).setAnimationListener(new BaseConversationUI.6.1(this));
    }
    if (BaseConversationUI.access$1100(this.vPi))
    {
      BaseConversationUI.access$200(this.vPi).setOndispatchDraw(new BaseConversationUI.6.2(this));
      BaseConversationUI.access$1102(this.vPi, false);
    }
    for (;;)
    {
      BaseConversationUI.access$1200(this.vPi).vbj = null;
      y.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
      return;
      BaseConversationUI.access$900(this.vPi);
      BaseConversationUI.access$1000(this.vPi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.6
 * JD-Core Version:    0.7.0.1
 */