package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class SnsMsgUI$12
  implements MMSlideDelView.g
{
  SnsMsgUI$12(SnsMsgUI paramSnsMsgUI) {}
  
  public final void s(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198368);
    SnsMsgUI.b(this.AfF).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(198368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.12
 * JD-Core Version:    0.7.0.1
 */