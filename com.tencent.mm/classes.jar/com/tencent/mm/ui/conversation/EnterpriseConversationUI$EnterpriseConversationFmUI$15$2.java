package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.transmit.SelectConversationUI;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$15$2
  implements n.d
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$15$2(EnterpriseConversationUI.EnterpriseConversationFmUI.15 param15) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34434);
    paramInt = 0;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      g.eK(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkQ.AkO), paramInt);
      AppMethodBeat.o(34434);
      return;
      g.t(this.AkQ.AkO.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkQ.AkO), 5);
      continue;
      paramMenuItem = new Intent(this.AkQ.AkO.thisActivity(), SelectConversationUI.class);
      paramMenuItem.putExtra("Select_Talker_Name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkQ.AkO));
      paramMenuItem.putExtra("Select_block_List", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkQ.AkO));
      paramMenuItem.putExtra("Select_Send_Card", true);
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      this.AkQ.AkO.startActivityForResult(paramMenuItem, 1);
      paramInt = 3;
      continue;
      paramInt = 4;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkQ.AkO));
      paramMenuItem.putExtra("enterprise_scene", 2);
      d.b(this.AkQ.AkO.thisActivity(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", paramMenuItem);
      continue;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkQ.AkO));
      d.b(this.AkQ.AkO.thisActivity(), "profile", ".ui.ContactInfoUI", paramMenuItem);
      paramInt = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.15.2
 * JD-Core Version:    0.7.0.1
 */