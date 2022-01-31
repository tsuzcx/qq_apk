package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsSingleTextViewUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SnsSingleTextViewUI$4(SnsSingleTextViewUI paramSnsSingleTextViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39304);
    this.rWm.finish();
    AppMethodBeat.o(39304);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.4
 * JD-Core Version:    0.7.0.1
 */