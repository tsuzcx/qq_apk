package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$4
  implements AppBrandRecentView.e
{
  ConversationWithAppBrandListView$4(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void qj(int paramInt)
  {
    AppMethodBeat.i(34269);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0) {
      ConversationWithAppBrandListView.b(this.AjJ, true);
    }
    for (;;)
    {
      ConversationWithAppBrandListView.a(this.AjJ, paramInt);
      AppMethodBeat.o(34269);
      return;
      ConversationWithAppBrandListView.b(this.AjJ, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.4
 * JD-Core Version:    0.7.0.1
 */