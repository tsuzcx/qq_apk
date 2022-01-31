package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class o$1
  implements ap.a
{
  o$1(o paramo) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26117);
    this.trC.trA += 100;
    this.trC.trB += this.trC.jdField_try.getMaxAmplitude() * 100 / 100;
    if (this.trC.trA >= 3000)
    {
      Object localObject = this.trC;
      ab.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
      ((o)localObject).jdField_try.Et();
      ((o)localObject).trz.stopTimer();
      ((o)localObject).trB /= 30;
      if (((o)localObject).trB >= 30) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).trB), Boolean.valueOf(bool) });
        localObject = new ur();
        ((ur)localObject).cLg.cLh = bool;
        a.ymk.l((b)localObject);
        AppMethodBeat.o(26117);
        return false;
      }
    }
    AppMethodBeat.o(26117);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o.1
 * JD-Core Version:    0.7.0.1
 */