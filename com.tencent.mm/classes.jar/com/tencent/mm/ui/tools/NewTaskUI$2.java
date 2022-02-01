package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;

final class NewTaskUI$2
  implements DialogInterface.OnCancelListener
{
  NewTaskUI$2(NewTaskUI paramNewTaskUI, com.tencent.mm.modelsimple.t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(39110);
    bh.aGY().a(this.XTL);
    AppMethodBeat.o(39110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI.2
 * JD-Core Version:    0.7.0.1
 */