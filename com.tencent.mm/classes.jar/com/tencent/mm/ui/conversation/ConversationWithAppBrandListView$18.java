package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$18
  implements Runnable
{
  ConversationWithAppBrandListView$18(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(34285);
    View localView = this.AjJ.getChildAt(0);
    if (localView == null) {}
    for (int i = 0;; i = localView.getBottom())
    {
      ab.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(i)));
      this.AjJ.smoothScrollToPositionFromTop(this.AjJ.getFirstHeaderVisible(), 0, 300);
      ConversationWithAppBrandListView.q(this.AjJ);
      AppMethodBeat.o(34285);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.18
 * JD-Core Version:    0.7.0.1
 */