package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class k
  extends b
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  public chd yhR;
  
  public k()
  {
    AppMethodBeat.i(67379);
    b.a locala = new b.a();
    locala.hQF = new chc();
    locala.hQG = new chd();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67381);
    ae.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhR = ((chd)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhR.dmy), this.yhR.phe });
    if ((!this.pil) && (!this.pim))
    {
      ae.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.yhR.HsW), Integer.valueOf(this.yhR.HsX) });
      if (this.yhR.HsW >= 0) {
        g.ajR().ajA().set(am.a.IWn, Integer.valueOf(this.yhR.HsW));
      }
      if (this.yhR.HsX > 0) {
        g.ajR().ajA().set(am.a.IWo, Integer.valueOf(this.yhR.HsX));
      }
      if (!bu.isNullOrNil(this.yhR.HsY)) {
        g.ajR().ajA().set(am.a.IWp, this.yhR.HsY);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67380);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (chd)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.k
 * JD-Core Version:    0.7.0.1
 */