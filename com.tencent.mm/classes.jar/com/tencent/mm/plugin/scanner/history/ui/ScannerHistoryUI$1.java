package com.tencent.mm.plugin.scanner.history.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScannerHistoryUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ScannerHistoryUI$1(ScannerHistoryUI paramScannerHistoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(80800);
    this.qtO.finish();
    AppMethodBeat.o(80800);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.1
 * JD-Core Version:    0.7.0.1
 */