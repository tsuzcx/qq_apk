package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsUI$9
  implements f
{
  SettingsUI$9(SettingsUI paramSettingsUI) {}
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final m paramm)
  {
    AppMethodBeat.i(127569);
    ab.d("MicroMsg.SettingsUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127568);
        g.Rc().b(255, SettingsUI.q(SettingsUI.9.this.qKL));
        SettingsUI.r(SettingsUI.9.this.qKL);
        if (SettingsUI.s(SettingsUI.9.this.qKL) != null)
        {
          SettingsUI.s(SettingsUI.9.this.qKL).stopTimer();
          SettingsUI.t(SettingsUI.9.this.qKL);
        }
        if (SettingsUI.o(SettingsUI.9.this.qKL) != null) {
          SettingsUI.o(SettingsUI.9.this.qKL).dismiss();
        }
        if ((paramm.getType() == 255) && (((t)paramm).fPH == 2))
        {
          if ((paramInt2 == -3) && (paramInt1 == 4))
          {
            Intent localIntent = new Intent(SettingsUI.9.this.qKL.getContext(), RegByMobileSetPwdUI.class);
            localIntent.putExtra("kintent_hint", SettingsUI.9.this.qKL.getString(2131302457));
            SettingsUI.9.this.qKL.startActivityForResult(localIntent, 5);
            AppMethodBeat.o(127568);
            return;
          }
          SettingsUI.u(SettingsUI.9.this.qKL);
        }
        AppMethodBeat.o(127568);
      }
    });
    AppMethodBeat.o(127569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.9
 * JD-Core Version:    0.7.0.1
 */