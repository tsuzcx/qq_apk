package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class EditPreference$2
  implements DialogInterface.OnClickListener
{
  EditPreference$2(EditPreference paramEditPreference) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(107161);
    if (EditPreference.a(this.zqK) != null) {
      EditPreference.a(this.zqK).dismiss();
    }
    AppMethodBeat.o(107161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.EditPreference.2
 * JD-Core Version:    0.7.0.1
 */