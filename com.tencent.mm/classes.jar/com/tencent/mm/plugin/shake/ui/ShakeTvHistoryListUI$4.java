package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class ShakeTvHistoryListUI$4
  implements AdapterView.OnItemLongClickListener
{
  ShakeTvHistoryListUI$4(ShakeTvHistoryListUI paramShakeTvHistoryListUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24896);
    if (paramInt < ShakeTvHistoryListUI.b(this.qRG).getHeaderViewsCount())
    {
      AppMethodBeat.o(24896);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.qRG.getContext(), ShakeTvHistoryListUI.c(this.qRG));
    AppMethodBeat.o(24896);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.4
 * JD-Core Version:    0.7.0.1
 */