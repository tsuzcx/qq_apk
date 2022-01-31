package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.chatting.ChattingUI;

final class NewBizConversationUI$18
  implements AdapterView.OnItemClickListener
{
  NewBizConversationUI$18(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34553);
    NewBizConversationUI.a(this.AlC, (ak)NewBizConversationUI.e(this.AlC).getItem(paramInt));
    NewBizConversationUI.a(this.AlC, NewBizConversationUI.g(this.AlC).field_username);
    paramAdapterView = NewBizConversationUI.g(this.AlC);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(NewBizConversationUI.e(this.AlC).getCount()) });
      NewBizConversationUI.e(this.AlC).notifyDataSetChanged();
      AppMethodBeat.o(34553);
      return;
    }
    paramView = new Intent(this.AlC, ChattingUI.class);
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("biz_click_item_unread_count", NewBizConversationUI.g(this.AlC).field_unReadCount);
    paramView.putExtra("biz_click_item_position", paramInt + 1);
    paramView.putExtra("KOpenArticleSceneFromScene", 92);
    paramView.putExtra("specific_chat_from_scene", 6);
    this.AlC.startActivity(paramView);
    NewBizConversationUI.e(this.AlC).a(paramAdapterView, paramInt);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.18
 * JD-Core Version:    0.7.0.1
 */