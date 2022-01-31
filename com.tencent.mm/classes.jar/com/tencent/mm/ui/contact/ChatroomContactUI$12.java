package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.b.a;

final class ChatroomContactUI$12
  implements AdapterView.OnItemLongClickListener
{
  ChatroomContactUI$12(ChatroomContactUI paramChatroomContactUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + paramInt);
    if (paramInt < ChatroomContactUI.b(this.vKh).getHeaderViewsCount())
    {
      y.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
      return true;
    }
    if ((ChatroomContactUI.d(this.vKh) != null) && (ChatroomContactUI.d(this.vKh).wiO)) {
      return true;
    }
    paramAdapterView = ((ad)ChatroomContactUI.f(this.vKh).getItem(paramInt - ChatroomContactUI.b(this.vKh).getHeaderViewsCount())).field_username;
    if ((s.hK(paramAdapterView)) || (s.hL(paramAdapterView))) {
      return true;
    }
    ChatroomContactUI.c(this.vKh, paramAdapterView);
    ChatroomContactUI.j(this.vKh).a(paramView, paramInt, paramLong, this.vKh, ChatroomContactUI.g(this.vKh), ChatroomContactUI.h(this.vKh), ChatroomContactUI.i(this.vKh));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.12
 * JD-Core Version:    0.7.0.1
 */