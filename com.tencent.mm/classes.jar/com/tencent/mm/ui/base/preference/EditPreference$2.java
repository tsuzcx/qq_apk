package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.a.c;

final class EditPreference$2
  implements DialogInterface.OnClickListener
{
  EditPreference$2(EditPreference paramEditPreference) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (EditPreference.a(this.vcj) != null) {
      EditPreference.a(this.vcj).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.EditPreference.2
 * JD-Core Version:    0.7.0.1
 */