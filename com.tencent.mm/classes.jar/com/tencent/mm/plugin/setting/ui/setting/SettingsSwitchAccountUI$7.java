package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import java.util.Set;

final class SettingsSwitchAccountUI$7
  implements View.OnClickListener
{
  SettingsSwitchAccountUI$7(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onClick(View paramView)
  {
    if (!SettingsSwitchAccountUI.f(this.nWi))
    {
      SettingsSwitchAccountUI.b(this.nWi, true);
      SettingsSwitchAccountUI.d(this.nWi).setDeleteState(SettingsSwitchAccountUI.f(this.nWi));
      SettingsSwitchAccountUI.d(this.nWi).bzE();
      SettingsSwitchAccountUI.e(this.nWi);
      if (bv.dXJ.Ii().size() > 1) {
        h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), bv.dXJ.Ij() });
      }
    }
    else
    {
      return;
    }
    h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), bv.dXJ.Ij() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.7
 * JD-Core Version:    0.7.0.1
 */