package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectContactUI$14$1
  implements DialogInterface.OnClickListener
{
  SelectContactUI$14$1(SelectContactUI.14 param14) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33862);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", this.Afn.Afm);
    paramDialogInterface.putExtra("App_MsgId", "fromSns");
    this.Afn.Afg.setResult(-1, paramDialogInterface);
    this.Afn.Afg.finish();
    AppMethodBeat.o(33862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.14.1
 * JD-Core Version:    0.7.0.1
 */