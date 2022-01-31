package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.base.h;

final class SettingsAliasUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAliasUI$3(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127187);
    SettingsAliasUI.a(this.qIa, SettingsAliasUI.c(this.qIa).getText().toString().trim());
    if (r.Zn().equalsIgnoreCase(SettingsAliasUI.d(this.qIa)))
    {
      this.qIa.hideVKB();
      this.qIa.finish();
      AppMethodBeat.o(127187);
      return true;
    }
    h.a(this.qIa.getContext(), this.qIa.getString(2131301616, new Object[] { SettingsAliasUI.d(this.qIa) }), this.qIa.getString(2131298507), new SettingsAliasUI.3.1(this), null);
    AppMethodBeat.o(127187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.3
 * JD-Core Version:    0.7.0.1
 */