package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class BaseConversationUI$6$2
  implements TestTimeForChatting.a
{
  BaseConversationUI$6$2(BaseConversationUI.6 param6) {}
  
  public final void cAb()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onDrawed]");
    this.vPj.start = System.currentTimeMillis();
    if (BaseConversationUI.access$100(this.vPj.vPi).getSwipeBackLayout() != null) {
      BaseConversationUI.access$100(this.vPj.vPi).getSwipeBackLayout().startAnimation(BaseConversationUI.access$700(this.vPj.vPi));
    }
    for (;;)
    {
      BaseConversationUI.access$200(this.vPj.vPi).setOndispatchDraw(null);
      return;
      BaseConversationUI.access$100(this.vPj.vPi).getView().startAnimation(BaseConversationUI.access$700(this.vPj.vPi));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.6.2
 * JD-Core Version:    0.7.0.1
 */