package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingDeleteAccountInputPassUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingDeleteAccountInputPassUI$2(SettingDeleteAccountInputPassUI paramSettingDeleteAccountInputPassUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127067);
    this.qGM.hideVKB();
    this.qGM.startActivity(new Intent(this.qGM, SettingDeleteAccountUI.class));
    AppMethodBeat.o(127067);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI.2
 * JD-Core Version:    0.7.0.1
 */