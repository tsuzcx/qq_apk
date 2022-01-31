package com.tencent.mm.plugin.readerapp.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReaderAppIntroUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ReaderAppIntroUI$1(ReaderAppIntroUI paramReaderAppIntroUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(76798);
    this.pTT.finish();
    AppMethodBeat.o(76798);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI.1
 * JD-Core Version:    0.7.0.1
 */