package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SelfQRCodeUI$10
  implements View.OnClickListener
{
  SelfQRCodeUI$10(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73957);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    c.ai(this.PpF, "setting", ".ui.setting.SettingsAddMeUI");
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(73957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.10
 * JD-Core Version:    0.7.0.1
 */