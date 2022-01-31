package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SingleChatInfoUI$a
  implements DialogInterface.OnCancelListener
{
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29879);
    SingleChatInfoUI.qA(true);
    AppMethodBeat.o(29879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.a
 * JD-Core Version:    0.7.0.1
 */