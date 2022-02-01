package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.h.h;

final class HomeUI$7
  implements View.OnClickListener
{
  HomeUI$7(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163248);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/HomeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = h.LOJ;
    h.geX().gSt = System.currentTimeMillis();
    HomeUI.p(this.VWJ);
    a.a(this, "com/tencent/mm/ui/HomeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.7
 * JD-Core Version:    0.7.0.1
 */