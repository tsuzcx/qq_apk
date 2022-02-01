package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class VoiceTransTextUI$6
  extends MMHandler
{
  VoiceTransTextUI$6(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(29288);
    int i = paramMessage.what;
    if (i == 1)
    {
      VoiceTransTextUI.b(this.Mib, true);
      AppMethodBeat.o(29288);
      return;
    }
    if (i == 2) {
      VoiceTransTextUI.b(this.Mib, false);
    }
    AppMethodBeat.o(29288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.6
 * JD-Core Version:    0.7.0.1
 */