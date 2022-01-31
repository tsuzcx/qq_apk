package com.tencent.mm.ui.conversation;

import android.database.DataSetObserver;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$11
  extends DataSetObserver
{
  int AjL = -1;
  
  ConversationWithAppBrandListView$11(ConversationWithAppBrandListView paramConversationWithAppBrandListView, ListAdapter paramListAdapter) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(34277);
    boolean bool;
    if (this.AjL != this.AjM.getCount())
    {
      if (this.AjL <= this.AjM.getCount()) {
        break label108;
      }
      bool = true;
      ab.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
      if (this.AjL <= this.AjM.getCount()) {
        break label113;
      }
      ConversationWithAppBrandListView.a(this.AjJ, false);
      ConversationWithAppBrandListView.a(this.AjJ, true);
    }
    for (;;)
    {
      this.AjL = this.AjM.getCount();
      AppMethodBeat.o(34277);
      return;
      label108:
      bool = false;
      break;
      label113:
      ConversationWithAppBrandListView.a(this.AjJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.11
 * JD-Core Version:    0.7.0.1
 */