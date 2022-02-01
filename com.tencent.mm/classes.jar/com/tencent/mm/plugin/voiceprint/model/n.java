package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
  implements i
{
  private String GRf;
  public int GRg;
  public a GRi;
  public String kly;
  public String lhR;
  public String mRa;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.lhR = null;
    this.GRi = null;
    this.GRg = -1;
    this.GRf = null;
    this.kly = null;
    this.mRa = null;
    bg.azz().a(618, this);
    bg.azz().a(616, this);
    bg.azz().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void fEE()
  {
    AppMethodBeat.i(29796);
    bg.azz().a(new g(this.lhR), 0);
    AppMethodBeat.o(29796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29797);
    Log.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((paramInt2 == -34) && (paramq.getType() == 617))
      {
        Log.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.GRi != null) {
          this.GRi.fEF();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.GRi != null) {
        this.GRi.fED();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramq.getType() == 618)
    {
      this.lhR = ((e)paramq).gwF;
      Log.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.lhR)) });
      if (!Util.isNullOrNil(this.lhR)) {
        fEE();
      }
    }
    if (paramq.getType() == 616)
    {
      paramString = (g)paramq;
      this.GRg = paramString.GQN;
      this.GRf = paramString.GQM;
      Log.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.GRg), Boolean.valueOf(Util.isNullOrNil(this.GRf)) });
      if (this.GRi != null) {
        this.GRi.aUv(this.GRf);
      }
    }
    if (paramq.getType() == 617)
    {
      paramString = (h)paramq;
      if (paramString.NH == 0)
      {
        Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.kly = paramString.kly;
        if (this.GRi != null)
        {
          this.GRi.wO(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.GRi != null) {
          this.GRi.wO(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void aUv(String paramString);
    
    public abstract void fED();
    
    public abstract void fEF();
    
    public abstract void wO(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */