package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.tools.k;

final class BizChatConversationUI$a$5
  implements MenuItem.OnMenuItemClickListener
{
  BizChatConversationUI$a$5(BizChatConversationUI.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (BizChatConversationUI.a.k(this.veW) != null)
    {
      BizChatConversationUI.a.k(this.veW).dismiss();
      BizChatConversationUI.a.a(this.veW, null);
    }
    BizChatConversationUI.a.a(this.veW, new k(this.veW.getContext()));
    BizChatConversationUI.a.k(this.veW).phH = new BizChatConversationUI.a.5.1(this);
    BizChatConversationUI.a.k(this.veW).phI = new BizChatConversationUI.a.5.2(this);
    BizChatConversationUI.a.k(this.veW).fy();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.5
 * JD-Core Version:    0.7.0.1
 */