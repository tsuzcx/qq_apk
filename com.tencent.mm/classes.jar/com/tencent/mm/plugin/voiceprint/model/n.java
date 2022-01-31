package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class n
  implements f
{
  public String gEl;
  public String hll;
  public String ikj;
  private String tru;
  public int trv;
  public n.a trx;
  
  public n()
  {
    AppMethodBeat.i(26114);
    this.hll = null;
    this.trx = null;
    this.trv = -1;
    this.tru = null;
    this.gEl = null;
    this.ikj = null;
    aw.Rc().a(618, this);
    aw.Rc().a(616, this);
    aw.Rc().a(617, this);
    AppMethodBeat.o(26114);
  }
  
  public final void cLh()
  {
    AppMethodBeat.i(26115);
    aw.Rc().a(new g(this.hll), 0);
    AppMethodBeat.o(26115);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26116);
    ab.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((paramInt2 == -34) && (paramm.getType() == 617))
      {
        ab.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.trx != null) {
          this.trx.cLg();
        }
        AppMethodBeat.o(26116);
        return;
      }
      if (this.trx != null) {
        this.trx.cLf();
      }
      AppMethodBeat.o(26116);
      return;
    }
    if (paramm.getType() == 618)
    {
      this.hll = ((e)paramm).eiu;
      ab.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(bo.isNullOrNil(this.hll)) });
      if (!bo.isNullOrNil(this.hll)) {
        cLh();
      }
    }
    if (paramm.getType() == 616)
    {
      paramString = (g)paramm;
      this.trv = paramString.tra;
      this.tru = paramString.tqZ;
      ab.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.trv), Boolean.valueOf(bo.isNullOrNil(this.tru)) });
      if (this.trx != null) {
        this.trx.aeD(this.tru);
      }
    }
    if (paramm.getType() == 617)
    {
      paramString = (h)paramm;
      if (paramString.DW == 0)
      {
        ab.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.gEl = paramString.gEl;
        if (this.trx != null)
        {
          this.trx.mH(true);
          AppMethodBeat.o(26116);
        }
      }
      else
      {
        ab.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
        if (this.trx != null) {
          this.trx.mH(false);
        }
      }
    }
    AppMethodBeat.o(26116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */