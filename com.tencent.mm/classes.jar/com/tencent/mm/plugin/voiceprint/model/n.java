package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class n
  implements com.tencent.mm.ak.g
{
  private String Awk;
  public int Awl;
  public a Awn;
  public String iRo;
  public String jGE;
  public String lhM;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.jGE = null;
    this.Awn = null;
    this.Awl = -1;
    this.Awk = null;
    this.iRo = null;
    this.lhM = null;
    az.agi().a(618, this);
    az.agi().a(616, this);
    az.agi().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void egy()
  {
    AppMethodBeat.i(29796);
    az.agi().a(new g(this.jGE), 0);
    AppMethodBeat.o(29796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(29797);
    ac.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((paramInt2 == -34) && (paramn.getType() == 617))
      {
        ac.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.Awn != null) {
          this.Awn.egz();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.Awn != null) {
        this.Awn.egx();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramn.getType() == 618)
    {
      this.jGE = ((e)paramn).fwd;
      ac.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(bs.isNullOrNil(this.jGE)) });
      if (!bs.isNullOrNil(this.jGE)) {
        egy();
      }
    }
    if (paramn.getType() == 616)
    {
      paramString = (g)paramn;
      this.Awl = paramString.AvQ;
      this.Awk = paramString.AvP;
      ac.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.Awl), Boolean.valueOf(bs.isNullOrNil(this.Awk)) });
      if (this.Awn != null) {
        this.Awn.ayt(this.Awk);
      }
    }
    if (paramn.getType() == 617)
    {
      paramString = (h)paramn;
      if (paramString.LD == 0)
      {
        ac.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.iRo = paramString.iRo;
        if (this.Awn != null)
        {
          this.Awn.sp(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        ac.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.Awn != null) {
          this.Awn.sp(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void ayt(String paramString);
    
    public abstract void egx();
    
    public abstract void egz();
    
    public abstract void sp(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */