package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.h.a.sy;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class o$1
  implements am.a
{
  o$1(o paramo) {}
  
  public final boolean tC()
  {
    this.pLG.pLE += 100;
    this.pLG.pLF += this.pLG.pLC.getMaxAmplitude() * 100 / 100;
    if (this.pLG.pLE >= 3000)
    {
      Object localObject = this.pLG;
      y.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
      ((o)localObject).pLC.uh();
      ((o)localObject).pLD.stopTimer();
      ((o)localObject).pLF /= 30;
      if (((o)localObject).pLF >= 30) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).pLF), Boolean.valueOf(bool) });
        localObject = new sy();
        ((sy)localObject).ccy.ccz = bool;
        a.udP.m((b)localObject);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o.1
 * JD-Core Version:    0.7.0.1
 */