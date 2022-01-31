package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$25
  implements Runnable
{
  ConversationWithAppBrandListView$25(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    if (ConversationWithAppBrandListView.c(this.vRV) != null)
    {
      y.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
      ConversationWithAppBrandListView.c(this.vRV).arw();
    }
    if (ConversationWithAppBrandListView.d(this.vRV) != null) {
      ConversationWithAppBrandListView.d(this.vRV).smoothScrollToPosition(0);
    }
    View localView = this.vRV.getChildAt(0);
    if (localView == null) {}
    for (int i = 0;; i = localView.getBottom())
    {
      if (i != 0) {
        this.vRV.smoothScrollBy(i, 0);
      }
      this.vRV.setSelection(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.25
 * JD-Core Version:    0.7.0.1
 */