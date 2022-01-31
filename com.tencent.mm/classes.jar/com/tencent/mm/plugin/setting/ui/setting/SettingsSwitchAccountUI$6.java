package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class SettingsSwitchAccountUI$6
  implements SwitchAccountGridView.c
{
  SettingsSwitchAccountUI$6(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void YX(final String paramString)
  {
    AppMethodBeat.i(127503);
    com.tencent.mm.ui.base.h.d(this.qKt, this.qKt.getString(2131303461, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(this.qKt).get(paramString)).username }), this.qKt.getString(2131297087), this.qKt.getString(2131297115), this.qKt.getString(2131297014), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(154188);
        ab.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramString });
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.6.this.qKt, true);
        bx.fnO.pG(paramString);
        SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.6.this.qKt).remove(paramString);
        paramAnonymousDialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.6.this.qKt);
        String str = paramString;
        if (paramAnonymousDialogInterface.qMq.contains(str))
        {
          paramAnonymousInt = paramAnonymousDialogInterface.qMq.indexOf(str);
          paramAnonymousDialogInterface.qMq.remove(str);
          paramAnonymousDialogInterface.qMr.remove(paramAnonymousInt);
          paramAnonymousDialogInterface.qMs.remove(paramAnonymousInt);
        }
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.6.this.qKt).ckO();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.6.this.qKt);
        if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.6.this.qKt) == 0)
        {
          if (bx.fnO.abf().size() > 0)
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), bx.fnO.abg() });
            AppMethodBeat.o(154188);
            return;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), bx.fnO.abg() });
        }
        AppMethodBeat.o(154188);
      }
    }, null);
    AppMethodBeat.o(127503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.6
 * JD-Core Version:    0.7.0.1
 */