package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

final class SettingsManageFindMoreUI$4
  implements View.OnClickListener
{
  SettingsManageFindMoreUI$4(SettingsManageFindMoreUI paramSettingsManageFindMoreUI, WeChatBrands.Business.Entries paramEntries) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256546);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindMoreUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.Dcy.checkAvailable(paramView.getContext());
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindMoreUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.4
 * JD-Core Version:    0.7.0.1
 */