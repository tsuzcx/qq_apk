package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipAddressUI$3
  implements DialogInterface.OnClickListener
{
  VoipAddressUI$3(VoipAddressUI paramVoipAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(38091);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(38091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI.3
 * JD-Core Version:    0.7.0.1
 */