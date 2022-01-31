package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

final class SettingsChattingUI$2$2
  implements DialogInterface.OnClickListener
{
  SettingsChattingUI$2$2(SettingsChattingUI.2 param2, ArrayList paramArrayList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127211);
    h.qsU.e(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(4), "" });
    SettingsChattingUI.a(this.qIg.qIf, true);
    if (this.qIh.size() <= 1)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("Chat_User", (String)this.qIh.get(0));
      paramDialogInterface.addFlags(67108864);
      d.f(this.qIg.qIf, ".ui.chatting.ChattingUI", paramDialogInterface);
      AppMethodBeat.o(127211);
      return;
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.putStringArrayListExtra("key_conversation_list", this.qIh);
    d.f(this.qIg.qIf, ".ui.conversation.SettingCheckUnProcessWalletConvUI", paramDialogInterface);
    AppMethodBeat.o(127211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2.2
 * JD-Core Version:    0.7.0.1
 */