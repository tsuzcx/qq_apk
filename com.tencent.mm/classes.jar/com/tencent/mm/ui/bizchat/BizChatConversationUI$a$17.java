package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.widget.b.a;

final class BizChatConversationUI$a$17
  implements AdapterView.OnItemLongClickListener
{
  BizChatConversationUI$a$17(BizChatConversationUI.a parama, a parama1) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.ncV.a(paramView, paramInt, paramLong, this.veW, BizChatConversationUI.a.f(this.veW), BizChatConversationUI.a.g(this.veW), BizChatConversationUI.a.h(this.veW));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.17
 * JD-Core Version:    0.7.0.1
 */