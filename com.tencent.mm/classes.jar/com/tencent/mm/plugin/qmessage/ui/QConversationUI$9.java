package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class QConversationUI$9
  implements AdapterView.OnItemClickListener
{
  QConversationUI$9(QConversationUI paramQConversationUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ak)QConversationUI.b(this.ncU).getItem(paramInt);
    paramView = new Intent();
    paramView.addFlags(67108864);
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("key_need_send_video", false);
    a.eUR.e(paramView, this.ncU.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.9
 * JD-Core Version:    0.7.0.1
 */