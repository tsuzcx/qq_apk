package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.p.a;

final class QConversationUI$1
  implements p.a
{
  QConversationUI$1(QConversationUI paramQConversationUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(24126);
    QConversationUI localQConversationUI = this.pIm;
    String str = QConversationUI.a(this.pIm).Oe();
    int i = u.oM(t.flf);
    if (i <= 0) {
      localQConversationUI.setMMTitle(str);
    }
    for (;;)
    {
      QConversationUI.a(this.pIm, QConversationUI.b(this.pIm).getCount());
      AppMethodBeat.o(24126);
      return;
      localQConversationUI.setMMTitle(str + "(" + i + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.1
 * JD-Core Version:    0.7.0.1
 */