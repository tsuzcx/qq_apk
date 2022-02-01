package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class SettingsModifyAliasCheckUI$2
  implements View.OnClickListener
{
  SettingsModifyAliasCheckUI$2(SettingsModifyAliasCheckUI paramSettingsModifyAliasCheckUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256549);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.plugin.account.a.b.a.b(this.DcB, this.DcB.getString(2131765251, new Object[] { LocaleUtil.getApplicationLanguage() }), -1, true);
    paramView = new gc();
    paramView.tm(SettingsAliasUI.Dbv);
    paramView.ejW = 8L;
    paramView.bfK();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.2
 * JD-Core Version:    0.7.0.1
 */