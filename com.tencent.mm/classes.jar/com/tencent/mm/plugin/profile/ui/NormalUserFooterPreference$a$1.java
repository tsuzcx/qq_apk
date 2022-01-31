package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class NormalUserFooterPreference$a$1
  implements MenuItem.OnMenuItemClickListener
{
  NormalUserFooterPreference$a$1(NormalUserFooterPreference.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(23676);
    paramMenuItem = new d(NormalUserFooterPreference.b(this.pCf.pCe), 1, false);
    paramMenuItem.sap = new NormalUserFooterPreference.a.1.1(this);
    paramMenuItem.sao = new NormalUserFooterPreference.a.1.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(23676);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1
 * JD-Core Version:    0.7.0.1
 */