package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;

final class ContactRemarkInfoModUI$12
  implements DialogInterface.OnCancelListener
{
  ContactRemarkInfoModUI$12(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(206923);
    bh.aGY().cancel(636);
    AppMethodBeat.o(206923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.12
 * JD-Core Version:    0.7.0.1
 */