package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipScoreDialog$3
  implements DialogInterface.OnDismissListener
{
  VoipScoreDialog$3(VoipScoreDialog paramVoipScoreDialog) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(4858);
    this.tCU.finish();
    AppMethodBeat.o(4858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog.3
 * JD-Core Version:    0.7.0.1
 */