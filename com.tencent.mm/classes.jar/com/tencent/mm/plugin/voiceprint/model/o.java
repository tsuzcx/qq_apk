package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class o
{
  public com.tencent.mm.modelvoice.m GRj;
  public MTimerHandler GRk;
  int GRl;
  int GRm;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.GRj = null;
    this.GRk = null;
    this.GRl = 0;
    this.GRm = 0;
    this.GRj = new com.tencent.mm.modelvoice.m();
    this.GRk = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        o.this.GRl += 100;
        o.this.GRm += o.this.GRj.getMaxAmplitude() * 100 / 100;
        if (o.this.GRl >= 3000)
        {
          Object localObject = o.this;
          Log.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).GRj.ZZ();
          ((o)localObject).GRk.stopTimer();
          ((o)localObject).GRm /= 30;
          if (((o)localObject).GRm >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).GRm), Boolean.valueOf(bool) });
            localObject = new zd();
            ((zd)localObject).efn.efo = bool;
            EventCenter.instance.publish((IEvent)localObject);
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
    this.GRj.ZZ();
    Log.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void TR()
  {
    AppMethodBeat.i(29801);
    Log.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.cz("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.GRj.hw(str))
    {
      this.GRj.ZZ();
      reset();
      Log.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.GRk.startTimer(100L);
      AppMethodBeat.o(29801);
      return;
      Log.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.GRk.stopTimer();
    this.GRl = 0;
    this.GRm = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */