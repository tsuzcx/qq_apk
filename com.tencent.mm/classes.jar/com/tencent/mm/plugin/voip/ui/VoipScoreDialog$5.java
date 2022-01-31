package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipScoreDialog$5
  implements DialogInterface.OnClickListener
{
  VoipScoreDialog$5(VoipScoreDialog paramVoipScoreDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(4861);
    VoipScoreDialog.b(this.tCU, 2);
    this.tCU.finish();
    AppMethodBeat.o(4861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog.5
 * JD-Core Version:    0.7.0.1
 */