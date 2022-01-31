package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsUI$6
  implements f
{
  SettingsUI$6(SettingsUI paramSettingsUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127565);
    g.Rc().b(281, SettingsUI.k(this.qKL));
    SettingsUI.l(this.qKL);
    if (SettingsUI.m(this.qKL) != null)
    {
      SettingsUI.m(this.qKL).stopTimer();
      SettingsUI.n(this.qKL);
    }
    if (SettingsUI.o(this.qKL) != null) {
      SettingsUI.o(this.qKL).dismiss();
    }
    SettingsUI.p(this.qKL);
    AppMethodBeat.o(127565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.6
 * JD-Core Version:    0.7.0.1
 */