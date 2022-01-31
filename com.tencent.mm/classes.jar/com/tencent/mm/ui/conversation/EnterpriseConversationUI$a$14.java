package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;

final class EnterpriseConversationUI$a$14
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseConversationUI$a$14(EnterpriseConversationUI.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.a.c(this.vSW));
    paramMenuItem.addFlags(67108864);
    d.b(this.vSW.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.14
 * JD-Core Version:    0.7.0.1
 */