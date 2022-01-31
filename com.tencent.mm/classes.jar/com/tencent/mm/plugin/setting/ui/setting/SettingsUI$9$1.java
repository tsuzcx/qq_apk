package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SettingsUI$9$1
  implements Runnable
{
  SettingsUI$9$1(SettingsUI.9 param9, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    g.Dk().b(255, SettingsUI.r(this.nWC.nWB));
    SettingsUI.s(this.nWC.nWB);
    if (SettingsUI.t(this.nWC.nWB) != null)
    {
      SettingsUI.t(this.nWC.nWB).stopTimer();
      SettingsUI.u(this.nWC.nWB);
    }
    if (SettingsUI.p(this.nWC.nWB) != null) {
      SettingsUI.p(this.nWC.nWB).dismiss();
    }
    if ((this.bEe.getType() == 255) && (((r)this.bEe).ezR == 2))
    {
      if ((this.bEg == -3) && (this.bEf == 4))
      {
        Intent localIntent = new Intent(this.nWC.nWB.mController.uMN, RegByMobileSetPwdUI.class);
        localIntent.putExtra("kintent_hint", this.nWC.nWB.getString(a.i.regbymobile_reg_setpwd_tip_when_logout));
        this.nWC.nWB.startActivityForResult(localIntent, 5);
      }
    }
    else {
      return;
    }
    SettingsUI.v(this.nWC.nWB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.9.1
 * JD-Core Version:    0.7.0.1
 */