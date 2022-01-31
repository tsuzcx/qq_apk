package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoiceTransTextUI$4
  implements ap.a
{
  VoiceTransTextUI$4(VoiceTransTextUI paramVoiceTransTextUI, int paramInt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25595);
    if (VoiceTransTextUI.m(this.taB))
    {
      AppMethodBeat.o(25595);
      return false;
    }
    ab.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[] { Integer.valueOf(this.sWi) });
    VoiceTransTextUI.a(this.taB, VoiceTransTextUI.a.taK);
    AppMethodBeat.o(25595);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.4
 * JD-Core Version:    0.7.0.1
 */