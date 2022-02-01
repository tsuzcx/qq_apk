package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  implements i
{
  public int GQT;
  public int GRe;
  private String GRf;
  public int GRg;
  public a GRh;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.GRe = 71;
    this.GRf = null;
    this.GRg = 0;
    this.GQT = 0;
    this.GRh = null;
    bg.azz().a(611, this);
    bg.azz().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.GRh = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29793);
    Log.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        Log.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
        if (this.GRh != null) {
          this.GRh.aUu(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.GRh != null) {
        this.GRh.fED();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramq.getType() == 611)
    {
      paramString = (d)paramq;
      this.GRg = paramString.GQN;
      this.GRf = paramString.GQM;
      Log.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.GRg), Boolean.valueOf(Util.isNullOrNil(this.GRf)) });
      if (this.GRh != null)
      {
        if (this.GRe != 71) {
          break label333;
        }
        this.GRh.aUs(this.GRf);
      }
    }
    if (paramq.getType() == 612)
    {
      paramString = (f)paramq;
      if (((paramString.GQU != 72) || (paramString.NH != 0)) && (paramString.GQU != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      Log.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.GQU) });
      this.GQT = paramString.GQT;
      if (this.GRh != null) {
        this.GRh.Y(true, paramString.GQU);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.GQU == 71) && (this.GRh != null)) {
        this.GRh.aUt(this.GRf);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.GRe != 72) {
        break;
      }
      this.GRh.aUt(this.GRf);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      Log.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.GQU) });
      if (this.GRh != null) {
        this.GRh.Y(false, paramString.GQU);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Y(boolean paramBoolean, int paramInt);
    
    public abstract void aUs(String paramString);
    
    public abstract void aUt(String paramString);
    
    public abstract void aUu(String paramString);
    
    public abstract void fED();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */