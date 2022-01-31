package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.c.a;

final class SnsMsgUI$2
  implements AdapterView.OnItemLongClickListener
{
  SnsMsgUI$2(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39066);
    if (paramInt < SnsMsgUI.c(this.rSU).getHeaderViewsCount())
    {
      ab.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
      AppMethodBeat.o(39066);
      return true;
    }
    new a(this.rSU).a(paramView, paramInt, paramLong, this.rSU, SnsMsgUI.k(this.rSU), SnsMsgUI.j(this.rSU)[0], SnsMsgUI.j(this.rSU)[1]);
    AppMethodBeat.o(39066);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.2
 * JD-Core Version:    0.7.0.1
 */