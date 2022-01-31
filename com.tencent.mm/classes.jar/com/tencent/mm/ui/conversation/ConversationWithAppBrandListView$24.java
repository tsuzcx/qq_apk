package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$24
  implements Runnable
{
  ConversationWithAppBrandListView$24(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(34292);
    if (ConversationWithAppBrandListView.c(this.AjJ) != null)
    {
      ab.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
      ConversationWithAppBrandListView.c(this.AjJ).aQi();
    }
    if (ConversationWithAppBrandListView.d(this.AjJ) != null) {
      ConversationWithAppBrandListView.d(this.AjJ).smoothScrollToPosition(0);
    }
    View localView = this.AjJ.getChildAt(0);
    if (localView == null) {}
    for (int i = 0;; i = localView.getBottom())
    {
      if (i != 0) {
        this.AjJ.smoothScrollBy(i, 0);
      }
      this.AjJ.setSelection(0);
      ConversationWithAppBrandListView.e(this.AjJ);
      AppMethodBeat.o(34292);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.24
 * JD-Core Version:    0.7.0.1
 */