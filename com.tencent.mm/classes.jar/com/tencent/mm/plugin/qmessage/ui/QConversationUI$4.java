package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.be;

final class QConversationUI$4
  implements bf.a
{
  QConversationUI$4(QConversationUI paramQConversationUI, String paramString, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(24129);
    boolean bool = QConversationUI.i(this.pIm);
    AppMethodBeat.o(24129);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(24130);
    aw.aaz();
    c.YF().arF(this.euc);
    if (this.efE != null) {
      this.efE.dismiss();
    }
    AppMethodBeat.o(24130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.4
 * JD-Core Version:    0.7.0.1
 */