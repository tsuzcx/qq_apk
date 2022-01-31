package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class ShakeItemListUI$4
  implements AdapterView.OnItemLongClickListener
{
  ShakeItemListUI$4(ShakeItemListUI paramShakeItemListUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24723);
    if (paramInt < ShakeItemListUI.c(this.qPL).getHeaderViewsCount())
    {
      ab.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
      AppMethodBeat.o(24723);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.qPL, ShakeItemListUI.e(this.qPL));
    AppMethodBeat.o(24723);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.4
 * JD-Core Version:    0.7.0.1
 */