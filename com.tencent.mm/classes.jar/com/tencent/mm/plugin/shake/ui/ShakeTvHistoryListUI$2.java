package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ShakeTvHistoryListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShakeTvHistoryListUI$2(ShakeTvHistoryListUI paramShakeTvHistoryListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24894);
    h.a(this.qRG.getContext(), true, this.qRG.getString(2131303652), "", this.qRG.getString(2131302874), this.qRG.getString(2131296888), new ShakeTvHistoryListUI.2.1(this), new ShakeTvHistoryListUI.2.2(this));
    AppMethodBeat.o(24894);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.2
 * JD-Core Version:    0.7.0.1
 */