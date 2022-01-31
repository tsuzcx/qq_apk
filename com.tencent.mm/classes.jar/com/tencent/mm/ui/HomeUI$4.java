package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.f;

final class HomeUI$4
  implements View.OnLongClickListener
{
  HomeUI$4(HomeUI paramHomeUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(153762);
    if ((b.dsf()) || (f.IS_FLAVOR_RED) || (f.IS_FLAVOR_PURPLE)) {
      HomeUI.k(this.yYw);
    }
    AppMethodBeat.o(153762);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.4
 * JD-Core Version:    0.7.0.1
 */