package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;

final class SettingsModifyAliasUI$8
  implements View.OnClickListener
{
  SettingsModifyAliasUI$8(SettingsModifyAliasUI paramSettingsModifyAliasUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221009);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    com.tencent.mm.plugin.account.a.b.a.b(this.yHF, this.yHF.getString(2131766393, new Object[] { ac.fks() }), 0, true);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(221009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.8
 * JD-Core Version:    0.7.0.1
 */