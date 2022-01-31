package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ReaderAppUI$5
  implements MMPullDownView.d
{
  ReaderAppUI$5(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean aEV()
  {
    View localView = ReaderAppUI.e(this.noS).getChildAt(ReaderAppUI.e(this.noS).getFirstVisiblePosition());
    return (localView != null) && (localView.getTop() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.5
 * JD-Core Version:    0.7.0.1
 */