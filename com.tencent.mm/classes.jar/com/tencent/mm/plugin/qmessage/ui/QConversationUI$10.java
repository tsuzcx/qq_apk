package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.c.a;

final class QConversationUI$10
  implements AdapterView.OnItemLongClickListener
{
  QConversationUI$10(QConversationUI paramQConversationUI, a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24136);
    if (paramInt < QConversationUI.c(this.pIm).getHeaderViewsCount())
    {
      ab.w("MicroMsg.QConversationUI", "on header view long click, ignore");
      AppMethodBeat.o(24136);
      return true;
    }
    this.pIn.a(paramView, paramInt, paramLong, this.pIm, QConversationUI.d(this.pIm), 0, 0);
    AppMethodBeat.o(24136);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.10
 * JD-Core Version:    0.7.0.1
 */