package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

final class SettingsChattingUI$2$2
  implements DialogInterface.OnClickListener
{
  SettingsChattingUI$2$2(SettingsChattingUI.2 param2, ArrayList paramArrayList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(4), "" });
    SettingsChattingUI.a(this.nUg.nUf, true);
    if (this.nUh.size() <= 1)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("Chat_User", (String)this.nUh.get(0));
      paramDialogInterface.addFlags(67108864);
      d.e(this.nUg.nUf, ".ui.chatting.ChattingUI", paramDialogInterface);
      return;
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.putStringArrayListExtra("key_conversation_list", this.nUh);
    d.e(this.nUg.nUf, ".ui.conversation.SettingCheckUnProcessWalletConvUI", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2.2
 * JD-Core Version:    0.7.0.1
 */