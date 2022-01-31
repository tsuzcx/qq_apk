package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.roomsdk.a.c.a;

final class SelectContactUI$6
  implements DialogInterface.OnCancelListener
{
  SelectContactUI$6(SelectContactUI paramSelectContactUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    SelectContactUI.d(this.vNB, false);
    this.vNF.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.6
 * JD-Core Version:    0.7.0.1
 */