package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
  implements f
{
  public q.a trK;
  private String trb;
  private int trh;
  public String tru;
  public int trv;
  
  public q()
  {
    AppMethodBeat.i(26128);
    this.trK = null;
    this.trv = -1;
    this.tru = null;
    this.trb = null;
    this.trh = 0;
    aw.Rc().a(611, this);
    aw.Rc().a(613, this);
    AppMethodBeat.o(26128);
  }
  
  public q(q.a parama)
  {
    this();
    this.trK = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26129);
    ab.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ab.d("MicroMsg.VoicePrintUnLockService", "blocked by limit");
        if (this.trK != null) {
          this.trK.cLg();
        }
        AppMethodBeat.o(26129);
        return;
      }
      if (this.trK != null) {
        this.trK.cLf();
      }
      AppMethodBeat.o(26129);
      return;
    }
    if (paramm.getType() == 611)
    {
      paramString = (d)paramm;
      this.trv = paramString.tra;
      this.tru = paramString.tqZ;
      this.trb = paramString.trb;
      ab.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.trv), this.trb, Boolean.valueOf(bo.isNullOrNil(this.tru)) });
      if (this.trK != null) {
        this.trK.aeD(this.tru);
      }
    }
    if (paramm.getType() == 613) {
      if (((j)paramm).DW == 0)
      {
        ab.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
        if (this.trK != null)
        {
          this.trK.mI(true);
          AppMethodBeat.o(26129);
        }
      }
      else
      {
        ab.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
        if (this.trK != null) {
          this.trK.mI(false);
        }
      }
    }
    AppMethodBeat.o(26129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */