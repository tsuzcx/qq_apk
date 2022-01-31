package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsUI$20$1
  implements Runnable
{
  SettingsUI$20$1(SettingsUI.20 param20, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(127582);
    g.Rc().b(255, SettingsUI.q(this.qKP.qKL));
    SettingsUI.r(this.qKP.qKL);
    if (SettingsUI.s(this.qKP.qKL) != null)
    {
      SettingsUI.s(this.qKP.qKL).stopTimer();
      SettingsUI.t(this.qKP.qKL);
    }
    if (SettingsUI.o(this.qKP.qKL) != null) {
      SettingsUI.o(this.qKP.qKL).dismiss();
    }
    if ((this.ckS.getType() == 255) && (((t)this.ckS).fPH == 1))
    {
      if ((this.val$errCode == -3) && (this.val$errType == 4))
      {
        Intent localIntent = new Intent(this.qKP.qKL.getContext(), RegByMobileSetPwdUI.class);
        localIntent.putExtra("kintent_hint", this.qKP.qKL.getString(2131302457));
        this.qKP.qKL.startActivityForResult(localIntent, 0);
        AppMethodBeat.o(127582);
        return;
      }
      SettingsUI.B(this.qKP.qKL);
    }
    AppMethodBeat.o(127582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.20.1
 * JD-Core Version:    0.7.0.1
 */