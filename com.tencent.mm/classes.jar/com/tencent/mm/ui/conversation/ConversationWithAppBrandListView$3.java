package com.tencent.mm.ui.conversation;

import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$3
  implements AppBrandRecentView.e
{
  ConversationWithAppBrandListView$3(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void mH(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0) {
      ConversationWithAppBrandListView.b(this.vRV, true);
    }
    for (;;)
    {
      ConversationWithAppBrandListView.a(this.vRV, paramInt);
      return;
      ConversationWithAppBrandListView.b(this.vRV, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.3
 * JD-Core Version:    0.7.0.1
 */