package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.au;

final class SettingCheckUnProcessWalletConvUI$3
  implements AdapterView.OnItemClickListener
{
  SettingCheckUnProcessWalletConvUI$3(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34612);
    paramAdapterView = SettingCheckUnProcessWalletConvUI.b(this.AlZ).QE(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(34612);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("chat_from_scene", 4);
    d.f(this.AlZ, ".ui.chatting.ChattingUI", paramView);
    AppMethodBeat.o(34612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.3
 * JD-Core Version:    0.7.0.1
 */