package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.text.ClipboardManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class VoiceTransTextUI$2$1
  implements h.c
{
  VoiceTransTextUI$2$1(VoiceTransTextUI.2 param2) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(25592);
    if ((paramInt == 0) && (VoiceTransTextUI.a(this.taC.taB) != null) && (VoiceTransTextUI.b(this.taC.taB) != null)) {
      VoiceTransTextUI.a(this.taC.taB).setText(VoiceTransTextUI.b(this.taC.taB).getText());
    }
    AppMethodBeat.o(25592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.2.1
 * JD-Core Version:    0.7.0.1
 */