package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;

final class QConversationUI$13
  implements MenuItem.OnMenuItemClickListener
{
  QConversationUI$13(QConversationUI paramQConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!bk.bl(QConversationUI.f(this.ncU))) {
      QConversationUI.a(this.ncU, QConversationUI.f(this.ncU), QConversationUI.g(this.ncU));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.13
 * JD-Core Version:    0.7.0.1
 */