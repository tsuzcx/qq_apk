package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.c.a;

final class ChatroomContactUI$12
  implements AdapterView.OnItemLongClickListener
{
  ChatroomContactUI$12(ChatroomContactUI paramChatroomContactUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33584);
    ab.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramInt)));
    if (paramInt < ChatroomContactUI.b(this.AbH).getHeaderViewsCount())
    {
      ab.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
      AppMethodBeat.o(33584);
      return true;
    }
    if ((ChatroomContactUI.d(this.AbH) != null) && (ChatroomContactUI.d(this.AbH).ABF))
    {
      AppMethodBeat.o(33584);
      return true;
    }
    paramAdapterView = ((ad)ChatroomContactUI.f(this.AbH).getItem(paramInt - ChatroomContactUI.b(this.AbH).getHeaderViewsCount())).field_username;
    if ((t.ot(paramAdapterView)) || (t.ou(paramAdapterView)))
    {
      AppMethodBeat.o(33584);
      return true;
    }
    ChatroomContactUI.c(this.AbH, paramAdapterView);
    ChatroomContactUI.j(this.AbH).a(paramView, paramInt, paramLong, this.AbH, ChatroomContactUI.g(this.AbH), ChatroomContactUI.h(this.AbH), ChatroomContactUI.i(this.AbH));
    AppMethodBeat.o(33584);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.12
 * JD-Core Version:    0.7.0.1
 */