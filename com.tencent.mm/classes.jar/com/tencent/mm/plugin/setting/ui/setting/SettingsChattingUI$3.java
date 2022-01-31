package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.sdk.b.a;

final class SettingsChattingUI$3
  implements bf.a
{
  SettingsChattingUI$3(SettingsChattingUI paramSettingsChattingUI) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(127214);
    boolean bool = SettingsChattingUI.c(this.qIf);
    AppMethodBeat.o(127214);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(127215);
    if (SettingsChattingUI.a(this.qIf) != null)
    {
      SettingsChattingUI.a(this.qIf).dismiss();
      SettingsChattingUI.a(this.qIf, null);
    }
    a.ymk.l(new ph());
    AppMethodBeat.o(127215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.3
 * JD-Core Version:    0.7.0.1
 */