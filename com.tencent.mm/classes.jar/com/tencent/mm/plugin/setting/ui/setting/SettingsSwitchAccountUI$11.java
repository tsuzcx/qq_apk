package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;

final class SettingsSwitchAccountUI$11
  implements View.OnClickListener
{
  SettingsSwitchAccountUI$11(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127508);
    SettingsSwitchAccountUI.b(this.qKt, false);
    SettingsSwitchAccountUI.a(this.qKt, false);
    SettingsSwitchAccountUI.e(this.qKt).setDeleteState(false);
    SettingsSwitchAccountUI.e(this.qKt).ckO();
    SettingsSwitchAccountUI.f(this.qKt);
    AppMethodBeat.o(127508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.11
 * JD-Core Version:    0.7.0.1
 */