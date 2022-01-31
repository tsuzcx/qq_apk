package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;

final class SelectConversationUI$19
  implements MenuItem.OnMenuItemClickListener
{
  SelectConversationUI$19(SelectConversationUI paramSelectConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.whw;
    boolean bool;
    if (!SelectConversationUI.a(this.whw))
    {
      bool = true;
      SelectConversationUI.a(paramMenuItem, bool);
      this.whw.cHE().nz(SelectConversationUI.a(this.whw));
      this.whw.vLN.nz(SelectConversationUI.a(this.whw));
      SelectConversationUI.k(this.whw);
      paramMenuItem = SelectConversationUI.m(this.whw);
      if (SelectConversationUI.a(this.whw)) {
        break label102;
      }
    }
    label102:
    for (int i = SelectConversationUI.l(this.whw);; i = R.l.select_more_contact)
    {
      paramMenuItem.setText(i);
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.19
 * JD-Core Version:    0.7.0.1
 */