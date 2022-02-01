package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;

final class SettingsModifyAliasCheckUI$2
  implements View.OnClickListener
{
  SettingsModifyAliasCheckUI$2(SettingsModifyAliasCheckUI paramSettingsModifyAliasCheckUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(220998);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    com.tencent.mm.plugin.account.a.b.a.b(this.yHz, this.yHz.getString(2131766392, new Object[] { ac.fks() }), -1, true);
    paramView = new dh();
    paramView.mw(SettingsAliasUI.yGx);
    paramView.dPH = 8L;
    paramView.aLk();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(220998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.2
 * JD-Core Version:    0.7.0.1
 */