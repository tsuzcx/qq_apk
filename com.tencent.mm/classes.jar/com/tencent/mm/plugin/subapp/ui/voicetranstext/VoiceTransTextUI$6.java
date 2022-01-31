package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VoiceTransTextUI$6
  extends ak
{
  VoiceTransTextUI$6(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(25599);
    int i = paramMessage.what;
    if (i == 1)
    {
      VoiceTransTextUI.b(this.taB, true);
      AppMethodBeat.o(25599);
      return;
    }
    if (i == 2) {
      VoiceTransTextUI.b(this.taB, false);
    }
    AppMethodBeat.o(25599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.6
 * JD-Core Version:    0.7.0.1
 */