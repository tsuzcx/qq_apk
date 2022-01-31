package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class QConversationUI$6
  implements MMSlideDelView.c
{
  QConversationUI$6(QConversationUI paramQConversationUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(24132);
    int i = QConversationUI.c(this.pIm).getPositionForView(paramView);
    AppMethodBeat.o(24132);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.6
 * JD-Core Version:    0.7.0.1
 */