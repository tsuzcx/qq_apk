package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class ShakeMsgListUI$5
  implements AdapterView.OnItemLongClickListener
{
  ShakeMsgListUI$5(ShakeMsgListUI paramShakeMsgListUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24756);
    if (paramInt < ShakeMsgListUI.f(this.qQa).getHeaderViewsCount())
    {
      ab.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
      AppMethodBeat.o(24756);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.qQa.getContext(), ShakeMsgListUI.h(this.qQa));
    AppMethodBeat.o(24756);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.5
 * JD-Core Version:    0.7.0.1
 */