package com.tencent.mm.plugin.setting.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SwitchAccountGridView$2
  implements View.OnClickListener
{
  SwitchAccountGridView$2(SwitchAccountGridView paramSwitchAccountGridView, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127703);
    if (SwitchAccountGridView.c(this.qMx) != null) {
      SwitchAccountGridView.c(this.qMx).YX(this.qMw);
    }
    AppMethodBeat.o(127703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.2
 * JD-Core Version:    0.7.0.1
 */