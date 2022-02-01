package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class SnsMsgUI$11
  implements MMSlideDelView.c
{
  SnsMsgUI$11(SnsMsgUI paramSnsMsgUI) {}
  
  public final int dA(View paramView)
  {
    AppMethodBeat.i(198367);
    int i = SnsMsgUI.b(this.AfF).getPositionForView(paramView);
    AppMethodBeat.o(198367);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.11
 * JD-Core Version:    0.7.0.1
 */