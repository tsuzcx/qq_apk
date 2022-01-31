package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class QConversationUI$2
  implements MenuItem.OnMenuItemClickListener
{
  QConversationUI$2(QConversationUI paramQConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Contact_User", QConversationUI.a(this.ncU).field_username);
    paramMenuItem.putExtra("Chat_Readonly", true);
    a.eUR.d(paramMenuItem, this.ncU.mController.uMN);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.2
 * JD-Core Version:    0.7.0.1
 */