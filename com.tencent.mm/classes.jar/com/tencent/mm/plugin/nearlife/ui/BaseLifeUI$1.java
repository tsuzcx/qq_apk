package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseLifeUI$1
  implements View.OnClickListener
{
  BaseLifeUI$1(BaseLifeUI paramBaseLifeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26560);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    BaseLifeUI.a(this.ABJ);
    a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.1
 * JD-Core Version:    0.7.0.1
 */