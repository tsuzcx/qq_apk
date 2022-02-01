package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class k
  extends b
{
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  public cbs wEr;
  
  public k()
  {
    AppMethodBeat.i(67379);
    b.a locala = new b.a();
    locala.hvt = new cbr();
    locala.hvu = new cbs();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67381);
    ac.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEr = ((cbs)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEr.dae), this.wEr.oxf });
    if ((!this.oyl) && (!this.oym))
    {
      ac.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.wEr.FpL), Integer.valueOf(this.wEr.FpM) });
      if (this.wEr.FpL >= 0) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPt, Integer.valueOf(this.wEr.FpL));
      }
      if (this.wEr.FpM > 0) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPu, Integer.valueOf(this.wEr.FpM));
      }
      if (!bs.isNullOrNil(this.wEr.FpN)) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPv, this.wEr.FpN);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(67380);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cbs)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.k
 * JD-Core Version:    0.7.0.1
 */