package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class SelectContactUI$6
  implements DialogInterface.OnCancelListener
{
  SelectContactUI$6(SelectContactUI paramSelectContactUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(153968);
    SelectContactUI.d(this.Afg, false);
    this.Afi.cancel();
    AppMethodBeat.o(153968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.6
 * JD-Core Version:    0.7.0.1
 */