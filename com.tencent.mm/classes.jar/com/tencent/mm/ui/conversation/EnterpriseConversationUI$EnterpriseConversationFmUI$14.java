package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$14
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$14(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34432);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkO));
    paramMenuItem.addFlags(67108864);
    d.b(this.AkO.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramMenuItem);
    AppMethodBeat.o(34432);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.14
 * JD-Core Version:    0.7.0.1
 */