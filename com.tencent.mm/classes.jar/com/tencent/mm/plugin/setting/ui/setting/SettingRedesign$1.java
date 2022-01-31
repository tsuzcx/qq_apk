package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingRedesign$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingRedesign$1(SettingRedesign paramSettingRedesign) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127073);
    this.qGP.finish();
    SettingRedesign.a(this.qGP);
    AppMethodBeat.o(127073);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingRedesign.1
 * JD-Core Version:    0.7.0.1
 */