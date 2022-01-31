package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QConversationUI$3
  implements DialogInterface.OnCancelListener
{
  QConversationUI$3(QConversationUI paramQConversationUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24128);
    QConversationUI.h(this.pIm);
    AppMethodBeat.o(24128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.3
 * JD-Core Version:    0.7.0.1
 */