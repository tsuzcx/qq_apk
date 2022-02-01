package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.f.c;

final class SettingsChattingUI$4
  implements f.c
{
  SettingsChattingUI$4(SettingsChattingUI paramSettingsChattingUI, boolean paramBoolean, CheckBoxPreference paramCheckBoxPreference) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(224123);
    if (paramBoolean)
    {
      ae.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(this.FaZ) });
      g.ajR().ajA().set(66832, Boolean.valueOf(this.FaZ));
      AppMethodBeat.o(224123);
      return;
    }
    this.Fba.setChecked(false);
    SettingsChattingUI.d(this.yWL).notifyDataSetChanged();
    AppMethodBeat.o(224123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.4
 * JD-Core Version:    0.7.0.1
 */