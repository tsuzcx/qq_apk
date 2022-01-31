package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

final class h$9
  implements DialogInterface.OnClickListener
{
  h$9(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (h.r(this.uJi) != null)
    {
      au.Hx();
      paramDialogInterface = c.Dz();
      if (h.r(this.uJi).isChecked()) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.o(4104, Boolean.valueOf(bool));
      paramDialogInterface = (LauncherUI)this.uJi.getContext();
      if (paramDialogInterface != null) {
        paramDialogInterface.uKP.uKi.acW("tab_find_friend");
      }
      a.eF(this.uJi.getContext());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.9
 * JD-Core Version:    0.7.0.1
 */