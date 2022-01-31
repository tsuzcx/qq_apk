package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.r.a;

final class QConversationUI$1
  implements r.a
{
  QConversationUI$1(QConversationUI paramQConversationUI) {}
  
  public final void Wp()
  {
    QConversationUI localQConversationUI = this.ncU;
    String str = QConversationUI.a(this.ncU).Bp();
    int i = t.ie(s.dUW);
    if (i <= 0) {
      localQConversationUI.setMMTitle(str);
    }
    for (;;)
    {
      QConversationUI.a(this.ncU, QConversationUI.b(this.ncU).getCount());
      return;
      localQConversationUI.setMMTitle(str + "(" + i + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.1
 * JD-Core Version:    0.7.0.1
 */