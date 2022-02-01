package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  implements h
{
  private String UsZ;
  public a UtH;
  private int Ute;
  public String Utq;
  public int Utr;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.UtH = null;
    this.Utr = -1;
    this.Utq = null;
    this.UsZ = null;
    this.Ute = 0;
    bh.aZW().a(611, this);
    bh.aZW().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.UtH = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29810);
    Log.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.UtH != null) {
          this.UtH.hUP();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.UtH != null) {
        this.UtH.hUN();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramp.getType() == 611)
    {
      paramString = (d)paramp;
      this.Utr = paramString.UsY;
      this.Utq = paramString.UsX;
      this.UsZ = paramString.UsZ;
      Log.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.Utr), this.UsZ, Boolean.valueOf(Util.isNullOrNil(this.Utq)) });
      if (this.UtH != null) {
        this.UtH.bfF(this.Utq);
      }
    }
    if (paramp.getType() == 613) {
      if (((j)paramp).brM == 0)
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.UtH != null)
        {
          this.UtH.Gg(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.UtH != null) {
          this.UtH.Gg(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void Gg(boolean paramBoolean);
    
    public abstract void bfF(String paramString);
    
    public abstract void hUN();
    
    public abstract void hUP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */