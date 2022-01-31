package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class QConversationUI$5
  implements n.d
{
  QConversationUI$5(QConversationUI paramQConversationUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24131);
    QConversationUI.a(this.pIm, QConversationUI.j(this.pIm));
    AppMethodBeat.o(24131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.5
 * JD-Core Version:    0.7.0.1
 */