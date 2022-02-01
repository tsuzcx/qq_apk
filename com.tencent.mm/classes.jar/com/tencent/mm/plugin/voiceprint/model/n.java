package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
  implements com.tencent.mm.am.h
{
  private String Utq;
  public int Utr;
  public a Utt;
  public String pZt;
  public String rdq;
  public String sWX;
  
  public n()
  {
    AppMethodBeat.i(29795);
    this.rdq = null;
    this.Utt = null;
    this.Utr = -1;
    this.Utq = null;
    this.pZt = null;
    this.sWX = null;
    bh.aZW().a(618, this);
    bh.aZW().a(616, this);
    bh.aZW().a(617, this);
    AppMethodBeat.o(29795);
  }
  
  public final void hUO()
  {
    AppMethodBeat.i(29796);
    bh.aZW().a(new g(this.rdq), 0);
    AppMethodBeat.o(29796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29797);
    Log.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((paramInt2 == -34) && (paramp.getType() == 617))
      {
        Log.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.Utt != null) {
          this.Utt.hUP();
        }
        AppMethodBeat.o(29797);
        return;
      }
      if (this.Utt != null) {
        this.Utt.hUN();
      }
      AppMethodBeat.o(29797);
      return;
    }
    if (paramp.getType() == 618)
    {
      this.rdq = ((e)paramp).lCS;
      Log.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.rdq)) });
      if (!Util.isNullOrNil(this.rdq)) {
        hUO();
      }
    }
    if (paramp.getType() == 616)
    {
      paramString = (g)paramp;
      this.Utr = paramString.UsY;
      this.Utq = paramString.UsX;
      Log.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.Utr), Boolean.valueOf(Util.isNullOrNil(this.Utq)) });
      if (this.Utt != null) {
        this.Utt.bfF(this.Utq);
      }
    }
    if (paramp.getType() == 617)
    {
      paramString = (h)paramp;
      if (paramString.brM == 0)
      {
        Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.pZt = paramString.pZt;
        if (this.Utt != null)
        {
          this.Utt.Gf(true);
          AppMethodBeat.o(29797);
        }
      }
      else
      {
        Log.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.Utt != null) {
          this.Utt.Gf(false);
        }
      }
    }
    AppMethodBeat.o(29797);
  }
  
  public static abstract interface a
  {
    public abstract void Gf(boolean paramBoolean);
    
    public abstract void bfF(String paramString);
    
    public abstract void hUN();
    
    public abstract void hUP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */