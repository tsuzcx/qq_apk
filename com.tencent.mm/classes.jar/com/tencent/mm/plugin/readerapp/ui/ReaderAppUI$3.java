package com.tencent.mm.plugin.readerapp.ui;

import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.g;

final class ReaderAppUI$3
  implements MMPullDownView.g
{
  ReaderAppUI$3(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean aEX()
  {
    if (ReaderAppUI.b(this.noS).aCc()) {
      ReaderAppUI.e(this.noS).setSelectionFromTop(0, ReaderAppUI.d(this.noS).getTopHeight());
    }
    int i;
    int j;
    int k;
    do
    {
      return true;
      i = ReaderAppUI.b(this.noS).getCount();
      j = ReaderAppUI.b(this.noS).aCd();
      y.v("MicroMsg.ReaderAppUI", "onLoadData add count:" + j);
      ReaderAppUI.b(this.noS).a(null, null);
      k = ReaderAppUI.b(this.noS).getCount();
      y.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
    } while (k <= i);
    y.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.d(this.noS).getTopHeight()) });
    j.a(ReaderAppUI.e(this.noS), j + 1, ReaderAppUI.d(this.noS).getTopHeight(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.3
 * JD-Core Version:    0.7.0.1
 */