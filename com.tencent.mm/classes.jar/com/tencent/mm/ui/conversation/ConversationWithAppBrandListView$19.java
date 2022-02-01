package com.tencent.mm.ui.conversation;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ap;

final class ConversationWithAppBrandListView$19
  implements Runnable
{
  ConversationWithAppBrandListView$19(ConversationWithAppBrandListView paramConversationWithAppBrandListView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public final void run()
  {
    AppMethodBeat.i(38415);
    this.IDB.topMargin = ap.dT(this.IDx.getContext());
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", new Object[] { Integer.valueOf(this.IDB.topMargin) });
    AppMethodBeat.o(38415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.19
 * JD-Core Version:    0.7.0.1
 */