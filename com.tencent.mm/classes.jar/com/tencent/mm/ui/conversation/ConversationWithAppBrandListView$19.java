package com.tencent.mm.ui.conversation;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

final class ConversationWithAppBrandListView$19
  implements Runnable
{
  ConversationWithAppBrandListView$19(ConversationWithAppBrandListView paramConversationWithAppBrandListView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public final void run()
  {
    AppMethodBeat.i(34286);
    this.AjN.topMargin = am.di(this.AjJ.getContext());
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", new Object[] { Integer.valueOf(this.AjN.topMargin) });
    AppMethodBeat.o(34286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.19
 * JD-Core Version:    0.7.0.1
 */