package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.b.a;

final class SnsMsgUI$17
  implements AdapterView.OnItemLongClickListener
{
  SnsMsgUI$17(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(198373);
    if (paramInt < SnsMsgUI.b(this.AfF).getHeaderViewsCount())
    {
      ad.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
      AppMethodBeat.o(198373);
      return true;
    }
    new a(this.AfF).a(paramView, paramInt, paramLong, this.AfF, SnsMsgUI.j(this.AfF), SnsMsgUI.i(this.AfF)[0], SnsMsgUI.i(this.AfF)[1]);
    AppMethodBeat.o(198373);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.17
 * JD-Core Version:    0.7.0.1
 */