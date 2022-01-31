package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

final class ConversationWithAppBrandListView$23
  implements AdapterView.OnItemLongClickListener
{
  ConversationWithAppBrandListView$23(ConversationWithAppBrandListView paramConversationWithAppBrandListView, AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt == 0) && (ConversationWithAppBrandListView.b(this.vRV))) {}
    while (this.vSd == null) {
      return false;
    }
    return this.vSd.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.23
 * JD-Core Version:    0.7.0.1
 */