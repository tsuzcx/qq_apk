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

final class SettingsAboutMicroMsgUI$3$1
  implements Runnable
{
  SettingsAboutMicroMsgUI$3$1(SettingsAboutMicroMsgUI.3 param3, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(127092);
    g.Rc().b(255, SettingsAboutMicroMsgUI.c(this.qHj.qHg));
    SettingsAboutMicroMsgUI.d(this.qHj.qHg);
    if (SettingsAboutMicroMsgUI.e(this.qHj.qHg) != null)
    {
      SettingsAboutMicroMsgUI.e(this.qHj.qHg).stopTimer();
      SettingsAboutMicroMsgUI.f(this.qHj.qHg);
    }
    if (SettingsAboutMicroMsgUI.a(this.qHj.qHg) != null) {
      SettingsAboutMicroMsgUI.a(this.qHj.qHg).dismiss();
    }
    if ((this.ckS.getType() == 255) && (((t)this.ckS).fPH == 1))
    {
      if ((this.val$errCode == -3) && (this.val$errType == 4))
      {
        Intent localIntent = new Intent(this.qHj.qHg.getContext(), RegByMobileSetPwdUI.class);
        localIntent.putExtra("kintent_hint", this.qHj.qHg.getString(2131302457));
        this.qHj.qHg.startActivityForResult(localIntent, 0);
        AppMethodBeat.o(127092);
        return;
      }
      SettingsAboutMicroMsgUI.g(this.qHj.qHg);
    }
    AppMethodBeat.o(127092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.3.1
 * JD-Core Version:    0.7.0.1
 */