package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class p
  implements g.a
{
  public static int ckX = 100;
  public m caR = null;
  public String fileName = "";
  public b gaP;
  private int jRV = 0;
  public long lvI = 0L;
  public boolean sXv = false;
  public int sXy = 0;
  public p.b trD;
  public String trE;
  public boolean trF = false;
  public p.a trG = null;
  
  public final boolean Ez()
  {
    long l = 0L;
    AppMethodBeat.i(26127);
    aw.aaA().KF();
    this.trF = false;
    ab.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      ab.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.caR != null) {
        this.caR.Et();
      }
      if (this.sXy != 2)
      {
        this.fileName = null;
        this.trF = false;
        ab.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.sXy = -1;
        ab.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.trF);
        if (this.gaP != null) {
          this.gaP.Mh();
        }
        boolean bool = this.trF;
        AppMethodBeat.o(26127);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(26127);
    }
    if (this.lvI <= 0L)
    {
      label207:
      this.jRV = ((int)l);
      if (this.jRV >= 1000) {
        break label290;
      }
      ab.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.jRV);
      this.fileName = "";
      this.trF = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = bo.av(this.lvI);
      break label207;
      label290:
      this.trF = true;
      ab.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(26126);
    ab.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(paramInt)));
    if (this.sXv)
    {
      AppMethodBeat.o(26126);
      return;
    }
    this.sXv = true;
    aw.aaA().b(this);
    this.caR = new m();
    this.trD = new p.b(this);
    this.trD.start();
    this.trF = false;
    this.sXy = 1;
    AppMethodBeat.o(26126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p
 * JD-Core Version:    0.7.0.1
 */