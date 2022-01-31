package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class SelectLabelContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectLabelContactUI$1(SelectLabelContactUI paramSelectLabelContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33906);
    paramMenuItem = new ArrayList(SelectLabelContactUI.a(this.Aft));
    ab.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[] { paramMenuItem.toString() });
    SelectLabelContactUI.a(this.Aft, bo.d(paramMenuItem, ","));
    AppMethodBeat.o(33906);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI.1
 * JD-Core Version:    0.7.0.1
 */