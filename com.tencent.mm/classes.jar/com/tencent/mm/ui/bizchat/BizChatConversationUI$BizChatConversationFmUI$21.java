package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class BizChatConversationUI$BizChatConversationFmUI$21
  implements MMSlideDelView.g
{
  BizChatConversationUI$BizChatConversationFmUI$21(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30078);
    BizChatConversationUI.BizChatConversationFmUI.j(this.ztv).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(30078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.21
 * JD-Core Version:    0.7.0.1
 */