package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class FMessageConversationUI$4
  implements AdapterView.OnItemLongClickListener
{
  FMessageConversationUI$4(FMessageConversationUI paramFMessageConversationUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25361);
    if (paramInt < FMessageConversationUI.b(this.sYg).getHeaderViewsCount())
    {
      ab.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
      AppMethodBeat.o(25361);
      return true;
    }
    int i = FMessageConversationUI.b(this.sYg).getHeaderViewsCount();
    this.jSq.a(paramView, paramInt - i, paramLong, this.sYg, FMessageConversationUI.c(this.sYg));
    AppMethodBeat.o(25361);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.4
 * JD-Core Version:    0.7.0.1
 */