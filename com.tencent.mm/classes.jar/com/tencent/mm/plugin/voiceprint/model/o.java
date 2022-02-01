package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class o
{
  public com.tencent.mm.modelvoice.m Cnk;
  public aw Cnl;
  int Cnm;
  int Cnn;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.Cnk = null;
    this.Cnl = null;
    this.Cnm = 0;
    this.Cnn = 0;
    this.Cnk = new com.tencent.mm.modelvoice.m();
    this.Cnl = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        o.this.Cnm += 100;
        o.this.Cnn += o.this.Cnk.getMaxAmplitude() * 100 / 100;
        if (o.this.Cnm >= 3000)
        {
          Object localObject = o.this;
          ae.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).Cnk.PF();
          ((o)localObject).Cnl.stopTimer();
          ((o)localObject).Cnn /= 30;
          if (((o)localObject).Cnn >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            ae.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).Cnn), Boolean.valueOf(bool) });
            localObject = new yb();
            ((yb)localObject).dNu.dNv = bool;
            a.IvT.l((b)localObject);
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
    this.Cnk.PF();
    ae.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void JE()
  {
    AppMethodBeat.i(29801);
    ae.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.ch("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.Cnk.gF(str))
    {
      this.Cnk.PF();
      reset();
      ae.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.Cnl.ay(100L, 100L);
      AppMethodBeat.o(29801);
      return;
      ae.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.Cnl.stopTimer();
    this.Cnm = 0;
    this.Cnn = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */