package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class l
  implements com.tencent.mm.al.f
{
  public int BVE;
  private String BVF;
  public int BVG;
  public a BVH;
  public int BVs;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.BVE = 71;
    this.BVF = null;
    this.BVG = 0;
    this.BVs = 0;
    this.BVH = null;
    ba.aiU().a(611, this);
    ba.aiU().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.BVH = parama;
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
        if (this.BVH != null) {
          this.BVH.aDB(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.BVH != null) {
        this.BVH.euj();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.BVG = paramString.BVl;
      this.BVF = paramString.BVk;
      ad.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.BVG), Boolean.valueOf(bt.isNullOrNil(this.BVF)) });
      if (this.BVH != null)
      {
        if (this.BVE != 71) {
          break label333;
        }
        this.BVH.aDz(this.BVF);
      }
    }
    if (paramn.getType() == 612)
    {
      paramString = (f)paramn;
      if (((paramString.BVu != 72) || (paramString.Nv != 0)) && (paramString.BVu != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      ad.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.BVu) });
      this.BVs = paramString.BVs;
      if (this.BVH != null) {
        this.BVH.S(true, paramString.BVu);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.BVu == 71) && (this.BVH != null)) {
        this.BVH.aDA(this.BVF);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.BVE != 72) {
        break;
      }
      this.BVH.aDA(this.BVF);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      ad.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.BVu) });
      if (this.BVH != null) {
        this.BVH.S(false, paramString.BVu);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void S(boolean paramBoolean, int paramInt);
    
    public abstract void aDA(String paramString);
    
    public abstract void aDB(String paramString);
    
    public abstract void aDz(String paramString);
    
    public abstract void euj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */