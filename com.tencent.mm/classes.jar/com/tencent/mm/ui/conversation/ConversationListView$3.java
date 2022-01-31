package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

final class ConversationListView$3
  implements AdapterView.OnItemLongClickListener
{
  ConversationListView$3(ConversationListView paramConversationListView) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ConversationListView.a(this.vQR) != null) && (!ConversationListView.b(this.vQR))) {
      return ConversationListView.a(this.vQR).onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.3
 * JD-Core Version:    0.7.0.1
 */