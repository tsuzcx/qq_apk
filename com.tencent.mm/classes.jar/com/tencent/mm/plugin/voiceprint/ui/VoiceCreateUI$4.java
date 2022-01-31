package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.modelvoice.k;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceCreateUI$4
  implements NoiseDetectMaskView.a
{
  VoiceCreateUI$4(VoiceCreateUI paramVoiceCreateUI) {}
  
  public final void bPk()
  {
    VoiceCreateUI.e(this.pMr);
    o localo = VoiceCreateUI.f(this.pMr);
    y.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
    localo.pLC.uh();
    localo.pLD.stopTimer();
    this.pMr.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.4
 * JD-Core Version:    0.7.0.1
 */