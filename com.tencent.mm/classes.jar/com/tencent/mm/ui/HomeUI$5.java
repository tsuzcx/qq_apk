package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.j;

final class HomeUI$5
  implements View.OnLongClickListener
{
  HomeUI$5(HomeUI paramHomeUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(163247);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/HomeUI$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    if ((j.DEBUG) || (com.tencent.mm.sdk.a.b.fnF()) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
      HomeUI.m(this.Jta);
    }
    a.a(false, this, "com/tencent/mm/ui/HomeUI$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(163247);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.5
 * JD-Core Version:    0.7.0.1
 */