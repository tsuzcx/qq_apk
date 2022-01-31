package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipAddressUI$2
  implements DialogInterface.OnClickListener
{
  VoipAddressUI$2(VoipAddressUI paramVoipAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33969);
    paramDialogInterface.dismiss();
    this.AfP.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(33969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI.2
 * JD-Core Version:    0.7.0.1
 */