package com.tencent.mm.plugin.readerapp.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.g;

final class ReaderAppUI$3
  implements MMPullDownView.g
{
  ReaderAppUI$3(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean bin()
  {
    AppMethodBeat.i(76815);
    if (ReaderAppUI.b(this.pUg).bem())
    {
      ReaderAppUI.e(this.pUg).setSelectionFromTop(0, ReaderAppUI.d(this.pUg).getTopHeight());
      AppMethodBeat.o(76815);
      return true;
    }
    int i = ReaderAppUI.b(this.pUg).getCount();
    int j = ReaderAppUI.b(this.pUg).ben();
    ab.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
    ReaderAppUI.b(this.pUg).a(null, null);
    int k = ReaderAppUI.b(this.pUg).getCount();
    ab.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
    if (k > i)
    {
      ab.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.d(this.pUg).getTopHeight()) });
      k.a(ReaderAppUI.e(this.pUg), j + 1, ReaderAppUI.d(this.pUg).getTopHeight(), false);
    }
    AppMethodBeat.o(76815);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.3
 * JD-Core Version:    0.7.0.1
 */