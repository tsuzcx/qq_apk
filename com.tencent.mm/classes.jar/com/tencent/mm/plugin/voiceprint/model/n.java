package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
  implements com.tencent.mm.al.g
{
  public String iri;
  public String jgp;
  public String kGt;
  private String zdE;
  public int zdF;
  public a zdH;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.jgp = null;
    this.zdH = null;
    this.zdF = -1;
    this.zdE = null;
    this.iri = null;
    this.kGt = null;
    az.aeS().a(618, this);
    az.aeS().a(616, this);
    az.aeS().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(29796);
    az.aeS().a(new g(this.jgp), 0);
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
        if (this.zdH != null) {
          this.zdH.dRp();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.zdH != null) {
        this.zdH.dRn();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramn.getType() == 618)
    {
      this.jgp = ((e)paramn).fsw;
      ad.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.jgp)) });
      if (!bt.isNullOrNil(this.jgp)) {
        dRo();
      }
    }
    if (paramn.getType() == 616)
    {
      paramString = (g)paramn;
      this.zdF = paramString.zdk;
      this.zdE = paramString.zdj;
      ad.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.zdF), Boolean.valueOf(bt.isNullOrNil(this.zdE)) });
      if (this.zdH != null) {
        this.zdH.atc(this.zdE);
      }
    }
    if (paramn.getType() == 617)
    {
      paramString = (h)paramn;
      if (paramString.KI == 0)
      {
        ad.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.iri = paramString.iri;
        if (this.zdH != null)
        {
          this.zdH.ro(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        ad.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.zdH != null) {
          this.zdH.ro(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void atc(String paramString);
    
    public abstract void dRn();
    
    public abstract void dRp();
    
    public abstract void ro(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */