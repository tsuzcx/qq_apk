package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class SnsMsgUI$12
  implements MMSlideDelView.c
{
  SnsMsgUI$12(SnsMsgUI paramSnsMsgUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(39078);
    int i = SnsMsgUI.c(this.rSU).getPositionForView(paramView);
    AppMethodBeat.o(39078);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.12
 * JD-Core Version:    0.7.0.1
 */