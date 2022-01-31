package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewTaskUI$4
  implements DialogInterface.OnCancelListener
{
  NewTaskUI$4(NewTaskUI paramNewTaskUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(34920);
    if (NewTaskUI.AwI != null)
    {
      NewTaskUI.AwI = null;
      this.AwK.finish();
    }
    AppMethodBeat.o(34920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI.4
 * JD-Core Version:    0.7.0.1
 */