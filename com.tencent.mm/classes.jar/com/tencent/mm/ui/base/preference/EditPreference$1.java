package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class EditPreference$1
  implements DialogInterface.OnClickListener
{
  EditPreference$1(EditPreference paramEditPreference, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(107160);
    if (EditPreference.a(this.zqK) != null) {
      EditPreference.a(this.zqK).dismiss();
    }
    this.zqK.value = this.zqJ.getText().toString();
    if (EditPreference.b(this.zqK) != null) {
      EditPreference.b(this.zqK).dEI();
    }
    if (EditPreference.c(this.zqK) != null) {
      EditPreference.c(this.zqK).a(this.zqK, EditPreference.d(this.zqK));
    }
    AppMethodBeat.o(107160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.EditPreference.1
 * JD-Core Version:    0.7.0.1
 */