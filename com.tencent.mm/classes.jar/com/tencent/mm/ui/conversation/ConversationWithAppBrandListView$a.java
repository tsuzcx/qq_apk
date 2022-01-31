package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$a
  implements Runnable
{
  ConversationWithAppBrandListView$a(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void run()
  {
    View localView = this.vRV.getChildAt(0);
    if ((this.vRV.getFirstVisiblePosition() != 0) || (localView == null) || (localView.getTop() >= 0)) {
      return;
    }
    y.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
    if (localView.getBottom() >= ConversationWithAppBrandListView.r(this.vRV))
    {
      ConversationWithAppBrandListView.s(this.vRV);
      return;
    }
    ConversationWithAppBrandListView.t(this.vRV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.a
 * JD-Core Version:    0.7.0.1
 */