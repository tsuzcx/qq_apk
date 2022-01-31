package com.tencent.mm.ui.matrix;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MatrixReportUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MatrixReportUI$1(MatrixReportUI paramMatrixReportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(156159);
    this.Aps.finish();
    AppMethodBeat.o(156159);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixReportUI.1
 * JD-Core Version:    0.7.0.1
 */