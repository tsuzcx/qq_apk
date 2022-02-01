package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class SnsMsgUI$11
  implements MMSlideDelView.c
{
  SnsMsgUI$11(SnsMsgUI paramSnsMsgUI) {}
  
  public final int eB(View paramView)
  {
    AppMethodBeat.i(308499);
    int i = SnsMsgUI.b(this.RtY).getPositionForView(paramView);
    AppMethodBeat.o(308499);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.11
 * JD-Core Version:    0.7.0.1
 */