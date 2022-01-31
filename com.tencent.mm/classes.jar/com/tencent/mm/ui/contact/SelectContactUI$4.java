package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SelectContactUI$4
  implements DialogInterface.OnClickListener
{
  SelectContactUI$4(SelectContactUI paramSelectContactUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33853);
    ab.i("MicroMsg.SelectContactUI", "return the result");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", this.Afh);
    paramDialogInterface.putExtra("Select_Conv_User", this.Afh);
    paramDialogInterface.putExtra("Select_Contact", this.Afh);
    this.Afg.setResult(-1, paramDialogInterface);
    this.Afg.finish();
    AppMethodBeat.o(33853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */