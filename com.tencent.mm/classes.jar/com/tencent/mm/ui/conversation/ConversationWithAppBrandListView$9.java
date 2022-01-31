package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$9
  implements Runnable
{
  ConversationWithAppBrandListView$9(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(34275);
    if (ConversationWithAppBrandListView.c(this.AjJ) != null)
    {
      ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
      ConversationWithAppBrandListView.c(this.AjJ).aQi();
    }
    AppMethodBeat.o(34275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.9
 * JD-Core Version:    0.7.0.1
 */