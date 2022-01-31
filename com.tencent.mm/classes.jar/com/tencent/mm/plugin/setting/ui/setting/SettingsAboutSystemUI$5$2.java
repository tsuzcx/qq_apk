package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class SettingsAboutSystemUI$5$2
  implements bf.a
{
  SettingsAboutSystemUI$5$2(SettingsAboutSystemUI.5 param5) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(127114);
    boolean bool = SettingsAboutSystemUI.b(this.qHx.qHp);
    AppMethodBeat.o(127114);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(127115);
    if (SettingsAboutSystemUI.c(this.qHx.qHp) != null)
    {
      SettingsAboutSystemUI.c(this.qHx.qHp).dismiss();
      SettingsAboutSystemUI.a(this.qHx.qHp, null);
    }
    AppMethodBeat.o(127115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.5.2
 * JD-Core Version:    0.7.0.1
 */