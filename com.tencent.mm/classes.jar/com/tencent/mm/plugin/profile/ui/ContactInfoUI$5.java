package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactInfoUI$5
  implements DialogInterface.OnClickListener
{
  ContactInfoUI$5(ContactInfoUI paramContactInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153555);
    paramDialogInterface.dismiss();
    this.pyI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(153555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.5
 * JD-Core Version:    0.7.0.1
 */