package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.be;

final class QConversationUI$4
  implements bd.a
{
  QConversationUI$4(QConversationUI paramQConversationUI, String paramString, ProgressDialog paramProgressDialog) {}
  
  public final void xA()
  {
    au.Hx();
    c.FB().abu(this.dAA);
    if (this.doh != null) {
      this.doh.dismiss();
    }
  }
  
  public final boolean xz()
  {
    return QConversationUI.i(this.ncU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.4
 * JD-Core Version:    0.7.0.1
 */