package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class o
{
  public com.tencent.mm.modelvoice.m zdI;
  public av zdJ;
  int zdK;
  int zdL;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.zdI = null;
    this.zdJ = null;
    this.zdK = 0;
    this.zdL = 0;
    this.zdI = new com.tencent.mm.modelvoice.m();
    this.zdJ = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        o.this.zdK += 100;
        o.this.zdL += o.this.zdI.getMaxAmplitude() * 100 / 100;
        if (o.this.zdK >= 3000)
        {
          Object localObject = o.this;
          ad.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).zdI.Ob();
          ((o)localObject).zdJ.stopTimer();
          ((o)localObject).zdL /= 30;
          if (((o)localObject).zdL >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).zdL), Boolean.valueOf(bool) });
            localObject = new wq();
            ((wq)localObject).dCd.dCe = bool;
            a.ESL.l((b)localObject);
            AppMethodBeat.o(29798);
            return false;
          }
        }
        AppMethodBeat.o(29798);
        return true;
      }
    }, true);
    AppMethodBeat.o(29799);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(29800);
    this.zdI.Ob();
    ad.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void dRq()
  {
    AppMethodBeat.i(29801);
    ad.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.bP("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.zdI.fO(str))
    {
      this.zdI.Ob();
      reset();
      ad.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.zdJ.av(100L, 100L);
      AppMethodBeat.o(29801);
      return;
      ad.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.zdJ.stopTimer();
    this.zdK = 0;
    this.zdL = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */