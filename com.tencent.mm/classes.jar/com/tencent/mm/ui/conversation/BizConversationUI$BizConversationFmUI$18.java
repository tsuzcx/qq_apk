package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;

final class BizConversationUI$BizConversationFmUI$18
  implements AdapterView.OnItemClickListener
{
  BizConversationUI$BizConversationFmUI$18(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34135);
    BizConversationUI.BizConversationFmUI.a(this.Ahf, (ak)BizConversationUI.BizConversationFmUI.e(this.Ahf).getItem(paramInt));
    BizConversationUI.BizConversationFmUI.a(this.Ahf, BizConversationUI.BizConversationFmUI.f(this.Ahf).field_username);
    paramAdapterView = BizConversationUI.BizConversationFmUI.f(this.Ahf);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BizConversationUI.BizConversationFmUI.e(this.Ahf).getCount()) });
      BizConversationUI.BizConversationFmUI.e(this.Ahf).notifyDataSetChanged();
      AppMethodBeat.o(34135);
      return;
    }
    paramView = new Bundle();
    paramView.putInt("biz_click_item_unread_count", BizConversationUI.BizConversationFmUI.f(this.Ahf).field_unReadCount);
    paramView.putInt("biz_click_item_position", paramInt + 1);
    paramView.putInt("KOpenArticleSceneFromScene", 131);
    paramView.putInt("specific_chat_from_scene", 1);
    this.Ahf.ui.startChatting(paramAdapterView.field_username, paramView, true);
    BizConversationUI.BizConversationFmUI.e(this.Ahf).a(paramAdapterView, paramInt);
    AppMethodBeat.o(34135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.18
 * JD-Core Version:    0.7.0.1
 */