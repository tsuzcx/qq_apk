package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.widget.a.f.c;

final class SettingsChattingUI$4
  implements f.c
{
  SettingsChattingUI$4(SettingsChattingUI paramSettingsChattingUI, boolean paramBoolean, CheckBoxPreference paramCheckBoxPreference) {}
  
  public final void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(264856);
    if (paramBoolean)
    {
      Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(this.Jhg) });
      h.aHG().aHp().i(66832, Boolean.valueOf(this.Jhg));
      AppMethodBeat.o(264856);
      return;
    }
    this.Jhh.setChecked(false);
    SettingsChattingUI.d(this.Jhc).notifyDataSetChanged();
    AppMethodBeat.o(264856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.4
 * JD-Core Version:    0.7.0.1
 */