package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class o
{
  public com.tencent.mm.modelvoice.m BVJ;
  public av BVK;
  int BVL;
  int BVM;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.BVJ = null;
    this.BVK = null;
    this.BVL = 0;
    this.BVM = 0;
    this.BVJ = new com.tencent.mm.modelvoice.m();
    this.BVK = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        o.this.BVL += 100;
        o.this.BVM += o.this.BVJ.getMaxAmplitude() * 100 / 100;
        if (o.this.BVL >= 3000)
        {
          Object localObject = o.this;
          ad.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).BVJ.PG();
          ((o)localObject).BVK.stopTimer();
          ((o)localObject).BVM /= 30;
          if (((o)localObject).BVM >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).BVM), Boolean.valueOf(bool) });
            localObject = new xv();
            ((xv)localObject).dMe.dMf = bool;
            a.IbL.l((b)localObject);
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
    this.BVJ.PG();
    ad.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void Jw()
  {
    AppMethodBeat.i(29801);
    ad.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.cd("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.BVJ.gz(str))
    {
      this.BVJ.PG();
      reset();
      ad.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.BVK.az(100L, 100L);
      AppMethodBeat.o(29801);
      return;
      ad.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.BVK.stopTimer();
    this.BVL = 0;
    this.BVM = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */