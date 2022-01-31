package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.widget.b.a;

final class NewBizConversationUI$3
  implements AdapterView.OnItemLongClickListener
{
  NewBizConversationUI$3(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    NewBizConversationUI.a(this.vTG, (ak)NewBizConversationUI.e(this.vTG).getItem(paramInt));
    NewBizConversationUI.a(this.vTG, NewBizConversationUI.g(this.vTG).field_username);
    NewBizConversationUI.k(this.vTG).a(paramView, paramInt, paramLong, this.vTG, NewBizConversationUI.h(this.vTG), NewBizConversationUI.i(this.vTG), NewBizConversationUI.j(this.vTG));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.3
 * JD-Core Version:    0.7.0.1
 */