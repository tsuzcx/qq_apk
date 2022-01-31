package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class SelectContactUI$3
  implements DialogInterface.OnClickListener
{
  SelectContactUI$3(SelectContactUI paramSelectContactUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.SelectContactUI", "return the result,and create new label");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", this.vNE);
    paramDialogInterface.putExtra("Select_Conv_User", this.vNE);
    paramDialogInterface.putExtra("Select_Contact", this.vNE);
    paramDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", this.vNE);
    this.vNB.setResult(-1, paramDialogInterface);
    this.vNB.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */