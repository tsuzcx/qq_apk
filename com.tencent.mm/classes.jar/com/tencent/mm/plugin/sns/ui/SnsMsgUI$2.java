package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.b.a;

final class SnsMsgUI$2
  implements AdapterView.OnItemLongClickListener
{
  SnsMsgUI$2(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < SnsMsgUI.c(this.paq).getHeaderViewsCount())
    {
      y.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
      return true;
    }
    new a(this.paq).a(paramView, paramInt, paramLong, this.paq, SnsMsgUI.k(this.paq), SnsMsgUI.j(this.paq)[0], SnsMsgUI.j(this.paq)[1]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.2
 * JD-Core Version:    0.7.0.1
 */