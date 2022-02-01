package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class o
{
  public com.tencent.mm.modelvoice.m Awo;
  public au Awp;
  int Awq;
  int Awr;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.Awo = null;
    this.Awp = null;
    this.Awq = 0;
    this.Awr = 0;
    this.Awo = new com.tencent.mm.modelvoice.m();
    this.Awp = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        o.this.Awq += 100;
        o.this.Awr += o.this.Awo.getMaxAmplitude() * 100 / 100;
        if (o.this.Awq >= 3000)
        {
          Object localObject = o.this;
          ac.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).Awo.NX();
          ((o)localObject).Awp.stopTimer();
          ((o)localObject).Awr /= 30;
          if (((o)localObject).Awr >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            ac.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).Awr), Boolean.valueOf(bool) });
            localObject = new xb();
            ((xb)localObject).dzR.dzS = bool;
            a.GpY.l((b)localObject);
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
    this.Awo.NX();
    ac.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void egA()
  {
    AppMethodBeat.i(29801);
    ac.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.bW("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.Awo.fE(str))
    {
      this.Awo.NX();
      reset();
      ac.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.Awp.au(100L, 100L);
      AppMethodBeat.o(29801);
      return;
      ac.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.Awp.stopTimer();
    this.Awq = 0;
    this.Awr = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */