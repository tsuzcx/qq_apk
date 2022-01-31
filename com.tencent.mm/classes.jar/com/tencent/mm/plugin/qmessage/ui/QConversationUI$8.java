package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class QConversationUI$8
  implements MMSlideDelView.f
{
  QConversationUI$8(QConversationUI paramQConversationUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.QConversationUI", "onItemDel object null");
      return;
    }
    QConversationUI.a(this.ncU, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.8
 * JD-Core Version:    0.7.0.1
 */