package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class l
  implements g
{
  public int zdD;
  private String zdE;
  public int zdF;
  public a zdG;
  public int zdr;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.zdD = 71;
    this.zdE = null;
    this.zdF = 0;
    this.zdr = 0;
    this.zdG = null;
    az.aeS().a(611, this);
    az.aeS().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.zdG = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29793);
    ad.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ad.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
        if (this.zdG != null) {
          this.zdG.atb(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.zdG != null) {
        this.zdG.dRn();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.zdF = paramString.zdk;
      this.zdE = paramString.zdj;
      ad.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.zdF), Boolean.valueOf(bt.isNullOrNil(this.zdE)) });
      if (this.zdG != null)
      {
        if (this.zdD != 71) {
          break label333;
        }
        this.zdG.asZ(this.zdE);
      }
    }
    if (paramn.getType() == 612)
    {
      paramString = (f)paramn;
      if (((paramString.zdt != 72) || (paramString.KI != 0)) && (paramString.zdt != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      ad.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.zdt) });
      this.zdr = paramString.zdr;
      if (this.zdG != null) {
        this.zdG.P(true, paramString.zdt);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.zdt == 71) && (this.zdG != null)) {
        this.zdG.ata(this.zdE);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.zdD != 72) {
        break;
      }
      this.zdG.ata(this.zdE);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      ad.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.zdt) });
      if (this.zdG != null) {
        this.zdG.P(false, paramString.zdt);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void P(boolean paramBoolean, int paramInt);
    
    public abstract void asZ(String paramString);
    
    public abstract void ata(String paramString);
    
    public abstract void atb(String paramString);
    
    public abstract void dRn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */