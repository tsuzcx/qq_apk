package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ui.widget.a.c;

final class EditPreference$1
  implements DialogInterface.OnClickListener
{
  EditPreference$1(EditPreference paramEditPreference, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (EditPreference.a(this.vcj) != null) {
      EditPreference.a(this.vcj).dismiss();
    }
    this.vcj.value = this.vci.getText().toString();
    if (EditPreference.b(this.vcj) != null) {
      EditPreference.b(this.vcj).cBt();
    }
    if (EditPreference.c(this.vcj) != null) {
      EditPreference.c(this.vcj).a(this.vcj, EditPreference.d(this.vcj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.EditPreference.1
 * JD-Core Version:    0.7.0.1
 */