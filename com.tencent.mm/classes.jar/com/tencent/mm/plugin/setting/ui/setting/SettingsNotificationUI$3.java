package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;

final class SettingsNotificationUI$3
  implements DialogInterface.OnClickListener
{
  SettingsNotificationUI$3(SettingsNotificationUI paramSettingsNotificationUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127354);
    f.bU(false);
    paramDialogInterface = new bi();
    paramDialogInterface.hL(2);
    paramDialogInterface.fQ(System.currentTimeMillis());
    paramDialogInterface.setType(1);
    paramDialogInterface.kj("weixin");
    paramDialogInterface.setContent(this.qJo.getContext().getString(2131303348, new Object[] { Build.MODEL }));
    bf.l(paramDialogInterface);
    paramDialogInterface = ((j)g.E(j.class)).YF().arH("weixin");
    if (paramDialogInterface != null)
    {
      paramDialogInterface.setContent(this.qJo.getContext().getString(2131303348, new Object[] { Build.MODEL }));
      paramDialogInterface.hJ(paramDialogInterface.field_unReadCount + 1);
      ((j)g.E(j.class)).YF().a(paramDialogInterface, "weixin");
    }
    for (;;)
    {
      this.qJo.initView();
      h.qsU.idkeyStat(500L, 3L, 1L, false);
      com.tencent.mm.model.au.k(false, true);
      AppMethodBeat.o(127354);
      return;
      paramDialogInterface = new ak();
      paramDialogInterface.setContent(this.qJo.getContext().getString(2131303348, new Object[] { Build.MODEL }));
      paramDialogInterface.setUsername("weixin");
      paramDialogInterface.hJ(1);
      ((j)g.E(j.class)).YF().d(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.3
 * JD-Core Version:    0.7.0.1
 */