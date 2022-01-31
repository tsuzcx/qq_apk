package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoicePrintVolumeMeter$1
  implements ap.a
{
  VoicePrintVolumeMeter$1(VoicePrintVolumeMeter paramVoicePrintVolumeMeter) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26209);
    VoicePrintVolumeMeter.a(this.tsM);
    boolean bool = VoicePrintVolumeMeter.b(this.tsM);
    AppMethodBeat.o(26209);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter.1
 * JD-Core Version:    0.7.0.1
 */