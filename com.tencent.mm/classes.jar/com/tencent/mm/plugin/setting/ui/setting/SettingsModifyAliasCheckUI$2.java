package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class SettingsModifyAliasCheckUI$2
  implements View.OnClickListener
{
  SettingsModifyAliasCheckUI$2(SettingsModifyAliasCheckUI paramSettingsModifyAliasCheckUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264893);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.plugin.account.sdk.b.a.b(this.Jic, this.Jic.getString(b.i.set_alias_help_url, new Object[] { LocaleUtil.getApplicationLanguage() }), -1, true);
    paramView = new hv();
    paramView.xd(SettingsAliasUI.JgW);
    paramView.geB = 8L;
    paramView.bpa();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(264893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.2
 * JD-Core Version:    0.7.0.1
 */