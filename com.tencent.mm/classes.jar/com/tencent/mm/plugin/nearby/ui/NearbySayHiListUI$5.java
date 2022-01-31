package com.tencent.mm.plugin.nearby.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class NearbySayHiListUI$5
  implements MenuItem.OnMenuItemClickListener
{
  NearbySayHiListUI$5(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55498);
    h.a(this.pdR.getContext(), true, this.pdR.getResources().getString(2131302875), "", this.pdR.getResources().getString(2131302874), this.pdR.getString(2131296888), new NearbySayHiListUI.5.1(this), null);
    AppMethodBeat.o(55498);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.5
 * JD-Core Version:    0.7.0.1
 */