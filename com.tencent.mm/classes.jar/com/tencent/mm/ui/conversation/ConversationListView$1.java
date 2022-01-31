package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.sdk.platformtools.c;

final class ConversationListView$1
  implements Runnable
{
  ConversationListView$1(ConversationListView paramConversationListView) {}
  
  public final void run()
  {
    ConversationListView.a(this.vQR, c.q(this.vQR.getContext().getResources().getDrawable(R.k.app_brand_desktop_bottom_close_icon)));
    ConversationListView.a(this.vQR, (NinePatchDrawable)this.vQR.getResources().getDrawable(R.g.app_brand_desktop_bottom_gradient));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.1
 * JD-Core Version:    0.7.0.1
 */