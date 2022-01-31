package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ReaderAppUI$5
  implements MMPullDownView.d
{
  ReaderAppUI$5(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean bil()
  {
    AppMethodBeat.i(76817);
    View localView = ReaderAppUI.e(this.pUg).getChildAt(ReaderAppUI.e(this.pUg).getFirstVisiblePosition());
    if ((localView != null) && (localView.getTop() == 0))
    {
      AppMethodBeat.o(76817);
      return true;
    }
    AppMethodBeat.o(76817);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.5
 * JD-Core Version:    0.7.0.1
 */