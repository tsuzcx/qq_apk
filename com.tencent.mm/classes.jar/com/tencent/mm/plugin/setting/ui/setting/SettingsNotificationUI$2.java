package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SettingsNotificationUI$2
  implements DialogInterface.OnClickListener
{
  SettingsNotificationUI$2(SettingsNotificationUI paramSettingsNotificationUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    f.bv(false);
    paramDialogInterface = new bi();
    paramDialogInterface.fA(2);
    paramDialogInterface.bg(System.currentTimeMillis());
    paramDialogInterface.setType(1);
    paramDialogInterface.ec("weixin");
    paramDialogInterface.setContent(this.nVj.mController.uMN.getString(a.i.settings_new_voip_msg_weixin_close_tips, new Object[] { Build.MODEL }));
    bd.h(paramDialogInterface);
    paramDialogInterface = ((j)g.r(j.class)).FB().abv("weixin");
    if (paramDialogInterface != null)
    {
      paramDialogInterface.setContent(this.nVj.mController.uMN.getString(a.i.settings_new_voip_msg_weixin_close_tips, new Object[] { Build.MODEL }));
      paramDialogInterface.fy(paramDialogInterface.field_unReadCount + 1);
      ((j)g.r(j.class)).FB().a(paramDialogInterface, "weixin");
    }
    for (;;)
    {
      h.nFQ.a(500L, 3L, 1L, false);
      com.tencent.mm.model.as.j(false, true);
      return;
      paramDialogInterface = new ak();
      paramDialogInterface.setContent(this.nVj.mController.uMN.getString(a.i.settings_new_voip_msg_weixin_close_tips, new Object[] { Build.MODEL }));
      paramDialogInterface.setUsername("weixin");
      paramDialogInterface.fy(1);
      ((j)g.r(j.class)).FB().d(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.2
 * JD-Core Version:    0.7.0.1
 */