package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

final class SettingsManageFindMoreUI$5
  implements View.OnClickListener
{
  SettingsManageFindMoreUI$5(SettingsManageFindMoreUI paramSettingsManageFindMoreUI, WeChatBrands.Business.Entries paramEntries) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(298790);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindMoreUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.PtP.checkAvailable(paramView.getContext());
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindMoreUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.5
 * JD-Core Version:    0.7.0.1
 */