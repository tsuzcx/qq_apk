package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class SelectLabelContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectLabelContactUI$1(SelectLabelContactUI paramSelectLabelContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new ArrayList(SelectLabelContactUI.a(this.vNL));
    y.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[] { paramMenuItem.toString() });
    SelectLabelContactUI.a(this.vNL, bk.c(paramMenuItem, ","));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI.1
 * JD-Core Version:    0.7.0.1
 */