package com.tencent.mm.pluginsdk.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class VoiceInputLayout$1
  extends ak
{
  VoiceInputLayout$1(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(27579);
    if (paramMessage.what != 0)
    {
      if (paramMessage.what == 1) {
        ab.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(this.vSy.currentState) });
      }
    }
    else
    {
      ab.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(this.vSy.currentState) });
      if (this.vSy.currentState == 3) {
        break label94;
      }
      AppMethodBeat.o(27579);
      return;
    }
    AppMethodBeat.o(27579);
    return;
    label94:
    VoiceInputLayout.a(this.vSy).removeMessages(0);
    VoiceInputLayout.a(this.vSy).removeMessages(1);
    if (VoiceInputLayout.b(this.vSy) != null) {
      VoiceInputLayout.b(this.vSy).cancel(true);
    }
    this.vSy.reset(true);
    AppMethodBeat.o(27579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.1
 * JD-Core Version:    0.7.0.1
 */