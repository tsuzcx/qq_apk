package com.tencent.mm.ui.conversation;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ap;

final class ConversationWithAppBrandListView$19
  implements Runnable
{
  ConversationWithAppBrandListView$19(ConversationWithAppBrandListView paramConversationWithAppBrandListView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public final void run()
  {
    AppMethodBeat.i(38415);
    this.Hdo.topMargin = ap.dL(this.Hdk.getContext());
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", new Object[] { Integer.valueOf(this.Hdo.topMargin) });
    AppMethodBeat.o(38415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.19
 * JD-Core Version:    0.7.0.1
 */