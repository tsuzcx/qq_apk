package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class q
  implements f
{
  private String CmN;
  private int CmT;
  public String Cng;
  public int Cnh;
  public a Cnx;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.Cnx = null;
    this.Cnh = -1;
    this.Cng = null;
    this.CmN = null;
    this.CmT = 0;
    bc.ajj().a(611, this);
    bc.ajj().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.Cnx = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29810);
    ae.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ae.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.Cnx != null) {
          this.Cnx.exR();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.Cnx != null) {
        this.Cnx.exP();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.Cnh = paramString.CmM;
      this.Cng = paramString.CmL;
      this.CmN = paramString.CmN;
      ae.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.Cnh), this.CmN, Boolean.valueOf(bu.isNullOrNil(this.Cng)) });
      if (this.Cnx != null) {
        this.Cnx.aEV(this.Cng);
      }
    }
    if (paramn.getType() == 613) {
      if (((j)paramn).Nv == 0)
      {
        ae.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.Cnx != null)
        {
          this.Cnx.tg(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        ae.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.Cnx != null) {
          this.Cnx.tg(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void aEV(String paramString);
    
    public abstract void exP();
    
    public abstract void exR();
    
    public abstract void tg(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */