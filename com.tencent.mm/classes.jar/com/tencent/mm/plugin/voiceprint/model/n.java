package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
  implements f
{
  private String BVF;
  public int BVG;
  public a BVI;
  public String jkw;
  public String kaQ;
  public String lEN;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.kaQ = null;
    this.BVI = null;
    this.BVG = -1;
    this.BVF = null;
    this.jkw = null;
    this.lEN = null;
    ba.aiU().a(618, this);
    ba.aiU().a(616, this);
    ba.aiU().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void euk()
  {
    AppMethodBeat.i(29796);
    ba.aiU().a(new g(this.kaQ), 0);
    AppMethodBeat.o(29796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(29797);
    ad.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((paramInt2 == -34) && (paramn.getType() == 617))
      {
        ad.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.BVI != null) {
          this.BVI.eul();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.BVI != null) {
        this.BVI.euj();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramn.getType() == 618)
    {
      this.kaQ = ((e)paramn).fPq;
      ad.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.kaQ)) });
      if (!bt.isNullOrNil(this.kaQ)) {
        euk();
      }
    }
    if (paramn.getType() == 616)
    {
      paramString = (g)paramn;
      this.BVG = paramString.BVl;
      this.BVF = paramString.BVk;
      ad.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.BVG), Boolean.valueOf(bt.isNullOrNil(this.BVF)) });
      if (this.BVI != null) {
        this.BVI.aDC(this.BVF);
      }
    }
    if (paramn.getType() == 617)
    {
      paramString = (h)paramn;
      if (paramString.Nv == 0)
      {
        ad.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.jkw = paramString.jkw;
        if (this.BVI != null)
        {
          this.BVI.sY(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        ad.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.BVI != null) {
          this.BVI.sY(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void aDC(String paramString);
    
    public abstract void euj();
    
    public abstract void eul();
    
    public abstract void sY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */