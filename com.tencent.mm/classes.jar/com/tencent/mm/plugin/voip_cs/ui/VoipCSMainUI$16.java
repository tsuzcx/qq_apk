package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipCSMainUI$16
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$16(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(135404);
    ab.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
    r.cNu();
    if (VoipCSMainUI.a(this.tLK)) {
      VoipCSMainUI.b(this.tLK);
    }
    AppMethodBeat.o(135404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.16
 * JD-Core Version:    0.7.0.1
 */