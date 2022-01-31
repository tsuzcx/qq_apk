package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ReaderAppUI$4
  implements MMPullDownView.c
{
  ReaderAppUI$4(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean bim()
  {
    AppMethodBeat.i(76816);
    View localView = ReaderAppUI.e(this.pUg).getChildAt(ReaderAppUI.e(this.pUg).getChildCount() - 1);
    if (localView == null)
    {
      AppMethodBeat.o(76816);
      return false;
    }
    if ((localView.getBottom() <= ReaderAppUI.e(this.pUg).getHeight()) && (ReaderAppUI.e(this.pUg).getLastVisiblePosition() == ReaderAppUI.e(this.pUg).getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(76816);
      return true;
    }
    AppMethodBeat.o(76816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.4
 * JD-Core Version:    0.7.0.1
 */