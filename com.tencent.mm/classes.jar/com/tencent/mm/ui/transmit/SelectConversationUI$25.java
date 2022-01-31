package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectConversationUI$25
  implements DialogInterface.OnClickListener
{
  SelectConversationUI$25(SelectConversationUI paramSelectConversationUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35147);
    SelectConversationUI.f(this.AAp);
    this.AAp.hideVKB();
    AppMethodBeat.o(35147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.25
 * JD-Core Version:    0.7.0.1
 */