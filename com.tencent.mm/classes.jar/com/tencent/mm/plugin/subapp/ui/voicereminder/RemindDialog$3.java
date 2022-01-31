package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.subapp.c.d;

final class RemindDialog$3
  implements DialogInterface.OnClickListener
{
  RemindDialog$3(RemindDialog paramRemindDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25561);
    paramDialogInterface = d.cGS();
    if (paramDialogInterface != null) {
      paramDialogInterface.pn(RemindDialog.c(this.sZX));
    }
    this.sZX.finish();
    AppMethodBeat.o(25561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.3
 * JD-Core Version:    0.7.0.1
 */