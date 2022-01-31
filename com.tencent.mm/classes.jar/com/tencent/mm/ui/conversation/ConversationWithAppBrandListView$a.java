package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$a
  implements Runnable
{
  ConversationWithAppBrandListView$a(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(34293);
    View localView = this.AjJ.getChildAt(0);
    if ((this.AjJ.getFirstVisiblePosition() == 0) && (localView != null))
    {
      if (localView.getTop() >= 0)
      {
        AppMethodBeat.o(34293);
        return;
      }
      ab.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
      if (localView.getBottom() >= ConversationWithAppBrandListView.r(this.AjJ))
      {
        ConversationWithAppBrandListView.s(this.AjJ);
        AppMethodBeat.o(34293);
        return;
      }
      ConversationWithAppBrandListView.t(this.AjJ);
    }
    AppMethodBeat.o(34293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.a
 * JD-Core Version:    0.7.0.1
 */