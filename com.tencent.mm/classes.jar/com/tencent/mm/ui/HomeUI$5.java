package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;

final class HomeUI$5
  implements View.OnClickListener
{
  HomeUI$5(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29345);
    paramView = i.sFa;
    i.cDJ().cWC = System.currentTimeMillis();
    HomeUI.l(this.yYw);
    AppMethodBeat.o(29345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.5
 * JD-Core Version:    0.7.0.1
 */