package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b rr;
  public ckm wEt;
  
  public m()
  {
    AppMethodBeat.i(67385);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    b.a locala = new b.a();
    locala.hvt = new ckl();
    locala.hvu = new ckm();
    locala.funcId = 1378;
    locala.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(67385);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67387);
    ac.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEt = ((ckm)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEt.dae), this.wEt.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67387);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67386);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67386);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (ckm)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1378;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.m
 * JD-Core Version:    0.7.0.1
 */