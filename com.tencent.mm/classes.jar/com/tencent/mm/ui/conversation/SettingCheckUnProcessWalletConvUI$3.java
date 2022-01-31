package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.as;

final class SettingCheckUnProcessWalletConvUI$3
  implements AdapterView.OnItemClickListener
{
  SettingCheckUnProcessWalletConvUI$3(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = SettingCheckUnProcessWalletConvUI.b(this.vUd).HS(paramInt);
    if (paramAdapterView == null) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("chat_from_scene", 4);
    d.e(this.vUd, ".ui.chatting.ChattingUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.3
 * JD-Core Version:    0.7.0.1
 */