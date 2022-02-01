package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aak;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class o
{
  public com.tencent.mm.modelvoice.m NHu;
  public MTimerHandler NHv;
  int NHw;
  int NHx;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.NHu = null;
    this.NHv = null;
    this.NHw = 0;
    this.NHx = 0;
    this.NHu = new com.tencent.mm.modelvoice.m();
    this.NHv = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        o.this.NHw += 100;
        o.this.NHx += o.this.NHu.aeK() * 100 / 100;
        if (o.this.NHw >= 3000)
        {
          Object localObject = o.this;
          Log.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).NHu.aeJ();
          ((o)localObject).NHv.stopTimer();
          ((o)localObject).NHx /= 30;
          if (((o)localObject).NHx >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).NHx), Boolean.valueOf(bool) });
            localObject = new aak();
            ((aak)localObject).fZC.fZD = bool;
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
    this.NHu.aeJ();
    Log.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void Yv()
  {
    AppMethodBeat.i(29801);
    Log.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.cN("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.NHu.ik(str))
    {
      this.NHu.aeJ();
      reset();
      Log.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.NHv.startTimer(100L);
      AppMethodBeat.o(29801);
      return;
      Log.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.NHv.stopTimer();
    this.NHw = 0;
    this.NHx = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */