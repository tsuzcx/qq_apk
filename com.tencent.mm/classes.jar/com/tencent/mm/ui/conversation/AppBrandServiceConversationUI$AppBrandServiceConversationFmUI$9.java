package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9
  implements AdapterView.OnItemClickListener
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(this.vOR, (ak)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.vOR).getItem(paramInt));
    paramAdapterView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$400(this.vOR);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.vOR).getCount()) });
      AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$100(this.vOR).notifyDataSetChanged();
      return;
    }
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(this.vOR, paramAdapterView.field_username);
    paramView = new Bundle();
    paramView.putBoolean("finish_direct", false);
    paramView.putBoolean("key_need_send_video", false);
    paramView.putString("key_scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$000(this.vOR));
    paramView.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$600(this.vOR));
    this.vOR.ui.startChatting(paramAdapterView.field_username, paramView, true);
    this.vOR.entryCustomerMsgDialogReport(paramAdapterView.field_username, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$600(this.vOR));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.9
 * JD-Core Version:    0.7.0.1
 */