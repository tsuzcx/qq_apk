package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class NearbySayHiListUI$10
  implements AdapterView.OnItemLongClickListener
{
  NearbySayHiListUI$10(NearbySayHiListUI paramNearbySayHiListUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < NearbySayHiListUI.d(this.mDP).getHeaderViewsCount())
    {
      y.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
      return true;
    }
    this.hZt.a(paramView, paramInt, paramLong, this.mDP, NearbySayHiListUI.g(this.mDP));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.10
 * JD-Core Version:    0.7.0.1
 */