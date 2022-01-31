package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.snackbar.b;

final class VoipScoreDialog$4
  implements DialogInterface.OnClickListener
{
  VoipScoreDialog$4(VoipScoreDialog paramVoipScoreDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(4860);
    VoipScoreDialog.b(this.tCU, 3);
    b.a(this.tCU, null, this.tCU.getString(2131304729), new VoipScoreDialog.4.1(this));
    if (VoipScoreDialog.a(this.tCU) != null) {
      VoipScoreDialog.a(this.tCU).dismiss();
    }
    AppMethodBeat.o(4860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog.4
 * JD-Core Version:    0.7.0.1
 */