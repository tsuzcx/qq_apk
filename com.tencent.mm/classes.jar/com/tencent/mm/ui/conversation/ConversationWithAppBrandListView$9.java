package com.tencent.mm.ui.conversation;

import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$9
  implements Runnable
{
  ConversationWithAppBrandListView$9(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    if (ConversationWithAppBrandListView.c(this.vRV) != null)
    {
      y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
      ConversationWithAppBrandListView.c(this.vRV).arw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.9
 * JD-Core Version:    0.7.0.1
 */