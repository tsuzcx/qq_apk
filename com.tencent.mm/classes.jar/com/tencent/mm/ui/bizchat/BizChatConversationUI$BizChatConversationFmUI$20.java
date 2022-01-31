package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class BizChatConversationUI$BizChatConversationFmUI$20
  implements MMSlideDelView.c
{
  BizChatConversationUI$BizChatConversationFmUI$20(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(30077);
    int i = BizChatConversationUI.BizChatConversationFmUI.j(this.ztv).getPositionForView(paramView);
    AppMethodBeat.o(30077);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.20
 * JD-Core Version:    0.7.0.1
 */