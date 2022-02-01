package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
  implements i
{
  private String NHq;
  public int NHr;
  public a NHt;
  public String ndo;
  public String ocz;
  public String pRV;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.ocz = null;
    this.NHt = null;
    this.NHr = -1;
    this.NHq = null;
    this.ndo = null;
    this.pRV = null;
    bh.aGY().a(618, this);
    bh.aGY().a(616, this);
    bh.aGY().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void gwR()
  {
    AppMethodBeat.i(29796);
    bh.aGY().a(new g(this.ocz), 0);
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
        if (this.NHt != null) {
          this.NHt.gwS();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.NHt != null) {
        this.NHt.gwQ();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramq.getType() == 618)
    {
      this.ocz = ((e)paramq).jaS;
      Log.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.ocz)) });
      if (!Util.isNullOrNil(this.ocz)) {
        gwR();
      }
    }
    if (paramq.getType() == 616)
    {
      paramString = (g)paramq;
      this.NHr = paramString.NGY;
      this.NHq = paramString.NGX;
      Log.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.NHr), Boolean.valueOf(Util.isNullOrNil(this.NHq)) });
      if (this.NHt != null) {
        this.NHt.bfZ(this.NHq);
      }
    }
    if (paramq.getType() == 617)
    {
      paramString = (h)paramq;
      if (paramString.Lz == 0)
      {
        Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.ndo = paramString.ndo;
        if (this.NHt != null)
        {
          this.NHt.AG(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.NHt != null) {
          this.NHt.AG(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void AG(boolean paramBoolean);
    
    public abstract void bfZ(String paramString);
    
    public abstract void gwQ();
    
    public abstract void gwS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */