package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class UnfamiliarContactDetailUI$4$1
  implements Runnable
{
  UnfamiliarContactDetailUI$4$1(UnfamiliarContactDetailUI.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(127635);
    UnfamiliarContactDetailUI.e(this.qLk.qLi).ajb.notifyChanged();
    UnfamiliarContactDetailUI.c(this.qLk.qLi, false);
    AppMethodBeat.o(127635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.4.1
 * JD-Core Version:    0.7.0.1
 */