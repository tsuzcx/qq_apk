package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  implements i
{
  private String GQO;
  private int GQT;
  public String GRf;
  public int GRg;
  public a GRw;
  
  public q()
  {
    AppMethodBeat.i(29809);
    this.GRw = null;
    this.GRg = -1;
    this.GRf = null;
    this.GQO = null;
    this.GQT = 0;
    bg.azz().a(611, this);
    bg.azz().a(613, this);
    AppMethodBeat.o(29809);
  }
  
  public q(a parama)
  {
    this();
    this.GRw = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(29810);
    Log.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.GRw != null) {
          this.GRw.fEF();
        }
        AppMethodBeat.o(29810);
        return;
      }
      if (this.GRw != null) {
        this.GRw.fED();
      }
      AppMethodBeat.o(29810);
      return;
    }
    if (paramq.getType() == 611)
    {
      paramString = (d)paramq;
      this.GRg = paramString.GQN;
      this.GRf = paramString.GQM;
      this.GQO = paramString.GQO;
      Log.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.GRg), this.GQO, Boolean.valueOf(Util.isNullOrNil(this.GRf)) });
      if (this.GRw != null) {
        this.GRw.aUv(this.GRf);
      }
    }
    if (paramq.getType() == 613) {
      if (((j)paramq).NH == 0)
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.GRw != null)
        {
          this.GRw.wP(true);
          AppMethodBeat.o(29810);
        }
      }
      else
      {
        Log.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.GRw != null) {
          this.GRw.wP(false);
        }
      }
    }
    AppMethodBeat.o(29810);
  }
  
  public static abstract interface a
  {
    public abstract void aUv(String paramString);
    
    public abstract void fED();
    
    public abstract void fEF();
    
    public abstract void wP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */