package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class QConversationUI$7
  implements MMSlideDelView.g
{
  QConversationUI$7(QConversationUI paramQConversationUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24133);
    QConversationUI.c(this.pIm).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(24133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.7
 * JD-Core Version:    0.7.0.1
 */