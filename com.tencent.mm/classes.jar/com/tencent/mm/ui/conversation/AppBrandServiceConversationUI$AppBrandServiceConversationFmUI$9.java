package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9
  implements AdapterView.OnItemClickListener
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33994);
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(this.AgB, (ak)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.AgB).getItem(paramInt));
    paramAdapterView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$400(this.AgB);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.AgB).getCount()) });
      AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.AgB).notifyDataSetChanged();
      AppMethodBeat.o(33994);
      return;
    }
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(this.AgB, paramAdapterView.field_username);
    paramView = new Bundle();
    paramView.putBoolean("finish_direct", false);
    paramView.putBoolean("key_need_send_video", false);
    paramView.putString("key_scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$000(this.AgB));
    paramView.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$600(this.AgB));
    this.AgB.ui.startChatting(paramAdapterView.field_username, paramView, true);
    this.AgB.entryCustomerMsgDialogReport(paramAdapterView.field_username, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$600(this.AgB));
    AppMethodBeat.o(33994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.9
 * JD-Core Version:    0.7.0.1
 */