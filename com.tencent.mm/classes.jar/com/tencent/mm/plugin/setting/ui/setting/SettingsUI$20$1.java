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

final class SettingsUI$20$1
  implements Runnable
{
  SettingsUI$20$1(SettingsUI.20 param20, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    g.Dk().b(255, SettingsUI.r(this.nWF.nWB));
    SettingsUI.s(this.nWF.nWB);
    if (SettingsUI.t(this.nWF.nWB) != null)
    {
      SettingsUI.t(this.nWF.nWB).stopTimer();
      SettingsUI.u(this.nWF.nWB);
    }
    if (SettingsUI.p(this.nWF.nWB) != null) {
      SettingsUI.p(this.nWF.nWB).dismiss();
    }
    if ((this.bEe.getType() == 255) && (((r)this.bEe).ezR == 1))
    {
      if ((this.bEg == -3) && (this.bEf == 4))
      {
        Intent localIntent = new Intent(this.nWF.nWB.mController.uMN, RegByMobileSetPwdUI.class);
        localIntent.putExtra("kintent_hint", this.nWF.nWB.getString(a.i.regbymobile_reg_setpwd_tip_when_logout));
        this.nWF.nWB.startActivityForResult(localIntent, 0);
      }
    }
    else {
      return;
    }
    SettingsUI.C(this.nWF.nWB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.20.1
 * JD-Core Version:    0.7.0.1
 */