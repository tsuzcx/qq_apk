package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.sdk.b.a;

final class RecordMsgBaseUI$1
  implements AbsListView.OnScrollListener
{
  RecordMsgBaseUI$1(RecordMsgBaseUI paramRecordMsgBaseUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    AppMethodBeat.i(24231);
    if (paramInt1 == 0)
    {
      paramAbsListView = this.pZB.gJa.getChildAt(0);
      if (paramAbsListView == null) {}
      for (paramInt1 = paramInt2; paramInt1 == 0; paramInt1 = paramAbsListView.getTop())
      {
        this.pZB.hideActionbarLine();
        AppMethodBeat.o(24231);
        return;
      }
    }
    this.pZB.showActionbarLine();
    AppMethodBeat.o(24231);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(24230);
    if (paramInt == 0)
    {
      paramAbsListView = new ua();
      paramAbsListView.cKz.type = 5;
      paramAbsListView.cKz.cKA = this.pZB.gJa.getFirstVisiblePosition();
      paramAbsListView.cKz.cKB = this.pZB.gJa.getLastVisiblePosition();
      paramAbsListView.cKz.cKC = this.pZB.gJa.getHeaderViewsCount();
      a.ymk.l(paramAbsListView);
    }
    AppMethodBeat.o(24230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.1
 * JD-Core Version:    0.7.0.1
 */