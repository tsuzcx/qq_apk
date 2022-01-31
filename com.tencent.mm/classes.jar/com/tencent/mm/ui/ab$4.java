package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class ab$4
  implements DialogInterface.OnClickListener
{
  ab$4(ab paramab, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29842);
    if (this.tyr != null)
    {
      aw.aaz();
      paramDialogInterface = c.Ru();
      if (this.tyr.isChecked()) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.set(4104, Boolean.valueOf(bool));
      paramDialogInterface = LauncherUI.getInstance();
      if (paramDialogInterface != null) {
        paramDialogInterface.yYT.getMainTabUI().atp("tab_find_friend");
      }
      a.fF(ab.c(this.zeD));
      AppMethodBeat.o(29842);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ab.4
 * JD-Core Version:    0.7.0.1
 */