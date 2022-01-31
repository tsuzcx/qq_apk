package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsFontUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsFontUI$2(SettingsFontUI paramSettingsFontUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.nFQ.f(11609, new Object[] { Integer.valueOf(SettingsFontUI.a(this.nUp)), Integer.valueOf(SettingsFontUI.b(this.nUp)), Integer.valueOf(0) });
    y.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.a(this.nUp)), Integer.valueOf(SettingsFontUI.b(this.nUp)) });
    this.nUp.finish();
    SettingsFontUI.a(this.nUp, this.nUp.nUl);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.2
 * JD-Core Version:    0.7.0.1
 */