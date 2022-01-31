package com.tencent.mm.plugin.qqmail.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrListUI$4
  implements AbsListView.OnScrollListener
{
  MailAddrListUI$4(MailAddrListUI paramMailAddrListUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(68314);
    if (1 == paramInt) {
      this.pNn.hideVKB();
    }
    AppMethodBeat.o(68314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.4
 * JD-Core Version:    0.7.0.1
 */