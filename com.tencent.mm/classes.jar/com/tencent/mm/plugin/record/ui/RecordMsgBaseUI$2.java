package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.sdk.event.EventCenter;

final class RecordMsgBaseUI$2
  implements AbsListView.OnScrollListener
{
  RecordMsgBaseUI$2(RecordMsgBaseUI paramRecordMsgBaseUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    AppMethodBeat.i(27873);
    if (paramInt1 == 0)
    {
      paramAbsListView = this.BHY.krb.getChildAt(0);
      if (paramAbsListView == null) {}
      for (paramInt1 = paramInt2; paramInt1 == 0; paramInt1 = paramAbsListView.getTop())
      {
        this.BHY.hideActionbarLine();
        AppMethodBeat.o(27873);
        return;
      }
    }
    this.BHY.showActionbarLine();
    AppMethodBeat.o(27873);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(27872);
    if (paramInt == 0)
    {
      paramAbsListView = new yh();
      paramAbsListView.eeC.type = 5;
      paramAbsListView.eeC.eeD = this.BHY.krb.getFirstVisiblePosition();
      paramAbsListView.eeC.eeE = this.BHY.krb.getLastVisiblePosition();
      paramAbsListView.eeC.eeF = this.BHY.krb.getHeaderViewsCount();
      EventCenter.instance.publish(paramAbsListView);
    }
    AppMethodBeat.o(27872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.2
 * JD-Core Version:    0.7.0.1
 */