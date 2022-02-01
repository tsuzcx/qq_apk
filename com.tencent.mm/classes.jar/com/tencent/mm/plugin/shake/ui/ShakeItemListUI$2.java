package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ShakeItemListUI$2
  implements View.OnClickListener
{
  ShakeItemListUI$2(ShakeItemListUI paramShakeItemListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28392);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ShakeItemListUI.a(this.DjD, ShakeItemListUI.a(this.DjD) ^ 0xFFFFFFFF);
    this.DjD.setShowType(ShakeItemListUI.a(this.DjD));
    a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.2
 * JD-Core Version:    0.7.0.1
 */