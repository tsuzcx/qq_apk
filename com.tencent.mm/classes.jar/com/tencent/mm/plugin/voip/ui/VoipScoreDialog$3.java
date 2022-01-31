package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.snackbar.b;

final class VoipScoreDialog$3
  implements DialogInterface.OnClickListener
{
  VoipScoreDialog$3(VoipScoreDialog paramVoipScoreDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VoipScoreDialog.b(this.pXr, 3);
    b.a(this.pXr, null, this.pXr.getString(a.e.voip_score_dialog_dismiss_message), new VoipScoreDialog.3.1(this));
    if (VoipScoreDialog.a(this.pXr) != null) {
      VoipScoreDialog.a(this.pXr).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog.3
 * JD-Core Version:    0.7.0.1
 */