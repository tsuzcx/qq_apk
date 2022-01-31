package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class NearbySayHiListUI$10
  implements AdapterView.OnItemLongClickListener
{
  NearbySayHiListUI$10(NearbySayHiListUI paramNearbySayHiListUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(55504);
    if (paramInt < NearbySayHiListUI.d(this.pdR).getHeaderViewsCount())
    {
      ab.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
      AppMethodBeat.o(55504);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.pdR, NearbySayHiListUI.g(this.pdR));
    AppMethodBeat.o(55504);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.10
 * JD-Core Version:    0.7.0.1
 */