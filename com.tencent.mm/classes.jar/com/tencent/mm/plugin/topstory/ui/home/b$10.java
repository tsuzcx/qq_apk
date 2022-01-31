package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$10
  implements View.OnClickListener
{
  b$10(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1588);
    this.tgw.onBackBtnClick();
    AppMethodBeat.o(1588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.10
 * JD-Core Version:    0.7.0.1
 */