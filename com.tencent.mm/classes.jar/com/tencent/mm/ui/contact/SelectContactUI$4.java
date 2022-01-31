package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class SelectContactUI$4
  implements DialogInterface.OnClickListener
{
  SelectContactUI$4(SelectContactUI paramSelectContactUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.SelectContactUI", "return the result");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", this.vNE);
    paramDialogInterface.putExtra("Select_Conv_User", this.vNE);
    paramDialogInterface.putExtra("Select_Contact", this.vNE);
    this.vNB.setResult(-1, paramDialogInterface);
    this.vNB.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */