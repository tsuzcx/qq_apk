package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

final class af$4
  implements DialogInterface.OnClickListener
{
  af$4(af paramaf, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.pSR != null)
    {
      au.Hx();
      paramDialogInterface = c.Dz();
      if (this.pSR.isChecked()) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.o(4104, Boolean.valueOf(bool));
      paramDialogInterface = LauncherUI.cyX();
      if (paramDialogInterface != null) {
        paramDialogInterface.uKP.uKi.acW("tab_find_friend");
      }
      a.eF(af.c(this.uQr));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.af.4
 * JD-Core Version:    0.7.0.1
 */