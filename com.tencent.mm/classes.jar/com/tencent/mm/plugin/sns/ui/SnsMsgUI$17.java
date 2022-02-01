package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.b.a;

final class SnsMsgUI$17
  implements AdapterView.OnItemLongClickListener
{
  SnsMsgUI$17(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(219911);
    if (paramInt < SnsMsgUI.b(this.AwR).getHeaderViewsCount())
    {
      ae.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
      AppMethodBeat.o(219911);
      return true;
    }
    new a(this.AwR).a(paramView, paramInt, paramLong, this.AwR, SnsMsgUI.j(this.AwR), SnsMsgUI.i(this.AwR)[0], SnsMsgUI.i(this.AwR)[1]);
    AppMethodBeat.o(219911);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.17
 * JD-Core Version:    0.7.0.1
 */