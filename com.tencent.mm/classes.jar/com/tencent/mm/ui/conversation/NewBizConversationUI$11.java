package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class NewBizConversationUI$11
  implements MenuItem.OnMenuItemClickListener
{
  NewBizConversationUI$11(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34546);
    paramMenuItem = new d(this.AlC, 1, false);
    paramMenuItem.sao = new NewBizConversationUI.11.1(this);
    paramMenuItem.sap = new NewBizConversationUI.11.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(34546);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.11
 * JD-Core Version:    0.7.0.1
 */