package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.tools.j;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10
  implements AdapterView.OnItemLongClickListener
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(this.vOR, (ak)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.vOR).getItem(paramInt));
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(this.vOR, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$400(this.vOR).field_username);
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$700(this.vOR).a(paramView, paramInt, paramLong, this.vOR, this.vOR);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.10
 * JD-Core Version:    0.7.0.1
 */