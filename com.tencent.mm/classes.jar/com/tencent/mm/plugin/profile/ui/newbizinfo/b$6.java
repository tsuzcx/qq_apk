package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.ui.widget.b.d;

final class b$6
  implements MenuItem.OnMenuItemClickListener
{
  b$6(b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153584);
    paramMenuItem = new d(this.pDl.pDe, 1, false);
    paramMenuItem.sao = new b.6.1(this);
    paramMenuItem.sap = new b.6.2(this);
    paramMenuItem.crd();
    c.cZ(this.pDl.contact.field_username, 600);
    AppMethodBeat.o(153584);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.6
 * JD-Core Version:    0.7.0.1
 */