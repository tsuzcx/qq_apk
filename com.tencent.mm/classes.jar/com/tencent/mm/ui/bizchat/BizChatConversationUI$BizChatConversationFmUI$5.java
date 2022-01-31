package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.m;

final class BizChatConversationUI$BizChatConversationFmUI$5
  implements MenuItem.OnMenuItemClickListener
{
  BizChatConversationUI$BizChatConversationFmUI$5(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30061);
    if (BizChatConversationUI.BizChatConversationFmUI.k(this.ztv) != null)
    {
      BizChatConversationUI.BizChatConversationFmUI.k(this.ztv).dismiss();
      BizChatConversationUI.BizChatConversationFmUI.a(this.ztv, null);
    }
    BizChatConversationUI.BizChatConversationFmUI.a(this.ztv, new m(this.ztv.getContext()));
    BizChatConversationUI.BizChatConversationFmUI.k(this.ztv).sao = new BizChatConversationUI.BizChatConversationFmUI.5.1(this);
    BizChatConversationUI.BizChatConversationFmUI.k(this.ztv).sap = new BizChatConversationUI.BizChatConversationFmUI.5.2(this);
    BizChatConversationUI.BizChatConversationFmUI.k(this.ztv).gr();
    AppMethodBeat.o(30061);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.5
 * JD-Core Version:    0.7.0.1
 */