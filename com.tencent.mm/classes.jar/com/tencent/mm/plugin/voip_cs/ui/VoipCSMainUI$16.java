package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.sdk.platformtools.y;

final class VoipCSMainUI$16
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$16(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
    q.bQX();
    if (VoipCSMainUI.a(this.qeX)) {
      VoipCSMainUI.b(this.qeX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.16
 * JD-Core Version:    0.7.0.1
 */