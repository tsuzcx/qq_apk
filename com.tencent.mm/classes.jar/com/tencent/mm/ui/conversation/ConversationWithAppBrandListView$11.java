package com.tencent.mm.ui.conversation;

import android.database.DataSetObserver;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class ConversationWithAppBrandListView$11
  extends DataSetObserver
{
  int Hdm = -1;
  
  ConversationWithAppBrandListView$11(ConversationWithAppBrandListView paramConversationWithAppBrandListView, ListAdapter paramListAdapter) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(38406);
    boolean bool;
    if (this.Hdm != this.Hdn.getCount())
    {
      if (this.Hdm <= this.Hdn.getCount()) {
        break label108;
      }
      bool = true;
      ad.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
      if (this.Hdm <= this.Hdn.getCount()) {
        break label113;
      }
      ConversationWithAppBrandListView.a(this.Hdk, false);
      ConversationWithAppBrandListView.a(this.Hdk, true);
    }
    for (;;)
    {
      this.Hdm = this.Hdn.getCount();
      AppMethodBeat.o(38406);
      return;
      label108:
      bool = false;
      break;
      label113:
      ConversationWithAppBrandListView.a(this.Hdk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.11
 * JD-Core Version:    0.7.0.1
 */