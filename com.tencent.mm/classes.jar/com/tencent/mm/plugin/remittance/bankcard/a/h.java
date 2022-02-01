package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.al.b rr;
  public apy vuj;
  
  public h()
  {
    AppMethodBeat.i(67370);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    b.a locala = new b.a();
    locala.gUU = new apx();
    locala.gUV = new apy();
    locala.funcId = 1399;
    locala.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(67370);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67372);
    ad.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vuj = ((apy)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.vuj.dcG), this.vuj.nTK });
    if ((!this.nUQ) && (this.vuj.dcG != 0)) {
      this.nUR = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67372);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67371);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67371);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (apy)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
  }
  
  public final int getType()
  {
    return 1399;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.h
 * JD-Core Version:    0.7.0.1
 */