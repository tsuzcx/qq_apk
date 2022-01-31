package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.k;

final class EnterpriseConversationUI$a$15
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseConversationUI$a$15(EnterpriseConversationUI.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (EnterpriseConversationUI.a.d(this.vSW) != null)
    {
      EnterpriseConversationUI.a.d(this.vSW).dismiss();
      EnterpriseConversationUI.a.a(this.vSW, null);
    }
    EnterpriseConversationUI.a.a(this.vSW, new k(this.vSW.getContext()));
    EnterpriseConversationUI.a.d(this.vSW).phH = new EnterpriseConversationUI.a.15.1(this);
    EnterpriseConversationUI.a.d(this.vSW).phI = new EnterpriseConversationUI.a.15.2(this);
    EnterpriseConversationUI.a.d(this.vSW).fy();
    g.dB(EnterpriseConversationUI.a.c(this.vSW), 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.15
 * JD-Core Version:    0.7.0.1
 */