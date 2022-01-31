package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;

final class SettingsModifyNameUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsModifyNameUI$3(SettingsModifyNameUI paramSettingsModifyNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127308);
    paramMenuItem = SettingsModifyNameUI.c(this.qJf).getText().toString();
    String str = b.MZ();
    if ((!bo.isNullOrNil(str)) && (paramMenuItem.matches(".*[" + str + "].*")))
    {
      h.b(this.qJf.getContext(), this.qJf.getString(2131300749, new Object[] { str }), this.qJf.getString(2131297087), true);
      AppMethodBeat.o(127308);
      return false;
    }
    c.d(SettingsModifyNameUI.c(this.qJf)).hR(1, 32).a(this.qJf);
    AppMethodBeat.o(127308);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.3
 * JD-Core Version:    0.7.0.1
 */