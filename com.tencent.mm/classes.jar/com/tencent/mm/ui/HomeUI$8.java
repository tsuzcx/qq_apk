package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class HomeUI$8
  implements View.OnClickListener
{
  HomeUI$8(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186950);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/HomeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    HomeUI.o(this.Jta);
    a.a(this, "com/tencent/mm/ui/HomeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(186950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.8
 * JD-Core Version:    0.7.0.1
 */