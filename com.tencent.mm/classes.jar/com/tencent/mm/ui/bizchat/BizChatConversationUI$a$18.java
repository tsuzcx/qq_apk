package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ai.a.a;

final class BizChatConversationUI$a$18
  implements AdapterView.OnItemClickListener
{
  BizChatConversationUI$a$18(BizChatConversationUI.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (a)BizChatConversationUI.a.b(this.veW).getItem(paramInt);
    BizChatConversationUI.a.b(this.veW, paramAdapterView.field_bizChatId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.18
 * JD-Core Version:    0.7.0.1
 */