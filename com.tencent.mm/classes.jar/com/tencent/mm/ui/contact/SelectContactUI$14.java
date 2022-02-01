package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class SelectContactUI$14
  implements DialogInterface.OnCancelListener
{
  SelectContactUI$14(SelectContactUI paramSelectContactUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(234034);
    SelectContactUI.D(this.PZl);
    this.PZs.cancel();
    AppMethodBeat.o(234034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.14
 * JD-Core Version:    0.7.0.1
 */