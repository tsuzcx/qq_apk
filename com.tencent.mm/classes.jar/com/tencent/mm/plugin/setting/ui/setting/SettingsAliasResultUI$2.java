package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SettingsAliasResultUI$2
  implements View.OnClickListener
{
  SettingsAliasResultUI$2(SettingsAliasResultUI paramSettingsAliasResultUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.nTV.mController.uMN, RegByMobileSetPwdUI.class);
    paramView.putExtra("kintent_hint", this.nTV.getString(a.i.regbymobile_reg_setpwd_tip_after_set_alias));
    this.nTV.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI.2
 * JD-Core Version:    0.7.0.1
 */