package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public cqg yhT;
  
  public m()
  {
    AppMethodBeat.i(67385);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    b.a locala = new b.a();
    locala.hQF = new cqf();
    locala.hQG = new cqg();
    locala.funcId = 1378;
    locala.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(67385);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67387);
    ae.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhT = ((cqg)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhT.dmy), this.yhT.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67387);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67386);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67386);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cqg)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1378;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.m
 * JD-Core Version:    0.7.0.1
 */