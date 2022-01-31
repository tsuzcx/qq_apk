package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.base.h;

final class SettingsModifyEmailAddrUI$22
  implements View.OnClickListener
{
  SettingsModifyEmailAddrUI$22(SettingsModifyEmailAddrUI paramSettingsModifyEmailAddrUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127284);
    paramView = new y(y.gya);
    g.Rc().a(paramView, 0);
    paramView = this.qIZ;
    SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI = this.qIZ;
    this.qIZ.getString(2131297087);
    SettingsModifyEmailAddrUI.a(paramView, h.b(localSettingsModifyEmailAddrUI, this.qIZ.getString(2131303500), true, new SettingsModifyEmailAddrUI.22.1(this)));
    this.qIZ.hideVKB();
    AppMethodBeat.o(127284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.22
 * JD-Core Version:    0.7.0.1
 */