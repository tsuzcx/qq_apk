package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import java.util.Set;

final class SettingsSwitchAccountUI$9
  implements View.OnClickListener
{
  SettingsSwitchAccountUI$9(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127506);
    if (!SettingsSwitchAccountUI.g(this.qKt))
    {
      SettingsSwitchAccountUI.b(this.qKt, true);
      SettingsSwitchAccountUI.e(this.qKt).setDeleteState(SettingsSwitchAccountUI.g(this.qKt));
      SettingsSwitchAccountUI.e(this.qKt).ckO();
      SettingsSwitchAccountUI.f(this.qKt);
      if (bx.fnO.abf().size() > 1)
      {
        h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), bx.fnO.abg() });
        AppMethodBeat.o(127506);
        return;
      }
      h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), bx.fnO.abg() });
    }
    AppMethodBeat.o(127506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.9
 * JD-Core Version:    0.7.0.1
 */