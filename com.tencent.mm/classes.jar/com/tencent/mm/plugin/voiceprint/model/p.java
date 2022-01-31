package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  implements f.a
{
  public static int bEl = 100;
  public k byP = null;
  public b eLi;
  public String fileName = "";
  private int hYh = 0;
  public long jlU = 0L;
  public p.b pLH;
  public String pLI;
  public boolean pLJ = false;
  public p.a pLK = null;
  public boolean pvP = false;
  public int pvS = 0;
  
  public final void ew(int paramInt)
  {
    y.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :" + paramInt);
    if (this.pvP) {
      return;
    }
    this.pvP = true;
    au.Hy().b(this);
    this.byP = new k();
    this.pLH = new p.b(this);
    this.pLH.start();
    this.pLJ = false;
    this.pvS = 1;
  }
  
  public final boolean un()
  {
    long l = 0L;
    au.Hy().yl();
    this.pLJ = false;
    y.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      y.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.byP != null) {
        this.byP.uh();
      }
      if (this.pvS != 2)
      {
        this.fileName = null;
        this.pLJ = false;
        y.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.pvS = -1;
        y.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.pLJ);
        if (this.eLi != null) {
          this.eLi.zE();
        }
        return this.pLJ;
      }
    }
    finally {}
    if (this.jlU <= 0L)
    {
      label185:
      this.hYh = ((int)l);
      if (this.hYh >= 1000) {
        break label268;
      }
      y.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.hYh);
      this.fileName = "";
      this.pLJ = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = bk.cp(this.jlU);
      break label185;
      label268:
      this.pLJ = true;
      y.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p
 * JD-Core Version:    0.7.0.1
 */