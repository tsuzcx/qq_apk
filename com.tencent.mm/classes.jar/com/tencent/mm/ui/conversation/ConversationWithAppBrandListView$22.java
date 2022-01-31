package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class ConversationWithAppBrandListView$22
  implements AdapterView.OnItemClickListener
{
  ConversationWithAppBrandListView$22(ConversationWithAppBrandListView paramConversationWithAppBrandListView, AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.vSc != null) {
      this.vSc.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    if (!ConversationWithAppBrandListView.b(this.vRV)) {}
    while (this.vRV.getFirstVisiblePosition() != 0) {
      return;
    }
    this.vRV.A(500L, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.22
 * JD-Core Version:    0.7.0.1
 */