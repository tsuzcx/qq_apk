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

final class SettingsAboutMicroMsgUI$3$1
  implements Runnable
{
  SettingsAboutMicroMsgUI$3$1(SettingsAboutMicroMsgUI.3 param3, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    g.Dk().b(255, SettingsAboutMicroMsgUI.c(this.nTj.nTg));
    SettingsAboutMicroMsgUI.d(this.nTj.nTg);
    if (SettingsAboutMicroMsgUI.e(this.nTj.nTg) != null)
    {
      SettingsAboutMicroMsgUI.e(this.nTj.nTg).stopTimer();
      SettingsAboutMicroMsgUI.f(this.nTj.nTg);
    }
    if (SettingsAboutMicroMsgUI.a(this.nTj.nTg) != null) {
      SettingsAboutMicroMsgUI.a(this.nTj.nTg).dismiss();
    }
    if ((this.bEe.getType() == 255) && (((r)this.bEe).ezR == 1))
    {
      if ((this.bEg == -3) && (this.bEf == 4))
      {
        Intent localIntent = new Intent(this.nTj.nTg.mController.uMN, RegByMobileSetPwdUI.class);
        localIntent.putExtra("kintent_hint", this.nTj.nTg.getString(a.i.regbymobile_reg_setpwd_tip_when_logout));
        this.nTj.nTg.startActivityForResult(localIntent, 0);
      }
    }
    else {
      return;
    }
    SettingsAboutMicroMsgUI.g(this.nTj.nTg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.3.1
 * JD-Core Version:    0.7.0.1
 */