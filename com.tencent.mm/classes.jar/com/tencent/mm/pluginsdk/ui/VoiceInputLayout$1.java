package com.tencent.mm.pluginsdk.ui;

import android.os.Message;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceInputLayout$1
  extends ah
{
  VoiceInputLayout$1(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0)
    {
      if (paramMessage.what == 1) {
        y.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(this.sbr.kFU) });
      }
    }
    else
    {
      y.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(this.sbr.kFU) });
      if (this.sbr.kFU == 3) {
        break label75;
      }
    }
    return;
    label75:
    VoiceInputLayout.a(this.sbr).removeMessages(0);
    VoiceInputLayout.a(this.sbr).removeMessages(1);
    if (VoiceInputLayout.b(this.sbr) != null) {
      VoiceInputLayout.b(this.sbr).cancel(true);
    }
    this.sbr.reset(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.1
 * JD-Core Version:    0.7.0.1
 */