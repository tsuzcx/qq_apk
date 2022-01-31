package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class FMessageConversationUI$3
  implements AdapterView.OnItemLongClickListener
{
  FMessageConversationUI$3(FMessageConversationUI paramFMessageConversationUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < FMessageConversationUI.b(this.pwx).getHeaderViewsCount())
    {
      y.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
      return true;
    }
    int i = FMessageConversationUI.b(this.pwx).getHeaderViewsCount();
    this.hZt.a(paramView, paramInt - i, paramLong, this.pwx, FMessageConversationUI.c(this.pwx));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.3
 * JD-Core Version:    0.7.0.1
 */