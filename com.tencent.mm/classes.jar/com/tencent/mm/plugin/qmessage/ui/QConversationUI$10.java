package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.b.a;

final class QConversationUI$10
  implements AdapterView.OnItemLongClickListener
{
  QConversationUI$10(QConversationUI paramQConversationUI, a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(27776);
    if (paramInt < QConversationUI.c(this.BqG).getHeaderViewsCount())
    {
      Log.w("MicroMsg.QConversationUI", "on header view long click, ignore");
      AppMethodBeat.o(27776);
      return true;
    }
    this.BqH.a(paramView, paramInt, paramLong, this.BqG, QConversationUI.d(this.BqG), 0, 0);
    AppMethodBeat.o(27776);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.10
 * JD-Core Version:    0.7.0.1
 */