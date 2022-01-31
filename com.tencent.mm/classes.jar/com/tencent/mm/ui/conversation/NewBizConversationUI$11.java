package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class NewBizConversationUI$11
  implements MenuItem.OnMenuItemClickListener
{
  NewBizConversationUI$11(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.vTG, 1, false);
    paramMenuItem.phH = new NewBizConversationUI.11.1(this);
    paramMenuItem.phI = new NewBizConversationUI.11.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.11
 * JD-Core Version:    0.7.0.1
 */