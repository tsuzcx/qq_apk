package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.storage.ad;

final class NormalUserFooterPreference$a$1$1$2
  implements DialogInterface.OnClickListener
{
  NormalUserFooterPreference$a$1$1$2(NormalUserFooterPreference.a.1.1 param1, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.mYH.mYF.mYE.bsM();
    if (NormalUserFooterPreference.a(this.mYH.mYF.mYE.mYC).getSource() == 18)
    {
      NormalUserFooterPreference.a(this.mYH.mYF.mYE.mYC, 9);
      if (this.mYG.isChecked()) {
        NormalUserFooterPreference.a.c(this.mYH.mYF.mYE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.1.2
 * JD-Core Version:    0.7.0.1
 */