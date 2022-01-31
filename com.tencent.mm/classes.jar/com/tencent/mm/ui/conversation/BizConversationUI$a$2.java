package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.widget.b.a;

final class BizConversationUI$a$2
  implements AdapterView.OnItemLongClickListener
{
  BizConversationUI$a$2(BizConversationUI.a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BizConversationUI.a.a(this.vPu, (ak)BizConversationUI.a.e(this.vPu).getItem(paramInt));
    BizConversationUI.a.a(this.vPu, BizConversationUI.a.f(this.vPu).field_username);
    BizConversationUI.a.j(this.vPu).a(paramView, paramInt, paramLong, this.vPu, BizConversationUI.a.g(this.vPu), BizConversationUI.a.h(this.vPu), BizConversationUI.a.i(this.vPu));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a.2
 * JD-Core Version:    0.7.0.1
 */