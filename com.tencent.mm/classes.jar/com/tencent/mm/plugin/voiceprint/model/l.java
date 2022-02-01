package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  implements h
{
  public int Ute;
  public int Utp;
  private String Utq;
  public int Utr;
  public a Uts;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.Utp = 71;
    this.Utq = null;
    this.Utr = 0;
    this.Ute = 0;
    this.Uts = null;
    bh.aZW().a(611, this);
    bh.aZW().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.Uts = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29793);
    Log.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        Log.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
        if (this.Uts != null) {
          this.Uts.bfE(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.Uts != null) {
        this.Uts.hUN();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramp.getType() == 611)
    {
      paramString = (d)paramp;
      this.Utr = paramString.UsY;
      this.Utq = paramString.UsX;
      Log.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.Utr), Boolean.valueOf(Util.isNullOrNil(this.Utq)) });
      if (this.Uts != null)
      {
        if (this.Utp != 71) {
          break label333;
        }
        this.Uts.bfC(this.Utq);
      }
    }
    if (paramp.getType() == 612)
    {
      paramString = (f)paramp;
      if (((paramString.Utf != 72) || (paramString.brM != 0)) && (paramString.Utf != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      Log.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.Utf) });
      this.Ute = paramString.Ute;
      if (this.Uts != null) {
        this.Uts.an(true, paramString.Utf);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.Utf == 71) && (this.Uts != null)) {
        this.Uts.bfD(this.Utq);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.Utp != 72) {
        break;
      }
      this.Uts.bfD(this.Utq);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      Log.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.Utf) });
      if (this.Uts != null) {
        this.Uts.an(false, paramString.Utf);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void an(boolean paramBoolean, int paramInt);
    
    public abstract void bfC(String paramString);
    
    public abstract void bfD(String paramString);
    
    public abstract void bfE(String paramString);
    
    public abstract void hUN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */