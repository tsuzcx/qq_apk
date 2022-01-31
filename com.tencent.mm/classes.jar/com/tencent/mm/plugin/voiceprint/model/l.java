package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  implements com.tencent.mm.ah.f
{
  public a pLA = null;
  public int pLl = 0;
  public int pLx = 71;
  private String pLy = null;
  public int pLz = 0;
  
  public l()
  {
    au.Dk().a(611, this);
    au.Dk().a(612, this);
  }
  
  public l(a parama)
  {
    this();
    this.pLA = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      if (this.pLA != null) {
        this.pLA.bPa();
      }
    }
    label146:
    label190:
    label351:
    for (;;)
    {
      return;
      if (paramm.getType() == 611)
      {
        paramString = (d)paramm;
        this.pLz = paramString.pLe;
        this.pLy = paramString.pLd;
        y.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.pLz), Boolean.valueOf(bk.bl(this.pLy)) });
        if (this.pLA != null)
        {
          if (this.pLx != 71) {
            break label278;
          }
          this.pLA.PV(this.pLy);
        }
      }
      if (paramm.getType() == 612)
      {
        paramString = (f)paramm;
        if (((paramString.pLn != 72) || (paramString.Do != 0)) && (paramString.pLn != 71)) {
          break label303;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label308;
        }
        y.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.pLn) });
        this.pLl = paramString.pLl;
        if (this.pLA != null) {
          this.pLA.x(true, paramString.pLn);
        }
      }
      for (;;)
      {
        if ((paramInt1 == 0) || (paramString.pLn != 71) || (this.pLA == null)) {
          break label351;
        }
        this.pLA.PW(this.pLy);
        return;
        if (this.pLx != 72) {
          break label146;
        }
        this.pLA.PW(this.pLy);
        break label146;
        break;
        paramInt1 = 0;
        break label190;
        y.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.pLn) });
        if (this.pLA != null) {
          this.pLA.x(false, paramString.pLn);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void PV(String paramString);
    
    public abstract void PW(String paramString);
    
    public abstract void bPa();
    
    public abstract void x(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */