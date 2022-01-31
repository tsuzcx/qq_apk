package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class VoiceTransTextUI$6
  extends ah
{
  VoiceTransTextUI$6(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 1) {
      VoiceTransTextUI.b(this.pyO, true);
    }
    while (i != 2) {
      return;
    }
    VoiceTransTextUI.b(this.pyO, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.6
 * JD-Core Version:    0.7.0.1
 */