package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(127213);
    com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(2), "" });
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(324L, 0L, 1L, false);
    SettingsChattingUI.a(this.qIf, false);
    paramDialogInterface = this.qIf;
    Object localObject = this.qIf;
    this.qIf.getString(2131297087);
    SettingsChattingUI.a(paramDialogInterface, com.tencent.mm.ui.base.h.b((Context)localObject, this.qIf.getString(2131297112), true, new SettingsChattingUI.2.1(this)));
    paramDialogInterface = ((j)g.E(j.class)).bPQ().bQg();
    if (paramDialogInterface != null)
    {
      ab.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", new Object[] { Integer.valueOf(paramDialogInterface.size()) });
      localObject = new HashSet();
      paramDialogInterface = paramDialogInterface.iterator();
      while (paramDialogInterface.hasNext())
      {
        bi localbi = (bi)paramDialogInterface.next();
        if ((!((Set)localObject).contains(localbi.field_talker)) && (((j)g.E(j.class)).YF().arH(localbi.field_talker) != null) && (f.am(localbi))) {
          ((Set)localObject).add(localbi.field_talker);
        }
      }
      paramDialogInterface = new ArrayList();
      paramDialogInterface.addAll((Collection)localObject);
    }
    while ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      SettingsChattingUI.a(this.qIf).dismiss();
      com.tencent.mm.ui.base.h.a(this.qIf, false, this.qIf.getString(2131305021, new Object[] { Integer.valueOf(paramDialogInterface.size()) }), null, this.qIf.getString(2131300537), this.qIf.getString(2131298414), new SettingsChattingUI.2.2(this, paramDialogInterface), new SettingsChattingUI.2.3(this), -1, 2131689667);
      AppMethodBeat.o(127213);
      return;
      paramDialogInterface = null;
    }
    SettingsChattingUI.b(this.qIf);
    AppMethodBeat.o(127213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2
 * JD-Core Version:    0.7.0.1
 */