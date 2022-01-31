package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

final class a$1$2
  implements DialogInterface.OnClickListener
{
  a$1$2(a.1 param1, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.sih.getText().toString().trim();
    if ((paramDialogInterface != null) && (paramDialogInterface.length() > 0)) {
      a.a(this.sig.sie, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.1.2
 * JD-Core Version:    0.7.0.1
 */