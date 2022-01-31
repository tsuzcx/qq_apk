package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.tools.l;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10
  implements AdapterView.OnItemLongClickListener
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33995);
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(this.AgB, (ak)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.AgB).getItem(paramInt));
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(this.AgB, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$400(this.AgB).field_username);
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$700(this.AgB).a(paramView, paramInt, paramLong, this.AgB, this.AgB);
    AppMethodBeat.o(33995);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.10
 * JD-Core Version:    0.7.0.1
 */