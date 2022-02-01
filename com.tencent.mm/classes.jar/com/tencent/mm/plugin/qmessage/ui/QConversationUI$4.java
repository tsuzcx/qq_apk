package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bw;

final class QConversationUI$4
  implements bp.a
{
  QConversationUI$4(QConversationUI paramQConversationUI, String paramString, ProgressDialog paramProgressDialog) {}
  
  public final boolean amG()
  {
    AppMethodBeat.i(27769);
    boolean bool = QConversationUI.i(this.BqG);
    AppMethodBeat.o(27769);
    return bool;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(27770);
    bg.aVF();
    c.aST().bjW(this.gMw);
    if (this.guD != null) {
      this.guD.dismiss();
    }
    AppMethodBeat.o(27770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.4
 * JD-Core Version:    0.7.0.1
 */