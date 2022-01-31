package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class FavRecordDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FavRecordDetailUI$2(FavRecordDetailUI paramFavRecordDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24207);
    paramMenuItem = new d(this.pZl.getContext(), 1, false);
    paramMenuItem.sao = new FavRecordDetailUI.2.1(this);
    paramMenuItem.sap = new FavRecordDetailUI.2.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(24207);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2
 * JD-Core Version:    0.7.0.1
 */