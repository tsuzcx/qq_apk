package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.text.ClipboardManager;
import android.widget.TextView;
import com.tencent.mm.ui.base.h.c;

final class VoiceTransTextUI$2$1
  implements h.c
{
  VoiceTransTextUI$2$1(VoiceTransTextUI.2 param2) {}
  
  public final void gl(int paramInt)
  {
    if ((paramInt == 0) && (VoiceTransTextUI.a(this.pyP.pyO) != null) && (VoiceTransTextUI.b(this.pyP.pyO) != null)) {
      VoiceTransTextUI.a(this.pyP.pyO).setText(VoiceTransTextUI.b(this.pyP.pyO).getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.2.1
 * JD-Core Version:    0.7.0.1
 */