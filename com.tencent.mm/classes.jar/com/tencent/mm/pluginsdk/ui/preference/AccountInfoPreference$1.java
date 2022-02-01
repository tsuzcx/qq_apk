package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

final class AccountInfoPreference$1
  implements View.OnClickListener
{
  AccountInfoPreference$1(AccountInfoPreference paramAccountInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31805);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/preference/AccountInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    c.b(this.Ymf.mContext, "setting", ".ui.setting.SettingsPersonalInfoUI", paramView);
    a.a(this, "com/tencent/mm/pluginsdk/ui/preference/AccountInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */