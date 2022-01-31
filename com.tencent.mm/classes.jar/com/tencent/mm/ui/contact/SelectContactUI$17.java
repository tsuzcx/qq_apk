package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class SelectContactUI$17
  implements MenuItem.OnMenuItemClickListener
{
  SelectContactUI$17(SelectContactUI paramSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = SelectContactUI.c(this.vNB, s.fA(SelectContactUI.a(this.vNB), 8192));
    paramMenuItem.remove(q.Gj());
    if ((s.fA(SelectContactUI.a(this.vNB), 4096)) && (paramMenuItem.size() > 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (!SelectContactUI.d(this.vNB))
      {
        SelectContactUI.d(this.vNB, true);
        SelectContactUI.e(this.vNB);
      }
      y.i("MicroMsg.SelectContactUI", "Create the chatroom");
      return true;
    }
    return SelectContactUI.b(this.vNB, SelectContactUI.a(this.vNB, s.fA(SelectContactUI.a(this.vNB), 8192)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.17
 * JD-Core Version:    0.7.0.1
 */