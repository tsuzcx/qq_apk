package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  implements i
{
  public int NHe;
  public int NHp;
  private String NHq;
  public int NHr;
  public a NHs;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.NHp = 71;
    this.NHq = null;
    this.NHr = 0;
    this.NHe = 0;
    this.NHs = null;
    bh.aGY().a(611, this);
    bh.aGY().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.NHs = parama;
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
        if (this.NHs != null) {
          this.NHs.bfY(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.NHs != null) {
        this.NHs.gwQ();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramq.getType() == 611)
    {
      paramString = (d)paramq;
      this.NHr = paramString.NGY;
      this.NHq = paramString.NGX;
      Log.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.NHr), Boolean.valueOf(Util.isNullOrNil(this.NHq)) });
      if (this.NHs != null)
      {
        if (this.NHp != 71) {
          break label333;
        }
        this.NHs.bfW(this.NHq);
      }
    }
    if (paramq.getType() == 612)
    {
      paramString = (f)paramq;
      if (((paramString.NHf != 72) || (paramString.Lz != 0)) && (paramString.NHf != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      Log.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.NHf) });
      this.NHe = paramString.NHe;
      if (this.NHs != null) {
        this.NHs.al(true, paramString.NHf);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.NHf == 71) && (this.NHs != null)) {
        this.NHs.bfX(this.NHq);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.NHp != 72) {
        break;
      }
      this.NHs.bfX(this.NHq);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      Log.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.NHf) });
      if (this.NHs != null) {
        this.NHs.al(false, paramString.NHf);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void al(boolean paramBoolean, int paramInt);
    
    public abstract void bfW(String paramString);
    
    public abstract void bfX(String paramString);
    
    public abstract void bfY(String paramString);
    
    public abstract void gwQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */