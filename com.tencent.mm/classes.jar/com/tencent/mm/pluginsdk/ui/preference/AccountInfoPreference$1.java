package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.base.preference.Preference;

final class AccountInfoPreference$1
  implements View.OnClickListener
{
  AccountInfoPreference$1(AccountInfoPreference paramAccountInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28015);
    paramView = new Intent();
    d.b(this.waA.mContext, "setting", ".ui.setting.SettingsPersonalInfoUI", paramView);
    AppMethodBeat.o(28015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */