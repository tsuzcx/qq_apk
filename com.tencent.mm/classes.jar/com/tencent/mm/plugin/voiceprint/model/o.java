package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ach;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class o
{
  public com.tencent.mm.modelvoice.m Utu;
  public MTimerHandler Utv;
  int Utw;
  int Utx;
  
  public o()
  {
    AppMethodBeat.i(29799);
    this.Utu = null;
    this.Utv = null;
    this.Utw = 0;
    this.Utx = 0;
    this.Utu = new com.tencent.mm.modelvoice.m();
    this.Utv = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29798);
        Object localObject = o.this;
        ((o)localObject).Utw += 100;
        localObject = o.this;
        ((o)localObject).Utx = (o.this.Utu.aGI() * 100 / 100 + ((o)localObject).Utx);
        if (o.this.Utw >= 3000)
        {
          localObject = o.this;
          Log.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
          ((o)localObject).Utu.aGH();
          ((o)localObject).Utv.stopTimer();
          ((o)localObject).Utx /= 30;
          if (((o)localObject).Utx >= 30) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[] { Integer.valueOf(((o)localObject).Utx), Boolean.valueOf(bool) });
            localObject = new ach();
            ((ach)localObject).ifK.ifL = bool;
            ((ach)localObject).publish();
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
    this.Utu.aGH();
    Log.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(29800);
  }
  
  public final void aAq()
  {
    AppMethodBeat.i(29801);
    Log.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.dt("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.Utu.jL(str))
    {
      this.Utu.aGH();
      reset();
      Log.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.Utv.startTimer(100L);
      AppMethodBeat.o(29801);
      return;
      Log.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29802);
    stopRecord();
    this.Utv.stopTimer();
    this.Utw = 0;
    this.Utx = 0;
    AppMethodBeat.o(29802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */