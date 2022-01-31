package com.tencent.mm.ui.conversation;

import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$4
  implements AppBrandRecentView.e
{
  ConversationWithAppBrandListView$4(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void mH(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0) {
      ConversationWithAppBrandListView.c(this.vRV, true);
    }
    for (;;)
    {
      ConversationWithAppBrandListView.a(this.vRV, paramInt);
      return;
      ConversationWithAppBrandListView.c(this.vRV, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.4
 * JD-Core Version:    0.7.0.1
 */