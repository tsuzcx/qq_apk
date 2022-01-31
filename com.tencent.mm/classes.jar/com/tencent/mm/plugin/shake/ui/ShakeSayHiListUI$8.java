package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class ShakeSayHiListUI$8
  implements AdapterView.OnItemLongClickListener
{
  ShakeSayHiListUI$8(ShakeSayHiListUI paramShakeSayHiListUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < ShakeSayHiListUI.d(this.odv).getHeaderViewsCount())
    {
      y.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
      return true;
    }
    this.hZt.a(paramView, paramInt, paramLong, this.odv, ShakeSayHiListUI.f(this.odv));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.8
 * JD-Core Version:    0.7.0.1
 */