package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
  implements g
{
  private String AvR;
  private int AvX;
  public a AwB;
  public String Awk;
  public int Awl;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.AwB = null;
    this.Awl = -1;
    this.Awk = null;
    this.AvR = null;
    this.AvX = 0;
    az.agi().a(611, this);
    az.agi().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.AwB = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29810);
    ac.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ac.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.AwB != null) {
          this.AwB.egz();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.AwB != null) {
        this.AwB.egx();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.Awl = paramString.AvQ;
      this.Awk = paramString.AvP;
      this.AvR = paramString.AvR;
      ac.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.Awl), this.AvR, Boolean.valueOf(bs.isNullOrNil(this.Awk)) });
      if (this.AwB != null) {
        this.AwB.ayt(this.Awk);
      }
    }
    if (paramn.getType() == 613) {
      if (((j)paramn).LD == 0)
      {
        ac.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.AwB != null)
        {
          this.AwB.sq(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        ac.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.AwB != null) {
          this.AwB.sq(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void ayt(String paramString);
    
    public abstract void egx();
    
    public abstract void egz();
    
    public abstract void sq(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */