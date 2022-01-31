package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.transmit.SelectConversationUI;

final class EnterpriseConversationUI$a$15$2
  implements n.d
{
  EnterpriseConversationUI$a$15$2(EnterpriseConversationUI.a.15 param15) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 0;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      g.dB(EnterpriseConversationUI.a.c(this.vSY.vSW), paramInt);
      return;
      g.n(this.vSY.vSW.getContext(), EnterpriseConversationUI.a.c(this.vSY.vSW), 5);
      continue;
      paramMenuItem = new Intent(this.vSY.vSW.thisActivity(), SelectConversationUI.class);
      paramMenuItem.putExtra("Select_Talker_Name", EnterpriseConversationUI.a.c(this.vSY.vSW));
      paramMenuItem.putExtra("Select_block_List", EnterpriseConversationUI.a.c(this.vSY.vSW));
      paramMenuItem.putExtra("Select_Send_Card", true);
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      this.vSY.vSW.startActivityForResult(paramMenuItem, 1);
      paramInt = 3;
      continue;
      paramInt = 4;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.a.c(this.vSY.vSW));
      paramMenuItem.putExtra("enterprise_scene", 2);
      d.b(this.vSY.vSW.thisActivity(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", paramMenuItem);
      continue;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", EnterpriseConversationUI.a.c(this.vSY.vSW));
      d.b(this.vSY.vSW.thisActivity(), "profile", ".ui.ContactInfoUI", paramMenuItem);
      paramInt = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.15.2
 * JD-Core Version:    0.7.0.1
 */