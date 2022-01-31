package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class o
{
  public k pLC = null;
  public am pLD = null;
  int pLE = 0;
  int pLF = 0;
  
  public final void reset()
  {
    this.pLC.uh();
    y.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
    this.pLD.stopTimer();
    this.pLE = 0;
    this.pLF = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.o
 * JD-Core Version:    0.7.0.1
 */