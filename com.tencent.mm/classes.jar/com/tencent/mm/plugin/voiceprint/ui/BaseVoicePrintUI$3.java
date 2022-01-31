package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class BaseVoicePrintUI$3
  implements ap.a
{
  BaseVoicePrintUI$3(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26132);
    if (BaseVoicePrintUI.a(this.trX) == null)
    {
      AppMethodBeat.o(26132);
      return true;
    }
    p localp = BaseVoicePrintUI.a(this.trX);
    if (localp.caR != null)
    {
      i = localp.caR.getMaxAmplitude();
      if (i > p.ckX) {
        p.ckX = i;
      }
      ab.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.ckX + " per:" + i * 100 / p.ckX);
    }
    for (int i = i * 100 / p.ckX;; i = 0)
    {
      BaseVoicePrintUI.a(this.trX, i);
      AppMethodBeat.o(26132);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.3
 * JD-Core Version:    0.7.0.1
 */