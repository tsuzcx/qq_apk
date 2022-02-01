package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.pulldown.h;

final class HomeUI$21
  implements View.OnClickListener
{
  HomeUI$21(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290120);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/HomeUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    new h(HomeUI.c(this.VWJ)).show();
    a.a(this, "com/tencent/mm/ui/HomeUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.21
 * JD-Core Version:    0.7.0.1
 */