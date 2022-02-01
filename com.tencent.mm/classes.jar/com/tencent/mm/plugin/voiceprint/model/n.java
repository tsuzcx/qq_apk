package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class n
  implements f
{
  private String Cng;
  public int Cnh;
  public a Cnj;
  public String jnq;
  public String keg;
  public String lJm;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.keg = null;
    this.Cnj = null;
    this.Cnh = -1;
    this.Cng = null;
    this.jnq = null;
    this.lJm = null;
    bc.ajj().a(618, this);
    bc.ajj().a(616, this);
    bc.ajj().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void exQ()
  {
    AppMethodBeat.i(29796);
    bc.ajj().a(new g(this.keg), 0);
    AppMethodBeat.o(29796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(29797);
    ae.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((paramInt2 == -34) && (paramn.getType() == 617))
      {
        ae.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.Cnj != null) {
          this.Cnj.exR();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.Cnj != null) {
        this.Cnj.exP();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramn.getType() == 618)
    {
      this.keg = ((e)paramn).fRw;
      ae.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(bu.isNullOrNil(this.keg)) });
      if (!bu.isNullOrNil(this.keg)) {
        exQ();
      }
    }
    if (paramn.getType() == 616)
    {
      paramString = (g)paramn;
      this.Cnh = paramString.CmM;
      this.Cng = paramString.CmL;
      ae.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.Cnh), Boolean.valueOf(bu.isNullOrNil(this.Cng)) });
      if (this.Cnj != null) {
        this.Cnj.aEV(this.Cng);
      }
    }
    if (paramn.getType() == 617)
    {
      paramString = (h)paramn;
      if (paramString.Nv == 0)
      {
        ae.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.jnq = paramString.jnq;
        if (this.Cnj != null)
        {
          this.Cnj.tf(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        ae.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.Cnj != null) {
          this.Cnj.tf(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void aEV(String paramString);
    
    public abstract void exP();
    
    public abstract void exR();
    
    public abstract void tf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */