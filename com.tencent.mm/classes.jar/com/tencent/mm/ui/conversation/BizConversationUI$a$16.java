package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;

final class BizConversationUI$a$16
  implements AdapterView.OnItemClickListener
{
  BizConversationUI$a$16(BizConversationUI.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BizConversationUI.a.a(this.vPu, (ak)BizConversationUI.a.e(this.vPu).getItem(paramInt));
    BizConversationUI.a.a(this.vPu, BizConversationUI.a.f(this.vPu).field_username);
    paramAdapterView = BizConversationUI.a.f(this.vPu);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BizConversationUI.a.e(this.vPu).getCount()) });
      BizConversationUI.a.e(this.vPu).notifyDataSetChanged();
      return;
    }
    paramView = new Bundle();
    paramView.putInt("biz_click_item_unread_count", BizConversationUI.a.f(this.vPu).field_unReadCount);
    paramView.putInt("biz_click_item_position", paramInt + 1);
    paramView.putInt("KOpenArticleSceneFromScene", 131);
    paramView.putInt("specific_chat_from_scene", 1);
    this.vPu.ui.startChatting(paramAdapterView.field_username, paramView, true);
    BizConversationUI.a.e(this.vPu).a(paramAdapterView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a.16
 * JD-Core Version:    0.7.0.1
 */