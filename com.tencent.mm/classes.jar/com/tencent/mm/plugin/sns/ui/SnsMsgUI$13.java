package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class SnsMsgUI$13
  implements MMSlideDelView.g
{
  SnsMsgUI$13(SnsMsgUI paramSnsMsgUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39079);
    SnsMsgUI.c(this.rSU).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(39079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.13
 * JD-Core Version:    0.7.0.1
 */