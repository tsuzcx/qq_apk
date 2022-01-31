package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$19
  implements Runnable
{
  ConversationWithAppBrandListView$19(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    View localView = this.vRV.getChildAt(0);
    if (localView == null) {}
    for (int i = 0;; i = localView.getBottom())
    {
      y.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: " + i);
      this.vRV.smoothScrollToPositionFromTop(this.vRV.getFirstHeaderVisible(), 0, 300);
      ConversationWithAppBrandListView.q(this.vRV);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.19
 * JD-Core Version:    0.7.0.1
 */