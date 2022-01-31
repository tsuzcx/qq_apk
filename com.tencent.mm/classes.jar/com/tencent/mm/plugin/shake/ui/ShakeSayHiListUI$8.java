package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class ShakeSayHiListUI$8
  implements AdapterView.OnItemLongClickListener
{
  ShakeSayHiListUI$8(ShakeSayHiListUI paramShakeSayHiListUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24881);
    if (paramInt < ShakeSayHiListUI.d(this.qRC).getHeaderViewsCount())
    {
      ab.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
      AppMethodBeat.o(24881);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.qRC, ShakeSayHiListUI.f(this.qRC));
    AppMethodBeat.o(24881);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.8
 * JD-Core Version:    0.7.0.1
 */