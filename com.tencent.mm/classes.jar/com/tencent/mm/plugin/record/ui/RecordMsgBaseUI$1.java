package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.h.a.si;
import com.tencent.mm.sdk.b.a;

final class RecordMsgBaseUI$1
  implements AbsListView.OnScrollListener
{
  RecordMsgBaseUI$1(RecordMsgBaseUI paramRecordMsgBaseUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    if (paramInt1 == 0)
    {
      paramAbsListView = this.ntT.fry.getChildAt(0);
      if (paramAbsListView == null) {}
      for (paramInt1 = paramInt2; paramInt1 == 0; paramInt1 = paramAbsListView.getTop())
      {
        this.ntT.czo();
        return;
      }
    }
    this.ntT.czp();
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramAbsListView = new si();
      paramAbsListView.cbT.type = 5;
      paramAbsListView.cbT.cbU = this.ntT.fry.getFirstVisiblePosition();
      paramAbsListView.cbT.cbV = this.ntT.fry.getLastVisiblePosition();
      paramAbsListView.cbT.cbW = this.ntT.fry.getHeaderViewsCount();
      a.udP.m(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.1
 * JD-Core Version:    0.7.0.1
 */