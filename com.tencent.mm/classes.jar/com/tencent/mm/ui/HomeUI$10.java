package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class HomeUI$10
  implements View.OnClickListener
{
  HomeUI$10(HomeUI paramHomeUI)
  {
    AppMethodBeat.i(161498);
    AppMethodBeat.o(161498);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249336);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/HomeUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    HomeUI.q(this.adBf);
    a.a(this, "com/tencent/mm/ui/HomeUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.10
 * JD-Core Version:    0.7.0.1
 */