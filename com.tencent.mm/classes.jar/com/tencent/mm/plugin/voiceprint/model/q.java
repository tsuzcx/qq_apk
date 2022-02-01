package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  implements f
{
  public String BVF;
  public int BVG;
  public a BVW;
  private String BVm;
  private int BVs;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.BVW = null;
    this.BVG = -1;
    this.BVF = null;
    this.BVm = null;
    this.BVs = 0;
    ba.aiU().a(611, this);
    ba.aiU().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.BVW = parama;
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
        if (this.BVW != null) {
          this.BVW.eul();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.BVW != null) {
        this.BVW.euj();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.BVG = paramString.BVl;
      this.BVF = paramString.BVk;
      this.BVm = paramString.BVm;
      ad.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.BVG), this.BVm, Boolean.valueOf(bt.isNullOrNil(this.BVF)) });
      if (this.BVW != null) {
        this.BVW.aDC(this.BVF);
      }
    }
    if (paramn.getType() == 613) {
      if (((j)paramn).Nv == 0)
      {
        ad.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.BVW != null)
        {
          this.BVW.sZ(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        ad.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.BVW != null) {
          this.BVW.sZ(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void aDC(String paramString);
    
    public abstract void euj();
    
    public abstract void eul();
    
    public abstract void sZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */