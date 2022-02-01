package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class VoiceLoginUI$2
  implements DialogInterface.OnClickListener
{
  VoiceLoginUI$2(VoiceLoginUI paramVoiceLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29873);
    paramDialogInterface.dismiss();
    b.lx(this.Uun.getContext());
    AppMethodBeat.o(29873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI.2
 * JD-Core Version:    0.7.0.1
 */