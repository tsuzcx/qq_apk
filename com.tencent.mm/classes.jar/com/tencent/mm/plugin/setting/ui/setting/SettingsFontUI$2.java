package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class SettingsFontUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsFontUI$2(SettingsFontUI paramSettingsFontUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127222);
    h.qsU.e(11609, new Object[] { Integer.valueOf(SettingsFontUI.b(this.qIs)), Integer.valueOf(SettingsFontUI.c(this.qIs)), Integer.valueOf(0) });
    ab.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.b(this.qIs)), Integer.valueOf(SettingsFontUI.c(this.qIs)) });
    SettingsFontUI.b(this.qIs, SettingsFontUI.a(this.qIs));
    AppMethodBeat.o(127222);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.2
 * JD-Core Version:    0.7.0.1
 */