package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.base.b;
import java.util.Set;

final class SettingsSwitchAccountUI$10
  implements View.OnClickListener
{
  SettingsSwitchAccountUI$10(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127507);
    SettingsSwitchAccountUI.b(this.qKt, false);
    SettingsSwitchAccountUI.a(this.qKt, false);
    SettingsSwitchAccountUI.e(this.qKt).setDeleteState(false);
    SettingsSwitchAccountUI.e(this.qKt).ckO();
    SettingsSwitchAccountUI.f(this.qKt);
    if (SettingsSwitchAccountUI.e(this.qKt).getAccountCount() == 0)
    {
      if (bx.fnO.abf().size() <= 1) {
        break label172;
      }
      h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), bx.fnO.abg() });
    }
    for (;;)
    {
      paramView = a.gmO.bm(this.qKt);
      paramView.addFlags(67108864);
      this.qKt.startActivity(paramView);
      this.qKt.finish();
      b.ig(this.qKt);
      SettingsSwitchAccountUI.h(this.qKt);
      AppMethodBeat.o(127507);
      return;
      label172:
      h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), bx.fnO.abg() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.10
 * JD-Core Version:    0.7.0.1
 */