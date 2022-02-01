package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SelfQRCodeUI$6
  implements View.OnClickListener
{
  SelfQRCodeUI$6(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190309);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    SelfQRCodeUI.h(this.yUO);
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.6
 * JD-Core Version:    0.7.0.1
 */