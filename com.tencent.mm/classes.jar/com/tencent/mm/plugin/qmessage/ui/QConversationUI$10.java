package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.b.a;

final class QConversationUI$10
  implements AdapterView.OnItemLongClickListener
{
  QConversationUI$10(QConversationUI paramQConversationUI, a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < QConversationUI.c(this.ncU).getHeaderViewsCount())
    {
      y.w("MicroMsg.QConversationUI", "on header view long click, ignore");
      return true;
    }
    this.ncV.a(paramView, paramInt, paramLong, this.ncU, QConversationUI.d(this.ncU), 0, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.10
 * JD-Core Version:    0.7.0.1
 */