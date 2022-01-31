package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;

final class ShakeTvHistoryListUI$4
  implements AdapterView.OnItemLongClickListener
{
  ShakeTvHistoryListUI$4(ShakeTvHistoryListUI paramShakeTvHistoryListUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < ShakeTvHistoryListUI.b(this.odz).getHeaderViewsCount()) {
      return true;
    }
    this.hZt.a(paramView, paramInt, paramLong, this.odz.mController.uMN, ShakeTvHistoryListUI.c(this.odz));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.4
 * JD-Core Version:    0.7.0.1
 */