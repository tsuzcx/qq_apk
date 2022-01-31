package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class o
{
  int trA;
  int trB;
  public com.tencent.mm.modelvoice.m jdField_try;
  public ap trz;
  
  public o()
  {
    AppMethodBeat.i(26118);
    this.jdField_try = null;
    this.trz = null;
    this.trA = 0;
    this.trB = 0;
    this.jdField_try = new com.tencent.mm.modelvoice.m();
    this.trz = new ap(Looper.getMainLooper(), new o.1(this), true);
    AppMethodBeat.o(26118);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(26119);
    this.jdField_try.Et();
    ab.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    AppMethodBeat.o(26119);
  }
  
  public final void cLi()
  {
    AppMethodBeat.i(26120);
    ab.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    reset();
    String str = m.bE("voice_pt_voice_print_noise_detect.rec", true);
    if (!this.jdField_try.eH(str))
    {
      this.jdField_try.Et();
      reset();
      ab.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      this.trz.ag(100L, 100L);
      AppMethodBeat.o(26120);
      return;
      ab.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(26121);
    stopRecord();
    this.trz.stopTimer();
    this.trA = 0;
    this.trB = 0;
    AppMethodBeat.o(26121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */