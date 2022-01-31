package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class QConversationUI$13
  implements MenuItem.OnMenuItemClickListener
{
  QConversationUI$13(QConversationUI paramQConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24139);
    if (!bo.isNullOrNil(QConversationUI.f(this.pIm))) {
      QConversationUI.a(this.pIm, QConversationUI.f(this.pIm), QConversationUI.g(this.pIm));
    }
    AppMethodBeat.o(24139);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.13
 * JD-Core Version:    0.7.0.1
 */