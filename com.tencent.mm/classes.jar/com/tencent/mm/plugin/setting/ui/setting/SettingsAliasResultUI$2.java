package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;

final class SettingsAliasResultUI$2
  implements View.OnClickListener
{
  SettingsAliasResultUI$2(SettingsAliasResultUI paramSettingsAliasResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127178);
    paramView = new Intent(this.qHV.getContext(), RegByMobileSetPwdUI.class);
    paramView.putExtra("kintent_hint", this.qHV.getString(2131302455));
    this.qHV.startActivityForResult(paramView, 0);
    AppMethodBeat.o(127178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI.2
 * JD-Core Version:    0.7.0.1
 */