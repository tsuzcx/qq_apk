package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class QConversationUI$8
  implements MMSlideDelView.f
{
  QConversationUI$8(QConversationUI paramQConversationUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(24134);
    if (paramObject == null)
    {
      ab.e("MicroMsg.QConversationUI", "onItemDel object null");
      AppMethodBeat.o(24134);
      return;
    }
    QConversationUI.a(this.pIm, paramObject.toString());
    AppMethodBeat.o(24134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.8
 * JD-Core Version:    0.7.0.1
 */