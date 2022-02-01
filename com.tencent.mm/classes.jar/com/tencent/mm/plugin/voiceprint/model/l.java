package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class l
  implements g
{
  public int AvX;
  public int Awj;
  private String Awk;
  public int Awl;
  public a Awm;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.Awj = 71;
    this.Awk = null;
    this.Awl = 0;
    this.AvX = 0;
    this.Awm = null;
    az.agi().a(611, this);
    az.agi().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.Awm = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29793);
    ac.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ac.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
        if (this.Awm != null) {
          this.Awm.ays(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.Awm != null) {
        this.Awm.egx();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.Awl = paramString.AvQ;
      this.Awk = paramString.AvP;
      ac.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.Awl), Boolean.valueOf(bs.isNullOrNil(this.Awk)) });
      if (this.Awm != null)
      {
        if (this.Awj != 71) {
          break label333;
        }
        this.Awm.ayq(this.Awk);
      }
    }
    if (paramn.getType() == 612)
    {
      paramString = (f)paramn;
      if (((paramString.AvZ != 72) || (paramString.LD != 0)) && (paramString.AvZ != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      ac.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.AvZ) });
      this.AvX = paramString.AvX;
      if (this.Awm != null) {
        this.Awm.R(true, paramString.AvZ);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.AvZ == 71) && (this.Awm != null)) {
        this.Awm.ayr(this.Awk);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.Awj != 72) {
        break;
      }
      this.Awm.ayr(this.Awk);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      ac.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.AvZ) });
      if (this.Awm != null) {
        this.Awm.R(false, paramString.AvZ);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void R(boolean paramBoolean, int paramInt);
    
    public abstract void ayq(String paramString);
    
    public abstract void ayr(String paramString);
    
    public abstract void ays(String paramString);
    
    public abstract void egx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */