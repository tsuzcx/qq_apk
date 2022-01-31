package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChattingSendDataToDeviceUI$6
  implements DialogInterface.OnClickListener
{
  ChattingSendDataToDeviceUI$6(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30767);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(30767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.6
 * JD-Core Version:    0.7.0.1
 */