package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class MMCreateChatroomUI$3
  implements DialogInterface.OnCancelListener
{
  MMCreateChatroomUI$3(MMCreateChatroomUI paramMMCreateChatroomUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(39239);
    MMCreateChatroomUI.a(this.Qyd, false);
    this.PZs.cancel();
    AppMethodBeat.o(39239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI.3
 * JD-Core Version:    0.7.0.1
 */