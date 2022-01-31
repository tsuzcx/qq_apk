package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.pluginsdk.n;

final class QConversationUI$2
  implements MenuItem.OnMenuItemClickListener
{
  QConversationUI$2(QConversationUI paramQConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24127);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Contact_User", QConversationUI.a(this.pIm).field_username);
    paramMenuItem.putExtra("Chat_Readonly", true);
    a.gmO.c(paramMenuItem, this.pIm.getContext());
    AppMethodBeat.o(24127);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.2
 * JD-Core Version:    0.7.0.1
 */