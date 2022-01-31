package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightDraftUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SightDraftUI$1(SightDraftUI paramSightDraftUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25024);
    this.qVt.finish();
    AppMethodBeat.o(25024);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.1
 * JD-Core Version:    0.7.0.1
 */