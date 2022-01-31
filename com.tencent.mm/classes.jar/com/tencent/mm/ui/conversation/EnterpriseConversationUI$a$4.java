package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

final class EnterpriseConversationUI$a$4
  implements n.d
{
  EnterpriseConversationUI$a$4(EnterpriseConversationUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      EnterpriseConversationUI.a.a(this.vSW, EnterpriseConversationUI.a.g(this.vSW));
      return;
    case 2: 
      EnterpriseConversationUI.a.b(this.vSW, EnterpriseConversationUI.a.g(this.vSW));
      return;
    }
    EnterpriseConversationUI.a.adZ(EnterpriseConversationUI.a.g(this.vSW));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.4
 * JD-Core Version:    0.7.0.1
 */