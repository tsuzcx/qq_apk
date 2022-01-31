package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ReaderAppUI$4
  implements MMPullDownView.c
{
  ReaderAppUI$4(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean aEW()
  {
    View localView = ReaderAppUI.e(this.noS).getChildAt(ReaderAppUI.e(this.noS).getChildCount() - 1);
    if (localView == null) {}
    while ((localView.getBottom() > ReaderAppUI.e(this.noS).getHeight()) || (ReaderAppUI.e(this.noS).getLastVisiblePosition() != ReaderAppUI.e(this.noS).getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.4
 * JD-Core Version:    0.7.0.1
 */