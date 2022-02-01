package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  implements i
{
  private String NGZ;
  public a NHH;
  private int NHe;
  public String NHq;
  public int NHr;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.NHH = null;
    this.NHr = -1;
    this.NHq = null;
    this.NGZ = null;
    this.NHe = 0;
    bh.aGY().a(611, this);
    bh.aGY().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.NHH = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(29810);
    Log.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.NHH != null) {
          this.NHH.gwS();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.NHH != null) {
        this.NHH.gwQ();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramq.getType() == 611)
    {
      paramString = (d)paramq;
      this.NHr = paramString.NGY;
      this.NHq = paramString.NGX;
      this.NGZ = paramString.NGZ;
      Log.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.NHr), this.NGZ, Boolean.valueOf(Util.isNullOrNil(this.NHq)) });
      if (this.NHH != null) {
        this.NHH.bfZ(this.NHq);
      }
    }
    if (paramq.getType() == 613) {
      if (((j)paramq).Lz == 0)
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.NHH != null)
        {
          this.NHH.AH(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.NHH != null) {
          this.NHH.AH(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void AH(boolean paramBoolean);
    
    public abstract void bfZ(String paramString);
    
    public abstract void gwQ();
    
    public abstract void gwS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */