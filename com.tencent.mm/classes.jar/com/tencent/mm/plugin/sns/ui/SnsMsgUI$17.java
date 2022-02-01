package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.b.a;

final class SnsMsgUI$17
  implements AdapterView.OnItemLongClickListener
{
  SnsMsgUI$17(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(308602);
    if (paramInt < SnsMsgUI.b(this.RtY).getHeaderViewsCount())
    {
      Log.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
      AppMethodBeat.o(308602);
      return true;
    }
    new a(this.RtY).a(paramView, paramInt, paramLong, this.RtY, SnsMsgUI.j(this.RtY), SnsMsgUI.i(this.RtY)[0], SnsMsgUI.i(this.RtY)[1]);
    AppMethodBeat.o(308602);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.17
 * JD-Core Version:    0.7.0.1
 */