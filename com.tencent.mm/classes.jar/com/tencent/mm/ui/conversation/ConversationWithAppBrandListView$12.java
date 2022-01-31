package com.tencent.mm.ui.conversation;

import android.database.DataSetObserver;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationWithAppBrandListView$12
  extends DataSetObserver
{
  int vSa = -1;
  
  ConversationWithAppBrandListView$12(ConversationWithAppBrandListView paramConversationWithAppBrandListView, ListAdapter paramListAdapter) {}
  
  public final void onChanged()
  {
    boolean bool;
    if (this.vSa != this.vSb.getCount())
    {
      if (this.vSa <= this.vSb.getCount()) {
        break label98;
      }
      bool = true;
      y.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
      if (this.vSa <= this.vSb.getCount()) {
        break label103;
      }
      ConversationWithAppBrandListView.a(this.vRV, false);
      ConversationWithAppBrandListView.a(this.vRV, true);
    }
    for (;;)
    {
      this.vSa = this.vSb.getCount();
      return;
      label98:
      bool = false;
      break;
      label103:
      ConversationWithAppBrandListView.a(this.vRV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.12
 * JD-Core Version:    0.7.0.1
 */