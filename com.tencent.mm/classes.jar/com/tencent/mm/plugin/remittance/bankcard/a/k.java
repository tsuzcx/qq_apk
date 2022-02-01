package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class k
  extends b
{
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b rr;
  public bwy vum;
  
  public k()
  {
    AppMethodBeat.i(67379);
    b.a locala = new b.a();
    locala.gUU = new bwx();
    locala.gUV = new bwy();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67381);
    ad.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vum = ((bwy)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.vum.dcG), this.vum.nTK });
    if ((!this.nUQ) && (!this.nUR))
    {
      ad.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.vum.DTp), Integer.valueOf(this.vum.DTq) });
      if (this.vum.DTp >= 0) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrD, Integer.valueOf(this.vum.DTp));
      }
      if (this.vum.DTq > 0) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrE, Integer.valueOf(this.vum.DTq));
      }
      if (!bt.isNullOrNil(this.vum.DTr)) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrF, this.vum.DTr);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(67380);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (bwy)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
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