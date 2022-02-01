package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class SettingsModifyAliasUI$8
  implements View.OnClickListener
{
  SettingsModifyAliasUI$8(SettingsModifyAliasUI paramSettingsModifyAliasUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(298724);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.plugin.account.sdk.c.a.b(this.Puo, this.Puo.getString(b.i.set_alias_term_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 0, true);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.8
 * JD-Core Version:    0.7.0.1
 */