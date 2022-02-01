package com.tencent.mm.plugin.teenmode.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SettingsTeenModeMainFinder$3
  implements View.OnClickListener
{
  SettingsTeenModeMainFinder$3(SettingsTeenModeMainFinder paramSettingsTeenModeMainFinder) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(279125);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("from_teen_mode_setting_page", true);
    c.b(this.TaV, "finder", ".ui.FinderFollowListUI", paramView);
    a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.3
 * JD-Core Version:    0.7.0.1
 */