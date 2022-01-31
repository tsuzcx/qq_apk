package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class SettingsChattingUI$2
  implements DialogInterface.OnClickListener
{
  SettingsChattingUI$2(SettingsChattingUI paramSettingsChattingUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(2), "" });
    com.tencent.mm.plugin.report.service.h.nFQ.a(324L, 0L, 1L, false);
    SettingsChattingUI.a(this.nUf, false);
    paramDialogInterface = this.nUf;
    Object localObject = this.nUf;
    this.nUf.getString(a.i.app_tip);
    SettingsChattingUI.a(paramDialogInterface, com.tencent.mm.ui.base.h.b((Context)localObject, this.nUf.getString(a.i.app_waiting), true, new SettingsChattingUI.2.1(this)));
    paramDialogInterface = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bie();
    if (paramDialogInterface != null)
    {
      y.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", new Object[] { Integer.valueOf(paramDialogInterface.size()) });
      localObject = new HashSet();
      paramDialogInterface = paramDialogInterface.iterator();
      while (paramDialogInterface.hasNext())
      {
        bi localbi = (bi)paramDialogInterface.next();
        if ((!((Set)localObject).contains(localbi.field_talker)) && (((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(localbi.field_talker) != null) && (e.af(localbi))) {
          ((Set)localObject).add(localbi.field_talker);
        }
      }
      paramDialogInterface = new ArrayList();
      paramDialogInterface.addAll((Collection)localObject);
    }
    while ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      SettingsChattingUI.a(this.nUf).dismiss();
      com.tencent.mm.ui.base.h.a(this.nUf, false, this.nUf.getString(a.i.wallet_clearall_conversation_note, new Object[] { Integer.valueOf(paramDialogInterface.size()) }), null, this.nUf.getString(a.i.goto_conversation), this.nUf.getString(a.i.clearall_conversation), new SettingsChattingUI.2.2(this, paramDialogInterface), new SettingsChattingUI.2.3(this), -1, a.c.alert_btn_color_warn);
      return;
      paramDialogInterface = null;
    }
    SettingsChattingUI.b(this.nUf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2
 * JD-Core Version:    0.7.0.1
 */