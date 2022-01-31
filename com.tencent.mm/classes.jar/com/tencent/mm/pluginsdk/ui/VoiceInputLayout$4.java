package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoiceInputLayout$4
  implements ap.a
{
  VoiceInputLayout$4(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(27585);
    if (VoiceInputLayout.b(this.vSy) == null)
    {
      AppMethodBeat.o(27585);
      return true;
    }
    int i = VoiceInputLayout.b(this.vSy).getMaxAmplitudeRate();
    if (this.vSy.currentState == 2) {
      this.vSy.wF(i);
    }
    AppMethodBeat.o(27585);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.4
 * JD-Core Version:    0.7.0.1
 */