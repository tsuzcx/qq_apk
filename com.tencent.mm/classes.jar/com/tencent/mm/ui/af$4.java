package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class af$4
  implements DialogInterface.OnClickListener
{
  af$4(af paramaf, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33689);
    if (this.GVa != null)
    {
      bg.aVF();
      paramDialogInterface = c.azQ();
      if (this.GVa.isChecked()) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.set(4104, Boolean.valueOf(bool));
      paramDialogInterface = LauncherUI.getInstance();
      if (paramDialogInterface != null) {
        paramDialogInterface.ODR.getMainTabUI().blU("tab_find_friend");
      }
      a.ih(af.b(this.OKm));
      AppMethodBeat.o(33689);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.af.4
 * JD-Core Version:    0.7.0.1
 */