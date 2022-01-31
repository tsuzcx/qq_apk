package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$3
  implements View.OnClickListener
{
  HomeUI$3(HomeUI paramHomeUI, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153761);
    HomeUI.j(this.yYw).gr();
    if (this.yYx)
    {
      paramView = this.yYw;
      Boolean localBoolean = Boolean.TRUE;
      HomeUI.a(paramView, localBoolean, localBoolean);
      AppMethodBeat.o(153761);
      return;
    }
    HomeUI.a(this.yYw, Boolean.TRUE, Boolean.FALSE);
    AppMethodBeat.o(153761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.3
 * JD-Core Version:    0.7.0.1
 */