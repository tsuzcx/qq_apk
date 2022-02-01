package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  implements g
{
  public String zdE;
  public int zdF;
  public a zdV;
  private String zdl;
  private int zdr;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.zdV = null;
    this.zdF = -1;
    this.zdE = null;
    this.zdl = null;
    this.zdr = 0;
    az.aeS().a(611, this);
    az.aeS().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.zdV = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29810);
    ad.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ad.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.zdV != null) {
          this.zdV.dRp();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.zdV != null) {
        this.zdV.dRn();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.zdF = paramString.zdk;
      this.zdE = paramString.zdj;
      this.zdl = paramString.zdl;
      ad.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.zdF), this.zdl, Boolean.valueOf(bt.isNullOrNil(this.zdE)) });
      if (this.zdV != null) {
        this.zdV.atc(this.zdE);
      }
    }
    if (paramn.getType() == 613) {
      if (((j)paramn).KI == 0)
      {
        ad.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.zdV != null)
        {
          this.zdV.rp(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        ad.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.zdV != null) {
          this.zdV.rp(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void atc(String paramString);
    
    public abstract void dRn();
    
    public abstract void dRp();
    
    public abstract void rp(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */