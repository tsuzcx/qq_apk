package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ShakeItemListUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShakeItemListUI$1(ShakeItemListUI paramShakeItemListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24720);
    h.a(this.qPL, true, this.qPL.getString(2131302875), "", this.qPL.getString(2131296891), this.qPL.getString(2131296888), new ShakeItemListUI.1.1(this), null);
    AppMethodBeat.o(24720);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1
 * JD-Core Version:    0.7.0.1
 */