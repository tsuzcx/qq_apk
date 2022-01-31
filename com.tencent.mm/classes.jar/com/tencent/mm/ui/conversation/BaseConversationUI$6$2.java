package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class BaseConversationUI$6$2
  implements TestTimeForChatting.a
{
  BaseConversationUI$6$2(BaseConversationUI.6 param6) {}
  
  public final void dDc()
  {
    AppMethodBeat.i(34053);
    ab.i("MicroMsg.BaseConversationUI", "[onDrawed]");
    this.AgU.start = System.currentTimeMillis();
    if (BaseConversationUI.access$100(this.AgU.AgT) == null)
    {
      ab.e("MicroMsg.BaseConversationUI", "chattingFragmet is null!");
      AppMethodBeat.o(34053);
      return;
    }
    if (BaseConversationUI.access$100(this.AgU.AgT).getSwipeBackLayout() != null) {
      BaseConversationUI.access$100(this.AgU.AgT).getSwipeBackLayout().startAnimation(BaseConversationUI.access$700(this.AgU.AgT));
    }
    for (;;)
    {
      BaseConversationUI.access$200(this.AgU.AgT).setOndispatchDraw(null);
      AppMethodBeat.o(34053);
      return;
      BaseConversationUI.access$100(this.AgU.AgT).getView().startAnimation(BaseConversationUI.access$700(this.AgU.AgT));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.6.2
 * JD-Core Version:    0.7.0.1
 */