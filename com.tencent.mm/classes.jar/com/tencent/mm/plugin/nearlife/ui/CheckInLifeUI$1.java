package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class CheckInLifeUI$1
  implements View.OnClickListener
{
  CheckInLifeUI$1(CheckInLifeUI paramCheckInLifeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26577);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/nearlife/ui/CheckInLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    CheckInLifeUI.a(this.Mrd, paramView, false);
    a.a(this, "com/tencent/mm/plugin/nearlife/ui/CheckInLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI.1
 * JD-Core Version:    0.7.0.1
 */