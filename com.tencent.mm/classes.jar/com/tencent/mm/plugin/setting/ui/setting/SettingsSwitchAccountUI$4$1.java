package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class SettingsSwitchAccountUI$4$1
  implements DialogInterface.OnClickListener
{
  SettingsSwitchAccountUI$4$1(SettingsSwitchAccountUI.4 param4, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { this.nWj });
    SettingsSwitchAccountUI.a(this.nWk.nWi, true);
    bv.dXJ.iS(this.nWj);
    SettingsSwitchAccountUI.c(this.nWk.nWi).remove(this.nWj);
    paramDialogInterface = SettingsSwitchAccountUI.d(this.nWk.nWi);
    String str = this.nWj;
    if (paramDialogInterface.nYg.contains(str))
    {
      paramInt = paramDialogInterface.nYg.indexOf(str);
      paramDialogInterface.nYg.remove(str);
      paramDialogInterface.nYh.remove(paramInt);
      paramDialogInterface.nYi.remove(paramInt);
    }
    SettingsSwitchAccountUI.d(this.nWk.nWi).bzE();
    SettingsSwitchAccountUI.e(this.nWk.nWi);
    if (SettingsSwitchAccountUI.a(this.nWk.nWi) == 0)
    {
      if (bv.dXJ.Ii().size() > 0) {
        h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), bv.dXJ.Ij() });
      }
    }
    else {
      return;
    }
    h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), bv.dXJ.Ij() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.4.1
 * JD-Core Version:    0.7.0.1
 */